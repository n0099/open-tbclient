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
    private com.baidu.adp.lib.e.b<ImageView> aSu;
    private com.baidu.adp.lib.e.b<TextView> aSv;
    private com.baidu.adp.lib.e.b<View> aSw;
    private com.baidu.adp.lib.e.b<LinearLayout> aSx;
    private com.baidu.adp.lib.e.b<RelativeLayout> aSy;
    private com.baidu.adp.lib.e.b<GifView> aSz;
    private ShareReportModel anG;
    private com.baidu.adp.lib.e.b<TbImageView> aox;
    private com.baidu.tieba.e.b bzL;
    private VoiceManager cxT;
    private String eJX;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eKH;
    private View eKI;
    public ar eKR;
    private w eKS;
    private boolean eKU;
    private com.baidu.tieba.tbadkCore.data.e eKX;
    private com.baidu.tbadk.editortools.pb.e eKY;
    private com.baidu.tbadk.editortools.pb.d eKZ;
    private com.baidu.tieba.pb.pb.main.a.b eKq;
    private com.baidu.tbadk.core.dialog.a eKw;
    private boolean eLM;
    private String eLY;
    private com.baidu.tbadk.core.data.n eLZ;
    private com.baidu.adp.base.e eLd;
    private com.baidu.tbadk.core.view.c eLe;
    private BdUniqueId eLf;
    private Runnable eLg;
    private at eLh;
    private com.baidu.adp.widget.a.a eLi;
    private String eLj;
    private TbRichTextMemeInfo eLk;
    private List<a> eLn;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eKp = false;
    private boolean eKr = false;
    private boolean eKs = false;
    private boolean eqe = false;
    private boolean eKt = true;
    private int eKu = 0;
    private com.baidu.tbadk.core.dialog.b eKv = null;
    private long ckH = -1;
    private long aJR = 0;
    private long eKx = 0;
    private long createTime = 0;
    private long aJJ = 0;
    private boolean eKy = false;
    private com.baidu.tbadk.l.d eKz = null;
    private long eKA = 0;
    private boolean eKB = false;
    private long eKC = 0;
    private String aDj = null;
    private boolean eKD = false;
    private boolean isFullScreen = false;
    private String eKE = "";
    private boolean eKF = true;
    private boolean eKG = false;
    private String source = "";
    private PbInterviewStatusView.a eKJ = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eKM.jr(!PbActivity.this.eKF);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eKK != null && PbActivity.this.eKK.nC()) {
                        PbActivity.this.aRJ();
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
    private PbModel eKK = null;
    private com.baidu.tbadk.baseEditMark.a ent = null;
    private ForumManageModel eKL = null;
    private com.baidu.tbadk.coreExtra.c.a aoY = null;
    private ap eKM = null;
    public final com.baidu.tieba.pb.pb.main.a.a eKN = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eKO = false;
    private boolean eKP = false;
    private boolean eKQ = false;
    private boolean eKT = false;
    private boolean eKV = false;
    private boolean eKW = false;
    private boolean eLa = false;
    private com.baidu.tbadk.editortools.pb.c aDn = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Dr() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDo = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Dq() {
            if (PbActivity.this.eKR == null || PbActivity.this.eKR.aVm() == null || !PbActivity.this.eKR.aVm().bCr()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eKR.aVm().bCt());
            PbActivity.this.eKR.jA(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b eLb = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Dq() {
            if (PbActivity.this.eKR == null || PbActivity.this.eKR.aVn() == null || !PbActivity.this.eKR.aVn().bCr()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eKR.aVn().bCt());
            PbActivity.this.eKR.jB(true);
            return true;
        }
    };
    private boolean eLc = false;
    private int mLastScrollState = -1;
    private boolean cyz = false;
    private int eLl = 0;
    private int eLm = -1;
    private final x.a eLo = new x.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void B(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eKM.showToast(str);
            }
        }
    };
    private final CustomMessageListener eLp = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eKK != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eKZ != null) {
                    PbActivity.this.eKM.hh(PbActivity.this.eKZ.DA());
                }
                PbActivity.this.eKM.aUe();
                PbActivity.this.eKM.aEU();
            }
        }
    };
    CustomMessageListener cyP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                PbActivity.this.eKK.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                if (PbActivity.this.eKM != null && PbActivity.this.eKK != null) {
                    PbActivity.this.eKM.d(PbActivity.this.eKK.getPbData(), PbActivity.this.eKK.aSI(), PbActivity.this.eKK.aSZ());
                }
                if (PbActivity.this.eKM != null && PbActivity.this.eKM.aUv() != null) {
                    PbActivity.this.eKM.aUv().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eLq = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eKM != null) {
                    if (booleanValue) {
                        PbActivity.this.eKM.azN();
                    } else {
                        PbActivity.this.eKM.azM();
                    }
                }
            }
        }
    };
    private CustomMessageListener dWd = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eKZ != null) {
                    PbActivity.this.eKM.hh(PbActivity.this.eKZ.DA());
                }
                PbActivity.this.eKM.hi(false);
            }
        }
    };
    private CustomMessageListener dWz = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
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
    private CustomMessageListener eLr = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eKM != null && PbActivity.this.eKM.aUv() != null) {
                PbActivity.this.eKM.aUv().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dwa = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private j.a eLs = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.py(2);
                ag.aTO().reset();
                PbActivity.this.eKK.aTa();
                boolean z2 = false;
                ArrayList<PostData> aPY = PbActivity.this.eKK.getPbData().aPY();
                if (aPY != null) {
                    Iterator<PostData> it = aPY.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ao.k(next) && next.buO().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eKM.o(PbActivity.this.eKK.getPbData());
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
    private View.OnClickListener dWc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aDj);
        }
    };
    CustomMessageListener dgS = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eLt = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                aq.a aVar = new aq.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.WE = abVar.WE;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKK.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eKK.aSQ() != null && PbActivity.this.eKK.aSQ().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eKM.a(abVar.sendCount, PbActivity.this.eKK.getPbData(), PbActivity.this.eKK.aSI(), PbActivity.this.eKK.aSZ());
                    }
                    if (pbData.aPY() != null && pbData.aPY().size() >= 1 && pbData.aPY().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aPY().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eKK.aSH(), 0L);
                        if (c2 == abVar.postId && c3 == abVar.threadId) {
                            com.baidu.tbadk.core.data.aq buN = pbData.aPY().get(0).buN();
                            if (buN == null) {
                                buN = new com.baidu.tbadk.core.data.aq();
                            }
                            ArrayList<aq.a> qu = buN.qu();
                            if (qu == null) {
                                qu = new ArrayList<>();
                            }
                            qu.add(0, aVar);
                            buN.bM(abVar.sendCount + buN.qt());
                            buN.g(qu);
                            pbData.aPY().get(0).a(buN);
                            PbActivity.this.eKM.aUv().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eLu = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.afU() != null && !aVar.afU().isEmpty()) {
                    PbActivity.this.eKM.a(aVar, PbActivity.this.eLw);
                }
                PbActivity.this.eKM.a(aVar, PbActivity.this.eKK.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.aVz()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a eLv = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void B(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.v(list) && PbActivity.this.eKM != null) {
                PbActivity.this.eKM.cx(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eLw = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
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
    private boolean eLx = false;
    private PraiseModel eLy = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hT(String str) {
            PbActivity.this.eLx = false;
            if (PbActivity.this.eLy != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKK.getPbData();
                if (pbData.aPW().ri().getIsLike() == 1) {
                    PbActivity.this.jP(0);
                } else {
                    PbActivity.this.jP(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aPW()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void C(int i, String str) {
            PbActivity.this.eLx = false;
            if (PbActivity.this.eLy != null && str != null) {
                if (AntiHelper.ua(i)) {
                    AntiHelper.ao(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eLz = 0;
    private boolean eLA = true;
    private b.a eLB = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void iS(boolean z) {
            PbActivity.this.iR(z);
            if (PbActivity.this.eKM.aUY() != null && z) {
                PbActivity.this.eKM.jr(false);
            }
            PbActivity.this.eKM.jt(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().arR != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().arR, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahv));
                        }
                    } else if (updateAttentionMessage.getData().BJ) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aQd().rt() != null && PbActivity.this.aQd().rt().getGodUserData() != null) {
                            PbActivity.this.aQd().rt().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aPW() != null && PbActivity.this.eKK.getPbData().aPW().rt() != null) {
                            PbActivity.this.eKK.getPbData().aPW().rt().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bzm = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eKM.VR();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.pz(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.are();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aSE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eKM.aUf()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eKK != null && (PbActivity.this.eKK.getPbData() != null || PbActivity.this.eKK.getPbData().aQs() != null)) {
                    if (PbActivity.this.eKK.getPbData().aQs().aQB()) {
                        if (PbActivity.this.eKK.getPbData().aQs().eHn == 1 || PbActivity.this.eKK.getPbData().aQs().eHn == 3 || PbActivity.this.eKK.getPbData().aQs().eHn == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eKK.getPbData().aQs().aQB() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eKK.getPbData().aQs().aQB() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eKC > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).jX(false);
                        PbActivity.this.eKC = System.currentTimeMillis();
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
                    if (PbActivity.this.bi(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.eKM != null && PbActivity.this.eKM.aRt() && (view.getId() == d.g.pb_head_user_info_root || view == PbActivity.this.eKM.aVf())) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ac("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.eKN != null && PbActivity.this.eKN.eYc != null) {
                            PbActivity.this.eKN.eYc.onClick(view);
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
            if (PbActivity.this.eKZ != null) {
                PbActivity.this.eKM.hh(PbActivity.this.eKZ.DA());
            }
            PbActivity.this.eKM.aUe();
            PbActivity.this.eKM.aEU();
            return true;
        }
    });
    private CustomMessageListener eLC = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eLf) {
                PbActivity.this.eKM.VR();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKK.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aQj().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eLe.c(PbActivity.this.eLd.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eLd.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.ga(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aSa();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eLd.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.eLe.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eLD = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eLf) {
                PbActivity.this.eKM.VR();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eLe.c(PbActivity.this.eLd.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eLd.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.eLe.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eLE = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eLf) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eKM.VR();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gDt;
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
                    PbActivity.this.eKM.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eLF = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eKM.aUf() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aRa() != null && PbActivity.this.aRa().getPbData() != null && PbActivity.this.aRa().getPbData().aQs() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aQB = PbActivity.this.aRa().getPbData().aQs().aQB();
                if (intValue < 10) {
                    if (aQB) {
                        if (PbActivity.this.eKK.getPbData().aQs().eHn == 1 || PbActivity.this.eKK.getPbData().aQs().eHn == 3 || PbActivity.this.eKK.getPbData().aQs().eHn == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eKK.getPbData().aQs().aQB() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQB ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eKC > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).jX(false);
                        PbActivity.this.eKC = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aQB);
                TiebaStatic.log(PbActivity.this.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aQB ? 0 : 1));
            }
        }
    };
    private CustomMessageListener cyZ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cyz = true;
                }
            }
        }
    };
    public a.b ezo = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.ajz();
            com.baidu.tbadk.core.data.ap aua = PbActivity.this.eKK.aua();
            int pageNum = PbActivity.this.eKM.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (aua == null || pageNum <= aua.qm()) {
                PbActivity.this.eKM.aEU();
                PbActivity.this.py(2);
                PbActivity.this.ajy();
                PbActivity.this.eKM.aUz();
                if (com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.eKK.pE(PbActivity.this.eKM.getPageNum());
                    if (PbActivity.this.eKq != null) {
                        PbActivity.this.eKq.showFloatingView();
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
    public final View.OnClickListener czv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
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
            com.baidu.tieba.pb.data.l aQs;
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
            boolean k;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.eKM.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.eKK.iZ(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.eKM.aUA();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTH()) {
                        if (view == PbActivity.this.eKM.eRV.aLM) {
                            if (PbActivity.this.eKM.jv(PbActivity.this.eKK.aSN())) {
                                PbActivity.this.ajy();
                                return;
                            }
                            PbActivity.this.eKt = false;
                            PbActivity.this.eKr = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eKM.aUx() && (PbActivity.this.eKM.eRV.aWe() == null || (view != PbActivity.this.eKM.eRV.aWe().aTG() && view != PbActivity.this.eKM.eRV.aWe().aTE()))) {
                            if (view == PbActivity.this.eKM.aUQ()) {
                                if (PbActivity.this.eKK != null) {
                                    com.baidu.tbadk.browser.a.O(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eKK.getPbData().aPW().rs().getLink());
                                }
                            } else if (view != PbActivity.this.eKM.eRV.eYM && view.getId() != d.g.view_forum_name_first_floor) {
                                if (view == PbActivity.this.eKM.eRV.eYN) {
                                    if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null) {
                                        ArrayList<PostData> aPY = PbActivity.this.eKK.getPbData().aPY();
                                        if ((aPY == null || aPY.size() <= 0) && PbActivity.this.eKK.aSI()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ac("tid", PbActivity.this.eKK.aSH()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getForumId()));
                                        if (!PbActivity.this.eKM.aVg()) {
                                            PbActivity.this.eKM.aUe();
                                        }
                                        PbActivity.this.aRA();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTs()) {
                                        if ((PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTD()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.eKM.eRV.aWe() == null || (view != PbActivity.this.eKM.eRV.aWe().getCancelView() && view != PbActivity.this.eKM.eRV.aWe().aTC())) {
                                                if (view != PbActivity.this.eKM.eRV.eYO) {
                                                    if (PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTA()) {
                                                        if ((PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTJ()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTB()) {
                                                                if (PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTK()) {
                                                                    if (PbActivity.this.eKS == null || view != PbActivity.this.eKS.aTu()) {
                                                                        if (PbActivity.this.eKS == null || view != PbActivity.this.eKS.aTs()) {
                                                                            if (PbActivity.this.eKS == null || view != PbActivity.this.eKS.aTx()) {
                                                                                if (PbActivity.this.eKS == null || view != PbActivity.this.eKS.aTv()) {
                                                                                    if (PbActivity.this.eKS == null || view != PbActivity.this.eKS.aTw()) {
                                                                                        if (PbActivity.this.eKM.aUY() == view) {
                                                                                            if (PbActivity.this.eKM.aUY().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKK.getPbData();
                                                                                                if (pbData != null && pbData.aPW() != null && pbData.aPW().qZ() != null) {
                                                                                                    String pB = pbData.aPW().qZ().pB();
                                                                                                    if (StringUtils.isNull(pB)) {
                                                                                                        pB = pbData.aPW().qZ().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ac("obj_id", pB));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cd("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.aRV();
                                                                                        } else if (PbActivity.this.eKM.aUu() != view) {
                                                                                            if (PbActivity.this.eKS == null || view != PbActivity.this.eKS.aTt()) {
                                                                                                if (PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTI()) {
                                                                                                    if (PbActivity.this.eKM.eRV.aWe() != null && view == PbActivity.this.eKM.eRV.aWe().aTF()) {
                                                                                                        if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.eKM.c(PbActivity.this.eKK.getPbData(), PbActivity.this.eKK.aSI(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                PbActivity.this.eKM.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                            PbActivity.this.eKM.eRV.om();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.eKM.aRm()) {
                                                                                                            if (view == PbActivity.this.eKM.eRV.aWf()) {
                                                                                                                PbActivity.this.eKM.aUH();
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
                                                                                                                    PostData bj = PbActivity.this.bj(view);
                                                                                                                    if (bj != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", bj.buT() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state) {
                                                                                                                    PbActivity.this.f(view, 2, false);
                                                                                                                    if (PbActivity.this.aRa() != null && PbActivity.this.aRa().getPbData() != null && PbActivity.this.aRa().getPbData().aQs() != null && PbActivity.this.aRa().getPbData().aQs() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aRw().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aRa().getPbData().aQs().aQB() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && !StringUtils.isNull(PbActivity.this.eKK.getPbData().getThreadId()) && (aQs = PbActivity.this.eKK.getPbData().aQs()) != null && aQs.aQA() > 0) {
                                                                                                                        av.vI().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eKK.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.eKS == null) {
                                                                                                                                PbActivity.this.eKS = new w(PbActivity.this.getPageContext(), PbActivity.this.czv);
                                                                                                                                PbActivity.this.eKM.bq(PbActivity.this.eKS.getView());
                                                                                                                                PbActivity.this.eKS.jd(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.eKS.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ac("tid", PbActivity.this.eKK.eOn));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.eKS.aTs().setTag(sparseArray2);
                                                                                                                            PbActivity.this.eKS.aTx().setTag(view.getTag());
                                                                                                                            PbActivity.this.eKS.jf(z6);
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
                                                                                                                                    PbActivity.this.eKS.aTv().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.eKS.aTv().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.eKS.aTt().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eKS.aTv().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eKS.aTt().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.eKS.aTt().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.eKS.aTt().setVisibility(8);
                                                                                                                                PbActivity.this.eKS.aTv().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.eKS.aTt().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eKS.aTv().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eKS.aTt().setText(d.j.delete);
                                                                                                                                PbActivity.this.eKS.aTv().setVisibility(0);
                                                                                                                                if (PbActivity.this.eKK.getPbData().aQh() != 1002 || z2) {
                                                                                                                                    PbActivity.this.eKS.aTv().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eKS.aTv().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.eKS.aTt().setVisibility(8);
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
                                                                                                                                PbActivity.this.eKS.aTu().setTag(sparseArray7);
                                                                                                                                PbActivity.this.eKS.aTu().setVisibility(0);
                                                                                                                                PbActivity.this.eKS.aTt().setVisibility(8);
                                                                                                                                PbActivity.this.eKS.aTu().setText(d.j.mute_option);
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
                                                                                                                                boolean iN = PbActivity.this.iN(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.eLQ = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (ao.k(PbActivity.this.eLQ) ? false : iN) {
                                                                                                                                    PbActivity.this.eKS.aTu().setVisibility(0);
                                                                                                                                    PbActivity.this.eKS.aTu().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eKS.aTu().setVisibility(8);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            SparseArray sparseArray8 = (SparseArray) view.getTag();
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
                                                                                                                                PbActivity.this.eKS.aTw().setVisibility(0);
                                                                                                                                PbActivity.this.eKS.aTw().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.eKS.aTw().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.eKS.aTw().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.eKS.aTw().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eKK.getPbData().nC()) {
                                                                                                                            String nB = PbActivity.this.eKK.getPbData().nB();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(nB) && nB.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.eKS.aTs().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eKS.aTs().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.eKS.je(true);
                                                                                                                                PbActivity.this.eKS.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.eKS.je(true);
                                                                                                                        PbActivity.this.eKS.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aPW() != null && PbActivity.this.eKK.getPbData().aPW().sa() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), PbActivity.this.eKK.getPbData().aPW().sa());
                                                                                                                        if (PbActivity.this.eKK.getPbData().aPW().rY() != 1) {
                                                                                                                            if (PbActivity.this.eKK.getPbData().aPW().rY() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getPbData().getForumId()).ac("tid", PbActivity.this.eKK.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.eKK.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.eKM.setSelection(0);
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
                                                                                                                        PbActivity.this.eKM.aUe();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aRx() == 1) {
                                                                                                                            if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getPbData().getForumId()).ac("tid", PbActivity.this.eKK.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aRx() == 2 && PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getPbData().getForumId()).ac("tid", PbActivity.this.eKK.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.aRx() == 1) {
                                                                                                                            if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getPbData().getForumId()).ac("tid", PbActivity.this.eKK.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aRx() == 2 && PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getPbData().getForumId()).ac("tid", PbActivity.this.eKK.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.aRQ();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.aRR();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aQo() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eKK.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ac(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        av.vI().c(PbActivity.this.getPageContext(), new String[]{pbData2.aQo().aQw()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aQo() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eKK.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        av.vI().c(PbActivity.this.getPageContext(), new String[]{pbData3.aQo().aQw()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.eKM.eRV.aWe() != null && view == PbActivity.this.eKM.eRV.aWe().aTL()) {
                                                                                                                    if (PbActivity.this.eKK == null || PbActivity.this.eKK.getPbData() == null || PbActivity.this.eKK.getPbData().aPW() == null) {
                                                                                                                        PbActivity.this.eKM.eRV.om();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.hy()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.eKK.getPbData().aPW().rb() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eKK.aSH(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).tq();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").r("obj_locate", PbActivity.this.W(PbActivity.this.eKK.getPbData().aPW())).ac("tid", PbActivity.this.eKK.getPbData().aPW().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.eLl >= 0) {
                                                                                                                        if (PbActivity.this.eKK != null) {
                                                                                                                            PbActivity.this.eKK.aTo();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eKM.aUv() != null) {
                                                                                                                            PbActivity.this.eKM.aUv().a(PbActivity.this.eKK.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.eKM.getListView().setSelection(PbActivity.this.eKK.aTr());
                                                                                                                        PbActivity.this.eLl = 0;
                                                                                                                        if (PbActivity.this.eKK != null) {
                                                                                                                            PbActivity.this.eKK.bu(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.eKM.aVj();
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eKK.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eKK.aSH(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eKK.getPbData().aPW().rO())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.eKK.getPbData() != null) {
                                                                                                            PbActivity.this.eKM.aEU();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                String aSH = PbActivity.this.eKK.aSH();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.eKK.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.eKK.getPbData().aQh();
                                                                                                                }
                                                                                                                PbActivity.this.ajy();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c px = PbActivity.this.px(id2);
                                                                                                                    if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && px != null) {
                                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aSH, id2, "pb", true, null, true, null, i3, postData3.aWX(), PbActivity.this.eKK.getPbData().qf(), false, postData3.rt().getIconInfo()).addBigImageData(px.eMv, px.eMw, px.eMx, px.index)));
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
                                                                                                                    c px2 = PbActivity.this.px(id2);
                                                                                                                    if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && px2 != null && PbActivity.this.aRs().aUc() != null) {
                                                                                                                        com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                        mVar.b(PbActivity.this.eKK.getPbData().aPU());
                                                                                                                        mVar.M(PbActivity.this.eKK.getPbData().aPW());
                                                                                                                        mVar.d(postData4);
                                                                                                                        PbActivity.this.aRs().aUc().d(mVar);
                                                                                                                        PbActivity.this.aRs().aUc().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c px3 = PbActivity.this.px(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && px3 != null) {
                                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aSH, id2, "pb", true, null, false, null, i3, postData3.aWX(), PbActivity.this.eKK.getPbData().qf(), false, postData3.rt().getIconInfo()).addBigImageData(px3.eMv, px3.eMw, px3.eMx, px3.index)));
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                    PbActivity.this.eKM.aEU();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.eKM.c(PbActivity.this.eKK.getPbData(), PbActivity.this.eKK.aSI(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eKK.getPbData().aPU().getId(), PbActivity.this.eKK.getPbData().aPU().getName(), PbActivity.this.eKK.getPbData().aPW().getId(), String.valueOf(PbActivity.this.eKK.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
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
                                                                                                    if (!com.baidu.tieba.c.a.ZF() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eKK.aSH(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.eKM.bo(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.eKM.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.aRo();
                                                                                        }
                                                                                    } else {
                                                                                        long j2 = -1;
                                                                                        String str8 = "";
                                                                                        int i4 = 0;
                                                                                        if (view.getTag(d.g.tag_chudian_template_id) instanceof Long) {
                                                                                            j2 = ((Long) view.getTag(d.g.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (view.getTag(d.g.tag_chudian_monitor_id) instanceof String) {
                                                                                            str8 = (String) view.getTag(d.g.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (view.getTag(d.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                            i4 = ((Integer) view.getTag(d.g.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eKK.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aPU() != null) {
                                                                                            str9 = pbData4.aPU().getId();
                                                                                            str10 = pbData4.aPU().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.a.a(j2, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j2, str8, str9, str10, str11, i4);
                                                                                    }
                                                                                } else {
                                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                                    if (sparseArray12 != null) {
                                                                                        if ((sparseArray12.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_id) instanceof String) && (sparseArray12.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                            boolean booleanValue7 = ((Boolean) sparseArray12.get(d.g.tag_del_post_is_self)).booleanValue();
                                                                                            int intValue = ((Integer) sparseArray12.get(d.g.tag_manage_user_identity)).intValue();
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.ZF() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eKK.aSH(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.eKM.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.eKS.aTz()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ac("tid", PbActivity.this.eKK.eOn));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eKK.getPbData() != null) {
                                                                                    PbActivity.this.eKM.aEU();
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
                                                                                        String aSH2 = PbActivity.this.eKK.aSH();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.eKK.getPbData() != null) {
                                                                                            i5 = PbActivity.this.eKK.getPbData().aQh();
                                                                                        }
                                                                                        PbActivity.this.ajy();
                                                                                        c px4 = PbActivity.this.px(id3);
                                                                                        if (px4 != null) {
                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aSH2, id3, "pb", true, null, true, null, i5, postData.aWX(), PbActivity.this.eKK.getPbData().qf(), false, postData.rt().getIconInfo()).addBigImageData(px4.eMv, px4.eMw, px4.eMx, px4.index)));
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
                                                                                PbActivity.this.bk(view);
                                                                                if (PbActivity.this.eKK.getPbData().aPW() != null && PbActivity.this.eKK.getPbData().aPW().rt() != null && PbActivity.this.eKK.getPbData().aPW().rt().getUserId() != null && PbActivity.this.ent != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eKK.eOn).r("obj_locate", 2).ac("obj_id", PbActivity.this.eKK.getPbData().aPW().rt().getUserId()).r("obj_type", PbActivity.this.ent.nC() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eKK.getPbData())));
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
                                                                            PbActivity.this.pu((String) tag);
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
                                                                        PbActivity.this.eKM.onChangeSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").r("obj_type", 0).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        PbActivity.this.eKM.onChangeSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.eKM.eRV.om();
                                                                }
                                                            } else if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aPW() != null) {
                                                                PbActivity.this.eKM.eRV.om();
                                                                PbActivity.this.pu(PbActivity.this.eKK.getPbData().aPW().rK());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.eKM.aEU();
                                                            if (com.baidu.adp.lib.util.j.hh()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.eKK.aSU()));
                                                                    return;
                                                                }
                                                                PbActivity.this.py(2);
                                                                PbActivity.this.ajy();
                                                                PbActivity.this.eKM.aUz();
                                                                boolean aST = PbActivity.this.eKK.aST();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.eKK.aSU()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.eKM.eRV != null && PbActivity.this.eKM.eRV.aWe() != null && view == PbActivity.this.eKM.eRV.aWe().aTJ()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (aST) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.eKM.jo(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.eKM.aEU();
                                                        if (PbActivity.this.eKK.aua() != null) {
                                                            PbActivity.this.eKM.a(PbActivity.this.eKK.aua(), PbActivity.this.ezo);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.p.al.fS() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.eKK != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ac("tid", PbActivity.this.eKK.aSH()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.hy()) {
                                                        if (PbActivity.this.eKK.getPbData() != null) {
                                                            ArrayList<PostData> aPY2 = PbActivity.this.eKK.getPbData().aPY();
                                                            if ((aPY2 != null && aPY2.size() > 0) || !PbActivity.this.eKK.aSI()) {
                                                                PbActivity.this.eKM.aEU();
                                                                PbActivity.this.ajy();
                                                                PbActivity.this.py(2);
                                                                if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aQo() != null && !StringUtils.isNull(PbActivity.this.eKK.getPbData().aQo().pQ(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.p.al.fS()) {
                                                                    PbActivity.this.pz(2);
                                                                } else {
                                                                    PbActivity.this.eKM.showLoadingDialog();
                                                                    PbActivity.this.eKK.aTi().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.eKM.eRV.om();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.hh()) {
                                            PbActivity.this.eKM.aEU();
                                            if (PbActivity.this.eKM.eRV.aWe() != null && view == PbActivity.this.eKM.eRV.aWe().aTD() && !PbActivity.this.eKM.aVg()) {
                                                PbActivity.this.eKM.aUe();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.ajy();
                                                PbActivity.this.eKM.aUz();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    k = PbActivity.this.eKK.k(true, PbActivity.this.aRO());
                                                } else {
                                                    k = view.getId() == d.g.reply_title ? PbActivity.this.eKK.k(false, PbActivity.this.aRO()) : PbActivity.this.eKK.pz(PbActivity.this.aRO());
                                                }
                                                view.setTag(Boolean.valueOf(k));
                                                if (k) {
                                                    PbActivity.this.eKM.iW(true);
                                                    PbActivity.this.eKM.azN();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.eKM.jo(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.py(2);
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
                                        PbActivity.this.eKM.aEU();
                                        if (PbActivity.this.px(11009) && PbActivity.this.eKK.pL(PbActivity.this.eKM.aUE()) != null) {
                                            PbActivity.this.aRI();
                                            if (PbActivity.this.eKK.getPbData().aPW() != null && PbActivity.this.eKK.getPbData().aPW().rt() != null && PbActivity.this.eKK.getPbData().aPW().rt().getUserId() != null && PbActivity.this.ent != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eKK.eOn).r("obj_locate", 1).ac("obj_id", PbActivity.this.eKK.getPbData().aPW().rt().getUserId()).r("obj_type", PbActivity.this.ent.nC() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eKK.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                    PbActivity.this.eKM.iW(true);
                                    PbActivity.this.eKM.aUe();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eKM.azN();
                                        PbActivity.this.ajy();
                                        PbActivity.this.eKM.aUz();
                                        PbActivity.this.eKK.pz(PbActivity.this.aRO());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.py(2);
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
                                if (PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aPW() != null && PbActivity.this.eKK.getPbData().aPW().sh() && PbActivity.this.eKK.getPbData().aPW().rL() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.eKK.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eKK.aSG()) && PbActivity.this.eKK.getAppealInfo() != null) {
                                        name = PbActivity.this.eKK.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eKK.getPbData().aPU().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aSG = PbActivity.this.eKK.aSG();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eKK.aSJ() && aSG != null && aSG.equals(name)) {
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
                            if (PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aQh() == 1 && !PbActivity.this.eKL.bvs()) {
                                PbActivity.this.eKM.aEU();
                                int i6 = 0;
                                if (PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTE()) {
                                    if (PbActivity.this.eKM.eRV.aWe() == null || view != PbActivity.this.eKM.eRV.aWe().aTG()) {
                                        if (view == PbActivity.this.eKM.aUx()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eKK.getPbData().aPW().rp() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eKK.getPbData().aPW().ro() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aPU = PbActivity.this.eKK.getPbData().aPU();
                                String name2 = aPU.getName();
                                String id4 = aPU.getId();
                                String id5 = PbActivity.this.eKK.getPbData().aPW().getId();
                                if (!com.baidu.tieba.c.a.ZF() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eKM.aUw();
                                    PbActivity.this.eKL.a(id4, name2, id5, i6, PbActivity.this.eKM.aUy());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.hh()) {
                        PbActivity.this.eKM.aEU();
                        PbActivity.this.ajy();
                        PbActivity.this.eKM.aUz();
                        PbActivity.this.eKM.showLoadingDialog();
                        if (PbActivity.this.eKM.aUm() != null) {
                            PbActivity.this.eKM.aUm().setVisibility(8);
                        }
                        PbActivity.this.eKK.pE(1);
                        if (PbActivity.this.eKq != null) {
                            PbActivity.this.eKq.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String aRv = PbActivity.this.aRv();
                        if (!TextUtils.isEmpty(aRv)) {
                            av.vI().c(PbActivity.this.getPageContext(), new String[]{aRv});
                        }
                    }
                } else if (PbActivity.this.eKB) {
                    PbActivity.this.eKB = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.aRs().aUc() != null && postData5.rt() != null && postData5.buG() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.aRs().aUd() != null) {
                                    PbActivity.this.aRs().aUd().aSz();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.eKK.getPbData().aPU());
                                mVar2.M(PbActivity.this.eKK.getPbData().aPW());
                                mVar2.d(postData5);
                                PbActivity.this.aRs().aUc().d(mVar2);
                                PbActivity.this.aRs().aUc().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.rt().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.eKZ != null) {
                                    PbActivity.this.eKM.hh(PbActivity.this.eKZ.DA());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aDw = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.r rVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.ajy();
            PbActivity.this.eKM.a(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.ad.GM() && PbActivity.this.aRa() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aRa().pC(postWriteCallBackData.getPostId());
                    PbActivity.this.eLl = PbActivity.this.eKM.aUh();
                    if (PbActivity.this.eKK != null) {
                        PbActivity.this.eKK.bu(PbActivity.this.eLl, PbActivity.this.eKM.aUi());
                    }
                }
                PbActivity.this.eKM.aEU();
                PbActivity.this.eKR.aVl();
                if (PbActivity.this.eKZ != null) {
                    PbActivity.this.eKM.hh(PbActivity.this.eKZ.DA());
                }
                PbActivity.this.eKM.aUb();
                PbActivity.this.eKM.hi(true);
                PbActivity.this.eKK.aSW();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eKK.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKK.getPbData();
                            if (pbData != null && pbData.aPW() != null && pbData.aPW().rt() != null && (userId = pbData.aPW().rt().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.ad.GM() && PbActivity.this.eKK.aSP()) {
                                PbActivity.this.eKM.aUz();
                            }
                        } else if (!com.baidu.tbadk.p.ad.GM() && PbActivity.this.eKK.aSP()) {
                            PbActivity.this.eKM.aUz();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eKM.o(PbActivity.this.eKK.getPbData());
                    }
                    if (PbActivity.this.eKK.aSM()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ac("tid", PbActivity.this.eKK.aSH()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                PbActivity.this.eKR.d(postWriteCallBackData);
            } else if (rVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d eLG = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.r rVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.eKR != null) {
                if (z) {
                    PbActivity.this.eKR.aVk();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbActivity.this.eKR.e(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a eLH = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eM;
            if (!z || fVar == null || fVar.aQf() != null || com.baidu.tbadk.core.util.v.u(fVar.aPY()) >= 1) {
                PbActivity.this.eqe = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eKM.aUB();
                if (fVar == null || !fVar.aQc()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eKM.getView());
                } else if (PbActivity.this.eKM.aTZ() == null) {
                    PbActivity.this.eLc = true;
                }
                PbActivity.this.eKM.azM();
                if (PbActivity.this.isFullScreen || PbActivity.this.eKM.aVg()) {
                    PbActivity.this.eKM.aUU();
                } else if (!PbActivity.this.eKM.aUT()) {
                    PbActivity.this.eKM.hi(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eKT = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eKM.Oo();
                    PbActivity.this.eKM.jx(fVar.aQc());
                    if (fVar.aPW() != null && fVar.aPW().sr() != null) {
                        PbActivity.this.a(fVar.aPW().sr());
                    }
                    PbActivity.this.aRp();
                    if (PbActivity.this.eKZ != null) {
                        PbActivity.this.eKM.hh(PbActivity.this.eKZ.DA());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aPY() != null && fVar.aPY().size() >= 1 && fVar.aPY().get(0) != null) {
                        PbActivity.this.eKK.pB(fVar.aPY().get(0).getId());
                    } else if (fVar.aQf() != null) {
                        PbActivity.this.eKK.pB(fVar.aQf().getId());
                    }
                    if (PbActivity.this.eKZ != null) {
                        PbActivity.this.eKZ.a(fVar.qf());
                        PbActivity.this.eKZ.a(fVar.aPU(), fVar.getUserData());
                        PbActivity.this.eKZ.a(PbActivity.this.eKK.aSQ(), PbActivity.this.eKK.aSH(), PbActivity.this.eKK.aTk());
                        if (fVar.aPW() != null) {
                            PbActivity.this.eKZ.bE(fVar.aPW().sH());
                        }
                    }
                    if (PbActivity.this.ent != null) {
                        PbActivity.this.ent.ab(fVar.nC());
                    }
                    if (fVar == null || fVar.aQi() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eKM.jw(PbActivity.this.mIsFromCDN);
                    PbActivity.this.eKM.a(fVar, i2, i3, PbActivity.this.eKK.aSI(), i4, PbActivity.this.eKK.getIsFromMark());
                    PbActivity.this.eKM.d(fVar, PbActivity.this.eKK.aSI());
                    PbActivity.this.eKM.ju(PbActivity.this.eKK.getHostMode());
                    AntiData qf = fVar.qf();
                    if (qf != null) {
                        PbActivity.this.aDj = qf.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aDj) && PbActivity.this.eKZ != null && PbActivity.this.eKZ.CU() != null && (eM = PbActivity.this.eKZ.CU().eM(6)) != null && !TextUtils.isEmpty(PbActivity.this.aDj)) {
                            ((View) eM).setOnClickListener(PbActivity.this.dWc);
                        }
                    }
                    if (PbActivity.this.eKV) {
                        PbActivity.this.eKV = false;
                        PbActivity.this.aRs().getListView().setSelection(PbActivity.this.aRC());
                    }
                    if (PbActivity.this.eKW) {
                        PbActivity.this.eKW = false;
                        int aRC = PbActivity.this.aRC();
                        if (aRC == -1) {
                            aRC = PbActivity.this.aRD();
                        }
                        if (PbActivity.this.aRs() != null) {
                            PbActivity.this.aRs().pP(aRC);
                        }
                    } else {
                        PbActivity.this.eKM.aUF();
                    }
                    PbActivity.this.eKK.a(fVar.aPU(), PbActivity.this.eLu);
                    PbActivity.this.eKK.a(PbActivity.this.eLv);
                } else if (str != null) {
                    if (!PbActivity.this.eKT && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eKK != null && PbActivity.this.eKK.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eKK.getAppealInfo().eGy)) {
                                    PbActivity.this.eKM.a(PbActivity.this.eKK.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eKM.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eKM.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.eKM.aUU();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.eKK.aSH());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                    }
                    if (i != -1) {
                        PbActivity.this.eKM.pD(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.eKM.pD("");
                    }
                    PbActivity.this.eKM.wu();
                }
                PbActivity.this.aJR = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aRa().aSI() || PbActivity.this.aRa().getPbData().qv().qs() != 0 || PbActivity.this.aRa().aTd()) {
                    PbActivity.this.eLa = true;
                    return;
                }
                return;
            }
            PbActivity.this.eKK.pE(1);
            if (PbActivity.this.eKq != null) {
                PbActivity.this.eKq.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eKM.o(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.r.Gt().Gu()) {
                com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m(i, z, responsedMessage, PbActivity.this.aJJ, PbActivity.this.createTime, PbActivity.this.aJR, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.ckH : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aJJ = 0L;
                if (mVar != null) {
                    mVar.Go();
                }
            }
        }
    };
    private CustomMessageListener eLI = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aRx() == 1) {
                    PbActivity.this.aRG();
                }
                PbActivity.this.aRy();
            }
        }
    };
    private final a.InterfaceC0042a eLJ = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eKM.aUB();
            if (z) {
                if (PbActivity.this.ent != null) {
                    PbActivity.this.ent.ab(z2);
                }
                PbActivity.this.eKK.jb(z2);
                if (PbActivity.this.eKK.nC()) {
                    PbActivity.this.aRJ();
                } else {
                    PbActivity.this.eKM.o(PbActivity.this.eKK.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.ent != null && PbActivity.this.ent.nF() != null && PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aPW() != null && PbActivity.this.eKK.getPbData().aPW().rt() != null) {
                        MarkData nF = PbActivity.this.ent.nF();
                        MetaData rt = PbActivity.this.eKK.getPbData().aPW().rt();
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
            if (!PbActivity.this.pv(PbActivity.this.mLastScrollState) && PbActivity.this.pv(i)) {
                if (PbActivity.this.eKM != null) {
                    PbActivity.this.eKM.aEU();
                    if (PbActivity.this.eKZ != null && !PbActivity.this.eKM.aUf()) {
                        PbActivity.this.eKM.hh(PbActivity.this.eKZ.DA());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.eKM.aUe();
                    }
                }
                if (!PbActivity.this.eKy) {
                    PbActivity.this.eKy = true;
                    PbActivity.this.eKM.aUS();
                }
            }
            PbActivity.this.eKM.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eKq != null) {
                PbActivity.this.eKq.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eKz == null) {
                PbActivity.this.eKz = new com.baidu.tbadk.l.d();
                PbActivity.this.eKz.fs(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aPW() != null && PbActivity.this.eKK.getPbData().aPW().sh()) {
                    z = false;
                }
                if (PbActivity.this.eKM.aUv() != null && z) {
                    PbActivity.this.eKM.aUv().notifyDataSetChanged();
                }
                PbActivity.this.eKz.Ga();
            } else if (i == 1) {
                PbActivity.this.eKz.Ga();
            } else {
                PbActivity.this.eKz.Ga();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aPY;
            if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKM != null && PbActivity.this.eKM.aUv() != null) {
                PbActivity.this.eKM.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eKq != null) {
                    PbActivity.this.eKq.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eKK.aSY() && (aPY = PbActivity.this.eKK.getPbData().aPY()) != null && !aPY.isEmpty()) {
                    int aSo = ((i + i2) - PbActivity.this.eKM.aUv().aSo()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eKK.getPbData();
                    if (pbData != null) {
                        if (pbData.aPZ() != null && pbData.aPZ().hasData()) {
                            aSo--;
                        }
                        if (pbData.aQa() != null && pbData.aQa().hasData()) {
                            aSo--;
                        }
                        int size = aPY.size();
                        if (aSo < 0 || aSo >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eLK = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.eKL.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eKK.aSW();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.daT && bVar.fay > 0 && bVar.gsB != 0 && bVar.fay != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.fay == 1002 && !bVar.daT) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eKM.a(1, dVar.Al, dVar.gsD, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eKL.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eKM.a(PbActivity.this.eKL.getLoadDataMode(), fVar.Al, fVar.gsD, false);
                        PbActivity.this.eKM.aj(fVar.gsF);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eKM.a(PbActivity.this.eKL.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d eLL = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
    };
    private final g.b bcu = new g.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aRP()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eKK.ja(true)) {
                PbActivity.this.eKM.aUC();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eLN = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eLM && PbActivity.this.aRP()) {
                PbActivity.this.aRR();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eKK.iZ(false)) {
                    PbActivity.this.eKM.aUA();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eKK.getPbData() != null) {
                    PbActivity.this.eKM.aUR();
                }
                PbActivity.this.eLM = true;
            }
        }
    };
    private int eLO = 0;
    private final TbRichTextView.f aSD = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
        /* JADX DEBUG: Multi-variable search result rejected for r2v34, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
        public void a(View view, String str, int i) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.eKM.e((TbRichText) view.getTag());
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
                    PbActivity.this.eKI = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.eMy) {
                    TbRichText as = PbActivity.this.as(str, i);
                    if (as != null && PbActivity.this.eLO >= 0 && PbActivity.this.eLO < as.IT().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String c2 = com.baidu.tieba.pb.data.g.c(as.IT().get(PbActivity.this.eLO));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.eMv.size()) {
                                break;
                            } else if (!cVar.eMv.get(i3).equals(c2)) {
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
                            concurrentHashMap.put(str2, cVar.eMw.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eMx, cVar.lastId, PbActivity.this.eKK.aSU(), concurrentHashMap, true, false, PbActivity.this.eKK.getHostMode());
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.eMv, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.v(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.eMw.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eMx, cVar.eMv.get(0), PbActivity.this.eKK.aSU(), concurrentHashMap2, true, false, PbActivity.this.eKK.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eLP = false;
    PostData eLQ = null;
    private final b.InterfaceC0047b eLR = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eLQ != null) {
                if (i == 0) {
                    PbActivity.this.eLQ.bW(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eLQ = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.eLQ);
                }
            }
        }
    };
    private final b.InterfaceC0047b eLS = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eLi != null && !TextUtils.isEmpty(PbActivity.this.eLj)) {
                if (i == 0) {
                    if (PbActivity.this.eLk == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eLj));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eLj;
                        aVar.pkgId = PbActivity.this.eLk.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eLk.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eLh == null) {
                        PbActivity.this.eLh = new at(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eLh.i(PbActivity.this.eLj, PbActivity.this.eLi.kN());
                }
                PbActivity.this.eLi = null;
                PbActivity.this.eLj = null;
            }
        }
    };
    private final View.OnLongClickListener auZ = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eLi = ((TbImageView) view).getBdImage();
                PbActivity.this.eLj = ((TbImageView) view).getUrl();
                if (PbActivity.this.eLi != null && !TextUtils.isEmpty(PbActivity.this.eLj)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eLk = null;
                    } else {
                        PbActivity.this.eLk = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eKM.a(PbActivity.this.eLS, PbActivity.this.eLi.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.eLi = ((GifView) view).getBdImage();
                }
                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                    PbActivity.this.eLj = ((GifView) view).getBdImage().getUrl();
                }
                if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                    PbActivity.this.eLk = null;
                } else {
                    PbActivity.this.eLk = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                }
                PbActivity.this.eKM.a(PbActivity.this.eLS, PbActivity.this.eLi.isGif());
            } else if (view instanceof com.baidu.tbadk.widget.c) {
                if (((com.baidu.tbadk.widget.c) view).getBdImage() != null) {
                    PbActivity.this.eLi = ((com.baidu.tbadk.widget.c) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.c) view).getBdImage().getUrl())) {
                        PbActivity.this.eLj = ((com.baidu.tbadk.widget.c) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eLk = null;
                    } else {
                        PbActivity.this.eLk = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eKM.a(PbActivity.this.eLS, PbActivity.this.eLi.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eLQ = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.eLQ != null && PbActivity.this.ent != null) {
                        PbActivity.this.eKM.a(PbActivity.this.eLR, PbActivity.this.ent.nC() && PbActivity.this.eLQ.getId() != null && PbActivity.this.eLQ.getId().equals(PbActivity.this.eKK.rD()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a cwk = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (!PbActivity.this.eKs && z && !PbActivity.this.eKK.aSO()) {
                PbActivity.this.aEB();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener aMI = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).asZ()) {
                        break;
                    }
                }
            }
            PbActivity.this.bzL.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0081a bzM = new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        final int bJd;

        {
            this.bJd = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ag(int i, int i2) {
            if (J(i2) && PbActivity.this.eKM != null && PbActivity.this.eKq != null) {
                PbActivity.this.eKM.aUV();
                PbActivity.this.eKq.eK(false);
                PbActivity.this.eKq.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ah(int i, int i2) {
            if (J(i2) && PbActivity.this.eKM != null && PbActivity.this.eKq != null) {
                PbActivity.this.eKq.eK(true);
                if (Math.abs(i2) > this.bJd) {
                    PbActivity.this.eKq.hideFloatingView();
                }
                if (PbActivity.this.aRP()) {
                    PbActivity.this.eKM.aUr();
                    PbActivity.this.eKM.aUs();
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
    private final b.a eLT = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // com.baidu.tieba.e.b.a
        public void ef(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aQQ();
            } else {
                com.baidu.tieba.pb.a.b.aQP();
            }
        }
    };
    private String eLU = null;
    private final o.a eLV = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eLU = str2;
                PbActivity.this.eKM.pE(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eLW = -1;
    private int eLX = -1;
    private CustomMessageListener eMa = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Ty == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0045a) {
                    if (aVar.Tz != null && !aVar.Tz.hasError() && aVar.Tz.getError() == 0) {
                        if (PbActivity.this.eKM != null) {
                            PbActivity.this.eKM.y(((a.C0045a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aSb();
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
                        if (PbActivity.this.eKM != null && PbActivity.this.eKM != null) {
                            PbActivity.this.eKM.y(((a.C0045a) aVar).channelId, 2);
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
    private final CustomMessageListener cyS = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
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
        public ArrayList<String> eMv;
        public ConcurrentHashMap<String, ImageUrlData> eMw;
        public boolean eMy;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eMx = false;
        public boolean eMz = false;
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

    public com.baidu.tbadk.editortools.pb.d aRn() {
        return this.eKZ;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        if (mVar.aQG() != null) {
            String id = mVar.aQG().getId();
            ArrayList<PostData> aPY = this.eKK.getPbData().aPY();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aPY.size()) {
                    break;
                }
                PostData postData = aPY.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aQK = mVar.aQK();
                    postData.tU(mVar.getTotalCount());
                    if (postData.buD() != null && aQK != null) {
                        Iterator<PostData> it = aQK.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.rt() != null && (metaData = postData.getUserMap().get(next.rt().getUserId())) != null) {
                                next.a(metaData);
                                next.mE(true);
                                next.b(getPageContext(), this.eKK.pA(metaData.getUserId()));
                            }
                        }
                        postData.buD().clear();
                        postData.buD().addAll(aQK);
                    }
                    if (postData.buz() != null) {
                        postData.buA();
                    }
                }
            }
            if (!this.eKK.getIsFromMark()) {
                this.eKM.o(this.eKK.getPbData());
            }
            c(mVar);
        }
    }

    public void aRo() {
        com.baidu.tieba.pb.data.f pbData;
        bh aPW;
        if (!this.eLx) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (this.eLA) {
                this.eLx = true;
                if (this.eKK != null && (pbData = this.eKK.getPbData()) != null && (aPW = pbData.aPW()) != null) {
                    int isLike = aPW.ri() == null ? 0 : aPW.ri().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ac("tid", aPW.getId()));
                    }
                    if (this.eLy != null) {
                        this.eLy.a(aPW.rK(), aPW.getId(), isLike, "pb");
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
                                    PbActivity.this.eKM.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eLf);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eLf);
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
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eLf);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eLf);
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
    public void jP(int i) {
        bh aPW;
        String str;
        String y;
        if (this.eKK != null && this.eKK.getPbData() != null && (aPW = this.eKK.getPbData().aPW()) != null) {
            if (i == 1) {
                PraiseData ri = aPW.ri();
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
                        aPW.a(praiseData);
                    } else {
                        aPW.ri().getUser().add(0, metaData);
                        aPW.ri().setNum(aPW.ri().getNum() + 1);
                        aPW.ri().setIsLike(i);
                    }
                }
                if (aPW.ri() != null) {
                    if (aPW.ri().getNum() < 1) {
                        y = getResources().getString(d.j.zan);
                    } else {
                        y = com.baidu.tbadk.core.util.am.y(aPW.ri().getNum());
                    }
                    this.eKM.P(y, true);
                }
            } else if (aPW.ri() != null) {
                aPW.ri().setIsLike(i);
                aPW.ri().setNum(aPW.ri().getNum() - 1);
                ArrayList<MetaData> user = aPW.ri().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aPW.ri().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aPW.ri().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = aPW.ri().getNum() + "";
                }
                this.eKM.P(str, false);
            }
            if (this.eKK.aSI()) {
                this.eKM.aUv().notifyDataSetChanged();
            } else {
                this.eKM.p(this.eKK.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eKK != null && this.eKK.getPbData() != null && this.eKM != null) {
            this.eKM.d(this.eKK.getPbData(), this.eKK.aSI(), this.eKK.aSZ());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eKK.t(bundle);
        if (this.cxT != null) {
            this.cxT.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eKZ.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eLd = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.ckH = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eKE = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eKE)) {
                this.eKr = true;
            }
            this.eLW = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eLX = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eLY = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eKV = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eKW = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aRP()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.eLm = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
        } else {
            this.ckH = System.currentTimeMillis();
        }
        this.eKx = System.currentTimeMillis();
        this.aJJ = this.eKx - this.ckH;
        super.onCreate(bundle);
        this.eKu = 0;
        v(bundle);
        if (this.eKK != null && this.eKK.getPbData() != null) {
            this.eKK.getPbData().pr(this.source);
        }
        initUI();
        if (intent != null && this.eKM != null) {
            this.eKM.eRO = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eLg == null) {
                    this.eLg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eKM.pG("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eLg, 1500L);
            }
        }
        this.cxT = new VoiceManager();
        this.cxT.onCreate(getPageContext());
        initData(bundle);
        this.eKY = new com.baidu.tbadk.editortools.pb.e();
        aRp();
        this.eKZ = (com.baidu.tbadk.editortools.pb.d) this.eKY.aW(getActivity());
        this.eKZ.d(this);
        this.eKZ.a(this.aDw);
        this.eKZ.a(this.aDn);
        this.eKZ.a(this, bundle);
        this.eKZ.CU().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eKZ.CU().bx(true);
        iM(true);
        this.eKM.setEditorTools(this.eKZ.CU());
        this.eKZ.a(this.eKK.aSQ(), this.eKK.aSH(), this.eKK.aTk());
        registerListener(this.dWd);
        if (!this.eKK.aSN()) {
            this.eKZ.fU(this.eKK.aSH());
        }
        if (this.eKK.aTl()) {
            this.eKZ.fS(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.eKZ.fS(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eKx;
        registerListener(this.eLq);
        registerListener(this.dWz);
        registerListener(this.eLr);
        registerListener(this.cyP);
        registerListener(this.eLF);
        registerListener(this.eLp);
        this.eKX = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gpN);
        this.eKX.bui();
        registerListener(this.eLt);
        registerListener(this.mAttentionListener);
        if (this.eKK != null) {
            this.eKK.aTb();
        }
        registerListener(this.eLI);
        registerListener(this.eMa);
        registerListener(this.cyZ);
        if (this.eKM != null && this.eKM.aUZ() != null && this.eKM.aVa() != null) {
            this.eKq = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eKM.aUZ(), this.eKM.aVa(), this.eKM.aUm());
            this.eKq.a(this.eLB);
        }
        if (this.eKp && this.eKM != null && this.eKM.aVa() != null) {
            this.eKM.aVa().setVisibility(8);
        }
        this.eLe = new com.baidu.tbadk.core.view.c();
        this.eLe.akR = 1000L;
        registerListener(this.eLE);
        registerListener(this.eLC);
        registerListener(this.eLD);
        this.eLf = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eLf;
        userMuteAddAndDelCustomMessage.setTag(this.eLf);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eLf;
        userMuteCheckCustomMessage.setTag(this.eLf);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eKK.aTi().a(this.bzm);
        if ("from_tieba_kuang".equals(this.eKE)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 2).ac("tid", this.eKK.aSH()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        this.eKR = new ar();
        if (this.eKZ.Du() != null) {
            this.eKR.f(this.eKZ.Du().Dm());
        }
        this.eKZ.a(this.aDo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRp() {
        if (this.eKY != null && this.eKK != null) {
            this.eKY.setForumName(this.eKK.aSG());
            if (this.eKK.getPbData() != null && this.eKK.getPbData().aPU() != null) {
                this.eKY.setForumId(this.eKK.getPbData().aPU().getId());
            }
            this.eKY.setFrom("pb");
            this.eKY.a(this.eKK);
        }
    }

    public String aRq() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aRr() {
        return this.eKq;
    }

    private void iM(boolean z) {
        this.eKZ.bB(z);
        this.eKZ.bC(z);
        this.eKZ.bD(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cxT != null) {
            this.cxT.onStart(getPageContext());
        }
    }

    public ap aRs() {
        return this.eKM;
    }

    public PbModel aRa() {
        return this.eKK;
    }

    public void pt(String str) {
        if (this.eKK != null && !StringUtils.isNull(str) && this.eKM != null) {
            this.eKM.jz(true);
            this.eKK.pt(str);
            this.eKD = true;
            this.eKM.aEU();
            this.eKM.aUU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eKs = false;
        } else {
            this.eKs = true;
        }
        super.onPause();
        if (this.eKM.aTZ() != null && this.eKM.aTZ().aRk() != null) {
            this.eKM.aTZ().aRk().onPause();
        }
        BdListView listView = getListView();
        this.eKu = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eKu == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cxT != null) {
            this.cxT.onPause(getPageContext());
        }
        if (this.eKM != null) {
            this.eKM.onPause();
        }
        if (!this.eKK.aSN()) {
            this.eKZ.fT(this.eKK.aSH());
        }
        if (this.eKK != null) {
            this.eKK.aTc();
        }
        MessageManager.getInstance().unRegisterListener(this.dwa);
        atv();
        MessageManager.getInstance().unRegisterListener(this.eLC);
        MessageManager.getInstance().unRegisterListener(this.eLD);
        MessageManager.getInstance().unRegisterListener(this.eLE);
        MessageManager.getInstance().unRegisterListener(this.cyS);
        MessageManager.getInstance().unRegisterListener(this.dgS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aRt() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eKK.getPbData(), this.eKK.aSI(), this.eKK.aSZ());
        return (a2 == null || a2.rt() == null || a2.rt().getGodUserData() == null || a2.rt().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eKs = false;
        super.onResume();
        if (this.eKG) {
            this.eKG = false;
            aRV();
        }
        if (this.eKM.aTZ() != null && this.eKM.aTZ().aRk() != null) {
            this.eKM.aTZ().aRk().onResume();
        }
        if (aRt()) {
            this.eKA = System.currentTimeMillis();
        } else {
            this.eKA = -1L;
        }
        if (this.eKM != null && this.eKM.getView() != null) {
            if (!this.eqe) {
                aRM();
            } else {
                hideLoadingView(this.eKM.getView());
            }
            this.eKM.onResume();
        }
        if (this.eKu == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eKM != null) {
            noNetworkView = this.eKM.aUa();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.hh()) {
            noNetworkView.aI(false);
        }
        if (this.cxT != null) {
            this.cxT.onResume(getPageContext());
        }
        registerListener(this.dwa);
        this.eKU = false;
        aRU();
        registerListener(this.eLC);
        registerListener(this.eLD);
        registerListener(this.eLE);
        registerListener(this.cyS);
        registerListener(this.dgS);
        if (this.cyz) {
            aEB();
            this.cyz = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eKM.jp(z);
        if (this.eKS != null) {
            this.eKS.jd(z);
        }
        if (z && this.eKU) {
            this.eKM.aUA();
            this.eKK.iZ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eKA > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ac("obj_duration", (System.currentTimeMillis() - this.eKA) + ""));
            this.eKA = 0L;
        }
        if (aRs().aUd() != null) {
            aRs().aUd().onStop();
        }
        if (this.eKM.eRV != null && !this.eKM.eRV.aaQ()) {
            this.eKM.eRV.aFn();
        }
        if (this.eKK != null && this.eKK.getPbData() != null && this.eKK.getPbData().aPU() != null && this.eKK.getPbData().aPW() != null) {
            com.baidu.tbadk.distribute.a.CE().a(getPageContext().getPageActivity(), "pb", this.eKK.getPbData().aPU().getId(), com.baidu.adp.lib.g.b.c(this.eKK.getPbData().aPW().getId(), 0L));
        }
        if (this.cxT != null) {
            this.cxT.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.eKy && this.eKM != null) {
            this.eKy = true;
            this.eKM.aUS();
            a(false, (PostData) null);
        }
        if (this.eKK != null) {
            this.eKK.cancelLoadData();
            this.eKK.destory();
            if (this.eKK.aTh() != null) {
                this.eKK.aTh().onDestroy();
            }
        }
        if (this.eKZ != null) {
            this.eKZ.onDestroy();
        }
        if (this.eKL != null) {
            this.eKL.cancelLoadData();
        }
        if (this.eKM != null) {
            this.eKM.onDestroy();
            if (this.eKM.eRV != null) {
                this.eKM.eRV.aFn();
            }
        }
        if (this.eKz != null) {
            this.eKz.onDestroy();
        }
        if (this.eKq != null) {
            this.eKq.Hi();
        }
        super.onDestroy();
        if (this.cxT != null) {
            this.cxT.onDestory(getPageContext());
        }
        this.eKM.aEU();
        MessageManager.getInstance().unRegisterListener(this.eLC);
        MessageManager.getInstance().unRegisterListener(this.eLD);
        MessageManager.getInstance().unRegisterListener(this.eLE);
        MessageManager.getInstance().unRegisterListener(this.eLf);
        MessageManager.getInstance().unRegisterListener(this.eLF);
        MessageManager.getInstance().unRegisterListener(this.cyZ);
        this.eLd = null;
        this.eLe = null;
        com.baidu.tieba.recapp.e.a.bjQ().bjS();
        if (this.eLg != null) {
            getSafeHandler().removeCallbacks(this.eLg);
        }
        if (this.eKH != null) {
            this.eKH.cancelLoadData();
        }
        if (this.eKM != null && this.eKM.eRV != null) {
            this.eKM.eRV.aWi();
        }
        this.eKR.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        h aUv;
        ArrayList<PostData> aSp;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.b adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xF() && this.eKM != null && (aUv = this.eKM.aUv()) != null && (aSp = aUv.aSp()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aSp.iterator();
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
                        bVar.aMr = id;
                        bVar.bUP = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Zh == 1 && !TextUtils.isEmpty(id)) {
                    next.Zh = 2;
                    a.b bVar2 = new a.b();
                    bVar2.aMr = id;
                    bVar2.bUP = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eKK == null || this.eKK.getPbData() == null || this.eKK.getPbData().aPU() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eKK.getPbData().aPU().getFirst_class();
                    str2 = this.eKK.getPbData().aPU().getSecond_class();
                    str = this.eKK.getPbData().aPU().getId();
                    str4 = this.eKK.aSH();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xI());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eKM.onChangeSkinType(i);
        if (this.eKZ != null && this.eKZ.CU() != null) {
            this.eKZ.CU().onChangeSkinType(i);
        }
        if (this.eKM.aUa() != null) {
            this.eKM.aUa().onChangeSkinType(getPageContext(), i);
        }
        this.eKR.onChangeSkinType();
    }

    private void initUI() {
        this.eKM = new ap(this, this.czv, this.aSE);
        this.bzL = new com.baidu.tieba.e.b(getActivity());
        this.bzL.a(this.eLT);
        this.bzL.a(this.bzM);
        this.eKM.setOnScrollListener(this.mOnScrollListener);
        this.eKM.d(this.eLN);
        this.eKM.a(this.bcu);
        this.eKM.iE(com.baidu.tbadk.core.h.oT().oZ());
        this.eKM.setOnImageClickListener(this.aSD);
        this.eKM.a(this.auZ);
        this.eKM.h(this.cwk);
        this.eKM.a(this.eLL);
        this.eKM.jp(this.mIsLogin);
        if (getIntent() != null) {
            this.eKM.setIsInterviewLive(getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_INTERVIEW_LIVE, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bi(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gqp == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oT().oZ()) {
                    return false;
                }
                return pw(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eKM != null) {
            if (z && (!this.eqe || this.eLc)) {
                aRM();
            } else {
                hideLoadingView(this.eKM.getView());
            }
            this.eLc = false;
        }
    }

    private void aRu() {
        if (this.eKv == null) {
            this.eKv = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eKv.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eJX = PbActivity.this.eJX.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eJX);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eKK.aSH(), PbActivity.this.eJX, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eJX = PbActivity.this.eJX.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eJX);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eKK.aSH(), PbActivity.this.eJX, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eJX = PbActivity.this.eJX.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eJX);
                        bVar.dismiss();
                    }
                }
            }).cg(b.a.abA).ch(17).d(getPageContext());
        }
    }

    private void v(Bundle bundle) {
        this.eKK = new PbModel(this);
        this.eKK.a(this.eLH);
        if (this.eKK.aTf() != null) {
            this.eKK.aTf().a(this.eLV);
        }
        if (this.eKK.aTe() != null) {
            this.eKK.aTe().a(this.eLs);
        }
        if (this.eKK.aTh() != null) {
            this.eKK.aTh().b(this.eLo);
        }
        if (bundle != null) {
            this.eKK.initWithBundle(bundle);
        } else {
            this.eKK.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eKK.jc(true);
        }
        ag.aTO().O(this.eKK.aSF(), this.eKK.getIsFromMark());
        if (StringUtils.isNull(this.eKK.aSH())) {
            finish();
        } else {
            this.eKK.Fr();
        }
    }

    private void initData(Bundle bundle) {
        this.ent = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.ent != null) {
            this.ent.a(this.eLJ);
        }
        this.eKL = new ForumManageModel(this);
        this.eKL.setLoadDataCallBack(this.eLK);
        this.aoY = new com.baidu.tbadk.coreExtra.c.a(null);
        this.eKM.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eKK.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eKK.getPbData().aPU().getId(), PbActivity.this.eKK.getPbData().aPU().getName(), PbActivity.this.eKK.getPbData().aPW().getId(), valueOf, str, str2)));
            }
        });
        this.eLy.setUniqueId(getUniqueId());
        this.eLy.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eKM.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eLf;
        userMuteCheckCustomMessage.setTag(this.eLf);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aRv() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.eKK != null && (pbData = this.eKK.getPbData()) != null) {
            return pbData.aQg().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPW() != null) {
            if (fVar.aPW().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aPW().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aPW().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData bj(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.buT()) {
                postData.cP(postData.buS() - 1);
            } else {
                postData.cP(postData.buS() + 1);
            }
            postData.mF(!postData.buT());
            ((PbFloorAgreeView) view).a(postData.buT(), postData.buS(), true);
            final int i = postData.buT() ? 0 : 1;
            this.eKK.aTg().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pA(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).qa(i2);
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

    public com.baidu.tbadk.core.util.ak aRw() {
        return new com.baidu.tbadk.core.util.ak("c12003").ac("tid", this.eKK.eOn).r("obj_type", 0).ac(ImageViewerConfig.FORUM_ID, this.eKK.getForumId()).r("obj_param1", this.eKK.getPbData().aPW().getThreadType() == 40 ? 2 : 1);
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
                        PbActivity.this.aRs().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aRs().aUd() != null) {
                        PbActivity.this.eKZ.CU().setVisibility(8);
                        PbActivity.this.aRs().aUd().bC(str, str2);
                        if (PbActivity.this.eKR.aVo() == null && PbActivity.this.aRs().aUd().aSC().Du() != null) {
                            PbActivity.this.aRs().aUd().aSC().Du().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.eKR != null && PbActivity.this.eKR.aVn() != null) {
                                        if (!PbActivity.this.eKR.aVn().bCs()) {
                                            PbActivity.this.eKR.jB(false);
                                        }
                                        PbActivity.this.eKR.aVn().nr(false);
                                    }
                                }
                            });
                            PbActivity.this.eKR.g(PbActivity.this.aRs().aUd().aSC().Du().Dm());
                            PbActivity.this.aRs().aUd().aSC().a(PbActivity.this.eLb);
                        }
                    }
                    PbActivity.this.aRs().aUU();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.eKK != null && this.eKK.getPbData() != null && postData.buG() > 1) {
            String aSH = this.eKK.aSH();
            String id = postData.getId();
            int i = 0;
            if (this.eKK.getPbData() != null) {
                i = this.eKK.getPbData().aQh();
            }
            c px = px(id);
            if (px != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(aSH, id, "pb", true, null, false, null, i, postData.aWX(), this.eKK.getPbData().qf(), false, postData.rt() != null ? postData.rt().getIconInfo() : null).addBigImageData(px.eMv, px.eMw, px.eMx, px.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        am amVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (aRa() != null && aRa().getPbData() != null && aRa().getPbData().aQs() != null) {
                com.baidu.tieba.pb.data.l aQs = aRa().getPbData().aQs();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof am)) {
                    amVar = null;
                } else {
                    amVar = (am) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aQs != null) {
                    int i2 = -1;
                    if (z) {
                        aQs.pr(i);
                    } else if (aQs.aQB()) {
                        aQs.aQD();
                        i2 = 1;
                    } else {
                        aQs.ps(i);
                        i2 = 0;
                    }
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pA(int i3) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void a(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), customDialogData);
                        }
                    };
                    if (this.eKK != null && this.eKK.aTg() != null) {
                        String str = "";
                        if (this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null) {
                            str = this.eKK.getPbData().aPW().rK();
                        }
                        if (this.eKK.getPbData() != null) {
                            this.eKK.getPbData().a(aQs);
                        }
                        if (z) {
                            this.eKK.aTg().a(str, 3, i, this.eKK.getForumId(), aVar);
                        } else {
                            this.eKK.aTg().a(str, i2, 3, i, this.eKK.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.eHn = i2;
                            kVar.eHo = aQs;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (amVar != null) {
                        amVar.b(aQs);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aRx() {
        if (this.eKK.getPbData() == null || this.eKK.getPbData().aPW() == null) {
            return -1;
        }
        return this.eKK.getPbData().aPW().rY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRy() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.pX(this.eKK.getForumId()) && this.eKK.getPbData() != null && this.eKK.getPbData().aPU() != null) {
            if (this.eKK.getPbData().aPU().isLike() == 1) {
                aRN();
                this.eKK.aTj().bF(this.eKK.getForumId(), this.eKK.aSH());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iN(boolean z) {
        if (this.eKK == null || this.eKK.getPbData() == null) {
            return false;
        }
        return ((this.eKK.getPbData().aQh() != 0) || this.eKK.getPbData().aPW() == null || this.eKK.getPbData().aPW().rt() == null || TextUtils.equals(this.eKK.getPbData().aPW().rt().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aRz() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.p.q.GN()) {
            return "";
        }
        PostData aQd = aQd();
        if (this.eKK == null || (pbData = this.eKK.getPbData()) == null || pbData.getUserData() == null || pbData.aPW() == null || aQd == null || aQd.rt() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aQd.rt().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aPW().rb() == 0) {
            return "";
        }
        if (pbData.aPW().rb() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean iO(boolean z) {
        if (z) {
            return true;
        }
        if (this.eKK == null || this.eKK.getPbData() == null) {
            return false;
        }
        return this.eKK.getPbData().aQh() != 0;
    }

    private boolean iP(boolean z) {
        return (z || this.eKK == null || this.eKK.getPbData() == null || this.eKK.getPbData().aQh() == 0) ? false : true;
    }

    public void aRA() {
        if (this.eKK != null && this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null && this.eKK.getPbData().aPW().rt() != null) {
            if (this.eKM != null) {
                this.eKM.aUb();
            }
            bh aPW = this.eKK.getPbData().aPW();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aPW.rt().getUserId());
            aPW.rt().getGodUserData();
            z zVar = new z();
            int aQh = this.eKK.getPbData().aQh();
            if (aQh == 1) {
                zVar.eQj = true;
                zVar.eQi = true;
                zVar.eQq = aPW.ro() == 1;
                zVar.eQp = aPW.rp() == 1;
            } else {
                zVar.eQj = false;
                zVar.eQi = false;
            }
            if (aQh == 1002 && !equals) {
                zVar.eQu = true;
            }
            zVar.eQf = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            zVar.eQk = iO(equals);
            zVar.eQl = aRB();
            zVar.eQm = iP(equals);
            zVar.eQg = this.eKK.aSI();
            zVar.eQh = true;
            zVar.eHB = this.ent != null && this.ent.nC();
            zVar.eQe = iN(equals);
            zVar.eQs = aRz();
            zVar.eQd = equals && this.eKM.aUI();
            zVar.eQn = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.eQo = true;
            zVar.isHostOnly = this.eKK.getHostMode();
            zVar.eQr = true;
            if (aPW.rL() == null) {
                zVar.eQt = true;
            } else {
                zVar.eQt = false;
            }
            this.eKM.eRV.a(zVar);
        }
    }

    private boolean aRB() {
        if (this.eKK != null && this.eKK.aSI()) {
            return this.eKK.aua() == null || this.eKK.aua().qs() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(View view) {
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

    public int aRC() {
        if (aRs() == null || aRs().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aRs().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) fVar).mType == com.baidu.tieba.pb.data.j.eHj) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aRD() {
        if (aRs() == null || aRs().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aRs().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.gqn) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aEB();
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
                    PbActivity.this.aoY.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.eKK.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).th();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.eKM.aUB();
        this.eKK.jb(z);
        if (this.ent != null) {
            this.ent.ab(z);
            if (markData != null) {
                this.ent.a(markData);
            }
        }
        if (this.eKK.nC()) {
            aRJ();
        } else {
            this.eKM.o(this.eKK.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pv(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(String str) {
        if (!StringUtils.isNull(str) && this.eKK != null) {
            String aSH = this.eKK.aSH();
            String id = this.eKK.getPbData().aPU().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + aSH + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eKK.aSN()) {
                    antiData.setBlock_forum_name(this.eKK.getPbData().aPU().getName());
                    antiData.setBlock_forum_id(this.eKK.getPbData().aPU().getId());
                    antiData.setUser_name(this.eKK.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eKK.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.ua(i)) {
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
            ga(str);
        } else {
            this.eKM.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eKM.a(0, bVar.Al, bVar.gsD, z);
            if (bVar.Al) {
                if (bVar.gsB == 1) {
                    ArrayList<PostData> aPY = this.eKK.getPbData().aPY();
                    int size = aPY.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aPY.get(i).getId())) {
                            i++;
                        } else {
                            aPY.remove(i);
                            break;
                        }
                    }
                    this.eKM.o(this.eKK.getPbData());
                } else if (bVar.gsB == 0) {
                    aRE();
                } else if (bVar.gsB == 2) {
                    ArrayList<PostData> aPY2 = this.eKK.getPbData().aPY();
                    int size2 = aPY2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aPY2.get(i2).buD().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aPY2.get(i2).buD().get(i3).getId())) {
                                i3++;
                            } else {
                                aPY2.get(i2).buD().remove(i3);
                                aPY2.get(i2).buF();
                                z2 = true;
                                break;
                            }
                        }
                        aPY2.get(i2).sC(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eKM.o(this.eKK.getPbData());
                    }
                    a(bVar, this.eKM);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eKM.a(this.eKL.getLoadDataMode(), fVar.Al, fVar.gsD, false);
            if (fVar.Al) {
                this.eKO = true;
                if (i == 2 || i == 3) {
                    this.eKP = true;
                    this.eKQ = false;
                } else if (i == 4 || i == 5) {
                    this.eKP = false;
                    this.eKQ = true;
                }
                if (i == 2) {
                    this.eKK.getPbData().aPW().bT(1);
                    this.eKK.setIsGood(1);
                } else if (i == 3) {
                    this.eKK.getPbData().aPW().bT(0);
                    this.eKK.setIsGood(0);
                } else if (i == 4) {
                    this.eKK.getPbData().aPW().bS(1);
                    this.eKK.ir(1);
                } else if (i == 5) {
                    this.eKK.getPbData().aPW().bS(0);
                    this.eKK.ir(0);
                }
                this.eKM.c(this.eKK.getPbData(), this.eKK.aSI());
                if (this.eKK.getPbData().aQh() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void aRE() {
        if (this.eKK.aSJ() || this.eKK.aSL()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eKK.aSH());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eKK.aSH()));
        if (aRK()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRF() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aQe;
        boolean z = true;
        if (this.eKM != null) {
            this.eKM.aEU();
        }
        if (this.eKK != null && this.eKK.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eKK.getPbData().aPW().getId();
            historyMessage.forumName = this.eKK.getPbData().aPU().getName();
            historyMessage.threadName = this.eKK.getPbData().aPW().getTitle();
            ArrayList<PostData> aPY = this.eKK.getPbData().aPY();
            int aUD = this.eKM != null ? this.eKM.aUD() : 0;
            if (aPY != null && aUD >= 0 && aUD < aPY.size()) {
                historyMessage.postID = aPY.get(aUD).getId();
            }
            historyMessage.isHostOnly = this.eKK.getHostMode();
            historyMessage.isSquence = this.eKK.aSI();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eKZ != null) {
            this.eKZ.onDestroy();
        }
        if (this.eKt && aRs() != null) {
            aRs().aVh();
        }
        if (this.eKK != null && (this.eKK.aSJ() || this.eKK.aSL())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eKK.aSH());
            if (this.eKO) {
                if (this.eKQ) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eKK.aEL());
                }
                if (this.eKP) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eKK.getIsGood());
                }
            }
            if (this.eKK.getPbData() != null && System.currentTimeMillis() - this.eKx >= 40000 && (aQe = this.eKK.getPbData().aQe()) != null && !com.baidu.tbadk.core.util.v.v(aQe.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aQe);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eLm);
            }
            setResult(-1, intent);
        }
        if (aRK()) {
            if (this.eKK != null && this.eKM != null && this.eKM.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eKK.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aQc() && !this.eKD) {
                        ag aTO = ag.aTO();
                        com.baidu.tieba.pb.data.f pbData2 = this.eKK.getPbData();
                        Parcelable onSaveInstanceState = this.eKM.getListView().onSaveInstanceState();
                        boolean aSI = this.eKK.aSI();
                        boolean hostMode = this.eKK.getHostMode();
                        if (this.eKM.aUm() == null || this.eKM.aUm().getVisibility() != 0) {
                            z = false;
                        }
                        aTO.a(pbData2, onSaveInstanceState, aSI, hostMode, z);
                        if (this.eLl >= 0 || this.eKK.aTp() != null) {
                            ag.aTO().j(this.eKK.aTp());
                            ag.aTO().i(this.eKK.aTq());
                            ag.aTO().pN(this.eKK.aTr());
                        }
                    }
                }
            } else {
                ag.aTO().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eKM == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eKM.pQ(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean px(int i) {
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
        this.eKZ.onActivityResult(i, i2, intent);
        if (this.eKH != null) {
            this.eKH.onActivityResult(i, i2, intent);
        }
        if (aRs().aUd() != null) {
            aRs().aUd().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aRI();
                    return;
                case 13008:
                    ag.aTO().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eKK != null) {
                                PbActivity.this.eKK.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eKK != null) {
                        a(aRH(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aRx() == 1) {
                        aRG();
                    }
                    intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aRy();
                        return;
                    }
                    return;
                case 24008:
                    this.eKM.iL(false);
                    if (this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null && this.eKK.getPbData().aPW().rO() != null) {
                        this.eKK.getPbData().aPW().rO().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.eKM != null && this.eKM.eRV != null) {
                        this.eKM.eRV.om();
                        this.eKM.eRV.aWd();
                        if (this.eKK != null && this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null) {
                            this.eKK.getPbData().aPW().bO(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.eKI != null) {
                        this.eKM.bp(this.eKI);
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
                if (intent != null && aRs() != null && aRn() != null && aRs().aUf() && com.baidu.tbadk.editortools.pb.a.Dp().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Dp().setStatus(0);
                    if (this.eKM != null) {
                        this.eKM.aUe();
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
            if (this.eKH == null) {
                this.eKH = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eKH.b(this.aDn);
                this.eKH.c(this.aDw);
            }
            this.eKH.a(emotionImageData, aRa(), aRa().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRG() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null && this.eKK.getPbData().aPW().rF() != null && this.eKK.getPbData().aPW().rF().size() > 0 && this.eKK.getPbData().aPW().rF().get(0) != null) {
            this.mAwardActId = this.eKK.getPbData().aPW().rF().get(0).pn();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eKK.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void R(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    pz(2);
                    return;
                case 2:
                    this.eKM.aUt();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aRH() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bK = this.eKK.getPbData().bK(getPageContext().getPageActivity());
        PostData aUg = this.eKM.aUg();
        String str = "";
        if (aUg != null) {
            str = aUg.getId();
            String bX = aUg.bX(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(bX)) {
                bK[1] = bX;
            }
        }
        String rK = this.eKK.getPbData().aPW().rK();
        if (rK != null && rK.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bK[1]);
        shareFromPBMsgData.setImageUrl(bK[0]);
        shareFromPBMsgData.setForumName(this.eKK.getPbData().aPU().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eKK.getPbData().aPW().getId());
        shareFromPBMsgData.setTitle(this.eKK.getPbData().aPW().getTitle());
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(aRH(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eKK != null && this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(getPageContext().getPageActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ac = new com.baidu.tbadk.core.util.ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getForumId()).ac("tid", PbActivity.this.eKK.aSH());
                        if (PbActivity.this.e(PbActivity.this.eKK.getPbData()) != 0) {
                            ac.r("obj_type", PbActivity.this.e(PbActivity.this.eKK.getPbData()));
                        }
                        TiebaStatic.log(ac);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aRx() == 1) {
                        PbActivity.this.aRG();
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
                kVar.G(shareFromPBMsgData.getImageUrl(), this.eKK.getPbData().aQi() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eKK != null && this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null) {
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
                    if (PbActivity.this.aRx() == 1) {
                        PbActivity.this.aRG();
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
                kVar.G(shareFromPBMsgData.getImageUrl(), this.eKK.getPbData().aQi() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRI() {
        MarkData pL;
        if (this.ent != null && (pL = this.eKK.pL(this.eKM.aUE())) != null) {
            if (!pL.isApp() || (pL = this.eKK.pL(this.eKM.aUE() + 1)) != null) {
                this.eKM.aUz();
                this.ent.a(pL);
                if (!this.ent.nC()) {
                    this.ent.nE();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.ent.nD();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRJ() {
        com.baidu.tieba.pb.data.f pbData = this.eKK.getPbData();
        this.eKK.jb(true);
        if (this.ent != null) {
            pbData.pq(this.ent.nB());
        }
        this.eKM.o(pbData);
    }

    private boolean aRK() {
        if (this.eKK == null) {
            return true;
        }
        if (this.eKK.nC()) {
            final MarkData aSV = this.eKK.aSV();
            if (aSV == null || !this.eKK.getIsFromMark()) {
                return true;
            }
            final MarkData pL = this.eKK.pL(this.eKM.aUD());
            if (pL == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aSV);
                setResult(-1, intent);
                return true;
            } else if (pL.getPostId() == null || pL.getPostId().equals(aSV.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aSV);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cS(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.ent != null) {
                            if (PbActivity.this.ent.nC()) {
                                PbActivity.this.ent.nD();
                                PbActivity.this.ent.ab(false);
                            }
                            PbActivity.this.ent.a(pL);
                            PbActivity.this.ent.ab(true);
                            PbActivity.this.ent.nE();
                        }
                        aSV.setPostId(pL.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aSV);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aRF();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aSV);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aRF();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eKM != null && PbActivity.this.eKM.getView() != null) {
                            PbActivity.this.eKM.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aSV);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aRF();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.th();
                return false;
            }
        } else if (this.eKK.getPbData() == null || this.eKK.getPbData().aPY() == null || this.eKK.getPbData().aPY().size() <= 0 || !this.eKK.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eKM == null) {
            return null;
        }
        return this.eKM.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Jy() {
        if (this.eKM == null) {
            return 0;
        }
        return this.eKM.aUM();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Jz() {
        if (this.aSu == null) {
            this.aSu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Xd */
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
        return this.aSu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> JA() {
        if (this.aSv == null) {
            this.aSv = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aSv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> JB() {
        if (this.aSz == null) {
            this.aSz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aSf */
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
        return this.aSz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> JC() {
        if (this.aSw == null) {
            this.aSw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aEC */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aR */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aS */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aT */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aSw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> JE() {
        this.aSy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aSg */
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
        return this.aSy;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aox == null) {
            this.aox = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aox;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eKB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        if (au.pH(str) && this.eKK != null && this.eKK.aSH() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").r("obj_param1", 1).ac("post_id", this.eKK.aSH()));
        }
        au.aVp().f(getPageContext(), str);
        this.eKB = true;
    }

    private com.baidu.tbadk.core.dialog.a aRL() {
        if (this.eKw == null) {
            this.eKw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eKw.cR(getPageContext().getString(d.j.download_baidu_video_dialog));
            this.eKw.a(getPageContext().getString(d.j.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
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
            this.eKw.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eKw.ao(true);
            this.eKw.b(getPageContext());
            this.eKw.ap(false);
        }
        this.eKw.th();
        return this.eKw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        au.aVp().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eKB = true;
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
            aRL();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eKB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eKK.getPbData();
            TbRichText as = as(str, i);
            if (as != null && (tbRichTextData = as.IT().get(this.eLO)) != null) {
                cVar.eMv = new ArrayList<>();
                cVar.eMw = new ConcurrentHashMap<>();
                if (!tbRichTextData.IZ().Jl()) {
                    cVar.eMy = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    cVar.eMv.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = as.getPostId();
                    imageUrlData.mIsReserver = this.eKK.aSU();
                    imageUrlData.mIsSeeHost = this.eKK.getHostMode();
                    cVar.eMw.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aPU() != null) {
                            cVar.forumName = pbData.aPU().getName();
                            cVar.forumId = pbData.aPU().getId();
                        }
                        if (pbData.aPW() != null) {
                            cVar.threadId = pbData.aPW().getId();
                        }
                        cVar.eMx = pbData.aQi() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.eMy = true;
                int size = pbData.aPY().size();
                this.eLP = false;
                cVar.index = -1;
                if (pbData.aQd() != null) {
                    PostData aQd = pbData.aQd();
                    TbRichText aEx = aQd.aEx();
                    if (!ao.k(aQd)) {
                        i2 = a(aEx, as, i, i, cVar.eMv, cVar.eMw);
                    } else {
                        i2 = a(aQd, i, cVar.eMv, cVar.eMw);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aPY().get(i4);
                    if (postData.getId() == null || pbData.aQd() == null || pbData.aQd().getId() == null || !postData.getId().equals(pbData.aQd().getId())) {
                        TbRichText aEx2 = postData.aEx();
                        if (!ao.k(postData)) {
                            i3 = a(aEx2, as, i3, i, cVar.eMv, cVar.eMw);
                        } else {
                            i3 = a(postData, i3, cVar.eMv, cVar.eMw);
                        }
                    }
                }
                if (cVar.eMv.size() > 0) {
                    cVar.lastId = cVar.eMv.get(cVar.eMv.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aPU() != null) {
                        cVar.forumName = pbData.aPU().getName();
                        cVar.forumId = pbData.aPU().getId();
                    }
                    if (pbData.aPW() != null) {
                        cVar.threadId = pbData.aPW().getId();
                    }
                    cVar.eMx = pbData.aQi() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IZ() == null) {
            return null;
        }
        return tbRichTextData.IZ().Jp();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IZ() == null) {
            return 0L;
        }
        return tbRichTextData.IZ().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IZ() == null) {
            return false;
        }
        return tbRichTextData.IZ().Jq();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IZ() == null) {
            return false;
        }
        return tbRichTextData.IZ().Jr();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo IZ;
        if (tbRichText == tbRichText2) {
            this.eLP = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.IT().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.IT().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int af = (int) com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.IZ().getWidth() * af;
                    int height = af * tbRichTextData.IZ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.IZ().Jl()) {
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
                            if (tbRichTextData != null && (IZ = tbRichTextData.IZ()) != null) {
                                String Jn = IZ.Jn();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = Jn;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eKK.aSH(), -1L);
                                imageUrlData.mIsReserver = this.eKK.aSU();
                                imageUrlData.mIsSeeHost = this.eKK.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eLP) {
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
        com.baidu.tieba.tbadkCore.data.h buO;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bum;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bum = (buO = postData.buO()).bum()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bum.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bum.get(i3);
                if (jVar != null) {
                    String buq = jVar.buq();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(buq)) {
                        arrayList.add(buq);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = buq;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bup();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eKK.aSH(), -1L);
                        imageUrlData.mIsReserver = this.eKK.aSU();
                        imageUrlData.mIsSeeHost = this.eKK.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = buO.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(buq, imageUrlData);
                        }
                        if (!this.eLP) {
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
            if (postData.getId() != null && postData.getId().equals(this.eKK.rD())) {
                z = true;
            }
            MarkData h = this.eKK.h(postData);
            if (h != null) {
                this.eKM.aUz();
                if (this.ent != null) {
                    this.ent.a(h);
                    if (!z) {
                        this.ent.nE();
                    } else {
                        this.ent.nD();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText as(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eKK == null || this.eKK.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eKK.getPbData();
        if (pbData.aQd() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aQd());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aPY = pbData.aPY();
            a(pbData, aPY);
            return a(aPY, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aQg() != null && fVar.aQg().eHD != null && (list = fVar.aQg().eHD) != null && arrayList != null) {
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

    private long pv(String str) {
        ArrayList<PostData> aPY;
        com.baidu.tieba.pb.data.f pbData = this.eKK.getPbData();
        if (pbData != null && (aPY = pbData.aPY()) != null && !aPY.isEmpty()) {
            Iterator<PostData> it = aPY.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h buO = next.buO();
                if (buO != null && buO.gpV) {
                    Iterator<TbRichTextData> it2 = next.aEx().IT().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Ji().getLink().equals(str)) {
                            return buO.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> IT;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText aEx = arrayList.get(i2).aEx();
            if (aEx != null && (IT = aEx.IT()) != null) {
                int size = IT.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (IT.get(i4) != null && IT.get(i4).getType() == 8) {
                        i3++;
                        if (IT.get(i4).IZ().Jn().equals(str)) {
                            int af = (int) com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
                            int width = IT.get(i4).IZ().getWidth() * af;
                            int height = IT.get(i4).IZ().getHeight() * af;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eLO = i4;
                            return aEx;
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
            this.eJX = str;
            if (this.eKv == null) {
                aRu();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eKv.ck(1).setVisibility(8);
            } else {
                this.eKv.ck(1).setVisibility(0);
            }
            this.eKv.tl();
            this.eKB = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cxT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEB() {
        hideNetRefreshView(this.eKM.getView());
        aRM();
        if (this.eKK.Fr()) {
            this.eKM.aUz();
        }
    }

    private void aRM() {
        showLoadingView(this.eKM.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View EM = getLoadingView().EM();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EM.getLayoutParams();
        layoutParams.addRule(3, this.eKM.aUZ().getId());
        EM.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajy() {
        if (this.cxT != null) {
            this.cxT.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void py(int i) {
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
    public void pz(int i) {
        boolean z;
        String str;
        Uri parse;
        if (this.eKK.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eKK.getPbData();
            pbData.aPU().getName();
            String title = pbData.aPW().getTitle();
            int i2 = this.eKK.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aPU() != null) {
                if ((pbData.aPU().isLike() == 1) && AddExperiencedModel.pX(pbData.getForumId())) {
                    z = true;
                    String str2 = "http://tieba.baidu.com/p/" + this.eKK.aSH() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bK = pbData.bK(getPageContext().getPageActivity());
                    str = bK[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    String str3 = bK[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aRx() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                    } else if (aRx() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                    }
                    String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str3);
                    final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
                    dVar.title = title;
                    dVar.content = format;
                    dVar.linkUrl = str2;
                    dVar.atQ = true;
                    dVar.atU = z;
                    dVar.extData = this.eKK.aSH();
                    dVar.auf = 3;
                    dVar.aue = i;
                    dVar.fid = this.eKK.getForumId();
                    dVar.Xl = this.eKK.aSH();
                    dVar.aug = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.atZ = parse;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.auf);
                    bundle.putInt("obj_type", dVar.aug);
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
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10125").ac("tid", PbActivity.this.eKK.aSH()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eKK.getForumId()).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
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
                            if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aQt()) {
                                PbActivity.this.eKM.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
                }
            }
            z = false;
            String str22 = "http://tieba.baidu.com/p/" + this.eKK.aSH() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bK2 = pbData.bK(getPageContext().getPageActivity());
            str = bK2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            String str32 = bK2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aRx() != 1) {
            }
            String format2 = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str32);
            final com.baidu.tbadk.coreExtra.d.d dVar2 = new com.baidu.tbadk.coreExtra.d.d();
            dVar2.title = title;
            dVar2.content = format2;
            dVar2.linkUrl = str22;
            dVar2.atQ = true;
            dVar2.atU = z;
            dVar2.extData = this.eKK.aSH();
            dVar2.auf = 3;
            dVar2.aue = i;
            dVar2.fid = this.eKK.getForumId();
            dVar2.Xl = this.eKK.aSH();
            dVar2.aug = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.auf);
            bundle2.putInt("obj_type", dVar2.aug);
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
                    if (PbActivity.this.eKK != null && PbActivity.this.eKK.getPbData() != null && PbActivity.this.eKK.getPbData().aQt()) {
                        PbActivity.this.eKM.getView().setSystemUiVisibility(4);
                    }
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPW() != null) {
            if (fVar.aPW().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aPW().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void aRN() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pY(PbActivity.this.eKK.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eKM.aVi();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.anG == null) {
                this.anG = new ShareReportModel(getPageContext());
            }
            this.anG.j(shareItem.fid, shareItem.Xl, shareItem.atW);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> JD() {
        if (this.aSx == null) {
            this.aSx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aSh */
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
        return this.aSx;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eKM.aUu() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, this.eKK.getPbData().getForumId()));
            } else {
                bh aPW = this.eKK.getPbData().aPW();
                if (view != null) {
                    boolean z = aPW.ri() == null || aPW.ri().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eLz > 1000) {
                            this.eLA = true;
                            bl(view);
                        } else {
                            this.eLA = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            m(view, this.eLA);
                        } else {
                            l(view, this.eLA);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        l(view, this.eLA);
                    } else if (motionEvent.getAction() == 3) {
                        l(view, this.eLA);
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
                    PbActivity.this.eLz = System.currentTimeMillis();
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
                    PbActivity.this.eLz = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bl(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    public void ajz() {
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
            int intValue = ((Integer) sparseArray.get(ap.eTM)).intValue();
            if (intValue == ap.eTN) {
                if (!this.eKL.bvs()) {
                    this.eKM.aUw();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.eKL.a(this.eKK.getPbData().aPU().getId(), this.eKK.getPbData().aPU().getName(), this.eKK.getPbData().aPW().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ap.eTO || intValue == ap.eTQ) {
                if (this.eKK.aTf() != null) {
                    this.eKK.aTf().pD(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ap.eTO) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ap.eTP) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eLU).pi()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eLf);
        userMuteAddAndDelCustomMessage.setTag(this.eLf);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pw(String str) {
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

    public void iQ(boolean z) {
        this.eKU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aRO() {
        ArrayList<PostData> aPY;
        int u;
        if (this.eKK == null || this.eKK.getPbData() == null || this.eKK.getPbData().aPY() == null || (u = com.baidu.tbadk.core.util.v.u((aPY = this.eKK.getPbData().aPY()))) == 0) {
            return "";
        }
        if (this.eKK.aSU()) {
            Iterator<PostData> it = aPY.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.buG() == 1) {
                    return next.getId();
                }
            }
        }
        int aUD = this.eKM.aUD();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aPY, aUD);
        if (postData == null || postData.rt() == null) {
            return "";
        }
        if (this.eKK.pA(postData.rt().getUserId())) {
            return postData.getId();
        }
        for (int i = aUD - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aPY, i);
            if (postData2 == null || postData2.rt() == null || postData2.rt().getUserId() == null) {
                break;
            } else if (this.eKK.pA(postData2.rt().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aUD + 1; i2 < u; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aPY, i2);
            if (postData3 == null || postData3.rt() == null || postData3.rt().getUserId() == null) {
                return "";
            }
            if (this.eKK.pA(postData3.rt().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (av.vI().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(pv(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eKK.getPbData().aPU().getId(), this.eKK.getPbData().aPU().getName(), this.eKK.getPbData().aPW().getTid());
            }
            this.eKB = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eKK.aTe() != null) {
                    PbActivity.this.eKK.aTe().co(j);
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
    public c px(String str) {
        String str2;
        if (this.eKK.getPbData() == null || this.eKK.getPbData().aPY() == null || this.eKK.getPbData().aPY().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.eKK.getPbData().aPY().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eKK.getPbData().aPY().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eKK.getPbData().aPY().get(i);
        if (postData.aEx() == null || postData.aEx().IT() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aEx().IT().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.IZ() != null) {
                    str2 = next.IZ().Jn();
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
        if (this.eKr) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eKr = false;
        } else if (aRP()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eKr) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eKr = false;
        } else if (aRP()) {
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
        if (pageStayDurationItem != null && this.eKK != null) {
            if (this.eKK.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eKK.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eKK.aSH(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aRP() {
        return (!this.eKp && this.eLW == -1 && this.eLX == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eLZ = nVar;
            this.eKp = true;
            this.eKM.aUn();
            this.eKM.pF(this.eLY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRQ() {
        if (this.eLZ != null) {
            if (this.eLW == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eLZ.getCartoonId(), this.eLW, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRR() {
        if (this.eLZ != null) {
            if (this.eLX == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eLZ.getCartoonId(), this.eLX, 0)));
                finish();
            }
        }
    }

    public int aRS() {
        return this.eLW;
    }

    public int aRT() {
        return this.eLX;
    }

    private void atv() {
        if (this.eKK != null && this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null && this.eKK.getPbData().aPW().sh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aRU() {
        if (this.eKK != null && this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null && this.eKK.getPbData().aPW().sh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aRV() {
        if (this.eKs) {
            this.eKG = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null && this.eKK.getPbData().aPW().qZ() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eKK.getPbData().aPW().qZ().getThreadId(), this.eKK.getPbData().aPW().qZ().getTaskId(), this.eKK.getPbData().aPW().qZ().getForumId(), this.eKK.getPbData().aPW().qZ().getForumName(), this.eKK.getPbData().aPW().ro(), this.eKK.getPbData().aPW().rp())));
            this.eKr = true;
            finish();
        }
    }

    public boolean aRW() {
        return this.eKs;
    }

    public String aRX() {
        return this.eKE;
    }

    public PbInterviewStatusView.a aRY() {
        return this.eKJ;
    }

    public void iR(boolean z) {
        this.eKF = z;
    }

    public boolean aRZ() {
        if (this.eKK != null) {
            return this.eKK.aSJ();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSa() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eLd).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eLd.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eLd).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eLd != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eLd.getPageActivity());
            aVar.cS(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eLd).th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eKM.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eLd.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cS(this.eLd.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eKM.showLoadingDialog();
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
        aVar.b(this.eLd).th();
    }

    public void aSb() {
        if (this.eKK != null && this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null && this.eKK.getPbData().aPW().sz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cc(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eKK.getPbData().aPW().sz().channelId, true, PbActivity.this.getUniqueId())));
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
                if (au.pH(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.eKM != null) {
            this.eKM.onConfigurationChanged(configuration);
        }
        if (this.eKS != null) {
            this.eKS.dismiss();
        }
    }

    public boolean aSc() {
        if (this.eKK != null) {
            return this.eKK.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ap apVar) {
        boolean z;
        List<PostData> list = this.eKK.getPbData().aQg().eHD;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).buD().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).buD().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).buD().remove(i2);
                    list.get(i).buF();
                    z = true;
                    break;
                }
            }
            list.get(i).sC(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            apVar.o(this.eKK.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aQG().getId();
        List<PostData> list = this.eKK.getPbData().aQg().eHD;
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
                ArrayList<PostData> aQK = mVar.aQK();
                postData.tU(mVar.getTotalCount());
                if (postData.buD() != null) {
                    postData.buD().clear();
                    postData.buD().addAll(aQK);
                }
            }
        }
        if (!this.eKK.getIsFromMark()) {
            this.eKM.o(this.eKK.getPbData());
        }
    }

    public boolean aSd() {
        boolean z = true;
        if (this.eKK == null) {
            return false;
        }
        switch (this.eKK.aTn()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eKK.getPbData() != null && this.eKK.getPbData().aPW() != null && this.eKK.getPbData().aPW().sH()) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aSe() {
        if (this.eKM != null) {
            this.eKM.aUb();
            ajz();
        }
    }

    public PostData aQd() {
        return this.eKM.b(this.eKK.eOE, this.eKK.aSI());
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
        if (this.eLn != null && !this.eLn.isEmpty()) {
            int size = this.eLn.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.eLn.get(i).onBackPressed()) {
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
            if (this.eLn == null) {
                this.eLn = new ArrayList();
            }
            if (!this.eLn.contains(aVar)) {
                this.eLn.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.eLn != null) {
            this.eLn.remove(aVar);
        }
    }
}
