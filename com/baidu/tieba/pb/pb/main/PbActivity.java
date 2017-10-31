package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
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
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.e.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.pb.CustomDialogData;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.pb.main.PbFloorAgreeModel;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.a.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.share.AddExperiencedModel;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
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
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.e {
    private com.baidu.adp.lib.e.b<ImageView> aSm;
    private com.baidu.adp.lib.e.b<TextView> aSn;
    private com.baidu.adp.lib.e.b<View> aSo;
    private com.baidu.adp.lib.e.b<LinearLayout> aSp;
    private com.baidu.adp.lib.e.b<RelativeLayout> aSq;
    private com.baidu.adp.lib.e.b<GifView> aSr;
    private ShareReportModel anH;
    private com.baidu.adp.lib.e.b<TbImageView> aoy;
    private com.baidu.tieba.e.b bzz;
    private VoiceManager cxA;
    private String eJD;
    private com.baidu.tieba.pb.pb.main.a.b eJW;
    private boolean eKA;
    private com.baidu.tieba.tbadkCore.data.e eKD;
    private com.baidu.tbadk.editortools.pb.e eKE;
    private com.baidu.tbadk.editortools.pb.d eKF;
    private com.baidu.adp.base.e eKJ;
    private com.baidu.tbadk.core.view.c eKK;
    private BdUniqueId eKL;
    private Runnable eKM;
    private at eKN;
    private com.baidu.adp.widget.a.a eKO;
    private String eKP;
    private TbRichTextMemeInfo eKQ;
    private List<a> eKT;
    private com.baidu.tbadk.core.dialog.a eKc;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eKn;
    private View eKo;
    public ar eKx;
    private w eKy;
    private String eLE;
    private com.baidu.tbadk.core.data.n eLF;
    private boolean eLs;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eJV = false;
    private boolean eJX = false;
    private boolean eJY = false;
    private boolean eqa = false;
    private boolean eJZ = true;
    private int eKa = 0;
    private com.baidu.tbadk.core.dialog.b eKb = null;
    private long cko = -1;
    private long aJJ = 0;
    private long eKd = 0;
    private long createTime = 0;
    private long aJB = 0;
    private boolean eKe = false;
    private com.baidu.tbadk.l.d eKf = null;
    private long eKg = 0;
    private boolean eKh = false;
    private long eKi = 0;
    private String aDb = null;
    private boolean eKj = false;
    private boolean isFullScreen = false;
    private String eKk = "";
    private boolean eKl = true;
    private boolean eKm = false;
    private String source = "";
    private PbInterviewStatusView.a eKp = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eKs.jl(!PbActivity.this.eKl);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eKq != null && PbActivity.this.eKq.nC()) {
                        PbActivity.this.aRB();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahv));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahv));
        }
    };
    private PbModel eKq = null;
    private com.baidu.tbadk.baseEditMark.a enp = null;
    private ForumManageModel eKr = null;
    private com.baidu.tbadk.coreExtra.c.a aoZ = null;
    private ap eKs = null;
    public final com.baidu.tieba.pb.pb.main.a.a eKt = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eKu = false;
    private boolean eKv = false;
    private boolean eKw = false;
    private boolean eKz = false;
    private boolean eKB = false;
    private boolean eKC = false;
    private boolean eKG = false;
    private com.baidu.tbadk.editortools.pb.c aDf = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Df() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDg = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean De() {
            if (PbActivity.this.eKx == null || PbActivity.this.eKx.aVe() == null || !PbActivity.this.eKx.aVe().bCf()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eKx.aVe().bCh());
            PbActivity.this.eKx.ju(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b eKH = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean De() {
            if (PbActivity.this.eKx == null || PbActivity.this.eKx.aVf() == null || !PbActivity.this.eKx.aVf().bCf()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eKx.aVf().bCh());
            PbActivity.this.eKx.jv(true);
            return true;
        }
    };
    private boolean eKI = false;
    private int mLastScrollState = -1;
    private boolean cyg = false;
    private int eKR = 0;
    private int eKS = -1;
    private final x.a eKU = new x.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void B(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eKs.showToast(str);
            }
        }
    };
    private final CustomMessageListener eKV = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eKq != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eKF != null) {
                    PbActivity.this.eKs.hb(PbActivity.this.eKF.Do());
                }
                PbActivity.this.eKs.aTW();
                PbActivity.this.eKs.aEQ();
            }
        }
    };
    CustomMessageListener cyw = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                PbActivity.this.eKq.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                if (PbActivity.this.eKs != null && PbActivity.this.eKq != null) {
                    PbActivity.this.eKs.d(PbActivity.this.eKq.getPbData(), PbActivity.this.eKq.aSA(), PbActivity.this.eKq.aSR());
                }
                if (PbActivity.this.eKs != null && PbActivity.this.eKs.aUn() != null) {
                    PbActivity.this.eKs.aUn().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eKW = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eKs != null) {
                    if (booleanValue) {
                        PbActivity.this.eKs.azr();
                    } else {
                        PbActivity.this.eKs.azq();
                    }
                }
            }
        }
    };
    private CustomMessageListener dVZ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eKF != null) {
                    PbActivity.this.eKs.hb(PbActivity.this.eKF.Do());
                }
                PbActivity.this.eKs.hc(false);
            }
        }
    };
    private CustomMessageListener dWv = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.m) eVar.getData());
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
    private CustomMessageListener eKX = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eKs != null && PbActivity.this.eKs.aUn() != null) {
                PbActivity.this.eKs.aUn().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dvG = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private j.a eKY = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.px(2);
                ag.aTG().reset();
                PbActivity.this.eKq.aSS();
                boolean z2 = false;
                ArrayList<PostData> aPQ = PbActivity.this.eKq.getPbData().aPQ();
                if (aPQ != null) {
                    Iterator<PostData> it = aPQ.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ao.k(next) && next.buC().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eKs.o(PbActivity.this.eKq.getPbData());
                    }
                    PbActivity.this.showToast(d.j.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(d.j.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(d.j.operation_failed);
        }
    };
    private View.OnClickListener dVY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aDb);
        }
    };
    CustomMessageListener dgy = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eKZ = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                aq.a aVar = new aq.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.WE = abVar.WE;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKq.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eKq.aSI() != null && PbActivity.this.eKq.aSI().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eKs.a(abVar.sendCount, PbActivity.this.eKq.getPbData(), PbActivity.this.eKq.aSA(), PbActivity.this.eKq.aSR());
                    }
                    if (pbData.aPQ() != null && pbData.aPQ().size() >= 1 && pbData.aPQ().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aPQ().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eKq.aSz(), 0L);
                        if (c2 == abVar.postId && c3 == abVar.threadId) {
                            com.baidu.tbadk.core.data.aq buB = pbData.aPQ().get(0).buB();
                            if (buB == null) {
                                buB = new com.baidu.tbadk.core.data.aq();
                            }
                            ArrayList<aq.a> qu = buB.qu();
                            if (qu == null) {
                                qu = new ArrayList<>();
                            }
                            qu.add(0, aVar);
                            buB.bM(abVar.sendCount + buB.qt());
                            buB.g(qu);
                            pbData.aPQ().get(0).a(buB);
                            PbActivity.this.eKs.aUn().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eLa = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.afG() != null && !aVar.afG().isEmpty()) {
                    PbActivity.this.eKs.a(aVar, PbActivity.this.eLc);
                }
                PbActivity.this.eKs.a(aVar, PbActivity.this.eKq.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.aVr()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a eLb = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void B(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.v(list) && PbActivity.this.eKs != null) {
                PbActivity.this.eKs.cw(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eLc = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aT(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.fJ().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbActivity.this.getUniqueId());
            } else {
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_BOTTOM)));
            }
        }
    };
    private boolean eLd = false;
    private PraiseModel eLe = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hS(String str) {
            PbActivity.this.eLd = false;
            if (PbActivity.this.eLe != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKq.getPbData();
                if (pbData.aPO().ri().getIsLike() == 1) {
                    PbActivity.this.jQ(0);
                } else {
                    PbActivity.this.jQ(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aPO()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void C(int i, String str) {
            PbActivity.this.eLd = false;
            if (PbActivity.this.eLe != null && str != null) {
                if (AntiHelper.tW(i)) {
                    AntiHelper.ao(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eLf = 0;
    private boolean eLg = true;
    private b.a eLh = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void iM(boolean z) {
            PbActivity.this.iL(z);
            if (PbActivity.this.eKs.aUQ() != null && z) {
                PbActivity.this.eKs.jl(false);
            }
            PbActivity.this.eKs.jn(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().arL != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().arL, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahv));
                        }
                    } else if (updateAttentionMessage.getData().BJ) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aPV().rt() != null && PbActivity.this.aPV().rt().getGodUserData() != null) {
                            PbActivity.this.aPV().rt().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aPO() != null && PbActivity.this.eKq.getPbData().aPO().rt() != null) {
                            PbActivity.this.eKq.getPbData().aPO().rt().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bza = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eKs.VG();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.py(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.aqO();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aSw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eKs.aTX()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eKq != null && (PbActivity.this.eKq.getPbData() != null || PbActivity.this.eKq.getPbData().aQk() != null)) {
                    if (PbActivity.this.eKq.getPbData().aQk().aQt()) {
                        if (PbActivity.this.eKq.getPbData().aQk().eGT == 1 || PbActivity.this.eKq.getPbData().aQk().eGT == 3 || PbActivity.this.eKq.getPbData().aQk().eGT == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eKq.getPbData().aQk().aQt() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eKq.getPbData().aQk().aQt() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eKi > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).jR(false);
                        PbActivity.this.eKi = System.currentTimeMillis();
                    }
                }
            }
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == d.g.richText) {
                    if (PbActivity.this.bh(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.eKs != null && PbActivity.this.eKs.aRl() && (view.getId() == d.g.pb_head_user_info_root || view == PbActivity.this.eKs.aUX())) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ac("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.eKt != null && PbActivity.this.eKt.eXH != null) {
                            PbActivity.this.eKt.eXH.onClick(view);
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
            if (PbActivity.this.eKF != null) {
                PbActivity.this.eKs.hb(PbActivity.this.eKF.Do());
            }
            PbActivity.this.eKs.aTW();
            PbActivity.this.eKs.aEQ();
            return true;
        }
    });
    private CustomMessageListener eLi = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eKL) {
                PbActivity.this.eKs.VG();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKq.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aQb().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eKK.c(PbActivity.this.eKJ.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eKJ.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.fZ(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aRS();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eKJ.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.eKK.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eLj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eKL) {
                PbActivity.this.eKs.VG();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eKK.c(PbActivity.this.eKJ.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eKJ.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.eKK.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eLk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eKL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eKs.VG();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gCl;
                if (aVar.error == 0 && dataRes != null) {
                    int g = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = g == 1;
                    if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
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
                    PbActivity.this.eKs.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eLl = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eKs.aTX() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aQS() != null && PbActivity.this.aQS().getPbData() != null && PbActivity.this.aQS().getPbData().aQk() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aQt = PbActivity.this.aQS().getPbData().aQk().aQt();
                if (intValue < 10) {
                    if (aQt) {
                        if (PbActivity.this.eKq.getPbData().aQk().eGT == 1 || PbActivity.this.eKq.getPbData().aQk().eGT == 3 || PbActivity.this.eKq.getPbData().aQk().eGT == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eKq.getPbData().aQk().aQt() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQt ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eKi > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).jR(false);
                        PbActivity.this.eKi = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aQt);
                TiebaStatic.log(PbActivity.this.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aQt ? 0 : 1));
            }
        }
    };
    private CustomMessageListener cyG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cyg = true;
                }
            }
        }
    };
    public a.b eyU = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.ajl();
            com.baidu.tbadk.core.data.ap atJ = PbActivity.this.eKq.atJ();
            int pageNum = PbActivity.this.eKs.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (atJ == null || pageNum <= atJ.qm()) {
                PbActivity.this.eKs.aEQ();
                PbActivity.this.px(2);
                PbActivity.this.ajk();
                PbActivity.this.eKs.aUr();
                if (com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.eKq.pD(PbActivity.this.eKs.getPageNum());
                    if (PbActivity.this.eJW != null) {
                        PbActivity.this.eJW.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(d.j.pb_page_error);
            }
        }
    };
    public final View.OnClickListener czc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Multi-variable search result rejected for r4v158, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v162, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v203, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v24, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v317, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:676:0x1f45  */
        /* JADX WARN: Removed duplicated region for block: B:703:0x213b  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String name;
            com.baidu.tieba.pb.data.l aQk;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            String str;
            int i;
            bl blVar;
            SparseArray sparseArray;
            PostData postData;
            boolean j;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.eKs.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.eKq.iT(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.eKs.aUs();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTz()) {
                        if (view == PbActivity.this.eKs.eRA.aLE) {
                            if (PbActivity.this.eKs.jp(PbActivity.this.eKq.aSF())) {
                                PbActivity.this.ajk();
                                return;
                            }
                            PbActivity.this.eJZ = false;
                            PbActivity.this.eJX = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eKs.aUp() && (PbActivity.this.eKs.eRA.aVW() == null || (view != PbActivity.this.eKs.eRA.aVW().aTy() && view != PbActivity.this.eKs.eRA.aVW().aTw()))) {
                            if (view == PbActivity.this.eKs.aUI()) {
                                if (PbActivity.this.eKq != null) {
                                    com.baidu.tbadk.browser.a.O(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eKq.getPbData().aPO().rs().getLink());
                                }
                            } else if (view != PbActivity.this.eKs.eRA.eYr && view.getId() != d.g.view_forum_name_first_floor) {
                                if (view == PbActivity.this.eKs.eRA.eYs) {
                                    if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null) {
                                        ArrayList<PostData> aPQ = PbActivity.this.eKq.getPbData().aPQ();
                                        if ((aPQ == null || aPQ.size() <= 0) && PbActivity.this.eKq.aSA()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ac("tid", PbActivity.this.eKq.aSz()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getForumId()));
                                        if (!PbActivity.this.eKs.aUY()) {
                                            PbActivity.this.eKs.aTW();
                                        }
                                        PbActivity.this.aRs();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTk()) {
                                        if ((PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTv()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.eKs.eRA.aVW() == null || (view != PbActivity.this.eKs.eRA.aVW().getCancelView() && view != PbActivity.this.eKs.eRA.aVW().aTu())) {
                                                if (view != PbActivity.this.eKs.eRA.eYt) {
                                                    if (PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTs()) {
                                                        if ((PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTB()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTt()) {
                                                                if (PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTC()) {
                                                                    if (PbActivity.this.eKy == null || view != PbActivity.this.eKy.aTm()) {
                                                                        if (PbActivity.this.eKy == null || view != PbActivity.this.eKy.aTk()) {
                                                                            if (PbActivity.this.eKy == null || view != PbActivity.this.eKy.aTp()) {
                                                                                if (PbActivity.this.eKy == null || view != PbActivity.this.eKy.aTn()) {
                                                                                    if (PbActivity.this.eKy == null || view != PbActivity.this.eKy.aTo()) {
                                                                                        if (PbActivity.this.eKs.aUQ() == view) {
                                                                                            if (PbActivity.this.eKs.aUQ().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKq.getPbData();
                                                                                                if (pbData != null && pbData.aPO() != null && pbData.aPO().qZ() != null) {
                                                                                                    String pB = pbData.aPO().qZ().pB();
                                                                                                    if (StringUtils.isNull(pB)) {
                                                                                                        pB = pbData.aPO().qZ().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ac("obj_id", pB));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.bZ("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.aRN();
                                                                                        } else if (PbActivity.this.eKs.aUm() != view) {
                                                                                            if (PbActivity.this.eKy == null || view != PbActivity.this.eKy.aTl()) {
                                                                                                if (PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTA()) {
                                                                                                    if (PbActivity.this.eKs.eRA.aVW() != null && view == PbActivity.this.eKs.eRA.aVW().aTx()) {
                                                                                                        if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.eKs.c(PbActivity.this.eKq.getPbData(), PbActivity.this.eKq.aSA(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                PbActivity.this.eKs.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                            PbActivity.this.eKs.eRA.om();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.eKs.aRe()) {
                                                                                                            if (view == PbActivity.this.eKs.eRA.aVX()) {
                                                                                                                PbActivity.this.eKs.aUz();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (blVar = (bl) view.getTag()) != null && !StringUtils.isNull(blVar.sW())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        av.vI().c(PbActivity.this.getPageContext(), new String[]{blVar.sW()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData bi = PbActivity.this.bi(view);
                                                                                                                    if (bi != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", bi.buH() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state) {
                                                                                                                    PbActivity.this.f(view, 2, false);
                                                                                                                    if (PbActivity.this.aQS() != null && PbActivity.this.aQS().getPbData() != null && PbActivity.this.aQS().getPbData().aQk() != null && PbActivity.this.aQS().getPbData().aQk() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aQS().getPbData().aQk().aQt() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && !StringUtils.isNull(PbActivity.this.eKq.getPbData().getThreadId()) && (aQk = PbActivity.this.eKq.getPbData().aQk()) != null && aQk.aQs() > 0) {
                                                                                                                        av.vI().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eKq.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.eKy == null) {
                                                                                                                                PbActivity.this.eKy = new w(PbActivity.this.getPageContext(), PbActivity.this.czc);
                                                                                                                                PbActivity.this.eKs.bp(PbActivity.this.eKy.getView());
                                                                                                                                PbActivity.this.eKy.iX(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.eKy.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ac("tid", PbActivity.this.eKq.eNT));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.eKy.aTk().setTag(sparseArray2);
                                                                                                                            PbActivity.this.eKy.aTp().setTag(view.getTag());
                                                                                                                            PbActivity.this.eKy.iZ(z6);
                                                                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
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
                                                                                                                                    PbActivity.this.eKy.aTn().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.eKy.aTn().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.eKy.aTl().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eKy.aTn().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eKy.aTl().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.eKy.aTl().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.eKy.aTl().setVisibility(8);
                                                                                                                                PbActivity.this.eKy.aTn().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.eKy.aTl().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eKy.aTn().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eKy.aTl().setText(d.j.delete);
                                                                                                                                PbActivity.this.eKy.aTn().setVisibility(0);
                                                                                                                                if (PbActivity.this.eKq.getPbData().aPZ() != 1002 || z2) {
                                                                                                                                    PbActivity.this.eKy.aTn().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eKy.aTn().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.eKy.aTl().setVisibility(8);
                                                                                                                            }
                                                                                                                            SparseArray sparseArray6 = (SparseArray) view.getTag();
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
                                                                                                                                PbActivity.this.eKy.aTm().setTag(sparseArray7);
                                                                                                                                PbActivity.this.eKy.aTm().setVisibility(0);
                                                                                                                                PbActivity.this.eKy.aTl().setVisibility(8);
                                                                                                                                PbActivity.this.eKy.aTm().setText(d.j.mute_option);
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
                                                                                                                                boolean iH = PbActivity.this.iH(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.eLw = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (ao.k(PbActivity.this.eLw) ? false : iH) {
                                                                                                                                    PbActivity.this.eKy.aTm().setVisibility(0);
                                                                                                                                    PbActivity.this.eKy.aTm().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eKy.aTm().setVisibility(8);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                                                                            long j2 = 0;
                                                                                                                            if (!(sparseArray8.get(d.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                z5 = false;
                                                                                                                            } else {
                                                                                                                                z5 = ((Boolean) sparseArray8.get(d.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                            }
                                                                                                                            if (sparseArray8.get(d.g.tag_chudian_template_id) instanceof Long) {
                                                                                                                                j2 = ((Long) sparseArray8.get(d.g.tag_chudian_template_id)).longValue();
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
                                                                                                                                PbActivity.this.eKy.aTo().setVisibility(0);
                                                                                                                                PbActivity.this.eKy.aTo().setTag(d.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                                PbActivity.this.eKy.aTo().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.eKy.aTo().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.eKy.aTo().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eKq.getPbData().nC()) {
                                                                                                                            String nB = PbActivity.this.eKq.getPbData().nB();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(nB) && nB.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.eKy.aTk().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eKy.aTk().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.eKy.iY(true);
                                                                                                                                PbActivity.this.eKy.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.eKy.iY(true);
                                                                                                                        PbActivity.this.eKy.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aPO() != null && PbActivity.this.eKq.getPbData().aPO().sa() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), PbActivity.this.eKq.getPbData().aPO().sa());
                                                                                                                        if (PbActivity.this.eKq.getPbData().aPO().rY() != 1) {
                                                                                                                            if (PbActivity.this.eKq.getPbData().aPO().rY() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getPbData().getForumId()).ac("tid", PbActivity.this.eKq.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.eKq.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.eKs.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (ax.aT(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.j.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.eKs.aTW();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aRp() == 1) {
                                                                                                                            if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getPbData().getForumId()).ac("tid", PbActivity.this.eKq.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aRp() == 2 && PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getPbData().getForumId()).ac("tid", PbActivity.this.eKq.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.aRp() == 1) {
                                                                                                                            if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getPbData().getForumId()).ac("tid", PbActivity.this.eKq.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aRp() == 2 && PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getPbData().getForumId()).ac("tid", PbActivity.this.eKq.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.aRI();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.aRJ();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aQg() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eKq.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ac(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        av.vI().c(PbActivity.this.getPageContext(), new String[]{pbData2.aQg().aQo()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aQg() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eKq.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        av.vI().c(PbActivity.this.getPageContext(), new String[]{pbData3.aQg().aQo()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.eKs.eRA.aVW() != null && view == PbActivity.this.eKs.eRA.aVW().aTD()) {
                                                                                                                    if (PbActivity.this.eKq == null || PbActivity.this.eKq.getPbData() == null || PbActivity.this.eKq.getPbData().aPO() == null) {
                                                                                                                        PbActivity.this.eKs.eRA.om();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.hy()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.eKq.getPbData().aPO().rb() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eKq.aSz(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).tq();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").r("obj_locate", PbActivity.this.W(PbActivity.this.eKq.getPbData().aPO())).ac("tid", PbActivity.this.eKq.getPbData().aPO().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.eKR >= 0) {
                                                                                                                        if (PbActivity.this.eKq != null) {
                                                                                                                            PbActivity.this.eKq.aTg();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eKs.aUn() != null) {
                                                                                                                            PbActivity.this.eKs.aUn().a(PbActivity.this.eKq.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.eKs.getListView().setSelection(PbActivity.this.eKq.aTj());
                                                                                                                        PbActivity.this.eKR = 0;
                                                                                                                        if (PbActivity.this.eKq != null) {
                                                                                                                            PbActivity.this.eKq.bv(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.eKs.aVb();
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eKq.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eKq.aSz(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eKq.getPbData().aPO().rO())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.eKq.getPbData() != null) {
                                                                                                            PbActivity.this.eKs.aEQ();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                String aSz = PbActivity.this.eKq.aSz();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.eKq.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.eKq.getPbData().aPZ();
                                                                                                                }
                                                                                                                PbActivity.this.ajk();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c pt = PbActivity.this.pt(id2);
                                                                                                                    if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && pt != null) {
                                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aSz, id2, "pb", true, null, true, null, i3, postData3.aWP(), PbActivity.this.eKq.getPbData().qf(), false, postData3.rt().getIconInfo()).addBigImageData(pt.eMb, pt.eMc, pt.eMd, pt.index)));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (view.getId() == d.g.sub_pb_item) {
                                                                                                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                                                                                    String str5 = (String) sparseArray10.get(d.g.tag_photo_username);
                                                                                                                    String str6 = (String) sparseArray9.get(d.g.tag_photo_userid);
                                                                                                                    PostData postData4 = (PostData) sparseArray10.get(d.g.tag_load_sub_data);
                                                                                                                    String str7 = null;
                                                                                                                    if (postData4 != null) {
                                                                                                                        str7 = postData4.getId();
                                                                                                                    }
                                                                                                                    TiebaStatic.log("c11741");
                                                                                                                    c pt2 = PbActivity.this.pt(id2);
                                                                                                                    if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && pt2 != null && PbActivity.this.aRk().aTU() != null) {
                                                                                                                        com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                        mVar.b(PbActivity.this.eKq.getPbData().aPM());
                                                                                                                        mVar.M(PbActivity.this.eKq.getPbData().aPO());
                                                                                                                        mVar.d(postData4);
                                                                                                                        PbActivity.this.aRk().aTU().d(mVar);
                                                                                                                        PbActivity.this.aRk().aTU().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c pt3 = PbActivity.this.pt(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && pt3 != null) {
                                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aSz, id2, "pb", true, null, false, null, i3, postData3.aWP(), PbActivity.this.eKq.getPbData().qf(), false, postData3.rt().getIconInfo()).addBigImageData(pt3.eMb, pt3.eMc, pt3.eMd, pt3.index)));
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                    PbActivity.this.eKs.aEQ();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.eKs.c(PbActivity.this.eKq.getPbData(), PbActivity.this.eKq.aSA(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eKq.getPbData().aPM().getId(), PbActivity.this.eKq.getPbData().aPM().getName(), PbActivity.this.eKq.getPbData().aPO().getId(), String.valueOf(PbActivity.this.eKq.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    PbActivity.this.showToast(d.j.network_not_available);
                                                                                                    return;
                                                                                                }
                                                                                            } else if (!com.baidu.adp.lib.util.j.hh()) {
                                                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                                                return;
                                                                                            } else {
                                                                                                SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                                if (sparseArray11 != null) {
                                                                                                    if (!com.baidu.tieba.c.a.Zt() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eKq.aSz(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
                                                                                                        boolean booleanValue4 = ((Boolean) sparseArray11.get(d.g.tag_should_manage_visible)).booleanValue();
                                                                                                        boolean booleanValue5 = ((Boolean) sparseArray11.get(d.g.tag_should_delete_visible)).booleanValue();
                                                                                                        boolean booleanValue6 = ((Boolean) sparseArray11.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                                        if (booleanValue4) {
                                                                                                            if (booleanValue6) {
                                                                                                                sparseArray11.put(d.g.tag_from, 1);
                                                                                                                sparseArray11.put(d.g.tag_check_mute_from, 2);
                                                                                                                PbActivity.this.c(sparseArray11);
                                                                                                            } else {
                                                                                                                sparseArray11.put(d.g.tag_check_mute_from, 2);
                                                                                                                PbActivity.this.eKs.bn(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.eKs.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.aRg();
                                                                                        }
                                                                                    } else {
                                                                                        long j3 = -1;
                                                                                        String str8 = "";
                                                                                        int i4 = 0;
                                                                                        if (view.getTag(d.g.tag_chudian_template_id) instanceof Long) {
                                                                                            j3 = ((Long) view.getTag(d.g.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (view.getTag(d.g.tag_chudian_monitor_id) instanceof String) {
                                                                                            str8 = (String) view.getTag(d.g.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (view.getTag(d.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                            i4 = ((Integer) view.getTag(d.g.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eKq.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aPM() != null) {
                                                                                            str9 = pbData4.aPM().getId();
                                                                                            str10 = pbData4.aPM().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.a.a(j3, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j3, str8, str9, str10, str11, i4);
                                                                                    }
                                                                                } else {
                                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                                    if (sparseArray12 != null) {
                                                                                        if ((sparseArray12.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_id) instanceof String) && (sparseArray12.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                            boolean booleanValue7 = ((Boolean) sparseArray12.get(d.g.tag_del_post_is_self)).booleanValue();
                                                                                            int intValue = ((Integer) sparseArray12.get(d.g.tag_manage_user_identity)).intValue();
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.Zt() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eKq.aSz(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.eKs.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.eKy.aTr()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ac("tid", PbActivity.this.eKq.eNT));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eKq.getPbData() != null) {
                                                                                    PbActivity.this.eKs.aEQ();
                                                                                    if (!(view.getTag() instanceof SparseArray)) {
                                                                                        sparseArray = null;
                                                                                    } else {
                                                                                        sparseArray = (SparseArray) view.getTag();
                                                                                    }
                                                                                    if (sparseArray == null || !(sparseArray.get(d.g.tag_load_sub_data) instanceof PostData)) {
                                                                                        postData = null;
                                                                                    } else {
                                                                                        postData = (PostData) sparseArray.get(d.g.tag_load_sub_data);
                                                                                    }
                                                                                    if (postData != null) {
                                                                                        String aSz2 = PbActivity.this.eKq.aSz();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.eKq.getPbData() != null) {
                                                                                            i5 = PbActivity.this.eKq.getPbData().aPZ();
                                                                                        }
                                                                                        PbActivity.this.ajk();
                                                                                        c pt4 = PbActivity.this.pt(id3);
                                                                                        if (pt4 != null) {
                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aSz2, id3, "pb", true, null, true, null, i5, postData.aWP(), PbActivity.this.eKq.getPbData().qf(), false, postData.rt().getIconInfo()).addBigImageData(pt4.eMb, pt4.eMc, pt4.eMd, pt4.index)));
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bj(view);
                                                                                if (PbActivity.this.eKq.getPbData().aPO() != null && PbActivity.this.eKq.getPbData().aPO().rt() != null && PbActivity.this.eKq.getPbData().aPO().rt().getUserId() != null && PbActivity.this.enp != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eKq.eNT).r("obj_locate", 2).ac("obj_id", PbActivity.this.eKq.getPbData().aPO().rt().getUserId()).r("obj_type", PbActivity.this.enp.nC() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eKq.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 4));
                                                                        if (!com.baidu.adp.lib.util.j.hh()) {
                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                            return;
                                                                        }
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            PbActivity.this.pq((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            SparseArray<Object> sparseArray13 = (SparseArray) tag;
                                                                            if ((sparseArray13.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray13.get(d.g.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray13.put(d.g.tag_from, 0);
                                                                                sparseArray13.put(d.g.tag_check_mute_from, 2);
                                                                                PbActivity.this.c(sparseArray13);
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        PbActivity.this.eKs.onChangeSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").r("obj_type", 0).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        PbActivity.this.eKs.onChangeSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.eKs.eRA.om();
                                                                }
                                                            } else if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aPO() != null) {
                                                                PbActivity.this.eKs.eRA.om();
                                                                PbActivity.this.pq(PbActivity.this.eKq.getPbData().aPO().rK());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.eKs.aEQ();
                                                            if (com.baidu.adp.lib.util.j.hh()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.eKq.aSM()));
                                                                    return;
                                                                }
                                                                PbActivity.this.px(2);
                                                                PbActivity.this.ajk();
                                                                PbActivity.this.eKs.aUr();
                                                                boolean aSL = PbActivity.this.eKq.aSL();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.eKq.aSM()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.eKs.eRA != null && PbActivity.this.eKs.eRA.aVW() != null && view == PbActivity.this.eKs.eRA.aVW().aTB()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (aSL) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.eKs.ji(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.eKs.aEQ();
                                                        if (PbActivity.this.eKq.atJ() != null) {
                                                            PbActivity.this.eKs.a(PbActivity.this.eKq.atJ(), PbActivity.this.eyU);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.p.al.fS() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.eKq != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ac("tid", PbActivity.this.eKq.aSz()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.hy()) {
                                                        if (PbActivity.this.eKq.getPbData() != null) {
                                                            ArrayList<PostData> aPQ2 = PbActivity.this.eKq.getPbData().aPQ();
                                                            if ((aPQ2 != null && aPQ2.size() > 0) || !PbActivity.this.eKq.aSA()) {
                                                                PbActivity.this.eKs.aEQ();
                                                                PbActivity.this.ajk();
                                                                PbActivity.this.px(2);
                                                                if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aQg() != null && !StringUtils.isNull(PbActivity.this.eKq.getPbData().aQg().pQ(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.p.al.fS()) {
                                                                    PbActivity.this.py(2);
                                                                } else {
                                                                    PbActivity.this.eKs.showLoadingDialog();
                                                                    PbActivity.this.eKq.aTa().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                }
                                                            } else {
                                                                com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        PbActivity.this.showToast(d.j.neterror);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.eKs.eRA.om();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.hh()) {
                                            PbActivity.this.eKs.aEQ();
                                            if (PbActivity.this.eKs.eRA.aVW() != null && view == PbActivity.this.eKs.eRA.aVW().aTv() && !PbActivity.this.eKs.aUY()) {
                                                PbActivity.this.eKs.aTW();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.ajk();
                                                PbActivity.this.eKs.aUr();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    j = PbActivity.this.eKq.j(true, PbActivity.this.aRG());
                                                } else {
                                                    j = view.getId() == d.g.reply_title ? PbActivity.this.eKq.j(false, PbActivity.this.aRG()) : PbActivity.this.eKq.pv(PbActivity.this.aRG());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.eKs.iQ(true);
                                                    PbActivity.this.eKs.azr();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.eKs.ji(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.px(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.hh()) {
                                        PbActivity.this.eKs.aEQ();
                                        if (PbActivity.this.pw(11009) && PbActivity.this.eKq.pK(PbActivity.this.eKs.aUw()) != null) {
                                            PbActivity.this.aRA();
                                            if (PbActivity.this.eKq.getPbData().aPO() != null && PbActivity.this.eKq.getPbData().aPO().rt() != null && PbActivity.this.eKq.getPbData().aPO().rt().getUserId() != null && PbActivity.this.enp != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eKq.eNT).r("obj_locate", 1).ac("obj_id", PbActivity.this.eKq.getPbData().aPO().rt().getUserId()).r("obj_type", PbActivity.this.enp.nC() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eKq.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                    PbActivity.this.eKs.iQ(true);
                                    PbActivity.this.eKs.aTW();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eKs.azr();
                                        PbActivity.this.ajk();
                                        PbActivity.this.eKs.aUr();
                                        PbActivity.this.eKq.pv(PbActivity.this.aRG());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.px(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(d.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (view.getId() == d.g.view_forum_name_first_floor) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12505").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, com.baidu.tieba.pb.d.v(PbActivity.this.getPageContext())));
                                }
                                if (PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aPO() != null && PbActivity.this.eKq.getPbData().aPO().sh() && PbActivity.this.eKq.getPbData().aPO().rL() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.eKq.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eKq.aSy()) && PbActivity.this.eKq.getAppealInfo() != null) {
                                        name = PbActivity.this.eKq.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eKq.getPbData().aPM().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aSy = PbActivity.this.eKq.aSy();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eKq.aSB() && aSy != null && aSy.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.hh()) {
                            if (PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aPZ() == 1 && !PbActivity.this.eKr.bvg()) {
                                PbActivity.this.eKs.aEQ();
                                int i6 = 0;
                                if (PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTw()) {
                                    if (PbActivity.this.eKs.eRA.aVW() == null || view != PbActivity.this.eKs.eRA.aVW().aTy()) {
                                        if (view == PbActivity.this.eKs.aUp()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eKq.getPbData().aPO().rp() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eKq.getPbData().aPO().ro() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aPM = PbActivity.this.eKq.getPbData().aPM();
                                String name2 = aPM.getName();
                                String id4 = aPM.getId();
                                String id5 = PbActivity.this.eKq.getPbData().aPO().getId();
                                if (!com.baidu.tieba.c.a.Zt() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eKs.aUo();
                                    PbActivity.this.eKr.a(id4, name2, id5, i6, PbActivity.this.eKs.aUq());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.hh()) {
                        PbActivity.this.eKs.aEQ();
                        PbActivity.this.ajk();
                        PbActivity.this.eKs.aUr();
                        PbActivity.this.eKs.showLoadingDialog();
                        if (PbActivity.this.eKs.aUe() != null) {
                            PbActivity.this.eKs.aUe().setVisibility(8);
                        }
                        PbActivity.this.eKq.pD(1);
                        if (PbActivity.this.eJW != null) {
                            PbActivity.this.eJW.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String aRn = PbActivity.this.aRn();
                        if (!TextUtils.isEmpty(aRn)) {
                            av.vI().c(PbActivity.this.getPageContext(), new String[]{aRn});
                        }
                    }
                } else if (PbActivity.this.eKh) {
                    PbActivity.this.eKh = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.aRk().aTU() != null && postData5.rt() != null && postData5.buu() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.aRk().aTV() != null) {
                                    PbActivity.this.aRk().aTV().aSr();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.eKq.getPbData().aPM());
                                mVar2.M(PbActivity.this.eKq.getPbData().aPO());
                                mVar2.d(postData5);
                                PbActivity.this.aRk().aTU().d(mVar2);
                                PbActivity.this.aRk().aTU().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.rt().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.eKF != null) {
                                    PbActivity.this.eKs.hb(PbActivity.this.eKF.Do());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aDo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.ajk();
            PbActivity.this.eKs.a(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.ad.GB() && PbActivity.this.aQS() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aQS().py(postWriteCallBackData.getPostId());
                    PbActivity.this.eKR = PbActivity.this.eKs.aTZ();
                    if (PbActivity.this.eKq != null) {
                        PbActivity.this.eKq.bv(PbActivity.this.eKR, PbActivity.this.eKs.aUa());
                    }
                }
                PbActivity.this.eKs.aEQ();
                PbActivity.this.eKx.aVd();
                if (PbActivity.this.eKF != null) {
                    PbActivity.this.eKs.hb(PbActivity.this.eKF.Do());
                }
                PbActivity.this.eKs.aTT();
                PbActivity.this.eKs.hc(true);
                PbActivity.this.eKq.aSO();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eKq.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKq.getPbData();
                            if (pbData != null && pbData.aPO() != null && pbData.aPO().rt() != null && (userId = pbData.aPO().rt().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.ad.GB() && PbActivity.this.eKq.aSH()) {
                                PbActivity.this.eKs.aUr();
                            }
                        } else if (!com.baidu.tbadk.p.ad.GB() && PbActivity.this.eKq.aSH()) {
                            PbActivity.this.eKs.aUr();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eKs.o(PbActivity.this.eKq.getPbData());
                    }
                    if (PbActivity.this.eKq.aSE()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ac("tid", PbActivity.this.eKq.aSz()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                PbActivity.this.eKx.d(postWriteCallBackData);
            } else if (qVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d eLm = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.eKx != null) {
                if (z) {
                    PbActivity.this.eKx.aVc();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbActivity.this.eKx.e(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a eLn = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eN;
            if (!z || fVar == null || fVar.aPX() != null || com.baidu.tbadk.core.util.v.u(fVar.aPQ()) >= 1) {
                PbActivity.this.eqa = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eKs.aUt();
                if (fVar == null || !fVar.aPU()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eKs.getView());
                } else if (PbActivity.this.eKs.aTR() == null) {
                    PbActivity.this.eKI = true;
                }
                PbActivity.this.eKs.azq();
                if (PbActivity.this.isFullScreen || PbActivity.this.eKs.aUY()) {
                    PbActivity.this.eKs.aUM();
                } else if (!PbActivity.this.eKs.aUL()) {
                    PbActivity.this.eKs.hc(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eKz = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eKs.Od();
                    PbActivity.this.eKs.jr(fVar.aPU());
                    if (fVar.aPO() != null && fVar.aPO().sr() != null) {
                        PbActivity.this.a(fVar.aPO().sr());
                    }
                    PbActivity.this.aRh();
                    if (PbActivity.this.eKF != null) {
                        PbActivity.this.eKs.hb(PbActivity.this.eKF.Do());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aPQ() != null && fVar.aPQ().size() >= 1 && fVar.aPQ().get(0) != null) {
                        PbActivity.this.eKq.px(fVar.aPQ().get(0).getId());
                    } else if (fVar.aPX() != null) {
                        PbActivity.this.eKq.px(fVar.aPX().getId());
                    }
                    if (PbActivity.this.eKF != null) {
                        PbActivity.this.eKF.a(fVar.qf());
                        PbActivity.this.eKF.a(fVar.aPM(), fVar.getUserData());
                        PbActivity.this.eKF.a(PbActivity.this.eKq.aSI(), PbActivity.this.eKq.aSz(), PbActivity.this.eKq.aTc());
                        if (fVar.aPO() != null) {
                            PbActivity.this.eKF.bD(fVar.aPO().sH());
                        }
                    }
                    if (PbActivity.this.enp != null) {
                        PbActivity.this.enp.ab(fVar.nC());
                    }
                    if (fVar == null || fVar.aQa() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eKs.jq(PbActivity.this.mIsFromCDN);
                    PbActivity.this.eKs.a(fVar, i2, i3, PbActivity.this.eKq.aSA(), i4, PbActivity.this.eKq.getIsFromMark());
                    PbActivity.this.eKs.d(fVar, PbActivity.this.eKq.aSA());
                    PbActivity.this.eKs.jo(PbActivity.this.eKq.getHostMode());
                    AntiData qf = fVar.qf();
                    if (qf != null) {
                        PbActivity.this.aDb = qf.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aDb) && PbActivity.this.eKF != null && PbActivity.this.eKF.CI() != null && (eN = PbActivity.this.eKF.CI().eN(6)) != null && !TextUtils.isEmpty(PbActivity.this.aDb)) {
                            ((View) eN).setOnClickListener(PbActivity.this.dVY);
                        }
                    }
                    if (PbActivity.this.eKB) {
                        PbActivity.this.eKB = false;
                        PbActivity.this.aRk().getListView().setSelection(PbActivity.this.aRu());
                    }
                    if (PbActivity.this.eKC) {
                        PbActivity.this.eKC = false;
                        int aRu = PbActivity.this.aRu();
                        if (aRu == -1) {
                            aRu = PbActivity.this.aRv();
                        }
                        if (PbActivity.this.aRk() != null) {
                            PbActivity.this.aRk().pO(aRu);
                        }
                    } else {
                        PbActivity.this.eKs.aUx();
                    }
                    PbActivity.this.eKq.a(fVar.aPM(), PbActivity.this.eLa);
                    PbActivity.this.eKq.a(PbActivity.this.eLb);
                } else if (str != null) {
                    if (!PbActivity.this.eKz && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eKq != null && PbActivity.this.eKq.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eKq.getAppealInfo().eGe)) {
                                    PbActivity.this.eKs.a(PbActivity.this.eKq.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eKs.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eKs.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.eKs.aUM();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.eKq.aSz());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                    }
                    if (i != -1) {
                        PbActivity.this.eKs.pz(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.eKs.pz("");
                    }
                    PbActivity.this.eKs.wu();
                }
                PbActivity.this.aJJ = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aQS().aSA() || PbActivity.this.aQS().getPbData().qv().qs() != 0 || PbActivity.this.aQS().aSV()) {
                    PbActivity.this.eKG = true;
                    return;
                }
                return;
            }
            PbActivity.this.eKq.pD(1);
            if (PbActivity.this.eJW != null) {
                PbActivity.this.eJW.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eKs.o(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.r.Gi().Gj()) {
                com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m(i, z, responsedMessage, PbActivity.this.aJB, PbActivity.this.createTime, PbActivity.this.aJJ, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.cko : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aJB = 0L;
                if (mVar != null) {
                    mVar.Gd();
                }
            }
        }
    };
    private CustomMessageListener eLo = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aRp() == 1) {
                    PbActivity.this.aRy();
                }
                PbActivity.this.aRq();
            }
        }
    };
    private final a.InterfaceC0042a eLp = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eKs.aUt();
            if (z) {
                if (PbActivity.this.enp != null) {
                    PbActivity.this.enp.ab(z2);
                }
                PbActivity.this.eKq.iV(z2);
                if (PbActivity.this.eKq.nC()) {
                    PbActivity.this.aRB();
                } else {
                    PbActivity.this.eKs.o(PbActivity.this.eKq.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.enp != null && PbActivity.this.enp.nF() != null && PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aPO() != null && PbActivity.this.eKq.getPbData().aPO().rt() != null) {
                        MarkData nF = PbActivity.this.enp.nF();
                        MetaData rt = PbActivity.this.eKq.getPbData().aPO().rt();
                        if (nF != null && rt != null) {
                            if (!com.baidu.tbadk.core.util.am.equals(TbadkCoreApplication.getCurrentAccount(), rt.getUserId()) && !rt.hadConcerned()) {
                                PbActivity.this.b(rt);
                                return;
                            } else {
                                PbActivity.this.showToast(d.j.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.j.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.j.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.j.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            boolean z = true;
            if (!PbActivity.this.pu(PbActivity.this.mLastScrollState) && PbActivity.this.pu(i)) {
                if (PbActivity.this.eKs != null) {
                    PbActivity.this.eKs.aEQ();
                    if (PbActivity.this.eKF != null && !PbActivity.this.eKs.aTX()) {
                        PbActivity.this.eKs.hb(PbActivity.this.eKF.Do());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.eKs.aTW();
                    }
                }
                if (!PbActivity.this.eKe) {
                    PbActivity.this.eKe = true;
                    PbActivity.this.eKs.aUK();
                }
            }
            PbActivity.this.eKs.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eJW != null) {
                PbActivity.this.eJW.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eKf == null) {
                PbActivity.this.eKf = new com.baidu.tbadk.l.d();
                PbActivity.this.eKf.ft(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aPO() != null && PbActivity.this.eKq.getPbData().aPO().sh()) {
                    z = false;
                }
                if (PbActivity.this.eKs.aUn() != null && z) {
                    PbActivity.this.eKs.aUn().notifyDataSetChanged();
                }
                PbActivity.this.eKf.FP();
            } else if (i == 1) {
                PbActivity.this.eKf.FP();
            } else {
                PbActivity.this.eKf.FP();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aPQ;
            if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKs != null && PbActivity.this.eKs.aUn() != null) {
                PbActivity.this.eKs.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eJW != null) {
                    PbActivity.this.eJW.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eKq.aSQ() && (aPQ = PbActivity.this.eKq.getPbData().aPQ()) != null && !aPQ.isEmpty()) {
                    int aSg = ((i + i2) - PbActivity.this.eKs.aUn().aSg()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKq.getPbData();
                    if (pbData != null) {
                        if (pbData.aPR() != null && pbData.aPR().hasData()) {
                            aSg--;
                        }
                        if (pbData.aPS() != null && pbData.aPS().hasData()) {
                            aSg--;
                        }
                        int size = aPQ.size();
                        if (aSg < 0 || aSg >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eLq = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.eKr.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eKq.aSO();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.daz && bVar.fad > 0 && bVar.gry != 0 && bVar.fad != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.fad == 1002 && !bVar.daz) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eKs.a(1, dVar.Al, dVar.grA, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eKr.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eKs.a(PbActivity.this.eKr.getLoadDataMode(), fVar.Al, fVar.grA, false);
                        PbActivity.this.eKs.aj(fVar.grC);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eKs.a(PbActivity.this.eKr.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d eLr = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
    };
    private final g.b bcl = new g.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aRH()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eKq.iU(true)) {
                PbActivity.this.eKs.aUu();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eLt = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eLs && PbActivity.this.aRH()) {
                PbActivity.this.aRJ();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eKq.iT(false)) {
                    PbActivity.this.eKs.aUs();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eKq.getPbData() != null) {
                    PbActivity.this.eKs.aUJ();
                }
                PbActivity.this.eLs = true;
            }
        }
    };
    private int eLu = 0;
    private final TbRichTextView.f aSv = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
        /* JADX DEBUG: Multi-variable search result rejected for r2v34, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
        public void a(View view, String str, int i) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.eKs.e((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(d.g.tag_rich_text_meme_info) != null && (view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    PbActivity.this.eKo = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.eMe) {
                    TbRichText as = PbActivity.this.as(str, i);
                    if (as != null && PbActivity.this.eLu >= 0 && PbActivity.this.eLu < as.II().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String c2 = com.baidu.tieba.pb.data.g.c(as.II().get(PbActivity.this.eLu));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.eMb.size()) {
                                break;
                            } else if (!cVar.eMb.get(i3).equals(c2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(c2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.v(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.eMc.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eMd, cVar.lastId, PbActivity.this.eKq.aSM(), concurrentHashMap, true, false, PbActivity.this.eKq.getHostMode());
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.eMb, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.v(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.eMc.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eMd, cVar.eMb.get(0), PbActivity.this.eKq.aSM(), concurrentHashMap2, true, false, PbActivity.this.eKq.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eLv = false;
    PostData eLw = null;
    private final b.InterfaceC0047b eLx = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eLw != null) {
                if (i == 0) {
                    PbActivity.this.eLw.bW(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eLw = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.eLw);
                }
            }
        }
    };
    private final b.InterfaceC0047b eLy = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eKO != null && !TextUtils.isEmpty(PbActivity.this.eKP)) {
                if (i == 0) {
                    if (PbActivity.this.eKQ == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eKP));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eKP;
                        aVar.pkgId = PbActivity.this.eKQ.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eKQ.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eKN == null) {
                        PbActivity.this.eKN = new at(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eKN.i(PbActivity.this.eKP, PbActivity.this.eKO.kN());
                }
                PbActivity.this.eKO = null;
                PbActivity.this.eKP = null;
            }
        }
    };
    private final View.OnLongClickListener auR = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eKO = ((TbImageView) view).getBdImage();
                PbActivity.this.eKP = ((TbImageView) view).getUrl();
                if (PbActivity.this.eKO != null && !TextUtils.isEmpty(PbActivity.this.eKP)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eKQ = null;
                    } else {
                        PbActivity.this.eKQ = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eKs.a(PbActivity.this.eLy, PbActivity.this.eKO.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.eKO = ((GifView) view).getBdImage();
                }
                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                    PbActivity.this.eKP = ((GifView) view).getBdImage().getUrl();
                }
                if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                    PbActivity.this.eKQ = null;
                } else {
                    PbActivity.this.eKQ = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                }
                PbActivity.this.eKs.a(PbActivity.this.eLy, PbActivity.this.eKO.isGif());
            } else if (view instanceof com.baidu.tbadk.widget.c) {
                if (((com.baidu.tbadk.widget.c) view).getBdImage() != null) {
                    PbActivity.this.eKO = ((com.baidu.tbadk.widget.c) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.c) view).getBdImage().getUrl())) {
                        PbActivity.this.eKP = ((com.baidu.tbadk.widget.c) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eKQ = null;
                    } else {
                        PbActivity.this.eKQ = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eKs.a(PbActivity.this.eLy, PbActivity.this.eKO.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eLw = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.eLw != null && PbActivity.this.enp != null) {
                        PbActivity.this.eKs.a(PbActivity.this.eLx, PbActivity.this.enp.nC() && PbActivity.this.eLw.getId() != null && PbActivity.this.eLw.getId().equals(PbActivity.this.eKq.rD()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a cvR = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (!PbActivity.this.eJY && z && !PbActivity.this.eKq.aSG()) {
                PbActivity.this.aEx();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag())) {
                    FrameLayout frameLayout2 = (FrameLayout) childAt;
                    if (frameLayout2.getChildCount() <= 0) {
                        break;
                    }
                    View childAt2 = frameLayout2.getChildAt(0);
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).asI()) {
                        break;
                    }
                }
            }
            PbActivity.this.bzz.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0081a bzA = new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        final int bIQ;

        {
            this.bIQ = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ag(int i, int i2) {
            if (J(i2) && PbActivity.this.eKs != null && PbActivity.this.eJW != null) {
                PbActivity.this.eKs.aUN();
                PbActivity.this.eJW.eF(false);
                PbActivity.this.eJW.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ah(int i, int i2) {
            if (J(i2) && PbActivity.this.eKs != null && PbActivity.this.eJW != null) {
                PbActivity.this.eJW.eF(true);
                if (Math.abs(i2) > this.bIQ) {
                    PbActivity.this.eJW.hideFloatingView();
                }
                if (PbActivity.this.aRH()) {
                    PbActivity.this.eKs.aUj();
                    PbActivity.this.eKs.aUk();
                }
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ai(int i, int i2) {
        }

        private boolean J(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eLz = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // com.baidu.tieba.e.b.a
        public void ea(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aQI();
            } else {
                com.baidu.tieba.pb.a.b.aQH();
            }
        }
    };
    private String eLA = null;
    private final o.a eLB = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eLA = str2;
                PbActivity.this.eKs.pA(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eLC = -1;
    private int eLD = -1;
    private CustomMessageListener eLG = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Ty == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0045a) {
                    if (aVar.Tz != null && !aVar.Tz.hasError() && aVar.Tz.getError() == 0) {
                        if (PbActivity.this.eKs != null) {
                            PbActivity.this.eKs.y(((a.C0045a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aRT();
                        }
                    } else if (z) {
                        if (aVar.Tz != null && aVar.Tz.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Tz.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Tz != null && !aVar.Tz.hasError() && aVar.Tz.getError() == 0) {
                        if (PbActivity.this.eKs != null && PbActivity.this.eKs != null) {
                            PbActivity.this.eKs.y(((a.C0045a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Tz != null && aVar.Tz.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Tz.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Tz == null || aVar.Tz.hasError() || aVar.Tz.getError() != 0) {
                        if (z) {
                            if (aVar.Tz != null && aVar.Tz.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Tz.getErrorString());
                            } else {
                                PbActivity.this.showToast(d.j.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.j.channel_need_push), 1).show();
                    }
                }
            }
        }
    };
    private final CustomMessageListener cyz = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ac("obj_locate", "pb"));
                    av.vI().c(PbActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes.dex */
    public interface b {
        void f(Object obj);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ArrayList<String> eMb;
        public ConcurrentHashMap<String, ImageUrlData> eMc;
        public boolean eMe;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eMd = false;
        public boolean eMf = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d aRf() {
        return this.eKF;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        if (mVar.aQy() != null) {
            String id = mVar.aQy().getId();
            ArrayList<PostData> aPQ = this.eKq.getPbData().aPQ();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aPQ.size()) {
                    break;
                }
                PostData postData = aPQ.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aQC = mVar.aQC();
                    postData.tQ(mVar.getTotalCount());
                    if (postData.bur() != null && aQC != null) {
                        Iterator<PostData> it = aQC.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.rt() != null && (metaData = postData.getUserMap().get(next.rt().getUserId())) != null) {
                                next.a(metaData);
                                next.mw(true);
                                next.b(getPageContext(), this.eKq.pw(metaData.getUserId()));
                            }
                        }
                        postData.bur().clear();
                        postData.bur().addAll(aQC);
                    }
                    if (postData.bun() != null) {
                        postData.buo();
                    }
                }
            }
            if (!this.eKq.getIsFromMark()) {
                this.eKs.o(this.eKq.getPbData());
            }
            c(mVar);
        }
    }

    public void aRg() {
        com.baidu.tieba.pb.data.f pbData;
        bh aPO;
        if (!this.eLd) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (this.eLg) {
                this.eLd = true;
                if (this.eKq != null && (pbData = this.eKq.getPbData()) != null && (aPO = pbData.aPO()) != null) {
                    int isLike = aPO.ri() == null ? 0 : aPO.ri().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ac("tid", aPO.getId()));
                    }
                    if (this.eLe != null) {
                        this.eLe.a(aPO.rK(), aPO.getId(), isLike, "pb");
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
                bVar.cf(d.j.operation);
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.j.delete);
                    strArr[1] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.eKs.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eKL);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eKL);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eKL);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eKL);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).tl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jQ(int i) {
        bh aPO;
        String str;
        String y;
        if (this.eKq != null && this.eKq.getPbData() != null && (aPO = this.eKq.getPbData().aPO()) != null) {
            if (i == 1) {
                PraiseData ri = aPO.ri();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (ri == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aPO.a(praiseData);
                    } else {
                        aPO.ri().getUser().add(0, metaData);
                        aPO.ri().setNum(aPO.ri().getNum() + 1);
                        aPO.ri().setIsLike(i);
                    }
                }
                if (aPO.ri() != null) {
                    if (aPO.ri().getNum() < 1) {
                        y = getResources().getString(d.j.zan);
                    } else {
                        y = com.baidu.tbadk.core.util.am.y(aPO.ri().getNum());
                    }
                    this.eKs.P(y, true);
                }
            } else if (aPO.ri() != null) {
                aPO.ri().setIsLike(i);
                aPO.ri().setNum(aPO.ri().getNum() - 1);
                ArrayList<MetaData> user = aPO.ri().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aPO.ri().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aPO.ri().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = aPO.ri().getNum() + "";
                }
                this.eKs.P(str, false);
            }
            if (this.eKq.aSA()) {
                this.eKs.aUn().notifyDataSetChanged();
            } else {
                this.eKs.p(this.eKq.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eKq != null && this.eKq.getPbData() != null && this.eKs != null) {
            this.eKs.d(this.eKq.getPbData(), this.eKq.aSA(), this.eKq.aSR());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eKq.t(bundle);
        if (this.cxA != null) {
            this.cxA.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eKF.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eKJ = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cko = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eKk = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eKk)) {
                this.eJX = true;
            }
            this.eLC = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eLD = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eLE = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eKB = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eKC = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aRH()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.eKS = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
        } else {
            this.cko = System.currentTimeMillis();
        }
        this.eKd = System.currentTimeMillis();
        this.aJB = this.eKd - this.cko;
        super.onCreate(bundle);
        this.eKa = 0;
        v(bundle);
        if (this.eKq != null && this.eKq.getPbData() != null) {
            this.eKq.getPbData().pn(this.source);
        }
        initUI();
        if (intent != null && this.eKs != null) {
            this.eKs.eRu = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eKM == null) {
                    this.eKM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eKs.pC("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eKM, 1500L);
            }
        }
        this.cxA = new VoiceManager();
        this.cxA.onCreate(getPageContext());
        initData(bundle);
        this.eKE = new com.baidu.tbadk.editortools.pb.e();
        aRh();
        this.eKF = (com.baidu.tbadk.editortools.pb.d) this.eKE.aW(getActivity());
        this.eKF.d(this);
        this.eKF.a(this.aDo);
        this.eKF.a(this.aDf);
        this.eKF.a(this, bundle);
        this.eKF.CI().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eKF.CI().bw(true);
        iG(true);
        this.eKs.setEditorTools(this.eKF.CI());
        this.eKF.a(this.eKq.aSI(), this.eKq.aSz(), this.eKq.aTc());
        registerListener(this.dVZ);
        if (!this.eKq.aSF()) {
            this.eKF.fT(this.eKq.aSz());
        }
        if (this.eKq.aTd()) {
            this.eKF.fR(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.eKF.fR(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eKd;
        registerListener(this.eKW);
        registerListener(this.dWv);
        registerListener(this.eKX);
        registerListener(this.cyw);
        registerListener(this.eLl);
        registerListener(this.eKV);
        this.eKD = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.goK);
        this.eKD.btW();
        registerListener(this.eKZ);
        registerListener(this.mAttentionListener);
        if (this.eKq != null) {
            this.eKq.aST();
        }
        registerListener(this.eLo);
        registerListener(this.eLG);
        registerListener(this.cyG);
        if (this.eKs != null && this.eKs.aUR() != null && this.eKs.aUS() != null) {
            this.eJW = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eKs.aUR(), this.eKs.aUS(), this.eKs.aUe());
            this.eJW.a(this.eLh);
        }
        if (this.eJV && this.eKs != null && this.eKs.aUS() != null) {
            this.eKs.aUS().setVisibility(8);
        }
        this.eKK = new com.baidu.tbadk.core.view.c();
        this.eKK.akR = 1000L;
        registerListener(this.eLk);
        registerListener(this.eLi);
        registerListener(this.eLj);
        this.eKL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eKL;
        userMuteAddAndDelCustomMessage.setTag(this.eKL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eKL;
        userMuteCheckCustomMessage.setTag(this.eKL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eKq.aTa().a(this.bza);
        if ("from_tieba_kuang".equals(this.eKk)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 2).ac("tid", this.eKq.aSz()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        this.eKx = new ar();
        if (this.eKF.Di() != null) {
            this.eKx.f(this.eKF.Di().Da());
        }
        this.eKF.a(this.aDg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRh() {
        if (this.eKE != null && this.eKq != null) {
            this.eKE.setForumName(this.eKq.aSy());
            if (this.eKq.getPbData() != null && this.eKq.getPbData().aPM() != null) {
                this.eKE.setForumId(this.eKq.getPbData().aPM().getId());
            }
            this.eKE.setFrom("pb");
            this.eKE.a(this.eKq);
        }
    }

    public String aRi() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aRj() {
        return this.eJW;
    }

    private void iG(boolean z) {
        this.eKF.bA(z);
        this.eKF.bB(z);
        this.eKF.bC(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cxA != null) {
            this.cxA.onStart(getPageContext());
        }
    }

    public ap aRk() {
        return this.eKs;
    }

    public PbModel aQS() {
        return this.eKq;
    }

    public void pp(String str) {
        if (this.eKq != null && !StringUtils.isNull(str) && this.eKs != null) {
            this.eKs.jt(true);
            this.eKq.pp(str);
            this.eKj = true;
            this.eKs.aEQ();
            this.eKs.aUM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eJY = false;
        } else {
            this.eJY = true;
        }
        super.onPause();
        if (this.eKs.aTR() != null && this.eKs.aTR().aRc() != null) {
            this.eKs.aTR().aRc().onPause();
        }
        BdListView listView = getListView();
        this.eKa = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eKa == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cxA != null) {
            this.cxA.onPause(getPageContext());
        }
        if (this.eKs != null) {
            this.eKs.onPause();
        }
        if (!this.eKq.aSF()) {
            this.eKF.fS(this.eKq.aSz());
        }
        if (this.eKq != null) {
            this.eKq.aSU();
        }
        MessageManager.getInstance().unRegisterListener(this.dvG);
        ate();
        MessageManager.getInstance().unRegisterListener(this.eLi);
        MessageManager.getInstance().unRegisterListener(this.eLj);
        MessageManager.getInstance().unRegisterListener(this.eLk);
        MessageManager.getInstance().unRegisterListener(this.cyz);
        MessageManager.getInstance().unRegisterListener(this.dgy);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aRl() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eKq.getPbData(), this.eKq.aSA(), this.eKq.aSR());
        return (a2 == null || a2.rt() == null || a2.rt().getGodUserData() == null || a2.rt().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eJY = false;
        super.onResume();
        if (this.eKm) {
            this.eKm = false;
            aRN();
        }
        if (this.eKs.aTR() != null && this.eKs.aTR().aRc() != null) {
            this.eKs.aTR().aRc().onResume();
        }
        if (aRl()) {
            this.eKg = System.currentTimeMillis();
        } else {
            this.eKg = -1L;
        }
        if (this.eKs != null && this.eKs.getView() != null) {
            if (!this.eqa) {
                aRE();
            } else {
                hideLoadingView(this.eKs.getView());
            }
            this.eKs.onResume();
        }
        if (this.eKa == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eKs != null) {
            noNetworkView = this.eKs.aTS();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.hh()) {
            noNetworkView.aI(false);
        }
        if (this.cxA != null) {
            this.cxA.onResume(getPageContext());
        }
        registerListener(this.dvG);
        this.eKA = false;
        aRM();
        registerListener(this.eLi);
        registerListener(this.eLj);
        registerListener(this.eLk);
        registerListener(this.cyz);
        registerListener(this.dgy);
        if (this.cyg) {
            aEx();
            this.cyg = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eKs.jj(z);
        if (this.eKy != null) {
            this.eKy.iX(z);
        }
        if (z && this.eKA) {
            this.eKs.aUs();
            this.eKq.iT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eKg > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ac("obj_duration", (System.currentTimeMillis() - this.eKg) + ""));
            this.eKg = 0L;
        }
        if (aRk().aTV() != null) {
            aRk().aTV().onStop();
        }
        if (this.eKs.eRA != null && !this.eKs.eRA.aaE()) {
            this.eKs.eRA.aFj();
        }
        if (this.eKq != null && this.eKq.getPbData() != null && this.eKq.getPbData().aPM() != null && this.eKq.getPbData().aPO() != null) {
            com.baidu.tbadk.distribute.a.Cs().a(getPageContext().getPageActivity(), "pb", this.eKq.getPbData().aPM().getId(), com.baidu.adp.lib.g.b.c(this.eKq.getPbData().aPO().getId(), 0L));
        }
        if (this.cxA != null) {
            this.cxA.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.eKe && this.eKs != null) {
            this.eKe = true;
            this.eKs.aUK();
            a(false, (PostData) null);
        }
        if (this.eKq != null) {
            this.eKq.cancelLoadData();
            this.eKq.destory();
            if (this.eKq.aSZ() != null) {
                this.eKq.aSZ().onDestroy();
            }
        }
        if (this.eKF != null) {
            this.eKF.onDestroy();
        }
        if (this.eKr != null) {
            this.eKr.cancelLoadData();
        }
        if (this.eKs != null) {
            this.eKs.onDestroy();
            if (this.eKs.eRA != null) {
                this.eKs.eRA.aFj();
            }
        }
        if (this.eKf != null) {
            this.eKf.onDestroy();
        }
        if (this.eJW != null) {
            this.eJW.GX();
        }
        super.onDestroy();
        if (this.cxA != null) {
            this.cxA.onDestory(getPageContext());
        }
        this.eKs.aEQ();
        MessageManager.getInstance().unRegisterListener(this.eLi);
        MessageManager.getInstance().unRegisterListener(this.eLj);
        MessageManager.getInstance().unRegisterListener(this.eLk);
        MessageManager.getInstance().unRegisterListener(this.eKL);
        MessageManager.getInstance().unRegisterListener(this.eLl);
        MessageManager.getInstance().unRegisterListener(this.cyG);
        this.eKJ = null;
        this.eKK = null;
        com.baidu.tieba.recapp.e.a.bjF().bjH();
        if (this.eKM != null) {
            getSafeHandler().removeCallbacks(this.eKM);
        }
        if (this.eKn != null) {
            this.eKn.cancelLoadData();
        }
        if (this.eKs != null && this.eKs.eRA != null) {
            this.eKs.eRA.aWa();
        }
        this.eKx.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        h aUn;
        ArrayList<PostData> aSh;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xx() && this.eKs != null && (aUn = this.eKs.aUn()) != null && (aSh = aUn.aSh()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aSh.iterator();
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
                        bVar.aMj = id;
                        bVar.bUC = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Zh == 1 && !TextUtils.isEmpty(id)) {
                    next.Zh = 2;
                    a.b bVar2 = new a.b();
                    bVar2.aMj = id;
                    bVar2.bUC = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eKq == null || this.eKq.getPbData() == null || this.eKq.getPbData().aPM() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eKq.getPbData().aPM().getFirst_class();
                    str2 = this.eKq.getPbData().aPM().getSecond_class();
                    str = this.eKq.getPbData().aPM().getId();
                    str4 = this.eKq.aSz();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eKs.onChangeSkinType(i);
        if (this.eKF != null && this.eKF.CI() != null) {
            this.eKF.CI().onChangeSkinType(i);
        }
        if (this.eKs.aTS() != null) {
            this.eKs.aTS().onChangeSkinType(getPageContext(), i);
        }
        this.eKx.onChangeSkinType();
    }

    private void initUI() {
        this.eKs = new ap(this, this.czc, this.aSw);
        this.bzz = new com.baidu.tieba.e.b(getActivity());
        this.bzz.a(this.eLz);
        this.bzz.a(this.bzA);
        this.eKs.setOnScrollListener(this.mOnScrollListener);
        this.eKs.d(this.eLt);
        this.eKs.a(this.bcl);
        this.eKs.iy(com.baidu.tbadk.core.h.oT().oZ());
        this.eKs.setOnImageClickListener(this.aSv);
        this.eKs.a(this.auR);
        this.eKs.h(this.cvR);
        this.eKs.a(this.eLr);
        this.eKs.jj(this.mIsLogin);
        if (getIntent() != null) {
            this.eKs.setIsInterviewLive(getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_INTERVIEW_LIVE, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bh(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gpm == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oT().oZ()) {
                    return false;
                }
                return ps(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eKs != null) {
            if (z && (!this.eqa || this.eKI)) {
                aRE();
            } else {
                hideLoadingView(this.eKs.getView());
            }
            this.eKI = false;
        }
    }

    private void aRm() {
        if (this.eKb == null) {
            this.eKb = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eKb.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eJD = PbActivity.this.eJD.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eJD);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eKq.aSz(), PbActivity.this.eJD, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eJD = PbActivity.this.eJD.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eJD);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eKq.aSz(), PbActivity.this.eJD, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eJD = PbActivity.this.eJD.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eJD);
                        bVar.dismiss();
                    }
                }
            }).cg(b.a.abA).ch(17).d(getPageContext());
        }
    }

    private void v(Bundle bundle) {
        this.eKq = new PbModel(this);
        this.eKq.a(this.eLn);
        if (this.eKq.aSX() != null) {
            this.eKq.aSX().a(this.eLB);
        }
        if (this.eKq.aSW() != null) {
            this.eKq.aSW().a(this.eKY);
        }
        if (this.eKq.aSZ() != null) {
            this.eKq.aSZ().b(this.eKU);
        }
        if (bundle != null) {
            this.eKq.initWithBundle(bundle);
        } else {
            this.eKq.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eKq.iW(true);
        }
        ag.aTG().O(this.eKq.aSx(), this.eKq.getIsFromMark());
        if (StringUtils.isNull(this.eKq.aSz())) {
            finish();
        } else {
            this.eKq.Ff();
        }
    }

    private void initData(Bundle bundle) {
        this.enp = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.enp != null) {
            this.enp.a(this.eLp);
        }
        this.eKr = new ForumManageModel(this);
        this.eKr.setLoadDataCallBack(this.eLq);
        this.aoZ = new com.baidu.tbadk.coreExtra.c.a(null);
        this.eKs.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eKq.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eKq.getPbData().aPM().getId(), PbActivity.this.eKq.getPbData().aPM().getName(), PbActivity.this.eKq.getPbData().aPO().getId(), valueOf, str, str2)));
            }
        });
        this.eLe.setUniqueId(getUniqueId());
        this.eLe.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eKs.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eKL;
        userMuteCheckCustomMessage.setTag(this.eKL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aRn() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.eKq != null && (pbData = this.eKq.getPbData()) != null) {
            return pbData.aPY().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPO() != null) {
            if (fVar.aPO().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aPO().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aPO().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData bi(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.buH()) {
                postData.cN(postData.buG() - 1);
            } else {
                postData.cN(postData.buG() + 1);
            }
            postData.mx(!postData.buH());
            ((PbFloorAgreeView) view).a(postData.buH(), postData.buG(), true);
            final int i = postData.buH() ? 0 : 1;
            this.eKq.aSY().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pz(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).pZ(i2);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void a(CustomDialogData customDialogData) {
                    customDialogData.type = 0;
                    com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), customDialogData);
                }
            });
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.ak aRo() {
        return new com.baidu.tbadk.core.util.ak("c12003").ac("tid", this.eKq.eNT).r("obj_type", 0).ac(ImageViewerConfig.FORUM_ID, this.eKq.getForumId()).r("obj_param1", this.eKq.getPbData().aPO().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
                @Override // java.lang.Runnable
                public void run() {
                    int f;
                    int ae = (com.baidu.adp.lib.util.l.ae(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        f = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.f(PbActivity.this.getPageContext().getPageActivity(), d.e.ds120);
                    } else {
                        f = com.baidu.adp.lib.util.l.f(PbActivity.this.getPageContext().getPageActivity(), d.e.ds640);
                    }
                    int i = f - ae;
                    if (i > 0) {
                        PbActivity.this.aRk().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aRk().aTV() != null) {
                        PbActivity.this.eKF.CI().setVisibility(8);
                        PbActivity.this.aRk().aTV().bB(str, str2);
                        if (PbActivity.this.eKx.aVg() == null && PbActivity.this.aRk().aTV().aSu().Di() != null) {
                            PbActivity.this.aRk().aTV().aSu().Di().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.eKx != null && PbActivity.this.eKx.aVf() != null) {
                                        if (!PbActivity.this.eKx.aVf().bCg()) {
                                            PbActivity.this.eKx.jv(false);
                                        }
                                        PbActivity.this.eKx.aVf().nj(false);
                                    }
                                }
                            });
                            PbActivity.this.eKx.g(PbActivity.this.aRk().aTV().aSu().Di().Da());
                            PbActivity.this.aRk().aTV().aSu().a(PbActivity.this.eKH);
                        }
                    }
                    PbActivity.this.aRk().aUM();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.eKq != null && this.eKq.getPbData() != null && postData.buu() > 1) {
            String aSz = this.eKq.aSz();
            String id = postData.getId();
            int i = 0;
            if (this.eKq.getPbData() != null) {
                i = this.eKq.getPbData().aPZ();
            }
            c pt = pt(id);
            if (pt != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(aSz, id, "pb", true, null, false, null, i, postData.aWP(), this.eKq.getPbData().qf(), false, postData.rt() != null ? postData.rt().getIconInfo() : null).addBigImageData(pt.eMb, pt.eMc, pt.eMd, pt.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        am amVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (aQS() != null && aQS().getPbData() != null && aQS().getPbData().aQk() != null) {
                com.baidu.tieba.pb.data.l aQk = aQS().getPbData().aQk();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof am)) {
                    amVar = null;
                } else {
                    amVar = (am) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aQk != null) {
                    int i2 = -1;
                    if (z) {
                        aQk.pq(i);
                    } else if (aQk.aQt()) {
                        aQk.aQv();
                        i2 = 1;
                    } else {
                        aQk.pr(i);
                        i2 = 0;
                    }
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pz(int i3) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void a(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), customDialogData);
                        }
                    };
                    if (this.eKq != null && this.eKq.aSY() != null) {
                        String str = "";
                        if (this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null) {
                            str = this.eKq.getPbData().aPO().rK();
                        }
                        if (this.eKq.getPbData() != null) {
                            this.eKq.getPbData().a(aQk);
                        }
                        if (z) {
                            this.eKq.aSY().a(str, 3, i, this.eKq.getForumId(), aVar);
                        } else {
                            this.eKq.aSY().a(str, i2, 3, i, this.eKq.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.eGT = i2;
                            kVar.eGU = aQk;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (amVar != null) {
                        amVar.b(aQk);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aRp() {
        if (this.eKq.getPbData() == null || this.eKq.getPbData().aPO() == null) {
            return -1;
        }
        return this.eKq.getPbData().aPO().rY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRq() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.pT(this.eKq.getForumId()) && this.eKq.getPbData() != null && this.eKq.getPbData().aPM() != null) {
            if (this.eKq.getPbData().aPM().isLike() == 1) {
                aRF();
                this.eKq.aTb().bE(this.eKq.getForumId(), this.eKq.aSz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iH(boolean z) {
        if (this.eKq == null || this.eKq.getPbData() == null) {
            return false;
        }
        return ((this.eKq.getPbData().aPZ() != 0) || this.eKq.getPbData().aPO() == null || this.eKq.getPbData().aPO().rt() == null || TextUtils.equals(this.eKq.getPbData().aPO().rt().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aRr() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.p.q.GC()) {
            return "";
        }
        PostData aPV = aPV();
        if (this.eKq == null || (pbData = this.eKq.getPbData()) == null || pbData.getUserData() == null || pbData.aPO() == null || aPV == null || aPV.rt() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aPV.rt().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aPO().rb() == 0) {
            return "";
        }
        if (pbData.aPO().rb() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean iI(boolean z) {
        if (z) {
            return true;
        }
        if (this.eKq == null || this.eKq.getPbData() == null) {
            return false;
        }
        return this.eKq.getPbData().aPZ() != 0;
    }

    private boolean iJ(boolean z) {
        return (z || this.eKq == null || this.eKq.getPbData() == null || this.eKq.getPbData().aPZ() == 0) ? false : true;
    }

    public void aRs() {
        if (this.eKq != null && this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null && this.eKq.getPbData().aPO().rt() != null) {
            if (this.eKs != null) {
                this.eKs.aTT();
            }
            bh aPO = this.eKq.getPbData().aPO();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aPO.rt().getUserId());
            aPO.rt().getGodUserData();
            z zVar = new z();
            int aPZ = this.eKq.getPbData().aPZ();
            if (aPZ == 1) {
                zVar.ePP = true;
                zVar.ePO = true;
                zVar.ePW = aPO.ro() == 1;
                zVar.ePV = aPO.rp() == 1;
            } else {
                zVar.ePP = false;
                zVar.ePO = false;
            }
            if (aPZ == 1002 && !equals) {
                zVar.eQa = true;
            }
            zVar.ePL = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            zVar.ePQ = iI(equals);
            zVar.ePR = aRt();
            zVar.ePS = iJ(equals);
            zVar.ePM = this.eKq.aSA();
            zVar.ePN = true;
            zVar.eHh = this.enp != null && this.enp.nC();
            zVar.ePK = iH(equals);
            zVar.ePY = aRr();
            zVar.ePJ = equals && this.eKs.aUA();
            zVar.ePT = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.ePU = true;
            zVar.isHostOnly = this.eKq.getHostMode();
            zVar.ePX = true;
            if (aPO.rL() == null) {
                zVar.ePZ = true;
            } else {
                zVar.ePZ = false;
            }
            this.eKs.eRA.a(zVar);
        }
    }

    private boolean aRt() {
        if (this.eKq != null && this.eKq.aSA()) {
            return this.eKq.atJ() == null || this.eKq.atJ().qs() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null) {
            f(postData);
        }
    }

    public int aRu() {
        if (aRk() == null || aRk().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aRk().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) fVar).mType == com.baidu.tieba.pb.data.j.eGP) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aRv() {
        if (aRk() == null || aRk().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aRk().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.gpk) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aEx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cR(getResources().getString(d.j.mark_done));
            aVar.au(true);
            aVar.cS(getResources().getString(d.j.mark_like));
            aVar.at(true);
            aVar.ao(false);
            aVar.b(getResources().getString(d.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ac("obj_id", metaData.getUserId()).r("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ac("obj_id", metaData.getUserId()).r("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.aoZ.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.eKq.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).th();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.eKs.aUt();
        this.eKq.iV(z);
        if (this.enp != null) {
            this.enp.ab(z);
            if (markData != null) {
                this.enp.a(markData);
            }
        }
        if (this.eKq.nC()) {
            aRB();
        } else {
            this.eKs.o(this.eKq.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pu(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq(String str) {
        if (!StringUtils.isNull(str) && this.eKq != null) {
            String aSz = this.eKq.aSz();
            String id = this.eKq.getPbData().aPM().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + aSz + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eKq.aSF()) {
                    antiData.setBlock_forum_name(this.eKq.getPbData().aPM().getName());
                    antiData.setBlock_forum_id(this.eKq.getPbData().aPM().getId());
                    antiData.setUser_name(this.eKq.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eKq.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.tW(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.aht));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.aht));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.aht));
            }
        } else if (i == 230277) {
            fZ(str);
        } else {
            this.eKs.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eKs.a(0, bVar.Al, bVar.grA, z);
            if (bVar.Al) {
                if (bVar.gry == 1) {
                    ArrayList<PostData> aPQ = this.eKq.getPbData().aPQ();
                    int size = aPQ.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aPQ.get(i).getId())) {
                            i++;
                        } else {
                            aPQ.remove(i);
                            break;
                        }
                    }
                    this.eKs.o(this.eKq.getPbData());
                } else if (bVar.gry == 0) {
                    aRw();
                } else if (bVar.gry == 2) {
                    ArrayList<PostData> aPQ2 = this.eKq.getPbData().aPQ();
                    int size2 = aPQ2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aPQ2.get(i2).bur().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aPQ2.get(i2).bur().get(i3).getId())) {
                                i3++;
                            } else {
                                aPQ2.get(i2).bur().remove(i3);
                                aPQ2.get(i2).but();
                                z2 = true;
                                break;
                            }
                        }
                        aPQ2.get(i2).sw(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eKs.o(this.eKq.getPbData());
                    }
                    a(bVar, this.eKs);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eKs.a(this.eKr.getLoadDataMode(), fVar.Al, fVar.grA, false);
            if (fVar.Al) {
                this.eKu = true;
                if (i == 2 || i == 3) {
                    this.eKv = true;
                    this.eKw = false;
                } else if (i == 4 || i == 5) {
                    this.eKv = false;
                    this.eKw = true;
                }
                if (i == 2) {
                    this.eKq.getPbData().aPO().bT(1);
                    this.eKq.setIsGood(1);
                } else if (i == 3) {
                    this.eKq.getPbData().aPO().bT(0);
                    this.eKq.setIsGood(0);
                } else if (i == 4) {
                    this.eKq.getPbData().aPO().bS(1);
                    this.eKq.it(1);
                } else if (i == 5) {
                    this.eKq.getPbData().aPO().bS(0);
                    this.eKq.it(0);
                }
                this.eKs.c(this.eKq.getPbData(), this.eKq.aSA());
                if (this.eKq.getPbData().aPZ() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void aRw() {
        if (this.eKq.aSB() || this.eKq.aSD()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eKq.aSz());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eKq.aSz()));
        if (aRC()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRx() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aPW;
        boolean z = true;
        if (this.eKs != null) {
            this.eKs.aEQ();
        }
        if (this.eKq != null && this.eKq.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eKq.getPbData().aPO().getId();
            historyMessage.forumName = this.eKq.getPbData().aPM().getName();
            historyMessage.threadName = this.eKq.getPbData().aPO().getTitle();
            ArrayList<PostData> aPQ = this.eKq.getPbData().aPQ();
            int aUv = this.eKs != null ? this.eKs.aUv() : 0;
            if (aPQ != null && aUv >= 0 && aUv < aPQ.size()) {
                historyMessage.postID = aPQ.get(aUv).getId();
            }
            historyMessage.isHostOnly = this.eKq.getHostMode();
            historyMessage.isSquence = this.eKq.aSA();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eKF != null) {
            this.eKF.onDestroy();
        }
        if (this.eJZ && aRk() != null) {
            aRk().aUZ();
        }
        if (this.eKq != null && (this.eKq.aSB() || this.eKq.aSD())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eKq.aSz());
            if (this.eKu) {
                if (this.eKw) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eKq.aEH());
                }
                if (this.eKv) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eKq.getIsGood());
                }
            }
            if (this.eKq.getPbData() != null && System.currentTimeMillis() - this.eKd >= 40000 && (aPW = this.eKq.getPbData().aPW()) != null && !com.baidu.tbadk.core.util.v.v(aPW.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aPW);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eKS);
            }
            setResult(-1, intent);
        }
        if (aRC()) {
            if (this.eKq != null && this.eKs != null && this.eKs.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eKq.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aPU() && !this.eKj) {
                        ag aTG = ag.aTG();
                        com.baidu.tieba.pb.data.f pbData2 = this.eKq.getPbData();
                        Parcelable onSaveInstanceState = this.eKs.getListView().onSaveInstanceState();
                        boolean aSA = this.eKq.aSA();
                        boolean hostMode = this.eKq.getHostMode();
                        if (this.eKs.aUe() == null || this.eKs.aUe().getVisibility() != 0) {
                            z = false;
                        }
                        aTG.a(pbData2, onSaveInstanceState, aSA, hostMode, z);
                        if (this.eKR >= 0 || this.eKq.aTh() != null) {
                            ag.aTG().j(this.eKq.aTh());
                            ag.aTG().i(this.eKq.aTi());
                            ag.aTG().pM(this.eKq.aTj());
                        }
                    }
                }
            } else {
                ag.aTG().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eKs == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eKs.pP(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pw(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.eKF.onActivityResult(i, i2, intent);
        if (this.eKn != null) {
            this.eKn.onActivityResult(i, i2, intent);
        }
        if (aRk().aTV() != null) {
            aRk().aTV().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aRA();
                    return;
                case 13008:
                    ag.aTG().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eKq != null) {
                                PbActivity.this.eKq.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eKq != null) {
                        a(aRz(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    K(intent);
                    return;
                case 24006:
                    R(intent);
                    return;
                case 24007:
                    if (aRp() == 1) {
                        aRy();
                    }
                    intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aRq();
                        return;
                    }
                    return;
                case 24008:
                    this.eKs.iF(false);
                    if (this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null && this.eKq.getPbData().aPO().rO() != null) {
                        this.eKq.getPbData().aPO().rO().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        c(emotionImageData);
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.eKs != null && this.eKs.eRA != null) {
                        this.eKs.eRA.om();
                        this.eKs.eRA.aVV();
                        if (this.eKq != null && this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null) {
                            this.eKq.getPbData().aPO().bO(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.eKo != null) {
                        this.eKs.bo(this.eKo);
                        return;
                    }
                    return;
                default:
                    return;
            }
            intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
            intent.getStringExtra("KEY_FORUM_NAME");
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aRk() != null && aRf() != null && aRk().aTX() && com.baidu.tbadk.editortools.pb.a.Dd().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Dd().setStatus(0);
                    if (this.eKs != null) {
                        this.eKs.aTW();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.eKn == null) {
                this.eKn = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eKn.b(this.aDf);
                this.eKn.c(this.aDo);
            }
            this.eKn.a(emotionImageData, aQS(), aQS().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRy() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null && this.eKq.getPbData().aPO().rF() != null && this.eKq.getPbData().aPO().rF().size() > 0 && this.eKq.getPbData().aPO().rF().get(0) != null) {
            this.mAwardActId = this.eKq.getPbData().aPO().rF().get(0).pn();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eKq.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void R(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    py(2);
                    return;
                case 2:
                    this.eKs.aUl();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aRz() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bK = this.eKq.getPbData().bK(getPageContext().getPageActivity());
        PostData aTY = this.eKs.aTY();
        String str = "";
        if (aTY != null) {
            str = aTY.getId();
            String bX = aTY.bX(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(bX)) {
                bK[1] = bX;
            }
        }
        String rK = this.eKq.getPbData().aPO().rK();
        if (rK != null && rK.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bK[1]);
        shareFromPBMsgData.setImageUrl(bK[0]);
        shareFromPBMsgData.setForumName(this.eKq.getPbData().aPM().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eKq.getPbData().aPO().getId());
        shareFromPBMsgData.setTitle(this.eKq.getPbData().aPO().getTitle());
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(aRz(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eKq != null && this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(getPageContext().getPageActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ac = new com.baidu.tbadk.core.util.ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getForumId()).ac("tid", PbActivity.this.eKq.aSz());
                        if (PbActivity.this.e(PbActivity.this.eKq.getPbData()) != 0) {
                            ac.r("obj_type", PbActivity.this.e(PbActivity.this.eKq.getPbData()));
                        }
                        TiebaStatic.log(ac);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aRp() == 1) {
                        PbActivity.this.aRy();
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(getPageContext()).th();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.G(shareFromPBMsgData.getImageUrl(), this.eKq.getPbData().aQa() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eKq != null && this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(getPageContext().getPageActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aRp() == 1) {
                        PbActivity.this.aRy();
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(getPageContext()).th();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.G(shareFromPBMsgData.getImageUrl(), this.eKq.getPbData().aQa() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRA() {
        MarkData pK;
        if (this.enp != null && (pK = this.eKq.pK(this.eKs.aUw())) != null) {
            if (!pK.isApp() || (pK = this.eKq.pK(this.eKs.aUw() + 1)) != null) {
                this.eKs.aUr();
                this.enp.a(pK);
                if (!this.enp.nC()) {
                    this.enp.nE();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.enp.nD();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRB() {
        com.baidu.tieba.pb.data.f pbData = this.eKq.getPbData();
        this.eKq.iV(true);
        if (this.enp != null) {
            pbData.pm(this.enp.nB());
        }
        this.eKs.o(pbData);
    }

    private boolean aRC() {
        if (this.eKq == null) {
            return true;
        }
        if (this.eKq.nC()) {
            final MarkData aSN = this.eKq.aSN();
            if (aSN == null || !this.eKq.getIsFromMark()) {
                return true;
            }
            final MarkData pK = this.eKq.pK(this.eKs.aUv());
            if (pK == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aSN);
                setResult(-1, intent);
                return true;
            } else if (pK.getPostId() == null || pK.getPostId().equals(aSN.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aSN);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cS(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.enp != null) {
                            if (PbActivity.this.enp.nC()) {
                                PbActivity.this.enp.nD();
                                PbActivity.this.enp.ab(false);
                            }
                            PbActivity.this.enp.a(pK);
                            PbActivity.this.enp.ab(true);
                            PbActivity.this.enp.nE();
                        }
                        aSN.setPostId(pK.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aSN);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aRx();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aSN);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aRx();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eKs != null && PbActivity.this.eKs.getView() != null) {
                            PbActivity.this.eKs.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aSN);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aRx();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.th();
                return false;
            }
        } else if (this.eKq.getPbData() == null || this.eKq.getPbData().aPQ() == null || this.eKq.getPbData().aPQ().size() <= 0 || !this.eKq.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eKs == null) {
            return null;
        }
        return this.eKs.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Jn() {
        if (this.eKs == null) {
            return 0;
        }
        return this.eKs.aUE();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Jo() {
        if (this.aSm == null) {
            this.aSm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: WS */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean oZ = com.baidu.tbadk.core.h.oT().oZ();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.C0080d.common_color_10220));
                    if (oZ) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0080d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView o(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.h.oT().oZ()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0080d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aSm;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Jp() {
        if (this.aSn == null) {
            this.aSn = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aSn;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Jq() {
        if (this.aSr == null) {
            this.aSr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRX */
                public GifView fI() {
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
                    return gifView;
                }
            }, 20, 0);
        }
        return this.aSr;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Jr() {
        if (this.aSo == null) {
            this.aSo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aEy */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQ */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aR */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aS */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aSo;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Jt() {
        this.aSq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aRY */
            public RelativeLayout fI() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public void n(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout o(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public RelativeLayout p(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.aSq;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aoy == null) {
            this.aoy = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoy;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eKh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        if (au.pD(str) && this.eKq != null && this.eKq.aSz() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").r("obj_param1", 1).ac("post_id", this.eKq.aSz()));
        }
        au.aVh().f(getPageContext(), str);
        this.eKh = true;
    }

    private com.baidu.tbadk.core.dialog.a aRD() {
        if (this.eKc == null) {
            this.eKc = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eKc.cR(getPageContext().getString(d.j.download_baidu_video_dialog));
            this.eKc.a(getPageContext().getString(d.j.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.dG()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.uh());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.j.download_baidu_video));
                    }
                }
            });
            this.eKc.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eKc.ao(true);
            this.eKc.b(getPageContext());
            this.eKc.ap(false);
        }
        this.eKc.th();
        return this.eKc;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        au.aVh().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eKh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra(VrPlayerActivityConfig.TITLE, "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aRD();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eKh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eKq.getPbData();
            TbRichText as = as(str, i);
            if (as != null && (tbRichTextData = as.II().get(this.eLu)) != null) {
                cVar.eMb = new ArrayList<>();
                cVar.eMc = new ConcurrentHashMap<>();
                if (!tbRichTextData.IO().Ja()) {
                    cVar.eMe = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    cVar.eMb.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = as.getPostId();
                    imageUrlData.mIsReserver = this.eKq.aSM();
                    imageUrlData.mIsSeeHost = this.eKq.getHostMode();
                    cVar.eMc.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aPM() != null) {
                            cVar.forumName = pbData.aPM().getName();
                            cVar.forumId = pbData.aPM().getId();
                        }
                        if (pbData.aPO() != null) {
                            cVar.threadId = pbData.aPO().getId();
                        }
                        cVar.eMd = pbData.aQa() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.eMe = true;
                int size = pbData.aPQ().size();
                this.eLv = false;
                cVar.index = -1;
                if (pbData.aPV() != null) {
                    PostData aPV = pbData.aPV();
                    TbRichText aEt = aPV.aEt();
                    if (!ao.k(aPV)) {
                        i2 = a(aEt, as, i, i, cVar.eMb, cVar.eMc);
                    } else {
                        i2 = a(aPV, i, cVar.eMb, cVar.eMc);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aPQ().get(i4);
                    if (postData.getId() == null || pbData.aPV() == null || pbData.aPV().getId() == null || !postData.getId().equals(pbData.aPV().getId())) {
                        TbRichText aEt2 = postData.aEt();
                        if (!ao.k(postData)) {
                            i3 = a(aEt2, as, i3, i, cVar.eMb, cVar.eMc);
                        } else {
                            i3 = a(postData, i3, cVar.eMb, cVar.eMc);
                        }
                    }
                }
                if (cVar.eMb.size() > 0) {
                    cVar.lastId = cVar.eMb.get(cVar.eMb.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aPM() != null) {
                        cVar.forumName = pbData.aPM().getName();
                        cVar.forumId = pbData.aPM().getId();
                    }
                    if (pbData.aPO() != null) {
                        cVar.threadId = pbData.aPO().getId();
                    }
                    cVar.eMd = pbData.aQa() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IO() == null) {
            return null;
        }
        return tbRichTextData.IO().Je();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IO() == null) {
            return 0L;
        }
        return tbRichTextData.IO().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IO() == null) {
            return false;
        }
        return tbRichTextData.IO().Jf();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IO() == null) {
            return false;
        }
        return tbRichTextData.IO().Jg();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo IO;
        if (tbRichText == tbRichText2) {
            this.eLv = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.II().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.II().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int af = (int) com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.IO().getWidth() * af;
                    int height = af * tbRichTextData.IO().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.IO().Ja()) {
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
                            if (tbRichTextData != null && (IO = tbRichTextData.IO()) != null) {
                                String Jc = IO.Jc();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = Jc;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eKq.aSz(), -1L);
                                imageUrlData.mIsReserver = this.eKq.aSM();
                                imageUrlData.mIsSeeHost = this.eKq.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eLv) {
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
        com.baidu.tieba.tbadkCore.data.h buC;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bua;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bua = (buC = postData.buC()).bua()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bua.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bua.get(i3);
                if (jVar != null) {
                    String bue = jVar.bue();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bue)) {
                        arrayList.add(bue);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bue;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bud();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eKq.aSz(), -1L);
                        imageUrlData.mIsReserver = this.eKq.aSM();
                        imageUrlData.mIsSeeHost = this.eKq.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = buC.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bue, imageUrlData);
                        }
                        if (!this.eLv) {
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
            if (postData.getId() != null && postData.getId().equals(this.eKq.rD())) {
                z = true;
            }
            MarkData h = this.eKq.h(postData);
            if (h != null) {
                this.eKs.aUr();
                if (this.enp != null) {
                    this.enp.a(h);
                    if (!z) {
                        this.enp.nE();
                    } else {
                        this.enp.nD();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText as(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eKq == null || this.eKq.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eKq.getPbData();
        if (pbData.aPV() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aPV());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aPQ = pbData.aPQ();
            a(pbData, aPQ);
            return a(aPQ, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aPY() != null && fVar.aPY().eHj != null && (list = fVar.aPY().eHj) != null && arrayList != null) {
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

    private long pr(String str) {
        ArrayList<PostData> aPQ;
        com.baidu.tieba.pb.data.f pbData = this.eKq.getPbData();
        if (pbData != null && (aPQ = pbData.aPQ()) != null && !aPQ.isEmpty()) {
            Iterator<PostData> it = aPQ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h buC = next.buC();
                if (buC != null && buC.goS) {
                    Iterator<TbRichTextData> it2 = next.aEt().II().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IX().getLink().equals(str)) {
                            return buC.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> II;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText aEt = arrayList.get(i2).aEt();
            if (aEt != null && (II = aEt.II()) != null) {
                int size = II.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (II.get(i4) != null && II.get(i4).getType() == 8) {
                        i3++;
                        if (II.get(i4).IO().Jc().equals(str)) {
                            int af = (int) com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
                            int width = II.get(i4).IO().getWidth() * af;
                            int height = II.get(i4).IO().getHeight() * af;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eLu = i4;
                            return aEt;
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
            this.eJD = str;
            if (this.eKb == null) {
                aRm();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eKb.ck(1).setVisibility(8);
            } else {
                this.eKb.ck(1).setVisibility(0);
            }
            this.eKb.tl();
            this.eKh = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cxA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEx() {
        hideNetRefreshView(this.eKs.getView());
        aRE();
        if (this.eKq.Ff()) {
            this.eKs.aUr();
        }
    }

    private void aRE() {
        showLoadingView(this.eKs.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View EA = getLoadingView().EA();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EA.getLayoutParams();
        layoutParams.addRule(3, this.eKs.aUR().getId());
        EA.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajk() {
        if (this.cxA != null) {
            this.cxA.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void px(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void py(int i) {
        boolean z;
        String str;
        Uri parse;
        if (this.eKq.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eKq.getPbData();
            pbData.aPM().getName();
            String title = pbData.aPO().getTitle();
            int i2 = this.eKq.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aPM() != null) {
                if ((pbData.aPM().isLike() == 1) && AddExperiencedModel.pT(pbData.getForumId())) {
                    z = true;
                    String str2 = "http://tieba.baidu.com/p/" + this.eKq.aSz() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bK = pbData.bK(getPageContext().getPageActivity());
                    str = bK[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    String str3 = bK[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aRp() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                    } else if (aRp() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                    }
                    String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str3);
                    final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
                    dVar.title = title;
                    dVar.content = format;
                    dVar.linkUrl = str2;
                    dVar.atI = true;
                    dVar.atM = z;
                    dVar.extData = this.eKq.aSz();
                    dVar.atX = 3;
                    dVar.atW = i;
                    dVar.fid = this.eKq.getForumId();
                    dVar.Xl = this.eKq.aSz();
                    dVar.atY = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.atR = parse;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.atX);
                    bundle.putInt("obj_type", dVar.atY);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.Xl);
                    bundle.putString(SapiAccountManager.SESSION_UID, dVar.uid);
                    dVar.e(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setIsCopyLink(true);
                    if (TbadkCoreApplication.isLogin()) {
                        shareDialogConfig.addOutsideTextView(d.j.forum_friend, d.f.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 23007)));
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10125").ac("tid", PbActivity.this.eKq.aSz()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKq.getForumId()).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                                PbActivity.this.wH();
                            }
                        });
                    }
                    shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            dVar.linkUrl = com.baidu.tbadk.coreExtra.d.e.ai(dVar.linkUrl, dVar.Xl);
                            com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.j.copy_pb_url_success));
                            PbActivity.this.wH();
                        }
                    });
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aQl()) {
                                PbActivity.this.eKs.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
                }
            }
            z = false;
            String str22 = "http://tieba.baidu.com/p/" + this.eKq.aSz() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bK2 = pbData.bK(getPageContext().getPageActivity());
            str = bK2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            String str32 = bK2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aRp() != 1) {
            }
            String format2 = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str32);
            final com.baidu.tbadk.coreExtra.d.d dVar2 = new com.baidu.tbadk.coreExtra.d.d();
            dVar2.title = title;
            dVar2.content = format2;
            dVar2.linkUrl = str22;
            dVar2.atI = true;
            dVar2.atM = z;
            dVar2.extData = this.eKq.aSz();
            dVar2.atX = 3;
            dVar2.atW = i;
            dVar2.fid = this.eKq.getForumId();
            dVar2.Xl = this.eKq.aSz();
            dVar2.atY = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.atX);
            bundle2.putInt("obj_type", dVar2.atY);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.Xl);
            bundle2.putString(SapiAccountManager.SESSION_UID, dVar2.uid);
            dVar2.e(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setIsCopyLink(true);
            if (TbadkCoreApplication.isLogin()) {
            }
            shareDialogConfig2.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar2.linkUrl = com.baidu.tbadk.coreExtra.d.e.ai(dVar2.linkUrl, dVar2.Xl);
                    com.baidu.adp.lib.util.a.aw(dVar2.linkUrl);
                    com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.j.copy_pb_url_success));
                    PbActivity.this.wH();
                }
            });
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.eKq != null && PbActivity.this.eKq.getPbData() != null && PbActivity.this.eKq.getPbData().aQl()) {
                        PbActivity.this.eKs.getView().setSystemUiVisibility(4);
                    }
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPO() != null) {
            if (fVar.aPO().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aPO().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void aRF() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pU(PbActivity.this.eKq.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eKs.aVa();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.anH == null) {
                this.anH = new ShareReportModel(getPageContext());
            }
            this.anH.j(shareItem.fid, shareItem.Xl, shareItem.atO);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Js() {
        if (this.aSp == null) {
            this.aSp = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRZ */
                public LinearLayout fI() {
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
        return this.aSp;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eKs.aUm() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, this.eKq.getPbData().getForumId()));
            } else {
                bh aPO = this.eKq.getPbData().aPO();
                if (view != null) {
                    boolean z = aPO.ri() == null || aPO.ri().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eLf > 1000) {
                            this.eLg = true;
                            bk(view);
                        } else {
                            this.eLg = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            m(view, this.eLg);
                        } else {
                            l(view, this.eLg);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        l(view, this.eLg);
                    } else if (motionEvent.getAction() == 3) {
                        l(view, this.eLg);
                    }
                }
            }
        }
        return false;
    }

    private void l(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eLf = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void m(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eLf = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bk(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    public void ajl() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11017)));
        } else if (aVar.tj() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tj();
            int intValue = ((Integer) sparseArray.get(ap.eTr)).intValue();
            if (intValue == ap.eTs) {
                if (!this.eKr.bvg()) {
                    this.eKs.aUo();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.eKr.a(this.eKq.getPbData().aPM().getId(), this.eKq.getPbData().aPM().getName(), this.eKq.getPbData().aPO().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ap.eTt || intValue == ap.eTv) {
                if (this.eKq.aSX() != null) {
                    this.eKq.aSX().pC(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ap.eTt) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ap.eTu) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eLA).pi()));
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
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eKL);
        userMuteAddAndDelCustomMessage.setTag(this.eKL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean ps(String str) {
        if (!StringUtils.isNull(str) && ax.aT(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(d.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void iK(boolean z) {
        this.eKA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aRG() {
        ArrayList<PostData> aPQ;
        int u;
        if (this.eKq == null || this.eKq.getPbData() == null || this.eKq.getPbData().aPQ() == null || (u = com.baidu.tbadk.core.util.v.u((aPQ = this.eKq.getPbData().aPQ()))) == 0) {
            return "";
        }
        if (this.eKq.aSM()) {
            Iterator<PostData> it = aPQ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.buu() == 1) {
                    return next.getId();
                }
            }
        }
        int aUv = this.eKs.aUv();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aPQ, aUv);
        if (postData == null || postData.rt() == null) {
            return "";
        }
        if (this.eKq.pw(postData.rt().getUserId())) {
            return postData.getId();
        }
        for (int i = aUv - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aPQ, i);
            if (postData2 == null || postData2.rt() == null || postData2.rt().getUserId() == null) {
                break;
            } else if (this.eKq.pw(postData2.rt().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aUv + 1; i2 < u; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aPQ, i2);
            if (postData3 == null || postData3.rt() == null || postData3.rt().getUserId() == null) {
                return "";
            }
            if (this.eKq.pw(postData3.rt().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (av.vI().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(pr(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eKq.getPbData().aPM().getId(), this.eKq.getPbData().aPM().getName(), this.eKq.getPbData().aPO().getTid());
            }
            this.eKh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cS(getResources().getString(d.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cS(getResources().getString(d.j.make_sure_hide));
        }
        aVar.a(getResources().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eKq.aSW() != null) {
                    PbActivity.this.eKq.aSW().co(j);
                }
            }
        });
        aVar.b(getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.ap(false);
        aVar.b(getPageContext());
        aVar.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c pt(String str) {
        String str2;
        if (this.eKq.getPbData() == null || this.eKq.getPbData().aPQ() == null || this.eKq.getPbData().aPQ().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.eKq.getPbData().aPQ().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eKq.getPbData().aPQ().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eKq.getPbData().aPQ().get(i);
        if (postData.aEt() == null || postData.aEt().II() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aEt().II().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.IO() != null) {
                    str2 = next.IO().Jc();
                }
            }
        }
        str2 = null;
        a(str2, 0, cVar);
        com.baidu.tieba.pb.data.g.a(postData, cVar);
        return cVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eJX) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eJX = false;
        } else if (aRH()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eJX) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eJX = false;
        } else if (aRH()) {
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
        if (pageStayDurationItem != null && this.eKq != null) {
            if (this.eKq.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eKq.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eKq.aSz(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aRH() {
        return (!this.eJV && this.eLC == -1 && this.eLD == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eLF = nVar;
            this.eJV = true;
            this.eKs.aUf();
            this.eKs.pB(this.eLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRI() {
        if (this.eLF != null) {
            if (this.eLC == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eLF.getCartoonId(), this.eLC, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRJ() {
        if (this.eLF != null) {
            if (this.eLD == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eLF.getCartoonId(), this.eLD, 0)));
                finish();
            }
        }
    }

    public int aRK() {
        return this.eLC;
    }

    public int aRL() {
        return this.eLD;
    }

    private void ate() {
        if (this.eKq != null && this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null && this.eKq.getPbData().aPO().sh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aRM() {
        if (this.eKq != null && this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null && this.eKq.getPbData().aPO().sh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aRN() {
        if (this.eJY) {
            this.eKm = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null && this.eKq.getPbData().aPO().qZ() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eKq.getPbData().aPO().qZ().getThreadId(), this.eKq.getPbData().aPO().qZ().getTaskId(), this.eKq.getPbData().aPO().qZ().getForumId(), this.eKq.getPbData().aPO().qZ().getForumName(), this.eKq.getPbData().aPO().ro(), this.eKq.getPbData().aPO().rp())));
            this.eJX = true;
            finish();
        }
    }

    public boolean aRO() {
        return this.eJY;
    }

    public String aRP() {
        return this.eKk;
    }

    public PbInterviewStatusView.a aRQ() {
        return this.eKp;
    }

    public void iL(boolean z) {
        this.eKl = z;
    }

    public boolean aRR() {
        if (this.eKq != null) {
            return this.eKq.aSB();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eKJ).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eKJ.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eKJ).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eKJ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eKJ.getPageActivity());
            aVar.cS(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eKJ).th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eKs.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eKJ.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cS(this.eKJ.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eKs.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eKJ).th();
    }

    public void aRT() {
        if (this.eKq != null && this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null && this.eKq.getPbData().aPO().sz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cc(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eKq.getPbData().aPO().sz().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.th();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.pD(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.e(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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
        if (this.eKs != null) {
            this.eKs.onConfigurationChanged(configuration);
        }
        if (this.eKy != null) {
            this.eKy.dismiss();
        }
    }

    public boolean aRU() {
        if (this.eKq != null) {
            return this.eKq.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ap apVar) {
        boolean z;
        List<PostData> list = this.eKq.getPbData().aPY().eHj;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bur().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bur().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bur().remove(i2);
                    list.get(i).but();
                    z = true;
                    break;
                }
            }
            list.get(i).sw(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            apVar.o(this.eKq.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aQy().getId();
        List<PostData> list = this.eKq.getPbData().aPY().eHj;
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
                ArrayList<PostData> aQC = mVar.aQC();
                postData.tQ(mVar.getTotalCount());
                if (postData.bur() != null) {
                    postData.bur().clear();
                    postData.bur().addAll(aQC);
                }
            }
        }
        if (!this.eKq.getIsFromMark()) {
            this.eKs.o(this.eKq.getPbData());
        }
    }

    public boolean aRV() {
        boolean z = true;
        if (this.eKq == null) {
            return false;
        }
        switch (this.eKq.aTf()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eKq.getPbData() != null && this.eKq.getPbData().aPO() != null && this.eKq.getPbData().aPO().sH()) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aRW() {
        if (this.eKs != null) {
            this.eKs.aTT();
            ajl();
        }
    }

    public PostData aPV() {
        return this.eKs.b(this.eKq.eOk, this.eKq.aSA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.isLinkThread()) {
                return 3;
            }
            if (bhVar.sB()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eKT != null && !this.eKT.isEmpty()) {
            int size = this.eKT.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.eKT.get(i).onBackPressed()) {
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
            if (this.eKT == null) {
                this.eKT = new ArrayList();
            }
            if (!this.eKT.contains(aVar)) {
                this.eKT.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.eKT != null) {
            this.eKT.remove(aVar);
        }
    }
}
