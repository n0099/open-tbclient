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
    private com.baidu.tieba.f.b dWi;
    private au fQB;
    private VoiceManager foO;
    private com.baidu.tieba.frs.profession.permission.c fsw;
    public com.baidu.tbadk.core.util.aj gPK;
    private String hDG;
    private com.baidu.tieba.pb.pb.main.b.b hDM;
    private com.baidu.tbadk.editortools.pb.d hEA;
    private com.baidu.tieba.frs.profession.permission.c hEC;
    private EmotionImageData hED;
    private com.baidu.adp.base.e hEG;
    private com.baidu.tbadk.core.view.e hEH;
    private BdUniqueId hEI;
    private Runnable hEJ;
    private com.baidu.adp.widget.ImageView.a hEK;
    private String hEL;
    private TbRichTextMemeInfo hEM;
    private List<a> hEP;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hEc;
    private View hEd;
    int hEf;
    private com.baidu.tieba.pb.pb.report.a hEi;
    public as hEq;
    private com.baidu.tbadk.core.dialog.i hEr;
    private com.baidu.tbadk.core.dialog.k hEs;
    private boolean hEu;
    private com.baidu.tieba.tbadkCore.data.f hEy;
    private com.baidu.tbadk.editortools.pb.f hEz;
    private String hFD;
    private com.baidu.tbadk.core.data.o hFE;
    private boolean hFs;
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
    private static final b.a hFy = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.f.b.a
        public void iY(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bQC();
            } else {
                com.baidu.tieba.pb.a.b.bQB();
            }
        }
    };
    private boolean hDL = false;
    private boolean hDN = false;
    private boolean hDO = false;
    private boolean hhj = false;
    private boolean hDP = true;
    private int hDQ = 0;
    private com.baidu.tbadk.core.dialog.b hDR = null;
    private long eSl = -1;
    private long cyE = 0;
    private long hDS = 0;
    private long createTime = 0;
    private long cyw = 0;
    private boolean hDT = false;
    private com.baidu.tbadk.p.b hDU = null;
    private long hDV = 0;
    private boolean hDW = false;
    private long hDX = 0;
    private int fOg = 1;
    private String cst = null;
    private boolean hDY = false;
    private boolean isFullScreen = false;
    private String hDZ = "";
    private boolean hEa = true;
    private boolean hEb = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hEe = new int[2];
    private PbInterviewStatusView.a hEg = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void G(boolean z) {
            PbActivity.this.hEl.oC(!PbActivity.this.hEa);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hEh != null && PbActivity.this.hEh.ZC()) {
                        PbActivity.this.bRx();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hEh = null;
    private com.baidu.tbadk.baseEditMark.a hEj = null;
    private ForumManageModel eyx = null;
    private com.baidu.tbadk.coreExtra.model.a bSl = null;
    private com.baidu.tieba.pb.data.l hEk = null;
    private ShareSuccessReplyToServerModel fEO = null;
    private aq hEl = null;
    public final com.baidu.tieba.pb.pb.main.b.a hEm = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hEn = false;
    private boolean hEo = false;
    private boolean hEp = false;
    private boolean hEt = false;
    private boolean hEv = false;
    private boolean hEw = false;
    private boolean hEx = false;
    private boolean hEB = false;
    public boolean hEE = false;
    private com.baidu.tbadk.editortools.pb.c csw = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void arr() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b csx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean arq() {
            if (PbActivity.this.hEq == null || PbActivity.this.hEq.bVp() == null || !PbActivity.this.hEq.bVp().cwe()) {
                return !PbActivity.this.xf(com.baidu.tbadk.core.util.aj.bSg);
            }
            PbActivity.this.showToast(PbActivity.this.hEq.bVp().cwg());
            if (PbActivity.this.hEA != null && (PbActivity.this.hEA.arF() || PbActivity.this.hEA.arG())) {
                PbActivity.this.hEA.a(false, PbActivity.this.hEq.bVs());
            }
            PbActivity.this.hEq.oO(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hEF = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean arq() {
            if (PbActivity.this.hEq == null || PbActivity.this.hEq.bVq() == null || !PbActivity.this.hEq.bVq().cwe()) {
                return !PbActivity.this.xf(com.baidu.tbadk.core.util.aj.bSh);
            }
            PbActivity.this.showToast(PbActivity.this.hEq.bVq().cwg());
            if (PbActivity.this.hEl != null && PbActivity.this.hEl.bUc() != null && PbActivity.this.hEl.bUc().bSw() != null && PbActivity.this.hEl.bUc().bSw().arG()) {
                PbActivity.this.hEl.bUc().bSw().a(PbActivity.this.hEq.bVs());
            }
            PbActivity.this.hEq.oP(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean fpE = false;
    private int hEN = 0;
    private int hEO = -1;
    private final a hEQ = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hEl != null && PbActivity.this.hEl.bUc() != null) {
                s bUc = PbActivity.this.hEl.bUc();
                if (bUc.bSu()) {
                    bUc.bSt();
                    return true;
                }
            }
            if (PbActivity.this.hEl != null && PbActivity.this.hEl.bUW()) {
                PbActivity.this.hEl.bUX();
                return true;
            }
            return false;
        }
    };
    private r.a hER = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
    };
    private AddExperiencedModel.a fpQ = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bRB();
        }
    };
    private final z.a hES = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hEl.showToast(str);
            }
        }
    };
    private final CustomMessageListener hET = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hEh != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hEA != null) {
                    PbActivity.this.hEl.oH(PbActivity.this.hEA.arz());
                }
                PbActivity.this.hEl.bUd();
                PbActivity.this.hEl.bUP();
            }
        }
    };
    CustomMessageListener fqk = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hEh.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hEl != null && PbActivity.this.hEh != null) {
                    PbActivity.this.hEl.d(PbActivity.this.hEh.getPbData(), PbActivity.this.hEh.bSG(), PbActivity.this.hEh.getRequestType());
                }
                if (PbActivity.this.hEl != null && PbActivity.this.hEl.bUu() != null) {
                    PbActivity.this.hEl.bUu().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hEU = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hEl != null) {
                    if (booleanValue) {
                        PbActivity.this.hEl.bBX();
                    } else {
                        PbActivity.this.hEl.bBW();
                    }
                }
            }
        }
    };
    private CustomMessageListener hEV = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hEA != null) {
                    PbActivity.this.hEl.oH(PbActivity.this.hEA.arz());
                }
                PbActivity.this.hEl.oJ(false);
            }
        }
    };
    private CustomMessageListener hEW = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
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
    private CustomMessageListener hEX = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hEl != null && PbActivity.this.hEl.bUu() != null) {
                PbActivity.this.hEl.bUu().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gtJ = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener fqh = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hDO) {
                PbActivity.this.bRR();
            }
        }
    };
    private h.a hEY = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void v(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.xh(2);
                aj.bTO().reset();
                PbActivity.this.hEh.bTb();
                boolean z2 = false;
                ArrayList<PostData> bPK = PbActivity.this.hEh.getPbData().bPK();
                if (bPK != null) {
                    Iterator<PostData> it = bPK.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.cmD().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hEl.m(PbActivity.this.hEh.getPbData());
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
    private CustomMessageListener hEZ = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEh.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hEh.bSS() != null && PbActivity.this.hEh.bSS().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hEl.a(aaVar.sendCount, PbActivity.this.hEh.getPbData(), PbActivity.this.hEh.bSG(), PbActivity.this.hEh.getRequestType());
                    }
                    if (pbData.bPK() != null && pbData.bPK().size() >= 1 && pbData.bPK().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.bPK().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.hEh.bSF(), 0L);
                        if (c2 == aaVar.postId && c3 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cmC = pbData.bPK().get(0).cmC();
                            if (cmC == null) {
                                cmC = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> acr = cmC.acr();
                            if (acr == null) {
                                acr = new ArrayList<>();
                            }
                            acr.add(0, aVar);
                            cmC.setTotal(aaVar.sendCount + cmC.getTotal());
                            cmC.p(acr);
                            pbData.bPK().get(0).a(cmC);
                            PbActivity.this.hEl.bUu().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fHP = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                PbActivity.this.AY((String) customResponsedMessage.getData());
                PbActivity.this.hEh.bSY();
                if (PbActivity.this.hEl.bUu() != null) {
                    PbActivity.this.hEl.m(PbActivity.this.hEh.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hFa = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bVz()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hFb = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aj(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.aa(list) && PbActivity.this.hEl != null) {
                PbActivity.this.hEl.dI(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hFc = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
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
    private boolean hFd = false;
    private PraiseModel hFe = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void sm(String str) {
            PbActivity.this.hFd = false;
            if (PbActivity.this.hFe != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEh.getPbData();
                if (pbData.bPI().adh().getIsLike() == 1) {
                    PbActivity.this.sb(0);
                } else {
                    PbActivity.this.sb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bPI()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbActivity.this.hFd = false;
            if (PbActivity.this.hFe != null && str != null) {
                if (AntiHelper.aG(i, str)) {
                    AntiHelper.aI(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hFf = 0;
    private boolean hFg = true;
    private b.a hFh = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void od(boolean z) {
            PbActivity.this.oc(z);
            if (PbActivity.this.hEl.bVc() != null && z) {
                PbActivity.this.hEl.oC(false);
            }
            PbActivity.this.hEl.oE(z);
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
                        if (PbActivity.this.bPP().adv() != null && PbActivity.this.bPP().adv().getGodUserData() != null) {
                            PbActivity.this.bPP().adv().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().adv() != null) {
                            PbActivity.this.hEh.getPbData().bPI().adv().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a dVz = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hEl.aSD();
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
                    com.baidu.tieba.i.a.bsp();
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
            PbActivity.this.bRh();
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
                    if (PbActivity.this.hEl != null && PbActivity.this.hEl.bRf() && view.getId() == R.id.pb_head_user_info_root) {
                        if (view.getTag(R.id.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").bT(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(R.id.tag_user_id)));
                        }
                        if (PbActivity.this.hEm != null && PbActivity.this.hEm.fQU != null) {
                            PbActivity.this.hEm.fQU.onClick(view);
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
            if (PbActivity.this.hEA != null) {
                PbActivity.this.hEl.oH(PbActivity.this.hEA.arz());
            }
            PbActivity.this.hEl.bUd();
            PbActivity.this.hEl.bUP();
            return true;
        }
    });
    private CustomMessageListener hFi = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hEI) {
                PbActivity.this.hEl.aSD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEh.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bPV().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hEH.i(PbActivity.this.hEG.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hEG.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbActivity.this.qf(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bRN();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hEG.getResources().getString(R.string.mute_fail);
                    }
                    PbActivity.this.hEH.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hFj = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hEI) {
                PbActivity.this.hEl.aSD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hEH.i(PbActivity.this.hEG.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hEG.getResources().getString(R.string.un_mute_fail);
                }
                PbActivity.this.hEH.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hFk = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hEI) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hEl.aSD();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.jnb;
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
                    PbActivity.this.hEl.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hFl = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hEl.bUe() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bRh();
            }
        }
    };
    private CustomMessageListener fqr = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.fpE = true;
                }
            }
        }
    };
    public a.b hst = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bkf();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hEh.getPageData();
            int pageNum = PbActivity.this.hEl.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.ack()) {
                PbActivity.this.hEl.bUP();
                PbActivity.this.xh(2);
                PbActivity.this.bke();
                PbActivity.this.hEl.bUy();
                if (com.baidu.adp.lib.util.j.jS()) {
                    PbActivity.this.hEh.xp(PbActivity.this.hEl.getPageNum());
                    if (PbActivity.this.hDM != null) {
                        PbActivity.this.hDM.showFloatingView();
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
    public final View.OnClickListener fqZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
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
                    if (view == PbActivity.this.hEl.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hEh.on(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hEl.bUz();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hEl.hNd.bVM() == null || view != PbActivity.this.hEl.hNd.bVM().bTJ()) {
                        if (view == PbActivity.this.hEl.hNd.cAN) {
                            if (PbActivity.this.hEl.oG(PbActivity.this.hEh.bSL())) {
                                PbActivity.this.bke();
                                return;
                            }
                            PbActivity.this.hDP = false;
                            PbActivity.this.hDN = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hEl.hNd.cAN);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hEl.bUw() && (PbActivity.this.hEl.hNd.bVM() == null || (view != PbActivity.this.hEl.hNd.bVM().bTI() && view != PbActivity.this.hEl.hNd.bVM().bTG()))) {
                            if (view == PbActivity.this.hEl.bUS()) {
                                if (PbActivity.this.hEh != null) {
                                    com.baidu.tbadk.browser.a.af(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEh.getPbData().bPI().adu().getLink());
                                }
                            } else if (view != PbActivity.this.hEl.hNd.hSy) {
                                if (view == PbActivity.this.hEl.hNd.hSz) {
                                    if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                                        ArrayList<PostData> bPK = PbActivity.this.hEh.getPbData().bPK();
                                        if ((bPK == null || bPK.size() <= 0) && PbActivity.this.hEh.bSG()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").bT("tid", PbActivity.this.hEh.bSF()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", PbActivity.this.hEh.getForumId()));
                                        if (!PbActivity.this.hEl.bVh()) {
                                            PbActivity.this.hEl.bUd();
                                        }
                                        PbActivity.this.bRp();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.jS()) {
                                        PbActivity.this.hEl.oh(true);
                                        PbActivity.this.hEl.bUd();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hEl.bBX();
                                            PbActivity.this.bke();
                                            PbActivity.this.hEl.bUy();
                                            PbActivity.this.hEh.Bf(PbActivity.this.bRC());
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
                                    if ((PbActivity.this.hEl.hNd.bVM() == null || view != PbActivity.this.hEl.hNd.bVM().bTF()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbActivity.this.hEl.hNd.bVM() != null && view == PbActivity.this.hEl.hNd.bVM().getCancelView()) {
                                            PbActivity.this.hEl.hNd.TU();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbActivity.this.hEl.hNd.bVM() == null || view != PbActivity.this.hEl.hNd.bVM().bTD()) {
                                                if ((PbActivity.this.hEl.hNd.bVM() == null || view != PbActivity.this.hEl.hNd.bVM().bTL()) && view.getId() != R.id.pb_sort) {
                                                    if (PbActivity.this.hEl.hNd.bVM() == null || view != PbActivity.this.hEl.hNd.bVM().bTE()) {
                                                        if (PbActivity.this.hEl.hNd.bVM() == null || view != PbActivity.this.hEl.hNd.bVM().bTM()) {
                                                            if (PbActivity.this.hEl.bVc() == view) {
                                                                if (PbActivity.this.hEl.bVc().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEh.getPbData();
                                                                    if (pbData != null && pbData.bPI() != null && pbData.bPI().adb() != null) {
                                                                        String acS = pbData.bPI().adb().acS();
                                                                        if (StringUtils.isNull(acS)) {
                                                                            acS = pbData.bPI().adb().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").bT(VideoPlayActivityConfig.OBJ_ID, acS));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.el("c10725", null);
                                                                }
                                                                PbActivity.this.bRJ();
                                                            } else if (PbActivity.this.hEl.hNd.bVM() == null || view != PbActivity.this.hEl.hNd.bVM().bTK()) {
                                                                if (PbActivity.this.hEl.hNd.bVM() != null && view == PbActivity.this.hEl.hNd.bVM().bTH()) {
                                                                    if (com.baidu.adp.lib.util.j.jS()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hEl.c(PbActivity.this.hEh.getPbData(), PbActivity.this.hEh.bSG(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(R.id.tag_del_multi_forum))) {
                                                                                PbActivity.this.hEl.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hEl.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) c2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hEl.hNd.TU();
                                                                    } else {
                                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hEh != null && view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar.bT("tid", PbActivity.this.hEh.bSF());
                                                                        amVar.bT("fid", PbActivity.this.hEh.getForumId());
                                                                        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar.P("obj_locate", 4);
                                                                        TiebaStatic.log(amVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hEh.getPbData() != null) {
                                                                            PbActivity.this.hEl.bUP();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cmG() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                }
                                                                                if (postData.iZw != null) {
                                                                                    com.baidu.tbadk.core.util.am aie = postData.iZw.aie();
                                                                                    aie.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aie.P("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aie.P("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aie);
                                                                                }
                                                                                String bSF = PbActivity.this.hEh.bSF();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hEh.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hEh.getPbData().bPU();
                                                                                }
                                                                                PbActivity.this.bke();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    c Bd = PbActivity.this.Bd(id);
                                                                                    if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && Bd != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bSF, id, "pb", true, null, true, null, i4, postData.bWE(), PbActivity.this.hEh.getPbData().getAnti(), false, postData.adv().getIconInfo()).addBigImageData(Bd.hGg, Bd.hGh, Bd.hGi, Bd.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hEh.bTn());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hEh.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c Bd2 = PbActivity.this.Bd(id);
                                                                                    if (postData != null && PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && Bd2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bSF, id, "pb", true, null, false, null, i4, postData.bWE(), PbActivity.this.hEh.getPbData().getAnti(), false, postData.adv().getIconInfo()).addBigImageData(Bd2.hGg, Bd2.hGh, Bd2.hGi, Bd2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hEh.bTn());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hEh.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").P("obj_locate", 3).bT("fid", PbActivity.this.hEh.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbActivity.this.hEh != null) {
                                                                        com.baidu.tbadk.core.util.am amVar2 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar2.bT("tid", PbActivity.this.hEh.bSF());
                                                                        amVar2.bT("fid", PbActivity.this.hEh.getForumId());
                                                                        amVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar2.P("obj_locate", 5);
                                                                        TiebaStatic.log(amVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                                                                                    String bSF2 = PbActivity.this.hEh.bSF();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hEh.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hEh.getPbData().bPU();
                                                                                    }
                                                                                    c Bd3 = PbActivity.this.Bd(id2);
                                                                                    if (Bd3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bSF2, id2, "pb", true, null, false, null, i5, postData2.bWE(), PbActivity.this.hEh.getPbData().getAnti(), false, postData2.adv().getIconInfo()).addBigImageData(Bd3.hGg, Bd3.hGh, Bd3.hGi, Bd3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hEh.bTn());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hEh.getFromForumId());
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
                                                                    if (PbActivity.this.hEh != null) {
                                                                        com.baidu.tbadk.core.util.am amVar3 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar3.bT("tid", PbActivity.this.hEh.bSF());
                                                                        amVar3.bT("fid", PbActivity.this.hEh.getForumId());
                                                                        amVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar3.P("obj_locate", 6);
                                                                        TiebaStatic.log(amVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.bRe().bUb() != null && postData3.adv() != null && postData3.cmu() != 1) {
                                                                                    if (PbActivity.this.bRe().bUc() != null) {
                                                                                        PbActivity.this.bRe().bUc().bSs();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                    kVar.a(PbActivity.this.hEh.getPbData().getForum());
                                                                                    kVar.ai(PbActivity.this.hEh.getPbData().bPI());
                                                                                    kVar.e(postData3);
                                                                                    PbActivity.this.bRe().bUb().d(kVar);
                                                                                    PbActivity.this.bRe().bUb().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.adv().getUserId(), "");
                                                                                    if (PbActivity.this.hEA != null) {
                                                                                        PbActivity.this.hEl.oH(PbActivity.this.hEA.arz());
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
                                                                } else if (view != PbActivity.this.hEl.bQZ()) {
                                                                    if (view == PbActivity.this.hEl.hNd.bVN()) {
                                                                        PbActivity.this.hEl.bUF();
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").bT("tid", PbActivity.this.hEh.hJl));
                                                                                    }
                                                                                    if (PbActivity.this.hEs == null) {
                                                                                        PbActivity.this.hEs = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                                                                                        PbActivity.this.hEs.a(PbActivity.this.hFx);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cu(view);
                                                                                    if (!PbActivity.this.cu(view) || PbActivity.this.hEK == null || !PbActivity.this.hEK.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hEs);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cmw() != null && postData4.cmw().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hEs);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbActivity.this.ggM = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hEh.getPbData().ZC()) {
                                                                                        String ZB = PbActivity.this.hEh.getPbData().ZB();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(ZB) && ZB.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hEs);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hEs);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbActivity.this.ggM);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hEs);
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
                                                                                                    if (!ap.m(PbActivity.this.ggM)) {
                                                                                                        nY = PbActivity.this.nY(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        nY = false;
                                                                                                    }
                                                                                                    if (nY) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEs);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEs);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hEs);
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
                                                                                                    if (PbActivity.this.hEh.getPbData().bPU() == 1002 && !z3) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEs);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEs);
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
                                                                                            PbActivity.this.hEs.W(arrayList);
                                                                                            PbActivity.this.hEr = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hEs.afZ());
                                                                                            PbActivity.this.hEr.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbActivity.this.ggM);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hEs.W(arrayList);
                                                                                    PbActivity.this.hEr = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hEs.afZ());
                                                                                    PbActivity.this.hEr.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), PbActivity.this.hEh.getPbData().bPI().getActUrl());
                                                                                if (PbActivity.this.hEh.getPbData().bPI().aef() != 1) {
                                                                                    if (PbActivity.this.hEh.getPbData().bPI().aef() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").bT("fid", PbActivity.this.hEh.getPbData().getForumId()).bT("tid", PbActivity.this.hEh.getPbData().getThreadId()).bT("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hEh.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hEl.setSelection(0);
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
                                                                                PbActivity.this.hEl.bUd();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bRm() == 1 && PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").bT("fid", PbActivity.this.hEh.getPbData().getForumId()).bT("tid", PbActivity.this.hEh.getPbData().getThreadId()).bT("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bRm() == 1 && PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").bT("fid", PbActivity.this.hEh.getPbData().getForumId()).bT("tid", PbActivity.this.hEh.getPbData().getThreadId()).bT("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbActivity.this.bRE();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbActivity.this.bRF();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bQb() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hEh.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").bT("fid", pbData2.getForumId()));
                                                                                ba.aiz().c(PbActivity.this.getPageContext(), new String[]{pbData2.bQb().bQi()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bQb() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hEh.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bT("fid", pbData3.getForumId()));
                                                                                ba.aiz().c(PbActivity.this.getPageContext(), new String[]{pbData3.bQb().bQi()});
                                                                            }
                                                                        } else if (PbActivity.this.hEl.hNd.bVM() != null && view == PbActivity.this.hEl.hNd.bVM().bTN()) {
                                                                            if (PbActivity.this.hEh == null || PbActivity.this.hEh.getPbData() == null || PbActivity.this.hEh.getPbData().bPI() == null) {
                                                                                PbActivity.this.hEl.hNd.TU();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.ki()) {
                                                                                PbActivity.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hEh.getPbData().bPI().adc() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEh.bSF(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(R.string.haved_fans_called)).afO();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").P("obj_locate", PbActivity.this.au(PbActivity.this.hEh.getPbData().bPI())).bT("tid", PbActivity.this.hEh.getPbData().bPI().getTid()).P("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hEN >= 0) {
                                                                                if (PbActivity.this.hEh != null) {
                                                                                    PbActivity.this.hEh.bTo();
                                                                                }
                                                                                if (PbActivity.this.hEl.bUu() != null) {
                                                                                    PbActivity.this.hEl.bUu().a(PbActivity.this.hEh.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hEl.getListView().setSelection(PbActivity.this.hEh.bTr());
                                                                                PbActivity.this.hEN = 0;
                                                                                if (PbActivity.this.hEh != null) {
                                                                                    PbActivity.this.hEh.cb(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbActivity.this.bRj();
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
                                                                            if (PbActivity.this.hEl.getListView() != null && PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hEl.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbActivity.this.hEl.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean bQg = PbActivity.this.hEh.getPbData().bQg();
                                                                                boolean z8 = PbActivity.this.hEl.hMX != null && PbActivity.this.hEl.hMX.bWU();
                                                                                boolean bUM = PbActivity.this.hEl.bUM();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bQg && PbActivity.this.hEl.hMX != null && PbActivity.this.hEl.hMX.aHP() != null) {
                                                                                    int af = ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)) - PbActivity.this.hEl.hMX.bWV();
                                                                                    z9 = firstVisiblePosition == 0 && (top == af || top == PbActivity.this.hEl.hMX.aHP().getHeight() - PbActivity.this.hEl.hMX.bWV());
                                                                                    i7 = af;
                                                                                }
                                                                                if ((PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().adm() <= 0) || (bUM && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bRj();
                                                                                        if (PbActivity.this.hEh.getPbData().bPI().adv() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEh.hJl).bT("fid", PbActivity.this.hEh.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hEh.getPbData().bPI().adv().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.6d);
                                                                                    if (bQg) {
                                                                                        if (PbActivity.this.hEl.hOS != null && PbActivity.this.hEl.hOS.hQc != null && PbActivity.this.hEl.hOS.hQc.getView() != null) {
                                                                                            if (PbActivity.this.hEl.hOS.hQc.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bRs();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hEl.hMX.aHP() != null) {
                                                                                                    i8 = PbActivity.this.hEl.hMX.aHP().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hEl.hOS.hQc.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hEl.bUl() != null) {
                                                                                        z10 = PbActivity.this.hEl.bUl().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hEl.hOS != null && PbActivity.this.hEl.hOS.hQc != null && PbActivity.this.hEl.hOS.hQc.getView() != null && PbActivity.this.hEl.hOS.hQc.getView().getParent() != null && PbActivity.this.hEl.hNd != null && PbActivity.this.hEl.hNd.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hEl.hOS.hQc.getView().getTop() - PbActivity.this.hEl.hNd.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bUM) {
                                                                                        int bRs = PbActivity.this.bRs();
                                                                                        if (PbActivity.this.bRr() != -1) {
                                                                                            bRs--;
                                                                                        }
                                                                                        int g = com.baidu.adp.lib.util.l.g(PbActivity.this, R.dimen.tbds116);
                                                                                        if (bRs < 0) {
                                                                                            i2 = PbActivity.this.hEl.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.Z(PbActivity.this.hEl.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bRs;
                                                                                            i3 = g;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bQg || PbActivity.this.hEl.hMX.aHP() == null) {
                                                                                            if (PbActivity.this.hEl.hNd != null && PbActivity.this.hEl.hNd.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hEl.hNd.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hEl.hMX.aHP().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hEl.hOS == null || PbActivity.this.hEl.hOS.hQc == null || PbActivity.this.hEl.hOS.hQc.getView() == null || PbActivity.this.hEl.hOS.hQc.getView().getParent() == null) {
                                                                                            PbActivity.this.hEl.getListView().setSelectionFromTop(i2, i3 + ah);
                                                                                            PbActivity.this.hEl.getListView().smoothScrollBy(ah, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hEl.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hEl.getListView().smoothScrollBy(PbActivity.this.hEl.hOS.hQc.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-ah))) {
                                                                                        PbActivity.this.hEl.getListView().setSelectionFromTop(0, i7 - ah);
                                                                                        PbActivity.this.hEl.getListView().smoothScrollBy(-ah, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hEl.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().adv() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEh.hJl).bT("fid", PbActivity.this.hEh.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hEh.getPbData().bPI().adv().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(PbActivity.this.hEh.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hEh.bTn() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hEh.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar4 = new com.baidu.tbadk.core.util.am("c13401");
                                                                                amVar4.bT("tid", PbActivity.this.hEh.bSF());
                                                                                amVar4.bT("fid", PbActivity.this.hEh.getForumId());
                                                                                amVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bg) {
                                                                                bg bgVar = (bg) view.getTag();
                                                                                if (PbActivity.this.hEh.bTn() == 3 && PbActivity.this.bQE() && PbActivity.this.hEh.getPbData() != null && com.baidu.tbadk.core.util.v.aa(PbActivity.this.hEh.getPbData().bQd())) {
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
                                                                            if (PbActivity.this.hEh != null) {
                                                                                com.baidu.tbadk.core.util.am amVar6 = new com.baidu.tbadk.core.util.am("c13398");
                                                                                amVar6.bT("tid", PbActivity.this.hEh.bSF());
                                                                                amVar6.bT("fid", PbActivity.this.hEh.getForumId());
                                                                                amVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                amVar6.P("obj_locate", 2);
                                                                                TiebaStatic.log(amVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.hEh.getPbData();
                                                                                if (PbActivity.this.hEk == null) {
                                                                                    PbActivity.this.hEk = new com.baidu.tieba.pb.data.l(PbActivity.this.getPageContext());
                                                                                }
                                                                                long c3 = com.baidu.adp.lib.g.b.c(pbData4.getThreadId(), 0L);
                                                                                long c4 = com.baidu.adp.lib.g.b.c(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.am("c13446").l("forum_id", c4).aif();
                                                                                PbActivity.this.registerListener(PbActivity.this.hFn);
                                                                                PbActivity.this.hEk.s(c3, c4);
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13274").bT("fid", PbActivity.this.hEh.getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "PB_card").bT("tid", PbActivity.this.hEh.bSF()).P("obj_param1", smartApp.is_game.intValue()));
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.hEh.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.hEh.bSF(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hEh.getPbData().bPI().adP())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.jS()) {
                                                                PbActivity.this.hEl.bUP();
                                                                SparseArray<Object> c5 = PbActivity.this.hEl.c(PbActivity.this.hEh.getPbData(), PbActivity.this.hEh.bSG(), 1);
                                                                if (c5 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEh.getPbData().getForum().getId(), PbActivity.this.hEh.getPbData().getForum().getName(), PbActivity.this.hEh.getPbData().bPI().getId(), String.valueOf(PbActivity.this.hEh.getPbData().getUserData().getUserId()), (String) c5.get(R.id.tag_forbid_user_name), (String) c5.get(R.id.tag_forbid_user_name_show), (String) c5.get(R.id.tag_forbid_user_post_id), (String) c5.get(R.id.tag_forbid_user_portrait))));
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
                                                            PbActivity.this.hEl.hNd.bVL();
                                                        }
                                                    } else if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bPI() != null) {
                                                        PbActivity.this.hEl.hNd.TU();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                        PbActivity.this.Ba(PbActivity.this.hEh.getPbData().bPI().adL());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hEl.bUP();
                                                    if (com.baidu.adp.lib.util.j.jS()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hEh.bSW()));
                                                            return;
                                                        }
                                                        PbActivity.this.xh(2);
                                                        PbActivity.this.bke();
                                                        PbActivity.this.hEl.bUy();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hEh.getPbData().hBB == null || PbActivity.this.hEh.getPbData().hBB.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(R.string.sort_type_new), PbActivity.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hEh.getPbData().hBB.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hEh.getPbData().hBB.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hEh.getPbData().hBB.get(i10).sort_name + PbActivity.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbActivity.this.hEh.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hEh.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hEh.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hEh.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != R.id.pb_sort ? 1 : 0).P("obj_type", i12));
                                                                if (PbActivity.this.hEh.getPbData().hBB != null && PbActivity.this.hEh.getPbData().hBB.size() > i11) {
                                                                    i11 = PbActivity.this.hEh.getPbData().hBB.get(i11).sort_type.intValue();
                                                                }
                                                                boolean xu = PbActivity.this.hEh.xu(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hEh.bSW()));
                                                                if (xu) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hEl.oy(true);
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
                                                PbActivity.this.hEl.bUP();
                                                if (PbActivity.this.bQO().getPbData().hBC != 2) {
                                                    if (PbActivity.this.hEh.getPageData() != null) {
                                                        PbActivity.this.hEl.a(PbActivity.this.hEh.getPageData(), PbActivity.this.hst);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (bf.iE() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().adv() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEh.hJl).bT("fid", PbActivity.this.hEh.getPbData().getForumId()).P("obj_locate", 4).bT("uid", PbActivity.this.hEh.getPbData().bPI().adv().getUserId()));
                                            }
                                            if (PbActivity.this.hEh != null) {
                                                com.baidu.tbadk.core.util.am amVar7 = new com.baidu.tbadk.core.util.am("c12386");
                                                amVar7.bT("tid", PbActivity.this.hEh.bSF());
                                                amVar7.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                amVar7.bT("fid", PbActivity.this.hEh.getForumId());
                                                amVar7.P("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    amVar7.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(amVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.ki()) {
                                                if (PbActivity.this.hEh.getPbData() != null) {
                                                    ArrayList<PostData> bPK2 = PbActivity.this.hEh.getPbData().bPK();
                                                    if ((bPK2 != null && bPK2.size() > 0) || !PbActivity.this.hEh.bSG()) {
                                                        PbActivity.this.hEl.bUP();
                                                        PbActivity.this.bke();
                                                        PbActivity.this.xh(2);
                                                        if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bQb() != null && !StringUtils.isNull(PbActivity.this.hEh.getPbData().bQb().abS(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bT("fid", PbActivity.this.hEh.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                        if (bf.iE()) {
                                                            PbActivity.this.xi(2);
                                                        } else {
                                                            PbActivity.this.hEl.showLoadingDialog();
                                                            PbActivity.this.hEh.bTi().p(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                        PbActivity.this.hEl.bUP();
                                        if (PbActivity.this.hEl.hNd.bVM() != null && view == PbActivity.this.hEl.hNd.bVM().bTF() && !PbActivity.this.hEl.bVh()) {
                                            PbActivity.this.hEl.bUd();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bke();
                                            PbActivity.this.hEl.bUy();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                t = PbActivity.this.hEh.t(true, PbActivity.this.bRC());
                                            } else {
                                                t = view.getId() == R.id.reply_title ? PbActivity.this.hEh.t(false, PbActivity.this.bRC()) : PbActivity.this.hEh.Bf(PbActivity.this.bRC());
                                            }
                                            view.setTag(Boolean.valueOf(t));
                                            if (t) {
                                                PbActivity.this.hEl.oh(true);
                                                PbActivity.this.hEl.bBX();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hEl.oy(true);
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
                                    PbActivity.this.hEl.bUP();
                                    if (PbActivity.this.xg(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.hEh.xv(PbActivity.this.hEl.bUD()) != null) {
                                        PbActivity.this.bRw();
                                        if (PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().adv() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEh.hJl).bT("fid", PbActivity.this.hEh.getPbData().getForumId()).P("obj_locate", 3).bT("uid", PbActivity.this.hEh.getPbData().bPI().adv().getUserId()));
                                        }
                                        if (PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().adv() != null && PbActivity.this.hEh.getPbData().bPI().adv().getUserId() != null && PbActivity.this.hEj != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bT("tid", PbActivity.this.hEh.hJl).P("obj_locate", 1).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hEh.getPbData().bPI().adv().getUserId()).P("obj_type", PbActivity.this.hEj.ZC() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hEh.getPbData())));
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
                                if (PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().aep() && PbActivity.this.hEh.getPbData().bPI().adM() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.hEh.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hEh.bQF()) && PbActivity.this.hEh.getAppealInfo() != null) {
                                        name = PbActivity.this.hEh.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hEh.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bQF = PbActivity.this.hEh.bQF();
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hEh.bSH() && bQF != null && bQF.equals(name)) {
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
                            if (PbActivity.this.hEh.getPbData() != null) {
                                if ((PbActivity.this.hEh.getPbData().bPU() == 1 || PbActivity.this.hEh.getPbData().bPU() == 3) && !PbActivity.this.eyx.cnf()) {
                                    PbActivity.this.hEl.bUP();
                                    int i11 = 0;
                                    if (PbActivity.this.hEl.hNd.bVM() == null || view != PbActivity.this.hEl.hNd.bVM().bTG()) {
                                        if (PbActivity.this.hEl.hNd.bVM() == null || view != PbActivity.this.hEl.hNd.bVM().bTI()) {
                                            if (view == PbActivity.this.hEl.bUw()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hEh.getPbData().bPI().adr() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hEh.getPbData().bPI().adq() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hEh.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hEh.getPbData().bPI().getId();
                                    PbActivity.this.hEl.bUv();
                                    PbActivity.this.eyx.a(id4, name2, id5, i11, PbActivity.this.hEl.bUx());
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
                        PbActivity.this.hEl.bUP();
                        PbActivity.this.bke();
                        PbActivity.this.hEl.bUy();
                        PbActivity.this.hEl.showLoadingDialog();
                        if (PbActivity.this.hEl.bUl() != null) {
                            PbActivity.this.hEl.bUl().setVisibility(8);
                        }
                        PbActivity.this.hEh.xp(1);
                        if (PbActivity.this.hDM != null) {
                            PbActivity.this.hDM.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String bRk = PbActivity.this.bRk();
                        if (!TextUtils.isEmpty(bRk)) {
                            ba.aiz().c(PbActivity.this.getPageContext(), new String[]{bRk});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hEh != null) {
                    com.baidu.tbadk.core.util.am amVar8 = new com.baidu.tbadk.core.util.am("c13398");
                    amVar8.bT("tid", PbActivity.this.hEh.bSF());
                    amVar8.bT("fid", PbActivity.this.hEh.getForumId());
                    amVar8.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    amVar8.P("obj_locate", 1);
                    TiebaStatic.log(amVar8);
                }
                if (PbActivity.this.hDW) {
                    PbActivity.this.hDW = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.bRe().bUb() != null && postData5.adv() != null && postData5.cmu() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bRe().bUc() != null) {
                                PbActivity.this.bRe().bUc().bSs();
                            }
                            com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                            kVar2.a(PbActivity.this.hEh.getPbData().getForum());
                            kVar2.ai(PbActivity.this.hEh.getPbData().bPI());
                            kVar2.e(postData5);
                            PbActivity.this.bRe().bUb().d(kVar2);
                            PbActivity.this.bRe().bUb().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.adv().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hEh.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hEA != null) {
                                PbActivity.this.hEl.oH(PbActivity.this.hEA.arz());
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
                if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                    amVar.bT("fid", PbActivity.this.hEh.getPbData().getForumId());
                }
                if (PbActivity.this.hEh != null) {
                    amVar.bT("tid", PbActivity.this.hEh.bSF());
                }
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.bke();
            PbActivity.this.hEl.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.t.av.auH() && PbActivity.this.bQO() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bQO().Bi(postWriteCallBackData.getPostId());
                    PbActivity.this.hEN = PbActivity.this.hEl.bUh();
                    if (PbActivity.this.hEh != null) {
                        PbActivity.this.hEh.cb(PbActivity.this.hEN, PbActivity.this.hEl.bUi());
                    }
                }
                PbActivity.this.hEl.bUP();
                PbActivity.this.hEq.bVo();
                if (PbActivity.this.hEA != null) {
                    PbActivity.this.hEl.oH(PbActivity.this.hEA.arz());
                }
                PbActivity.this.hEl.bUa();
                PbActivity.this.hEl.oJ(true);
                PbActivity.this.hEh.bSY();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hEh.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEh.getPbData();
                            if (pbData != null && pbData.bPI() != null && pbData.bPI().adv() != null && (userId = pbData.bPI().adv().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.t.av.auH() && PbActivity.this.hEh.bSP()) {
                                PbActivity.this.hEl.bUy();
                            }
                        } else if (!com.baidu.tbadk.t.av.auH() && PbActivity.this.hEh.bSP()) {
                            PbActivity.this.hEl.bUy();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hEl.m(PbActivity.this.hEh.getPbData());
                    }
                    if (PbActivity.this.hEh.bSK()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").bT("tid", PbActivity.this.hEh.bSF()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hEA.arF() || PbActivity.this.hEA.arG()) {
                    PbActivity.this.hEA.a(false, postWriteCallBackData);
                }
                PbActivity.this.hEq.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gPK != null) {
                    PbActivity.this.gPK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hFm = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                    amVar.bT("fid", PbActivity.this.hEh.getPbData().getForumId());
                }
                if (PbActivity.this.hEh != null) {
                    amVar.bT("tid", PbActivity.this.hEh.bSF());
                }
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (PbActivity.this.hEq != null) {
                    PbActivity.this.hEq.bVn();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gPK != null) {
                    PbActivity.this.gPK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hEq != null) {
                if (PbActivity.this.hEl != null && PbActivity.this.hEl.bUc() != null && PbActivity.this.hEl.bUc().bSw() != null && PbActivity.this.hEl.bUc().bSw().arG()) {
                    PbActivity.this.hEl.bUc().bSw().a(postWriteCallBackData);
                }
                PbActivity.this.hEq.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hFn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView bVm;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbActivity.this.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbActivity.this.hEl != null && (bVm = PbActivity.this.hEl.bVm()) != null && PbActivity.this.hEl.getListView() != null) {
                            PbActivity.this.hEl.getListView().removeHeaderView(bVm);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a hFo = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g kg;
            if (!z || dVar == null || dVar.bPS() != null || com.baidu.tbadk.core.util.v.Z(dVar.bPK()) >= 1) {
                PbActivity.this.hhj = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hEl.bUA();
                if (dVar == null || !dVar.bPO()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hEl.getView());
                }
                PbActivity.this.hEl.bBW();
                if (PbActivity.this.isFullScreen || PbActivity.this.hEl.bVh()) {
                    PbActivity.this.hEl.bUY();
                } else if (!PbActivity.this.hEl.bUV()) {
                    PbActivity.this.hEl.oJ(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hEt = true;
                }
                if (dVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hEl.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hEl.aUE();
                    if (dVar.bPI() != null && dVar.bPI().aey() != null) {
                        PbActivity.this.a(dVar.bPI().aey());
                    }
                    PbActivity.this.bRb();
                    if (PbActivity.this.hEA != null) {
                        PbActivity.this.hEl.oH(PbActivity.this.hEA.arz());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bPK() != null && dVar.bPK().size() >= 1 && dVar.bPK().get(0) != null) {
                        PbActivity.this.hEh.Bh(dVar.bPK().get(0).getId());
                    } else if (dVar.bPS() != null) {
                        PbActivity.this.hEh.Bh(dVar.bPS().getId());
                    }
                    if (PbActivity.this.hEA != null) {
                        PbActivity.this.hEA.a(dVar.getAnti());
                        PbActivity.this.hEA.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hEA.a(PbActivity.this.hEh.bSS(), PbActivity.this.hEh.bSF(), PbActivity.this.hEh.bTk());
                        if (dVar.bPI() != null) {
                            PbActivity.this.hEA.fk(dVar.bPI().aeN());
                        }
                    }
                    if (PbActivity.this.hEj != null) {
                        PbActivity.this.hEj.ds(dVar.ZC());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hEl.oI(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hEl.a(dVar, i2, i3, PbActivity.this.hEh.bSG(), i4, PbActivity.this.hEh.getIsFromMark());
                    PbActivity.this.hEl.e(dVar, PbActivity.this.hEh.bSG());
                    PbActivity.this.hEl.oF(PbActivity.this.hEh.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.cst = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.cst) && PbActivity.this.hEA != null && PbActivity.this.hEA.aqS() != null && (kg = PbActivity.this.hEA.aqS().kg(6)) != null && !TextUtils.isEmpty(PbActivity.this.cst)) {
                            ((View) kg).setOnClickListener(PbActivity.this.cth);
                        }
                    }
                    if (PbActivity.this.hEv) {
                        PbActivity.this.hEv = false;
                        final int bRr = PbActivity.this.bRr();
                        if (!dVar.bQg()) {
                            PbActivity.this.hEl.xB(bRr);
                        } else {
                            final int af = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bRr, af);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hEw) {
                        PbActivity.this.hEw = false;
                        final int bRr2 = PbActivity.this.bRr();
                        final boolean z2 = bRr2 != -1;
                        if (!z2) {
                            bRr2 = PbActivity.this.bRs();
                        }
                        if (PbActivity.this.hEl != null) {
                            if (!dVar.bQg()) {
                                PbActivity.this.hEl.xB(bRr2);
                            } else {
                                final int af2 = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bRr2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hEl.setSelectionFromTop(bRr2, af2);
                                            } else {
                                                PbActivity.this.hEl.setSelectionFromTop(bRr2 - 1, af2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hEl.oK(true);
                                PbActivity.this.hEl.oJ(false);
                            }
                        }
                    } else if (PbActivity.this.hEx) {
                        PbActivity.this.hEx = false;
                        PbActivity.this.hEl.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hEl.bUE();
                    }
                    PbActivity.this.hEh.a(dVar.getForum(), PbActivity.this.hFa);
                    PbActivity.this.hEh.a(PbActivity.this.hFb);
                    if (PbActivity.this.gPK != null && dVar.bPI() != null && dVar.bPI().adv() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bPI().adv());
                        PbActivity.this.gPK.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hEt && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hEh != null && PbActivity.this.hEh.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hEh.getAppealInfo().hAV)) {
                                    PbActivity.this.hEl.a(PbActivity.this.hEh.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hEl.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hEl.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                            }
                            PbActivity.this.hEl.bUY();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hEh.bSF());
                            jSONObject.put("fid", PbActivity.this.hEh.getForumId());
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
                        PbActivity.this.hEl.Bl("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                            arrayList = PbActivity.this.hEh.getPbData().bPK();
                        }
                        if (com.baidu.tbadk.core.util.v.Z(arrayList) != 0 && (com.baidu.tbadk.core.util.v.Z(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cmu() != 1)) {
                            PbActivity.this.hEl.Bl(PbActivity.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbActivity.this.bRP()) {
                            PbActivity.this.hEl.Bm(PbActivity.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbActivity.this.hEl.Bm(PbActivity.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbActivity.this.hEl.ajz();
                }
                PbActivity.this.cyE = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bQO().bSG() || PbActivity.this.bQO().getPbData().getPage().acq() != 0 || PbActivity.this.bQO().bTe()) {
                    PbActivity.this.hEB = true;
                    return;
                }
                return;
            }
            PbActivity.this.hEh.xp(1);
            if (PbActivity.this.hDM != null) {
                PbActivity.this.hDM.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hEl.m(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.p.m.auk().aul()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eSl : j;
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
                if (!z2 && PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bPI() != null) {
                    int threadType = PbActivity.this.hEh.getPbData().bPI().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hDZ, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hDZ, "from_frs")) {
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
    private CustomMessageListener hFp = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bRn();
            }
        }
    };
    private final a.InterfaceC0236a hFq = new a.InterfaceC0236a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0236a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hEl.bUA();
            if (z) {
                if (PbActivity.this.hEj != null) {
                    PbActivity.this.hEj.ds(z2);
                }
                PbActivity.this.hEh.op(z2);
                if (PbActivity.this.hEh.ZC()) {
                    PbActivity.this.bRx();
                } else {
                    PbActivity.this.hEl.m(PbActivity.this.hEh.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hEj != null && PbActivity.this.hEj.ZF() != null && PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().adv() != null) {
                        MarkData ZF = PbActivity.this.hEj.ZF();
                        MetaData adv = PbActivity.this.hEh.getPbData().bPI().adv();
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
                if (PbActivity.this.hEl != null) {
                    PbActivity.this.hEl.bUP();
                    if (PbActivity.this.hEA != null && !PbActivity.this.hEl.bUe()) {
                        PbActivity.this.hEl.oH(PbActivity.this.hEA.arz());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hEl.bUd();
                    }
                }
                if (!PbActivity.this.hDT) {
                    PbActivity.this.hDT = true;
                    PbActivity.this.hEl.bUU();
                }
            }
            PbActivity.this.hEl.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hDM != null) {
                PbActivity.this.hDM.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hDU == null) {
                PbActivity.this.hDU = new com.baidu.tbadk.p.b();
                PbActivity.this.hDU.kK(1001);
            }
            if (i == 0) {
                PbActivity.this.hDU.aub();
            } else {
                PbActivity.this.hDU.aua();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.clt().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bPK;
            if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEl != null && PbActivity.this.hEl.bUu() != null) {
                PbActivity.this.hEl.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hDM != null) {
                    PbActivity.this.hDM.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hEh.bTa() && (bPK = PbActivity.this.hEh.getPbData().bPK()) != null && !bPK.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hEl.bUu().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEh.getPbData();
                    if (pbData != null) {
                        if (pbData.bPL() != null && pbData.bPL().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bPM() != null && pbData.bPM().hasData()) {
                            headerCount--;
                        }
                        int size = bPK.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eyB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eyx.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hEh.bSY();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hUu != 1002 || bVar.fTQ) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hEl.a(1, dVar.FN, dVar.jbh, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eyx.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hEl.a(PbActivity.this.eyx.getLoadDataMode(), gVar.FN, gVar.jbh, false);
                        PbActivity.this.hEl.ax(gVar.jbk);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hEl.a(PbActivity.this.eyx.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hFr = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final h.c cXI = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (PbActivity.this.bRD()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hEh.oo(true)) {
                PbActivity.this.hEl.bUB();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fIZ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hFs && PbActivity.this.bRD()) {
                PbActivity.this.bRF();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hEh.on(false)) {
                    PbActivity.this.hEl.bUz();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hEh.getPbData() != null) {
                    PbActivity.this.hEl.bUT();
                }
                PbActivity.this.hFs = true;
            }
        }
    };
    private int hFt = 0;
    private final TbRichTextView.h cIM = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bUu;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hEh != null) {
                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                        amVar.bT("tid", PbActivity.this.hEh.bSF());
                        amVar.bT("fid", PbActivity.this.hEh.getForumId());
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
                        PbActivity.this.hEd = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hGj) {
                        TbRichText bd = PbActivity.this.bd(str, i);
                        if (bd != null && PbActivity.this.hFt >= 0 && PbActivity.this.hFt < bd.axy().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bd.axy().get(PbActivity.this.hFt));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hGg.size()) {
                                    break;
                                } else if (!cVar.hGg.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bd.getPostId() != 0 && (bUu = PbActivity.this.hEl.bUu()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bUu.getDataList();
                                if (com.baidu.tbadk.core.util.v.Z(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bd.getPostId() == com.baidu.adp.lib.g.b.c(((PostData) next).getId(), 0L)) {
                                            if (bd.getPostId() != com.baidu.adp.lib.g.b.c(PbActivity.this.hEh.bTk(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hEh.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.aa(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hGh.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hGi, cVar.lastId, PbActivity.this.hEh.bSV(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.n(rect);
                            createConfig.setIsHotSort(PbActivity.this.hEh.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hGg, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.aa(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hGh.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hGi, cVar.hGg.get(0), PbActivity.this.hEh.bSV(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hEh.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hEl.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hFu = false;
    PostData ggM = null;
    private final b.a hFv = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.ggM != null) {
                if (i == 0) {
                    PbActivity.this.ggM.ek(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.ggM = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.ggM);
                }
            }
        }
    };
    private final b.a hFw = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hEK != null && !TextUtils.isEmpty(PbActivity.this.hEL)) {
                if (i == 0) {
                    if (PbActivity.this.hEM == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hEL));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hEL;
                        aVar.pkgId = PbActivity.this.hEM.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hEM.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.mPermissionJudgement.aiM();
                    PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.aa(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fQB == null) {
                            PbActivity.this.fQB = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fQB.h(PbActivity.this.hEL, PbActivity.this.hEK.nv());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hEK = null;
                PbActivity.this.hEL = null;
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
                        PbActivity.this.hEK = ((TbImageView) view).getBdImage();
                        PbActivity.this.hEL = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hEK == null || TextUtils.isEmpty(PbActivity.this.hEL)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hEM = null;
                        } else {
                            PbActivity.this.hEM = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hEK = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hEL = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hEM = null;
                            } else {
                                PbActivity.this.hEM = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hEK = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hEL = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hEM = null;
                        } else {
                            PbActivity.this.hEM = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbActivity.this.hEl.a(PbActivity.this.hFw, PbActivity.this.hEK.isGif());
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
            PbActivity.this.ggM = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbActivity.this.ggM == null) {
                return true;
            }
            if (PbActivity.this.ggM.cmu() != 1 || !PbActivity.this.cu(view)) {
                if (PbActivity.this.hEj != null) {
                    if (!PbActivity.this.hEj.ZC() || PbActivity.this.ggM.getId() == null || !PbActivity.this.ggM.getId().equals(PbActivity.this.hEh.adE())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.ggM.cmu() == 1) {
                        PbActivity.this.hEl.a(PbActivity.this.hFv, z, false);
                        return true;
                    }
                    if (PbActivity.this.hEs == null) {
                        PbActivity.this.hEs = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                        PbActivity.this.hEs.a(PbActivity.this.hFx);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cu = PbActivity.this.cu(view);
                        boolean z3 = (!PbActivity.this.cu(view) || PbActivity.this.hEK == null || PbActivity.this.hEK.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hEs);
                            gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                            gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                            gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(gVar3);
                        }
                        if (cu) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbActivity.this.getString(R.string.save_to_emotion), PbActivity.this.hEs));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbActivity.this.getString(R.string.save_to_local), PbActivity.this.hEs));
                        }
                        if (!cu && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hEs);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(R.id.tag_clip_board, PbActivity.this.ggM);
                            gVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(gVar4);
                        }
                        if (!z4) {
                            if (z) {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hEs);
                            } else {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hEs);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(R.id.tag_clip_board, PbActivity.this.ggM);
                            sparseArray4.put(R.id.tag_is_subpb, false);
                            gVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(gVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hEs);
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
                                if (!ap.m(PbActivity.this.ggM)) {
                                    nY = PbActivity.this.nY(z5) & PbActivity.this.isLogin();
                                } else {
                                    nY = false;
                                }
                                if (nY) {
                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEs);
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
                                    gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEs);
                                    gVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(R.id.tag_should_delete_visible, false);
                                }
                                gVar = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hEs);
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
                                    if (PbActivity.this.hEh.getPbData().bPU() == 1002 && !z5) {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEs);
                                    } else {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEs);
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
                        PbActivity.this.hEs.W(arrayList);
                        PbActivity.this.hEr = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hEs.afZ());
                        PbActivity.this.hEr.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").bT("tid", PbActivity.this.hEh.hJl).bT("fid", PbActivity.this.hEh.getForumId()).bT("uid", PbActivity.this.hEh.getPbData().bPI().adv().getUserId()).bT("post_id", PbActivity.this.hEh.aro()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hEl.a(PbActivity.this.hFw, PbActivity.this.hEK.isGif());
            return true;
        }
    };
    private k.c hFx = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbActivity.this.hEr != null) {
                PbActivity.this.hEr.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEh.getPbData();
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
                    if (PbActivity.this.hEK != null && !TextUtils.isEmpty(PbActivity.this.hEL)) {
                        if (PbActivity.this.hEM == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hEL));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hEL;
                            aVar.pkgId = PbActivity.this.hEM.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hEM.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hEK = null;
                        PbActivity.this.hEL = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hEK != null && !TextUtils.isEmpty(PbActivity.this.hEL)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.aiM();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.aa(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fQB == null) {
                                PbActivity.this.fQB = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fQB.h(PbActivity.this.hEL, PbActivity.this.hEK.nv());
                            PbActivity.this.hEK = null;
                            PbActivity.this.hEL = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.ggM != null) {
                        PbActivity.this.ggM.ek(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.ggM = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").P("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.ct(view);
                        if (PbActivity.this.hEh.getPbData().bPI() != null && PbActivity.this.hEh.getPbData().bPI().adv() != null && PbActivity.this.hEh.getPbData().bPI().adv().getUserId() != null && PbActivity.this.hEj != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bT("tid", PbActivity.this.hEh.hJl).P("obj_locate", 2).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hEh.getPbData().bPI().adv().getUserId()).P("obj_type", PbActivity.this.hEj.ZC() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hEh.getPbData())));
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
                        PbActivity.this.hEl.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbActivity.this.hEl.cA(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hEl.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a fmu = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (!PbActivity.this.hDO && z && !PbActivity.this.hEh.bSM()) {
                PbActivity.this.bRz();
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
            PbActivity.this.dWi.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0302a dWj = new a.InterfaceC0302a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        final int egi;

        {
            this.egi = (int) PbActivity.this.getResources().getDimension(R.dimen.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            if (ax(i2) && PbActivity.this.hEl != null && PbActivity.this.hDM != null) {
                PbActivity.this.hEl.bUZ();
                PbActivity.this.hDM.kb(false);
                PbActivity.this.hDM.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            if (ax(i2) && PbActivity.this.hEl != null && PbActivity.this.hDM != null) {
                PbActivity.this.hDM.kb(true);
                if (Math.abs(i2) > this.egi) {
                    PbActivity.this.hDM.hideFloatingView();
                }
                if (PbActivity.this.bRD()) {
                    PbActivity.this.hEl.bUr();
                    PbActivity.this.hEl.bUs();
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
    private String hFz = null;
    private final m.a hFA = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hFz = str2;
                PbActivity.this.hEl.Bn(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hFB = -1;
    private int hFC = -1;
    private CustomMessageListener hFF = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bDk == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0238a) {
                    if (aVar.bDl != null && !aVar.bDl.hasError() && aVar.bDl.getError() == 0) {
                        if (PbActivity.this.hEl != null) {
                            PbActivity.this.hEl.q(((a.C0238a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bRO();
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
                        if (PbActivity.this.hEl != null && PbActivity.this.hEl != null) {
                            PbActivity.this.hEl.q(((a.C0238a) aVar).channelId, 2);
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
        public ArrayList<String> hGg;
        public ConcurrentHashMap<String, ImageUrlData> hGh;
        public boolean hGj;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hGi = false;
        public boolean hGk = false;
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

    public com.baidu.tbadk.editortools.pb.d bRa() {
        return this.hEA;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        boolean z = true;
        if (kVar.bQr() != null) {
            String id = kVar.bQr().getId();
            ArrayList<PostData> bPK = this.hEh.getPbData().bPK();
            int i = 0;
            while (true) {
                if (i >= bPK.size()) {
                    break;
                }
                PostData postData = bPK.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bQv = kVar.bQv();
                    postData.Ax(kVar.getTotalCount());
                    if (postData.cmr() != null && bQv != null) {
                        Iterator<PostData> it = bQv.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.adv() != null && (metaData = postData.getUserMap().get(next.adv().getUserId())) != null) {
                                next.a(metaData);
                                next.qN(true);
                                next.a(getPageContext(), this.hEh.Bg(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bQv.size() != postData.cmr().size();
                        postData.cmr().clear();
                        postData.cmr().addAll(bQv);
                        z = z2;
                    }
                    if (postData.cmn() != null) {
                        postData.cmo();
                    }
                }
            }
            if (!this.hEh.getIsFromMark() && z) {
                this.hEl.m(this.hEh.getPbData());
            }
            if (z) {
                c(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bPX = this.hEh.getPbData().bPX();
            if (bPX != null && str.equals(bPX.getAdId())) {
                if (bPX.cmi() != null) {
                    bPX.cmi().legoCard = null;
                }
                this.hEh.getPbData().bPY();
            }
            com.baidu.tieba.tbadkCore.data.m bSQ = this.hEh.bSQ();
            if (bSQ != null && str.equals(bSQ.getAdId())) {
                this.hEh.bSR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.hEr != null && this.hEr.isShowing()) {
                this.hEr.dismiss();
                this.hEr = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this);
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbActivity.this.hEr != null) {
                            PbActivity.this.hEr.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hEl.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbActivity.this.hEI);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hEI);
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
                this.hEr = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar.afZ());
                this.hEr.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        bg bPI;
        if (this.hEh != null && this.hEh.getPbData() != null && (bPI = this.hEh.getPbData().bPI()) != null) {
            if (i == 1) {
                PraiseData adh = bPI.adh();
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
                        bPI.a(praiseData);
                    } else {
                        bPI.adh().getUser().add(0, metaData);
                        bPI.adh().setNum(bPI.adh().getNum() + 1);
                        bPI.adh().setIsLike(i);
                    }
                }
                if (bPI.adh() != null) {
                    if (bPI.adh().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.ap.aL(bPI.adh().getNum());
                    }
                }
            } else if (bPI.adh() != null) {
                bPI.adh().setIsLike(i);
                bPI.adh().setNum(bPI.adh().getNum() - 1);
                ArrayList<MetaData> user = bPI.adh().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bPI.adh().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bPI.adh().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = bPI.adh().getNum() + "";
                }
            }
            if (this.hEh.bSG()) {
                this.hEl.bUu().notifyDataSetChanged();
            } else {
                this.hEl.n(this.hEh.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hEh.ab(bundle);
        if (this.foO != null) {
            this.foO.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hEA.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hDS = System.currentTimeMillis();
        this.hEG = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eSl = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hDZ = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hDZ) && intent.getData() != null) {
                this.hDZ = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hDZ)) {
                this.hDN = true;
            }
            this.hFB = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hFC = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hFD = intent.getStringExtra("key_manga_title");
            this.hEv = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hEw = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hEx = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bRD()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.hEO = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.eSl = System.currentTimeMillis();
        }
        this.cyw = this.hDS - this.eSl;
        super.onCreate(bundle);
        this.hDQ = 0;
        aa(bundle);
        if (this.hEh != null && this.hEh.getPbData() != null) {
            this.hEh.getPbData().AW(this.source);
        }
        initUI();
        if (intent != null && this.hEl != null) {
            this.hEl.hMW = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hEJ == null) {
                    this.hEJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hEl.Bp("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hEJ, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hEh != null && this.hEh.getPbData() != null) {
                this.hEh.Bj(stringExtra);
            }
        }
        this.foO = new VoiceManager();
        this.foO.onCreate(getPageContext());
        initData(bundle);
        this.hEz = new com.baidu.tbadk.editortools.pb.f();
        bRb();
        this.hEA = (com.baidu.tbadk.editortools.pb.d) this.hEz.cJ(getActivity());
        this.hEA.b(this);
        this.hEA.a(this.csD);
        this.hEA.a(this.csw);
        this.hEA.a(this, bundle);
        this.hEA.aqS().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hEA.aqS().fd(true);
        nX(true);
        this.hEl.setEditorTools(this.hEA.aqS());
        this.hEA.a(this.hEh.bSS(), this.hEh.bSF(), this.hEh.bTk());
        registerListener(this.hEV);
        if (!this.hEh.bSL()) {
            this.hEA.qa(this.hEh.bSF());
        }
        if (this.hEh.bTl()) {
            this.hEA.pY(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.hEl != null) {
            this.hEA.pY(this.hEl.bUf());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hEU);
        registerListener(this.hEW);
        registerListener(this.hEX);
        registerListener(this.fqk);
        registerListener(this.hFl);
        registerListener(this.hET);
        this.hEy = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.iXZ);
        this.hEy.clV();
        registerListener(this.hEZ);
        registerListener(this.mAttentionListener);
        if (this.hEh != null) {
            this.hEh.bTc();
        }
        registerListener(this.hFp);
        registerListener(this.hFF);
        registerListener(this.fqr);
        if (this.hEl != null && this.hEl.bVd() != null && this.hEl.bVe() != null) {
            this.hDM = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hEl.bVd(), this.hEl.bVe(), this.hEl.bUl());
            this.hDM.a(this.hFh);
        }
        if (this.hDL && this.hEl != null && this.hEl.bVe() != null) {
            this.hEl.bVe().setVisibility(8);
        }
        this.hEH = new com.baidu.tbadk.core.view.e();
        this.hEH.bXF = 1000L;
        registerListener(this.hFk);
        registerListener(this.hFi);
        registerListener(this.hFj);
        registerListener(this.fHP);
        registerListener(this.fqh);
        this.hEI = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hEI;
        userMuteAddAndDelCustomMessage.setTag(this.hEI);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hEI;
        userMuteCheckCustomMessage.setTag(this.hEI);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hEh.bTi().a(this.dVz);
        this.hEq = new as();
        if (this.hEA.ars() != null) {
            this.hEq.k(this.hEA.ars().getInputView());
        }
        this.hEA.a(this.csx);
        this.fEO = new ShareSuccessReplyToServerModel();
        a(this.hEQ);
        this.gPK = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gPK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bSg) {
                        PbActivity.this.hEA.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bSh && PbActivity.this.hEl != null && PbActivity.this.hEl.bUc() != null && PbActivity.this.hEl.bUc().bSw() != null) {
                        PbActivity.this.hEl.bUc().bSw().arL();
                    } else if (i == com.baidu.tbadk.core.util.aj.bSi) {
                        PbActivity.this.c(PbActivity.this.hED);
                    }
                }
            }
        });
        this.hEi = new com.baidu.tieba.pb.pb.report.a(this);
        this.hEi.r(getUniqueId());
        com.baidu.tieba.q.c.clt().u(getUniqueId());
        com.baidu.tbadk.core.business.a.abt().bB("3", "");
        this.createTime = System.currentTimeMillis() - this.hDS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRb() {
        if (this.hEz != null && this.hEh != null) {
            this.hEz.setForumName(this.hEh.bQF());
            if (this.hEh.getPbData() != null && this.hEh.getPbData().getForum() != null) {
                this.hEz.a(this.hEh.getPbData().getForum());
            }
            this.hEz.setFrom("pb");
            this.hEz.a(this.hEh);
        }
    }

    public String bRc() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bRd() {
        return this.hDM;
    }

    private void nX(boolean z) {
        this.hEA.fh(z);
        this.hEA.fi(z);
        this.hEA.fj(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().bQg() && !z && this.hEl != null && this.hEl.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.hEl.getView().setSystemUiVisibility(4);
        }
        this.hEE = z;
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
        if (this.foO != null) {
            this.foO.onStart(getPageContext());
        }
    }

    public aq bRe() {
        return this.hEl;
    }

    public PbModel bQO() {
        return this.hEh;
    }

    public void AZ(String str) {
        if (this.hEh != null && !StringUtils.isNull(str) && this.hEl != null) {
            this.hEl.oM(true);
            this.hEh.AZ(str);
            this.hDY = true;
            this.hEl.bUP();
            this.hEl.bUY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hDO = false;
        } else {
            this.hDO = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hDQ = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hDQ == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.foO != null) {
            this.foO.onPause(getPageContext());
        }
        if (this.hEl != null) {
            this.hEl.onPause();
        }
        if (!this.hEh.bSL()) {
            this.hEA.pZ(this.hEh.bSF());
        }
        if (this.hEh != null) {
            this.hEh.bTd();
        }
        com.baidu.tbadk.BdToken.c.Yk().Yp();
        MessageManager.getInstance().unRegisterListener(this.gtJ);
        bvy();
        MessageManager.getInstance().unRegisterListener(this.hFi);
        MessageManager.getInstance().unRegisterListener(this.hFj);
        MessageManager.getInstance().unRegisterListener(this.hFk);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bRf() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hEh.getPbData(), this.hEh.bSG(), this.hEh.getRequestType());
        return (a2 == null || a2.adv() == null || a2.adv().getGodUserData() == null || a2.adv().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hDO = false;
        super.onResume();
        if (this.hEb) {
            this.hEb = false;
            bRJ();
        }
        if (bRf()) {
            this.hDV = System.currentTimeMillis();
        } else {
            this.hDV = -1L;
        }
        if (this.hEl != null && this.hEl.getView() != null) {
            if (!this.hhj) {
                bRA();
            } else {
                hideLoadingView(this.hEl.getView());
            }
            this.hEl.onResume();
        }
        if (this.hDQ == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hEl != null) {
            noNetworkView = this.hEl.bTZ();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.jS()) {
            noNetworkView.ek(false);
        }
        if (this.foO != null) {
            this.foO.onResume(getPageContext());
        }
        registerListener(this.gtJ);
        this.hEu = false;
        bRI();
        registerListener(this.hFi);
        registerListener(this.hFj);
        registerListener(this.hFk);
        if (this.fpE) {
            bRz();
            this.fpE = false;
        }
        bRR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hEl.oB(z);
        if (this.hEr != null) {
            this.hEr.dismiss();
        }
        if (z && this.hEu) {
            this.hEl.bUz();
            this.hEh.on(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hDV > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").bT("obj_duration", (System.currentTimeMillis() - this.hDV) + ""));
            this.hDV = 0L;
        }
        if (bRe().bUc() != null) {
            bRe().bUc().onStop();
        }
        if (this.hEl.hNd != null && !this.hEl.hNd.aYv()) {
            this.hEl.hNd.bGU();
        }
        if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().getForum() != null && this.hEh.getPbData().bPI() != null) {
            com.baidu.tbadk.distribute.a.aqF().a(getPageContext().getPageActivity(), "pb", this.hEh.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hEh.getPbData().bPI().getId(), 0L));
        }
        if (this.foO != null) {
            this.foO.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.clt().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.clt().v(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bT("fid", this.hEh.getPbData().getForumId());
            amVar.bT("tid", this.hEh.bSF());
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hDT && this.hEl != null) {
            this.hDT = true;
            this.hEl.bUU();
            a(false, (PostData) null);
        }
        if (this.hEh != null) {
            this.hEh.cancelLoadData();
            this.hEh.destory();
            if (this.hEh.bTh() != null) {
                this.hEh.bTh().onDestroy();
            }
        }
        if (this.hEA != null) {
            this.hEA.onDestroy();
        }
        if (this.eyx != null) {
            this.eyx.cancelLoadData();
        }
        if (this.hEl != null) {
            this.hEl.onDestroy();
            if (this.hEl.hNd != null) {
                this.hEl.hNd.bGU();
            }
        }
        if (this.hDU != null) {
            this.hDU.auc();
        }
        if (this.hDM != null) {
            this.hDM.avm();
        }
        super.onDestroy();
        if (this.foO != null) {
            this.foO.onDestory(getPageContext());
        }
        this.hEl.bUP();
        MessageManager.getInstance().unRegisterListener(this.hFi);
        MessageManager.getInstance().unRegisterListener(this.hFj);
        MessageManager.getInstance().unRegisterListener(this.hFk);
        MessageManager.getInstance().unRegisterListener(this.hEI);
        MessageManager.getInstance().unRegisterListener(this.hFl);
        MessageManager.getInstance().unRegisterListener(this.fqr);
        MessageManager.getInstance().unRegisterListener(this.fHP);
        MessageManager.getInstance().unRegisterListener(this.hFn);
        this.hEG = null;
        this.hEH = null;
        com.baidu.tieba.recapp.d.a.cfz().cfB();
        if (this.hEJ != null) {
            getSafeHandler().removeCallbacks(this.hEJ);
        }
        if (this.hEc != null) {
            this.hEc.cancelLoadData();
        }
        if (this.hEl != null && this.hEl.hNd != null) {
            this.hEl.hNd.bVQ();
        }
        if (this.fEO != null) {
            this.fEO.cancelLoadData();
        }
        this.hEq.onDestroy();
        if (this.hEh != null && this.hEh.bTj() != null) {
            this.hEh.bTj().onDestroy();
        }
        if (this.gPK != null) {
            this.gPK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bUu;
        ArrayList<PostData> bSh;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.akW() && this.hEl != null && (bUu = this.hEl.bUu()) != null && (bSh = bUu.bSh()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bSh.iterator();
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
                        bVar.eAu = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.bJA == 1 && !TextUtils.isEmpty(id)) {
                    next.bJA = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.eAu = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hEh == null || this.hEh.getPbData() == null || this.hEh.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hEh.getPbData().getForum().getFirst_class();
                    str2 = this.hEh.getPbData().getForum().getSecond_class();
                    str = this.hEh.getPbData().getForum().getId();
                    str4 = this.hEh.bSF();
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
            this.hEl.onChangeSkinType(i);
            if (this.hEA != null && this.hEA.aqS() != null) {
                this.hEA.aqS().onChangeSkinType(i);
            }
            if (this.hEl.bTZ() != null) {
                this.hEl.bTZ().onChangeSkinType(getPageContext(), i);
            }
            this.hEq.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.al.a(i, getResources(), (int) R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hEl = new aq(this, this.fqZ, this.ckg);
        this.dWi = new com.baidu.tieba.f.b(getActivity());
        this.dWi.a(hFy);
        this.dWi.a(this.dWj);
        this.hEl.setOnScrollListener(this.mOnScrollListener);
        this.hEl.e(this.fIZ);
        this.hEl.setListPullRefreshListener(this.cXI);
        this.hEl.nR(com.baidu.tbadk.core.i.abb().abf());
        this.hEl.setOnImageClickListener(this.cIM);
        this.hEl.b(this.clk);
        this.hEl.h(this.fmu);
        this.hEl.a(this.hFr);
        this.hEl.oB(this.mIsLogin);
        if (getIntent() != null) {
            this.hEl.oN(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hEl.bUb().setFromForumId(this.hEh.getFromForumId());
    }

    public void bRg() {
        if (this.hEl != null && this.hEh != null) {
            if ((this.hEh.getPbData() != null || this.hEh.getPbData().bQf() != null) && checkUpIsLogin() && this.hEl.bUu() != null && this.hEl.bUu().bSm() != null) {
                this.hEl.bUu().bSm().oC(this.hEh.bSF());
            }
        }
    }

    public void bRh() {
        TiebaStatic.log("c12181");
        if (this.hEl != null && this.hEh != null) {
            if (this.hEl == null || this.hEl.bUe()) {
                if (this.hEh.getPbData() != null || this.hEh.getPbData().bQf() != null) {
                    com.baidu.tieba.pb.data.j bQf = this.hEh.getPbData().bQf();
                    if (checkUpIsLogin()) {
                        if ((!bQf.bQo() || bQf.aeR() != 2) && this.hEl.bUu() != null && this.hEl.bUu().bSm() != null) {
                            this.hEl.bUu().bSm().oC(this.hEh.bSF());
                        }
                        if (System.currentTimeMillis() - this.hDX > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).pg(false);
                            this.hDX = System.currentTimeMillis();
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
                if (postData.getType() != PostData.iYB && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.abb().abf()) {
                    return Bc(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hEh == null || this.hEh.getPbData() == null) {
                        return true;
                    }
                    if (bRe().bUc() != null) {
                        bRe().bUc().bSs();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.hEh.getPbData().getForum());
                    kVar.ai(this.hEh.getPbData().bPI());
                    kVar.e(postData);
                    bRe().bUb().d(kVar);
                    bRe().bUb().setPostId(postData.getId());
                    a(view, postData.adv().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hEA != null) {
                        this.hEl.oH(this.hEA.arz());
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
        if (this.hEl != null) {
            if (z && !this.hhj) {
                bRA();
            } else {
                hideLoadingView(this.hEl.getView());
            }
            if (z && this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().bQg() && this.hEl.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                this.hEl.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bRi() {
        if (this.hDR == null) {
            this.hDR = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hDR.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hDG = PbActivity.this.hDG.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hDG);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hEh.bSF(), PbActivity.this.hDG, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hDG = PbActivity.this.hDG.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hDG);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hEh.bSF(), PbActivity.this.hDG, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hDG = PbActivity.this.hDG.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hDG);
                        bVar.dismiss();
                    }
                }
            }).ht(R.style.dialog_ani_b2t).hu(17).d(getPageContext());
        }
    }

    private void aa(Bundle bundle) {
        this.hEh = new PbModel(this);
        this.hEh.a(this.hFo);
        if (this.hEh.bTg() != null) {
            this.hEh.bTg().a(this.hFA);
        }
        if (this.hEh.bTf() != null) {
            this.hEh.bTf().a(this.hEY);
        }
        if (this.hEh.bTh() != null) {
            this.hEh.bTh().b(this.hES);
        }
        if (bundle != null) {
            this.hEh.initWithBundle(bundle);
        } else {
            this.hEh.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hEh.oq(true);
        }
        aj.bTO().aq(this.hEh.bSD(), this.hEh.getIsFromMark());
        if (StringUtils.isNull(this.hEh.bSF())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hDZ) && this.hDZ != null) {
            this.hEh.xw(6);
        }
        this.hEh.atv();
    }

    private void initData(Bundle bundle) {
        this.hEj = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hEj != null) {
            this.hEj.a(this.hFq);
        }
        this.eyx = new ForumManageModel(this);
        this.eyx.setLoadDataCallBack(this.eyB);
        this.bSl = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hEl.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.jS()) {
                    PbActivity.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hEh.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEh.getPbData().getForum().getId(), PbActivity.this.hEh.getPbData().getForum().getName(), PbActivity.this.hEh.getPbData().bPI().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hFe.setUniqueId(getUniqueId());
        this.hFe.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hEl.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hEI;
        userMuteCheckCustomMessage.setTag(this.hEI);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bRj() {
        if (checkUpIsLogin()) {
            if (this.fsw == null) {
                this.fsw = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fsw.si(0);
                this.fsw.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jV(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void n(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jW(boolean z) {
                        if (z) {
                            PbActivity.this.hEl.buL();
                        }
                    }
                });
            }
            if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().getForum() != null) {
                this.fsw.t(this.hEh.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hEh.bSF(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bRk() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hEh != null && (pbData = this.hEh.getPbData()) != null) {
            return pbData.bPT().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPI() != null) {
            if (dVar.bPI().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bPI().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bPI().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bRl()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hEe);
                this.hEf = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hEC == null) {
                this.hEC = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hEC.si(1);
                this.hEC.a(new AnonymousClass40(str, str2));
            }
            if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().getForum() != null) {
                this.hEC.t(this.hEh.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hEh.bSF(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$40  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String hFP;
        final /* synthetic */ String hFQ;

        AnonymousClass40(String str, String str2) {
            this.hFP = str;
            this.hFQ = str2;
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
                        PbActivity.this.bRe().getListView().smoothScrollBy((PbActivity.this.hEe[1] + PbActivity.this.hEf) - (ah - g), 50);
                        if (PbActivity.this.bRe().bUc() != null) {
                            PbActivity.this.hEA.aqS().setVisibility(8);
                            PbActivity.this.bRe().bUc().Y(AnonymousClass40.this.hFP, AnonymousClass40.this.hFQ, PbActivity.this.bRe().bUf());
                            com.baidu.tbadk.editortools.pb.g bSw = PbActivity.this.bRe().bUc().bSw();
                            if (bSw != null && PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                                bSw.a(PbActivity.this.hEh.getPbData().getAnti());
                            }
                            if (PbActivity.this.hEq.bVr() == null && PbActivity.this.bRe().bUc().bSw().arT() != null) {
                                PbActivity.this.bRe().bUc().bSw().arT().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hEq != null && PbActivity.this.hEq.bVq() != null) {
                                            if (!PbActivity.this.hEq.bVq().cwf()) {
                                                PbActivity.this.hEq.oP(false);
                                            }
                                            PbActivity.this.hEq.bVq().rK(false);
                                        }
                                    }
                                });
                                PbActivity.this.hEq.l(PbActivity.this.bRe().bUc().bSw().arT().getInputView());
                                PbActivity.this.bRe().bUc().bSw().a(PbActivity.this.hEF);
                            }
                        }
                        PbActivity.this.bRe().bUY();
                    }
                }, 0L);
            }
        }
    }

    public boolean bRl() {
        if (this.gPK == null || this.hEh.getPbData() == null || this.hEh.getPbData().getAnti() == null) {
            return true;
        }
        return this.gPK.hZ(this.hEh.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean xf(int i) {
        if (this.gPK == null || this.hEh.getPbData() == null || this.hEh.getPbData().getAnti() == null) {
            return true;
        }
        return this.gPK.R(this.hEh.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.hEh != null && this.hEh.getPbData() != null && postData.cmu() != 1) {
            String bSF = this.hEh.bSF();
            String id = postData.getId();
            int bPU = this.hEh.getPbData() != null ? this.hEh.getPbData().bPU() : 0;
            c Bd = Bd(id);
            if (Bd != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bSF, id, "pb", true, null, false, null, bPU, postData.bWE(), this.hEh.getPbData().getAnti(), false, postData.adv() != null ? postData.adv().getIconInfo() : null).addBigImageData(Bd.hGg, Bd.hGh, Bd.hGi, Bd.index);
                addBigImageData.setKeyPageStartFrom(this.hEh.bTn());
                addBigImageData.setFromFrsForumId(this.hEh.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bRm() {
        if (this.hEh.getPbData() == null || this.hEh.getPbData().bPI() == null) {
            return -1;
        }
        return this.hEh.getPbData().bPI().aef();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRn() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Dq(this.hEh.getForumId()) && this.hEh.getPbData() != null && this.hEh.getPbData().getForum() != null) {
            if (this.hEh.getPbData().getForum().isLike() == 1) {
                this.hEh.bTj().ed(this.hEh.getForumId(), this.hEh.bSF());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nY(boolean z) {
        if (this.hEh == null || this.hEh.getPbData() == null) {
            return false;
        }
        return ((this.hEh.getPbData().bPU() != 0) || this.hEh.getPbData().bPI() == null || this.hEh.getPbData().bPI().adv() == null || TextUtils.equals(this.hEh.getPbData().bPI().adv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bRo() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.t.y.auI()) {
            return "";
        }
        PostData bPP = bPP();
        if (this.hEh == null || (pbData = this.hEh.getPbData()) == null || pbData.getUserData() == null || pbData.bPI() == null || bPP == null || bPP.adv() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bPP.adv().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bPI().adc() == 0) {
            return "";
        }
        if (pbData.bPI().adc() == 0) {
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
        if (this.hEh == null || this.hEh.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hEh.getPbData();
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.bPU() != 0) {
                return pbData.bPU() != 3;
            }
            List<com.baidu.tbadk.core.data.bc> bQd = pbData.bQd();
            if (com.baidu.tbadk.core.util.v.Z(bQd) > 0) {
                for (com.baidu.tbadk.core.data.bc bcVar : bQd) {
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
        if (z || this.hEh == null || this.hEh.getPbData() == null) {
            return false;
        }
        return ((this.hEh.getPbData().getForum() != null && this.hEh.getPbData().getForum().isBlockBawuDelete) || this.hEh.getPbData().bPU() == 0 || this.hEh.getPbData().bPU() == 3) ? false : true;
    }

    public void bRp() {
        if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().bPI() != null && this.hEh.getPbData().bPI().adv() != null) {
            if (this.hEl != null) {
                this.hEl.bUa();
            }
            bg bPI = this.hEh.getPbData().bPI();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bPI.adv().getUserId());
            ab abVar = new ab();
            int bPU = this.hEh.getPbData().bPU();
            if (bPU == 1 || bPU == 3) {
                abVar.hLo = true;
                abVar.hLn = true;
                abVar.hLv = bPI.adq() == 1;
                abVar.hLu = bPI.adr() == 1;
            } else {
                abVar.hLo = false;
                abVar.hLn = false;
            }
            if (bPU == 1002 && !equals) {
                abVar.hLz = true;
            }
            abVar.hLp = nZ(equals);
            abVar.hLq = bRq();
            abVar.hLr = oa(equals);
            abVar.ox = this.hEh.bSG();
            abVar.hLm = true;
            abVar.hLl = nY(equals);
            abVar.hLx = bRo();
            abVar.hLk = equals && this.hEl.bUG();
            abVar.hLs = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hLt = true;
            abVar.isHostOnly = this.hEh.getHostMode();
            abVar.hLw = true;
            if (bPI.adM() == null) {
                abVar.hLy = true;
            } else {
                abVar.hLy = false;
            }
            this.hEl.hNd.a(abVar);
        }
    }

    private boolean bRq() {
        if (this.hEh != null && this.hEh.bSG()) {
            return this.hEh.getPageData() == null || this.hEh.getPageData().acq() != 0;
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

    public int bRr() {
        if (bRe() == null || bRe().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRe().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.i) && ((com.baidu.tieba.pb.data.i) mVar).mType == com.baidu.tieba.pb.data.i.hBV) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bRs() {
        if (bRe() == null || bRe().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRe().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.iYA) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bRz();
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
                    PbActivity.this.bSl.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hEh.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).afG();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hEl.bUA();
        this.hEh.op(z);
        if (this.hEj != null) {
            this.hEj.ds(z);
            if (markData != null) {
                this.hEj.a(markData);
            }
        }
        if (this.hEh.ZC()) {
            bRx();
        } else {
            this.hEl.m(this.hEh.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xd(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba(String str) {
        this.hEi.By(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hEh.bSL()) {
                    antiData.setBlock_forum_name(this.hEh.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hEh.getPbData().getForum().getId());
                    antiData.setUser_name(this.hEh.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hEh.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bRe() != null) {
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
            this.hEl.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.jbh) ? bVar.jbh : getString(R.string.delete_fail);
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
                this.hEl.a(0, bVar.FN, bVar.jbh, z);
            }
            if (bVar.FN) {
                if (bVar.eVs == 1) {
                    ArrayList<PostData> bPK = this.hEh.getPbData().bPK();
                    int size = bPK.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bPK.get(i).getId())) {
                            i++;
                        } else {
                            bPK.remove(i);
                            break;
                        }
                    }
                    this.hEh.getPbData().bPI().hc(this.hEh.getPbData().bPI().adm() - 1);
                    this.hEl.m(this.hEh.getPbData());
                } else if (bVar.eVs == 0) {
                    bRt();
                } else if (bVar.eVs == 2) {
                    ArrayList<PostData> bPK2 = this.hEh.getPbData().bPK();
                    int size2 = bPK2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bPK2.get(i2).cmr().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bPK2.get(i2).cmr().get(i3).getId())) {
                                i3++;
                            } else {
                                bPK2.get(i2).cmr().remove(i3);
                                bPK2.get(i2).cmt();
                                z2 = true;
                                break;
                            }
                        }
                        bPK2.get(i2).DU(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hEl.m(this.hEh.getPbData());
                    }
                    a(bVar, this.hEl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hEl.a(this.eyx.getLoadDataMode(), gVar.FN, gVar.jbh, false);
            if (gVar.FN) {
                this.hEn = true;
                if (i == 2 || i == 3) {
                    this.hEo = true;
                    this.hEp = false;
                } else if (i == 4 || i == 5) {
                    this.hEo = false;
                    this.hEp = true;
                }
                if (i == 2) {
                    this.hEh.getPbData().bPI().hf(1);
                    this.hEh.setIsGood(1);
                } else if (i == 3) {
                    this.hEh.getPbData().bPI().hf(0);
                    this.hEh.setIsGood(0);
                } else if (i == 4) {
                    this.hEh.getPbData().bPI().he(1);
                    this.hEh.pE(1);
                } else if (i == 5) {
                    this.hEh.getPbData().bPI().he(0);
                    this.hEh.pE(0);
                }
                this.hEl.d(this.hEh.getPbData(), this.hEh.bSG());
            }
        }
    }

    private void bRt() {
        if (this.hEh.bSH() || this.hEh.bSJ()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hEh.bSF());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hEh.bSF()));
        if (bRy()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRu() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bPR;
        boolean z = false;
        if (this.hEl != null) {
            this.hEl.bUP();
        }
        if (this.hEh != null && this.hEh.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hEh.getPbData().bPI().getId();
            if (this.hEh.isShareThread() && this.hEh.getPbData().bPI().bKP != null) {
                historyMessage.threadName = this.hEh.getPbData().bPI().bKP.showText;
            } else {
                historyMessage.threadName = this.hEh.getPbData().bPI().getTitle();
            }
            if (this.hEh.isShareThread() && !bQE()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hEh.getPbData().getForum().getName();
            }
            ArrayList<PostData> bPK = this.hEh.getPbData().bPK();
            int bUC = this.hEl != null ? this.hEl.bUC() : 0;
            if (bPK != null && bUC >= 0 && bUC < bPK.size()) {
                historyMessage.postID = bPK.get(bUC).getId();
            }
            historyMessage.isHostOnly = this.hEh.getHostMode();
            historyMessage.isSquence = this.hEh.bSG();
            historyMessage.isShareThread = this.hEh.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hEA != null) {
            this.hEA.onDestroy();
        }
        if (this.hDP && bRe() != null) {
            bRe().bVi();
        }
        if (this.hEh != null && (this.hEh.bSH() || this.hEh.bSJ())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hEh.bSF());
            if (this.hEn) {
                if (this.hEp) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hEh.bdk());
                }
                if (this.hEo) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hEh.getIsGood());
                }
            }
            if (this.hEh.getPbData() != null && System.currentTimeMillis() - this.hDS >= 40000 && (bPR = this.hEh.getPbData().bPR()) != null && !com.baidu.tbadk.core.util.v.aa(bPR.getDataList())) {
                intent.putExtra("guess_like_data", bPR);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hEO);
            }
            setResult(-1, intent);
        }
        if (bRy()) {
            if (this.hEh != null && this.hEl != null && this.hEl.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hEh.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bPO() && !this.hDY && pbData.hBD == null) {
                        aj bTO = aj.bTO();
                        com.baidu.tieba.pb.data.d bSN = this.hEh.bSN();
                        Parcelable onSaveInstanceState = this.hEl.getListView().onSaveInstanceState();
                        boolean bSG = this.hEh.bSG();
                        boolean hostMode = this.hEh.getHostMode();
                        if (this.hEl.bUl() != null && this.hEl.bUl().getVisibility() == 0) {
                            z = true;
                        }
                        bTO.a(bSN, onSaveInstanceState, bSG, hostMode, z);
                        if (this.hEN >= 0 || this.hEh.bTp() != null) {
                            aj.bTO().l(this.hEh.bTp());
                            aj.bTO().k(this.hEh.bTq());
                            aj.bTO().xy(this.hEh.bTr());
                        }
                    }
                }
            } else {
                aj.bTO().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hEl == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hEl.xD(i)) {
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
            this.hEl.bUa();
            this.hEl.bUc().bSs();
            this.hEl.oJ(false);
        }
        this.hEl.bUd();
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
                        this.hEA.resetData();
                        this.hEA.b(writeData);
                        this.hEA.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k kj = this.hEA.aqS().kj(6);
                        if (kj != null && kj.cqE != null) {
                            kj.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hEA.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hEl.bUc() != null && this.hEl.bUc().bSw() != null) {
                            com.baidu.tbadk.editortools.pb.g bSw = this.hEl.bUc().bSw();
                            bSw.b(writeData);
                            bSw.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k kj2 = bSw.aqS().kj(6);
                            if (kj2 != null && kj2.cqE != null) {
                                kj2.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bSw.arL();
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
        this.hEA.onActivityResult(i, i2, intent);
        if (this.hEc != null) {
            this.hEc.onActivityResult(i, i2, intent);
        }
        if (bRe().bUc() != null) {
            bRe().bUc().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bRw();
                    return;
                case 13008:
                    aj.bTO().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hEh != null) {
                                PbActivity.this.hEh.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.cer().w(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hEh != null) {
                        a(bRv(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    ag(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.cer().w(getPageContext());
                        bRn();
                        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.fEO != null && shareItem != null && shareItem.linkUrl != null) {
                            this.fEO.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
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
                    this.hEl.nW(false);
                    if (this.hEh.getPbData() != null && this.hEh.getPbData().bPI() != null && this.hEh.getPbData().bPI().adP() != null) {
                        this.hEh.getPbData().bPI().adP().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hED = emotionImageData;
                        if (xf(com.baidu.tbadk.core.util.aj.bSi)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hEl != null && this.hEl.hNd != null) {
                        this.hEl.hNd.TU();
                        this.hEl.hNd.bVK();
                        if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().bPI() != null) {
                            this.hEh.getPbData().bPI().ha(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hEd != null) {
                        this.hEl.cB(this.hEd);
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
            if (this.hEc == null) {
                this.hEc = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hEc.b(this.csw);
                this.hEc.c(this.csD);
            }
            this.hEc.a(emotionImageData, bQO(), bQO().getPbData());
        }
    }

    private ShareFromPBMsgData bRv() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ea = this.hEh.getPbData().ea(getPageContext().getPageActivity());
        PostData bUg = this.hEl.bUg();
        String str = "";
        if (bUg != null) {
            str = bUg.getId();
            String el = bUg.el(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(el)) {
                ea[1] = el;
            }
        }
        String adL = this.hEh.getPbData().bPI().adL();
        if (adL != null && adL.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ea[1]);
        shareFromPBMsgData.setImageUrl(ea[0]);
        shareFromPBMsgData.setForumName(this.hEh.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hEh.getPbData().bPI().getId());
        shareFromPBMsgData.setTitle(this.hEh.getPbData().bPI().getTitle());
        return shareFromPBMsgData;
    }

    private void ag(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bRv(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().bPI() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hr(1);
            aVar.aF(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null) {
                        com.baidu.tbadk.core.util.am bT = new com.baidu.tbadk.core.util.am("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).P("obj_param1", 3).bT("fid", PbActivity.this.hEh.getForumId()).bT("tid", PbActivity.this.hEh.bSF());
                        if (PbActivity.this.d(PbActivity.this.hEh.getPbData()) != 0) {
                            bT.P("obj_type", PbActivity.this.d(PbActivity.this.hEh.getPbData()));
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
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hEh.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().bPI() != null) {
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
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hEh.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRw() {
        MarkData xv;
        if (this.hEj != null && (xv = this.hEh.xv(this.hEl.bUD())) != null) {
            if (!xv.isApp() || (xv = this.hEh.xv(this.hEl.bUD() + 1)) != null) {
                this.hEl.bUy();
                this.hEj.a(xv);
                if (!this.hEj.ZC()) {
                    this.hEj.ZE();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hEj.ZD();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        com.baidu.tieba.pb.data.d pbData = this.hEh.getPbData();
        this.hEh.op(true);
        if (this.hEj != null) {
            pbData.AV(this.hEj.ZB());
        }
        this.hEl.m(pbData);
    }

    private boolean bRy() {
        if (this.hEh == null) {
            return true;
        }
        if (this.hEh.ZC()) {
            final MarkData bSX = this.hEh.bSX();
            if (bSX == null || !this.hEh.getIsFromMark()) {
                return true;
            }
            final MarkData xv = this.hEh.xv(this.hEl.bUC());
            if (xv == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bSX);
                setResult(-1, intent);
                return true;
            } else if (xv.getPostId() == null || xv.getPostId().equals(bSX.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bSX);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mE(getPageContext().getString(R.string.alert_update_mark));
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hEj != null) {
                            if (PbActivity.this.hEj.ZC()) {
                                PbActivity.this.hEj.ZD();
                                PbActivity.this.hEj.ds(false);
                            }
                            PbActivity.this.hEj.a(xv);
                            PbActivity.this.hEj.ds(true);
                            PbActivity.this.hEj.ZE();
                        }
                        bSX.setPostId(xv.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bSX);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bRu();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bSX);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bRu();
                    }
                });
                aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hEl != null && PbActivity.this.hEl.getView() != null) {
                            PbActivity.this.hEl.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bSX);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bRu();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.afG();
                return false;
            }
        } else if (this.hEh.getPbData() == null || this.hEh.getPbData().bPK() == null || this.hEh.getPbData().bPK().size() <= 0 || !this.hEh.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hEl == null) {
            return null;
        }
        return this.hEl.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ayf() {
        if (this.hEl == null) {
            return 0;
        }
        return this.hEl.bUN();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> ayg() {
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
    public com.baidu.adp.lib.e.b<TextView> ayh() {
        if (this.cLs == null) {
            this.cLs = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cLs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> ayi() {
        if (this.cIE == null) {
            this.cIE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRT */
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
    public com.baidu.adp.lib.e.b<View> ayj() {
        if (this.cLt == null) {
            this.cLt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRU */
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
                    ((PlayVoiceBntNew) view).cnD();
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
    public com.baidu.adp.lib.e.b<RelativeLayout> ayl() {
        this.cLv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bRV */
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
        this.hDW = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (av.Bq(str) && this.hEh != null && this.hEh.bSF() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").P("obj_param1", 1).bT("post_id", this.hEh.bSF()));
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
            av.bVt().c(getPageContext(), str);
        }
        this.hDW = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        av.bVt().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hDW = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Rect rect) {
        if (rect != null && this.hEl != null && this.hEl.bVd() != null && rect.top <= this.hEl.bVd().getHeight()) {
            rect.top += this.hEl.bVd().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hEh.getPbData();
            TbRichText bd = bd(str, i);
            if (bd != null && (tbRichTextData = bd.axy().get(this.hFt)) != null) {
                cVar.hGg = new ArrayList<>();
                cVar.hGh = new ConcurrentHashMap<>();
                if (!tbRichTextData.axF().axR()) {
                    cVar.hGj = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hGg.add(b2);
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
                    imageUrlData.mIsReserver = this.hEh.bSV();
                    imageUrlData.mIsSeeHost = this.hEh.getHostMode();
                    cVar.hGh.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bPI() != null) {
                            cVar.threadId = pbData.bPI().getId();
                        }
                        cVar.hGi = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.hGj = true;
                int size = pbData.bPK().size();
                this.hFu = false;
                cVar.index = -1;
                if (pbData.bPP() != null) {
                    PostData bPP = pbData.bPP();
                    TbRichText cmw = bPP.cmw();
                    if (!ap.m(bPP)) {
                        i2 = a(cmw, bd, i, i, cVar.hGg, cVar.hGh);
                    } else {
                        i2 = a(bPP, i, cVar.hGg, cVar.hGh);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bPK().get(i4);
                    if (postData.getId() == null || pbData.bPP() == null || pbData.bPP().getId() == null || !postData.getId().equals(pbData.bPP().getId())) {
                        TbRichText cmw2 = postData.cmw();
                        if (!ap.m(postData)) {
                            i3 = a(cmw2, bd, i3, i, cVar.hGg, cVar.hGh);
                        } else {
                            i3 = a(postData, i3, cVar.hGg, cVar.hGh);
                        }
                    }
                }
                if (cVar.hGg.size() > 0) {
                    cVar.lastId = cVar.hGg.get(cVar.hGg.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bPI() != null) {
                        cVar.threadId = pbData.bPI().getId();
                    }
                    cVar.hGi = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.axF() == null) {
            return null;
        }
        return tbRichTextData.axF().axW();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.axF() == null) {
            return 0L;
        }
        return tbRichTextData.axF().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.axF() == null) {
            return false;
        }
        return tbRichTextData.axF().axX();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.axF() == null) {
            return false;
        }
        return tbRichTextData.axF().axY();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo axF;
        String str;
        if (tbRichText == tbRichText2) {
            this.hFu = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.axy().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.axy().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.axF().getWidth() * ai;
                    int height = ai * tbRichTextData.axF().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.axF().axR()) {
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
                            if (tbRichTextData != null && (axF = tbRichTextData.axF()) != null) {
                                String axT = axF.axT();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = axF.axU();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = axT;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hEh.bSF(), -1L);
                                imageUrlData.mIsReserver = this.hEh.bSV();
                                imageUrlData.mIsSeeHost = this.hEh.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hFu) {
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
        com.baidu.tieba.tbadkCore.data.i cmD;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> clZ;
        if (postData != null && arrayList != null && concurrentHashMap != null && (clZ = (cmD = postData.cmD()).clZ()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == clZ.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = clZ.get(i3);
                if (kVar != null) {
                    String cmd = kVar.cmd();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(cmd)) {
                        arrayList.add(cmd);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cmd;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cmc();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hEh.bSF(), -1L);
                        imageUrlData.mIsReserver = this.hEh.bSV();
                        imageUrlData.mIsSeeHost = this.hEh.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cmD.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cmd, imageUrlData);
                        }
                        if (!this.hFu) {
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
            if (postData.getId() != null && postData.getId().equals(this.hEh.adE())) {
                z = true;
            }
            MarkData j = this.hEh.j(postData);
            if (j != null) {
                this.hEl.bUy();
                if (this.hEj != null) {
                    this.hEj.a(j);
                    if (!z) {
                        this.hEj.ZE();
                    } else {
                        this.hEj.ZD();
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
        if (this.hEh == null || this.hEh.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hEh.getPbData();
        if (pbData.bPP() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bPP());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bPK = pbData.bPK();
            a(pbData, bPK);
            return a(bPK, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bPT() != null && dVar.bPT().hCk != null && (list = dVar.bPT().hCk) != null && arrayList != null) {
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
        ArrayList<PostData> bPK;
        com.baidu.tieba.pb.data.d pbData = this.hEh.getPbData();
        if (pbData != null && (bPK = pbData.bPK()) != null && !bPK.isEmpty()) {
            Iterator<PostData> it = bPK.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cmD = next.cmD();
                if (cmD != null && cmD.iYh) {
                    Iterator<TbRichTextData> it2 = next.cmw().axy().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.axO().getLink().equals(str)) {
                            return cmD.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> axy;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cmw = arrayList.get(i2).cmw();
            if (cmw != null && (axy = cmw.axy()) != null) {
                int size = axy.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (axy.get(i4) != null && axy.get(i4).getType() == 8) {
                        i3++;
                        if (axy.get(i4).axF().axT().equals(str) || axy.get(i4).axF().axU().equals(str)) {
                            int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                            int width = axy.get(i4).axF().getWidth() * ai;
                            int height = axy.get(i4).axF().getHeight() * ai;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hFt = i4;
                            return cmw;
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
            this.hDG = str;
            if (this.hDR == null) {
                bRi();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hDR.hw(1).setVisibility(8);
            } else {
                this.hDR.hw(1).setVisibility(0);
            }
            this.hDR.afJ();
            this.hDW = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.foO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRz() {
        hideNetRefreshView(this.hEl.getView());
        bRA();
        if (this.hEh.atv()) {
            this.hEl.bUy();
        }
    }

    private void bRA() {
        showLoadingView(this.hEl.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View asC = getLoadingView().asC();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) asC.getLayoutParams();
        layoutParams.addRule(3, this.hEl.bVd().getId());
        asC.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bke() {
        if (this.foO != null) {
            this.foO.stopPlay();
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
        bg bPI;
        if (this.hEh.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hEh.getPbData();
            pbData.getForum().getName();
            String title = pbData.bPI().getTitle();
            int i2 = this.hEh.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Dq(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hEh.bSF() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] ea = pbData.ea(getPageContext().getPageActivity());
                    str = ea[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = ea[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bRm() == 1) {
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
                    eVar.extData = this.hEh.bSF();
                    eVar.cjF = 3;
                    eVar.cjE = i;
                    eVar.fid = this.hEh.getForumId();
                    eVar.tid = this.hEh.bSF();
                    eVar.cjJ = d(pbData);
                    eVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        eVar.imageUri = parse;
                    }
                    bPI = this.hEh.getPbData().bPI();
                    eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bPI);
                    TbadkCoreApplication.getInst().setShareItem(eVar);
                    if (bPI != null) {
                        eVar.cjT = bPI.getShareImageUrl();
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
                            if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bQg() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                                PbActivity.this.hEl.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.aZz().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hEh.bSF() + "?share=9105&fr=share&see_lz=" + i2;
            String[] ea2 = pbData.ea(getPageContext().getPageActivity());
            str = ea2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = ea2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bRm() == 1) {
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = str2;
            eVar2.linkUrl = str32;
            eVar2.cjm = true;
            eVar2.cjt = z;
            eVar2.extData = this.hEh.bSF();
            eVar2.cjF = 3;
            eVar2.cjE = i;
            eVar2.fid = this.hEh.getForumId();
            eVar2.tid = this.hEh.bSF();
            eVar2.cjJ = d(pbData);
            eVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            bPI = this.hEh.getPbData().bPI();
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bPI);
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            if (bPI != null) {
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
                    if (PbActivity.this.hEh != null && PbActivity.this.hEh.getPbData() != null && PbActivity.this.hEh.getPbData().bQg() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                        PbActivity.this.hEl.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.aZz().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPI() != null) {
            if (dVar.bPI().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bPI().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRB() {
        com.baidu.tbadk.util.aa.a(new com.baidu.tbadk.util.z<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.Dr(PbActivity.this.hEh.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hEl.bVj();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> ayk() {
        if (this.cLu == null) {
            this.cLu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRW */
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

    public void bkf() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData biW() {
        if (this.hEh == null || this.hEh.getPbData() == null) {
            return null;
        }
        return this.hEh.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.afI() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.afI();
            int intValue = ((Integer) sparseArray.get(aq.hOW)).intValue();
            if (intValue == aq.hOX) {
                if (!this.eyx.cnf()) {
                    this.hEl.bUv();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eyx.Ea(com.baidu.tbadk.core.util.ap.y(jSONArray));
                    }
                    this.eyx.a(this.hEh.getPbData().getForum().getId(), this.hEh.getPbData().getForum().getName(), this.hEh.getPbData().bPI().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hOY || intValue == aq.hPa) {
                if (this.hEh.bTg() != null) {
                    this.hEh.bTg().xl(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hOY) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hEI);
        userMuteAddAndDelCustomMessage.setTag(this.hEI);
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
        this.hEu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bRC() {
        ArrayList<PostData> bPK;
        int Z;
        if (this.hEh == null || this.hEh.getPbData() == null || this.hEh.getPbData().bPK() == null || (Z = com.baidu.tbadk.core.util.v.Z((bPK = this.hEh.getPbData().bPK()))) == 0) {
            return "";
        }
        if (this.hEh.bSV()) {
            Iterator<PostData> it = bPK.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cmu() == 1) {
                    return next.getId();
                }
            }
        }
        int bUC = this.hEl.bUC();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bPK, bUC);
        if (postData == null || postData.adv() == null) {
            return "";
        }
        if (this.hEh.Bg(postData.adv().getUserId())) {
            return postData.getId();
        }
        for (int i = bUC - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bPK, i);
            if (postData2 == null || postData2.adv() == null || postData2.adv().getUserId() == null) {
                break;
            } else if (this.hEh.Bg(postData2.adv().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bUC + 1; i2 < Z; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bPK, i2);
            if (postData3 == null || postData3.adv() == null || postData3.adv().getUserId() == null) {
                return "";
            }
            if (this.hEh.Bg(postData3.adv().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.aiz().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(Bb(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hEh.getPbData().getForum().getId(), this.hEh.getPbData().getForum().getName(), this.hEh.getPbData().bPI().getTid());
            }
            this.hDW = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hEh.bTf() != null) {
                    PbActivity.this.hEh.bTf().eb(j);
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
        if (this.hEh.getPbData() == null || this.hEh.getPbData().bPK() == null || this.hEh.getPbData().bPK().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hEh.getPbData().bPK().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hEh.getPbData().bPK().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hEh.getPbData().bPK().get(i);
        if (postData.cmw() == null || postData.cmw().axy() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cmw().axy().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.axF() != null) {
                    str2 = next.axF().axT();
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
        if (this.hDN) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hDN = false;
        } else if (bRD()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hDN) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hDN = false;
        } else if (bRD()) {
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
        if (pageStayDurationItem != null && this.hEh != null) {
            if (this.hEh.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.hEh.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.hEh.bSF(), 0L));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bRD() {
        return (!this.hDL && this.hFB == -1 && this.hFC == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hFE = oVar;
            this.hDL = true;
            this.hEl.bUm();
            this.hEl.Bo(this.hFD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRE() {
        if (this.hFE != null) {
            if (this.hFB == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cD(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hFE.getCartoonId(), this.hFB, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRF() {
        if (this.hFE != null) {
            if (this.hFC == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cD(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hFE.getCartoonId(), this.hFC, 0)));
                finish();
            }
        }
    }

    public int bRG() {
        return this.hFB;
    }

    public int bRH() {
        return this.hFC;
    }

    private void bvy() {
        if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().bPI() != null && this.hEh.getPbData().bPI().aep()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bRI() {
        if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().bPI() != null && this.hEh.getPbData().bPI().aep()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bRJ() {
        if (this.hDO) {
            this.hEb = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hEh.getPbData() != null && this.hEh.getPbData().bPI() != null && this.hEh.getPbData().bPI().adb() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hEh.getPbData().bPI().adb().getThreadId(), this.hEh.getPbData().bPI().adb().getTaskId(), this.hEh.getPbData().bPI().adb().getForumId(), this.hEh.getPbData().bPI().adb().getForumName(), this.hEh.getPbData().bPI().adq(), this.hEh.getPbData().bPI().adr())));
            this.hDN = true;
            finish();
        }
    }

    public String bRK() {
        return this.hDZ;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bRL() {
        return this.hEg;
    }

    public void oc(boolean z) {
        this.hEa = z;
    }

    public boolean bRM() {
        if (this.hEh != null) {
            return this.hEh.bSH();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mE(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hEG).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hEG.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hEG).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hEG != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEG.getPageActivity());
            aVar.mE(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hEG).afG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hEl.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEG.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.mE(this.hEG.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mE(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hEl.showLoadingDialog();
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
        aVar.b(this.hEG).afG();
    }

    public void bRO() {
        if (this.hEh != null && this.hEh.getPbData() != null && this.hEh.getPbData().bPI() != null && this.hEh.getPbData().bPI().aeF() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.ho(R.string.channel_open_push_message);
            aVar.a(R.string.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hEh.getPbData().bPI().aeF().channelId, true, PbActivity.this.getUniqueId())));
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
        if (configuration.orientation != this.fOg) {
            this.fOg = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.hEl != null) {
                this.hEl.onConfigurationChanged(configuration);
            }
            if (this.hEr != null) {
                this.hEr.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921419, configuration));
        }
    }

    public boolean bRP() {
        if (this.hEh != null) {
            return this.hEh.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hEh.getPbData().bPT().hCk;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cmr().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cmr().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cmr().remove(i2);
                    list.get(i).cmt();
                    z = true;
                    break;
                }
            }
            list.get(i).DU(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.hEh.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bQr().getId();
        List<PostData> list = this.hEh.getPbData().bPT().hCk;
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
                ArrayList<PostData> bQv = kVar.bQv();
                postData.Ax(kVar.getTotalCount());
                if (postData.cmr() != null) {
                    postData.cmr().clear();
                    postData.cmr().addAll(bQv);
                }
            }
        }
        if (!this.hEh.getIsFromMark()) {
            this.hEl.m(this.hEh.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bQD() {
        return this.hEm;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bQE() {
        if (this.hEh == null) {
            return false;
        }
        return this.hEh.bQE();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bQF() {
        if (this.hEh != null) {
            return this.hEh.bQF();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bQG() {
        if (this.hEh == null || this.hEh.getPbData() == null) {
            return 0;
        }
        return this.hEh.getPbData().bPU();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AX(String str) {
        return this.hEh != null && this.hEh.Bg(str);
    }

    public void bRQ() {
        if (this.hEl != null) {
            this.hEl.bUa();
            bkf();
        }
    }

    public PostData bPP() {
        return this.hEl.c(this.hEh.hJH, this.hEh.bSG());
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
        if (this.hEP != null && !this.hEP.isEmpty()) {
            int size = this.hEP.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hEP.get(i).onBackPressed()) {
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
            if (this.hEP == null) {
                this.hEP = new ArrayList();
            }
            if (!this.hEP.contains(aVar)) {
                this.hEP.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hEP == null) {
                this.hEP = new ArrayList();
            }
            if (!this.hEP.contains(aVar)) {
                this.hEP.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hEP != null) {
            this.hEP.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRR() {
        if (this.hEh != null && !com.baidu.tbadk.core.util.ap.isEmpty(this.hEh.bSF())) {
            com.baidu.tbadk.BdToken.c.Yk().k(com.baidu.tbadk.BdToken.b.bwW, com.baidu.adp.lib.g.b.c(this.hEh.bSF(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hEh == null || com.baidu.tbadk.core.util.ap.isEmpty(this.hEh.bSF())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.hEh.bSF(), 0L);
    }
}
