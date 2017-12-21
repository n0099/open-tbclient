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
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.am;
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
import com.baidu.tbadk.core.util.ax;
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
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e {
    private com.baidu.adp.lib.e.b<ImageView> aVA;
    private com.baidu.adp.lib.e.b<TextView> aVB;
    private com.baidu.adp.lib.e.b<View> aVC;
    private com.baidu.adp.lib.e.b<LinearLayout> aVD;
    private com.baidu.adp.lib.e.b<RelativeLayout> aVE;
    private com.baidu.adp.lib.e.b<GifView> aVF;
    private com.baidu.tieba.d.c anY;
    private com.baidu.adp.lib.e.b<TbImageView> aoU;
    private com.baidu.tieba.e.b bHP;
    private VoiceManager cHl;
    private String eSL;
    public at eTD;
    private y eTE;
    private boolean eTG;
    private com.baidu.tieba.tbadkCore.data.e eTJ;
    private com.baidu.tbadk.editortools.pb.g eTK;
    private com.baidu.tbadk.editortools.pb.d eTL;
    private com.baidu.adp.base.e eTQ;
    private com.baidu.tbadk.core.view.d eTR;
    private BdUniqueId eTS;
    private Runnable eTT;
    private av eTU;
    private com.baidu.adp.widget.a.a eTV;
    private String eTW;
    private TbRichTextMemeInfo eTX;
    private com.baidu.tieba.pb.pb.main.a.b eTd;
    private com.baidu.tbadk.core.dialog.a eTj;
    private com.baidu.tieba.pb.pb.main.emotion.model.a eTu;
    private View eTv;
    private boolean eUA;
    private String eUM;
    private com.baidu.tbadk.core.data.m eUN;
    private List<a> eUa;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eTc = false;
    private boolean eTe = false;
    private boolean eTf = false;
    private boolean exc = false;
    private boolean eTg = true;
    private int eTh = 0;
    private com.baidu.tbadk.core.dialog.b eTi = null;
    private long ctz = -1;
    private long aKz = 0;
    private long eTk = 0;
    private long createTime = 0;
    private long aKr = 0;
    private boolean eTl = false;
    private com.baidu.tbadk.k.d eTm = null;
    private long eTn = 0;
    private boolean eTo = false;
    private long eTp = 0;
    private String aDL = null;
    private boolean eTq = false;
    private boolean isFullScreen = false;
    private String eTr = "";
    private boolean eTs = true;
    private boolean eTt = false;
    private String source = "";
    private PbInterviewStatusView.a eTw = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eTy.jP(!PbActivity.this.eTs);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eTx != null && PbActivity.this.eTx.nH()) {
                        PbActivity.this.aTi();
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahP));
        }
    };
    private PbModel eTx = null;
    private com.baidu.tbadk.baseEditMark.a eus = null;
    private ForumManageModel cbL = null;
    private com.baidu.tbadk.coreExtra.model.a apx = null;
    private ShareSuccessReplyToServerModel cWV = null;
    private ar eTy = null;
    public final com.baidu.tieba.pb.pb.main.a.a eTz = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eTA = false;
    private boolean eTB = false;
    private boolean eTC = false;
    private boolean eTF = false;
    private boolean eTH = false;
    private boolean eTI = false;
    private boolean eTM = false;
    public boolean eTN = false;
    private com.baidu.tbadk.editortools.pb.c aDO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void DB() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean DA() {
            if (PbActivity.this.eTD == null || PbActivity.this.eTD.aWW() == null || !PbActivity.this.eTD.aWW().bFG()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eTD.aWW().bFI());
            if (PbActivity.this.eTL != null && (PbActivity.this.eTL.DP() || PbActivity.this.eTL.DQ())) {
                PbActivity.this.eTL.a(false, PbActivity.this.eTD.aWZ());
            }
            PbActivity.this.eTD.ka(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b eTO = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean DA() {
            if (PbActivity.this.eTD == null || PbActivity.this.eTD.aWX() == null || !PbActivity.this.eTD.aWX().bFG()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eTD.aWX().bFI());
            if (PbActivity.this.eTy != null && PbActivity.this.eTy.aVN() != null && PbActivity.this.eTy.aVN().aUf() != null && PbActivity.this.eTy.aVN().aUf().DQ()) {
                PbActivity.this.eTy.aVN().aUf().a(PbActivity.this.eTD.aWZ());
            }
            PbActivity.this.eTD.kb(true);
            return true;
        }
    };
    private boolean eTP = false;
    private int mLastScrollState = -1;
    private boolean cHR = false;
    private int eTY = 0;
    private int eTZ = -1;
    private final z.a eUb = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void C(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eTy.showToast(str);
            }
        }
    };
    private final CustomMessageListener eUc = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eTx != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eTL != null) {
                    PbActivity.this.eTy.jU(PbActivity.this.eTL.DI());
                }
                PbActivity.this.eTy.aVO();
                PbActivity.this.eTy.aWx();
            }
        }
    };
    CustomMessageListener cIh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                PbActivity.this.eTx.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                if (PbActivity.this.eTy != null && PbActivity.this.eTx != null) {
                    PbActivity.this.eTy.d(PbActivity.this.eTx.getPbData(), PbActivity.this.eTx.aUo(), PbActivity.this.eTx.aUG());
                }
                if (PbActivity.this.eTy != null && PbActivity.this.eTy.aWe() != null) {
                    PbActivity.this.eTy.aWe().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eUd = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eTy != null) {
                    if (booleanValue) {
                        PbActivity.this.eTy.aBw();
                    } else {
                        PbActivity.this.eTy.aBv();
                    }
                }
            }
        }
    };
    private CustomMessageListener eUe = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eTL != null) {
                    PbActivity.this.eTy.jU(PbActivity.this.eTL.DI());
                }
                PbActivity.this.eTy.jW(false);
            }
        }
    };
    private CustomMessageListener eUf = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
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
    private CustomMessageListener eUg = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eTy != null && PbActivity.this.eTy.aWe() != null) {
                PbActivity.this.eTy.aWe().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dEV = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private j.a eUh = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.pS(2);
                ai.aVw().reset();
                PbActivity.this.eTx.aUH();
                boolean z2 = false;
                ArrayList<PostData> aRs = PbActivity.this.eTx.getPbData().aRs();
                if (aRs != null) {
                    Iterator<PostData> it = aRs.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.bxe().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eTy.p(PbActivity.this.eTx.getPbData());
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
    private View.OnClickListener aEw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aDL);
        }
    };
    private CustomMessageListener eUi = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x)) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = xVar.id;
                aVar.giftName = xVar.name;
                aVar.WV = xVar.WV;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTx.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eTx.aUx() != null && PbActivity.this.eTx.aUx().getUserIdLong() == xVar.toUserId) {
                        PbActivity.this.eTy.a(xVar.sendCount, PbActivity.this.eTx.getPbData(), PbActivity.this.eTx.aUo(), PbActivity.this.eTx.aUG());
                    }
                    if (pbData.aRs() != null && pbData.aRs().size() >= 1 && pbData.aRs().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aRs().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eTx.aUn(), 0L);
                        if (c2 == xVar.postId && c3 == xVar.threadId) {
                            com.baidu.tbadk.core.data.am bxd = pbData.aRs().get(0).bxd();
                            if (bxd == null) {
                                bxd = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> qx = bxd.qx();
                            if (qx == null) {
                                qx = new ArrayList<>();
                            }
                            qx.add(0, aVar);
                            bxd.bM(xVar.sendCount + bxd.qw());
                            bxd.g(qx);
                            pbData.aRs().get(0).a(bxd);
                            PbActivity.this.eTy.aWe().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eUj = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.ahM() != null && !aVar.ahM().isEmpty()) {
                    PbActivity.this.eTy.a(aVar, PbActivity.this.eUl);
                }
                PbActivity.this.eTy.a(aVar, PbActivity.this.eTx.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.aXc()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a eUk = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void C(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.w(list) && PbActivity.this.eTy != null) {
                PbActivity.this.eTy.cL(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eUl = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aS(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.fJ().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13.1
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
    private boolean eUm = false;
    private PraiseModel eUn = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hW(String str) {
            PbActivity.this.eUm = false;
            if (PbActivity.this.eUn != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTx.getPbData();
                if (pbData.aRq().rk().getIsLike() == 1) {
                    PbActivity.this.kp(0);
                } else {
                    PbActivity.this.kp(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aRq()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void F(int i, String str) {
            PbActivity.this.eUm = false;
            if (PbActivity.this.eUn != null && str != null) {
                if (AntiHelper.uB(i)) {
                    AntiHelper.am(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eUo = 0;
    private boolean eUp = true;
    private b.a eUq = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jk(boolean z) {
            PbActivity.this.jj(z);
            if (PbActivity.this.eTy.aWI() != null && z) {
                PbActivity.this.eTy.jP(false);
            }
            PbActivity.this.eTy.jR(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().ass != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().ass, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahP));
                        }
                    } else if (updateAttentionMessage.getData().BJ) {
                        if (PbActivity.this.aRx().rv() != null && PbActivity.this.aRx().rv().getGodUserData() != null) {
                            PbActivity.this.aRx().rv().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRq() != null && PbActivity.this.eTx.getPbData().aRq().rv() != null) {
                            PbActivity.this.eTx.getPbData().aRq().rv().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bHq = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eTy.XC();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.pT(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.atg();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aVK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eTy.aVP()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eTx != null && (PbActivity.this.eTx.getPbData() != null || PbActivity.this.eTx.getPbData().aRM() != null)) {
                    if (PbActivity.this.eTx.getPbData().aRM().aRW()) {
                        if (PbActivity.this.eTx.getPbData().aRM().eQf == 1 || PbActivity.this.eTx.getPbData().aRM().eQf == 3 || PbActivity.this.eTx.getPbData().aRM().eQf == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eTx.getPbData().aRM().aRW() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eTx.getPbData().aRM().aRW() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eTp > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).kv(false);
                        PbActivity.this.eTp = System.currentTimeMillis();
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
                    if (PbActivity.this.bd(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.eTy != null && PbActivity.this.eTy.aSS() && (view.getId() == d.g.pb_head_user_info_root || view == PbActivity.this.eTy.aWP())) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ac("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.eTz != null && PbActivity.this.eTz.ffX != null) {
                            PbActivity.this.eTz.ffX.onClick(view);
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
            if (PbActivity.this.eTL != null) {
                PbActivity.this.eTy.jU(PbActivity.this.eTL.DI());
            }
            PbActivity.this.eTy.aVO();
            PbActivity.this.eTy.aWx();
            return true;
        }
    });
    private CustomMessageListener eUr = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eTS) {
                PbActivity.this.eTy.XC();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTx.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aRD().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eTR.c(PbActivity.this.eTQ.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eTQ.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aTA();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eTQ.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.eTR.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eUs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eTS) {
                PbActivity.this.eTy.XC();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eTR.c(PbActivity.this.eTQ.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eTQ.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.eTR.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eUt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eTS) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eTy.XC();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gPy;
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
                    PbActivity.this.eTy.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eUu = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eTy.aVP() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aSx() != null && PbActivity.this.aSx().getPbData() != null && PbActivity.this.aSx().getPbData().aRM() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aRW = PbActivity.this.aSx().getPbData().aRM().aRW();
                if (intValue < 10) {
                    if (aRW) {
                        if (PbActivity.this.eTx.getPbData().aRM().eQf == 1 || PbActivity.this.eTx.getPbData().aRM().eQf == 3 || PbActivity.this.eTx.getPbData().aRM().eQf == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eTx.getPbData().aRM().aRW() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aRW ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eTp > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).kv(false);
                        PbActivity.this.eTp = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aRW, 3);
                TiebaStatic.log(PbActivity.this.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aRW ? 0 : 1));
            }
        }
    };
    private CustomMessageListener cIr = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cHR = true;
                }
            }
        }
    };
    public a.b eGD = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.alC();
            com.baidu.tbadk.core.data.al avJ = PbActivity.this.eTx.avJ();
            int pageNum = PbActivity.this.eTy.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (avJ == null || pageNum <= avJ.qp()) {
                PbActivity.this.eTy.aWx();
                PbActivity.this.pS(2);
                PbActivity.this.alB();
                PbActivity.this.eTy.aWi();
                if (com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.eTx.qa(PbActivity.this.eTy.getPageNum());
                    if (PbActivity.this.eTd != null) {
                        PbActivity.this.eTd.showFloatingView();
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
    public final View.OnClickListener cIN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Multi-variable search result rejected for r2v183, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v187, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v224, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v324, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v46, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:689:0x1c0f  */
        /* JADX WARN: Removed duplicated region for block: B:716:0x1dd9  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String name;
            com.baidu.tieba.pb.data.l aRM;
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
            boolean k;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.eTy.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.eTx.jv(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.eTy.aWj();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVp()) {
                        if (view == PbActivity.this.eTy.fbO.aMu) {
                            if (PbActivity.this.eTy.jT(PbActivity.this.eTx.aUu())) {
                                PbActivity.this.alB();
                                return;
                            }
                            PbActivity.this.eTg = false;
                            PbActivity.this.eTe = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eTy.aWg() && (PbActivity.this.eTy.fbO.aXl() == null || (view != PbActivity.this.eTy.fbO.aXl().aVo() && view != PbActivity.this.eTy.fbO.aXl().aVm()))) {
                            if (view == PbActivity.this.eTy.aWA()) {
                                if (PbActivity.this.eTx != null) {
                                    com.baidu.tbadk.browser.a.O(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eTx.getPbData().aRq().ru().getLink());
                                }
                            } else if (view != PbActivity.this.eTy.fbO.fgG && view.getId() != d.g.view_forum_name_first_floor && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.eTy.fbO.fgH) {
                                    if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null) {
                                        ArrayList<PostData> aRs = PbActivity.this.eTx.getPbData().aRs();
                                        if ((aRs == null || aRs.size() <= 0) && PbActivity.this.eTx.aUo()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ac("tid", PbActivity.this.eTx.aUn()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getForumId()));
                                        if (!PbActivity.this.eTy.aWQ()) {
                                            PbActivity.this.eTy.aVO();
                                        }
                                        PbActivity.this.aSZ();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVa()) {
                                        if ((PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVl()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.eTy.fbO.aXl() == null || (view != PbActivity.this.eTy.fbO.aXl().getCancelView() && view != PbActivity.this.eTy.fbO.aXl().aVk())) {
                                                if (view != PbActivity.this.eTy.fbO.fgI && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVi()) {
                                                        if ((PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVr()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVj()) {
                                                                if (PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVs()) {
                                                                    if (PbActivity.this.eTE == null || view != PbActivity.this.eTE.aVc()) {
                                                                        if (PbActivity.this.eTE == null || view != PbActivity.this.eTE.aVa()) {
                                                                            if (PbActivity.this.eTE == null || view != PbActivity.this.eTE.aVf()) {
                                                                                if (PbActivity.this.eTE == null || view != PbActivity.this.eTE.aVd()) {
                                                                                    if (PbActivity.this.eTE == null || view != PbActivity.this.eTE.aVe()) {
                                                                                        if (PbActivity.this.eTy.aWI() == view) {
                                                                                            if (PbActivity.this.eTy.aWI().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTx.getPbData();
                                                                                                if (pbData != null && pbData.aRq() != null && pbData.aRq().rb() != null) {
                                                                                                    String pG = pbData.aRq().rb().pG();
                                                                                                    if (StringUtils.isNull(pG)) {
                                                                                                        pG = pbData.aRq().rb().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ac("obj_id", pG));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cf("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.aTv();
                                                                                        } else if (PbActivity.this.eTy.aWd() != view) {
                                                                                            if (PbActivity.this.eTE == null || view != PbActivity.this.eTE.aVb()) {
                                                                                                if (PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVq()) {
                                                                                                    if (PbActivity.this.eTy.fbO.aXl() != null && view == PbActivity.this.eTy.fbO.aXl().aVn()) {
                                                                                                        if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.eTy.c(PbActivity.this.eTx.getPbData(), PbActivity.this.eTx.aUo(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                PbActivity.this.eTy.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                            PbActivity.this.eTy.fbO.or();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.eTy.aSL()) {
                                                                                                            if (view == PbActivity.this.eTy.fbO.aXm()) {
                                                                                                                PbActivity.this.eTy.aWq();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (biVar = (bi) view.getTag()) != null && !StringUtils.isNull(biVar.sW())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{biVar.sW()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData be = PbActivity.this.be(view);
                                                                                                                    if (be != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", be.bxj() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.aSx() != null && PbActivity.this.aSx().getPbData() != null && PbActivity.this.aSx().getPbData().aRM() != null && PbActivity.this.aSx().getPbData().aRM() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aSx().getPbData().aRM().aRW() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && !StringUtils.isNull(PbActivity.this.eTx.getPbData().getThreadId()) && (aRM = PbActivity.this.eTx.getPbData().aRM()) != null && aRM.aRV() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eTx.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.eTE == null) {
                                                                                                                                PbActivity.this.eTE = new y(PbActivity.this.getPageContext(), PbActivity.this.cIN);
                                                                                                                                PbActivity.this.eTy.bo(PbActivity.this.eTE.getView());
                                                                                                                                PbActivity.this.eTE.jz(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.eTE.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ac("tid", PbActivity.this.eTx.eXW));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.eTE.aVa().setTag(sparseArray2);
                                                                                                                            PbActivity.this.eTE.aVf().setTag(view.getTag());
                                                                                                                            PbActivity.this.eTE.jB(z6);
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
                                                                                                                                    PbActivity.this.eTE.aVd().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.eTE.aVd().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.eTE.aVb().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eTE.aVd().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eTE.aVb().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.eTE.aVb().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.eTE.aVb().setVisibility(8);
                                                                                                                                PbActivity.this.eTE.aVd().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.eTE.aVb().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eTE.aVd().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eTE.aVb().setText(d.j.delete);
                                                                                                                                PbActivity.this.eTE.aVd().setVisibility(0);
                                                                                                                                if (PbActivity.this.eTx.getPbData().aRB() != 1002 || z2) {
                                                                                                                                    PbActivity.this.eTE.aVd().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eTE.aVd().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.eTE.aVb().setVisibility(8);
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
                                                                                                                                PbActivity.this.eTE.aVc().setTag(sparseArray7);
                                                                                                                                PbActivity.this.eTE.aVc().setVisibility(0);
                                                                                                                                PbActivity.this.eTE.aVb().setVisibility(8);
                                                                                                                                PbActivity.this.eTE.aVc().setText(d.j.mute_option);
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
                                                                                                                                boolean jf = PbActivity.this.jf(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.eUE = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (aq.k(PbActivity.this.eUE) ? false : jf) {
                                                                                                                                    PbActivity.this.eTE.aVc().setVisibility(0);
                                                                                                                                    PbActivity.this.eTE.aVc().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eTE.aVc().setVisibility(8);
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
                                                                                                                                PbActivity.this.eTE.aVe().setVisibility(0);
                                                                                                                                PbActivity.this.eTE.aVe().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.eTE.aVe().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.eTE.aVe().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.eTE.aVe().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eTx.getPbData().nH()) {
                                                                                                                            String nG = PbActivity.this.eTx.getPbData().nG();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(nG) && nG.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.eTE.aVa().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eTE.aVa().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.eTE.jA(true);
                                                                                                                                PbActivity.this.eTE.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.eTE.jA(true);
                                                                                                                        PbActivity.this.eTE.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRq() != null && PbActivity.this.eTx.getPbData().aRq().sb() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), PbActivity.this.eTx.getPbData().aRq().sb());
                                                                                                                        if (PbActivity.this.eTx.getPbData().aRq().rZ() != 1) {
                                                                                                                            if (PbActivity.this.eTx.getPbData().aRq().rZ() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getPbData().getForumId()).ac("tid", PbActivity.this.eTx.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.eTx.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.eTy.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (ax.aS(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.j.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.eTy.aVO();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aSW() == 1) {
                                                                                                                            if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getPbData().getForumId()).ac("tid", PbActivity.this.eTx.getPbData().getThreadId()).ac("uid", currentAccount));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aSW() == 2 && PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getPbData().getForumId()).ac("tid", PbActivity.this.eTx.getPbData().getThreadId()).ac("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.aSW() == 1) {
                                                                                                                            if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getPbData().getForumId()).ac("tid", PbActivity.this.eTx.getPbData().getThreadId()).ac("uid", currentAccount2));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aSW() == 2 && PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getPbData().getForumId()).ac("tid", PbActivity.this.eTx.getPbData().getThreadId()).ac("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.aTq();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.aTr();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRI() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eTx.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ac(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{pbData2.aRI().aRR()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRI() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eTx.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{pbData3.aRI().aRR()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.eTy.fbO.aXl() != null && view == PbActivity.this.eTy.fbO.aXl().aVt()) {
                                                                                                                    if (PbActivity.this.eTx == null || PbActivity.this.eTx.getPbData() == null || PbActivity.this.eTx.getPbData().aRq() == null) {
                                                                                                                        PbActivity.this.eTy.fbO.or();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.hy()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.eTx.getPbData().aRq().rd() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eTx.aUn(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).tq();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").r("obj_locate", PbActivity.this.Z(PbActivity.this.eTx.getPbData().aRq())).ac("tid", PbActivity.this.eTx.getPbData().aRq().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.eTY >= 0) {
                                                                                                                        if (PbActivity.this.eTx != null) {
                                                                                                                            PbActivity.this.eTx.aUV();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eTy.aWe() != null) {
                                                                                                                            PbActivity.this.eTy.aWe().a(PbActivity.this.eTx.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.eTy.getListView().setSelection(PbActivity.this.eTx.aUY());
                                                                                                                        PbActivity.this.eTY = 0;
                                                                                                                        if (PbActivity.this.eTx != null) {
                                                                                                                            PbActivity.this.eTx.bu(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.eTy.aWT();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eTx.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eTx.aUn(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eTx.getPbData().aRq().rQ())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.eTx.getPbData() != null) {
                                                                                                            PbActivity.this.eTy.aWx();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bxl()) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12630"));
                                                                                                                }
                                                                                                                String aUn = PbActivity.this.eTx.aUn();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.eTx.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.eTx.getPbData().aRB();
                                                                                                                }
                                                                                                                PbActivity.this.alB();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c pM = PbActivity.this.pM(id2);
                                                                                                                    if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && pM != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aUn, id2, "pb", true, null, true, null, i3, postData3.aYe(), PbActivity.this.eTx.getPbData().qg(), false, postData3.rv().getIconInfo()).addBigImageData(pM.eVo, pM.eVp, pM.eVq, pM.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.eTx.aUU());
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
                                                                                                                    c pM2 = PbActivity.this.pM(id2);
                                                                                                                    if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && pM2 != null && PbActivity.this.aSR().aVM() != null) {
                                                                                                                        com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                        mVar.b(PbActivity.this.eTx.getPbData().aRo());
                                                                                                                        mVar.R(PbActivity.this.eTx.getPbData().aRq());
                                                                                                                        mVar.d(postData4);
                                                                                                                        PbActivity.this.aSR().aVM().d(mVar);
                                                                                                                        PbActivity.this.aSR().aVM().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c pM3 = PbActivity.this.pM(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && pM3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aUn, id2, "pb", true, null, false, null, i3, postData3.aYe(), PbActivity.this.eTx.getPbData().qg(), false, postData3.rv().getIconInfo()).addBigImageData(pM3.eVo, pM3.eVp, pM3.eVq, pM3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.eTx.aUU());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                    PbActivity.this.eTy.aWx();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.eTy.c(PbActivity.this.eTx.getPbData(), PbActivity.this.eTx.aUo(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eTx.getPbData().aRo().getId(), PbActivity.this.eTx.getPbData().aRo().getName(), PbActivity.this.eTx.getPbData().aRq().getId(), String.valueOf(PbActivity.this.eTx.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
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
                                                                                                    if (!com.baidu.tieba.c.a.abp() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eTx.aUn(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.eTy.bm(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.eTy.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.aSN();
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
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eTx.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aRo() != null) {
                                                                                            str9 = pbData4.aRo().getId();
                                                                                            str10 = pbData4.aRo().getName();
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
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.abp() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eTx.aUn(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.eTy.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.eTE.aVh()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ac("tid", PbActivity.this.eTx.eXW));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eTx.getPbData() != null) {
                                                                                    PbActivity.this.eTy.aWx();
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
                                                                                        String aUn2 = PbActivity.this.eTx.aUn();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.eTx.getPbData() != null) {
                                                                                            i5 = PbActivity.this.eTx.getPbData().aRB();
                                                                                        }
                                                                                        PbActivity.this.alB();
                                                                                        c pM4 = PbActivity.this.pM(id3);
                                                                                        if (pM4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aUn2, id3, "pb", true, null, true, null, i5, postData.aYe(), PbActivity.this.eTx.getPbData().qg(), false, postData.rv().getIconInfo()).addBigImageData(pM4.eVo, pM4.eVp, pM4.eVq, pM4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.eTx.aUU());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bf(view);
                                                                                if (PbActivity.this.eTx.getPbData().aRq() != null && PbActivity.this.eTx.getPbData().aRq().rv() != null && PbActivity.this.eTx.getPbData().aRq().rv().getUserId() != null && PbActivity.this.eus != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eTx.eXW).r("obj_locate", 2).ac("obj_id", PbActivity.this.eTx.getPbData().aRq().rv().getUserId()).r("obj_type", PbActivity.this.eus.nH() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eTx.getPbData())));
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
                                                                            PbActivity.this.pJ((String) tag);
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").r("obj_type", 0).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.eTy.fbO.or();
                                                                }
                                                            } else if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRq() != null) {
                                                                PbActivity.this.eTy.fbO.or();
                                                                PbActivity.this.pJ(PbActivity.this.eTx.getPbData().aRq().rM());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.eTy.aWx();
                                                            if (com.baidu.adp.lib.util.j.hh()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.eTx.aUB()));
                                                                    return;
                                                                }
                                                                PbActivity.this.pS(2);
                                                                PbActivity.this.alB();
                                                                PbActivity.this.eTy.aWi();
                                                                boolean aUA = PbActivity.this.eTx.aUA();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.eTx.aUB()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.eTy.fbO != null && PbActivity.this.eTy.fbO.aXl() != null && view == PbActivity.this.eTy.fbO.aXl().aVr()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (aUA) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.eTy.jK(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.eTy.aWx();
                                                        if (PbActivity.this.eTx.avJ() != null) {
                                                            PbActivity.this.eTy.a(PbActivity.this.eTx.avJ(), PbActivity.this.eGD);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.am.fS() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.eTx != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ac("tid", PbActivity.this.eTx.aUn()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.hy()) {
                                                        if (PbActivity.this.eTx.getPbData() != null) {
                                                            ArrayList<PostData> aRs2 = PbActivity.this.eTx.getPbData().aRs();
                                                            if ((aRs2 != null && aRs2.size() > 0) || !PbActivity.this.eTx.aUo()) {
                                                                PbActivity.this.eTy.aWx();
                                                                PbActivity.this.alB();
                                                                PbActivity.this.pS(2);
                                                                if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRI() != null && !StringUtils.isNull(PbActivity.this.eTx.getPbData().aRI().pR(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.am.fS()) {
                                                                    PbActivity.this.pT(2);
                                                                } else {
                                                                    PbActivity.this.eTy.showLoadingDialog();
                                                                    PbActivity.this.eTx.aUP().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.eTy.fbO.or();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.hh()) {
                                            PbActivity.this.eTy.aWx();
                                            if (PbActivity.this.eTy.fbO.aXl() != null && view == PbActivity.this.eTy.fbO.aXl().aVl() && !PbActivity.this.eTy.aWQ()) {
                                                PbActivity.this.eTy.aVO();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.alB();
                                                PbActivity.this.eTy.aWi();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    k = PbActivity.this.eTx.k(true, PbActivity.this.aTo());
                                                } else {
                                                    k = view.getId() == d.g.reply_title ? PbActivity.this.eTx.k(false, PbActivity.this.aTo()) : PbActivity.this.eTx.pO(PbActivity.this.aTo());
                                                }
                                                view.setTag(Boolean.valueOf(k));
                                                if (k) {
                                                    PbActivity.this.eTy.jo(true);
                                                    PbActivity.this.eTy.aBw();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.eTy.jK(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.pS(2);
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
                                        PbActivity.this.eTy.aWx();
                                        if (PbActivity.this.pR(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.eTx.qh(PbActivity.this.eTy.aWn()) != null) {
                                            PbActivity.this.aTh();
                                            if (PbActivity.this.eTx.getPbData().aRq() != null && PbActivity.this.eTx.getPbData().aRq().rv() != null && PbActivity.this.eTx.getPbData().aRq().rv().getUserId() != null && PbActivity.this.eus != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eTx.eXW).r("obj_locate", 1).ac("obj_id", PbActivity.this.eTx.getPbData().aRq().rv().getUserId()).r("obj_type", PbActivity.this.eus.nH() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eTx.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                    PbActivity.this.eTy.jo(true);
                                    PbActivity.this.eTy.aVO();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eTy.aBw();
                                        PbActivity.this.alB();
                                        PbActivity.this.eTy.aWi();
                                        PbActivity.this.eTx.pO(PbActivity.this.aTo());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.pS(2);
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
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12505").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, com.baidu.tieba.pb.d.u(PbActivity.this.getPageContext())));
                                }
                                if (PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRq() != null && PbActivity.this.eTx.getPbData().aRq().si() && PbActivity.this.eTx.getPbData().aRq().rN() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.eTx.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eTx.aUm()) && PbActivity.this.eTx.getAppealInfo() != null) {
                                        name = PbActivity.this.eTx.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eTx.getPbData().aRo().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aUm = PbActivity.this.eTx.aUm();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eTx.aUp() && aUm != null && aUm.equals(name)) {
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
                            if (PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRB() == 1 && !PbActivity.this.cbL.bxJ()) {
                                PbActivity.this.eTy.aWx();
                                int i6 = 0;
                                if (PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVm()) {
                                    if (PbActivity.this.eTy.fbO.aXl() == null || view != PbActivity.this.eTy.fbO.aXl().aVo()) {
                                        if (view == PbActivity.this.eTy.aWg()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eTx.getPbData().aRq().rr() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eTx.getPbData().aRq().rq() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aRo = PbActivity.this.eTx.getPbData().aRo();
                                String name2 = aRo.getName();
                                String id4 = aRo.getId();
                                String id5 = PbActivity.this.eTx.getPbData().aRq().getId();
                                if (!com.baidu.tieba.c.a.abp() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eTy.aWf();
                                    PbActivity.this.cbL.a(id4, name2, id5, i6, PbActivity.this.eTy.aWh());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.hh()) {
                        PbActivity.this.eTy.aWx();
                        PbActivity.this.alB();
                        PbActivity.this.eTy.aWi();
                        PbActivity.this.eTy.showLoadingDialog();
                        if (PbActivity.this.eTy.aVV() != null) {
                            PbActivity.this.eTy.aVV().setVisibility(8);
                        }
                        PbActivity.this.eTx.qa(1);
                        if (PbActivity.this.eTd != null) {
                            PbActivity.this.eTd.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String aSU = PbActivity.this.aSU();
                        if (!TextUtils.isEmpty(aSU)) {
                            com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{aSU});
                        }
                    }
                } else if (PbActivity.this.eTo) {
                    PbActivity.this.eTo = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.aSR().aVM() != null && postData5.rv() != null && postData5.bwV() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.aSR().aVN() != null) {
                                    PbActivity.this.aSR().aVN().aUb();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.eTx.getPbData().aRo());
                                mVar2.R(PbActivity.this.eTx.getPbData().aRq());
                                mVar2.d(postData5);
                                PbActivity.this.aSR().aVM().d(mVar2);
                                PbActivity.this.aSR().aVM().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.rv().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.eTL != null) {
                                    PbActivity.this.eTy.jU(PbActivity.this.eTL.DI());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aDV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.alB();
            PbActivity.this.eTy.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ad.GU() && PbActivity.this.aSx() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aSx().pR(postWriteCallBackData.getPostId());
                    PbActivity.this.eTY = PbActivity.this.eTy.aVR();
                    if (PbActivity.this.eTx != null) {
                        PbActivity.this.eTx.bu(PbActivity.this.eTY, PbActivity.this.eTy.aVS());
                    }
                }
                PbActivity.this.eTy.aWx();
                PbActivity.this.eTD.aWV();
                if (PbActivity.this.eTL != null) {
                    PbActivity.this.eTy.jU(PbActivity.this.eTL.DI());
                }
                PbActivity.this.eTy.aVL();
                PbActivity.this.eTy.jW(true);
                PbActivity.this.eTx.aUD();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eTx.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTx.getPbData();
                            if (pbData != null && pbData.aRq() != null && pbData.aRq().rv() != null && (userId = pbData.aRq().rv().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ad.GU() && PbActivity.this.eTx.aUw()) {
                                PbActivity.this.eTy.aWi();
                            }
                        } else if (!com.baidu.tbadk.o.ad.GU() && PbActivity.this.eTx.aUw()) {
                            PbActivity.this.eTy.aWi();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eTy.p(PbActivity.this.eTx.getPbData());
                    }
                    if (PbActivity.this.eTx.aUs()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ac("tid", PbActivity.this.eTx.aUn()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.eTL.DP() || PbActivity.this.eTL.DQ()) {
                    PbActivity.this.eTL.a(false, postWriteCallBackData);
                }
                PbActivity.this.eTD.e(postWriteCallBackData);
            } else if (sVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d eUv = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.eTD != null) {
                if (z) {
                    PbActivity.this.eTD.aWU();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    if (PbActivity.this.eTy != null && PbActivity.this.eTy.aVN() != null && PbActivity.this.eTy.aVN().aUf() != null && PbActivity.this.eTy.aVN().aUf().DQ()) {
                        PbActivity.this.eTy.aVN().aUf().a(postWriteCallBackData);
                    }
                    PbActivity.this.eTD.f(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a eUw = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eN;
            if (!z || fVar == null || fVar.aRz() != null || com.baidu.tbadk.core.util.v.v(fVar.aRs()) >= 1) {
                PbActivity.this.exc = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eTy.aWk();
                if (fVar == null || !fVar.aRw()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eTy.getView());
                } else if (PbActivity.this.eTy.aVJ() == null) {
                    PbActivity.this.eTP = true;
                }
                PbActivity.this.eTy.aBv();
                if (PbActivity.this.isFullScreen || PbActivity.this.eTy.aWQ()) {
                    PbActivity.this.eTy.aWE();
                } else if (!PbActivity.this.eTy.aWD()) {
                    PbActivity.this.eTy.jW(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eTF = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eTy.PB();
                    PbActivity.this.eTy.jX(fVar.aRw());
                    if (fVar.aRq() != null && fVar.aRq().ss() != null) {
                        PbActivity.this.a(fVar.aRq().ss());
                    }
                    PbActivity.this.aSO();
                    if (PbActivity.this.eTL != null) {
                        PbActivity.this.eTy.jU(PbActivity.this.eTL.DI());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aRs() != null && fVar.aRs().size() >= 1 && fVar.aRs().get(0) != null) {
                        PbActivity.this.eTx.pQ(fVar.aRs().get(0).getId());
                    } else if (fVar.aRz() != null) {
                        PbActivity.this.eTx.pQ(fVar.aRz().getId());
                    }
                    if (PbActivity.this.eTL != null) {
                        PbActivity.this.eTL.a(fVar.qg());
                        PbActivity.this.eTL.a(fVar.aRo(), fVar.getUserData());
                        PbActivity.this.eTL.a(PbActivity.this.eTx.aUx(), PbActivity.this.eTx.aUn(), PbActivity.this.eTx.aUR());
                        if (fVar.aRq() != null) {
                            PbActivity.this.eTL.bF(fVar.aRq().sI());
                        }
                    }
                    if (PbActivity.this.eus != null) {
                        PbActivity.this.eus.ab(fVar.nH());
                    }
                    if (fVar == null || fVar.aRC() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eTy.jV(PbActivity.this.mIsFromCDN);
                    PbActivity.this.eTy.a(fVar, i2, i3, PbActivity.this.eTx.aUo(), i4, PbActivity.this.eTx.getIsFromMark());
                    PbActivity.this.eTy.d(fVar, PbActivity.this.eTx.aUo());
                    PbActivity.this.eTy.jS(PbActivity.this.eTx.getHostMode());
                    AntiData qg = fVar.qg();
                    if (qg != null) {
                        PbActivity.this.aDL = qg.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aDL) && PbActivity.this.eTL != null && PbActivity.this.eTL.De() != null && (eN = PbActivity.this.eTL.De().eN(6)) != null && !TextUtils.isEmpty(PbActivity.this.aDL)) {
                            ((View) eN).setOnClickListener(PbActivity.this.aEw);
                        }
                    }
                    if (PbActivity.this.eTH) {
                        PbActivity.this.eTH = false;
                        final int aTb = PbActivity.this.aTb();
                        if (fVar.aRN()) {
                            final int ac = (int) (com.baidu.adp.lib.util.l.ac(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(aTb, ac);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.aSR().qm(aTb);
                        }
                    }
                    if (PbActivity.this.eTI) {
                        PbActivity.this.eTI = false;
                        final int aTb2 = PbActivity.this.aTb();
                        final boolean z2 = aTb2 != -1;
                        if (!z2) {
                            aTb2 = PbActivity.this.aTc();
                        }
                        if (PbActivity.this.aSR() != null) {
                            if (fVar.aRN()) {
                                final int ac2 = (int) (com.baidu.adp.lib.util.l.ac(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (aTb2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(aTb2, ac2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(aTb2 - 1, ac2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.aSR().qm(aTb2);
                            }
                        }
                    } else {
                        PbActivity.this.eTy.aWo();
                    }
                    PbActivity.this.eTx.a(fVar.aRo(), PbActivity.this.eUj);
                    PbActivity.this.eTx.a(PbActivity.this.eUk);
                } else if (str != null) {
                    if (!PbActivity.this.eTF && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eTx != null && PbActivity.this.eTx.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eTx.getAppealInfo().ePp)) {
                                    PbActivity.this.eTy.a(PbActivity.this.eTx.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eTy.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eTy.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.eTy.aWE();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.eTx.aUn());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getForumId());
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
                        PbActivity.this.eTy.pT(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.eTy.pT("");
                    }
                    PbActivity.this.eTy.ww();
                }
                PbActivity.this.aKz = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aSx().aUo() || PbActivity.this.aSx().getPbData().qy().qv() != 0 || PbActivity.this.aSx().aUK()) {
                    PbActivity.this.eTM = true;
                    return;
                }
                return;
            }
            PbActivity.this.eTx.qa(1);
            if (PbActivity.this.eTd != null) {
                PbActivity.this.eTd.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eTy.p(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.r.GB().GC()) {
                com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, PbActivity.this.aKr, PbActivity.this.createTime, PbActivity.this.aKz, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.ctz : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aKr = 0L;
                if (mVar != null) {
                    mVar.Gw();
                }
            }
        }
    };
    private CustomMessageListener eUx = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aSW() == 1) {
                    PbActivity.this.aTf();
                }
                PbActivity.this.aSX();
            }
        }
    };
    private final a.InterfaceC0056a eUy = new a.InterfaceC0056a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0056a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eTy.aWk();
            if (z) {
                if (PbActivity.this.eus != null) {
                    PbActivity.this.eus.ab(z2);
                }
                PbActivity.this.eTx.jx(z2);
                if (PbActivity.this.eTx.nH()) {
                    PbActivity.this.aTi();
                } else {
                    PbActivity.this.eTy.p(PbActivity.this.eTx.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.eus != null && PbActivity.this.eus.nK() != null && PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRq() != null && PbActivity.this.eTx.getPbData().aRq().rv() != null) {
                        MarkData nK = PbActivity.this.eus.nK();
                        MetaData rv = PbActivity.this.eTx.getPbData().aRq().rv();
                        if (nK != null && rv != null) {
                            if (!com.baidu.tbadk.core.util.am.equals(TbadkCoreApplication.getCurrentAccount(), rv.getUserId()) && !rv.hadConcerned()) {
                                PbActivity.this.b(rv);
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
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.pP(PbActivity.this.mLastScrollState) && PbActivity.this.pP(i)) {
                if (PbActivity.this.eTy != null) {
                    PbActivity.this.eTy.aWx();
                    if (PbActivity.this.eTL != null && !PbActivity.this.eTy.aVP()) {
                        PbActivity.this.eTy.jU(PbActivity.this.eTL.DI());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.eTy.aVO();
                    }
                }
                if (!PbActivity.this.eTl) {
                    PbActivity.this.eTl = true;
                    PbActivity.this.eTy.aWC();
                }
            }
            PbActivity.this.eTy.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eTd != null) {
                PbActivity.this.eTd.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eTm == null) {
                PbActivity.this.eTm = new com.baidu.tbadk.k.d();
                PbActivity.this.eTm.fr(1001);
            }
            if (i == 0) {
                PbActivity.this.eTm.Gi();
            } else if (i == 1) {
                PbActivity.this.eTm.Gi();
            } else {
                PbActivity.this.eTm.Gi();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aRs;
            if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTy != null && PbActivity.this.eTy.aWe() != null) {
                PbActivity.this.eTy.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eTd != null) {
                    PbActivity.this.eTd.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eTx.aUF() && (aRs = PbActivity.this.eTx.getPbData().aRs()) != null && !aRs.isEmpty()) {
                    int aTR = ((i + i2) - PbActivity.this.eTy.aWe().aTR()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTx.getPbData();
                    if (pbData != null) {
                        if (pbData.aRt() != null && pbData.aRt().hasData()) {
                            aTR--;
                        }
                        if (pbData.aRu() != null && pbData.aRu().hasData()) {
                            aTR--;
                        }
                        int size = aRs.size();
                        if (aTR < 0 || aTR >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cbP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.cbL.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eTx.aUD();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dkJ && bVar.fiu > 0 && bVar.gEl != 0 && bVar.fiu != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.fiu == 1002 && !bVar.dkJ) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eTy.a(1, dVar.Aj, dVar.gEn, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cbL.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.eTy.a(PbActivity.this.cbL.getLoadDataMode(), gVar.Aj, gVar.gEn, false);
                        PbActivity.this.eTy.al(gVar.gEq);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eTy.a(PbActivity.this.cbL.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d eUz = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
    };
    private final h.b bfL = new h.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aTp()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eTx.jw(true)) {
                PbActivity.this.eTy.aWl();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eUB = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eUA && PbActivity.this.aTp()) {
                PbActivity.this.aTr();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eTx.jv(false)) {
                    PbActivity.this.eTy.aWj();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eTx.getPbData() != null) {
                    PbActivity.this.eTy.aWB();
                }
                PbActivity.this.eUA = true;
            }
        }
    };
    private int eUC = 0;
    private final TbRichTextView.g aVJ = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
        public void a(View view, String str, int i) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.eTy.b((TbRichText) view.getTag());
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
                    PbActivity.this.eTv = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.eVr) {
                    TbRichText au = PbActivity.this.au(str, i);
                    if (au != null && PbActivity.this.eUC >= 0 && PbActivity.this.eUC < au.Jr().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.g.b(au.Jr().get(PbActivity.this.eUC));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.eVo.size()) {
                                break;
                            } else if (!cVar.eVo.get(i3).equals(b2)) {
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
                            concurrentHashMap.put(str2, cVar.eVp.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eVq, cVar.lastId, PbActivity.this.eTx.aUB(), concurrentHashMap, true, false, PbActivity.this.eTx.getHostMode());
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.eVo, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.w(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.eVp.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eVq, cVar.eVo.get(0), PbActivity.this.eTx.aUB(), concurrentHashMap2, true, false, PbActivity.this.eTx.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eUD = false;
    PostData eUE = null;
    private final b.InterfaceC0060b eUF = new b.InterfaceC0060b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eUE != null) {
                if (i == 0) {
                    PbActivity.this.eUE.cd(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eUE = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.eUE);
                }
            }
        }
    };
    private final b.InterfaceC0060b eUG = new b.InterfaceC0060b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eTV != null && !TextUtils.isEmpty(PbActivity.this.eTW)) {
                if (i == 0) {
                    if (PbActivity.this.eTX == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eTW));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eTW;
                        aVar.pkgId = PbActivity.this.eTX.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eTX.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eTU == null) {
                        PbActivity.this.eTU = new av(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eTU.i(PbActivity.this.eTW, PbActivity.this.eTV.kN());
                }
                PbActivity.this.eTV = null;
                PbActivity.this.eTW = null;
            }
        }
    };
    private final View.OnLongClickListener avI = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eTV = ((TbImageView) view).getBdImage();
                PbActivity.this.eTW = ((TbImageView) view).getUrl();
                if (PbActivity.this.eTV != null && !TextUtils.isEmpty(PbActivity.this.eTW)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eTX = null;
                    } else {
                        PbActivity.this.eTX = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eTy.a(PbActivity.this.eUG, PbActivity.this.eTV.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.eTV = ((GifView) view).getBdImage();
                }
                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                    PbActivity.this.eTW = ((GifView) view).getBdImage().getUrl();
                }
                if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                    PbActivity.this.eTX = null;
                } else {
                    PbActivity.this.eTX = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                }
                PbActivity.this.eTy.a(PbActivity.this.eUG, PbActivity.this.eTV.isGif());
            } else if (view instanceof com.baidu.tbadk.widget.c) {
                if (((com.baidu.tbadk.widget.c) view).getBdImage() != null) {
                    PbActivity.this.eTV = ((com.baidu.tbadk.widget.c) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.c) view).getBdImage().getUrl())) {
                        PbActivity.this.eTW = ((com.baidu.tbadk.widget.c) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eTX = null;
                    } else {
                        PbActivity.this.eTX = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eTy.a(PbActivity.this.eUG, PbActivity.this.eTV.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eUE = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.eUE != null && PbActivity.this.eus != null) {
                        PbActivity.this.eTy.a(PbActivity.this.eUF, PbActivity.this.eus.nH() && PbActivity.this.eUE.getId() != null && PbActivity.this.eUE.getId().equals(PbActivity.this.eTx.rF()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a cFA = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (!PbActivity.this.eTf && z && !PbActivity.this.eTx.aUv()) {
                PbActivity.this.aTl();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener aNp = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).auL()) {
                        break;
                    }
                }
            }
            PbActivity.this.bHP.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0096a bHQ = new a.InterfaceC0096a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        final int bRk;

        {
            this.bRk = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ag(int i, int i2) {
            if (K(i2) && PbActivity.this.eTy != null && PbActivity.this.eTd != null) {
                PbActivity.this.eTy.aWF();
                PbActivity.this.eTd.fc(false);
                PbActivity.this.eTd.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ah(int i, int i2) {
            if (K(i2) && PbActivity.this.eTy != null && PbActivity.this.eTd != null) {
                PbActivity.this.eTd.fc(true);
                if (Math.abs(i2) > this.bRk) {
                    PbActivity.this.eTd.hideFloatingView();
                }
                if (PbActivity.this.aTp()) {
                    PbActivity.this.eTy.aWa();
                    PbActivity.this.eTy.aWb();
                }
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ai(int i, int i2) {
        }

        private boolean K(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eUH = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // com.baidu.tieba.e.b.a
        public void ex(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aSn();
            } else {
                com.baidu.tieba.pb.a.b.aSm();
            }
        }
    };
    private String eUI = null;
    private final o.a eUJ = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eUI = str2;
                PbActivity.this.eTy.pU(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eUK = -1;
    private int eUL = -1;
    private CustomMessageListener eUO = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Ud == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0058a) {
                    if (aVar.Ue != null && !aVar.Ue.hasError() && aVar.Ue.getError() == 0) {
                        if (PbActivity.this.eTy != null) {
                            PbActivity.this.eTy.y(((a.C0058a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aTB();
                        }
                    } else if (z) {
                        if (aVar.Ue != null && aVar.Ue.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Ue.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Ue != null && !aVar.Ue.hasError() && aVar.Ue.getError() == 0) {
                        if (PbActivity.this.eTy != null && PbActivity.this.eTy != null) {
                            PbActivity.this.eTy.y(((a.C0058a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Ue != null && aVar.Ue.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Ue.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Ue == null || aVar.Ue.hasError() || aVar.Ue.getError() != 0) {
                        if (z) {
                            if (aVar.Ue != null && aVar.Ue.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Ue.getErrorString());
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
    private final CustomMessageListener cIk = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ac("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{str});
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
        public ArrayList<String> eVo;
        public ConcurrentHashMap<String, ImageUrlData> eVp;
        public boolean eVr;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eVq = false;
        public boolean eVs = false;
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

    public com.baidu.tbadk.editortools.pb.d aSM() {
        return this.eTL;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        if (mVar.aSc() != null) {
            String id = mVar.aSc().getId();
            ArrayList<PostData> aRs = this.eTx.getPbData().aRs();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aRs.size()) {
                    break;
                }
                PostData postData = aRs.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aSg = mVar.aSg();
                    postData.uv(mVar.getTotalCount());
                    if (postData.bwS() != null && aSg != null) {
                        Iterator<PostData> it = aSg.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.rv() != null && (metaData = postData.getUserMap().get(next.rv().getUserId())) != null) {
                                next.a(metaData);
                                next.nd(true);
                                next.b(getPageContext(), this.eTx.pP(metaData.getUserId()));
                            }
                        }
                        postData.bwS().clear();
                        postData.bwS().addAll(aSg);
                    }
                    if (postData.bwO() != null) {
                        postData.bwP();
                    }
                }
            }
            if (!this.eTx.getIsFromMark()) {
                this.eTy.p(this.eTx.getPbData());
            }
            c(mVar);
        }
    }

    public void aSN() {
        com.baidu.tieba.pb.data.f pbData;
        bd aRq;
        if (!this.eUm) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (this.eUp) {
                this.eUm = true;
                if (this.eTx != null && (pbData = this.eTx.getPbData()) != null && (aRq = pbData.aRq()) != null) {
                    int isLike = aRq.rk() == null ? 0 : aRq.rk().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ac("tid", aRq.getId()));
                    }
                    if (this.eUn != null) {
                        this.eUn.a(aRq.rM(), aRq.getId(), isLike, "pb");
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
                bVar.cg(d.j.operation);
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.j.delete);
                    strArr[1] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr, new b.InterfaceC0060b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.eTy.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eTS);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eTS);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0060b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eTS);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eTS);
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
    public void kp(int i) {
        bd aRq;
        String str;
        String y;
        if (this.eTx != null && this.eTx.getPbData() != null && (aRq = this.eTx.getPbData().aRq()) != null) {
            if (i == 1) {
                PraiseData rk = aRq.rk();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rk == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aRq.a(praiseData);
                    } else {
                        aRq.rk().getUser().add(0, metaData);
                        aRq.rk().setNum(aRq.rk().getNum() + 1);
                        aRq.rk().setIsLike(i);
                    }
                }
                if (aRq.rk() != null) {
                    if (aRq.rk().getNum() < 1) {
                        y = getResources().getString(d.j.zan);
                    } else {
                        y = com.baidu.tbadk.core.util.am.y(aRq.rk().getNum());
                    }
                    this.eTy.R(y, true);
                }
            } else if (aRq.rk() != null) {
                aRq.rk().setIsLike(i);
                aRq.rk().setNum(aRq.rk().getNum() - 1);
                ArrayList<MetaData> user = aRq.rk().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aRq.rk().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aRq.rk().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = aRq.rk().getNum() + "";
                }
                this.eTy.R(str, false);
            }
            if (this.eTx.aUo()) {
                this.eTy.aWe().notifyDataSetChanged();
            } else {
                this.eTy.q(this.eTx.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eTx.u(bundle);
        if (this.cHl != null) {
            this.cHl.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eTL.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eTQ = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.ctz = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eTr = intent.getStringExtra("from");
            if ("from_interview_live".equals(this.eTr)) {
                this.eTe = true;
            }
            this.eUK = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.eUL = intent.getIntExtra("key_manga_next_chapter", -1);
            this.eUM = intent.getStringExtra("key_manga_title");
            this.eTH = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.eTI = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (aTp()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.eTZ = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.ctz = System.currentTimeMillis();
        }
        this.eTk = System.currentTimeMillis();
        this.aKr = this.eTk - this.ctz;
        super.onCreate(bundle);
        this.eTh = 0;
        t(bundle);
        if (this.eTx != null && this.eTx.getPbData() != null) {
            this.eTx.getPbData().pH(this.source);
        }
        initUI();
        if (intent != null && this.eTy != null) {
            this.eTy.fbH = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.eTT == null) {
                    this.eTT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eTy.pW("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eTT, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.eTx != null && this.eTx.getPbData() != null) {
                this.eTx.pS(stringExtra);
            }
        }
        this.cHl = new VoiceManager();
        this.cHl.onCreate(getPageContext());
        initData(bundle);
        this.eTK = new com.baidu.tbadk.editortools.pb.g();
        aSO();
        this.eTL = (com.baidu.tbadk.editortools.pb.d) this.eTK.aV(getActivity());
        this.eTL.d(this);
        this.eTL.a(this.aDV);
        this.eTL.a(this.aDO);
        this.eTL.a(this, bundle);
        this.eTL.De().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eTL.De().by(true);
        je(true);
        this.eTy.setEditorTools(this.eTL.De());
        this.eTL.a(this.eTx.aUx(), this.eTx.aUn(), this.eTx.aUR());
        registerListener(this.eUe);
        if (!this.eTx.aUu()) {
            this.eTL.fW(this.eTx.aUn());
        }
        if (this.eTx.aUS()) {
            this.eTL.fU(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.eTL.fU(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eTk;
        registerListener(this.eUd);
        registerListener(this.eUf);
        registerListener(this.eUg);
        registerListener(this.cIh);
        registerListener(this.eUu);
        registerListener(this.eUc);
        this.eTJ = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gBt);
        this.eTJ.bwx();
        registerListener(this.eUi);
        registerListener(this.mAttentionListener);
        if (this.eTx != null) {
            this.eTx.aUI();
        }
        registerListener(this.eUx);
        registerListener(this.eUO);
        registerListener(this.cIr);
        if (this.eTy != null && this.eTy.aWJ() != null && this.eTy.aWK() != null) {
            this.eTd = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eTy.aWJ(), this.eTy.aWK(), this.eTy.aVV());
            this.eTd.a(this.eUq);
        }
        if (this.eTc && this.eTy != null && this.eTy.aWK() != null) {
            this.eTy.aWK().setVisibility(8);
        }
        this.eTR = new com.baidu.tbadk.core.view.d();
        this.eTR.alo = 1000L;
        registerListener(this.eUt);
        registerListener(this.eUr);
        registerListener(this.eUs);
        this.eTS = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eTS;
        userMuteAddAndDelCustomMessage.setTag(this.eTS);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eTS;
        userMuteCheckCustomMessage.setTag(this.eTS);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eTx.aUP().a(this.bHq);
        if ("from_tieba_kuang".equals(this.eTr)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 2).ac("tid", this.eTx.aUn()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        this.eTD = new at();
        if (this.eTL.DC() != null) {
            this.eTD.g(this.eTL.DC().getInputView());
        }
        this.eTL.a(this.aDP);
        this.cWV = new ShareSuccessReplyToServerModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSO() {
        if (this.eTK != null && this.eTx != null) {
            this.eTK.setForumName(this.eTx.aUm());
            if (this.eTx.getPbData() != null && this.eTx.getPbData().aRo() != null) {
                this.eTK.setForumId(this.eTx.getPbData().aRo().getId());
            }
            this.eTK.setFrom("pb");
            this.eTK.a(this.eTx);
        }
    }

    public String aSP() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aSQ() {
        return this.eTd;
    }

    private void je(boolean z) {
        this.eTL.bC(z);
        this.eTL.bD(z);
        this.eTL.bE(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRN() && !z && this.eTy != null && this.eTy.getView() != null) {
            this.eTy.getView().setSystemUiVisibility(4);
        }
        this.eTN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cHl != null) {
            this.cHl.onStart(getPageContext());
        }
    }

    public ar aSR() {
        return this.eTy;
    }

    public PbModel aSx() {
        return this.eTx;
    }

    public void pI(String str) {
        if (this.eTx != null && !StringUtils.isNull(str) && this.eTy != null) {
            this.eTy.jZ(true);
            this.eTx.pI(str);
            this.eTq = true;
            this.eTy.aWx();
            this.eTy.aWE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eTf = false;
        } else {
            this.eTf = true;
        }
        super.onPause();
        if (this.eTy.aVJ() != null && this.eTy.aVJ().aSJ() != null) {
            this.eTy.aVJ().aSJ().onPause();
        }
        BdListView listView = getListView();
        this.eTh = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eTh == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cHl != null) {
            this.cHl.onPause(getPageContext());
        }
        if (this.eTy != null) {
            this.eTy.onPause();
        }
        if (!this.eTx.aUu()) {
            this.eTL.fV(this.eTx.aUn());
        }
        if (this.eTx != null) {
            this.eTx.aUJ();
        }
        MessageManager.getInstance().unRegisterListener(this.dEV);
        ave();
        MessageManager.getInstance().unRegisterListener(this.eUr);
        MessageManager.getInstance().unRegisterListener(this.eUs);
        MessageManager.getInstance().unRegisterListener(this.eUt);
        MessageManager.getInstance().unRegisterListener(this.cIk);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aSS() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eTx.getPbData(), this.eTx.aUo(), this.eTx.aUG());
        return (a2 == null || a2.rv() == null || a2.rv().getGodUserData() == null || a2.rv().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eTf = false;
        super.onResume();
        if (this.eTt) {
            this.eTt = false;
            aTv();
        }
        if (this.eTy.aVJ() != null && this.eTy.aVJ().aSJ() != null) {
            this.eTy.aVJ().aSJ().onResume();
        }
        if (aSS()) {
            this.eTn = System.currentTimeMillis();
        } else {
            this.eTn = -1L;
        }
        if (this.eTy != null && this.eTy.getView() != null) {
            if (!this.exc) {
                aTm();
            } else {
                hideLoadingView(this.eTy.getView());
            }
            this.eTy.onResume();
        }
        if (this.eTh == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eTy != null) {
            noNetworkView = this.eTy.aVK();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.hh()) {
            noNetworkView.aI(false);
        }
        if (this.cHl != null) {
            this.cHl.onResume(getPageContext());
        }
        registerListener(this.dEV);
        this.eTG = false;
        aTu();
        registerListener(this.eUr);
        registerListener(this.eUs);
        registerListener(this.eUt);
        registerListener(this.cIk);
        if (this.cHR) {
            aTl();
            this.cHR = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eTy.jN(z);
        if (this.eTE != null) {
            this.eTE.jz(z);
        }
        if (z && this.eTG) {
            this.eTy.aWj();
            this.eTx.jv(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eTn > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ac("obj_duration", (System.currentTimeMillis() - this.eTn) + ""));
            this.eTn = 0L;
        }
        if (aSR().aVN() != null) {
            aSR().aVN().onStop();
        }
        if (this.eTy.fbO != null && !this.eTy.fbO.acI()) {
            this.eTy.fbO.aGe();
        }
        if (this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRo() != null && this.eTx.getPbData().aRq() != null) {
            com.baidu.tbadk.distribute.a.CO().a(getPageContext().getPageActivity(), "pb", this.eTx.getPbData().aRo().getId(), com.baidu.adp.lib.g.b.c(this.eTx.getPbData().aRq().getId(), 0L));
        }
        if (this.cHl != null) {
            this.cHl.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.eTl && this.eTy != null) {
            this.eTl = true;
            this.eTy.aWC();
            a(false, (PostData) null);
        }
        if (this.eTx != null) {
            this.eTx.cancelLoadData();
            this.eTx.destory();
            if (this.eTx.aUO() != null) {
                this.eTx.aUO().onDestroy();
            }
        }
        if (this.eTL != null) {
            this.eTL.onDestroy();
        }
        if (this.cbL != null) {
            this.cbL.cancelLoadData();
        }
        if (this.eTy != null) {
            this.eTy.onDestroy();
            if (this.eTy.fbO != null) {
                this.eTy.fbO.aGe();
            }
        }
        if (this.eTm != null) {
            this.eTm.onDestroy();
        }
        if (this.eTd != null) {
            this.eTd.Hq();
        }
        super.onDestroy();
        if (this.cHl != null) {
            this.cHl.onDestory(getPageContext());
        }
        this.eTy.aWx();
        MessageManager.getInstance().unRegisterListener(this.eUr);
        MessageManager.getInstance().unRegisterListener(this.eUs);
        MessageManager.getInstance().unRegisterListener(this.eUt);
        MessageManager.getInstance().unRegisterListener(this.eTS);
        MessageManager.getInstance().unRegisterListener(this.eUu);
        MessageManager.getInstance().unRegisterListener(this.cIr);
        this.eTQ = null;
        this.eTR = null;
        com.baidu.tieba.recapp.e.a.bmw().bmy();
        if (this.eTT != null) {
            getSafeHandler().removeCallbacks(this.eTT);
        }
        if (this.eTu != null) {
            this.eTu.cancelLoadData();
        }
        if (this.eTy != null && this.eTy.fbO != null) {
            this.eTy.fbO.aXp();
        }
        if (this.cWV != null) {
            this.cWV.cancelLoadData();
        }
        this.eTD.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        h aWe;
        ArrayList<PostData> aTS;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xH() && this.eTy != null && (aWe = this.eTy.aWe()) != null && (aTS = aWe.aTS()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aTS.iterator();
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
                        bVar.aMY = id;
                        bVar.cdB = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Zx == 1 && !TextUtils.isEmpty(id)) {
                    next.Zx = 2;
                    a.b bVar2 = new a.b();
                    bVar2.aMY = id;
                    bVar2.cdB = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eTx == null || this.eTx.getPbData() == null || this.eTx.getPbData().aRo() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eTx.getPbData().aRo().getFirst_class();
                    str2 = this.eTx.getPbData().aRo().getSecond_class();
                    str = this.eTx.getPbData().aRo().getId();
                    str4 = this.eTx.aUn();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xK());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eTy.onChangeSkinType(i);
        if (this.eTL != null && this.eTL.De() != null) {
            this.eTL.De().onChangeSkinType(i);
        }
        if (this.eTy.aVK() != null) {
            this.eTy.aVK().onChangeSkinType(getPageContext(), i);
        }
        this.eTD.onChangeSkinType();
    }

    private void initUI() {
        this.eTy = new ar(this, this.cIN, this.aVK);
        this.bHP = new com.baidu.tieba.e.b(getActivity());
        this.bHP.a(this.eUH);
        this.bHP.a(this.bHQ);
        this.eTy.setOnScrollListener(this.mOnScrollListener);
        this.eTy.d(this.eUB);
        this.eTy.a(this.bfL);
        this.eTy.iY(com.baidu.tbadk.core.h.oY().pe());
        this.eTy.setOnImageClickListener(this.aVJ);
        this.eTy.a(this.avI);
        this.eTy.h(this.cFA);
        this.eTy.a(this.eUz);
        this.eTy.jN(this.mIsLogin);
        if (getIntent() != null) {
            this.eTy.setIsInterviewLive(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bd(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gBV == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oY().pe()) {
                    return false;
                }
                return pL(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eTy != null) {
            if (z && (!this.exc || this.eTP)) {
                aTm();
            } else {
                hideLoadingView(this.eTy.getView());
            }
            this.eTP = false;
            if (z && this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRN() && this.eTy.getView() != null) {
                this.eTy.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void aST() {
        if (this.eTi == null) {
            this.eTi = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eTi.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0060b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eSL = PbActivity.this.eSL.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSL);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eTx.aUn(), PbActivity.this.eSL, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eSL = PbActivity.this.eSL.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSL);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eTx.aUn(), PbActivity.this.eSL, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eSL = PbActivity.this.eSL.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSL);
                        bVar.dismiss();
                    }
                }
            }).ch(b.a.abS).ci(17).d(getPageContext());
        }
    }

    private void t(Bundle bundle) {
        this.eTx = new PbModel(this);
        this.eTx.a(this.eUw);
        if (this.eTx.aUM() != null) {
            this.eTx.aUM().a(this.eUJ);
        }
        if (this.eTx.aUL() != null) {
            this.eTx.aUL().a(this.eUh);
        }
        if (this.eTx.aUO() != null) {
            this.eTx.aUO().b(this.eUb);
        }
        if (bundle != null) {
            this.eTx.initWithBundle(bundle);
        } else {
            this.eTx.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eTx.jy(true);
        }
        ai.aVw().Q(this.eTx.aUl(), this.eTx.getIsFromMark());
        if (StringUtils.isNull(this.eTx.aUn())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.eTr)) {
            this.eTx.qi(6);
        }
        this.eTx.Fz();
    }

    private void initData(Bundle bundle) {
        this.eus = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eus != null) {
            this.eus.a(this.eUy);
        }
        this.cbL = new ForumManageModel(this);
        this.cbL.setLoadDataCallBack(this.cbP);
        this.apx = new com.baidu.tbadk.coreExtra.model.a(null);
        this.eTy.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eTx.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eTx.getPbData().aRo().getId(), PbActivity.this.eTx.getPbData().aRo().getName(), PbActivity.this.eTx.getPbData().aRq().getId(), valueOf, str, str2)));
            }
        });
        this.eUn.setUniqueId(getUniqueId());
        this.eUn.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eTy.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eTS;
        userMuteCheckCustomMessage.setTag(this.eTS);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aSU() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.eTx != null && (pbData = this.eTx.getPbData()) != null) {
            return pbData.aRA().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aRq() != null) {
            if (fVar.aRq().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aRq().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aRq().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData be(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bxj()) {
                postData.cX(postData.bxi() - 1);
            } else {
                postData.cX(postData.bxi() + 1);
            }
            postData.ne(!postData.bxj());
            ((PbFloorAgreeView) view).a(postData.bxj(), postData.bxi(), true);
            final int i = postData.bxj() ? 0 : 1;
            this.eTx.aUN().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pU(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).qs(i2);
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

    public com.baidu.tbadk.core.util.ak aSV() {
        return new com.baidu.tbadk.core.util.ak("c12003").ac("tid", this.eTx.eXW).r("obj_type", 0).ac(ImageViewerConfig.FORUM_ID, this.eTx.getForumId()).r("obj_param1", this.eTx.getPbData().aRq().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
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
                        PbActivity.this.aSR().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aSR().aVN() != null) {
                        PbActivity.this.eTL.De().setVisibility(8);
                        PbActivity.this.aSR().aVN().bH(str, str2);
                        com.baidu.tbadk.editortools.pb.h aUf = PbActivity.this.aSR().aVN().aUf();
                        if (aUf != null && PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null) {
                            aUf.a(PbActivity.this.eTx.getPbData().qg());
                        }
                        if (PbActivity.this.eTD.aWY() == null && PbActivity.this.aSR().aVN().aUf().Ee() != null) {
                            PbActivity.this.aSR().aVN().aUf().Ee().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.eTD != null && PbActivity.this.eTD.aWX() != null) {
                                        if (!PbActivity.this.eTD.aWX().bFH()) {
                                            PbActivity.this.eTD.kb(false);
                                        }
                                        PbActivity.this.eTD.aWX().nU(false);
                                    }
                                }
                            });
                            PbActivity.this.eTD.h(PbActivity.this.aSR().aVN().aUf().Ee().getInputView());
                            PbActivity.this.aSR().aVN().aUf().a(PbActivity.this.eTO);
                        }
                    }
                    PbActivity.this.aSR().aWE();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.eTx != null && this.eTx.getPbData() != null && postData.bwV() > 1) {
            String aUn = this.eTx.aUn();
            String id = postData.getId();
            int aRB = this.eTx.getPbData() != null ? this.eTx.getPbData().aRB() : 0;
            c pM = pM(id);
            if (pM != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(aUn, id, "pb", true, null, false, null, aRB, postData.aYe(), this.eTx.getPbData().qg(), false, postData.rv() != null ? postData.rv().getIconInfo() : null).addBigImageData(pM.eVo, pM.eVp, pM.eVq, pM.index);
                addBigImageData.setKeyPageStartFrom(this.eTx.aUU());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        ao aoVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (aSx() != null && aSx().getPbData() != null && aSx().getPbData().aRM() != null) {
                com.baidu.tieba.pb.data.l aRM = aSx().getPbData().aRM();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof ao)) {
                    aoVar = null;
                } else {
                    aoVar = (ao) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aRM != null) {
                    int i3 = -1;
                    if (z) {
                        aRM.pK(i);
                    } else if (aRM.aRW()) {
                        aRM.aRZ();
                        i3 = 1;
                    } else {
                        aRM.pM(i);
                        i3 = 0;
                    }
                    aRM.pL(i2);
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pU(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.eTx != null && this.eTx.aUN() != null) {
                        String str = "";
                        if (this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null) {
                            str = this.eTx.getPbData().aRq().rM();
                        }
                        if (this.eTx.getPbData() != null) {
                            this.eTx.getPbData().a(aRM);
                        }
                        if (z) {
                            this.eTx.aUN().a(str, 3, i, this.eTx.getForumId(), aVar);
                        } else {
                            this.eTx.aUN().a(str, i3, 3, i, this.eTx.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.eQf = i3;
                            kVar.eQg = aRM;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (aoVar != null) {
                        aoVar.b(aRM);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aSW() {
        if (this.eTx.getPbData() == null || this.eTx.getPbData().aRq() == null) {
            return -1;
        }
        return this.eTx.getPbData().aRq().rZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSX() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.qk(this.eTx.getForumId()) && this.eTx.getPbData() != null && this.eTx.getPbData().aRo() != null) {
            if (this.eTx.getPbData().aRo().isLike() == 1) {
                aTn();
                this.eTx.aUQ().bK(this.eTx.getForumId(), this.eTx.aUn());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jf(boolean z) {
        if (this.eTx == null || this.eTx.getPbData() == null) {
            return false;
        }
        return ((this.eTx.getPbData().aRB() != 0) || this.eTx.getPbData().aRq() == null || this.eTx.getPbData().aRq().rv() == null || TextUtils.equals(this.eTx.getPbData().aRq().rv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aSY() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.o.q.GV()) {
            return "";
        }
        PostData aRx = aRx();
        if (this.eTx == null || (pbData = this.eTx.getPbData()) == null || pbData.getUserData() == null || pbData.aRq() == null || aRx == null || aRx.rv() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aRx.rv().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aRq().rd() == 0) {
            return "";
        }
        if (pbData.aRq().rd() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean jg(boolean z) {
        if (z) {
            return true;
        }
        if (this.eTx == null || this.eTx.getPbData() == null) {
            return false;
        }
        return this.eTx.getPbData().aRB() != 0;
    }

    private boolean jh(boolean z) {
        return (z || this.eTx == null || this.eTx.getPbData() == null || this.eTx.getPbData().aRB() == 0) ? false : true;
    }

    public void aSZ() {
        if (this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null && this.eTx.getPbData().aRq().rv() != null) {
            if (this.eTy != null) {
                this.eTy.aVL();
            }
            bd aRq = this.eTx.getPbData().aRq();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aRq.rv().getUserId());
            aRq.rv().getGodUserData();
            ab abVar = new ab();
            int aRB = this.eTx.getPbData().aRB();
            if (aRB == 1) {
                abVar.eZX = true;
                abVar.eZW = true;
                abVar.fae = aRq.rq() == 1;
                abVar.fad = aRq.rr() == 1;
            } else {
                abVar.eZX = false;
                abVar.eZW = false;
            }
            if (aRB == 1002 && !equals) {
                abVar.fai = true;
            }
            abVar.eZT = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            abVar.eZY = jg(equals);
            abVar.eZZ = aTa();
            abVar.faa = jh(equals);
            abVar.eZU = this.eTx.aUo();
            abVar.eZV = true;
            abVar.eQu = this.eus != null && this.eus.nH();
            abVar.eZS = jf(equals);
            abVar.fag = aSY();
            abVar.eZR = equals && this.eTy.aWr();
            abVar.fab = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fac = true;
            abVar.isHostOnly = this.eTx.getHostMode();
            abVar.faf = true;
            if (aRq.rN() == null) {
                abVar.fah = true;
            } else {
                abVar.fah = false;
            }
            this.eTy.fbO.a(abVar);
        }
    }

    private boolean aTa() {
        if (this.eTx != null && this.eTx.aUo()) {
            return this.eTx.avJ() == null || this.eTx.avJ().qv() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(View view) {
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

    public int aTb() {
        if (aSR() == null || aSR().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aSR().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) fVar).mType == com.baidu.tieba.pb.data.j.eQb) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aTc() {
        if (aSR() == null || aSR().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aSR().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.gBT) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aTl();
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
            aVar.b(getResources().getString(d.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ac("obj_id", metaData.getUserId()).r("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ac("obj_id", metaData.getUserId()).r("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.apx.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.eTx.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).th();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.eTy.aWk();
        this.eTx.jx(z);
        if (this.eus != null) {
            this.eus.ab(z);
            if (markData != null) {
                this.eus.a(markData);
            }
        }
        if (this.eTx.nH()) {
            aTi();
        } else {
            this.eTy.p(this.eTx.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pP(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(String str) {
        if (!StringUtils.isNull(str) && this.eTx != null) {
            String aUn = this.eTx.aUn();
            String id = this.eTx.getPbData().aRo().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + aUn + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.eTx.aUu()) {
                    antiData.setBlock_forum_name(this.eTx.getPbData().aRo().getName());
                    antiData.setBlock_forum_id(this.eTx.getPbData().aRo().getId());
                    antiData.setUser_name(this.eTx.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eTx.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.uB(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahN));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahN));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahN));
            }
        } else if (i == 230277) {
            gc(str);
        } else {
            this.eTy.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eTy.a(0, bVar.Aj, bVar.gEn, z);
            if (bVar.Aj) {
                if (bVar.gEl == 1) {
                    ArrayList<PostData> aRs = this.eTx.getPbData().aRs();
                    int size = aRs.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aRs.get(i).getId())) {
                            i++;
                        } else {
                            aRs.remove(i);
                            break;
                        }
                    }
                    this.eTy.p(this.eTx.getPbData());
                } else if (bVar.gEl == 0) {
                    aTd();
                } else if (bVar.gEl == 2) {
                    ArrayList<PostData> aRs2 = this.eTx.getPbData().aRs();
                    int size2 = aRs2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aRs2.get(i2).bwS().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aRs2.get(i2).bwS().get(i3).getId())) {
                                i3++;
                            } else {
                                aRs2.get(i2).bwS().remove(i3);
                                aRs2.get(i2).bwU();
                                z2 = true;
                                break;
                            }
                        }
                        aRs2.get(i2).te(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eTy.p(this.eTx.getPbData());
                    }
                    a(bVar, this.eTy);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.eTy.a(this.cbL.getLoadDataMode(), gVar.Aj, gVar.gEn, false);
            if (gVar.Aj) {
                this.eTA = true;
                if (i == 2 || i == 3) {
                    this.eTB = true;
                    this.eTC = false;
                } else if (i == 4 || i == 5) {
                    this.eTB = false;
                    this.eTC = true;
                }
                if (i == 2) {
                    this.eTx.getPbData().aRq().bT(1);
                    this.eTx.setIsGood(1);
                } else if (i == 3) {
                    this.eTx.getPbData().aRq().bT(0);
                    this.eTx.setIsGood(0);
                } else if (i == 4) {
                    this.eTx.getPbData().aRq().bS(1);
                    this.eTx.iQ(1);
                } else if (i == 5) {
                    this.eTx.getPbData().aRq().bS(0);
                    this.eTx.iQ(0);
                }
                this.eTy.c(this.eTx.getPbData(), this.eTx.aUo());
                if (this.eTx.getPbData().aRB() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void aTd() {
        if (this.eTx.aUp() || this.eTx.aUr()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eTx.aUn());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eTx.aUn()));
        if (aTj()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTe() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aRy;
        boolean z = true;
        if (this.eTy != null) {
            this.eTy.aWx();
        }
        if (this.eTx != null && this.eTx.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eTx.getPbData().aRq().getId();
            if (this.eTx.isShareThread() && this.eTx.getPbData().aRq().aaF != null) {
                historyMessage.threadName = this.eTx.getPbData().aRq().aaF.showText;
            } else {
                historyMessage.threadName = this.eTx.getPbData().aRq().getTitle();
            }
            if (this.eTx.isShareThread() && !aTD()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.eTx.getPbData().aRo().getName();
            }
            ArrayList<PostData> aRs = this.eTx.getPbData().aRs();
            int aWm = this.eTy != null ? this.eTy.aWm() : 0;
            if (aRs != null && aWm >= 0 && aWm < aRs.size()) {
                historyMessage.postID = aRs.get(aWm).getId();
            }
            historyMessage.isHostOnly = this.eTx.getHostMode();
            historyMessage.isSquence = this.eTx.aUo();
            historyMessage.isShareThread = this.eTx.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eTL != null) {
            this.eTL.onDestroy();
        }
        if (this.eTg && aSR() != null) {
            aSR().aWR();
        }
        if (this.eTx != null && (this.eTx.aUp() || this.eTx.aUr())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eTx.aUn());
            if (this.eTA) {
                if (this.eTC) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.eTx.aUt());
                }
                if (this.eTB) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.eTx.getIsGood());
                }
            }
            if (this.eTx.getPbData() != null && System.currentTimeMillis() - this.eTk >= 40000 && (aRy = this.eTx.getPbData().aRy()) != null && !com.baidu.tbadk.core.util.v.w(aRy.getDataList())) {
                intent.putExtra("guess_like_data", aRy);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.eTZ);
            }
            setResult(-1, intent);
        }
        if (aTj()) {
            if (this.eTx != null && this.eTy != null && this.eTy.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eTx.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aRw() && !this.eTq) {
                        ai aVw = ai.aVw();
                        com.baidu.tieba.pb.data.f pbData2 = this.eTx.getPbData();
                        Parcelable onSaveInstanceState = this.eTy.getListView().onSaveInstanceState();
                        boolean aUo = this.eTx.aUo();
                        boolean hostMode = this.eTx.getHostMode();
                        if (this.eTy.aVV() == null || this.eTy.aVV().getVisibility() != 0) {
                            z = false;
                        }
                        aVw.a(pbData2, onSaveInstanceState, aUo, hostMode, z);
                        if (this.eTY >= 0 || this.eTx.aUW() != null) {
                            ai.aVw().j(this.eTx.aUW());
                            ai.aVw().i(this.eTx.aUX());
                            ai.aVw().qk(this.eTx.aUY());
                        }
                    }
                }
            } else {
                ai.aVw().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eTy == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eTy.qn(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pR(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.eTy.aVL();
            this.eTy.aVN().aUb();
            this.eTy.jW(false);
        }
        this.eTy.aVO();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.eTL.resetData();
                        this.eTL.b(writeData);
                        this.eTL.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.r eP = this.eTL.De().eP(6);
                        if (eP != null && eP.aBW != null) {
                            eP.aBW.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.eTL.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.eTy.aVN() != null && this.eTy.aVN().aUd() != null) {
                            com.baidu.tbadk.editortools.pb.h aUd = this.eTy.aVN().aUd();
                            aUd.b(writeData);
                            aUd.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.r eP2 = aUd.De().eP(6);
                            if (eP2 != null && eP2.aBW != null) {
                                eP2.aBW.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                aUd.DW();
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.eTL.onActivityResult(i, i2, intent);
        if (this.eTu != null) {
            this.eTu.onActivityResult(i, i2, intent);
        }
        if (aSR().aVN() != null) {
            aSR().aVN().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    aTh();
                    return;
                case 13008:
                    ai.aVw().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eTx != null) {
                                PbActivity.this.eTx.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eTx != null) {
                        a(aTg(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    K(intent);
                    return;
                case 24006:
                    S(intent);
                    return;
                case 24007:
                    if (aSW() == 1) {
                        aTf();
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aSX();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.cWV != null && shareItem != null && shareItem.linkUrl != null) {
                            this.cWV.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void zM() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51.1
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
                    this.eTy.jd(false);
                    if (this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null && this.eTx.getPbData().aRq().rQ() != null) {
                        this.eTx.getPbData().aRq().rQ().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.eTy != null && this.eTy.fbO != null) {
                        this.eTy.fbO.or();
                        this.eTy.fbO.aXk();
                        if (this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null) {
                            this.eTx.getPbData().aRq().bO(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.eTv != null) {
                        this.eTy.bn(this.eTv);
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
            if (this.eTu == null) {
                this.eTu = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.eTu.b(this.aDO);
                this.eTu.c(this.aDV);
            }
            this.eTu.a(emotionImageData, aSx(), aSx().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTf() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null && this.eTx.getPbData().aRq().rH() != null && this.eTx.getPbData().aRq().rH().size() > 0 && this.eTx.getPbData().aRq().rH().get(0) != null) {
            this.mAwardActId = this.eTx.getPbData().aRq().rH().get(0).ps();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eTx.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void S(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    pT(2);
                    return;
                case 2:
                    this.eTy.aWc();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aTg() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bM = this.eTx.getPbData().bM(getPageContext().getPageActivity());
        PostData aVQ = this.eTy.aVQ();
        String str = "";
        if (aVQ != null) {
            str = aVQ.getId();
            String ce = aVQ.ce(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ce)) {
                bM[1] = ce;
            }
        }
        String rM = this.eTx.getPbData().aRq().rM();
        if (rM != null && rM.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bM[1]);
        shareFromPBMsgData.setImageUrl(bM[0]);
        shareFromPBMsgData.setForumName(this.eTx.getPbData().aRo().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eTx.getPbData().aRq().getId());
        shareFromPBMsgData.setTitle(this.eTx.getPbData().aRq().getTitle());
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(aTg(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(getPageContext().getPageActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ac = new com.baidu.tbadk.core.util.ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTx.getForumId()).ac("tid", PbActivity.this.eTx.aUn());
                        if (PbActivity.this.e(PbActivity.this.eTx.getPbData()) != 0) {
                            ac.r("obj_type", PbActivity.this.e(PbActivity.this.eTx.getPbData()));
                        }
                        TiebaStatic.log(ac);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aSW() == 1) {
                        PbActivity.this.aTf();
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
                kVar.I(shareFromPBMsgData.getImageUrl(), this.eTx.getPbData().aRC() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(getPageContext().getPageActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aSW() == 1) {
                        PbActivity.this.aTf();
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
                kVar.I(shareFromPBMsgData.getImageUrl(), this.eTx.getPbData().aRC() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTh() {
        MarkData qh;
        if (this.eus != null && (qh = this.eTx.qh(this.eTy.aWn())) != null) {
            if (!qh.isApp() || (qh = this.eTx.qh(this.eTy.aWn() + 1)) != null) {
                this.eTy.aWi();
                this.eus.a(qh);
                if (!this.eus.nH()) {
                    this.eus.nJ();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.eus.nI();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTi() {
        com.baidu.tieba.pb.data.f pbData = this.eTx.getPbData();
        this.eTx.jx(true);
        if (this.eus != null) {
            pbData.pG(this.eus.nG());
        }
        this.eTy.p(pbData);
    }

    private boolean aTj() {
        if (this.eTx == null) {
            return true;
        }
        if (this.eTx.nH()) {
            final MarkData aUC = this.eTx.aUC();
            if (aUC == null || !this.eTx.getIsFromMark()) {
                return true;
            }
            final MarkData qh = this.eTx.qh(this.eTy.aWm());
            if (qh == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", aUC);
                setResult(-1, intent);
                return true;
            } else if (qh.getPostId() == null || qh.getPostId().equals(aUC.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", aUC);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cS(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.eus != null) {
                            if (PbActivity.this.eus.nH()) {
                                PbActivity.this.eus.nI();
                                PbActivity.this.eus.ab(false);
                            }
                            PbActivity.this.eus.a(qh);
                            PbActivity.this.eus.ab(true);
                            PbActivity.this.eus.nJ();
                        }
                        aUC.setPostId(qh.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", aUC);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aTe();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", aUC);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aTe();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eTy != null && PbActivity.this.eTy.getView() != null) {
                            PbActivity.this.eTy.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", aUC);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aTe();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.th();
                return false;
            }
        } else if (this.eTx.getPbData() == null || this.eTx.getPbData().aRs() == null || this.eTx.getPbData().aRs().size() <= 0 || !this.eTx.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eTy == null) {
            return null;
        }
        return this.eTy.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int JW() {
        if (this.eTy == null) {
            return 0;
        }
        return this.eTy.aWv();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> JX() {
        if (this.aVA == null) {
            this.aVA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: YR */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean pe = com.baidu.tbadk.core.h.oY().pe();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.C0095d.common_color_10220));
                    if (pe) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0095d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView o(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.h.oY().pe()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0095d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aVA;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> JY() {
        if (this.aVB == null) {
            this.aVB = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aVB;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> JZ() {
        if (this.aVF == null) {
            this.aVF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTF */
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
                    gifView.release();
                    return gifView;
                }
            }, 20, 0);
        }
        return this.aVF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Ka() {
        if (this.aVC == null) {
            this.aVC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTG */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bh */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bi */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bj */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aVC;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Kc() {
        this.aVE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aTH */
            public RelativeLayout fI() {
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
        return this.aVE;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aoU == null) {
            this.aoU = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoU;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eTo = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        if (aw.pX(str) && this.eTx != null && this.eTx.aUn() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").r("obj_param1", 1).ac("post_id", this.eTx.aUn()));
        }
        aw.aXa().f(getPageContext(), str);
        this.eTo = true;
    }

    private com.baidu.tbadk.core.dialog.a aTk() {
        if (this.eTj == null) {
            this.eTj = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eTj.cR(getPageContext().getString(d.j.download_baidu_video_dialog));
            this.eTj.a(getPageContext().getString(d.j.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
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
            this.eTj.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eTj.ao(true);
            this.eTj.b(getPageContext());
            this.eTj.ap(false);
        }
        this.eTj.th();
        return this.eTj;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        aw.aXa().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eTo = true;
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
            aTk();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eTo = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eTx.getPbData();
            TbRichText au = au(str, i);
            if (au != null && (tbRichTextData = au.Jr().get(this.eUC)) != null) {
                cVar.eVo = new ArrayList<>();
                cVar.eVp = new ConcurrentHashMap<>();
                if (!tbRichTextData.Jx().JJ()) {
                    cVar.eVr = false;
                    String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                    cVar.eVo.add(b2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (com.baidu.tbadk.o.ak.fS()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = au.getPostId();
                    imageUrlData.mIsReserver = this.eTx.aUB();
                    imageUrlData.mIsSeeHost = this.eTx.getHostMode();
                    cVar.eVp.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aRo() != null) {
                            cVar.forumName = pbData.aRo().getName();
                            cVar.forumId = pbData.aRo().getId();
                        }
                        if (pbData.aRq() != null) {
                            cVar.threadId = pbData.aRq().getId();
                        }
                        cVar.eVq = pbData.aRC() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.eVr = true;
                int size = pbData.aRs().size();
                this.eUD = false;
                cVar.index = -1;
                if (pbData.aRx() != null) {
                    PostData aRx = pbData.aRx();
                    TbRichText bwY = aRx.bwY();
                    if (!aq.k(aRx)) {
                        i2 = a(bwY, au, i, i, cVar.eVo, cVar.eVp);
                    } else {
                        i2 = a(aRx, i, cVar.eVo, cVar.eVp);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aRs().get(i4);
                    if (postData.getId() == null || pbData.aRx() == null || pbData.aRx().getId() == null || !postData.getId().equals(pbData.aRx().getId())) {
                        TbRichText bwY2 = postData.bwY();
                        if (!aq.k(postData)) {
                            i3 = a(bwY2, au, i3, i, cVar.eVo, cVar.eVp);
                        } else {
                            i3 = a(postData, i3, cVar.eVo, cVar.eVp);
                        }
                    }
                }
                if (cVar.eVo.size() > 0) {
                    cVar.lastId = cVar.eVo.get(cVar.eVo.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aRo() != null) {
                        cVar.forumName = pbData.aRo().getName();
                        cVar.forumId = pbData.aRo().getId();
                    }
                    if (pbData.aRq() != null) {
                        cVar.threadId = pbData.aRq().getId();
                    }
                    cVar.eVq = pbData.aRC() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Jx() == null) {
            return null;
        }
        return tbRichTextData.Jx().JN();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Jx() == null) {
            return 0L;
        }
        return tbRichTextData.Jx().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Jx() == null) {
            return false;
        }
        return tbRichTextData.Jx().JO();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Jx() == null) {
            return false;
        }
        return tbRichTextData.Jx().JP();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Jx;
        if (tbRichText == tbRichText2) {
            this.eUD = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Jr().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Jr().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int af = (int) com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.Jx().getWidth() * af;
                    int height = af * tbRichTextData.Jx().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.Jx().JJ()) {
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
                            if (tbRichTextData != null && (Jx = tbRichTextData.Jx()) != null) {
                                String JL = Jx.JL();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = JL;
                                if (com.baidu.tbadk.o.ak.fS()) {
                                    imageUrlData.urlType = 38;
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                }
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eTx.aUn(), -1L);
                                imageUrlData.mIsReserver = this.eTx.aUB();
                                imageUrlData.mIsSeeHost = this.eTx.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eUD) {
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
        com.baidu.tieba.tbadkCore.data.h bxe;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bwB;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bwB = (bxe = postData.bxe()).bwB()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bwB.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bwB.get(i3);
                if (jVar != null) {
                    String bwF = jVar.bwF();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bwF)) {
                        arrayList.add(bwF);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bwF;
                        if (com.baidu.tbadk.o.ak.fS()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bwE();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eTx.aUn(), -1L);
                        imageUrlData.mIsReserver = this.eTx.aUB();
                        imageUrlData.mIsSeeHost = this.eTx.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bxe.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bwF, imageUrlData);
                        }
                        if (!this.eUD) {
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
            if (postData.getId() != null && postData.getId().equals(this.eTx.rF())) {
                z = true;
            }
            MarkData h = this.eTx.h(postData);
            if (h != null) {
                this.eTy.aWi();
                if (this.eus != null) {
                    this.eus.a(h);
                    if (!z) {
                        this.eus.nJ();
                    } else {
                        this.eus.nI();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText au(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eTx == null || this.eTx.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eTx.getPbData();
        if (pbData.aRx() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aRx());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aRs = pbData.aRs();
            a(pbData, aRs);
            return a(aRs, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aRA() != null && fVar.aRA().eQw != null && (list = fVar.aRA().eQw) != null && arrayList != null) {
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

    private long pK(String str) {
        ArrayList<PostData> aRs;
        com.baidu.tieba.pb.data.f pbData = this.eTx.getPbData();
        if (pbData != null && (aRs = pbData.aRs()) != null && !aRs.isEmpty()) {
            Iterator<PostData> it = aRs.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bxe = next.bxe();
                if (bxe != null && bxe.gBB) {
                    Iterator<TbRichTextData> it2 = next.bwY().Jr().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.JG().getLink().equals(str)) {
                            return bxe.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Jr;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bwY = arrayList.get(i2).bwY();
            if (bwY != null && (Jr = bwY.Jr()) != null) {
                int size = Jr.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Jr.get(i4) != null && Jr.get(i4).getType() == 8) {
                        i3++;
                        if (Jr.get(i4).Jx().JL().equals(str) || Jr.get(i4).Jx().JI().equals(str)) {
                            int af = (int) com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
                            int width = Jr.get(i4).Jx().getWidth() * af;
                            int height = Jr.get(i4).Jx().getHeight() * af;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eUC = i4;
                            return bwY;
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
    public void f(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.eSL = str;
            if (this.eTi == null) {
                aST();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eTi.cl(1).setVisibility(8);
            } else {
                this.eTi.cl(1).setVisibility(0);
            }
            this.eTi.tl();
            this.eTo = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cHl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTl() {
        hideNetRefreshView(this.eTy.getView());
        aTm();
        if (this.eTx.Fz()) {
            this.eTy.aWi();
        }
    }

    private void aTm() {
        showLoadingView(this.eTy.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View EU = getLoadingView().EU();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EU.getLayoutParams();
        layoutParams.addRule(3, this.eTy.aWJ().getId());
        EU.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alB() {
        if (this.cHl != null) {
            this.cHl.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void pT(int i) {
        boolean z;
        String str;
        Uri parse;
        if (this.eTx.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eTx.getPbData();
            pbData.aRo().getName();
            String title = pbData.aRq().getTitle();
            int i2 = this.eTx.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aRo() != null) {
                if ((pbData.aRo().isLike() == 1) && AddExperiencedModel.qk(pbData.getForumId())) {
                    z = true;
                    String str2 = "http://tieba.baidu.com/p/" + this.eTx.aUn() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bM = pbData.bM(getPageContext().getPageActivity());
                    str = bM[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    String str3 = bM[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aSW() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac("uid", currentAccount));
                    } else if (aSW() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac("uid", currentAccount));
                    }
                    String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str3);
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = format;
                    dVar.linkUrl = str2;
                    dVar.auz = true;
                    dVar.auD = z;
                    dVar.extData = this.eTx.aUn();
                    dVar.auN = 3;
                    dVar.auM = i;
                    dVar.fid = this.eTx.getForumId();
                    dVar.tid = this.eTx.aUn();
                    dVar.auO = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.auH = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.eTx.getPbData().aRq());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.auN);
                    bundle.putInt("obj_type", dVar.auO);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.e(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRN()) {
                                PbActivity.this.eTy.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    if (this.anY == null) {
                        this.anY = new com.baidu.tieba.d.c(getActivity());
                    }
                    this.anY.a(shareDialogConfig);
                }
            }
            z = false;
            String str22 = "http://tieba.baidu.com/p/" + this.eTx.aUn() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bM2 = pbData.bM(getPageContext().getPageActivity());
            str = bM2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            String str32 = bM2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aSW() != 1) {
            }
            String format2 = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str32);
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = format2;
            dVar2.linkUrl = str22;
            dVar2.auz = true;
            dVar2.auD = z;
            dVar2.extData = this.eTx.aUn();
            dVar2.auN = 3;
            dVar2.auM = i;
            dVar2.fid = this.eTx.getForumId();
            dVar2.tid = this.eTx.aUn();
            dVar2.auO = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.eTx.getPbData().aRq());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.auN);
            bundle2.putInt("obj_type", dVar2.auO);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.e(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.eTx != null && PbActivity.this.eTx.getPbData() != null && PbActivity.this.eTx.getPbData().aRN()) {
                        PbActivity.this.eTy.getView().setSystemUiVisibility(4);
                    }
                }
            });
            if (this.anY == null) {
            }
            this.anY.a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aRq() != null) {
            if (fVar.aRq().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aRq().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void aTn() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.ql(PbActivity.this.eTx.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eTy.aWS();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Kb() {
        if (this.aVD == null) {
            this.aVD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTI */
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
        return this.aVD;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eTy.aWd() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, this.eTx.getPbData().getForumId()));
            } else {
                bd aRq = this.eTx.getPbData().aRq();
                if (view != null) {
                    boolean z = aRq.rk() == null || aRq.rk().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eUo > 1000) {
                            this.eUp = true;
                            bg(view);
                        } else {
                            this.eUp = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            m(view, this.eUp);
                        } else {
                            l(view, this.eUp);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        l(view, this.eUp);
                    } else if (motionEvent.getAction() == 3) {
                        l(view, this.eUp);
                    }
                }
            }
        }
        return false;
    }

    private void l(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eUo = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void m(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eUo = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bg(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    public void alC() {
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
            int intValue = ((Integer) sparseArray.get(ar.fdD)).intValue();
            if (intValue == ar.fdE) {
                if (!this.cbL.bxJ()) {
                    this.eTy.aWf();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cbL.a(this.eTx.getPbData().aRo().getId(), this.eTx.getPbData().aRo().getName(), this.eTx.getPbData().aRq().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ar.fdF || intValue == ar.fdH) {
                if (this.eTx.aUM() != null) {
                    this.eTx.aUM().pX(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.fdF) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ar.fdG) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eUI).pn()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eTS);
        userMuteAddAndDelCustomMessage.setTag(this.eTS);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pL(String str) {
        if (!StringUtils.isNull(str) && ax.aS(getPageContext().getPageActivity())) {
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

    public void ji(boolean z) {
        this.eTG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aTo() {
        ArrayList<PostData> aRs;
        int v;
        if (this.eTx == null || this.eTx.getPbData() == null || this.eTx.getPbData().aRs() == null || (v = com.baidu.tbadk.core.util.v.v((aRs = this.eTx.getPbData().aRs()))) == 0) {
            return "";
        }
        if (this.eTx.aUB()) {
            Iterator<PostData> it = aRs.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bwV() == 1) {
                    return next.getId();
                }
            }
        }
        int aWm = this.eTy.aWm();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aRs, aWm);
        if (postData == null || postData.rv() == null) {
            return "";
        }
        if (this.eTx.pP(postData.rv().getUserId())) {
            return postData.getId();
        }
        for (int i = aWm - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aRs, i);
            if (postData2 == null || postData2.rv() == null || postData2.rv().getUserId() == null) {
                break;
            } else if (this.eTx.pP(postData2.rv().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aWm + 1; i2 < v; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aRs, i2);
            if (postData3 == null || postData3.rv() == null || postData3.rv().getUserId() == null) {
                return "";
            }
            if (this.eTx.pP(postData3.rv().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.av.vI().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(pK(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eTx.getPbData().aRo().getId(), this.eTx.getPbData().aRo().getName(), this.eTx.getPbData().aRq().getTid());
            }
            this.eTo = true;
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
        aVar.a(getResources().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eTx.aUL() != null) {
                    PbActivity.this.eTx.aUL().cx(j);
                }
            }
        });
        aVar.b(getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
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
    public c pM(String str) {
        String str2;
        if (this.eTx.getPbData() == null || this.eTx.getPbData().aRs() == null || this.eTx.getPbData().aRs().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.eTx.getPbData().aRs().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eTx.getPbData().aRs().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eTx.getPbData().aRs().get(i);
        if (postData.bwY() == null || postData.bwY().Jr() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bwY().Jr().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Jx() != null) {
                    str2 = next.Jx().JL();
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
        if (this.eTe) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eTe = false;
        } else if (aTp()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eTe) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eTe = false;
        } else if (aTp()) {
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
        if (pageStayDurationItem != null && this.eTx != null) {
            if (this.eTx.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eTx.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eTx.aUn(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aTp() {
        return (!this.eTc && this.eUK == -1 && this.eUL == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.eUN = mVar;
            this.eTc = true;
            this.eTy.aVW();
            this.eTy.pV(this.eUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTq() {
        if (this.eUN != null) {
            if (this.eUK == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aR(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eUN.getCartoonId(), this.eUK, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTr() {
        if (this.eUN != null) {
            if (this.eUL == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aR(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eUN.getCartoonId(), this.eUL, 0)));
                finish();
            }
        }
    }

    public int aTs() {
        return this.eUK;
    }

    public int aTt() {
        return this.eUL;
    }

    private void ave() {
        if (this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null && this.eTx.getPbData().aRq().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aTu() {
        if (this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null && this.eTx.getPbData().aRq().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aTv() {
        if (this.eTf) {
            this.eTt = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null && this.eTx.getPbData().aRq().rb() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eTx.getPbData().aRq().rb().getThreadId(), this.eTx.getPbData().aRq().rb().getTaskId(), this.eTx.getPbData().aRq().rb().getForumId(), this.eTx.getPbData().aRq().rb().getForumName(), this.eTx.getPbData().aRq().rq(), this.eTx.getPbData().aRq().rr())));
            this.eTe = true;
            finish();
        }
    }

    public boolean aTw() {
        return this.eTf;
    }

    public String aTx() {
        return this.eTr;
    }

    public PbInterviewStatusView.a aTy() {
        return this.eTw;
    }

    public void jj(boolean z) {
        this.eTs = z;
    }

    public boolean aTz() {
        if (this.eTx != null) {
            return this.eTx.aUp();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eTQ).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eTQ.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eTQ).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eTQ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eTQ.getPageActivity());
            aVar.cS(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eTQ).th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eTy.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eTQ.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cS(this.eTQ.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eTy.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eTQ).th();
    }

    public void aTB() {
        if (this.eTx != null && this.eTx.getPbData() != null && this.eTx.getPbData().aRq() != null && this.eTx.getPbData().aRq().sA() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cd(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eTx.getPbData().aRq().sA().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
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

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (aw.pX(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.eTy != null) {
            this.eTy.onConfigurationChanged(configuration);
        }
        if (this.eTE != null) {
            this.eTE.dismiss();
        }
    }

    public boolean aTC() {
        if (this.eTx != null) {
            return this.eTx.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.eTx.getPbData().aRA().eQw;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bwS().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bwS().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bwS().remove(i2);
                    list.get(i).bwU();
                    z = true;
                    break;
                }
            }
            list.get(i).te(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.p(this.eTx.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aSc().getId();
        List<PostData> list = this.eTx.getPbData().aRA().eQw;
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
                ArrayList<PostData> aSg = mVar.aSg();
                postData.uv(mVar.getTotalCount());
                if (postData.bwS() != null) {
                    postData.bwS().clear();
                    postData.bwS().addAll(aSg);
                }
            }
        }
        if (!this.eTx.getIsFromMark()) {
            this.eTy.p(this.eTx.getPbData());
        }
    }

    public boolean aTD() {
        if (this.eTx == null) {
            return false;
        }
        return this.eTx.aTD();
    }

    public void aTE() {
        if (this.eTy != null) {
            this.eTy.aVL();
            alC();
        }
    }

    public PostData aRx() {
        return this.eTy.b(this.eTx.eYp, this.eTx.aUo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Z(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.isLinkThread()) {
                return 3;
            }
            if (bdVar.sC()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eUa != null && !this.eUa.isEmpty()) {
            int size = this.eUa.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.eUa.get(i).onBackPressed()) {
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
            if (this.eUa == null) {
                this.eUa = new ArrayList();
            }
            if (!this.eUa.contains(aVar)) {
                this.eUa.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.eUa != null) {
            this.eUa.remove(aVar);
        }
    }
}
