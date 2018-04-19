package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.KuangFloatingViewController;
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
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
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
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.a.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.pb.main.q;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView;
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
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e {
    private com.baidu.adp.lib.e.b<ImageView> aWn;
    private com.baidu.adp.lib.e.b<TextView> aWo;
    private com.baidu.adp.lib.e.b<View> aWp;
    private com.baidu.adp.lib.e.b<LinearLayout> aWq;
    private com.baidu.adp.lib.e.b<RelativeLayout> aWr;
    private com.baidu.adp.lib.e.b<GifView> aWs;
    private com.baidu.adp.lib.e.b<TbImageView> aqg;
    private com.baidu.tbadk.core.util.b.a baD;
    private com.baidu.tieba.f.b byy;
    private com.baidu.tbadk.core.dialog.i cXT;
    private VoiceManager cXj;
    public com.baidu.tbadk.core.util.ai enV;
    private com.baidu.tieba.pb.pb.main.emotion.model.a feK;
    private View feL;
    public au feT;
    private x feU;
    private boolean feW;
    private com.baidu.tieba.tbadkCore.data.e feZ;
    private String feo;
    private com.baidu.tieba.pb.pb.main.a.b feu;
    private boolean ffS;
    private com.baidu.tbadk.editortools.pb.f ffa;
    private com.baidu.tbadk.editortools.pb.d ffb;
    private EmotionImageData ffd;
    private com.baidu.adp.base.e ffg;
    private com.baidu.tbadk.core.view.b ffh;
    private BdUniqueId ffi;
    private Runnable ffj;
    private aw ffk;
    private com.baidu.adp.widget.ImageView.a ffl;
    private String ffm;
    private TbRichTextMemeInfo ffn;
    private List<a> ffq;
    private String fge;
    private com.baidu.tbadk.core.data.n fgf;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private boolean fet = false;
    private boolean fev = false;
    private boolean few = false;
    private boolean eJt = false;
    private boolean fex = true;
    private int fey = 0;
    private com.baidu.tbadk.core.dialog.b fez = null;
    private long cHR = -1;
    private long aKV = 0;
    private long feA = 0;
    private long createTime = 0;
    private long aKN = 0;
    private boolean feB = false;
    private com.baidu.tbadk.k.d feC = null;
    private long feD = 0;
    private boolean feE = false;
    private long feF = 0;
    private String aEA = null;
    private boolean feG = false;
    private boolean isFullScreen = false;
    private String feH = "";
    private boolean feI = true;
    private boolean feJ = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a feM = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void q(boolean z) {
            PbActivity.this.feO.kg(!PbActivity.this.feI);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.feN != null && PbActivity.this.feN.oI()) {
                        PbActivity.this.aXf();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12536").r("obj_locate", ar.a.aje));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12535").r("obj_locate", ar.a.aje));
        }
    };
    private PbModel feN = null;
    private com.baidu.tbadk.baseEditMark.a eGw = null;
    private ForumManageModel cpH = null;
    private com.baidu.tbadk.coreExtra.model.a ait = null;
    private ShareSuccessReplyToServerModel dll = null;
    private as feO = null;
    public final com.baidu.tieba.pb.pb.main.a.a feP = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean feQ = false;
    private boolean feR = false;
    private boolean feS = false;
    private boolean feV = false;
    private boolean feX = false;
    private boolean feY = false;
    private boolean ffc = false;
    public boolean ffe = false;
    private com.baidu.tbadk.editortools.pb.c aED = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Ed() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aEE = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ec() {
            if (PbActivity.this.feT == null || PbActivity.this.feT.baQ() == null || !PbActivity.this.feT.baQ().bAW()) {
                return !PbActivity.this.qd(com.baidu.tbadk.core.util.ai.aio);
            }
            PbActivity.this.showToast(PbActivity.this.feT.baQ().bAY());
            if (PbActivity.this.ffb != null && (PbActivity.this.ffb.Eq() || PbActivity.this.ffb.Er())) {
                PbActivity.this.ffb.a(false, PbActivity.this.feT.baT());
            }
            PbActivity.this.feT.kr(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fff = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ec() {
            if (PbActivity.this.feT == null || PbActivity.this.feT.baR() == null || !PbActivity.this.feT.baR().bAW()) {
                return !PbActivity.this.qd(com.baidu.tbadk.core.util.ai.aip);
            }
            PbActivity.this.showToast(PbActivity.this.feT.baR().bAY());
            if (PbActivity.this.feO != null && PbActivity.this.feO.aZH() != null && PbActivity.this.feO.aZH().aYa() != null && PbActivity.this.feO.aZH().aYa().Er()) {
                PbActivity.this.feO.aZH().aYa().a(PbActivity.this.feT.baT());
            }
            PbActivity.this.feT.ks(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean cXP = false;
    private int ffo = 0;
    private int ffp = -1;
    private final a ffr = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.feO != null && PbActivity.this.feO.aZH() != null) {
                r aZH = PbActivity.this.feO.aZH();
                if (aZH.aXX()) {
                    aZH.aXW();
                    return true;
                }
            }
            if (PbActivity.this.feO != null && PbActivity.this.feO.bay()) {
                PbActivity.this.feO.baz();
                return true;
            }
            return false;
        }
    };
    private q.b ffs = new q.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // com.baidu.tieba.pb.pb.main.q.b
        public void c(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private AddExperiencedModel.a cXV = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.aXj();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final y.a fft = new y.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void D(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.feO.showToast(str);
            }
        }
    };
    private final CustomMessageListener ffu = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.feN != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.ffb != null) {
                    PbActivity.this.feO.kl(PbActivity.this.ffb.Ek());
                }
                PbActivity.this.feO.aZI();
                PbActivity.this.feO.bar();
            }
        }
    };
    CustomMessageListener cYl = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                PbActivity.this.feN.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                if (PbActivity.this.feO != null && PbActivity.this.feN != null) {
                    PbActivity.this.feO.d(PbActivity.this.feN.getPbData(), PbActivity.this.feN.aYk(), PbActivity.this.feN.getRequestType());
                }
                if (PbActivity.this.feO != null && PbActivity.this.feO.aZY() != null) {
                    PbActivity.this.feO.aZY().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener ffv = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.feO != null) {
                    if (booleanValue) {
                        PbActivity.this.feO.aFf();
                    } else {
                        PbActivity.this.feO.aFe();
                    }
                }
            }
        }
    };
    private CustomMessageListener ffw = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.ffb != null) {
                    PbActivity.this.feO.kl(PbActivity.this.ffb.Ek());
                }
                PbActivity.this.feO.kn(false);
            }
        }
    };
    private CustomMessageListener ffx = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customResponsedMessage.getData();
                switch (dVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.k) dVar.getData());
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
    private CustomMessageListener ffy = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.feO != null && PbActivity.this.feO.aZY() != null) {
                PbActivity.this.feO.aZY().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dRK = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a ffz = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void m(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.qf(2);
                ai.aZr().reset();
                PbActivity.this.feN.aYC();
                boolean z2 = false;
                ArrayList<PostData> aVu = PbActivity.this.feN.getPbData().aVu();
                if (aVu != null) {
                    Iterator<PostData> it = aVu.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ar.j(next) && next.bsi().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.feO.n(PbActivity.this.feN.getPbData());
                    }
                    PbActivity.this.showToast(d.k.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(d.k.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(d.k.operation_failed);
        }
    };
    private View.OnClickListener aFk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbActivity.this.showToast(PbActivity.this.aEA);
        }
    };
    private CustomMessageListener ffA = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z)) {
                com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
                an.a aVar = new an.a();
                aVar.giftId = zVar.id;
                aVar.giftName = zVar.name;
                aVar.thumbnailUrl = zVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.feN.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.feN.aYt() != null && PbActivity.this.feN.aYt().getUserIdLong() == zVar.toUserId) {
                        PbActivity.this.feO.a(zVar.sendCount, PbActivity.this.feN.getPbData(), PbActivity.this.feN.aYk(), PbActivity.this.feN.getRequestType());
                    }
                    if (pbData.aVu() != null && pbData.aVu().size() >= 1 && pbData.aVu().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aVu().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.feN.aYj(), 0L);
                        if (c2 == zVar.postId && c3 == zVar.threadId) {
                            com.baidu.tbadk.core.data.an bsh = pbData.aVu().get(0).bsh();
                            if (bsh == null) {
                                bsh = new com.baidu.tbadk.core.data.an();
                            }
                            ArrayList<an.a> rf = bsh.rf();
                            if (rf == null) {
                                rf = new ArrayList<>();
                            }
                            rf.add(0, aVar);
                            bsh.bJ(zVar.sendCount + bsh.re());
                            bsh.g(rf);
                            pbData.aVu().get(0).a(bsh);
                            PbActivity.this.feO.aZY().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a ffB = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.alA() != null && !aVar.alA().isEmpty()) {
                    PbActivity.this.feO.a(aVar, PbActivity.this.ffD);
                }
                PbActivity.this.feO.a(aVar, PbActivity.this.feN.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.baW()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a ffC = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void D(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.w(list) && PbActivity.this.feO != null) {
                PbActivity.this.feO.cO(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a ffD = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                az.aK(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.fp().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17.1
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
    private boolean ffE = false;
    private PraiseModel ffF = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void in(String str) {
            PbActivity.this.ffE = false;
            if (PbActivity.this.ffF != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.feN.getPbData();
                if (pbData.aVs().rF().getIsLike() == 1) {
                    PbActivity.this.ks(0);
                } else {
                    PbActivity.this.ks(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.aVs()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void R(int i, String str) {
            PbActivity.this.ffE = false;
            if (PbActivity.this.ffF != null && str != null) {
                if (AntiHelper.tt(i)) {
                    AntiHelper.am(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long ffG = 0;
    private boolean ffH = true;
    private b.a ffI = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jC(boolean z) {
            PbActivity.this.jB(z);
            if (PbActivity.this.feO.baE() != null && z) {
                PbActivity.this.feO.kg(false);
            }
            PbActivity.this.feO.ki(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().auo != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().auo, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12534").r("obj_locate", ar.a.aje));
                        }
                    } else if (updateAttentionMessage.getData().Aj) {
                        if (PbActivity.this.aVz().rQ() != null && PbActivity.this.aVz().rQ().getGodUserData() != null) {
                            PbActivity.this.aVz().rQ().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVs() != null && PbActivity.this.feN.getPbData().aVs().rQ() != null) {
                            PbActivity.this.feN.getPbData().aVs().rQ().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bQy = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.feO.aas();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.qg(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.awJ();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.k.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aWx = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view2, MotionEvent motionEvent) {
            if (PbActivity.this.feO.aZJ()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.feN != null && (PbActivity.this.feN.getPbData() != null || PbActivity.this.feN.getPbData().aVO() != null)) {
                    if (PbActivity.this.feN.getPbData().aVO().aVW()) {
                        if (PbActivity.this.feN.getPbData().aVO().fcG == 1 || PbActivity.this.feN.getPbData().aVO().fcG == 3 || PbActivity.this.feN.getPbData().aVO().fcG == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.feN.getPbData().aVO().aVW() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.feN.getPbData().aVO().aVW() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.feF > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kN(false);
                        PbActivity.this.feF = System.currentTimeMillis();
                    }
                }
            }
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view2, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view2, MotionEvent motionEvent) {
            if (view2 != null) {
                if (view2.getId() == d.g.richText) {
                    if (PbActivity.this.aV(view2)) {
                        return true;
                    }
                } else if (view2.getId() == d.g.pb_floor_item_layout) {
                    if (view2.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view2.getTag(d.g.tag_from));
                    }
                } else if (!(view2 instanceof TbRichTextView) && view2.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.feO != null && PbActivity.this.feO.aWP() && view2.getId() == d.g.pb_head_user_info_root) {
                        if (view2.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10630").ac(VideoPlayActivityConfig.OBJ_ID, (String) view2.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.feP != null && PbActivity.this.feP.fsk != null) {
                            PbActivity.this.feP.fsk.onClick(view2);
                        }
                    }
                } else {
                    SparseArray sparseArray = null;
                    if (view2.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view2.getTag();
                    }
                    if (sparseArray != null) {
                        PbActivity.this.c(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (PbActivity.this.ffb != null) {
                PbActivity.this.feO.kl(PbActivity.this.ffb.Ek());
            }
            PbActivity.this.feO.aZI();
            PbActivity.this.feO.bar();
            return true;
        }
    });
    private CustomMessageListener ffJ = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.ffi) {
                PbActivity.this.feO.aas();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.feN.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aVG().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.ffh.i(PbActivity.this.ffg.getResources().getString(d.k.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.ffg.getResources().getString(d.k.mute_error_beyond_limit);
                    }
                    PbActivity.this.gt(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aXv();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.an.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.ffg.getResources().getString(d.k.mute_fail);
                    }
                    PbActivity.this.ffh.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener ffK = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.ffi) {
                PbActivity.this.feO.aas();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.ffh.i(PbActivity.this.ffg.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.an.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.ffg.getResources().getString(d.k.un_mute_fail);
                }
                PbActivity.this.ffh.j(muteMessage);
            }
        }
    };
    private CustomMessageListener ffL = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.ffi) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.feO.aas();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gJB;
                if (aVar.error == 0 && dataRes != null) {
                    int g = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = g == 1;
                    if (com.baidu.tbadk.core.util.an.isEmpty(str)) {
                        sparseArray.put(d.g.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(d.g.tag_user_mute_msg, str);
                    }
                    sparseArray.put(d.g.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(d.g.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(d.g.tag_from)).intValue();
                if (intValue == 0) {
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.feO.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener ffM = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.feO.aZJ() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aWx() != null && PbActivity.this.aWx().getPbData() != null && PbActivity.this.aWx().getPbData().aVO() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aVW = PbActivity.this.aWx().getPbData().aVO().aVW();
                if (intValue < 10) {
                    if (aVW) {
                        if (PbActivity.this.feN.getPbData().aVO().fcG == 1 || PbActivity.this.feN.getPbData().aVO().fcG == 3 || PbActivity.this.feN.getPbData().aVO().fcG == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.feN.getPbData().aVO().aVW() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVW ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.feF > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kN(false);
                        PbActivity.this.feF = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aVW, 3);
                TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVW ? 0 : 1));
            }
        }
    };
    private CustomMessageListener cYt = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cXP = true;
                }
            }
        }
    };
    public a.b eTi = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.apD();
            com.baidu.tbadk.core.data.am azo = PbActivity.this.feN.azo();
            int pageNum = PbActivity.this.feO.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.k.pb_page_error);
            } else if (azo == null || pageNum <= azo.qX()) {
                PbActivity.this.feO.bar();
                PbActivity.this.qf(2);
                PbActivity.this.apC();
                PbActivity.this.feO.bac();
                if (com.baidu.adp.lib.util.j.gP()) {
                    PbActivity.this.feN.qn(PbActivity.this.feO.getPageNum());
                    if (PbActivity.this.feu != null) {
                        PbActivity.this.feu.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(d.k.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(d.k.pb_page_error);
            }
        }
    };
    public final View.OnClickListener cYT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Multi-variable search result rejected for r2v181, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v185, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v212, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v315, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:687:0x1c3a  */
        /* JADX WARN: Removed duplicated region for block: B:714:0x1e04  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            String name;
            com.baidu.tieba.pb.data.j aVO;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            String str;
            int i;
            bi biVar;
            SparseArray sparseArray;
            PostData postData;
            boolean l;
            if (view2 != null) {
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == PbActivity.this.feO.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.feN.jM(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.feO.bad();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aZk()) {
                        if (view2 == PbActivity.this.feO.fnY.aMS) {
                            if (PbActivity.this.feO.kk(PbActivity.this.feN.aYq())) {
                                PbActivity.this.apC();
                                return;
                            }
                            PbActivity.this.fex = false;
                            PbActivity.this.fev = false;
                            PbActivity.this.finish();
                        } else if (view2 != PbActivity.this.feO.baa() && (PbActivity.this.feO.fnY.bbi() == null || (view2 != PbActivity.this.feO.fnY.bbi().aZj() && view2 != PbActivity.this.feO.fnY.bbi().aZh()))) {
                            if (view2 == PbActivity.this.feO.bau()) {
                                if (PbActivity.this.feN != null) {
                                    com.baidu.tbadk.browser.a.M(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.feN.getPbData().aVs().rP().getLink());
                                }
                            } else if (view2 != PbActivity.this.feO.fnY.fsU && view2.getId() != d.g.view_forum_name) {
                                if (view2 == PbActivity.this.feO.fnY.fsV) {
                                    if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null) {
                                        ArrayList<PostData> aVu = PbActivity.this.feN.getPbData().aVu();
                                        if ((aVu == null || aVu.size() <= 0) && PbActivity.this.feN.aYk()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12378").ac("tid", PbActivity.this.feN.aYj()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getForumId()));
                                        if (!PbActivity.this.feO.baJ()) {
                                            PbActivity.this.feO.aZI();
                                        }
                                        PbActivity.this.aWX();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view2.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aYV()) {
                                        if ((PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aZg()) && view2.getId() != d.g.floor_owner_reply && view2.getId() != d.g.reply_title) {
                                            if (PbActivity.this.feO.fnY.bbi() == null || (view2 != PbActivity.this.feO.fnY.bbi().getCancelView() && view2 != PbActivity.this.feO.fnY.bbi().aZf())) {
                                                if (view2 != PbActivity.this.feO.fnY.fsW && view2.getId() != d.g.tv_share && view2.getId() != d.g.share_container) {
                                                    if (PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aZd()) {
                                                        if ((PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aZm()) && view2.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aZe()) {
                                                                if (PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aZn()) {
                                                                    if (PbActivity.this.feU == null || view2 != PbActivity.this.feU.aYX()) {
                                                                        if (PbActivity.this.feU == null || view2 != PbActivity.this.feU.aYV()) {
                                                                            if (PbActivity.this.feU == null || view2 != PbActivity.this.feU.aZa()) {
                                                                                if (PbActivity.this.feU == null || view2 != PbActivity.this.feU.aYY()) {
                                                                                    if (PbActivity.this.feU == null || view2 != PbActivity.this.feU.aYZ()) {
                                                                                        if (PbActivity.this.feO.baE() == view2) {
                                                                                            if (PbActivity.this.feO.baE().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.d pbData = PbActivity.this.feN.getPbData();
                                                                                                if (pbData != null && pbData.aVs() != null && pbData.aVs().rA() != null) {
                                                                                                    String qw = pbData.aVs().rA().qw();
                                                                                                    if (StringUtils.isNull(qw)) {
                                                                                                        qw = pbData.aVs().rA().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11107").ac(VideoPlayActivityConfig.OBJ_ID, qw));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cc("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.aXr();
                                                                                        } else if (PbActivity.this.feO.aZX() != view2) {
                                                                                            if (PbActivity.this.feU == null || view2 != PbActivity.this.feU.aYW()) {
                                                                                                if (PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aZl()) {
                                                                                                    if (PbActivity.this.feO.fnY.bbi() != null && view2 == PbActivity.this.feO.fnY.bbi().aZi()) {
                                                                                                        if (com.baidu.adp.lib.util.j.gP()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.feO.c(PbActivity.this.feN.getPbData(), PbActivity.this.feN.aYk(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.feO.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.feO.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.feO.fnY.pr();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.k.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view2.getId() != d.g.sub_pb_more && view2.getId() != d.g.sub_pb_item && view2.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view2 != PbActivity.this.feO.aWI()) {
                                                                                                            if (view2 == PbActivity.this.feO.fnY.bbj()) {
                                                                                                                PbActivity.this.feO.baj();
                                                                                                            } else {
                                                                                                                int id = view2.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (biVar = (bi) view2.getTag()) != null && !StringUtils.isNull(biVar.ts())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        com.baidu.tbadk.core.util.ax.wg().c(PbActivity.this.getPageContext(), new String[]{biVar.ts()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view2 instanceof PbFloorAgreeView)) {
                                                                                                                    PostData aW = PbActivity.this.aW(view2);
                                                                                                                    if (aW != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, aW.bsl() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view2, 2, false, 1);
                                                                                                                    if (PbActivity.this.aWx() != null && PbActivity.this.aWx().getPbData() != null && PbActivity.this.aWx().getPbData().aVO() != null && PbActivity.this.aWx().getPbData().aVO() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.aWx().getPbData().aVO().aVW() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view2 != null && (view2.getTag() instanceof Boolean) && ((Boolean) view2.getTag()).booleanValue() && PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && !StringUtils.isNull(PbActivity.this.feN.getPbData().getThreadId()) && (aVO = PbActivity.this.feN.getPbData().aVO()) != null && aVO.aVU() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.ax.wg().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.feN.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view2 != null && view2.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view2.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.feU == null) {
                                                                                                                                PbActivity.this.feU = new x(PbActivity.this.getPageContext(), PbActivity.this.cYT);
                                                                                                                                PbActivity.this.feO.bg(PbActivity.this.feU.getView());
                                                                                                                                PbActivity.this.feU.jQ(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.feU.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12006").ac("tid", PbActivity.this.feN.fjV));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view2.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.feU.aYV().setTag(sparseArray2);
                                                                                                                            PbActivity.this.feU.aZa().setTag(view2.getTag());
                                                                                                                            PbActivity.this.feU.jS(z6);
                                                                                                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                                                                                                            boolean booleanValue = ((Boolean) sparseArray3.get(d.g.tag_should_manage_visible)).booleanValue();
                                                                                                                            boolean booleanValue2 = ((Boolean) sparseArray3.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                                                            boolean booleanValue3 = ((Boolean) sparseArray3.get(d.g.tag_should_delete_visible)).booleanValue();
                                                                                                                            if (!(sparseArray3.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                z2 = false;
                                                                                                                            } else {
                                                                                                                                z2 = ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue();
                                                                                                                            }
                                                                                                                            String str2 = null;
                                                                                                                            if (sparseArray3.get(d.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                str2 = (String) sparseArray3.get(d.g.tag_forbid_user_post_id);
                                                                                                                            }
                                                                                                                            if (booleanValue) {
                                                                                                                                SparseArray sparseArray4 = new SparseArray();
                                                                                                                                sparseArray4.put(d.g.tag_should_manage_visible, true);
                                                                                                                                sparseArray4.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray4.put(d.g.tag_forbid_user_name, sparseArray3.get(d.g.tag_forbid_user_name));
                                                                                                                                sparseArray4.put(d.g.tag_forbid_user_post_id, str2);
                                                                                                                                if (booleanValue2) {
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_visible, true);
                                                                                                                                    sparseArray4.put(d.g.tag_is_mem, sparseArray3.get(d.g.tag_is_mem));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_mute_userid, sparseArray3.get(d.g.tag_user_mute_mute_userid));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_mute_username, sparseArray3.get(d.g.tag_user_mute_mute_username));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_post_id, sparseArray3.get(d.g.tag_user_mute_post_id));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_thread_id, sparseArray3.get(d.g.tag_user_mute_thread_id));
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_visible, false);
                                                                                                                                }
                                                                                                                                if (booleanValue3) {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, true);
                                                                                                                                    sparseArray4.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                    sparseArray4.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                    sparseArray4.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                    PbActivity.this.feU.aYY().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.feU.aYY().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.feU.aYW().setTag(sparseArray4);
                                                                                                                                PbActivity.this.feU.aYY().setTag(sparseArray4);
                                                                                                                                PbActivity.this.feU.aYW().setText(d.k.bar_manager);
                                                                                                                                PbActivity.this.feU.aYW().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.feU.aYW().setVisibility(8);
                                                                                                                                PbActivity.this.feU.aYY().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.feU.aYW().setTag(sparseArray5);
                                                                                                                                PbActivity.this.feU.aYY().setTag(sparseArray5);
                                                                                                                                PbActivity.this.feU.aYW().setText(d.k.delete);
                                                                                                                                PbActivity.this.feU.aYY().setVisibility(0);
                                                                                                                                if (PbActivity.this.feN.getPbData().aVE() != 1002 || z2) {
                                                                                                                                    PbActivity.this.feU.aYY().setText(d.k.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.feU.aYY().setText(d.k.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.feU.aYW().setVisibility(8);
                                                                                                                            }
                                                                                                                            SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                                                                            if (!(sparseArray6.get(d.g.tag_user_mute_visible) instanceof Boolean)) {
                                                                                                                                z3 = false;
                                                                                                                            } else {
                                                                                                                                z3 = ((Boolean) sparseArray6.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                                                            }
                                                                                                                            if (!((Boolean) sparseArray6.get(d.g.tag_should_manage_visible)).booleanValue() && z3) {
                                                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_visible, true);
                                                                                                                                sparseArray7.put(d.g.tag_is_mem, sparseArray6.get(d.g.tag_is_mem));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_mute_userid, sparseArray6.get(d.g.tag_user_mute_mute_userid));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_mute_username, sparseArray6.get(d.g.tag_user_mute_mute_username));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_post_id, sparseArray6.get(d.g.tag_user_mute_post_id));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_thread_id, sparseArray6.get(d.g.tag_user_mute_thread_id));
                                                                                                                                sparseArray7.put(d.g.tag_del_post_is_self, sparseArray6.get(d.g.tag_del_post_is_self));
                                                                                                                                sparseArray7.put(d.g.tag_del_post_type, sparseArray6.get(d.g.tag_del_post_type));
                                                                                                                                sparseArray7.put(d.g.tag_del_post_id, sparseArray6.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray7.put(d.g.tag_manage_user_identity, sparseArray6.get(d.g.tag_manage_user_identity));
                                                                                                                                PbActivity.this.feU.aYX().setTag(sparseArray7);
                                                                                                                                PbActivity.this.feU.aYX().setVisibility(0);
                                                                                                                                PbActivity.this.feU.aYW().setVisibility(8);
                                                                                                                                PbActivity.this.feU.aYX().setText(d.k.mute_option);
                                                                                                                            } else {
                                                                                                                                if (!(sparseArray6.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                    z4 = false;
                                                                                                                                } else {
                                                                                                                                    z4 = ((Boolean) sparseArray6.get(d.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                }
                                                                                                                                String str3 = null;
                                                                                                                                if (sparseArray6.get(d.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                    str3 = (String) sparseArray6.get(d.g.tag_forbid_user_post_id);
                                                                                                                                }
                                                                                                                                boolean jx = PbActivity.this.jx(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.ffW = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (ar.j(PbActivity.this.ffW) ? false : jx) {
                                                                                                                                    PbActivity.this.feU.aYX().setVisibility(0);
                                                                                                                                    PbActivity.this.feU.aYX().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.feU.aYX().setVisibility(8);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            SparseArray sparseArray8 = (SparseArray) view2.getTag();
                                                                                                                            long j = 0;
                                                                                                                            if (!(sparseArray8.get(d.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                z5 = false;
                                                                                                                            } else {
                                                                                                                                z5 = ((Boolean) sparseArray8.get(d.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                            }
                                                                                                                            if (sparseArray8.get(d.g.tag_chudian_template_id) instanceof Long) {
                                                                                                                                j = ((Long) sparseArray8.get(d.g.tag_chudian_template_id)).longValue();
                                                                                                                            }
                                                                                                                            if (!(sparseArray8.get(d.g.tag_chudian_monitor_id) instanceof String)) {
                                                                                                                                str = "";
                                                                                                                            } else {
                                                                                                                                str = (String) sparseArray8.get(d.g.tag_chudian_monitor_id);
                                                                                                                            }
                                                                                                                            if (!(sparseArray8.get(d.g.tag_chudian_hide_day) instanceof Integer)) {
                                                                                                                                i = 0;
                                                                                                                            } else {
                                                                                                                                i = ((Integer) sparseArray8.get(d.g.tag_chudian_hide_day)).intValue();
                                                                                                                            }
                                                                                                                            if (z5) {
                                                                                                                                PbActivity.this.feU.aYZ().setVisibility(0);
                                                                                                                                PbActivity.this.feU.aYZ().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.feU.aYZ().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.feU.aYZ().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.feU.aYZ().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.feN.getPbData().oI()) {
                                                                                                                            String oH = PbActivity.this.feN.getPbData().oH();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(oH) && oH.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.feU.aYV().setText(d.k.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.feU.aYV().setText(d.k.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.feU.jR(true);
                                                                                                                                PbActivity.this.feU.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.feU.jR(true);
                                                                                                                        PbActivity.this.feU.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVs() != null && PbActivity.this.feN.getPbData().aVs().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.M(PbActivity.this.getActivity(), PbActivity.this.feN.getPbData().aVs().getActUrl());
                                                                                                                        if (PbActivity.this.feN.getPbData().aVs().ss() != 1) {
                                                                                                                            if (PbActivity.this.feN.getPbData().aVs().ss() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view2.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view2.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10912").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getPbData().getForumId()).ac("tid", PbActivity.this.feN.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.feN.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.feO.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (az.aK(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.k.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view2.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.feO.aZI();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view2 != null) {
                                                                                                                        com.baidu.tbadk.browser.a.M(PbActivity.this.getActivity(), (String) view2.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aWU() == 1 && PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10397").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getPbData().getForumId()).ac("tid", PbActivity.this.feN.getPbData().getThreadId()).ac("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view2 != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.M(PbActivity.this.getActivity(), (String) view2.getTag());
                                                                                                                        if (PbActivity.this.aWU() == 1 && PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10507").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getPbData().getForumId()).ac("tid", PbActivity.this.feN.getPbData().getThreadId()).ac("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.aXm();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.aXn();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVK() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.feN.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11679").ac(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.ax.wg().c(PbActivity.this.getPageContext(), new String[]{pbData2.aVK().aVT()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVK() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.feN.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11678").ac(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.ax.wg().c(PbActivity.this.getPageContext(), new String[]{pbData3.aVK().aVT()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.feO.fnY.bbi() != null && view2 == PbActivity.this.feO.fnY.bbi().aZo()) {
                                                                                                                    if (PbActivity.this.feN == null || PbActivity.this.feN.getPbData() == null || PbActivity.this.feN.getPbData().aVs() == null) {
                                                                                                                        PbActivity.this.feO.fnY.pr();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.hg()) {
                                                                                                                        PbActivity.this.showToast(d.k.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.feN.getPbData().aVs().rB() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.feN.aYj(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.k.haved_fans_called)).tL();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12399").r("obj_locate", PbActivity.this.ac(PbActivity.this.feN.getPbData().aVs())).ac("tid", PbActivity.this.feN.getPbData().aVs().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.ffo >= 0) {
                                                                                                                        if (PbActivity.this.feN != null) {
                                                                                                                            PbActivity.this.feN.aYQ();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.feO.aZY() != null) {
                                                                                                                            PbActivity.this.feO.aZY().a(PbActivity.this.feN.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.feO.getListView().setSelection(PbActivity.this.feN.aYT());
                                                                                                                        PbActivity.this.ffo = 0;
                                                                                                                        if (PbActivity.this.feN != null) {
                                                                                                                            PbActivity.this.feN.bp(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.feO.baM();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view2.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view2.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.feN.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.feN.aYj(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.feN.getPbData().aVs().sj())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.feN.getPbData() != null) {
                                                                                                            PbActivity.this.feO.bar();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view2.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view3 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view3 != null) {
                                                                                                                if (postData3.bsn() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12630"));
                                                                                                                }
                                                                                                                String aYj = PbActivity.this.feN.aYj();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.feN.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.feN.getPbData().aVE();
                                                                                                                }
                                                                                                                PbActivity.this.apC();
                                                                                                                if (view2.getId() == d.g.replybtn) {
                                                                                                                    c qv = PbActivity.this.qv(id2);
                                                                                                                    if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && qv != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aYj, id2, "pb", true, null, true, null, i3, postData3.bbZ(), PbActivity.this.feN.getPbData().qT(), false, postData3.rQ().getIconInfo()).addBigImageData(qv.fgG, qv.fgH, qv.fgI, qv.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.feN.aYP());
                                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (view2.getId() == d.g.sub_pb_item) {
                                                                                                                    SparseArray sparseArray10 = (SparseArray) view2.getTag();
                                                                                                                    String str5 = (String) sparseArray10.get(d.g.tag_photo_username);
                                                                                                                    String str6 = (String) sparseArray9.get(d.g.tag_photo_userid);
                                                                                                                    PostData postData4 = (PostData) sparseArray10.get(d.g.tag_load_sub_data);
                                                                                                                    String str7 = null;
                                                                                                                    if (postData4 != null) {
                                                                                                                        str7 = postData4.getId();
                                                                                                                    }
                                                                                                                    TiebaStatic.log("c11741");
                                                                                                                    c qv2 = PbActivity.this.qv(id2);
                                                                                                                    if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && qv2 != null && PbActivity.this.aWO().aZG() != null) {
                                                                                                                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                                                        kVar.a(PbActivity.this.feN.getPbData().aVq());
                                                                                                                        kVar.T(PbActivity.this.feN.getPbData().aVs());
                                                                                                                        kVar.d(postData4);
                                                                                                                        PbActivity.this.aWO().aZG().d(kVar);
                                                                                                                        PbActivity.this.aWO().aZG().setPostId(str7);
                                                                                                                        PbActivity.this.b(view2, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c qv3 = PbActivity.this.qv(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && qv3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aYj, id2, "pb", true, null, false, null, i3, postData3.bbZ(), PbActivity.this.feN.getPbData().qT(), false, postData3.rQ().getIconInfo()).addBigImageData(qv3.fgG, qv3.fgH, qv3.fgI, qv3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.feN.aYP());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10517").r("obj_locate", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.gP()) {
                                                                                                    PbActivity.this.feO.bar();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.feO.c(PbActivity.this.feN.getPbData(), PbActivity.this.feN.aYk(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.feN.getPbData().aVq().getId(), PbActivity.this.feN.getPbData().aVq().getName(), PbActivity.this.feN.getPbData().aVs().getId(), String.valueOf(PbActivity.this.feN.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    PbActivity.this.showToast(d.k.network_not_available);
                                                                                                    return;
                                                                                                }
                                                                                            } else if (!com.baidu.adp.lib.util.j.gP()) {
                                                                                                PbActivity.this.showToast(d.k.network_not_available);
                                                                                                return;
                                                                                            } else {
                                                                                                SparseArray<Object> sparseArray11 = (SparseArray) view2.getTag();
                                                                                                if (sparseArray11 != null) {
                                                                                                    if (!com.baidu.tieba.c.a.aeW() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.feN.aYj(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
                                                                                                        boolean booleanValue4 = ((Boolean) sparseArray11.get(d.g.tag_should_manage_visible)).booleanValue();
                                                                                                        boolean booleanValue5 = ((Boolean) sparseArray11.get(d.g.tag_should_delete_visible)).booleanValue();
                                                                                                        boolean booleanValue6 = ((Boolean) sparseArray11.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                                        if (booleanValue4) {
                                                                                                            if (booleanValue6) {
                                                                                                                sparseArray11.put(d.g.tag_from, 1);
                                                                                                                sparseArray11.put(d.g.tag_check_mute_from, 2);
                                                                                                                PbActivity.this.b(sparseArray11);
                                                                                                            } else {
                                                                                                                sparseArray11.put(d.g.tag_check_mute_from, 2);
                                                                                                                PbActivity.this.feO.be(view2);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.feO.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.aWK();
                                                                                        }
                                                                                    } else {
                                                                                        long j2 = -1;
                                                                                        String str8 = "";
                                                                                        int i4 = 0;
                                                                                        if (view2.getTag(d.g.tag_chudian_template_id) instanceof Long) {
                                                                                            j2 = ((Long) view2.getTag(d.g.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (view2.getTag(d.g.tag_chudian_monitor_id) instanceof String) {
                                                                                            str8 = (String) view2.getTag(d.g.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (view2.getTag(d.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                            i4 = ((Integer) view2.getTag(d.g.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.feN.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aVq() != null) {
                                                                                            str9 = pbData4.aVq().getId();
                                                                                            str10 = pbData4.aVq().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.a.a(j2, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j2, str8, str9, str10, str11, i4);
                                                                                    }
                                                                                } else {
                                                                                    SparseArray sparseArray12 = (SparseArray) view2.getTag();
                                                                                    if (sparseArray12 != null) {
                                                                                        if ((sparseArray12.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_id) instanceof String) && (sparseArray12.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                            boolean booleanValue7 = ((Boolean) sparseArray12.get(d.g.tag_del_post_is_self)).booleanValue();
                                                                                            int intValue = ((Integer) sparseArray12.get(d.g.tag_manage_user_identity)).intValue();
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.feN.aYj(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.feO.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.feU.aZc()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12007").ac("tid", PbActivity.this.feN.fjV));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.feN.getPbData() != null) {
                                                                                    PbActivity.this.feO.bar();
                                                                                    if (!(view2.getTag() instanceof SparseArray)) {
                                                                                        sparseArray = null;
                                                                                    } else {
                                                                                        sparseArray = (SparseArray) view2.getTag();
                                                                                    }
                                                                                    if (sparseArray == null || !(sparseArray.get(d.g.tag_load_sub_data) instanceof PostData)) {
                                                                                        postData = null;
                                                                                    } else {
                                                                                        postData = (PostData) sparseArray.get(d.g.tag_load_sub_data);
                                                                                    }
                                                                                    if (postData != null) {
                                                                                        String aYj2 = PbActivity.this.feN.aYj();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.feN.getPbData() != null) {
                                                                                            i5 = PbActivity.this.feN.getPbData().aVE();
                                                                                        }
                                                                                        PbActivity.this.apC();
                                                                                        c qv4 = PbActivity.this.qv(id3);
                                                                                        if (qv4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aYj2, id3, "pb", true, null, true, null, i5, postData.bbZ(), PbActivity.this.feN.getPbData().qT(), false, postData.rQ().getIconInfo()).addBigImageData(qv4.fgG, qv4.fgH, qv4.fgI, qv4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.feN.aYP());
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
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11739").r("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.aX(view2);
                                                                                if (PbActivity.this.feN.getPbData().aVs() != null && PbActivity.this.feN.getPbData().aVs().rQ() != null && PbActivity.this.feN.getPbData().aVs().rQ().getUserId() != null && PbActivity.this.eGw != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12526").ac("tid", PbActivity.this.feN.fjV).r("obj_locate", 2).ac(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.feN.getPbData().aVs().rQ().getUserId()).r("obj_type", PbActivity.this.eGw.oI() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.feN.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11739").r("obj_locate", 4));
                                                                        if (!com.baidu.adp.lib.util.j.gP()) {
                                                                            PbActivity.this.showToast(d.k.network_not_available);
                                                                            return;
                                                                        }
                                                                        Object tag = view2.getTag();
                                                                        if (tag instanceof String) {
                                                                            PbActivity.this.qs((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            SparseArray<Object> sparseArray13 = (SparseArray) tag;
                                                                            if ((sparseArray13.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray13.get(d.g.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray13.put(d.g.tag_from, 0);
                                                                                sparseArray13.put(d.g.tag_check_mute_from, 2);
                                                                                PbActivity.this.b(sparseArray13);
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10647").r("obj_type", 0).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10647").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.feO.fnY.bbh();
                                                                }
                                                            } else if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVs() != null) {
                                                                PbActivity.this.feO.fnY.pr();
                                                                PbActivity.this.qs(PbActivity.this.feN.getPbData().aVs().sg());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.feO.bar();
                                                            if (com.baidu.adp.lib.util.j.gP()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view2.setTag(Boolean.valueOf(PbActivity.this.feN.aYx()));
                                                                    return;
                                                                }
                                                                PbActivity.this.qf(2);
                                                                PbActivity.this.apC();
                                                                PbActivity.this.feO.bac();
                                                                boolean aYw = PbActivity.this.feN.aYw();
                                                                view2.setTag(Boolean.valueOf(PbActivity.this.feN.aYx()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.feO.fnY != null && PbActivity.this.feO.fnY.bbi() != null && view2 == PbActivity.this.feO.fnY.bbi().aZm()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view2.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (aYw) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.feO.kb(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.k.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.feO.bar();
                                                        if (PbActivity.this.feN.azo() != null) {
                                                            PbActivity.this.feO.a(PbActivity.this.feN.azo(), PbActivity.this.eTi);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.ap.fz() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.feN != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12386").ac("tid", PbActivity.this.feN.aYj()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.hg()) {
                                                        if (PbActivity.this.feN.getPbData() != null) {
                                                            ArrayList<PostData> aVu2 = PbActivity.this.feN.getPbData().aVu();
                                                            if ((aVu2 != null && aVu2.size() > 0) || !PbActivity.this.feN.aYk()) {
                                                                PbActivity.this.feO.bar();
                                                                PbActivity.this.apC();
                                                                PbActivity.this.qf(2);
                                                                if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVK() != null && !StringUtils.isNull(PbActivity.this.feN.getPbData().aVK().qG(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11678").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11939"));
                                                                if (com.baidu.tbadk.o.ap.fz()) {
                                                                    PbActivity.this.qg(2);
                                                                } else {
                                                                    PbActivity.this.feO.showLoadingDialog();
                                                                    PbActivity.this.feN.aYK().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                }
                                                            } else {
                                                                com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        PbActivity.this.showToast(d.k.neterror);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.feO.fnY.pr();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.gP()) {
                                            PbActivity.this.feO.bar();
                                            if (PbActivity.this.feO.fnY.bbi() != null && view2 == PbActivity.this.feO.fnY.bbi().aZg() && !PbActivity.this.feO.baJ()) {
                                                PbActivity.this.feO.aZI();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.apC();
                                                PbActivity.this.feO.bac();
                                                if (view2.getId() == d.g.floor_owner_reply) {
                                                    l = PbActivity.this.feN.l(true, PbActivity.this.aXk());
                                                } else {
                                                    l = view2.getId() == d.g.reply_title ? PbActivity.this.feN.l(false, PbActivity.this.aXk()) : PbActivity.this.feN.qw(PbActivity.this.aXk());
                                                }
                                                view2.setTag(Boolean.valueOf(l));
                                                if (l) {
                                                    PbActivity.this.feO.jG(true);
                                                    PbActivity.this.feO.aFf();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.feO.kb(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.qf(2);
                                            } else {
                                                view2.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.k.network_not_available);
                                            view2.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.gP()) {
                                        PbActivity.this.feO.bar();
                                        if (PbActivity.this.qe(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.feN.qs(PbActivity.this.feO.bah()) != null) {
                                            PbActivity.this.aXe();
                                            if (PbActivity.this.feN.getPbData().aVs() != null && PbActivity.this.feN.getPbData().aVs().rQ() != null && PbActivity.this.feN.getPbData().aVs().rQ().getUserId() != null && PbActivity.this.eGw != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12526").ac("tid", PbActivity.this.feN.fjV).r("obj_locate", 1).ac(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.feN.getPbData().aVs().rQ().getUserId()).r("obj_type", PbActivity.this.eGw.oI() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.feN.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.k.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.gP()) {
                                    PbActivity.this.feO.jG(true);
                                    PbActivity.this.feO.aZI();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.feO.aFf();
                                        PbActivity.this.apC();
                                        PbActivity.this.feO.bac();
                                        PbActivity.this.feN.qw(PbActivity.this.aXk());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.qf(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(d.k.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVs() != null && PbActivity.this.feN.getPbData().aVs().sB() && PbActivity.this.feN.getPbData().aVs().sh() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11922"));
                                }
                                if (PbActivity.this.feN.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.feN.aYi()) && PbActivity.this.feN.getAppealInfo() != null) {
                                        name = PbActivity.this.feN.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.feN.getPbData().aVq().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aYi = PbActivity.this.feN.aYi();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.feN.aYl() && aYi != null && aYi.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.gP()) {
                            if (PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVE() == 1 && !PbActivity.this.cpH.bsK()) {
                                PbActivity.this.feO.bar();
                                int i6 = 0;
                                if (PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aZh()) {
                                    if (PbActivity.this.feO.fnY.bbi() == null || view2 != PbActivity.this.feO.fnY.bbi().aZj()) {
                                        if (view2 == PbActivity.this.feO.baa()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.feN.getPbData().aVs().rM() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.feN.getPbData().aVs().rL() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aVq = PbActivity.this.feN.getPbData().aVq();
                                String name2 = aVq.getName();
                                String id4 = aVq.getId();
                                String id5 = PbActivity.this.feN.getPbData().aVs().getId();
                                if (!com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.feO.aZZ();
                                    PbActivity.this.cpH.a(id4, name2, id5, i6, PbActivity.this.feO.bab());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.k.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.gP()) {
                        PbActivity.this.feO.bar();
                        PbActivity.this.apC();
                        PbActivity.this.feO.bac();
                        PbActivity.this.feO.showLoadingDialog();
                        if (PbActivity.this.feO.aZP() != null) {
                            PbActivity.this.feO.aZP().setVisibility(8);
                        }
                        PbActivity.this.feN.qn(1);
                        if (PbActivity.this.feu != null) {
                            PbActivity.this.feu.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.k.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.k.pb_god_reply_title_tag).equals(view2.getTag()) && view2.getId() == d.g.reply_god_title_group) {
                        String aWR = PbActivity.this.aWR();
                        if (!TextUtils.isEmpty(aWR)) {
                            com.baidu.tbadk.core.util.ax.wg().c(PbActivity.this.getPageContext(), new String[]{aWR});
                        }
                    }
                } else if (PbActivity.this.feE) {
                    PbActivity.this.feE = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.aWO().aZG() != null && postData5.rQ() != null && postData5.brZ() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.aWO().aZH() != null) {
                                    PbActivity.this.aWO().aZH().aXV();
                                }
                                com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                                kVar2.a(PbActivity.this.feN.getPbData().aVq());
                                kVar2.T(PbActivity.this.feN.getPbData().aVs());
                                kVar2.d(postData5);
                                PbActivity.this.aWO().aZG().d(kVar2);
                                PbActivity.this.aWO().aZG().setPostId(postData5.getId());
                                PbActivity.this.b(view2, postData5.rQ().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.ffb != null) {
                                    PbActivity.this.feO.kl(PbActivity.this.ffb.Ek());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.apC();
            PbActivity.this.feO.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ag.Hr() && PbActivity.this.aWx() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aWx().qz(postWriteCallBackData.getPostId());
                    PbActivity.this.ffo = PbActivity.this.feO.aZL();
                    if (PbActivity.this.feN != null) {
                        PbActivity.this.feN.bp(PbActivity.this.ffo, PbActivity.this.feO.aZM());
                    }
                }
                PbActivity.this.feO.bar();
                PbActivity.this.feT.baP();
                if (PbActivity.this.ffb != null) {
                    PbActivity.this.feO.kl(PbActivity.this.ffb.Ek());
                }
                PbActivity.this.feO.aZF();
                PbActivity.this.feO.kn(true);
                PbActivity.this.feN.aYz();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.feN.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.feN.getPbData();
                            if (pbData != null && pbData.aVs() != null && pbData.aVs().rQ() != null && (userId = pbData.aVs().rQ().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ag.Hr() && PbActivity.this.feN.aYs()) {
                                PbActivity.this.feO.bac();
                            }
                        } else if (!com.baidu.tbadk.o.ag.Hr() && PbActivity.this.feN.aYs()) {
                            PbActivity.this.feO.bac();
                        }
                    } else if (floor != null) {
                        PbActivity.this.feO.n(PbActivity.this.feN.getPbData());
                    }
                    if (PbActivity.this.feN.aYo()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10369").ac("tid", PbActivity.this.feN.aYj()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.ffb.Eq() || PbActivity.this.ffb.Er()) {
                    PbActivity.this.ffb.a(false, postWriteCallBackData);
                }
                PbActivity.this.feT.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.enV != null) {
                    PbActivity.this.enV.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (tVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d ffN = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.feT != null) {
                    PbActivity.this.feT.baO();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.enV != null) {
                    PbActivity.this.enV.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.feT != null) {
                if (PbActivity.this.feO != null && PbActivity.this.feO.aZH() != null && PbActivity.this.feO.aZH().aYa() != null && PbActivity.this.feO.aZH().aYa().Er()) {
                    PbActivity.this.feO.aZH().aYa().a(postWriteCallBackData);
                }
                PbActivity.this.feT.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a ffO = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g eE;
            if (!z || dVar == null || dVar.aVC() != null || com.baidu.tbadk.core.util.v.v(dVar.aVu()) >= 1) {
                PbActivity.this.eJt = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.feO.bae();
                if (dVar == null || !dVar.aVy()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.feO.getView());
                }
                PbActivity.this.feO.aFe();
                if (PbActivity.this.isFullScreen || PbActivity.this.feO.baJ()) {
                    PbActivity.this.feO.baA();
                } else if (!PbActivity.this.feO.bax()) {
                    PbActivity.this.feO.kn(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.feV = true;
                }
                if (z && dVar != null) {
                    PbActivity.this.feO.showListView();
                    if (dVar.aVs() != null && dVar.aVs().sI() != null) {
                        PbActivity.this.a(dVar.aVs().sI());
                    }
                    PbActivity.this.aWL();
                    if (PbActivity.this.ffb != null) {
                        PbActivity.this.feO.kl(PbActivity.this.ffb.Ek());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.aVu() != null && dVar.aVu().size() >= 1 && dVar.aVu().get(0) != null) {
                        PbActivity.this.feN.qy(dVar.aVu().get(0).getId());
                    } else if (dVar.aVC() != null) {
                        PbActivity.this.feN.qy(dVar.aVC().getId());
                    }
                    if (PbActivity.this.ffb != null) {
                        PbActivity.this.ffb.a(dVar.qT());
                        PbActivity.this.ffb.a(dVar.aVq(), dVar.getUserData());
                        PbActivity.this.ffb.a(PbActivity.this.feN.aYt(), PbActivity.this.feN.aYj(), PbActivity.this.feN.aYM());
                        if (dVar.aVs() != null) {
                            PbActivity.this.ffb.bE(dVar.aVs().sY());
                        }
                    }
                    if (PbActivity.this.eGw != null) {
                        PbActivity.this.eGw.ae(dVar.oI());
                    }
                    if (dVar == null || dVar.aVF() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.feO.km(PbActivity.this.mIsFromCDN);
                    PbActivity.this.feO.a(dVar, i2, i3, PbActivity.this.feN.aYk(), i4, PbActivity.this.feN.getIsFromMark());
                    PbActivity.this.feO.d(dVar, PbActivity.this.feN.aYk());
                    PbActivity.this.feO.kj(PbActivity.this.feN.getHostMode());
                    AntiData qT = dVar.qT();
                    if (qT != null) {
                        PbActivity.this.aEA = qT.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aEA) && PbActivity.this.ffb != null && PbActivity.this.ffb.DF() != null && (eE = PbActivity.this.ffb.DF().eE(6)) != null && !TextUtils.isEmpty(PbActivity.this.aEA)) {
                            ((View) eE).setOnClickListener(PbActivity.this.aFk);
                        }
                    }
                    if (PbActivity.this.feX) {
                        PbActivity.this.feX = false;
                        final int aWZ = PbActivity.this.aWZ();
                        if (dVar.aVP()) {
                            final int af = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.xj() != null) {
                                        PbActivity.this.xj().setSelectionFromTop(aWZ, af);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.aWO().qy(aWZ);
                        }
                    }
                    if (PbActivity.this.feY) {
                        PbActivity.this.feY = false;
                        final int aWZ2 = PbActivity.this.aWZ();
                        final boolean z2 = aWZ2 != -1;
                        if (!z2) {
                            aWZ2 = PbActivity.this.aXa();
                        }
                        if (PbActivity.this.aWO() != null) {
                            if (dVar.aVP()) {
                                final int af2 = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (aWZ2 != -1 && PbActivity.this.xj() != null) {
                                            if (z2) {
                                                PbActivity.this.xj().setSelectionFromTop(aWZ2, af2);
                                            } else {
                                                PbActivity.this.xj().setSelectionFromTop(aWZ2 - 1, af2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.aWO().qy(aWZ2);
                            }
                        }
                    } else {
                        PbActivity.this.feO.bai();
                    }
                    PbActivity.this.feN.a(dVar.aVq(), PbActivity.this.ffB);
                    PbActivity.this.feN.a(PbActivity.this.ffC);
                    if (PbActivity.this.enV != null && dVar.aVs() != null && dVar.aVs().rQ() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.aVs().rQ());
                        PbActivity.this.enV.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.feV && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.feN != null && PbActivity.this.feN.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.feN.getAppealInfo().fbN)) {
                                    PbActivity.this.feO.a(PbActivity.this.feN.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.feO.getView(), PbActivity.this.getPageContext().getResources().getString(d.k.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.feO.getView(), PbActivity.this.getPageContext().getResources().getString(d.k.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.feO.baA();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.feN.aYj());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.i iVar = new com.baidu.tbadk.core.util.i();
                        iVar.setOpType("2");
                        iVar.start();
                    }
                    if (i != -1) {
                        PbActivity.this.feO.qC(PbActivity.this.getResources().getString(d.k.list_no_more_new));
                    } else {
                        PbActivity.this.feO.qC("");
                    }
                    PbActivity.this.feO.wS();
                }
                PbActivity.this.aKV = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aWx().aYk() || PbActivity.this.aWx().getPbData().rg().rd() != 0 || PbActivity.this.aWx().aYF()) {
                    PbActivity.this.ffc = true;
                    return;
                }
                return;
            }
            PbActivity.this.feN.qn(1);
            if (PbActivity.this.feu != null) {
                PbActivity.this.feu.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.feO.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.p.Ha().Hb()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.cHR : j;
                com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, PbActivity.this.aKN, PbActivity.this.createTime, PbActivity.this.aKV, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aKN = 0L;
                if (lVar != null) {
                    lVar.GT();
                }
                if (!z2 && com.baidu.tbadk.core.util.an.equals(PbActivity.this.feH, PbActivityConfig.KEY_FROM_PERSONALIZE) && PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVs() != null) {
                    int threadType = PbActivity.this.feN.getPbData().aVs().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        com.baidu.tbadk.k.g gVar = new com.baidu.tbadk.k.g();
                        gVar.pageType = 1;
                        gVar.fi(1005);
                        gVar.aLi = currentTimeMillis;
                        gVar.fj(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener ffP = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.aWV();
            }
        }
    };
    private final a.InterfaceC0082a ffQ = new a.InterfaceC0082a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0082a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.feO.bae();
            if (z) {
                if (PbActivity.this.eGw != null) {
                    PbActivity.this.eGw.ae(z2);
                }
                PbActivity.this.feN.jO(z2);
                if (PbActivity.this.feN.oI()) {
                    PbActivity.this.aXf();
                } else {
                    PbActivity.this.feO.n(PbActivity.this.feN.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.eGw != null && PbActivity.this.eGw.oL() != null && PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVs() != null && PbActivity.this.feN.getPbData().aVs().rQ() != null) {
                        MarkData oL = PbActivity.this.eGw.oL();
                        MetaData rQ = PbActivity.this.feN.getPbData().aVs().rQ();
                        if (oL != null && rQ != null) {
                            if (!com.baidu.tbadk.core.util.an.equals(TbadkCoreApplication.getCurrentAccount(), rQ.getUserId()) && !rQ.hadConcerned()) {
                                PbActivity.this.b(rQ);
                                return;
                            } else {
                                PbActivity.this.showToast(d.k.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.k.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.k.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.k.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.qb(PbActivity.this.mLastScrollState) && PbActivity.this.qb(i)) {
                if (PbActivity.this.feO != null) {
                    PbActivity.this.feO.bar();
                    if (PbActivity.this.ffb != null && !PbActivity.this.feO.aZJ()) {
                        PbActivity.this.feO.kl(PbActivity.this.ffb.Ek());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.feO.aZI();
                    }
                }
                if (!PbActivity.this.feB) {
                    PbActivity.this.feB = true;
                    PbActivity.this.feO.baw();
                }
            }
            PbActivity.this.feO.onScrollStateChanged(absListView, i);
            if (PbActivity.this.feu != null) {
                PbActivity.this.feu.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.feC == null) {
                PbActivity.this.feC = new com.baidu.tbadk.k.d();
                PbActivity.this.feC.fi(1001);
            }
            if (i == 0) {
                PbActivity.this.feC.GF();
            } else if (i == 1) {
                PbActivity.this.feC.GF();
            } else {
                PbActivity.this.feC.GF();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aVu;
            if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feO != null && PbActivity.this.feO.aZY() != null) {
                PbActivity.this.feO.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.feu != null) {
                    PbActivity.this.feu.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.feN.aYB() && (aVu = PbActivity.this.feN.getPbData().aVu()) != null && !aVu.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.feO.aZY().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.feN.getPbData();
                    if (pbData != null) {
                        if (pbData.aVv() != null && pbData.aVv().hasData()) {
                            headerCount--;
                        }
                        if (pbData.aVw() != null && pbData.aVw().hasData()) {
                            headerCount--;
                        }
                        int size = aVu.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cpL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cpH.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.feN.aYz();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fuJ != 1002 || bVar.dxu) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.feO.a(1, dVar.yR, dVar.gyO, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cpH.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.feO.a(PbActivity.this.cpH.getLoadDataMode(), gVar.yR, gVar.gyO, false);
                        PbActivity.this.feO.ao(gVar.gyR);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.feO.a(PbActivity.this.cpH.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d ffR = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final e.b bfj = new e.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            if (PbActivity.this.aXl()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.feN.jN(true)) {
                PbActivity.this.feO.baf();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e ffT = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.ffS && PbActivity.this.aXl()) {
                PbActivity.this.aXn();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.feN.jM(false)) {
                    PbActivity.this.feO.bad();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.feN.getPbData() != null) {
                    PbActivity.this.feO.bav();
                }
                PbActivity.this.ffS = true;
            }
        }
    };
    private int ffU = 0;
    private final TbRichTextView.h aWw = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view2, String str, int i, boolean z) {
            try {
                if ((view2.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.feO.b((TbRichText) view2.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view2.getTag(d.g.tag_rich_text_meme_info) != null && (view2.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(d.g.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view2).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    PbActivity.this.feL = view2;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fgJ) {
                    TbRichText aB = PbActivity.this.aB(str, i);
                    if (aB != null && PbActivity.this.ffU >= 0 && PbActivity.this.ffU < aB.JJ().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aB.JJ().get(PbActivity.this.ffU));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fgG.size()) {
                                break;
                            } else if (!cVar.fgG.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.w(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fgH.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fgI, cVar.lastId, PbActivity.this.feN.aYx(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.fgG, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.w(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fgH.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fgI, cVar.fgG.get(0), PbActivity.this.feN.aYx(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean ffV = false;
    PostData ffW = null;
    private final b.InterfaceC0086b ffX = new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
            bVar.dismiss();
            if (PbActivity.this.ffW != null) {
                if (i == 0) {
                    PbActivity.this.ffW.bY(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.ffW = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.e(PbActivity.this.ffW);
                }
            }
        }
    };
    private final b.InterfaceC0086b ffY = new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
            bVar.dismiss();
            if (PbActivity.this.ffl != null && !TextUtils.isEmpty(PbActivity.this.ffm)) {
                if (i == 0) {
                    if (PbActivity.this.ffn == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.ffm));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.ffm;
                        aVar.pkgId = PbActivity.this.ffn.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.ffn.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.baD == null) {
                        PbActivity.this.baD = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.baD.wu();
                    PbActivity.this.baD.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.baD.v(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.ffk == null) {
                            PbActivity.this.ffk = new aw(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.ffk.i(PbActivity.this.ffm, PbActivity.this.ffl.kp());
                    } else {
                        return;
                    }
                }
                PbActivity.this.ffl = null;
                PbActivity.this.ffm = null;
            }
        }
    };
    private final View.OnLongClickListener axW = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            SparseArray sparseArray;
            if (view2 instanceof TbImageView) {
                PbActivity.this.ffl = ((TbImageView) view2).getBdImage();
                PbActivity.this.ffm = ((TbImageView) view2).getUrl();
                if (PbActivity.this.ffl != null && !TextUtils.isEmpty(PbActivity.this.ffm)) {
                    if (view2.getTag(d.g.tag_rich_text_meme_info) == null || !(view2.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.ffn = null;
                    } else {
                        PbActivity.this.ffn = (TbRichTextMemeInfo) view2.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.feO.a(PbActivity.this.ffY, PbActivity.this.ffl.isGif());
                }
            } else if (view2 instanceof GifView) {
                if (((GifView) view2).getBdImage() != null) {
                    PbActivity.this.ffl = ((GifView) view2).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view2).getBdImage().getUrl())) {
                        PbActivity.this.ffm = ((GifView) view2).getBdImage().getUrl();
                    }
                    if (view2.getTag(d.g.tag_rich_text_meme_info) == null || !(view2.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.ffn = null;
                    } else {
                        PbActivity.this.ffn = (TbRichTextMemeInfo) view2.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.feO.a(PbActivity.this.ffY, PbActivity.this.ffl.isGif());
                }
            } else if (view2 instanceof TbMemeImageView) {
                if (((TbMemeImageView) view2).getBdImage() != null) {
                    PbActivity.this.ffl = ((TbMemeImageView) view2).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view2).getBdImage().getUrl())) {
                        PbActivity.this.ffm = ((TbMemeImageView) view2).getBdImage().getUrl();
                    }
                    if (view2.getTag(d.g.tag_rich_text_meme_info) == null || !(view2.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.ffn = null;
                    } else {
                        PbActivity.this.ffn = (TbRichTextMemeInfo) view2.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.feO.a(PbActivity.this.ffY, PbActivity.this.ffl.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.ffW = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.ffW != null && PbActivity.this.eGw != null) {
                        PbActivity.this.feO.a(PbActivity.this.ffX, PbActivity.this.eGw.oI() && PbActivity.this.ffW.getId() != null && PbActivity.this.ffW.getId().equals(PbActivity.this.feN.rZ()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a cVh = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!PbActivity.this.few && z && !PbActivity.this.feN.aYr()) {
                PbActivity.this.aXh();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener aNK = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag())) {
                    FrameLayout frameLayout2 = (FrameLayout) childAt;
                    if (frameLayout2.getChildCount() <= 0) {
                        break;
                    }
                    View childAt2 = frameLayout2.getChildAt(0);
                    if (frameLayout2 != null && (childAt2 instanceof PbMainFloorPraiseFloatingView) && ((PbMainFloorPraiseFloatingView) childAt2).anM()) {
                        break;
                    }
                }
            }
            PbActivity.this.byy.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0131a byz = new a.InterfaceC0131a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        final int can;

        {
            this.can = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void W(int i, int i2) {
            if (T(i2) && PbActivity.this.feO != null && PbActivity.this.feu != null) {
                PbActivity.this.feO.baB();
                PbActivity.this.feu.fB(false);
                PbActivity.this.feu.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void X(int i, int i2) {
            if (T(i2) && PbActivity.this.feO != null && PbActivity.this.feu != null) {
                PbActivity.this.feu.fB(true);
                if (Math.abs(i2) > this.can) {
                    PbActivity.this.feu.hideFloatingView();
                }
                if (PbActivity.this.aXl()) {
                    PbActivity.this.feO.aZU();
                    PbActivity.this.feO.aZV();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void Y(int i, int i2) {
        }

        private boolean T(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a ffZ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.f.b.a
        public void eW(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aWp();
            } else {
                com.baidu.tieba.pb.a.b.aWo();
            }
        }
    };
    private String fga = null;
    private final m.a fgb = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void h(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.k.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.k.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fga = str2;
                PbActivity.this.feO.qD(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fgc = -1;
    private int fgd = -1;
    private CustomMessageListener fgg = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Vf == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0084a) {
                    if (aVar.Vg != null && !aVar.Vg.hasError() && aVar.Vg.getError() == 0) {
                        if (PbActivity.this.feO != null) {
                            PbActivity.this.feO.z(((a.C0084a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aXw();
                        }
                    } else if (z) {
                        if (aVar.Vg != null && aVar.Vg.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Vg.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.k.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Vg != null && !aVar.Vg.hasError() && aVar.Vg.getError() == 0) {
                        if (PbActivity.this.feO != null && PbActivity.this.feO != null) {
                            PbActivity.this.feO.z(((a.C0084a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Vg != null && aVar.Vg.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Vg.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.k.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Vg == null || aVar.Vg.hasError() || aVar.Vg.getError() != 0) {
                        if (z) {
                            if (aVar.Vg != null && aVar.Vg.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Vg.getErrorString());
                            } else {
                                PbActivity.this.showToast(d.k.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.k.channel_need_push), 1).show();
                    }
                }
            }
        }
    };
    private final CustomMessageListener cYo = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11455").ac("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.ax.wg().c(PbActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void f(Object obj);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public ArrayList<String> fgG;
        public ConcurrentHashMap<String, ImageUrlData> fgH;
        public boolean fgJ;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fgI = false;
        public boolean fgK = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes2.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d aWJ() {
        return this.ffb;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        if (kVar.aWc() != null) {
            String id = kVar.aWc().getId();
            ArrayList<PostData> aVu = this.feN.getPbData().aVu();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aVu.size()) {
                    break;
                }
                PostData postData = aVu.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aWg = kVar.aWg();
                    postData.tn(kVar.getTotalCount());
                    if (postData.brW() != null && aWg != null) {
                        Iterator<PostData> it = aWg.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.rQ() != null && (metaData = postData.getUserMap().get(next.rQ().getUserId())) != null) {
                                next.a(metaData);
                                next.mq(true);
                                next.b(getPageContext(), this.feN.qx(metaData.getUserId()));
                            }
                        }
                        postData.brW().clear();
                        postData.brW().addAll(aWg);
                    }
                    if (postData.brS() != null) {
                        postData.brT();
                    }
                }
            }
            if (!this.feN.getIsFromMark()) {
                this.feO.n(this.feN.getPbData());
            }
            c(kVar);
        }
    }

    public void aWK() {
        com.baidu.tieba.pb.data.d pbData;
        bd aVs;
        if (!this.ffE) {
            if (!com.baidu.adp.lib.util.l.hg()) {
                showToast(d.k.no_network_guide);
            } else if (this.ffH) {
                this.ffE = true;
                if (this.feN != null && (pbData = this.feN.getPbData()) != null && (aVs = pbData.aVs()) != null) {
                    int isLike = aVs.rF() == null ? 0 : aVs.rF().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10796").ac("tid", aVs.getId()));
                    }
                    if (this.ffF != null) {
                        this.ffF.a(aVs.sg(), aVs.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer)) {
            final String str = (String) sparseArray.get(d.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
                bVar.cc(d.k.operation);
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.k.delete);
                    strArr[1] = z ? getResources().getString(d.k.un_mute) : getResources().getString(d.k.mute);
                    bVar.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view2) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.feO.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.ffi);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.ffi);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.k.un_mute) : getResources().getString(d.k.mute);
                    bVar.a(strArr2, new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view2) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.ffi);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.ffi);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).tG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(int i) {
        bd aVs;
        String str;
        String z;
        if (this.feN != null && this.feN.getPbData() != null && (aVs = this.feN.getPbData().aVs()) != null) {
            if (i == 1) {
                PraiseData rF = aVs.rF();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rF == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aVs.a(praiseData);
                    } else {
                        aVs.rF().getUser().add(0, metaData);
                        aVs.rF().setNum(aVs.rF().getNum() + 1);
                        aVs.rF().setIsLike(i);
                    }
                }
                if (aVs.rF() != null) {
                    if (aVs.rF().getNum() < 1) {
                        z = getResources().getString(d.k.zan);
                    } else {
                        z = com.baidu.tbadk.core.util.an.z(aVs.rF().getNum());
                    }
                    this.feO.M(z, true);
                }
            } else if (aVs.rF() != null) {
                aVs.rF().setIsLike(i);
                aVs.rF().setNum(aVs.rF().getNum() - 1);
                ArrayList<MetaData> user = aVs.rF().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aVs.rF().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aVs.rF().getNum() < 1) {
                    str = getResources().getString(d.k.zan);
                } else {
                    str = aVs.rF().getNum() + "";
                }
                this.feO.M(str, false);
            }
            if (this.feN.aYk()) {
                this.feO.aZY().notifyDataSetChanged();
            } else {
                this.feO.o(this.feN.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.feN.y(bundle);
        if (this.cXj != null) {
            this.cXj.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.ffb.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.feA = System.currentTimeMillis();
        this.ffg = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cHR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.feH = intent.getStringExtra("from");
            if (StringUtils.isNull(this.feH) && intent.getData() != null) {
                this.feH = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.feH)) {
                this.fev = true;
            }
            this.fgc = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fgd = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fge = intent.getStringExtra("key_manga_title");
            this.feX = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.feY = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (aXl()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.an.isEmpty(this.source) ? "" : this.source;
            this.ffp = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.cHR = System.currentTimeMillis();
        }
        this.aKN = this.feA - this.cHR;
        super.onCreate(bundle);
        this.fey = 0;
        x(bundle);
        if (this.feN != null && this.feN.getPbData() != null) {
            this.feN.getPbData().qq(this.source);
        }
        initUI();
        if (intent != null && this.feO != null) {
            this.feO.fnR = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.ffj == null) {
                    this.ffj = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.feO.qF("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.ffj, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.feN != null && this.feN.getPbData() != null) {
                this.feN.qA(stringExtra);
            }
        }
        this.cXj = new VoiceManager();
        this.cXj.onCreate(getPageContext());
        initData(bundle);
        this.ffa = new com.baidu.tbadk.editortools.pb.f();
        aWL();
        this.ffb = (com.baidu.tbadk.editortools.pb.d) this.ffa.aO(getActivity());
        this.ffb.b(this);
        this.ffb.a(this.aEK);
        this.ffb.a(this.aED);
        this.ffb.a(this, bundle);
        this.ffb.DF().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.ffb.DF().bx(true);
        jw(true);
        this.feO.setEditorTools(this.ffb.DF());
        this.ffb.a(this.feN.aYt(), this.feN.aYj(), this.feN.aYM());
        registerListener(this.ffw);
        if (!this.feN.aYq()) {
            this.ffb.gm(this.feN.aYj());
        }
        if (this.feN.aYN()) {
            this.ffb.gk(getPageContext().getString(d.k.pb_reply_hint_from_smart_frs));
        } else {
            this.ffb.gk(getPageContext().getString(d.k.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.ffv);
        registerListener(this.ffx);
        registerListener(this.ffy);
        registerListener(this.cYl);
        registerListener(this.ffM);
        registerListener(this.ffu);
        this.feZ = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gvV);
        this.feZ.brC();
        registerListener(this.ffA);
        registerListener(this.mAttentionListener);
        if (this.feN != null) {
            this.feN.aYD();
        }
        registerListener(this.ffP);
        registerListener(this.fgg);
        registerListener(this.cYt);
        if (this.feO != null && this.feO.baF() != null && this.feO.baG() != null) {
            this.feu = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.feO.baF(), this.feO.baG(), this.feO.aZP());
            this.feu.a(this.ffI);
        }
        if (this.fet && this.feO != null && this.feO.baG() != null) {
            this.feO.baG().setVisibility(8);
        }
        this.ffh = new com.baidu.tbadk.core.view.b();
        this.ffh.ams = 1000L;
        registerListener(this.ffL);
        registerListener(this.ffJ);
        registerListener(this.ffK);
        this.ffi = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.ffi;
        userMuteAddAndDelCustomMessage.setTag(this.ffi);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.ffi;
        userMuteCheckCustomMessage.setTag(this.ffi);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.feN.aYK().a(this.bQy);
        if ("from_tieba_kuang".equals(this.feH) && this.feH != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12264").r("obj_type", 2).ac("tid", this.feN.aYj()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                    @Override // com.baidu.tbadk.core.e
                    public void ak(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
            httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.aS("shoubai://internal?type=pb&param=" + this.feN.aYj()));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        this.feT = new au();
        if (this.ffb.Ee() != null) {
            this.feT.g(this.ffb.Ee().getInputView());
        }
        this.ffb.a(this.aEE);
        this.dll = new ShareSuccessReplyToServerModel();
        a(this.ffr);
        this.enV = new com.baidu.tbadk.core.util.ai(getPageContext());
        this.enV.a(new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.ai.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.ai.aio) {
                        PbActivity.this.ffb.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.ai.aip && PbActivity.this.feO != null && PbActivity.this.feO.aZH() != null && PbActivity.this.feO.aZH().aYa() != null) {
                        PbActivity.this.feO.aZH().aYa().Ew();
                    } else if (i == com.baidu.tbadk.core.util.ai.aiq) {
                        PbActivity.this.c(PbActivity.this.ffd);
                    }
                }
            }
        });
        this.createTime = System.currentTimeMillis() - this.feA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWL() {
        if (this.ffa != null && this.feN != null) {
            this.ffa.setForumName(this.feN.aYi());
            if (this.feN.getPbData() != null && this.feN.getPbData().aVq() != null) {
                this.ffa.a(this.feN.getPbData().aVq());
            }
            this.ffa.setFrom("pb");
            this.ffa.a(this.feN);
        }
    }

    public String aWM() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aWN() {
        return this.feu;
    }

    private void jw(boolean z) {
        this.ffb.bB(z);
        this.ffb.bC(z);
        this.ffb.bD(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVP() && !z && this.feO != null && this.feO.getView() != null) {
            this.feO.getView().setSystemUiVisibility(4);
        }
        this.ffe = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cXj != null) {
            this.cXj.onStart(getPageContext());
        }
    }

    public as aWO() {
        return this.feO;
    }

    public PbModel aWx() {
        return this.feN;
    }

    public void qr(String str) {
        if (this.feN != null && !StringUtils.isNull(str) && this.feO != null) {
            this.feO.kp(true);
            this.feN.qr(str);
            this.feG = true;
            this.feO.bar();
            this.feO.baA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.few = false;
        } else {
            this.few = true;
        }
        super.onPause();
        BdListView xj = xj();
        this.fey = CompatibleUtile.getInstance().getViewLayer(xj);
        if (this.fey == 1) {
            CompatibleUtile.getInstance().noneViewGpu(xj);
        }
        if (this.cXj != null) {
            this.cXj.onPause(getPageContext());
        }
        if (this.feO != null) {
            this.feO.onPause();
        }
        if (!this.feN.aYq()) {
            this.ffb.gl(this.feN.aYj());
        }
        if (this.feN != null) {
            this.feN.aYE();
        }
        MessageManager.getInstance().unRegisterListener(this.dRK);
        ayI();
        MessageManager.getInstance().unRegisterListener(this.ffJ);
        MessageManager.getInstance().unRegisterListener(this.ffK);
        MessageManager.getInstance().unRegisterListener(this.ffL);
        MessageManager.getInstance().unRegisterListener(this.cYo);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean aWP() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.feN.getPbData(), this.feN.aYk(), this.feN.getRequestType());
        return (a2 == null || a2.rQ() == null || a2.rQ().getGodUserData() == null || a2.rQ().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.few = false;
        super.onResume();
        if (this.feJ) {
            this.feJ = false;
            aXr();
        }
        if (aWP()) {
            this.feD = System.currentTimeMillis();
        } else {
            this.feD = -1L;
        }
        if (this.feO != null && this.feO.getView() != null) {
            if (!this.eJt) {
                aXi();
            } else {
                hideLoadingView(this.feO.getView());
            }
            this.feO.onResume();
        }
        if (this.fey == 1) {
            CompatibleUtile.getInstance().closeViewGpu(xj());
        }
        NoNetworkView noNetworkView = null;
        if (this.feO != null) {
            noNetworkView = this.feO.aZE();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.gP()) {
            noNetworkView.aL(false);
        }
        if (this.cXj != null) {
            this.cXj.onResume(getPageContext());
        }
        registerListener(this.dRK);
        this.feW = false;
        aXq();
        registerListener(this.ffJ);
        registerListener(this.ffK);
        registerListener(this.ffL);
        registerListener(this.cYo);
        if (this.cXP) {
            aXh();
            this.cXP = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.e
                public void ak(boolean z) {
                    if (z) {
                        KuangFloatingViewController.getInstance().showFloatingView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.feO.ke(z);
        if (this.feU != null) {
            this.feU.jQ(z);
        }
        if (z && this.feW) {
            this.feO.bad();
            this.feN.jM(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.feD > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10804").ac("obj_duration", (System.currentTimeMillis() - this.feD) + ""));
            this.feD = 0L;
        }
        if (aWO().aZH() != null) {
            aWO().aZH().onStop();
        }
        if (this.feO.fnY != null && !this.feO.fnY.agf()) {
            this.feO.fnY.aKe();
        }
        if (this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVq() != null && this.feN.getPbData().aVs() != null) {
            com.baidu.tbadk.distribute.a.Dq().a(getPageContext().getPageActivity(), "pb", this.feN.getPbData().aVq().getId(), com.baidu.adp.lib.g.b.c(this.feN.getPbData().aVs().getId(), 0L));
        }
        if (this.cXj != null) {
            this.cXj.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.feB && this.feO != null) {
            this.feB = true;
            this.feO.baw();
            a(false, (PostData) null);
        }
        if (this.feN != null) {
            this.feN.cancelLoadData();
            this.feN.destory();
            if (this.feN.aYJ() != null) {
                this.feN.aYJ().onDestroy();
            }
        }
        if (this.ffb != null) {
            this.ffb.onDestroy();
        }
        if (this.cpH != null) {
            this.cpH.cancelLoadData();
        }
        if (this.feO != null) {
            this.feO.onDestroy();
            if (this.feO.fnY != null) {
                this.feO.fnY.aKe();
            }
        }
        if (this.feC != null) {
            this.feC.onDestroy();
        }
        if (this.feu != null) {
            this.feu.HM();
        }
        super.onDestroy();
        if (this.cXj != null) {
            this.cXj.onDestory(getPageContext());
        }
        this.feO.bar();
        MessageManager.getInstance().unRegisterListener(this.ffJ);
        MessageManager.getInstance().unRegisterListener(this.ffK);
        MessageManager.getInstance().unRegisterListener(this.ffL);
        MessageManager.getInstance().unRegisterListener(this.ffi);
        MessageManager.getInstance().unRegisterListener(this.ffM);
        MessageManager.getInstance().unRegisterListener(this.cYt);
        this.ffg = null;
        this.ffh = null;
        com.baidu.tieba.recapp.d.a.bjZ().bkb();
        if (this.ffj != null) {
            getSafeHandler().removeCallbacks(this.ffj);
        }
        if (this.feK != null) {
            this.feK.cancelLoadData();
        }
        if (this.feO != null && this.feO.fnY != null) {
            this.feO.fnY.bbm();
        }
        if (this.dll != null) {
            this.dll.cancelLoadData();
        }
        this.feT.onDestroy();
        if (this.cXT != null) {
            this.cXT.onDestroy();
        }
        if (this.feN != null && this.feN.aYL() != null) {
            this.feN.aYL().onDestroy();
        }
        if (this.enV != null) {
            this.enV.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f aZY;
        ArrayList<PostData> aXM;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.yh() && this.feO != null && (aZY = this.feO.aZY()) != null && (aXM = aZY.aXM()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aXM.iterator();
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
                        bVar.aNv = id;
                        bVar.crD = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aaC == 1 && !TextUtils.isEmpty(id)) {
                    next.aaC = 2;
                    a.b bVar2 = new a.b();
                    bVar2.aNv = id;
                    bVar2.crD = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.feN == null || this.feN.getPbData() == null || this.feN.getPbData().aVq() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.feN.getPbData().aVq().getFirst_class();
                    str2 = this.feN.getPbData().aVq().getSecond_class();
                    str = this.feN.getPbData().aVq().getId();
                    str4 = this.feN.aYj();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.yk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.feO.onChangeSkinType(i);
            if (this.ffb != null && this.ffb.DF() != null) {
                this.ffb.DF().onChangeSkinType(i);
            }
            if (this.feO.aZE() != null) {
                this.feO.aZE().onChangeSkinType(getPageContext(), i);
            }
            this.feT.onChangeSkinType();
            if (this.cXT != null) {
                this.cXT.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.feO = new as(this, this.cYT, this.aWx);
        this.byy = new com.baidu.tieba.f.b(getActivity());
        this.byy.a(this.ffZ);
        this.byy.a(this.byz);
        this.feO.setOnScrollListener(this.mOnScrollListener);
        this.feO.e(this.ffT);
        this.feO.a(this.bfj);
        this.feO.jq(com.baidu.tbadk.core.i.pY().qe());
        this.feO.setOnImageClickListener(this.aWw);
        this.feO.b(this.axW);
        this.feO.h(this.cVh);
        this.feO.a(this.ffR);
        this.feO.ke(this.mIsLogin);
        if (getIntent() != null) {
            this.feO.kq(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aV(View view2) {
        if (view2 != null && (view2.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view2.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.gww && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.pY().qe()) {
                    return qu(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.feN == null || this.feN.getPbData() == null) {
                        return true;
                    }
                    if (aWO().aZH() != null) {
                        aWO().aZH().aXV();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.feN.getPbData().aVq());
                    kVar.T(this.feN.getPbData().aVs());
                    kVar.d(postData);
                    aWO().aZG().d(kVar);
                    aWO().aZG().setPostId(postData.getId());
                    b(view2, postData.rQ().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.ffb != null) {
                        this.feO.kl(this.ffb.Ek());
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
        if (this.feO != null) {
            if (z && !this.eJt) {
                aXi();
            } else {
                hideLoadingView(this.feO.getView());
            }
            if (z && this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVP() && this.feO.getView() != null) {
                this.feO.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void aWQ() {
        if (this.fez == null) {
            this.fez = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fez.a(new String[]{getPageContext().getString(d.k.call_phone), getPageContext().getString(d.k.sms_phone), getPageContext().getString(d.k.search_in_baidu)}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.feo = PbActivity.this.feo.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.feo);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.feN.aYj(), PbActivity.this.feo, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.feo = PbActivity.this.feo.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.feo);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.feN.aYj(), PbActivity.this.feo, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.feo = PbActivity.this.feo.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.feo);
                        bVar.dismiss();
                    }
                }
            }).cd(b.a.acX).ce(17).d(getPageContext());
        }
    }

    private void x(Bundle bundle) {
        this.feN = new PbModel(this);
        this.feN.a(this.ffO);
        if (this.feN.aYH() != null) {
            this.feN.aYH().a(this.fgb);
        }
        if (this.feN.aYG() != null) {
            this.feN.aYG().a(this.ffz);
        }
        if (this.feN.aYJ() != null) {
            this.feN.aYJ().b(this.fft);
        }
        if (bundle != null) {
            this.feN.initWithBundle(bundle);
        } else {
            this.feN.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.feN.jP(true);
        }
        ai.aZr().L(this.feN.aYh(), this.feN.getIsFromMark());
        if (StringUtils.isNull(this.feN.aYj())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.feH) && this.feH != null) {
            this.feN.qt(6);
        }
        if (this.feN.aYI() != null) {
            this.feN.aYI().a(this.ffs);
        }
        if (this.feN.aYL() != null) {
            this.feN.aYL().a(this.cXV);
        }
        this.feN.FY();
    }

    private void initData(Bundle bundle) {
        this.eGw = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eGw != null) {
            this.eGw.a(this.ffQ);
        }
        this.cpH = new ForumManageModel(this);
        this.cpH.setLoadDataCallBack(this.cpL);
        this.ait = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.feO.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    PbActivity.this.showToast(d.k.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.feN.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.feN.getPbData().aVq().getId(), PbActivity.this.feN.getPbData().aVq().getName(), PbActivity.this.feN.getPbData().aVs().getId(), valueOf, str, str2)));
            }
        });
        this.ffF.setUniqueId(getUniqueId());
        this.ffF.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.feO.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.ffi;
        userMuteCheckCustomMessage.setTag(this.ffi);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aWR() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.feN != null && (pbData = this.feN.getPbData()) != null) {
            return pbData.aVD().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aVs() != null) {
            if (dVar.aVs().getThreadType() == 0) {
                return 1;
            }
            if (dVar.aVs().getThreadType() == 54) {
                return 2;
            }
            if (dVar.aVs().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData aW(final View view2) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view2.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bsl()) {
                postData.cU(postData.bsk() - 1);
            } else {
                postData.cU(postData.bsk() + 1);
            }
            postData.mr(!postData.bsl());
            ((PbFloorAgreeView) view2).a(postData.bsl(), postData.bsk(), true);
            final int i = postData.bsl() ? 0 : 1;
            this.feN.aYI().a(postData.getId(), i, new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
                @Override // com.baidu.tieba.pb.pb.main.q.a
                public void qh(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view2).qE(i2);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.q.a
                public void c(CustomDialogData customDialogData) {
                    customDialogData.type = 0;
                    com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                }
            });
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.al aWS() {
        return new com.baidu.tbadk.core.util.al("c12003").ac("tid", this.feN.fjV).r("obj_type", 0).ac(ImageViewerConfig.FORUM_ID, this.feN.getForumId()).r("obj_param1", this.feN.getPbData().aVs().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2, final String str, final String str2) {
        if (view2 != null && str != null && str2 != null && aWT()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view2.getMeasuredHeight();
            view2.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
                @Override // java.lang.Runnable
                public void run() {
                    int e;
                    int ah = (com.baidu.adp.lib.util.l.ah(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        e = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.e(PbActivity.this.getPageContext().getPageActivity(), d.e.ds120);
                    } else {
                        e = com.baidu.adp.lib.util.l.e(PbActivity.this.getPageContext().getPageActivity(), d.e.ds640);
                    }
                    int i = e - ah;
                    if (i > 0) {
                        PbActivity.this.aWO().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aWO().aZH() != null) {
                        PbActivity.this.ffb.DF().setVisibility(8);
                        PbActivity.this.aWO().aZH().bG(str, str2);
                        com.baidu.tbadk.editortools.pb.g aYa = PbActivity.this.aWO().aZH().aYa();
                        if (aYa != null && PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null) {
                            aYa.a(PbActivity.this.feN.getPbData().qT());
                        }
                        if (PbActivity.this.feT.baS() == null && PbActivity.this.aWO().aZH().aYa().EE() != null) {
                            PbActivity.this.aWO().aZH().aYa().EE().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.feT != null && PbActivity.this.feT.baR() != null) {
                                        if (!PbActivity.this.feT.baR().bAX()) {
                                            PbActivity.this.feT.ks(false);
                                        }
                                        PbActivity.this.feT.baR().nj(false);
                                    }
                                }
                            });
                            PbActivity.this.feT.h(PbActivity.this.aWO().aZH().aYa().EE().getInputView());
                            PbActivity.this.aWO().aZH().aYa().a(PbActivity.this.fff);
                        }
                    }
                    PbActivity.this.aWO().baA();
                }
            }, 500L);
        }
    }

    public boolean aWT() {
        if (this.enV == null || this.feN.getPbData() == null || this.feN.getPbData().qT() == null) {
            return true;
        }
        return this.enV.cJ(this.feN.getPbData().qT().replyPrivateFlag);
    }

    public boolean qd(int i) {
        if (this.enV == null || this.feN.getPbData() == null || this.feN.getPbData().qT() == null) {
            return true;
        }
        return this.enV.t(this.feN.getPbData().qT().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.feN != null && this.feN.getPbData() != null && postData.brZ() > 1) {
            String aYj = this.feN.aYj();
            String id = postData.getId();
            int aVE = this.feN.getPbData() != null ? this.feN.getPbData().aVE() : 0;
            c qv = qv(id);
            if (qv != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(aYj, id, "pb", true, null, false, null, aVE, postData.bbZ(), this.feN.getPbData().qT(), false, postData.rQ() != null ? postData.rQ().getIconInfo() : null).addBigImageData(qv.fgG, qv.fgH, qv.fgI, qv.index);
                addBigImageData.setKeyPageStartFrom(this.feN.aYP());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public void a(View view2, int i, boolean z, int i2) {
        ap apVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.hg()) {
                showToast(d.k.no_network_guide);
            } else if (aWx() != null && aWx().getPbData() != null && aWx().getPbData().aVO() != null) {
                com.baidu.tieba.pb.data.j aVO = aWx().getPbData().aVO();
                if (view2 == null || !(view2.getTag(d.g.pb_main_thread_praise_view) instanceof ap)) {
                    apVar = null;
                } else {
                    apVar = (ap) view2.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aVO != null) {
                    int i3 = -1;
                    if (z) {
                        aVO.pV(i);
                    } else if (aVO.aVW()) {
                        aVO.aVZ();
                        i3 = 1;
                    } else {
                        aVO.pX(i);
                        i3 = 0;
                    }
                    aVO.pW(i2);
                    q.a aVar = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                        @Override // com.baidu.tieba.pb.pb.main.q.a
                        public void qh(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.q.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.feN != null && this.feN.aYI() != null) {
                        String str = "";
                        if (this.feN.getPbData() != null && this.feN.getPbData().aVs() != null) {
                            str = this.feN.getPbData().aVs().sg();
                        }
                        if (this.feN.getPbData() != null) {
                            this.feN.getPbData().a(aVO);
                        }
                        if (z) {
                            this.feN.aYI().a(str, 3, i, this.feN.getForumId(), aVar);
                        } else {
                            this.feN.aYI().a(str, i3, 3, i, this.feN.getForumId(), aVar);
                            com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i();
                            iVar.fcG = i3;
                            iVar.fcH = aVO;
                            iVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016551, iVar));
                        }
                    }
                    if (apVar != null) {
                        apVar.b(aVO);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aWU() {
        if (this.feN.getPbData() == null || this.feN.getPbData().aVs() == null) {
            return -1;
        }
        return this.feN.getPbData().aVs().ss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWV() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.sn(this.feN.getForumId()) && this.feN.getPbData() != null && this.feN.getPbData().aVq() != null) {
            if (this.feN.getPbData().aVq().isLike() == 1) {
                this.feN.aYL().bV(this.feN.getForumId(), this.feN.aYj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jx(boolean z) {
        if (this.feN == null || this.feN.getPbData() == null) {
            return false;
        }
        return ((this.feN.getPbData().aVE() != 0) || this.feN.getPbData().aVs() == null || this.feN.getPbData().aVs().rQ() == null || TextUtils.equals(this.feN.getPbData().aVs().rQ().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aWW() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.o.q.Hs()) {
            return "";
        }
        PostData aVz = aVz();
        if (this.feN == null || (pbData = this.feN.getPbData()) == null || pbData.getUserData() == null || pbData.aVs() == null || aVz == null || aVz.rQ() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aVz.rQ().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aVs().rB() == 0) {
            return "";
        }
        if (pbData.aVs().rB() == 0) {
            return getPageContext().getString(d.k.fans_call);
        }
        return getPageContext().getString(d.k.haved_fans_call);
    }

    private boolean jy(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.u uVar;
        if (z) {
            return true;
        }
        if (this.feN == null || this.feN.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.feN.getPbData();
        if (pbData.aVE() == 0) {
            List<com.baidu.tbadk.core.data.az> aVM = pbData.aVM();
            if (com.baidu.tbadk.core.util.v.v(aVM) > 0) {
                for (com.baidu.tbadk.core.data.az azVar : aVM) {
                    if (azVar != null && (uVar = azVar.ZA) != null && uVar.XE && !uVar.isDeleted && (uVar.type == 1 || uVar.type == 2)) {
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

    private boolean jz(boolean z) {
        return (z || this.feN == null || this.feN.getPbData() == null || this.feN.getPbData().aVE() == 0) ? false : true;
    }

    public void aWX() {
        if (this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVs() != null && this.feN.getPbData().aVs().rQ() != null) {
            if (this.feO != null) {
                this.feO.aZF();
            }
            bd aVs = this.feN.getPbData().aVs();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aVs.rQ().getUserId());
            aa aaVar = new aa();
            int aVE = this.feN.getPbData().aVE();
            if (aVE == 1) {
                aaVar.flW = true;
                aaVar.flV = true;
                aaVar.fmd = aVs.rL() == 1;
                aaVar.fmc = aVs.rM() == 1;
            } else {
                aaVar.flW = false;
                aaVar.flV = false;
            }
            if (aVE == 1002 && !equals) {
                aaVar.fmh = true;
            }
            aaVar.flS = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            aaVar.flX = jy(equals);
            aaVar.flY = aWY();
            aaVar.flZ = jz(equals);
            aaVar.flT = this.feN.aYk();
            aaVar.flU = true;
            aaVar.fcV = this.eGw != null && this.eGw.oI();
            aaVar.flR = jx(equals);
            aaVar.fmf = aWW();
            aaVar.flQ = equals && this.feO.bak();
            aaVar.fma = TbadkCoreApplication.getInst().getSkinType() == 1;
            aaVar.fmb = true;
            aaVar.isHostOnly = this.feN.getHostMode();
            aaVar.fme = true;
            if (aVs.sh() == null) {
                aaVar.fmg = true;
            } else {
                aaVar.fmg = false;
            }
            this.feO.fnY.a(aaVar);
        }
    }

    private boolean aWY() {
        if (this.feN != null && this.feN.aYk()) {
            return this.feN.azo() == null || this.feN.azo().rd() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(View view2) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view2.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null) {
            e(postData);
        }
    }

    public int aWZ() {
        if (aWO() == null || aWO().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aWO().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fcC) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aXa() {
        if (aWO() == null || aWO().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aWO().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.gwv) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        aXh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.db(getResources().getString(d.k.mark_done));
            aVar.ay(true);
            aVar.dc(getResources().getString(d.k.mark_like));
            aVar.ax(true);
            aVar.ar(false);
            aVar.b(getResources().getString(d.k.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12528").ac(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.k.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12528").ac(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.ait.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.feN.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).tD();
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.feO.bae();
        this.feN.jO(z);
        if (this.eGw != null) {
            this.eGw.ae(z);
            if (markData != null) {
                this.eGw.a(markData);
            }
        }
        if (this.feN.oI()) {
            aXf();
        } else {
            this.feO.n(this.feN.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qb(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qs(String str) {
        if (!StringUtils.isNull(str) && this.feN != null) {
            String aYj = this.feN.aYj();
            String id = this.feN.getPbData().aVq().getId();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.k.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + aYj + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.feN.aYq()) {
                    antiData.setBlock_forum_name(this.feN.getPbData().aVq().getName());
                    antiData.setBlock_forum_id(this.feN.getPbData().aVq().getId());
                    antiData.setUser_name(this.feN.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.feN.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.tt(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12536").r("obj_locate", ar.a.ajc));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12535").r("obj_locate", ar.a.ajc));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12534").r("obj_locate", ar.a.ajc));
            }
        } else if (i == 230277) {
            gt(str);
        } else {
            this.feO.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.feO.a(0, bVar.yR, bVar.gyO, z);
            if (bVar.yR) {
                if (bVar.gyM == 1) {
                    ArrayList<PostData> aVu = this.feN.getPbData().aVu();
                    int size = aVu.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aVu.get(i).getId())) {
                            i++;
                        } else {
                            aVu.remove(i);
                            break;
                        }
                    }
                    this.feO.n(this.feN.getPbData());
                } else if (bVar.gyM == 0) {
                    aXb();
                } else if (bVar.gyM == 2) {
                    ArrayList<PostData> aVu2 = this.feN.getPbData().aVu();
                    int size2 = aVu2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aVu2.get(i2).brW().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aVu2.get(i2).brW().get(i3).getId())) {
                                i3++;
                            } else {
                                aVu2.get(i2).brW().remove(i3);
                                aVu2.get(i2).brY();
                                z2 = true;
                                break;
                            }
                        }
                        aVu2.get(i2).sT(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.feO.n(this.feN.getPbData());
                    }
                    a(bVar, this.feO);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.feO.a(this.cpH.getLoadDataMode(), gVar.yR, gVar.gyO, false);
            if (gVar.yR) {
                this.feQ = true;
                if (i == 2 || i == 3) {
                    this.feR = true;
                    this.feS = false;
                } else if (i == 4 || i == 5) {
                    this.feR = false;
                    this.feS = true;
                }
                if (i == 2) {
                    this.feN.getPbData().aVs().bQ(1);
                    this.feN.setIsGood(1);
                } else if (i == 3) {
                    this.feN.getPbData().aVs().bQ(0);
                    this.feN.setIsGood(0);
                } else if (i == 4) {
                    this.feN.getPbData().aVs().bP(1);
                    this.feN.iY(1);
                } else if (i == 5) {
                    this.feN.getPbData().aVs().bP(0);
                    this.feN.iY(0);
                }
                this.feO.c(this.feN.getPbData(), this.feN.aYk());
            }
        }
    }

    private void aXb() {
        if (this.feN.aYl() || this.feN.aYn()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.feN.aYj());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.feN.aYj()));
        if (aXg()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXc() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aVB;
        boolean z = false;
        if (this.feO != null) {
            this.feO.bar();
        }
        if (this.feN != null && this.feN.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.feN.getPbData().aVs().getId();
            if (this.feN.isShareThread() && this.feN.getPbData().aVs().abL != null) {
                historyMessage.threadName = this.feN.getPbData().aVs().abL.showText;
            } else {
                historyMessage.threadName = this.feN.getPbData().aVs().getTitle();
            }
            if (this.feN.isShareThread() && !aXy()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.feN.getPbData().aVq().getName();
            }
            ArrayList<PostData> aVu = this.feN.getPbData().aVu();
            int bag = this.feO != null ? this.feO.bag() : 0;
            if (aVu != null && bag >= 0 && bag < aVu.size()) {
                historyMessage.postID = aVu.get(bag).getId();
            }
            historyMessage.isHostOnly = this.feN.getHostMode();
            historyMessage.isSquence = this.feN.aYk();
            historyMessage.isShareThread = this.feN.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.ffb != null) {
            this.ffb.onDestroy();
        }
        if (this.fex && aWO() != null) {
            aWO().baK();
        }
        if (this.feN != null && (this.feN.aYl() || this.feN.aYn())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.feN.aYj());
            if (this.feQ) {
                if (this.feS) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.feN.aYp());
                }
                if (this.feR) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.feN.getIsGood());
                }
            }
            if (this.feN.getPbData() != null && System.currentTimeMillis() - this.feA >= 40000 && (aVB = this.feN.getPbData().aVB()) != null && !com.baidu.tbadk.core.util.v.w(aVB.getDataList())) {
                intent.putExtra("guess_like_data", aVB);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.ffp);
            }
            setResult(-1, intent);
        }
        if (aXg()) {
            if (this.feN != null && this.feO != null && this.feO.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.feN.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aVy() && !this.feG) {
                        ai aZr = ai.aZr();
                        com.baidu.tieba.pb.data.d pbData2 = this.feN.getPbData();
                        Parcelable onSaveInstanceState = this.feO.getListView().onSaveInstanceState();
                        boolean aYk = this.feN.aYk();
                        boolean hostMode = this.feN.getHostMode();
                        if (this.feO.aZP() != null && this.feO.aZP().getVisibility() == 0) {
                            z = true;
                        }
                        aZr.a(pbData2, onSaveInstanceState, aYk, hostMode, z);
                        if (this.ffo >= 0 || this.feN.aYR() != null) {
                            ai.aZr().i(this.feN.aYR());
                            ai.aZr().h(this.feN.aYS());
                            ai.aZr().qv(this.feN.aYT());
                        }
                    }
                }
            } else {
                ai.aZr().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.feO == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.feO.qz(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qe(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.feO.aZF();
            this.feO.aZH().aXV();
            this.feO.kn(false);
        }
        this.feO.aZI();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.ffb.resetData();
                        this.ffb.b(writeData);
                        this.ffb.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k eH = this.ffb.DF().eH(6);
                        if (eH != null && eH.aCM != null) {
                            eH.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.ffb.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.feO.aZH() != null && this.feO.aZH().aYa() != null) {
                            com.baidu.tbadk.editortools.pb.g aYa = this.feO.aZH().aYa();
                            aYa.b(writeData);
                            aYa.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k eH2 = aYa.DF().eH(6);
                            if (eH2 != null && eH2.aCM != null) {
                                eH2.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                aYa.Ew();
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
        this.ffb.onActivityResult(i, i2, intent);
        if (this.feK != null) {
            this.feK.onActivityResult(i, i2, intent);
        }
        if (aWO().aZH() != null) {
            aWO().aZH().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    aXe();
                    return;
                case 13008:
                    ai.aZr().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.feN != null) {
                                PbActivity.this.feN.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.feN != null) {
                        a(aXd(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    J(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aWV();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dll != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dll.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void AF() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59.1
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
                    this.feO.jv(false);
                    if (this.feN.getPbData() != null && this.feN.getPbData().aVs() != null && this.feN.getPbData().aVs().sj() != null) {
                        this.feN.getPbData().aVs().sj().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.ffd = emotionImageData;
                        if (qd(com.baidu.tbadk.core.util.ai.aiq)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.feO != null && this.feO.fnY != null) {
                        this.feO.fnY.pr();
                        this.feO.fnY.bbg();
                        if (this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVs() != null) {
                            this.feN.getPbData().aVs().bL(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.feL != null) {
                        this.feO.bf(this.feL);
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
            if (this.feK == null) {
                this.feK = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.feK.b(this.aED);
                this.feK.c(this.aEK);
            }
            this.feK.a(emotionImageData, aWx(), aWx().getPbData());
        }
    }

    private ShareFromPBMsgData aXd() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bM = this.feN.getPbData().bM(getPageContext().getPageActivity());
        PostData aZK = this.feO.aZK();
        String str = "";
        if (aZK != null) {
            str = aZK.getId();
            String bZ = aZK.bZ(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(bZ)) {
                bM[1] = bZ;
            }
        }
        String sg = this.feN.getPbData().aVs().sg();
        if (sg != null && sg.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bM[1]);
        shareFromPBMsgData.setImageUrl(bM[0]);
        shareFromPBMsgData.setForumName(this.feN.getPbData().aVq().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.feN.getPbData().aVs().getId());
        shareFromPBMsgData.setTitle(this.feN.getPbData().aVs().getTitle());
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        a(aXd(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVs() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cb(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null) {
                        com.baidu.tbadk.core.util.al ac = new com.baidu.tbadk.core.util.al("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.feN.getForumId()).ac("tid", PbActivity.this.feN.aYj());
                        if (PbActivity.this.e(PbActivity.this.feN.getPbData()) != 0) {
                            ac.r("obj_type", PbActivity.this.e(PbActivity.this.feN.getPbData()));
                        }
                        TiebaStatic.log(ac);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(getPageContext()).tD();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.feN.getPbData().aVF() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVs() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cb(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(getPageContext()).tD();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.feN.getPbData().aVF() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXe() {
        MarkData qs;
        if (this.eGw != null && (qs = this.feN.qs(this.feO.bah())) != null) {
            if (!qs.isApp() || (qs = this.feN.qs(this.feO.bah() + 1)) != null) {
                this.feO.bac();
                this.eGw.a(qs);
                if (!this.eGw.oI()) {
                    this.eGw.oK();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.eGw.oJ();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXf() {
        com.baidu.tieba.pb.data.d pbData = this.feN.getPbData();
        this.feN.jO(true);
        if (this.eGw != null) {
            pbData.qp(this.eGw.oH());
        }
        this.feO.n(pbData);
    }

    private boolean aXg() {
        if (this.feN == null) {
            return true;
        }
        if (this.feN.oI()) {
            final MarkData aYy = this.feN.aYy();
            if (aYy == null || !this.feN.getIsFromMark()) {
                return true;
            }
            final MarkData qs = this.feN.qs(this.feO.bag());
            if (qs == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", aYy);
                setResult(-1, intent);
                return true;
            } else if (qs.getPostId() == null || qs.getPostId().equals(aYy.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", aYy);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dc(getPageContext().getString(d.k.alert_update_mark));
                aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.eGw != null) {
                            if (PbActivity.this.eGw.oI()) {
                                PbActivity.this.eGw.oJ();
                                PbActivity.this.eGw.ae(false);
                            }
                            PbActivity.this.eGw.a(qs);
                            PbActivity.this.eGw.ae(true);
                            PbActivity.this.eGw.oK();
                        }
                        aYy.setPostId(qs.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", aYy);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aXc();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", aYy);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aXc();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.feO != null && PbActivity.this.feO.getView() != null) {
                            PbActivity.this.feO.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", aYy);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aXc();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.tD();
                return false;
            }
        } else if (this.feN.getPbData() == null || this.feN.getPbData().aVu() == null || this.feN.getPbData().aVu().size() <= 0 || !this.feN.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdListView xj() {
        if (this.feO == null) {
            return null;
        }
        return this.feO.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Ko() {
        if (this.feO == null) {
            return 0;
        }
        return this.feO.bap();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Kp() {
        if (this.aWn == null) {
            this.aWn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: abw */
                public ImageView fo() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean qe = com.baidu.tbadk.core.i.pY().qe();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ak.getDrawable(d.C0126d.common_color_10220));
                    if (qe) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(d.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public void n(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0126d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView o(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.pY().qe()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(d.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public ImageView p(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0126d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aWn;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Kq() {
        if (this.aWo == null) {
            this.aWo = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.aWo;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Kr() {
        if (this.aWs == null) {
            this.aWs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aXA */
                public GifView fo() {
                    return new GifView(PbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void n(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView o(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView p(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.EW();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.aWs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Ks() {
        if (this.aWp == null) {
            this.aWp = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aXB */
                public View fo() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aZ */
                public void n(View view2) {
                    ((PlayVoiceBntNew) view2).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ba */
                public View o(View view2) {
                    ((PlayVoiceBntNew) view2).btf();
                    return view2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bb */
                public View p(View view2) {
                    ((PlayVoiceBntNew) view2).reset();
                    return view2;
                }
            }, 8, 0);
        }
        return this.aWp;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Ku() {
        this.aWr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aXC */
            public RelativeLayout fo() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout o(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout p(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.aWr;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xk() {
        if (this.aqg == null) {
            this.aqg = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.aqg;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void S(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.feE = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void T(Context context, String str) {
        if (ax.qG(str) && this.feN != null && this.feN.aYj() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11664").r("obj_param1", 1).ac("post_id", this.feN.aYj()));
        }
        ax.baU().c(getPageContext(), str);
        this.feE = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        ax.baU().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.feE = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.feN.getPbData();
            TbRichText aB = aB(str, i);
            if (aB != null && (tbRichTextData = aB.JJ().get(this.ffU)) != null) {
                cVar.fgG = new ArrayList<>();
                cVar.fgH = new ConcurrentHashMap<>();
                if (!tbRichTextData.JP().Kb()) {
                    cVar.fgJ = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fgG.add(b2);
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
                    imageUrlData.postId = aB.getPostId();
                    imageUrlData.mIsReserver = this.feN.aYx();
                    imageUrlData.mIsSeeHost = this.feN.getHostMode();
                    cVar.fgH.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aVq() != null) {
                            cVar.forumName = pbData.aVq().getName();
                            cVar.forumId = pbData.aVq().getId();
                        }
                        if (pbData.aVs() != null) {
                            cVar.threadId = pbData.aVs().getId();
                        }
                        cVar.fgI = pbData.aVF() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fgJ = true;
                int size = pbData.aVu().size();
                this.ffV = false;
                cVar.index = -1;
                if (pbData.aVz() != null) {
                    PostData aVz = pbData.aVz();
                    TbRichText bsb = aVz.bsb();
                    if (!ar.j(aVz)) {
                        i2 = a(bsb, aB, i, i, cVar.fgG, cVar.fgH);
                    } else {
                        i2 = a(aVz, i, cVar.fgG, cVar.fgH);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aVu().get(i4);
                    if (postData.getId() == null || pbData.aVz() == null || pbData.aVz().getId() == null || !postData.getId().equals(pbData.aVz().getId())) {
                        TbRichText bsb2 = postData.bsb();
                        if (!ar.j(postData)) {
                            i3 = a(bsb2, aB, i3, i, cVar.fgG, cVar.fgH);
                        } else {
                            i3 = a(postData, i3, cVar.fgG, cVar.fgH);
                        }
                    }
                }
                if (cVar.fgG.size() > 0) {
                    cVar.lastId = cVar.fgG.get(cVar.fgG.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aVq() != null) {
                        cVar.forumName = pbData.aVq().getName();
                        cVar.forumId = pbData.aVq().getId();
                    }
                    if (pbData.aVs() != null) {
                        cVar.threadId = pbData.aVs().getId();
                    }
                    cVar.fgI = pbData.aVF() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.JP() == null) {
            return null;
        }
        return tbRichTextData.JP().Kf();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.JP() == null) {
            return 0L;
        }
        return tbRichTextData.JP().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.JP() == null) {
            return false;
        }
        return tbRichTextData.JP().Kg();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.JP() == null) {
            return false;
        }
        return tbRichTextData.JP().Kh();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo JP;
        String str;
        if (tbRichText == tbRichText2) {
            this.ffV = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.JJ().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.JJ().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.JP().getWidth() * ai;
                    int height = ai * tbRichTextData.JP().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.JP().Kb()) {
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
                            if (tbRichTextData != null && (JP = tbRichTextData.JP()) != null) {
                                String Kc = JP.Kc();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = JP.Kd();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = Kc;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.feN.aYj(), -1L);
                                imageUrlData.mIsReserver = this.feN.aYx();
                                imageUrlData.mIsSeeHost = this.feN.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.ffV) {
                            i4 = i7 + 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i = i4;
                i5 = i3;
            }
        }
        return i;
    }

    private int a(PostData postData, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        com.baidu.tieba.tbadkCore.data.h bsi;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> brG;
        if (postData != null && arrayList != null && concurrentHashMap != null && (brG = (bsi = postData.bsi()).brG()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == brG.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = brG.get(i3);
                if (jVar != null) {
                    String brK = jVar.brK();
                    if (!com.baidu.tbadk.core.util.an.isEmpty(brK)) {
                        arrayList.add(brK);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = brK;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.brJ();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.feN.aYj(), -1L);
                        imageUrlData.mIsReserver = this.feN.aYx();
                        imageUrlData.mIsSeeHost = this.feN.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bsi.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(brK, imageUrlData);
                        }
                        if (!this.ffV) {
                            i++;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    protected void e(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.feN.rZ())) {
                z = true;
            }
            MarkData g = this.feN.g(postData);
            if (g != null) {
                this.feO.bac();
                if (this.eGw != null) {
                    this.eGw.a(g);
                    if (!z) {
                        this.eGw.oK();
                    } else {
                        this.eGw.oJ();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aB(String str, int i) {
        TbRichText tbRichText = null;
        if (this.feN == null || this.feN.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.feN.getPbData();
        if (pbData.aVz() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aVz());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aVu = pbData.aVu();
            a(pbData, aVu);
            return a(aVu, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.aVD() != null && dVar.aVD().fcX != null && (list = dVar.aVD().fcX) != null && arrayList != null) {
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

    private long qt(String str) {
        ArrayList<PostData> aVu;
        com.baidu.tieba.pb.data.d pbData = this.feN.getPbData();
        if (pbData != null && (aVu = pbData.aVu()) != null && !aVu.isEmpty()) {
            Iterator<PostData> it = aVu.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bsi = next.bsi();
                if (bsi != null && bsi.gwd) {
                    Iterator<TbRichTextData> it2 = next.bsb().JJ().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.JY().getLink().equals(str)) {
                            return bsi.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> JJ;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bsb = arrayList.get(i2).bsb();
            if (bsb != null && (JJ = bsb.JJ()) != null) {
                int size = JJ.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (JJ.get(i4) != null && JJ.get(i4).getType() == 8) {
                        i3++;
                        if (JJ.get(i4).JP().Kc().equals(str) || JJ.get(i4).JP().Kd().equals(str)) {
                            int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                            int width = JJ.get(i4).JP().getWidth() * ai;
                            int height = JJ.get(i4).JP().getHeight() * ai;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.ffU = i4;
                            return bsb;
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
    public void g(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.feo = str;
            if (this.fez == null) {
                aWQ();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fez.ch(1).setVisibility(8);
            } else {
                this.fez.ch(1).setVisibility(0);
            }
            this.fez.tG();
            this.feE = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cXj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXh() {
        hideNetRefreshView(this.feO.getView());
        aXi();
        if (this.feN.FY()) {
            this.feO.bac();
        }
    }

    private void aXi() {
        showLoadingView(this.feO.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View Fs = getLoadingView().Fs();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Fs.getLayoutParams();
        layoutParams.addRule(3, this.feO.baF().getId());
        Fs.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apC() {
        if (this.cXj != null) {
            this.cXj.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(int i) {
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
    public void qg(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.feN.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.feN.getPbData();
            pbData.aVq().getName();
            String title = pbData.aVs().getTitle();
            int i2 = this.feN.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aVq() != null) {
                if ((pbData.aVq().isLike() == 1) && AddExperiencedModel.sn(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.feN.aYj() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bM = pbData.bM(getPageContext().getPageActivity());
                    str = bM[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bM[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aWU() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10399").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.an.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.awN = true;
                    dVar.awR = z;
                    dVar.extData = this.feN.aYj();
                    dVar.axb = 3;
                    dVar.axa = i;
                    dVar.fid = this.feN.getForumId();
                    dVar.tid = this.feN.aYj();
                    dVar.axc = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.awV = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.feN.getPbData().aVs());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.axb);
                    bundle.putInt("obj_type", dVar.axc);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.f(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVP()) {
                                PbActivity.this.feO.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.d.d.ahh().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.feN.aYj() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bM2 = pbData.bM(getPageContext().getPageActivity());
            str = bM2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bM2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aWU() == 1) {
            }
            if (com.baidu.tbadk.core.util.an.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.awN = true;
            dVar2.awR = z;
            dVar2.extData = this.feN.aYj();
            dVar2.axb = 3;
            dVar2.axa = i;
            dVar2.fid = this.feN.getForumId();
            dVar2.tid = this.feN.aYj();
            dVar2.axc = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.feN.getPbData().aVs());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.axb);
            bundle2.putInt("obj_type", dVar2.axc);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.f(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.feN != null && PbActivity.this.feN.getPbData() != null && PbActivity.this.feN.getPbData().aVP()) {
                        PbActivity.this.feO.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.d.d.ahh().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aVs() != null) {
            if (dVar.aVs().getThreadType() == 0) {
                return 1;
            }
            if (dVar.aVs().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXj() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.so(PbActivity.this.feN.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.feO.baL();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Kt() {
        if (this.aWq == null) {
            this.aWq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aXD */
                public LinearLayout fo() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
                    linearLayout.setId(d.g.pb_text_voice_layout);
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
                /* renamed from: b */
                public void n(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout o(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout p(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.aWq;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (this.feO.aZX() == view2) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, this.feN.getPbData().getForumId()));
            } else {
                bd aVs = this.feN.getPbData().aVs();
                if (view2 != null) {
                    boolean z = aVs.rF() == null || aVs.rF().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.ffG > 1000) {
                            this.ffH = true;
                            aY(view2);
                        } else {
                            this.ffH = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            m(view2, this.ffH);
                        } else {
                            l(view2, this.ffH);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        l(view2, this.ffH);
                    } else if (motionEvent.getAction() == 3) {
                        l(view2, this.ffH);
                    }
                }
            }
        }
        return false;
    }

    private void l(View view2, boolean z) {
        if (z) {
            view2.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.ffG = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void m(View view2, boolean z) {
        if (z) {
            view2.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.ffG = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void aY(View view2) {
        view2.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (xj() == null) {
            return null;
        }
        return xj().getPreLoadHandle();
    }

    public void apD() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, 11017)));
        } else if (aVar.tF() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tF();
            int intValue = ((Integer) sparseArray.get(as.fpN)).intValue();
            if (intValue == as.fpO) {
                if (!this.cpH.bsK()) {
                    this.feO.aZZ();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cpH.a(this.feN.getPbData().aVq().getId(), this.feN.getPbData().aVq().getName(), this.feN.getPbData().aVs().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == as.fpP || intValue == as.fpR) {
                if (this.feN.aYH() != null) {
                    this.feN.aYH().qk(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == as.fpP) {
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
        if (sparseArray.get(d.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(d.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(d.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(d.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(d.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(d.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(d.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.ffi);
        userMuteAddAndDelCustomMessage.setTag(this.ffi);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean qu(String str) {
        if (!StringUtils.isNull(str) && az.aK(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(d.k.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void jA(boolean z) {
        this.feW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aXk() {
        ArrayList<PostData> aVu;
        int v;
        if (this.feN == null || this.feN.getPbData() == null || this.feN.getPbData().aVu() == null || (v = com.baidu.tbadk.core.util.v.v((aVu = this.feN.getPbData().aVu()))) == 0) {
            return "";
        }
        if (this.feN.aYx()) {
            Iterator<PostData> it = aVu.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.brZ() == 1) {
                    return next.getId();
                }
            }
        }
        int bag = this.feO.bag();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aVu, bag);
        if (postData == null || postData.rQ() == null) {
            return "";
        }
        if (this.feN.qx(postData.rQ().getUserId())) {
            return postData.getId();
        }
        for (int i = bag - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aVu, i);
            if (postData2 == null || postData2.rQ() == null || postData2.rQ().getUserId() == null) {
                break;
            } else if (this.feN.qx(postData2.rQ().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bag + 1; i2 < v; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aVu, i2);
            if (postData3 == null || postData3.rQ() == null || postData3.rQ().getUserId() == null) {
                return "";
            }
            if (this.feN.qx(postData3.rQ().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.ax.wg().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(qt(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.feN.getPbData().aVq().getId(), this.feN.getPbData().aVq().getName(), this.feN.getPbData().aVs().getTid());
            }
            this.feE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.dc(getResources().getString(d.k.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.dc(getResources().getString(d.k.make_sure_hide));
        }
        aVar.a(getResources().getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.feN.aYG() != null) {
                    PbActivity.this.feN.aYG().cI(j);
                }
            }
        });
        aVar.b(getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.as(false);
        aVar.b(getPageContext());
        aVar.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c qv(String str) {
        String str2;
        if (this.feN.getPbData() == null || this.feN.getPbData().aVu() == null || this.feN.getPbData().aVu().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.feN.getPbData().aVu().size()) {
                i = 0;
                break;
            } else if (str.equals(this.feN.getPbData().aVu().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.feN.getPbData().aVu().get(i);
        if (postData.bsb() == null || postData.bsb().JJ() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bsb().JJ().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.JP() != null) {
                    str2 = next.JP().Kc();
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
        if (this.fev) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fev = false;
        } else if (aXl()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fev) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fev = false;
        } else if (aXl()) {
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
        if (pageStayDurationItem != null && this.feN != null) {
            if (this.feN.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.feN.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.feN.aYj(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aXl() {
        return (!this.fet && this.fgc == -1 && this.fgd == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.fgf = nVar;
            this.fet = true;
            this.feO.aZQ();
            this.feO.qE(this.fge);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        if (this.fgf != null) {
            if (this.fgc == -1) {
                showToast(d.k.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                az.aJ(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fgf.getCartoonId(), this.fgc, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXn() {
        if (this.fgf != null) {
            if (this.fgd == -1) {
                showToast(d.k.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                az.aJ(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fgf.getCartoonId(), this.fgd, 0)));
                finish();
            }
        }
    }

    public int aXo() {
        return this.fgc;
    }

    public int aXp() {
        return this.fgd;
    }

    private void ayI() {
        if (this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVs() != null && this.feN.getPbData().aVs().sB()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void aXq() {
        if (this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVs() != null && this.feN.getPbData().aVs().sB()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void aXr() {
        if (this.few) {
            this.feJ = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.feN.getPbData() != null && this.feN.getPbData().aVs() != null && this.feN.getPbData().aVs().rA() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.feN.getPbData().aVs().rA().getThreadId(), this.feN.getPbData().aVs().rA().getTaskId(), this.feN.getPbData().aVs().rA().getForumId(), this.feN.getPbData().aVs().rA().getForumName(), this.feN.getPbData().aVs().rL(), this.feN.getPbData().aVs().rM())));
            this.fev = true;
            finish();
        }
    }

    public String aXs() {
        return this.feH;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a aXt() {
        return this.feM;
    }

    public void jB(boolean z) {
        this.feI = z;
    }

    public boolean aXu() {
        if (this.feN != null) {
            return this.feN.aYl();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dc(getResources().getString(d.k.mute_is_super_member_function));
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.ffg).showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.ffg.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.ffg).tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(String str) {
        if (str == null) {
            str = "";
        }
        if (this.ffg != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ffg.getPageActivity());
            aVar.dc(str);
            aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.ffg).tD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.feO.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ffg.getPageActivity());
        if (com.baidu.tbadk.core.util.an.isEmpty(str)) {
            aVar.dc(this.ffg.getResources().getString(d.k.block_mute_message_alert, str2));
        } else {
            aVar.dc(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.feO.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.ffg).tD();
    }

    public void aXw() {
        if (this.feN != null && this.feN.getPbData() != null && this.feN.getPbData().aVs() != null && this.feN.getPbData().aVs().sQ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bZ(d.k.channel_open_push_message);
            aVar.a(d.k.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.feN.getPbData().aVs().sQ().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.98
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.k.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.tD();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ax.qG(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.feO != null) {
            this.feO.onConfigurationChanged(configuration);
        }
        if (this.feU != null) {
            this.feU.dismiss();
        }
    }

    public boolean aXx() {
        if (this.feN != null) {
            return this.feN.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, as asVar) {
        boolean z;
        List<PostData> list = this.feN.getPbData().aVD().fcX;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).brW().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).brW().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).brW().remove(i2);
                    list.get(i).brY();
                    z = true;
                    break;
                }
            }
            list.get(i).sT(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            asVar.n(this.feN.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.aWc().getId();
        List<PostData> list = this.feN.getPbData().aVD().fcX;
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
                ArrayList<PostData> aWg = kVar.aWg();
                postData.tn(kVar.getTotalCount());
                if (postData.brW() != null) {
                    postData.brW().clear();
                    postData.brW().addAll(aWg);
                }
            }
        }
        if (!this.feN.getIsFromMark()) {
            this.feO.n(this.feN.getPbData());
        }
    }

    public boolean aXy() {
        if (this.feN == null) {
            return false;
        }
        return this.feN.aXy();
    }

    public void aXz() {
        if (this.feO != null) {
            this.feO.aZF();
            apD();
        }
    }

    public PostData aVz() {
        return this.feO.b(this.feN.fkn, this.feN.aYk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ac(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.isLinkThread()) {
                return 3;
            }
            if (bdVar.sS()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ffq != null && !this.ffq.isEmpty()) {
            int size = this.ffq.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.ffq.get(i).onBackPressed()) {
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
            if (this.ffq == null) {
                this.ffq = new ArrayList();
            }
            if (!this.ffq.contains(aVar)) {
                this.ffq.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.ffq == null) {
                this.ffq = new ArrayList();
            }
            if (!this.ffq.contains(aVar)) {
                this.ffq.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.ffq != null) {
            this.ffq.remove(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.cXT == null) {
            this.cXT = new com.baidu.tbadk.core.dialog.i(getPageContext());
        }
        this.cXT.a(contriInfo, -1L);
    }
}
