package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bi;
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
    private com.baidu.adp.lib.e.b<ImageView> bJE;
    private com.baidu.adp.lib.e.b<TextView> bJF;
    private com.baidu.adp.lib.e.b<View> bJG;
    private com.baidu.adp.lib.e.b<LinearLayout> bJH;
    private com.baidu.adp.lib.e.b<RelativeLayout> bJI;
    private com.baidu.adp.lib.e.b<GifView> bJJ;
    private com.baidu.tbadk.core.util.b.a bOI;
    private com.baidu.tieba.d.c bce;
    private com.baidu.adp.lib.e.b<TbImageView> bdh;
    private com.baidu.tieba.e.b ckT;
    private VoiceManager dBC;
    private com.baidu.tbadk.core.dialog.a fHF;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fHQ;
    private View fHR;
    public au fHZ;
    private String fHh;
    private com.baidu.tieba.pb.pb.main.a.b fHz;
    private boolean fIX;
    private y fIa;
    private boolean fIc;
    private com.baidu.tieba.tbadkCore.data.e fIf;
    private com.baidu.tbadk.editortools.pb.g fIg;
    private com.baidu.tbadk.editortools.pb.d fIh;
    private com.baidu.adp.base.e fIm;
    private com.baidu.tbadk.core.view.e fIn;
    private BdUniqueId fIo;
    private Runnable fIp;
    private aw fIq;
    private com.baidu.adp.widget.a.a fIr;
    private String fIs;
    private TbRichTextMemeInfo fIt;
    private List<a> fIw;
    private String fJj;
    private com.baidu.tbadk.core.data.m fJk;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private boolean fHy = false;
    private boolean fHA = false;
    private boolean fHB = false;
    private boolean fkY = false;
    private boolean fHC = true;
    private int fHD = 0;
    private com.baidu.tbadk.core.dialog.b fHE = null;
    private long dmS = -1;
    private long byF = 0;
    private long fHG = 0;
    private long createTime = 0;
    private long byx = 0;
    private boolean fHH = false;
    private com.baidu.tbadk.k.d fHI = null;
    private long fHJ = 0;
    private boolean fHK = false;
    private long fHL = 0;
    private String brX = null;
    private boolean fHM = false;
    private boolean isFullScreen = false;
    private String fHN = "";
    private boolean fHO = true;
    private boolean fHP = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fHS = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void W(boolean z) {
            PbActivity.this.fHU.kw(!PbActivity.this.fHO);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fHT != null && PbActivity.this.fHT.vl()) {
                        PbActivity.this.baD();
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", ap.a.aWb));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", ap.a.aWb));
        }
    };
    private PbModel fHT = null;
    private com.baidu.tbadk.baseEditMark.a fin = null;
    private ForumManageModel cVn = null;
    private com.baidu.tbadk.coreExtra.model.a bdJ = null;
    private ShareSuccessReplyToServerModel dOd = null;
    private as fHU = null;
    public final com.baidu.tieba.pb.pb.main.a.a fHV = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean fHW = false;
    private boolean fHX = false;
    private boolean fHY = false;
    private boolean fIb = false;
    private boolean fId = false;
    private boolean fIe = false;
    private boolean fIi = false;
    public boolean fIj = false;
    private com.baidu.tbadk.editortools.pb.c bsa = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void KT() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b bsb = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean KS() {
            if (PbActivity.this.fHZ == null || PbActivity.this.fHZ.bet() == null || !PbActivity.this.fHZ.bet().bEQ()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fHZ.bet().bES());
            if (PbActivity.this.fIh != null && (PbActivity.this.fIh.Lh() || PbActivity.this.fIh.Li())) {
                PbActivity.this.fIh.a(false, PbActivity.this.fHZ.bew());
            }
            PbActivity.this.fHZ.kH(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fIk = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean KS() {
            if (PbActivity.this.fHZ == null || PbActivity.this.fHZ.beu() == null || !PbActivity.this.fHZ.beu().bEQ()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fHZ.beu().bES());
            if (PbActivity.this.fHU != null && PbActivity.this.fHU.bdj() != null && PbActivity.this.fHU.bdj().bbB() != null && PbActivity.this.fHU.bdj().bbB().Li()) {
                PbActivity.this.fHU.bdj().bbB().a(PbActivity.this.fHZ.bew());
            }
            PbActivity.this.fHZ.kI(true);
            return true;
        }
    };
    private boolean fIl = false;
    private int mLastScrollState = -1;
    private boolean dCi = false;
    private int fIu = 0;
    private int fIv = -1;
    private final a fIx = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fHU != null && PbActivity.this.fHU.bdj() != null) {
                s bdj = PbActivity.this.fHU.bdj();
                if (bdj.bbx()) {
                    bdj.bbw();
                    return true;
                }
            }
            if (PbActivity.this.fHU != null && PbActivity.this.fHU.bea()) {
                PbActivity.this.fHU.beb();
                return true;
            }
            return false;
        }
    };
    private final z.a fIy = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void J(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fHU.showToast(str);
            }
        }
    };
    private final CustomMessageListener fIz = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fHT != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fIh != null) {
                    PbActivity.this.fHU.kB(PbActivity.this.fIh.La());
                }
                PbActivity.this.fHU.bdk();
                PbActivity.this.fHU.bdT();
            }
        }
    };
    CustomMessageListener dCA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                PbActivity.this.fHT.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                if (PbActivity.this.fHU != null && PbActivity.this.fHT != null) {
                    PbActivity.this.fHU.d(PbActivity.this.fHT.getPbData(), PbActivity.this.fHT.bbL(), PbActivity.this.fHT.getRequestType());
                }
                if (PbActivity.this.fHU != null && PbActivity.this.fHU.bdA() != null) {
                    PbActivity.this.fHU.bdA().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fIA = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fHU != null) {
                    if (booleanValue) {
                        PbActivity.this.fHU.aIH();
                    } else {
                        PbActivity.this.fHU.aIG();
                    }
                }
            }
        }
    };
    private CustomMessageListener fIB = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fIh != null) {
                    PbActivity.this.fHU.kB(PbActivity.this.fIh.La());
                }
                PbActivity.this.fHU.kD(false);
            }
        }
    };
    private CustomMessageListener fIC = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
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
    private CustomMessageListener fID = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fHU != null && PbActivity.this.fHU.bdA() != null) {
                PbActivity.this.fHU.bdA().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener esQ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private j.a fIE = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void i(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.sF(2);
                aj.bcS().reset();
                PbActivity.this.fHT.bcd();
                boolean z2 = false;
                ArrayList<PostData> aYN = PbActivity.this.fHT.getPbData().aYN();
                if (aYN != null) {
                    Iterator<PostData> it = aYN.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ar.k(next) && next.bvT().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fHU.n(PbActivity.this.fHT.getPbData());
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
    private View.OnClickListener bsI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.brX);
        }
    };
    private CustomMessageListener fIF = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.aLu = yVar.aLu;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHT.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fHT.bbU() != null && PbActivity.this.fHT.bbU().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fHU.a(yVar.sendCount, PbActivity.this.fHT.getPbData(), PbActivity.this.fHT.bbL(), PbActivity.this.fHT.getRequestType());
                    }
                    if (pbData.aYN() != null && pbData.aYN().size() >= 1 && pbData.aYN().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aYN().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.fHT.bbK(), 0L);
                        if (c2 == yVar.postId && c3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bvS = pbData.aYN().get(0).bvS();
                            if (bvS == null) {
                                bvS = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> xY = bvS.xY();
                            if (xY == null) {
                                xY = new ArrayList<>();
                            }
                            xY.add(0, aVar);
                            bvS.eL(yVar.sendCount + bvS.xX());
                            bvS.h(xY);
                            pbData.aYN().get(0).a(bvS);
                            PbActivity.this.fHU.bdA().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a fIG = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.aqu() != null && !aVar.aqu().isEmpty()) {
                    PbActivity.this.fHU.a(aVar, PbActivity.this.fII);
                }
                PbActivity.this.fHU.a(aVar, PbActivity.this.fHT.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.bez()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fIH = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void J(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.E(list) && PbActivity.this.fHU != null) {
                PbActivity.this.fHU.cQ(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fII = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                com.baidu.tbadk.core.util.ax.bb(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.nm().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14.1
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
    private boolean fIJ = false;
    private PraiseModel fIK = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void ih(String str) {
            PbActivity.this.fIJ = false;
            if (PbActivity.this.fIK != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHT.getPbData();
                if (pbData.aYL().yI().getIsLike() == 1) {
                    PbActivity.this.nC(0);
                } else {
                    PbActivity.this.nC(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aYL()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void H(int i, String str) {
            PbActivity.this.fIJ = false;
            if (PbActivity.this.fIK != null && str != null) {
                if (AntiHelper.vQ(i)) {
                    AntiHelper.an(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fIL = 0;
    private boolean fIM = true;
    private b.a fIN = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jS(boolean z) {
            PbActivity.this.jR(z);
            if (PbActivity.this.fHU.beg() != null && z) {
                PbActivity.this.fHU.kw(false);
            }
            PbActivity.this.fHU.ky(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().bgS != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().bgS, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", ap.a.aWb));
                        }
                    } else if (updateAttentionMessage.getData().apQ) {
                        if (PbActivity.this.aYS().yT() != null && PbActivity.this.aYS().yT().getGodUserData() != null) {
                            PbActivity.this.aYS().yT().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aYL() != null && PbActivity.this.fHT.getPbData().aYL().yT() != null) {
                            PbActivity.this.fHT.getPbData().aYL().yT().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cwu = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fHU.afb();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.sG(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.aAt();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bJO = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (PbActivity.this.fHU.bdl()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fHT != null && (PbActivity.this.fHT.getPbData() != null || PbActivity.this.fHT.getPbData().aZh() != null)) {
                    if (PbActivity.this.fHT.getPbData().aZh().aZs()) {
                        if (PbActivity.this.fHT.getPbData().aZh().fEA == 1 || PbActivity.this.fHT.getPbData().aZh().fEA == 3 || PbActivity.this.fHT.getPbData().aZh().fEA == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fHT.getPbData().aZh().aZs() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fHT.getPbData().aZh().aZs() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fHL > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).ld(false);
                        PbActivity.this.fHL = System.currentTimeMillis();
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
                    if (PbActivity.this.cq(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.fHU != null && PbActivity.this.fHU.ban() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").aa("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.fHV != null && PbActivity.this.fHV.fUN != null) {
                            PbActivity.this.fHV.fUN.onClick(view);
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
            if (PbActivity.this.fIh != null) {
                PbActivity.this.fHU.kB(PbActivity.this.fIh.La());
            }
            PbActivity.this.fHU.bdk();
            PbActivity.this.fHU.bdT();
            return true;
        }
    });
    private CustomMessageListener fIO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fIo) {
                PbActivity.this.fHU.afb();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHT.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aYZ().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fIn.q(PbActivity.this.fIm.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fIm.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gt(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.baV();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fIm.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.fIn.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fIP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fIo) {
                PbActivity.this.fHU.afb();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fIn.q(PbActivity.this.fIm.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fIm.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.fIn.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fIQ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fIo) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fHU.afb();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hmt;
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
                    PbActivity.this.fHU.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fIR = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fHU.bdl() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aZT() != null && PbActivity.this.aZT().getPbData() != null && PbActivity.this.aZT().getPbData().aZh() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aZs = PbActivity.this.aZT().getPbData().aZh().aZs();
                if (intValue < 10) {
                    if (aZs) {
                        if (PbActivity.this.fHT.getPbData().aZh().fEA == 1 || PbActivity.this.fHT.getPbData().aZh().fEA == 3 || PbActivity.this.fHT.getPbData().aZh().fEA == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fHT.getPbData().aZh().aZs() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", aZs ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fHL > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).ld(false);
                        PbActivity.this.fHL = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aZs, 3);
                TiebaStatic.log(PbActivity.this.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).s("obj_locate", 4).s("obj_id", aZs ? 0 : 1));
            }
        }
    };
    private CustomMessageListener dCJ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dCi = true;
                }
            }
        }
    };
    public a.b fuT = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.aut();
            com.baidu.tbadk.core.data.al aCV = PbActivity.this.fHT.aCV();
            int pageNum = PbActivity.this.fHU.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (aCV == null || pageNum <= aCV.xQ()) {
                PbActivity.this.fHU.bdT();
                PbActivity.this.sF(2);
                PbActivity.this.aus();
                PbActivity.this.fHU.bdE();
                if (com.baidu.adp.lib.util.j.oJ()) {
                    PbActivity.this.fHT.sN(PbActivity.this.fHU.getPageNum());
                    if (PbActivity.this.fHz != null) {
                        PbActivity.this.fHz.showFloatingView();
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
    public final View.OnClickListener dDg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
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
            com.baidu.tieba.pb.data.l aZh;
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
            boolean j;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fHU.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fHT.kc(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fHU.bdF();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcL()) {
                        if (view == PbActivity.this.fHU.fQC.bAy) {
                            if (PbActivity.this.fHU.kA(PbActivity.this.fHT.bbR())) {
                                PbActivity.this.aus();
                                return;
                            }
                            PbActivity.this.fHC = false;
                            PbActivity.this.fHA = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fHU.bdC() && (PbActivity.this.fHU.fQC.beK() == null || (view != PbActivity.this.fHU.fQC.beK().bcK() && view != PbActivity.this.fHU.fQC.beK().bcI()))) {
                            if (view == PbActivity.this.fHU.bdW()) {
                                if (PbActivity.this.fHT != null) {
                                    com.baidu.tbadk.browser.a.P(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHT.getPbData().aYL().yS().getLink());
                                }
                            } else if (view != PbActivity.this.fHU.fQC.fVx && view.getId() != d.g.view_forum_name_first_floor && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.fHU.fQC.fVy) {
                                    if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null) {
                                        ArrayList<PostData> aYN = PbActivity.this.fHT.getPbData().aYN();
                                        if ((aYN == null || aYN.size() <= 0) && PbActivity.this.fHT.bbL()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").aa("tid", PbActivity.this.fHT.bbK()).aa("uid", TbadkCoreApplication.getCurrentAccount()).aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getForumId()));
                                        if (!PbActivity.this.fHU.ben()) {
                                            PbActivity.this.fHU.bdk();
                                        }
                                        PbActivity.this.bau();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcw()) {
                                        if ((PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcH()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.fHU.fQC.beK() == null || (view != PbActivity.this.fHU.fQC.beK().getCancelView() && view != PbActivity.this.fHU.fQC.beK().bcG())) {
                                                if (view != PbActivity.this.fHU.fQC.fVz && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcE()) {
                                                        if ((PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcN()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcF()) {
                                                                if (PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcO()) {
                                                                    if (PbActivity.this.fIa == null || view != PbActivity.this.fIa.bcy()) {
                                                                        if (PbActivity.this.fIa == null || view != PbActivity.this.fIa.bcw()) {
                                                                            if (PbActivity.this.fIa == null || view != PbActivity.this.fIa.bcB()) {
                                                                                if (PbActivity.this.fIa == null || view != PbActivity.this.fIa.bcz()) {
                                                                                    if (PbActivity.this.fIa == null || view != PbActivity.this.fIa.bcA()) {
                                                                                        if (PbActivity.this.fHU.beg() == view) {
                                                                                            if (PbActivity.this.fHU.beg().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHT.getPbData();
                                                                                                if (pbData != null && pbData.aYL() != null && pbData.aYL().yB() != null) {
                                                                                                    String xj = pbData.aYL().yB().xj();
                                                                                                    if (StringUtils.isNull(xj)) {
                                                                                                        xj = pbData.aYL().yB().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").aa("obj_id", xj));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cb("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.baQ();
                                                                                        } else if (PbActivity.this.fHU.bdz() != view) {
                                                                                            if (PbActivity.this.fIa == null || view != PbActivity.this.fIa.bcx()) {
                                                                                                if (PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcM()) {
                                                                                                    if (PbActivity.this.fHU.fQC.beK() != null && view == PbActivity.this.fHU.fQC.beK().bcJ()) {
                                                                                                        if (com.baidu.adp.lib.util.j.oJ()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.fHU.c(PbActivity.this.fHT.getPbData(), PbActivity.this.fHT.bbL(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.fHU.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.fHU.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.fHU.fQC.vU();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.fHU.bag()) {
                                                                                                            if (view == PbActivity.this.fHU.fQC.beL()) {
                                                                                                                PbActivity.this.fHU.bdM();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (biVar = (bi) view.getTag()) != null && !StringUtils.isNull(biVar.Aq())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        com.baidu.tbadk.core.util.av.Da().c(PbActivity.this.getPageContext(), new String[]{biVar.Aq()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData cr = PbActivity.this.cr(view);
                                                                                                                    if (cr != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 5).s("obj_id", cr.bvY() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.aZT() != null && PbActivity.this.aZT().getPbData() != null && PbActivity.this.aZT().getPbData().aZh() != null && PbActivity.this.aZT().getPbData().aZh() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 4).s("obj_id", PbActivity.this.aZT().getPbData().aZh().aZs() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && !StringUtils.isNull(PbActivity.this.fHT.getPbData().getThreadId()) && (aZh = PbActivity.this.fHT.getPbData().aZh()) != null && aZh.aZq() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.av.Da().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.fHT.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.fIa == null) {
                                                                                                                                PbActivity.this.fIa = new y(PbActivity.this.getPageContext(), PbActivity.this.dDg);
                                                                                                                                PbActivity.this.fHU.cB(PbActivity.this.fIa.getView());
                                                                                                                                PbActivity.this.fIa.kg(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.fIa.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").aa("tid", PbActivity.this.fHT.fMI));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.fIa.bcw().setTag(sparseArray2);
                                                                                                                            PbActivity.this.fIa.bcB().setTag(view.getTag());
                                                                                                                            PbActivity.this.fIa.ki(z6);
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
                                                                                                                                    PbActivity.this.fIa.bcz().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.fIa.bcz().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.fIa.bcx().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fIa.bcz().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fIa.bcx().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.fIa.bcx().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.fIa.bcx().setVisibility(8);
                                                                                                                                PbActivity.this.fIa.bcz().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.fIa.bcx().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fIa.bcz().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fIa.bcx().setText(d.j.delete);
                                                                                                                                PbActivity.this.fIa.bcz().setVisibility(0);
                                                                                                                                if (PbActivity.this.fHT.getPbData().aYX() != 1002 || z2) {
                                                                                                                                    PbActivity.this.fIa.bcz().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fIa.bcz().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.fIa.bcx().setVisibility(8);
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
                                                                                                                                PbActivity.this.fIa.bcy().setTag(sparseArray7);
                                                                                                                                PbActivity.this.fIa.bcy().setVisibility(0);
                                                                                                                                PbActivity.this.fIa.bcx().setVisibility(8);
                                                                                                                                PbActivity.this.fIa.bcy().setText(d.j.mute_option);
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
                                                                                                                                boolean jN = PbActivity.this.jN(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fJb = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (ar.k(PbActivity.this.fJb) ? false : jN) {
                                                                                                                                    PbActivity.this.fIa.bcy().setVisibility(0);
                                                                                                                                    PbActivity.this.fIa.bcy().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fIa.bcy().setVisibility(8);
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
                                                                                                                                PbActivity.this.fIa.bcA().setVisibility(0);
                                                                                                                                PbActivity.this.fIa.bcA().setTag(d.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                                PbActivity.this.fIa.bcA().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.fIa.bcA().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.fIa.bcA().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fHT.getPbData().vl()) {
                                                                                                                            String vk = PbActivity.this.fHT.getPbData().vk();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(vk) && vk.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.fIa.bcw().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fIa.bcw().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fIa.kh(true);
                                                                                                                                PbActivity.this.fIa.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.fIa.kh(true);
                                                                                                                        PbActivity.this.fIa.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aYL() != null && PbActivity.this.fHT.getPbData().aYL().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.P(PbActivity.this.getActivity(), PbActivity.this.fHT.getPbData().aYL().getActUrl());
                                                                                                                        if (PbActivity.this.fHT.getPbData().aYL().zx() != 1) {
                                                                                                                            if (PbActivity.this.fHT.getPbData().aYL().zx() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getPbData().getForumId()).aa("tid", PbActivity.this.fHT.getPbData().getThreadId()).aa("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.fHT.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.fHU.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (com.baidu.tbadk.core.util.ax.bb(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.j.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.fHU.bdk();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.P(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.bar() == 1) {
                                                                                                                            if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getPbData().getForumId()).aa("tid", PbActivity.this.fHT.getPbData().getThreadId()).aa("uid", currentAccount));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.bar() == 2 && PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getPbData().getForumId()).aa("tid", PbActivity.this.fHT.getPbData().getThreadId()).aa("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.P(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.bar() == 1) {
                                                                                                                            if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getPbData().getForumId()).aa("tid", PbActivity.this.fHT.getPbData().getThreadId()).aa("uid", currentAccount2));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.bar() == 2 && PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getPbData().getForumId()).aa("tid", PbActivity.this.fHT.getPbData().getThreadId()).aa("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.baL();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.baM();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aZd() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.fHT.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").aa(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.Da().c(PbActivity.this.getPageContext(), new String[]{pbData2.aZd().aZm()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aZd() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.fHT.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").aa(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.Da().c(PbActivity.this.getPageContext(), new String[]{pbData3.aZd().aZm()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.fHU.fQC.beK() != null && view == PbActivity.this.fHU.fQC.beK().bcP()) {
                                                                                                                    if (PbActivity.this.fHT == null || PbActivity.this.fHT.getPbData() == null || PbActivity.this.fHT.getPbData().aYL() == null) {
                                                                                                                        PbActivity.this.fHU.fQC.vU();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.pa()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.fHT.getPbData().aYL().yD() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHT.bbK(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).AJ();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").s("obj_locate", PbActivity.this.X(PbActivity.this.fHT.getPbData().aYL())).aa("tid", PbActivity.this.fHT.getPbData().aYL().getTid()).s("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.fIu >= 0) {
                                                                                                                        if (PbActivity.this.fHT != null) {
                                                                                                                            PbActivity.this.fHT.bcr();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fHU.bdA() != null) {
                                                                                                                            PbActivity.this.fHU.bdA().a(PbActivity.this.fHT.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.fHU.getListView().setSelection(PbActivity.this.fHT.bcu());
                                                                                                                        PbActivity.this.fIu = 0;
                                                                                                                        if (PbActivity.this.fHT != null) {
                                                                                                                            PbActivity.this.fHT.cs(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.fHU.beq();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.fHT.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.fHT.bbK(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fHT.getPbData().aYL().zo())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.fHT.getPbData() != null) {
                                                                                                            PbActivity.this.fHU.bdT();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bwa() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12630"));
                                                                                                                }
                                                                                                                String bbK = PbActivity.this.fHT.bbK();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.fHT.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.fHT.getPbData().aYX();
                                                                                                                }
                                                                                                                PbActivity.this.aus();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c qh = PbActivity.this.qh(id2);
                                                                                                                    if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && qh != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bbK, id2, "pb", true, null, true, null, i3, postData3.bfA(), PbActivity.this.fHT.getPbData().xH(), false, postData3.yT().getIconInfo()).addBigImageData(qh.fJL, qh.fJM, qh.fJN, qh.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.fHT.bcq());
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
                                                                                                                    c qh2 = PbActivity.this.qh(id2);
                                                                                                                    if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && qh2 != null && PbActivity.this.bam().bdi() != null) {
                                                                                                                        com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                        mVar.b(PbActivity.this.fHT.getPbData().aYJ());
                                                                                                                        mVar.Q(PbActivity.this.fHT.getPbData().aYL());
                                                                                                                        mVar.d(postData4);
                                                                                                                        PbActivity.this.bam().bdi().d(mVar);
                                                                                                                        PbActivity.this.bam().bdi().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c qh3 = PbActivity.this.qh(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && qh3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bbK, id2, "pb", true, null, false, null, i3, postData3.bfA(), PbActivity.this.fHT.getPbData().xH(), false, postData3.yT().getIconInfo()).addBigImageData(qh3.fJL, qh3.fJM, qh3.fJN, qh3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.fHT.bcq());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 3).aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.oJ()) {
                                                                                                    PbActivity.this.fHU.bdT();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.fHU.c(PbActivity.this.fHT.getPbData(), PbActivity.this.fHT.bbL(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHT.getPbData().aYJ().getId(), PbActivity.this.fHT.getPbData().aYJ().getName(), PbActivity.this.fHT.getPbData().aYL().getId(), String.valueOf(PbActivity.this.fHT.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    PbActivity.this.showToast(d.j.network_not_available);
                                                                                                    return;
                                                                                                }
                                                                                            } else if (!com.baidu.adp.lib.util.j.oJ()) {
                                                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                                                return;
                                                                                            } else {
                                                                                                SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                                if (sparseArray11 != null) {
                                                                                                    if (!com.baidu.tieba.c.a.akc() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fHT.bbK(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.fHU.cz(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.fHU.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.bai();
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
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.fHT.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aYJ() != null) {
                                                                                            str9 = pbData4.aYJ().getId();
                                                                                            str10 = pbData4.aYJ().getName();
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
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.akc() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fHT.bbK(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.fHU.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.fIa.bcD()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").aa("tid", PbActivity.this.fHT.fMI));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fHT.getPbData() != null) {
                                                                                    PbActivity.this.fHU.bdT();
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
                                                                                        String bbK2 = PbActivity.this.fHT.bbK();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.fHT.getPbData() != null) {
                                                                                            i5 = PbActivity.this.fHT.getPbData().aYX();
                                                                                        }
                                                                                        PbActivity.this.aus();
                                                                                        c qh4 = PbActivity.this.qh(id3);
                                                                                        if (qh4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bbK2, id3, "pb", true, null, true, null, i5, postData.bfA(), PbActivity.this.fHT.getPbData().xH(), false, postData.yT().getIconInfo()).addBigImageData(qh4.fJL, qh4.fJM, qh4.fJN, qh4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.fHT.bcq());
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
                                                                                PbActivity.this.cs(view);
                                                                                if (PbActivity.this.fHT.getPbData().aYL() != null && PbActivity.this.fHT.getPbData().aYL().yT() != null && PbActivity.this.fHT.getPbData().aYL().yT().getUserId() != null && PbActivity.this.fin != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").aa("tid", PbActivity.this.fHT.fMI).s("obj_locate", 2).aa("obj_id", PbActivity.this.fHT.getPbData().aYL().yT().getUserId()).s("obj_type", PbActivity.this.fin.vl() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fHT.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 4));
                                                                        if (!com.baidu.adp.lib.util.j.oJ()) {
                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                            return;
                                                                        }
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            PbActivity.this.qe((String) tag);
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
                                                                    PbActivity.this.fHU.fQC.beJ();
                                                                }
                                                            } else if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aYL() != null) {
                                                                PbActivity.this.fHU.fQC.vU();
                                                                PbActivity.this.qe(PbActivity.this.fHT.getPbData().aYL().zk());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fHU.bdT();
                                                            if (com.baidu.adp.lib.util.j.oJ()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.fHT.bbY()));
                                                                    return;
                                                                }
                                                                PbActivity.this.sF(2);
                                                                PbActivity.this.aus();
                                                                PbActivity.this.fHU.bdE();
                                                                boolean bbX = PbActivity.this.fHT.bbX();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.fHT.bbY()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.fHU.fQC != null && PbActivity.this.fHU.fQC.beK() != null && view == PbActivity.this.fHU.fQC.beK().bcN()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (bbX) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.fHU.kr(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fHU.bdT();
                                                        if (PbActivity.this.fHT.aCV() != null) {
                                                            PbActivity.this.fHU.a(PbActivity.this.fHT.aCV(), PbActivity.this.fuT);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.am.nv() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fHT != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").aa("tid", PbActivity.this.fHT.bbK()).aa("uid", TbadkCoreApplication.getCurrentAccount()).aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getForumId()).s("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.pa()) {
                                                        if (PbActivity.this.fHT.getPbData() != null) {
                                                            ArrayList<PostData> aYN2 = PbActivity.this.fHT.getPbData().aYN();
                                                            if ((aYN2 != null && aYN2.size() > 0) || !PbActivity.this.fHT.bbL()) {
                                                                PbActivity.this.fHU.bdT();
                                                                PbActivity.this.aus();
                                                                PbActivity.this.sF(2);
                                                                if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aZd() != null && !StringUtils.isNull(PbActivity.this.fHT.getPbData().aZd().xu(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.am.nv()) {
                                                                    PbActivity.this.sG(2);
                                                                } else {
                                                                    PbActivity.this.fHU.showLoadingDialog();
                                                                    PbActivity.this.fHT.bcl().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.fHU.fQC.vU();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.oJ()) {
                                            PbActivity.this.fHU.bdT();
                                            if (PbActivity.this.fHU.fQC.beK() != null && view == PbActivity.this.fHU.fQC.beK().bcH() && !PbActivity.this.fHU.ben()) {
                                                PbActivity.this.fHU.bdk();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.aus();
                                                PbActivity.this.fHU.bdE();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    j = PbActivity.this.fHT.j(true, PbActivity.this.baJ());
                                                } else {
                                                    j = view.getId() == d.g.reply_title ? PbActivity.this.fHT.j(false, PbActivity.this.baJ()) : PbActivity.this.fHT.qi(PbActivity.this.baJ());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.fHU.jW(true);
                                                    PbActivity.this.fHU.aIH();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fHU.kr(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.sF(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.oJ()) {
                                        PbActivity.this.fHU.bdT();
                                        if (PbActivity.this.sE(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fHT.sT(PbActivity.this.fHU.bdJ()) != null) {
                                            PbActivity.this.baC();
                                            if (PbActivity.this.fHT.getPbData().aYL() != null && PbActivity.this.fHT.getPbData().aYL().yT() != null && PbActivity.this.fHT.getPbData().aYL().yT().getUserId() != null && PbActivity.this.fin != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").aa("tid", PbActivity.this.fHT.fMI).s("obj_locate", 1).aa("obj_id", PbActivity.this.fHT.getPbData().aYL().yT().getUserId()).s("obj_type", PbActivity.this.fin.vl() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fHT.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.oJ()) {
                                    PbActivity.this.fHU.jW(true);
                                    PbActivity.this.fHU.bdk();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fHU.aIH();
                                        PbActivity.this.aus();
                                        PbActivity.this.fHU.bdE();
                                        PbActivity.this.fHT.qi(PbActivity.this.baJ());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.sF(2);
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
                                if (PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aYL() != null && PbActivity.this.fHT.getPbData().aYL().zG() && PbActivity.this.fHT.getPbData().aYL().zl() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.fHT.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fHT.bbJ()) && PbActivity.this.fHT.getAppealInfo() != null) {
                                        name = PbActivity.this.fHT.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fHT.getPbData().aYJ().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bbJ = PbActivity.this.fHT.bbJ();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fHT.bbM() && bbJ != null && bbJ.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.oJ()) {
                            if (PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aYX() == 1 && !PbActivity.this.cVn.bwx()) {
                                PbActivity.this.fHU.bdT();
                                int i6 = 0;
                                if (PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcI()) {
                                    if (PbActivity.this.fHU.fQC.beK() == null || view != PbActivity.this.fHU.fQC.beK().bcK()) {
                                        if (view == PbActivity.this.fHU.bdC()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.fHT.getPbData().aYL().yP() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.fHT.getPbData().aYL().yO() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aYJ = PbActivity.this.fHT.getPbData().aYJ();
                                String name2 = aYJ.getName();
                                String id4 = aYJ.getId();
                                String id5 = PbActivity.this.fHT.getPbData().aYL().getId();
                                if (!com.baidu.tieba.c.a.akc() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.fHU.bdB();
                                    PbActivity.this.cVn.a(id4, name2, id5, i6, PbActivity.this.fHU.bdD());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.oJ()) {
                        PbActivity.this.fHU.bdT();
                        PbActivity.this.aus();
                        PbActivity.this.fHU.bdE();
                        PbActivity.this.fHU.showLoadingDialog();
                        if (PbActivity.this.fHU.bdr() != null) {
                            PbActivity.this.fHU.bdr().setVisibility(8);
                        }
                        PbActivity.this.fHT.sN(1);
                        if (PbActivity.this.fHz != null) {
                            PbActivity.this.fHz.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bap = PbActivity.this.bap();
                        if (!TextUtils.isEmpty(bap)) {
                            com.baidu.tbadk.core.util.av.Da().c(PbActivity.this.getPageContext(), new String[]{bap});
                        }
                    }
                } else if (PbActivity.this.fHK) {
                    PbActivity.this.fHK = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.bam().bdi() != null && postData5.yT() != null && postData5.bvJ() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bam().bdj() != null) {
                                    PbActivity.this.bam().bdj().bbv();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.fHT.getPbData().aYJ());
                                mVar2.Q(PbActivity.this.fHT.getPbData().aYL());
                                mVar2.d(postData5);
                                PbActivity.this.bam().bdi().d(mVar2);
                                PbActivity.this.bam().bdi().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.yT().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fIh != null) {
                                    PbActivity.this.fHU.kB(PbActivity.this.fIh.La());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d bsh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.aus();
            PbActivity.this.fHU.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ad.Oj() && PbActivity.this.aZT() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aZT().ql(postWriteCallBackData.getPostId());
                    PbActivity.this.fIu = PbActivity.this.fHU.bdn();
                    if (PbActivity.this.fHT != null) {
                        PbActivity.this.fHT.cs(PbActivity.this.fIu, PbActivity.this.fHU.bdo());
                    }
                }
                PbActivity.this.fHU.bdT();
                PbActivity.this.fHZ.bes();
                if (PbActivity.this.fIh != null) {
                    PbActivity.this.fHU.kB(PbActivity.this.fIh.La());
                }
                PbActivity.this.fHU.bdh();
                PbActivity.this.fHU.kD(true);
                PbActivity.this.fHT.bca();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fHT.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHT.getPbData();
                            if (pbData != null && pbData.aYL() != null && pbData.aYL().yT() != null && (userId = pbData.aYL().yT().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ad.Oj() && PbActivity.this.fHT.bbT()) {
                                PbActivity.this.fHU.bdE();
                            }
                        } else if (!com.baidu.tbadk.o.ad.Oj() && PbActivity.this.fHT.bbT()) {
                            PbActivity.this.fHU.bdE();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fHU.n(PbActivity.this.fHT.getPbData());
                    }
                    if (PbActivity.this.fHT.bbP()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").aa("tid", PbActivity.this.fHT.bbK()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fIh.Lh() || PbActivity.this.fIh.Li()) {
                    PbActivity.this.fIh.a(false, postWriteCallBackData);
                }
                PbActivity.this.fHZ.e(postWriteCallBackData);
            } else if (tVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fIS = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.fHZ != null) {
                if (z) {
                    PbActivity.this.fHZ.ber();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    if (PbActivity.this.fHU != null && PbActivity.this.fHU.bdj() != null && PbActivity.this.fHU.bdj().bbB() != null && PbActivity.this.fHU.bdj().bbB().Li()) {
                        PbActivity.this.fHU.bdj().bbB().a(postWriteCallBackData);
                    }
                    PbActivity.this.fHZ.f(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a fIT = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l hH;
            if (!z || fVar == null || fVar.aYV() != null || com.baidu.tbadk.core.util.v.D(fVar.aYN()) >= 1) {
                PbActivity.this.fkY = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fHU.bdG();
                if (fVar == null || !fVar.aYR()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fHU.getView());
                } else if (PbActivity.this.fHU.bdf() == null) {
                    PbActivity.this.fIl = true;
                }
                PbActivity.this.fHU.aIG();
                if (PbActivity.this.isFullScreen || PbActivity.this.fHU.ben()) {
                    PbActivity.this.fHU.bec();
                } else if (!PbActivity.this.fHU.bdZ()) {
                    PbActivity.this.fHU.kD(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.fIb = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.fHU.WP();
                    PbActivity.this.fHU.kE(fVar.aYR());
                    if (fVar.aYL() != null && fVar.aYL().zN() != null) {
                        PbActivity.this.a(fVar.aYL().zN());
                    }
                    PbActivity.this.baj();
                    if (PbActivity.this.fIh != null) {
                        PbActivity.this.fHU.kB(PbActivity.this.fIh.La());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aYN() != null && fVar.aYN().size() >= 1 && fVar.aYN().get(0) != null) {
                        PbActivity.this.fHT.qk(fVar.aYN().get(0).getId());
                    } else if (fVar.aYV() != null) {
                        PbActivity.this.fHT.qk(fVar.aYV().getId());
                    }
                    if (PbActivity.this.fIh != null) {
                        PbActivity.this.fIh.a(fVar.xH());
                        PbActivity.this.fIh.a(fVar.aYJ(), fVar.getUserData());
                        PbActivity.this.fIh.a(PbActivity.this.fHT.bbU(), PbActivity.this.fHT.bbK(), PbActivity.this.fHT.bcn());
                        if (fVar.aYL() != null) {
                            PbActivity.this.fIh.ci(fVar.aYL().Ad());
                        }
                    }
                    if (PbActivity.this.fin != null) {
                        PbActivity.this.fin.aI(fVar.vl());
                    }
                    if (fVar == null || fVar.aYY() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fHU.kC(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fHU.a(fVar, i2, i3, PbActivity.this.fHT.bbL(), i4, PbActivity.this.fHT.getIsFromMark());
                    PbActivity.this.fHU.d(fVar, PbActivity.this.fHT.bbL());
                    PbActivity.this.fHU.kz(PbActivity.this.fHT.getHostMode());
                    AntiData xH = fVar.xH();
                    if (xH != null) {
                        PbActivity.this.brX = xH.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.brX) && PbActivity.this.fIh != null && PbActivity.this.fIh.Kw() != null && (hH = PbActivity.this.fIh.Kw().hH(6)) != null && !TextUtils.isEmpty(PbActivity.this.brX)) {
                            ((View) hH).setOnClickListener(PbActivity.this.bsI);
                        }
                    }
                    if (PbActivity.this.fId) {
                        PbActivity.this.fId = false;
                        final int baw = PbActivity.this.baw();
                        if (fVar.aZi()) {
                            final int ao = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(baw, ao);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bam().sY(baw);
                        }
                    }
                    if (PbActivity.this.fIe) {
                        PbActivity.this.fIe = false;
                        final int baw2 = PbActivity.this.baw();
                        final boolean z2 = baw2 != -1;
                        if (!z2) {
                            baw2 = PbActivity.this.bax();
                        }
                        if (PbActivity.this.bam() != null) {
                            if (fVar.aZi()) {
                                final int ao2 = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (baw2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(baw2, ao2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(baw2 - 1, ao2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.bam().sY(baw2);
                            }
                        }
                    } else {
                        PbActivity.this.fHU.bdK();
                    }
                    PbActivity.this.fHT.a(fVar.aYJ(), PbActivity.this.fIG);
                    PbActivity.this.fHT.a(PbActivity.this.fIH);
                } else if (str != null) {
                    if (!PbActivity.this.fIb && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fHT != null && PbActivity.this.fHT.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fHT.getAppealInfo().fDG)) {
                                    PbActivity.this.fHU.a(PbActivity.this.fHT.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fHU.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fHU.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.fHU.bec();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fHT.bbK());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getForumId());
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
                        PbActivity.this.fHU.qo(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.fHU.qo("");
                    }
                    PbActivity.this.fHU.DN();
                }
                PbActivity.this.byF = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aZT().bbL() || PbActivity.this.aZT().getPbData().xZ().xW() != 0 || PbActivity.this.aZT().bcg()) {
                    PbActivity.this.fIi = true;
                    return;
                }
                return;
            }
            PbActivity.this.fHT.sN(1);
            if (PbActivity.this.fHz != null) {
                PbActivity.this.fHz.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.fHU.n(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.r.NQ().NR()) {
                com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, PbActivity.this.byx, PbActivity.this.createTime, PbActivity.this.byF, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.dmS : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.byx = 0L;
                if (mVar != null) {
                    mVar.NL();
                }
            }
        }
    };
    private CustomMessageListener fIU = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.bar() == 1) {
                    PbActivity.this.baA();
                }
                PbActivity.this.bas();
            }
        }
    };
    private final a.InterfaceC0069a fIV = new a.InterfaceC0069a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0069a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fHU.bdG();
            if (z) {
                if (PbActivity.this.fin != null) {
                    PbActivity.this.fin.aI(z2);
                }
                PbActivity.this.fHT.ke(z2);
                if (PbActivity.this.fHT.vl()) {
                    PbActivity.this.baD();
                } else {
                    PbActivity.this.fHU.n(PbActivity.this.fHT.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fin != null && PbActivity.this.fin.vo() != null && PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aYL() != null && PbActivity.this.fHT.getPbData().aYL().yT() != null) {
                        MarkData vo = PbActivity.this.fin.vo();
                        MetaData yT = PbActivity.this.fHT.getPbData().aYL().yT();
                        if (vo != null && yT != null) {
                            if (!com.baidu.tbadk.core.util.am.equals(TbadkCoreApplication.getCurrentAccount(), yT.getUserId()) && !yT.hadConcerned()) {
                                PbActivity.this.b(yT);
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
            if (!PbActivity.this.sC(PbActivity.this.mLastScrollState) && PbActivity.this.sC(i)) {
                if (PbActivity.this.fHU != null) {
                    PbActivity.this.fHU.bdT();
                    if (PbActivity.this.fIh != null && !PbActivity.this.fHU.bdl()) {
                        PbActivity.this.fHU.kB(PbActivity.this.fIh.La());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fHU.bdk();
                    }
                }
                if (!PbActivity.this.fHH) {
                    PbActivity.this.fHH = true;
                    PbActivity.this.fHU.bdY();
                }
            }
            PbActivity.this.fHU.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fHz != null) {
                PbActivity.this.fHz.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fHI == null) {
                PbActivity.this.fHI = new com.baidu.tbadk.k.d();
                PbActivity.this.fHI.im(1001);
            }
            if (i == 0) {
                PbActivity.this.fHI.Nx();
            } else if (i == 1) {
                PbActivity.this.fHI.Nx();
            } else {
                PbActivity.this.fHI.Nx();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aYN;
            if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHU != null && PbActivity.this.fHU.bdA() != null) {
                PbActivity.this.fHU.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fHz != null) {
                    PbActivity.this.fHz.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fHT.bcc() && (aYN = PbActivity.this.fHT.getPbData().aYN()) != null && !aYN.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fHU.bdA().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHT.getPbData();
                    if (pbData != null) {
                        if (pbData.aYO() != null && pbData.aYO().hasData()) {
                            headerCount--;
                        }
                        if (pbData.aYP() != null && pbData.aYP().hasData()) {
                            headerCount--;
                        }
                        int size = aYN.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cVr = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.cVn.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fHT.bca();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dYy && bVar.fXo > 0 && bVar.haU != 0 && bVar.fXo != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.fXo == 1002 && !bVar.dYy) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fHU.a(1, dVar.aov, dVar.haW, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cVn.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fHU.a(PbActivity.this.cVn.getLoadDataMode(), gVar.aov, gVar.haW, false);
                        PbActivity.this.fHU.am(gVar.haZ);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fHU.a(PbActivity.this.cVn.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fIW = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
    };
    private final j.b bTg = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
        @Override // com.baidu.tbadk.core.view.j.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.baK()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fHT.kd(true)) {
                PbActivity.this.fHU.bdH();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fIY = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fIX && PbActivity.this.baK()) {
                PbActivity.this.baM();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fHT.kc(false)) {
                    PbActivity.this.fHU.bdF();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fHT.getPbData() != null) {
                    PbActivity.this.fHU.bdX();
                }
                PbActivity.this.fIX = true;
            }
        }
    };
    private int fIZ = 0;
    private final TbRichTextView.h bJN = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fHU.b((TbRichText) view.getTag());
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
                    PbActivity.this.fHR = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fJO) {
                    TbRichText ay = PbActivity.this.ay(str, i);
                    if (ay != null && PbActivity.this.fIZ >= 0 && PbActivity.this.fIZ < ay.QD().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.g.b(ay.QD().get(PbActivity.this.fIZ));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fJL.size()) {
                                break;
                            } else if (!cVar.fJL.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.E(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fJM.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fJN, cVar.lastId, PbActivity.this.fHT.bbY(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.f(cVar.fJL, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.E(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fJM.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fJN, cVar.fJL.get(0), PbActivity.this.fHT.bbY(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fJa = false;
    PostData fJb = null;
    private final b.InterfaceC0073b fJc = new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fJb != null) {
                if (i == 0) {
                    PbActivity.this.fJb.ch(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fJb = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fJb);
                }
            }
        }
    };
    private final b.InterfaceC0073b fJd = new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fIr != null && !TextUtils.isEmpty(PbActivity.this.fIs)) {
                if (i == 0) {
                    if (PbActivity.this.fIt == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.fIs));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fIs;
                        aVar.pkgId = PbActivity.this.fIt.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fIt.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    Activity pageActivity = PbActivity.this.getPageContext().getPageActivity();
                    if (PbActivity.this.bOI == null) {
                        PbActivity.this.bOI = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bOI.Do();
                    PbActivity.this.bOI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bOI.u(pageActivity)) {
                        if (PbActivity.this.fIq == null) {
                            PbActivity.this.fIq = new aw(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fIq.j(PbActivity.this.fIs, PbActivity.this.fIr.sm());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fIr = null;
                PbActivity.this.fIs = null;
            }
        }
    };
    private final View.OnLongClickListener bkf = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.fIr = ((TbImageView) view).getBdImage();
                PbActivity.this.fIs = ((TbImageView) view).getUrl();
                if (PbActivity.this.fIr != null && !TextUtils.isEmpty(PbActivity.this.fIs)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fIt = null;
                    } else {
                        PbActivity.this.fIt = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fHU.a(PbActivity.this.fJd, PbActivity.this.fIr.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.fIr = ((GifView) view).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                        PbActivity.this.fIs = ((GifView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fIt = null;
                    } else {
                        PbActivity.this.fIt = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fHU.a(PbActivity.this.fJd, PbActivity.this.fIr.isGif());
                }
            } else if (view instanceof com.baidu.tbadk.widget.d) {
                if (((com.baidu.tbadk.widget.d) view).getBdImage() != null) {
                    PbActivity.this.fIr = ((com.baidu.tbadk.widget.d) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.d) view).getBdImage().getUrl())) {
                        PbActivity.this.fIs = ((com.baidu.tbadk.widget.d) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fIt = null;
                    } else {
                        PbActivity.this.fIt = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fHU.a(PbActivity.this.fJd, PbActivity.this.fIr.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fJb = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.fJb != null && PbActivity.this.fin != null) {
                        PbActivity.this.fHU.a(PbActivity.this.fJc, PbActivity.this.fin.vl() && PbActivity.this.fJb.getId() != null && PbActivity.this.fJb.getId().equals(PbActivity.this.fHT.zd()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dzL = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bq(boolean z) {
            if (!PbActivity.this.fHB && z && !PbActivity.this.fHT.bbS()) {
                PbActivity.this.baG();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener bBt = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).asH()) {
                        break;
                    }
                }
            }
            PbActivity.this.ckT.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0109a ckU = new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        final int cGo;

        {
            this.cGo = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
            if (Z(i2) && PbActivity.this.fHU != null && PbActivity.this.fHz != null) {
                PbActivity.this.fHU.bed();
                PbActivity.this.fHz.fP(false);
                PbActivity.this.fHz.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
            if (Z(i2) && PbActivity.this.fHU != null && PbActivity.this.fHz != null) {
                PbActivity.this.fHz.fP(true);
                if (Math.abs(i2) > this.cGo) {
                    PbActivity.this.fHz.hideFloatingView();
                }
                if (PbActivity.this.baK()) {
                    PbActivity.this.fHU.bdw();
                    PbActivity.this.fHU.bdx();
                }
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }

        private boolean Z(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a fJe = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.e.b.a
        public void fl(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aZJ();
            } else {
                com.baidu.tieba.pb.a.b.aZI();
            }
        }
    };
    private String fJf = null;
    private final o.a fJg = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fJf = str2;
                PbActivity.this.fHU.qp(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fJh = -1;
    private int fJi = -1;
    private CustomMessageListener fJl = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.aIC == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0071a) {
                    if (aVar.aID != null && !aVar.aID.hasError() && aVar.aID.getError() == 0) {
                        if (PbActivity.this.fHU != null) {
                            PbActivity.this.fHU.y(((a.C0071a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.baW();
                        }
                    } else if (z) {
                        if (aVar.aID != null && aVar.aID.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aID.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.aID != null && !aVar.aID.hasError() && aVar.aID.getError() == 0) {
                        if (PbActivity.this.fHU != null && PbActivity.this.fHU != null) {
                            PbActivity.this.fHU.y(((a.C0071a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.aID != null && aVar.aID.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aID.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.aID == null || aVar.aID.hasError() || aVar.aID.getError() != 0) {
                        if (z) {
                            if (aVar.aID != null && aVar.aID.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.aID.getErrorString());
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
    private final CustomMessageListener dCD = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").aa("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.av.Da().c(PbActivity.this.getPageContext(), new String[]{str});
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
        public ArrayList<String> fJL;
        public ConcurrentHashMap<String, ImageUrlData> fJM;
        public boolean fJO;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fJN = false;
        public boolean fJP = false;
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

    public com.baidu.tbadk.editortools.pb.d bah() {
        return this.fIh;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        if (mVar.aZy() != null) {
            String id = mVar.aZy().getId();
            ArrayList<PostData> aYN = this.fHT.getPbData().aYN();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aYN.size()) {
                    break;
                }
                PostData postData = aYN.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aZC = mVar.aZC();
                    postData.vK(mVar.getTotalCount());
                    if (postData.bvG() != null && aZC != null) {
                        Iterator<PostData> it = aZC.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.yT() != null && (metaData = postData.getUserMap().get(next.yT().getUserId())) != null) {
                                next.a(metaData);
                                next.mC(true);
                                next.b(getPageContext(), this.fHT.qj(metaData.getUserId()));
                            }
                        }
                        postData.bvG().clear();
                        postData.bvG().addAll(aZC);
                    }
                    if (postData.bvB() != null) {
                        postData.bvC();
                    }
                }
            }
            if (!this.fHT.getIsFromMark()) {
                this.fHU.n(this.fHT.getPbData());
            }
            c(mVar);
        }
    }

    public void bai() {
        com.baidu.tieba.pb.data.f pbData;
        bd aYL;
        if (!this.fIJ) {
            if (!com.baidu.adp.lib.util.l.pa()) {
                showToast(d.j.no_network_guide);
            } else if (this.fIM) {
                this.fIJ = true;
                if (this.fHT != null && (pbData = this.fHT.getPbData()) != null && (aYL = pbData.aYL()) != null) {
                    int isLike = aYL.yI() == null ? 0 : aYL.yI().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").aa("tid", aYL.getId()));
                    }
                    if (this.fIK != null) {
                        this.fIK.a(aYL.zk(), aYL.getId(), isLike, "pb");
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
                bVar.fe(d.j.operation);
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.j.delete);
                    strArr[1] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr, new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fHU.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fIo);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fIo);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fIo);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fIo);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).AE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC(int i) {
        bd aYL;
        String str;
        String H;
        if (this.fHT != null && this.fHT.getPbData() != null && (aYL = this.fHT.getPbData().aYL()) != null) {
            if (i == 1) {
                PraiseData yI = aYL.yI();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yI == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aYL.a(praiseData);
                    } else {
                        aYL.yI().getUser().add(0, metaData);
                        aYL.yI().setNum(aYL.yI().getNum() + 1);
                        aYL.yI().setIsLike(i);
                    }
                }
                if (aYL.yI() != null) {
                    if (aYL.yI().getNum() < 1) {
                        H = getResources().getString(d.j.zan);
                    } else {
                        H = com.baidu.tbadk.core.util.am.H(aYL.yI().getNum());
                    }
                    this.fHU.S(H, true);
                }
            } else if (aYL.yI() != null) {
                aYL.yI().setIsLike(i);
                aYL.yI().setNum(aYL.yI().getNum() - 1);
                ArrayList<MetaData> user = aYL.yI().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aYL.yI().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aYL.yI().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = aYL.yI().getNum() + "";
                }
                this.fHU.S(str, false);
            }
            if (this.fHT.bbL()) {
                this.fHU.bdA().notifyDataSetChanged();
            } else {
                this.fHU.o(this.fHT.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fHT.x(bundle);
        if (this.dBC != null) {
            this.dBC.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fIh.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fIm = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.dmS = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fHN = intent.getStringExtra("from");
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fHN)) {
                this.fHA = true;
            }
            this.fJh = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fJi = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fJj = intent.getStringExtra("key_manga_title");
            this.fId = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fIe = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (baK()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.fIv = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.dmS = System.currentTimeMillis();
        }
        this.fHG = System.currentTimeMillis();
        this.byx = this.fHG - this.dmS;
        super.onCreate(bundle);
        this.fHD = 0;
        w(bundle);
        if (this.fHT != null && this.fHT.getPbData() != null) {
            this.fHT.getPbData().qc(this.source);
        }
        initUI();
        if (intent != null && this.fHU != null) {
            this.fHU.fQv = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fIp == null) {
                    this.fIp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fHU.qr("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fIp, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fHT != null && this.fHT.getPbData() != null) {
                this.fHT.qm(stringExtra);
            }
        }
        this.dBC = new VoiceManager();
        this.dBC.onCreate(getPageContext());
        initData(bundle);
        this.fIg = new com.baidu.tbadk.editortools.pb.g();
        baj();
        this.fIh = (com.baidu.tbadk.editortools.pb.d) this.fIg.be(getActivity());
        this.fIh.b(this);
        this.fIh.a(this.bsh);
        this.fIh.a(this.bsa);
        this.fIh.a(this, bundle);
        this.fIh.Kw().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.fIh.Kw().cb(true);
        jM(true);
        this.fHU.setEditorTools(this.fIh.Kw());
        this.fIh.a(this.fHT.bbU(), this.fHT.bbK(), this.fHT.bcn());
        registerListener(this.fIB);
        if (!this.fHT.bbR()) {
            this.fIh.gm(this.fHT.bbK());
        }
        if (this.fHT.bco()) {
            this.fIh.gk(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fIh.gk(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.fHG;
        registerListener(this.fIA);
        registerListener(this.fIC);
        registerListener(this.fID);
        registerListener(this.dCA);
        registerListener(this.fIR);
        registerListener(this.fIz);
        this.fIf = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gYa);
        this.fIf.bvk();
        registerListener(this.fIF);
        registerListener(this.mAttentionListener);
        if (this.fHT != null) {
            this.fHT.bce();
        }
        registerListener(this.fIU);
        registerListener(this.fJl);
        registerListener(this.dCJ);
        if (this.fHU != null && this.fHU.beh() != null && this.fHU.bei() != null) {
            this.fHz = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.fHU.beh(), this.fHU.bei(), this.fHU.bdr());
            this.fHz.a(this.fIN);
        }
        if (this.fHy && this.fHU != null && this.fHU.bei() != null) {
            this.fHU.bei().setVisibility(8);
        }
        this.fIn = new com.baidu.tbadk.core.view.e();
        this.fIn.aZw = 1000L;
        registerListener(this.fIQ);
        registerListener(this.fIO);
        registerListener(this.fIP);
        this.fIo = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fIo;
        userMuteAddAndDelCustomMessage.setTag(this.fIo);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fIo;
        userMuteCheckCustomMessage.setTag(this.fIo);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fHT.bcl().a(this.cwu);
        if ("from_tieba_kuang".equals(this.fHN)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 2).aa("tid", this.fHT.bbK()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                    @Override // com.baidu.tbadk.core.e
                    public void aP(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
        this.fHZ = new au();
        if (this.fIh.KU() != null) {
            this.fHZ.g(this.fIh.KU().getInputView());
        }
        this.fIh.a(this.bsb);
        this.dOd = new ShareSuccessReplyToServerModel();
        a(this.fIx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baj() {
        if (this.fIg != null && this.fHT != null) {
            this.fIg.setForumName(this.fHT.bbJ());
            if (this.fHT.getPbData() != null && this.fHT.getPbData().aYJ() != null) {
                this.fIg.setForumId(this.fHT.getPbData().aYJ().getId());
            }
            this.fIg.setFrom("pb");
            this.fIg.a(this.fHT);
        }
    }

    public String bak() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b bal() {
        return this.fHz;
    }

    private void jM(boolean z) {
        this.fIh.cf(z);
        this.fIh.cg(z);
        this.fIh.ch(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aZi() && !z && this.fHU != null && this.fHU.getView() != null) {
            this.fHU.getView().setSystemUiVisibility(4);
        }
        this.fIj = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dBC != null) {
            this.dBC.onStart(getPageContext());
        }
    }

    public as bam() {
        return this.fHU;
    }

    public PbModel aZT() {
        return this.fHT;
    }

    public void qd(String str) {
        if (this.fHT != null && !StringUtils.isNull(str) && this.fHU != null) {
            this.fHU.kG(true);
            this.fHT.qd(str);
            this.fHM = true;
            this.fHU.bdT();
            this.fHU.bec();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fHB = false;
        } else {
            this.fHB = true;
        }
        super.onPause();
        if (this.fHU.bdf() != null && this.fHU.bdf().bae() != null) {
            this.fHU.bdf().bae().onPause();
        }
        BdListView listView = getListView();
        this.fHD = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fHD == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dBC != null) {
            this.dBC.onPause(getPageContext());
        }
        if (this.fHU != null) {
            this.fHU.onPause();
        }
        if (!this.fHT.bbR()) {
            this.fIh.gl(this.fHT.bbK());
        }
        if (this.fHT != null) {
            this.fHT.bcf();
        }
        MessageManager.getInstance().unRegisterListener(this.esQ);
        aCq();
        MessageManager.getInstance().unRegisterListener(this.fIO);
        MessageManager.getInstance().unRegisterListener(this.fIP);
        MessageManager.getInstance().unRegisterListener(this.fIQ);
        MessageManager.getInstance().unRegisterListener(this.dCD);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean ban() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.fHT.getPbData(), this.fHT.bbL(), this.fHT.getRequestType());
        return (a2 == null || a2.yT() == null || a2.yT().getGodUserData() == null || a2.yT().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fHB = false;
        super.onResume();
        if (this.fHP) {
            this.fHP = false;
            baQ();
        }
        if (this.fHU.bdf() != null && this.fHU.bdf().bae() != null) {
            this.fHU.bdf().bae().onResume();
        }
        if (ban()) {
            this.fHJ = System.currentTimeMillis();
        } else {
            this.fHJ = -1L;
        }
        if (this.fHU != null && this.fHU.getView() != null) {
            if (!this.fkY) {
                baH();
            } else {
                hideLoadingView(this.fHU.getView());
            }
            this.fHU.onResume();
        }
        if (this.fHD == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fHU != null) {
            noNetworkView = this.fHU.bdg();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.oJ()) {
            noNetworkView.bp(false);
        }
        if (this.dBC != null) {
            this.dBC.onResume(getPageContext());
        }
        registerListener(this.esQ);
        this.fIc = false;
        baP();
        registerListener(this.fIO);
        registerListener(this.fIP);
        registerListener(this.fIQ);
        registerListener(this.dCD);
        if (this.dCi) {
            baG();
            this.dCi = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                @Override // com.baidu.tbadk.core.e
                public void aP(boolean z) {
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
        this.fHU.ku(z);
        if (this.fIa != null) {
            this.fIa.kg(z);
        }
        if (z && this.fIc) {
            this.fHU.bdF();
            this.fHT.kc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fHJ > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").aa("obj_duration", (System.currentTimeMillis() - this.fHJ) + ""));
            this.fHJ = 0L;
        }
        if (bam().bdj() != null) {
            bam().bdj().onStop();
        }
        if (this.fHU.fQC != null && !this.fHU.fQC.alw()) {
            this.fHU.fQC.aNo();
        }
        if (this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aYJ() != null && this.fHT.getPbData().aYL() != null) {
            com.baidu.tbadk.distribute.a.Kg().a(getPageContext().getPageActivity(), "pb", this.fHT.getPbData().aYJ().getId(), com.baidu.adp.lib.g.b.c(this.fHT.getPbData().aYL().getId(), 0L));
        }
        if (this.dBC != null) {
            this.dBC.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.fHH && this.fHU != null) {
            this.fHH = true;
            this.fHU.bdY();
            a(false, (PostData) null);
        }
        if (this.fHT != null) {
            this.fHT.cancelLoadData();
            this.fHT.destory();
            if (this.fHT.bck() != null) {
                this.fHT.bck().onDestroy();
            }
        }
        if (this.fIh != null) {
            this.fIh.onDestroy();
        }
        if (this.cVn != null) {
            this.cVn.cancelLoadData();
        }
        if (this.fHU != null) {
            this.fHU.onDestroy();
            if (this.fHU.fQC != null) {
                this.fHU.fQC.aNo();
            }
        }
        if (this.fHI != null) {
            this.fHI.onDestroy();
        }
        if (this.fHz != null) {
            this.fHz.OF();
        }
        super.onDestroy();
        if (this.dBC != null) {
            this.dBC.onDestory(getPageContext());
        }
        this.fHU.bdT();
        MessageManager.getInstance().unRegisterListener(this.fIO);
        MessageManager.getInstance().unRegisterListener(this.fIP);
        MessageManager.getInstance().unRegisterListener(this.fIQ);
        MessageManager.getInstance().unRegisterListener(this.fIo);
        MessageManager.getInstance().unRegisterListener(this.fIR);
        MessageManager.getInstance().unRegisterListener(this.dCJ);
        this.fIm = null;
        this.fIn = null;
        com.baidu.tieba.recapp.e.a.bnx().bnz();
        if (this.fIp != null) {
            getSafeHandler().removeCallbacks(this.fIp);
        }
        if (this.fHQ != null) {
            this.fHQ.cancelLoadData();
        }
        if (this.fHU != null && this.fHU.fQC != null) {
            this.fHU.fQC.beO();
        }
        if (this.dOd != null) {
            this.dOd.cancelLoadData();
        }
        this.fHZ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        h bdA;
        ArrayList<PostData> bbm;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.EZ() && this.fHU != null && (bdA = this.fHU.bdA()) != null && (bbm = bdA.bbm()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bbm.iterator();
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
                        bVar.bBc = id;
                        bVar.cXb = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aNV == 1 && !TextUtils.isEmpty(id)) {
                    next.aNV = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bBc = id;
                    bVar2.cXb = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fHT == null || this.fHT.getPbData() == null || this.fHT.getPbData().aYJ() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fHT.getPbData().aYJ().getFirst_class();
                    str2 = this.fHT.getPbData().aYJ().getSecond_class();
                    str = this.fHT.getPbData().aYJ().getId();
                    str4 = this.fHT.bbK();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Fc());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fHU.onChangeSkinType(i);
            if (this.fIh != null && this.fIh.Kw() != null) {
                this.fIh.Kw().onChangeSkinType(i);
            }
            if (this.fHU.bdg() != null) {
                this.fHU.bdg().onChangeSkinType(getPageContext(), i);
            }
            this.fHZ.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fHU = new as(this, this.dDg, this.bJO);
        this.ckT = new com.baidu.tieba.e.b(getActivity());
        this.ckT.a(this.fJe);
        this.ckT.a(this.ckU);
        this.fHU.setOnScrollListener(this.mOnScrollListener);
        this.fHU.d(this.fIY);
        this.fHU.a(this.bTg);
        this.fHU.jG(com.baidu.tbadk.core.i.wB().wH());
        this.fHU.setOnImageClickListener(this.bJN);
        this.fHU.a(this.bkf);
        this.fHU.h(this.dzL);
        this.fHU.a(this.fIW);
        this.fHU.ku(this.mIsLogin);
        if (getIntent() != null) {
            this.fHU.setIsInterviewLive(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cq(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gYC == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.i.wB().wH()) {
                    return false;
                }
                return qg(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.fHU != null) {
            if (z && (!this.fkY || this.fIl)) {
                baH();
            } else {
                hideLoadingView(this.fHU.getView());
            }
            this.fIl = false;
            if (z && this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aZi() && this.fHU.getView() != null) {
                this.fHU.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void bao() {
        if (this.fHE == null) {
            this.fHE = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fHE.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fHh = PbActivity.this.fHh.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHh);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fHT.bbK(), PbActivity.this.fHh, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fHh = PbActivity.this.fHh.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHh);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fHT.bbK(), PbActivity.this.fHh, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fHh = PbActivity.this.fHh.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHh);
                        bVar.dismiss();
                    }
                }
            }).ff(b.a.aQn).fg(17).d(getPageContext());
        }
    }

    private void w(Bundle bundle) {
        this.fHT = new PbModel(this);
        this.fHT.a(this.fIT);
        if (this.fHT.bci() != null) {
            this.fHT.bci().a(this.fJg);
        }
        if (this.fHT.bch() != null) {
            this.fHT.bch().a(this.fIE);
        }
        if (this.fHT.bck() != null) {
            this.fHT.bck().b(this.fIy);
        }
        if (bundle != null) {
            this.fHT.initWithBundle(bundle);
        } else {
            this.fHT.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fHT.kf(true);
        }
        aj.bcS().R(this.fHT.bbI(), this.fHT.getIsFromMark());
        if (StringUtils.isNull(this.fHT.bbK())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fHN)) {
            this.fHT.sU(6);
        }
        this.fHT.MQ();
    }

    private void initData(Bundle bundle) {
        this.fin = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fin != null) {
            this.fin.a(this.fIV);
        }
        this.cVn = new ForumManageModel(this);
        this.cVn.setLoadDataCallBack(this.cVr);
        this.bdJ = new com.baidu.tbadk.coreExtra.model.a(null);
        this.fHU.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void ak(Object obj) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fHT.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHT.getPbData().aYJ().getId(), PbActivity.this.fHT.getPbData().aYJ().getName(), PbActivity.this.fHT.getPbData().aYL().getId(), valueOf, str, str2)));
            }
        });
        this.fIK.setUniqueId(getUniqueId());
        this.fIK.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fHU.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fIo;
        userMuteCheckCustomMessage.setTag(this.fIo);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bap() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.fHT != null && (pbData = this.fHT.getPbData()) != null) {
            return pbData.aYW().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aYL() != null) {
            if (fVar.aYL().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aYL().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aYL().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData cr(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bvY()) {
                postData.cR(postData.bvX() - 1);
            } else {
                postData.cR(postData.bvX() + 1);
            }
            postData.mD(!postData.bvY());
            ((PbFloorAgreeView) view).a(postData.bvY(), postData.bvX(), true);
            final int i = postData.bvY() ? 0 : 1;
            this.fHT.bcj().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void sH(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).te(i2);
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

    public com.baidu.tbadk.core.util.ak baq() {
        return new com.baidu.tbadk.core.util.ak("c12003").aa("tid", this.fHT.fMI).s("obj_type", 0).aa(ImageViewerConfig.FORUM_ID, this.fHT.getForumId()).s("obj_param1", this.fHT.getPbData().aYL().getThreadType() == 40 ? 2 : 1);
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
                        PbActivity.this.bam().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bam().bdj() != null) {
                        PbActivity.this.fIh.Kw().setVisibility(8);
                        PbActivity.this.bam().bdj().bF(str, str2);
                        com.baidu.tbadk.editortools.pb.h bbB = PbActivity.this.bam().bdj().bbB();
                        if (bbB != null && PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null) {
                            bbB.a(PbActivity.this.fHT.getPbData().xH());
                        }
                        if (PbActivity.this.fHZ.bev() == null && PbActivity.this.bam().bdj().bbB().Lv() != null) {
                            PbActivity.this.bam().bdj().bbB().Lv().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fHZ != null && PbActivity.this.fHZ.beu() != null) {
                                        if (!PbActivity.this.fHZ.beu().bER()) {
                                            PbActivity.this.fHZ.kI(false);
                                        }
                                        PbActivity.this.fHZ.beu().nu(false);
                                    }
                                }
                            });
                            PbActivity.this.fHZ.h(PbActivity.this.bam().bdj().bbB().Lv().getInputView());
                            PbActivity.this.bam().bdj().bbB().a(PbActivity.this.fIk);
                        }
                    }
                    PbActivity.this.bam().bec();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.fHT != null && this.fHT.getPbData() != null && postData.bvJ() > 1) {
            String bbK = this.fHT.bbK();
            String id = postData.getId();
            int aYX = this.fHT.getPbData() != null ? this.fHT.getPbData().aYX() : 0;
            c qh = qh(id);
            if (qh != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bbK, id, "pb", true, null, false, null, aYX, postData.bfA(), this.fHT.getPbData().xH(), false, postData.yT() != null ? postData.yT().getIconInfo() : null).addBigImageData(qh.fJL, qh.fJM, qh.fJN, qh.index);
                addBigImageData.setKeyPageStartFrom(this.fHT.bcq());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        ap apVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.pa()) {
                showToast(d.j.no_network_guide);
            } else if (aZT() != null && aZT().getPbData() != null && aZT().getPbData().aZh() != null) {
                com.baidu.tieba.pb.data.l aZh = aZT().getPbData().aZh();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof ap)) {
                    apVar = null;
                } else {
                    apVar = (ap) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aZh != null) {
                    int i3 = -1;
                    if (z) {
                        aZh.sx(i);
                    } else if (aZh.aZs()) {
                        aZh.aZv();
                        i3 = 1;
                    } else {
                        aZh.sz(i);
                        i3 = 0;
                    }
                    aZh.sy(i2);
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void sH(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.fHT != null && this.fHT.bcj() != null) {
                        String str = "";
                        if (this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null) {
                            str = this.fHT.getPbData().aYL().zk();
                        }
                        if (this.fHT.getPbData() != null) {
                            this.fHT.getPbData().a(aZh);
                        }
                        if (z) {
                            this.fHT.bcj().a(str, 3, i, this.fHT.getForumId(), aVar);
                        } else {
                            this.fHT.bcj().a(str, i3, 3, i, this.fHT.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.fEA = i3;
                            kVar.fEB = aZh;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (apVar != null) {
                        apVar.b(aZh);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bar() {
        if (this.fHT.getPbData() == null || this.fHT.getPbData().aYL() == null) {
            return -1;
        }
        return this.fHT.getPbData().aYL().zx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bas() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.qF(this.fHT.getForumId()) && this.fHT.getPbData() != null && this.fHT.getPbData().aYJ() != null) {
            if (this.fHT.getPbData().aYJ().isLike() == 1) {
                baI();
                this.fHT.bcm().bI(this.fHT.getForumId(), this.fHT.bbK());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jN(boolean z) {
        if (this.fHT == null || this.fHT.getPbData() == null) {
            return false;
        }
        return ((this.fHT.getPbData().aYX() != 0) || this.fHT.getPbData().aYL() == null || this.fHT.getPbData().aYL().yT() == null || TextUtils.equals(this.fHT.getPbData().aYL().yT().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bat() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.o.q.Ok()) {
            return "";
        }
        PostData aYS = aYS();
        if (this.fHT == null || (pbData = this.fHT.getPbData()) == null || pbData.getUserData() == null || pbData.aYL() == null || aYS == null || aYS.yT() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aYS.yT().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aYL().yD() == 0) {
            return "";
        }
        if (pbData.aYL().yD() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean jO(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fHT == null || this.fHT.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.fHT.getPbData();
        if (pbData.aYX() == 0) {
            List<ay> aZf = pbData.aZf();
            if (com.baidu.tbadk.core.util.v.D(aZf) > 0) {
                for (ay ayVar : aZf) {
                    if (ayVar != null && (tVar = ayVar.aMS) != null && tVar.aKZ && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
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

    private boolean jP(boolean z) {
        return (z || this.fHT == null || this.fHT.getPbData() == null || this.fHT.getPbData().aYX() == 0) ? false : true;
    }

    public void bau() {
        if (this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null && this.fHT.getPbData().aYL().yT() != null) {
            if (this.fHU != null) {
                this.fHU.bdh();
            }
            bd aYL = this.fHT.getPbData().aYL();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aYL.yT().getUserId());
            ab abVar = new ab();
            int aYX = this.fHT.getPbData().aYX();
            if (aYX == 1) {
                abVar.fOK = true;
                abVar.fOJ = true;
                abVar.fOR = aYL.yO() == 1;
                abVar.fOQ = aYL.yP() == 1;
            } else {
                abVar.fOK = false;
                abVar.fOJ = false;
            }
            if (aYX == 1002 && !equals) {
                abVar.fOV = true;
            }
            abVar.fOG = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            abVar.fOL = jO(equals);
            abVar.fOM = bav();
            abVar.fON = jP(equals);
            abVar.fOH = this.fHT.bbL();
            abVar.fOI = true;
            abVar.fEQ = this.fin != null && this.fin.vl();
            abVar.fOF = jN(equals);
            abVar.fOT = bat();
            abVar.fOE = equals && this.fHU.bdN();
            abVar.fOO = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fOP = true;
            abVar.isHostOnly = this.fHT.getHostMode();
            abVar.fOS = true;
            if (aYL.zl() == null) {
                abVar.fOU = true;
            } else {
                abVar.fOU = false;
            }
            this.fHU.fQC.a(abVar);
        }
    }

    private boolean bav() {
        if (this.fHT != null && this.fHT.bbL()) {
            return this.fHT.aCV() == null || this.fHT.aCV().xW() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(View view) {
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

    public int baw() {
        if (bam() == null || bam().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bam().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) iVar).mType == com.baidu.tieba.pb.data.j.fEw) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bax() {
        if (bam() == null || bam().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bam().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof PostData) && iVar.getType() == PostData.gYA) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        baG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cY(getResources().getString(d.j.mark_done));
            aVar.bd(true);
            aVar.cZ(getResources().getString(d.j.mark_like));
            aVar.bc(true);
            aVar.aW(false);
            aVar.b(getResources().getString(d.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").aa("obj_id", metaData.getUserId()).s("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").aa("obj_id", metaData.getUserId()).s("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.bdJ.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fHT.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).AB();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fHU.bdG();
        this.fHT.ke(z);
        if (this.fin != null) {
            this.fin.aI(z);
            if (markData != null) {
                this.fin.a(markData);
            }
        }
        if (this.fHT.vl()) {
            baD();
        } else {
            this.fHU.n(this.fHT.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sC(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(String str) {
        if (!StringUtils.isNull(str) && this.fHT != null) {
            String bbK = this.fHT.bbK();
            String id = this.fHT.getPbData().aYJ().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + bbK + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fHT.bbR()) {
                    antiData.setBlock_forum_name(this.fHT.getPbData().aYJ().getName());
                    antiData.setBlock_forum_id(this.fHT.getPbData().aYJ().getId());
                    antiData.setUser_name(this.fHT.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fHT.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.vQ(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", ap.a.aVZ));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", ap.a.aVZ));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", ap.a.aVZ));
            }
        } else if (i == 230277) {
            gt(str);
        } else {
            this.fHU.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.fHU.a(0, bVar.aov, bVar.haW, z);
            if (bVar.aov) {
                if (bVar.haU == 1) {
                    ArrayList<PostData> aYN = this.fHT.getPbData().aYN();
                    int size = aYN.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aYN.get(i).getId())) {
                            i++;
                        } else {
                            aYN.remove(i);
                            break;
                        }
                    }
                    this.fHU.n(this.fHT.getPbData());
                } else if (bVar.haU == 0) {
                    bay();
                } else if (bVar.haU == 2) {
                    ArrayList<PostData> aYN2 = this.fHT.getPbData().aYN();
                    int size2 = aYN2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aYN2.get(i2).bvG().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aYN2.get(i2).bvG().get(i3).getId())) {
                                i3++;
                            } else {
                                aYN2.get(i2).bvG().remove(i3);
                                aYN2.get(i2).bvI();
                                z2 = true;
                                break;
                            }
                        }
                        aYN2.get(i2).sF(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fHU.n(this.fHT.getPbData());
                    }
                    a(bVar, this.fHU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fHU.a(this.cVn.getLoadDataMode(), gVar.aov, gVar.haW, false);
            if (gVar.aov) {
                this.fHW = true;
                if (i == 2 || i == 3) {
                    this.fHX = true;
                    this.fHY = false;
                } else if (i == 4 || i == 5) {
                    this.fHX = false;
                    this.fHY = true;
                }
                if (i == 2) {
                    this.fHT.getPbData().aYL().eS(1);
                    this.fHT.setIsGood(1);
                } else if (i == 3) {
                    this.fHT.getPbData().aYL().eS(0);
                    this.fHT.setIsGood(0);
                } else if (i == 4) {
                    this.fHT.getPbData().aYL().eR(1);
                    this.fHT.lR(1);
                } else if (i == 5) {
                    this.fHT.getPbData().aYL().eR(0);
                    this.fHT.lR(0);
                }
                this.fHU.c(this.fHT.getPbData(), this.fHT.bbL());
                if (this.fHT.getPbData().aYX() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void bay() {
        if (this.fHT.bbM() || this.fHT.bbO()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fHT.bbK());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.fHT.bbK()));
        if (baE()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baz() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aYU;
        boolean z = true;
        if (this.fHU != null) {
            this.fHU.bdT();
        }
        if (this.fHT != null && this.fHT.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fHT.getPbData().aYL().getId();
            if (this.fHT.isShareThread() && this.fHT.getPbData().aYL().aPc != null) {
                historyMessage.threadName = this.fHT.getPbData().aYL().aPc.showText;
            } else {
                historyMessage.threadName = this.fHT.getPbData().aYL().getTitle();
            }
            if (this.fHT.isShareThread() && !baY()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fHT.getPbData().aYJ().getName();
            }
            ArrayList<PostData> aYN = this.fHT.getPbData().aYN();
            int bdI = this.fHU != null ? this.fHU.bdI() : 0;
            if (aYN != null && bdI >= 0 && bdI < aYN.size()) {
                historyMessage.postID = aYN.get(bdI).getId();
            }
            historyMessage.isHostOnly = this.fHT.getHostMode();
            historyMessage.isSquence = this.fHT.bbL();
            historyMessage.isShareThread = this.fHT.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fIh != null) {
            this.fIh.onDestroy();
        }
        if (this.fHC && bam() != null) {
            bam().beo();
        }
        if (this.fHT != null && (this.fHT.bbM() || this.fHT.bbO())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fHT.bbK());
            if (this.fHW) {
                if (this.fHY) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fHT.bbQ());
                }
                if (this.fHX) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fHT.getIsGood());
                }
            }
            if (this.fHT.getPbData() != null && System.currentTimeMillis() - this.fHG >= 40000 && (aYU = this.fHT.getPbData().aYU()) != null && !com.baidu.tbadk.core.util.v.E(aYU.getDataList())) {
                intent.putExtra("guess_like_data", aYU);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fIv);
            }
            setResult(-1, intent);
        }
        if (baE()) {
            if (this.fHT != null && this.fHU != null && this.fHU.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.fHT.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aYR() && !this.fHM) {
                        aj bcS = aj.bcS();
                        com.baidu.tieba.pb.data.f pbData2 = this.fHT.getPbData();
                        Parcelable onSaveInstanceState = this.fHU.getListView().onSaveInstanceState();
                        boolean bbL = this.fHT.bbL();
                        boolean hostMode = this.fHT.getHostMode();
                        if (this.fHU.bdr() == null || this.fHU.bdr().getVisibility() != 0) {
                            z = false;
                        }
                        bcS.a(pbData2, onSaveInstanceState, bbL, hostMode, z);
                        if (this.fIu >= 0 || this.fHT.bcs() != null) {
                            aj.bcS().j(this.fHT.bcs());
                            aj.bcS().i(this.fHT.bct());
                            aj.bcS().sW(this.fHT.bcu());
                        }
                    }
                }
            } else {
                aj.bcS().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fHU == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fHU.sZ(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sE(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fHU.bdh();
            this.fHU.bdj().bbv();
            this.fHU.kD(false);
        }
        this.fHU.bdk();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fIh.resetData();
                        this.fIh.b(writeData);
                        this.fIh.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.r hJ = this.fIh.Kw().hJ(6);
                        if (hJ != null && hJ.bqj != null) {
                            hJ.bqj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fIh.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fHU.bdj() != null && this.fHU.bdj().bbz() != null) {
                            com.baidu.tbadk.editortools.pb.h bbz = this.fHU.bdj().bbz();
                            bbz.b(writeData);
                            bbz.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.r hJ2 = bbz.Kw().hJ(6);
                            if (hJ2 != null && hJ2.bqj != null) {
                                hJ2.bqj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bbz.Ln();
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
        this.fIh.onActivityResult(i, i2, intent);
        if (this.fHQ != null) {
            this.fHQ.onActivityResult(i, i2, intent);
        }
        if (bam().bdj() != null) {
            bam().bdj().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    baC();
                    return;
                case 13008:
                    aj.bcS().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fHT != null) {
                                PbActivity.this.fHT.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.fHT != null) {
                        a(baB(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (bar() == 1) {
                        baA();
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        bas();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dOd != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dOd.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void Hg() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54.1
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
                    this.fHU.jL(false);
                    if (this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null && this.fHT.getPbData().aYL().zo() != null) {
                        this.fHT.getPbData().aYL().zo().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fHU != null && this.fHU.fQC != null) {
                        this.fHU.fQC.vU();
                        this.fHU.fQC.beI();
                        if (this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null) {
                            this.fHT.getPbData().aYL().eN(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fHR != null) {
                        this.fHU.cA(this.fHR);
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
            if (this.fHQ == null) {
                this.fHQ = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fHQ.b(this.bsa);
                this.fHQ.c(this.bsh);
            }
            this.fHQ.a(emotionImageData, aZT(), aZT().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baA() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null && this.fHT.getPbData().aYL().zf() != null && this.fHT.getPbData().aYL().zf().size() > 0 && this.fHT.getPbData().aYL().zf().get(0) != null) {
            this.mAwardActId = this.fHT.getPbData().aYL().zf().get(0).wV();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.fHT.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void T(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    sG(2);
                    return;
                case 2:
                    this.fHU.bdy();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData baB() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bU = this.fHT.getPbData().bU(getPageContext().getPageActivity());
        PostData bdm = this.fHU.bdm();
        String str = "";
        if (bdm != null) {
            str = bdm.getId();
            String ci = bdm.ci(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ci)) {
                bU[1] = ci;
            }
        }
        String zk = this.fHT.getPbData().aYL().zk();
        if (zk != null && zk.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bU[1]);
        shareFromPBMsgData.setImageUrl(bU[0]);
        shareFromPBMsgData.setForumName(this.fHT.getPbData().aYJ().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fHT.getPbData().aYL().getId());
        shareFromPBMsgData.setTitle(this.fHT.getPbData().aYL().getTitle());
        return shareFromPBMsgData;
    }

    private void M(Intent intent) {
        a(baB(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.fd(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak aa = new com.baidu.tbadk.core.util.ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_param1", 3).aa(ImageViewerConfig.FORUM_ID, PbActivity.this.fHT.getForumId()).aa("tid", PbActivity.this.fHT.bbK());
                        if (PbActivity.this.e(PbActivity.this.fHT.getPbData()) != 0) {
                            aa.s("obj_type", PbActivity.this.e(PbActivity.this.fHT.getPbData()));
                        }
                        TiebaStatic.log(aa);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.bar() == 1) {
                        PbActivity.this.baA();
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
            aVar.aX(true);
            aVar.b(getPageContext()).AB();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), this.fHT.getPbData().aYY() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.fd(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.bar() == 1) {
                        PbActivity.this.baA();
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
            aVar.aX(true);
            aVar.b(getPageContext()).AB();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), this.fHT.getPbData().aYY() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baC() {
        MarkData sT;
        if (this.fin != null && (sT = this.fHT.sT(this.fHU.bdJ())) != null) {
            if (!sT.isApp() || (sT = this.fHT.sT(this.fHU.bdJ() + 1)) != null) {
                this.fHU.bdE();
                this.fin.a(sT);
                if (!this.fin.vl()) {
                    this.fin.vn();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fin.vm();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baD() {
        com.baidu.tieba.pb.data.f pbData = this.fHT.getPbData();
        this.fHT.ke(true);
        if (this.fin != null) {
            pbData.qb(this.fin.vk());
        }
        this.fHU.n(pbData);
    }

    private boolean baE() {
        if (this.fHT == null) {
            return true;
        }
        if (this.fHT.vl()) {
            final MarkData bbZ = this.fHT.bbZ();
            if (bbZ == null || !this.fHT.getIsFromMark()) {
                return true;
            }
            final MarkData sT = this.fHT.sT(this.fHU.bdI());
            if (sT == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bbZ);
                setResult(-1, intent);
                return true;
            } else if (sT.getPostId() == null || sT.getPostId().equals(bbZ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bbZ);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cZ(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fin != null) {
                            if (PbActivity.this.fin.vl()) {
                                PbActivity.this.fin.vm();
                                PbActivity.this.fin.aI(false);
                            }
                            PbActivity.this.fin.a(sT);
                            PbActivity.this.fin.aI(true);
                            PbActivity.this.fin.vn();
                        }
                        bbZ.setPostId(sT.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bbZ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.baz();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bbZ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.baz();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fHU != null && PbActivity.this.fHU.getView() != null) {
                            PbActivity.this.fHU.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bbZ);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.baz();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.AB();
                return false;
            }
        } else if (this.fHT.getPbData() == null || this.fHT.getPbData().aYN() == null || this.fHT.getPbData().aYN().size() <= 0 || !this.fHT.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fHU == null) {
            return null;
        }
        return this.fHU.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Rj() {
        if (this.fHU == null) {
            return 0;
        }
        return this.fHU.bdR();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Rk() {
        if (this.bJE == null) {
            this.bJE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: agq */
                public ImageView nl() {
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
        return this.bJE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Rl() {
        if (this.bJF == null) {
            this.bJF = TbRichTextView.x(getPageContext().getPageActivity(), 8);
        }
        return this.bJF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Rm() {
        if (this.bJJ == null) {
            this.bJJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bba */
                public GifView nl() {
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
                    gifView.LN();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bJJ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Rn() {
        if (this.bJG == null) {
            this.bJG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbb */
                public View nl() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cu */
                public void as(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cv */
                public View at(View view) {
                    ((PlayVoiceBntNew) view).bwR();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cw */
                public View au(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bJG;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Rp() {
        this.bJI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bbc */
            public RelativeLayout nl() {
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
        return this.bJI;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Ef() {
        if (this.bdh == null) {
            this.bdh = UserIconBox.v(getPageContext().getPageActivity(), 8);
        }
        return this.bdh;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fHK = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        if (ax.qs(str) && this.fHT != null && this.fHT.bbK() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").s("obj_param1", 1).aa("post_id", this.fHT.bbK()));
        }
        ax.bex().f(getPageContext(), str);
        this.fHK = true;
    }

    private com.baidu.tbadk.core.dialog.a baF() {
        if (this.fHF == null) {
            this.fHF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.fHF.cY(getPageContext().getString(d.j.download_baidu_video_dialog));
            this.fHF.a(getPageContext().getString(d.j.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.lk()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.BA());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.j.download_baidu_video));
                    }
                }
            });
            this.fHF.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fHF.aW(true);
            this.fHF.b(getPageContext());
            this.fHF.aX(false);
        }
        this.fHF.AB();
        return this.fHF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        ax.bex().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fHK = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            baF();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.fHK = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.fHT.getPbData();
            TbRichText ay = ay(str, i);
            if (ay != null && (tbRichTextData = ay.QD().get(this.fIZ)) != null) {
                cVar.fJL = new ArrayList<>();
                cVar.fJM = new ConcurrentHashMap<>();
                if (!tbRichTextData.QJ().QV()) {
                    cVar.fJO = false;
                    String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                    cVar.fJL.add(b2);
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
                    imageUrlData.postId = ay.getPostId();
                    imageUrlData.mIsReserver = this.fHT.bbY();
                    imageUrlData.mIsSeeHost = this.fHT.getHostMode();
                    cVar.fJM.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aYJ() != null) {
                            cVar.forumName = pbData.aYJ().getName();
                            cVar.forumId = pbData.aYJ().getId();
                        }
                        if (pbData.aYL() != null) {
                            cVar.threadId = pbData.aYL().getId();
                        }
                        cVar.fJN = pbData.aYY() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fJO = true;
                int size = pbData.aYN().size();
                this.fJa = false;
                cVar.index = -1;
                if (pbData.aYS() != null) {
                    PostData aYS = pbData.aYS();
                    TbRichText bvM = aYS.bvM();
                    if (!ar.k(aYS)) {
                        i2 = a(bvM, ay, i, i, cVar.fJL, cVar.fJM);
                    } else {
                        i2 = a(aYS, i, cVar.fJL, cVar.fJM);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aYN().get(i4);
                    if (postData.getId() == null || pbData.aYS() == null || pbData.aYS().getId() == null || !postData.getId().equals(pbData.aYS().getId())) {
                        TbRichText bvM2 = postData.bvM();
                        if (!ar.k(postData)) {
                            i3 = a(bvM2, ay, i3, i, cVar.fJL, cVar.fJM);
                        } else {
                            i3 = a(postData, i3, cVar.fJL, cVar.fJM);
                        }
                    }
                }
                if (cVar.fJL.size() > 0) {
                    cVar.lastId = cVar.fJL.get(cVar.fJL.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aYJ() != null) {
                        cVar.forumName = pbData.aYJ().getName();
                        cVar.forumId = pbData.aYJ().getId();
                    }
                    if (pbData.aYL() != null) {
                        cVar.threadId = pbData.aYL().getId();
                    }
                    cVar.fJN = pbData.aYY() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QJ() == null) {
            return null;
        }
        return tbRichTextData.QJ().Ra();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QJ() == null) {
            return 0L;
        }
        return tbRichTextData.QJ().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QJ() == null) {
            return false;
        }
        return tbRichTextData.QJ().Rb();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QJ() == null) {
            return false;
        }
        return tbRichTextData.QJ().Rc();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo QJ;
        String str;
        if (tbRichText == tbRichText2) {
            this.fJa = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.QD().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.QD().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.QJ().getWidth() * ar;
                    int height = ar * tbRichTextData.QJ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.QJ().QV()) {
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
                            if (tbRichTextData != null && (QJ = tbRichTextData.QJ()) != null) {
                                String QX = QJ.QX();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = QJ.QY();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = QX;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fHT.bbK(), -1L);
                                imageUrlData.mIsReserver = this.fHT.bbY();
                                imageUrlData.mIsSeeHost = this.fHT.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fJa) {
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
        com.baidu.tieba.tbadkCore.data.h bvT;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bvo;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bvo = (bvT = postData.bvT()).bvo()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bvo.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bvo.get(i3);
                if (jVar != null) {
                    String bvs = jVar.bvs();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bvs)) {
                        arrayList.add(bvs);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bvs;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bvr();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fHT.bbK(), -1L);
                        imageUrlData.mIsReserver = this.fHT.bbY();
                        imageUrlData.mIsSeeHost = this.fHT.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bvT.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bvs, imageUrlData);
                        }
                        if (!this.fJa) {
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
            if (postData.getId() != null && postData.getId().equals(this.fHT.zd())) {
                z = true;
            }
            MarkData h = this.fHT.h(postData);
            if (h != null) {
                this.fHU.bdE();
                if (this.fin != null) {
                    this.fin.a(h);
                    if (!z) {
                        this.fin.vn();
                    } else {
                        this.fin.vm();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ay(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fHT == null || this.fHT.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.fHT.getPbData();
        if (pbData.aYS() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aYS());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aYN = pbData.aYN();
            a(pbData, aYN);
            return a(aYN, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aYW() != null && fVar.aYW().fES != null && (list = fVar.aYW().fES) != null && arrayList != null) {
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

    private long qf(String str) {
        ArrayList<PostData> aYN;
        com.baidu.tieba.pb.data.f pbData = this.fHT.getPbData();
        if (pbData != null && (aYN = pbData.aYN()) != null && !aYN.isEmpty()) {
            Iterator<PostData> it = aYN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bvT = next.bvT();
                if (bvT != null && bvT.gYi) {
                    Iterator<TbRichTextData> it2 = next.bvM().QD().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.QS().getLink().equals(str)) {
                            return bvT.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> QD;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bvM = arrayList.get(i2).bvM();
            if (bvM != null && (QD = bvM.QD()) != null) {
                int size = QD.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (QD.get(i4) != null && QD.get(i4).getType() == 8) {
                        i3++;
                        if (QD.get(i4).QJ().QX().equals(str) || QD.get(i4).QJ().QY().equals(str)) {
                            int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                            int width = QD.get(i4).QJ().getWidth() * ar;
                            int height = QD.get(i4).QJ().getHeight() * ar;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fIZ = i4;
                            return bvM;
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
            this.fHh = str;
            if (this.fHE == null) {
                bao();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fHE.fj(1).setVisibility(8);
            } else {
                this.fHE.fj(1).setVisibility(0);
            }
            this.fHE.AE();
            this.fHK = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baG() {
        hideNetRefreshView(this.fHU.getView());
        baH();
        if (this.fHT.MQ()) {
            this.fHU.bdE();
        }
    }

    private void baH() {
        showLoadingView(this.fHU.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View Mj = getLoadingView().Mj();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Mj.getLayoutParams();
        layoutParams.addRule(3, this.fHU.beh().getId());
        Mj.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aus() {
        if (this.dBC != null) {
            this.dBC.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sF(int i) {
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
    public void sG(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fHT.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.fHT.getPbData();
            pbData.aYJ().getName();
            String title = pbData.aYL().getTitle();
            int i2 = this.fHT.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aYJ() != null) {
                if ((pbData.aYJ().isLike() == 1) && AddExperiencedModel.qF(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fHT.bbK() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bU = pbData.bU(getPageContext().getPageActivity());
                    str = bU[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bU[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bar() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").aa(ImageViewerConfig.FORUM_ID, pbData.getForumId()).aa("tid", pbData.getThreadId()).aa("uid", currentAccount));
                    } else if (bar() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").aa(ImageViewerConfig.FORUM_ID, pbData.getForumId()).aa("tid", pbData.getThreadId()).aa("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.bje = true;
                    dVar.bji = z;
                    dVar.extData = this.fHT.bbK();
                    dVar.bjs = 3;
                    dVar.bjr = i;
                    dVar.fid = this.fHT.getForumId();
                    dVar.tid = this.fHT.bbK();
                    dVar.bjt = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.bjm = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fHT.getPbData().aYL());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.bjs);
                    bundle.putInt("obj_type", dVar.bjt);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.h(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aZi()) {
                                PbActivity.this.fHU.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    if (this.bce == null) {
                        this.bce = new com.baidu.tieba.d.c(getActivity());
                    }
                    this.bce.a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fHT.bbK() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bU2 = pbData.bU(getPageContext().getPageActivity());
            str = bU2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bU2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bar() != 1) {
            }
            if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.bje = true;
            dVar2.bji = z;
            dVar2.extData = this.fHT.bbK();
            dVar2.bjs = 3;
            dVar2.bjr = i;
            dVar2.fid = this.fHT.getForumId();
            dVar2.tid = this.fHT.bbK();
            dVar2.bjt = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fHT.getPbData().aYL());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.bjs);
            bundle2.putInt("obj_type", dVar2.bjt);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.h(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fHT != null && PbActivity.this.fHT.getPbData() != null && PbActivity.this.fHT.getPbData().aZi()) {
                        PbActivity.this.fHU.getView().setSystemUiVisibility(4);
                    }
                }
            });
            if (this.bce == null) {
            }
            this.bce.a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aYL() != null) {
            if (fVar.aYL().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aYL().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void baI() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.qG(PbActivity.this.fHT.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fHU.bep();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Ro() {
        if (this.bJH == null) {
            this.bJH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbd */
                public LinearLayout nl() {
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
        return this.bJH;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fHU.bdz() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).aa(ImageViewerConfig.FORUM_ID, this.fHT.getPbData().getForumId()));
            } else {
                bd aYL = this.fHT.getPbData().aYL();
                if (view != null) {
                    boolean z = aYL.yI() == null || aYL.yI().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fIL > 1000) {
                            this.fIM = true;
                            ct(view);
                        } else {
                            this.fIM = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            s(view, this.fIM);
                        } else {
                            r(view, this.fIM);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        r(view, this.fIM);
                    } else if (motionEvent.getAction() == 3) {
                        r(view, this.fIM);
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
                    PbActivity.this.fIL = System.currentTimeMillis();
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
                    PbActivity.this.fIL = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void ct(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void aut() {
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
        } else if (aVar.AD() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.AD();
            int intValue = ((Integer) sparseArray.get(as.fSp)).intValue();
            if (intValue == as.fSq) {
                if (!this.cVn.bwx()) {
                    this.fHU.bdB();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cVn.a(this.fHT.getPbData().aYJ().getId(), this.fHT.getPbData().aYJ().getName(), this.fHT.getPbData().aYL().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == as.fSr || intValue == as.fSt) {
                if (this.fHT.bci() != null) {
                    this.fHT.bci().sK(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == as.fSr) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == as.fSs) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.fJf).wQ()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fIo);
        userMuteAddAndDelCustomMessage.setTag(this.fIo);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean qg(String str) {
        if (!StringUtils.isNull(str) && com.baidu.tbadk.core.util.ax.bb(getPageContext().getPageActivity())) {
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

    public void jQ(boolean z) {
        this.fIc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String baJ() {
        ArrayList<PostData> aYN;
        int D;
        if (this.fHT == null || this.fHT.getPbData() == null || this.fHT.getPbData().aYN() == null || (D = com.baidu.tbadk.core.util.v.D((aYN = this.fHT.getPbData().aYN()))) == 0) {
            return "";
        }
        if (this.fHT.bbY()) {
            Iterator<PostData> it = aYN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bvJ() == 1) {
                    return next.getId();
                }
            }
        }
        int bdI = this.fHU.bdI();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(aYN, bdI);
        if (postData == null || postData.yT() == null) {
            return "";
        }
        if (this.fHT.qj(postData.yT().getUserId())) {
            return postData.getId();
        }
        for (int i = bdI - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(aYN, i);
            if (postData2 == null || postData2.yT() == null || postData2.yT().getUserId() == null) {
                break;
            } else if (this.fHT.qj(postData2.yT().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bdI + 1; i2 < D; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(aYN, i2);
            if (postData3 == null || postData3.yT() == null || postData3.yT().getUserId() == null) {
                return "";
            }
            if (this.fHT.qj(postData3.yT().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.av.Da().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(qf(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fHT.getPbData().aYJ().getId(), this.fHT.getPbData().aYJ().getName(), this.fHT.getPbData().aYL().getTid());
            }
            this.fHK = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fHT.bch() != null) {
                    PbActivity.this.fHT.bch().cG(j);
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
        aVar.aX(false);
        aVar.b(getPageContext());
        aVar.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c qh(String str) {
        String str2;
        if (this.fHT.getPbData() == null || this.fHT.getPbData().aYN() == null || this.fHT.getPbData().aYN().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fHT.getPbData().aYN().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fHT.getPbData().aYN().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fHT.getPbData().aYN().get(i);
        if (postData.bvM() == null || postData.bvM().QD() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bvM().QD().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.QJ() != null) {
                    str2 = next.QJ().QX();
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
        if (this.fHA) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fHA = false;
        } else if (baK()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fHA) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fHA = false;
        } else if (baK()) {
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
        if (pageStayDurationItem != null && this.fHT != null) {
            if (this.fHT.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fHT.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fHT.bbK(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean baK() {
        return (!this.fHy && this.fJh == -1 && this.fJi == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fJk = mVar;
            this.fHy = true;
            this.fHU.bds();
            this.fHU.qq(this.fJj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baL() {
        if (this.fJk != null) {
            if (this.fJh == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.ax.ba(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fJk.getCartoonId(), this.fJh, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baM() {
        if (this.fJk != null) {
            if (this.fJi == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.ax.ba(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fJk.getCartoonId(), this.fJi, 0)));
                finish();
            }
        }
    }

    public int baN() {
        return this.fJh;
    }

    public int baO() {
        return this.fJi;
    }

    private void aCq() {
        if (this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null && this.fHT.getPbData().aYL().zG()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void baP() {
        if (this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null && this.fHT.getPbData().aYL().zG()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void baQ() {
        if (this.fHB) {
            this.fHP = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null && this.fHT.getPbData().aYL().yB() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fHT.getPbData().aYL().yB().getThreadId(), this.fHT.getPbData().aYL().yB().getTaskId(), this.fHT.getPbData().aYL().yB().getForumId(), this.fHT.getPbData().aYL().yB().getForumName(), this.fHT.getPbData().aYL().yO(), this.fHT.getPbData().aYL().yP())));
            this.fHA = true;
            finish();
        }
    }

    public boolean baR() {
        return this.fHB;
    }

    public String baS() {
        return this.fHN;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a baT() {
        return this.fHS;
    }

    public void jR(boolean z) {
        this.fHO = z;
    }

    public boolean baU() {
        if (this.fHT != null) {
            return this.fHT.bbM();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cZ(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fIm).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fIm.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fIm).AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fIm != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fIm.getPageActivity());
            aVar.cZ(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fIm).AB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fHU.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fIm.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cZ(this.fIm.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cZ(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fHU.showLoadingDialog();
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
        aVar.b(this.fIm).AB();
    }

    public void baW() {
        if (this.fHT != null && this.fHT.getPbData() != null && this.fHT.getPbData().aYL() != null && this.fHT.getPbData().aYL().zV() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.fb(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.fHT.getPbData().aYL().zV().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.AB();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ax.qs(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.fHU != null) {
            this.fHU.onConfigurationChanged(configuration);
        }
        if (this.fIa != null) {
            this.fIa.dismiss();
        }
    }

    public boolean baX() {
        if (this.fHT != null) {
            return this.fHT.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, as asVar) {
        boolean z;
        List<PostData> list = this.fHT.getPbData().aYW().fES;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bvG().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bvG().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bvG().remove(i2);
                    list.get(i).bvI();
                    z = true;
                    break;
                }
            }
            list.get(i).sF(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            asVar.n(this.fHT.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aZy().getId();
        List<PostData> list = this.fHT.getPbData().aYW().fES;
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
                ArrayList<PostData> aZC = mVar.aZC();
                postData.vK(mVar.getTotalCount());
                if (postData.bvG() != null) {
                    postData.bvG().clear();
                    postData.bvG().addAll(aZC);
                }
            }
        }
        if (!this.fHT.getIsFromMark()) {
            this.fHU.n(this.fHT.getPbData());
        }
    }

    public boolean baY() {
        if (this.fHT == null) {
            return false;
        }
        return this.fHT.baY();
    }

    public void baZ() {
        if (this.fHU != null) {
            this.fHU.bdh();
            aut();
        }
    }

    public PostData aYS() {
        return this.fHU.b(this.fHT.fNb, this.fHT.bbL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.isLinkThread()) {
                return 3;
            }
            if (bdVar.zX()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fIw != null && !this.fIw.isEmpty()) {
            int size = this.fIw.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fIw.get(i).onBackPressed()) {
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
            if (this.fIw == null) {
                this.fIw = new ArrayList();
            }
            if (!this.fIw.contains(aVar)) {
                this.fIw.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fIw == null) {
                this.fIw = new ArrayList();
            }
            if (!this.fIw.contains(aVar)) {
                this.fIw.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fIw != null) {
            this.fIw.remove(aVar);
        }
    }
}
