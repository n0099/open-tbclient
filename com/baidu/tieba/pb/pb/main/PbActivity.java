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
import com.baidu.tbadk.core.view.g;
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
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.e {
    private com.baidu.adp.lib.e.b<GifView> aVA;
    private com.baidu.adp.lib.e.b<ImageView> aVv;
    private com.baidu.adp.lib.e.b<TextView> aVw;
    private com.baidu.adp.lib.e.b<View> aVx;
    private com.baidu.adp.lib.e.b<LinearLayout> aVy;
    private com.baidu.adp.lib.e.b<RelativeLayout> aVz;
    private com.baidu.tieba.d.c anT;
    private com.baidu.adp.lib.e.b<TbImageView> aoO;
    private com.baidu.tieba.e.b bHH;
    private VoiceManager cGZ;
    private String eRD;
    private com.baidu.tieba.pb.pb.main.a.b eRV;
    private com.baidu.tieba.tbadkCore.data.e eSB;
    private com.baidu.tbadk.editortools.pb.g eSC;
    private com.baidu.tbadk.editortools.pb.d eSD;
    private com.baidu.adp.base.e eSI;
    private com.baidu.tbadk.core.view.c eSJ;
    private BdUniqueId eSK;
    private Runnable eSL;
    private av eSM;
    private com.baidu.adp.widget.a.a eSN;
    private String eSO;
    private TbRichTextMemeInfo eSP;
    private List<a> eSS;
    private com.baidu.tbadk.core.dialog.a eSb;
    private com.baidu.tieba.pb.pb.main.emotion.model.a eSm;
    private View eSn;
    public at eSv;
    private y eSw;
    private boolean eSy;
    private String eTE;
    private com.baidu.tbadk.core.data.m eTF;
    private boolean eTs;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eRU = false;
    private boolean eRW = false;
    private boolean eRX = false;
    private boolean evU = false;
    private boolean eRY = true;
    private int eRZ = 0;
    private com.baidu.tbadk.core.dialog.b eSa = null;
    private long ctl = -1;
    private long aKs = 0;
    private long eSc = 0;
    private long createTime = 0;
    private long aKk = 0;
    private boolean eSd = false;
    private com.baidu.tbadk.k.d eSe = null;
    private long eSf = 0;
    private boolean eSg = false;
    private long eSh = 0;
    private String aDD = null;
    private boolean eSi = false;
    private boolean isFullScreen = false;
    private String eSj = "";
    private boolean eSk = true;
    private boolean eSl = false;
    private String source = "";
    private PbInterviewStatusView.a eSo = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eSq.jO(!PbActivity.this.eSk);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eSp != null && PbActivity.this.eSp.nJ()) {
                        PbActivity.this.aSZ();
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahS));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahS));
        }
    };
    private PbModel eSp = null;
    private com.baidu.tbadk.baseEditMark.a etk = null;
    private ForumManageModel cbD = null;
    private com.baidu.tbadk.coreExtra.model.a apr = null;
    private ShareSuccessReplyToServerModel cWG = null;
    private ar eSq = null;
    public final com.baidu.tieba.pb.pb.main.a.a eSr = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eSs = false;
    private boolean eSt = false;
    private boolean eSu = false;
    private boolean eSx = false;
    private boolean eSz = false;
    private boolean eSA = false;
    private boolean eSE = false;
    public boolean eSF = false;
    private com.baidu.tbadk.editortools.pb.c aDG = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void DA() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDH = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Dz() {
            if (PbActivity.this.eSv == null || PbActivity.this.eSv.aWN() == null || !PbActivity.this.eSv.aWN().bEU()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eSv.aWN().bEW());
            if (PbActivity.this.eSD != null && (PbActivity.this.eSD.DO() || PbActivity.this.eSD.DP())) {
                PbActivity.this.eSD.a(false, PbActivity.this.eSv.aWQ());
            }
            PbActivity.this.eSv.jZ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b eSG = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Dz() {
            if (PbActivity.this.eSv == null || PbActivity.this.eSv.aWO() == null || !PbActivity.this.eSv.aWO().bEU()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eSv.aWO().bEW());
            if (PbActivity.this.eSq != null && PbActivity.this.eSq.aVE() != null && PbActivity.this.eSq.aVE().aTW() != null && PbActivity.this.eSq.aVE().aTW().DP()) {
                PbActivity.this.eSq.aVE().aTW().a(PbActivity.this.eSv.aWQ());
            }
            PbActivity.this.eSv.ka(true);
            return true;
        }
    };
    private boolean eSH = false;
    private int mLastScrollState = -1;
    private boolean cHE = false;
    private int eSQ = 0;
    private int eSR = -1;
    private final z.a eST = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void C(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eSq.showToast(str);
            }
        }
    };
    private final CustomMessageListener eSU = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eSp != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eSD != null) {
                    PbActivity.this.eSq.jT(PbActivity.this.eSD.DH());
                }
                PbActivity.this.eSq.aVF();
                PbActivity.this.eSq.aWo();
            }
        }
    };
    CustomMessageListener cHU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                PbActivity.this.eSp.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                if (PbActivity.this.eSq != null && PbActivity.this.eSp != null) {
                    PbActivity.this.eSq.d(PbActivity.this.eSp.getPbData(), PbActivity.this.eSp.aUf(), PbActivity.this.eSp.aUx());
                }
                if (PbActivity.this.eSq != null && PbActivity.this.eSq.aVV() != null) {
                    PbActivity.this.eSq.aVV().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eSV = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eSq != null) {
                    if (booleanValue) {
                        PbActivity.this.eSq.aBn();
                    } else {
                        PbActivity.this.eSq.aBm();
                    }
                }
            }
        }
    };
    private CustomMessageListener eSW = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eSD != null) {
                    PbActivity.this.eSq.jT(PbActivity.this.eSD.DH());
                }
                PbActivity.this.eSq.jV(false);
            }
        }
    };
    private CustomMessageListener eSX = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
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
    private CustomMessageListener eSY = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eSq != null && PbActivity.this.eSq.aVV() != null) {
                PbActivity.this.eSq.aVV().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dDN = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private j.a eSZ = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.pL(2);
                ai.aVn().reset();
                PbActivity.this.eSp.aUy();
                boolean z2 = false;
                ArrayList<PostData> aRj = PbActivity.this.eSp.getPbData().aRj();
                if (aRj != null) {
                    Iterator<PostData> it = aRj.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.bwx().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eSq.p(PbActivity.this.eSp.getPbData());
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
    private View.OnClickListener aEo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aDD);
        }
    };
    private CustomMessageListener eTa = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x)) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = xVar.id;
                aVar.giftName = xVar.name;
                aVar.WY = xVar.WY;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eSp.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eSp.aUo() != null && PbActivity.this.eSp.aUo().getUserIdLong() == xVar.toUserId) {
                        PbActivity.this.eSq.a(xVar.sendCount, PbActivity.this.eSp.getPbData(), PbActivity.this.eSp.aUf(), PbActivity.this.eSp.aUx());
                    }
                    if (pbData.aRj() != null && pbData.aRj().size() >= 1 && pbData.aRj().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aRj().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eSp.aUe(), 0L);
                        if (c2 == xVar.postId && c3 == xVar.threadId) {
                            com.baidu.tbadk.core.data.am bww = pbData.aRj().get(0).bww();
                            if (bww == null) {
                                bww = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> qz = bww.qz();
                            if (qz == null) {
                                qz = new ArrayList<>();
                            }
                            qz.add(0, aVar);
                            bww.bM(xVar.sendCount + bww.qy());
                            bww.g(qz);
                            pbData.aRj().get(0).a(bww);
                            PbActivity.this.eSq.aVV().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eTb = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.ahF() != null && !aVar.ahF().isEmpty()) {
                    PbActivity.this.eSq.a(aVar, PbActivity.this.eTd);
                }
                PbActivity.this.eSq.a(aVar, PbActivity.this.eSp.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.aWT()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a eTc = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void C(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.w(list) && PbActivity.this.eSq != null) {
                PbActivity.this.eSq.cK(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eTd = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aV(PbActivity.this.getPageContext().getPageActivity());
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
    private boolean eTe = false;
    private PraiseModel eTf = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hY(String str) {
            PbActivity.this.eTe = false;
            if (PbActivity.this.eTf != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eSp.getPbData();
                if (pbData.aRh().rm().getIsLike() == 1) {
                    PbActivity.this.kn(0);
                } else {
                    PbActivity.this.kn(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aRh()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void F(int i, String str) {
            PbActivity.this.eTe = false;
            if (PbActivity.this.eTf != null && str != null) {
                if (AntiHelper.uq(i)) {
                    AntiHelper.an(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eTg = 0;
    private boolean eTh = true;
    private b.a eTi = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jj(boolean z) {
            PbActivity.this.ji(z);
            if (PbActivity.this.eSq.aWz() != null && z) {
                PbActivity.this.eSq.jO(false);
            }
            PbActivity.this.eSq.jQ(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().ask != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().ask, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahS));
                        }
                    } else if (updateAttentionMessage.getData().BJ) {
                        if (PbActivity.this.aRo().rx() != null && PbActivity.this.aRo().rx().getGodUserData() != null) {
                            PbActivity.this.aRo().rx().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRh() != null && PbActivity.this.eSp.getPbData().aRh().rx() != null) {
                            PbActivity.this.eSp.getPbData().aRh().rx().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bHi = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eSq.XB();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.pM(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.asX();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aVF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eSq.aVG()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eSp != null && (PbActivity.this.eSp.getPbData() != null || PbActivity.this.eSp.getPbData().aRD() != null)) {
                    if (PbActivity.this.eSp.getPbData().aRD().aRN()) {
                        if (PbActivity.this.eSp.getPbData().aRD().eOX == 1 || PbActivity.this.eSp.getPbData().aRD().eOX == 3 || PbActivity.this.eSp.getPbData().aRD().eOX == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eSp.getPbData().aRD().aRN() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eSp.getPbData().aRD().aRN() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eSh > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).ku(false);
                        PbActivity.this.eSh = System.currentTimeMillis();
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
                    if (PbActivity.this.aZ(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.eSq != null && PbActivity.this.eSq.aSJ() && (view.getId() == d.g.pb_head_user_info_root || view == PbActivity.this.eSq.aWG())) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ac("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.eSr != null && PbActivity.this.eSr.feR != null) {
                            PbActivity.this.eSr.feR.onClick(view);
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
            if (PbActivity.this.eSD != null) {
                PbActivity.this.eSq.jT(PbActivity.this.eSD.DH());
            }
            PbActivity.this.eSq.aVF();
            PbActivity.this.eSq.aWo();
            return true;
        }
    });
    private CustomMessageListener eTj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eSK) {
                PbActivity.this.eSq.XB();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eSp.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aRu().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eSJ.c(PbActivity.this.eSI.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eSI.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gd(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aTr();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eSI.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.eSJ.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eTk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eSK) {
                PbActivity.this.eSq.XB();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eSJ.c(PbActivity.this.eSI.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eSI.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.eSJ.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eTl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eSK) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eSq.XB();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gML;
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
                    PbActivity.this.eSq.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eTm = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eSq.aVG() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aSo() != null && PbActivity.this.aSo().getPbData() != null && PbActivity.this.aSo().getPbData().aRD() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aRN = PbActivity.this.aSo().getPbData().aRD().aRN();
                if (intValue < 10) {
                    if (aRN) {
                        if (PbActivity.this.eSp.getPbData().aRD().eOX == 1 || PbActivity.this.eSp.getPbData().aRD().eOX == 3 || PbActivity.this.eSp.getPbData().aRD().eOX == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eSp.getPbData().aRD().aRN() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aRN ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eSh > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).ku(false);
                        PbActivity.this.eSh = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aRN, 3);
                TiebaStatic.log(PbActivity.this.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aRN ? 0 : 1));
            }
        }
    };
    private CustomMessageListener cIe = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cHE = true;
                }
            }
        }
    };
    public a.b eFv = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.alt();
            com.baidu.tbadk.core.data.al avA = PbActivity.this.eSp.avA();
            int pageNum = PbActivity.this.eSq.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (avA == null || pageNum <= avA.qr()) {
                PbActivity.this.eSq.aWo();
                PbActivity.this.pL(2);
                PbActivity.this.als();
                PbActivity.this.eSq.aVZ();
                if (com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.eSp.pT(PbActivity.this.eSq.getPageNum());
                    if (PbActivity.this.eRV != null) {
                        PbActivity.this.eRV.showFloatingView();
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
    public final View.OnClickListener cIA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Multi-variable search result rejected for r2v183, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v187, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v224, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v324, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v46, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:689:0x1c23  */
        /* JADX WARN: Removed duplicated region for block: B:716:0x1ded  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String name;
            com.baidu.tieba.pb.data.l aRD;
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
                    if (view == PbActivity.this.eSq.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.eSp.ju(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.eSq.aWa();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aVg()) {
                        if (view == PbActivity.this.eSq.faG.aMn) {
                            if (PbActivity.this.eSq.jS(PbActivity.this.eSp.aUl())) {
                                PbActivity.this.als();
                                return;
                            }
                            PbActivity.this.eRY = false;
                            PbActivity.this.eRW = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eSq.aVX() && (PbActivity.this.eSq.faG.aXd() == null || (view != PbActivity.this.eSq.faG.aXd().aVf() && view != PbActivity.this.eSq.faG.aXd().aVd()))) {
                            if (view == PbActivity.this.eSq.aWr()) {
                                if (PbActivity.this.eSp != null) {
                                    com.baidu.tbadk.browser.a.P(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSp.getPbData().aRh().rw().getLink());
                                }
                            } else if (view != PbActivity.this.eSq.faG.ffD && view.getId() != d.g.view_forum_name_first_floor && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.eSq.faG.ffE) {
                                    if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null) {
                                        ArrayList<PostData> aRj = PbActivity.this.eSp.getPbData().aRj();
                                        if ((aRj == null || aRj.size() <= 0) && PbActivity.this.eSp.aUf()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ac("tid", PbActivity.this.eSp.aUe()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getForumId()));
                                        if (!PbActivity.this.eSq.aWH()) {
                                            PbActivity.this.eSq.aVF();
                                        }
                                        PbActivity.this.aSQ();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aUR()) {
                                        if ((PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aVc()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.eSq.faG.aXd() == null || (view != PbActivity.this.eSq.faG.aXd().getCancelView() && view != PbActivity.this.eSq.faG.aXd().aVb())) {
                                                if (view != PbActivity.this.eSq.faG.ffF && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aUZ()) {
                                                        if ((PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aVi()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aVa()) {
                                                                if (PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aVj()) {
                                                                    if (PbActivity.this.eSw == null || view != PbActivity.this.eSw.aUT()) {
                                                                        if (PbActivity.this.eSw == null || view != PbActivity.this.eSw.aUR()) {
                                                                            if (PbActivity.this.eSw == null || view != PbActivity.this.eSw.aUW()) {
                                                                                if (PbActivity.this.eSw == null || view != PbActivity.this.eSw.aUU()) {
                                                                                    if (PbActivity.this.eSw == null || view != PbActivity.this.eSw.aUV()) {
                                                                                        if (PbActivity.this.eSq.aWz() == view) {
                                                                                            if (PbActivity.this.eSq.aWz().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eSp.getPbData();
                                                                                                if (pbData != null && pbData.aRh() != null && pbData.aRh().rd() != null) {
                                                                                                    String pI = pbData.aRh().rd().pI();
                                                                                                    if (StringUtils.isNull(pI)) {
                                                                                                        pI = pbData.aRh().rd().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ac("obj_id", pI));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.ce("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.aTm();
                                                                                        } else if (PbActivity.this.eSq.aVU() != view) {
                                                                                            if (PbActivity.this.eSw == null || view != PbActivity.this.eSw.aUS()) {
                                                                                                if (PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aVh()) {
                                                                                                    if (PbActivity.this.eSq.faG.aXd() != null && view == PbActivity.this.eSq.faG.aXd().aVe()) {
                                                                                                        if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.eSq.c(PbActivity.this.eSp.getPbData(), PbActivity.this.eSp.aUf(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                PbActivity.this.eSq.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                            PbActivity.this.eSq.faG.ot();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.eSq.aSC()) {
                                                                                                            if (view == PbActivity.this.eSq.faG.aXe()) {
                                                                                                                PbActivity.this.eSq.aWh();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (biVar = (bi) view.getTag()) != null && !StringUtils.isNull(biVar.sZ())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        com.baidu.tbadk.core.util.av.vL().c(PbActivity.this.getPageContext(), new String[]{biVar.sZ()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData ba = PbActivity.this.ba(view);
                                                                                                                    if (ba != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", ba.bwC() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.aSo() != null && PbActivity.this.aSo().getPbData() != null && PbActivity.this.aSo().getPbData().aRD() != null && PbActivity.this.aSo().getPbData().aRD() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aSM().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aSo().getPbData().aRD().aRN() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && !StringUtils.isNull(PbActivity.this.eSp.getPbData().getThreadId()) && (aRD = PbActivity.this.eSp.getPbData().aRD()) != null && aRD.aRM() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.av.vL().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eSp.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.eSw == null) {
                                                                                                                                PbActivity.this.eSw = new y(PbActivity.this.getPageContext(), PbActivity.this.cIA);
                                                                                                                                PbActivity.this.eSq.bk(PbActivity.this.eSw.getView());
                                                                                                                                PbActivity.this.eSw.jy(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.eSw.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ac("tid", PbActivity.this.eSp.eWO));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.eSw.aUR().setTag(sparseArray2);
                                                                                                                            PbActivity.this.eSw.aUW().setTag(view.getTag());
                                                                                                                            PbActivity.this.eSw.jA(z6);
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
                                                                                                                                    PbActivity.this.eSw.aUU().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.eSw.aUU().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.eSw.aUS().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eSw.aUU().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eSw.aUS().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.eSw.aUS().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.eSw.aUS().setVisibility(8);
                                                                                                                                PbActivity.this.eSw.aUU().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.eSw.aUS().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eSw.aUU().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eSw.aUS().setText(d.j.delete);
                                                                                                                                PbActivity.this.eSw.aUU().setVisibility(0);
                                                                                                                                if (PbActivity.this.eSp.getPbData().aRs() != 1002 || z2) {
                                                                                                                                    PbActivity.this.eSw.aUU().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eSw.aUU().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.eSw.aUS().setVisibility(8);
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
                                                                                                                                PbActivity.this.eSw.aUT().setTag(sparseArray7);
                                                                                                                                PbActivity.this.eSw.aUT().setVisibility(0);
                                                                                                                                PbActivity.this.eSw.aUS().setVisibility(8);
                                                                                                                                PbActivity.this.eSw.aUT().setText(d.j.mute_option);
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
                                                                                                                                boolean je = PbActivity.this.je(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.eTw = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (aq.k(PbActivity.this.eTw) ? false : je) {
                                                                                                                                    PbActivity.this.eSw.aUT().setVisibility(0);
                                                                                                                                    PbActivity.this.eSw.aUT().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eSw.aUT().setVisibility(8);
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
                                                                                                                                PbActivity.this.eSw.aUV().setVisibility(0);
                                                                                                                                PbActivity.this.eSw.aUV().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.eSw.aUV().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.eSw.aUV().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.eSw.aUV().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eSp.getPbData().nJ()) {
                                                                                                                            String nI = PbActivity.this.eSp.getPbData().nI();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(nI) && nI.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.eSw.aUR().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eSw.aUR().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.eSw.jz(true);
                                                                                                                                PbActivity.this.eSw.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.eSw.jz(true);
                                                                                                                        PbActivity.this.eSw.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRh() != null && PbActivity.this.eSp.getPbData().aRh().sd() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.P(PbActivity.this.getActivity(), PbActivity.this.eSp.getPbData().aRh().sd());
                                                                                                                        if (PbActivity.this.eSp.getPbData().aRh().sb() != 1) {
                                                                                                                            if (PbActivity.this.eSp.getPbData().aRh().sb() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getPbData().getForumId()).ac("tid", PbActivity.this.eSp.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.eSp.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.eSq.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (ax.aV(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.j.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.eSq.aVF();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.P(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aSN() == 1) {
                                                                                                                            if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getPbData().getForumId()).ac("tid", PbActivity.this.eSp.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aSN() == 2 && PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getPbData().getForumId()).ac("tid", PbActivity.this.eSp.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.P(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.aSN() == 1) {
                                                                                                                            if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getPbData().getForumId()).ac("tid", PbActivity.this.eSp.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aSN() == 2 && PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getPbData().getForumId()).ac("tid", PbActivity.this.eSp.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.aTh();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.aTi();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRz() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eSp.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ac(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.vL().c(PbActivity.this.getPageContext(), new String[]{pbData2.aRz().aRI()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRz() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eSp.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.vL().c(PbActivity.this.getPageContext(), new String[]{pbData3.aRz().aRI()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.eSq.faG.aXd() != null && view == PbActivity.this.eSq.faG.aXd().aVk()) {
                                                                                                                    if (PbActivity.this.eSp == null || PbActivity.this.eSp.getPbData() == null || PbActivity.this.eSp.getPbData().aRh() == null) {
                                                                                                                        PbActivity.this.eSq.faG.ot();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.hy()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.eSp.getPbData().aRh().rf() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSp.aUe(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).tt();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").r("obj_locate", PbActivity.this.X(PbActivity.this.eSp.getPbData().aRh())).ac("tid", PbActivity.this.eSp.getPbData().aRh().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.eSQ >= 0) {
                                                                                                                        if (PbActivity.this.eSp != null) {
                                                                                                                            PbActivity.this.eSp.aUM();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eSq.aVV() != null) {
                                                                                                                            PbActivity.this.eSq.aVV().a(PbActivity.this.eSp.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.eSq.getListView().setSelection(PbActivity.this.eSp.aUP());
                                                                                                                        PbActivity.this.eSQ = 0;
                                                                                                                        if (PbActivity.this.eSp != null) {
                                                                                                                            PbActivity.this.eSp.bt(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.eSq.aWK();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eSp.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eSp.aUe(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eSp.getPbData().aRh().rS())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.eSp.getPbData() != null) {
                                                                                                            PbActivity.this.eSq.aWo();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bwE()) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12630"));
                                                                                                                }
                                                                                                                String aUe = PbActivity.this.eSp.aUe();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.eSp.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.eSp.getPbData().aRs();
                                                                                                                }
                                                                                                                PbActivity.this.als();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c pM = PbActivity.this.pM(id2);
                                                                                                                    if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && pM != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aUe, id2, "pb", true, null, true, null, i3, postData3.aXW(), PbActivity.this.eSp.getPbData().qi(), false, postData3.rx().getIconInfo()).addBigImageData(pM.eUg, pM.eUh, pM.eUi, pM.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.eSp.aUL());
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
                                                                                                                    if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && pM2 != null && PbActivity.this.aSI().aVD() != null) {
                                                                                                                        com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                        mVar.b(PbActivity.this.eSp.getPbData().aRf());
                                                                                                                        mVar.P(PbActivity.this.eSp.getPbData().aRh());
                                                                                                                        mVar.d(postData4);
                                                                                                                        PbActivity.this.aSI().aVD().d(mVar);
                                                                                                                        PbActivity.this.aSI().aVD().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c pM3 = PbActivity.this.pM(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && pM3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aUe, id2, "pb", true, null, false, null, i3, postData3.aXW(), PbActivity.this.eSp.getPbData().qi(), false, postData3.rx().getIconInfo()).addBigImageData(pM3.eUg, pM3.eUh, pM3.eUi, pM3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.eSp.aUL());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                    PbActivity.this.eSq.aWo();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.eSq.c(PbActivity.this.eSp.getPbData(), PbActivity.this.eSp.aUf(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSp.getPbData().aRf().getId(), PbActivity.this.eSp.getPbData().aRf().getName(), PbActivity.this.eSp.getPbData().aRh().getId(), String.valueOf(PbActivity.this.eSp.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
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
                                                                                                    if (!com.baidu.tieba.c.a.abo() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eSp.aUe(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.eSq.bi(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.eSq.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.aSE();
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
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eSp.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aRf() != null) {
                                                                                            str9 = pbData4.aRf().getId();
                                                                                            str10 = pbData4.aRf().getName();
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
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.abo() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eSp.aUe(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.eSq.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.eSw.aUY()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ac("tid", PbActivity.this.eSp.eWO));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eSp.getPbData() != null) {
                                                                                    PbActivity.this.eSq.aWo();
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
                                                                                        String aUe2 = PbActivity.this.eSp.aUe();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.eSp.getPbData() != null) {
                                                                                            i5 = PbActivity.this.eSp.getPbData().aRs();
                                                                                        }
                                                                                        PbActivity.this.als();
                                                                                        c pM4 = PbActivity.this.pM(id3);
                                                                                        if (pM4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aUe2, id3, "pb", true, null, true, null, i5, postData.aXW(), PbActivity.this.eSp.getPbData().qi(), false, postData.rx().getIconInfo()).addBigImageData(pM4.eUg, pM4.eUh, pM4.eUi, pM4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.eSp.aUL());
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
                                                                                PbActivity.this.bb(view);
                                                                                if (PbActivity.this.eSp.getPbData().aRh() != null && PbActivity.this.eSp.getPbData().aRh().rx() != null && PbActivity.this.eSp.getPbData().aRh().rx().getUserId() != null && PbActivity.this.etk != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eSp.eWO).r("obj_locate", 2).ac("obj_id", PbActivity.this.eSp.getPbData().aRh().rx().getUserId()).r("obj_type", PbActivity.this.etk.nJ() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eSp.getPbData())));
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
                                                                        PbActivity.this.eSq.onChangeSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").r("obj_type", 0).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        PbActivity.this.eSq.onChangeSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.eSq.faG.ot();
                                                                }
                                                            } else if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRh() != null) {
                                                                PbActivity.this.eSq.faG.ot();
                                                                PbActivity.this.pJ(PbActivity.this.eSp.getPbData().aRh().rO());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.eSq.aWo();
                                                            if (com.baidu.adp.lib.util.j.hh()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.eSp.aUs()));
                                                                    return;
                                                                }
                                                                PbActivity.this.pL(2);
                                                                PbActivity.this.als();
                                                                PbActivity.this.eSq.aVZ();
                                                                boolean aUr = PbActivity.this.eSp.aUr();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.eSp.aUs()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.eSq.faG != null && PbActivity.this.eSq.faG.aXd() != null && view == PbActivity.this.eSq.faG.aXd().aVi()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (aUr) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.eSq.jJ(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.eSq.aWo();
                                                        if (PbActivity.this.eSp.avA() != null) {
                                                            PbActivity.this.eSq.a(PbActivity.this.eSp.avA(), PbActivity.this.eFv);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.al.fS() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.eSp != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ac("tid", PbActivity.this.eSp.aUe()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.hy()) {
                                                        if (PbActivity.this.eSp.getPbData() != null) {
                                                            ArrayList<PostData> aRj2 = PbActivity.this.eSp.getPbData().aRj();
                                                            if ((aRj2 != null && aRj2.size() > 0) || !PbActivity.this.eSp.aUf()) {
                                                                PbActivity.this.eSq.aWo();
                                                                PbActivity.this.als();
                                                                PbActivity.this.pL(2);
                                                                if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRz() != null && !StringUtils.isNull(PbActivity.this.eSp.getPbData().aRz().pT(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.al.fS()) {
                                                                    PbActivity.this.pM(2);
                                                                } else {
                                                                    PbActivity.this.eSq.showLoadingDialog();
                                                                    PbActivity.this.eSp.aUG().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.eSq.faG.ot();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.hh()) {
                                            PbActivity.this.eSq.aWo();
                                            if (PbActivity.this.eSq.faG.aXd() != null && view == PbActivity.this.eSq.faG.aXd().aVc() && !PbActivity.this.eSq.aWH()) {
                                                PbActivity.this.eSq.aVF();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.als();
                                                PbActivity.this.eSq.aVZ();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    k = PbActivity.this.eSp.k(true, PbActivity.this.aTf());
                                                } else {
                                                    k = view.getId() == d.g.reply_title ? PbActivity.this.eSp.k(false, PbActivity.this.aTf()) : PbActivity.this.eSp.pO(PbActivity.this.aTf());
                                                }
                                                view.setTag(Boolean.valueOf(k));
                                                if (k) {
                                                    PbActivity.this.eSq.jn(true);
                                                    PbActivity.this.eSq.aBn();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.eSq.jJ(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.pL(2);
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
                                        PbActivity.this.eSq.aWo();
                                        if (PbActivity.this.pK(11009) && PbActivity.this.eSp.qa(PbActivity.this.eSq.aWe()) != null) {
                                            PbActivity.this.aSY();
                                            if (PbActivity.this.eSp.getPbData().aRh() != null && PbActivity.this.eSp.getPbData().aRh().rx() != null && PbActivity.this.eSp.getPbData().aRh().rx().getUserId() != null && PbActivity.this.etk != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eSp.eWO).r("obj_locate", 1).ac("obj_id", PbActivity.this.eSp.getPbData().aRh().rx().getUserId()).r("obj_type", PbActivity.this.etk.nJ() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eSp.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                    PbActivity.this.eSq.jn(true);
                                    PbActivity.this.eSq.aVF();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eSq.aBn();
                                        PbActivity.this.als();
                                        PbActivity.this.eSq.aVZ();
                                        PbActivity.this.eSp.pO(PbActivity.this.aTf());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.pL(2);
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
                                if (PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRh() != null && PbActivity.this.eSp.getPbData().aRh().sk() && PbActivity.this.eSp.getPbData().aRh().rP() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.eSp.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eSp.aUd()) && PbActivity.this.eSp.getAppealInfo() != null) {
                                        name = PbActivity.this.eSp.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eSp.getPbData().aRf().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aUd = PbActivity.this.eSp.aUd();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eSp.aUg() && aUd != null && aUd.equals(name)) {
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
                            if (PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRs() == 1 && !PbActivity.this.cbD.bxc()) {
                                PbActivity.this.eSq.aWo();
                                int i6 = 0;
                                if (PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aVd()) {
                                    if (PbActivity.this.eSq.faG.aXd() == null || view != PbActivity.this.eSq.faG.aXd().aVf()) {
                                        if (view == PbActivity.this.eSq.aVX()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eSp.getPbData().aRh().rt() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eSp.getPbData().aRh().rs() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aRf = PbActivity.this.eSp.getPbData().aRf();
                                String name2 = aRf.getName();
                                String id4 = aRf.getId();
                                String id5 = PbActivity.this.eSp.getPbData().aRh().getId();
                                if (!com.baidu.tieba.c.a.abo() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eSq.aVW();
                                    PbActivity.this.cbD.a(id4, name2, id5, i6, PbActivity.this.eSq.aVY());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.hh()) {
                        PbActivity.this.eSq.aWo();
                        PbActivity.this.als();
                        PbActivity.this.eSq.aVZ();
                        PbActivity.this.eSq.showLoadingDialog();
                        if (PbActivity.this.eSq.aVM() != null) {
                            PbActivity.this.eSq.aVM().setVisibility(8);
                        }
                        PbActivity.this.eSp.pT(1);
                        if (PbActivity.this.eRV != null) {
                            PbActivity.this.eRV.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String aSL = PbActivity.this.aSL();
                        if (!TextUtils.isEmpty(aSL)) {
                            com.baidu.tbadk.core.util.av.vL().c(PbActivity.this.getPageContext(), new String[]{aSL});
                        }
                    }
                } else if (PbActivity.this.eSg) {
                    PbActivity.this.eSg = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.aSI().aVD() != null && postData5.rx() != null && postData5.bwo() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.aSI().aVE() != null) {
                                    PbActivity.this.aSI().aVE().aTS();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.eSp.getPbData().aRf());
                                mVar2.P(PbActivity.this.eSp.getPbData().aRh());
                                mVar2.d(postData5);
                                PbActivity.this.aSI().aVD().d(mVar2);
                                PbActivity.this.aSI().aVD().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.rx().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.eSD != null) {
                                    PbActivity.this.eSq.jT(PbActivity.this.eSD.DH());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aDN = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.r rVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.als();
            PbActivity.this.eSq.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ad.GT() && PbActivity.this.aSo() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aSo().pR(postWriteCallBackData.getPostId());
                    PbActivity.this.eSQ = PbActivity.this.eSq.aVI();
                    if (PbActivity.this.eSp != null) {
                        PbActivity.this.eSp.bt(PbActivity.this.eSQ, PbActivity.this.eSq.aVJ());
                    }
                }
                PbActivity.this.eSq.aWo();
                PbActivity.this.eSv.aWM();
                if (PbActivity.this.eSD != null) {
                    PbActivity.this.eSq.jT(PbActivity.this.eSD.DH());
                }
                PbActivity.this.eSq.aVC();
                PbActivity.this.eSq.jV(true);
                PbActivity.this.eSp.aUu();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eSp.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eSp.getPbData();
                            if (pbData != null && pbData.aRh() != null && pbData.aRh().rx() != null && (userId = pbData.aRh().rx().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ad.GT() && PbActivity.this.eSp.aUn()) {
                                PbActivity.this.eSq.aVZ();
                            }
                        } else if (!com.baidu.tbadk.o.ad.GT() && PbActivity.this.eSp.aUn()) {
                            PbActivity.this.eSq.aVZ();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eSq.p(PbActivity.this.eSp.getPbData());
                    }
                    if (PbActivity.this.eSp.aUj()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ac("tid", PbActivity.this.eSp.aUe()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.eSD.DO() || PbActivity.this.eSD.DP()) {
                    PbActivity.this.eSD.a(false, postWriteCallBackData);
                }
                PbActivity.this.eSv.e(postWriteCallBackData);
            } else if (rVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d eTn = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.r rVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.eSv != null) {
                if (z) {
                    PbActivity.this.eSv.aWL();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    if (PbActivity.this.eSq != null && PbActivity.this.eSq.aVE() != null && PbActivity.this.eSq.aVE().aTW() != null && PbActivity.this.eSq.aVE().aTW().DP()) {
                        PbActivity.this.eSq.aVE().aTW().a(postWriteCallBackData);
                    }
                    PbActivity.this.eSv.f(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a eTo = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eN;
            if (!z || fVar == null || fVar.aRq() != null || com.baidu.tbadk.core.util.v.v(fVar.aRj()) >= 1) {
                PbActivity.this.evU = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eSq.aWb();
                if (fVar == null || !fVar.aRn()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eSq.getView());
                } else if (PbActivity.this.eSq.aVA() == null) {
                    PbActivity.this.eSH = true;
                }
                PbActivity.this.eSq.aBm();
                if (PbActivity.this.isFullScreen || PbActivity.this.eSq.aWH()) {
                    PbActivity.this.eSq.aWv();
                } else if (!PbActivity.this.eSq.aWu()) {
                    PbActivity.this.eSq.jV(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eSx = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eSq.PB();
                    PbActivity.this.eSq.jW(fVar.aRn());
                    if (fVar.aRh() != null && fVar.aRh().su() != null) {
                        PbActivity.this.a(fVar.aRh().su());
                    }
                    PbActivity.this.aSF();
                    if (PbActivity.this.eSD != null) {
                        PbActivity.this.eSq.jT(PbActivity.this.eSD.DH());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aRj() != null && fVar.aRj().size() >= 1 && fVar.aRj().get(0) != null) {
                        PbActivity.this.eSp.pQ(fVar.aRj().get(0).getId());
                    } else if (fVar.aRq() != null) {
                        PbActivity.this.eSp.pQ(fVar.aRq().getId());
                    }
                    if (PbActivity.this.eSD != null) {
                        PbActivity.this.eSD.a(fVar.qi());
                        PbActivity.this.eSD.a(fVar.aRf(), fVar.getUserData());
                        PbActivity.this.eSD.a(PbActivity.this.eSp.aUo(), PbActivity.this.eSp.aUe(), PbActivity.this.eSp.aUI());
                        if (fVar.aRh() != null) {
                            PbActivity.this.eSD.bE(fVar.aRh().sK());
                        }
                    }
                    if (PbActivity.this.etk != null) {
                        PbActivity.this.etk.ab(fVar.nJ());
                    }
                    if (fVar == null || fVar.aRt() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eSq.jU(PbActivity.this.mIsFromCDN);
                    PbActivity.this.eSq.a(fVar, i2, i3, PbActivity.this.eSp.aUf(), i4, PbActivity.this.eSp.getIsFromMark());
                    PbActivity.this.eSq.d(fVar, PbActivity.this.eSp.aUf());
                    PbActivity.this.eSq.jR(PbActivity.this.eSp.getHostMode());
                    AntiData qi = fVar.qi();
                    if (qi != null) {
                        PbActivity.this.aDD = qi.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aDD) && PbActivity.this.eSD != null && PbActivity.this.eSD.Dd() != null && (eN = PbActivity.this.eSD.Dd().eN(6)) != null && !TextUtils.isEmpty(PbActivity.this.aDD)) {
                            ((View) eN).setOnClickListener(PbActivity.this.aEo);
                        }
                    }
                    if (PbActivity.this.eSz) {
                        PbActivity.this.eSz = false;
                        final int aSS = PbActivity.this.aSS();
                        if (fVar.aRE()) {
                            final int ac = (int) (com.baidu.adp.lib.util.l.ac(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(aSS, ac);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.aSI().qf(aSS);
                        }
                    }
                    if (PbActivity.this.eSA) {
                        PbActivity.this.eSA = false;
                        final int aSS2 = PbActivity.this.aSS();
                        final boolean z2 = aSS2 != -1;
                        if (!z2) {
                            aSS2 = PbActivity.this.aST();
                        }
                        if (PbActivity.this.aSI() != null) {
                            if (fVar.aRE()) {
                                final int ac2 = (int) (com.baidu.adp.lib.util.l.ac(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (aSS2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(aSS2, ac2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(aSS2 - 1, ac2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.aSI().qf(aSS2);
                            }
                        }
                    } else {
                        PbActivity.this.eSq.aWf();
                    }
                    PbActivity.this.eSp.a(fVar.aRf(), PbActivity.this.eTb);
                    PbActivity.this.eSp.a(PbActivity.this.eTc);
                } else if (str != null) {
                    if (!PbActivity.this.eSx && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eSp != null && PbActivity.this.eSp.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eSp.getAppealInfo().eOh)) {
                                    PbActivity.this.eSq.a(PbActivity.this.eSp.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eSq.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eSq.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.eSq.aWv();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.eSp.aUe());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getForumId());
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
                        PbActivity.this.eSq.pT(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.eSq.pT("");
                    }
                    PbActivity.this.eSq.wy();
                }
                PbActivity.this.aKs = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aSo().aUf() || PbActivity.this.aSo().getPbData().qA().qx() != 0 || PbActivity.this.aSo().aUB()) {
                    PbActivity.this.eSE = true;
                    return;
                }
                return;
            }
            PbActivity.this.eSp.pT(1);
            if (PbActivity.this.eRV != null) {
                PbActivity.this.eRV.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eSq.p(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.r.GA().GB()) {
                com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, PbActivity.this.aKk, PbActivity.this.createTime, PbActivity.this.aKs, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.ctl : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aKk = 0L;
                if (mVar != null) {
                    mVar.Gv();
                }
            }
        }
    };
    private CustomMessageListener eTp = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aSN() == 1) {
                    PbActivity.this.aSW();
                }
                PbActivity.this.aSO();
            }
        }
    };
    private final a.InterfaceC0043a eTq = new a.InterfaceC0043a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0043a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eSq.aWb();
            if (z) {
                if (PbActivity.this.etk != null) {
                    PbActivity.this.etk.ab(z2);
                }
                PbActivity.this.eSp.jw(z2);
                if (PbActivity.this.eSp.nJ()) {
                    PbActivity.this.aSZ();
                } else {
                    PbActivity.this.eSq.p(PbActivity.this.eSp.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.etk != null && PbActivity.this.etk.nM() != null && PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRh() != null && PbActivity.this.eSp.getPbData().aRh().rx() != null) {
                        MarkData nM = PbActivity.this.etk.nM();
                        MetaData rx = PbActivity.this.eSp.getPbData().aRh().rx();
                        if (nM != null && rx != null) {
                            if (!com.baidu.tbadk.core.util.am.equals(TbadkCoreApplication.getCurrentAccount(), rx.getUserId()) && !rx.hadConcerned()) {
                                PbActivity.this.b(rx);
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
            if (!PbActivity.this.pI(PbActivity.this.mLastScrollState) && PbActivity.this.pI(i)) {
                if (PbActivity.this.eSq != null) {
                    PbActivity.this.eSq.aWo();
                    if (PbActivity.this.eSD != null && !PbActivity.this.eSq.aVG()) {
                        PbActivity.this.eSq.jT(PbActivity.this.eSD.DH());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.eSq.aVF();
                    }
                }
                if (!PbActivity.this.eSd) {
                    PbActivity.this.eSd = true;
                    PbActivity.this.eSq.aWt();
                }
            }
            PbActivity.this.eSq.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eRV != null) {
                PbActivity.this.eRV.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eSe == null) {
                PbActivity.this.eSe = new com.baidu.tbadk.k.d();
                PbActivity.this.eSe.fr(1001);
            }
            if (i == 0) {
                PbActivity.this.eSe.Gh();
            } else if (i == 1) {
                PbActivity.this.eSe.Gh();
            } else {
                PbActivity.this.eSe.Gh();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aRj;
            if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSq != null && PbActivity.this.eSq.aVV() != null) {
                PbActivity.this.eSq.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eRV != null) {
                    PbActivity.this.eRV.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eSp.aUw() && (aRj = PbActivity.this.eSp.getPbData().aRj()) != null && !aRj.isEmpty()) {
                    int aTI = ((i + i2) - PbActivity.this.eSq.aVV().aTI()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eSp.getPbData();
                    if (pbData != null) {
                        if (pbData.aRk() != null && pbData.aRk().hasData()) {
                            aTI--;
                        }
                        if (pbData.aRl() != null && pbData.aRl().hasData()) {
                            aTI--;
                        }
                        int size = aRj.size();
                        if (aTI < 0 || aTI >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cbH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.cbD.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eSp.aUu();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.djA && bVar.fhq > 0 && bVar.gBx != 0 && bVar.fhq != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.fhq == 1002 && !bVar.djA) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eSq.a(1, dVar.Al, dVar.gBz, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cbD.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eSq.a(PbActivity.this.cbD.getLoadDataMode(), fVar.Al, fVar.gBz, false);
                        PbActivity.this.eSq.ak(fVar.gBB);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eSq.a(PbActivity.this.cbD.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d eTr = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
    };
    private final g.b bfG = new g.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aTg()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eSp.jv(true)) {
                PbActivity.this.eSq.aWc();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eTt = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eTs && PbActivity.this.aTg()) {
                PbActivity.this.aTi();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eSp.ju(false)) {
                    PbActivity.this.eSq.aWa();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eSp.getPbData() != null) {
                    PbActivity.this.eSq.aWs();
                }
                PbActivity.this.eTs = true;
            }
        }
    };
    private int eTu = 0;
    private final TbRichTextView.f aVE = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
        public void a(View view, String str, int i) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.eSq.b((TbRichText) view.getTag());
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
                    PbActivity.this.eSn = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.eUj) {
                    TbRichText at = PbActivity.this.at(str, i);
                    if (at != null && PbActivity.this.eTu >= 0 && PbActivity.this.eTu < at.Jq().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.g.b(at.Jq().get(PbActivity.this.eTu));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.eUg.size()) {
                                break;
                            } else if (!cVar.eUg.get(i3).equals(b2)) {
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
                            concurrentHashMap.put(str2, cVar.eUh.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eUi, cVar.lastId, PbActivity.this.eSp.aUs(), concurrentHashMap, true, false, PbActivity.this.eSp.getHostMode());
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.eUg, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.w(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.eUh.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eUi, cVar.eUg.get(0), PbActivity.this.eSp.aUs(), concurrentHashMap2, true, false, PbActivity.this.eSp.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eTv = false;
    PostData eTw = null;
    private final b.InterfaceC0047b eTx = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eTw != null) {
                if (i == 0) {
                    PbActivity.this.eTw.ce(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eTw = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.eTw);
                }
            }
        }
    };
    private final b.InterfaceC0047b eTy = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eSN != null && !TextUtils.isEmpty(PbActivity.this.eSO)) {
                if (i == 0) {
                    if (PbActivity.this.eSP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eSO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eSO;
                        aVar.pkgId = PbActivity.this.eSP.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eSP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eSM == null) {
                        PbActivity.this.eSM = new av(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eSM.i(PbActivity.this.eSO, PbActivity.this.eSN.kN());
                }
                PbActivity.this.eSN = null;
                PbActivity.this.eSO = null;
            }
        }
    };
    private final View.OnLongClickListener avA = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eSN = ((TbImageView) view).getBdImage();
                PbActivity.this.eSO = ((TbImageView) view).getUrl();
                if (PbActivity.this.eSN != null && !TextUtils.isEmpty(PbActivity.this.eSO)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eSP = null;
                    } else {
                        PbActivity.this.eSP = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eSq.a(PbActivity.this.eTy, PbActivity.this.eSN.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.eSN = ((GifView) view).getBdImage();
                }
                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                    PbActivity.this.eSO = ((GifView) view).getBdImage().getUrl();
                }
                if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                    PbActivity.this.eSP = null;
                } else {
                    PbActivity.this.eSP = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                }
                PbActivity.this.eSq.a(PbActivity.this.eTy, PbActivity.this.eSN.isGif());
            } else if (view instanceof com.baidu.tbadk.widget.c) {
                if (((com.baidu.tbadk.widget.c) view).getBdImage() != null) {
                    PbActivity.this.eSN = ((com.baidu.tbadk.widget.c) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.c) view).getBdImage().getUrl())) {
                        PbActivity.this.eSO = ((com.baidu.tbadk.widget.c) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eSP = null;
                    } else {
                        PbActivity.this.eSP = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eSq.a(PbActivity.this.eTy, PbActivity.this.eSN.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eTw = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.eTw != null && PbActivity.this.etk != null) {
                        PbActivity.this.eSq.a(PbActivity.this.eTx, PbActivity.this.etk.nJ() && PbActivity.this.eTw.getId() != null && PbActivity.this.eTw.getId().equals(PbActivity.this.eSp.rH()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a cFo = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (!PbActivity.this.eRX && z && !PbActivity.this.eSp.aUm()) {
                PbActivity.this.aTc();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener aNj = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).auC()) {
                        break;
                    }
                }
            }
            PbActivity.this.bHH.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0083a bHI = new a.InterfaceC0083a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        final int bRc;

        {
            this.bRc = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void af(int i, int i2) {
            if (K(i2) && PbActivity.this.eSq != null && PbActivity.this.eRV != null) {
                PbActivity.this.eSq.aWw();
                PbActivity.this.eRV.fb(false);
                PbActivity.this.eRV.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ag(int i, int i2) {
            if (K(i2) && PbActivity.this.eSq != null && PbActivity.this.eRV != null) {
                PbActivity.this.eRV.fb(true);
                if (Math.abs(i2) > this.bRc) {
                    PbActivity.this.eRV.hideFloatingView();
                }
                if (PbActivity.this.aTg()) {
                    PbActivity.this.eSq.aVR();
                    PbActivity.this.eSq.aVS();
                }
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ah(int i, int i2) {
        }

        private boolean K(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eTz = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // com.baidu.tieba.e.b.a
        public void ew(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aSe();
            } else {
                com.baidu.tieba.pb.a.b.aSd();
            }
        }
    };
    private String eTA = null;
    private final o.a eTB = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eTA = str2;
                PbActivity.this.eSq.pU(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eTC = -1;
    private int eTD = -1;
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Ug == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0045a) {
                    if (aVar.Uh != null && !aVar.Uh.hasError() && aVar.Uh.getError() == 0) {
                        if (PbActivity.this.eSq != null) {
                            PbActivity.this.eSq.y(((a.C0045a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aTs();
                        }
                    } else if (z) {
                        if (aVar.Uh != null && aVar.Uh.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Uh.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Uh != null && !aVar.Uh.hasError() && aVar.Uh.getError() == 0) {
                        if (PbActivity.this.eSq != null && PbActivity.this.eSq != null) {
                            PbActivity.this.eSq.y(((a.C0045a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Uh != null && aVar.Uh.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Uh.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Uh == null || aVar.Uh.hasError() || aVar.Uh.getError() != 0) {
                        if (z) {
                            if (aVar.Uh != null && aVar.Uh.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Uh.getErrorString());
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
    private final CustomMessageListener cHX = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ac("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.av.vL().c(PbActivity.this.getPageContext(), new String[]{str});
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
        public ArrayList<String> eUg;
        public ConcurrentHashMap<String, ImageUrlData> eUh;
        public boolean eUj;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eUi = false;
        public boolean eUk = false;
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

    public com.baidu.tbadk.editortools.pb.d aSD() {
        return this.eSD;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        if (mVar.aRT() != null) {
            String id = mVar.aRT().getId();
            ArrayList<PostData> aRj = this.eSp.getPbData().aRj();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aRj.size()) {
                    break;
                }
                PostData postData = aRj.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aRX = mVar.aRX();
                    postData.uk(mVar.getTotalCount());
                    if (postData.bwl() != null && aRX != null) {
                        Iterator<PostData> it = aRX.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.rx() != null && (metaData = postData.getUserMap().get(next.rx().getUserId())) != null) {
                                next.a(metaData);
                                next.nb(true);
                                next.b(getPageContext(), this.eSp.pP(metaData.getUserId()));
                            }
                        }
                        postData.bwl().clear();
                        postData.bwl().addAll(aRX);
                    }
                    if (postData.bwh() != null) {
                        postData.bwi();
                    }
                }
            }
            if (!this.eSp.getIsFromMark()) {
                this.eSq.p(this.eSp.getPbData());
            }
            c(mVar);
        }
    }

    public void aSE() {
        com.baidu.tieba.pb.data.f pbData;
        bd aRh;
        if (!this.eTe) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (this.eTh) {
                this.eTe = true;
                if (this.eSp != null && (pbData = this.eSp.getPbData()) != null && (aRh = pbData.aRh()) != null) {
                    int isLike = aRh.rm() == null ? 0 : aRh.rm().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ac("tid", aRh.getId()));
                    }
                    if (this.eTf != null) {
                        this.eTf.a(aRh.rO(), aRh.getId(), isLike, "pb");
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
                    bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.eSq.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eSK);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eSK);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eSK);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eSK);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).to();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(int i) {
        bd aRh;
        String str;
        String y;
        if (this.eSp != null && this.eSp.getPbData() != null && (aRh = this.eSp.getPbData().aRh()) != null) {
            if (i == 1) {
                PraiseData rm = aRh.rm();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rm == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aRh.a(praiseData);
                    } else {
                        aRh.rm().getUser().add(0, metaData);
                        aRh.rm().setNum(aRh.rm().getNum() + 1);
                        aRh.rm().setIsLike(i);
                    }
                }
                if (aRh.rm() != null) {
                    if (aRh.rm().getNum() < 1) {
                        y = getResources().getString(d.j.zan);
                    } else {
                        y = com.baidu.tbadk.core.util.am.y(aRh.rm().getNum());
                    }
                    this.eSq.Q(y, true);
                }
            } else if (aRh.rm() != null) {
                aRh.rm().setIsLike(i);
                aRh.rm().setNum(aRh.rm().getNum() - 1);
                ArrayList<MetaData> user = aRh.rm().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aRh.rm().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aRh.rm().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = aRh.rm().getNum() + "";
                }
                this.eSq.Q(str, false);
            }
            if (this.eSp.aUf()) {
                this.eSq.aVV().notifyDataSetChanged();
            } else {
                this.eSq.q(this.eSp.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eSp.u(bundle);
        if (this.cGZ != null) {
            this.cGZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eSD.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eSI = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.ctl = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eSj = intent.getStringExtra("from");
            if ("from_interview_live".equals(this.eSj)) {
                this.eRW = true;
            }
            this.eTC = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.eTD = intent.getIntExtra("key_manga_next_chapter", -1);
            this.eTE = intent.getStringExtra("key_manga_title");
            this.eSz = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.eSA = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (aTg()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.eSR = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.ctl = System.currentTimeMillis();
        }
        this.eSc = System.currentTimeMillis();
        this.aKk = this.eSc - this.ctl;
        super.onCreate(bundle);
        this.eRZ = 0;
        t(bundle);
        if (this.eSp != null && this.eSp.getPbData() != null) {
            this.eSp.getPbData().pH(this.source);
        }
        initUI();
        if (intent != null && this.eSq != null) {
            this.eSq.faz = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.eSL == null) {
                    this.eSL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eSq.pW("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eSL, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.eSp != null && this.eSp.getPbData() != null) {
                this.eSp.pS(stringExtra);
            }
        }
        this.cGZ = new VoiceManager();
        this.cGZ.onCreate(getPageContext());
        initData(bundle);
        this.eSC = new com.baidu.tbadk.editortools.pb.g();
        aSF();
        this.eSD = (com.baidu.tbadk.editortools.pb.d) this.eSC.aY(getActivity());
        this.eSD.d(this);
        this.eSD.a(this.aDN);
        this.eSD.a(this.aDG);
        this.eSD.a(this, bundle);
        this.eSD.Dd().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eSD.Dd().bx(true);
        jd(true);
        this.eSq.setEditorTools(this.eSD.Dd());
        this.eSD.a(this.eSp.aUo(), this.eSp.aUe(), this.eSp.aUI());
        registerListener(this.eSW);
        if (!this.eSp.aUl()) {
            this.eSD.fX(this.eSp.aUe());
        }
        if (this.eSp.aUJ()) {
            this.eSD.fV(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.eSD.fV(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eSc;
        registerListener(this.eSV);
        registerListener(this.eSX);
        registerListener(this.eSY);
        registerListener(this.cHU);
        registerListener(this.eTm);
        registerListener(this.eSU);
        this.eSB = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gyF);
        this.eSB.bvQ();
        registerListener(this.eTa);
        registerListener(this.mAttentionListener);
        if (this.eSp != null) {
            this.eSp.aUz();
        }
        registerListener(this.eTp);
        registerListener(this.eTG);
        registerListener(this.cIe);
        if (this.eSq != null && this.eSq.aWA() != null && this.eSq.aWB() != null) {
            this.eRV = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eSq.aWA(), this.eSq.aWB(), this.eSq.aVM());
            this.eRV.a(this.eTi);
        }
        if (this.eRU && this.eSq != null && this.eSq.aWB() != null) {
            this.eSq.aWB().setVisibility(8);
        }
        this.eSJ = new com.baidu.tbadk.core.view.c();
        this.eSJ.alo = 1000L;
        registerListener(this.eTl);
        registerListener(this.eTj);
        registerListener(this.eTk);
        this.eSK = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eSK;
        userMuteAddAndDelCustomMessage.setTag(this.eSK);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eSK;
        userMuteCheckCustomMessage.setTag(this.eSK);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eSp.aUG().a(this.bHi);
        if ("from_tieba_kuang".equals(this.eSj)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 2).ac("tid", this.eSp.aUe()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        this.eSv = new at();
        if (this.eSD.DB() != null) {
            this.eSv.g(this.eSD.DB().getInputView());
        }
        this.eSD.a(this.aDH);
        this.cWG = new ShareSuccessReplyToServerModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSF() {
        if (this.eSC != null && this.eSp != null) {
            this.eSC.setForumName(this.eSp.aUd());
            if (this.eSp.getPbData() != null && this.eSp.getPbData().aRf() != null) {
                this.eSC.setForumId(this.eSp.getPbData().aRf().getId());
            }
            this.eSC.setFrom("pb");
            this.eSC.a(this.eSp);
        }
    }

    public String aSG() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aSH() {
        return this.eRV;
    }

    private void jd(boolean z) {
        this.eSD.bB(z);
        this.eSD.bC(z);
        this.eSD.bD(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRE() && !z && this.eSq != null && this.eSq.getView() != null) {
            this.eSq.getView().setSystemUiVisibility(4);
        }
        this.eSF = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cGZ != null) {
            this.cGZ.onStart(getPageContext());
        }
    }

    public ar aSI() {
        return this.eSq;
    }

    public PbModel aSo() {
        return this.eSp;
    }

    public void pI(String str) {
        if (this.eSp != null && !StringUtils.isNull(str) && this.eSq != null) {
            this.eSq.jY(true);
            this.eSp.pI(str);
            this.eSi = true;
            this.eSq.aWo();
            this.eSq.aWv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eRX = false;
        } else {
            this.eRX = true;
        }
        super.onPause();
        if (this.eSq.aVA() != null && this.eSq.aVA().aSA() != null) {
            this.eSq.aVA().aSA().onPause();
        }
        BdListView listView = getListView();
        this.eRZ = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eRZ == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cGZ != null) {
            this.cGZ.onPause(getPageContext());
        }
        if (this.eSq != null) {
            this.eSq.onPause();
        }
        if (!this.eSp.aUl()) {
            this.eSD.fW(this.eSp.aUe());
        }
        if (this.eSp != null) {
            this.eSp.aUA();
        }
        MessageManager.getInstance().unRegisterListener(this.dDN);
        auV();
        MessageManager.getInstance().unRegisterListener(this.eTj);
        MessageManager.getInstance().unRegisterListener(this.eTk);
        MessageManager.getInstance().unRegisterListener(this.eTl);
        MessageManager.getInstance().unRegisterListener(this.cHX);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aSJ() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eSp.getPbData(), this.eSp.aUf(), this.eSp.aUx());
        return (a2 == null || a2.rx() == null || a2.rx().getGodUserData() == null || a2.rx().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eRX = false;
        super.onResume();
        if (this.eSl) {
            this.eSl = false;
            aTm();
        }
        if (this.eSq.aVA() != null && this.eSq.aVA().aSA() != null) {
            this.eSq.aVA().aSA().onResume();
        }
        if (aSJ()) {
            this.eSf = System.currentTimeMillis();
        } else {
            this.eSf = -1L;
        }
        if (this.eSq != null && this.eSq.getView() != null) {
            if (!this.evU) {
                aTd();
            } else {
                hideLoadingView(this.eSq.getView());
            }
            this.eSq.onResume();
        }
        if (this.eRZ == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eSq != null) {
            noNetworkView = this.eSq.aVB();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.hh()) {
            noNetworkView.aI(false);
        }
        if (this.cGZ != null) {
            this.cGZ.onResume(getPageContext());
        }
        registerListener(this.dDN);
        this.eSy = false;
        aTl();
        registerListener(this.eTj);
        registerListener(this.eTk);
        registerListener(this.eTl);
        registerListener(this.cHX);
        if (this.cHE) {
            aTc();
            this.cHE = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eSq.jM(z);
        if (this.eSw != null) {
            this.eSw.jy(z);
        }
        if (z && this.eSy) {
            this.eSq.aWa();
            this.eSp.ju(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eSf > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ac("obj_duration", (System.currentTimeMillis() - this.eSf) + ""));
            this.eSf = 0L;
        }
        if (aSI().aVE() != null) {
            aSI().aVE().onStop();
        }
        if (this.eSq.faG != null && !this.eSq.faG.acz()) {
            this.eSq.faG.aFV();
        }
        if (this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRf() != null && this.eSp.getPbData().aRh() != null) {
            com.baidu.tbadk.distribute.a.CN().a(getPageContext().getPageActivity(), "pb", this.eSp.getPbData().aRf().getId(), com.baidu.adp.lib.g.b.c(this.eSp.getPbData().aRh().getId(), 0L));
        }
        if (this.cGZ != null) {
            this.cGZ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.eSd && this.eSq != null) {
            this.eSd = true;
            this.eSq.aWt();
            a(false, (PostData) null);
        }
        if (this.eSp != null) {
            this.eSp.cancelLoadData();
            this.eSp.destory();
            if (this.eSp.aUF() != null) {
                this.eSp.aUF().onDestroy();
            }
        }
        if (this.eSD != null) {
            this.eSD.onDestroy();
        }
        if (this.cbD != null) {
            this.cbD.cancelLoadData();
        }
        if (this.eSq != null) {
            this.eSq.onDestroy();
            if (this.eSq.faG != null) {
                this.eSq.faG.aFV();
            }
        }
        if (this.eSe != null) {
            this.eSe.onDestroy();
        }
        if (this.eRV != null) {
            this.eRV.Hp();
        }
        super.onDestroy();
        if (this.cGZ != null) {
            this.cGZ.onDestory(getPageContext());
        }
        this.eSq.aWo();
        MessageManager.getInstance().unRegisterListener(this.eTj);
        MessageManager.getInstance().unRegisterListener(this.eTk);
        MessageManager.getInstance().unRegisterListener(this.eTl);
        MessageManager.getInstance().unRegisterListener(this.eSK);
        MessageManager.getInstance().unRegisterListener(this.eTm);
        MessageManager.getInstance().unRegisterListener(this.cIe);
        this.eSI = null;
        this.eSJ = null;
        com.baidu.tieba.recapp.e.a.blQ().blS();
        if (this.eSL != null) {
            getSafeHandler().removeCallbacks(this.eSL);
        }
        if (this.eSm != null) {
            this.eSm.cancelLoadData();
        }
        if (this.eSq != null && this.eSq.faG != null) {
            this.eSq.faG.aXh();
        }
        if (this.cWG != null) {
            this.cWG.cancelLoadData();
        }
        this.eSv.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        h aVV;
        ArrayList<PostData> aTJ;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.b adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xG() && this.eSq != null && (aVV = this.eSq.aVV()) != null && (aTJ = aVV.aTJ()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aTJ.iterator();
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
                        bVar.aMS = id;
                        bVar.cdj = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ZA == 1 && !TextUtils.isEmpty(id)) {
                    next.ZA = 2;
                    a.b bVar2 = new a.b();
                    bVar2.aMS = id;
                    bVar2.cdj = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eSp == null || this.eSp.getPbData() == null || this.eSp.getPbData().aRf() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eSp.getPbData().aRf().getFirst_class();
                    str2 = this.eSp.getPbData().aRf().getSecond_class();
                    str = this.eSp.getPbData().aRf().getId();
                    str4 = this.eSp.aUe();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xJ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eSq.onChangeSkinType(i);
        if (this.eSD != null && this.eSD.Dd() != null) {
            this.eSD.Dd().onChangeSkinType(i);
        }
        if (this.eSq.aVB() != null) {
            this.eSq.aVB().onChangeSkinType(getPageContext(), i);
        }
        this.eSv.onChangeSkinType();
    }

    private void initUI() {
        this.eSq = new ar(this, this.cIA, this.aVF);
        this.bHH = new com.baidu.tieba.e.b(getActivity());
        this.bHH.a(this.eTz);
        this.bHH.a(this.bHI);
        this.eSq.setOnScrollListener(this.mOnScrollListener);
        this.eSq.d(this.eTt);
        this.eSq.a(this.bfG);
        this.eSq.iX(com.baidu.tbadk.core.h.pa().pg());
        this.eSq.setOnImageClickListener(this.aVE);
        this.eSq.a(this.avA);
        this.eSq.h(this.cFo);
        this.eSq.a(this.eTr);
        this.eSq.jM(this.mIsLogin);
        if (getIntent() != null) {
            this.eSq.setIsInterviewLive(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZ(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gzh == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.pa().pg()) {
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
        if (this.eSq != null) {
            if (z && (!this.evU || this.eSH)) {
                aTd();
            } else {
                hideLoadingView(this.eSq.getView());
            }
            this.eSH = false;
            if (z && this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRE() && this.eSq.getView() != null) {
                this.eSq.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void aSK() {
        if (this.eSa == null) {
            this.eSa = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eSa.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eRD = PbActivity.this.eRD.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eRD);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eSp.aUe(), PbActivity.this.eRD, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eRD = PbActivity.this.eRD.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eRD);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eSp.aUe(), PbActivity.this.eRD, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eRD = PbActivity.this.eRD.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eRD);
                        bVar.dismiss();
                    }
                }
            }).ch(b.a.abV).ci(17).d(getPageContext());
        }
    }

    private void t(Bundle bundle) {
        this.eSp = new PbModel(this);
        this.eSp.a(this.eTo);
        if (this.eSp.aUD() != null) {
            this.eSp.aUD().a(this.eTB);
        }
        if (this.eSp.aUC() != null) {
            this.eSp.aUC().a(this.eSZ);
        }
        if (this.eSp.aUF() != null) {
            this.eSp.aUF().b(this.eST);
        }
        if (bundle != null) {
            this.eSp.initWithBundle(bundle);
        } else {
            this.eSp.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eSp.jx(true);
        }
        ai.aVn().P(this.eSp.aUc(), this.eSp.getIsFromMark());
        if (StringUtils.isNull(this.eSp.aUe())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.eSj)) {
            this.eSp.qb(6);
        }
        this.eSp.Fy();
    }

    private void initData(Bundle bundle) {
        this.etk = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.etk != null) {
            this.etk.a(this.eTq);
        }
        this.cbD = new ForumManageModel(this);
        this.cbD.setLoadDataCallBack(this.cbH);
        this.apr = new com.baidu.tbadk.coreExtra.model.a(null);
        this.eSq.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eSp.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSp.getPbData().aRf().getId(), PbActivity.this.eSp.getPbData().aRf().getName(), PbActivity.this.eSp.getPbData().aRh().getId(), valueOf, str, str2)));
            }
        });
        this.eTf.setUniqueId(getUniqueId());
        this.eTf.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eSq.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eSK;
        userMuteCheckCustomMessage.setTag(this.eSK);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aSL() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.eSp != null && (pbData = this.eSp.getPbData()) != null) {
            return pbData.aRr().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aRh() != null) {
            if (fVar.aRh().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aRh().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aRh().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData ba(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bwC()) {
                postData.cW(postData.bwB() - 1);
            } else {
                postData.cW(postData.bwB() + 1);
            }
            postData.nc(!postData.bwC());
            ((PbFloorAgreeView) view).a(postData.bwC(), postData.bwB(), true);
            final int i = postData.bwC() ? 0 : 1;
            this.eSp.aUE().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pN(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).ql(i2);
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

    public com.baidu.tbadk.core.util.ak aSM() {
        return new com.baidu.tbadk.core.util.ak("c12003").ac("tid", this.eSp.eWO).r("obj_type", 0).ac(ImageViewerConfig.FORUM_ID, this.eSp.getForumId()).r("obj_param1", this.eSp.getPbData().aRh().getThreadType() == 40 ? 2 : 1);
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
                        PbActivity.this.aSI().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aSI().aVE() != null) {
                        PbActivity.this.eSD.Dd().setVisibility(8);
                        PbActivity.this.aSI().aVE().bG(str, str2);
                        com.baidu.tbadk.editortools.pb.h aTW = PbActivity.this.aSI().aVE().aTW();
                        if (aTW != null && PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null) {
                            aTW.a(PbActivity.this.eSp.getPbData().qi());
                        }
                        if (PbActivity.this.eSv.aWP() == null && PbActivity.this.aSI().aVE().aTW().Ed() != null) {
                            PbActivity.this.aSI().aVE().aTW().Ed().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.eSv != null && PbActivity.this.eSv.aWO() != null) {
                                        if (!PbActivity.this.eSv.aWO().bEV()) {
                                            PbActivity.this.eSv.ka(false);
                                        }
                                        PbActivity.this.eSv.aWO().nT(false);
                                    }
                                }
                            });
                            PbActivity.this.eSv.h(PbActivity.this.aSI().aVE().aTW().Ed().getInputView());
                            PbActivity.this.aSI().aVE().aTW().a(PbActivity.this.eSG);
                        }
                    }
                    PbActivity.this.aSI().aWv();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.eSp != null && this.eSp.getPbData() != null && postData.bwo() > 1) {
            String aUe = this.eSp.aUe();
            String id = postData.getId();
            int aRs = this.eSp.getPbData() != null ? this.eSp.getPbData().aRs() : 0;
            c pM = pM(id);
            if (pM != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(aUe, id, "pb", true, null, false, null, aRs, postData.aXW(), this.eSp.getPbData().qi(), false, postData.rx() != null ? postData.rx().getIconInfo() : null).addBigImageData(pM.eUg, pM.eUh, pM.eUi, pM.index);
                addBigImageData.setKeyPageStartFrom(this.eSp.aUL());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        ao aoVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (aSo() != null && aSo().getPbData() != null && aSo().getPbData().aRD() != null) {
                com.baidu.tieba.pb.data.l aRD = aSo().getPbData().aRD();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof ao)) {
                    aoVar = null;
                } else {
                    aoVar = (ao) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aRD != null) {
                    int i3 = -1;
                    if (z) {
                        aRD.pD(i);
                    } else if (aRD.aRN()) {
                        aRD.aRQ();
                        i3 = 1;
                    } else {
                        aRD.pF(i);
                        i3 = 0;
                    }
                    aRD.pE(i2);
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pN(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.eSp != null && this.eSp.aUE() != null) {
                        String str = "";
                        if (this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null) {
                            str = this.eSp.getPbData().aRh().rO();
                        }
                        if (this.eSp.getPbData() != null) {
                            this.eSp.getPbData().a(aRD);
                        }
                        if (z) {
                            this.eSp.aUE().a(str, 3, i, this.eSp.getForumId(), aVar);
                        } else {
                            this.eSp.aUE().a(str, i3, 3, i, this.eSp.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.eOX = i3;
                            kVar.eOY = aRD;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (aoVar != null) {
                        aoVar.b(aRD);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aSN() {
        if (this.eSp.getPbData() == null || this.eSp.getPbData().aRh() == null) {
            return -1;
        }
        return this.eSp.getPbData().aRh().sb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSO() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.qk(this.eSp.getForumId()) && this.eSp.getPbData() != null && this.eSp.getPbData().aRf() != null) {
            if (this.eSp.getPbData().aRf().isLike() == 1) {
                aTe();
                this.eSp.aUH().bJ(this.eSp.getForumId(), this.eSp.aUe());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean je(boolean z) {
        if (this.eSp == null || this.eSp.getPbData() == null) {
            return false;
        }
        return ((this.eSp.getPbData().aRs() != 0) || this.eSp.getPbData().aRh() == null || this.eSp.getPbData().aRh().rx() == null || TextUtils.equals(this.eSp.getPbData().aRh().rx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aSP() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.o.q.GU()) {
            return "";
        }
        PostData aRo = aRo();
        if (this.eSp == null || (pbData = this.eSp.getPbData()) == null || pbData.getUserData() == null || pbData.aRh() == null || aRo == null || aRo.rx() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aRo.rx().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aRh().rf() == 0) {
            return "";
        }
        if (pbData.aRh().rf() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean jf(boolean z) {
        if (z) {
            return true;
        }
        if (this.eSp == null || this.eSp.getPbData() == null) {
            return false;
        }
        return this.eSp.getPbData().aRs() != 0;
    }

    private boolean jg(boolean z) {
        return (z || this.eSp == null || this.eSp.getPbData() == null || this.eSp.getPbData().aRs() == 0) ? false : true;
    }

    public void aSQ() {
        if (this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null && this.eSp.getPbData().aRh().rx() != null) {
            if (this.eSq != null) {
                this.eSq.aVC();
            }
            bd aRh = this.eSp.getPbData().aRh();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aRh.rx().getUserId());
            aRh.rx().getGodUserData();
            ab abVar = new ab();
            int aRs = this.eSp.getPbData().aRs();
            if (aRs == 1) {
                abVar.eYP = true;
                abVar.eYO = true;
                abVar.eYW = aRh.rs() == 1;
                abVar.eYV = aRh.rt() == 1;
            } else {
                abVar.eYP = false;
                abVar.eYO = false;
            }
            if (aRs == 1002 && !equals) {
                abVar.eZa = true;
            }
            abVar.eYL = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            abVar.eYQ = jf(equals);
            abVar.eYR = aSR();
            abVar.eYS = jg(equals);
            abVar.eYM = this.eSp.aUf();
            abVar.eYN = true;
            abVar.ePm = this.etk != null && this.etk.nJ();
            abVar.eYK = je(equals);
            abVar.eYY = aSP();
            abVar.eYJ = equals && this.eSq.aWi();
            abVar.eYT = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.eYU = true;
            abVar.isHostOnly = this.eSp.getHostMode();
            abVar.eYX = true;
            if (aRh.rP() == null) {
                abVar.eYZ = true;
            } else {
                abVar.eYZ = false;
            }
            this.eSq.faG.a(abVar);
        }
    }

    private boolean aSR() {
        if (this.eSp != null && this.eSp.aUf()) {
            return this.eSp.avA() == null || this.eSp.avA().qx() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(View view) {
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

    public int aSS() {
        if (aSI() == null || aSI().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aSI().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) fVar).mType == com.baidu.tieba.pb.data.j.eOT) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aST() {
        if (aSI() == null || aSI().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aSI().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.gzf) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aTc();
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
                    PbActivity.this.apr.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.eSp.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).tk();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.eSq.aWb();
        this.eSp.jw(z);
        if (this.etk != null) {
            this.etk.ab(z);
            if (markData != null) {
                this.etk.a(markData);
            }
        }
        if (this.eSp.nJ()) {
            aSZ();
        } else {
            this.eSq.p(this.eSp.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pI(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(String str) {
        if (!StringUtils.isNull(str) && this.eSp != null) {
            String aUe = this.eSp.aUe();
            String id = this.eSp.getPbData().aRf().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + aUe + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.eSp.aUl()) {
                    antiData.setBlock_forum_name(this.eSp.getPbData().aRf().getName());
                    antiData.setBlock_forum_id(this.eSp.getPbData().aRf().getId());
                    antiData.setUser_name(this.eSp.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eSp.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.uq(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahQ));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahQ));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahQ));
            }
        } else if (i == 230277) {
            gd(str);
        } else {
            this.eSq.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eSq.a(0, bVar.Al, bVar.gBz, z);
            if (bVar.Al) {
                if (bVar.gBx == 1) {
                    ArrayList<PostData> aRj = this.eSp.getPbData().aRj();
                    int size = aRj.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aRj.get(i).getId())) {
                            i++;
                        } else {
                            aRj.remove(i);
                            break;
                        }
                    }
                    this.eSq.p(this.eSp.getPbData());
                } else if (bVar.gBx == 0) {
                    aSU();
                } else if (bVar.gBx == 2) {
                    ArrayList<PostData> aRj2 = this.eSp.getPbData().aRj();
                    int size2 = aRj2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aRj2.get(i2).bwl().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aRj2.get(i2).bwl().get(i3).getId())) {
                                i3++;
                            } else {
                                aRj2.get(i2).bwl().remove(i3);
                                aRj2.get(i2).bwn();
                                z2 = true;
                                break;
                            }
                        }
                        aRj2.get(i2).sZ(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eSq.p(this.eSp.getPbData());
                    }
                    a(bVar, this.eSq);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eSq.a(this.cbD.getLoadDataMode(), fVar.Al, fVar.gBz, false);
            if (fVar.Al) {
                this.eSs = true;
                if (i == 2 || i == 3) {
                    this.eSt = true;
                    this.eSu = false;
                } else if (i == 4 || i == 5) {
                    this.eSt = false;
                    this.eSu = true;
                }
                if (i == 2) {
                    this.eSp.getPbData().aRh().bT(1);
                    this.eSp.setIsGood(1);
                } else if (i == 3) {
                    this.eSp.getPbData().aRh().bT(0);
                    this.eSp.setIsGood(0);
                } else if (i == 4) {
                    this.eSp.getPbData().aRh().bS(1);
                    this.eSp.iO(1);
                } else if (i == 5) {
                    this.eSp.getPbData().aRh().bS(0);
                    this.eSp.iO(0);
                }
                this.eSq.c(this.eSp.getPbData(), this.eSp.aUf());
                if (this.eSp.getPbData().aRs() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void aSU() {
        if (this.eSp.aUg() || this.eSp.aUi()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eSp.aUe());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eSp.aUe()));
        if (aTa()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSV() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aRp;
        boolean z = true;
        if (this.eSq != null) {
            this.eSq.aWo();
        }
        if (this.eSp != null && this.eSp.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eSp.getPbData().aRh().getId();
            if (this.eSp.isShareThread() && this.eSp.getPbData().aRh().aaI != null) {
                historyMessage.threadName = this.eSp.getPbData().aRh().aaI.showText;
            } else {
                historyMessage.threadName = this.eSp.getPbData().aRh().getTitle();
            }
            if (this.eSp.isShareThread() && !aTu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.eSp.getPbData().aRf().getName();
            }
            ArrayList<PostData> aRj = this.eSp.getPbData().aRj();
            int aWd = this.eSq != null ? this.eSq.aWd() : 0;
            if (aRj != null && aWd >= 0 && aWd < aRj.size()) {
                historyMessage.postID = aRj.get(aWd).getId();
            }
            historyMessage.isHostOnly = this.eSp.getHostMode();
            historyMessage.isSquence = this.eSp.aUf();
            historyMessage.isShareThread = this.eSp.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eSD != null) {
            this.eSD.onDestroy();
        }
        if (this.eRY && aSI() != null) {
            aSI().aWI();
        }
        if (this.eSp != null && (this.eSp.aUg() || this.eSp.aUi())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eSp.aUe());
            if (this.eSs) {
                if (this.eSu) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.eSp.aUk());
                }
                if (this.eSt) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.eSp.getIsGood());
                }
            }
            if (this.eSp.getPbData() != null && System.currentTimeMillis() - this.eSc >= 40000 && (aRp = this.eSp.getPbData().aRp()) != null && !com.baidu.tbadk.core.util.v.w(aRp.getDataList())) {
                intent.putExtra("guess_like_data", aRp);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.eSR);
            }
            setResult(-1, intent);
        }
        if (aTa()) {
            if (this.eSp != null && this.eSq != null && this.eSq.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eSp.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aRn() && !this.eSi) {
                        ai aVn = ai.aVn();
                        com.baidu.tieba.pb.data.f pbData2 = this.eSp.getPbData();
                        Parcelable onSaveInstanceState = this.eSq.getListView().onSaveInstanceState();
                        boolean aUf = this.eSp.aUf();
                        boolean hostMode = this.eSp.getHostMode();
                        if (this.eSq.aVM() == null || this.eSq.aVM().getVisibility() != 0) {
                            z = false;
                        }
                        aVn.a(pbData2, onSaveInstanceState, aUf, hostMode, z);
                        if (this.eSQ >= 0 || this.eSp.aUN() != null) {
                            ai.aVn().j(this.eSp.aUN());
                            ai.aVn().i(this.eSp.aUO());
                            ai.aVn().qd(this.eSp.aUP());
                        }
                    }
                }
            } else {
                ai.aVn().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eSq == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eSq.qg(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pK(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.eSq.aVC();
            this.eSq.aVE().aTS();
            this.eSq.jV(false);
        }
        this.eSq.aVF();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.eSD.resetData();
                        this.eSD.b(writeData);
                        this.eSD.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.r eP = this.eSD.Dd().eP(6);
                        if (eP != null && eP.aBO != null) {
                            eP.aBO.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.eSD.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.eSq.aVE() != null && this.eSq.aVE().aTU() != null) {
                            com.baidu.tbadk.editortools.pb.h aTU = this.eSq.aVE().aTU();
                            aTU.b(writeData);
                            aTU.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.r eP2 = aTU.Dd().eP(6);
                            if (eP2 != null && eP2.aBO != null) {
                                eP2.aBO.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                aTU.DV();
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
        this.eSD.onActivityResult(i, i2, intent);
        if (this.eSm != null) {
            this.eSm.onActivityResult(i, i2, intent);
        }
        if (aSI().aVE() != null) {
            aSI().aVE().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aSY();
                    return;
                case 13008:
                    ai.aVn().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eSp != null) {
                                PbActivity.this.eSp.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eSp != null) {
                        a(aSX(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aSN() == 1) {
                        aSW();
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aSO();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.cWG != null && shareItem != null && shareItem.linkUrl != null) {
                            this.cWG.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void zL() {
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
                    this.eSq.jc(false);
                    if (this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null && this.eSp.getPbData().aRh().rS() != null) {
                        this.eSp.getPbData().aRh().rS().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.eSq != null && this.eSq.faG != null) {
                        this.eSq.faG.ot();
                        this.eSq.faG.aXc();
                        if (this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null) {
                            this.eSp.getPbData().aRh().bO(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.eSn != null) {
                        this.eSq.bj(this.eSn);
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
            if (this.eSm == null) {
                this.eSm = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.eSm.b(this.aDG);
                this.eSm.c(this.aDN);
            }
            this.eSm.a(emotionImageData, aSo(), aSo().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSW() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null && this.eSp.getPbData().aRh().rJ() != null && this.eSp.getPbData().aRh().rJ().size() > 0 && this.eSp.getPbData().aRh().rJ().get(0) != null) {
            this.mAwardActId = this.eSp.getPbData().aRh().rJ().get(0).pu();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eSp.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void S(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    pM(2);
                    return;
                case 2:
                    this.eSq.aVT();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aSX() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bP = this.eSp.getPbData().bP(getPageContext().getPageActivity());
        PostData aVH = this.eSq.aVH();
        String str = "";
        if (aVH != null) {
            str = aVH.getId();
            String cf = aVH.cf(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(cf)) {
                bP[1] = cf;
            }
        }
        String rO = this.eSp.getPbData().aRh().rO();
        if (rO != null && rO.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bP[1]);
        shareFromPBMsgData.setImageUrl(bP[0]);
        shareFromPBMsgData.setForumName(this.eSp.getPbData().aRf().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eSp.getPbData().aRh().getId());
        shareFromPBMsgData.setTitle(this.eSp.getPbData().aRh().getTitle());
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(aSX(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(getPageContext().getPageActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ac = new com.baidu.tbadk.core.util.ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eSp.getForumId()).ac("tid", PbActivity.this.eSp.aUe());
                        if (PbActivity.this.e(PbActivity.this.eSp.getPbData()) != 0) {
                            ac.r("obj_type", PbActivity.this.e(PbActivity.this.eSp.getPbData()));
                        }
                        TiebaStatic.log(ac);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aSN() == 1) {
                        PbActivity.this.aSW();
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
            aVar.b(getPageContext()).tk();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.H(shareFromPBMsgData.getImageUrl(), this.eSp.getPbData().aRt() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null) {
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
                    if (PbActivity.this.aSN() == 1) {
                        PbActivity.this.aSW();
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
            aVar.b(getPageContext()).tk();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.H(shareFromPBMsgData.getImageUrl(), this.eSp.getPbData().aRt() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSY() {
        MarkData qa;
        if (this.etk != null && (qa = this.eSp.qa(this.eSq.aWe())) != null) {
            if (!qa.isApp() || (qa = this.eSp.qa(this.eSq.aWe() + 1)) != null) {
                this.eSq.aVZ();
                this.etk.a(qa);
                if (!this.etk.nJ()) {
                    this.etk.nL();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.etk.nK();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSZ() {
        com.baidu.tieba.pb.data.f pbData = this.eSp.getPbData();
        this.eSp.jw(true);
        if (this.etk != null) {
            pbData.pG(this.etk.nI());
        }
        this.eSq.p(pbData);
    }

    private boolean aTa() {
        if (this.eSp == null) {
            return true;
        }
        if (this.eSp.nJ()) {
            final MarkData aUt = this.eSp.aUt();
            if (aUt == null || !this.eSp.getIsFromMark()) {
                return true;
            }
            final MarkData qa = this.eSp.qa(this.eSq.aWd());
            if (qa == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", aUt);
                setResult(-1, intent);
                return true;
            } else if (qa.getPostId() == null || qa.getPostId().equals(aUt.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", aUt);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cS(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.etk != null) {
                            if (PbActivity.this.etk.nJ()) {
                                PbActivity.this.etk.nK();
                                PbActivity.this.etk.ab(false);
                            }
                            PbActivity.this.etk.a(qa);
                            PbActivity.this.etk.ab(true);
                            PbActivity.this.etk.nL();
                        }
                        aUt.setPostId(qa.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", aUt);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aSV();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", aUt);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aSV();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eSq != null && PbActivity.this.eSq.getView() != null) {
                            PbActivity.this.eSq.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", aUt);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aSV();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.tk();
                return false;
            }
        } else if (this.eSp.getPbData() == null || this.eSp.getPbData().aRj() == null || this.eSp.getPbData().aRj().size() <= 0 || !this.eSp.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eSq == null) {
            return null;
        }
        return this.eSq.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int JV() {
        if (this.eSq == null) {
            return 0;
        }
        return this.eSq.aWm();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> JW() {
        if (this.aVv == null) {
            this.aVv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: YQ */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean pg = com.baidu.tbadk.core.h.pa().pg();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.C0082d.common_color_10220));
                    if (pg) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0082d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView o(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.h.pa().pg()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0082d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aVv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> JX() {
        if (this.aVw == null) {
            this.aVw = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aVw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> JY() {
        if (this.aVA == null) {
            this.aVA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTw */
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
        return this.aVA;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> JZ() {
        if (this.aVx == null) {
            this.aVx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTx */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bd */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: be */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bf */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aVx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Kb() {
        this.aVz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aTy */
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
        return this.aVz;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wO() {
        if (this.aoO == null) {
            this.aoO = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoO;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eSg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        if (aw.pX(str) && this.eSp != null && this.eSp.aUe() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").r("obj_param1", 1).ac("post_id", this.eSp.aUe()));
        }
        aw.aWR().f(getPageContext(), str);
        this.eSg = true;
    }

    private com.baidu.tbadk.core.dialog.a aTb() {
        if (this.eSb == null) {
            this.eSb = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eSb.cR(getPageContext().getString(d.j.download_baidu_video_dialog));
            this.eSb.a(getPageContext().getString(d.j.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.dG()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.uk());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.j.download_baidu_video));
                    }
                }
            });
            this.eSb.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eSb.ao(true);
            this.eSb.b(getPageContext());
            this.eSb.ap(false);
        }
        this.eSb.tk();
        return this.eSb;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        aw.aWR().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eSg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra(VrPlayerActivityConfig.TITLE, "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aTb();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eSg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eSp.getPbData();
            TbRichText at = at(str, i);
            if (at != null && (tbRichTextData = at.Jq().get(this.eTu)) != null) {
                cVar.eUg = new ArrayList<>();
                cVar.eUh = new ConcurrentHashMap<>();
                if (!tbRichTextData.Jw().JI()) {
                    cVar.eUj = false;
                    String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                    cVar.eUg.add(b2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = at.getPostId();
                    imageUrlData.mIsReserver = this.eSp.aUs();
                    imageUrlData.mIsSeeHost = this.eSp.getHostMode();
                    cVar.eUh.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aRf() != null) {
                            cVar.forumName = pbData.aRf().getName();
                            cVar.forumId = pbData.aRf().getId();
                        }
                        if (pbData.aRh() != null) {
                            cVar.threadId = pbData.aRh().getId();
                        }
                        cVar.eUi = pbData.aRt() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.eUj = true;
                int size = pbData.aRj().size();
                this.eTv = false;
                cVar.index = -1;
                if (pbData.aRo() != null) {
                    PostData aRo = pbData.aRo();
                    TbRichText bwr = aRo.bwr();
                    if (!aq.k(aRo)) {
                        i2 = a(bwr, at, i, i, cVar.eUg, cVar.eUh);
                    } else {
                        i2 = a(aRo, i, cVar.eUg, cVar.eUh);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aRj().get(i4);
                    if (postData.getId() == null || pbData.aRo() == null || pbData.aRo().getId() == null || !postData.getId().equals(pbData.aRo().getId())) {
                        TbRichText bwr2 = postData.bwr();
                        if (!aq.k(postData)) {
                            i3 = a(bwr2, at, i3, i, cVar.eUg, cVar.eUh);
                        } else {
                            i3 = a(postData, i3, cVar.eUg, cVar.eUh);
                        }
                    }
                }
                if (cVar.eUg.size() > 0) {
                    cVar.lastId = cVar.eUg.get(cVar.eUg.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aRf() != null) {
                        cVar.forumName = pbData.aRf().getName();
                        cVar.forumId = pbData.aRf().getId();
                    }
                    if (pbData.aRh() != null) {
                        cVar.threadId = pbData.aRh().getId();
                    }
                    cVar.eUi = pbData.aRt() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Jw() == null) {
            return null;
        }
        return tbRichTextData.Jw().JM();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Jw() == null) {
            return 0L;
        }
        return tbRichTextData.Jw().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Jw() == null) {
            return false;
        }
        return tbRichTextData.Jw().JN();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Jw() == null) {
            return false;
        }
        return tbRichTextData.Jw().JO();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Jw;
        if (tbRichText == tbRichText2) {
            this.eTv = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Jq().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Jq().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int af = (int) com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.Jw().getWidth() * af;
                    int height = af * tbRichTextData.Jw().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.Jw().JI()) {
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
                            if (tbRichTextData != null && (Jw = tbRichTextData.Jw()) != null) {
                                String JK = Jw.JK();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = JK;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eSp.aUe(), -1L);
                                imageUrlData.mIsReserver = this.eSp.aUs();
                                imageUrlData.mIsSeeHost = this.eSp.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eTv) {
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
        com.baidu.tieba.tbadkCore.data.h bwx;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bvU;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bvU = (bwx = postData.bwx()).bvU()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bvU.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bvU.get(i3);
                if (jVar != null) {
                    String bvY = jVar.bvY();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bvY)) {
                        arrayList.add(bvY);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bvY;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bvX();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eSp.aUe(), -1L);
                        imageUrlData.mIsReserver = this.eSp.aUs();
                        imageUrlData.mIsSeeHost = this.eSp.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bwx.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bvY, imageUrlData);
                        }
                        if (!this.eTv) {
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
            if (postData.getId() != null && postData.getId().equals(this.eSp.rH())) {
                z = true;
            }
            MarkData h = this.eSp.h(postData);
            if (h != null) {
                this.eSq.aVZ();
                if (this.etk != null) {
                    this.etk.a(h);
                    if (!z) {
                        this.etk.nL();
                    } else {
                        this.etk.nK();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText at(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eSp == null || this.eSp.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eSp.getPbData();
        if (pbData.aRo() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aRo());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aRj = pbData.aRj();
            a(pbData, aRj);
            return a(aRj, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aRr() != null && fVar.aRr().ePo != null && (list = fVar.aRr().ePo) != null && arrayList != null) {
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
        ArrayList<PostData> aRj;
        com.baidu.tieba.pb.data.f pbData = this.eSp.getPbData();
        if (pbData != null && (aRj = pbData.aRj()) != null && !aRj.isEmpty()) {
            Iterator<PostData> it = aRj.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bwx = next.bwx();
                if (bwx != null && bwx.gyN) {
                    Iterator<TbRichTextData> it2 = next.bwr().Jq().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.JF().getLink().equals(str)) {
                            return bwx.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Jq;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bwr = arrayList.get(i2).bwr();
            if (bwr != null && (Jq = bwr.Jq()) != null) {
                int size = Jq.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Jq.get(i4) != null && Jq.get(i4).getType() == 8) {
                        i3++;
                        if (Jq.get(i4).Jw().JK().equals(str)) {
                            int af = (int) com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
                            int width = Jq.get(i4).Jw().getWidth() * af;
                            int height = Jq.get(i4).Jw().getHeight() * af;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eTu = i4;
                            return bwr;
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
            this.eRD = str;
            if (this.eSa == null) {
                aSK();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eSa.cl(1).setVisibility(8);
            } else {
                this.eSa.cl(1).setVisibility(0);
            }
            this.eSa.to();
            this.eSg = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cGZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTc() {
        hideNetRefreshView(this.eSq.getView());
        aTd();
        if (this.eSp.Fy()) {
            this.eSq.aVZ();
        }
    }

    private void aTd() {
        showLoadingView(this.eSq.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View ET = getLoadingView().ET();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ET.getLayoutParams();
        layoutParams.addRule(3, this.eSq.aWA().getId());
        ET.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void als() {
        if (this.cGZ != null) {
            this.cGZ.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL(int i) {
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
    public void pM(int i) {
        boolean z;
        String str;
        Uri parse;
        if (this.eSp.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eSp.getPbData();
            pbData.aRf().getName();
            String title = pbData.aRh().getTitle();
            int i2 = this.eSp.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aRf() != null) {
                if ((pbData.aRf().isLike() == 1) && AddExperiencedModel.qk(pbData.getForumId())) {
                    z = true;
                    String str2 = "http://tieba.baidu.com/p/" + this.eSp.aUe() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bP = pbData.bP(getPageContext().getPageActivity());
                    str = bP[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    String str3 = bP[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aSN() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                    } else if (aSN() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                    }
                    String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str3);
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = format;
                    dVar.linkUrl = str2;
                    dVar.aur = true;
                    dVar.auv = z;
                    dVar.extData = this.eSp.aUe();
                    dVar.auF = 3;
                    dVar.auE = i;
                    dVar.fid = this.eSp.getForumId();
                    dVar.tid = this.eSp.aUe();
                    dVar.auG = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.auz = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.eSp.getPbData().aRh());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.auF);
                    bundle.putInt("obj_type", dVar.auG);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString(SapiAccountManager.SESSION_UID, dVar.uid);
                    dVar.e(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRE()) {
                                PbActivity.this.eSq.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    if (this.anT == null) {
                        this.anT = new com.baidu.tieba.d.c(getActivity());
                    }
                    this.anT.a(shareDialogConfig);
                }
            }
            z = false;
            String str22 = "http://tieba.baidu.com/p/" + this.eSp.aUe() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bP2 = pbData.bP(getPageContext().getPageActivity());
            str = bP2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            String str32 = bP2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aSN() != 1) {
            }
            String format2 = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str32);
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = format2;
            dVar2.linkUrl = str22;
            dVar2.aur = true;
            dVar2.auv = z;
            dVar2.extData = this.eSp.aUe();
            dVar2.auF = 3;
            dVar2.auE = i;
            dVar2.fid = this.eSp.getForumId();
            dVar2.tid = this.eSp.aUe();
            dVar2.auG = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.eSp.getPbData().aRh());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.auF);
            bundle2.putInt("obj_type", dVar2.auG);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString(SapiAccountManager.SESSION_UID, dVar2.uid);
            dVar2.e(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.eSp != null && PbActivity.this.eSp.getPbData() != null && PbActivity.this.eSp.getPbData().aRE()) {
                        PbActivity.this.eSq.getView().setSystemUiVisibility(4);
                    }
                }
            });
            if (this.anT == null) {
            }
            this.anT.a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aRh() != null) {
            if (fVar.aRh().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aRh().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void aTe() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.ql(PbActivity.this.eSp.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eSq.aWJ();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Ka() {
        if (this.aVy == null) {
            this.aVy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTz */
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
        return this.aVy;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eSq.aVU() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, this.eSp.getPbData().getForumId()));
            } else {
                bd aRh = this.eSp.getPbData().aRh();
                if (view != null) {
                    boolean z = aRh.rm() == null || aRh.rm().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eTg > 1000) {
                            this.eTh = true;
                            bc(view);
                        } else {
                            this.eTh = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            m(view, this.eTh);
                        } else {
                            l(view, this.eTh);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        l(view, this.eTh);
                    } else if (motionEvent.getAction() == 3) {
                        l(view, this.eTh);
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
                    PbActivity.this.eTg = System.currentTimeMillis();
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
                    PbActivity.this.eTg = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bc(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    public void alt() {
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
        } else if (aVar.tm() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tm();
            int intValue = ((Integer) sparseArray.get(ar.fcx)).intValue();
            if (intValue == ar.fcy) {
                if (!this.cbD.bxc()) {
                    this.eSq.aVW();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cbD.a(this.eSp.getPbData().aRf().getId(), this.eSp.getPbData().aRf().getName(), this.eSp.getPbData().aRh().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ar.fcz || intValue == ar.fcB) {
                if (this.eSp.aUD() != null) {
                    this.eSp.aUD().pQ(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.fcz) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ar.fcA) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eTA).pp()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eSK);
        userMuteAddAndDelCustomMessage.setTag(this.eSK);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pL(String str) {
        if (!StringUtils.isNull(str) && ax.aV(getPageContext().getPageActivity())) {
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

    public void jh(boolean z) {
        this.eSy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aTf() {
        ArrayList<PostData> aRj;
        int v;
        if (this.eSp == null || this.eSp.getPbData() == null || this.eSp.getPbData().aRj() == null || (v = com.baidu.tbadk.core.util.v.v((aRj = this.eSp.getPbData().aRj()))) == 0) {
            return "";
        }
        if (this.eSp.aUs()) {
            Iterator<PostData> it = aRj.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bwo() == 1) {
                    return next.getId();
                }
            }
        }
        int aWd = this.eSq.aWd();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aRj, aWd);
        if (postData == null || postData.rx() == null) {
            return "";
        }
        if (this.eSp.pP(postData.rx().getUserId())) {
            return postData.getId();
        }
        for (int i = aWd - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aRj, i);
            if (postData2 == null || postData2.rx() == null || postData2.rx().getUserId() == null) {
                break;
            } else if (this.eSp.pP(postData2.rx().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aWd + 1; i2 < v; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aRj, i2);
            if (postData3 == null || postData3.rx() == null || postData3.rx().getUserId() == null) {
                return "";
            }
            if (this.eSp.pP(postData3.rx().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.av.vL().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(pK(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eSp.getPbData().aRf().getId(), this.eSp.getPbData().aRf().getName(), this.eSp.getPbData().aRh().getTid());
            }
            this.eSg = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eSp.aUC() != null) {
                    PbActivity.this.eSp.aUC().cx(j);
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
        aVar.tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c pM(String str) {
        String str2;
        if (this.eSp.getPbData() == null || this.eSp.getPbData().aRj() == null || this.eSp.getPbData().aRj().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.eSp.getPbData().aRj().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eSp.getPbData().aRj().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eSp.getPbData().aRj().get(i);
        if (postData.bwr() == null || postData.bwr().Jq() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bwr().Jq().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Jw() != null) {
                    str2 = next.Jw().JK();
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
        if (this.eRW) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eRW = false;
        } else if (aTg()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eRW) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eRW = false;
        } else if (aTg()) {
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
        if (pageStayDurationItem != null && this.eSp != null) {
            if (this.eSp.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eSp.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eSp.aUe(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aTg() {
        return (!this.eRU && this.eTC == -1 && this.eTD == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.eTF = mVar;
            this.eRU = true;
            this.eSq.aVN();
            this.eSq.pV(this.eTE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTh() {
        if (this.eTF != null) {
            if (this.eTC == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aU(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eTF.getCartoonId(), this.eTC, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTi() {
        if (this.eTF != null) {
            if (this.eTD == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aU(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eTF.getCartoonId(), this.eTD, 0)));
                finish();
            }
        }
    }

    public int aTj() {
        return this.eTC;
    }

    public int aTk() {
        return this.eTD;
    }

    private void auV() {
        if (this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null && this.eSp.getPbData().aRh().sk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aTl() {
        if (this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null && this.eSp.getPbData().aRh().sk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aTm() {
        if (this.eRX) {
            this.eSl = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null && this.eSp.getPbData().aRh().rd() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eSp.getPbData().aRh().rd().getThreadId(), this.eSp.getPbData().aRh().rd().getTaskId(), this.eSp.getPbData().aRh().rd().getForumId(), this.eSp.getPbData().aRh().rd().getForumName(), this.eSp.getPbData().aRh().rs(), this.eSp.getPbData().aRh().rt())));
            this.eRW = true;
            finish();
        }
    }

    public boolean aTn() {
        return this.eRX;
    }

    public String aTo() {
        return this.eSj;
    }

    public PbInterviewStatusView.a aTp() {
        return this.eSo;
    }

    public void ji(boolean z) {
        this.eSk = z;
    }

    public boolean aTq() {
        if (this.eSp != null) {
            return this.eSp.aUg();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eSI).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eSI.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eSI).tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eSI != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSI.getPageActivity());
            aVar.cS(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eSI).tk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eSq.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSI.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cS(this.eSI.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eSq.showLoadingDialog();
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
        aVar.b(this.eSI).tk();
    }

    public void aTs() {
        if (this.eSp != null && this.eSp.getPbData() != null && this.eSp.getPbData().aRh() != null && this.eSp.getPbData().aRh().sC() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cd(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eSp.getPbData().aRh().sC().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.tk();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
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
        if (this.eSq != null) {
            this.eSq.onConfigurationChanged(configuration);
        }
        if (this.eSw != null) {
            this.eSw.dismiss();
        }
    }

    public boolean aTt() {
        if (this.eSp != null) {
            return this.eSp.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.eSp.getPbData().aRr().ePo;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bwl().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bwl().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bwl().remove(i2);
                    list.get(i).bwn();
                    z = true;
                    break;
                }
            }
            list.get(i).sZ(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.p(this.eSp.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aRT().getId();
        List<PostData> list = this.eSp.getPbData().aRr().ePo;
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
                ArrayList<PostData> aRX = mVar.aRX();
                postData.uk(mVar.getTotalCount());
                if (postData.bwl() != null) {
                    postData.bwl().clear();
                    postData.bwl().addAll(aRX);
                }
            }
        }
        if (!this.eSp.getIsFromMark()) {
            this.eSq.p(this.eSp.getPbData());
        }
    }

    public boolean aTu() {
        if (this.eSp == null) {
            return false;
        }
        return this.eSp.aTu();
    }

    public void aTv() {
        if (this.eSq != null) {
            this.eSq.aVC();
            alt();
        }
    }

    public PostData aRo() {
        return this.eSq.b(this.eSp.eXh, this.eSp.aUf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.isLinkThread()) {
                return 3;
            }
            if (bdVar.sE()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.eSS != null && !this.eSS.isEmpty()) {
            int size = this.eSS.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.eSS.get(i).onBackPressed()) {
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
            if (this.eSS == null) {
                this.eSS = new ArrayList();
            }
            if (!this.eSS.contains(aVar)) {
                this.eSS.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.eSS != null) {
            this.eSS.remove(aVar);
        }
    }
}
