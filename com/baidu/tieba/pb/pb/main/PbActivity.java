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
import android.view.animation.AnimationUtils;
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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PostPraiseView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.p.ax;
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
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.pb.main.r;
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
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<PbActivity> {
    private com.baidu.adp.lib.e.b<TbImageView> aKP;
    private com.baidu.adp.lib.e.b<ImageView> brG;
    private com.baidu.adp.lib.e.b<TextView> brH;
    private com.baidu.adp.lib.e.b<View> brI;
    private com.baidu.adp.lib.e.b<LinearLayout> brJ;
    private com.baidu.adp.lib.e.b<RelativeLayout> brK;
    private com.baidu.adp.lib.e.b<GifView> brL;
    private com.baidu.tbadk.core.util.b.a bzi;
    private com.baidu.tieba.f.b cwP;
    private VoiceManager dKQ;
    private com.baidu.tbadk.core.dialog.h dLC;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fVJ;
    private View fVK;
    private com.baidu.tieba.pb.pb.report.a fVN;
    public at fVU;
    private y fVV;
    private boolean fVX;
    private String fVn;
    private com.baidu.tieba.pb.pb.main.b.b fVt;
    private boolean fWT;
    private com.baidu.tieba.tbadkCore.data.e fWa;
    private com.baidu.tbadk.editortools.pb.f fWb;
    private com.baidu.tbadk.editortools.pb.d fWc;
    private EmotionImageData fWe;
    private com.baidu.adp.base.e fWh;
    private com.baidu.tbadk.core.view.g fWi;
    private BdUniqueId fWj;
    private Runnable fWk;
    private av fWl;
    private com.baidu.adp.widget.ImageView.a fWm;
    private String fWn;
    private TbRichTextMemeInfo fWo;
    private List<a> fWr;
    private String fXe;
    private com.baidu.tbadk.core.data.m fXf;
    public com.baidu.tbadk.core.util.aj fhU;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.aCO));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.aCO));
        }
    };
    private static final b.a fWZ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.f.b.a
        public void fY(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bhN();
            } else {
                com.baidu.tieba.pb.a.b.bhM();
            }
        }
    };
    private boolean fVs = false;
    private boolean fVu = false;
    private boolean fVv = false;
    private boolean fyX = false;
    private boolean fVw = true;
    private int fVx = 0;
    private com.baidu.tbadk.core.dialog.b fVy = null;
    private long dru = -1;
    private long bfY = 0;
    private long fVz = 0;
    private long createTime = 0;
    private long bfQ = 0;
    private boolean fVA = false;
    private com.baidu.tbadk.l.b fVB = null;
    private long fVC = 0;
    private boolean fVD = false;
    private long fVE = 0;
    private String aZY = null;
    private boolean fVF = false;
    private boolean isFullScreen = false;
    private String fVG = "";
    private boolean fVH = true;
    private boolean fVI = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fVL = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void O(boolean z) {
            PbActivity.this.fVP.lo(!PbActivity.this.fVH);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fVM != null && PbActivity.this.fVM.wq()) {
                        PbActivity.this.biJ();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fVM = null;
    private com.baidu.tbadk.baseEditMark.a fVO = null;
    private ForumManageModel cYy = null;
    private com.baidu.tbadk.coreExtra.model.a aCb = null;
    private ShareSuccessReplyToServerModel eax = null;
    private ar fVP = null;
    public final com.baidu.tieba.pb.pb.main.b.a fVQ = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean fVR = false;
    private boolean fVS = false;
    private boolean fVT = false;
    private boolean fVW = false;
    private boolean fVY = false;
    private boolean fVZ = false;
    private boolean fWd = false;
    public boolean fWf = false;
    private com.baidu.tbadk.editortools.pb.c bab = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Mw() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b bac = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Mv() {
            if (PbActivity.this.fVU == null || PbActivity.this.fVU.bmy() == null || !PbActivity.this.fVU.bmy().bNN()) {
                return !PbActivity.this.sq(com.baidu.tbadk.core.util.aj.aBW);
            }
            PbActivity.this.showToast(PbActivity.this.fVU.bmy().bNP());
            if (PbActivity.this.fWc != null && (PbActivity.this.fWc.MK() || PbActivity.this.fWc.ML())) {
                PbActivity.this.fWc.a(false, PbActivity.this.fVU.bmB());
            }
            PbActivity.this.fVU.lA(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fWg = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Mv() {
            if (PbActivity.this.fVU == null || PbActivity.this.fVU.bmz() == null || !PbActivity.this.fVU.bmz().bNN()) {
                return !PbActivity.this.sq(com.baidu.tbadk.core.util.aj.aBX);
            }
            PbActivity.this.showToast(PbActivity.this.fVU.bmz().bNP());
            if (PbActivity.this.fVP != null && PbActivity.this.fVP.bll() != null && PbActivity.this.fVP.bll().bjH() != null && PbActivity.this.fVP.bll().bjH().ML()) {
                PbActivity.this.fVP.bll().bjH().a(PbActivity.this.fVU.bmB());
            }
            PbActivity.this.fVU.lB(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dLy = false;
    private int fWp = 0;
    private int fWq = -1;
    private final a fWs = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fVP != null && PbActivity.this.fVP.bll() != null) {
                s bll = PbActivity.this.fVP.bll();
                if (bll.bjE()) {
                    bll.bjD();
                    return true;
                }
            }
            if (PbActivity.this.fVP != null && PbActivity.this.fVP.bme()) {
                PbActivity.this.fVP.bmf();
                return true;
            }
            return false;
        }
    };
    private r.a fWt = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
    };
    private AddExperiencedModel.a dLH = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.biN();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final z.a fWu = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void P(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fVP.showToast(str);
            }
        }
    };
    private final CustomMessageListener fWv = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fVM != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fWc != null) {
                    PbActivity.this.fVP.lt(PbActivity.this.fWc.ME());
                }
                PbActivity.this.fVP.blm();
                PbActivity.this.fVP.blX();
            }
        }
    };
    CustomMessageListener dLZ = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.fVM.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.fVP != null && PbActivity.this.fVM != null) {
                    PbActivity.this.fVP.d(PbActivity.this.fVM.getPbData(), PbActivity.this.fVM.bjQ(), PbActivity.this.fVM.getRequestType());
                }
                if (PbActivity.this.fVP != null && PbActivity.this.fVP.blD() != null) {
                    PbActivity.this.fVP.blD().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fWw = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fVP != null) {
                    if (booleanValue) {
                        PbActivity.this.fVP.aTj();
                    } else {
                        PbActivity.this.fVP.aTi();
                    }
                }
            }
        }
    };
    private CustomMessageListener fWx = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fWc != null) {
                    PbActivity.this.fVP.lt(PbActivity.this.fWc.ME());
                }
                PbActivity.this.fVP.lv(false);
            }
        }
    };
    private CustomMessageListener fWy = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customResponsedMessage.getData();
                switch (dVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.j) dVar.getData());
                        return;
                    case 1:
                        PbActivity.this.a((ForumManageModel.b) dVar.getData(), false);
                        return;
                    case 2:
                        if (dVar.getData() == null) {
                            PbActivity.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbActivity.this.a(true, (MarkData) dVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener fWz = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fVP != null && PbActivity.this.fVP.blD() != null) {
                PbActivity.this.fVP.blD().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener eLR = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener akA = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.fVv) {
                PbActivity.this.bjd();
            }
        }
    };
    private h.a fWA = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void n(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.ss(2);
                aj.bkX().reset();
                PbActivity.this.fVM.bki();
                boolean z2 = false;
                ArrayList<PostData> bgX = PbActivity.this.fVM.getPbData().bgX();
                if (bgX != null) {
                    Iterator<PostData> it = bgX.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.bEs().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fVP.n(PbActivity.this.fVM.getPbData());
                    }
                    PbActivity.this.showToast(e.j.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(e.j.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(e.j.operation_failed);
        }
    };
    private View.OnClickListener baJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aZY);
        }
    };
    private CustomMessageListener fWB = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fVM.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fVM.bjZ() != null && PbActivity.this.fVM.bjZ().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fVP.a(yVar.sendCount, PbActivity.this.fVM.getPbData(), PbActivity.this.fVM.bjQ(), PbActivity.this.fVM.getRequestType());
                    }
                    if (pbData.bgX() != null && pbData.bgX().size() >= 1 && pbData.bgX().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bgX().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.fVM.bjP(), 0L);
                        if (d2 == yVar.postId && d3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bEr = pbData.bgX().get(0).bEr();
                            if (bEr == null) {
                                bEr = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> yR = bEr.yR();
                            if (yR == null) {
                                yR = new ArrayList<>();
                            }
                            yR.add(0, aVar);
                            bEr.setTotal(yVar.sendCount + bEr.getTotal());
                            bEr.k(yR);
                            pbData.bgX().get(0).a(bEr);
                            PbActivity.this.fVP.blD().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener edv = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null) {
                PbActivity.this.sR((String) customResponsedMessage.getData());
                PbActivity.this.fVM.bkf();
                if (PbActivity.this.fVP.blD() != null) {
                    PbActivity.this.fVP.n(PbActivity.this.fVM.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a fWC = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.awK() != null && !aVar.awK().isEmpty()) {
                    PbActivity.this.fVP.a(aVar, PbActivity.this.fWE);
                }
                PbActivity.this.fVP.a(aVar, PbActivity.this.fVM.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bmI()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fWD = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void P(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.I(list) && PbActivity.this.fVP != null) {
                PbActivity.this.fVP.m20do(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fWE = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bJ(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.jA().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18.1
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
    private boolean fWF = false;
    private PraiseModel fWG = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void kd(String str) {
            PbActivity.this.fWF = false;
            if (PbActivity.this.fWG != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fVM.getPbData();
                if (pbData.bgV().zt().getIsLike() == 1) {
                    PbActivity.this.ni(0);
                } else {
                    PbActivity.this.ni(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bgV()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void N(int i, String str) {
            PbActivity.this.fWF = false;
            if (PbActivity.this.fWG != null && str != null) {
                if (AntiHelper.aj(i, str)) {
                    AntiHelper.aJ(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fWH = 0;
    private boolean fWI = true;
    private b.a fWJ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void kO(boolean z) {
            PbActivity.this.kN(z);
            if (PbActivity.this.fVP.bmk() != null && z) {
                PbActivity.this.fVP.lo(false);
            }
            PbActivity.this.fVP.lq(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aPt != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aPt, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.aCO));
                        }
                    } else if (updateAttentionMessage.getData().Jr) {
                        if (PbActivity.this.bhc().zG() != null && PbActivity.this.bhc().zG().getGodUserData() != null) {
                            PbActivity.this.bhc().zG().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bgV() != null && PbActivity.this.fVM.getPbData().bgV().zG() != null) {
                            PbActivity.this.fVM.getPbData().bgV().zG().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cwg = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fVP.aln();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.st(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.aKv();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(e.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c brQ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            PbActivity.this.bit();
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == e.g.richText) {
                    if (PbActivity.this.bv(view)) {
                        return true;
                    }
                } else if (view.getId() == e.g.pb_floor_item_layout) {
                    if (view.getTag(e.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(e.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != e.g.pb_post_header_layout) {
                    if (PbActivity.this.fVP != null && PbActivity.this.fVP.bir() && view.getId() == e.g.pb_head_user_info_root) {
                        if (view.getTag(e.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").aA(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(e.g.tag_user_id)));
                        }
                        if (PbActivity.this.fVQ != null && PbActivity.this.fVQ.ekW != null) {
                            PbActivity.this.fVQ.ekW.onClick(view);
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
            if (PbActivity.this.fWc != null) {
                PbActivity.this.fVP.lt(PbActivity.this.fWc.ME());
            }
            PbActivity.this.fVP.blm();
            PbActivity.this.fVP.blX();
            return true;
        }
    });
    private CustomMessageListener fWK = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fWj) {
                PbActivity.this.fVP.aln();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fVM.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bhj().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fWi.e(PbActivity.this.fWh.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fWh.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.hU(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.biZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ao.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fWh.getResources().getString(e.j.mute_fail);
                    }
                    PbActivity.this.fWi.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fWL = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fWj) {
                PbActivity.this.fVP.aln();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fWi.e(PbActivity.this.fWh.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ao.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fWh.getResources().getString(e.j.un_mute_fail);
                }
                PbActivity.this.fWi.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fWM = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fWj) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fVP.aln();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hCH;
                if (aVar.error == 0 && dataRes != null) {
                    int l = com.baidu.adp.lib.g.b.l(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = l == 1;
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        sparseArray.put(e.g.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(e.g.tag_user_mute_msg, str);
                    }
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(e.g.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(e.g.tag_from)).intValue();
                if (intValue == 0) {
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.fVP.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fWN = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fVP.bln() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bit();
            }
        }
    };
    private CustomMessageListener dMg = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dLy = true;
                }
            }
        }
    };
    public a.b fJP = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.aBN();
            com.baidu.tbadk.core.data.al pageData = PbActivity.this.fVM.getPageData();
            int pageNum = PbActivity.this.fVP.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(e.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.yK()) {
                PbActivity.this.fVP.blX();
                PbActivity.this.ss(2);
                PbActivity.this.aBM();
                PbActivity.this.fVP.blH();
                if (com.baidu.adp.lib.util.j.kV()) {
                    PbActivity.this.fVM.sA(PbActivity.this.fVP.getPageNum());
                    if (PbActivity.this.fVt != null) {
                        PbActivity.this.fVt.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(e.j.pb_page_error);
            }
        }
    };
    public final View.OnClickListener dMI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Multi-variable search result rejected for r2v175, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v179, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v206, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v315, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            String name;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String str;
            int i;
            bg bgVar;
            String[] strArr;
            boolean q;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fVP.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fVM.kX(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fVP.blI();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkQ()) {
                        if (view == PbActivity.this.fVP.geM.bhV) {
                            if (PbActivity.this.fVP.ls(PbActivity.this.fVM.bjW())) {
                                PbActivity.this.aBM();
                                return;
                            }
                            PbActivity.this.fVw = false;
                            PbActivity.this.fVu = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.fVP.geM.bhV);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fVP.blF() && (PbActivity.this.fVP.geM.bmU() == null || (view != PbActivity.this.fVP.geM.bmU().bkP() && view != PbActivity.this.fVP.geM.bmU().bkN()))) {
                            if (view == PbActivity.this.fVP.bma()) {
                                if (PbActivity.this.fVM != null) {
                                    com.baidu.tbadk.browser.a.ad(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fVM.getPbData().bgV().zF().getLink());
                                }
                            } else if (view != PbActivity.this.fVP.geM.gjN && view.getId() != e.g.view_forum_name) {
                                if (view == PbActivity.this.fVP.geM.gjO) {
                                    if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null) {
                                        ArrayList<PostData> bgX = PbActivity.this.fVM.getPbData().bgX();
                                        if ((bgX == null || bgX.size() <= 0) && PbActivity.this.fVM.bjQ()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").aA("tid", PbActivity.this.fVM.bjP()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getForumId()));
                                        if (!PbActivity.this.fVP.bmp()) {
                                            PbActivity.this.fVP.blm();
                                        }
                                        PbActivity.this.biB();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != e.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkB()) {
                                        if ((PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkM()) && view.getId() != e.g.floor_owner_reply && view.getId() != e.g.reply_title) {
                                            if (PbActivity.this.fVP.geM.bmU() == null || (view != PbActivity.this.fVP.geM.bmU().getCancelView() && view != PbActivity.this.fVP.geM.bmU().bkL())) {
                                                if (view != PbActivity.this.fVP.geM.gjP && view.getId() != e.g.share_num_container) {
                                                    if (PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkJ()) {
                                                        if ((PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkS()) && view.getId() != e.g.pb_sort) {
                                                            if (PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkK()) {
                                                                if (PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkT()) {
                                                                    if (PbActivity.this.fVV == null || view != PbActivity.this.fVV.bkD()) {
                                                                        if (PbActivity.this.fVV == null || view != PbActivity.this.fVV.bkB()) {
                                                                            if (PbActivity.this.fVV == null || view != PbActivity.this.fVV.bkE()) {
                                                                                if (PbActivity.this.fVV == null || view != PbActivity.this.fVV.bkF()) {
                                                                                    if (PbActivity.this.fVV == null || view != PbActivity.this.fVV.bkH()) {
                                                                                        if (PbActivity.this.fVV == null || view != PbActivity.this.fVV.bkI()) {
                                                                                            if (PbActivity.this.fVV == null || view != PbActivity.this.fVV.bkG()) {
                                                                                                if (PbActivity.this.fVP.bmk() == view) {
                                                                                                    if (PbActivity.this.fVP.bmk().getIndicateStatus()) {
                                                                                                        com.baidu.tieba.pb.data.d pbData = PbActivity.this.fVM.getPbData();
                                                                                                        if (pbData != null && pbData.bgV() != null && pbData.bgV().zn() != null) {
                                                                                                            String yg = pbData.bgV().zn().yg();
                                                                                                            if (StringUtils.isNull(yg)) {
                                                                                                                yg = pbData.bgV().zn().getTaskId();
                                                                                                            }
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").aA(VideoPlayActivityConfig.OBJ_ID, yg));
                                                                                                        }
                                                                                                    } else {
                                                                                                        com.baidu.tieba.tbadkCore.d.a.cL("c10725", null);
                                                                                                    }
                                                                                                    PbActivity.this.biV();
                                                                                                } else if (PbActivity.this.fVP.blC() != view) {
                                                                                                    if (PbActivity.this.fVV == null || view != PbActivity.this.fVV.bkC()) {
                                                                                                        if (PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkR()) {
                                                                                                            if (PbActivity.this.fVP.geM.bmU() != null && view == PbActivity.this.fVP.geM.bmU().bkO()) {
                                                                                                                if (com.baidu.adp.lib.util.j.kV()) {
                                                                                                                    SparseArray<Object> c2 = PbActivity.this.fVP.c(PbActivity.this.fVM.getPbData(), PbActivity.this.fVM.bjQ(), 1);
                                                                                                                    if (c2 != null) {
                                                                                                                        if (StringUtils.isNull((String) c2.get(e.g.tag_del_multi_forum))) {
                                                                                                                            PbActivity.this.fVP.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                                        } else {
                                                                                                                            PbActivity.this.fVP.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(e.g.tag_del_multi_forum));
                                                                                                                        }
                                                                                                                    }
                                                                                                                    PbActivity.this.fVP.geM.dismissPopMenu();
                                                                                                                } else {
                                                                                                                    PbActivity.this.showToast(e.j.network_not_available);
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (view.getId() != e.g.sub_pb_more && view.getId() != e.g.sub_pb_item && view.getId() != e.g.pb_floor_reply_more && view.getId() != e.g.new_sub_pb_list_richText) {
                                                                                                                if (view != PbActivity.this.fVP.bik()) {
                                                                                                                    if (view == PbActivity.this.fVP.geM.bmV()) {
                                                                                                                        PbActivity.this.fVP.blP();
                                                                                                                    } else {
                                                                                                                        int id = view.getId();
                                                                                                                        if (id == e.g.pb_u9_text_view) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin() && (bgVar = (bg) view.getTag()) != null && !StringUtils.isNull(bgVar.Bu())) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                ay.Ef().c(PbActivity.this.getPageContext(), new String[]{bgVar.Bu()});
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.replybtn || id == e.g.cover_reply_content || id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right || id == e.g.image_more_tip) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11740"));
                                                                                                                                PostData postData = null;
                                                                                                                                if (view != null && view.getTag() != null) {
                                                                                                                                    postData = (PostData) ((SparseArray) view.getTag()).get(e.g.tag_load_sub_data);
                                                                                                                                    if (PbActivity.this.fVV == null) {
                                                                                                                                        PbActivity.this.fVV = new y(PbActivity.this.getPageContext(), PbActivity.this.dMI);
                                                                                                                                        PbActivity.this.fVP.bH(PbActivity.this.fVV.getView());
                                                                                                                                        PbActivity.this.fVV.lb(PbActivity.this.mIsLogin);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fVV.showDialog();
                                                                                                                                    if (id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right) {
                                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").aA("tid", PbActivity.this.fVM.gaS));
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray = new SparseArray();
                                                                                                                                    sparseArray.put(e.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(e.g.tag_clip_board));
                                                                                                                                    sparseArray.put(e.g.tag_is_subpb, false);
                                                                                                                                    PbActivity.this.fVV.bkB().setTag(sparseArray);
                                                                                                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                                                                    boolean booleanValue = ((Boolean) sparseArray2.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                                                                    boolean booleanValue2 = ((Boolean) sparseArray2.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                                                    boolean booleanValue3 = ((Boolean) sparseArray2.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                                                                    if (!(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                        z = false;
                                                                                                                                    } else {
                                                                                                                                        z = ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                    }
                                                                                                                                    String str2 = null;
                                                                                                                                    if (sparseArray2.get(e.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                        str2 = (String) sparseArray2.get(e.g.tag_forbid_user_post_id);
                                                                                                                                    }
                                                                                                                                    if (booleanValue) {
                                                                                                                                        SparseArray sparseArray3 = new SparseArray();
                                                                                                                                        sparseArray3.put(e.g.tag_should_manage_visible, true);
                                                                                                                                        sparseArray3.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_name, sparseArray2.get(e.g.tag_forbid_user_name));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_name_show, sparseArray2.get(e.g.tag_forbid_user_name_show));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_portrait, sparseArray2.get(e.g.tag_forbid_user_portrait));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_post_id, str2);
                                                                                                                                        if (booleanValue2) {
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_visible, true);
                                                                                                                                            sparseArray3.put(e.g.tag_is_mem, sparseArray2.get(e.g.tag_is_mem));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_userid, sparseArray2.get(e.g.tag_user_mute_mute_userid));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_username, sparseArray2.get(e.g.tag_user_mute_mute_username));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_nameshow, sparseArray2.get(e.g.tag_user_mute_mute_nameshow));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_post_id, sparseArray2.get(e.g.tag_user_mute_post_id));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_thread_id, sparseArray2.get(e.g.tag_user_mute_thread_id));
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        }
                                                                                                                                        if (booleanValue3) {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, true);
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                            PbActivity.this.fVV.bkE().setVisibility(0);
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, false);
                                                                                                                                            PbActivity.this.fVV.bkE().setVisibility(8);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fVV.bkC().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fVV.bkE().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fVV.bkC().setText(e.j.bar_manager);
                                                                                                                                        PbActivity.this.fVV.bkC().setVisibility(0);
                                                                                                                                    } else if (!booleanValue3) {
                                                                                                                                        PbActivity.this.fVV.bkC().setVisibility(8);
                                                                                                                                        PbActivity.this.fVV.bkE().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        SparseArray sparseArray4 = new SparseArray();
                                                                                                                                        sparseArray4.put(e.g.tag_should_manage_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_should_delete_visible, true);
                                                                                                                                        sparseArray4.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                        PbActivity.this.fVV.bkC().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fVV.bkE().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fVV.bkC().setText(e.j.delete);
                                                                                                                                        PbActivity.this.fVV.bkE().setVisibility(0);
                                                                                                                                        if (PbActivity.this.fVM.getPbData().bhh() != 1002 || z) {
                                                                                                                                            PbActivity.this.fVV.bkE().setText(e.j.delete);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fVV.bkE().setText(e.j.report_text);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fVV.bkC().setVisibility(8);
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                                                                    if (!(sparseArray5.get(e.g.tag_user_mute_visible) instanceof Boolean)) {
                                                                                                                                        z2 = false;
                                                                                                                                    } else {
                                                                                                                                        z2 = ((Boolean) sparseArray5.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                                                    }
                                                                                                                                    if (!((Boolean) sparseArray5.get(e.g.tag_should_manage_visible)).booleanValue() && z2) {
                                                                                                                                        SparseArray sparseArray6 = new SparseArray();
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_visible, true);
                                                                                                                                        sparseArray6.put(e.g.tag_is_mem, sparseArray5.get(e.g.tag_is_mem));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_userid, sparseArray5.get(e.g.tag_user_mute_mute_userid));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_username, sparseArray5.get(e.g.tag_user_mute_mute_username));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_nameshow, sparseArray5.get(e.g.tag_user_mute_mute_nameshow));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_post_id, sparseArray5.get(e.g.tag_user_mute_post_id));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_thread_id, sparseArray5.get(e.g.tag_user_mute_thread_id));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_is_self, sparseArray5.get(e.g.tag_del_post_is_self));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_type, sparseArray5.get(e.g.tag_del_post_type));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_id, sparseArray5.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray6.put(e.g.tag_manage_user_identity, sparseArray5.get(e.g.tag_manage_user_identity));
                                                                                                                                        PbActivity.this.fVV.bkD().setTag(sparseArray6);
                                                                                                                                        PbActivity.this.fVV.bkD().setVisibility(0);
                                                                                                                                        PbActivity.this.fVV.bkC().setVisibility(8);
                                                                                                                                        PbActivity.this.fVV.bkD().setText(e.j.mute_option);
                                                                                                                                    } else {
                                                                                                                                        if (!(sparseArray5.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                            z3 = false;
                                                                                                                                        } else {
                                                                                                                                            z3 = ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                        }
                                                                                                                                        String str3 = null;
                                                                                                                                        if (sparseArray5.get(e.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                            str3 = (String) sparseArray5.get(e.g.tag_forbid_user_post_id);
                                                                                                                                        }
                                                                                                                                        boolean kJ = PbActivity.this.kJ(z3) & PbActivity.this.isLogin();
                                                                                                                                        PbActivity.this.fWW = (PostData) sparseArray5.get(e.g.tag_clip_board);
                                                                                                                                        if (aq.k(PbActivity.this.fWW) ? false : kJ) {
                                                                                                                                            PbActivity.this.fVV.bkD().setVisibility(0);
                                                                                                                                            PbActivity.this.fVV.bkD().setTag(str3);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fVV.bkD().setVisibility(8);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                                                                                                                    long j = 0;
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                        z4 = false;
                                                                                                                                    } else {
                                                                                                                                        z4 = ((Boolean) sparseArray7.get(e.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                                    }
                                                                                                                                    if (sparseArray7.get(e.g.tag_chudian_template_id) instanceof Long) {
                                                                                                                                        j = ((Long) sparseArray7.get(e.g.tag_chudian_template_id)).longValue();
                                                                                                                                    }
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_chudian_monitor_id) instanceof String)) {
                                                                                                                                        str = "";
                                                                                                                                    } else {
                                                                                                                                        str = (String) sparseArray7.get(e.g.tag_chudian_monitor_id);
                                                                                                                                    }
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_chudian_hide_day) instanceof Integer)) {
                                                                                                                                        i = 0;
                                                                                                                                    } else {
                                                                                                                                        i = ((Integer) sparseArray7.get(e.g.tag_chudian_hide_day)).intValue();
                                                                                                                                    }
                                                                                                                                    if (z4) {
                                                                                                                                        PbActivity.this.fVV.bkG().setVisibility(0);
                                                                                                                                        PbActivity.this.fVV.bkG().setTag(e.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                        PbActivity.this.fVV.bkG().setTag(e.g.tag_chudian_monitor_id, str);
                                                                                                                                        PbActivity.this.fVV.bkG().setTag(e.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fVV.bkG().setVisibility(8);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                boolean z5 = false;
                                                                                                                                if (PbActivity.this.fVM.getPbData().wq()) {
                                                                                                                                    String wp = PbActivity.this.fVM.getPbData().wp();
                                                                                                                                    if (postData != null && !com.baidu.adp.lib.util.k.isEmpty(wp) && wp.equals(postData.getId())) {
                                                                                                                                        z5 = true;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (z5) {
                                                                                                                                    PbActivity.this.fVV.bkB().setText(e.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fVV.bkB().setText(e.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fVV.bkI().setVisibility(8);
                                                                                                                                PbActivity.this.fVV.bkH().setVisibility(8);
                                                                                                                                if (postData != null) {
                                                                                                                                    if (postData.bEl() == null || postData.bEl().toString().length() <= 0) {
                                                                                                                                        PbActivity.this.fVV.bkF().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fVV.bkF().setVisibility(0);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fWW = postData;
                                                                                                                                }
                                                                                                                                PbActivity.this.fVV.refreshUI();
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_act_btn) {
                                                                                                                            if (PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bgV() != null && PbActivity.this.fVM.getPbData().bgV().getActUrl() != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ad(PbActivity.this.getActivity(), PbActivity.this.fVM.getPbData().bgV().getActUrl());
                                                                                                                                if (PbActivity.this.fVM.getPbData().bgV().Ak() != 1) {
                                                                                                                                    if (PbActivity.this.fVM.getPbData().bgV().Ak() == 2) {
                                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.lottery_tail) {
                                                                                                                            if (view.getTag(e.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                                String str4 = (String) view.getTag(e.g.tag_pb_lottery_tail_link);
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getPbData().getForumId()).aA("tid", PbActivity.this.fVM.getPbData().getThreadId()).aA("lotterytail", StringUtils.string(str4, BaseRequestAction.SPLITE, TbadkCoreApplication.getCurrentAccount())));
                                                                                                                                if (PbActivity.this.fVM.getPbData().getThreadId().equals(str4)) {
                                                                                                                                    PbActivity.this.fVP.setSelection(0);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_item_tail_content) {
                                                                                                                            if (ba.bJ(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                                String string = TbadkCoreApplication.getInst().getString(e.j.tail_web_view_title);
                                                                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                                if (!StringUtils.isNull(string2)) {
                                                                                                                                    TiebaStatic.log("c10056");
                                                                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                                }
                                                                                                                                PbActivity.this.fVP.blm();
                                                                                                                            }
                                                                                                                        } else if (id == e.g.join_vote_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ad(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                if (PbActivity.this.biy() == 1 && PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getPbData().getForumId()).aA("tid", PbActivity.this.fVM.getPbData().getThreadId()).aA("uid", currentAccount));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.look_all_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                com.baidu.tbadk.browser.a.ad(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                if (PbActivity.this.biy() == 1 && PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getPbData().getForumId()).aA("tid", PbActivity.this.fVM.getPbData().getThreadId()).aA("uid", currentAccount2));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.manga_prev_btn) {
                                                                                                                            PbActivity.this.biQ();
                                                                                                                        } else if (id == e.g.manga_next_btn) {
                                                                                                                            PbActivity.this.biR();
                                                                                                                        } else if (id == e.g.yule_head_img_img) {
                                                                                                                            if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bhp() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fVM.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").aA(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                                ay.Ef().c(PbActivity.this.getPageContext(), new String[]{pbData2.bhp().bhy()});
                                                                                                                            }
                                                                                                                        } else if (id == e.g.yule_head_img_all_rank) {
                                                                                                                            if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bhp() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fVM.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").aA(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                                ay.Ef().c(PbActivity.this.getPageContext(), new String[]{pbData3.bhp().bhy()});
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.fVP.geM.bmU() != null && view == PbActivity.this.fVP.geM.bmU().bkU()) {
                                                                                                                            if (PbActivity.this.fVM == null || PbActivity.this.fVM.getPbData() == null || PbActivity.this.fVM.getPbData().bgV() == null) {
                                                                                                                                PbActivity.this.fVP.geM.dismissPopMenu();
                                                                                                                                return;
                                                                                                                            } else if (!com.baidu.adp.lib.util.l.ll()) {
                                                                                                                                PbActivity.this.showToast(e.j.neterror);
                                                                                                                                return;
                                                                                                                            } else {
                                                                                                                                int i2 = 1;
                                                                                                                                if (PbActivity.this.fVM.getPbData().bgV().zo() == 0) {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fVM.bjP(), 25028)));
                                                                                                                                } else {
                                                                                                                                    BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(e.j.haved_fans_called)).BN();
                                                                                                                                    i2 = 2;
                                                                                                                                }
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").x("obj_locate", PbActivity.this.al(PbActivity.this.fVM.getPbData().bgV())).aA("tid", PbActivity.this.fVM.getPbData().bgV().getTid()).x("obj_type", i2));
                                                                                                                            }
                                                                                                                        } else if (id == e.g.tv_pb_reply_more) {
                                                                                                                            if (PbActivity.this.fWp >= 0) {
                                                                                                                                if (PbActivity.this.fVM != null) {
                                                                                                                                    PbActivity.this.fVM.bkv();
                                                                                                                                }
                                                                                                                                if (PbActivity.this.fVP.blD() != null) {
                                                                                                                                    PbActivity.this.fVP.blD().a(PbActivity.this.fVM.getPbData(), false);
                                                                                                                                }
                                                                                                                                PbActivity.this.fVP.getListView().setSelection(PbActivity.this.fVM.bky());
                                                                                                                                PbActivity.this.fWp = 0;
                                                                                                                                if (PbActivity.this.fVM != null) {
                                                                                                                                    PbActivity.this.fVM.by(0, 0);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.single_bar_tips) {
                                                                                                                            PbActivity.this.fVP.bmt();
                                                                                                                        } else if (id == e.g.pb_post_recommend_live_layout) {
                                                                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                                TiebaStatic.log("c12640");
                                                                                                                            }
                                                                                                                        } else if (id == e.g.thread_info_commont_container) {
                                                                                                                            PbActivity.this.fVP.blr();
                                                                                                                        } else if (id == e.g.new_sub_pb_list_richText) {
                                                                                                                            SparseArray sparseArray8 = null;
                                                                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                                                                sparseArray8 = (SparseArray) view.getTag();
                                                                                                                            }
                                                                                                                            if (sparseArray8 != null) {
                                                                                                                                PbActivity.this.c(sparseArray8);
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.fVM.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.fVM.bjP(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fVM.getPbData().bgV().Ab())));
                                                                                                                }
                                                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                if (PbActivity.this.fVM.getPbData() != null) {
                                                                                                                    PbActivity.this.fVP.blX();
                                                                                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                    PostData postData2 = (PostData) sparseArray9.get(e.g.tag_load_sub_data);
                                                                                                                    View view2 = (View) sparseArray9.get(e.g.tag_load_sub_view);
                                                                                                                    if (postData2 != null && view2 != null) {
                                                                                                                        if (postData2.bEv() == 1) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                                                        }
                                                                                                                        String bjP = PbActivity.this.fVM.bjP();
                                                                                                                        String id2 = postData2.getId();
                                                                                                                        int i3 = 0;
                                                                                                                        if (PbActivity.this.fVM.getPbData() != null) {
                                                                                                                            i3 = PbActivity.this.fVM.getPbData().bhh();
                                                                                                                        }
                                                                                                                        PbActivity.this.aBM();
                                                                                                                        if (view.getId() == e.g.replybtn) {
                                                                                                                            c sW = PbActivity.this.sW(id2);
                                                                                                                            if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && sW != null) {
                                                                                                                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bjP, id2, "pb", true, null, true, null, i3, postData2.bnJ(), PbActivity.this.fVM.getPbData().yE(), false, postData2.zG().getIconInfo()).addBigImageData(sW.fXG, sW.fXH, sW.fXI, sW.index);
                                                                                                                                addBigImageData.setKeyPageStartFrom(PbActivity.this.fVM.bku());
                                                                                                                                addBigImageData.setFromFrsForumId(PbActivity.this.fVM.getFromForumId());
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            c sW2 = PbActivity.this.sW(id2);
                                                                                                                            if (postData2 != null && PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && sW2 != null) {
                                                                                                                                SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bjP, id2, "pb", true, null, false, null, i3, postData2.bnJ(), PbActivity.this.fVM.getPbData().yE(), false, postData2.zG().getIconInfo()).addBigImageData(sW2.fXG, sW2.fXH, sW2.fXI, sW2.index);
                                                                                                                                addBigImageData2.setKeyPageStartFrom(PbActivity.this.fVM.bku());
                                                                                                                                addBigImageData2.setFromFrsForumId(PbActivity.this.fVM.getFromForumId());
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
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 3).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getPbData().getForumId()));
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                                                                                            PbActivity.this.fVP.blX();
                                                                                                            SparseArray<Object> c3 = PbActivity.this.fVP.c(PbActivity.this.fVM.getPbData(), PbActivity.this.fVM.bjQ(), 1);
                                                                                                            if (c3 != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fVM.getPbData().bgT().getId(), PbActivity.this.fVM.getPbData().bgT().getName(), PbActivity.this.fVM.getPbData().bgV().getId(), String.valueOf(PbActivity.this.fVM.getPbData().getUserData().getUserId()), (String) c3.get(e.g.tag_forbid_user_name), (String) c3.get(e.g.tag_forbid_user_name_show), (String) c3.get(e.g.tag_forbid_user_post_id), (String) c3.get(e.g.tag_forbid_user_portrait))));
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(e.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (!com.baidu.adp.lib.util.j.kV()) {
                                                                                                        PbActivity.this.showToast(e.j.network_not_available);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        SparseArray<Object> sparseArray10 = (SparseArray) view.getTag();
                                                                                                        if (sparseArray10 != null) {
                                                                                                            boolean booleanValue4 = ((Boolean) sparseArray10.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                                            boolean booleanValue5 = ((Boolean) sparseArray10.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                                            boolean booleanValue6 = ((Boolean) sparseArray10.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                            if (booleanValue4) {
                                                                                                                if (booleanValue6) {
                                                                                                                    sparseArray10.put(e.g.tag_from, 1);
                                                                                                                    sparseArray10.put(e.g.tag_check_mute_from, 2);
                                                                                                                    PbActivity.this.b(sparseArray10);
                                                                                                                } else {
                                                                                                                    sparseArray10.put(e.g.tag_check_mute_from, 2);
                                                                                                                    PbActivity.this.fVP.bF(view);
                                                                                                                }
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.fVP.a(((Integer) sparseArray10.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray10.get(e.g.tag_del_post_id), ((Integer) sparseArray10.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getPbData().getForumId()));
                                                                                                    return;
                                                                                                } else {
                                                                                                    PbActivity.this.bim();
                                                                                                }
                                                                                            } else {
                                                                                                long j2 = -1;
                                                                                                String str5 = "";
                                                                                                int i4 = 0;
                                                                                                if (view.getTag(e.g.tag_chudian_template_id) instanceof Long) {
                                                                                                    j2 = ((Long) view.getTag(e.g.tag_chudian_template_id)).longValue();
                                                                                                }
                                                                                                if (view.getTag(e.g.tag_chudian_monitor_id) instanceof String) {
                                                                                                    str5 = (String) view.getTag(e.g.tag_chudian_monitor_id);
                                                                                                }
                                                                                                if (view.getTag(e.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                                    i4 = ((Integer) view.getTag(e.g.tag_chudian_hide_day)).intValue();
                                                                                                }
                                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fVM.getPbData();
                                                                                                String str6 = null;
                                                                                                String str7 = null;
                                                                                                String str8 = null;
                                                                                                if (pbData4 != null && pbData4.bgT() != null) {
                                                                                                    str6 = pbData4.bgT().getId();
                                                                                                    str7 = pbData4.bgT().getName();
                                                                                                    str8 = pbData4.getThreadId();
                                                                                                }
                                                                                                com.baidu.tieba.pb.a.a(j2, str5, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str6, str7, str8);
                                                                                                PbActivity.this.a(j2, str5, str6, str7, str8, i4);
                                                                                            }
                                                                                        } else if (PbActivity.this.fWm != null && !TextUtils.isEmpty(PbActivity.this.fWn)) {
                                                                                            if (PbActivity.this.bzi == null) {
                                                                                                PbActivity.this.bzi = new com.baidu.tbadk.core.util.b.a();
                                                                                            }
                                                                                            PbActivity.this.bzi.Et();
                                                                                            PbActivity.this.bzi.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                            if (!PbActivity.this.bzi.A(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                if (PbActivity.this.fWl == null) {
                                                                                                    PbActivity.this.fWl = new av(PbActivity.this.getPageContext());
                                                                                                }
                                                                                                PbActivity.this.fWl.i(PbActivity.this.fWn, PbActivity.this.fWm.os());
                                                                                                PbActivity.this.fWm = null;
                                                                                                PbActivity.this.fWn = null;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.fWm != null && !TextUtils.isEmpty(PbActivity.this.fWn)) {
                                                                                        if (PbActivity.this.fWo == null) {
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fWn));
                                                                                        } else {
                                                                                            d.a aVar = new d.a();
                                                                                            aVar.url = PbActivity.this.fWn;
                                                                                            aVar.pkgId = PbActivity.this.fWo.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fWo.memeInfo.pck_id;
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                                        }
                                                                                        PbActivity.this.fWm = null;
                                                                                        PbActivity.this.fWn = null;
                                                                                    }
                                                                                } else if (PbActivity.this.fWW != null) {
                                                                                    PbActivity.this.fWW.cZ(PbActivity.this.getPageContext().getPageActivity());
                                                                                    PbActivity.this.fWW = null;
                                                                                }
                                                                            } else {
                                                                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                                                                if (sparseArray11 != null) {
                                                                                    if ((sparseArray11.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_id) instanceof String) && (sparseArray11.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                        PbActivity.this.fVP.a(((Integer) sparseArray11.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(e.g.tag_del_post_id), ((Integer) sparseArray11.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").x("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bx(view);
                                                                                if (PbActivity.this.fVM.getPbData().bgV() != null && PbActivity.this.fVM.getPbData().bgV().zG() != null && PbActivity.this.fVM.getPbData().bgV().zG().getUserId() != null && PbActivity.this.fVO != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").aA("tid", PbActivity.this.fVM.gaS).x("obj_locate", 2).aA(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fVM.getPbData().bgV().zG().getUserId()).x("obj_type", PbActivity.this.fVO.wq() ? 0 : 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fVM.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (!com.baidu.adp.lib.util.j.kV()) {
                                                                        PbActivity.this.showToast(e.j.network_not_available);
                                                                        return;
                                                                    } else {
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13079"));
                                                                            PbActivity.this.sT((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").x("obj_locate", 4));
                                                                            SparseArray<Object> sparseArray12 = (SparseArray) tag;
                                                                            if ((sparseArray12.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray12.get(e.g.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray12.put(e.g.tag_from, 0);
                                                                                sparseArray12.put(e.g.tag_check_mute_from, 2);
                                                                                PbActivity.this.b(sparseArray12);
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    UtilHelper.showSkinChangeAnimation(PbActivity.this.getActivity());
                                                                    if (skinType == 1) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").x("obj_type", 0).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").x("obj_type", 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.fVP.geM.bmT();
                                                                }
                                                            } else if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bgV() != null) {
                                                                PbActivity.this.fVP.geM.dismissPopMenu();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                                PbActivity.this.sT(PbActivity.this.fVM.getPbData().bgV().zX());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fVP.blX();
                                                            if (com.baidu.adp.lib.util.j.kV()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Integer.valueOf(PbActivity.this.fVM.bkd()));
                                                                    return;
                                                                }
                                                                PbActivity.this.ss(2);
                                                                PbActivity.this.aBM();
                                                                PbActivity.this.fVP.blH();
                                                                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(PbActivity.this.getPageContext().getPageActivity());
                                                                if (PbActivity.this.fVM.getPbData().fTm == null || PbActivity.this.fVM.getPbData().fTm.size() <= 0) {
                                                                    strArr = new String[]{PbActivity.this.getResources().getString(e.j.sort_type_new), PbActivity.this.getResources().getString(e.j.sort_type_old)};
                                                                } else {
                                                                    String[] strArr2 = new String[PbActivity.this.fVM.getPbData().fTm.size()];
                                                                    int i5 = 0;
                                                                    while (true) {
                                                                        int i6 = i5;
                                                                        if (i6 >= PbActivity.this.fVM.getPbData().fTm.size()) {
                                                                            break;
                                                                        }
                                                                        strArr2[i6] = PbActivity.this.fVM.getPbData().fTm.get(i6).sort_name + PbActivity.this.getResources().getString(e.j.sort_static);
                                                                        i5 = i6 + 1;
                                                                    }
                                                                    strArr = strArr2;
                                                                }
                                                                bVar.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                                                                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i7, View view3) {
                                                                        int i8 = 2;
                                                                        if (PbActivity.this.fVM.acb() == 1 && i7 == 1) {
                                                                            i8 = 0;
                                                                        } else if (PbActivity.this.fVM.acb() == 2 && i7 == 0) {
                                                                            i8 = 1;
                                                                        } else if (PbActivity.this.fVM.acb() != 3 || i7 == 2) {
                                                                            i8 = (i7 != 2 || PbActivity.this.fVM.acb() == 3) ? 0 : 3;
                                                                        }
                                                                        TiebaStatic.log("c12097");
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != e.g.pb_sort ? 1 : 0).x("obj_type", i8));
                                                                        if (PbActivity.this.fVM.getPbData().fTm != null && PbActivity.this.fVM.getPbData().fTm.size() > i7) {
                                                                            i7 = PbActivity.this.fVM.getPbData().fTm.get(i7).sort_type.intValue();
                                                                        }
                                                                        boolean sF = PbActivity.this.fVM.sF(i7);
                                                                        view.setTag(Integer.valueOf(PbActivity.this.fVM.bkd()));
                                                                        if (sF) {
                                                                            PbActivity.this.mIsLoading = true;
                                                                            PbActivity.this.fVP.lj(true);
                                                                        }
                                                                        bVar2.dismiss();
                                                                    }
                                                                });
                                                                bVar.d(PbActivity.this.getPageContext()).BI();
                                                            } else {
                                                                PbActivity.this.showToast(e.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fVP.blX();
                                                        if (PbActivity.this.bhZ().getPbData().fTn != 2) {
                                                            if (PbActivity.this.fVM.getPageData() != null) {
                                                                PbActivity.this.fVP.a(PbActivity.this.fVM.getPageData(), PbActivity.this.fJP);
                                                            }
                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            PbActivity.this.showToast(e.j.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (ax.jJ() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fVM != null) {
                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12386");
                                                        amVar.aA("tid", PbActivity.this.fVM.bjP());
                                                        amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                                                        amVar.aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getForumId());
                                                        amVar.x("obj_locate", 6);
                                                        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        TiebaStatic.log(amVar);
                                                    }
                                                    if (com.baidu.adp.lib.util.l.ll()) {
                                                        if (PbActivity.this.fVM.getPbData() != null) {
                                                            ArrayList<PostData> bgX2 = PbActivity.this.fVM.getPbData().bgX();
                                                            if ((bgX2 != null && bgX2.size() > 0) || !PbActivity.this.fVM.bjQ()) {
                                                                PbActivity.this.fVP.blX();
                                                                PbActivity.this.aBM();
                                                                PbActivity.this.ss(2);
                                                                if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bhp() != null && !StringUtils.isNull(PbActivity.this.fVM.getPbData().bhp().ys(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                                if (ax.jJ()) {
                                                                    PbActivity.this.st(2);
                                                                } else {
                                                                    PbActivity.this.fVP.showLoadingDialog();
                                                                    PbActivity.this.fVM.bkp().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                }
                                                            } else {
                                                                com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        PbActivity.this.showToast(e.j.neterror);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.fVP.geM.dismissPopMenu();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                            PbActivity.this.fVP.blX();
                                            if (PbActivity.this.fVP.geM.bmU() != null && view == PbActivity.this.fVP.geM.bmU().bkM() && !PbActivity.this.fVP.bmp()) {
                                                PbActivity.this.fVP.blm();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.aBM();
                                                PbActivity.this.fVP.blH();
                                                if (view.getId() == e.g.floor_owner_reply) {
                                                    q = PbActivity.this.fVM.q(true, PbActivity.this.biO());
                                                } else {
                                                    q = view.getId() == e.g.reply_title ? PbActivity.this.fVM.q(false, PbActivity.this.biO()) : PbActivity.this.fVM.sX(PbActivity.this.biO());
                                                }
                                                view.setTag(Boolean.valueOf(q));
                                                if (q) {
                                                    PbActivity.this.fVP.kS(true);
                                                    PbActivity.this.fVP.aTj();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fVP.lj(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.ss(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(e.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.kV()) {
                                        PbActivity.this.fVP.blX();
                                        if (PbActivity.this.sr(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fVM.sG(PbActivity.this.fVP.blM()) != null) {
                                            PbActivity.this.biI();
                                            if (PbActivity.this.fVM.getPbData().bgV() != null && PbActivity.this.fVM.getPbData().bgV().zG() != null && PbActivity.this.fVM.getPbData().bgV().zG().getUserId() != null && PbActivity.this.fVO != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").aA("tid", PbActivity.this.fVM.gaS).x("obj_locate", 1).aA(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fVM.getPbData().bgV().zG().getUserId()).x("obj_type", PbActivity.this.fVO.wq() ? 0 : 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fVM.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(e.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.kV()) {
                                    PbActivity.this.fVP.kS(true);
                                    PbActivity.this.fVP.blm();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fVP.aTj();
                                        PbActivity.this.aBM();
                                        PbActivity.this.fVP.blH();
                                        PbActivity.this.fVM.sX(PbActivity.this.biO());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.ss(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(e.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bgV() != null && PbActivity.this.fVM.getPbData().bgV().Au() && PbActivity.this.fVM.getPbData().bgV().zY() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.fVM.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fVM.bhQ()) && PbActivity.this.fVM.getAppealInfo() != null) {
                                        name = PbActivity.this.fVM.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fVM.getPbData().bgT().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bhQ = PbActivity.this.fVM.bhQ();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fVM.bjR() && bhQ != null && bhQ.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.kV()) {
                            if (PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bhh() == 1 && !PbActivity.this.cYy.bEU()) {
                                PbActivity.this.fVP.blX();
                                int i7 = 0;
                                if (PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkN()) {
                                    if (PbActivity.this.fVP.geM.bmU() == null || view != PbActivity.this.fVP.geM.bmU().bkP()) {
                                        if (view == PbActivity.this.fVP.blF()) {
                                            i7 = 2;
                                        }
                                    } else if (PbActivity.this.fVM.getPbData().bgV().zC() == 1) {
                                        i7 = 3;
                                    } else {
                                        i7 = 6;
                                    }
                                } else if (PbActivity.this.fVM.getPbData().bgV().zB() == 1) {
                                    i7 = 5;
                                } else {
                                    i7 = 4;
                                }
                                ForumData bgT = PbActivity.this.fVM.getPbData().bgT();
                                String name2 = bgT.getName();
                                String id3 = bgT.getId();
                                String id4 = PbActivity.this.fVM.getPbData().bgV().getId();
                                PbActivity.this.fVP.blE();
                                PbActivity.this.cYy.a(id3, name2, id4, i7, PbActivity.this.fVP.blG());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(e.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.kV()) {
                        PbActivity.this.fVP.blX();
                        PbActivity.this.aBM();
                        PbActivity.this.fVP.blH();
                        PbActivity.this.fVP.showLoadingDialog();
                        if (PbActivity.this.fVP.blu() != null) {
                            PbActivity.this.fVP.blu().setVisibility(8);
                        }
                        PbActivity.this.fVM.sA(1);
                        if (PbActivity.this.fVt != null) {
                            PbActivity.this.fVt.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(e.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(e.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == e.g.reply_god_title_group) {
                        String biv = PbActivity.this.biv();
                        if (!TextUtils.isEmpty(biv)) {
                            ay.Ef().c(PbActivity.this.getPageContext(), new String[]{biv});
                        }
                    }
                } else if (PbActivity.this.fVD) {
                    PbActivity.this.fVD = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(e.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData3 = (PostData) obj;
                            if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.biq().blk() != null && postData3.zG() != null && postData3.bEj() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.biq().bll() != null) {
                                    PbActivity.this.biq().bll().bjC();
                                }
                                com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                jVar.a(PbActivity.this.fVM.getPbData().bgT());
                                jVar.aa(PbActivity.this.fVM.getPbData().bgV());
                                jVar.e(postData3);
                                PbActivity.this.biq().blk().d(jVar);
                                PbActivity.this.biq().blk().setPostId(postData3.getId());
                                PbActivity.this.a(view, postData3.zG().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fWc != null) {
                                    PbActivity.this.fVP.lt(PbActivity.this.fWc.ME());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d bai = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.w wVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null) {
                    amVar.aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getPbData().getForumId());
                }
                if (PbActivity.this.fVM != null) {
                    amVar.aA("tid", PbActivity.this.fVM.bjP());
                }
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.aBM();
            PbActivity.this.fVP.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.ao.PD() && PbActivity.this.bhZ() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bhZ().ta(postWriteCallBackData.getPostId());
                    PbActivity.this.fWp = PbActivity.this.fVP.blp();
                    if (PbActivity.this.fVM != null) {
                        PbActivity.this.fVM.by(PbActivity.this.fWp, PbActivity.this.fVP.blq());
                    }
                }
                PbActivity.this.fVP.blX();
                PbActivity.this.fVU.bmx();
                if (PbActivity.this.fWc != null) {
                    PbActivity.this.fVP.lt(PbActivity.this.fWc.ME());
                }
                PbActivity.this.fVP.blj();
                PbActivity.this.fVP.lv(true);
                PbActivity.this.fVM.bkf();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fVM.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fVM.getPbData();
                            if (pbData != null && pbData.bgV() != null && pbData.bgV().zG() != null && (userId = pbData.bgV().zG().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.ao.PD() && PbActivity.this.fVM.bjY()) {
                                PbActivity.this.fVP.blH();
                            }
                        } else if (!com.baidu.tbadk.p.ao.PD() && PbActivity.this.fVM.bjY()) {
                            PbActivity.this.fVP.blH();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fVP.n(PbActivity.this.fVM.getPbData());
                    }
                    if (PbActivity.this.fVM.bjU()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").aA("tid", PbActivity.this.fVM.bjP()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fWc.MK() || PbActivity.this.fWc.ML()) {
                    PbActivity.this.fWc.a(false, postWriteCallBackData);
                }
                PbActivity.this.fVU.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.fhU != null) {
                    PbActivity.this.fhU.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (wVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fWO = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.w wVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null) {
                    amVar.aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getPbData().getForumId());
                }
                if (PbActivity.this.fVM != null) {
                    amVar.aA("tid", PbActivity.this.fVM.bjP());
                }
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.fVU != null) {
                    PbActivity.this.fVU.bmw();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.fhU != null) {
                    PbActivity.this.fhU.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.fVU != null) {
                if (PbActivity.this.fVP != null && PbActivity.this.fVP.bll() != null && PbActivity.this.fVP.bll().bjH() != null && PbActivity.this.fVP.bll().bjH().ML()) {
                    PbActivity.this.fVP.bll().bjH().a(postWriteCallBackData);
                }
                PbActivity.this.fVU.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fWP = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g fI;
            if (!z || dVar == null || dVar.bhf() != null || com.baidu.tbadk.core.util.v.H(dVar.bgX()) >= 1) {
                PbActivity.this.fyX = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fVP.blJ();
                if (dVar == null || !dVar.bhb()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fVP.getView());
                }
                PbActivity.this.fVP.aTi();
                if (PbActivity.this.isFullScreen || PbActivity.this.fVP.bmp()) {
                    PbActivity.this.fVP.bmg();
                } else if (!PbActivity.this.fVP.bmd()) {
                    PbActivity.this.fVP.lv(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fVW = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.fVP.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.fVP.anp();
                    if (dVar.bgV() != null && dVar.bgV().AB() != null) {
                        PbActivity.this.a(dVar.bgV().AB());
                    }
                    PbActivity.this.bin();
                    if (PbActivity.this.fWc != null) {
                        PbActivity.this.fVP.lt(PbActivity.this.fWc.ME());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bgX() != null && dVar.bgX().size() >= 1 && dVar.bgX().get(0) != null) {
                        PbActivity.this.fVM.sZ(dVar.bgX().get(0).getId());
                    } else if (dVar.bhf() != null) {
                        PbActivity.this.fVM.sZ(dVar.bhf().getId());
                    }
                    if (PbActivity.this.fWc != null) {
                        PbActivity.this.fWc.a(dVar.yE());
                        PbActivity.this.fWc.a(dVar.bgT(), dVar.getUserData());
                        PbActivity.this.fWc.a(PbActivity.this.fVM.bjZ(), PbActivity.this.fVM.bjP(), PbActivity.this.fVM.bkr());
                        if (dVar.bgV() != null) {
                            PbActivity.this.fWc.cx(dVar.bgV().AR());
                        }
                    }
                    if (PbActivity.this.fVO != null) {
                        PbActivity.this.fVO.aP(dVar.wq());
                    }
                    if (dVar == null || dVar.bhi() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fVP.lu(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fVP.a(dVar, i2, i3, PbActivity.this.fVM.bjQ(), i4, PbActivity.this.fVM.getIsFromMark());
                    PbActivity.this.fVP.d(dVar, PbActivity.this.fVM.bjQ());
                    PbActivity.this.fVP.lr(PbActivity.this.fVM.getHostMode());
                    AntiData yE = dVar.yE();
                    if (yE != null) {
                        PbActivity.this.aZY = yE.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aZY) && PbActivity.this.fWc != null && PbActivity.this.fWc.LY() != null && (fI = PbActivity.this.fWc.LY().fI(6)) != null && !TextUtils.isEmpty(PbActivity.this.aZY)) {
                            ((View) fI).setOnClickListener(PbActivity.this.baJ);
                        }
                    }
                    if (PbActivity.this.fVY) {
                        PbActivity.this.fVY = false;
                        final int biD = PbActivity.this.biD();
                        if (dVar.bhu()) {
                            final int aO = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(biD, aO);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.biq().sM(biD);
                        }
                    }
                    if (PbActivity.this.fVZ) {
                        PbActivity.this.fVZ = false;
                        final int biD2 = PbActivity.this.biD();
                        final boolean z2 = biD2 != -1;
                        if (!z2) {
                            biD2 = PbActivity.this.biE();
                        }
                        if (PbActivity.this.biq() != null) {
                            if (dVar.bhu()) {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (biD2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(biD2, aO2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(biD2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.biq().lw(true);
                            } else {
                                PbActivity.this.biq().sM(biD2);
                            }
                        }
                    } else {
                        PbActivity.this.fVP.blN();
                    }
                    PbActivity.this.fVM.a(dVar.bgT(), PbActivity.this.fWC);
                    PbActivity.this.fVM.a(PbActivity.this.fWD);
                    if (PbActivity.this.fhU != null && dVar.bgV() != null && dVar.bgV().zG() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bgV().zG());
                        PbActivity.this.fhU.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fVW && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fVM != null && PbActivity.this.fVM.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fVM.getAppealInfo().fSE)) {
                                    PbActivity.this.fVP.a(PbActivity.this.fVM.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fVP.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0210e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fVP.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0210e.ds200));
                            }
                            PbActivity.this.fVP.bmg();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fVM.bjP());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.j jVar = new com.baidu.tbadk.core.util.j();
                        jVar.setOpType("2");
                        jVar.start();
                    }
                    if (i != -1) {
                        PbActivity.this.fVP.td(PbActivity.this.getResources().getString(e.j.list_no_more_new));
                    } else {
                        PbActivity.this.fVP.td("");
                    }
                    PbActivity.this.fVP.Fd();
                }
                PbActivity.this.bfY = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bhZ().bjQ() || PbActivity.this.bhZ().getPbData().yS().yQ() != 0 || PbActivity.this.bhZ().bkl()) {
                    PbActivity.this.fWd = true;
                    return;
                }
                return;
            }
            PbActivity.this.fVM.sA(1);
            if (PbActivity.this.fVt != null) {
                PbActivity.this.fVt.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fVP.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.m.Pl().Pm()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.dru : j;
                com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, PbActivity.this.bfQ, PbActivity.this.createTime, PbActivity.this.bfY, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.bfQ = 0L;
                if (iVar != null) {
                    iVar.Pi();
                }
                if (z2) {
                    iVar.bgh = currentTimeMillis;
                    iVar.cL(true);
                }
                if (!z2 && PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bgV() != null) {
                    int threadType = PbActivity.this.fVM.getPbData().bgV().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fVG, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fVG, "from_frs")) {
                                com.baidu.tbadk.l.i iVar2 = new com.baidu.tbadk.l.i();
                                iVar2.gj(1000);
                                iVar2.bgj = currentTimeMillis;
                                iVar2.gk(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.l.d dVar = new com.baidu.tbadk.l.d();
                        dVar.pageType = 1;
                        dVar.gj(1005);
                        dVar.bgj = currentTimeMillis;
                        dVar.gk(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fWQ = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.biz();
            }
        }
    };
    private final a.InterfaceC0154a fWR = new a.InterfaceC0154a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fVP.blJ();
            if (z) {
                if (PbActivity.this.fVO != null) {
                    PbActivity.this.fVO.aP(z2);
                }
                PbActivity.this.fVM.kZ(z2);
                if (PbActivity.this.fVM.wq()) {
                    PbActivity.this.biJ();
                } else {
                    PbActivity.this.fVP.n(PbActivity.this.fVM.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fVO != null && PbActivity.this.fVO.wt() != null && PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bgV() != null && PbActivity.this.fVM.getPbData().bgV().zG() != null) {
                        MarkData wt = PbActivity.this.fVO.wt();
                        MetaData zG = PbActivity.this.fVM.getPbData().bgV().zG();
                        if (wt != null && zG != null) {
                            if (!com.baidu.tbadk.core.util.ao.equals(TbadkCoreApplication.getCurrentAccount(), zG.getUserId()) && !zG.hadConcerned()) {
                                PbActivity.this.b(zG);
                                return;
                            } else {
                                PbActivity.this.showToast(e.j.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.so(PbActivity.this.mLastScrollState) && PbActivity.this.so(i)) {
                if (PbActivity.this.fVP != null) {
                    PbActivity.this.fVP.blX();
                    if (PbActivity.this.fWc != null && !PbActivity.this.fVP.bln()) {
                        PbActivity.this.fVP.lt(PbActivity.this.fWc.ME());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fVP.blm();
                    }
                }
                if (!PbActivity.this.fVA) {
                    PbActivity.this.fVA = true;
                    PbActivity.this.fVP.bmc();
                }
            }
            PbActivity.this.fVP.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fVt != null) {
                PbActivity.this.fVt.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fVB == null) {
                PbActivity.this.fVB = new com.baidu.tbadk.l.b();
                PbActivity.this.fVB.gj(1001);
            }
            if (i == 0) {
                PbActivity.this.fVB.Pc();
            } else {
                PbActivity.this.fVB.Pb();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bgX;
            if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVP != null && PbActivity.this.fVP.blD() != null) {
                PbActivity.this.fVP.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fVt != null) {
                    PbActivity.this.fVt.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fVM.bkh() && (bgX = PbActivity.this.fVM.getPbData().bgX()) != null && !bgX.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fVP.blD().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fVM.getPbData();
                    if (pbData != null) {
                        if (pbData.bgY() != null && pbData.bgY().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bgZ() != null && pbData.bgZ().hasData()) {
                            headerCount--;
                        }
                        int size = bgX.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cYC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cYy.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fVM.bkf();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.glB != 1002 || bVar.epZ) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fVP.a(1, dVar.HZ, dVar.hqU, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cYy.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fVP.a(PbActivity.this.cYy.getLoadDataMode(), gVar.HZ, gVar.hqU, false);
                        PbActivity.this.fVP.ap(gVar.hqX);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fVP.a(PbActivity.this.cYy.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fWS = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final j.b bDC = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            if (PbActivity.this.biP()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fVM.kY(true)) {
                PbActivity.this.fVP.blK();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e edV = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fWT && PbActivity.this.biP()) {
                PbActivity.this.biR();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fVM.kX(false)) {
                    PbActivity.this.fVP.blI();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fVM.getPbData() != null) {
                    PbActivity.this.fVP.bmb();
                }
                PbActivity.this.fWT = true;
            }
        }
    };
    private int fWU = 0;
    private final TbRichTextView.h brP = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fVP.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(e.g.tag_rich_text_meme_info) != null && (view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    PbActivity.this.fVK = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fXJ) {
                    TbRichText aM = PbActivity.this.aM(str, i);
                    if (aM != null && PbActivity.this.fWU >= 0 && PbActivity.this.fWU < aM.Sb().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aM.Sb().get(PbActivity.this.fWU));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fXG.size()) {
                                break;
                            } else if (!cVar.fXG.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.I(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fXH.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fXI, cVar.lastId, PbActivity.this.fVM.bkc(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbActivity.this.l(rect);
                        createConfig.setIsHotSort(PbActivity.this.fVM.acb() == 2);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.d(cVar.fXG, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.I(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fXH.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fXI, cVar.fXG.get(0), PbActivity.this.fVM.bkc(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                createConfig2.setIsHotSort(PbActivity.this.fVM.acb() == 2);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fWV = false;
    PostData fWW = null;
    private final b.InterfaceC0158b fWX = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fWW != null) {
                if (i == 0) {
                    PbActivity.this.fWW.cZ(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fWW = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fWW);
                }
            }
        }
    };
    private final b.InterfaceC0158b fWY = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fWm != null && !TextUtils.isEmpty(PbActivity.this.fWn)) {
                if (i == 0) {
                    if (PbActivity.this.fWo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fWn));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fWn;
                        aVar.pkgId = PbActivity.this.fWo.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fWo.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.bzi == null) {
                        PbActivity.this.bzi = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bzi.Et();
                    PbActivity.this.bzi.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bzi.A(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fWl == null) {
                            PbActivity.this.fWl = new av(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fWl.i(PbActivity.this.fWn, PbActivity.this.fWm.os());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fWm = null;
                PbActivity.this.fWn = null;
            }
        }
    };
    private final View.OnLongClickListener aTr = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        /* JADX WARN: Removed duplicated region for block: B:122:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0190  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            SparseArray<Object> sparseArray;
            boolean z;
            SparseArray<Object> sparseArray2;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (PbActivity.this.by(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.fWm = ((TbImageView) view).getBdImage();
                        PbActivity.this.fWn = ((TbImageView) view).getUrl();
                        if (PbActivity.this.fWm != null && !TextUtils.isEmpty(PbActivity.this.fWn)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fWo = null;
                            } else {
                                PbActivity.this.fWo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                PbActivity.this.fVP.a(PbActivity.this.fWY, PbActivity.this.fWm.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                sparseArray = sparseArray2;
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.fWm = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.fWn = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fWo = null;
                            } else {
                                PbActivity.this.fWo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.fWm = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.fWn = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.fWo = null;
                        } else {
                            PbActivity.this.fWo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                        }
                    }
                    if (!(view.getParent() instanceof TbRichTextView)) {
                    }
                    if (sparseArray2 != null) {
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 != null) {
                }
                return true;
            }
            PbActivity.this.fWW = (PostData) sparseArray.get(e.g.tag_clip_board);
            if (PbActivity.this.fWW != null) {
                if (PbActivity.this.fWW.bEj() != 1 || !PbActivity.this.by(view)) {
                    if (PbActivity.this.fVO != null) {
                        boolean z2 = PbActivity.this.fVO.wq() && PbActivity.this.fWW.getId() != null && PbActivity.this.fWW.getId().equals(PbActivity.this.fVM.zQ());
                        if (view == null || sparseArray == null) {
                            z = false;
                        } else {
                            if (PbActivity.this.fVV == null) {
                                PbActivity.this.fVV = new y(PbActivity.this.getPageContext(), PbActivity.this.dMI);
                                PbActivity.this.fVP.bH(PbActivity.this.fVV.getView());
                                PbActivity.this.fVV.lb(PbActivity.this.mIsLogin);
                            }
                            if (PbActivity.this.fWW.bEj() == 1) {
                                PbActivity.this.fVP.a(PbActivity.this.fWX, z2, false);
                            } else {
                                PbActivity.this.fVV.showDialog();
                                z = PbActivity.this.kJ(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & PbActivity.this.isLogin();
                            }
                        }
                        boolean booleanValue = sparseArray.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            PbActivity.this.fVV.bkB().setText(e.j.remove_mark);
                        } else {
                            PbActivity.this.fVV.bkB().setText(e.j.mark);
                        }
                        if (booleanValue) {
                            PbActivity.this.fVV.bkB().setVisibility(8);
                        } else {
                            PbActivity.this.fVV.bkB().setVisibility(0);
                        }
                        if (PbActivity.this.by(view)) {
                            if (PbActivity.this.fWm != null && !PbActivity.this.fWm.isGif()) {
                                sparseArray.put(e.g.tag_richtext_image, true);
                            } else {
                                sparseArray.put(e.g.tag_richtext_image, false);
                            }
                            sparseArray.put(e.g.tag_richtext_emotion, true);
                        } else {
                            sparseArray.put(e.g.tag_richtext_image, false);
                            sparseArray.put(e.g.tag_richtext_emotion, false);
                        }
                        PbActivity.this.fVV.a(sparseArray, PbActivity.this.fVM.getPbData().bhh(), z);
                        PbActivity.this.fVV.refreshUI();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").aA("tid", PbActivity.this.fVM.gaS).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getForumId()).aA("uid", PbActivity.this.fVM.getPbData().bgV().zG().getUserId()).aA("post_id", PbActivity.this.fVM.Mt()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, booleanValue ? 2 : 1));
                    }
                } else {
                    PbActivity.this.fVP.a(PbActivity.this.fWY, PbActivity.this.fWm.isGif());
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dID = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (!PbActivity.this.fVv && z && !PbActivity.this.fVM.bjX()) {
                PbActivity.this.biL();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0210e.ds200));
        }
    };
    public View.OnTouchListener biP = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.cwP.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0214a cwQ = new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        final int cIa;

        {
            this.cIa = (int) PbActivity.this.getResources().getDimension(e.C0210e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (ag(i2) && PbActivity.this.fVP != null && PbActivity.this.fVt != null) {
                PbActivity.this.fVP.bmh();
                PbActivity.this.fVt.gQ(false);
                PbActivity.this.fVt.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            if (ag(i2) && PbActivity.this.fVP != null && PbActivity.this.fVt != null) {
                PbActivity.this.fVt.gQ(true);
                if (Math.abs(i2) > this.cIa) {
                    PbActivity.this.fVt.hideFloatingView();
                }
                if (PbActivity.this.biP()) {
                    PbActivity.this.fVP.blz();
                    PbActivity.this.fVP.blA();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fXa = null;
    private final m.a fXb = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void k(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(e.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fXa = str2;
                PbActivity.this.fVP.te(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fXc = -1;
    private int fXd = -1;
    private CustomMessageListener fXg = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.aoH == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0156a) {
                    if (aVar.aoI != null && !aVar.aoI.hasError() && aVar.aoI.getError() == 0) {
                        if (PbActivity.this.fVP != null) {
                            PbActivity.this.fVP.n(((a.C0156a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bja();
                        }
                    } else if (z) {
                        if (aVar.aoI != null && aVar.aoI.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aoI.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.aoI != null && !aVar.aoI.hasError() && aVar.aoI.getError() == 0) {
                        if (PbActivity.this.fVP != null && PbActivity.this.fVP != null) {
                            PbActivity.this.fVP.n(((a.C0156a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.aoI != null && aVar.aoI.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aoI.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.aoI == null || aVar.aoI.hasError() || aVar.aoI.getError() != 0) {
                        if (z) {
                            if (aVar.aoI != null && aVar.aoI.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.aoI.getErrorString());
                            } else {
                                PbActivity.this.showToast(e.j.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(e.j.channel_need_push), 1).show();
                    }
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void m(Object obj);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public ArrayList<String> fXG;
        public ConcurrentHashMap<String, ImageUrlData> fXH;
        public boolean fXJ;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fXI = false;
        public boolean fXK = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes6.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d bil() {
        return this.fWc;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bhC() != null) {
            String id = jVar.bhC().getId();
            ArrayList<PostData> bgX = this.fVM.getPbData().bgX();
            int i = 0;
            while (true) {
                if (i >= bgX.size()) {
                    break;
                }
                PostData postData = bgX.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bhG = jVar.bhG();
                    postData.vH(jVar.getTotalCount());
                    if (postData.bEg() != null && bhG != null) {
                        Iterator<PostData> it = bhG.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.zG() != null && (metaData = postData.getUserMap().get(next.zG().getUserId())) != null) {
                                next.a(metaData);
                                next.nx(true);
                                next.a(getPageContext(), this.fVM.sY(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bhG.size() != postData.bEg().size();
                        postData.bEg().clear();
                        postData.bEg().addAll(bhG);
                        z = z2;
                    }
                    if (postData.bEc() != null) {
                        postData.bEd();
                    }
                }
            }
            if (!this.fVM.getIsFromMark() && z) {
                this.fVP.n(this.fVM.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sR(String str) {
        com.baidu.tieba.tbadkCore.data.l bhl;
        if (!TextUtils.isEmpty(str) && (bhl = this.fVM.getPbData().bhl()) != null && str.equals(bhl.getAdId())) {
            if (bhl.bDX() != null) {
                bhl.bDX().legoCard = null;
            }
            this.fVM.getPbData().bhm();
        }
    }

    public void bim() {
        com.baidu.tieba.pb.data.d pbData;
        bb bgV;
        if (!this.fWF) {
            if (!com.baidu.adp.lib.util.l.ll()) {
                showToast(e.j.no_network_guide);
            } else if (this.fWI) {
                this.fWF = true;
                if (this.fVM != null && (pbData = this.fVM.getPbData()) != null && (bgV = pbData.bgV()) != null) {
                    int isLike = bgV.zt() == null ? 0 : bgV.zt().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10796").aA("tid", bgV.getId()));
                    }
                    if (this.fWG != null) {
                        this.fWG.a(bgV.zX(), bgV.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer)) {
            final String str = (String) sparseArray.get(e.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
                bVar.de(e.j.operation);
                int i = -1;
                if (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(e.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(e.j.delete);
                    strArr[1] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fVP.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fWj);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fWj);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fWj);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fWj);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).BI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(int i) {
        bb bgV;
        String str;
        String V;
        if (this.fVM != null && this.fVM.getPbData() != null && (bgV = this.fVM.getPbData().bgV()) != null) {
            if (i == 1) {
                PraiseData zt = bgV.zt();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (zt == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bgV.a(praiseData);
                    } else {
                        bgV.zt().getUser().add(0, metaData);
                        bgV.zt().setNum(bgV.zt().getNum() + 1);
                        bgV.zt().setIsLike(i);
                    }
                }
                if (bgV.zt() != null) {
                    if (bgV.zt().getNum() < 1) {
                        V = getResources().getString(e.j.zan);
                    } else {
                        V = com.baidu.tbadk.core.util.ao.V(bgV.zt().getNum());
                    }
                    this.fVP.W(V, true);
                }
            } else if (bgV.zt() != null) {
                bgV.zt().setIsLike(i);
                bgV.zt().setNum(bgV.zt().getNum() - 1);
                ArrayList<MetaData> user = bgV.zt().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bgV.zt().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bgV.zt().getNum() < 1) {
                    str = getResources().getString(e.j.zan);
                } else {
                    str = bgV.zt().getNum() + "";
                }
                this.fVP.W(str, false);
            }
            if (this.fVM.bjQ()) {
                this.fVP.blD().notifyDataSetChanged();
            } else {
                this.fVP.o(this.fVM.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fVM.G(bundle);
        if (this.dKQ != null) {
            this.dKQ.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fWc.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fVz = System.currentTimeMillis();
        this.fWh = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.dru = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fVG = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fVG) && intent.getData() != null) {
                this.fVG = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fVG)) {
                this.fVu = true;
            }
            this.fXc = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fXd = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fXe = intent.getStringExtra("key_manga_title");
            this.fVY = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fVZ = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (biP()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ao.isEmpty(this.source) ? "" : this.source;
            this.fWq = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.dru = System.currentTimeMillis();
        }
        this.bfQ = this.fVz - this.dru;
        super.onCreate(bundle);
        this.fVx = 0;
        F(bundle);
        if (this.fVM != null && this.fVM.getPbData() != null) {
            this.fVM.getPbData().sP(this.source);
        }
        initUI();
        if (intent != null && this.fVP != null) {
            this.fVP.geF = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fWk == null) {
                    this.fWk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fVP.tg("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fWk, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fVM != null && this.fVM.getPbData() != null) {
                this.fVM.tb(stringExtra);
            }
        }
        this.dKQ = new VoiceManager();
        this.dKQ.onCreate(getPageContext());
        initData(bundle);
        this.fWb = new com.baidu.tbadk.editortools.pb.f();
        bin();
        this.fWc = (com.baidu.tbadk.editortools.pb.d) this.fWb.bM(getActivity());
        this.fWc.b(this);
        this.fWc.a(this.bai);
        this.fWc.a(this.bab);
        this.fWc.a(this, bundle);
        this.fWc.LY().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fWc.LY().cq(true);
        kI(true);
        this.fVP.setEditorTools(this.fWc.LY());
        this.fWc.a(this.fVM.bjZ(), this.fVM.bjP(), this.fVM.bkr());
        registerListener(this.fWx);
        if (!this.fVM.bjW()) {
            this.fWc.hP(this.fVM.bjP());
        }
        if (this.fVM.bks()) {
            this.fWc.hN(getPageContext().getString(e.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fWc.hN(getPageContext().getString(e.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fWw);
        registerListener(this.fWy);
        registerListener(this.fWz);
        registerListener(this.dLZ);
        registerListener(this.fWN);
        registerListener(this.fWv);
        this.fWa = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.hnX);
        this.fWa.bDK();
        registerListener(this.fWB);
        registerListener(this.mAttentionListener);
        if (this.fVM != null) {
            this.fVM.bkj();
        }
        registerListener(this.fWQ);
        registerListener(this.fXg);
        registerListener(this.dMg);
        if (this.fVP != null && this.fVP.bml() != null && this.fVP.bmm() != null) {
            this.fVt = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.fVP.bml(), this.fVP.bmm(), this.fVP.blu());
            this.fVt.a(this.fWJ);
        }
        if (this.fVs && this.fVP != null && this.fVP.bmm() != null) {
            this.fVP.bmm().setVisibility(8);
        }
        this.fWi = new com.baidu.tbadk.core.view.g();
        this.fWi.aHd = 1000L;
        registerListener(this.fWM);
        registerListener(this.fWK);
        registerListener(this.fWL);
        registerListener(this.edv);
        registerListener(this.akA);
        this.fWj = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fWj;
        userMuteAddAndDelCustomMessage.setTag(this.fWj);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fWj;
        userMuteCheckCustomMessage.setTag(this.fWj);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fVM.bkp().a(this.cwg);
        this.fVU = new at();
        if (this.fWc.Mx() != null) {
            this.fVU.g(this.fWc.Mx().getInputView());
        }
        this.fWc.a(this.bac);
        this.eax = new ShareSuccessReplyToServerModel();
        a(this.fWs);
        this.fhU = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.fhU.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.aBW) {
                        PbActivity.this.fWc.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.aBX && PbActivity.this.fVP != null && PbActivity.this.fVP.bll() != null && PbActivity.this.fVP.bll().bjH() != null) {
                        PbActivity.this.fVP.bll().bjH().MQ();
                    } else if (i == com.baidu.tbadk.core.util.aj.aBY) {
                        PbActivity.this.c(PbActivity.this.fWe);
                    }
                }
            }
        });
        this.fVN = new com.baidu.tieba.pb.pb.report.a(this);
        this.fVN.o(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.fVz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bin() {
        if (this.fWb != null && this.fVM != null) {
            this.fWb.setForumName(this.fVM.bhQ());
            if (this.fVM.getPbData() != null && this.fVM.getPbData().bgT() != null) {
                this.fWb.a(this.fVM.getPbData().bgT());
            }
            this.fWb.setFrom("pb");
            this.fWb.a(this.fVM);
        }
    }

    public String bio() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bip() {
        return this.fVt;
    }

    private void kI(boolean z) {
        this.fWc.cu(z);
        this.fWc.cv(z);
        this.fWc.cw(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bhu() && !z && this.fVP != null && this.fVP.getView() != null) {
            this.fVP.getView().setSystemUiVisibility(4);
        }
        this.fWf = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dKQ != null) {
            this.dKQ.onStart(getPageContext());
        }
    }

    public ar biq() {
        return this.fVP;
    }

    public PbModel bhZ() {
        return this.fVM;
    }

    public void sS(String str) {
        if (this.fVM != null && !StringUtils.isNull(str) && this.fVP != null) {
            this.fVP.ly(true);
            this.fVM.sS(str);
            this.fVF = true;
            this.fVP.blX();
            this.fVP.bmg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fVv = false;
        } else {
            this.fVv = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fVx = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fVx == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dKQ != null) {
            this.dKQ.onPause(getPageContext());
        }
        if (this.fVP != null) {
            this.fVP.onPause();
        }
        if (!this.fVM.bjW()) {
            this.fWc.hO(this.fVM.bjP());
        }
        if (this.fVM != null) {
            this.fVM.bkk();
        }
        com.baidu.tbadk.BdToken.c.vu().vv();
        MessageManager.getInstance().unRegisterListener(this.eLR);
        aMS();
        MessageManager.getInstance().unRegisterListener(this.fWK);
        MessageManager.getInstance().unRegisterListener(this.fWL);
        MessageManager.getInstance().unRegisterListener(this.fWM);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bir() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fVM.getPbData(), this.fVM.bjQ(), this.fVM.getRequestType());
        return (a2 == null || a2.zG() == null || a2.zG().getGodUserData() == null || a2.zG().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fVv = false;
        super.onResume();
        if (this.fVI) {
            this.fVI = false;
            biV();
        }
        if (bir()) {
            this.fVC = System.currentTimeMillis();
        } else {
            this.fVC = -1L;
        }
        if (this.fVP != null && this.fVP.getView() != null) {
            if (!this.fyX) {
                biM();
            } else {
                hideLoadingView(this.fVP.getView());
            }
            this.fVP.onResume();
        }
        if (this.fVx == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fVP != null) {
            noNetworkView = this.fVP.bli();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kV()) {
            noNetworkView.bE(false);
        }
        if (this.dKQ != null) {
            this.dKQ.onResume(getPageContext());
        }
        registerListener(this.eLR);
        this.fVX = false;
        biU();
        registerListener(this.fWK);
        registerListener(this.fWL);
        registerListener(this.fWM);
        if (this.dLy) {
            biL();
            this.dLy = false;
        }
        bjd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fVP.lm(z);
        if (this.fVV != null) {
            this.fVV.lb(z);
        }
        if (z && this.fVX) {
            this.fVP.blI();
            this.fVM.kX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fVC > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").aA("obj_duration", (System.currentTimeMillis() - this.fVC) + ""));
            this.fVC = 0L;
        }
        if (biq().bll() != null) {
            biq().bll().onStop();
        }
        if (this.fVP.geM != null && !this.fVP.geM.aqZ()) {
            this.fVP.geM.aYh();
        }
        if (this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bgT() != null && this.fVM.getPbData().bgV() != null) {
            com.baidu.tbadk.distribute.a.LL().a(getPageContext().getPageActivity(), "pb", this.fVM.getPbData().bgT().getId(), com.baidu.adp.lib.g.b.d(this.fVM.getPbData().bgV().getId(), 0L));
        }
        if (this.dKQ != null) {
            this.dKQ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aA(ImageViewerConfig.FORUM_ID, this.fVM.getPbData().getForumId());
            amVar.aA("tid", this.fVM.bjP());
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.fVA && this.fVP != null) {
            this.fVA = true;
            this.fVP.bmc();
            a(false, (PostData) null);
        }
        if (this.fVM != null) {
            this.fVM.cancelLoadData();
            this.fVM.destory();
            if (this.fVM.bko() != null) {
                this.fVM.bko().onDestroy();
            }
        }
        if (this.fWc != null) {
            this.fWc.onDestroy();
        }
        if (this.cYy != null) {
            this.cYy.cancelLoadData();
        }
        if (this.fVP != null) {
            this.fVP.onDestroy();
            if (this.fVP.geM != null) {
                this.fVP.geM.aYh();
            }
        }
        if (this.fVB != null) {
            this.fVB.Pd();
        }
        if (this.fVt != null) {
            this.fVt.Qe();
        }
        super.onDestroy();
        if (this.dKQ != null) {
            this.dKQ.onDestory(getPageContext());
        }
        this.fVP.blX();
        MessageManager.getInstance().unRegisterListener(this.fWK);
        MessageManager.getInstance().unRegisterListener(this.fWL);
        MessageManager.getInstance().unRegisterListener(this.fWM);
        MessageManager.getInstance().unRegisterListener(this.fWj);
        MessageManager.getInstance().unRegisterListener(this.fWN);
        MessageManager.getInstance().unRegisterListener(this.dMg);
        MessageManager.getInstance().unRegisterListener(this.edv);
        this.fWh = null;
        this.fWi = null;
        com.baidu.tieba.recapp.d.a.bwa().bwc();
        if (this.fWk != null) {
            getSafeHandler().removeCallbacks(this.fWk);
        }
        if (this.fVJ != null) {
            this.fVJ.cancelLoadData();
        }
        if (this.fVP != null && this.fVP.geM != null) {
            this.fVP.geM.bmY();
        }
        if (this.eax != null) {
            this.eax.cancelLoadData();
        }
        this.fVU.onDestroy();
        if (this.dLC != null) {
            this.dLC.onDestroy();
        }
        if (this.fVM != null && this.fVM.bkq() != null) {
            this.fVM.bkq().onDestroy();
        }
        if (this.fhU != null) {
            this.fhU.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f blD;
        ArrayList<PostData> bjt;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.Gu() && this.fVP != null && (blD = this.fVP.blD()) != null && (bjt = blD.bjt()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bjt.iterator();
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
                        bVar.daz = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.auk == 1 && !TextUtils.isEmpty(id)) {
                    next.auk = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.daz = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fVM == null || this.fVM.getPbData() == null || this.fVM.getPbData().bgT() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fVM.getPbData().bgT().getFirst_class();
                    str2 = this.fVM.getPbData().bgT().getSecond_class();
                    str = this.fVM.getPbData().bgT().getId();
                    str4 = this.fVM.bjP();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Gx());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fVP.onChangeSkinType(i);
            if (this.fWc != null && this.fWc.LY() != null) {
                this.fWc.LY().onChangeSkinType(i);
            }
            if (this.fVP.bli() != null) {
                this.fVP.bli().onChangeSkinType(getPageContext(), i);
            }
            this.fVU.onChangeSkinType();
            if (this.dLC != null) {
                this.dLC.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fVP = new ar(this, this.dMI, this.brQ);
        this.cwP = new com.baidu.tieba.f.b(getActivity());
        this.cwP.a(fWZ);
        this.cwP.a(this.cwQ);
        this.fVP.setOnScrollListener(this.mOnScrollListener);
        this.fVP.e(this.edV);
        this.fVP.a(this.bDC);
        this.fVP.kC(com.baidu.tbadk.core.i.xE().xI());
        this.fVP.setOnImageClickListener(this.brP);
        this.fVP.b(this.aTr);
        this.fVP.h(this.dID);
        this.fVP.a(this.fWS);
        this.fVP.lm(this.mIsLogin);
        if (getIntent() != null) {
            this.fVP.lz(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.fVP.blk().setFromForumId(this.fVM.getFromForumId());
    }

    public void bis() {
        if (this.fVP != null && this.fVM != null) {
            if (this.fVM.getPbData() != null || this.fVM.getPbData().bht() != null) {
                TiebaStatic.log(biw().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_locate", 4).x(VideoPlayActivityConfig.OBJ_ID, bhZ().getPbData().bht().bhz() ? 0 : 1));
                if (checkUpIsLogin() && this.fVP.blD() != null && this.fVP.blD().bjy() != null) {
                    this.fVP.blD().bjy().gr(this.fVM.bjP());
                }
            }
        }
    }

    public void bit() {
        TiebaStatic.log("c12181");
        if (this.fVP != null && this.fVM != null) {
            if (this.fVP == null || this.fVP.bln()) {
                if (this.fVM.getPbData() != null || this.fVM.getPbData().bht() != null) {
                    com.baidu.tieba.pb.data.i bht = this.fVM.getPbData().bht();
                    TiebaStatic.log(biw().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_locate", 4).x(VideoPlayActivityConfig.OBJ_ID, bht.bhz() ? 0 : 1));
                    if (checkUpIsLogin()) {
                        if ((!bht.bhz() || bht.AV() != 2) && this.fVP.blD() != null && this.fVP.blD().bjy() != null) {
                            this.fVP.blD().bjy().gr(this.fVM.bjP());
                        }
                        if (System.currentTimeMillis() - this.fVE > SystemScreenshotManager.DELAY_TIME) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).lU(false);
                            this.fVE = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bv(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(e.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.hoz && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.xE().xI()) {
                    return sV(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fVM == null || this.fVM.getPbData() == null) {
                        return true;
                    }
                    if (biq().bll() != null) {
                        biq().bll().bjC();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.fVM.getPbData().bgT());
                    jVar.aa(this.fVM.getPbData().bgV());
                    jVar.e(postData);
                    biq().blk().d(jVar);
                    biq().blk().setPostId(postData.getId());
                    a(view, postData.zG().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fWc != null) {
                        this.fVP.lt(this.fWc.ME());
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
        if (this.fVP != null) {
            if (z && !this.fyX) {
                biM();
            } else {
                hideLoadingView(this.fVP.getView());
            }
            if (z && this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bhu() && this.fVP.getView() != null) {
                this.fVP.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void biu() {
        if (this.fVy == null) {
            this.fVy = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fVy.a(new String[]{getPageContext().getString(e.j.call_phone), getPageContext().getString(e.j.sms_phone), getPageContext().getString(e.j.search_in_baidu)}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fVn = PbActivity.this.fVn.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fVn);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fVM.bjP(), PbActivity.this.fVn, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fVn = PbActivity.this.fVn.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fVn);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fVM.bjP(), PbActivity.this.fVn, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fVn = PbActivity.this.fVn.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fVn);
                        bVar.dismiss();
                    }
                }
            }).df(b.a.awP).dg(17).d(getPageContext());
        }
    }

    private void F(Bundle bundle) {
        this.fVM = new PbModel(this);
        this.fVM.a(this.fWP);
        if (this.fVM.bkn() != null) {
            this.fVM.bkn().a(this.fXb);
        }
        if (this.fVM.bkm() != null) {
            this.fVM.bkm().a(this.fWA);
        }
        if (this.fVM.bko() != null) {
            this.fVM.bko().b(this.fWu);
        }
        if (bundle != null) {
            this.fVM.initWithBundle(bundle);
        } else {
            this.fVM.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fVM.la(true);
        }
        aj.bkX().V(this.fVM.bjO(), this.fVM.getIsFromMark());
        if (StringUtils.isNull(this.fVM.bjP())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fVG) && this.fVG != null) {
            this.fVM.sH(6);
        }
        this.fVM.Ox();
    }

    private void initData(Bundle bundle) {
        this.fVO = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fVO != null) {
            this.fVO.a(this.fWR);
        }
        this.cYy = new ForumManageModel(this);
        this.cYy.setLoadDataCallBack(this.cYC);
        this.aCb = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fVP.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    PbActivity.this.showToast(e.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fVM.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fVM.getPbData().bgT().getId(), PbActivity.this.fVM.getPbData().bgT().getName(), PbActivity.this.fVM.getPbData().bgV().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.fWG.setUniqueId(getUniqueId());
        this.fWG.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fVP.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(e.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fWj;
        userMuteCheckCustomMessage.setTag(this.fWj);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String biv() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fVM != null && (pbData = this.fVM.getPbData()) != null) {
            return pbData.bhg().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bgV() != null) {
            if (dVar.bgV().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bgV().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bgV().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData bw(View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(e.g.tag_clip_board)) != null) {
            if (view instanceof PostPraiseView) {
                ((PostPraiseView) view).L(view);
                return postData;
            }
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.am biw() {
        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12003");
        amVar.aA("tid", this.fVM.gaS);
        amVar.x("obj_type", 0);
        amVar.aA(ImageViewerConfig.FORUM_ID, this.fVM.getForumId());
        amVar.x("obj_param1", this.fVM.getPbData().bgV().getThreadType() == 40 ? 2 : 1);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aA("obj_param2", TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && bix()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                @Override // java.lang.Runnable
                public void run() {
                    int h;
                    int aQ = (com.baidu.adp.lib.util.l.aQ(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        h = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0210e.ds120);
                    } else {
                        h = com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0210e.ds640);
                    }
                    int i = h - aQ;
                    if (i > 0) {
                        PbActivity.this.biq().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.biq().bll() != null) {
                        PbActivity.this.fWc.LY().setVisibility(8);
                        PbActivity.this.biq().bll().cn(str, str2);
                        com.baidu.tbadk.editortools.pb.g bjH = PbActivity.this.biq().bll().bjH();
                        if (bjH != null && PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null) {
                            bjH.a(PbActivity.this.fVM.getPbData().yE());
                        }
                        if (PbActivity.this.fVU.bmA() == null && PbActivity.this.biq().bll().bjH().MY() != null) {
                            PbActivity.this.biq().bll().bjH().MY().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fVU != null && PbActivity.this.fVU.bmz() != null) {
                                        if (!PbActivity.this.fVU.bmz().bNO()) {
                                            PbActivity.this.fVU.lB(false);
                                        }
                                        PbActivity.this.fVU.bmz().ou(false);
                                    }
                                }
                            });
                            PbActivity.this.fVU.h(PbActivity.this.biq().bll().bjH().MY().getInputView());
                            PbActivity.this.biq().bll().bjH().a(PbActivity.this.fWg);
                        }
                    }
                    PbActivity.this.biq().bmg();
                }
            }, 500L);
        }
    }

    public boolean bix() {
        if (this.fhU == null || this.fVM.getPbData() == null || this.fVM.getPbData().yE() == null) {
            return true;
        }
        return this.fhU.dK(this.fVM.getPbData().yE().replyPrivateFlag);
    }

    public boolean sq(int i) {
        if (this.fhU == null || this.fVM.getPbData() == null || this.fVM.getPbData().yE() == null) {
            return true;
        }
        return this.fhU.x(this.fVM.getPbData().yE().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(e.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null && this.fVM != null && this.fVM.getPbData() != null && postData.bEj() != 1) {
            String bjP = this.fVM.bjP();
            String id = postData.getId();
            int bhh = this.fVM.getPbData() != null ? this.fVM.getPbData().bhh() : 0;
            c sW = sW(id);
            if (sW != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bjP, id, "pb", true, null, false, null, bhh, postData.bnJ(), this.fVM.getPbData().yE(), false, postData.zG() != null ? postData.zG().getIconInfo() : null).addBigImageData(sW.fXG, sW.fXH, sW.fXI, sW.index);
                addBigImageData.setKeyPageStartFrom(this.fVM.bku());
                addBigImageData.setFromFrsForumId(this.fVM.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int biy() {
        if (this.fVM.getPbData() == null || this.fVM.getPbData().bgV() == null) {
            return -1;
        }
        return this.fVM.getPbData().bgV().Ak();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biz() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.va(this.fVM.getForumId()) && this.fVM.getPbData() != null && this.fVM.getPbData().bgT() != null) {
            if (this.fVM.getPbData().bgT().isLike() == 1) {
                this.fVM.bkq().cE(this.fVM.getForumId(), this.fVM.bjP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kJ(boolean z) {
        if (this.fVM == null || this.fVM.getPbData() == null) {
            return false;
        }
        return ((this.fVM.getPbData().bhh() != 0) || this.fVM.getPbData().bgV() == null || this.fVM.getPbData().bgV().zG() == null || TextUtils.equals(this.fVM.getPbData().bgV().zG().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String biA() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.p.u.PE()) {
            return "";
        }
        PostData bhc = bhc();
        if (this.fVM == null || (pbData = this.fVM.getPbData()) == null || pbData.getUserData() == null || pbData.bgV() == null || bhc == null || bhc.zG() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bhc.zG().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bgV().zo() == 0) {
            return "";
        }
        if (pbData.bgV().zo() == 0) {
            return getPageContext().getString(e.j.fans_call);
        }
        return getPageContext().getString(e.j.haved_fans_call);
    }

    private boolean kK(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fVM == null || this.fVM.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fVM.getPbData();
        if (pbData.bhh() == 0) {
            List<com.baidu.tbadk.core.data.ay> bhr = pbData.bhr();
            if (com.baidu.tbadk.core.util.v.H(bhr) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : bhr) {
                    if (ayVar != null && (tVar = ayVar.ata) != null && tVar.ara && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            return z2;
        }
        return true;
    }

    private boolean kL(boolean z) {
        return (z || this.fVM == null || this.fVM.getPbData() == null || this.fVM.getPbData().bhh() == 0) ? false : true;
    }

    public void biB() {
        if (this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bgV() != null && this.fVM.getPbData().bgV().zG() != null) {
            if (this.fVP != null) {
                this.fVP.blj();
            }
            bb bgV = this.fVM.getPbData().bgV();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgV.zG().getUserId());
            ab abVar = new ab();
            int bhh = this.fVM.getPbData().bhh();
            if (bhh == 1) {
                abVar.gcU = true;
                abVar.gcT = true;
                abVar.gdb = bgV.zB() == 1;
                abVar.gda = bgV.zC() == 1;
            } else {
                abVar.gcU = false;
                abVar.gcT = false;
            }
            if (bhh == 1002 && !equals) {
                abVar.gdf = true;
            }
            abVar.gcR = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            abVar.gcV = kK(equals);
            abVar.gcW = biC();
            abVar.gcX = kL(equals);
            abVar.qZ = this.fVM.bjQ();
            abVar.gcS = true;
            abVar.fTK = this.fVO != null && this.fVO.wq();
            abVar.gcQ = kJ(equals);
            abVar.gdd = biA();
            abVar.gcP = equals && this.fVP.blQ();
            abVar.gcY = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.gcZ = true;
            abVar.isHostOnly = this.fVM.getHostMode();
            abVar.gdc = true;
            if (bgV.zY() == null) {
                abVar.gde = true;
            } else {
                abVar.gde = false;
            }
            this.fVP.geM.a(abVar);
        }
    }

    private boolean biC() {
        if (this.fVM != null && this.fVM.bjQ()) {
            return this.fVM.getPageData() == null || this.fVM.getPageData().yQ() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null) {
            f(postData);
        }
    }

    public int biD() {
        if (biq() == null || biq().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = biq().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fTx) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int biE() {
        if (biq() == null || biq().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = biq().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.hoy) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        biL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.eA(getResources().getString(e.j.mark_done));
            aVar.bm(true);
            aVar.eB(getResources().getString(e.j.mark_like));
            aVar.bl(true);
            aVar.bf(false);
            aVar.b(getResources().getString(e.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").aA(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).x("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(e.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").aA(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).x("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.aCb.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fVM.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).BF();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fVP.blJ();
        this.fVM.kZ(z);
        if (this.fVO != null) {
            this.fVO.aP(z);
            if (markData != null) {
                this.fVO.a(markData);
            }
        }
        if (this.fVM.wq()) {
            biJ();
        } else {
            this.fVP.n(this.fVM.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean so(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sT(String str) {
        this.fVN.tp(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fVM.bjW()) {
                    antiData.setBlock_forum_name(this.fVM.getPbData().bgT().getName());
                    antiData.setBlock_forum_id(this.fVM.getPbData().bgT().getId());
                    antiData.setUser_name(this.fVM.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fVM.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else if (biq() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.aj(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.aCM));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.aCM));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.aCM));
            }
        } else if (i == 230277) {
            hU(str);
        } else {
            this.fVP.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.hqU) ? bVar.hqU : getString(e.j.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.eB(string);
                aVar.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.bf(true);
                aVar.b(getPageContext());
                aVar.BF();
            } else {
                this.fVP.a(0, bVar.HZ, bVar.hqU, z);
            }
            if (bVar.HZ) {
                if (bVar.hqS == 1) {
                    ArrayList<PostData> bgX = this.fVM.getPbData().bgX();
                    int size = bgX.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bgX.get(i).getId())) {
                            i++;
                        } else {
                            bgX.remove(i);
                            break;
                        }
                    }
                    this.fVP.n(this.fVM.getPbData());
                } else if (bVar.hqS == 0) {
                    biF();
                } else if (bVar.hqS == 2) {
                    ArrayList<PostData> bgX2 = this.fVM.getPbData().bgX();
                    int size2 = bgX2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bgX2.get(i2).bEg().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bgX2.get(i2).bEg().get(i3).getId())) {
                                i3++;
                            } else {
                                bgX2.get(i2).bEg().remove(i3);
                                bgX2.get(i2).bEi();
                                z2 = true;
                                break;
                            }
                        }
                        bgX2.get(i2).vG(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fVP.n(this.fVM.getPbData());
                    }
                    a(bVar, this.fVP);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fVP.a(this.cYy.getLoadDataMode(), gVar.HZ, gVar.hqU, false);
            if (gVar.HZ) {
                this.fVR = true;
                if (i == 2 || i == 3) {
                    this.fVS = true;
                    this.fVT = false;
                } else if (i == 4 || i == 5) {
                    this.fVS = false;
                    this.fVT = true;
                }
                if (i == 2) {
                    this.fVM.getPbData().bgV().cS(1);
                    this.fVM.setIsGood(1);
                } else if (i == 3) {
                    this.fVM.getPbData().bgV().cS(0);
                    this.fVM.setIsGood(0);
                } else if (i == 4) {
                    this.fVM.getPbData().bgV().cR(1);
                    this.fVM.lb(1);
                } else if (i == 5) {
                    this.fVM.getPbData().bgV().cR(0);
                    this.fVM.lb(0);
                }
                this.fVP.c(this.fVM.getPbData(), this.fVM.bjQ());
            }
        }
    }

    private void biF() {
        if (this.fVM.bjR() || this.fVM.bjT()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fVM.bjP());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fVM.bjP()));
        if (biK()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biG() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bhe;
        boolean z = false;
        if (this.fVP != null) {
            this.fVP.blX();
        }
        if (this.fVM != null && this.fVM.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.fVM.getPbData().bgV().getId();
            if (this.fVM.isShareThread() && this.fVM.getPbData().bgV().avt != null) {
                historyMessage.threadName = this.fVM.getPbData().bgV().avt.showText;
            } else {
                historyMessage.threadName = this.fVM.getPbData().bgV().getTitle();
            }
            if (this.fVM.isShareThread() && !bhP()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fVM.getPbData().bgT().getName();
            }
            ArrayList<PostData> bgX = this.fVM.getPbData().bgX();
            int blL = this.fVP != null ? this.fVP.blL() : 0;
            if (bgX != null && blL >= 0 && blL < bgX.size()) {
                historyMessage.postID = bgX.get(blL).getId();
            }
            historyMessage.isHostOnly = this.fVM.getHostMode();
            historyMessage.isSquence = this.fVM.bjQ();
            historyMessage.isShareThread = this.fVM.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fWc != null) {
            this.fWc.onDestroy();
        }
        if (this.fVw && biq() != null) {
            biq().bmq();
        }
        if (this.fVM != null && (this.fVM.bjR() || this.fVM.bjT())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fVM.bjP());
            if (this.fVR) {
                if (this.fVT) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fVM.bjV());
                }
                if (this.fVS) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fVM.getIsGood());
                }
            }
            if (this.fVM.getPbData() != null && System.currentTimeMillis() - this.fVz >= 40000 && (bhe = this.fVM.getPbData().bhe()) != null && !com.baidu.tbadk.core.util.v.I(bhe.getDataList())) {
                intent.putExtra("guess_like_data", bhe);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fWq);
            }
            setResult(-1, intent);
        }
        if (biK()) {
            if (this.fVM != null && this.fVP != null && this.fVP.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fVM.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bhb() && !this.fVF) {
                        aj bkX = aj.bkX();
                        com.baidu.tieba.pb.data.d pbData2 = this.fVM.getPbData();
                        Parcelable onSaveInstanceState = this.fVP.getListView().onSaveInstanceState();
                        boolean bjQ = this.fVM.bjQ();
                        boolean hostMode = this.fVM.getHostMode();
                        if (this.fVP.blu() != null && this.fVP.blu().getVisibility() == 0) {
                            z = true;
                        }
                        bkX.a(pbData2, onSaveInstanceState, bjQ, hostMode, z);
                        if (this.fWp >= 0 || this.fVM.bkw() != null) {
                            aj.bkX().j(this.fVM.bkw());
                            aj.bkX().i(this.fVM.bkx());
                            aj.bkX().sJ(this.fVM.bky());
                        }
                    }
                }
            } else {
                aj.bkX().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fVP == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fVP.sN(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sr(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fVP.blj();
            this.fVP.bll().bjC();
            this.fVP.lv(false);
        }
        this.fVP.blm();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fWc.resetData();
                        this.fWc.b(writeData);
                        this.fWc.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k fL = this.fWc.LY().fL(6);
                        if (fL != null && fL.aYl != null) {
                            fL.aYl.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fWc.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fVP.bll() != null && this.fVP.bll().bjH() != null) {
                            com.baidu.tbadk.editortools.pb.g bjH = this.fVP.bll().bjH();
                            bjH.b(writeData);
                            bjH.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k fL2 = bjH.LY().fL(6);
                            if (fL2 != null && fL2.aYl != null) {
                                fL2.aYl.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bjH.MQ();
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
        this.fWc.onActivityResult(i, i2, intent);
        if (this.fVJ != null) {
            this.fVJ.onActivityResult(i, i2, intent);
        }
        if (biq().bll() != null) {
            biq().bll().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    biI();
                    return;
                case 13008:
                    aj.bkX().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fVM != null) {
                                PbActivity.this.fVM.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.buS().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fVM != null) {
                        a(biH(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.buS().x(getPageContext());
                        biz();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.eax != null && shareItem != null && shareItem.linkUrl != null) {
                            this.eax.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void IZ() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57.1
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
                    this.fVP.kH(false);
                    if (this.fVM.getPbData() != null && this.fVM.getPbData().bgV() != null && this.fVM.getPbData().bgV().Ab() != null) {
                        this.fVM.getPbData().bgV().Ab().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fWe = emotionImageData;
                        if (sq(com.baidu.tbadk.core.util.aj.aBY)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fVP != null && this.fVP.geM != null) {
                        this.fVP.geM.dismissPopMenu();
                        this.fVP.geM.bmS();
                        if (this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bgV() != null) {
                            this.fVM.getPbData().bgV().cN(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fVK != null) {
                        this.fVP.bG(this.fVK);
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
            if (this.fVJ == null) {
                this.fVJ = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fVJ.b(this.bab);
                this.fVJ.c(this.bai);
            }
            this.fVJ.a(emotionImageData, bhZ(), bhZ().getPbData());
        }
    }

    private ShareFromPBMsgData biH() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] cP = this.fVM.getPbData().cP(getPageContext().getPageActivity());
        PostData blo = this.fVP.blo();
        String str = "";
        if (blo != null) {
            str = blo.getId();
            String da = blo.da(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(da)) {
                cP[1] = da;
            }
        }
        String zX = this.fVM.getPbData().bgV().zX();
        if (zX != null && zX.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(cP[1]);
        shareFromPBMsgData.setImageUrl(cP[0]);
        shareFromPBMsgData.setForumName(this.fVM.getPbData().bgT().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fVM.getPbData().bgV().getId());
        shareFromPBMsgData.setTitle(this.fVM.getPbData().bgV().getTitle());
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(biH(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bgV() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.dd(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null) {
                        com.baidu.tbadk.core.util.am aA = new com.baidu.tbadk.core.util.am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_param1", 3).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fVM.getForumId()).aA("tid", PbActivity.this.fVM.bjP());
                        if (PbActivity.this.e(PbActivity.this.fVM.getPbData()) != 0) {
                            aA.x("obj_type", PbActivity.this.e(PbActivity.this.fVM.getPbData()));
                        }
                        TiebaStatic.log(aA);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bg(true);
            aVar.b(getPageContext()).BF();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.N(shareFromPBMsgData.getImageUrl(), this.fVM.getPbData().bhi() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bgV() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.dd(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bg(true);
            aVar.b(getPageContext()).BF();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.N(shareFromPBMsgData.getImageUrl(), this.fVM.getPbData().bhi() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biI() {
        MarkData sG;
        if (this.fVO != null && (sG = this.fVM.sG(this.fVP.blM())) != null) {
            if (!sG.isApp() || (sG = this.fVM.sG(this.fVP.blM() + 1)) != null) {
                this.fVP.blH();
                this.fVO.a(sG);
                if (!this.fVO.wq()) {
                    this.fVO.ws();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fVO.wr();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biJ() {
        com.baidu.tieba.pb.data.d pbData = this.fVM.getPbData();
        this.fVM.kZ(true);
        if (this.fVO != null) {
            pbData.sO(this.fVO.wp());
        }
        this.fVP.n(pbData);
    }

    private boolean biK() {
        if (this.fVM == null) {
            return true;
        }
        if (this.fVM.wq()) {
            final MarkData bke = this.fVM.bke();
            if (bke == null || !this.fVM.getIsFromMark()) {
                return true;
            }
            final MarkData sG = this.fVM.sG(this.fVP.blL());
            if (sG == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bke);
                setResult(-1, intent);
                return true;
            } else if (sG.getPostId() == null || sG.getPostId().equals(bke.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bke);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.eB(getPageContext().getString(e.j.alert_update_mark));
                aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fVO != null) {
                            if (PbActivity.this.fVO.wq()) {
                                PbActivity.this.fVO.wr();
                                PbActivity.this.fVO.aP(false);
                            }
                            PbActivity.this.fVO.a(sG);
                            PbActivity.this.fVO.aP(true);
                            PbActivity.this.fVO.ws();
                        }
                        bke.setPostId(sG.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bke);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.biG();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bke);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.biG();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fVP != null && PbActivity.this.fVP.getView() != null) {
                            PbActivity.this.fVP.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bke);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.biG();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.BF();
                return false;
            }
        } else if (this.fVM.getPbData() == null || this.fVM.getPbData().bgX() == null || this.fVM.getPbData().bgX().size() <= 0 || !this.fVM.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fVP == null) {
            return null;
        }
        return this.fVP.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int SI() {
        if (this.fVP == null) {
            return 0;
        }
        return this.fVP.blV();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> SJ() {
        if (this.brG == null) {
            this.brG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: amw */
                public ImageView jz() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean xI = com.baidu.tbadk.core.i.xE().xI();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(e.d.common_color_10220));
                    if (xI) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(e.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public void u(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public ImageView v(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.xE().xI()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(e.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public ImageView w(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.brG;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> SK() {
        if (this.brH == null) {
            this.brH = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.brH;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> SL() {
        if (this.brL == null) {
            this.brL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjf */
                public GifView jz() {
                    return new GifView(PbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void u(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView v(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView w(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.Ns();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.brL;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> SM() {
        if (this.brI == null) {
            this.brI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjg */
                public View jz() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0210e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bA */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bB */
                public View v(View view) {
                    ((PlayVoiceBntNew) view).bFt();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bC */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.brI;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> SO() {
        this.brK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bjh */
            public RelativeLayout jz() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout v(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout w(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.brK;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Fw() {
        if (this.aKP == null) {
            this.aKP = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aKP;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fVD = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (aw.th(str) && this.fVM != null && this.fVM.bjP() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").x("obj_param1", 1).aA("post_id", this.fVM.bjP()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                iVar.mLink = str;
                iVar.type = 3;
                iVar.aXp = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
            }
        } else {
            aw.bmC().c(getPageContext(), str);
        }
        this.fVD = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
        aw.bmC().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fVD = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Rect rect) {
        if (rect != null && this.fVP != null && this.fVP.bml() != null && rect.top <= this.fVP.bml().getHeight()) {
            rect.top += this.fVP.bml().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.fVM.getPbData();
            TbRichText aM = aM(str, i);
            if (aM != null && (tbRichTextData = aM.Sb().get(this.fWU)) != null) {
                cVar.fXG = new ArrayList<>();
                cVar.fXH = new ConcurrentHashMap<>();
                if (!tbRichTextData.Sh().St()) {
                    cVar.fXJ = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fXG.add(b2);
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
                    imageUrlData.postId = aM.getPostId();
                    imageUrlData.mIsReserver = this.fVM.bkc();
                    imageUrlData.mIsSeeHost = this.fVM.getHostMode();
                    cVar.fXH.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.bgT() != null) {
                            cVar.forumName = pbData.bgT().getName();
                            cVar.forumId = pbData.bgT().getId();
                        }
                        if (pbData.bgV() != null) {
                            cVar.threadId = pbData.bgV().getId();
                        }
                        cVar.fXI = pbData.bhi() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.fXJ = true;
                int size = pbData.bgX().size();
                this.fWV = false;
                cVar.index = -1;
                if (pbData.bhc() != null) {
                    PostData bhc = pbData.bhc();
                    TbRichText bEl = bhc.bEl();
                    if (!aq.k(bhc)) {
                        i2 = a(bEl, aM, i, i, cVar.fXG, cVar.fXH);
                    } else {
                        i2 = a(bhc, i, cVar.fXG, cVar.fXH);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bgX().get(i4);
                    if (postData.getId() == null || pbData.bhc() == null || pbData.bhc().getId() == null || !postData.getId().equals(pbData.bhc().getId())) {
                        TbRichText bEl2 = postData.bEl();
                        if (!aq.k(postData)) {
                            i3 = a(bEl2, aM, i3, i, cVar.fXG, cVar.fXH);
                        } else {
                            i3 = a(postData, i3, cVar.fXG, cVar.fXH);
                        }
                    }
                }
                if (cVar.fXG.size() > 0) {
                    cVar.lastId = cVar.fXG.get(cVar.fXG.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.bgT() != null) {
                        cVar.forumName = pbData.bgT().getName();
                        cVar.forumId = pbData.bgT().getId();
                    }
                    if (pbData.bgV() != null) {
                        cVar.threadId = pbData.bgV().getId();
                    }
                    cVar.fXI = pbData.bhi() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Sh() == null) {
            return null;
        }
        return tbRichTextData.Sh().Sz();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Sh() == null) {
            return 0L;
        }
        return tbRichTextData.Sh().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Sh() == null) {
            return false;
        }
        return tbRichTextData.Sh().SA();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Sh() == null) {
            return false;
        }
        return tbRichTextData.Sh().SB();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Sh;
        String str;
        if (tbRichText == tbRichText2) {
            this.fWV = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Sb().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Sb().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.Sh().getWidth() * aR;
                    int height = aR * tbRichTextData.Sh().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.Sh().St()) {
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
                            if (tbRichTextData != null && (Sh = tbRichTextData.Sh()) != null) {
                                String Sw = Sh.Sw();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = Sh.Sx();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = Sw;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fVM.bjP(), -1L);
                                imageUrlData.mIsReserver = this.fVM.bkc();
                                imageUrlData.mIsSeeHost = this.fVM.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fWV) {
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
        com.baidu.tieba.tbadkCore.data.h bEs;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bDO;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bDO = (bEs = postData.bEs()).bDO()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bDO.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bDO.get(i3);
                if (jVar != null) {
                    String bDS = jVar.bDS();
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(bDS)) {
                        arrayList.add(bDS);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bDS;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bDR();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fVM.bjP(), -1L);
                        imageUrlData.mIsReserver = this.fVM.bkc();
                        imageUrlData.mIsSeeHost = this.fVM.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bEs.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bDS, imageUrlData);
                        }
                        if (!this.fWV) {
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
            if (postData.getId() != null && postData.getId().equals(this.fVM.zQ())) {
                z = true;
            }
            MarkData h = this.fVM.h(postData);
            if (h != null) {
                this.fVP.blH();
                if (this.fVO != null) {
                    this.fVO.a(h);
                    if (!z) {
                        this.fVO.ws();
                    } else {
                        this.fVO.wr();
                    }
                }
            }
        }
    }

    public boolean by(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aM(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fVM == null || this.fVM.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fVM.getPbData();
        if (pbData.bhc() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bhc());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bgX = pbData.bgX();
            a(pbData, bgX);
            return a(bgX, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bhg() != null && dVar.bhg().fTM != null && (list = dVar.bhg().fTM) != null && arrayList != null) {
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

    private long sU(String str) {
        ArrayList<PostData> bgX;
        com.baidu.tieba.pb.data.d pbData = this.fVM.getPbData();
        if (pbData != null && (bgX = pbData.bgX()) != null && !bgX.isEmpty()) {
            Iterator<PostData> it = bgX.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bEs = next.bEs();
                if (bEs != null && bEs.hof) {
                    Iterator<TbRichTextData> it2 = next.bEl().Sb().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Sq().getLink().equals(str)) {
                            return bEs.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Sb;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bEl = arrayList.get(i2).bEl();
            if (bEl != null && (Sb = bEl.Sb()) != null) {
                int size = Sb.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Sb.get(i4) != null && Sb.get(i4).getType() == 8) {
                        i3++;
                        if (Sb.get(i4).Sh().Sw().equals(str) || Sb.get(i4).Sh().Sx().equals(str)) {
                            int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                            int width = Sb.get(i4).Sh().getWidth() * aR;
                            int height = Sb.get(i4).Sh().getHeight() * aR;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fWU = i4;
                            return bEl;
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
    public void i(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.fVn = str;
            if (this.fVy == null) {
                biu();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fVy.dj(1).setVisibility(8);
            } else {
                this.fVy.dj(1).setVisibility(0);
            }
            this.fVy.BI();
            this.fVD = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dKQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biL() {
        hideNetRefreshView(this.fVP.getView());
        biM();
        if (this.fVM.Ox()) {
            this.fVP.blH();
        }
    }

    private void biM() {
        showLoadingView(this.fVP.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds400));
        View NK = getLoadingView().NK();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) NK.getLayoutParams();
        layoutParams.addRule(3, this.fVP.bml().getId());
        NK.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBM() {
        if (this.dKQ != null) {
            this.dKQ.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004020, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void st(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fVM.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fVM.getPbData();
            pbData.bgT().getName();
            String title = pbData.bgV().getTitle();
            int i2 = this.fVM.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.bgT() != null) {
                if ((pbData.bgT().isLike() == 1) && AddExperiencedModel.va(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fVM.bjP() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] cP = pbData.cP(getPageContext().getPageActivity());
                    str = cP[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = cP[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (biy() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").aA(ImageViewerConfig.FORUM_ID, pbData.getForumId()).aA("tid", pbData.getThreadId()).aA("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.aSa = true;
                    dVar.aSf = z;
                    dVar.extData = this.fVM.bjP();
                    dVar.aSo = 3;
                    dVar.aSn = i;
                    dVar.fid = this.fVM.getForumId();
                    dVar.tid = this.fVM.bjP();
                    dVar.aSp = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fVM.getPbData().bgV());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aSo);
                    bundle.putInt("obj_type", dVar.aSp);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.k(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bhu()) {
                                PbActivity.this.fVP.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.asd().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fVM.bjP() + "?share=9105&fr=share&see_lz=" + i2;
            String[] cP2 = pbData.cP(getPageContext().getPageActivity());
            str = cP2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = cP2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (biy() == 1) {
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aSa = true;
            dVar2.aSf = z;
            dVar2.extData = this.fVM.bjP();
            dVar2.aSo = 3;
            dVar2.aSn = i;
            dVar2.fid = this.fVM.getForumId();
            dVar2.tid = this.fVM.bjP();
            dVar2.aSp = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fVM.getPbData().bgV());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aSo);
            bundle2.putInt("obj_type", dVar2.aSp);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.k(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fVM != null && PbActivity.this.fVM.getPbData() != null && PbActivity.this.fVM.getPbData().bhu()) {
                        PbActivity.this.fVP.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.asd().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bgV() != null) {
            if (dVar.bgV().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bgV().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biN() {
        com.baidu.tbadk.util.x.a(new com.baidu.tbadk.util.w<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.w
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.vb(PbActivity.this.fVM.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fVP.bmr();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> SN() {
        if (this.brJ == null) {
            this.brJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bji */
                public LinearLayout jz() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
                    linearLayout.setId(e.g.pb_text_voice_layout);
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
                public void u(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout v(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout w(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.brJ;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fVP.blC() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).aA(ImageViewerConfig.FORUM_ID, this.fVM.getPbData().getForumId()));
            } else {
                bb bgV = this.fVM.getPbData().bgV();
                if (view != null) {
                    boolean z = bgV.zt() == null || bgV.zt().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fWH > 1000) {
                            this.fWI = true;
                            bz(view);
                        } else {
                            this.fWI = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            k(view, this.fWI);
                        } else {
                            j(view, this.fWI);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        j(view, this.fWI);
                    } else if (motionEvent.getAction() == 3) {
                        j(view, this.fWI);
                    }
                }
            }
        }
        return false;
    }

    private void j(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fWH = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fWH = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bz(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void aBN() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData aAM() {
        if (this.fVM == null || this.fVM.getPbData() == null) {
            return null;
        }
        return this.fVM.getPbData().yE();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.BH() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.BH();
            int intValue = ((Integer) sparseArray.get(ar.ggz)).intValue();
            if (intValue == ar.ggA) {
                if (!this.cYy.bEU()) {
                    this.fVP.blE();
                    String str = (String) sparseArray.get(e.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.cYy.vM(com.baidu.tbadk.core.util.ao.i(jSONArray));
                    }
                    this.cYy.a(this.fVM.getPbData().bgT().getId(), this.fVM.getPbData().bgT().getName(), this.fVM.getPbData().bgV().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == ar.ggB || intValue == ar.ggD) {
                if (this.fVM.bkn() != null) {
                    this.fVM.bkn().sw(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.ggB) {
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
        if (sparseArray.get(e.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(e.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(e.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(e.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(e.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(e.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(e.g.tag_user_mute_msg);
        }
        if (sparseArray.get(e.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fWj);
        userMuteAddAndDelCustomMessage.setTag(this.fWj);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean sV(String str) {
        if (!StringUtils.isNull(str) && ba.bJ(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(e.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void kM(boolean z) {
        this.fVX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String biO() {
        ArrayList<PostData> bgX;
        int H;
        if (this.fVM == null || this.fVM.getPbData() == null || this.fVM.getPbData().bgX() == null || (H = com.baidu.tbadk.core.util.v.H((bgX = this.fVM.getPbData().bgX()))) == 0) {
            return "";
        }
        if (this.fVM.bkc()) {
            Iterator<PostData> it = bgX.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bEj() == 1) {
                    return next.getId();
                }
            }
        }
        int blL = this.fVP.blL();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bgX, blL);
        if (postData == null || postData.zG() == null) {
            return "";
        }
        if (this.fVM.sY(postData.zG().getUserId())) {
            return postData.getId();
        }
        for (int i = blL - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(bgX, i);
            if (postData2 == null || postData2.zG() == null || postData2.zG().getUserId() == null) {
                break;
            } else if (this.fVM.sY(postData2.zG().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = blL + 1; i2 < H; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(bgX, i2);
            if (postData3 == null || postData3.zG() == null || postData3.zG().getUserId() == null) {
                return "";
            }
            if (this.fVM.sY(postData3.zG().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ar(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ay.Ef().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(sU(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fVM.getPbData().bgT().getId(), this.fVM.getPbData().bgT().getName(), this.fVM.getPbData().bgV().getTid());
            }
            this.fVD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.eB(getResources().getString(e.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.eB(getResources().getString(e.j.make_sure_hide));
        }
        aVar.a(getResources().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fVM.bkm() != null) {
                    PbActivity.this.fVM.bkm().cY(j);
                }
            }
        });
        aVar.b(getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.bg(false);
        aVar.b(getPageContext());
        aVar.BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c sW(String str) {
        String str2;
        if (this.fVM.getPbData() == null || this.fVM.getPbData().bgX() == null || this.fVM.getPbData().bgX().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fVM.getPbData().bgX().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fVM.getPbData().bgX().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fVM.getPbData().bgX().get(i);
        if (postData.bEl() == null || postData.bEl().Sb() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bEl().Sb().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Sh() != null) {
                    str2 = next.Sh().Sw();
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
        if (this.fVu) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fVu = false;
        } else if (biP()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fVu) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fVu = false;
        } else if (biP()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fVM != null) {
            if (this.fVM.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.fVM.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.fVM.bjP(), 0L));
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean biP() {
        return (!this.fVs && this.fXc == -1 && this.fXd == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fXf = mVar;
            this.fVs = true;
            this.fVP.blv();
            this.fVP.tf(this.fXe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biQ() {
        if (this.fXf != null) {
            if (this.fXc == -1) {
                showToast(e.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fXf.getCartoonId(), this.fXc, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biR() {
        if (this.fXf != null) {
            if (this.fXd == -1) {
                showToast(e.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fXf.getCartoonId(), this.fXd, 0)));
                finish();
            }
        }
    }

    public int biS() {
        return this.fXc;
    }

    public int biT() {
        return this.fXd;
    }

    private void aMS() {
        if (this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bgV() != null && this.fVM.getPbData().bgV().Au()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void biU() {
        if (this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bgV() != null && this.fVM.getPbData().bgV().Au()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void biV() {
        if (this.fVv) {
            this.fVI = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fVM.getPbData() != null && this.fVM.getPbData().bgV() != null && this.fVM.getPbData().bgV().zn() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fVM.getPbData().bgV().zn().getThreadId(), this.fVM.getPbData().bgV().zn().getTaskId(), this.fVM.getPbData().bgV().zn().getForumId(), this.fVM.getPbData().bgV().zn().getForumName(), this.fVM.getPbData().bgV().zB(), this.fVM.getPbData().bgV().zC())));
            this.fVu = true;
            finish();
        }
    }

    public String biW() {
        return this.fVG;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a biX() {
        return this.fVL;
    }

    public void kN(boolean z) {
        this.fVH = z;
    }

    public boolean biY() {
        if (this.fVM != null) {
            return this.fVM.bjR();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.eB(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fWh).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fWh.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fWh).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fWh != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fWh.getPageActivity());
            aVar.eB(str);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fWh).BF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fVP.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fWh.getPageActivity());
        if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            aVar.eB(this.fWh.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.eB(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fVP.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fWh).BF();
    }

    public void bja() {
        if (this.fVM != null && this.fVM.getPbData() != null && this.fVM.getPbData().bgV() != null && this.fVM.getPbData().bgV().AJ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.db(e.j.channel_open_push_message);
            aVar.a(e.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fVM.getPbData().bgV().AJ().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(e.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.BF();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (aw.th(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_wenxue)) != null) {
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

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.isFullScreen = true;
        } else {
            this.isFullScreen = false;
        }
        if (this.fVP != null) {
            this.fVP.onConfigurationChanged(configuration);
        }
        if (this.fVV != null) {
            this.fVV.dismiss();
        }
    }

    public boolean bjb() {
        if (this.fVM != null) {
            return this.fVM.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.fVM.getPbData().bhg().fTM;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bEg().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bEg().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bEg().remove(i2);
                    list.get(i).bEi();
                    z = true;
                    break;
                }
            }
            list.get(i).vG(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.n(this.fVM.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bhC().getId();
        List<PostData> list = this.fVM.getPbData().bhg().fTM;
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
                ArrayList<PostData> bhG = jVar.bhG();
                postData.vH(jVar.getTotalCount());
                if (postData.bEg() != null) {
                    postData.bEg().clear();
                    postData.bEg().addAll(bhG);
                }
            }
        }
        if (!this.fVM.getIsFromMark()) {
            this.fVP.n(this.fVM.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bhO() {
        return this.fVQ;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bhP() {
        if (this.fVM == null) {
            return false;
        }
        return this.fVM.bhP();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bhQ() {
        if (this.fVM != null) {
            return this.fVM.bhQ();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bhR() {
        if (this.fVM == null || this.fVM.getPbData() == null) {
            return 0;
        }
        return this.fVM.getPbData().bhh();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean sQ(String str) {
        return this.fVM != null && this.fVM.sY(str);
    }

    public void bjc() {
        if (this.fVP != null) {
            this.fVP.blj();
            aBN();
        }
    }

    public PostData bhc() {
        return this.fVP.b(this.fVM.gbm, this.fVM.bjQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.isLinkThread()) {
                return 3;
            }
            if (bbVar.AL()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fWr != null && !this.fWr.isEmpty()) {
            int size = this.fWr.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fWr.get(i).onBackPressed()) {
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
            if (this.fWr == null) {
                this.fWr = new ArrayList();
            }
            if (!this.fWr.contains(aVar)) {
                this.fWr.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fWr == null) {
                this.fWr = new ArrayList();
            }
            if (!this.fWr.contains(aVar)) {
                this.fWr.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fWr != null) {
            this.fWr.remove(aVar);
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dLC == null) {
            this.dLC = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dLC.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bn(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dLC.a(contriInfo, -1L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.k kVar) {
        com.baidu.tbadk.core.util.ad.a(kVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(kVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjd() {
        if (this.fVM != null && !com.baidu.tbadk.core.util.ao.isEmpty(this.fVM.bjP())) {
            com.baidu.tbadk.BdToken.c.vu().f(com.baidu.tbadk.BdToken.b.ajO, com.baidu.adp.lib.g.b.d(this.fVM.bjP(), 0L));
        }
    }
}
