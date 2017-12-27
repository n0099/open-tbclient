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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.i;
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
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbFloorAgreeModel;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.a.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.main.z;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e {
    private com.baidu.adp.lib.e.b<ImageView> bJo;
    private com.baidu.adp.lib.e.b<TextView> bJp;
    private com.baidu.adp.lib.e.b<View> bJq;
    private com.baidu.adp.lib.e.b<LinearLayout> bJr;
    private com.baidu.adp.lib.e.b<RelativeLayout> bJs;
    private com.baidu.adp.lib.e.b<GifView> bJt;
    private com.baidu.tieba.d.c bbW;
    private com.baidu.adp.lib.e.b<TbImageView> bcT;
    private com.baidu.tieba.e.b ckD;
    private VoiceManager dwG;
    private com.baidu.tieba.pb.pb.main.a.b fFE;
    private com.baidu.tbadk.core.dialog.a fFK;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fFV;
    private View fFW;
    private String fFm;
    private List<a> fGB;
    public au fGe;
    private y fGf;
    private boolean fGh;
    private com.baidu.tieba.tbadkCore.data.e fGk;
    private com.baidu.tbadk.editortools.pb.g fGl;
    private com.baidu.tbadk.editortools.pb.d fGm;
    private com.baidu.adp.base.e fGr;
    private com.baidu.tbadk.core.view.d fGs;
    private BdUniqueId fGt;
    private Runnable fGu;
    private aw fGv;
    private com.baidu.adp.widget.a.a fGw;
    private String fGx;
    private TbRichTextMemeInfo fGy;
    private boolean fHc;
    private String fHo;
    private com.baidu.tbadk.core.data.m fHp;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private boolean fFD = false;
    private boolean fFF = false;
    private boolean fFG = false;
    private boolean fje = false;
    private boolean fFH = true;
    private int fFI = 0;
    private com.baidu.tbadk.core.dialog.b fFJ = null;
    private long dhW = -1;
    private long byn = 0;
    private long fFL = 0;
    private long createTime = 0;
    private long byf = 0;
    private boolean fFM = false;
    private com.baidu.tbadk.k.d fFN = null;
    private long fFO = 0;
    private boolean fFP = false;
    private long fFQ = 0;
    private String brF = null;
    private boolean fFR = false;
    private boolean isFullScreen = false;
    private String fFS = "";
    private boolean fFT = true;
    private boolean fFU = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fFX = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void W(boolean z) {
            PbActivity.this.fFZ.kr(!PbActivity.this.fFT);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fFY != null && PbActivity.this.fFY.vk()) {
                        PbActivity.this.bau();
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", ap.a.aVZ));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", ap.a.aVZ));
        }
    };
    private PbModel fFY = null;
    private com.baidu.tbadk.baseEditMark.a fgs = null;
    private ForumManageModel cQq = null;
    private com.baidu.tbadk.coreExtra.model.a bdv = null;
    private ShareSuccessReplyToServerModel dJg = null;
    private as fFZ = null;
    public final com.baidu.tieba.pb.pb.main.a.a fGa = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean fGb = false;
    private boolean fGc = false;
    private boolean fGd = false;
    private boolean fGg = false;
    private boolean fGi = false;
    private boolean fGj = false;
    private boolean fGn = false;
    public boolean fGo = false;
    private com.baidu.tbadk.editortools.pb.c brI = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Lc() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b brJ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lb() {
            if (PbActivity.this.fGe == null || PbActivity.this.fGe.bek() == null || !PbActivity.this.fGe.bek().bLo()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fGe.bek().bLq());
            if (PbActivity.this.fGm != null && (PbActivity.this.fGm.Lq() || PbActivity.this.fGm.Lr())) {
                PbActivity.this.fGm.a(false, PbActivity.this.fGe.ben());
            }
            PbActivity.this.fGe.kC(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fGp = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lb() {
            if (PbActivity.this.fGe == null || PbActivity.this.fGe.bel() == null || !PbActivity.this.fGe.bel().bLo()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fGe.bel().bLq());
            if (PbActivity.this.fFZ != null && PbActivity.this.fFZ.bda() != null && PbActivity.this.fFZ.bda().bbs() != null && PbActivity.this.fFZ.bda().bbs().Lr()) {
                PbActivity.this.fFZ.bda().bbs().a(PbActivity.this.fGe.ben());
            }
            PbActivity.this.fGe.kD(true);
            return true;
        }
    };
    private boolean fGq = false;
    private int mLastScrollState = -1;
    private boolean dxm = false;
    private int fGz = 0;
    private int fGA = -1;
    private final a fGC = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fFZ != null && PbActivity.this.fFZ.bda() != null) {
                s bda = PbActivity.this.fFZ.bda();
                if (bda.bbo()) {
                    bda.bbn();
                    return true;
                }
            }
            if (PbActivity.this.fFZ != null && PbActivity.this.fFZ.bdR()) {
                PbActivity.this.fFZ.bdS();
                return true;
            }
            return false;
        }
    };
    private final z.a fGD = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void L(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void i(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fFZ.showToast(str);
            }
        }
    };
    private final CustomMessageListener fGE = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fFY != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fGm != null) {
                    PbActivity.this.fFZ.kw(PbActivity.this.fGm.Lj());
                }
                PbActivity.this.fFZ.bdb();
                PbActivity.this.fFZ.bdK();
            }
        }
    };
    CustomMessageListener dxE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                PbActivity.this.fFY.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                if (PbActivity.this.fFZ != null && PbActivity.this.fFY != null) {
                    PbActivity.this.fFZ.d(PbActivity.this.fFY.getPbData(), PbActivity.this.fFY.bbC(), PbActivity.this.fFY.getRequestType());
                }
                if (PbActivity.this.fFZ != null && PbActivity.this.fFZ.bdr() != null) {
                    PbActivity.this.fFZ.bdr().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fGF = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fFZ != null) {
                    if (booleanValue) {
                        PbActivity.this.fFZ.aIx();
                    } else {
                        PbActivity.this.fFZ.aIw();
                    }
                }
            }
        }
    };
    private CustomMessageListener fGG = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fGm != null) {
                    PbActivity.this.fFZ.kw(PbActivity.this.fGm.Lj());
                }
                PbActivity.this.fFZ.ky(false);
            }
        }
    };
    private CustomMessageListener fGH = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
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
    private CustomMessageListener fGI = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fFZ != null && PbActivity.this.fFZ.bdr() != null) {
                PbActivity.this.fFZ.bdr().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener eqX = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private j.a fGJ = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.sM(2);
                aj.bcJ().reset();
                PbActivity.this.fFY.bbU();
                boolean z2 = false;
                ArrayList<PostData> aYC = PbActivity.this.fFY.getPbData().aYC();
                if (aYC != null) {
                    Iterator<PostData> it = aYC.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ar.k(next) && next.bCv().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fFZ.p(PbActivity.this.fFY.getPbData());
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
    private View.OnClickListener bsq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.brF);
        }
    };
    private CustomMessageListener fGK = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                an.a aVar = new an.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.aLt = yVar.aLt;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fFY.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fFY.bbL() != null && PbActivity.this.fFY.bbL().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fFZ.a(yVar.sendCount, PbActivity.this.fFY.getPbData(), PbActivity.this.fFY.bbC(), PbActivity.this.fFY.getRequestType());
                    }
                    if (pbData.aYC() != null && pbData.aYC().size() >= 1 && pbData.aYC().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aYC().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.fFY.bbB(), 0L);
                        if (c2 == yVar.postId && c3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.an bCu = pbData.aYC().get(0).bCu();
                            if (bCu == null) {
                                bCu = new com.baidu.tbadk.core.data.an();
                            }
                            ArrayList<an.a> ya = bCu.ya();
                            if (ya == null) {
                                ya = new ArrayList<>();
                            }
                            ya.add(0, aVar);
                            bCu.eM(yVar.sendCount + bCu.xZ());
                            bCu.h(ya);
                            pbData.aYC().get(0).a(bCu);
                            PbActivity.this.fFZ.bdr().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a fGL = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.apm() != null && !aVar.apm().isEmpty()) {
                    PbActivity.this.fFZ.a(aVar, PbActivity.this.fGN);
                }
                PbActivity.this.fFZ.a(aVar, PbActivity.this.fFY.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.beq()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fGM = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void L(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.G(list) && PbActivity.this.fFZ != null) {
                PbActivity.this.fFZ.cW(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fGN = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                com.baidu.tbadk.core.util.ax.be(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.nl().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14.1
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
    private boolean fGO = false;
    private PraiseModel fGP = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hY(String str) {
            PbActivity.this.fGO = false;
            if (PbActivity.this.fGP != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fFY.getPbData();
                if (pbData.aYA().yM().getIsLike() == 1) {
                    PbActivity.this.nz(0);
                } else {
                    PbActivity.this.nz(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aYA()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void E(int i, String str) {
            PbActivity.this.fGO = false;
            if (PbActivity.this.fGP != null && str != null) {
                if (AntiHelper.xo(i)) {
                    AntiHelper.ap(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fGQ = 0;
    private boolean fGR = true;
    private b.a fGS = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jM(boolean z) {
            PbActivity.this.jL(z);
            if (PbActivity.this.fFZ.bdX() != null && z) {
                PbActivity.this.fFZ.kr(false);
            }
            PbActivity.this.fFZ.kt(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().bgt != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().bgt, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", ap.a.aVZ));
                        }
                    } else if (updateAttentionMessage.getData().apO) {
                        if (PbActivity.this.aYI().yX() != null && PbActivity.this.aYI().yX().getGodUserData() != null) {
                            PbActivity.this.aYI().yX().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYA() != null && PbActivity.this.fFY.getPbData().aYA().yX() != null) {
                            PbActivity.this.fFY.getPbData().aYA().yX().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cvY = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fFZ.afk();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.sN(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.aAm();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bJy = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (PbActivity.this.fFZ.bdc()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fFY != null && (PbActivity.this.fFY.getPbData() != null || PbActivity.this.fFY.getPbData().aYY() != null)) {
                    if (PbActivity.this.fFY.getPbData().aYY().aZj()) {
                        if (PbActivity.this.fFY.getPbData().aYY().fCF == 1 || PbActivity.this.fFY.getPbData().aYY().fCF == 3 || PbActivity.this.fFY.getPbData().aYY().fCF == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fFY.getPbData().aYY().aZj() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fFY.getPbData().aYY().aZj() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fFQ > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).kY(false);
                        PbActivity.this.fFQ = System.currentTimeMillis();
                    }
                }
            }
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean e(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == d.g.richText) {
                    if (PbActivity.this.co(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.fFZ != null && PbActivity.this.fFZ.bae() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ab("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.fGa != null && PbActivity.this.fGa.fSS != null) {
                            PbActivity.this.fGa.fSS.onClick(view);
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
            if (PbActivity.this.fGm != null) {
                PbActivity.this.fFZ.kw(PbActivity.this.fGm.Lj());
            }
            PbActivity.this.fFZ.bdb();
            PbActivity.this.fFZ.bdK();
            return true;
        }
    });
    private CustomMessageListener fGT = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fGt) {
                PbActivity.this.fFZ.afk();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fFY.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aYP().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fGs.q(PbActivity.this.fGr.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fGr.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gj(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.baM();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fGr.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.fGs.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fGU = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fGt) {
                PbActivity.this.fFZ.afk();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fGs.q(PbActivity.this.fGr.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fGr.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.fGs.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fGV = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fGt) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fFZ.afk();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hww;
                if (aVar.error == 0 && dataRes != null) {
                    int h = com.baidu.adp.lib.g.b.h(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = h == 1;
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
                    PbActivity.this.fFZ.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fGW = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fFZ.bdc() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aZK() != null && PbActivity.this.aZK().getPbData() != null && PbActivity.this.aZK().getPbData().aYY() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aZj = PbActivity.this.aZK().getPbData().aYY().aZj();
                if (intValue < 10) {
                    if (aZj) {
                        if (PbActivity.this.fFY.getPbData().aYY().fCF == 1 || PbActivity.this.fFY.getPbData().aYY().fCF == 3 || PbActivity.this.fFY.getPbData().aYY().fCF == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fFY.getPbData().aYY().aZj() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", aZj ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fFQ > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).kY(false);
                        PbActivity.this.fFQ = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aZj, 3);
                TiebaStatic.log(PbActivity.this.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).s("obj_locate", 4).s("obj_id", aZj ? 0 : 1));
            }
        }
    };
    private CustomMessageListener dxN = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dxm = true;
                }
            }
        }
    };
    public a.b fsX = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.atl();
            com.baidu.tbadk.core.data.am aCL = PbActivity.this.fFY.aCL();
            int pageNum = PbActivity.this.fFZ.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (aCL == null || pageNum <= aCL.xS()) {
                PbActivity.this.fFZ.bdK();
                PbActivity.this.sM(2);
                PbActivity.this.atk();
                PbActivity.this.fFZ.bdv();
                if (com.baidu.adp.lib.util.j.oI()) {
                    PbActivity.this.fFY.sU(PbActivity.this.fFZ.getPageNum());
                    if (PbActivity.this.fFE != null) {
                        PbActivity.this.fFE.showFloatingView();
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
    public final View.OnClickListener dyk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Multi-variable search result rejected for r2v184, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v188, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v225, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v328, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v47, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:692:0x1c66  */
        /* JADX WARN: Removed duplicated region for block: B:719:0x1e30  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String name;
            com.baidu.tieba.pb.data.l aYY;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            String str;
            int i;
            bj bjVar;
            SparseArray sparseArray;
            PostData postData;
            boolean j;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fFZ.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fFY.jX(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fFZ.bdw();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcC()) {
                        if (view == PbActivity.this.fFZ.fOH.bAh) {
                            if (PbActivity.this.fFZ.kv(PbActivity.this.fFY.bbI())) {
                                PbActivity.this.atk();
                                return;
                            }
                            PbActivity.this.fFH = false;
                            PbActivity.this.fFF = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fFZ.bdt() && (PbActivity.this.fFZ.fOH.beB() == null || (view != PbActivity.this.fFZ.fOH.beB().bcB() && view != PbActivity.this.fFZ.fOH.beB().bcz()))) {
                            if (view == PbActivity.this.fFZ.bdN()) {
                                if (PbActivity.this.fFY != null) {
                                    com.baidu.tbadk.browser.a.R(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fFY.getPbData().aYA().yW().getLink());
                                }
                            } else if (view != PbActivity.this.fFZ.fOH.fTC && view.getId() != d.g.view_forum_name_first_floor && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.fFZ.fOH.fTD) {
                                    if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null) {
                                        ArrayList<PostData> aYC = PbActivity.this.fFY.getPbData().aYC();
                                        if ((aYC == null || aYC.size() <= 0) && PbActivity.this.fFY.bbC()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ab("tid", PbActivity.this.fFY.bbB()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getForumId()));
                                        if (!PbActivity.this.fFZ.bee()) {
                                            PbActivity.this.fFZ.bdb();
                                        }
                                        PbActivity.this.bal();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcn()) {
                                        if ((PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcy()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.fFZ.fOH.beB() == null || (view != PbActivity.this.fFZ.fOH.beB().getCancelView() && view != PbActivity.this.fFZ.fOH.beB().bcx())) {
                                                if (view != PbActivity.this.fFZ.fOH.fTE && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcv()) {
                                                        if ((PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcE()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcw()) {
                                                                if (PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcF()) {
                                                                    if (PbActivity.this.fGf == null || view != PbActivity.this.fGf.bcp()) {
                                                                        if (PbActivity.this.fGf == null || view != PbActivity.this.fGf.bcn()) {
                                                                            if (PbActivity.this.fGf == null || view != PbActivity.this.fGf.bcs()) {
                                                                                if (PbActivity.this.fGf == null || view != PbActivity.this.fGf.bcq()) {
                                                                                    if (PbActivity.this.fGf == null || view != PbActivity.this.fGf.bcr()) {
                                                                                        if (PbActivity.this.fFZ.bdX() == view) {
                                                                                            if (PbActivity.this.fFZ.bdX().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fFY.getPbData();
                                                                                                if (pbData != null && pbData.aYA() != null && pbData.aYA().yD() != null) {
                                                                                                    String xj = pbData.aYA().yD().xj();
                                                                                                    if (StringUtils.isNull(xj)) {
                                                                                                        xj = pbData.aYA().yD().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ab("obj_id", xj));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cg("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.baH();
                                                                                        } else if (PbActivity.this.fFZ.bdq() != view) {
                                                                                            if (PbActivity.this.fGf == null || view != PbActivity.this.fGf.bco()) {
                                                                                                if (PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcD()) {
                                                                                                    if (PbActivity.this.fFZ.fOH.beB() != null && view == PbActivity.this.fFZ.fOH.beB().bcA()) {
                                                                                                        if (com.baidu.adp.lib.util.j.oI()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.fFZ.c(PbActivity.this.fFY.getPbData(), PbActivity.this.fFY.bbC(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.fFZ.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.fFZ.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.fFZ.fOH.vU();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.fFZ.aZX()) {
                                                                                                            if (view == PbActivity.this.fFZ.fOH.beC()) {
                                                                                                                PbActivity.this.fFZ.bdD();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (bjVar = (bj) view.getTag()) != null && !StringUtils.isNull(bjVar.Ax())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        com.baidu.tbadk.core.util.av.Di().c(PbActivity.this.getPageContext(), new String[]{bjVar.Ax()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData cp = PbActivity.this.cp(view);
                                                                                                                    if (cp != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 5).s("obj_id", cp.bCA() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.aZK() != null && PbActivity.this.aZK().getPbData() != null && PbActivity.this.aZK().getPbData().aYY() != null && PbActivity.this.aZK().getPbData().aYY() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 4).s("obj_id", PbActivity.this.aZK().getPbData().aYY().aZj() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && !StringUtils.isNull(PbActivity.this.fFY.getPbData().getThreadId()) && (aYY = PbActivity.this.fFY.getPbData().aYY()) != null && aYY.aZh() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.av.Di().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.fFY.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.fGf == null) {
                                                                                                                                PbActivity.this.fGf = new y(PbActivity.this.getPageContext(), PbActivity.this.dyk);
                                                                                                                                PbActivity.this.fFZ.cz(PbActivity.this.fGf.getView());
                                                                                                                                PbActivity.this.fGf.kb(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.fGf.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ab("tid", PbActivity.this.fFY.fKN));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.fGf.bcn().setTag(sparseArray2);
                                                                                                                            PbActivity.this.fGf.bcs().setTag(view.getTag());
                                                                                                                            PbActivity.this.fGf.kd(z6);
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
                                                                                                                                    PbActivity.this.fGf.bcq().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.fGf.bcq().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.fGf.bco().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fGf.bcq().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fGf.bco().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.fGf.bco().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.fGf.bco().setVisibility(8);
                                                                                                                                PbActivity.this.fGf.bcq().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.fGf.bco().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fGf.bcq().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fGf.bco().setText(d.j.delete);
                                                                                                                                PbActivity.this.fGf.bcq().setVisibility(0);
                                                                                                                                if (PbActivity.this.fFY.getPbData().aYN() != 1002 || z2) {
                                                                                                                                    PbActivity.this.fGf.bcq().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fGf.bcq().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.fGf.bco().setVisibility(8);
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
                                                                                                                                PbActivity.this.fGf.bcp().setTag(sparseArray7);
                                                                                                                                PbActivity.this.fGf.bcp().setVisibility(0);
                                                                                                                                PbActivity.this.fGf.bco().setVisibility(8);
                                                                                                                                PbActivity.this.fGf.bcp().setText(d.j.mute_option);
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
                                                                                                                                boolean jH = PbActivity.this.jH(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fHg = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (ar.k(PbActivity.this.fHg) ? false : jH) {
                                                                                                                                    PbActivity.this.fGf.bcp().setVisibility(0);
                                                                                                                                    PbActivity.this.fGf.bcp().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fGf.bcp().setVisibility(8);
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
                                                                                                                                PbActivity.this.fGf.bcr().setVisibility(0);
                                                                                                                                PbActivity.this.fGf.bcr().setTag(d.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                                PbActivity.this.fGf.bcr().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.fGf.bcr().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.fGf.bcr().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fFY.getPbData().vk()) {
                                                                                                                            String vj = PbActivity.this.fFY.getPbData().vj();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(vj) && vj.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.fGf.bcn().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fGf.bcn().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fGf.kc(true);
                                                                                                                                PbActivity.this.fGf.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.fGf.kc(true);
                                                                                                                        PbActivity.this.fGf.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYA() != null && PbActivity.this.fFY.getPbData().aYA().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.R(PbActivity.this.getActivity(), PbActivity.this.fFY.getPbData().aYA().getActUrl());
                                                                                                                        if (PbActivity.this.fFY.getPbData().aYA().zB() != 1) {
                                                                                                                            if (PbActivity.this.fFY.getPbData().aYA().zB() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getPbData().getForumId()).ab("tid", PbActivity.this.fFY.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.fFY.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.fFZ.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (com.baidu.tbadk.core.util.ax.be(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.j.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.fFZ.bdb();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.R(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.bai() == 1) {
                                                                                                                            if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getPbData().getForumId()).ab("tid", PbActivity.this.fFY.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.bai() == 2 && PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getPbData().getForumId()).ab("tid", PbActivity.this.fFY.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.R(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.bai() == 1) {
                                                                                                                            if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getPbData().getForumId()).ab("tid", PbActivity.this.fFY.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.bai() == 2 && PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getPbData().getForumId()).ab("tid", PbActivity.this.fFY.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.baC();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.baD();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYU() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.fFY.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ab(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.Di().c(PbActivity.this.getPageContext(), new String[]{pbData2.aYU().aZd()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYU() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.fFY.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ab(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.Di().c(PbActivity.this.getPageContext(), new String[]{pbData3.aYU().aZd()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.fFZ.fOH.beB() != null && view == PbActivity.this.fFZ.fOH.beB().bcG()) {
                                                                                                                    if (PbActivity.this.fFY == null || PbActivity.this.fFY.getPbData() == null || PbActivity.this.fFY.getPbData().aYA() == null) {
                                                                                                                        PbActivity.this.fFZ.fOH.vU();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.oZ()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.fFY.getPbData().aYA().yF() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fFY.bbB(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).AQ();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").s("obj_locate", PbActivity.this.X(PbActivity.this.fFY.getPbData().aYA())).ab("tid", PbActivity.this.fFY.getPbData().aYA().getTid()).s("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.fGz >= 0) {
                                                                                                                        if (PbActivity.this.fFY != null) {
                                                                                                                            PbActivity.this.fFY.bci();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fFZ.bdr() != null) {
                                                                                                                            PbActivity.this.fFZ.bdr().a(PbActivity.this.fFY.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.fFZ.getListView().setSelection(PbActivity.this.fFY.bcl());
                                                                                                                        PbActivity.this.fGz = 0;
                                                                                                                        if (PbActivity.this.fFY != null) {
                                                                                                                            PbActivity.this.fFY.cs(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.fFZ.beh();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.fFY.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.fFY.bbB(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fFY.getPbData().aYA().zs())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.fFY.getPbData() != null) {
                                                                                                            PbActivity.this.fFZ.bdK();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bCC() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12630"));
                                                                                                                }
                                                                                                                String bbB = PbActivity.this.fFY.bbB();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.fFY.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.fFY.getPbData().aYN();
                                                                                                                }
                                                                                                                PbActivity.this.atk();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c pW = PbActivity.this.pW(id2);
                                                                                                                    if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && pW != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bbB, id2, "pb", true, null, true, null, i3, postData3.bfu(), PbActivity.this.fFY.getPbData().xJ(), false, postData3.yX().getIconInfo()).addBigImageData(pW.fHQ, pW.fHR, pW.fHS, pW.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.fFY.bch());
                                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
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
                                                                                                                    c pW2 = PbActivity.this.pW(id2);
                                                                                                                    if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && pW2 != null && PbActivity.this.bad().bcZ() != null) {
                                                                                                                        com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                        mVar.b(PbActivity.this.fFY.getPbData().aYy());
                                                                                                                        mVar.Q(PbActivity.this.fFY.getPbData().aYA());
                                                                                                                        mVar.d(postData4);
                                                                                                                        PbActivity.this.bad().bcZ().d(mVar);
                                                                                                                        PbActivity.this.bad().bcZ().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c pW3 = PbActivity.this.pW(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && pW3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bbB, id2, "pb", true, null, false, null, i3, postData3.bfu(), PbActivity.this.fFY.getPbData().xJ(), false, postData3.yX().getIconInfo()).addBigImageData(pW3.fHQ, pW3.fHR, pW3.fHS, pW3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.fFY.bch());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 3).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.oI()) {
                                                                                                    PbActivity.this.fFZ.bdK();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.fFZ.c(PbActivity.this.fFY.getPbData(), PbActivity.this.fFY.bbC(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fFY.getPbData().aYy().getId(), PbActivity.this.fFY.getPbData().aYy().getName(), PbActivity.this.fFY.getPbData().aYA().getId(), String.valueOf(PbActivity.this.fFY.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    PbActivity.this.showToast(d.j.network_not_available);
                                                                                                    return;
                                                                                                }
                                                                                            } else if (!com.baidu.adp.lib.util.j.oI()) {
                                                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                                                return;
                                                                                            } else {
                                                                                                SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                                if (sparseArray11 != null) {
                                                                                                    if (!com.baidu.tieba.c.a.aiU() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fFY.bbB(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.fFZ.cx(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.fFZ.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.aZZ();
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
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.fFY.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aYy() != null) {
                                                                                            str9 = pbData4.aYy().getId();
                                                                                            str10 = pbData4.aYy().getName();
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
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.aiU() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fFY.bbB(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.fFZ.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.fGf.bcu()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ab("tid", PbActivity.this.fFY.fKN));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fFY.getPbData() != null) {
                                                                                    PbActivity.this.fFZ.bdK();
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
                                                                                        String bbB2 = PbActivity.this.fFY.bbB();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.fFY.getPbData() != null) {
                                                                                            i5 = PbActivity.this.fFY.getPbData().aYN();
                                                                                        }
                                                                                        PbActivity.this.atk();
                                                                                        c pW4 = PbActivity.this.pW(id3);
                                                                                        if (pW4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bbB2, id3, "pb", true, null, true, null, i5, postData.bfu(), PbActivity.this.fFY.getPbData().xJ(), false, postData.yX().getIconInfo()).addBigImageData(pW4.fHQ, pW4.fHR, pW4.fHS, pW4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.fFY.bch());
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
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.cq(view);
                                                                                if (PbActivity.this.fFY.getPbData().aYA() != null && PbActivity.this.fFY.getPbData().aYA().yX() != null && PbActivity.this.fFY.getPbData().aYA().yX().getUserId() != null && PbActivity.this.fgs != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ab("tid", PbActivity.this.fFY.fKN).s("obj_locate", 2).ab("obj_id", PbActivity.this.fFY.getPbData().aYA().yX().getUserId()).s("obj_type", PbActivity.this.fgs.vk() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fFY.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 4));
                                                                        if (!com.baidu.adp.lib.util.j.oI()) {
                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                            return;
                                                                        }
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            PbActivity.this.pT((String) tag);
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
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").s("obj_type", 0).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").s("obj_type", 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.fFZ.fOH.beA();
                                                                }
                                                            } else if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYA() != null) {
                                                                PbActivity.this.fFZ.fOH.vU();
                                                                PbActivity.this.pT(PbActivity.this.fFY.getPbData().aYA().zo());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fFZ.bdK();
                                                            if (com.baidu.adp.lib.util.j.oI()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.fFY.bbP()));
                                                                    return;
                                                                }
                                                                PbActivity.this.sM(2);
                                                                PbActivity.this.atk();
                                                                PbActivity.this.fFZ.bdv();
                                                                boolean bbO = PbActivity.this.fFY.bbO();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.fFY.bbP()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.fFZ.fOH != null && PbActivity.this.fFZ.fOH.beB() != null && view == PbActivity.this.fFZ.fOH.beB().bcE()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (bbO) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.fFZ.km(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fFZ.bdK();
                                                        if (PbActivity.this.fFY.aCL() != null) {
                                                            PbActivity.this.fFZ.a(PbActivity.this.fFY.aCL(), PbActivity.this.fsX);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.am.nu() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fFY != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ab("tid", PbActivity.this.fFY.bbB()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getForumId()).s("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.oZ()) {
                                                        if (PbActivity.this.fFY.getPbData() != null) {
                                                            ArrayList<PostData> aYC2 = PbActivity.this.fFY.getPbData().aYC();
                                                            if ((aYC2 != null && aYC2.size() > 0) || !PbActivity.this.fFY.bbC()) {
                                                                PbActivity.this.fFZ.bdK();
                                                                PbActivity.this.atk();
                                                                PbActivity.this.sM(2);
                                                                if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYU() != null && !StringUtils.isNull(PbActivity.this.fFY.getPbData().aYU().xu(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.am.nu()) {
                                                                    PbActivity.this.sN(2);
                                                                } else {
                                                                    PbActivity.this.fFZ.showLoadingDialog();
                                                                    PbActivity.this.fFY.bcc().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.fFZ.fOH.vU();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.oI()) {
                                            PbActivity.this.fFZ.bdK();
                                            if (PbActivity.this.fFZ.fOH.beB() != null && view == PbActivity.this.fFZ.fOH.beB().bcy() && !PbActivity.this.fFZ.bee()) {
                                                PbActivity.this.fFZ.bdb();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.atk();
                                                PbActivity.this.fFZ.bdv();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    j = PbActivity.this.fFY.j(true, PbActivity.this.baA());
                                                } else {
                                                    j = view.getId() == d.g.reply_title ? PbActivity.this.fFY.j(false, PbActivity.this.baA()) : PbActivity.this.fFY.pY(PbActivity.this.baA());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.fFZ.jQ(true);
                                                    PbActivity.this.fFZ.aIx();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fFZ.km(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.sM(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.oI()) {
                                        PbActivity.this.fFZ.bdK();
                                        if (PbActivity.this.sL(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fFY.tb(PbActivity.this.fFZ.bdA()) != null) {
                                            PbActivity.this.bat();
                                            if (PbActivity.this.fFY.getPbData().aYA() != null && PbActivity.this.fFY.getPbData().aYA().yX() != null && PbActivity.this.fFY.getPbData().aYA().yX().getUserId() != null && PbActivity.this.fgs != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ab("tid", PbActivity.this.fFY.fKN).s("obj_locate", 1).ab("obj_id", PbActivity.this.fFY.getPbData().aYA().yX().getUserId()).s("obj_type", PbActivity.this.fgs.vk() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fFY.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.oI()) {
                                    PbActivity.this.fFZ.jQ(true);
                                    PbActivity.this.fFZ.bdb();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fFZ.aIx();
                                        PbActivity.this.atk();
                                        PbActivity.this.fFZ.bdv();
                                        PbActivity.this.fFY.pY(PbActivity.this.baA());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.sM(2);
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
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12505").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, com.baidu.tieba.pb.d.t(PbActivity.this.getPageContext())));
                                }
                                if (PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYA() != null && PbActivity.this.fFY.getPbData().aYA().zK() && PbActivity.this.fFY.getPbData().aYA().zp() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.fFY.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fFY.bbA()) && PbActivity.this.fFY.getAppealInfo() != null) {
                                        name = PbActivity.this.fFY.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fFY.getPbData().aYy().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bbA = PbActivity.this.fFY.bbA();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fFY.bbD() && bbA != null && bbA.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.oI()) {
                            if (PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYN() == 1 && !PbActivity.this.cQq.bCZ()) {
                                PbActivity.this.fFZ.bdK();
                                int i6 = 0;
                                if (PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcz()) {
                                    if (PbActivity.this.fFZ.fOH.beB() == null || view != PbActivity.this.fFZ.fOH.beB().bcB()) {
                                        if (view == PbActivity.this.fFZ.bdt()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.fFY.getPbData().aYA().yT() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.fFY.getPbData().aYA().yS() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aYy = PbActivity.this.fFY.getPbData().aYy();
                                String name2 = aYy.getName();
                                String id4 = aYy.getId();
                                String id5 = PbActivity.this.fFY.getPbData().aYA().getId();
                                if (!com.baidu.tieba.c.a.aiU() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.fFZ.bds();
                                    PbActivity.this.cQq.a(id4, name2, id5, i6, PbActivity.this.fFZ.bdu());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.oI()) {
                        PbActivity.this.fFZ.bdK();
                        PbActivity.this.atk();
                        PbActivity.this.fFZ.bdv();
                        PbActivity.this.fFZ.showLoadingDialog();
                        if (PbActivity.this.fFZ.bdi() != null) {
                            PbActivity.this.fFZ.bdi().setVisibility(8);
                        }
                        PbActivity.this.fFY.sU(1);
                        if (PbActivity.this.fFE != null) {
                            PbActivity.this.fFE.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bag = PbActivity.this.bag();
                        if (!TextUtils.isEmpty(bag)) {
                            com.baidu.tbadk.core.util.av.Di().c(PbActivity.this.getPageContext(), new String[]{bag});
                        }
                    }
                } else if (PbActivity.this.fFP) {
                    PbActivity.this.fFP = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.bad().bcZ() != null && postData5.yX() != null && postData5.bCl() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bad().bda() != null) {
                                    PbActivity.this.bad().bda().bbm();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.fFY.getPbData().aYy());
                                mVar2.Q(PbActivity.this.fFY.getPbData().aYA());
                                mVar2.d(postData5);
                                PbActivity.this.bad().bcZ().d(mVar2);
                                PbActivity.this.bad().bcZ().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.yX().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fGm != null) {
                                    PbActivity.this.fFZ.kw(PbActivity.this.fGm.Lj());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d brP = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.atk();
            PbActivity.this.fFZ.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ad.Ot() && PbActivity.this.aZK() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aZK().qb(postWriteCallBackData.getPostId());
                    PbActivity.this.fGz = PbActivity.this.fFZ.bde();
                    if (PbActivity.this.fFY != null) {
                        PbActivity.this.fFY.cs(PbActivity.this.fGz, PbActivity.this.fFZ.bdf());
                    }
                }
                PbActivity.this.fFZ.bdK();
                PbActivity.this.fGe.bej();
                if (PbActivity.this.fGm != null) {
                    PbActivity.this.fFZ.kw(PbActivity.this.fGm.Lj());
                }
                PbActivity.this.fFZ.bcY();
                PbActivity.this.fFZ.ky(true);
                PbActivity.this.fFY.bbR();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fFY.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.fFY.getPbData();
                            if (pbData != null && pbData.aYA() != null && pbData.aYA().yX() != null && (userId = pbData.aYA().yX().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ad.Ot() && PbActivity.this.fFY.bbK()) {
                                PbActivity.this.fFZ.bdv();
                            }
                        } else if (!com.baidu.tbadk.o.ad.Ot() && PbActivity.this.fFY.bbK()) {
                            PbActivity.this.fFZ.bdv();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fFZ.p(PbActivity.this.fFY.getPbData());
                    }
                    if (PbActivity.this.fFY.bbG()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ab("tid", PbActivity.this.fFY.bbB()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fGm.Lq() || PbActivity.this.fGm.Lr()) {
                    PbActivity.this.fGm.a(false, postWriteCallBackData);
                }
                PbActivity.this.fGe.e(postWriteCallBackData);
            } else if (sVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fGX = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.fGe != null) {
                if (z) {
                    PbActivity.this.fGe.bei();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    if (PbActivity.this.fFZ != null && PbActivity.this.fFZ.bda() != null && PbActivity.this.fFZ.bda().bbs() != null && PbActivity.this.fFZ.bda().bbs().Lr()) {
                        PbActivity.this.fFZ.bda().bbs().a(postWriteCallBackData);
                    }
                    PbActivity.this.fGe.f(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a fGY = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l hL;
            if (!z || fVar == null || fVar.aYL() != null || com.baidu.tbadk.core.util.v.F(fVar.aYC()) >= 1) {
                PbActivity.this.fje = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fFZ.bdx();
                if (fVar == null || !fVar.aYH()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fFZ.getView());
                } else if (PbActivity.this.fFZ.bcW() == null) {
                    PbActivity.this.fGq = true;
                }
                PbActivity.this.fFZ.aIw();
                if (PbActivity.this.isFullScreen || PbActivity.this.fFZ.bee()) {
                    PbActivity.this.fFZ.bdT();
                } else if (!PbActivity.this.fFZ.bdQ()) {
                    PbActivity.this.fFZ.ky(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.fGg = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.fFZ.WZ();
                    PbActivity.this.fFZ.kz(fVar.aYH());
                    if (fVar.aYA() != null && fVar.aYA().zU() != null) {
                        PbActivity.this.a(fVar.aYA().zU());
                    }
                    PbActivity.this.baa();
                    if (PbActivity.this.fGm != null) {
                        PbActivity.this.fFZ.kw(PbActivity.this.fGm.Lj());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aYC() != null && fVar.aYC().size() >= 1 && fVar.aYC().get(0) != null) {
                        PbActivity.this.fFY.qa(fVar.aYC().get(0).getId());
                    } else if (fVar.aYL() != null) {
                        PbActivity.this.fFY.qa(fVar.aYL().getId());
                    }
                    if (PbActivity.this.fGm != null) {
                        PbActivity.this.fGm.a(fVar.xJ());
                        PbActivity.this.fGm.a(fVar.aYy(), fVar.getUserData());
                        PbActivity.this.fGm.a(PbActivity.this.fFY.bbL(), PbActivity.this.fFY.bbB(), PbActivity.this.fFY.bce());
                        if (fVar.aYA() != null) {
                            PbActivity.this.fGm.cj(fVar.aYA().Ak());
                        }
                    }
                    if (PbActivity.this.fgs != null) {
                        PbActivity.this.fgs.aH(fVar.vk());
                    }
                    if (fVar == null || fVar.aYO() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fFZ.kx(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fFZ.a(fVar, i2, i3, PbActivity.this.fFY.bbC(), i4, PbActivity.this.fFY.getIsFromMark());
                    PbActivity.this.fFZ.d(fVar, PbActivity.this.fFY.bbC());
                    PbActivity.this.fFZ.ku(PbActivity.this.fFY.getHostMode());
                    AntiData xJ = fVar.xJ();
                    if (xJ != null) {
                        PbActivity.this.brF = xJ.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.brF) && PbActivity.this.fGm != null && PbActivity.this.fGm.KF() != null && (hL = PbActivity.this.fGm.KF().hL(6)) != null && !TextUtils.isEmpty(PbActivity.this.brF)) {
                            ((View) hL).setOnClickListener(PbActivity.this.bsq);
                        }
                    }
                    if (PbActivity.this.fGi) {
                        PbActivity.this.fGi = false;
                        final int ban = PbActivity.this.ban();
                        if (fVar.aYZ()) {
                            final int ao = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(ban, ao);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bad().tg(ban);
                        }
                    }
                    if (PbActivity.this.fGj) {
                        PbActivity.this.fGj = false;
                        final int ban2 = PbActivity.this.ban();
                        final boolean z2 = ban2 != -1;
                        if (!z2) {
                            ban2 = PbActivity.this.bao();
                        }
                        if (PbActivity.this.bad() != null) {
                            if (fVar.aYZ()) {
                                final int ao2 = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ban2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(ban2, ao2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(ban2 - 1, ao2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.bad().tg(ban2);
                            }
                        }
                    } else {
                        PbActivity.this.fFZ.bdB();
                    }
                    PbActivity.this.fFY.a(fVar.aYy(), PbActivity.this.fGL);
                    PbActivity.this.fFY.a(PbActivity.this.fGM);
                } else if (str != null) {
                    if (!PbActivity.this.fGg && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fFY != null && PbActivity.this.fFY.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fFY.getAppealInfo().fBL)) {
                                    PbActivity.this.fFZ.a(PbActivity.this.fFY.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fFZ.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fFZ.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.fFZ.bdT();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fFY.bbB());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.i iVar = new com.baidu.tbadk.core.util.i();
                        iVar.setOpType("2");
                        iVar.start();
                    }
                    if (i != -1) {
                        PbActivity.this.fFZ.qe(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.fFZ.qe("");
                    }
                    PbActivity.this.fFZ.DU();
                }
                PbActivity.this.byn = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aZK().bbC() || PbActivity.this.aZK().getPbData().yb().xY() != 0 || PbActivity.this.aZK().bbX()) {
                    PbActivity.this.fGn = true;
                    return;
                }
                return;
            }
            PbActivity.this.fFY.sU(1);
            if (PbActivity.this.fFE != null) {
                PbActivity.this.fFE.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.fFZ.p(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.r.Oa().Ob()) {
                com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, PbActivity.this.byf, PbActivity.this.createTime, PbActivity.this.byn, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.dhW : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.byf = 0L;
                if (mVar != null) {
                    mVar.NV();
                }
            }
        }
    };
    private CustomMessageListener fGZ = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.bai() == 1) {
                    PbActivity.this.bar();
                }
                PbActivity.this.baj();
            }
        }
    };
    private final a.InterfaceC0070a fHa = new a.InterfaceC0070a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0070a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fFZ.bdx();
            if (z) {
                if (PbActivity.this.fgs != null) {
                    PbActivity.this.fgs.aH(z2);
                }
                PbActivity.this.fFY.jZ(z2);
                if (PbActivity.this.fFY.vk()) {
                    PbActivity.this.bau();
                } else {
                    PbActivity.this.fFZ.p(PbActivity.this.fFY.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fgs != null && PbActivity.this.fgs.vn() != null && PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYA() != null && PbActivity.this.fFY.getPbData().aYA().yX() != null) {
                        MarkData vn = PbActivity.this.fgs.vn();
                        MetaData yX = PbActivity.this.fFY.getPbData().aYA().yX();
                        if (vn != null && yX != null) {
                            if (!com.baidu.tbadk.core.util.am.equals(TbadkCoreApplication.getCurrentAccount(), yX.getUserId()) && !yX.hadConcerned()) {
                                PbActivity.this.b(yX);
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
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.sJ(PbActivity.this.mLastScrollState) && PbActivity.this.sJ(i)) {
                if (PbActivity.this.fFZ != null) {
                    PbActivity.this.fFZ.bdK();
                    if (PbActivity.this.fGm != null && !PbActivity.this.fFZ.bdc()) {
                        PbActivity.this.fFZ.kw(PbActivity.this.fGm.Lj());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fFZ.bdb();
                    }
                }
                if (!PbActivity.this.fFM) {
                    PbActivity.this.fFM = true;
                    PbActivity.this.fFZ.bdP();
                }
            }
            PbActivity.this.fFZ.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fFE != null) {
                PbActivity.this.fFE.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fFN == null) {
                PbActivity.this.fFN = new com.baidu.tbadk.k.d();
                PbActivity.this.fFN.iq(1001);
            }
            if (i == 0) {
                PbActivity.this.fFN.NH();
            } else if (i == 1) {
                PbActivity.this.fFN.NH();
            } else {
                PbActivity.this.fFN.NH();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aYC;
            if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFZ != null && PbActivity.this.fFZ.bdr() != null) {
                PbActivity.this.fFZ.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fFE != null) {
                    PbActivity.this.fFE.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fFY.bbT() && (aYC = PbActivity.this.fFY.getPbData().aYC()) != null && !aYC.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fFZ.bdr().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.fFY.getPbData();
                    if (pbData != null) {
                        if (pbData.aYD() != null && pbData.aYD().hasData()) {
                            headerCount--;
                        }
                        if (pbData.aYE() != null && pbData.aYE().hasData()) {
                            headerCount--;
                        }
                        int size = aYC.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cQu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.cQq.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fFY.bbR();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dWS && bVar.fVt > 0 && bVar.hkZ != 0 && bVar.fVt != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.fVt == 1002 && !bVar.dWS) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fFZ.a(1, dVar.aot, dVar.hlb, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cQq.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fFZ.a(PbActivity.this.cQq.getLoadDataMode(), gVar.aot, gVar.hlb, false);
                        PbActivity.this.fFZ.am(gVar.hle);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fFZ.a(PbActivity.this.cQq.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fHb = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
    };
    private final i.b bSR = new i.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
        @Override // com.baidu.tbadk.core.view.i.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.baB()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fFY.jY(true)) {
                PbActivity.this.fFZ.bdy();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fHd = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fHc && PbActivity.this.baB()) {
                PbActivity.this.baD();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fFY.jX(false)) {
                    PbActivity.this.fFZ.bdw();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fFY.getPbData() != null) {
                    PbActivity.this.fFZ.bdO();
                }
                PbActivity.this.fHc = true;
            }
        }
    };
    private int fHe = 0;
    private final TbRichTextView.h bJx = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fFZ.b((TbRichText) view.getTag());
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
                    PbActivity.this.fFW = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fHT) {
                    TbRichText aw = PbActivity.this.aw(str, i);
                    if (aw != null && PbActivity.this.fHe >= 0 && PbActivity.this.fHe < aw.QN().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.g.b(aw.QN().get(PbActivity.this.fHe));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fHQ.size()) {
                                break;
                            } else if (!cVar.fHQ.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.G(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fHR.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fHS, cVar.lastId, PbActivity.this.fFY.bbP(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.f(cVar.fHQ, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.G(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fHR.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fHS, cVar.fHQ.get(0), PbActivity.this.fFY.bbP(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fHf = false;
    PostData fHg = null;
    private final b.InterfaceC0074b fHh = new b.InterfaceC0074b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fHg != null) {
                if (i == 0) {
                    PbActivity.this.fHg.co(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fHg = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fHg);
                }
            }
        }
    };
    private final b.InterfaceC0074b fHi = new b.InterfaceC0074b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fGw != null && !TextUtils.isEmpty(PbActivity.this.fGx)) {
                if (i == 0) {
                    if (PbActivity.this.fGy == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.fGx));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fGx;
                        aVar.pkgId = PbActivity.this.fGy.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fGy.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.fGv == null) {
                        PbActivity.this.fGv = new aw(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.fGv.i(PbActivity.this.fGx, PbActivity.this.fGw.sl());
                }
                PbActivity.this.fGw = null;
                PbActivity.this.fGx = null;
            }
        }
    };
    private final View.OnLongClickListener bjN = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.fGw = ((TbImageView) view).getBdImage();
                PbActivity.this.fGx = ((TbImageView) view).getUrl();
                if (PbActivity.this.fGw != null && !TextUtils.isEmpty(PbActivity.this.fGx)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fGy = null;
                    } else {
                        PbActivity.this.fGy = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fFZ.a(PbActivity.this.fHi, PbActivity.this.fGw.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.fGw = ((GifView) view).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                        PbActivity.this.fGx = ((GifView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fGy = null;
                    } else {
                        PbActivity.this.fGy = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fFZ.a(PbActivity.this.fHi, PbActivity.this.fGw.isGif());
                }
            } else if (view instanceof com.baidu.tbadk.widget.d) {
                if (((com.baidu.tbadk.widget.d) view).getBdImage() != null) {
                    PbActivity.this.fGw = ((com.baidu.tbadk.widget.d) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.d) view).getBdImage().getUrl())) {
                        PbActivity.this.fGx = ((com.baidu.tbadk.widget.d) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fGy = null;
                    } else {
                        PbActivity.this.fGy = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fFZ.a(PbActivity.this.fHi, PbActivity.this.fGw.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fHg = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.fHg != null && PbActivity.this.fgs != null) {
                        PbActivity.this.fFZ.a(PbActivity.this.fHh, PbActivity.this.fgs.vk() && PbActivity.this.fHg.getId() != null && PbActivity.this.fHg.getId().equals(PbActivity.this.fFY.zh()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a duP = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bp(boolean z) {
            if (!PbActivity.this.fFG && z && !PbActivity.this.fFY.bbJ()) {
                PbActivity.this.bax();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener bBc = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).arz()) {
                        break;
                    }
                }
            }
            PbActivity.this.ckD.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0109a ckE = new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        final int cFR;

        {
            this.cFR = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
            if (aa(i2) && PbActivity.this.fFZ != null && PbActivity.this.fFE != null) {
                PbActivity.this.fFZ.bdU();
                PbActivity.this.fFE.fI(false);
                PbActivity.this.fFE.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
            if (aa(i2) && PbActivity.this.fFZ != null && PbActivity.this.fFE != null) {
                PbActivity.this.fFE.fI(true);
                if (Math.abs(i2) > this.cFR) {
                    PbActivity.this.fFE.hideFloatingView();
                }
                if (PbActivity.this.baB()) {
                    PbActivity.this.fFZ.bdn();
                    PbActivity.this.fFZ.bdo();
                }
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }

        private boolean aa(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a fHj = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.e.b.a
        public void fe(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aZA();
            } else {
                com.baidu.tieba.pb.a.b.aZz();
            }
        }
    };
    private String fHk = null;
    private final o.a fHl = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void j(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fHk = str2;
                PbActivity.this.fFZ.qf(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fHm = -1;
    private int fHn = -1;
    private CustomMessageListener fHq = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.aIB == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0072a) {
                    if (aVar.aIC != null && !aVar.aIC.hasError() && aVar.aIC.getError() == 0) {
                        if (PbActivity.this.fFZ != null) {
                            PbActivity.this.fFZ.y(((a.C0072a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.baN();
                        }
                    } else if (z) {
                        if (aVar.aIC != null && aVar.aIC.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aIC.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.aIC != null && !aVar.aIC.hasError() && aVar.aIC.getError() == 0) {
                        if (PbActivity.this.fFZ != null && PbActivity.this.fFZ != null) {
                            PbActivity.this.fFZ.y(((a.C0072a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.aIC != null && aVar.aIC.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aIC.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.aIC == null || aVar.aIC.hasError() || aVar.aIC.getError() != 0) {
                        if (z) {
                            if (aVar.aIC != null && aVar.aIC.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.aIC.getErrorString());
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
    private final CustomMessageListener dxH = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ab("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.av.Di().c(PbActivity.this.getPageContext(), new String[]{str});
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
        void ak(Object obj);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public ArrayList<String> fHQ;
        public ConcurrentHashMap<String, ImageUrlData> fHR;
        public boolean fHT;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fHS = false;
        public boolean fHU = false;
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

    public com.baidu.tbadk.editortools.pb.d aZY() {
        return this.fGm;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        if (mVar.aZp() != null) {
            String id = mVar.aZp().getId();
            ArrayList<PostData> aYC = this.fFY.getPbData().aYC();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aYC.size()) {
                    break;
                }
                PostData postData = aYC.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aZt = mVar.aZt();
                    postData.xi(mVar.getTotalCount());
                    if (postData.bCi() != null && aZt != null) {
                        Iterator<PostData> it = aZt.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.yX() != null && (metaData = postData.getUserMap().get(next.yX().getUserId())) != null) {
                                next.a(metaData);
                                next.nx(true);
                                next.b(getPageContext(), this.fFY.pZ(metaData.getUserId()));
                            }
                        }
                        postData.bCi().clear();
                        postData.bCi().addAll(aZt);
                    }
                    if (postData.bCd() != null) {
                        postData.bCe();
                    }
                }
            }
            if (!this.fFY.getIsFromMark()) {
                this.fFZ.p(this.fFY.getPbData());
            }
            c(mVar);
        }
    }

    public void aZZ() {
        com.baidu.tieba.pb.data.f pbData;
        be aYA;
        if (!this.fGO) {
            if (!com.baidu.adp.lib.util.l.oZ()) {
                showToast(d.j.no_network_guide);
            } else if (this.fGR) {
                this.fGO = true;
                if (this.fFY != null && (pbData = this.fFY.getPbData()) != null && (aYA = pbData.aYA()) != null) {
                    int isLike = aYA.yM() == null ? 0 : aYA.yM().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ab("tid", aYA.getId()));
                    }
                    if (this.fGP != null) {
                        this.fGP.a(aYA.zo(), aYA.getId(), isLike, "pb");
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
                bVar.fg(d.j.operation);
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.j.delete);
                    strArr[1] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr, new b.InterfaceC0074b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fFZ.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fGt);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fGt);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0074b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fGt);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fGt);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).AL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(int i) {
        be aYA;
        String str;
        String G;
        if (this.fFY != null && this.fFY.getPbData() != null && (aYA = this.fFY.getPbData().aYA()) != null) {
            if (i == 1) {
                PraiseData yM = aYA.yM();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yM == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aYA.a(praiseData);
                    } else {
                        aYA.yM().getUser().add(0, metaData);
                        aYA.yM().setNum(aYA.yM().getNum() + 1);
                        aYA.yM().setIsLike(i);
                    }
                }
                if (aYA.yM() != null) {
                    if (aYA.yM().getNum() < 1) {
                        G = getResources().getString(d.j.zan);
                    } else {
                        G = com.baidu.tbadk.core.util.am.G(aYA.yM().getNum());
                    }
                    this.fFZ.S(G, true);
                }
            } else if (aYA.yM() != null) {
                aYA.yM().setIsLike(i);
                aYA.yM().setNum(aYA.yM().getNum() - 1);
                ArrayList<MetaData> user = aYA.yM().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aYA.yM().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aYA.yM().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = aYA.yM().getNum() + "";
                }
                this.fFZ.S(str, false);
            }
            if (this.fFY.bbC()) {
                this.fFZ.bdr().notifyDataSetChanged();
            } else {
                this.fFZ.q(this.fFY.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fFY.x(bundle);
        if (this.dwG != null) {
            this.dwG.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fGm.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fGr = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.dhW = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fFS = intent.getStringExtra("from");
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fFS)) {
                this.fFF = true;
            }
            this.fHm = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fHn = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fHo = intent.getStringExtra("key_manga_title");
            this.fGi = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fGj = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (baB()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.fGA = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.dhW = System.currentTimeMillis();
        }
        this.fFL = System.currentTimeMillis();
        this.byf = this.fFL - this.dhW;
        super.onCreate(bundle);
        this.fFI = 0;
        w(bundle);
        if (this.fFY != null && this.fFY.getPbData() != null) {
            this.fFY.getPbData().pR(this.source);
        }
        initUI();
        if (intent != null && this.fFZ != null) {
            this.fFZ.fOA = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fGu == null) {
                    this.fGu = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fFZ.qh("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fGu, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fFY != null && this.fFY.getPbData() != null) {
                this.fFY.qc(stringExtra);
            }
        }
        this.dwG = new VoiceManager();
        this.dwG.onCreate(getPageContext());
        initData(bundle);
        this.fGl = new com.baidu.tbadk.editortools.pb.g();
        baa();
        this.fGm = (com.baidu.tbadk.editortools.pb.d) this.fGl.bh(getActivity());
        this.fGm.d(this);
        this.fGm.a(this.brP);
        this.fGm.a(this.brI);
        this.fGm.a(this, bundle);
        this.fGm.KF().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.fGm.KF().cc(true);
        jG(true);
        this.fFZ.setEditorTools(this.fGm.KF());
        this.fGm.a(this.fFY.bbL(), this.fFY.bbB(), this.fFY.bce());
        registerListener(this.fGG);
        if (!this.fFY.bbI()) {
            this.fGm.gd(this.fFY.bbB());
        }
        if (this.fFY.bcf()) {
            this.fGm.gb(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fGm.gb(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.fFL;
        registerListener(this.fGF);
        registerListener(this.fGH);
        registerListener(this.fGI);
        registerListener(this.dxE);
        registerListener(this.fGW);
        registerListener(this.fGE);
        this.fGk = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.hig);
        this.fGk.bBM();
        registerListener(this.fGK);
        registerListener(this.mAttentionListener);
        if (this.fFY != null) {
            this.fFY.bbV();
        }
        registerListener(this.fGZ);
        registerListener(this.fHq);
        registerListener(this.dxN);
        if (this.fFZ != null && this.fFZ.bdY() != null && this.fFZ.bdZ() != null) {
            this.fFE = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.fFZ.bdY(), this.fFZ.bdZ(), this.fFZ.bdi());
            this.fFE.a(this.fGS);
        }
        if (this.fFD && this.fFZ != null && this.fFZ.bdZ() != null) {
            this.fFZ.bdZ().setVisibility(8);
        }
        this.fGs = new com.baidu.tbadk.core.view.d();
        this.fGs.aZp = 1000L;
        registerListener(this.fGV);
        registerListener(this.fGT);
        registerListener(this.fGU);
        this.fGt = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fGt;
        userMuteAddAndDelCustomMessage.setTag(this.fGt);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fGt;
        userMuteCheckCustomMessage.setTag(this.fGt);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fFY.bcc().a(this.cvY);
        if ("from_tieba_kuang".equals(this.fFS)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 2).ab("tid", this.fFY.bbB()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                    @Override // com.baidu.tbadk.core.e
                    public void aO(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
        this.fGe = new au();
        if (this.fGm.Ld() != null) {
            this.fGe.g(this.fGm.Ld().getInputView());
        }
        this.fGm.a(this.brJ);
        this.dJg = new ShareSuccessReplyToServerModel();
        a(this.fGC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baa() {
        if (this.fGl != null && this.fFY != null) {
            this.fGl.setForumName(this.fFY.bbA());
            if (this.fFY.getPbData() != null && this.fFY.getPbData().aYy() != null) {
                this.fGl.setForumId(this.fFY.getPbData().aYy().getId());
            }
            this.fGl.setFrom("pb");
            this.fGl.a(this.fFY);
        }
    }

    public String bab() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b bac() {
        return this.fFE;
    }

    private void jG(boolean z) {
        this.fGm.cg(z);
        this.fGm.ch(z);
        this.fGm.ci(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYZ() && !z && this.fFZ != null && this.fFZ.getView() != null) {
            this.fFZ.getView().setSystemUiVisibility(4);
        }
        this.fGo = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dwG != null) {
            this.dwG.onStart(getPageContext());
        }
    }

    public as bad() {
        return this.fFZ;
    }

    public PbModel aZK() {
        return this.fFY;
    }

    public void pS(String str) {
        if (this.fFY != null && !StringUtils.isNull(str) && this.fFZ != null) {
            this.fFZ.kB(true);
            this.fFY.pS(str);
            this.fFR = true;
            this.fFZ.bdK();
            this.fFZ.bdT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fFG = false;
        } else {
            this.fFG = true;
        }
        super.onPause();
        if (this.fFZ.bcW() != null && this.fFZ.bcW().aZV() != null) {
            this.fFZ.bcW().aZV().onPause();
        }
        BdListView listView = getListView();
        this.fFI = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fFI == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dwG != null) {
            this.dwG.onPause(getPageContext());
        }
        if (this.fFZ != null) {
            this.fFZ.onPause();
        }
        if (!this.fFY.bbI()) {
            this.fGm.gc(this.fFY.bbB());
        }
        if (this.fFY != null) {
            this.fFY.bbW();
        }
        MessageManager.getInstance().unRegisterListener(this.eqX);
        aCg();
        MessageManager.getInstance().unRegisterListener(this.fGT);
        MessageManager.getInstance().unRegisterListener(this.fGU);
        MessageManager.getInstance().unRegisterListener(this.fGV);
        MessageManager.getInstance().unRegisterListener(this.dxH);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean bae() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.fFY.getPbData(), this.fFY.bbC(), this.fFY.getRequestType());
        return (a2 == null || a2.yX() == null || a2.yX().getGodUserData() == null || a2.yX().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fFG = false;
        super.onResume();
        if (this.fFU) {
            this.fFU = false;
            baH();
        }
        if (this.fFZ.bcW() != null && this.fFZ.bcW().aZV() != null) {
            this.fFZ.bcW().aZV().onResume();
        }
        if (bae()) {
            this.fFO = System.currentTimeMillis();
        } else {
            this.fFO = -1L;
        }
        if (this.fFZ != null && this.fFZ.getView() != null) {
            if (!this.fje) {
                bay();
            } else {
                hideLoadingView(this.fFZ.getView());
            }
            this.fFZ.onResume();
        }
        if (this.fFI == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fFZ != null) {
            noNetworkView = this.fFZ.bcX();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.oI()) {
            noNetworkView.bo(false);
        }
        if (this.dwG != null) {
            this.dwG.onResume(getPageContext());
        }
        registerListener(this.eqX);
        this.fGh = false;
        baG();
        registerListener(this.fGT);
        registerListener(this.fGU);
        registerListener(this.fGV);
        registerListener(this.dxH);
        if (this.dxm) {
            bax();
            this.dxm = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                @Override // com.baidu.tbadk.core.e
                public void aO(boolean z) {
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
        this.fFZ.kp(z);
        if (this.fGf != null) {
            this.fGf.kb(z);
        }
        if (z && this.fGh) {
            this.fFZ.bdw();
            this.fFY.jX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fFO > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ab("obj_duration", (System.currentTimeMillis() - this.fFO) + ""));
            this.fFO = 0L;
        }
        if (bad().bda() != null) {
            bad().bda().onStop();
        }
        if (this.fFZ.fOH != null && !this.fFZ.fOH.ako()) {
            this.fFZ.fOH.aNe();
        }
        if (this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYy() != null && this.fFY.getPbData().aYA() != null) {
            com.baidu.tbadk.distribute.a.Kp().a(getPageContext().getPageActivity(), "pb", this.fFY.getPbData().aYy().getId(), com.baidu.adp.lib.g.b.c(this.fFY.getPbData().aYA().getId(), 0L));
        }
        if (this.dwG != null) {
            this.dwG.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.fFM && this.fFZ != null) {
            this.fFM = true;
            this.fFZ.bdP();
            a(false, (PostData) null);
        }
        if (this.fFY != null) {
            this.fFY.cancelLoadData();
            this.fFY.destory();
            if (this.fFY.bcb() != null) {
                this.fFY.bcb().onDestroy();
            }
        }
        if (this.fGm != null) {
            this.fGm.onDestroy();
        }
        if (this.cQq != null) {
            this.cQq.cancelLoadData();
        }
        if (this.fFZ != null) {
            this.fFZ.onDestroy();
            if (this.fFZ.fOH != null) {
                this.fFZ.fOH.aNe();
            }
        }
        if (this.fFN != null) {
            this.fFN.onDestroy();
        }
        if (this.fFE != null) {
            this.fFE.OP();
        }
        super.onDestroy();
        if (this.dwG != null) {
            this.dwG.onDestory(getPageContext());
        }
        this.fFZ.bdK();
        MessageManager.getInstance().unRegisterListener(this.fGT);
        MessageManager.getInstance().unRegisterListener(this.fGU);
        MessageManager.getInstance().unRegisterListener(this.fGV);
        MessageManager.getInstance().unRegisterListener(this.fGt);
        MessageManager.getInstance().unRegisterListener(this.fGW);
        MessageManager.getInstance().unRegisterListener(this.dxN);
        this.fGr = null;
        this.fGs = null;
        com.baidu.tieba.recapp.e.a.bud().buf();
        if (this.fGu != null) {
            getSafeHandler().removeCallbacks(this.fGu);
        }
        if (this.fFV != null) {
            this.fFV.cancelLoadData();
        }
        if (this.fFZ != null && this.fFZ.fOH != null) {
            this.fFZ.fOH.beF();
        }
        if (this.dJg != null) {
            this.dJg.cancelLoadData();
        }
        this.fGe.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        h bdr;
        ArrayList<PostData> bbd;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.Fg() && this.fFZ != null && (bdr = this.fFZ.bdr()) != null && (bbd = bdr.bbd()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bbd.iterator();
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
                        bVar.bAL = id;
                        bVar.cSe = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aNW == 1 && !TextUtils.isEmpty(id)) {
                    next.aNW = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bAL = id;
                    bVar2.cSe = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fFY == null || this.fFY.getPbData() == null || this.fFY.getPbData().aYy() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fFY.getPbData().aYy().getFirst_class();
                    str2 = this.fFY.getPbData().aYy().getSecond_class();
                    str = this.fFY.getPbData().aYy().getId();
                    str4 = this.fFY.bbB();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Fj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fFZ.onChangeSkinType(i);
            if (this.fGm != null && this.fGm.KF() != null) {
                this.fGm.KF().onChangeSkinType(i);
            }
            if (this.fFZ.bcX() != null) {
                this.fFZ.bcX().onChangeSkinType(getPageContext(), i);
            }
            this.fGe.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fFZ = new as(this, this.dyk, this.bJy);
        this.ckD = new com.baidu.tieba.e.b(getActivity());
        this.ckD.a(this.fHj);
        this.ckD.a(this.ckE);
        this.fFZ.setOnScrollListener(this.mOnScrollListener);
        this.fFZ.d(this.fHd);
        this.fFZ.a(this.bSR);
        this.fFZ.jA(com.baidu.tbadk.core.i.wB().wH());
        this.fFZ.setOnImageClickListener(this.bJx);
        this.fFZ.a(this.bjN);
        this.fFZ.h(this.duP);
        this.fFZ.a(this.fHb);
        this.fFZ.kp(this.mIsLogin);
        if (getIntent() != null) {
            this.fFZ.setIsInterviewLive(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean co(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.hiI == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.i.wB().wH()) {
                    return false;
                }
                return pV(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.fFZ != null) {
            if (z && (!this.fje || this.fGq)) {
                bay();
            } else {
                hideLoadingView(this.fFZ.getView());
            }
            this.fGq = false;
            if (z && this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYZ() && this.fFZ.getView() != null) {
                this.fFZ.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void baf() {
        if (this.fFJ == null) {
            this.fFJ = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fFJ.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0074b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fFm = PbActivity.this.fFm.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fFm);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fFY.bbB(), PbActivity.this.fFm, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fFm = PbActivity.this.fFm.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fFm);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fFY.bbB(), PbActivity.this.fFm, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fFm = PbActivity.this.fFm.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fFm);
                        bVar.dismiss();
                    }
                }
            }).fh(b.a.aQl).fi(17).d(getPageContext());
        }
    }

    private void w(Bundle bundle) {
        this.fFY = new PbModel(this);
        this.fFY.a(this.fGY);
        if (this.fFY.bbZ() != null) {
            this.fFY.bbZ().a(this.fHl);
        }
        if (this.fFY.bbY() != null) {
            this.fFY.bbY().a(this.fGJ);
        }
        if (this.fFY.bcb() != null) {
            this.fFY.bcb().b(this.fGD);
        }
        if (bundle != null) {
            this.fFY.initWithBundle(bundle);
        } else {
            this.fFY.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fFY.ka(true);
        }
        aj.bcJ().R(this.fFY.bbz(), this.fFY.getIsFromMark());
        if (StringUtils.isNull(this.fFY.bbB())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fFS)) {
            this.fFY.tc(6);
        }
        this.fFY.Na();
    }

    private void initData(Bundle bundle) {
        this.fgs = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fgs != null) {
            this.fgs.a(this.fHa);
        }
        this.cQq = new ForumManageModel(this);
        this.cQq.setLoadDataCallBack(this.cQu);
        this.bdv = new com.baidu.tbadk.coreExtra.model.a(null);
        this.fFZ.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void ak(Object obj) {
                if (!com.baidu.adp.lib.util.j.oI()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fFY.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fFY.getPbData().aYy().getId(), PbActivity.this.fFY.getPbData().aYy().getName(), PbActivity.this.fFY.getPbData().aYA().getId(), valueOf, str, str2)));
            }
        });
        this.fGP.setUniqueId(getUniqueId());
        this.fGP.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fFZ.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fGt;
        userMuteCheckCustomMessage.setTag(this.fGt);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bag() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.fFY != null && (pbData = this.fFY.getPbData()) != null) {
            return pbData.aYM().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aYA() != null) {
            if (fVar.aYA().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aYA().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aYA().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData cp(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bCA()) {
                postData.cX(postData.bCz() - 1);
            } else {
                postData.cX(postData.bCz() + 1);
            }
            postData.ny(!postData.bCA());
            ((PbFloorAgreeView) view).a(postData.bCA(), postData.bCz(), true);
            final int i = postData.bCA() ? 0 : 1;
            this.fFY.bca().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void sO(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).tm(i2);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void c(CustomDialogData customDialogData) {
                    customDialogData.type = 0;
                    com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                }
            });
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.ak bah() {
        return new com.baidu.tbadk.core.util.ak("c12003").ab("tid", this.fFY.fKN).s("obj_type", 0).ab(ImageViewerConfig.FORUM_ID, this.fFY.getForumId()).s("obj_param1", this.fFY.getPbData().aYA().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
                @Override // java.lang.Runnable
                public void run() {
                    int s;
                    int aq = (com.baidu.adp.lib.util.l.aq(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        s = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.s(PbActivity.this.getPageContext().getPageActivity(), d.e.ds120);
                    } else {
                        s = com.baidu.adp.lib.util.l.s(PbActivity.this.getPageContext().getPageActivity(), d.e.ds640);
                    }
                    int i = s - aq;
                    if (i > 0) {
                        PbActivity.this.bad().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bad().bda() != null) {
                        PbActivity.this.fGm.KF().setVisibility(8);
                        PbActivity.this.bad().bda().bH(str, str2);
                        com.baidu.tbadk.editortools.pb.h bbs = PbActivity.this.bad().bda().bbs();
                        if (bbs != null && PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null) {
                            bbs.a(PbActivity.this.fFY.getPbData().xJ());
                        }
                        if (PbActivity.this.fGe.bem() == null && PbActivity.this.bad().bda().bbs().LF() != null) {
                            PbActivity.this.bad().bda().bbs().LF().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fGe != null && PbActivity.this.fGe.bel() != null) {
                                        if (!PbActivity.this.fGe.bel().bLp()) {
                                            PbActivity.this.fGe.kD(false);
                                        }
                                        PbActivity.this.fGe.bel().oo(false);
                                    }
                                }
                            });
                            PbActivity.this.fGe.h(PbActivity.this.bad().bda().bbs().LF().getInputView());
                            PbActivity.this.bad().bda().bbs().a(PbActivity.this.fGp);
                        }
                    }
                    PbActivity.this.bad().bdT();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.fFY != null && this.fFY.getPbData() != null && postData.bCl() > 1) {
            String bbB = this.fFY.bbB();
            String id = postData.getId();
            int aYN = this.fFY.getPbData() != null ? this.fFY.getPbData().aYN() : 0;
            c pW = pW(id);
            if (pW != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bbB, id, "pb", true, null, false, null, aYN, postData.bfu(), this.fFY.getPbData().xJ(), false, postData.yX() != null ? postData.yX().getIconInfo() : null).addBigImageData(pW.fHQ, pW.fHR, pW.fHS, pW.index);
                addBigImageData.setKeyPageStartFrom(this.fFY.bch());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        ap apVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.oZ()) {
                showToast(d.j.no_network_guide);
            } else if (aZK() != null && aZK().getPbData() != null && aZK().getPbData().aYY() != null) {
                com.baidu.tieba.pb.data.l aYY = aZK().getPbData().aYY();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof ap)) {
                    apVar = null;
                } else {
                    apVar = (ap) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aYY != null) {
                    int i3 = -1;
                    if (z) {
                        aYY.sE(i);
                    } else if (aYY.aZj()) {
                        aYY.aZm();
                        i3 = 1;
                    } else {
                        aYY.sG(i);
                        i3 = 0;
                    }
                    aYY.sF(i2);
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void sO(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.fFY != null && this.fFY.bca() != null) {
                        String str = "";
                        if (this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null) {
                            str = this.fFY.getPbData().aYA().zo();
                        }
                        if (this.fFY.getPbData() != null) {
                            this.fFY.getPbData().a(aYY);
                        }
                        if (z) {
                            this.fFY.bca().a(str, 3, i, this.fFY.getForumId(), aVar);
                        } else {
                            this.fFY.bca().a(str, i3, 3, i, this.fFY.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.fCF = i3;
                            kVar.fCG = aYY;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (apVar != null) {
                        apVar.b(aYY);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bai() {
        if (this.fFY.getPbData() == null || this.fFY.getPbData().aYA() == null) {
            return -1;
        }
        return this.fFY.getPbData().aYA().zB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baj() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.qv(this.fFY.getForumId()) && this.fFY.getPbData() != null && this.fFY.getPbData().aYy() != null) {
            if (this.fFY.getPbData().aYy().isLike() == 1) {
                baz();
                this.fFY.bcd().bK(this.fFY.getForumId(), this.fFY.bbB());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jH(boolean z) {
        if (this.fFY == null || this.fFY.getPbData() == null) {
            return false;
        }
        return ((this.fFY.getPbData().aYN() != 0) || this.fFY.getPbData().aYA() == null || this.fFY.getPbData().aYA().yX() == null || TextUtils.equals(this.fFY.getPbData().aYA().yX().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bak() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.o.q.Ou()) {
            return "";
        }
        PostData aYI = aYI();
        if (this.fFY == null || (pbData = this.fFY.getPbData()) == null || pbData.getUserData() == null || pbData.aYA() == null || aYI == null || aYI.yX() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aYI.yX().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aYA().yF() == 0) {
            return "";
        }
        if (pbData.aYA().yF() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean jI(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fFY == null || this.fFY.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.fFY.getPbData();
        if (pbData.aYN() == 0) {
            List<az> aYW = pbData.aYW();
            if (com.baidu.tbadk.core.util.v.F(aYW) > 0) {
                for (az azVar : aYW) {
                    if (azVar != null && (tVar = azVar.aMT) != null && tVar.aKY && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
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

    private boolean jJ(boolean z) {
        return (z || this.fFY == null || this.fFY.getPbData() == null || this.fFY.getPbData().aYN() == 0) ? false : true;
    }

    public void bal() {
        if (this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null && this.fFY.getPbData().aYA().yX() != null) {
            if (this.fFZ != null) {
                this.fFZ.bcY();
            }
            be aYA = this.fFY.getPbData().aYA();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aYA.yX().getUserId());
            ab abVar = new ab();
            int aYN = this.fFY.getPbData().aYN();
            if (aYN == 1) {
                abVar.fMP = true;
                abVar.fMO = true;
                abVar.fMW = aYA.yS() == 1;
                abVar.fMV = aYA.yT() == 1;
            } else {
                abVar.fMP = false;
                abVar.fMO = false;
            }
            if (aYN == 1002 && !equals) {
                abVar.fNa = true;
            }
            abVar.fML = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            abVar.fMQ = jI(equals);
            abVar.fMR = bam();
            abVar.fMS = jJ(equals);
            abVar.fMM = this.fFY.bbC();
            abVar.fMN = true;
            abVar.fCV = this.fgs != null && this.fgs.vk();
            abVar.fMK = jH(equals);
            abVar.fMY = bak();
            abVar.fMJ = equals && this.fFZ.bdE();
            abVar.fMT = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fMU = true;
            abVar.isHostOnly = this.fFY.getHostMode();
            abVar.fMX = true;
            if (aYA.zp() == null) {
                abVar.fMZ = true;
            } else {
                abVar.fMZ = false;
            }
            this.fFZ.fOH.a(abVar);
        }
    }

    private boolean bam() {
        if (this.fFY != null && this.fFY.bbC()) {
            return this.fFY.aCL() == null || this.fFY.aCL().xY() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
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

    public int ban() {
        if (bad() == null || bad().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bad().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) iVar).mType == com.baidu.tieba.pb.data.j.fCB) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bao() {
        if (bad() == null || bad().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bad().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof PostData) && iVar.getType() == PostData.hiG) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        bax();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cY(getResources().getString(d.j.mark_done));
            aVar.bc(true);
            aVar.cZ(getResources().getString(d.j.mark_like));
            aVar.bb(true);
            aVar.aV(false);
            aVar.b(getResources().getString(d.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ab("obj_id", metaData.getUserId()).s("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ab("obj_id", metaData.getUserId()).s("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.bdv.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fFY.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).AI();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fFZ.bdx();
        this.fFY.jZ(z);
        if (this.fgs != null) {
            this.fgs.aH(z);
            if (markData != null) {
                this.fgs.a(markData);
            }
        }
        if (this.fFY.vk()) {
            bau();
        } else {
            this.fFZ.p(this.fFY.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sJ(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pT(String str) {
        if (!StringUtils.isNull(str) && this.fFY != null) {
            String bbB = this.fFY.bbB();
            String id = this.fFY.getPbData().aYy().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + bbB + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fFY.bbI()) {
                    antiData.setBlock_forum_name(this.fFY.getPbData().aYy().getName());
                    antiData.setBlock_forum_id(this.fFY.getPbData().aYy().getId());
                    antiData.setUser_name(this.fFY.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fFY.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.xo(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", ap.a.aVX));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", ap.a.aVX));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", ap.a.aVX));
            }
        } else if (i == 230277) {
            gj(str);
        } else {
            this.fFZ.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.fFZ.a(0, bVar.aot, bVar.hlb, z);
            if (bVar.aot) {
                if (bVar.hkZ == 1) {
                    ArrayList<PostData> aYC = this.fFY.getPbData().aYC();
                    int size = aYC.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aYC.get(i).getId())) {
                            i++;
                        } else {
                            aYC.remove(i);
                            break;
                        }
                    }
                    this.fFZ.p(this.fFY.getPbData());
                } else if (bVar.hkZ == 0) {
                    bap();
                } else if (bVar.hkZ == 2) {
                    ArrayList<PostData> aYC2 = this.fFY.getPbData().aYC();
                    int size2 = aYC2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aYC2.get(i2).bCi().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aYC2.get(i2).bCi().get(i3).getId())) {
                                i3++;
                            } else {
                                aYC2.get(i2).bCi().remove(i3);
                                aYC2.get(i2).bCk();
                                z2 = true;
                                break;
                            }
                        }
                        aYC2.get(i2).td(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fFZ.p(this.fFY.getPbData());
                    }
                    a(bVar, this.fFZ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fFZ.a(this.cQq.getLoadDataMode(), gVar.aot, gVar.hlb, false);
            if (gVar.aot) {
                this.fGb = true;
                if (i == 2 || i == 3) {
                    this.fGc = true;
                    this.fGd = false;
                } else if (i == 4 || i == 5) {
                    this.fGc = false;
                    this.fGd = true;
                }
                if (i == 2) {
                    this.fFY.getPbData().aYA().eT(1);
                    this.fFY.setIsGood(1);
                } else if (i == 3) {
                    this.fFY.getPbData().aYA().eT(0);
                    this.fFY.setIsGood(0);
                } else if (i == 4) {
                    this.fFY.getPbData().aYA().eS(1);
                    this.fFY.lO(1);
                } else if (i == 5) {
                    this.fFY.getPbData().aYA().eS(0);
                    this.fFY.lO(0);
                }
                this.fFZ.c(this.fFY.getPbData(), this.fFY.bbC());
                if (this.fFY.getPbData().aYN() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void bap() {
        if (this.fFY.bbD() || this.fFY.bbF()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fFY.bbB());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.fFY.bbB()));
        if (bav()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baq() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aYK;
        boolean z = true;
        if (this.fFZ != null) {
            this.fFZ.bdK();
        }
        if (this.fFY != null && this.fFY.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fFY.getPbData().aYA().getId();
            if (this.fFY.isShareThread() && this.fFY.getPbData().aYA().aPb != null) {
                historyMessage.threadName = this.fFY.getPbData().aYA().aPb.showText;
            } else {
                historyMessage.threadName = this.fFY.getPbData().aYA().getTitle();
            }
            if (this.fFY.isShareThread() && !baP()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fFY.getPbData().aYy().getName();
            }
            ArrayList<PostData> aYC = this.fFY.getPbData().aYC();
            int bdz = this.fFZ != null ? this.fFZ.bdz() : 0;
            if (aYC != null && bdz >= 0 && bdz < aYC.size()) {
                historyMessage.postID = aYC.get(bdz).getId();
            }
            historyMessage.isHostOnly = this.fFY.getHostMode();
            historyMessage.isSquence = this.fFY.bbC();
            historyMessage.isShareThread = this.fFY.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fGm != null) {
            this.fGm.onDestroy();
        }
        if (this.fFH && bad() != null) {
            bad().bef();
        }
        if (this.fFY != null && (this.fFY.bbD() || this.fFY.bbF())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fFY.bbB());
            if (this.fGb) {
                if (this.fGd) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fFY.bbH());
                }
                if (this.fGc) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fFY.getIsGood());
                }
            }
            if (this.fFY.getPbData() != null && System.currentTimeMillis() - this.fFL >= 40000 && (aYK = this.fFY.getPbData().aYK()) != null && !com.baidu.tbadk.core.util.v.G(aYK.getDataList())) {
                intent.putExtra("guess_like_data", aYK);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fGA);
            }
            setResult(-1, intent);
        }
        if (bav()) {
            if (this.fFY != null && this.fFZ != null && this.fFZ.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.fFY.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aYH() && !this.fFR) {
                        aj bcJ = aj.bcJ();
                        com.baidu.tieba.pb.data.f pbData2 = this.fFY.getPbData();
                        Parcelable onSaveInstanceState = this.fFZ.getListView().onSaveInstanceState();
                        boolean bbC = this.fFY.bbC();
                        boolean hostMode = this.fFY.getHostMode();
                        if (this.fFZ.bdi() == null || this.fFZ.bdi().getVisibility() != 0) {
                            z = false;
                        }
                        bcJ.a(pbData2, onSaveInstanceState, bbC, hostMode, z);
                        if (this.fGz >= 0 || this.fFY.bcj() != null) {
                            aj.bcJ().j(this.fFY.bcj());
                            aj.bcJ().i(this.fFY.bck());
                            aj.bcJ().te(this.fFY.bcl());
                        }
                    }
                }
            } else {
                aj.bcJ().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fFZ == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fFZ.th(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sL(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fFZ.bcY();
            this.fFZ.bda().bbm();
            this.fFZ.ky(false);
        }
        this.fFZ.bdb();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fGm.resetData();
                        this.fGm.b(writeData);
                        this.fGm.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.r hN = this.fGm.KF().hN(6);
                        if (hN != null && hN.bpR != null) {
                            hN.bpR.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fGm.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fFZ.bda() != null && this.fFZ.bda().bbq() != null) {
                            com.baidu.tbadk.editortools.pb.h bbq = this.fFZ.bda().bbq();
                            bbq.b(writeData);
                            bbq.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.r hN2 = bbq.KF().hN(6);
                            if (hN2 != null && hN2.bpR != null) {
                                hN2.bpR.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bbq.Lx();
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
        this.fGm.onActivityResult(i, i2, intent);
        if (this.fFV != null) {
            this.fFV.onActivityResult(i, i2, intent);
        }
        if (bad().bda() != null) {
            bad().bda().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bat();
                    return;
                case 13008:
                    aj.bcJ().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fFY != null) {
                                PbActivity.this.fFY.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.fFY != null) {
                        a(bas(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    M(intent);
                    return;
                case 24006:
                    T(intent);
                    return;
                case 24007:
                    if (bai() == 1) {
                        bar();
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        baj();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dJg != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dJg.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void Hl() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54.1
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
                    this.fFZ.jF(false);
                    if (this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null && this.fFY.getPbData().aYA().zs() != null) {
                        this.fFY.getPbData().aYA().zs().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fFZ != null && this.fFZ.fOH != null) {
                        this.fFZ.fOH.vU();
                        this.fFZ.fOH.bez();
                        if (this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null) {
                            this.fFY.getPbData().aYA().eO(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fFW != null) {
                        this.fFZ.cy(this.fFW);
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

    private void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.fFV == null) {
                this.fFV = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fFV.b(this.brI);
                this.fFV.c(this.brP);
            }
            this.fFV.a(emotionImageData, aZK(), aZK().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bar() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null && this.fFY.getPbData().aYA().zj() != null && this.fFY.getPbData().aYA().zj().size() > 0 && this.fFY.getPbData().aYA().zj().get(0) != null) {
            this.mAwardActId = this.fFY.getPbData().aYA().zj().get(0).wV();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.fFY.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void T(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    sN(2);
                    return;
                case 2:
                    this.fFZ.bdp();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData bas() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bX = this.fFY.getPbData().bX(getPageContext().getPageActivity());
        PostData bdd = this.fFZ.bdd();
        String str = "";
        if (bdd != null) {
            str = bdd.getId();
            String cp = bdd.cp(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(cp)) {
                bX[1] = cp;
            }
        }
        String zo = this.fFY.getPbData().aYA().zo();
        if (zo != null && zo.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bX[1]);
        shareFromPBMsgData.setImageUrl(bX[0]);
        shareFromPBMsgData.setForumName(this.fFY.getPbData().aYy().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fFY.getPbData().aYA().getId());
        shareFromPBMsgData.setTitle(this.fFY.getPbData().aYA().getTitle());
        return shareFromPBMsgData;
    }

    private void M(Intent intent) {
        a(bas(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.ff(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ab = new com.baidu.tbadk.core.util.ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_param1", 3).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fFY.getForumId()).ab("tid", PbActivity.this.fFY.bbB());
                        if (PbActivity.this.e(PbActivity.this.fFY.getPbData()) != 0) {
                            ab.s("obj_type", PbActivity.this.e(PbActivity.this.fFY.getPbData()));
                        }
                        TiebaStatic.log(ab);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.bai() == 1) {
                        PbActivity.this.bar();
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aW(true);
            aVar.b(getPageContext()).AI();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), this.fFY.getPbData().aYO() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.ff(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.bai() == 1) {
                        PbActivity.this.bar();
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aW(true);
            aVar.b(getPageContext()).AI();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), this.fFY.getPbData().aYO() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bat() {
        MarkData tb;
        if (this.fgs != null && (tb = this.fFY.tb(this.fFZ.bdA())) != null) {
            if (!tb.isApp() || (tb = this.fFY.tb(this.fFZ.bdA() + 1)) != null) {
                this.fFZ.bdv();
                this.fgs.a(tb);
                if (!this.fgs.vk()) {
                    this.fgs.vm();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fgs.vl();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bau() {
        com.baidu.tieba.pb.data.f pbData = this.fFY.getPbData();
        this.fFY.jZ(true);
        if (this.fgs != null) {
            pbData.pQ(this.fgs.vj());
        }
        this.fFZ.p(pbData);
    }

    private boolean bav() {
        if (this.fFY == null) {
            return true;
        }
        if (this.fFY.vk()) {
            final MarkData bbQ = this.fFY.bbQ();
            if (bbQ == null || !this.fFY.getIsFromMark()) {
                return true;
            }
            final MarkData tb = this.fFY.tb(this.fFZ.bdz());
            if (tb == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bbQ);
                setResult(-1, intent);
                return true;
            } else if (tb.getPostId() == null || tb.getPostId().equals(bbQ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bbQ);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cZ(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fgs != null) {
                            if (PbActivity.this.fgs.vk()) {
                                PbActivity.this.fgs.vl();
                                PbActivity.this.fgs.aH(false);
                            }
                            PbActivity.this.fgs.a(tb);
                            PbActivity.this.fgs.aH(true);
                            PbActivity.this.fgs.vm();
                        }
                        bbQ.setPostId(tb.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bbQ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.baq();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bbQ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.baq();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fFZ != null && PbActivity.this.fFZ.getView() != null) {
                            PbActivity.this.fFZ.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bbQ);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.baq();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.AI();
                return false;
            }
        } else if (this.fFY.getPbData() == null || this.fFY.getPbData().aYC() == null || this.fFY.getPbData().aYC().size() <= 0 || !this.fFY.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fFZ == null) {
            return null;
        }
        return this.fFZ.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Rt() {
        if (this.fFZ == null) {
            return 0;
        }
        return this.fFZ.bdI();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Ru() {
        if (this.bJo == null) {
            this.bJo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: agz */
                public ImageView nk() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean wH = com.baidu.tbadk.core.i.wB().wH();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.C0108d.common_color_10220));
                    if (wH) {
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
                public void as(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0108d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView at(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.wB().wH()) {
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
                public ImageView au(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0108d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bJo;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Rv() {
        if (this.bJp == null) {
            this.bJp = TbRichTextView.x(getPageContext().getPageActivity(), 8);
        }
        return this.bJp;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Rw() {
        if (this.bJt == null) {
            this.bJt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baR */
                public GifView nk() {
                    return new GifView(PbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void as(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView at(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView au(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.LX();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bJt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Rx() {
        if (this.bJq == null) {
            this.bJq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baS */
                public View nk() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cs */
                public void as(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ct */
                public View at(View view) {
                    ((PlayVoiceBntNew) view).bDs();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cu */
                public View au(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bJq;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Rz() {
        this.bJs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: baT */
            public RelativeLayout nk() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void as(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout at(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout au(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bJs;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Em() {
        if (this.bcT == null) {
            this.bcT = UserIconBox.v(getPageContext().getPageActivity(), 8);
        }
        return this.bcT;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fFP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        if (ax.qi(str) && this.fFY != null && this.fFY.bbB() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").s("obj_param1", 1).ab("post_id", this.fFY.bbB()));
        }
        ax.beo().f(getPageContext(), str);
        this.fFP = true;
    }

    private com.baidu.tbadk.core.dialog.a baw() {
        if (this.fFK == null) {
            this.fFK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.fFK.cY(getPageContext().getString(d.j.download_baidu_video_dialog));
            this.fFK.a(getPageContext().getString(d.j.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.lk()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.BH());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.j.download_baidu_video));
                    }
                }
            });
            this.fFK.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fFK.aV(true);
            this.fFK.b(getPageContext());
            this.fFK.aW(false);
        }
        this.fFK.AI();
        return this.fFK;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        ax.beo().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fFP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ab(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            baw();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.fFP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.fFY.getPbData();
            TbRichText aw = aw(str, i);
            if (aw != null && (tbRichTextData = aw.QN().get(this.fHe)) != null) {
                cVar.fHQ = new ArrayList<>();
                cVar.fHR = new ConcurrentHashMap<>();
                if (!tbRichTextData.QT().Rf()) {
                    cVar.fHT = false;
                    String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                    cVar.fHQ.add(b2);
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
                    imageUrlData.postId = aw.getPostId();
                    imageUrlData.mIsReserver = this.fFY.bbP();
                    imageUrlData.mIsSeeHost = this.fFY.getHostMode();
                    cVar.fHR.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aYy() != null) {
                            cVar.forumName = pbData.aYy().getName();
                            cVar.forumId = pbData.aYy().getId();
                        }
                        if (pbData.aYA() != null) {
                            cVar.threadId = pbData.aYA().getId();
                        }
                        cVar.fHS = pbData.aYO() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fHT = true;
                int size = pbData.aYC().size();
                this.fHf = false;
                cVar.index = -1;
                if (pbData.aYI() != null) {
                    PostData aYI = pbData.aYI();
                    TbRichText bCo = aYI.bCo();
                    if (!ar.k(aYI)) {
                        i2 = a(bCo, aw, i, i, cVar.fHQ, cVar.fHR);
                    } else {
                        i2 = a(aYI, i, cVar.fHQ, cVar.fHR);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aYC().get(i4);
                    if (postData.getId() == null || pbData.aYI() == null || pbData.aYI().getId() == null || !postData.getId().equals(pbData.aYI().getId())) {
                        TbRichText bCo2 = postData.bCo();
                        if (!ar.k(postData)) {
                            i3 = a(bCo2, aw, i3, i, cVar.fHQ, cVar.fHR);
                        } else {
                            i3 = a(postData, i3, cVar.fHQ, cVar.fHR);
                        }
                    }
                }
                if (cVar.fHQ.size() > 0) {
                    cVar.lastId = cVar.fHQ.get(cVar.fHQ.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aYy() != null) {
                        cVar.forumName = pbData.aYy().getName();
                        cVar.forumId = pbData.aYy().getId();
                    }
                    if (pbData.aYA() != null) {
                        cVar.threadId = pbData.aYA().getId();
                    }
                    cVar.fHS = pbData.aYO() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QT() == null) {
            return null;
        }
        return tbRichTextData.QT().Rk();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QT() == null) {
            return 0L;
        }
        return tbRichTextData.QT().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QT() == null) {
            return false;
        }
        return tbRichTextData.QT().Rl();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QT() == null) {
            return false;
        }
        return tbRichTextData.QT().Rm();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo QT;
        String str;
        if (tbRichText == tbRichText2) {
            this.fHf = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.QN().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.QN().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.QT().getWidth() * ar;
                    int height = ar * tbRichTextData.QT().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.QT().Rf()) {
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
                        String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                            if (tbRichTextData != null && (QT = tbRichTextData.QT()) != null) {
                                String Rh = QT.Rh();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = QT.Ri();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = Rh;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fFY.bbB(), -1L);
                                imageUrlData.mIsReserver = this.fFY.bbP();
                                imageUrlData.mIsSeeHost = this.fFY.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fHf) {
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
        com.baidu.tieba.tbadkCore.data.h bCv;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bBQ;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bBQ = (bCv = postData.bCv()).bBQ()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bBQ.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bBQ.get(i3);
                if (jVar != null) {
                    String bBU = jVar.bBU();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bBU)) {
                        arrayList.add(bBU);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bBU;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bBT();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fFY.bbB(), -1L);
                        imageUrlData.mIsReserver = this.fFY.bbP();
                        imageUrlData.mIsSeeHost = this.fFY.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bCv.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bBU, imageUrlData);
                        }
                        if (!this.fHf) {
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
            if (postData.getId() != null && postData.getId().equals(this.fFY.zh())) {
                z = true;
            }
            MarkData h = this.fFY.h(postData);
            if (h != null) {
                this.fFZ.bdv();
                if (this.fgs != null) {
                    this.fgs.a(h);
                    if (!z) {
                        this.fgs.vm();
                    } else {
                        this.fgs.vl();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aw(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fFY == null || this.fFY.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.fFY.getPbData();
        if (pbData.aYI() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aYI());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aYC = pbData.aYC();
            a(pbData, aYC);
            return a(aYC, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aYM() != null && fVar.aYM().fCX != null && (list = fVar.aYM().fCX) != null && arrayList != null) {
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

    private long pU(String str) {
        ArrayList<PostData> aYC;
        com.baidu.tieba.pb.data.f pbData = this.fFY.getPbData();
        if (pbData != null && (aYC = pbData.aYC()) != null && !aYC.isEmpty()) {
            Iterator<PostData> it = aYC.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bCv = next.bCv();
                if (bCv != null && bCv.hio) {
                    Iterator<TbRichTextData> it2 = next.bCo().QN().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Rc().getLink().equals(str)) {
                            return bCv.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> QN;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bCo = arrayList.get(i2).bCo();
            if (bCo != null && (QN = bCo.QN()) != null) {
                int size = QN.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (QN.get(i4) != null && QN.get(i4).getType() == 8) {
                        i3++;
                        if (QN.get(i4).QT().Rh().equals(str) || QN.get(i4).QT().Ri().equals(str)) {
                            int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                            int width = QN.get(i4).QT().getWidth() * ar;
                            int height = QN.get(i4).QT().getHeight() * ar;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fHe = i4;
                            return bCo;
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
    public void h(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.fFm = str;
            if (this.fFJ == null) {
                baf();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fFJ.fl(1).setVisibility(8);
            } else {
                this.fFJ.fl(1).setVisibility(0);
            }
            this.fFJ.AL();
            this.fFP = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dwG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bax() {
        hideNetRefreshView(this.fFZ.getView());
        bay();
        if (this.fFY.Na()) {
            this.fFZ.bdv();
        }
    }

    private void bay() {
        showLoadingView(this.fFZ.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View Mt = getLoadingView().Mt();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Mt.getLayoutParams();
        layoutParams.addRule(3, this.fFZ.bdY().getId());
        Mt.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atk() {
        if (this.dwG != null) {
            this.dwG.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sM(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sN(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fFY.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.fFY.getPbData();
            pbData.aYy().getName();
            String title = pbData.aYA().getTitle();
            int i2 = this.fFY.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aYy() != null) {
                if ((pbData.aYy().isLike() == 1) && AddExperiencedModel.qv(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fFY.bbB() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bX = pbData.bX(getPageContext().getPageActivity());
                    str = bX[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bX[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bai() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ab(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                    } else if (bai() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ab(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.biF = true;
                    dVar.biJ = z;
                    dVar.extData = this.fFY.bbB();
                    dVar.biT = 3;
                    dVar.biS = i;
                    dVar.fid = this.fFY.getForumId();
                    dVar.tid = this.fFY.bbB();
                    dVar.biU = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.biN = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fFY.getPbData().aYA());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.biT);
                    bundle.putInt("obj_type", dVar.biU);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.h(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYZ()) {
                                PbActivity.this.fFZ.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    if (this.bbW == null) {
                        this.bbW = new com.baidu.tieba.d.c(getActivity());
                    }
                    this.bbW.a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fFY.bbB() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bX2 = pbData.bX(getPageContext().getPageActivity());
            str = bX2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bX2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bai() != 1) {
            }
            if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.biF = true;
            dVar2.biJ = z;
            dVar2.extData = this.fFY.bbB();
            dVar2.biT = 3;
            dVar2.biS = i;
            dVar2.fid = this.fFY.getForumId();
            dVar2.tid = this.fFY.bbB();
            dVar2.biU = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fFY.getPbData().aYA());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.biT);
            bundle2.putInt("obj_type", dVar2.biU);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.h(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fFY != null && PbActivity.this.fFY.getPbData() != null && PbActivity.this.fFY.getPbData().aYZ()) {
                        PbActivity.this.fFZ.getView().setSystemUiVisibility(4);
                    }
                }
            });
            if (this.bbW == null) {
            }
            this.bbW.a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aYA() != null) {
            if (fVar.aYA().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aYA().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void baz() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.qw(PbActivity.this.fFY.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fFZ.beg();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Ry() {
        if (this.bJr == null) {
            this.bJr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baU */
                public LinearLayout nk() {
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
                public void as(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout at(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout au(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.bJr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fFZ.bdq() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, this.fFY.getPbData().getForumId()));
            } else {
                be aYA = this.fFY.getPbData().aYA();
                if (view != null) {
                    boolean z = aYA.yM() == null || aYA.yM().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fGQ > 1000) {
                            this.fGR = true;
                            cr(view);
                        } else {
                            this.fGR = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            s(view, this.fGR);
                        } else {
                            r(view, this.fGR);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        r(view, this.fGR);
                    } else if (motionEvent.getAction() == 3) {
                        r(view, this.fGR);
                    }
                }
            }
        }
        return false;
    }

    private void r(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fGQ = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void s(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fGQ = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void cr(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void atl() {
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
        } else if (aVar.AK() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.AK();
            int intValue = ((Integer) sparseArray.get(as.fQu)).intValue();
            if (intValue == as.fQv) {
                if (!this.cQq.bCZ()) {
                    this.fFZ.bds();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cQq.a(this.fFY.getPbData().aYy().getId(), this.fFY.getPbData().aYy().getName(), this.fFY.getPbData().aYA().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == as.fQw || intValue == as.fQy) {
                if (this.fFY.bbZ() != null) {
                    this.fFY.bbZ().sR(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == as.fQw) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == as.fQx) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.fHk).wQ()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fGt);
        userMuteAddAndDelCustomMessage.setTag(this.fGt);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pV(String str) {
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.ax.be(getPageContext().getPageActivity())) {
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

    public void jK(boolean z) {
        this.fGh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String baA() {
        ArrayList<PostData> aYC;
        int F;
        if (this.fFY == null || this.fFY.getPbData() == null || this.fFY.getPbData().aYC() == null || (F = com.baidu.tbadk.core.util.v.F((aYC = this.fFY.getPbData().aYC()))) == 0) {
            return "";
        }
        if (this.fFY.bbP()) {
            Iterator<PostData> it = aYC.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bCl() == 1) {
                    return next.getId();
                }
            }
        }
        int bdz = this.fFZ.bdz();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(aYC, bdz);
        if (postData == null || postData.yX() == null) {
            return "";
        }
        if (this.fFY.pZ(postData.yX().getUserId())) {
            return postData.getId();
        }
        for (int i = bdz - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(aYC, i);
            if (postData2 == null || postData2.yX() == null || postData2.yX().getUserId() == null) {
                break;
            } else if (this.fFY.pZ(postData2.yX().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bdz + 1; i2 < F; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(aYC, i2);
            if (postData3 == null || postData3.yX() == null || postData3.yX().getUserId() == null) {
                return "";
            }
            if (this.fFY.pZ(postData3.yX().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ac(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.av.Di().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(pU(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fFY.getPbData().aYy().getId(), this.fFY.getPbData().aYy().getName(), this.fFY.getPbData().aYA().getTid());
            }
            this.fFP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cZ(getResources().getString(d.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cZ(getResources().getString(d.j.make_sure_hide));
        }
        aVar.a(getResources().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fFY.bbY() != null) {
                    PbActivity.this.fFY.bbY().cG(j);
                }
            }
        });
        aVar.b(getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.aW(false);
        aVar.b(getPageContext());
        aVar.AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c pW(String str) {
        String str2;
        if (this.fFY.getPbData() == null || this.fFY.getPbData().aYC() == null || this.fFY.getPbData().aYC().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fFY.getPbData().aYC().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fFY.getPbData().aYC().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fFY.getPbData().aYC().get(i);
        if (postData.bCo() == null || postData.bCo().QN() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bCo().QN().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.QT() != null) {
                    str2 = next.QT().Rh();
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
        if (this.fFF) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fFF = false;
        } else if (baB()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fFF) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fFF = false;
        } else if (baB()) {
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
        if (pageStayDurationItem != null && this.fFY != null) {
            if (this.fFY.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fFY.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fFY.bbB(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean baB() {
        return (!this.fFD && this.fHm == -1 && this.fHn == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fHp = mVar;
            this.fFD = true;
            this.fFZ.bdj();
            this.fFZ.qg(this.fHo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baC() {
        if (this.fHp != null) {
            if (this.fHm == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.ax.bd(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fHp.getCartoonId(), this.fHm, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baD() {
        if (this.fHp != null) {
            if (this.fHn == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.ax.bd(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fHp.getCartoonId(), this.fHn, 0)));
                finish();
            }
        }
    }

    public int baE() {
        return this.fHm;
    }

    public int baF() {
        return this.fHn;
    }

    private void aCg() {
        if (this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null && this.fFY.getPbData().aYA().zK()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void baG() {
        if (this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null && this.fFY.getPbData().aYA().zK()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void baH() {
        if (this.fFG) {
            this.fFU = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null && this.fFY.getPbData().aYA().yD() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fFY.getPbData().aYA().yD().getThreadId(), this.fFY.getPbData().aYA().yD().getTaskId(), this.fFY.getPbData().aYA().yD().getForumId(), this.fFY.getPbData().aYA().yD().getForumName(), this.fFY.getPbData().aYA().yS(), this.fFY.getPbData().aYA().yT())));
            this.fFF = true;
            finish();
        }
    }

    public boolean baI() {
        return this.fFG;
    }

    public String baJ() {
        return this.fFS;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a baK() {
        return this.fFX;
    }

    public void jL(boolean z) {
        this.fFT = z;
    }

    public boolean baL() {
        if (this.fFY != null) {
            return this.fFY.bbD();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baM() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cZ(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fGr).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fGr.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fGr).AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fGr != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fGr.getPageActivity());
            aVar.cZ(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fGr).AI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fFZ.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fGr.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cZ(this.fGr.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cZ(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fFZ.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fGr).AI();
    }

    public void baN() {
        if (this.fFY != null && this.fFY.getPbData() != null && this.fFY.getPbData().aYA() != null && this.fFY.getPbData().aYA().Ac() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.fd(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.fFY.getPbData().aYA().Ac().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.AI();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ax.qi(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.f(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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
        if (this.fFZ != null) {
            this.fFZ.onConfigurationChanged(configuration);
        }
        if (this.fGf != null) {
            this.fGf.dismiss();
        }
    }

    public boolean baO() {
        if (this.fFY != null) {
            return this.fFY.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, as asVar) {
        boolean z;
        List<PostData> list = this.fFY.getPbData().aYM().fCX;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bCi().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bCi().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bCi().remove(i2);
                    list.get(i).bCk();
                    z = true;
                    break;
                }
            }
            list.get(i).td(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            asVar.p(this.fFY.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aZp().getId();
        List<PostData> list = this.fFY.getPbData().aYM().fCX;
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
                ArrayList<PostData> aZt = mVar.aZt();
                postData.xi(mVar.getTotalCount());
                if (postData.bCi() != null) {
                    postData.bCi().clear();
                    postData.bCi().addAll(aZt);
                }
            }
        }
        if (!this.fFY.getIsFromMark()) {
            this.fFZ.p(this.fFY.getPbData());
        }
    }

    public boolean baP() {
        if (this.fFY == null) {
            return false;
        }
        return this.fFY.baP();
    }

    public void baQ() {
        if (this.fFZ != null) {
            this.fFZ.bcY();
            atl();
        }
    }

    public PostData aYI() {
        return this.fFZ.b(this.fFY.fLg, this.fFY.bbC());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X(be beVar) {
        if (beVar != null) {
            if (beVar.isLinkThread()) {
                return 3;
            }
            if (beVar.Ae()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fGB != null && !this.fGB.isEmpty()) {
            int size = this.fGB.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fGB.get(i).onBackPressed()) {
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
            if (this.fGB == null) {
                this.fGB = new ArrayList();
            }
            if (!this.fGB.contains(aVar)) {
                this.fGB.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fGB == null) {
                this.fGB = new ArrayList();
            }
            if (!this.fGB.contains(aVar)) {
                this.fGB.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fGB != null) {
            this.fGB.remove(aVar);
        }
    }
}
