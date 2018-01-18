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
    private com.baidu.adp.lib.e.b<RelativeLayout> bJA;
    private com.baidu.adp.lib.e.b<GifView> bJB;
    private com.baidu.adp.lib.e.b<ImageView> bJw;
    private com.baidu.adp.lib.e.b<TextView> bJx;
    private com.baidu.adp.lib.e.b<View> bJy;
    private com.baidu.adp.lib.e.b<LinearLayout> bJz;
    private com.baidu.tieba.d.c bbW;
    private com.baidu.adp.lib.e.b<TbImageView> bcZ;
    private com.baidu.tieba.e.b ckL;
    private VoiceManager dBh;
    private String fGM;
    public au fHE;
    private y fHF;
    private boolean fHH;
    private com.baidu.tieba.tbadkCore.data.e fHK;
    private com.baidu.tbadk.editortools.pb.g fHL;
    private com.baidu.tbadk.editortools.pb.d fHM;
    private com.baidu.adp.base.e fHR;
    private com.baidu.tbadk.core.view.e fHS;
    private BdUniqueId fHT;
    private Runnable fHU;
    private aw fHV;
    private com.baidu.adp.widget.a.a fHW;
    private String fHX;
    private TbRichTextMemeInfo fHY;
    private com.baidu.tieba.pb.pb.main.a.b fHe;
    private com.baidu.tbadk.core.dialog.a fHk;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fHv;
    private View fHw;
    private boolean fIC;
    private String fIO;
    private com.baidu.tbadk.core.data.m fIP;
    private List<a> fIb;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private boolean fHd = false;
    private boolean fHf = false;
    private boolean fHg = false;
    private boolean fkD = false;
    private boolean fHh = true;
    private int fHi = 0;
    private com.baidu.tbadk.core.dialog.b fHj = null;
    private long dmx = -1;
    private long byw = 0;
    private long fHl = 0;
    private long createTime = 0;
    private long byo = 0;
    private boolean fHm = false;
    private com.baidu.tbadk.k.d fHn = null;
    private long fHo = 0;
    private boolean fHp = false;
    private long fHq = 0;
    private String brO = null;
    private boolean fHr = false;
    private boolean isFullScreen = false;
    private String fHs = "";
    private boolean fHt = true;
    private boolean fHu = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fHx = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void W(boolean z) {
            PbActivity.this.fHz.kt(!PbActivity.this.fHt);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fHy != null && PbActivity.this.fHy.vk()) {
                        PbActivity.this.bay();
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", ap.a.aVY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", ap.a.aVY));
        }
    };
    private PbModel fHy = null;
    private com.baidu.tbadk.baseEditMark.a fhR = null;
    private ForumManageModel cUS = null;
    private com.baidu.tbadk.coreExtra.model.a bdB = null;
    private ShareSuccessReplyToServerModel dNI = null;
    private as fHz = null;
    public final com.baidu.tieba.pb.pb.main.a.a fHA = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean fHB = false;
    private boolean fHC = false;
    private boolean fHD = false;
    private boolean fHG = false;
    private boolean fHI = false;
    private boolean fHJ = false;
    private boolean fHN = false;
    public boolean fHO = false;
    private com.baidu.tbadk.editortools.pb.c brR = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void KR() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b brS = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean KQ() {
            if (PbActivity.this.fHE == null || PbActivity.this.fHE.beo() == null || !PbActivity.this.fHE.beo().bEO()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fHE.beo().bEQ());
            if (PbActivity.this.fHM != null && (PbActivity.this.fHM.Lf() || PbActivity.this.fHM.Lg())) {
                PbActivity.this.fHM.a(false, PbActivity.this.fHE.ber());
            }
            PbActivity.this.fHE.kE(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fHP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean KQ() {
            if (PbActivity.this.fHE == null || PbActivity.this.fHE.bep() == null || !PbActivity.this.fHE.bep().bEO()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fHE.bep().bEQ());
            if (PbActivity.this.fHz != null && PbActivity.this.fHz.bde() != null && PbActivity.this.fHz.bde().bbw() != null && PbActivity.this.fHz.bde().bbw().Lg()) {
                PbActivity.this.fHz.bde().bbw().a(PbActivity.this.fHE.ber());
            }
            PbActivity.this.fHE.kF(true);
            return true;
        }
    };
    private boolean fHQ = false;
    private int mLastScrollState = -1;
    private boolean dBN = false;
    private int fHZ = 0;
    private int fIa = -1;
    private final a fIc = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fHz != null && PbActivity.this.fHz.bde() != null) {
                s bde = PbActivity.this.fHz.bde();
                if (bde.bbs()) {
                    bde.bbr();
                    return true;
                }
            }
            if (PbActivity.this.fHz != null && PbActivity.this.fHz.bdV()) {
                PbActivity.this.fHz.bdW();
                return true;
            }
            return false;
        }
    };
    private final z.a fId = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void J(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fHz.showToast(str);
            }
        }
    };
    private final CustomMessageListener fIe = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fHy != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fHM != null) {
                    PbActivity.this.fHz.ky(PbActivity.this.fHM.KY());
                }
                PbActivity.this.fHz.bdf();
                PbActivity.this.fHz.bdO();
            }
        }
    };
    CustomMessageListener dCf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                PbActivity.this.fHy.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                if (PbActivity.this.fHz != null && PbActivity.this.fHy != null) {
                    PbActivity.this.fHz.d(PbActivity.this.fHy.getPbData(), PbActivity.this.fHy.bbG(), PbActivity.this.fHy.getRequestType());
                }
                if (PbActivity.this.fHz != null && PbActivity.this.fHz.bdv() != null) {
                    PbActivity.this.fHz.bdv().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fIf = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fHz != null) {
                    if (booleanValue) {
                        PbActivity.this.fHz.aIC();
                    } else {
                        PbActivity.this.fHz.aIB();
                    }
                }
            }
        }
    };
    private CustomMessageListener fIg = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fHM != null) {
                    PbActivity.this.fHz.ky(PbActivity.this.fHM.KY());
                }
                PbActivity.this.fHz.kA(false);
            }
        }
    };
    private CustomMessageListener fIh = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
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
    private CustomMessageListener fIi = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fHz != null && PbActivity.this.fHz.bdv() != null) {
                PbActivity.this.fHz.bdv().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener esv = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private j.a fIj = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void i(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.sF(2);
                aj.bcN().reset();
                PbActivity.this.fHy.bbY();
                boolean z2 = false;
                ArrayList<PostData> aYI = PbActivity.this.fHy.getPbData().aYI();
                if (aYI != null) {
                    Iterator<PostData> it = aYI.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ar.k(next) && next.bvR().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fHz.n(PbActivity.this.fHy.getPbData());
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
    private View.OnClickListener bsz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.brO);
        }
    };
    private CustomMessageListener fIk = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.aLr = yVar.aLr;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHy.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fHy.bbP() != null && PbActivity.this.fHy.bbP().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fHz.a(yVar.sendCount, PbActivity.this.fHy.getPbData(), PbActivity.this.fHy.bbG(), PbActivity.this.fHy.getRequestType());
                    }
                    if (pbData.aYI() != null && pbData.aYI().size() >= 1 && pbData.aYI().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aYI().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.fHy.bbF(), 0L);
                        if (c2 == yVar.postId && c3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bvQ = pbData.aYI().get(0).bvQ();
                            if (bvQ == null) {
                                bvQ = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> xX = bvQ.xX();
                            if (xX == null) {
                                xX = new ArrayList<>();
                            }
                            xX.add(0, aVar);
                            bvQ.eL(yVar.sendCount + bvQ.xW());
                            bvQ.h(xX);
                            pbData.aYI().get(0).a(bvQ);
                            PbActivity.this.fHz.bdv().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a fIl = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.aqp() != null && !aVar.aqp().isEmpty()) {
                    PbActivity.this.fHz.a(aVar, PbActivity.this.fIn);
                }
                PbActivity.this.fHz.a(aVar, PbActivity.this.fHy.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.beu()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fIm = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void J(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.E(list) && PbActivity.this.fHz != null) {
                PbActivity.this.fHz.cQ(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fIn = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
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
    private boolean fIo = false;
    private PraiseModel fIp = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hZ(String str) {
            PbActivity.this.fIo = false;
            if (PbActivity.this.fIp != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHy.getPbData();
                if (pbData.aYG().yH().getIsLike() == 1) {
                    PbActivity.this.nC(0);
                } else {
                    PbActivity.this.nC(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aYG()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void F(int i, String str) {
            PbActivity.this.fIo = false;
            if (PbActivity.this.fIp != null && str != null) {
                if (AntiHelper.vQ(i)) {
                    AntiHelper.ao(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fIq = 0;
    private boolean fIr = true;
    private b.a fIs = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jP(boolean z) {
            PbActivity.this.jO(z);
            if (PbActivity.this.fHz.beb() != null && z) {
                PbActivity.this.fHz.kt(false);
            }
            PbActivity.this.fHz.kv(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().bgK != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().bgK, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", ap.a.aVY));
                        }
                    } else if (updateAttentionMessage.getData().apN) {
                        if (PbActivity.this.aYN().yS() != null && PbActivity.this.aYN().yS().getGodUserData() != null) {
                            PbActivity.this.aYN().yS().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aYG() != null && PbActivity.this.fHy.getPbData().aYG().yS() != null) {
                            PbActivity.this.fHy.getPbData().aYG().yS().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cwj = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fHz.aeY();
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
                    com.baidu.tieba.h.a.aAo();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bJG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (PbActivity.this.fHz.bdg()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fHy != null && (PbActivity.this.fHy.getPbData() != null || PbActivity.this.fHy.getPbData().aZc() != null)) {
                    if (PbActivity.this.fHy.getPbData().aZc().aZn()) {
                        if (PbActivity.this.fHy.getPbData().aZc().fEf == 1 || PbActivity.this.fHy.getPbData().aZc().fEf == 3 || PbActivity.this.fHy.getPbData().aZc().fEf == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fHy.getPbData().aZc().aZn() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fHy.getPbData().aZc().aZn() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fHq > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).la(false);
                        PbActivity.this.fHq = System.currentTimeMillis();
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
                    if (PbActivity.this.fHz != null && PbActivity.this.fHz.bai() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ab("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.fHA != null && PbActivity.this.fHA.fUs != null) {
                            PbActivity.this.fHA.fUs.onClick(view);
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
            if (PbActivity.this.fHM != null) {
                PbActivity.this.fHz.ky(PbActivity.this.fHM.KY());
            }
            PbActivity.this.fHz.bdf();
            PbActivity.this.fHz.bdO();
            return true;
        }
    });
    private CustomMessageListener fIt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fHT) {
                PbActivity.this.fHz.aeY();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHy.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aYU().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fHS.q(PbActivity.this.fHR.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fHR.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gk(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.baQ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fHR.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.fHS.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fIu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fHT) {
                PbActivity.this.fHz.aeY();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fHS.q(PbActivity.this.fHR.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fHR.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.fHS.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fIv = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fHT) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fHz.aeY();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hlZ;
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
                    PbActivity.this.fHz.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fIw = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fHz.bdg() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aZO() != null && PbActivity.this.aZO().getPbData() != null && PbActivity.this.aZO().getPbData().aZc() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aZn = PbActivity.this.aZO().getPbData().aZc().aZn();
                if (intValue < 10) {
                    if (aZn) {
                        if (PbActivity.this.fHy.getPbData().aZc().fEf == 1 || PbActivity.this.fHy.getPbData().aZc().fEf == 3 || PbActivity.this.fHy.getPbData().aZc().fEf == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fHy.getPbData().aZc().aZn() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", aZn ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fHq > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).la(false);
                        PbActivity.this.fHq = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aZn, 3);
                TiebaStatic.log(PbActivity.this.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).s("obj_locate", 4).s("obj_id", aZn ? 0 : 1));
            }
        }
    };
    private CustomMessageListener dCo = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dBN = true;
                }
            }
        }
    };
    public a.b fuy = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.auo();
            com.baidu.tbadk.core.data.al aCQ = PbActivity.this.fHy.aCQ();
            int pageNum = PbActivity.this.fHz.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (aCQ == null || pageNum <= aCQ.xP()) {
                PbActivity.this.fHz.bdO();
                PbActivity.this.sF(2);
                PbActivity.this.aun();
                PbActivity.this.fHz.bdz();
                if (com.baidu.adp.lib.util.j.oI()) {
                    PbActivity.this.fHy.sN(PbActivity.this.fHz.getPageNum());
                    if (PbActivity.this.fHe != null) {
                        PbActivity.this.fHe.showFloatingView();
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
    public final View.OnClickListener dCL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
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
            com.baidu.tieba.pb.data.l aZc;
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
                    if (view == PbActivity.this.fHz.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fHy.jZ(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fHz.bdA();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcG()) {
                        if (view == PbActivity.this.fHz.fQh.bAq) {
                            if (PbActivity.this.fHz.kx(PbActivity.this.fHy.bbM())) {
                                PbActivity.this.aun();
                                return;
                            }
                            PbActivity.this.fHh = false;
                            PbActivity.this.fHf = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fHz.bdx() && (PbActivity.this.fHz.fQh.beF() == null || (view != PbActivity.this.fHz.fQh.beF().bcF() && view != PbActivity.this.fHz.fQh.beF().bcD()))) {
                            if (view == PbActivity.this.fHz.bdR()) {
                                if (PbActivity.this.fHy != null) {
                                    com.baidu.tbadk.browser.a.Q(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHy.getPbData().aYG().yR().getLink());
                                }
                            } else if (view != PbActivity.this.fHz.fQh.fVc && view.getId() != d.g.view_forum_name_first_floor && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.fHz.fQh.fVd) {
                                    if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null) {
                                        ArrayList<PostData> aYI = PbActivity.this.fHy.getPbData().aYI();
                                        if ((aYI == null || aYI.size() <= 0) && PbActivity.this.fHy.bbG()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ab("tid", PbActivity.this.fHy.bbF()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getForumId()));
                                        if (!PbActivity.this.fHz.bei()) {
                                            PbActivity.this.fHz.bdf();
                                        }
                                        PbActivity.this.bap();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcr()) {
                                        if ((PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcC()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.fHz.fQh.beF() == null || (view != PbActivity.this.fHz.fQh.beF().getCancelView() && view != PbActivity.this.fHz.fQh.beF().bcB())) {
                                                if (view != PbActivity.this.fHz.fQh.fVe && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcz()) {
                                                        if ((PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcI()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcA()) {
                                                                if (PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcJ()) {
                                                                    if (PbActivity.this.fHF == null || view != PbActivity.this.fHF.bct()) {
                                                                        if (PbActivity.this.fHF == null || view != PbActivity.this.fHF.bcr()) {
                                                                            if (PbActivity.this.fHF == null || view != PbActivity.this.fHF.bcw()) {
                                                                                if (PbActivity.this.fHF == null || view != PbActivity.this.fHF.bcu()) {
                                                                                    if (PbActivity.this.fHF == null || view != PbActivity.this.fHF.bcv()) {
                                                                                        if (PbActivity.this.fHz.beb() == view) {
                                                                                            if (PbActivity.this.fHz.beb().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHy.getPbData();
                                                                                                if (pbData != null && pbData.aYG() != null && pbData.aYG().yA() != null) {
                                                                                                    String xi = pbData.aYG().yA().xi();
                                                                                                    if (StringUtils.isNull(xi)) {
                                                                                                        xi = pbData.aYG().yA().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ab("obj_id", xi));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cc("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.baL();
                                                                                        } else if (PbActivity.this.fHz.bdu() != view) {
                                                                                            if (PbActivity.this.fHF == null || view != PbActivity.this.fHF.bcs()) {
                                                                                                if (PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcH()) {
                                                                                                    if (PbActivity.this.fHz.fQh.beF() != null && view == PbActivity.this.fHz.fQh.beF().bcE()) {
                                                                                                        if (com.baidu.adp.lib.util.j.oI()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.fHz.c(PbActivity.this.fHy.getPbData(), PbActivity.this.fHy.bbG(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.fHz.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.fHz.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.fHz.fQh.vT();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.fHz.bab()) {
                                                                                                            if (view == PbActivity.this.fHz.fQh.beG()) {
                                                                                                                PbActivity.this.fHz.bdH();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (biVar = (bi) view.getTag()) != null && !StringUtils.isNull(biVar.Ap())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        com.baidu.tbadk.core.util.av.CZ().c(PbActivity.this.getPageContext(), new String[]{biVar.Ap()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData cr = PbActivity.this.cr(view);
                                                                                                                    if (cr != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 5).s("obj_id", cr.bvW() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.aZO() != null && PbActivity.this.aZO().getPbData() != null && PbActivity.this.aZO().getPbData().aZc() != null && PbActivity.this.aZO().getPbData().aZc() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 4).s("obj_id", PbActivity.this.aZO().getPbData().aZc().aZn() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && !StringUtils.isNull(PbActivity.this.fHy.getPbData().getThreadId()) && (aZc = PbActivity.this.fHy.getPbData().aZc()) != null && aZc.aZl() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.av.CZ().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.fHy.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.fHF == null) {
                                                                                                                                PbActivity.this.fHF = new y(PbActivity.this.getPageContext(), PbActivity.this.dCL);
                                                                                                                                PbActivity.this.fHz.cB(PbActivity.this.fHF.getView());
                                                                                                                                PbActivity.this.fHF.kd(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.fHF.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ab("tid", PbActivity.this.fHy.fMn));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.fHF.bcr().setTag(sparseArray2);
                                                                                                                            PbActivity.this.fHF.bcw().setTag(view.getTag());
                                                                                                                            PbActivity.this.fHF.kf(z6);
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
                                                                                                                                    PbActivity.this.fHF.bcu().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.fHF.bcu().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.fHF.bcs().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fHF.bcu().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fHF.bcs().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.fHF.bcs().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.fHF.bcs().setVisibility(8);
                                                                                                                                PbActivity.this.fHF.bcu().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.fHF.bcs().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fHF.bcu().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fHF.bcs().setText(d.j.delete);
                                                                                                                                PbActivity.this.fHF.bcu().setVisibility(0);
                                                                                                                                if (PbActivity.this.fHy.getPbData().aYS() != 1002 || z2) {
                                                                                                                                    PbActivity.this.fHF.bcu().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fHF.bcu().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.fHF.bcs().setVisibility(8);
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
                                                                                                                                PbActivity.this.fHF.bct().setTag(sparseArray7);
                                                                                                                                PbActivity.this.fHF.bct().setVisibility(0);
                                                                                                                                PbActivity.this.fHF.bcs().setVisibility(8);
                                                                                                                                PbActivity.this.fHF.bct().setText(d.j.mute_option);
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
                                                                                                                                boolean jK = PbActivity.this.jK(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fIG = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (ar.k(PbActivity.this.fIG) ? false : jK) {
                                                                                                                                    PbActivity.this.fHF.bct().setVisibility(0);
                                                                                                                                    PbActivity.this.fHF.bct().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fHF.bct().setVisibility(8);
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
                                                                                                                                PbActivity.this.fHF.bcv().setVisibility(0);
                                                                                                                                PbActivity.this.fHF.bcv().setTag(d.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                                PbActivity.this.fHF.bcv().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.fHF.bcv().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.fHF.bcv().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fHy.getPbData().vk()) {
                                                                                                                            String vj = PbActivity.this.fHy.getPbData().vj();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(vj) && vj.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.fHF.bcr().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fHF.bcr().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fHF.ke(true);
                                                                                                                                PbActivity.this.fHF.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.fHF.ke(true);
                                                                                                                        PbActivity.this.fHF.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aYG() != null && PbActivity.this.fHy.getPbData().aYG().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.Q(PbActivity.this.getActivity(), PbActivity.this.fHy.getPbData().aYG().getActUrl());
                                                                                                                        if (PbActivity.this.fHy.getPbData().aYG().zw() != 1) {
                                                                                                                            if (PbActivity.this.fHy.getPbData().aYG().zw() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getPbData().getForumId()).ab("tid", PbActivity.this.fHy.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.fHy.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.fHz.setSelection(0);
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
                                                                                                                        PbActivity.this.fHz.bdf();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.Q(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.bam() == 1) {
                                                                                                                            if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getPbData().getForumId()).ab("tid", PbActivity.this.fHy.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.bam() == 2 && PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getPbData().getForumId()).ab("tid", PbActivity.this.fHy.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.Q(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.bam() == 1) {
                                                                                                                            if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getPbData().getForumId()).ab("tid", PbActivity.this.fHy.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.bam() == 2 && PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getPbData().getForumId()).ab("tid", PbActivity.this.fHy.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.baG();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.baH();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aYY() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.fHy.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ab(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.CZ().c(PbActivity.this.getPageContext(), new String[]{pbData2.aYY().aZh()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aYY() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.fHy.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ab(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.CZ().c(PbActivity.this.getPageContext(), new String[]{pbData3.aYY().aZh()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.fHz.fQh.beF() != null && view == PbActivity.this.fHz.fQh.beF().bcK()) {
                                                                                                                    if (PbActivity.this.fHy == null || PbActivity.this.fHy.getPbData() == null || PbActivity.this.fHy.getPbData().aYG() == null) {
                                                                                                                        PbActivity.this.fHz.fQh.vT();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.oZ()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.fHy.getPbData().aYG().yC() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHy.bbF(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).AI();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").s("obj_locate", PbActivity.this.X(PbActivity.this.fHy.getPbData().aYG())).ab("tid", PbActivity.this.fHy.getPbData().aYG().getTid()).s("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.fHZ >= 0) {
                                                                                                                        if (PbActivity.this.fHy != null) {
                                                                                                                            PbActivity.this.fHy.bcm();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fHz.bdv() != null) {
                                                                                                                            PbActivity.this.fHz.bdv().a(PbActivity.this.fHy.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.fHz.getListView().setSelection(PbActivity.this.fHy.bcp());
                                                                                                                        PbActivity.this.fHZ = 0;
                                                                                                                        if (PbActivity.this.fHy != null) {
                                                                                                                            PbActivity.this.fHy.cs(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.fHz.bel();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.fHy.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.fHy.bbF(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fHy.getPbData().aYG().zn())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.fHy.getPbData() != null) {
                                                                                                            PbActivity.this.fHz.bdO();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bvY() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12630"));
                                                                                                                }
                                                                                                                String bbF = PbActivity.this.fHy.bbF();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.fHy.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.fHy.getPbData().aYS();
                                                                                                                }
                                                                                                                PbActivity.this.aun();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c pZ = PbActivity.this.pZ(id2);
                                                                                                                    if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && pZ != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bbF, id2, "pb", true, null, true, null, i3, postData3.bfv(), PbActivity.this.fHy.getPbData().xG(), false, postData3.yS().getIconInfo()).addBigImageData(pZ.fJq, pZ.fJr, pZ.fJs, pZ.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.fHy.bcl());
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
                                                                                                                    c pZ2 = PbActivity.this.pZ(id2);
                                                                                                                    if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && pZ2 != null && PbActivity.this.bah().bdd() != null) {
                                                                                                                        com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                        mVar.b(PbActivity.this.fHy.getPbData().aYE());
                                                                                                                        mVar.Q(PbActivity.this.fHy.getPbData().aYG());
                                                                                                                        mVar.d(postData4);
                                                                                                                        PbActivity.this.bah().bdd().d(mVar);
                                                                                                                        PbActivity.this.bah().bdd().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c pZ3 = PbActivity.this.pZ(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && pZ3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bbF, id2, "pb", true, null, false, null, i3, postData3.bfv(), PbActivity.this.fHy.getPbData().xG(), false, postData3.yS().getIconInfo()).addBigImageData(pZ3.fJq, pZ3.fJr, pZ3.fJs, pZ3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.fHy.bcl());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 3).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.oI()) {
                                                                                                    PbActivity.this.fHz.bdO();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.fHz.c(PbActivity.this.fHy.getPbData(), PbActivity.this.fHy.bbG(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHy.getPbData().aYE().getId(), PbActivity.this.fHy.getPbData().aYE().getName(), PbActivity.this.fHy.getPbData().aYG().getId(), String.valueOf(PbActivity.this.fHy.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
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
                                                                                                    if (!com.baidu.tieba.c.a.ajX() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fHy.bbF(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.fHz.cz(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.fHz.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.bad();
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
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.fHy.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aYE() != null) {
                                                                                            str9 = pbData4.aYE().getId();
                                                                                            str10 = pbData4.aYE().getName();
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
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.ajX() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fHy.bbF(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.fHz.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.fHF.bcy()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ab("tid", PbActivity.this.fHy.fMn));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fHy.getPbData() != null) {
                                                                                    PbActivity.this.fHz.bdO();
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
                                                                                        String bbF2 = PbActivity.this.fHy.bbF();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.fHy.getPbData() != null) {
                                                                                            i5 = PbActivity.this.fHy.getPbData().aYS();
                                                                                        }
                                                                                        PbActivity.this.aun();
                                                                                        c pZ4 = PbActivity.this.pZ(id3);
                                                                                        if (pZ4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bbF2, id3, "pb", true, null, true, null, i5, postData.bfv(), PbActivity.this.fHy.getPbData().xG(), false, postData.yS().getIconInfo()).addBigImageData(pZ4.fJq, pZ4.fJr, pZ4.fJs, pZ4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.fHy.bcl());
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
                                                                                if (PbActivity.this.fHy.getPbData().aYG() != null && PbActivity.this.fHy.getPbData().aYG().yS() != null && PbActivity.this.fHy.getPbData().aYG().yS().getUserId() != null && PbActivity.this.fhR != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ab("tid", PbActivity.this.fHy.fMn).s("obj_locate", 2).ab("obj_id", PbActivity.this.fHy.getPbData().aYG().yS().getUserId()).s("obj_type", PbActivity.this.fhR.vk() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fHy.getPbData())));
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
                                                                            PbActivity.this.pW((String) tag);
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
                                                                    PbActivity.this.fHz.fQh.beE();
                                                                }
                                                            } else if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aYG() != null) {
                                                                PbActivity.this.fHz.fQh.vT();
                                                                PbActivity.this.pW(PbActivity.this.fHy.getPbData().aYG().zj());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fHz.bdO();
                                                            if (com.baidu.adp.lib.util.j.oI()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.fHy.bbT()));
                                                                    return;
                                                                }
                                                                PbActivity.this.sF(2);
                                                                PbActivity.this.aun();
                                                                PbActivity.this.fHz.bdz();
                                                                boolean bbS = PbActivity.this.fHy.bbS();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.fHy.bbT()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.fHz.fQh != null && PbActivity.this.fHz.fQh.beF() != null && view == PbActivity.this.fHz.fQh.beF().bcI()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (bbS) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.fHz.ko(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fHz.bdO();
                                                        if (PbActivity.this.fHy.aCQ() != null) {
                                                            PbActivity.this.fHz.a(PbActivity.this.fHy.aCQ(), PbActivity.this.fuy);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.am.nu() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fHy != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ab("tid", PbActivity.this.fHy.bbF()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getForumId()).s("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.oZ()) {
                                                        if (PbActivity.this.fHy.getPbData() != null) {
                                                            ArrayList<PostData> aYI2 = PbActivity.this.fHy.getPbData().aYI();
                                                            if ((aYI2 != null && aYI2.size() > 0) || !PbActivity.this.fHy.bbG()) {
                                                                PbActivity.this.fHz.bdO();
                                                                PbActivity.this.aun();
                                                                PbActivity.this.sF(2);
                                                                if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aYY() != null && !StringUtils.isNull(PbActivity.this.fHy.getPbData().aYY().xt(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.am.nu()) {
                                                                    PbActivity.this.sG(2);
                                                                } else {
                                                                    PbActivity.this.fHz.showLoadingDialog();
                                                                    PbActivity.this.fHy.bcg().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.fHz.fQh.vT();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.oI()) {
                                            PbActivity.this.fHz.bdO();
                                            if (PbActivity.this.fHz.fQh.beF() != null && view == PbActivity.this.fHz.fQh.beF().bcC() && !PbActivity.this.fHz.bei()) {
                                                PbActivity.this.fHz.bdf();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.aun();
                                                PbActivity.this.fHz.bdz();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    j = PbActivity.this.fHy.j(true, PbActivity.this.baE());
                                                } else {
                                                    j = view.getId() == d.g.reply_title ? PbActivity.this.fHy.j(false, PbActivity.this.baE()) : PbActivity.this.fHy.qa(PbActivity.this.baE());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.fHz.jT(true);
                                                    PbActivity.this.fHz.aIC();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fHz.ko(true);
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
                                    } else if (com.baidu.adp.lib.util.j.oI()) {
                                        PbActivity.this.fHz.bdO();
                                        if (PbActivity.this.sE(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fHy.sT(PbActivity.this.fHz.bdE()) != null) {
                                            PbActivity.this.bax();
                                            if (PbActivity.this.fHy.getPbData().aYG() != null && PbActivity.this.fHy.getPbData().aYG().yS() != null && PbActivity.this.fHy.getPbData().aYG().yS().getUserId() != null && PbActivity.this.fhR != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ab("tid", PbActivity.this.fHy.fMn).s("obj_locate", 1).ab("obj_id", PbActivity.this.fHy.getPbData().aYG().yS().getUserId()).s("obj_type", PbActivity.this.fhR.vk() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fHy.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.oI()) {
                                    PbActivity.this.fHz.jT(true);
                                    PbActivity.this.fHz.bdf();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fHz.aIC();
                                        PbActivity.this.aun();
                                        PbActivity.this.fHz.bdz();
                                        PbActivity.this.fHy.qa(PbActivity.this.baE());
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
                                if (PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aYG() != null && PbActivity.this.fHy.getPbData().aYG().zF() && PbActivity.this.fHy.getPbData().aYG().zk() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.fHy.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fHy.bbE()) && PbActivity.this.fHy.getAppealInfo() != null) {
                                        name = PbActivity.this.fHy.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fHy.getPbData().aYE().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bbE = PbActivity.this.fHy.bbE();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fHy.bbH() && bbE != null && bbE.equals(name)) {
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
                            if (PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aYS() == 1 && !PbActivity.this.cUS.bwv()) {
                                PbActivity.this.fHz.bdO();
                                int i6 = 0;
                                if (PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcD()) {
                                    if (PbActivity.this.fHz.fQh.beF() == null || view != PbActivity.this.fHz.fQh.beF().bcF()) {
                                        if (view == PbActivity.this.fHz.bdx()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.fHy.getPbData().aYG().yO() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.fHy.getPbData().aYG().yN() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aYE = PbActivity.this.fHy.getPbData().aYE();
                                String name2 = aYE.getName();
                                String id4 = aYE.getId();
                                String id5 = PbActivity.this.fHy.getPbData().aYG().getId();
                                if (!com.baidu.tieba.c.a.ajX() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.fHz.bdw();
                                    PbActivity.this.cUS.a(id4, name2, id5, i6, PbActivity.this.fHz.bdy());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.oI()) {
                        PbActivity.this.fHz.bdO();
                        PbActivity.this.aun();
                        PbActivity.this.fHz.bdz();
                        PbActivity.this.fHz.showLoadingDialog();
                        if (PbActivity.this.fHz.bdm() != null) {
                            PbActivity.this.fHz.bdm().setVisibility(8);
                        }
                        PbActivity.this.fHy.sN(1);
                        if (PbActivity.this.fHe != null) {
                            PbActivity.this.fHe.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bak = PbActivity.this.bak();
                        if (!TextUtils.isEmpty(bak)) {
                            com.baidu.tbadk.core.util.av.CZ().c(PbActivity.this.getPageContext(), new String[]{bak});
                        }
                    }
                } else if (PbActivity.this.fHp) {
                    PbActivity.this.fHp = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.bah().bdd() != null && postData5.yS() != null && postData5.bvH() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bah().bde() != null) {
                                    PbActivity.this.bah().bde().bbq();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.fHy.getPbData().aYE());
                                mVar2.Q(PbActivity.this.fHy.getPbData().aYG());
                                mVar2.d(postData5);
                                PbActivity.this.bah().bdd().d(mVar2);
                                PbActivity.this.bah().bdd().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.yS().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fHM != null) {
                                    PbActivity.this.fHz.ky(PbActivity.this.fHM.KY());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d brY = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.aun();
            PbActivity.this.fHz.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ad.Oh() && PbActivity.this.aZO() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aZO().qd(postWriteCallBackData.getPostId());
                    PbActivity.this.fHZ = PbActivity.this.fHz.bdi();
                    if (PbActivity.this.fHy != null) {
                        PbActivity.this.fHy.cs(PbActivity.this.fHZ, PbActivity.this.fHz.bdj());
                    }
                }
                PbActivity.this.fHz.bdO();
                PbActivity.this.fHE.ben();
                if (PbActivity.this.fHM != null) {
                    PbActivity.this.fHz.ky(PbActivity.this.fHM.KY());
                }
                PbActivity.this.fHz.bdc();
                PbActivity.this.fHz.kA(true);
                PbActivity.this.fHy.bbV();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fHy.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHy.getPbData();
                            if (pbData != null && pbData.aYG() != null && pbData.aYG().yS() != null && (userId = pbData.aYG().yS().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ad.Oh() && PbActivity.this.fHy.bbO()) {
                                PbActivity.this.fHz.bdz();
                            }
                        } else if (!com.baidu.tbadk.o.ad.Oh() && PbActivity.this.fHy.bbO()) {
                            PbActivity.this.fHz.bdz();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fHz.n(PbActivity.this.fHy.getPbData());
                    }
                    if (PbActivity.this.fHy.bbK()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ab("tid", PbActivity.this.fHy.bbF()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fHM.Lf() || PbActivity.this.fHM.Lg()) {
                    PbActivity.this.fHM.a(false, postWriteCallBackData);
                }
                PbActivity.this.fHE.e(postWriteCallBackData);
            } else if (tVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fIx = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.fHE != null) {
                if (z) {
                    PbActivity.this.fHE.bem();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    if (PbActivity.this.fHz != null && PbActivity.this.fHz.bde() != null && PbActivity.this.fHz.bde().bbw() != null && PbActivity.this.fHz.bde().bbw().Lg()) {
                        PbActivity.this.fHz.bde().bbw().a(postWriteCallBackData);
                    }
                    PbActivity.this.fHE.f(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a fIy = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l hH;
            if (!z || fVar == null || fVar.aYQ() != null || com.baidu.tbadk.core.util.v.D(fVar.aYI()) >= 1) {
                PbActivity.this.fkD = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fHz.bdB();
                if (fVar == null || !fVar.aYM()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fHz.getView());
                } else if (PbActivity.this.fHz.bda() == null) {
                    PbActivity.this.fHQ = true;
                }
                PbActivity.this.fHz.aIB();
                if (PbActivity.this.isFullScreen || PbActivity.this.fHz.bei()) {
                    PbActivity.this.fHz.bdX();
                } else if (!PbActivity.this.fHz.bdU()) {
                    PbActivity.this.fHz.kA(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.fHG = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.fHz.WN();
                    PbActivity.this.fHz.kB(fVar.aYM());
                    if (fVar.aYG() != null && fVar.aYG().zM() != null) {
                        PbActivity.this.a(fVar.aYG().zM());
                    }
                    PbActivity.this.bae();
                    if (PbActivity.this.fHM != null) {
                        PbActivity.this.fHz.ky(PbActivity.this.fHM.KY());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aYI() != null && fVar.aYI().size() >= 1 && fVar.aYI().get(0) != null) {
                        PbActivity.this.fHy.qc(fVar.aYI().get(0).getId());
                    } else if (fVar.aYQ() != null) {
                        PbActivity.this.fHy.qc(fVar.aYQ().getId());
                    }
                    if (PbActivity.this.fHM != null) {
                        PbActivity.this.fHM.a(fVar.xG());
                        PbActivity.this.fHM.a(fVar.aYE(), fVar.getUserData());
                        PbActivity.this.fHM.a(PbActivity.this.fHy.bbP(), PbActivity.this.fHy.bbF(), PbActivity.this.fHy.bci());
                        if (fVar.aYG() != null) {
                            PbActivity.this.fHM.ch(fVar.aYG().Ac());
                        }
                    }
                    if (PbActivity.this.fhR != null) {
                        PbActivity.this.fhR.aH(fVar.vk());
                    }
                    if (fVar == null || fVar.aYT() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fHz.kz(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fHz.a(fVar, i2, i3, PbActivity.this.fHy.bbG(), i4, PbActivity.this.fHy.getIsFromMark());
                    PbActivity.this.fHz.d(fVar, PbActivity.this.fHy.bbG());
                    PbActivity.this.fHz.kw(PbActivity.this.fHy.getHostMode());
                    AntiData xG = fVar.xG();
                    if (xG != null) {
                        PbActivity.this.brO = xG.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.brO) && PbActivity.this.fHM != null && PbActivity.this.fHM.Ku() != null && (hH = PbActivity.this.fHM.Ku().hH(6)) != null && !TextUtils.isEmpty(PbActivity.this.brO)) {
                            ((View) hH).setOnClickListener(PbActivity.this.bsz);
                        }
                    }
                    if (PbActivity.this.fHI) {
                        PbActivity.this.fHI = false;
                        final int bar = PbActivity.this.bar();
                        if (fVar.aZd()) {
                            final int ao = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bar, ao);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bah().sY(bar);
                        }
                    }
                    if (PbActivity.this.fHJ) {
                        PbActivity.this.fHJ = false;
                        final int bar2 = PbActivity.this.bar();
                        final boolean z2 = bar2 != -1;
                        if (!z2) {
                            bar2 = PbActivity.this.bas();
                        }
                        if (PbActivity.this.bah() != null) {
                            if (fVar.aZd()) {
                                final int ao2 = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bar2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bar2, ao2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bar2 - 1, ao2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.bah().sY(bar2);
                            }
                        }
                    } else {
                        PbActivity.this.fHz.bdF();
                    }
                    PbActivity.this.fHy.a(fVar.aYE(), PbActivity.this.fIl);
                    PbActivity.this.fHy.a(PbActivity.this.fIm);
                } else if (str != null) {
                    if (!PbActivity.this.fHG && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fHy != null && PbActivity.this.fHy.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fHy.getAppealInfo().fDl)) {
                                    PbActivity.this.fHz.a(PbActivity.this.fHy.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fHz.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fHz.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.fHz.bdX();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fHy.bbF());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getForumId());
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
                        PbActivity.this.fHz.qg(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.fHz.qg("");
                    }
                    PbActivity.this.fHz.DL();
                }
                PbActivity.this.byw = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aZO().bbG() || PbActivity.this.aZO().getPbData().xY().xV() != 0 || PbActivity.this.aZO().bcb()) {
                    PbActivity.this.fHN = true;
                    return;
                }
                return;
            }
            PbActivity.this.fHy.sN(1);
            if (PbActivity.this.fHe != null) {
                PbActivity.this.fHe.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.fHz.n(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.r.NO().NP()) {
                com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, PbActivity.this.byo, PbActivity.this.createTime, PbActivity.this.byw, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.dmx : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.byo = 0L;
                if (mVar != null) {
                    mVar.NJ();
                }
            }
        }
    };
    private CustomMessageListener fIz = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.bam() == 1) {
                    PbActivity.this.bav();
                }
                PbActivity.this.ban();
            }
        }
    };
    private final a.InterfaceC0069a fIA = new a.InterfaceC0069a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0069a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fHz.bdB();
            if (z) {
                if (PbActivity.this.fhR != null) {
                    PbActivity.this.fhR.aH(z2);
                }
                PbActivity.this.fHy.kb(z2);
                if (PbActivity.this.fHy.vk()) {
                    PbActivity.this.bay();
                } else {
                    PbActivity.this.fHz.n(PbActivity.this.fHy.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fhR != null && PbActivity.this.fhR.vn() != null && PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aYG() != null && PbActivity.this.fHy.getPbData().aYG().yS() != null) {
                        MarkData vn = PbActivity.this.fhR.vn();
                        MetaData yS = PbActivity.this.fHy.getPbData().aYG().yS();
                        if (vn != null && yS != null) {
                            if (!com.baidu.tbadk.core.util.am.equals(TbadkCoreApplication.getCurrentAccount(), yS.getUserId()) && !yS.hadConcerned()) {
                                PbActivity.this.b(yS);
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
                if (PbActivity.this.fHz != null) {
                    PbActivity.this.fHz.bdO();
                    if (PbActivity.this.fHM != null && !PbActivity.this.fHz.bdg()) {
                        PbActivity.this.fHz.ky(PbActivity.this.fHM.KY());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fHz.bdf();
                    }
                }
                if (!PbActivity.this.fHm) {
                    PbActivity.this.fHm = true;
                    PbActivity.this.fHz.bdT();
                }
            }
            PbActivity.this.fHz.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fHe != null) {
                PbActivity.this.fHe.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fHn == null) {
                PbActivity.this.fHn = new com.baidu.tbadk.k.d();
                PbActivity.this.fHn.im(1001);
            }
            if (i == 0) {
                PbActivity.this.fHn.Nv();
            } else if (i == 1) {
                PbActivity.this.fHn.Nv();
            } else {
                PbActivity.this.fHn.Nv();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aYI;
            if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHz != null && PbActivity.this.fHz.bdv() != null) {
                PbActivity.this.fHz.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fHe != null) {
                    PbActivity.this.fHe.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fHy.bbX() && (aYI = PbActivity.this.fHy.getPbData().aYI()) != null && !aYI.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fHz.bdv().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.fHy.getPbData();
                    if (pbData != null) {
                        if (pbData.aYJ() != null && pbData.aYJ().hasData()) {
                            headerCount--;
                        }
                        if (pbData.aYK() != null && pbData.aYK().hasData()) {
                            headerCount--;
                        }
                        int size = aYI.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cUW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.cUS.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fHy.bbV();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dYd && bVar.fWT > 0 && bVar.haA != 0 && bVar.fWT != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.fWT == 1002 && !bVar.dYd) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fHz.a(1, dVar.aos, dVar.haC, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cUS.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fHz.a(PbActivity.this.cUS.getLoadDataMode(), gVar.aos, gVar.haC, false);
                        PbActivity.this.fHz.am(gVar.haF);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fHz.a(PbActivity.this.cUS.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fIB = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
    };
    private final j.b bSY = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
        @Override // com.baidu.tbadk.core.view.j.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.baF()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fHy.ka(true)) {
                PbActivity.this.fHz.bdC();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fID = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fIC && PbActivity.this.baF()) {
                PbActivity.this.baH();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fHy.jZ(false)) {
                    PbActivity.this.fHz.bdA();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fHy.getPbData() != null) {
                    PbActivity.this.fHz.bdS();
                }
                PbActivity.this.fIC = true;
            }
        }
    };
    private int fIE = 0;
    private final TbRichTextView.h bJF = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fHz.b((TbRichText) view.getTag());
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
                    PbActivity.this.fHw = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fJt) {
                    TbRichText ay = PbActivity.this.ay(str, i);
                    if (ay != null && PbActivity.this.fIE >= 0 && PbActivity.this.fIE < ay.QB().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.g.b(ay.QB().get(PbActivity.this.fIE));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fJq.size()) {
                                break;
                            } else if (!cVar.fJq.get(i3).equals(b2)) {
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
                            concurrentHashMap.put(str2, cVar.fJr.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fJs, cVar.lastId, PbActivity.this.fHy.bbT(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.f(cVar.fJq, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.E(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fJr.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fJs, cVar.fJq.get(0), PbActivity.this.fHy.bbT(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fIF = false;
    PostData fIG = null;
    private final b.InterfaceC0073b fIH = new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fIG != null) {
                if (i == 0) {
                    PbActivity.this.fIG.ck(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fIG = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fIG);
                }
            }
        }
    };
    private final b.InterfaceC0073b fII = new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fHW != null && !TextUtils.isEmpty(PbActivity.this.fHX)) {
                if (i == 0) {
                    if (PbActivity.this.fHY == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.fHX));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fHX;
                        aVar.pkgId = PbActivity.this.fHY.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fHY.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.fHV == null) {
                        PbActivity.this.fHV = new aw(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.fHV.i(PbActivity.this.fHX, PbActivity.this.fHW.sl());
                }
                PbActivity.this.fHW = null;
                PbActivity.this.fHX = null;
            }
        }
    };
    private final View.OnLongClickListener bjX = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.fHW = ((TbImageView) view).getBdImage();
                PbActivity.this.fHX = ((TbImageView) view).getUrl();
                if (PbActivity.this.fHW != null && !TextUtils.isEmpty(PbActivity.this.fHX)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fHY = null;
                    } else {
                        PbActivity.this.fHY = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fHz.a(PbActivity.this.fII, PbActivity.this.fHW.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.fHW = ((GifView) view).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                        PbActivity.this.fHX = ((GifView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fHY = null;
                    } else {
                        PbActivity.this.fHY = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fHz.a(PbActivity.this.fII, PbActivity.this.fHW.isGif());
                }
            } else if (view instanceof com.baidu.tbadk.widget.d) {
                if (((com.baidu.tbadk.widget.d) view).getBdImage() != null) {
                    PbActivity.this.fHW = ((com.baidu.tbadk.widget.d) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.d) view).getBdImage().getUrl())) {
                        PbActivity.this.fHX = ((com.baidu.tbadk.widget.d) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fHY = null;
                    } else {
                        PbActivity.this.fHY = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fHz.a(PbActivity.this.fII, PbActivity.this.fHW.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fIG = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.fIG != null && PbActivity.this.fhR != null) {
                        PbActivity.this.fHz.a(PbActivity.this.fIH, PbActivity.this.fhR.vk() && PbActivity.this.fIG.getId() != null && PbActivity.this.fIG.getId().equals(PbActivity.this.fHy.zc()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dzq = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bp(boolean z) {
            if (!PbActivity.this.fHg && z && !PbActivity.this.fHy.bbN()) {
                PbActivity.this.baB();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener bBl = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).asC()) {
                        break;
                    }
                }
            }
            PbActivity.this.ckL.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0108a ckM = new a.InterfaceC0108a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        final int cGb;

        {
            this.cGb = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void aY(int i, int i2) {
            if (Z(i2) && PbActivity.this.fHz != null && PbActivity.this.fHe != null) {
                PbActivity.this.fHz.bdY();
                PbActivity.this.fHe.fM(false);
                PbActivity.this.fHe.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void aZ(int i, int i2) {
            if (Z(i2) && PbActivity.this.fHz != null && PbActivity.this.fHe != null) {
                PbActivity.this.fHe.fM(true);
                if (Math.abs(i2) > this.cGb) {
                    PbActivity.this.fHe.hideFloatingView();
                }
                if (PbActivity.this.baF()) {
                    PbActivity.this.fHz.bdr();
                    PbActivity.this.fHz.bds();
                }
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void ba(int i, int i2) {
        }

        private boolean Z(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a fIJ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.e.b.a
        public void fi(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aZE();
            } else {
                com.baidu.tieba.pb.a.b.aZD();
            }
        }
    };
    private String fIK = null;
    private final o.a fIL = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fIK = str2;
                PbActivity.this.fHz.qh(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fIM = -1;
    private int fIN = -1;
    private CustomMessageListener fIQ = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.aIz == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0071a) {
                    if (aVar.aIA != null && !aVar.aIA.hasError() && aVar.aIA.getError() == 0) {
                        if (PbActivity.this.fHz != null) {
                            PbActivity.this.fHz.y(((a.C0071a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.baR();
                        }
                    } else if (z) {
                        if (aVar.aIA != null && aVar.aIA.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aIA.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.aIA != null && !aVar.aIA.hasError() && aVar.aIA.getError() == 0) {
                        if (PbActivity.this.fHz != null && PbActivity.this.fHz != null) {
                            PbActivity.this.fHz.y(((a.C0071a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.aIA != null && aVar.aIA.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aIA.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.aIA == null || aVar.aIA.hasError() || aVar.aIA.getError() != 0) {
                        if (z) {
                            if (aVar.aIA != null && aVar.aIA.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.aIA.getErrorString());
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
    private final CustomMessageListener dCi = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ab("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.av.CZ().c(PbActivity.this.getPageContext(), new String[]{str});
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
        public ArrayList<String> fJq;
        public ConcurrentHashMap<String, ImageUrlData> fJr;
        public boolean fJt;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fJs = false;
        public boolean fJu = false;
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

    public com.baidu.tbadk.editortools.pb.d bac() {
        return this.fHM;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        if (mVar.aZt() != null) {
            String id = mVar.aZt().getId();
            ArrayList<PostData> aYI = this.fHy.getPbData().aYI();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aYI.size()) {
                    break;
                }
                PostData postData = aYI.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aZx = mVar.aZx();
                    postData.vK(mVar.getTotalCount());
                    if (postData.bvE() != null && aZx != null) {
                        Iterator<PostData> it = aZx.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.yS() != null && (metaData = postData.getUserMap().get(next.yS().getUserId())) != null) {
                                next.a(metaData);
                                next.mz(true);
                                next.b(getPageContext(), this.fHy.qb(metaData.getUserId()));
                            }
                        }
                        postData.bvE().clear();
                        postData.bvE().addAll(aZx);
                    }
                    if (postData.bvz() != null) {
                        postData.bvA();
                    }
                }
            }
            if (!this.fHy.getIsFromMark()) {
                this.fHz.n(this.fHy.getPbData());
            }
            c(mVar);
        }
    }

    public void bad() {
        com.baidu.tieba.pb.data.f pbData;
        bd aYG;
        if (!this.fIo) {
            if (!com.baidu.adp.lib.util.l.oZ()) {
                showToast(d.j.no_network_guide);
            } else if (this.fIr) {
                this.fIo = true;
                if (this.fHy != null && (pbData = this.fHy.getPbData()) != null && (aYG = pbData.aYG()) != null) {
                    int isLike = aYG.yH() == null ? 0 : aYG.yH().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ab("tid", aYG.getId()));
                    }
                    if (this.fIp != null) {
                        this.fIp.a(aYG.zj(), aYG.getId(), isLike, "pb");
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
                                    PbActivity.this.fHz.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fHT);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fHT);
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
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fHT);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fHT);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).AD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC(int i) {
        bd aYG;
        String str;
        String H;
        if (this.fHy != null && this.fHy.getPbData() != null && (aYG = this.fHy.getPbData().aYG()) != null) {
            if (i == 1) {
                PraiseData yH = aYG.yH();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yH == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aYG.a(praiseData);
                    } else {
                        aYG.yH().getUser().add(0, metaData);
                        aYG.yH().setNum(aYG.yH().getNum() + 1);
                        aYG.yH().setIsLike(i);
                    }
                }
                if (aYG.yH() != null) {
                    if (aYG.yH().getNum() < 1) {
                        H = getResources().getString(d.j.zan);
                    } else {
                        H = com.baidu.tbadk.core.util.am.H(aYG.yH().getNum());
                    }
                    this.fHz.S(H, true);
                }
            } else if (aYG.yH() != null) {
                aYG.yH().setIsLike(i);
                aYG.yH().setNum(aYG.yH().getNum() - 1);
                ArrayList<MetaData> user = aYG.yH().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aYG.yH().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aYG.yH().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = aYG.yH().getNum() + "";
                }
                this.fHz.S(str, false);
            }
            if (this.fHy.bbG()) {
                this.fHz.bdv().notifyDataSetChanged();
            } else {
                this.fHz.o(this.fHy.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fHy.x(bundle);
        if (this.dBh != null) {
            this.dBh.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fHM.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fHR = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.dmx = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fHs = intent.getStringExtra("from");
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fHs)) {
                this.fHf = true;
            }
            this.fIM = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fIN = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fIO = intent.getStringExtra("key_manga_title");
            this.fHI = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fHJ = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (baF()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.fIa = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.dmx = System.currentTimeMillis();
        }
        this.fHl = System.currentTimeMillis();
        this.byo = this.fHl - this.dmx;
        super.onCreate(bundle);
        this.fHi = 0;
        w(bundle);
        if (this.fHy != null && this.fHy.getPbData() != null) {
            this.fHy.getPbData().pU(this.source);
        }
        initUI();
        if (intent != null && this.fHz != null) {
            this.fHz.fQa = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fHU == null) {
                    this.fHU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fHz.qj("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fHU, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fHy != null && this.fHy.getPbData() != null) {
                this.fHy.qe(stringExtra);
            }
        }
        this.dBh = new VoiceManager();
        this.dBh.onCreate(getPageContext());
        initData(bundle);
        this.fHL = new com.baidu.tbadk.editortools.pb.g();
        bae();
        this.fHM = (com.baidu.tbadk.editortools.pb.d) this.fHL.bh(getActivity());
        this.fHM.b(this);
        this.fHM.a(this.brY);
        this.fHM.a(this.brR);
        this.fHM.a(this, bundle);
        this.fHM.Ku().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.fHM.Ku().ca(true);
        jJ(true);
        this.fHz.setEditorTools(this.fHM.Ku());
        this.fHM.a(this.fHy.bbP(), this.fHy.bbF(), this.fHy.bci());
        registerListener(this.fIg);
        if (!this.fHy.bbM()) {
            this.fHM.ge(this.fHy.bbF());
        }
        if (this.fHy.bcj()) {
            this.fHM.gc(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fHM.gc(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.fHl;
        registerListener(this.fIf);
        registerListener(this.fIh);
        registerListener(this.fIi);
        registerListener(this.dCf);
        registerListener(this.fIw);
        registerListener(this.fIe);
        this.fHK = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gXG);
        this.fHK.bvi();
        registerListener(this.fIk);
        registerListener(this.mAttentionListener);
        if (this.fHy != null) {
            this.fHy.bbZ();
        }
        registerListener(this.fIz);
        registerListener(this.fIQ);
        registerListener(this.dCo);
        if (this.fHz != null && this.fHz.bec() != null && this.fHz.bed() != null) {
            this.fHe = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.fHz.bec(), this.fHz.bed(), this.fHz.bdm());
            this.fHe.a(this.fIs);
        }
        if (this.fHd && this.fHz != null && this.fHz.bed() != null) {
            this.fHz.bed().setVisibility(8);
        }
        this.fHS = new com.baidu.tbadk.core.view.e();
        this.fHS.aZo = 1000L;
        registerListener(this.fIv);
        registerListener(this.fIt);
        registerListener(this.fIu);
        this.fHT = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fHT;
        userMuteAddAndDelCustomMessage.setTag(this.fHT);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.fHT;
        userMuteCheckCustomMessage.setTag(this.fHT);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fHy.bcg().a(this.cwj);
        if ("from_tieba_kuang".equals(this.fHs)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 2).ab("tid", this.fHy.bbF()));
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
        this.fHE = new au();
        if (this.fHM.KS() != null) {
            this.fHE.g(this.fHM.KS().getInputView());
        }
        this.fHM.a(this.brS);
        this.dNI = new ShareSuccessReplyToServerModel();
        a(this.fIc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        if (this.fHL != null && this.fHy != null) {
            this.fHL.setForumName(this.fHy.bbE());
            if (this.fHy.getPbData() != null && this.fHy.getPbData().aYE() != null) {
                this.fHL.setForumId(this.fHy.getPbData().aYE().getId());
            }
            this.fHL.setFrom("pb");
            this.fHL.a(this.fHy);
        }
    }

    public String baf() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b bag() {
        return this.fHe;
    }

    private void jJ(boolean z) {
        this.fHM.ce(z);
        this.fHM.cf(z);
        this.fHM.cg(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aZd() && !z && this.fHz != null && this.fHz.getView() != null) {
            this.fHz.getView().setSystemUiVisibility(4);
        }
        this.fHO = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dBh != null) {
            this.dBh.onStart(getPageContext());
        }
    }

    public as bah() {
        return this.fHz;
    }

    public PbModel aZO() {
        return this.fHy;
    }

    public void pV(String str) {
        if (this.fHy != null && !StringUtils.isNull(str) && this.fHz != null) {
            this.fHz.kD(true);
            this.fHy.pV(str);
            this.fHr = true;
            this.fHz.bdO();
            this.fHz.bdX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fHg = false;
        } else {
            this.fHg = true;
        }
        super.onPause();
        if (this.fHz.bda() != null && this.fHz.bda().aZZ() != null) {
            this.fHz.bda().aZZ().onPause();
        }
        BdListView listView = getListView();
        this.fHi = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fHi == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dBh != null) {
            this.dBh.onPause(getPageContext());
        }
        if (this.fHz != null) {
            this.fHz.onPause();
        }
        if (!this.fHy.bbM()) {
            this.fHM.gd(this.fHy.bbF());
        }
        if (this.fHy != null) {
            this.fHy.bca();
        }
        MessageManager.getInstance().unRegisterListener(this.esv);
        aCl();
        MessageManager.getInstance().unRegisterListener(this.fIt);
        MessageManager.getInstance().unRegisterListener(this.fIu);
        MessageManager.getInstance().unRegisterListener(this.fIv);
        MessageManager.getInstance().unRegisterListener(this.dCi);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean bai() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.fHy.getPbData(), this.fHy.bbG(), this.fHy.getRequestType());
        return (a2 == null || a2.yS() == null || a2.yS().getGodUserData() == null || a2.yS().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fHg = false;
        super.onResume();
        if (this.fHu) {
            this.fHu = false;
            baL();
        }
        if (this.fHz.bda() != null && this.fHz.bda().aZZ() != null) {
            this.fHz.bda().aZZ().onResume();
        }
        if (bai()) {
            this.fHo = System.currentTimeMillis();
        } else {
            this.fHo = -1L;
        }
        if (this.fHz != null && this.fHz.getView() != null) {
            if (!this.fkD) {
                baC();
            } else {
                hideLoadingView(this.fHz.getView());
            }
            this.fHz.onResume();
        }
        if (this.fHi == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fHz != null) {
            noNetworkView = this.fHz.bdb();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.oI()) {
            noNetworkView.bo(false);
        }
        if (this.dBh != null) {
            this.dBh.onResume(getPageContext());
        }
        registerListener(this.esv);
        this.fHH = false;
        baK();
        registerListener(this.fIt);
        registerListener(this.fIu);
        registerListener(this.fIv);
        registerListener(this.dCi);
        if (this.dBN) {
            baB();
            this.dBN = false;
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
        this.fHz.kr(z);
        if (this.fHF != null) {
            this.fHF.kd(z);
        }
        if (z && this.fHH) {
            this.fHz.bdA();
            this.fHy.jZ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fHo > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ab("obj_duration", (System.currentTimeMillis() - this.fHo) + ""));
            this.fHo = 0L;
        }
        if (bah().bde() != null) {
            bah().bde().onStop();
        }
        if (this.fHz.fQh != null && !this.fHz.fQh.alr()) {
            this.fHz.fQh.aNj();
        }
        if (this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aYE() != null && this.fHy.getPbData().aYG() != null) {
            com.baidu.tbadk.distribute.a.Ke().a(getPageContext().getPageActivity(), "pb", this.fHy.getPbData().aYE().getId(), com.baidu.adp.lib.g.b.c(this.fHy.getPbData().aYG().getId(), 0L));
        }
        if (this.dBh != null) {
            this.dBh.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.fHm && this.fHz != null) {
            this.fHm = true;
            this.fHz.bdT();
            a(false, (PostData) null);
        }
        if (this.fHy != null) {
            this.fHy.cancelLoadData();
            this.fHy.destory();
            if (this.fHy.bcf() != null) {
                this.fHy.bcf().onDestroy();
            }
        }
        if (this.fHM != null) {
            this.fHM.onDestroy();
        }
        if (this.cUS != null) {
            this.cUS.cancelLoadData();
        }
        if (this.fHz != null) {
            this.fHz.onDestroy();
            if (this.fHz.fQh != null) {
                this.fHz.fQh.aNj();
            }
        }
        if (this.fHn != null) {
            this.fHn.onDestroy();
        }
        if (this.fHe != null) {
            this.fHe.OD();
        }
        super.onDestroy();
        if (this.dBh != null) {
            this.dBh.onDestory(getPageContext());
        }
        this.fHz.bdO();
        MessageManager.getInstance().unRegisterListener(this.fIt);
        MessageManager.getInstance().unRegisterListener(this.fIu);
        MessageManager.getInstance().unRegisterListener(this.fIv);
        MessageManager.getInstance().unRegisterListener(this.fHT);
        MessageManager.getInstance().unRegisterListener(this.fIw);
        MessageManager.getInstance().unRegisterListener(this.dCo);
        this.fHR = null;
        this.fHS = null;
        com.baidu.tieba.recapp.e.a.bnw().bny();
        if (this.fHU != null) {
            getSafeHandler().removeCallbacks(this.fHU);
        }
        if (this.fHv != null) {
            this.fHv.cancelLoadData();
        }
        if (this.fHz != null && this.fHz.fQh != null) {
            this.fHz.fQh.beJ();
        }
        if (this.dNI != null) {
            this.dNI.cancelLoadData();
        }
        this.fHE.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        h bdv;
        ArrayList<PostData> bbh;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.EX() && this.fHz != null && (bdv = this.fHz.bdv()) != null && (bbh = bdv.bbh()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bbh.iterator();
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
                        bVar.bAU = id;
                        bVar.cWG = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aNS == 1 && !TextUtils.isEmpty(id)) {
                    next.aNS = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bAU = id;
                    bVar2.cWG = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fHy == null || this.fHy.getPbData() == null || this.fHy.getPbData().aYE() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fHy.getPbData().aYE().getFirst_class();
                    str2 = this.fHy.getPbData().aYE().getSecond_class();
                    str = this.fHy.getPbData().aYE().getId();
                    str4 = this.fHy.bbF();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Fa());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fHz.onChangeSkinType(i);
            if (this.fHM != null && this.fHM.Ku() != null) {
                this.fHM.Ku().onChangeSkinType(i);
            }
            if (this.fHz.bdb() != null) {
                this.fHz.bdb().onChangeSkinType(getPageContext(), i);
            }
            this.fHE.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fHz = new as(this, this.dCL, this.bJG);
        this.ckL = new com.baidu.tieba.e.b(getActivity());
        this.ckL.a(this.fIJ);
        this.ckL.a(this.ckM);
        this.fHz.setOnScrollListener(this.mOnScrollListener);
        this.fHz.d(this.fID);
        this.fHz.a(this.bSY);
        this.fHz.jD(com.baidu.tbadk.core.i.wA().wG());
        this.fHz.setOnImageClickListener(this.bJF);
        this.fHz.a(this.bjX);
        this.fHz.h(this.dzq);
        this.fHz.a(this.fIB);
        this.fHz.kr(this.mIsLogin);
        if (getIntent() != null) {
            this.fHz.setIsInterviewLive(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cq(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gYi == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.i.wA().wG()) {
                    return false;
                }
                return pY(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.fHz != null) {
            if (z && (!this.fkD || this.fHQ)) {
                baC();
            } else {
                hideLoadingView(this.fHz.getView());
            }
            this.fHQ = false;
            if (z && this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aZd() && this.fHz.getView() != null) {
                this.fHz.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void baj() {
        if (this.fHj == null) {
            this.fHj = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fHj.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fGM = PbActivity.this.fGM.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fGM);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fHy.bbF(), PbActivity.this.fGM, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fGM = PbActivity.this.fGM.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fGM);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fHy.bbF(), PbActivity.this.fGM, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fGM = PbActivity.this.fGM.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fGM);
                        bVar.dismiss();
                    }
                }
            }).ff(b.a.aQk).fg(17).d(getPageContext());
        }
    }

    private void w(Bundle bundle) {
        this.fHy = new PbModel(this);
        this.fHy.a(this.fIy);
        if (this.fHy.bcd() != null) {
            this.fHy.bcd().a(this.fIL);
        }
        if (this.fHy.bcc() != null) {
            this.fHy.bcc().a(this.fIj);
        }
        if (this.fHy.bcf() != null) {
            this.fHy.bcf().b(this.fId);
        }
        if (bundle != null) {
            this.fHy.initWithBundle(bundle);
        } else {
            this.fHy.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fHy.kc(true);
        }
        aj.bcN().R(this.fHy.bbD(), this.fHy.getIsFromMark());
        if (StringUtils.isNull(this.fHy.bbF())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fHs)) {
            this.fHy.sU(6);
        }
        this.fHy.MO();
    }

    private void initData(Bundle bundle) {
        this.fhR = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fhR != null) {
            this.fhR.a(this.fIA);
        }
        this.cUS = new ForumManageModel(this);
        this.cUS.setLoadDataCallBack(this.cUW);
        this.bdB = new com.baidu.tbadk.coreExtra.model.a(null);
        this.fHz.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void ak(Object obj) {
                if (!com.baidu.adp.lib.util.j.oI()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fHy.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fHy.getPbData().aYE().getId(), PbActivity.this.fHy.getPbData().aYE().getName(), PbActivity.this.fHy.getPbData().aYG().getId(), valueOf, str, str2)));
            }
        });
        this.fIp.setUniqueId(getUniqueId());
        this.fIp.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fHz.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fHT;
        userMuteCheckCustomMessage.setTag(this.fHT);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bak() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.fHy != null && (pbData = this.fHy.getPbData()) != null) {
            return pbData.aYR().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aYG() != null) {
            if (fVar.aYG().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aYG().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aYG().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData cr(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bvW()) {
                postData.cP(postData.bvV() - 1);
            } else {
                postData.cP(postData.bvV() + 1);
            }
            postData.mA(!postData.bvW());
            ((PbFloorAgreeView) view).a(postData.bvW(), postData.bvV(), true);
            final int i = postData.bvW() ? 0 : 1;
            this.fHy.bce().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
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

    public com.baidu.tbadk.core.util.ak bal() {
        return new com.baidu.tbadk.core.util.ak("c12003").ab("tid", this.fHy.fMn).s("obj_type", 0).ab(ImageViewerConfig.FORUM_ID, this.fHy.getForumId()).s("obj_param1", this.fHy.getPbData().aYG().getThreadType() == 40 ? 2 : 1);
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
                        PbActivity.this.bah().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bah().bde() != null) {
                        PbActivity.this.fHM.Ku().setVisibility(8);
                        PbActivity.this.bah().bde().bG(str, str2);
                        com.baidu.tbadk.editortools.pb.h bbw = PbActivity.this.bah().bde().bbw();
                        if (bbw != null && PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null) {
                            bbw.a(PbActivity.this.fHy.getPbData().xG());
                        }
                        if (PbActivity.this.fHE.beq() == null && PbActivity.this.bah().bde().bbw().Lt() != null) {
                            PbActivity.this.bah().bde().bbw().Lt().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fHE != null && PbActivity.this.fHE.bep() != null) {
                                        if (!PbActivity.this.fHE.bep().bEP()) {
                                            PbActivity.this.fHE.kF(false);
                                        }
                                        PbActivity.this.fHE.bep().nr(false);
                                    }
                                }
                            });
                            PbActivity.this.fHE.h(PbActivity.this.bah().bde().bbw().Lt().getInputView());
                            PbActivity.this.bah().bde().bbw().a(PbActivity.this.fHP);
                        }
                    }
                    PbActivity.this.bah().bdX();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.fHy != null && this.fHy.getPbData() != null && postData.bvH() > 1) {
            String bbF = this.fHy.bbF();
            String id = postData.getId();
            int aYS = this.fHy.getPbData() != null ? this.fHy.getPbData().aYS() : 0;
            c pZ = pZ(id);
            if (pZ != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bbF, id, "pb", true, null, false, null, aYS, postData.bfv(), this.fHy.getPbData().xG(), false, postData.yS() != null ? postData.yS().getIconInfo() : null).addBigImageData(pZ.fJq, pZ.fJr, pZ.fJs, pZ.index);
                addBigImageData.setKeyPageStartFrom(this.fHy.bcl());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        ap apVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.oZ()) {
                showToast(d.j.no_network_guide);
            } else if (aZO() != null && aZO().getPbData() != null && aZO().getPbData().aZc() != null) {
                com.baidu.tieba.pb.data.l aZc = aZO().getPbData().aZc();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof ap)) {
                    apVar = null;
                } else {
                    apVar = (ap) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aZc != null) {
                    int i3 = -1;
                    if (z) {
                        aZc.sx(i);
                    } else if (aZc.aZn()) {
                        aZc.aZq();
                        i3 = 1;
                    } else {
                        aZc.sz(i);
                        i3 = 0;
                    }
                    aZc.sy(i2);
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
                    if (this.fHy != null && this.fHy.bce() != null) {
                        String str = "";
                        if (this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null) {
                            str = this.fHy.getPbData().aYG().zj();
                        }
                        if (this.fHy.getPbData() != null) {
                            this.fHy.getPbData().a(aZc);
                        }
                        if (z) {
                            this.fHy.bce().a(str, 3, i, this.fHy.getForumId(), aVar);
                        } else {
                            this.fHy.bce().a(str, i3, 3, i, this.fHy.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.fEf = i3;
                            kVar.fEg = aZc;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (apVar != null) {
                        apVar.b(aZc);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bam() {
        if (this.fHy.getPbData() == null || this.fHy.getPbData().aYG() == null) {
            return -1;
        }
        return this.fHy.getPbData().aYG().zw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ban() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.qx(this.fHy.getForumId()) && this.fHy.getPbData() != null && this.fHy.getPbData().aYE() != null) {
            if (this.fHy.getPbData().aYE().isLike() == 1) {
                baD();
                this.fHy.bch().bJ(this.fHy.getForumId(), this.fHy.bbF());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jK(boolean z) {
        if (this.fHy == null || this.fHy.getPbData() == null) {
            return false;
        }
        return ((this.fHy.getPbData().aYS() != 0) || this.fHy.getPbData().aYG() == null || this.fHy.getPbData().aYG().yS() == null || TextUtils.equals(this.fHy.getPbData().aYG().yS().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bao() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.o.q.Oi()) {
            return "";
        }
        PostData aYN = aYN();
        if (this.fHy == null || (pbData = this.fHy.getPbData()) == null || pbData.getUserData() == null || pbData.aYG() == null || aYN == null || aYN.yS() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aYN.yS().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aYG().yC() == 0) {
            return "";
        }
        if (pbData.aYG().yC() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean jL(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fHy == null || this.fHy.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.fHy.getPbData();
        if (pbData.aYS() == 0) {
            List<ay> aZa = pbData.aZa();
            if (com.baidu.tbadk.core.util.v.D(aZa) > 0) {
                for (ay ayVar : aZa) {
                    if (ayVar != null && (tVar = ayVar.aMP) != null && tVar.aKW && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
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

    private boolean jM(boolean z) {
        return (z || this.fHy == null || this.fHy.getPbData() == null || this.fHy.getPbData().aYS() == 0) ? false : true;
    }

    public void bap() {
        if (this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null && this.fHy.getPbData().aYG().yS() != null) {
            if (this.fHz != null) {
                this.fHz.bdc();
            }
            bd aYG = this.fHy.getPbData().aYG();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aYG.yS().getUserId());
            ab abVar = new ab();
            int aYS = this.fHy.getPbData().aYS();
            if (aYS == 1) {
                abVar.fOp = true;
                abVar.fOo = true;
                abVar.fOw = aYG.yN() == 1;
                abVar.fOv = aYG.yO() == 1;
            } else {
                abVar.fOp = false;
                abVar.fOo = false;
            }
            if (aYS == 1002 && !equals) {
                abVar.fOA = true;
            }
            abVar.fOl = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            abVar.fOq = jL(equals);
            abVar.fOr = baq();
            abVar.fOs = jM(equals);
            abVar.fOm = this.fHy.bbG();
            abVar.fOn = true;
            abVar.fEv = this.fhR != null && this.fhR.vk();
            abVar.fOk = jK(equals);
            abVar.fOy = bao();
            abVar.fOj = equals && this.fHz.bdI();
            abVar.fOt = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fOu = true;
            abVar.isHostOnly = this.fHy.getHostMode();
            abVar.fOx = true;
            if (aYG.zk() == null) {
                abVar.fOz = true;
            } else {
                abVar.fOz = false;
            }
            this.fHz.fQh.a(abVar);
        }
    }

    private boolean baq() {
        if (this.fHy != null && this.fHy.bbG()) {
            return this.fHy.aCQ() == null || this.fHy.aCQ().xV() != 0;
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

    public int bar() {
        if (bah() == null || bah().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bah().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) iVar).mType == com.baidu.tieba.pb.data.j.fEb) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bas() {
        if (bah() == null || bah().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bah().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof PostData) && iVar.getType() == PostData.gYg) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        baB();
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
                    PbActivity.this.bdB.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fHy.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).AA();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fHz.bdB();
        this.fHy.kb(z);
        if (this.fhR != null) {
            this.fhR.aH(z);
            if (markData != null) {
                this.fhR.a(markData);
            }
        }
        if (this.fHy.vk()) {
            bay();
        } else {
            this.fHz.n(this.fHy.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sC(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW(String str) {
        if (!StringUtils.isNull(str) && this.fHy != null) {
            String bbF = this.fHy.bbF();
            String id = this.fHy.getPbData().aYE().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + bbF + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fHy.bbM()) {
                    antiData.setBlock_forum_name(this.fHy.getPbData().aYE().getName());
                    antiData.setBlock_forum_id(this.fHy.getPbData().aYE().getId());
                    antiData.setUser_name(this.fHy.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fHy.getPbData().getUserData().getUserId());
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", ap.a.aVW));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", ap.a.aVW));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", ap.a.aVW));
            }
        } else if (i == 230277) {
            gk(str);
        } else {
            this.fHz.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.fHz.a(0, bVar.aos, bVar.haC, z);
            if (bVar.aos) {
                if (bVar.haA == 1) {
                    ArrayList<PostData> aYI = this.fHy.getPbData().aYI();
                    int size = aYI.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aYI.get(i).getId())) {
                            i++;
                        } else {
                            aYI.remove(i);
                            break;
                        }
                    }
                    this.fHz.n(this.fHy.getPbData());
                } else if (bVar.haA == 0) {
                    bat();
                } else if (bVar.haA == 2) {
                    ArrayList<PostData> aYI2 = this.fHy.getPbData().aYI();
                    int size2 = aYI2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aYI2.get(i2).bvE().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aYI2.get(i2).bvE().get(i3).getId())) {
                                i3++;
                            } else {
                                aYI2.get(i2).bvE().remove(i3);
                                aYI2.get(i2).bvG();
                                z2 = true;
                                break;
                            }
                        }
                        aYI2.get(i2).sx(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fHz.n(this.fHy.getPbData());
                    }
                    a(bVar, this.fHz);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fHz.a(this.cUS.getLoadDataMode(), gVar.aos, gVar.haC, false);
            if (gVar.aos) {
                this.fHB = true;
                if (i == 2 || i == 3) {
                    this.fHC = true;
                    this.fHD = false;
                } else if (i == 4 || i == 5) {
                    this.fHC = false;
                    this.fHD = true;
                }
                if (i == 2) {
                    this.fHy.getPbData().aYG().eS(1);
                    this.fHy.setIsGood(1);
                } else if (i == 3) {
                    this.fHy.getPbData().aYG().eS(0);
                    this.fHy.setIsGood(0);
                } else if (i == 4) {
                    this.fHy.getPbData().aYG().eR(1);
                    this.fHy.lR(1);
                } else if (i == 5) {
                    this.fHy.getPbData().aYG().eR(0);
                    this.fHy.lR(0);
                }
                this.fHz.c(this.fHy.getPbData(), this.fHy.bbG());
                if (this.fHy.getPbData().aYS() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void bat() {
        if (this.fHy.bbH() || this.fHy.bbJ()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fHy.bbF());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.fHy.bbF()));
        if (baz()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bau() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aYP;
        boolean z = true;
        if (this.fHz != null) {
            this.fHz.bdO();
        }
        if (this.fHy != null && this.fHy.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fHy.getPbData().aYG().getId();
            if (this.fHy.isShareThread() && this.fHy.getPbData().aYG().aOZ != null) {
                historyMessage.threadName = this.fHy.getPbData().aYG().aOZ.showText;
            } else {
                historyMessage.threadName = this.fHy.getPbData().aYG().getTitle();
            }
            if (this.fHy.isShareThread() && !baT()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fHy.getPbData().aYE().getName();
            }
            ArrayList<PostData> aYI = this.fHy.getPbData().aYI();
            int bdD = this.fHz != null ? this.fHz.bdD() : 0;
            if (aYI != null && bdD >= 0 && bdD < aYI.size()) {
                historyMessage.postID = aYI.get(bdD).getId();
            }
            historyMessage.isHostOnly = this.fHy.getHostMode();
            historyMessage.isSquence = this.fHy.bbG();
            historyMessage.isShareThread = this.fHy.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fHM != null) {
            this.fHM.onDestroy();
        }
        if (this.fHh && bah() != null) {
            bah().bej();
        }
        if (this.fHy != null && (this.fHy.bbH() || this.fHy.bbJ())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fHy.bbF());
            if (this.fHB) {
                if (this.fHD) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fHy.bbL());
                }
                if (this.fHC) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fHy.getIsGood());
                }
            }
            if (this.fHy.getPbData() != null && System.currentTimeMillis() - this.fHl >= 40000 && (aYP = this.fHy.getPbData().aYP()) != null && !com.baidu.tbadk.core.util.v.E(aYP.getDataList())) {
                intent.putExtra("guess_like_data", aYP);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fIa);
            }
            setResult(-1, intent);
        }
        if (baz()) {
            if (this.fHy != null && this.fHz != null && this.fHz.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.fHy.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aYM() && !this.fHr) {
                        aj bcN = aj.bcN();
                        com.baidu.tieba.pb.data.f pbData2 = this.fHy.getPbData();
                        Parcelable onSaveInstanceState = this.fHz.getListView().onSaveInstanceState();
                        boolean bbG = this.fHy.bbG();
                        boolean hostMode = this.fHy.getHostMode();
                        if (this.fHz.bdm() == null || this.fHz.bdm().getVisibility() != 0) {
                            z = false;
                        }
                        bcN.a(pbData2, onSaveInstanceState, bbG, hostMode, z);
                        if (this.fHZ >= 0 || this.fHy.bcn() != null) {
                            aj.bcN().j(this.fHy.bcn());
                            aj.bcN().i(this.fHy.bco());
                            aj.bcN().sW(this.fHy.bcp());
                        }
                    }
                }
            } else {
                aj.bcN().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fHz == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fHz.sZ(i)) {
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
            this.fHz.bdc();
            this.fHz.bde().bbq();
            this.fHz.kA(false);
        }
        this.fHz.bdf();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fHM.resetData();
                        this.fHM.b(writeData);
                        this.fHM.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.r hJ = this.fHM.Ku().hJ(6);
                        if (hJ != null && hJ.bqa != null) {
                            hJ.bqa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fHM.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fHz.bde() != null && this.fHz.bde().bbu() != null) {
                            com.baidu.tbadk.editortools.pb.h bbu = this.fHz.bde().bbu();
                            bbu.b(writeData);
                            bbu.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.r hJ2 = bbu.Ku().hJ(6);
                            if (hJ2 != null && hJ2.bqa != null) {
                                hJ2.bqa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bbu.Ll();
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
        this.fHM.onActivityResult(i, i2, intent);
        if (this.fHv != null) {
            this.fHv.onActivityResult(i, i2, intent);
        }
        if (bah().bde() != null) {
            bah().bde().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bax();
                    return;
                case 13008:
                    aj.bcN().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fHy != null) {
                                PbActivity.this.fHy.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.fHy != null) {
                        a(baw(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (bam() == 1) {
                        bav();
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        ban();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dNI != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dNI.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void He() {
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
                    this.fHz.jI(false);
                    if (this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null && this.fHy.getPbData().aYG().zn() != null) {
                        this.fHy.getPbData().aYG().zn().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fHz != null && this.fHz.fQh != null) {
                        this.fHz.fQh.vT();
                        this.fHz.fQh.beD();
                        if (this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null) {
                            this.fHy.getPbData().aYG().eN(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fHw != null) {
                        this.fHz.cA(this.fHw);
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
            if (this.fHv == null) {
                this.fHv = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fHv.b(this.brR);
                this.fHv.c(this.brY);
            }
            this.fHv.a(emotionImageData, aZO(), aZO().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bav() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null && this.fHy.getPbData().aYG().ze() != null && this.fHy.getPbData().aYG().ze().size() > 0 && this.fHy.getPbData().aYG().ze().get(0) != null) {
            this.mAwardActId = this.fHy.getPbData().aYG().ze().get(0).wU();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.fHy.getPbData().getThreadId(), 0L));
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
                    this.fHz.bdt();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData baw() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bX = this.fHy.getPbData().bX(getPageContext().getPageActivity());
        PostData bdh = this.fHz.bdh();
        String str = "";
        if (bdh != null) {
            str = bdh.getId();
            String cl = bdh.cl(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(cl)) {
                bX[1] = cl;
            }
        }
        String zj = this.fHy.getPbData().aYG().zj();
        if (zj != null && zj.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bX[1]);
        shareFromPBMsgData.setImageUrl(bX[0]);
        shareFromPBMsgData.setForumName(this.fHy.getPbData().aYE().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fHy.getPbData().aYG().getId());
        shareFromPBMsgData.setTitle(this.fHy.getPbData().aYG().getTitle());
        return shareFromPBMsgData;
    }

    private void M(Intent intent) {
        a(baw(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.fd(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ab = new com.baidu.tbadk.core.util.ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_param1", 3).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fHy.getForumId()).ab("tid", PbActivity.this.fHy.bbF());
                        if (PbActivity.this.e(PbActivity.this.fHy.getPbData()) != 0) {
                            ab.s("obj_type", PbActivity.this.e(PbActivity.this.fHy.getPbData()));
                        }
                        TiebaStatic.log(ab);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.bam() == 1) {
                        PbActivity.this.bav();
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
            aVar.b(getPageContext()).AA();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), this.fHy.getPbData().aYT() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null) {
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
                    if (PbActivity.this.bam() == 1) {
                        PbActivity.this.bav();
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
            aVar.b(getPageContext()).AA();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), this.fHy.getPbData().aYT() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bax() {
        MarkData sT;
        if (this.fhR != null && (sT = this.fHy.sT(this.fHz.bdE())) != null) {
            if (!sT.isApp() || (sT = this.fHy.sT(this.fHz.bdE() + 1)) != null) {
                this.fHz.bdz();
                this.fhR.a(sT);
                if (!this.fhR.vk()) {
                    this.fhR.vm();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fhR.vl();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bay() {
        com.baidu.tieba.pb.data.f pbData = this.fHy.getPbData();
        this.fHy.kb(true);
        if (this.fhR != null) {
            pbData.pT(this.fhR.vj());
        }
        this.fHz.n(pbData);
    }

    private boolean baz() {
        if (this.fHy == null) {
            return true;
        }
        if (this.fHy.vk()) {
            final MarkData bbU = this.fHy.bbU();
            if (bbU == null || !this.fHy.getIsFromMark()) {
                return true;
            }
            final MarkData sT = this.fHy.sT(this.fHz.bdD());
            if (sT == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bbU);
                setResult(-1, intent);
                return true;
            } else if (sT.getPostId() == null || sT.getPostId().equals(bbU.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bbU);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cZ(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fhR != null) {
                            if (PbActivity.this.fhR.vk()) {
                                PbActivity.this.fhR.vl();
                                PbActivity.this.fhR.aH(false);
                            }
                            PbActivity.this.fhR.a(sT);
                            PbActivity.this.fhR.aH(true);
                            PbActivity.this.fhR.vm();
                        }
                        bbU.setPostId(sT.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bbU);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bau();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bbU);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bau();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fHz != null && PbActivity.this.fHz.getView() != null) {
                            PbActivity.this.fHz.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bbU);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bau();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.AA();
                return false;
            }
        } else if (this.fHy.getPbData() == null || this.fHy.getPbData().aYI() == null || this.fHy.getPbData().aYI().size() <= 0 || !this.fHy.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fHz == null) {
            return null;
        }
        return this.fHz.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Rh() {
        if (this.fHz == null) {
            return 0;
        }
        return this.fHz.bdM();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Ri() {
        if (this.bJw == null) {
            this.bJw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: agn */
                public ImageView nk() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean wG = com.baidu.tbadk.core.i.wA().wG();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.C0107d.common_color_10220));
                    if (wG) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0107d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView at(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.wA().wG()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0107d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bJw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Rj() {
        if (this.bJx == null) {
            this.bJx = TbRichTextView.x(getPageContext().getPageActivity(), 8);
        }
        return this.bJx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Rk() {
        if (this.bJB == null) {
            this.bJB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baV */
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
                    gifView.LL();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bJB;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Rl() {
        if (this.bJy == null) {
            this.bJy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baW */
                public View nk() {
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
                    ((PlayVoiceBntNew) view).bwP();
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
        return this.bJy;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Rn() {
        this.bJA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: baX */
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
        return this.bJA;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Ed() {
        if (this.bcZ == null) {
            this.bcZ = UserIconBox.v(getPageContext().getPageActivity(), 8);
        }
        return this.bcZ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fHp = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        if (ax.qk(str) && this.fHy != null && this.fHy.bbF() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").s("obj_param1", 1).ab("post_id", this.fHy.bbF()));
        }
        ax.bes().f(getPageContext(), str);
        this.fHp = true;
    }

    private com.baidu.tbadk.core.dialog.a baA() {
        if (this.fHk == null) {
            this.fHk = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.fHk.cY(getPageContext().getString(d.j.download_baidu_video_dialog));
            this.fHk.a(getPageContext().getString(d.j.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.lk()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.Bz());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.j.download_baidu_video));
                    }
                }
            });
            this.fHk.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fHk.aV(true);
            this.fHk.b(getPageContext());
            this.fHk.aW(false);
        }
        this.fHk.AA();
        return this.fHk;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        ax.bes().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fHp = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            baA();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.fHp = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.fHy.getPbData();
            TbRichText ay = ay(str, i);
            if (ay != null && (tbRichTextData = ay.QB().get(this.fIE)) != null) {
                cVar.fJq = new ArrayList<>();
                cVar.fJr = new ConcurrentHashMap<>();
                if (!tbRichTextData.QH().QT()) {
                    cVar.fJt = false;
                    String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                    cVar.fJq.add(b2);
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
                    imageUrlData.mIsReserver = this.fHy.bbT();
                    imageUrlData.mIsSeeHost = this.fHy.getHostMode();
                    cVar.fJr.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aYE() != null) {
                            cVar.forumName = pbData.aYE().getName();
                            cVar.forumId = pbData.aYE().getId();
                        }
                        if (pbData.aYG() != null) {
                            cVar.threadId = pbData.aYG().getId();
                        }
                        cVar.fJs = pbData.aYT() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fJt = true;
                int size = pbData.aYI().size();
                this.fIF = false;
                cVar.index = -1;
                if (pbData.aYN() != null) {
                    PostData aYN = pbData.aYN();
                    TbRichText bvK = aYN.bvK();
                    if (!ar.k(aYN)) {
                        i2 = a(bvK, ay, i, i, cVar.fJq, cVar.fJr);
                    } else {
                        i2 = a(aYN, i, cVar.fJq, cVar.fJr);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aYI().get(i4);
                    if (postData.getId() == null || pbData.aYN() == null || pbData.aYN().getId() == null || !postData.getId().equals(pbData.aYN().getId())) {
                        TbRichText bvK2 = postData.bvK();
                        if (!ar.k(postData)) {
                            i3 = a(bvK2, ay, i3, i, cVar.fJq, cVar.fJr);
                        } else {
                            i3 = a(postData, i3, cVar.fJq, cVar.fJr);
                        }
                    }
                }
                if (cVar.fJq.size() > 0) {
                    cVar.lastId = cVar.fJq.get(cVar.fJq.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aYE() != null) {
                        cVar.forumName = pbData.aYE().getName();
                        cVar.forumId = pbData.aYE().getId();
                    }
                    if (pbData.aYG() != null) {
                        cVar.threadId = pbData.aYG().getId();
                    }
                    cVar.fJs = pbData.aYT() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QH() == null) {
            return null;
        }
        return tbRichTextData.QH().QY();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QH() == null) {
            return 0L;
        }
        return tbRichTextData.QH().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QH() == null) {
            return false;
        }
        return tbRichTextData.QH().QZ();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QH() == null) {
            return false;
        }
        return tbRichTextData.QH().Ra();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo QH;
        String str;
        if (tbRichText == tbRichText2) {
            this.fIF = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.QB().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.QB().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.QH().getWidth() * ar;
                    int height = ar * tbRichTextData.QH().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.QH().QT()) {
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
                            if (tbRichTextData != null && (QH = tbRichTextData.QH()) != null) {
                                String QV = QH.QV();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = QH.QW();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = QV;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fHy.bbF(), -1L);
                                imageUrlData.mIsReserver = this.fHy.bbT();
                                imageUrlData.mIsSeeHost = this.fHy.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fIF) {
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
        com.baidu.tieba.tbadkCore.data.h bvR;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bvm;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bvm = (bvR = postData.bvR()).bvm()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bvm.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bvm.get(i3);
                if (jVar != null) {
                    String bvq = jVar.bvq();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bvq)) {
                        arrayList.add(bvq);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bvq;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bvp();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fHy.bbF(), -1L);
                        imageUrlData.mIsReserver = this.fHy.bbT();
                        imageUrlData.mIsSeeHost = this.fHy.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bvR.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bvq, imageUrlData);
                        }
                        if (!this.fIF) {
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
            if (postData.getId() != null && postData.getId().equals(this.fHy.zc())) {
                z = true;
            }
            MarkData h = this.fHy.h(postData);
            if (h != null) {
                this.fHz.bdz();
                if (this.fhR != null) {
                    this.fhR.a(h);
                    if (!z) {
                        this.fhR.vm();
                    } else {
                        this.fhR.vl();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ay(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fHy == null || this.fHy.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.fHy.getPbData();
        if (pbData.aYN() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aYN());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aYI = pbData.aYI();
            a(pbData, aYI);
            return a(aYI, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aYR() != null && fVar.aYR().fEx != null && (list = fVar.aYR().fEx) != null && arrayList != null) {
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

    private long pX(String str) {
        ArrayList<PostData> aYI;
        com.baidu.tieba.pb.data.f pbData = this.fHy.getPbData();
        if (pbData != null && (aYI = pbData.aYI()) != null && !aYI.isEmpty()) {
            Iterator<PostData> it = aYI.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bvR = next.bvR();
                if (bvR != null && bvR.gXO) {
                    Iterator<TbRichTextData> it2 = next.bvK().QB().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.QQ().getLink().equals(str)) {
                            return bvR.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> QB;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bvK = arrayList.get(i2).bvK();
            if (bvK != null && (QB = bvK.QB()) != null) {
                int size = QB.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (QB.get(i4) != null && QB.get(i4).getType() == 8) {
                        i3++;
                        if (QB.get(i4).QH().QV().equals(str) || QB.get(i4).QH().QW().equals(str)) {
                            int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                            int width = QB.get(i4).QH().getWidth() * ar;
                            int height = QB.get(i4).QH().getHeight() * ar;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fIE = i4;
                            return bvK;
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
            this.fGM = str;
            if (this.fHj == null) {
                baj();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fHj.fj(1).setVisibility(8);
            } else {
                this.fHj.fj(1).setVisibility(0);
            }
            this.fHj.AD();
            this.fHp = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baB() {
        hideNetRefreshView(this.fHz.getView());
        baC();
        if (this.fHy.MO()) {
            this.fHz.bdz();
        }
    }

    private void baC() {
        showLoadingView(this.fHz.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View Mh = getLoadingView().Mh();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Mh.getLayoutParams();
        layoutParams.addRule(3, this.fHz.bec().getId());
        Mh.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aun() {
        if (this.dBh != null) {
            this.dBh.stopPlay();
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
        if (this.fHy.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.fHy.getPbData();
            pbData.aYE().getName();
            String title = pbData.aYG().getTitle();
            int i2 = this.fHy.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aYE() != null) {
                if ((pbData.aYE().isLike() == 1) && AddExperiencedModel.qx(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fHy.bbF() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bX = pbData.bX(getPageContext().getPageActivity());
                    str = bX[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bX[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bam() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ab(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                    } else if (bam() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ab(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.biW = true;
                    dVar.bja = z;
                    dVar.extData = this.fHy.bbF();
                    dVar.bjk = 3;
                    dVar.bjj = i;
                    dVar.fid = this.fHy.getForumId();
                    dVar.tid = this.fHy.bbF();
                    dVar.bjl = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.bje = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fHy.getPbData().aYG());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.bjk);
                    bundle.putInt("obj_type", dVar.bjl);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.h(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aZd()) {
                                PbActivity.this.fHz.getView().setSystemUiVisibility(4);
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
            String str32 = "http://tieba.baidu.com/p/" + this.fHy.bbF() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bX2 = pbData.bX(getPageContext().getPageActivity());
            str = bX2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bX2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bam() != 1) {
            }
            if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.biW = true;
            dVar2.bja = z;
            dVar2.extData = this.fHy.bbF();
            dVar2.bjk = 3;
            dVar2.bjj = i;
            dVar2.fid = this.fHy.getForumId();
            dVar2.tid = this.fHy.bbF();
            dVar2.bjl = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fHy.getPbData().aYG());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.bjk);
            bundle2.putInt("obj_type", dVar2.bjl);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.h(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fHy != null && PbActivity.this.fHy.getPbData() != null && PbActivity.this.fHy.getPbData().aZd()) {
                        PbActivity.this.fHz.getView().setSystemUiVisibility(4);
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
        if (fVar != null && fVar.aYG() != null) {
            if (fVar.aYG().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aYG().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void baD() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.qy(PbActivity.this.fHy.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fHz.bek();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Rm() {
        if (this.bJz == null) {
            this.bJz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: baY */
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
        return this.bJz;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fHz.bdu() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, this.fHy.getPbData().getForumId()));
            } else {
                bd aYG = this.fHy.getPbData().aYG();
                if (view != null) {
                    boolean z = aYG.yH() == null || aYG.yH().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fIq > 1000) {
                            this.fIr = true;
                            ct(view);
                        } else {
                            this.fIr = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            s(view, this.fIr);
                        } else {
                            r(view, this.fIr);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        r(view, this.fIr);
                    } else if (motionEvent.getAction() == 3) {
                        r(view, this.fIr);
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
                    PbActivity.this.fIq = System.currentTimeMillis();
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
                    PbActivity.this.fIq = System.currentTimeMillis();
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

    public void auo() {
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
        } else if (aVar.AC() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.AC();
            int intValue = ((Integer) sparseArray.get(as.fRU)).intValue();
            if (intValue == as.fRV) {
                if (!this.cUS.bwv()) {
                    this.fHz.bdw();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cUS.a(this.fHy.getPbData().aYE().getId(), this.fHy.getPbData().aYE().getName(), this.fHy.getPbData().aYG().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == as.fRW || intValue == as.fRY) {
                if (this.fHy.bcd() != null) {
                    this.fHy.bcd().sK(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == as.fRW) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == as.fRX) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.fIK).wP()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fHT);
        userMuteAddAndDelCustomMessage.setTag(this.fHT);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pY(String str) {
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

    public void jN(boolean z) {
        this.fHH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String baE() {
        ArrayList<PostData> aYI;
        int D;
        if (this.fHy == null || this.fHy.getPbData() == null || this.fHy.getPbData().aYI() == null || (D = com.baidu.tbadk.core.util.v.D((aYI = this.fHy.getPbData().aYI()))) == 0) {
            return "";
        }
        if (this.fHy.bbT()) {
            Iterator<PostData> it = aYI.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bvH() == 1) {
                    return next.getId();
                }
            }
        }
        int bdD = this.fHz.bdD();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(aYI, bdD);
        if (postData == null || postData.yS() == null) {
            return "";
        }
        if (this.fHy.qb(postData.yS().getUserId())) {
            return postData.getId();
        }
        for (int i = bdD - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(aYI, i);
            if (postData2 == null || postData2.yS() == null || postData2.yS().getUserId() == null) {
                break;
            } else if (this.fHy.qb(postData2.yS().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bdD + 1; i2 < D; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(aYI, i2);
            if (postData3 == null || postData3.yS() == null || postData3.yS().getUserId() == null) {
                return "";
            }
            if (this.fHy.qb(postData3.yS().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ab(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.av.CZ().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(pX(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fHy.getPbData().aYE().getId(), this.fHy.getPbData().aYE().getName(), this.fHy.getPbData().aYG().getTid());
            }
            this.fHp = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fHy.bcc() != null) {
                    PbActivity.this.fHy.bcc().cE(j);
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
        aVar.AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c pZ(String str) {
        String str2;
        if (this.fHy.getPbData() == null || this.fHy.getPbData().aYI() == null || this.fHy.getPbData().aYI().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fHy.getPbData().aYI().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fHy.getPbData().aYI().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fHy.getPbData().aYI().get(i);
        if (postData.bvK() == null || postData.bvK().QB() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bvK().QB().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.QH() != null) {
                    str2 = next.QH().QV();
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
        if (this.fHf) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fHf = false;
        } else if (baF()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fHf) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fHf = false;
        } else if (baF()) {
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
        if (pageStayDurationItem != null && this.fHy != null) {
            if (this.fHy.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fHy.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fHy.bbF(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean baF() {
        return (!this.fHd && this.fIM == -1 && this.fIN == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fIP = mVar;
            this.fHd = true;
            this.fHz.bdn();
            this.fHz.qi(this.fIO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baG() {
        if (this.fIP != null) {
            if (this.fIM == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.ax.bd(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fIP.getCartoonId(), this.fIM, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baH() {
        if (this.fIP != null) {
            if (this.fIN == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.tbadk.core.util.ax.bd(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fIP.getCartoonId(), this.fIN, 0)));
                finish();
            }
        }
    }

    public int baI() {
        return this.fIM;
    }

    public int baJ() {
        return this.fIN;
    }

    private void aCl() {
        if (this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null && this.fHy.getPbData().aYG().zF()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void baK() {
        if (this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null && this.fHy.getPbData().aYG().zF()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void baL() {
        if (this.fHg) {
            this.fHu = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null && this.fHy.getPbData().aYG().yA() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fHy.getPbData().aYG().yA().getThreadId(), this.fHy.getPbData().aYG().yA().getTaskId(), this.fHy.getPbData().aYG().yA().getForumId(), this.fHy.getPbData().aYG().yA().getForumName(), this.fHy.getPbData().aYG().yN(), this.fHy.getPbData().aYG().yO())));
            this.fHf = true;
            finish();
        }
    }

    public boolean baM() {
        return this.fHg;
    }

    public String baN() {
        return this.fHs;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a baO() {
        return this.fHx;
    }

    public void jO(boolean z) {
        this.fHt = z;
    }

    public boolean baP() {
        if (this.fHy != null) {
            return this.fHy.bbH();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cZ(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fHR).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fHR.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fHR).AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fHR != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fHR.getPageActivity());
            aVar.cZ(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fHR).AA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fHz.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fHR.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cZ(this.fHR.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cZ(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fHz.showLoadingDialog();
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
        aVar.b(this.fHR).AA();
    }

    public void baR() {
        if (this.fHy != null && this.fHy.getPbData() != null && this.fHy.getPbData().aYG() != null && this.fHy.getPbData().aYG().zU() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.fb(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.fHy.getPbData().aYG().zU().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.AA();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ax.qk(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.fHz != null) {
            this.fHz.onConfigurationChanged(configuration);
        }
        if (this.fHF != null) {
            this.fHF.dismiss();
        }
    }

    public boolean baS() {
        if (this.fHy != null) {
            return this.fHy.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, as asVar) {
        boolean z;
        List<PostData> list = this.fHy.getPbData().aYR().fEx;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bvE().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bvE().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bvE().remove(i2);
                    list.get(i).bvG();
                    z = true;
                    break;
                }
            }
            list.get(i).sx(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            asVar.n(this.fHy.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aZt().getId();
        List<PostData> list = this.fHy.getPbData().aYR().fEx;
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
                ArrayList<PostData> aZx = mVar.aZx();
                postData.vK(mVar.getTotalCount());
                if (postData.bvE() != null) {
                    postData.bvE().clear();
                    postData.bvE().addAll(aZx);
                }
            }
        }
        if (!this.fHy.getIsFromMark()) {
            this.fHz.n(this.fHy.getPbData());
        }
    }

    public boolean baT() {
        if (this.fHy == null) {
            return false;
        }
        return this.fHy.baT();
    }

    public void baU() {
        if (this.fHz != null) {
            this.fHz.bdc();
            auo();
        }
    }

    public PostData aYN() {
        return this.fHz.b(this.fHy.fMG, this.fHy.bbG());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.isLinkThread()) {
                return 3;
            }
            if (bdVar.zW()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fIb != null && !this.fIb.isEmpty()) {
            int size = this.fIb.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fIb.get(i).onBackPressed()) {
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
            if (this.fIb == null) {
                this.fIb = new ArrayList();
            }
            if (!this.fIb.contains(aVar)) {
                this.fIb.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fIb == null) {
                this.fIb = new ArrayList();
            }
            if (!this.fIb.contains(aVar)) {
                this.fIb.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fIb != null) {
            this.fIb.remove(aVar);
        }
    }
}
