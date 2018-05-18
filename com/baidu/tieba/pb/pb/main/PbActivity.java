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
    private com.baidu.adp.lib.e.b<ImageView> aWo;
    private com.baidu.adp.lib.e.b<TextView> aWp;
    private com.baidu.adp.lib.e.b<View> aWq;
    private com.baidu.adp.lib.e.b<LinearLayout> aWr;
    private com.baidu.adp.lib.e.b<RelativeLayout> aWs;
    private com.baidu.adp.lib.e.b<GifView> aWt;
    private com.baidu.adp.lib.e.b<TbImageView> aqg;
    private com.baidu.tbadk.core.util.b.a baE;
    private com.baidu.tieba.f.b bzr;
    private com.baidu.tbadk.core.dialog.i cYX;
    private VoiceManager cYn;
    public com.baidu.tbadk.core.util.ai epb;
    private com.baidu.tieba.pb.pb.main.emotion.model.a ffO;
    private View ffP;
    public au ffX;
    private x ffY;
    private String ffs;
    private com.baidu.tieba.pb.pb.main.a.b ffy;
    private boolean fgW;
    private boolean fga;
    private com.baidu.tieba.tbadkCore.data.e fgd;
    private com.baidu.tbadk.editortools.pb.f fge;
    private com.baidu.tbadk.editortools.pb.d fgf;
    private EmotionImageData fgh;
    private com.baidu.adp.base.e fgk;
    private com.baidu.tbadk.core.view.b fgl;
    private BdUniqueId fgm;
    private Runnable fgn;
    private aw fgo;
    private com.baidu.adp.widget.ImageView.a fgp;
    private String fgq;
    private TbRichTextMemeInfo fgr;
    private List<a> fgu;
    private String fhi;
    private com.baidu.tbadk.core.data.n fhj;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private boolean ffx = false;
    private boolean ffz = false;
    private boolean ffA = false;
    private boolean eKx = false;
    private boolean ffB = true;
    private int ffC = 0;
    private com.baidu.tbadk.core.dialog.b ffD = null;
    private long cIX = -1;
    private long aKW = 0;
    private long ffE = 0;
    private long createTime = 0;
    private long aKO = 0;
    private boolean ffF = false;
    private com.baidu.tbadk.k.d ffG = null;
    private long ffH = 0;
    private boolean ffI = false;
    private long ffJ = 0;
    private String aEB = null;
    private boolean ffK = false;
    private boolean isFullScreen = false;
    private String ffL = "";
    private boolean ffM = true;
    private boolean ffN = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a ffQ = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void q(boolean z) {
            PbActivity.this.ffS.kh(!PbActivity.this.ffM);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.ffR != null && PbActivity.this.ffR.oH()) {
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
    private PbModel ffR = null;
    private com.baidu.tbadk.baseEditMark.a eHB = null;
    private ForumManageModel cqN = null;
    private com.baidu.tbadk.coreExtra.model.a ait = null;
    private ShareSuccessReplyToServerModel dmp = null;
    private as ffS = null;
    public final com.baidu.tieba.pb.pb.main.a.a ffT = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean ffU = false;
    private boolean ffV = false;
    private boolean ffW = false;
    private boolean ffZ = false;
    private boolean fgb = false;
    private boolean fgc = false;
    private boolean fgg = false;
    public boolean fgi = false;
    private com.baidu.tbadk.editortools.pb.c aEE = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Eb() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aEF = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ea() {
            if (PbActivity.this.ffX == null || PbActivity.this.ffX.baQ() == null || !PbActivity.this.ffX.baQ().bAU()) {
                return !PbActivity.this.qc(com.baidu.tbadk.core.util.ai.aio);
            }
            PbActivity.this.showToast(PbActivity.this.ffX.baQ().bAW());
            if (PbActivity.this.fgf != null && (PbActivity.this.fgf.Eo() || PbActivity.this.fgf.Ep())) {
                PbActivity.this.fgf.a(false, PbActivity.this.ffX.baT());
            }
            PbActivity.this.ffX.ks(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fgj = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ea() {
            if (PbActivity.this.ffX == null || PbActivity.this.ffX.baR() == null || !PbActivity.this.ffX.baR().bAU()) {
                return !PbActivity.this.qc(com.baidu.tbadk.core.util.ai.aip);
            }
            PbActivity.this.showToast(PbActivity.this.ffX.baR().bAW());
            if (PbActivity.this.ffS != null && PbActivity.this.ffS.aZH() != null && PbActivity.this.ffS.aZH().aYa() != null && PbActivity.this.ffS.aZH().aYa().Ep()) {
                PbActivity.this.ffS.aZH().aYa().a(PbActivity.this.ffX.baT());
            }
            PbActivity.this.ffX.kt(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean cYT = false;
    private int fgs = 0;
    private int fgt = -1;
    private final a fgv = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.ffS != null && PbActivity.this.ffS.aZH() != null) {
                r aZH = PbActivity.this.ffS.aZH();
                if (aZH.aXX()) {
                    aZH.aXW();
                    return true;
                }
            }
            if (PbActivity.this.ffS != null && PbActivity.this.ffS.bay()) {
                PbActivity.this.ffS.baz();
                return true;
            }
            return false;
        }
    };
    private q.b fgw = new q.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // com.baidu.tieba.pb.pb.main.q.b
        public void c(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private AddExperiencedModel.a cYZ = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.aXj();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final y.a fgx = new y.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void D(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.ffS.showToast(str);
            }
        }
    };
    private final CustomMessageListener fgy = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.ffR != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fgf != null) {
                    PbActivity.this.ffS.km(PbActivity.this.fgf.Ei());
                }
                PbActivity.this.ffS.aZI();
                PbActivity.this.ffS.bar();
            }
        }
    };
    CustomMessageListener cZp = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                PbActivity.this.ffR.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                if (PbActivity.this.ffS != null && PbActivity.this.ffR != null) {
                    PbActivity.this.ffS.d(PbActivity.this.ffR.getPbData(), PbActivity.this.ffR.aYk(), PbActivity.this.ffR.getRequestType());
                }
                if (PbActivity.this.ffS != null && PbActivity.this.ffS.aZY() != null) {
                    PbActivity.this.ffS.aZY().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fgz = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.ffS != null) {
                    if (booleanValue) {
                        PbActivity.this.ffS.aFd();
                    } else {
                        PbActivity.this.ffS.aFc();
                    }
                }
            }
        }
    };
    private CustomMessageListener fgA = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fgf != null) {
                    PbActivity.this.ffS.km(PbActivity.this.fgf.Ei());
                }
                PbActivity.this.ffS.ko(false);
            }
        }
    };
    private CustomMessageListener fgB = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
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
    private CustomMessageListener fgC = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.ffS != null && PbActivity.this.ffS.aZY() != null) {
                PbActivity.this.ffS.aZY().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dSO = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fgD = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.qe(2);
                ai.aZr().reset();
                PbActivity.this.ffR.aYC();
                boolean z2 = false;
                ArrayList<PostData> aVu = PbActivity.this.ffR.getPbData().aVu();
                if (aVu != null) {
                    Iterator<PostData> it = aVu.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ar.j(next) && next.bsg().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.ffS.n(PbActivity.this.ffR.getPbData());
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
    private View.OnClickListener aFl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbActivity.this.showToast(PbActivity.this.aEB);
        }
    };
    private CustomMessageListener fgE = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z)) {
                com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
                an.a aVar = new an.a();
                aVar.giftId = zVar.id;
                aVar.giftName = zVar.name;
                aVar.thumbnailUrl = zVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.ffR.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.ffR.aYt() != null && PbActivity.this.ffR.aYt().getUserIdLong() == zVar.toUserId) {
                        PbActivity.this.ffS.a(zVar.sendCount, PbActivity.this.ffR.getPbData(), PbActivity.this.ffR.aYk(), PbActivity.this.ffR.getRequestType());
                    }
                    if (pbData.aVu() != null && pbData.aVu().size() >= 1 && pbData.aVu().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aVu().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.ffR.aYj(), 0L);
                        if (c2 == zVar.postId && c3 == zVar.threadId) {
                            com.baidu.tbadk.core.data.an bsf = pbData.aVu().get(0).bsf();
                            if (bsf == null) {
                                bsf = new com.baidu.tbadk.core.data.an();
                            }
                            ArrayList<an.a> re = bsf.re();
                            if (re == null) {
                                re = new ArrayList<>();
                            }
                            re.add(0, aVar);
                            bsf.bK(zVar.sendCount + bsf.rd());
                            bsf.g(re);
                            pbData.aVu().get(0).a(bsf);
                            PbActivity.this.ffS.aZY().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a fgF = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.alA() != null && !aVar.alA().isEmpty()) {
                    PbActivity.this.ffS.a(aVar, PbActivity.this.fgH);
                }
                PbActivity.this.ffS.a(aVar, PbActivity.this.ffR.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.baW()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fgG = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void D(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.w(list) && PbActivity.this.ffS != null) {
                PbActivity.this.ffS.cR(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fgH = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
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
    private boolean fgI = false;
    private PraiseModel fgJ = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void io(String str) {
            PbActivity.this.fgI = false;
            if (PbActivity.this.fgJ != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.ffR.getPbData();
                if (pbData.aVs().rE().getIsLike() == 1) {
                    PbActivity.this.kr(0);
                } else {
                    PbActivity.this.kr(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.aVs()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void R(int i, String str) {
            PbActivity.this.fgI = false;
            if (PbActivity.this.fgJ != null && str != null) {
                if (AntiHelper.ts(i)) {
                    AntiHelper.am(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fgK = 0;
    private boolean fgL = true;
    private b.a fgM = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jD(boolean z) {
            PbActivity.this.jC(z);
            if (PbActivity.this.ffS.baE() != null && z) {
                PbActivity.this.ffS.kh(false);
            }
            PbActivity.this.ffS.kj(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aup != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aup, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12534").r("obj_locate", ar.a.aje));
                        }
                    } else if (updateAttentionMessage.getData().Ai) {
                        if (PbActivity.this.aVz().rP() != null && PbActivity.this.aVz().rP().getGodUserData() != null) {
                            PbActivity.this.aVz().rP().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVs() != null && PbActivity.this.ffR.getPbData().aVs().rP() != null) {
                            PbActivity.this.ffR.getPbData().aVs().rP().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bRn = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.ffS.aav();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.qf(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.awI();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.k.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aWy = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view2, MotionEvent motionEvent) {
            if (PbActivity.this.ffS.aZJ()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.ffR != null && (PbActivity.this.ffR.getPbData() != null || PbActivity.this.ffR.getPbData().aVO() != null)) {
                    if (PbActivity.this.ffR.getPbData().aVO().aVW()) {
                        if (PbActivity.this.ffR.getPbData().aVO().fdK == 1 || PbActivity.this.ffR.getPbData().aVO().fdK == 3 || PbActivity.this.ffR.getPbData().aVO().fdK == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.ffR.getPbData().aVO().aVW() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.ffR.getPbData().aVO().aVW() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.ffJ > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kO(false);
                        PbActivity.this.ffJ = System.currentTimeMillis();
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
                    if (PbActivity.this.ffS != null && PbActivity.this.ffS.aWP() && view2.getId() == d.g.pb_head_user_info_root) {
                        if (view2.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10630").ac(VideoPlayActivityConfig.OBJ_ID, (String) view2.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.ffT != null && PbActivity.this.ffT.fto != null) {
                            PbActivity.this.ffT.fto.onClick(view2);
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
            if (PbActivity.this.fgf != null) {
                PbActivity.this.ffS.km(PbActivity.this.fgf.Ei());
            }
            PbActivity.this.ffS.aZI();
            PbActivity.this.ffS.bar();
            return true;
        }
    });
    private CustomMessageListener fgN = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fgm) {
                PbActivity.this.ffS.aav();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.ffR.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aVG().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fgl.i(PbActivity.this.fgk.getResources().getString(d.k.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fgk.getResources().getString(d.k.mute_error_beyond_limit);
                    }
                    PbActivity.this.gt(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aXv();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.an.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fgk.getResources().getString(d.k.mute_fail);
                    }
                    PbActivity.this.fgl.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fgO = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fgm) {
                PbActivity.this.ffS.aav();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fgl.i(PbActivity.this.fgk.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.an.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fgk.getResources().getString(d.k.un_mute_fail);
                }
                PbActivity.this.fgl.j(muteMessage);
            }
        }
    };
    private CustomMessageListener fgP = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fgm) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.ffS.aav();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gKB;
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
                    PbActivity.this.ffS.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fgQ = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.ffS.aZJ() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aWx() != null && PbActivity.this.aWx().getPbData() != null && PbActivity.this.aWx().getPbData().aVO() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aVW = PbActivity.this.aWx().getPbData().aVO().aVW();
                if (intValue < 10) {
                    if (aVW) {
                        if (PbActivity.this.ffR.getPbData().aVO().fdK == 1 || PbActivity.this.ffR.getPbData().aVO().fdK == 3 || PbActivity.this.ffR.getPbData().aVO().fdK == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.ffR.getPbData().aVO().aVW() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVW ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.ffJ > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kO(false);
                        PbActivity.this.ffJ = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aVW, 3);
                TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aVW ? 0 : 1));
            }
        }
    };
    private CustomMessageListener cZx = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cYT = true;
                }
            }
        }
    };
    public a.b eUm = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.apC();
            com.baidu.tbadk.core.data.am azm = PbActivity.this.ffR.azm();
            int pageNum = PbActivity.this.ffS.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.k.pb_page_error);
            } else if (azm == null || pageNum <= azm.qW()) {
                PbActivity.this.ffS.bar();
                PbActivity.this.qe(2);
                PbActivity.this.apB();
                PbActivity.this.ffS.bac();
                if (com.baidu.adp.lib.util.j.gP()) {
                    PbActivity.this.ffR.qm(PbActivity.this.ffS.getPageNum());
                    if (PbActivity.this.ffy != null) {
                        PbActivity.this.ffy.showFloatingView();
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
    public final View.OnClickListener cZX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
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
                    if (view2 == PbActivity.this.ffS.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.ffR.jN(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.ffS.bad();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aZk()) {
                        if (view2 == PbActivity.this.ffS.fpd.aMT) {
                            if (PbActivity.this.ffS.kl(PbActivity.this.ffR.aYq())) {
                                PbActivity.this.apB();
                                return;
                            }
                            PbActivity.this.ffB = false;
                            PbActivity.this.ffz = false;
                            PbActivity.this.finish();
                        } else if (view2 != PbActivity.this.ffS.baa() && (PbActivity.this.ffS.fpd.bbi() == null || (view2 != PbActivity.this.ffS.fpd.bbi().aZj() && view2 != PbActivity.this.ffS.fpd.bbi().aZh()))) {
                            if (view2 == PbActivity.this.ffS.bau()) {
                                if (PbActivity.this.ffR != null) {
                                    com.baidu.tbadk.browser.a.M(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.ffR.getPbData().aVs().rO().getLink());
                                }
                            } else if (view2 != PbActivity.this.ffS.fpd.ftY && view2.getId() != d.g.view_forum_name) {
                                if (view2 == PbActivity.this.ffS.fpd.ftZ) {
                                    if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null) {
                                        ArrayList<PostData> aVu = PbActivity.this.ffR.getPbData().aVu();
                                        if ((aVu == null || aVu.size() <= 0) && PbActivity.this.ffR.aYk()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12378").ac("tid", PbActivity.this.ffR.aYj()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getForumId()));
                                        if (!PbActivity.this.ffS.baJ()) {
                                            PbActivity.this.ffS.aZI();
                                        }
                                        PbActivity.this.aWX();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view2.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aYV()) {
                                        if ((PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aZg()) && view2.getId() != d.g.floor_owner_reply && view2.getId() != d.g.reply_title) {
                                            if (PbActivity.this.ffS.fpd.bbi() == null || (view2 != PbActivity.this.ffS.fpd.bbi().getCancelView() && view2 != PbActivity.this.ffS.fpd.bbi().aZf())) {
                                                if (view2 != PbActivity.this.ffS.fpd.fua && view2.getId() != d.g.tv_share && view2.getId() != d.g.share_container) {
                                                    if (PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aZd()) {
                                                        if ((PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aZm()) && view2.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aZe()) {
                                                                if (PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aZn()) {
                                                                    if (PbActivity.this.ffY == null || view2 != PbActivity.this.ffY.aYX()) {
                                                                        if (PbActivity.this.ffY == null || view2 != PbActivity.this.ffY.aYV()) {
                                                                            if (PbActivity.this.ffY == null || view2 != PbActivity.this.ffY.aZa()) {
                                                                                if (PbActivity.this.ffY == null || view2 != PbActivity.this.ffY.aYY()) {
                                                                                    if (PbActivity.this.ffY == null || view2 != PbActivity.this.ffY.aYZ()) {
                                                                                        if (PbActivity.this.ffS.baE() == view2) {
                                                                                            if (PbActivity.this.ffS.baE().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.d pbData = PbActivity.this.ffR.getPbData();
                                                                                                if (pbData != null && pbData.aVs() != null && pbData.aVs().rz() != null) {
                                                                                                    String qv = pbData.aVs().rz().qv();
                                                                                                    if (StringUtils.isNull(qv)) {
                                                                                                        qv = pbData.aVs().rz().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11107").ac(VideoPlayActivityConfig.OBJ_ID, qv));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cc("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.aXr();
                                                                                        } else if (PbActivity.this.ffS.aZX() != view2) {
                                                                                            if (PbActivity.this.ffY == null || view2 != PbActivity.this.ffY.aYW()) {
                                                                                                if (PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aZl()) {
                                                                                                    if (PbActivity.this.ffS.fpd.bbi() != null && view2 == PbActivity.this.ffS.fpd.bbi().aZi()) {
                                                                                                        if (com.baidu.adp.lib.util.j.gP()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.ffS.c(PbActivity.this.ffR.getPbData(), PbActivity.this.ffR.aYk(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.ffS.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.ffS.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.ffS.fpd.pq();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.k.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view2.getId() != d.g.sub_pb_more && view2.getId() != d.g.sub_pb_item && view2.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view2 != PbActivity.this.ffS.aWI()) {
                                                                                                            if (view2 == PbActivity.this.ffS.fpd.bbj()) {
                                                                                                                PbActivity.this.ffS.baj();
                                                                                                            } else {
                                                                                                                int id = view2.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (biVar = (bi) view2.getTag()) != null && !StringUtils.isNull(biVar.tr())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        com.baidu.tbadk.core.util.ax.wf().c(PbActivity.this.getPageContext(), new String[]{biVar.tr()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view2 instanceof PbFloorAgreeView)) {
                                                                                                                    PostData aW = PbActivity.this.aW(view2);
                                                                                                                    if (aW != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, aW.bsj() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view2, 2, false, 1);
                                                                                                                    if (PbActivity.this.aWx() != null && PbActivity.this.aWx().getPbData() != null && PbActivity.this.aWx().getPbData().aVO() != null && PbActivity.this.aWx().getPbData().aVO() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aWS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.aWx().getPbData().aVO().aVW() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view2 != null && (view2.getTag() instanceof Boolean) && ((Boolean) view2.getTag()).booleanValue() && PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && !StringUtils.isNull(PbActivity.this.ffR.getPbData().getThreadId()) && (aVO = PbActivity.this.ffR.getPbData().aVO()) != null && aVO.aVU() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.ax.wf().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.ffR.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view2 != null && view2.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view2.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.ffY == null) {
                                                                                                                                PbActivity.this.ffY = new x(PbActivity.this.getPageContext(), PbActivity.this.cZX);
                                                                                                                                PbActivity.this.ffS.bg(PbActivity.this.ffY.getView());
                                                                                                                                PbActivity.this.ffY.jR(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.ffY.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12006").ac("tid", PbActivity.this.ffR.fkZ));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view2.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.ffY.aYV().setTag(sparseArray2);
                                                                                                                            PbActivity.this.ffY.aZa().setTag(view2.getTag());
                                                                                                                            PbActivity.this.ffY.jT(z6);
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
                                                                                                                                    PbActivity.this.ffY.aYY().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.ffY.aYY().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.ffY.aYW().setTag(sparseArray4);
                                                                                                                                PbActivity.this.ffY.aYY().setTag(sparseArray4);
                                                                                                                                PbActivity.this.ffY.aYW().setText(d.k.bar_manager);
                                                                                                                                PbActivity.this.ffY.aYW().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.ffY.aYW().setVisibility(8);
                                                                                                                                PbActivity.this.ffY.aYY().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.ffY.aYW().setTag(sparseArray5);
                                                                                                                                PbActivity.this.ffY.aYY().setTag(sparseArray5);
                                                                                                                                PbActivity.this.ffY.aYW().setText(d.k.delete);
                                                                                                                                PbActivity.this.ffY.aYY().setVisibility(0);
                                                                                                                                if (PbActivity.this.ffR.getPbData().aVE() != 1002 || z2) {
                                                                                                                                    PbActivity.this.ffY.aYY().setText(d.k.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.ffY.aYY().setText(d.k.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.ffY.aYW().setVisibility(8);
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
                                                                                                                                PbActivity.this.ffY.aYX().setTag(sparseArray7);
                                                                                                                                PbActivity.this.ffY.aYX().setVisibility(0);
                                                                                                                                PbActivity.this.ffY.aYW().setVisibility(8);
                                                                                                                                PbActivity.this.ffY.aYX().setText(d.k.mute_option);
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
                                                                                                                                boolean jy = PbActivity.this.jy(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fha = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (ar.j(PbActivity.this.fha) ? false : jy) {
                                                                                                                                    PbActivity.this.ffY.aYX().setVisibility(0);
                                                                                                                                    PbActivity.this.ffY.aYX().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.ffY.aYX().setVisibility(8);
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
                                                                                                                                PbActivity.this.ffY.aYZ().setVisibility(0);
                                                                                                                                PbActivity.this.ffY.aYZ().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.ffY.aYZ().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.ffY.aYZ().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.ffY.aYZ().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.ffR.getPbData().oH()) {
                                                                                                                            String oG = PbActivity.this.ffR.getPbData().oG();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(oG) && oG.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.ffY.aYV().setText(d.k.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.ffY.aYV().setText(d.k.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.ffY.jS(true);
                                                                                                                                PbActivity.this.ffY.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.ffY.jS(true);
                                                                                                                        PbActivity.this.ffY.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVs() != null && PbActivity.this.ffR.getPbData().aVs().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.M(PbActivity.this.getActivity(), PbActivity.this.ffR.getPbData().aVs().getActUrl());
                                                                                                                        if (PbActivity.this.ffR.getPbData().aVs().sr() != 1) {
                                                                                                                            if (PbActivity.this.ffR.getPbData().aVs().sr() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view2.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view2.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10912").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getPbData().getForumId()).ac("tid", PbActivity.this.ffR.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.ffR.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.ffS.setSelection(0);
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
                                                                                                                        PbActivity.this.ffS.aZI();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view2 != null) {
                                                                                                                        com.baidu.tbadk.browser.a.M(PbActivity.this.getActivity(), (String) view2.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aWU() == 1 && PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10397").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getPbData().getForumId()).ac("tid", PbActivity.this.ffR.getPbData().getThreadId()).ac("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view2 != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.M(PbActivity.this.getActivity(), (String) view2.getTag());
                                                                                                                        if (PbActivity.this.aWU() == 1 && PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10507").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getPbData().getForumId()).ac("tid", PbActivity.this.ffR.getPbData().getThreadId()).ac("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.aXm();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.aXn();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVK() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.ffR.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11679").ac(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.ax.wf().c(PbActivity.this.getPageContext(), new String[]{pbData2.aVK().aVT()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVK() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.ffR.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11678").ac(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.ax.wf().c(PbActivity.this.getPageContext(), new String[]{pbData3.aVK().aVT()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.ffS.fpd.bbi() != null && view2 == PbActivity.this.ffS.fpd.bbi().aZo()) {
                                                                                                                    if (PbActivity.this.ffR == null || PbActivity.this.ffR.getPbData() == null || PbActivity.this.ffR.getPbData().aVs() == null) {
                                                                                                                        PbActivity.this.ffS.fpd.pq();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.hg()) {
                                                                                                                        PbActivity.this.showToast(d.k.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.ffR.getPbData().aVs().rA() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.ffR.aYj(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.k.haved_fans_called)).tK();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12399").r("obj_locate", PbActivity.this.ac(PbActivity.this.ffR.getPbData().aVs())).ac("tid", PbActivity.this.ffR.getPbData().aVs().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.fgs >= 0) {
                                                                                                                        if (PbActivity.this.ffR != null) {
                                                                                                                            PbActivity.this.ffR.aYQ();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.ffS.aZY() != null) {
                                                                                                                            PbActivity.this.ffS.aZY().a(PbActivity.this.ffR.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.ffS.getListView().setSelection(PbActivity.this.ffR.aYT());
                                                                                                                        PbActivity.this.fgs = 0;
                                                                                                                        if (PbActivity.this.ffR != null) {
                                                                                                                            PbActivity.this.ffR.bo(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.ffS.baM();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view2.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view2.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.ffR.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.ffR.aYj(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.ffR.getPbData().aVs().si())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.ffR.getPbData() != null) {
                                                                                                            PbActivity.this.ffS.bar();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view2.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view3 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view3 != null) {
                                                                                                                if (postData3.bsl() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12630"));
                                                                                                                }
                                                                                                                String aYj = PbActivity.this.ffR.aYj();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.ffR.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.ffR.getPbData().aVE();
                                                                                                                }
                                                                                                                PbActivity.this.apB();
                                                                                                                if (view2.getId() == d.g.replybtn) {
                                                                                                                    c qy = PbActivity.this.qy(id2);
                                                                                                                    if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && qy != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aYj, id2, "pb", true, null, true, null, i3, postData3.bbZ(), PbActivity.this.ffR.getPbData().qS(), false, postData3.rP().getIconInfo()).addBigImageData(qy.fhK, qy.fhL, qy.fhM, qy.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.ffR.aYP());
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
                                                                                                                    c qy2 = PbActivity.this.qy(id2);
                                                                                                                    if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && qy2 != null && PbActivity.this.aWO().aZG() != null) {
                                                                                                                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                                                        kVar.a(PbActivity.this.ffR.getPbData().aVq());
                                                                                                                        kVar.T(PbActivity.this.ffR.getPbData().aVs());
                                                                                                                        kVar.d(postData4);
                                                                                                                        PbActivity.this.aWO().aZG().d(kVar);
                                                                                                                        PbActivity.this.aWO().aZG().setPostId(str7);
                                                                                                                        PbActivity.this.b(view2, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c qy3 = PbActivity.this.qy(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && qy3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aYj, id2, "pb", true, null, false, null, i3, postData3.bbZ(), PbActivity.this.ffR.getPbData().qS(), false, postData3.rP().getIconInfo()).addBigImageData(qy3.fhK, qy3.fhL, qy3.fhM, qy3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.ffR.aYP());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10517").r("obj_locate", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.gP()) {
                                                                                                    PbActivity.this.ffS.bar();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.ffS.c(PbActivity.this.ffR.getPbData(), PbActivity.this.ffR.aYk(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.ffR.getPbData().aVq().getId(), PbActivity.this.ffR.getPbData().aVq().getName(), PbActivity.this.ffR.getPbData().aVs().getId(), String.valueOf(PbActivity.this.ffR.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
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
                                                                                                    if (!com.baidu.tieba.c.a.aeW() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.ffR.aYj(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.ffS.be(view2);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.ffS.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getPbData().getForumId()));
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
                                                                                        com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.ffR.getPbData();
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
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.ffR.aYj(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.ffS.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.ffY.aZc()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12007").ac("tid", PbActivity.this.ffR.fkZ));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.ffR.getPbData() != null) {
                                                                                    PbActivity.this.ffS.bar();
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
                                                                                        String aYj2 = PbActivity.this.ffR.aYj();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.ffR.getPbData() != null) {
                                                                                            i5 = PbActivity.this.ffR.getPbData().aVE();
                                                                                        }
                                                                                        PbActivity.this.apB();
                                                                                        c qy4 = PbActivity.this.qy(id3);
                                                                                        if (qy4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aYj2, id3, "pb", true, null, true, null, i5, postData.bbZ(), PbActivity.this.ffR.getPbData().qS(), false, postData.rP().getIconInfo()).addBigImageData(qy4.fhK, qy4.fhL, qy4.fhM, qy4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.ffR.aYP());
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
                                                                                if (PbActivity.this.ffR.getPbData().aVs() != null && PbActivity.this.ffR.getPbData().aVs().rP() != null && PbActivity.this.ffR.getPbData().aVs().rP().getUserId() != null && PbActivity.this.eHB != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12526").ac("tid", PbActivity.this.ffR.fkZ).r("obj_locate", 2).ac(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.ffR.getPbData().aVs().rP().getUserId()).r("obj_type", PbActivity.this.eHB.oH() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.ffR.getPbData())));
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
                                                                            PbActivity.this.qv((String) tag);
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
                                                                    PbActivity.this.ffS.fpd.bbh();
                                                                }
                                                            } else if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVs() != null) {
                                                                PbActivity.this.ffS.fpd.pq();
                                                                PbActivity.this.qv(PbActivity.this.ffR.getPbData().aVs().sf());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.ffS.bar();
                                                            if (com.baidu.adp.lib.util.j.gP()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view2.setTag(Boolean.valueOf(PbActivity.this.ffR.aYx()));
                                                                    return;
                                                                }
                                                                PbActivity.this.qe(2);
                                                                PbActivity.this.apB();
                                                                PbActivity.this.ffS.bac();
                                                                boolean aYw = PbActivity.this.ffR.aYw();
                                                                view2.setTag(Boolean.valueOf(PbActivity.this.ffR.aYx()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.ffS.fpd != null && PbActivity.this.ffS.fpd.bbi() != null && view2 == PbActivity.this.ffS.fpd.bbi().aZm()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view2.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (aYw) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.ffS.kc(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.k.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.ffS.bar();
                                                        if (PbActivity.this.ffR.azm() != null) {
                                                            PbActivity.this.ffS.a(PbActivity.this.ffR.azm(), PbActivity.this.eUm);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.ap.fz() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.ffR != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12386").ac("tid", PbActivity.this.ffR.aYj()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.hg()) {
                                                        if (PbActivity.this.ffR.getPbData() != null) {
                                                            ArrayList<PostData> aVu2 = PbActivity.this.ffR.getPbData().aVu();
                                                            if ((aVu2 != null && aVu2.size() > 0) || !PbActivity.this.ffR.aYk()) {
                                                                PbActivity.this.ffS.bar();
                                                                PbActivity.this.apB();
                                                                PbActivity.this.qe(2);
                                                                if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVK() != null && !StringUtils.isNull(PbActivity.this.ffR.getPbData().aVK().qF(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11678").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11939"));
                                                                if (com.baidu.tbadk.o.ap.fz()) {
                                                                    PbActivity.this.qf(2);
                                                                } else {
                                                                    PbActivity.this.ffS.showLoadingDialog();
                                                                    PbActivity.this.ffR.aYK().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.ffS.fpd.pq();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.gP()) {
                                            PbActivity.this.ffS.bar();
                                            if (PbActivity.this.ffS.fpd.bbi() != null && view2 == PbActivity.this.ffS.fpd.bbi().aZg() && !PbActivity.this.ffS.baJ()) {
                                                PbActivity.this.ffS.aZI();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.apB();
                                                PbActivity.this.ffS.bac();
                                                if (view2.getId() == d.g.floor_owner_reply) {
                                                    l = PbActivity.this.ffR.l(true, PbActivity.this.aXk());
                                                } else {
                                                    l = view2.getId() == d.g.reply_title ? PbActivity.this.ffR.l(false, PbActivity.this.aXk()) : PbActivity.this.ffR.qz(PbActivity.this.aXk());
                                                }
                                                view2.setTag(Boolean.valueOf(l));
                                                if (l) {
                                                    PbActivity.this.ffS.jH(true);
                                                    PbActivity.this.ffS.aFd();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.ffS.kc(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.qe(2);
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
                                        PbActivity.this.ffS.bar();
                                        if (PbActivity.this.qd(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.ffR.qr(PbActivity.this.ffS.bah()) != null) {
                                            PbActivity.this.aXe();
                                            if (PbActivity.this.ffR.getPbData().aVs() != null && PbActivity.this.ffR.getPbData().aVs().rP() != null && PbActivity.this.ffR.getPbData().aVs().rP().getUserId() != null && PbActivity.this.eHB != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12526").ac("tid", PbActivity.this.ffR.fkZ).r("obj_locate", 1).ac(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.ffR.getPbData().aVs().rP().getUserId()).r("obj_type", PbActivity.this.eHB.oH() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.ffR.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.k.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.gP()) {
                                    PbActivity.this.ffS.jH(true);
                                    PbActivity.this.ffS.aZI();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.ffS.aFd();
                                        PbActivity.this.apB();
                                        PbActivity.this.ffS.bac();
                                        PbActivity.this.ffR.qz(PbActivity.this.aXk());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.qe(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(d.k.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVs() != null && PbActivity.this.ffR.getPbData().aVs().sA() && PbActivity.this.ffR.getPbData().aVs().sg() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11922"));
                                }
                                if (PbActivity.this.ffR.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.ffR.aYi()) && PbActivity.this.ffR.getAppealInfo() != null) {
                                        name = PbActivity.this.ffR.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.ffR.getPbData().aVq().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aYi = PbActivity.this.ffR.aYi();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.ffR.aYl() && aYi != null && aYi.equals(name)) {
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
                            if (PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVE() == 1 && !PbActivity.this.cqN.bsI()) {
                                PbActivity.this.ffS.bar();
                                int i6 = 0;
                                if (PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aZh()) {
                                    if (PbActivity.this.ffS.fpd.bbi() == null || view2 != PbActivity.this.ffS.fpd.bbi().aZj()) {
                                        if (view2 == PbActivity.this.ffS.baa()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.ffR.getPbData().aVs().rL() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.ffR.getPbData().aVs().rK() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aVq = PbActivity.this.ffR.getPbData().aVq();
                                String name2 = aVq.getName();
                                String id4 = aVq.getId();
                                String id5 = PbActivity.this.ffR.getPbData().aVs().getId();
                                if (!com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.ffS.aZZ();
                                    PbActivity.this.cqN.a(id4, name2, id5, i6, PbActivity.this.ffS.bab());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.k.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.gP()) {
                        PbActivity.this.ffS.bar();
                        PbActivity.this.apB();
                        PbActivity.this.ffS.bac();
                        PbActivity.this.ffS.showLoadingDialog();
                        if (PbActivity.this.ffS.aZP() != null) {
                            PbActivity.this.ffS.aZP().setVisibility(8);
                        }
                        PbActivity.this.ffR.qm(1);
                        if (PbActivity.this.ffy != null) {
                            PbActivity.this.ffy.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.k.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.k.pb_god_reply_title_tag).equals(view2.getTag()) && view2.getId() == d.g.reply_god_title_group) {
                        String aWR = PbActivity.this.aWR();
                        if (!TextUtils.isEmpty(aWR)) {
                            com.baidu.tbadk.core.util.ax.wf().c(PbActivity.this.getPageContext(), new String[]{aWR});
                        }
                    }
                } else if (PbActivity.this.ffI) {
                    PbActivity.this.ffI = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.aWO().aZG() != null && postData5.rP() != null && postData5.brX() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.aWO().aZH() != null) {
                                    PbActivity.this.aWO().aZH().aXV();
                                }
                                com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                                kVar2.a(PbActivity.this.ffR.getPbData().aVq());
                                kVar2.T(PbActivity.this.ffR.getPbData().aVs());
                                kVar2.d(postData5);
                                PbActivity.this.aWO().aZG().d(kVar2);
                                PbActivity.this.aWO().aZG().setPostId(postData5.getId());
                                PbActivity.this.b(view2, postData5.rP().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fgf != null) {
                                    PbActivity.this.ffS.km(PbActivity.this.fgf.Ei());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aEL = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.apB();
            PbActivity.this.ffS.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ag.Hp() && PbActivity.this.aWx() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aWx().qC(postWriteCallBackData.getPostId());
                    PbActivity.this.fgs = PbActivity.this.ffS.aZL();
                    if (PbActivity.this.ffR != null) {
                        PbActivity.this.ffR.bo(PbActivity.this.fgs, PbActivity.this.ffS.aZM());
                    }
                }
                PbActivity.this.ffS.bar();
                PbActivity.this.ffX.baP();
                if (PbActivity.this.fgf != null) {
                    PbActivity.this.ffS.km(PbActivity.this.fgf.Ei());
                }
                PbActivity.this.ffS.aZF();
                PbActivity.this.ffS.ko(true);
                PbActivity.this.ffR.aYz();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.ffR.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.ffR.getPbData();
                            if (pbData != null && pbData.aVs() != null && pbData.aVs().rP() != null && (userId = pbData.aVs().rP().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ag.Hp() && PbActivity.this.ffR.aYs()) {
                                PbActivity.this.ffS.bac();
                            }
                        } else if (!com.baidu.tbadk.o.ag.Hp() && PbActivity.this.ffR.aYs()) {
                            PbActivity.this.ffS.bac();
                        }
                    } else if (floor != null) {
                        PbActivity.this.ffS.n(PbActivity.this.ffR.getPbData());
                    }
                    if (PbActivity.this.ffR.aYo()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10369").ac("tid", PbActivity.this.ffR.aYj()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fgf.Eo() || PbActivity.this.fgf.Ep()) {
                    PbActivity.this.fgf.a(false, postWriteCallBackData);
                }
                PbActivity.this.ffX.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.epb != null) {
                    PbActivity.this.epb.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (tVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fgR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.ffX != null) {
                    PbActivity.this.ffX.baO();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.epb != null) {
                    PbActivity.this.epb.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.ffX != null) {
                if (PbActivity.this.ffS != null && PbActivity.this.ffS.aZH() != null && PbActivity.this.ffS.aZH().aYa() != null && PbActivity.this.ffS.aZH().aYa().Ep()) {
                    PbActivity.this.ffS.aZH().aYa().a(postWriteCallBackData);
                }
                PbActivity.this.ffX.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fgS = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g eF;
            if (!z || dVar == null || dVar.aVC() != null || com.baidu.tbadk.core.util.v.v(dVar.aVu()) >= 1) {
                PbActivity.this.eKx = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.ffS.bae();
                if (dVar == null || !dVar.aVy()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.ffS.getView());
                }
                PbActivity.this.ffS.aFc();
                if (PbActivity.this.isFullScreen || PbActivity.this.ffS.baJ()) {
                    PbActivity.this.ffS.baA();
                } else if (!PbActivity.this.ffS.bax()) {
                    PbActivity.this.ffS.ko(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.ffZ = true;
                }
                if (z && dVar != null) {
                    PbActivity.this.ffS.showListView();
                    if (dVar.aVs() != null && dVar.aVs().sH() != null) {
                        PbActivity.this.a(dVar.aVs().sH());
                    }
                    PbActivity.this.aWL();
                    if (PbActivity.this.fgf != null) {
                        PbActivity.this.ffS.km(PbActivity.this.fgf.Ei());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.aVu() != null && dVar.aVu().size() >= 1 && dVar.aVu().get(0) != null) {
                        PbActivity.this.ffR.qB(dVar.aVu().get(0).getId());
                    } else if (dVar.aVC() != null) {
                        PbActivity.this.ffR.qB(dVar.aVC().getId());
                    }
                    if (PbActivity.this.fgf != null) {
                        PbActivity.this.fgf.a(dVar.qS());
                        PbActivity.this.fgf.a(dVar.aVq(), dVar.getUserData());
                        PbActivity.this.fgf.a(PbActivity.this.ffR.aYt(), PbActivity.this.ffR.aYj(), PbActivity.this.ffR.aYM());
                        if (dVar.aVs() != null) {
                            PbActivity.this.fgf.bE(dVar.aVs().sX());
                        }
                    }
                    if (PbActivity.this.eHB != null) {
                        PbActivity.this.eHB.ae(dVar.oH());
                    }
                    if (dVar == null || dVar.aVF() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.ffS.kn(PbActivity.this.mIsFromCDN);
                    PbActivity.this.ffS.a(dVar, i2, i3, PbActivity.this.ffR.aYk(), i4, PbActivity.this.ffR.getIsFromMark());
                    PbActivity.this.ffS.d(dVar, PbActivity.this.ffR.aYk());
                    PbActivity.this.ffS.kk(PbActivity.this.ffR.getHostMode());
                    AntiData qS = dVar.qS();
                    if (qS != null) {
                        PbActivity.this.aEB = qS.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aEB) && PbActivity.this.fgf != null && PbActivity.this.fgf.DD() != null && (eF = PbActivity.this.fgf.DD().eF(6)) != null && !TextUtils.isEmpty(PbActivity.this.aEB)) {
                            ((View) eF).setOnClickListener(PbActivity.this.aFl);
                        }
                    }
                    if (PbActivity.this.fgb) {
                        PbActivity.this.fgb = false;
                        final int aWZ = PbActivity.this.aWZ();
                        if (dVar.aVP()) {
                            final int af = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.xi() != null) {
                                        PbActivity.this.xi().setSelectionFromTop(aWZ, af);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.aWO().qx(aWZ);
                        }
                    }
                    if (PbActivity.this.fgc) {
                        PbActivity.this.fgc = false;
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
                                        if (aWZ2 != -1 && PbActivity.this.xi() != null) {
                                            if (z2) {
                                                PbActivity.this.xi().setSelectionFromTop(aWZ2, af2);
                                            } else {
                                                PbActivity.this.xi().setSelectionFromTop(aWZ2 - 1, af2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.aWO().qx(aWZ2);
                            }
                        }
                    } else {
                        PbActivity.this.ffS.bai();
                    }
                    PbActivity.this.ffR.a(dVar.aVq(), PbActivity.this.fgF);
                    PbActivity.this.ffR.a(PbActivity.this.fgG);
                    if (PbActivity.this.epb != null && dVar.aVs() != null && dVar.aVs().rP() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.aVs().rP());
                        PbActivity.this.epb.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.ffZ && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.ffR != null && PbActivity.this.ffR.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.ffR.getAppealInfo().fcR)) {
                                    PbActivity.this.ffS.a(PbActivity.this.ffR.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.ffS.getView(), PbActivity.this.getPageContext().getResources().getString(d.k.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.ffS.getView(), PbActivity.this.getPageContext().getResources().getString(d.k.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.ffS.baA();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.ffR.aYj());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getForumId());
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
                        PbActivity.this.ffS.qF(PbActivity.this.getResources().getString(d.k.list_no_more_new));
                    } else {
                        PbActivity.this.ffS.qF("");
                    }
                    PbActivity.this.ffS.wR();
                }
                PbActivity.this.aKW = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aWx().aYk() || PbActivity.this.aWx().getPbData().rf().rc() != 0 || PbActivity.this.aWx().aYF()) {
                    PbActivity.this.fgg = true;
                    return;
                }
                return;
            }
            PbActivity.this.ffR.qm(1);
            if (PbActivity.this.ffy != null) {
                PbActivity.this.ffy.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.ffS.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.p.GY().GZ()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.cIX : j;
                com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, PbActivity.this.aKO, PbActivity.this.createTime, PbActivity.this.aKW, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aKO = 0L;
                if (lVar != null) {
                    lVar.GR();
                }
                if (!z2 && com.baidu.tbadk.core.util.an.equals(PbActivity.this.ffL, PbActivityConfig.KEY_FROM_PERSONALIZE) && PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVs() != null) {
                    int threadType = PbActivity.this.ffR.getPbData().aVs().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        com.baidu.tbadk.k.g gVar = new com.baidu.tbadk.k.g();
                        gVar.pageType = 1;
                        gVar.fj(1005);
                        gVar.aLj = currentTimeMillis;
                        gVar.fk(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fgT = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.aWV();
            }
        }
    };
    private final a.InterfaceC0082a fgU = new a.InterfaceC0082a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0082a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.ffS.bae();
            if (z) {
                if (PbActivity.this.eHB != null) {
                    PbActivity.this.eHB.ae(z2);
                }
                PbActivity.this.ffR.jP(z2);
                if (PbActivity.this.ffR.oH()) {
                    PbActivity.this.aXf();
                } else {
                    PbActivity.this.ffS.n(PbActivity.this.ffR.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.eHB != null && PbActivity.this.eHB.oK() != null && PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVs() != null && PbActivity.this.ffR.getPbData().aVs().rP() != null) {
                        MarkData oK = PbActivity.this.eHB.oK();
                        MetaData rP = PbActivity.this.ffR.getPbData().aVs().rP();
                        if (oK != null && rP != null) {
                            if (!com.baidu.tbadk.core.util.an.equals(TbadkCoreApplication.getCurrentAccount(), rP.getUserId()) && !rP.hadConcerned()) {
                                PbActivity.this.b(rP);
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
            if (!PbActivity.this.qa(PbActivity.this.mLastScrollState) && PbActivity.this.qa(i)) {
                if (PbActivity.this.ffS != null) {
                    PbActivity.this.ffS.bar();
                    if (PbActivity.this.fgf != null && !PbActivity.this.ffS.aZJ()) {
                        PbActivity.this.ffS.km(PbActivity.this.fgf.Ei());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.ffS.aZI();
                    }
                }
                if (!PbActivity.this.ffF) {
                    PbActivity.this.ffF = true;
                    PbActivity.this.ffS.baw();
                }
            }
            PbActivity.this.ffS.onScrollStateChanged(absListView, i);
            if (PbActivity.this.ffy != null) {
                PbActivity.this.ffy.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.ffG == null) {
                PbActivity.this.ffG = new com.baidu.tbadk.k.d();
                PbActivity.this.ffG.fj(1001);
            }
            if (i == 0) {
                PbActivity.this.ffG.GD();
            } else if (i == 1) {
                PbActivity.this.ffG.GD();
            } else {
                PbActivity.this.ffG.GD();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aVu;
            if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffS != null && PbActivity.this.ffS.aZY() != null) {
                PbActivity.this.ffS.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.ffy != null) {
                    PbActivity.this.ffy.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.ffR.aYB() && (aVu = PbActivity.this.ffR.getPbData().aVu()) != null && !aVu.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.ffS.aZY().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.ffR.getPbData();
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
    private final com.baidu.adp.base.d cqR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cqN.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.ffR.aYz();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fvM != 1002 || bVar.dyy) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.ffS.a(1, dVar.yQ, dVar.gzP, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cqN.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.ffS.a(PbActivity.this.cqN.getLoadDataMode(), gVar.yQ, gVar.gzP, false);
                        PbActivity.this.ffS.ao(gVar.gzS);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.ffS.a(PbActivity.this.cqN.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fgV = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final e.b bfk = new e.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            if (PbActivity.this.aXl()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.ffR.jO(true)) {
                PbActivity.this.ffS.baf();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fgX = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fgW && PbActivity.this.aXl()) {
                PbActivity.this.aXn();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.ffR.jN(false)) {
                    PbActivity.this.ffS.bad();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.ffR.getPbData() != null) {
                    PbActivity.this.ffS.bav();
                }
                PbActivity.this.fgW = true;
            }
        }
    };
    private int fgY = 0;
    private final TbRichTextView.h aWx = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view2, String str, int i, boolean z) {
            try {
                if ((view2.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.ffS.b((TbRichText) view2.getTag());
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
                    PbActivity.this.ffP = view2;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fhN) {
                    TbRichText aB = PbActivity.this.aB(str, i);
                    if (aB != null && PbActivity.this.fgY >= 0 && PbActivity.this.fgY < aB.JH().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aB.JH().get(PbActivity.this.fgY));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fhK.size()) {
                                break;
                            } else if (!cVar.fhK.get(i3).equals(b2)) {
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
                            concurrentHashMap.put(str2, cVar.fhL.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fhM, cVar.lastId, PbActivity.this.ffR.aYx(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.fhK, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.w(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fhL.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fhM, cVar.fhK.get(0), PbActivity.this.ffR.aYx(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fgZ = false;
    PostData fha = null;
    private final b.InterfaceC0086b fhb = new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
            bVar.dismiss();
            if (PbActivity.this.fha != null) {
                if (i == 0) {
                    PbActivity.this.fha.bY(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fha = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.e(PbActivity.this.fha);
                }
            }
        }
    };
    private final b.InterfaceC0086b fhc = new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
            bVar.dismiss();
            if (PbActivity.this.fgp != null && !TextUtils.isEmpty(PbActivity.this.fgq)) {
                if (i == 0) {
                    if (PbActivity.this.fgr == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fgq));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fgq;
                        aVar.pkgId = PbActivity.this.fgr.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fgr.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.baE == null) {
                        PbActivity.this.baE = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.baE.wt();
                    PbActivity.this.baE.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.baE.v(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fgo == null) {
                            PbActivity.this.fgo = new aw(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fgo.i(PbActivity.this.fgq, PbActivity.this.fgp.ko());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fgp = null;
                PbActivity.this.fgq = null;
            }
        }
    };
    private final View.OnLongClickListener axX = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            SparseArray sparseArray;
            if (view2 instanceof TbImageView) {
                PbActivity.this.fgp = ((TbImageView) view2).getBdImage();
                PbActivity.this.fgq = ((TbImageView) view2).getUrl();
                if (PbActivity.this.fgp != null && !TextUtils.isEmpty(PbActivity.this.fgq)) {
                    if (view2.getTag(d.g.tag_rich_text_meme_info) == null || !(view2.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fgr = null;
                    } else {
                        PbActivity.this.fgr = (TbRichTextMemeInfo) view2.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.ffS.a(PbActivity.this.fhc, PbActivity.this.fgp.isGif());
                }
            } else if (view2 instanceof GifView) {
                if (((GifView) view2).getBdImage() != null) {
                    PbActivity.this.fgp = ((GifView) view2).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view2).getBdImage().getUrl())) {
                        PbActivity.this.fgq = ((GifView) view2).getBdImage().getUrl();
                    }
                    if (view2.getTag(d.g.tag_rich_text_meme_info) == null || !(view2.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fgr = null;
                    } else {
                        PbActivity.this.fgr = (TbRichTextMemeInfo) view2.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.ffS.a(PbActivity.this.fhc, PbActivity.this.fgp.isGif());
                }
            } else if (view2 instanceof TbMemeImageView) {
                if (((TbMemeImageView) view2).getBdImage() != null) {
                    PbActivity.this.fgp = ((TbMemeImageView) view2).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view2).getBdImage().getUrl())) {
                        PbActivity.this.fgq = ((TbMemeImageView) view2).getBdImage().getUrl();
                    }
                    if (view2.getTag(d.g.tag_rich_text_meme_info) == null || !(view2.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fgr = null;
                    } else {
                        PbActivity.this.fgr = (TbRichTextMemeInfo) view2.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.ffS.a(PbActivity.this.fhc, PbActivity.this.fgp.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fha = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.fha != null && PbActivity.this.eHB != null) {
                        PbActivity.this.ffS.a(PbActivity.this.fhb, PbActivity.this.eHB.oH() && PbActivity.this.fha.getId() != null && PbActivity.this.fha.getId().equals(PbActivity.this.ffR.rY()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a cWl = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!PbActivity.this.ffA && z && !PbActivity.this.ffR.aYr()) {
                PbActivity.this.aXh();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener aNL = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
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
                    if (frameLayout2 != null && (childAt2 instanceof PbMainFloorPraiseFloatingView) && ((PbMainFloorPraiseFloatingView) childAt2).anL()) {
                        break;
                    }
                }
            }
            PbActivity.this.bzr.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0131a bzs = new a.InterfaceC0131a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        final int cbf;

        {
            this.cbf = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void W(int i, int i2) {
            if (T(i2) && PbActivity.this.ffS != null && PbActivity.this.ffy != null) {
                PbActivity.this.ffS.baB();
                PbActivity.this.ffy.fC(false);
                PbActivity.this.ffy.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void X(int i, int i2) {
            if (T(i2) && PbActivity.this.ffS != null && PbActivity.this.ffy != null) {
                PbActivity.this.ffy.fC(true);
                if (Math.abs(i2) > this.cbf) {
                    PbActivity.this.ffy.hideFloatingView();
                }
                if (PbActivity.this.aXl()) {
                    PbActivity.this.ffS.aZU();
                    PbActivity.this.ffS.aZV();
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
    private final b.a fhd = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.f.b.a
        public void eX(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aWp();
            } else {
                com.baidu.tieba.pb.a.b.aWo();
            }
        }
    };
    private String fhe = null;
    private final m.a fhf = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void h(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.k.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.k.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fhe = str2;
                PbActivity.this.ffS.qG(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fhg = -1;
    private int fhh = -1;
    private CustomMessageListener fhk = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Vb == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0084a) {
                    if (aVar.Vc != null && !aVar.Vc.hasError() && aVar.Vc.getError() == 0) {
                        if (PbActivity.this.ffS != null) {
                            PbActivity.this.ffS.y(((a.C0084a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aXw();
                        }
                    } else if (z) {
                        if (aVar.Vc != null && aVar.Vc.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Vc.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.k.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Vc != null && !aVar.Vc.hasError() && aVar.Vc.getError() == 0) {
                        if (PbActivity.this.ffS != null && PbActivity.this.ffS != null) {
                            PbActivity.this.ffS.y(((a.C0084a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Vc != null && aVar.Vc.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Vc.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.k.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Vc == null || aVar.Vc.hasError() || aVar.Vc.getError() != 0) {
                        if (z) {
                            if (aVar.Vc != null && aVar.Vc.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Vc.getErrorString());
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
    private final CustomMessageListener cZs = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11455").ac("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.ax.wf().c(PbActivity.this.getPageContext(), new String[]{str});
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
        public ArrayList<String> fhK;
        public ConcurrentHashMap<String, ImageUrlData> fhL;
        public boolean fhN;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fhM = false;
        public boolean fhO = false;
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
        return this.fgf;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        if (kVar.aWc() != null) {
            String id = kVar.aWc().getId();
            ArrayList<PostData> aVu = this.ffR.getPbData().aVu();
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
                    postData.tm(kVar.getTotalCount());
                    if (postData.brU() != null && aWg != null) {
                        Iterator<PostData> it = aWg.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.rP() != null && (metaData = postData.getUserMap().get(next.rP().getUserId())) != null) {
                                next.a(metaData);
                                next.mr(true);
                                next.b(getPageContext(), this.ffR.qA(metaData.getUserId()));
                            }
                        }
                        postData.brU().clear();
                        postData.brU().addAll(aWg);
                    }
                    if (postData.brQ() != null) {
                        postData.brR();
                    }
                }
            }
            if (!this.ffR.getIsFromMark()) {
                this.ffS.n(this.ffR.getPbData());
            }
            c(kVar);
        }
    }

    public void aWK() {
        com.baidu.tieba.pb.data.d pbData;
        bd aVs;
        if (!this.fgI) {
            if (!com.baidu.adp.lib.util.l.hg()) {
                showToast(d.k.no_network_guide);
            } else if (this.fgL) {
                this.fgI = true;
                if (this.ffR != null && (pbData = this.ffR.getPbData()) != null && (aVs = pbData.aVs()) != null) {
                    int isLike = aVs.rE() == null ? 0 : aVs.rE().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10796").ac("tid", aVs.getId()));
                    }
                    if (this.fgJ != null) {
                        this.fgJ.a(aVs.sf(), aVs.getId(), isLike, "pb");
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
                bVar.cd(d.k.operation);
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
                                    PbActivity.this.ffS.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fgm);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fgm);
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
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fgm);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fgm);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).tF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(int i) {
        bd aVs;
        String str;
        String z;
        if (this.ffR != null && this.ffR.getPbData() != null && (aVs = this.ffR.getPbData().aVs()) != null) {
            if (i == 1) {
                PraiseData rE = aVs.rE();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rE == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aVs.a(praiseData);
                    } else {
                        aVs.rE().getUser().add(0, metaData);
                        aVs.rE().setNum(aVs.rE().getNum() + 1);
                        aVs.rE().setIsLike(i);
                    }
                }
                if (aVs.rE() != null) {
                    if (aVs.rE().getNum() < 1) {
                        z = getResources().getString(d.k.zan);
                    } else {
                        z = com.baidu.tbadk.core.util.an.z(aVs.rE().getNum());
                    }
                    this.ffS.M(z, true);
                }
            } else if (aVs.rE() != null) {
                aVs.rE().setIsLike(i);
                aVs.rE().setNum(aVs.rE().getNum() - 1);
                ArrayList<MetaData> user = aVs.rE().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aVs.rE().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aVs.rE().getNum() < 1) {
                    str = getResources().getString(d.k.zan);
                } else {
                    str = aVs.rE().getNum() + "";
                }
                this.ffS.M(str, false);
            }
            if (this.ffR.aYk()) {
                this.ffS.aZY().notifyDataSetChanged();
            } else {
                this.ffS.o(this.ffR.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ffR.y(bundle);
        if (this.cYn != null) {
            this.cYn.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fgf.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.ffE = System.currentTimeMillis();
        this.fgk = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cIX = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.ffL = intent.getStringExtra("from");
            if (StringUtils.isNull(this.ffL) && intent.getData() != null) {
                this.ffL = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.ffL)) {
                this.ffz = true;
            }
            this.fhg = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fhh = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fhi = intent.getStringExtra("key_manga_title");
            this.fgb = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fgc = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (aXl()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.an.isEmpty(this.source) ? "" : this.source;
            this.fgt = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.cIX = System.currentTimeMillis();
        }
        this.aKO = this.ffE - this.cIX;
        super.onCreate(bundle);
        this.ffC = 0;
        x(bundle);
        if (this.ffR != null && this.ffR.getPbData() != null) {
            this.ffR.getPbData().qt(this.source);
        }
        initUI();
        if (intent != null && this.ffS != null) {
            this.ffS.foW = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fgn == null) {
                    this.fgn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.ffS.qI("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fgn, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.ffR != null && this.ffR.getPbData() != null) {
                this.ffR.qD(stringExtra);
            }
        }
        this.cYn = new VoiceManager();
        this.cYn.onCreate(getPageContext());
        initData(bundle);
        this.fge = new com.baidu.tbadk.editortools.pb.f();
        aWL();
        this.fgf = (com.baidu.tbadk.editortools.pb.d) this.fge.aO(getActivity());
        this.fgf.b(this);
        this.fgf.a(this.aEL);
        this.fgf.a(this.aEE);
        this.fgf.a(this, bundle);
        this.fgf.DD().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fgf.DD().bx(true);
        jx(true);
        this.ffS.setEditorTools(this.fgf.DD());
        this.fgf.a(this.ffR.aYt(), this.ffR.aYj(), this.ffR.aYM());
        registerListener(this.fgA);
        if (!this.ffR.aYq()) {
            this.fgf.gm(this.ffR.aYj());
        }
        if (this.ffR.aYN()) {
            this.fgf.gk(getPageContext().getString(d.k.pb_reply_hint_from_smart_frs));
        } else {
            this.fgf.gk(getPageContext().getString(d.k.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fgz);
        registerListener(this.fgB);
        registerListener(this.fgC);
        registerListener(this.cZp);
        registerListener(this.fgQ);
        registerListener(this.fgy);
        this.fgd = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gwW);
        this.fgd.brA();
        registerListener(this.fgE);
        registerListener(this.mAttentionListener);
        if (this.ffR != null) {
            this.ffR.aYD();
        }
        registerListener(this.fgT);
        registerListener(this.fhk);
        registerListener(this.cZx);
        if (this.ffS != null && this.ffS.baF() != null && this.ffS.baG() != null) {
            this.ffy = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.ffS.baF(), this.ffS.baG(), this.ffS.aZP());
            this.ffy.a(this.fgM);
        }
        if (this.ffx && this.ffS != null && this.ffS.baG() != null) {
            this.ffS.baG().setVisibility(8);
        }
        this.fgl = new com.baidu.tbadk.core.view.b();
        this.fgl.ams = 1000L;
        registerListener(this.fgP);
        registerListener(this.fgN);
        registerListener(this.fgO);
        this.fgm = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fgm;
        userMuteAddAndDelCustomMessage.setTag(this.fgm);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fgm;
        userMuteCheckCustomMessage.setTag(this.fgm);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.ffR.aYK().a(this.bRn);
        if ("from_tieba_kuang".equals(this.ffL) && this.ffL != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12264").r("obj_type", 2).ac("tid", this.ffR.aYj()));
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
            httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.aS("shoubai://internal?type=pb&param=" + this.ffR.aYj()));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        this.ffX = new au();
        if (this.fgf.Ec() != null) {
            this.ffX.g(this.fgf.Ec().getInputView());
        }
        this.fgf.a(this.aEF);
        this.dmp = new ShareSuccessReplyToServerModel();
        a(this.fgv);
        this.epb = new com.baidu.tbadk.core.util.ai(getPageContext());
        this.epb.a(new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.ai.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.ai.aio) {
                        PbActivity.this.fgf.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.ai.aip && PbActivity.this.ffS != null && PbActivity.this.ffS.aZH() != null && PbActivity.this.ffS.aZH().aYa() != null) {
                        PbActivity.this.ffS.aZH().aYa().Eu();
                    } else if (i == com.baidu.tbadk.core.util.ai.aiq) {
                        PbActivity.this.c(PbActivity.this.fgh);
                    }
                }
            }
        });
        this.createTime = System.currentTimeMillis() - this.ffE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWL() {
        if (this.fge != null && this.ffR != null) {
            this.fge.setForumName(this.ffR.aYi());
            if (this.ffR.getPbData() != null && this.ffR.getPbData().aVq() != null) {
                this.fge.a(this.ffR.getPbData().aVq());
            }
            this.fge.setFrom("pb");
            this.fge.a(this.ffR);
        }
    }

    public String aWM() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aWN() {
        return this.ffy;
    }

    private void jx(boolean z) {
        this.fgf.bB(z);
        this.fgf.bC(z);
        this.fgf.bD(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVP() && !z && this.ffS != null && this.ffS.getView() != null) {
            this.ffS.getView().setSystemUiVisibility(4);
        }
        this.fgi = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cYn != null) {
            this.cYn.onStart(getPageContext());
        }
    }

    public as aWO() {
        return this.ffS;
    }

    public PbModel aWx() {
        return this.ffR;
    }

    public void qu(String str) {
        if (this.ffR != null && !StringUtils.isNull(str) && this.ffS != null) {
            this.ffS.kq(true);
            this.ffR.qu(str);
            this.ffK = true;
            this.ffS.bar();
            this.ffS.baA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.ffA = false;
        } else {
            this.ffA = true;
        }
        super.onPause();
        BdListView xi = xi();
        this.ffC = CompatibleUtile.getInstance().getViewLayer(xi);
        if (this.ffC == 1) {
            CompatibleUtile.getInstance().noneViewGpu(xi);
        }
        if (this.cYn != null) {
            this.cYn.onPause(getPageContext());
        }
        if (this.ffS != null) {
            this.ffS.onPause();
        }
        if (!this.ffR.aYq()) {
            this.fgf.gl(this.ffR.aYj());
        }
        if (this.ffR != null) {
            this.ffR.aYE();
        }
        MessageManager.getInstance().unRegisterListener(this.dSO);
        ayG();
        MessageManager.getInstance().unRegisterListener(this.fgN);
        MessageManager.getInstance().unRegisterListener(this.fgO);
        MessageManager.getInstance().unRegisterListener(this.fgP);
        MessageManager.getInstance().unRegisterListener(this.cZs);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean aWP() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.ffR.getPbData(), this.ffR.aYk(), this.ffR.getRequestType());
        return (a2 == null || a2.rP() == null || a2.rP().getGodUserData() == null || a2.rP().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ffA = false;
        super.onResume();
        if (this.ffN) {
            this.ffN = false;
            aXr();
        }
        if (aWP()) {
            this.ffH = System.currentTimeMillis();
        } else {
            this.ffH = -1L;
        }
        if (this.ffS != null && this.ffS.getView() != null) {
            if (!this.eKx) {
                aXi();
            } else {
                hideLoadingView(this.ffS.getView());
            }
            this.ffS.onResume();
        }
        if (this.ffC == 1) {
            CompatibleUtile.getInstance().closeViewGpu(xi());
        }
        NoNetworkView noNetworkView = null;
        if (this.ffS != null) {
            noNetworkView = this.ffS.aZE();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.gP()) {
            noNetworkView.aL(false);
        }
        if (this.cYn != null) {
            this.cYn.onResume(getPageContext());
        }
        registerListener(this.dSO);
        this.fga = false;
        aXq();
        registerListener(this.fgN);
        registerListener(this.fgO);
        registerListener(this.fgP);
        registerListener(this.cZs);
        if (this.cYT) {
            aXh();
            this.cYT = false;
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
        this.ffS.kf(z);
        if (this.ffY != null) {
            this.ffY.jR(z);
        }
        if (z && this.fga) {
            this.ffS.bad();
            this.ffR.jN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ffH > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10804").ac("obj_duration", (System.currentTimeMillis() - this.ffH) + ""));
            this.ffH = 0L;
        }
        if (aWO().aZH() != null) {
            aWO().aZH().onStop();
        }
        if (this.ffS.fpd != null && !this.ffS.fpd.agf()) {
            this.ffS.fpd.aKd();
        }
        if (this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVq() != null && this.ffR.getPbData().aVs() != null) {
            com.baidu.tbadk.distribute.a.Do().a(getPageContext().getPageActivity(), "pb", this.ffR.getPbData().aVq().getId(), com.baidu.adp.lib.g.b.c(this.ffR.getPbData().aVs().getId(), 0L));
        }
        if (this.cYn != null) {
            this.cYn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.ffF && this.ffS != null) {
            this.ffF = true;
            this.ffS.baw();
            a(false, (PostData) null);
        }
        if (this.ffR != null) {
            this.ffR.cancelLoadData();
            this.ffR.destory();
            if (this.ffR.aYJ() != null) {
                this.ffR.aYJ().onDestroy();
            }
        }
        if (this.fgf != null) {
            this.fgf.onDestroy();
        }
        if (this.cqN != null) {
            this.cqN.cancelLoadData();
        }
        if (this.ffS != null) {
            this.ffS.onDestroy();
            if (this.ffS.fpd != null) {
                this.ffS.fpd.aKd();
            }
        }
        if (this.ffG != null) {
            this.ffG.onDestroy();
        }
        if (this.ffy != null) {
            this.ffy.HK();
        }
        super.onDestroy();
        if (this.cYn != null) {
            this.cYn.onDestory(getPageContext());
        }
        this.ffS.bar();
        MessageManager.getInstance().unRegisterListener(this.fgN);
        MessageManager.getInstance().unRegisterListener(this.fgO);
        MessageManager.getInstance().unRegisterListener(this.fgP);
        MessageManager.getInstance().unRegisterListener(this.fgm);
        MessageManager.getInstance().unRegisterListener(this.fgQ);
        MessageManager.getInstance().unRegisterListener(this.cZx);
        this.fgk = null;
        this.fgl = null;
        com.baidu.tieba.recapp.d.a.bjY().bka();
        if (this.fgn != null) {
            getSafeHandler().removeCallbacks(this.fgn);
        }
        if (this.ffO != null) {
            this.ffO.cancelLoadData();
        }
        if (this.ffS != null && this.ffS.fpd != null) {
            this.ffS.fpd.bbm();
        }
        if (this.dmp != null) {
            this.dmp.cancelLoadData();
        }
        this.ffX.onDestroy();
        if (this.cYX != null) {
            this.cYX.onDestroy();
        }
        if (this.ffR != null && this.ffR.aYL() != null) {
            this.ffR.aYL().onDestroy();
        }
        if (this.epb != null) {
            this.epb.onDestroy();
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
        if (adAdSense != null && adAdSense.yg() && this.ffS != null && (aZY = this.ffS.aZY()) != null && (aXM = aZY.aXM()) != null) {
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
                        bVar.aNw = id;
                        bVar.csJ = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aaD == 1 && !TextUtils.isEmpty(id)) {
                    next.aaD = 2;
                    a.b bVar2 = new a.b();
                    bVar2.aNw = id;
                    bVar2.csJ = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.ffR == null || this.ffR.getPbData() == null || this.ffR.getPbData().aVq() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.ffR.getPbData().aVq().getFirst_class();
                    str2 = this.ffR.getPbData().aVq().getSecond_class();
                    str = this.ffR.getPbData().aVq().getId();
                    str4 = this.ffR.aYj();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.yj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.ffS.onChangeSkinType(i);
            if (this.fgf != null && this.fgf.DD() != null) {
                this.fgf.DD().onChangeSkinType(i);
            }
            if (this.ffS.aZE() != null) {
                this.ffS.aZE().onChangeSkinType(getPageContext(), i);
            }
            this.ffX.onChangeSkinType();
            if (this.cYX != null) {
                this.cYX.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.ffS = new as(this, this.cZX, this.aWy);
        this.bzr = new com.baidu.tieba.f.b(getActivity());
        this.bzr.a(this.fhd);
        this.bzr.a(this.bzs);
        this.ffS.setOnScrollListener(this.mOnScrollListener);
        this.ffS.e(this.fgX);
        this.ffS.a(this.bfk);
        this.ffS.jr(com.baidu.tbadk.core.i.pX().qd());
        this.ffS.setOnImageClickListener(this.aWx);
        this.ffS.b(this.axX);
        this.ffS.h(this.cWl);
        this.ffS.a(this.fgV);
        this.ffS.kf(this.mIsLogin);
        if (getIntent() != null) {
            this.ffS.kr(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aV(View view2) {
        if (view2 != null && (view2.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view2.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.gxx && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.pX().qd()) {
                    return qx(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.ffR == null || this.ffR.getPbData() == null) {
                        return true;
                    }
                    if (aWO().aZH() != null) {
                        aWO().aZH().aXV();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.ffR.getPbData().aVq());
                    kVar.T(this.ffR.getPbData().aVs());
                    kVar.d(postData);
                    aWO().aZG().d(kVar);
                    aWO().aZG().setPostId(postData.getId());
                    b(view2, postData.rP().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fgf != null) {
                        this.ffS.km(this.fgf.Ei());
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
        if (this.ffS != null) {
            if (z && !this.eKx) {
                aXi();
            } else {
                hideLoadingView(this.ffS.getView());
            }
            if (z && this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVP() && this.ffS.getView() != null) {
                this.ffS.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void aWQ() {
        if (this.ffD == null) {
            this.ffD = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.ffD.a(new String[]{getPageContext().getString(d.k.call_phone), getPageContext().getString(d.k.sms_phone), getPageContext().getString(d.k.search_in_baidu)}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.ffs = PbActivity.this.ffs.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.ffs);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.ffR.aYj(), PbActivity.this.ffs, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.ffs = PbActivity.this.ffs.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.ffs);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.ffR.aYj(), PbActivity.this.ffs, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.ffs = PbActivity.this.ffs.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.ffs);
                        bVar.dismiss();
                    }
                }
            }).ce(b.a.acY).cf(17).d(getPageContext());
        }
    }

    private void x(Bundle bundle) {
        this.ffR = new PbModel(this);
        this.ffR.a(this.fgS);
        if (this.ffR.aYH() != null) {
            this.ffR.aYH().a(this.fhf);
        }
        if (this.ffR.aYG() != null) {
            this.ffR.aYG().a(this.fgD);
        }
        if (this.ffR.aYJ() != null) {
            this.ffR.aYJ().b(this.fgx);
        }
        if (bundle != null) {
            this.ffR.initWithBundle(bundle);
        } else {
            this.ffR.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.ffR.jQ(true);
        }
        ai.aZr().L(this.ffR.aYh(), this.ffR.getIsFromMark());
        if (StringUtils.isNull(this.ffR.aYj())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.ffL) && this.ffL != null) {
            this.ffR.qs(6);
        }
        if (this.ffR.aYI() != null) {
            this.ffR.aYI().a(this.fgw);
        }
        if (this.ffR.aYL() != null) {
            this.ffR.aYL().a(this.cYZ);
        }
        this.ffR.FW();
    }

    private void initData(Bundle bundle) {
        this.eHB = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eHB != null) {
            this.eHB.a(this.fgU);
        }
        this.cqN = new ForumManageModel(this);
        this.cqN.setLoadDataCallBack(this.cqR);
        this.ait = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.ffS.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    PbActivity.this.showToast(d.k.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.ffR.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.ffR.getPbData().aVq().getId(), PbActivity.this.ffR.getPbData().aVq().getName(), PbActivity.this.ffR.getPbData().aVs().getId(), valueOf, str, str2)));
            }
        });
        this.fgJ.setUniqueId(getUniqueId());
        this.fgJ.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ffS.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fgm;
        userMuteCheckCustomMessage.setTag(this.fgm);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aWR() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.ffR != null && (pbData = this.ffR.getPbData()) != null) {
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
            if (postData.bsj()) {
                postData.cU(postData.bsi() - 1);
            } else {
                postData.cU(postData.bsi() + 1);
            }
            postData.ms(!postData.bsj());
            ((PbFloorAgreeView) view2).a(postData.bsj(), postData.bsi(), true);
            final int i = postData.bsj() ? 0 : 1;
            this.ffR.aYI().a(postData.getId(), i, new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
                @Override // com.baidu.tieba.pb.pb.main.q.a
                public void qg(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view2).qD(i2);
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
        return new com.baidu.tbadk.core.util.al("c12003").ac("tid", this.ffR.fkZ).r("obj_type", 0).ac(ImageViewerConfig.FORUM_ID, this.ffR.getForumId()).r("obj_param1", this.ffR.getPbData().aVs().getThreadType() == 40 ? 2 : 1);
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
                        PbActivity.this.fgf.DD().setVisibility(8);
                        PbActivity.this.aWO().aZH().bG(str, str2);
                        com.baidu.tbadk.editortools.pb.g aYa = PbActivity.this.aWO().aZH().aYa();
                        if (aYa != null && PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null) {
                            aYa.a(PbActivity.this.ffR.getPbData().qS());
                        }
                        if (PbActivity.this.ffX.baS() == null && PbActivity.this.aWO().aZH().aYa().EC() != null) {
                            PbActivity.this.aWO().aZH().aYa().EC().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.ffX != null && PbActivity.this.ffX.baR() != null) {
                                        if (!PbActivity.this.ffX.baR().bAV()) {
                                            PbActivity.this.ffX.kt(false);
                                        }
                                        PbActivity.this.ffX.baR().nk(false);
                                    }
                                }
                            });
                            PbActivity.this.ffX.h(PbActivity.this.aWO().aZH().aYa().EC().getInputView());
                            PbActivity.this.aWO().aZH().aYa().a(PbActivity.this.fgj);
                        }
                    }
                    PbActivity.this.aWO().baA();
                }
            }, 500L);
        }
    }

    public boolean aWT() {
        if (this.epb == null || this.ffR.getPbData() == null || this.ffR.getPbData().qS() == null) {
            return true;
        }
        return this.epb.cK(this.ffR.getPbData().qS().replyPrivateFlag);
    }

    public boolean qc(int i) {
        if (this.epb == null || this.ffR.getPbData() == null || this.ffR.getPbData().qS() == null) {
            return true;
        }
        return this.epb.t(this.ffR.getPbData().qS().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.ffR != null && this.ffR.getPbData() != null && postData.brX() > 1) {
            String aYj = this.ffR.aYj();
            String id = postData.getId();
            int aVE = this.ffR.getPbData() != null ? this.ffR.getPbData().aVE() : 0;
            c qy = qy(id);
            if (qy != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(aYj, id, "pb", true, null, false, null, aVE, postData.bbZ(), this.ffR.getPbData().qS(), false, postData.rP() != null ? postData.rP().getIconInfo() : null).addBigImageData(qy.fhK, qy.fhL, qy.fhM, qy.index);
                addBigImageData.setKeyPageStartFrom(this.ffR.aYP());
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
                        aVO.pU(i);
                    } else if (aVO.aVW()) {
                        aVO.aVZ();
                        i3 = 1;
                    } else {
                        aVO.pW(i);
                        i3 = 0;
                    }
                    aVO.pV(i2);
                    q.a aVar = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                        @Override // com.baidu.tieba.pb.pb.main.q.a
                        public void qg(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.q.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.ffR != null && this.ffR.aYI() != null) {
                        String str = "";
                        if (this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null) {
                            str = this.ffR.getPbData().aVs().sf();
                        }
                        if (this.ffR.getPbData() != null) {
                            this.ffR.getPbData().a(aVO);
                        }
                        if (z) {
                            this.ffR.aYI().a(str, 3, i, this.ffR.getForumId(), aVar);
                        } else {
                            this.ffR.aYI().a(str, i3, 3, i, this.ffR.getForumId(), aVar);
                            com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i();
                            iVar.fdK = i3;
                            iVar.fdL = aVO;
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
        if (this.ffR.getPbData() == null || this.ffR.getPbData().aVs() == null) {
            return -1;
        }
        return this.ffR.getPbData().aVs().sr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWV() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.sq(this.ffR.getForumId()) && this.ffR.getPbData() != null && this.ffR.getPbData().aVq() != null) {
            if (this.ffR.getPbData().aVq().isLike() == 1) {
                this.ffR.aYL().bV(this.ffR.getForumId(), this.ffR.aYj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jy(boolean z) {
        if (this.ffR == null || this.ffR.getPbData() == null) {
            return false;
        }
        return ((this.ffR.getPbData().aVE() != 0) || this.ffR.getPbData().aVs() == null || this.ffR.getPbData().aVs().rP() == null || TextUtils.equals(this.ffR.getPbData().aVs().rP().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aWW() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.o.q.Hq()) {
            return "";
        }
        PostData aVz = aVz();
        if (this.ffR == null || (pbData = this.ffR.getPbData()) == null || pbData.getUserData() == null || pbData.aVs() == null || aVz == null || aVz.rP() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aVz.rP().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aVs().rA() == 0) {
            return "";
        }
        if (pbData.aVs().rA() == 0) {
            return getPageContext().getString(d.k.fans_call);
        }
        return getPageContext().getString(d.k.haved_fans_call);
    }

    private boolean jz(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.u uVar;
        if (z) {
            return true;
        }
        if (this.ffR == null || this.ffR.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.ffR.getPbData();
        if (pbData.aVE() == 0) {
            List<com.baidu.tbadk.core.data.az> aVM = pbData.aVM();
            if (com.baidu.tbadk.core.util.v.v(aVM) > 0) {
                for (com.baidu.tbadk.core.data.az azVar : aVM) {
                    if (azVar != null && (uVar = azVar.ZA) != null && uVar.XF && !uVar.isDeleted && (uVar.type == 1 || uVar.type == 2)) {
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

    private boolean jA(boolean z) {
        return (z || this.ffR == null || this.ffR.getPbData() == null || this.ffR.getPbData().aVE() == 0) ? false : true;
    }

    public void aWX() {
        if (this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null && this.ffR.getPbData().aVs().rP() != null) {
            if (this.ffS != null) {
                this.ffS.aZF();
            }
            bd aVs = this.ffR.getPbData().aVs();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aVs.rP().getUserId());
            aa aaVar = new aa();
            int aVE = this.ffR.getPbData().aVE();
            if (aVE == 1) {
                aaVar.fna = true;
                aaVar.fmZ = true;
                aaVar.fnh = aVs.rK() == 1;
                aaVar.fng = aVs.rL() == 1;
            } else {
                aaVar.fna = false;
                aaVar.fmZ = false;
            }
            if (aVE == 1002 && !equals) {
                aaVar.fnl = true;
            }
            aaVar.fmW = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            aaVar.fnb = jz(equals);
            aaVar.fnc = aWY();
            aaVar.fnd = jA(equals);
            aaVar.fmX = this.ffR.aYk();
            aaVar.fmY = true;
            aaVar.fdZ = this.eHB != null && this.eHB.oH();
            aaVar.fmV = jy(equals);
            aaVar.fnj = aWW();
            aaVar.fmU = equals && this.ffS.bak();
            aaVar.fne = TbadkCoreApplication.getInst().getSkinType() == 1;
            aaVar.fnf = true;
            aaVar.isHostOnly = this.ffR.getHostMode();
            aaVar.fni = true;
            if (aVs.sg() == null) {
                aaVar.fnk = true;
            } else {
                aaVar.fnk = false;
            }
            this.ffS.fpd.a(aaVar);
        }
    }

    private boolean aWY() {
        if (this.ffR != null && this.ffR.aYk()) {
            return this.ffR.azm() == null || this.ffR.azm().rc() != 0;
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
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fdG) {
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
            if ((hVar instanceof PostData) && hVar.getType() == PostData.gxw) {
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
                    PbActivity.this.ait.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.ffR.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).tC();
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.ffS.bae();
        this.ffR.jP(z);
        if (this.eHB != null) {
            this.eHB.ae(z);
            if (markData != null) {
                this.eHB.a(markData);
            }
        }
        if (this.ffR.oH()) {
            aXf();
        } else {
            this.ffS.n(this.ffR.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qa(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(String str) {
        if (!StringUtils.isNull(str) && this.ffR != null) {
            String aYj = this.ffR.aYj();
            String id = this.ffR.getPbData().aVq().getId();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.k.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + aYj + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.ffR.aYq()) {
                    antiData.setBlock_forum_name(this.ffR.getPbData().aVq().getName());
                    antiData.setBlock_forum_id(this.ffR.getPbData().aVq().getId());
                    antiData.setUser_name(this.ffR.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.ffR.getPbData().getUserData().getUserId());
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
        if (AntiHelper.ts(i)) {
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
            this.ffS.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.ffS.a(0, bVar.yQ, bVar.gzP, z);
            if (bVar.yQ) {
                if (bVar.gzN == 1) {
                    ArrayList<PostData> aVu = this.ffR.getPbData().aVu();
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
                    this.ffS.n(this.ffR.getPbData());
                } else if (bVar.gzN == 0) {
                    aXb();
                } else if (bVar.gzN == 2) {
                    ArrayList<PostData> aVu2 = this.ffR.getPbData().aVu();
                    int size2 = aVu2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aVu2.get(i2).brU().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aVu2.get(i2).brU().get(i3).getId())) {
                                i3++;
                            } else {
                                aVu2.get(i2).brU().remove(i3);
                                aVu2.get(i2).brW();
                                z2 = true;
                                break;
                            }
                        }
                        aVu2.get(i2).sW(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.ffS.n(this.ffR.getPbData());
                    }
                    a(bVar, this.ffS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.ffS.a(this.cqN.getLoadDataMode(), gVar.yQ, gVar.gzP, false);
            if (gVar.yQ) {
                this.ffU = true;
                if (i == 2 || i == 3) {
                    this.ffV = true;
                    this.ffW = false;
                } else if (i == 4 || i == 5) {
                    this.ffV = false;
                    this.ffW = true;
                }
                if (i == 2) {
                    this.ffR.getPbData().aVs().bR(1);
                    this.ffR.setIsGood(1);
                } else if (i == 3) {
                    this.ffR.getPbData().aVs().bR(0);
                    this.ffR.setIsGood(0);
                } else if (i == 4) {
                    this.ffR.getPbData().aVs().bQ(1);
                    this.ffR.iX(1);
                } else if (i == 5) {
                    this.ffR.getPbData().aVs().bQ(0);
                    this.ffR.iX(0);
                }
                this.ffS.c(this.ffR.getPbData(), this.ffR.aYk());
            }
        }
    }

    private void aXb() {
        if (this.ffR.aYl() || this.ffR.aYn()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.ffR.aYj());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.ffR.aYj()));
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
        if (this.ffS != null) {
            this.ffS.bar();
        }
        if (this.ffR != null && this.ffR.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.ffR.getPbData().aVs().getId();
            if (this.ffR.isShareThread() && this.ffR.getPbData().aVs().abM != null) {
                historyMessage.threadName = this.ffR.getPbData().aVs().abM.showText;
            } else {
                historyMessage.threadName = this.ffR.getPbData().aVs().getTitle();
            }
            if (this.ffR.isShareThread() && !aXy()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.ffR.getPbData().aVq().getName();
            }
            ArrayList<PostData> aVu = this.ffR.getPbData().aVu();
            int bag = this.ffS != null ? this.ffS.bag() : 0;
            if (aVu != null && bag >= 0 && bag < aVu.size()) {
                historyMessage.postID = aVu.get(bag).getId();
            }
            historyMessage.isHostOnly = this.ffR.getHostMode();
            historyMessage.isSquence = this.ffR.aYk();
            historyMessage.isShareThread = this.ffR.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fgf != null) {
            this.fgf.onDestroy();
        }
        if (this.ffB && aWO() != null) {
            aWO().baK();
        }
        if (this.ffR != null && (this.ffR.aYl() || this.ffR.aYn())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.ffR.aYj());
            if (this.ffU) {
                if (this.ffW) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.ffR.aYp());
                }
                if (this.ffV) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.ffR.getIsGood());
                }
            }
            if (this.ffR.getPbData() != null && System.currentTimeMillis() - this.ffE >= 40000 && (aVB = this.ffR.getPbData().aVB()) != null && !com.baidu.tbadk.core.util.v.w(aVB.getDataList())) {
                intent.putExtra("guess_like_data", aVB);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fgt);
            }
            setResult(-1, intent);
        }
        if (aXg()) {
            if (this.ffR != null && this.ffS != null && this.ffS.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.ffR.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aVy() && !this.ffK) {
                        ai aZr = ai.aZr();
                        com.baidu.tieba.pb.data.d pbData2 = this.ffR.getPbData();
                        Parcelable onSaveInstanceState = this.ffS.getListView().onSaveInstanceState();
                        boolean aYk = this.ffR.aYk();
                        boolean hostMode = this.ffR.getHostMode();
                        if (this.ffS.aZP() != null && this.ffS.aZP().getVisibility() == 0) {
                            z = true;
                        }
                        aZr.a(pbData2, onSaveInstanceState, aYk, hostMode, z);
                        if (this.fgs >= 0 || this.ffR.aYR() != null) {
                            ai.aZr().i(this.ffR.aYR());
                            ai.aZr().h(this.ffR.aYS());
                            ai.aZr().qu(this.ffR.aYT());
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
        if (keyEvent == null || this.ffS == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.ffS.qy(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qd(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.ffS.aZF();
            this.ffS.aZH().aXV();
            this.ffS.ko(false);
        }
        this.ffS.aZI();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fgf.resetData();
                        this.fgf.b(writeData);
                        this.fgf.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k eI = this.fgf.DD().eI(6);
                        if (eI != null && eI.aCN != null) {
                            eI.aCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fgf.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.ffS.aZH() != null && this.ffS.aZH().aYa() != null) {
                            com.baidu.tbadk.editortools.pb.g aYa = this.ffS.aZH().aYa();
                            aYa.b(writeData);
                            aYa.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k eI2 = aYa.DD().eI(6);
                            if (eI2 != null && eI2.aCN != null) {
                                eI2.aCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                aYa.Eu();
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
        this.fgf.onActivityResult(i, i2, intent);
        if (this.ffO != null) {
            this.ffO.onActivityResult(i, i2, intent);
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
                            if (PbActivity.this.ffR != null) {
                                PbActivity.this.ffR.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.ffR != null) {
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
                        if (this.dmp != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dmp.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void AD() {
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
                    this.ffS.jw(false);
                    if (this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null && this.ffR.getPbData().aVs().si() != null) {
                        this.ffR.getPbData().aVs().si().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fgh = emotionImageData;
                        if (qc(com.baidu.tbadk.core.util.ai.aiq)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.ffS != null && this.ffS.fpd != null) {
                        this.ffS.fpd.pq();
                        this.ffS.fpd.bbg();
                        if (this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null) {
                            this.ffR.getPbData().aVs().bM(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.ffP != null) {
                        this.ffS.bf(this.ffP);
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
            if (this.ffO == null) {
                this.ffO = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.ffO.b(this.aEE);
                this.ffO.c(this.aEL);
            }
            this.ffO.a(emotionImageData, aWx(), aWx().getPbData());
        }
    }

    private ShareFromPBMsgData aXd() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bM = this.ffR.getPbData().bM(getPageContext().getPageActivity());
        PostData aZK = this.ffS.aZK();
        String str = "";
        if (aZK != null) {
            str = aZK.getId();
            String bZ = aZK.bZ(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(bZ)) {
                bM[1] = bZ;
            }
        }
        String sf = this.ffR.getPbData().aVs().sf();
        if (sf != null && sf.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bM[1]);
        shareFromPBMsgData.setImageUrl(bM[0]);
        shareFromPBMsgData.setForumName(this.ffR.getPbData().aVq().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.ffR.getPbData().aVs().getId());
        shareFromPBMsgData.setTitle(this.ffR.getPbData().aVs().getTitle());
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        a(aXd(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null) {
                        com.baidu.tbadk.core.util.al ac = new com.baidu.tbadk.core.util.al("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.ffR.getForumId()).ac("tid", PbActivity.this.ffR.aYj());
                        if (PbActivity.this.e(PbActivity.this.ffR.getPbData()) != 0) {
                            ac.r("obj_type", PbActivity.this.e(PbActivity.this.ffR.getPbData()));
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
            aVar.b(getPageContext()).tC();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.ffR.getPbData().aVF() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cc(1);
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
            aVar.b(getPageContext()).tC();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.ffR.getPbData().aVF() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXe() {
        MarkData qr;
        if (this.eHB != null && (qr = this.ffR.qr(this.ffS.bah())) != null) {
            if (!qr.isApp() || (qr = this.ffR.qr(this.ffS.bah() + 1)) != null) {
                this.ffS.bac();
                this.eHB.a(qr);
                if (!this.eHB.oH()) {
                    this.eHB.oJ();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.eHB.oI();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXf() {
        com.baidu.tieba.pb.data.d pbData = this.ffR.getPbData();
        this.ffR.jP(true);
        if (this.eHB != null) {
            pbData.qs(this.eHB.oG());
        }
        this.ffS.n(pbData);
    }

    private boolean aXg() {
        if (this.ffR == null) {
            return true;
        }
        if (this.ffR.oH()) {
            final MarkData aYy = this.ffR.aYy();
            if (aYy == null || !this.ffR.getIsFromMark()) {
                return true;
            }
            final MarkData qr = this.ffR.qr(this.ffS.bag());
            if (qr == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", aYy);
                setResult(-1, intent);
                return true;
            } else if (qr.getPostId() == null || qr.getPostId().equals(aYy.getPostId())) {
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
                        if (PbActivity.this.eHB != null) {
                            if (PbActivity.this.eHB.oH()) {
                                PbActivity.this.eHB.oI();
                                PbActivity.this.eHB.ae(false);
                            }
                            PbActivity.this.eHB.a(qr);
                            PbActivity.this.eHB.ae(true);
                            PbActivity.this.eHB.oJ();
                        }
                        aYy.setPostId(qr.getPostId());
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
                        if (PbActivity.this.ffS != null && PbActivity.this.ffS.getView() != null) {
                            PbActivity.this.ffS.getView().getLocationOnScreen(iArr);
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
                aVar.tC();
                return false;
            }
        } else if (this.ffR.getPbData() == null || this.ffR.getPbData().aVu() == null || this.ffR.getPbData().aVu().size() <= 0 || !this.ffR.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdListView xi() {
        if (this.ffS == null) {
            return null;
        }
        return this.ffS.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Km() {
        if (this.ffS == null) {
            return 0;
        }
        return this.ffS.bap();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Kn() {
        if (this.aWo == null) {
            this.aWo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aby */
                public ImageView fo() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean qd = com.baidu.tbadk.core.i.pX().qd();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ak.getDrawable(d.C0126d.common_color_10220));
                    if (qd) {
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
                        if (com.baidu.tbadk.core.i.pX().qd()) {
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
        return this.aWo;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Ko() {
        if (this.aWp == null) {
            this.aWp = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.aWp;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Kp() {
        if (this.aWt == null) {
            this.aWt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
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
                    gifView.EU();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.aWt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Kq() {
        if (this.aWq == null) {
            this.aWq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
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
                    ((PlayVoiceBntNew) view2).btd();
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
        return this.aWq;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Ks() {
        this.aWs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
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
        return this.aWs;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xj() {
        if (this.aqg == null) {
            this.aqg = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.aqg;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void S(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ffI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void T(Context context, String str) {
        if (ax.qJ(str) && this.ffR != null && this.ffR.aYj() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11664").r("obj_param1", 1).ac("post_id", this.ffR.aYj()));
        }
        ax.baU().c(getPageContext(), str);
        this.ffI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        ax.baU().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.ffI = true;
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
            com.baidu.tieba.pb.data.d pbData = this.ffR.getPbData();
            TbRichText aB = aB(str, i);
            if (aB != null && (tbRichTextData = aB.JH().get(this.fgY)) != null) {
                cVar.fhK = new ArrayList<>();
                cVar.fhL = new ConcurrentHashMap<>();
                if (!tbRichTextData.JN().JZ()) {
                    cVar.fhN = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fhK.add(b2);
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
                    imageUrlData.mIsReserver = this.ffR.aYx();
                    imageUrlData.mIsSeeHost = this.ffR.getHostMode();
                    cVar.fhL.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aVq() != null) {
                            cVar.forumName = pbData.aVq().getName();
                            cVar.forumId = pbData.aVq().getId();
                        }
                        if (pbData.aVs() != null) {
                            cVar.threadId = pbData.aVs().getId();
                        }
                        cVar.fhM = pbData.aVF() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fhN = true;
                int size = pbData.aVu().size();
                this.fgZ = false;
                cVar.index = -1;
                if (pbData.aVz() != null) {
                    PostData aVz = pbData.aVz();
                    TbRichText brZ = aVz.brZ();
                    if (!ar.j(aVz)) {
                        i2 = a(brZ, aB, i, i, cVar.fhK, cVar.fhL);
                    } else {
                        i2 = a(aVz, i, cVar.fhK, cVar.fhL);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aVu().get(i4);
                    if (postData.getId() == null || pbData.aVz() == null || pbData.aVz().getId() == null || !postData.getId().equals(pbData.aVz().getId())) {
                        TbRichText brZ2 = postData.brZ();
                        if (!ar.j(postData)) {
                            i3 = a(brZ2, aB, i3, i, cVar.fhK, cVar.fhL);
                        } else {
                            i3 = a(postData, i3, cVar.fhK, cVar.fhL);
                        }
                    }
                }
                if (cVar.fhK.size() > 0) {
                    cVar.lastId = cVar.fhK.get(cVar.fhK.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aVq() != null) {
                        cVar.forumName = pbData.aVq().getName();
                        cVar.forumId = pbData.aVq().getId();
                    }
                    if (pbData.aVs() != null) {
                        cVar.threadId = pbData.aVs().getId();
                    }
                    cVar.fhM = pbData.aVF() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.JN() == null) {
            return null;
        }
        return tbRichTextData.JN().Kd();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.JN() == null) {
            return 0L;
        }
        return tbRichTextData.JN().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.JN() == null) {
            return false;
        }
        return tbRichTextData.JN().Ke();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.JN() == null) {
            return false;
        }
        return tbRichTextData.JN().Kf();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo JN;
        String str;
        if (tbRichText == tbRichText2) {
            this.fgZ = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.JH().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.JH().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.JN().getWidth() * ai;
                    int height = ai * tbRichTextData.JN().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.JN().JZ()) {
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
                            if (tbRichTextData != null && (JN = tbRichTextData.JN()) != null) {
                                String Ka = JN.Ka();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = JN.Kb();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = Ka;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ffR.aYj(), -1L);
                                imageUrlData.mIsReserver = this.ffR.aYx();
                                imageUrlData.mIsSeeHost = this.ffR.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fgZ) {
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
        com.baidu.tieba.tbadkCore.data.h bsg;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> brE;
        if (postData != null && arrayList != null && concurrentHashMap != null && (brE = (bsg = postData.bsg()).brE()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == brE.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = brE.get(i3);
                if (jVar != null) {
                    String brI = jVar.brI();
                    if (!com.baidu.tbadk.core.util.an.isEmpty(brI)) {
                        arrayList.add(brI);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = brI;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.brH();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.ffR.aYj(), -1L);
                        imageUrlData.mIsReserver = this.ffR.aYx();
                        imageUrlData.mIsSeeHost = this.ffR.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bsg.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(brI, imageUrlData);
                        }
                        if (!this.fgZ) {
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
            if (postData.getId() != null && postData.getId().equals(this.ffR.rY())) {
                z = true;
            }
            MarkData g = this.ffR.g(postData);
            if (g != null) {
                this.ffS.bac();
                if (this.eHB != null) {
                    this.eHB.a(g);
                    if (!z) {
                        this.eHB.oJ();
                    } else {
                        this.eHB.oI();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aB(String str, int i) {
        TbRichText tbRichText = null;
        if (this.ffR == null || this.ffR.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.ffR.getPbData();
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
        if (dVar != null && dVar.aVD() != null && dVar.aVD().feb != null && (list = dVar.aVD().feb) != null && arrayList != null) {
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

    private long qw(String str) {
        ArrayList<PostData> aVu;
        com.baidu.tieba.pb.data.d pbData = this.ffR.getPbData();
        if (pbData != null && (aVu = pbData.aVu()) != null && !aVu.isEmpty()) {
            Iterator<PostData> it = aVu.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bsg = next.bsg();
                if (bsg != null && bsg.gxe) {
                    Iterator<TbRichTextData> it2 = next.brZ().JH().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.JW().getLink().equals(str)) {
                            return bsg.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> JH;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText brZ = arrayList.get(i2).brZ();
            if (brZ != null && (JH = brZ.JH()) != null) {
                int size = JH.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (JH.get(i4) != null && JH.get(i4).getType() == 8) {
                        i3++;
                        if (JH.get(i4).JN().Ka().equals(str) || JH.get(i4).JN().Kb().equals(str)) {
                            int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                            int width = JH.get(i4).JN().getWidth() * ai;
                            int height = JH.get(i4).JN().getHeight() * ai;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fgY = i4;
                            return brZ;
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
            this.ffs = str;
            if (this.ffD == null) {
                aWQ();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.ffD.ci(1).setVisibility(8);
            } else {
                this.ffD.ci(1).setVisibility(0);
            }
            this.ffD.tF();
            this.ffI = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cYn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXh() {
        hideNetRefreshView(this.ffS.getView());
        aXi();
        if (this.ffR.FW()) {
            this.ffS.bac();
        }
    }

    private void aXi() {
        showLoadingView(this.ffS.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View Fq = getLoadingView().Fq();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Fq.getLayoutParams();
        layoutParams.addRule(3, this.ffS.baF().getId());
        Fq.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apB() {
        if (this.cYn != null) {
            this.cYn.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(int i) {
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
    public void qf(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.ffR.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.ffR.getPbData();
            pbData.aVq().getName();
            String title = pbData.aVs().getTitle();
            int i2 = this.ffR.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aVq() != null) {
                if ((pbData.aVq().isLike() == 1) && AddExperiencedModel.sq(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.ffR.aYj() + "?share=9105&fr=share&see_lz=" + i2;
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
                    dVar.awO = true;
                    dVar.awS = z;
                    dVar.extData = this.ffR.aYj();
                    dVar.axc = 3;
                    dVar.axb = i;
                    dVar.fid = this.ffR.getForumId();
                    dVar.tid = this.ffR.aYj();
                    dVar.axd = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.awW = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.ffR.getPbData().aVs());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.axc);
                    bundle.putInt("obj_type", dVar.axd);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.f(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVP()) {
                                PbActivity.this.ffS.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.d.d.ahh().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.ffR.aYj() + "?share=9105&fr=share&see_lz=" + i2;
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
            dVar2.awO = true;
            dVar2.awS = z;
            dVar2.extData = this.ffR.aYj();
            dVar2.axc = 3;
            dVar2.axb = i;
            dVar2.fid = this.ffR.getForumId();
            dVar2.tid = this.ffR.aYj();
            dVar2.axd = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.ffR.getPbData().aVs());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.axc);
            bundle2.putInt("obj_type", dVar2.axd);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.f(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.ffR != null && PbActivity.this.ffR.getPbData() != null && PbActivity.this.ffR.getPbData().aVP()) {
                        PbActivity.this.ffS.getView().setSystemUiVisibility(4);
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
                return Boolean.valueOf(AddExperiencedModel.ss(PbActivity.this.ffR.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.ffS.baL();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Kr() {
        if (this.aWr == null) {
            this.aWr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
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
        return this.aWr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (this.ffS.aZX() == view2) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, this.ffR.getPbData().getForumId()));
            } else {
                bd aVs = this.ffR.getPbData().aVs();
                if (view2 != null) {
                    boolean z = aVs.rE() == null || aVs.rE().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fgK > 1000) {
                            this.fgL = true;
                            aY(view2);
                        } else {
                            this.fgL = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            m(view2, this.fgL);
                        } else {
                            l(view2, this.fgL);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        l(view2, this.fgL);
                    } else if (motionEvent.getAction() == 3) {
                        l(view2, this.fgL);
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
                    PbActivity.this.fgK = System.currentTimeMillis();
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
                    PbActivity.this.fgK = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void aY(View view2) {
        view2.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (xi() == null) {
            return null;
        }
        return xi().getPreLoadHandle();
    }

    public void apC() {
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
        } else if (aVar.tE() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tE();
            int intValue = ((Integer) sparseArray.get(as.fqR)).intValue();
            if (intValue == as.fqS) {
                if (!this.cqN.bsI()) {
                    this.ffS.aZZ();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cqN.a(this.ffR.getPbData().aVq().getId(), this.ffR.getPbData().aVq().getName(), this.ffR.getPbData().aVs().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == as.fqT || intValue == as.fqV) {
                if (this.ffR.aYH() != null) {
                    this.ffR.aYH().qj(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == as.fqT) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fgm);
        userMuteAddAndDelCustomMessage.setTag(this.fgm);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean qx(String str) {
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

    public void jB(boolean z) {
        this.fga = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aXk() {
        ArrayList<PostData> aVu;
        int v;
        if (this.ffR == null || this.ffR.getPbData() == null || this.ffR.getPbData().aVu() == null || (v = com.baidu.tbadk.core.util.v.v((aVu = this.ffR.getPbData().aVu()))) == 0) {
            return "";
        }
        if (this.ffR.aYx()) {
            Iterator<PostData> it = aVu.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.brX() == 1) {
                    return next.getId();
                }
            }
        }
        int bag = this.ffS.bag();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aVu, bag);
        if (postData == null || postData.rP() == null) {
            return "";
        }
        if (this.ffR.qA(postData.rP().getUserId())) {
            return postData.getId();
        }
        for (int i = bag - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aVu, i);
            if (postData2 == null || postData2.rP() == null || postData2.rP().getUserId() == null) {
                break;
            } else if (this.ffR.qA(postData2.rP().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bag + 1; i2 < v; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aVu, i2);
            if (postData3 == null || postData3.rP() == null || postData3.rP().getUserId() == null) {
                return "";
            }
            if (this.ffR.qA(postData3.rP().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.ax.wf().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(qw(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.ffR.getPbData().aVq().getId(), this.ffR.getPbData().aVq().getName(), this.ffR.getPbData().aVs().getTid());
            }
            this.ffI = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.ffR.aYG() != null) {
                    PbActivity.this.ffR.aYG().cI(j);
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
        aVar.tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c qy(String str) {
        String str2;
        if (this.ffR.getPbData() == null || this.ffR.getPbData().aVu() == null || this.ffR.getPbData().aVu().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.ffR.getPbData().aVu().size()) {
                i = 0;
                break;
            } else if (str.equals(this.ffR.getPbData().aVu().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.ffR.getPbData().aVu().get(i);
        if (postData.brZ() == null || postData.brZ().JH() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.brZ().JH().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.JN() != null) {
                    str2 = next.JN().Ka();
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
        if (this.ffz) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.ffz = false;
        } else if (aXl()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.ffz) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.ffz = false;
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
        if (pageStayDurationItem != null && this.ffR != null) {
            if (this.ffR.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.ffR.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.ffR.aYj(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aXl() {
        return (!this.ffx && this.fhg == -1 && this.fhh == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.fhj = nVar;
            this.ffx = true;
            this.ffS.aZQ();
            this.ffS.qH(this.fhi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        if (this.fhj != null) {
            if (this.fhg == -1) {
                showToast(d.k.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                az.aJ(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fhj.getCartoonId(), this.fhg, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXn() {
        if (this.fhj != null) {
            if (this.fhh == -1) {
                showToast(d.k.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                az.aJ(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fhj.getCartoonId(), this.fhh, 0)));
                finish();
            }
        }
    }

    public int aXo() {
        return this.fhg;
    }

    public int aXp() {
        return this.fhh;
    }

    private void ayG() {
        if (this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null && this.ffR.getPbData().aVs().sA()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void aXq() {
        if (this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null && this.ffR.getPbData().aVs().sA()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void aXr() {
        if (this.ffA) {
            this.ffN = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null && this.ffR.getPbData().aVs().rz() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.ffR.getPbData().aVs().rz().getThreadId(), this.ffR.getPbData().aVs().rz().getTaskId(), this.ffR.getPbData().aVs().rz().getForumId(), this.ffR.getPbData().aVs().rz().getForumName(), this.ffR.getPbData().aVs().rK(), this.ffR.getPbData().aVs().rL())));
            this.ffz = true;
            finish();
        }
    }

    public String aXs() {
        return this.ffL;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a aXt() {
        return this.ffQ;
    }

    public void jC(boolean z) {
        this.ffM = z;
    }

    public boolean aXu() {
        if (this.ffR != null) {
            return this.ffR.aYl();
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
                    ((TbPageContext) PbActivity.this.fgk).showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fgk.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fgk).tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fgk != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fgk.getPageActivity());
            aVar.dc(str);
            aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fgk).tC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.ffS.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fgk.getPageActivity());
        if (com.baidu.tbadk.core.util.an.isEmpty(str)) {
            aVar.dc(this.fgk.getResources().getString(d.k.block_mute_message_alert, str2));
        } else {
            aVar.dc(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.ffS.showLoadingDialog();
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
        aVar.b(this.fgk).tC();
    }

    public void aXw() {
        if (this.ffR != null && this.ffR.getPbData() != null && this.ffR.getPbData().aVs() != null && this.ffR.getPbData().aVs().sP() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.ca(d.k.channel_open_push_message);
            aVar.a(d.k.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.ffR.getPbData().aVs().sP().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.tC();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ax.qJ(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.ffS != null) {
            this.ffS.onConfigurationChanged(configuration);
        }
        if (this.ffY != null) {
            this.ffY.dismiss();
        }
    }

    public boolean aXx() {
        if (this.ffR != null) {
            return this.ffR.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, as asVar) {
        boolean z;
        List<PostData> list = this.ffR.getPbData().aVD().feb;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).brU().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).brU().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).brU().remove(i2);
                    list.get(i).brW();
                    z = true;
                    break;
                }
            }
            list.get(i).sW(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            asVar.n(this.ffR.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.aWc().getId();
        List<PostData> list = this.ffR.getPbData().aVD().feb;
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
                postData.tm(kVar.getTotalCount());
                if (postData.brU() != null) {
                    postData.brU().clear();
                    postData.brU().addAll(aWg);
                }
            }
        }
        if (!this.ffR.getIsFromMark()) {
            this.ffS.n(this.ffR.getPbData());
        }
    }

    public boolean aXy() {
        if (this.ffR == null) {
            return false;
        }
        return this.ffR.aXy();
    }

    public void aXz() {
        if (this.ffS != null) {
            this.ffS.aZF();
            apC();
        }
    }

    public PostData aVz() {
        return this.ffS.b(this.ffR.flr, this.ffR.aYk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ac(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.isLinkThread()) {
                return 3;
            }
            if (bdVar.sR()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fgu != null && !this.fgu.isEmpty()) {
            int size = this.fgu.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fgu.get(i).onBackPressed()) {
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
            if (this.fgu == null) {
                this.fgu = new ArrayList();
            }
            if (!this.fgu.contains(aVar)) {
                this.fgu.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fgu == null) {
                this.fgu = new ArrayList();
            }
            if (!this.fgu.contains(aVar)) {
                this.fgu.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fgu != null) {
            this.fgu.remove(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.cYX == null) {
            this.cYX = new com.baidu.tbadk.core.dialog.i(getPageContext());
        }
        this.cYX.a(contriInfo, -1L);
    }
}
