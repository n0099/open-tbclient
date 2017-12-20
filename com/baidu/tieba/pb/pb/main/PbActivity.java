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
    private com.baidu.adp.lib.e.b<LinearLayout> aVA;
    private com.baidu.adp.lib.e.b<RelativeLayout> aVB;
    private com.baidu.adp.lib.e.b<GifView> aVC;
    private com.baidu.adp.lib.e.b<ImageView> aVx;
    private com.baidu.adp.lib.e.b<TextView> aVy;
    private com.baidu.adp.lib.e.b<View> aVz;
    private com.baidu.tieba.d.c anV;
    private com.baidu.adp.lib.e.b<TbImageView> aoR;
    private com.baidu.tieba.e.b bHL;
    private VoiceManager cHh;
    private String eSG;
    private com.baidu.tieba.pb.pb.main.a.b eSY;
    private boolean eTB;
    private com.baidu.tieba.tbadkCore.data.e eTE;
    private com.baidu.tbadk.editortools.pb.g eTF;
    private com.baidu.tbadk.editortools.pb.d eTG;
    private com.baidu.adp.base.e eTL;
    private com.baidu.tbadk.core.view.d eTM;
    private BdUniqueId eTN;
    private Runnable eTO;
    private av eTP;
    private com.baidu.adp.widget.a.a eTQ;
    private String eTR;
    private TbRichTextMemeInfo eTS;
    private List<a> eTV;
    private com.baidu.tbadk.core.dialog.a eTe;
    private com.baidu.tieba.pb.pb.main.emotion.model.a eTp;
    private View eTq;
    public at eTy;
    private y eTz;
    private String eUH;
    private com.baidu.tbadk.core.data.m eUI;
    private boolean eUv;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eSX = false;
    private boolean eSZ = false;
    private boolean eTa = false;
    private boolean ewY = false;
    private boolean eTb = true;
    private int eTc = 0;
    private com.baidu.tbadk.core.dialog.b eTd = null;
    private long ctu = -1;
    private long aKw = 0;
    private long eTf = 0;
    private long createTime = 0;
    private long aKo = 0;
    private boolean eTg = false;
    private com.baidu.tbadk.k.d eTh = null;
    private long eTi = 0;
    private boolean eTj = false;
    private long eTk = 0;
    private String aDI = null;
    private boolean eTl = false;
    private boolean isFullScreen = false;
    private String eTm = "";
    private boolean eTn = true;
    private boolean eTo = false;
    private String source = "";
    private PbInterviewStatusView.a eTr = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eTt.jP(!PbActivity.this.eTn);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eTs != null && PbActivity.this.eTs.nH()) {
                        PbActivity.this.aTh();
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahM));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahM));
        }
    };
    private PbModel eTs = null;
    private com.baidu.tbadk.baseEditMark.a euo = null;
    private ForumManageModel cbH = null;
    private com.baidu.tbadk.coreExtra.model.a apu = null;
    private ShareSuccessReplyToServerModel cWR = null;
    private ar eTt = null;
    public final com.baidu.tieba.pb.pb.main.a.a eTu = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eTv = false;
    private boolean eTw = false;
    private boolean eTx = false;
    private boolean eTA = false;
    private boolean eTC = false;
    private boolean eTD = false;
    private boolean eTH = false;
    public boolean eTI = false;
    private com.baidu.tbadk.editortools.pb.c aDL = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void DB() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aDM = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean DA() {
            if (PbActivity.this.eTy == null || PbActivity.this.eTy.aWV() == null || !PbActivity.this.eTy.aWV().bFF()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eTy.aWV().bFH());
            if (PbActivity.this.eTG != null && (PbActivity.this.eTG.DP() || PbActivity.this.eTG.DQ())) {
                PbActivity.this.eTG.a(false, PbActivity.this.eTy.aWY());
            }
            PbActivity.this.eTy.ka(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b eTJ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean DA() {
            if (PbActivity.this.eTy == null || PbActivity.this.eTy.aWW() == null || !PbActivity.this.eTy.aWW().bFF()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.eTy.aWW().bFH());
            if (PbActivity.this.eTt != null && PbActivity.this.eTt.aVM() != null && PbActivity.this.eTt.aVM().aUe() != null && PbActivity.this.eTt.aVM().aUe().DQ()) {
                PbActivity.this.eTt.aVM().aUe().a(PbActivity.this.eTy.aWY());
            }
            PbActivity.this.eTy.kb(true);
            return true;
        }
    };
    private boolean eTK = false;
    private int mLastScrollState = -1;
    private boolean cHN = false;
    private int eTT = 0;
    private int eTU = -1;
    private final z.a eTW = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void C(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eTt.showToast(str);
            }
        }
    };
    private final CustomMessageListener eTX = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eTs != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eTG != null) {
                    PbActivity.this.eTt.jU(PbActivity.this.eTG.DI());
                }
                PbActivity.this.eTt.aVN();
                PbActivity.this.eTt.aWw();
            }
        }
    };
    CustomMessageListener cId = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
                PbActivity.this.eTs.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                if (PbActivity.this.eTt != null && PbActivity.this.eTs != null) {
                    PbActivity.this.eTt.d(PbActivity.this.eTs.getPbData(), PbActivity.this.eTs.aUn(), PbActivity.this.eTs.aUF());
                }
                if (PbActivity.this.eTt != null && PbActivity.this.eTt.aWd() != null) {
                    PbActivity.this.eTt.aWd().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eTY = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eTt != null) {
                    if (booleanValue) {
                        PbActivity.this.eTt.aBv();
                    } else {
                        PbActivity.this.eTt.aBu();
                    }
                }
            }
        }
    };
    private CustomMessageListener eTZ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eTG != null) {
                    PbActivity.this.eTt.jU(PbActivity.this.eTG.DI());
                }
                PbActivity.this.eTt.jW(false);
            }
        }
    };
    private CustomMessageListener eUa = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
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
    private CustomMessageListener eUb = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eTt != null && PbActivity.this.eTt.aWd() != null) {
                PbActivity.this.eTt.aWd().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dER = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private j.a eUc = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.pS(2);
                ai.aVv().reset();
                PbActivity.this.eTs.aUG();
                boolean z2 = false;
                ArrayList<PostData> aRr = PbActivity.this.eTs.getPbData().aRr();
                if (aRr != null) {
                    Iterator<PostData> it = aRr.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.bxd().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eTt.p(PbActivity.this.eTs.getPbData());
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
    private View.OnClickListener aEt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aDI);
        }
    };
    private CustomMessageListener eUd = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x)) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = xVar.id;
                aVar.giftName = xVar.name;
                aVar.WS = xVar.WS;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTs.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eTs.aUw() != null && PbActivity.this.eTs.aUw().getUserIdLong() == xVar.toUserId) {
                        PbActivity.this.eTt.a(xVar.sendCount, PbActivity.this.eTs.getPbData(), PbActivity.this.eTs.aUn(), PbActivity.this.eTs.aUF());
                    }
                    if (pbData.aRr() != null && pbData.aRr().size() >= 1 && pbData.aRr().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aRr().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eTs.aUm(), 0L);
                        if (c2 == xVar.postId && c3 == xVar.threadId) {
                            com.baidu.tbadk.core.data.am bxc = pbData.aRr().get(0).bxc();
                            if (bxc == null) {
                                bxc = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> qx = bxc.qx();
                            if (qx == null) {
                                qx = new ArrayList<>();
                            }
                            qx.add(0, aVar);
                            bxc.bM(xVar.sendCount + bxc.qw());
                            bxc.g(qx);
                            pbData.aRr().get(0).a(bxc);
                            PbActivity.this.eTt.aWd().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eUe = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.ahM() != null && !aVar.ahM().isEmpty()) {
                    PbActivity.this.eTt.a(aVar, PbActivity.this.eUg);
                }
                PbActivity.this.eTt.a(aVar, PbActivity.this.eTs.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.aXb()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a eUf = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void C(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.w(list) && PbActivity.this.eTt != null) {
                PbActivity.this.eTt.cL(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eUg = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
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
    private boolean eUh = false;
    private PraiseModel eUi = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hW(String str) {
            PbActivity.this.eUh = false;
            if (PbActivity.this.eUi != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTs.getPbData();
                if (pbData.aRp().rk().getIsLike() == 1) {
                    PbActivity.this.kp(0);
                } else {
                    PbActivity.this.kp(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aRp()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void F(int i, String str) {
            PbActivity.this.eUh = false;
            if (PbActivity.this.eUi != null && str != null) {
                if (AntiHelper.uB(i)) {
                    AntiHelper.am(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eUj = 0;
    private boolean eUk = true;
    private b.a eUl = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jk(boolean z) {
            PbActivity.this.jj(z);
            if (PbActivity.this.eTt.aWH() != null && z) {
                PbActivity.this.eTt.jP(false);
            }
            PbActivity.this.eTt.jR(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().asp != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().asp, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahM));
                        }
                    } else if (updateAttentionMessage.getData().BI) {
                        if (PbActivity.this.aRw().rv() != null && PbActivity.this.aRw().rv().getGodUserData() != null) {
                            PbActivity.this.aRw().rv().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRp() != null && PbActivity.this.eTs.getPbData().aRp().rv() != null) {
                            PbActivity.this.eTs.getPbData().aRp().rv().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bHm = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eTt.XC();
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
                    com.baidu.tieba.h.a.atf();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aVH = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eTt.aVO()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eTs != null && (PbActivity.this.eTs.getPbData() != null || PbActivity.this.eTs.getPbData().aRL() != null)) {
                    if (PbActivity.this.eTs.getPbData().aRL().aRV()) {
                        if (PbActivity.this.eTs.getPbData().aRL().eQa == 1 || PbActivity.this.eTs.getPbData().aRL().eQa == 3 || PbActivity.this.eTs.getPbData().aRL().eQa == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.aSU().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eTs.getPbData().aRL().aRV() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.aSU().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eTs.getPbData().aRL().aRV() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eTk > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).kv(false);
                        PbActivity.this.eTk = System.currentTimeMillis();
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
                    if (PbActivity.this.eTt != null && PbActivity.this.eTt.aSR() && (view.getId() == d.g.pb_head_user_info_root || view == PbActivity.this.eTt.aWO())) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ac("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.eTu != null && PbActivity.this.eTu.ffS != null) {
                            PbActivity.this.eTu.ffS.onClick(view);
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
            if (PbActivity.this.eTG != null) {
                PbActivity.this.eTt.jU(PbActivity.this.eTG.DI());
            }
            PbActivity.this.eTt.aVN();
            PbActivity.this.eTt.aWw();
            return true;
        }
    });
    private CustomMessageListener eUm = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eTN) {
                PbActivity.this.eTt.XC();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTs.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aRC().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eTM.c(PbActivity.this.eTL.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eTL.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aTz();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eTL.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.eTM.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eUn = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eTN) {
                PbActivity.this.eTt.XC();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eTM.c(PbActivity.this.eTL.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eTL.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.eTM.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eUo = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eTN) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eTt.XC();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gPt;
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
                    PbActivity.this.eTt.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eUp = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eTt.aVO() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aSw() != null && PbActivity.this.aSw().getPbData() != null && PbActivity.this.aSw().getPbData().aRL() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aRV = PbActivity.this.aSw().getPbData().aRL().aRV();
                if (intValue < 10) {
                    if (aRV) {
                        if (PbActivity.this.eTs.getPbData().aRL().eQa == 1 || PbActivity.this.eTs.getPbData().aRL().eQa == 3 || PbActivity.this.eTs.getPbData().aRL().eQa == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.aSU().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eTs.getPbData().aRL().aRV() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.aSU().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aRV ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eTk > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).kv(false);
                        PbActivity.this.eTk = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aRV, 3);
                TiebaStatic.log(PbActivity.this.aSU().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aRV ? 0 : 1));
            }
        }
    };
    private CustomMessageListener cIn = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cHN = true;
                }
            }
        }
    };
    public a.b eGz = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.alC();
            com.baidu.tbadk.core.data.al avI = PbActivity.this.eTs.avI();
            int pageNum = PbActivity.this.eTt.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (avI == null || pageNum <= avI.qp()) {
                PbActivity.this.eTt.aWw();
                PbActivity.this.pS(2);
                PbActivity.this.alB();
                PbActivity.this.eTt.aWh();
                if (com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.eTs.qa(PbActivity.this.eTt.getPageNum());
                    if (PbActivity.this.eSY != null) {
                        PbActivity.this.eSY.showFloatingView();
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
    public final View.OnClickListener cIJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
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
            com.baidu.tieba.pb.data.l aRL;
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
                    if (view == PbActivity.this.eTt.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.eTs.jv(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.eTt.aWi();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aVo()) {
                        if (view == PbActivity.this.eTt.fbJ.aMr) {
                            if (PbActivity.this.eTt.jT(PbActivity.this.eTs.aUt())) {
                                PbActivity.this.alB();
                                return;
                            }
                            PbActivity.this.eTb = false;
                            PbActivity.this.eSZ = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eTt.aWf() && (PbActivity.this.eTt.fbJ.aXk() == null || (view != PbActivity.this.eTt.fbJ.aXk().aVn() && view != PbActivity.this.eTt.fbJ.aXk().aVl()))) {
                            if (view == PbActivity.this.eTt.aWz()) {
                                if (PbActivity.this.eTs != null) {
                                    com.baidu.tbadk.browser.a.O(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eTs.getPbData().aRp().ru().getLink());
                                }
                            } else if (view != PbActivity.this.eTt.fbJ.fgB && view.getId() != d.g.view_forum_name_first_floor && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.eTt.fbJ.fgC) {
                                    if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null) {
                                        ArrayList<PostData> aRr = PbActivity.this.eTs.getPbData().aRr();
                                        if ((aRr == null || aRr.size() <= 0) && PbActivity.this.eTs.aUn()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ac("tid", PbActivity.this.eTs.aUm()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getForumId()));
                                        if (!PbActivity.this.eTt.aWP()) {
                                            PbActivity.this.eTt.aVN();
                                        }
                                        PbActivity.this.aSY();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aUZ()) {
                                        if ((PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aVk()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.eTt.fbJ.aXk() == null || (view != PbActivity.this.eTt.fbJ.aXk().getCancelView() && view != PbActivity.this.eTt.fbJ.aXk().aVj())) {
                                                if (view != PbActivity.this.eTt.fbJ.fgD && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aVh()) {
                                                        if ((PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aVq()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aVi()) {
                                                                if (PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aVr()) {
                                                                    if (PbActivity.this.eTz == null || view != PbActivity.this.eTz.aVb()) {
                                                                        if (PbActivity.this.eTz == null || view != PbActivity.this.eTz.aUZ()) {
                                                                            if (PbActivity.this.eTz == null || view != PbActivity.this.eTz.aVe()) {
                                                                                if (PbActivity.this.eTz == null || view != PbActivity.this.eTz.aVc()) {
                                                                                    if (PbActivity.this.eTz == null || view != PbActivity.this.eTz.aVd()) {
                                                                                        if (PbActivity.this.eTt.aWH() == view) {
                                                                                            if (PbActivity.this.eTt.aWH().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTs.getPbData();
                                                                                                if (pbData != null && pbData.aRp() != null && pbData.aRp().rb() != null) {
                                                                                                    String pG = pbData.aRp().rb().pG();
                                                                                                    if (StringUtils.isNull(pG)) {
                                                                                                        pG = pbData.aRp().rb().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ac("obj_id", pG));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cf("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.aTu();
                                                                                        } else if (PbActivity.this.eTt.aWc() != view) {
                                                                                            if (PbActivity.this.eTz == null || view != PbActivity.this.eTz.aVa()) {
                                                                                                if (PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aVp()) {
                                                                                                    if (PbActivity.this.eTt.fbJ.aXk() != null && view == PbActivity.this.eTt.fbJ.aXk().aVm()) {
                                                                                                        if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.eTt.c(PbActivity.this.eTs.getPbData(), PbActivity.this.eTs.aUn(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                PbActivity.this.eTt.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                            PbActivity.this.eTt.fbJ.or();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.eTt.aSK()) {
                                                                                                            if (view == PbActivity.this.eTt.fbJ.aXl()) {
                                                                                                                PbActivity.this.eTt.aWp();
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
                                                                                                                        TiebaStatic.log(PbActivity.this.aSU().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", be.bxi() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.aSw() != null && PbActivity.this.aSw().getPbData() != null && PbActivity.this.aSw().getPbData().aRL() != null && PbActivity.this.aSw().getPbData().aRL() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aSU().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aSw().getPbData().aRL().aRV() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && !StringUtils.isNull(PbActivity.this.eTs.getPbData().getThreadId()) && (aRL = PbActivity.this.eTs.getPbData().aRL()) != null && aRL.aRU() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eTs.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.eTz == null) {
                                                                                                                                PbActivity.this.eTz = new y(PbActivity.this.getPageContext(), PbActivity.this.cIJ);
                                                                                                                                PbActivity.this.eTt.bo(PbActivity.this.eTz.getView());
                                                                                                                                PbActivity.this.eTz.jz(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.eTz.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ac("tid", PbActivity.this.eTs.eXR));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.eTz.aUZ().setTag(sparseArray2);
                                                                                                                            PbActivity.this.eTz.aVe().setTag(view.getTag());
                                                                                                                            PbActivity.this.eTz.jB(z6);
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
                                                                                                                                    PbActivity.this.eTz.aVc().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.eTz.aVc().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.eTz.aVa().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eTz.aVc().setTag(sparseArray4);
                                                                                                                                PbActivity.this.eTz.aVa().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.eTz.aVa().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.eTz.aVa().setVisibility(8);
                                                                                                                                PbActivity.this.eTz.aVc().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.eTz.aVa().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eTz.aVc().setTag(sparseArray5);
                                                                                                                                PbActivity.this.eTz.aVa().setText(d.j.delete);
                                                                                                                                PbActivity.this.eTz.aVc().setVisibility(0);
                                                                                                                                if (PbActivity.this.eTs.getPbData().aRA() != 1002 || z2) {
                                                                                                                                    PbActivity.this.eTz.aVc().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eTz.aVc().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.eTz.aVa().setVisibility(8);
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
                                                                                                                                PbActivity.this.eTz.aVb().setTag(sparseArray7);
                                                                                                                                PbActivity.this.eTz.aVb().setVisibility(0);
                                                                                                                                PbActivity.this.eTz.aVa().setVisibility(8);
                                                                                                                                PbActivity.this.eTz.aVb().setText(d.j.mute_option);
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
                                                                                                                                PbActivity.this.eUz = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (aq.k(PbActivity.this.eUz) ? false : jf) {
                                                                                                                                    PbActivity.this.eTz.aVb().setVisibility(0);
                                                                                                                                    PbActivity.this.eTz.aVb().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eTz.aVb().setVisibility(8);
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
                                                                                                                                PbActivity.this.eTz.aVd().setVisibility(0);
                                                                                                                                PbActivity.this.eTz.aVd().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.eTz.aVd().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.eTz.aVd().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.eTz.aVd().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eTs.getPbData().nH()) {
                                                                                                                            String nG = PbActivity.this.eTs.getPbData().nG();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(nG) && nG.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.eTz.aUZ().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eTz.aUZ().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.eTz.jA(true);
                                                                                                                                PbActivity.this.eTz.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.eTz.jA(true);
                                                                                                                        PbActivity.this.eTz.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRp() != null && PbActivity.this.eTs.getPbData().aRp().sb() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), PbActivity.this.eTs.getPbData().aRp().sb());
                                                                                                                        if (PbActivity.this.eTs.getPbData().aRp().rZ() != 1) {
                                                                                                                            if (PbActivity.this.eTs.getPbData().aRp().rZ() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getPbData().getForumId()).ac("tid", PbActivity.this.eTs.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.eTs.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.eTt.setSelection(0);
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
                                                                                                                        PbActivity.this.eTt.aVN();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aSV() == 1) {
                                                                                                                            if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getPbData().getForumId()).ac("tid", PbActivity.this.eTs.getPbData().getThreadId()).ac("uid", currentAccount));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aSV() == 2 && PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getPbData().getForumId()).ac("tid", PbActivity.this.eTs.getPbData().getThreadId()).ac("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.aSV() == 1) {
                                                                                                                            if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getPbData().getForumId()).ac("tid", PbActivity.this.eTs.getPbData().getThreadId()).ac("uid", currentAccount2));
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.aSV() == 2 && PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getPbData().getForumId()).ac("tid", PbActivity.this.eTs.getPbData().getThreadId()).ac("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.aTp();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.aTq();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRH() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eTs.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ac(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{pbData2.aRH().aRQ()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRH() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eTs.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{pbData3.aRH().aRQ()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.eTt.fbJ.aXk() != null && view == PbActivity.this.eTt.fbJ.aXk().aVs()) {
                                                                                                                    if (PbActivity.this.eTs == null || PbActivity.this.eTs.getPbData() == null || PbActivity.this.eTs.getPbData().aRp() == null) {
                                                                                                                        PbActivity.this.eTt.fbJ.or();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.hy()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.eTs.getPbData().aRp().rd() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eTs.aUm(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).tq();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").r("obj_locate", PbActivity.this.Z(PbActivity.this.eTs.getPbData().aRp())).ac("tid", PbActivity.this.eTs.getPbData().aRp().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.eTT >= 0) {
                                                                                                                        if (PbActivity.this.eTs != null) {
                                                                                                                            PbActivity.this.eTs.aUU();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eTt.aWd() != null) {
                                                                                                                            PbActivity.this.eTt.aWd().a(PbActivity.this.eTs.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.eTt.getListView().setSelection(PbActivity.this.eTs.aUX());
                                                                                                                        PbActivity.this.eTT = 0;
                                                                                                                        if (PbActivity.this.eTs != null) {
                                                                                                                            PbActivity.this.eTs.bu(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.eTt.aWS();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eTs.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eTs.aUm(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eTs.getPbData().aRp().rQ())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.eTs.getPbData() != null) {
                                                                                                            PbActivity.this.eTt.aWw();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bxk()) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12630"));
                                                                                                                }
                                                                                                                String aUm = PbActivity.this.eTs.aUm();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.eTs.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.eTs.getPbData().aRA();
                                                                                                                }
                                                                                                                PbActivity.this.alB();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c pM = PbActivity.this.pM(id2);
                                                                                                                    if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && pM != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aUm, id2, "pb", true, null, true, null, i3, postData3.aYd(), PbActivity.this.eTs.getPbData().qg(), false, postData3.rv().getIconInfo()).addBigImageData(pM.eVj, pM.eVk, pM.eVl, pM.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.eTs.aUT());
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
                                                                                                                    if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && pM2 != null && PbActivity.this.aSQ().aVL() != null) {
                                                                                                                        com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                        mVar.b(PbActivity.this.eTs.getPbData().aRn());
                                                                                                                        mVar.R(PbActivity.this.eTs.getPbData().aRp());
                                                                                                                        mVar.d(postData4);
                                                                                                                        PbActivity.this.aSQ().aVL().d(mVar);
                                                                                                                        PbActivity.this.aSQ().aVL().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c pM3 = PbActivity.this.pM(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && pM3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aUm, id2, "pb", true, null, false, null, i3, postData3.aYd(), PbActivity.this.eTs.getPbData().qg(), false, postData3.rv().getIconInfo()).addBigImageData(pM3.eVj, pM3.eVk, pM3.eVl, pM3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.eTs.aUT());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                    PbActivity.this.eTt.aWw();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.eTt.c(PbActivity.this.eTs.getPbData(), PbActivity.this.eTs.aUn(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eTs.getPbData().aRn().getId(), PbActivity.this.eTs.getPbData().aRn().getName(), PbActivity.this.eTs.getPbData().aRp().getId(), String.valueOf(PbActivity.this.eTs.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
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
                                                                                                    if (!com.baidu.tieba.c.a.abp() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eTs.aUm(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.eTt.bm(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.eTt.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.aSM();
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
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eTs.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aRn() != null) {
                                                                                            str9 = pbData4.aRn().getId();
                                                                                            str10 = pbData4.aRn().getName();
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
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.abp() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eTs.aUm(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.eTt.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.eTz.aVg()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ac("tid", PbActivity.this.eTs.eXR));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eTs.getPbData() != null) {
                                                                                    PbActivity.this.eTt.aWw();
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
                                                                                        String aUm2 = PbActivity.this.eTs.aUm();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.eTs.getPbData() != null) {
                                                                                            i5 = PbActivity.this.eTs.getPbData().aRA();
                                                                                        }
                                                                                        PbActivity.this.alB();
                                                                                        c pM4 = PbActivity.this.pM(id3);
                                                                                        if (pM4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(aUm2, id3, "pb", true, null, true, null, i5, postData.aYd(), PbActivity.this.eTs.getPbData().qg(), false, postData.rv().getIconInfo()).addBigImageData(pM4.eVj, pM4.eVk, pM4.eVl, pM4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.eTs.aUT());
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
                                                                                if (PbActivity.this.eTs.getPbData().aRp() != null && PbActivity.this.eTs.getPbData().aRp().rv() != null && PbActivity.this.eTs.getPbData().aRp().rv().getUserId() != null && PbActivity.this.euo != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eTs.eXR).r("obj_locate", 2).ac("obj_id", PbActivity.this.eTs.getPbData().aRp().rv().getUserId()).r("obj_type", PbActivity.this.euo.nH() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eTs.getPbData())));
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
                                                                    PbActivity.this.eTt.fbJ.or();
                                                                }
                                                            } else if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRp() != null) {
                                                                PbActivity.this.eTt.fbJ.or();
                                                                PbActivity.this.pJ(PbActivity.this.eTs.getPbData().aRp().rM());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.eTt.aWw();
                                                            if (com.baidu.adp.lib.util.j.hh()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.eTs.aUA()));
                                                                    return;
                                                                }
                                                                PbActivity.this.pS(2);
                                                                PbActivity.this.alB();
                                                                PbActivity.this.eTt.aWh();
                                                                boolean aUz = PbActivity.this.eTs.aUz();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.eTs.aUA()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.eTt.fbJ != null && PbActivity.this.eTt.fbJ.aXk() != null && view == PbActivity.this.eTt.fbJ.aXk().aVq()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (aUz) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.eTt.jK(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.eTt.aWw();
                                                        if (PbActivity.this.eTs.avI() != null) {
                                                            PbActivity.this.eTt.a(PbActivity.this.eTs.avI(), PbActivity.this.eGz);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.am.fS() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.eTs != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ac("tid", PbActivity.this.eTs.aUm()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.hy()) {
                                                        if (PbActivity.this.eTs.getPbData() != null) {
                                                            ArrayList<PostData> aRr2 = PbActivity.this.eTs.getPbData().aRr();
                                                            if ((aRr2 != null && aRr2.size() > 0) || !PbActivity.this.eTs.aUn()) {
                                                                PbActivity.this.eTt.aWw();
                                                                PbActivity.this.alB();
                                                                PbActivity.this.pS(2);
                                                                if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRH() != null && !StringUtils.isNull(PbActivity.this.eTs.getPbData().aRH().pR(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.am.fS()) {
                                                                    PbActivity.this.pT(2);
                                                                } else {
                                                                    PbActivity.this.eTt.showLoadingDialog();
                                                                    PbActivity.this.eTs.aUO().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.eTt.fbJ.or();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.hh()) {
                                            PbActivity.this.eTt.aWw();
                                            if (PbActivity.this.eTt.fbJ.aXk() != null && view == PbActivity.this.eTt.fbJ.aXk().aVk() && !PbActivity.this.eTt.aWP()) {
                                                PbActivity.this.eTt.aVN();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.alB();
                                                PbActivity.this.eTt.aWh();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    k = PbActivity.this.eTs.k(true, PbActivity.this.aTn());
                                                } else {
                                                    k = view.getId() == d.g.reply_title ? PbActivity.this.eTs.k(false, PbActivity.this.aTn()) : PbActivity.this.eTs.pO(PbActivity.this.aTn());
                                                }
                                                view.setTag(Boolean.valueOf(k));
                                                if (k) {
                                                    PbActivity.this.eTt.jo(true);
                                                    PbActivity.this.eTt.aBv();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.eTt.jK(true);
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
                                        PbActivity.this.eTt.aWw();
                                        if (PbActivity.this.pR(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.eTs.qh(PbActivity.this.eTt.aWm()) != null) {
                                            PbActivity.this.aTg();
                                            if (PbActivity.this.eTs.getPbData().aRp() != null && PbActivity.this.eTs.getPbData().aRp().rv() != null && PbActivity.this.eTs.getPbData().aRp().rv().getUserId() != null && PbActivity.this.euo != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eTs.eXR).r("obj_locate", 1).ac("obj_id", PbActivity.this.eTs.getPbData().aRp().rv().getUserId()).r("obj_type", PbActivity.this.euo.nH() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.eTs.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                    PbActivity.this.eTt.jo(true);
                                    PbActivity.this.eTt.aVN();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eTt.aBv();
                                        PbActivity.this.alB();
                                        PbActivity.this.eTt.aWh();
                                        PbActivity.this.eTs.pO(PbActivity.this.aTn());
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
                                if (PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRp() != null && PbActivity.this.eTs.getPbData().aRp().si() && PbActivity.this.eTs.getPbData().aRp().rN() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.eTs.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eTs.aUl()) && PbActivity.this.eTs.getAppealInfo() != null) {
                                        name = PbActivity.this.eTs.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eTs.getPbData().aRn().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aUl = PbActivity.this.eTs.aUl();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eTs.aUo() && aUl != null && aUl.equals(name)) {
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
                            if (PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRA() == 1 && !PbActivity.this.cbH.bxI()) {
                                PbActivity.this.eTt.aWw();
                                int i6 = 0;
                                if (PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aVl()) {
                                    if (PbActivity.this.eTt.fbJ.aXk() == null || view != PbActivity.this.eTt.fbJ.aXk().aVn()) {
                                        if (view == PbActivity.this.eTt.aWf()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eTs.getPbData().aRp().rr() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eTs.getPbData().aRp().rq() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aRn = PbActivity.this.eTs.getPbData().aRn();
                                String name2 = aRn.getName();
                                String id4 = aRn.getId();
                                String id5 = PbActivity.this.eTs.getPbData().aRp().getId();
                                if (!com.baidu.tieba.c.a.abp() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eTt.aWe();
                                    PbActivity.this.cbH.a(id4, name2, id5, i6, PbActivity.this.eTt.aWg());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.hh()) {
                        PbActivity.this.eTt.aWw();
                        PbActivity.this.alB();
                        PbActivity.this.eTt.aWh();
                        PbActivity.this.eTt.showLoadingDialog();
                        if (PbActivity.this.eTt.aVU() != null) {
                            PbActivity.this.eTt.aVU().setVisibility(8);
                        }
                        PbActivity.this.eTs.qa(1);
                        if (PbActivity.this.eSY != null) {
                            PbActivity.this.eSY.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String aST = PbActivity.this.aST();
                        if (!TextUtils.isEmpty(aST)) {
                            com.baidu.tbadk.core.util.av.vI().c(PbActivity.this.getPageContext(), new String[]{aST});
                        }
                    }
                } else if (PbActivity.this.eTj) {
                    PbActivity.this.eTj = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.aSQ().aVL() != null && postData5.rv() != null && postData5.bwU() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.aSQ().aVM() != null) {
                                    PbActivity.this.aSQ().aVM().aUa();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.eTs.getPbData().aRn());
                                mVar2.R(PbActivity.this.eTs.getPbData().aRp());
                                mVar2.d(postData5);
                                PbActivity.this.aSQ().aVL().d(mVar2);
                                PbActivity.this.aSQ().aVL().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.rv().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.eTG != null) {
                                    PbActivity.this.eTt.jU(PbActivity.this.eTG.DI());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aDS = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.alB();
            PbActivity.this.eTt.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ad.GU() && PbActivity.this.aSw() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aSw().pR(postWriteCallBackData.getPostId());
                    PbActivity.this.eTT = PbActivity.this.eTt.aVQ();
                    if (PbActivity.this.eTs != null) {
                        PbActivity.this.eTs.bu(PbActivity.this.eTT, PbActivity.this.eTt.aVR());
                    }
                }
                PbActivity.this.eTt.aWw();
                PbActivity.this.eTy.aWU();
                if (PbActivity.this.eTG != null) {
                    PbActivity.this.eTt.jU(PbActivity.this.eTG.DI());
                }
                PbActivity.this.eTt.aVK();
                PbActivity.this.eTt.jW(true);
                PbActivity.this.eTs.aUC();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eTs.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTs.getPbData();
                            if (pbData != null && pbData.aRp() != null && pbData.aRp().rv() != null && (userId = pbData.aRp().rv().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ad.GU() && PbActivity.this.eTs.aUv()) {
                                PbActivity.this.eTt.aWh();
                            }
                        } else if (!com.baidu.tbadk.o.ad.GU() && PbActivity.this.eTs.aUv()) {
                            PbActivity.this.eTt.aWh();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eTt.p(PbActivity.this.eTs.getPbData());
                    }
                    if (PbActivity.this.eTs.aUr()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ac("tid", PbActivity.this.eTs.aUm()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.eTG.DP() || PbActivity.this.eTG.DQ()) {
                    PbActivity.this.eTG.a(false, postWriteCallBackData);
                }
                PbActivity.this.eTy.e(postWriteCallBackData);
            } else if (sVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d eUq = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.eTy != null) {
                if (z) {
                    PbActivity.this.eTy.aWT();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    if (PbActivity.this.eTt != null && PbActivity.this.eTt.aVM() != null && PbActivity.this.eTt.aVM().aUe() != null && PbActivity.this.eTt.aVM().aUe().DQ()) {
                        PbActivity.this.eTt.aVM().aUe().a(postWriteCallBackData);
                    }
                    PbActivity.this.eTy.f(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a eUr = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eN;
            if (!z || fVar == null || fVar.aRy() != null || com.baidu.tbadk.core.util.v.v(fVar.aRr()) >= 1) {
                PbActivity.this.ewY = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eTt.aWj();
                if (fVar == null || !fVar.aRv()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eTt.getView());
                } else if (PbActivity.this.eTt.aVI() == null) {
                    PbActivity.this.eTK = true;
                }
                PbActivity.this.eTt.aBu();
                if (PbActivity.this.isFullScreen || PbActivity.this.eTt.aWP()) {
                    PbActivity.this.eTt.aWD();
                } else if (!PbActivity.this.eTt.aWC()) {
                    PbActivity.this.eTt.jW(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eTA = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eTt.PB();
                    PbActivity.this.eTt.jX(fVar.aRv());
                    if (fVar.aRp() != null && fVar.aRp().ss() != null) {
                        PbActivity.this.a(fVar.aRp().ss());
                    }
                    PbActivity.this.aSN();
                    if (PbActivity.this.eTG != null) {
                        PbActivity.this.eTt.jU(PbActivity.this.eTG.DI());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aRr() != null && fVar.aRr().size() >= 1 && fVar.aRr().get(0) != null) {
                        PbActivity.this.eTs.pQ(fVar.aRr().get(0).getId());
                    } else if (fVar.aRy() != null) {
                        PbActivity.this.eTs.pQ(fVar.aRy().getId());
                    }
                    if (PbActivity.this.eTG != null) {
                        PbActivity.this.eTG.a(fVar.qg());
                        PbActivity.this.eTG.a(fVar.aRn(), fVar.getUserData());
                        PbActivity.this.eTG.a(PbActivity.this.eTs.aUw(), PbActivity.this.eTs.aUm(), PbActivity.this.eTs.aUQ());
                        if (fVar.aRp() != null) {
                            PbActivity.this.eTG.bF(fVar.aRp().sI());
                        }
                    }
                    if (PbActivity.this.euo != null) {
                        PbActivity.this.euo.ab(fVar.nH());
                    }
                    if (fVar == null || fVar.aRB() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eTt.jV(PbActivity.this.mIsFromCDN);
                    PbActivity.this.eTt.a(fVar, i2, i3, PbActivity.this.eTs.aUn(), i4, PbActivity.this.eTs.getIsFromMark());
                    PbActivity.this.eTt.d(fVar, PbActivity.this.eTs.aUn());
                    PbActivity.this.eTt.jS(PbActivity.this.eTs.getHostMode());
                    AntiData qg = fVar.qg();
                    if (qg != null) {
                        PbActivity.this.aDI = qg.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aDI) && PbActivity.this.eTG != null && PbActivity.this.eTG.De() != null && (eN = PbActivity.this.eTG.De().eN(6)) != null && !TextUtils.isEmpty(PbActivity.this.aDI)) {
                            ((View) eN).setOnClickListener(PbActivity.this.aEt);
                        }
                    }
                    if (PbActivity.this.eTC) {
                        PbActivity.this.eTC = false;
                        final int aTa = PbActivity.this.aTa();
                        if (fVar.aRM()) {
                            final int ac = (int) (com.baidu.adp.lib.util.l.ac(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(aTa, ac);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.aSQ().qm(aTa);
                        }
                    }
                    if (PbActivity.this.eTD) {
                        PbActivity.this.eTD = false;
                        final int aTa2 = PbActivity.this.aTa();
                        final boolean z2 = aTa2 != -1;
                        if (!z2) {
                            aTa2 = PbActivity.this.aTb();
                        }
                        if (PbActivity.this.aSQ() != null) {
                            if (fVar.aRM()) {
                                final int ac2 = (int) (com.baidu.adp.lib.util.l.ac(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (aTa2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(aTa2, ac2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(aTa2 - 1, ac2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.aSQ().qm(aTa2);
                            }
                        }
                    } else {
                        PbActivity.this.eTt.aWn();
                    }
                    PbActivity.this.eTs.a(fVar.aRn(), PbActivity.this.eUe);
                    PbActivity.this.eTs.a(PbActivity.this.eUf);
                } else if (str != null) {
                    if (!PbActivity.this.eTA && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eTs != null && PbActivity.this.eTs.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eTs.getAppealInfo().ePk)) {
                                    PbActivity.this.eTt.a(PbActivity.this.eTs.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eTt.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eTt.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.eTt.aWD();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.eTs.aUm());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getForumId());
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
                        PbActivity.this.eTt.pT(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.eTt.pT("");
                    }
                    PbActivity.this.eTt.ww();
                }
                PbActivity.this.aKw = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aSw().aUn() || PbActivity.this.aSw().getPbData().qy().qv() != 0 || PbActivity.this.aSw().aUJ()) {
                    PbActivity.this.eTH = true;
                    return;
                }
                return;
            }
            PbActivity.this.eTs.qa(1);
            if (PbActivity.this.eSY != null) {
                PbActivity.this.eSY.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eTt.p(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.r.GB().GC()) {
                com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, PbActivity.this.aKo, PbActivity.this.createTime, PbActivity.this.aKw, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.ctu : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aKo = 0L;
                if (mVar != null) {
                    mVar.Gw();
                }
            }
        }
    };
    private CustomMessageListener eUs = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aSV() == 1) {
                    PbActivity.this.aTe();
                }
                PbActivity.this.aSW();
            }
        }
    };
    private final a.InterfaceC0057a eUt = new a.InterfaceC0057a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0057a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eTt.aWj();
            if (z) {
                if (PbActivity.this.euo != null) {
                    PbActivity.this.euo.ab(z2);
                }
                PbActivity.this.eTs.jx(z2);
                if (PbActivity.this.eTs.nH()) {
                    PbActivity.this.aTh();
                } else {
                    PbActivity.this.eTt.p(PbActivity.this.eTs.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.euo != null && PbActivity.this.euo.nK() != null && PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRp() != null && PbActivity.this.eTs.getPbData().aRp().rv() != null) {
                        MarkData nK = PbActivity.this.euo.nK();
                        MetaData rv = PbActivity.this.eTs.getPbData().aRp().rv();
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
                if (PbActivity.this.eTt != null) {
                    PbActivity.this.eTt.aWw();
                    if (PbActivity.this.eTG != null && !PbActivity.this.eTt.aVO()) {
                        PbActivity.this.eTt.jU(PbActivity.this.eTG.DI());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.eTt.aVN();
                    }
                }
                if (!PbActivity.this.eTg) {
                    PbActivity.this.eTg = true;
                    PbActivity.this.eTt.aWB();
                }
            }
            PbActivity.this.eTt.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eSY != null) {
                PbActivity.this.eSY.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eTh == null) {
                PbActivity.this.eTh = new com.baidu.tbadk.k.d();
                PbActivity.this.eTh.fr(1001);
            }
            if (i == 0) {
                PbActivity.this.eTh.Gi();
            } else if (i == 1) {
                PbActivity.this.eTh.Gi();
            } else {
                PbActivity.this.eTh.Gi();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aRr;
            if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTt != null && PbActivity.this.eTt.aWd() != null) {
                PbActivity.this.eTt.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eSY != null) {
                    PbActivity.this.eSY.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eTs.aUE() && (aRr = PbActivity.this.eTs.getPbData().aRr()) != null && !aRr.isEmpty()) {
                    int aTQ = ((i + i2) - PbActivity.this.eTt.aWd().aTQ()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eTs.getPbData();
                    if (pbData != null) {
                        if (pbData.aRs() != null && pbData.aRs().hasData()) {
                            aTQ--;
                        }
                        if (pbData.aRt() != null && pbData.aRt().hasData()) {
                            aTQ--;
                        }
                        int size = aRr.size();
                        if (aTQ < 0 || aTQ >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cbL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.cbH.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eTs.aUC();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.dkF && bVar.fip > 0 && bVar.gEg != 0 && bVar.fip != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.fip == 1002 && !bVar.dkF) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eTt.a(1, dVar.Ai, dVar.gEi, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cbH.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.eTt.a(PbActivity.this.cbH.getLoadDataMode(), gVar.Ai, gVar.gEi, false);
                        PbActivity.this.eTt.al(gVar.gEl);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eTt.a(PbActivity.this.cbH.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d eUu = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
    };
    private final h.b bfH = new h.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aTo()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eTs.jw(true)) {
                PbActivity.this.eTt.aWk();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eUw = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eUv && PbActivity.this.aTo()) {
                PbActivity.this.aTq();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eTs.jv(false)) {
                    PbActivity.this.eTt.aWi();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eTs.getPbData() != null) {
                    PbActivity.this.eTt.aWA();
                }
                PbActivity.this.eUv = true;
            }
        }
    };
    private int eUx = 0;
    private final TbRichTextView.g aVG = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
        public void a(View view, String str, int i) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.eTt.b((TbRichText) view.getTag());
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
                    PbActivity.this.eTq = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.eVm) {
                    TbRichText au = PbActivity.this.au(str, i);
                    if (au != null && PbActivity.this.eUx >= 0 && PbActivity.this.eUx < au.Jr().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.g.b(au.Jr().get(PbActivity.this.eUx));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.eVj.size()) {
                                break;
                            } else if (!cVar.eVj.get(i3).equals(b2)) {
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
                            concurrentHashMap.put(str2, cVar.eVk.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eVl, cVar.lastId, PbActivity.this.eTs.aUA(), concurrentHashMap, true, false, PbActivity.this.eTs.getHostMode());
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.eVj, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.w(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.eVk.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.eVl, cVar.eVj.get(0), PbActivity.this.eTs.aUA(), concurrentHashMap2, true, false, PbActivity.this.eTs.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eUy = false;
    PostData eUz = null;
    private final b.InterfaceC0061b eUA = new b.InterfaceC0061b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eUz != null) {
                if (i == 0) {
                    PbActivity.this.eUz.cd(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eUz = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.eUz);
                }
            }
        }
    };
    private final b.InterfaceC0061b eUB = new b.InterfaceC0061b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eTQ != null && !TextUtils.isEmpty(PbActivity.this.eTR)) {
                if (i == 0) {
                    if (PbActivity.this.eTS == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eTR));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eTR;
                        aVar.pkgId = PbActivity.this.eTS.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eTS.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eTP == null) {
                        PbActivity.this.eTP = new av(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eTP.i(PbActivity.this.eTR, PbActivity.this.eTQ.kN());
                }
                PbActivity.this.eTQ = null;
                PbActivity.this.eTR = null;
            }
        }
    };
    private final View.OnLongClickListener avF = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eTQ = ((TbImageView) view).getBdImage();
                PbActivity.this.eTR = ((TbImageView) view).getUrl();
                if (PbActivity.this.eTQ != null && !TextUtils.isEmpty(PbActivity.this.eTR)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eTS = null;
                    } else {
                        PbActivity.this.eTS = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eTt.a(PbActivity.this.eUB, PbActivity.this.eTQ.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.eTQ = ((GifView) view).getBdImage();
                }
                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                    PbActivity.this.eTR = ((GifView) view).getBdImage().getUrl();
                }
                if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                    PbActivity.this.eTS = null;
                } else {
                    PbActivity.this.eTS = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                }
                PbActivity.this.eTt.a(PbActivity.this.eUB, PbActivity.this.eTQ.isGif());
            } else if (view instanceof com.baidu.tbadk.widget.c) {
                if (((com.baidu.tbadk.widget.c) view).getBdImage() != null) {
                    PbActivity.this.eTQ = ((com.baidu.tbadk.widget.c) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.c) view).getBdImage().getUrl())) {
                        PbActivity.this.eTR = ((com.baidu.tbadk.widget.c) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eTS = null;
                    } else {
                        PbActivity.this.eTS = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eTt.a(PbActivity.this.eUB, PbActivity.this.eTQ.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eUz = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.eUz != null && PbActivity.this.euo != null) {
                        PbActivity.this.eTt.a(PbActivity.this.eUA, PbActivity.this.euo.nH() && PbActivity.this.eUz.getId() != null && PbActivity.this.eUz.getId().equals(PbActivity.this.eTs.rF()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a cFw = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (!PbActivity.this.eTa && z && !PbActivity.this.eTs.aUu()) {
                PbActivity.this.aTk();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener aNm = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).auK()) {
                        break;
                    }
                }
            }
            PbActivity.this.bHL.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0097a bHM = new a.InterfaceC0097a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        final int bRg;

        {
            this.bRg = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ag(int i, int i2) {
            if (K(i2) && PbActivity.this.eTt != null && PbActivity.this.eSY != null) {
                PbActivity.this.eTt.aWE();
                PbActivity.this.eSY.fc(false);
                PbActivity.this.eSY.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ah(int i, int i2) {
            if (K(i2) && PbActivity.this.eTt != null && PbActivity.this.eSY != null) {
                PbActivity.this.eSY.fc(true);
                if (Math.abs(i2) > this.bRg) {
                    PbActivity.this.eSY.hideFloatingView();
                }
                if (PbActivity.this.aTo()) {
                    PbActivity.this.eTt.aVZ();
                    PbActivity.this.eTt.aWa();
                }
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ai(int i, int i2) {
        }

        private boolean K(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eUC = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // com.baidu.tieba.e.b.a
        public void ex(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aSm();
            } else {
                com.baidu.tieba.pb.a.b.aSl();
            }
        }
    };
    private String eUD = null;
    private final o.a eUE = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eUD = str2;
                PbActivity.this.eTt.pU(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eUF = -1;
    private int eUG = -1;
    private CustomMessageListener eUJ = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Ua == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0059a) {
                    if (aVar.Ub != null && !aVar.Ub.hasError() && aVar.Ub.getError() == 0) {
                        if (PbActivity.this.eTt != null) {
                            PbActivity.this.eTt.y(((a.C0059a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aTA();
                        }
                    } else if (z) {
                        if (aVar.Ub != null && aVar.Ub.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Ub.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Ub != null && !aVar.Ub.hasError() && aVar.Ub.getError() == 0) {
                        if (PbActivity.this.eTt != null && PbActivity.this.eTt != null) {
                            PbActivity.this.eTt.y(((a.C0059a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Ub != null && aVar.Ub.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Ub.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Ub == null || aVar.Ub.hasError() || aVar.Ub.getError() != 0) {
                        if (z) {
                            if (aVar.Ub != null && aVar.Ub.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Ub.getErrorString());
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
    private final CustomMessageListener cIg = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
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
        public ArrayList<String> eVj;
        public ConcurrentHashMap<String, ImageUrlData> eVk;
        public boolean eVm;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eVl = false;
        public boolean eVn = false;
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

    public com.baidu.tbadk.editortools.pb.d aSL() {
        return this.eTG;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        if (mVar.aSb() != null) {
            String id = mVar.aSb().getId();
            ArrayList<PostData> aRr = this.eTs.getPbData().aRr();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aRr.size()) {
                    break;
                }
                PostData postData = aRr.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aSf = mVar.aSf();
                    postData.uv(mVar.getTotalCount());
                    if (postData.bwR() != null && aSf != null) {
                        Iterator<PostData> it = aSf.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.rv() != null && (metaData = postData.getUserMap().get(next.rv().getUserId())) != null) {
                                next.a(metaData);
                                next.nd(true);
                                next.b(getPageContext(), this.eTs.pP(metaData.getUserId()));
                            }
                        }
                        postData.bwR().clear();
                        postData.bwR().addAll(aSf);
                    }
                    if (postData.bwN() != null) {
                        postData.bwO();
                    }
                }
            }
            if (!this.eTs.getIsFromMark()) {
                this.eTt.p(this.eTs.getPbData());
            }
            c(mVar);
        }
    }

    public void aSM() {
        com.baidu.tieba.pb.data.f pbData;
        bd aRp;
        if (!this.eUh) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (this.eUk) {
                this.eUh = true;
                if (this.eTs != null && (pbData = this.eTs.getPbData()) != null && (aRp = pbData.aRp()) != null) {
                    int isLike = aRp.rk() == null ? 0 : aRp.rk().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ac("tid", aRp.getId()));
                    }
                    if (this.eUi != null) {
                        this.eUi.a(aRp.rM(), aRp.getId(), isLike, "pb");
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
                    bVar.a(strArr, new b.InterfaceC0061b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.eTt.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eTN);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eTN);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0061b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.eTN);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eTN);
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
        bd aRp;
        String str;
        String y;
        if (this.eTs != null && this.eTs.getPbData() != null && (aRp = this.eTs.getPbData().aRp()) != null) {
            if (i == 1) {
                PraiseData rk = aRp.rk();
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
                        aRp.a(praiseData);
                    } else {
                        aRp.rk().getUser().add(0, metaData);
                        aRp.rk().setNum(aRp.rk().getNum() + 1);
                        aRp.rk().setIsLike(i);
                    }
                }
                if (aRp.rk() != null) {
                    if (aRp.rk().getNum() < 1) {
                        y = getResources().getString(d.j.zan);
                    } else {
                        y = com.baidu.tbadk.core.util.am.y(aRp.rk().getNum());
                    }
                    this.eTt.R(y, true);
                }
            } else if (aRp.rk() != null) {
                aRp.rk().setIsLike(i);
                aRp.rk().setNum(aRp.rk().getNum() - 1);
                ArrayList<MetaData> user = aRp.rk().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aRp.rk().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aRp.rk().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = aRp.rk().getNum() + "";
                }
                this.eTt.R(str, false);
            }
            if (this.eTs.aUn()) {
                this.eTt.aWd().notifyDataSetChanged();
            } else {
                this.eTt.q(this.eTs.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eTs.u(bundle);
        if (this.cHh != null) {
            this.cHh.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eTG.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eTL = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.ctu = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eTm = intent.getStringExtra("from");
            if ("from_interview_live".equals(this.eTm)) {
                this.eSZ = true;
            }
            this.eUF = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.eUG = intent.getIntExtra("key_manga_next_chapter", -1);
            this.eUH = intent.getStringExtra("key_manga_title");
            this.eTC = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.eTD = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (aTo()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.eTU = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.ctu = System.currentTimeMillis();
        }
        this.eTf = System.currentTimeMillis();
        this.aKo = this.eTf - this.ctu;
        super.onCreate(bundle);
        this.eTc = 0;
        t(bundle);
        if (this.eTs != null && this.eTs.getPbData() != null) {
            this.eTs.getPbData().pH(this.source);
        }
        initUI();
        if (intent != null && this.eTt != null) {
            this.eTt.fbC = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.eTO == null) {
                    this.eTO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eTt.pW("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eTO, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.eTs != null && this.eTs.getPbData() != null) {
                this.eTs.pS(stringExtra);
            }
        }
        this.cHh = new VoiceManager();
        this.cHh.onCreate(getPageContext());
        initData(bundle);
        this.eTF = new com.baidu.tbadk.editortools.pb.g();
        aSN();
        this.eTG = (com.baidu.tbadk.editortools.pb.d) this.eTF.aV(getActivity());
        this.eTG.d(this);
        this.eTG.a(this.aDS);
        this.eTG.a(this.aDL);
        this.eTG.a(this, bundle);
        this.eTG.De().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eTG.De().by(true);
        je(true);
        this.eTt.setEditorTools(this.eTG.De());
        this.eTG.a(this.eTs.aUw(), this.eTs.aUm(), this.eTs.aUQ());
        registerListener(this.eTZ);
        if (!this.eTs.aUt()) {
            this.eTG.fW(this.eTs.aUm());
        }
        if (this.eTs.aUR()) {
            this.eTG.fU(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.eTG.fU(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eTf;
        registerListener(this.eTY);
        registerListener(this.eUa);
        registerListener(this.eUb);
        registerListener(this.cId);
        registerListener(this.eUp);
        registerListener(this.eTX);
        this.eTE = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gBo);
        this.eTE.bww();
        registerListener(this.eUd);
        registerListener(this.mAttentionListener);
        if (this.eTs != null) {
            this.eTs.aUH();
        }
        registerListener(this.eUs);
        registerListener(this.eUJ);
        registerListener(this.cIn);
        if (this.eTt != null && this.eTt.aWI() != null && this.eTt.aWJ() != null) {
            this.eSY = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eTt.aWI(), this.eTt.aWJ(), this.eTt.aVU());
            this.eSY.a(this.eUl);
        }
        if (this.eSX && this.eTt != null && this.eTt.aWJ() != null) {
            this.eTt.aWJ().setVisibility(8);
        }
        this.eTM = new com.baidu.tbadk.core.view.d();
        this.eTM.alk = 1000L;
        registerListener(this.eUo);
        registerListener(this.eUm);
        registerListener(this.eUn);
        this.eTN = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eTN;
        userMuteAddAndDelCustomMessage.setTag(this.eTN);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eTN;
        userMuteCheckCustomMessage.setTag(this.eTN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eTs.aUO().a(this.bHm);
        if ("from_tieba_kuang".equals(this.eTm)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 2).ac("tid", this.eTs.aUm()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        this.eTy = new at();
        if (this.eTG.DC() != null) {
            this.eTy.g(this.eTG.DC().getInputView());
        }
        this.eTG.a(this.aDM);
        this.cWR = new ShareSuccessReplyToServerModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSN() {
        if (this.eTF != null && this.eTs != null) {
            this.eTF.setForumName(this.eTs.aUl());
            if (this.eTs.getPbData() != null && this.eTs.getPbData().aRn() != null) {
                this.eTF.setForumId(this.eTs.getPbData().aRn().getId());
            }
            this.eTF.setFrom("pb");
            this.eTF.a(this.eTs);
        }
    }

    public String aSO() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aSP() {
        return this.eSY;
    }

    private void je(boolean z) {
        this.eTG.bC(z);
        this.eTG.bD(z);
        this.eTG.bE(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRM() && !z && this.eTt != null && this.eTt.getView() != null) {
            this.eTt.getView().setSystemUiVisibility(4);
        }
        this.eTI = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cHh != null) {
            this.cHh.onStart(getPageContext());
        }
    }

    public ar aSQ() {
        return this.eTt;
    }

    public PbModel aSw() {
        return this.eTs;
    }

    public void pI(String str) {
        if (this.eTs != null && !StringUtils.isNull(str) && this.eTt != null) {
            this.eTt.jZ(true);
            this.eTs.pI(str);
            this.eTl = true;
            this.eTt.aWw();
            this.eTt.aWD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eTa = false;
        } else {
            this.eTa = true;
        }
        super.onPause();
        if (this.eTt.aVI() != null && this.eTt.aVI().aSI() != null) {
            this.eTt.aVI().aSI().onPause();
        }
        BdListView listView = getListView();
        this.eTc = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eTc == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cHh != null) {
            this.cHh.onPause(getPageContext());
        }
        if (this.eTt != null) {
            this.eTt.onPause();
        }
        if (!this.eTs.aUt()) {
            this.eTG.fV(this.eTs.aUm());
        }
        if (this.eTs != null) {
            this.eTs.aUI();
        }
        MessageManager.getInstance().unRegisterListener(this.dER);
        avd();
        MessageManager.getInstance().unRegisterListener(this.eUm);
        MessageManager.getInstance().unRegisterListener(this.eUn);
        MessageManager.getInstance().unRegisterListener(this.eUo);
        MessageManager.getInstance().unRegisterListener(this.cIg);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aSR() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eTs.getPbData(), this.eTs.aUn(), this.eTs.aUF());
        return (a2 == null || a2.rv() == null || a2.rv().getGodUserData() == null || a2.rv().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eTa = false;
        super.onResume();
        if (this.eTo) {
            this.eTo = false;
            aTu();
        }
        if (this.eTt.aVI() != null && this.eTt.aVI().aSI() != null) {
            this.eTt.aVI().aSI().onResume();
        }
        if (aSR()) {
            this.eTi = System.currentTimeMillis();
        } else {
            this.eTi = -1L;
        }
        if (this.eTt != null && this.eTt.getView() != null) {
            if (!this.ewY) {
                aTl();
            } else {
                hideLoadingView(this.eTt.getView());
            }
            this.eTt.onResume();
        }
        if (this.eTc == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eTt != null) {
            noNetworkView = this.eTt.aVJ();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.hh()) {
            noNetworkView.aI(false);
        }
        if (this.cHh != null) {
            this.cHh.onResume(getPageContext());
        }
        registerListener(this.dER);
        this.eTB = false;
        aTt();
        registerListener(this.eUm);
        registerListener(this.eUn);
        registerListener(this.eUo);
        registerListener(this.cIg);
        if (this.cHN) {
            aTk();
            this.cHN = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eTt.jN(z);
        if (this.eTz != null) {
            this.eTz.jz(z);
        }
        if (z && this.eTB) {
            this.eTt.aWi();
            this.eTs.jv(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eTi > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ac("obj_duration", (System.currentTimeMillis() - this.eTi) + ""));
            this.eTi = 0L;
        }
        if (aSQ().aVM() != null) {
            aSQ().aVM().onStop();
        }
        if (this.eTt.fbJ != null && !this.eTt.fbJ.acI()) {
            this.eTt.fbJ.aGd();
        }
        if (this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRn() != null && this.eTs.getPbData().aRp() != null) {
            com.baidu.tbadk.distribute.a.CO().a(getPageContext().getPageActivity(), "pb", this.eTs.getPbData().aRn().getId(), com.baidu.adp.lib.g.b.c(this.eTs.getPbData().aRp().getId(), 0L));
        }
        if (this.cHh != null) {
            this.cHh.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.eTg && this.eTt != null) {
            this.eTg = true;
            this.eTt.aWB();
            a(false, (PostData) null);
        }
        if (this.eTs != null) {
            this.eTs.cancelLoadData();
            this.eTs.destory();
            if (this.eTs.aUN() != null) {
                this.eTs.aUN().onDestroy();
            }
        }
        if (this.eTG != null) {
            this.eTG.onDestroy();
        }
        if (this.cbH != null) {
            this.cbH.cancelLoadData();
        }
        if (this.eTt != null) {
            this.eTt.onDestroy();
            if (this.eTt.fbJ != null) {
                this.eTt.fbJ.aGd();
            }
        }
        if (this.eTh != null) {
            this.eTh.onDestroy();
        }
        if (this.eSY != null) {
            this.eSY.Hq();
        }
        super.onDestroy();
        if (this.cHh != null) {
            this.cHh.onDestory(getPageContext());
        }
        this.eTt.aWw();
        MessageManager.getInstance().unRegisterListener(this.eUm);
        MessageManager.getInstance().unRegisterListener(this.eUn);
        MessageManager.getInstance().unRegisterListener(this.eUo);
        MessageManager.getInstance().unRegisterListener(this.eTN);
        MessageManager.getInstance().unRegisterListener(this.eUp);
        MessageManager.getInstance().unRegisterListener(this.cIn);
        this.eTL = null;
        this.eTM = null;
        com.baidu.tieba.recapp.e.a.bmv().bmx();
        if (this.eTO != null) {
            getSafeHandler().removeCallbacks(this.eTO);
        }
        if (this.eTp != null) {
            this.eTp.cancelLoadData();
        }
        if (this.eTt != null && this.eTt.fbJ != null) {
            this.eTt.fbJ.aXo();
        }
        if (this.cWR != null) {
            this.cWR.cancelLoadData();
        }
        this.eTy.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        h aWd;
        ArrayList<PostData> aTR;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xH() && this.eTt != null && (aWd = this.eTt.aWd()) != null && (aTR = aWd.aTR()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aTR.iterator();
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
                        bVar.aMV = id;
                        bVar.cdx = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Zu == 1 && !TextUtils.isEmpty(id)) {
                    next.Zu = 2;
                    a.b bVar2 = new a.b();
                    bVar2.aMV = id;
                    bVar2.cdx = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eTs == null || this.eTs.getPbData() == null || this.eTs.getPbData().aRn() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eTs.getPbData().aRn().getFirst_class();
                    str2 = this.eTs.getPbData().aRn().getSecond_class();
                    str = this.eTs.getPbData().aRn().getId();
                    str4 = this.eTs.aUm();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xK());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eTt.onChangeSkinType(i);
        if (this.eTG != null && this.eTG.De() != null) {
            this.eTG.De().onChangeSkinType(i);
        }
        if (this.eTt.aVJ() != null) {
            this.eTt.aVJ().onChangeSkinType(getPageContext(), i);
        }
        this.eTy.onChangeSkinType();
    }

    private void initUI() {
        this.eTt = new ar(this, this.cIJ, this.aVH);
        this.bHL = new com.baidu.tieba.e.b(getActivity());
        this.bHL.a(this.eUC);
        this.bHL.a(this.bHM);
        this.eTt.setOnScrollListener(this.mOnScrollListener);
        this.eTt.d(this.eUw);
        this.eTt.a(this.bfH);
        this.eTt.iY(com.baidu.tbadk.core.h.oY().pe());
        this.eTt.setOnImageClickListener(this.aVG);
        this.eTt.a(this.avF);
        this.eTt.h(this.cFw);
        this.eTt.a(this.eUu);
        this.eTt.jN(this.mIsLogin);
        if (getIntent() != null) {
            this.eTt.setIsInterviewLive(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bd(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gBQ == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oY().pe()) {
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
        if (this.eTt != null) {
            if (z && (!this.ewY || this.eTK)) {
                aTl();
            } else {
                hideLoadingView(this.eTt.getView());
            }
            this.eTK = false;
            if (z && this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRM() && this.eTt.getView() != null) {
                this.eTt.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void aSS() {
        if (this.eTd == null) {
            this.eTd = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eTd.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0061b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eSG = PbActivity.this.eSG.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSG);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eTs.aUm(), PbActivity.this.eSG, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eSG = PbActivity.this.eSG.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSG);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eTs.aUm(), PbActivity.this.eSG, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eSG = PbActivity.this.eSG.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eSG);
                        bVar.dismiss();
                    }
                }
            }).ch(b.a.abP).ci(17).d(getPageContext());
        }
    }

    private void t(Bundle bundle) {
        this.eTs = new PbModel(this);
        this.eTs.a(this.eUr);
        if (this.eTs.aUL() != null) {
            this.eTs.aUL().a(this.eUE);
        }
        if (this.eTs.aUK() != null) {
            this.eTs.aUK().a(this.eUc);
        }
        if (this.eTs.aUN() != null) {
            this.eTs.aUN().b(this.eTW);
        }
        if (bundle != null) {
            this.eTs.initWithBundle(bundle);
        } else {
            this.eTs.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eTs.jy(true);
        }
        ai.aVv().Q(this.eTs.aUk(), this.eTs.getIsFromMark());
        if (StringUtils.isNull(this.eTs.aUm())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.eTm)) {
            this.eTs.qi(6);
        }
        this.eTs.Fz();
    }

    private void initData(Bundle bundle) {
        this.euo = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.euo != null) {
            this.euo.a(this.eUt);
        }
        this.cbH = new ForumManageModel(this);
        this.cbH.setLoadDataCallBack(this.cbL);
        this.apu = new com.baidu.tbadk.coreExtra.model.a(null);
        this.eTt.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eTs.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eTs.getPbData().aRn().getId(), PbActivity.this.eTs.getPbData().aRn().getName(), PbActivity.this.eTs.getPbData().aRp().getId(), valueOf, str, str2)));
            }
        });
        this.eUi.setUniqueId(getUniqueId());
        this.eUi.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eTt.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eTN;
        userMuteCheckCustomMessage.setTag(this.eTN);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aST() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.eTs != null && (pbData = this.eTs.getPbData()) != null) {
            return pbData.aRz().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aRp() != null) {
            if (fVar.aRp().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aRp().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aRp().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData be(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bxi()) {
                postData.cX(postData.bxh() - 1);
            } else {
                postData.cX(postData.bxh() + 1);
            }
            postData.ne(!postData.bxi());
            ((PbFloorAgreeView) view).a(postData.bxi(), postData.bxh(), true);
            final int i = postData.bxi() ? 0 : 1;
            this.eTs.aUM().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
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

    public com.baidu.tbadk.core.util.ak aSU() {
        return new com.baidu.tbadk.core.util.ak("c12003").ac("tid", this.eTs.eXR).r("obj_type", 0).ac(ImageViewerConfig.FORUM_ID, this.eTs.getForumId()).r("obj_param1", this.eTs.getPbData().aRp().getThreadType() == 40 ? 2 : 1);
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
                        PbActivity.this.aSQ().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aSQ().aVM() != null) {
                        PbActivity.this.eTG.De().setVisibility(8);
                        PbActivity.this.aSQ().aVM().bH(str, str2);
                        com.baidu.tbadk.editortools.pb.h aUe = PbActivity.this.aSQ().aVM().aUe();
                        if (aUe != null && PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null) {
                            aUe.a(PbActivity.this.eTs.getPbData().qg());
                        }
                        if (PbActivity.this.eTy.aWX() == null && PbActivity.this.aSQ().aVM().aUe().Ee() != null) {
                            PbActivity.this.aSQ().aVM().aUe().Ee().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.eTy != null && PbActivity.this.eTy.aWW() != null) {
                                        if (!PbActivity.this.eTy.aWW().bFG()) {
                                            PbActivity.this.eTy.kb(false);
                                        }
                                        PbActivity.this.eTy.aWW().nU(false);
                                    }
                                }
                            });
                            PbActivity.this.eTy.h(PbActivity.this.aSQ().aVM().aUe().Ee().getInputView());
                            PbActivity.this.aSQ().aVM().aUe().a(PbActivity.this.eTJ);
                        }
                    }
                    PbActivity.this.aSQ().aWD();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.eTs != null && this.eTs.getPbData() != null && postData.bwU() > 1) {
            String aUm = this.eTs.aUm();
            String id = postData.getId();
            int aRA = this.eTs.getPbData() != null ? this.eTs.getPbData().aRA() : 0;
            c pM = pM(id);
            if (pM != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(aUm, id, "pb", true, null, false, null, aRA, postData.aYd(), this.eTs.getPbData().qg(), false, postData.rv() != null ? postData.rv().getIconInfo() : null).addBigImageData(pM.eVj, pM.eVk, pM.eVl, pM.index);
                addBigImageData.setKeyPageStartFrom(this.eTs.aUT());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        ao aoVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.j.no_network_guide);
            } else if (aSw() != null && aSw().getPbData() != null && aSw().getPbData().aRL() != null) {
                com.baidu.tieba.pb.data.l aRL = aSw().getPbData().aRL();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof ao)) {
                    aoVar = null;
                } else {
                    aoVar = (ao) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aRL != null) {
                    int i3 = -1;
                    if (z) {
                        aRL.pK(i);
                    } else if (aRL.aRV()) {
                        aRL.aRY();
                        i3 = 1;
                    } else {
                        aRL.pM(i);
                        i3 = 0;
                    }
                    aRL.pL(i2);
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
                    if (this.eTs != null && this.eTs.aUM() != null) {
                        String str = "";
                        if (this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null) {
                            str = this.eTs.getPbData().aRp().rM();
                        }
                        if (this.eTs.getPbData() != null) {
                            this.eTs.getPbData().a(aRL);
                        }
                        if (z) {
                            this.eTs.aUM().a(str, 3, i, this.eTs.getForumId(), aVar);
                        } else {
                            this.eTs.aUM().a(str, i3, 3, i, this.eTs.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.eQa = i3;
                            kVar.eQb = aRL;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (aoVar != null) {
                        aoVar.b(aRL);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aSV() {
        if (this.eTs.getPbData() == null || this.eTs.getPbData().aRp() == null) {
            return -1;
        }
        return this.eTs.getPbData().aRp().rZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSW() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.qk(this.eTs.getForumId()) && this.eTs.getPbData() != null && this.eTs.getPbData().aRn() != null) {
            if (this.eTs.getPbData().aRn().isLike() == 1) {
                aTm();
                this.eTs.aUP().bK(this.eTs.getForumId(), this.eTs.aUm());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jf(boolean z) {
        if (this.eTs == null || this.eTs.getPbData() == null) {
            return false;
        }
        return ((this.eTs.getPbData().aRA() != 0) || this.eTs.getPbData().aRp() == null || this.eTs.getPbData().aRp().rv() == null || TextUtils.equals(this.eTs.getPbData().aRp().rv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aSX() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.o.q.GV()) {
            return "";
        }
        PostData aRw = aRw();
        if (this.eTs == null || (pbData = this.eTs.getPbData()) == null || pbData.getUserData() == null || pbData.aRp() == null || aRw == null || aRw.rv() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aRw.rv().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aRp().rd() == 0) {
            return "";
        }
        if (pbData.aRp().rd() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean jg(boolean z) {
        if (z) {
            return true;
        }
        if (this.eTs == null || this.eTs.getPbData() == null) {
            return false;
        }
        return this.eTs.getPbData().aRA() != 0;
    }

    private boolean jh(boolean z) {
        return (z || this.eTs == null || this.eTs.getPbData() == null || this.eTs.getPbData().aRA() == 0) ? false : true;
    }

    public void aSY() {
        if (this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null && this.eTs.getPbData().aRp().rv() != null) {
            if (this.eTt != null) {
                this.eTt.aVK();
            }
            bd aRp = this.eTs.getPbData().aRp();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aRp.rv().getUserId());
            aRp.rv().getGodUserData();
            ab abVar = new ab();
            int aRA = this.eTs.getPbData().aRA();
            if (aRA == 1) {
                abVar.eZS = true;
                abVar.eZR = true;
                abVar.eZZ = aRp.rq() == 1;
                abVar.eZY = aRp.rr() == 1;
            } else {
                abVar.eZS = false;
                abVar.eZR = false;
            }
            if (aRA == 1002 && !equals) {
                abVar.fad = true;
            }
            abVar.eZO = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            abVar.eZT = jg(equals);
            abVar.eZU = aSZ();
            abVar.eZV = jh(equals);
            abVar.eZP = this.eTs.aUn();
            abVar.eZQ = true;
            abVar.eQp = this.euo != null && this.euo.nH();
            abVar.eZN = jf(equals);
            abVar.fab = aSX();
            abVar.eZM = equals && this.eTt.aWq();
            abVar.eZW = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.eZX = true;
            abVar.isHostOnly = this.eTs.getHostMode();
            abVar.faa = true;
            if (aRp.rN() == null) {
                abVar.fac = true;
            } else {
                abVar.fac = false;
            }
            this.eTt.fbJ.a(abVar);
        }
    }

    private boolean aSZ() {
        if (this.eTs != null && this.eTs.aUn()) {
            return this.eTs.avI() == null || this.eTs.avI().qv() != 0;
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

    public int aTa() {
        if (aSQ() == null || aSQ().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aSQ().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) fVar).mType == com.baidu.tieba.pb.data.j.ePW) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aTb() {
        if (aSQ() == null || aSQ().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aSQ().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.gBO) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aTk();
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
                    PbActivity.this.apu.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.eTs.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).th();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.eTt.aWj();
        this.eTs.jx(z);
        if (this.euo != null) {
            this.euo.ab(z);
            if (markData != null) {
                this.euo.a(markData);
            }
        }
        if (this.eTs.nH()) {
            aTh();
        } else {
            this.eTt.p(this.eTs.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pP(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(String str) {
        if (!StringUtils.isNull(str) && this.eTs != null) {
            String aUm = this.eTs.aUm();
            String id = this.eTs.getPbData().aRn().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + aUm + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.eTs.aUt()) {
                    antiData.setBlock_forum_name(this.eTs.getPbData().aRn().getName());
                    antiData.setBlock_forum_id(this.eTs.getPbData().aRn().getId());
                    antiData.setUser_name(this.eTs.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eTs.getPbData().getUserData().getUserId());
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahK));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahK));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahK));
            }
        } else if (i == 230277) {
            gc(str);
        } else {
            this.eTt.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eTt.a(0, bVar.Ai, bVar.gEi, z);
            if (bVar.Ai) {
                if (bVar.gEg == 1) {
                    ArrayList<PostData> aRr = this.eTs.getPbData().aRr();
                    int size = aRr.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aRr.get(i).getId())) {
                            i++;
                        } else {
                            aRr.remove(i);
                            break;
                        }
                    }
                    this.eTt.p(this.eTs.getPbData());
                } else if (bVar.gEg == 0) {
                    aTc();
                } else if (bVar.gEg == 2) {
                    ArrayList<PostData> aRr2 = this.eTs.getPbData().aRr();
                    int size2 = aRr2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aRr2.get(i2).bwR().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aRr2.get(i2).bwR().get(i3).getId())) {
                                i3++;
                            } else {
                                aRr2.get(i2).bwR().remove(i3);
                                aRr2.get(i2).bwT();
                                z2 = true;
                                break;
                            }
                        }
                        aRr2.get(i2).te(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eTt.p(this.eTs.getPbData());
                    }
                    a(bVar, this.eTt);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.eTt.a(this.cbH.getLoadDataMode(), gVar.Ai, gVar.gEi, false);
            if (gVar.Ai) {
                this.eTv = true;
                if (i == 2 || i == 3) {
                    this.eTw = true;
                    this.eTx = false;
                } else if (i == 4 || i == 5) {
                    this.eTw = false;
                    this.eTx = true;
                }
                if (i == 2) {
                    this.eTs.getPbData().aRp().bT(1);
                    this.eTs.setIsGood(1);
                } else if (i == 3) {
                    this.eTs.getPbData().aRp().bT(0);
                    this.eTs.setIsGood(0);
                } else if (i == 4) {
                    this.eTs.getPbData().aRp().bS(1);
                    this.eTs.iQ(1);
                } else if (i == 5) {
                    this.eTs.getPbData().aRp().bS(0);
                    this.eTs.iQ(0);
                }
                this.eTt.c(this.eTs.getPbData(), this.eTs.aUn());
                if (this.eTs.getPbData().aRA() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void aTc() {
        if (this.eTs.aUo() || this.eTs.aUq()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eTs.aUm());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eTs.aUm()));
        if (aTi()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTd() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aRx;
        boolean z = true;
        if (this.eTt != null) {
            this.eTt.aWw();
        }
        if (this.eTs != null && this.eTs.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eTs.getPbData().aRp().getId();
            if (this.eTs.isShareThread() && this.eTs.getPbData().aRp().aaC != null) {
                historyMessage.threadName = this.eTs.getPbData().aRp().aaC.showText;
            } else {
                historyMessage.threadName = this.eTs.getPbData().aRp().getTitle();
            }
            if (this.eTs.isShareThread() && !aTC()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.eTs.getPbData().aRn().getName();
            }
            ArrayList<PostData> aRr = this.eTs.getPbData().aRr();
            int aWl = this.eTt != null ? this.eTt.aWl() : 0;
            if (aRr != null && aWl >= 0 && aWl < aRr.size()) {
                historyMessage.postID = aRr.get(aWl).getId();
            }
            historyMessage.isHostOnly = this.eTs.getHostMode();
            historyMessage.isSquence = this.eTs.aUn();
            historyMessage.isShareThread = this.eTs.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eTG != null) {
            this.eTG.onDestroy();
        }
        if (this.eTb && aSQ() != null) {
            aSQ().aWQ();
        }
        if (this.eTs != null && (this.eTs.aUo() || this.eTs.aUq())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eTs.aUm());
            if (this.eTv) {
                if (this.eTx) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.eTs.aUs());
                }
                if (this.eTw) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.eTs.getIsGood());
                }
            }
            if (this.eTs.getPbData() != null && System.currentTimeMillis() - this.eTf >= 40000 && (aRx = this.eTs.getPbData().aRx()) != null && !com.baidu.tbadk.core.util.v.w(aRx.getDataList())) {
                intent.putExtra("guess_like_data", aRx);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.eTU);
            }
            setResult(-1, intent);
        }
        if (aTi()) {
            if (this.eTs != null && this.eTt != null && this.eTt.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eTs.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aRv() && !this.eTl) {
                        ai aVv = ai.aVv();
                        com.baidu.tieba.pb.data.f pbData2 = this.eTs.getPbData();
                        Parcelable onSaveInstanceState = this.eTt.getListView().onSaveInstanceState();
                        boolean aUn = this.eTs.aUn();
                        boolean hostMode = this.eTs.getHostMode();
                        if (this.eTt.aVU() == null || this.eTt.aVU().getVisibility() != 0) {
                            z = false;
                        }
                        aVv.a(pbData2, onSaveInstanceState, aUn, hostMode, z);
                        if (this.eTT >= 0 || this.eTs.aUV() != null) {
                            ai.aVv().j(this.eTs.aUV());
                            ai.aVv().i(this.eTs.aUW());
                            ai.aVv().qk(this.eTs.aUX());
                        }
                    }
                }
            } else {
                ai.aVv().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eTt == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eTt.qn(i)) {
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
            this.eTt.aVK();
            this.eTt.aVM().aUa();
            this.eTt.jW(false);
        }
        this.eTt.aVN();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.eTG.resetData();
                        this.eTG.b(writeData);
                        this.eTG.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.r eP = this.eTG.De().eP(6);
                        if (eP != null && eP.aBT != null) {
                            eP.aBT.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.eTG.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.eTt.aVM() != null && this.eTt.aVM().aUc() != null) {
                            com.baidu.tbadk.editortools.pb.h aUc = this.eTt.aVM().aUc();
                            aUc.b(writeData);
                            aUc.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.r eP2 = aUc.De().eP(6);
                            if (eP2 != null && eP2.aBT != null) {
                                eP2.aBT.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                aUc.DW();
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
        this.eTG.onActivityResult(i, i2, intent);
        if (this.eTp != null) {
            this.eTp.onActivityResult(i, i2, intent);
        }
        if (aSQ().aVM() != null) {
            aSQ().aVM().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    aTg();
                    return;
                case 13008:
                    ai.aVv().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eTs != null) {
                                PbActivity.this.eTs.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eTs != null) {
                        a(aTf(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aSV() == 1) {
                        aTe();
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aSW();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.cWR != null && shareItem != null && shareItem.linkUrl != null) {
                            this.cWR.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
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
                    this.eTt.jd(false);
                    if (this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null && this.eTs.getPbData().aRp().rQ() != null) {
                        this.eTs.getPbData().aRp().rQ().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.eTt != null && this.eTt.fbJ != null) {
                        this.eTt.fbJ.or();
                        this.eTt.fbJ.aXj();
                        if (this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null) {
                            this.eTs.getPbData().aRp().bO(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.eTq != null) {
                        this.eTt.bn(this.eTq);
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
            if (this.eTp == null) {
                this.eTp = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.eTp.b(this.aDL);
                this.eTp.c(this.aDS);
            }
            this.eTp.a(emotionImageData, aSw(), aSw().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTe() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null && this.eTs.getPbData().aRp().rH() != null && this.eTs.getPbData().aRp().rH().size() > 0 && this.eTs.getPbData().aRp().rH().get(0) != null) {
            this.mAwardActId = this.eTs.getPbData().aRp().rH().get(0).ps();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eTs.getPbData().getThreadId(), 0L));
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
                    this.eTt.aWb();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aTf() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bM = this.eTs.getPbData().bM(getPageContext().getPageActivity());
        PostData aVP = this.eTt.aVP();
        String str = "";
        if (aVP != null) {
            str = aVP.getId();
            String ce = aVP.ce(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ce)) {
                bM[1] = ce;
            }
        }
        String rM = this.eTs.getPbData().aRp().rM();
        if (rM != null && rM.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bM[1]);
        shareFromPBMsgData.setImageUrl(bM[0]);
        shareFromPBMsgData.setForumName(this.eTs.getPbData().aRn().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eTs.getPbData().aRp().getId());
        shareFromPBMsgData.setTitle(this.eTs.getPbData().aRp().getTitle());
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(aTf(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(getPageContext().getPageActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ac = new com.baidu.tbadk.core.util.ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, PbActivity.this.eTs.getForumId()).ac("tid", PbActivity.this.eTs.aUm());
                        if (PbActivity.this.e(PbActivity.this.eTs.getPbData()) != 0) {
                            ac.r("obj_type", PbActivity.this.e(PbActivity.this.eTs.getPbData()));
                        }
                        TiebaStatic.log(ac);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aSV() == 1) {
                        PbActivity.this.aTe();
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
                kVar.I(shareFromPBMsgData.getImageUrl(), this.eTs.getPbData().aRB() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null) {
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
                    if (PbActivity.this.aSV() == 1) {
                        PbActivity.this.aTe();
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
                kVar.I(shareFromPBMsgData.getImageUrl(), this.eTs.getPbData().aRB() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTg() {
        MarkData qh;
        if (this.euo != null && (qh = this.eTs.qh(this.eTt.aWm())) != null) {
            if (!qh.isApp() || (qh = this.eTs.qh(this.eTt.aWm() + 1)) != null) {
                this.eTt.aWh();
                this.euo.a(qh);
                if (!this.euo.nH()) {
                    this.euo.nJ();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.euo.nI();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTh() {
        com.baidu.tieba.pb.data.f pbData = this.eTs.getPbData();
        this.eTs.jx(true);
        if (this.euo != null) {
            pbData.pG(this.euo.nG());
        }
        this.eTt.p(pbData);
    }

    private boolean aTi() {
        if (this.eTs == null) {
            return true;
        }
        if (this.eTs.nH()) {
            final MarkData aUB = this.eTs.aUB();
            if (aUB == null || !this.eTs.getIsFromMark()) {
                return true;
            }
            final MarkData qh = this.eTs.qh(this.eTt.aWl());
            if (qh == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", aUB);
                setResult(-1, intent);
                return true;
            } else if (qh.getPostId() == null || qh.getPostId().equals(aUB.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", aUB);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cS(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.euo != null) {
                            if (PbActivity.this.euo.nH()) {
                                PbActivity.this.euo.nI();
                                PbActivity.this.euo.ab(false);
                            }
                            PbActivity.this.euo.a(qh);
                            PbActivity.this.euo.ab(true);
                            PbActivity.this.euo.nJ();
                        }
                        aUB.setPostId(qh.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", aUB);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aTd();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", aUB);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aTd();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eTt != null && PbActivity.this.eTt.getView() != null) {
                            PbActivity.this.eTt.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", aUB);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aTd();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.th();
                return false;
            }
        } else if (this.eTs.getPbData() == null || this.eTs.getPbData().aRr() == null || this.eTs.getPbData().aRr().size() <= 0 || !this.eTs.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eTt == null) {
            return null;
        }
        return this.eTt.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int JW() {
        if (this.eTt == null) {
            return 0;
        }
        return this.eTt.aWu();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> JX() {
        if (this.aVx == null) {
            this.aVx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: YR */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean pe = com.baidu.tbadk.core.h.oY().pe();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.C0096d.common_color_10220));
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
                        foreDrawableImageView.setDefaultBgResource(d.C0096d.common_color_10220);
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
                        foreDrawableImageView.setDefaultBgResource(d.C0096d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aVx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> JY() {
        if (this.aVy == null) {
            this.aVy = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aVy;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> JZ() {
        if (this.aVC == null) {
            this.aVC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTE */
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
        return this.aVC;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Ka() {
        if (this.aVz == null) {
            this.aVz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTF */
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
        return this.aVz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Kc() {
        this.aVB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aTG */
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
        return this.aVB;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aoR == null) {
            this.aoR = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoR;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eTj = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        if (aw.pX(str) && this.eTs != null && this.eTs.aUm() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").r("obj_param1", 1).ac("post_id", this.eTs.aUm()));
        }
        aw.aWZ().f(getPageContext(), str);
        this.eTj = true;
    }

    private com.baidu.tbadk.core.dialog.a aTj() {
        if (this.eTe == null) {
            this.eTe = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eTe.cR(getPageContext().getString(d.j.download_baidu_video_dialog));
            this.eTe.a(getPageContext().getString(d.j.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
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
            this.eTe.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eTe.ao(true);
            this.eTe.b(getPageContext());
            this.eTe.ap(false);
        }
        this.eTe.th();
        return this.eTe;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        aw.aWZ().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eTj = true;
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
            aTj();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eTj = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eTs.getPbData();
            TbRichText au = au(str, i);
            if (au != null && (tbRichTextData = au.Jr().get(this.eUx)) != null) {
                cVar.eVj = new ArrayList<>();
                cVar.eVk = new ConcurrentHashMap<>();
                if (!tbRichTextData.Jx().JJ()) {
                    cVar.eVm = false;
                    String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                    cVar.eVj.add(b2);
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
                    imageUrlData.mIsReserver = this.eTs.aUA();
                    imageUrlData.mIsSeeHost = this.eTs.getHostMode();
                    cVar.eVk.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aRn() != null) {
                            cVar.forumName = pbData.aRn().getName();
                            cVar.forumId = pbData.aRn().getId();
                        }
                        if (pbData.aRp() != null) {
                            cVar.threadId = pbData.aRp().getId();
                        }
                        cVar.eVl = pbData.aRB() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.eVm = true;
                int size = pbData.aRr().size();
                this.eUy = false;
                cVar.index = -1;
                if (pbData.aRw() != null) {
                    PostData aRw = pbData.aRw();
                    TbRichText bwX = aRw.bwX();
                    if (!aq.k(aRw)) {
                        i2 = a(bwX, au, i, i, cVar.eVj, cVar.eVk);
                    } else {
                        i2 = a(aRw, i, cVar.eVj, cVar.eVk);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aRr().get(i4);
                    if (postData.getId() == null || pbData.aRw() == null || pbData.aRw().getId() == null || !postData.getId().equals(pbData.aRw().getId())) {
                        TbRichText bwX2 = postData.bwX();
                        if (!aq.k(postData)) {
                            i3 = a(bwX2, au, i3, i, cVar.eVj, cVar.eVk);
                        } else {
                            i3 = a(postData, i3, cVar.eVj, cVar.eVk);
                        }
                    }
                }
                if (cVar.eVj.size() > 0) {
                    cVar.lastId = cVar.eVj.get(cVar.eVj.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aRn() != null) {
                        cVar.forumName = pbData.aRn().getName();
                        cVar.forumId = pbData.aRn().getId();
                    }
                    if (pbData.aRp() != null) {
                        cVar.threadId = pbData.aRp().getId();
                    }
                    cVar.eVl = pbData.aRB() == 1;
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
            this.eUy = true;
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
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eTs.aUm(), -1L);
                                imageUrlData.mIsReserver = this.eTs.aUA();
                                imageUrlData.mIsSeeHost = this.eTs.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eUy) {
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
        com.baidu.tieba.tbadkCore.data.h bxd;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bwA;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bwA = (bxd = postData.bxd()).bwA()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bwA.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bwA.get(i3);
                if (jVar != null) {
                    String bwE = jVar.bwE();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bwE)) {
                        arrayList.add(bwE);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bwE;
                        if (com.baidu.tbadk.o.ak.fS()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bwD();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eTs.aUm(), -1L);
                        imageUrlData.mIsReserver = this.eTs.aUA();
                        imageUrlData.mIsSeeHost = this.eTs.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bxd.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bwE, imageUrlData);
                        }
                        if (!this.eUy) {
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
            if (postData.getId() != null && postData.getId().equals(this.eTs.rF())) {
                z = true;
            }
            MarkData h = this.eTs.h(postData);
            if (h != null) {
                this.eTt.aWh();
                if (this.euo != null) {
                    this.euo.a(h);
                    if (!z) {
                        this.euo.nJ();
                    } else {
                        this.euo.nI();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText au(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eTs == null || this.eTs.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eTs.getPbData();
        if (pbData.aRw() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aRw());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aRr = pbData.aRr();
            a(pbData, aRr);
            return a(aRr, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aRz() != null && fVar.aRz().eQr != null && (list = fVar.aRz().eQr) != null && arrayList != null) {
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
        ArrayList<PostData> aRr;
        com.baidu.tieba.pb.data.f pbData = this.eTs.getPbData();
        if (pbData != null && (aRr = pbData.aRr()) != null && !aRr.isEmpty()) {
            Iterator<PostData> it = aRr.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bxd = next.bxd();
                if (bxd != null && bxd.gBw) {
                    Iterator<TbRichTextData> it2 = next.bwX().Jr().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.JG().getLink().equals(str)) {
                            return bxd.getTemplateId();
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
            TbRichText bwX = arrayList.get(i2).bwX();
            if (bwX != null && (Jr = bwX.Jr()) != null) {
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
                            this.eUx = i4;
                            return bwX;
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
            this.eSG = str;
            if (this.eTd == null) {
                aSS();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eTd.cl(1).setVisibility(8);
            } else {
                this.eTd.cl(1).setVisibility(0);
            }
            this.eTd.tl();
            this.eTj = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cHh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTk() {
        hideNetRefreshView(this.eTt.getView());
        aTl();
        if (this.eTs.Fz()) {
            this.eTt.aWh();
        }
    }

    private void aTl() {
        showLoadingView(this.eTt.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View EU = getLoadingView().EU();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EU.getLayoutParams();
        layoutParams.addRule(3, this.eTt.aWI().getId());
        EU.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alB() {
        if (this.cHh != null) {
            this.cHh.stopPlay();
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
        if (this.eTs.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eTs.getPbData();
            pbData.aRn().getName();
            String title = pbData.aRp().getTitle();
            int i2 = this.eTs.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aRn() != null) {
                if ((pbData.aRn().isLike() == 1) && AddExperiencedModel.qk(pbData.getForumId())) {
                    z = true;
                    String str2 = "http://tieba.baidu.com/p/" + this.eTs.aUm() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bM = pbData.bM(getPageContext().getPageActivity());
                    str = bM[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    String str3 = bM[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aSV() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac("uid", currentAccount));
                    } else if (aSV() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ac(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ac("tid", pbData.getThreadId()).ac("uid", currentAccount));
                    }
                    String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str3);
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = format;
                    dVar.linkUrl = str2;
                    dVar.auw = true;
                    dVar.auA = z;
                    dVar.extData = this.eTs.aUm();
                    dVar.auK = 3;
                    dVar.auJ = i;
                    dVar.fid = this.eTs.getForumId();
                    dVar.tid = this.eTs.aUm();
                    dVar.auL = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.auE = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.eTs.getPbData().aRp());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.auK);
                    bundle.putInt("obj_type", dVar.auL);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.e(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRM()) {
                                PbActivity.this.eTt.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    if (this.anV == null) {
                        this.anV = new com.baidu.tieba.d.c(getActivity());
                    }
                    this.anV.a(shareDialogConfig);
                }
            }
            z = false;
            String str22 = "http://tieba.baidu.com/p/" + this.eTs.aUm() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bM2 = pbData.bM(getPageContext().getPageActivity());
            str = bM2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            String str32 = bM2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aSV() != 1) {
            }
            String format2 = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str32);
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = format2;
            dVar2.linkUrl = str22;
            dVar2.auw = true;
            dVar2.auA = z;
            dVar2.extData = this.eTs.aUm();
            dVar2.auK = 3;
            dVar2.auJ = i;
            dVar2.fid = this.eTs.getForumId();
            dVar2.tid = this.eTs.aUm();
            dVar2.auL = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.eTs.getPbData().aRp());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.auK);
            bundle2.putInt("obj_type", dVar2.auL);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.e(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.eTs != null && PbActivity.this.eTs.getPbData() != null && PbActivity.this.eTs.getPbData().aRM()) {
                        PbActivity.this.eTt.getView().setSystemUiVisibility(4);
                    }
                }
            });
            if (this.anV == null) {
            }
            this.anV.a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aRp() != null) {
            if (fVar.aRp().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aRp().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void aTm() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.ql(PbActivity.this.eTs.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eTt.aWR();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Kb() {
        if (this.aVA == null) {
            this.aVA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aTH */
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
        return this.aVA;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eTt.aWc() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, this.eTs.getPbData().getForumId()));
            } else {
                bd aRp = this.eTs.getPbData().aRp();
                if (view != null) {
                    boolean z = aRp.rk() == null || aRp.rk().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eUj > 1000) {
                            this.eUk = true;
                            bg(view);
                        } else {
                            this.eUk = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            m(view, this.eUk);
                        } else {
                            l(view, this.eUk);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        l(view, this.eUk);
                    } else if (motionEvent.getAction() == 3) {
                        l(view, this.eUk);
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
                    PbActivity.this.eUj = System.currentTimeMillis();
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
                    PbActivity.this.eUj = System.currentTimeMillis();
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
            int intValue = ((Integer) sparseArray.get(ar.fdy)).intValue();
            if (intValue == ar.fdz) {
                if (!this.cbH.bxI()) {
                    this.eTt.aWe();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cbH.a(this.eTs.getPbData().aRn().getId(), this.eTs.getPbData().aRn().getName(), this.eTs.getPbData().aRp().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ar.fdA || intValue == ar.fdC) {
                if (this.eTs.aUL() != null) {
                    this.eTs.aUL().pX(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.fdA) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ar.fdB) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eUD).pn()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eTN);
        userMuteAddAndDelCustomMessage.setTag(this.eTN);
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
        this.eTB = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aTn() {
        ArrayList<PostData> aRr;
        int v;
        if (this.eTs == null || this.eTs.getPbData() == null || this.eTs.getPbData().aRr() == null || (v = com.baidu.tbadk.core.util.v.v((aRr = this.eTs.getPbData().aRr()))) == 0) {
            return "";
        }
        if (this.eTs.aUA()) {
            Iterator<PostData> it = aRr.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bwU() == 1) {
                    return next.getId();
                }
            }
        }
        int aWl = this.eTt.aWl();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aRr, aWl);
        if (postData == null || postData.rv() == null) {
            return "";
        }
        if (this.eTs.pP(postData.rv().getUserId())) {
            return postData.getId();
        }
        for (int i = aWl - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aRr, i);
            if (postData2 == null || postData2.rv() == null || postData2.rv().getUserId() == null) {
                break;
            } else if (this.eTs.pP(postData2.rv().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aWl + 1; i2 < v; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aRr, i2);
            if (postData3 == null || postData3.rv() == null || postData3.rv().getUserId() == null) {
                return "";
            }
            if (this.eTs.pP(postData3.rv().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.av.vI().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(pK(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eTs.getPbData().aRn().getId(), this.eTs.getPbData().aRn().getName(), this.eTs.getPbData().aRp().getTid());
            }
            this.eTj = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eTs.aUK() != null) {
                    PbActivity.this.eTs.aUK().cx(j);
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
        if (this.eTs.getPbData() == null || this.eTs.getPbData().aRr() == null || this.eTs.getPbData().aRr().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.eTs.getPbData().aRr().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eTs.getPbData().aRr().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eTs.getPbData().aRr().get(i);
        if (postData.bwX() == null || postData.bwX().Jr() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bwX().Jr().iterator();
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
        if (this.eSZ) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eSZ = false;
        } else if (aTo()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eSZ) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eSZ = false;
        } else if (aTo()) {
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
        if (pageStayDurationItem != null && this.eTs != null) {
            if (this.eTs.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eTs.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eTs.aUm(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aTo() {
        return (!this.eSX && this.eUF == -1 && this.eUG == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.eUI = mVar;
            this.eSX = true;
            this.eTt.aVV();
            this.eTt.pV(this.eUH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTp() {
        if (this.eUI != null) {
            if (this.eUF == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aR(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eUI.getCartoonId(), this.eUF, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTq() {
        if (this.eUI != null) {
            if (this.eUG == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aR(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eUI.getCartoonId(), this.eUG, 0)));
                finish();
            }
        }
    }

    public int aTr() {
        return this.eUF;
    }

    public int aTs() {
        return this.eUG;
    }

    private void avd() {
        if (this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null && this.eTs.getPbData().aRp().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aTt() {
        if (this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null && this.eTs.getPbData().aRp().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aTu() {
        if (this.eTa) {
            this.eTo = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null && this.eTs.getPbData().aRp().rb() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eTs.getPbData().aRp().rb().getThreadId(), this.eTs.getPbData().aRp().rb().getTaskId(), this.eTs.getPbData().aRp().rb().getForumId(), this.eTs.getPbData().aRp().rb().getForumName(), this.eTs.getPbData().aRp().rq(), this.eTs.getPbData().aRp().rr())));
            this.eSZ = true;
            finish();
        }
    }

    public boolean aTv() {
        return this.eTa;
    }

    public String aTw() {
        return this.eTm;
    }

    public PbInterviewStatusView.a aTx() {
        return this.eTr;
    }

    public void jj(boolean z) {
        this.eTn = z;
    }

    public boolean aTy() {
        if (this.eTs != null) {
            return this.eTs.aUo();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cS(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eTL).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eTL.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eTL).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eTL != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eTL.getPageActivity());
            aVar.cS(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eTL).th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eTt.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eTL.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cS(this.eTL.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.cS(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eTt.showLoadingDialog();
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
        aVar.b(this.eTL).th();
    }

    public void aTA() {
        if (this.eTs != null && this.eTs.getPbData() != null && this.eTs.getPbData().aRp() != null && this.eTs.getPbData().aRp().sA() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cd(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eTs.getPbData().aRp().sA().channelId, true, PbActivity.this.getUniqueId())));
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
        if (this.eTt != null) {
            this.eTt.onConfigurationChanged(configuration);
        }
        if (this.eTz != null) {
            this.eTz.dismiss();
        }
    }

    public boolean aTB() {
        if (this.eTs != null) {
            return this.eTs.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.eTs.getPbData().aRz().eQr;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bwR().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bwR().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bwR().remove(i2);
                    list.get(i).bwT();
                    z = true;
                    break;
                }
            }
            list.get(i).te(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.p(this.eTs.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aSb().getId();
        List<PostData> list = this.eTs.getPbData().aRz().eQr;
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
                ArrayList<PostData> aSf = mVar.aSf();
                postData.uv(mVar.getTotalCount());
                if (postData.bwR() != null) {
                    postData.bwR().clear();
                    postData.bwR().addAll(aSf);
                }
            }
        }
        if (!this.eTs.getIsFromMark()) {
            this.eTt.p(this.eTs.getPbData());
        }
    }

    public boolean aTC() {
        if (this.eTs == null) {
            return false;
        }
        return this.eTs.aTC();
    }

    public void aTD() {
        if (this.eTt != null) {
            this.eTt.aVK();
            alC();
        }
    }

    public PostData aRw() {
        return this.eTt.b(this.eTs.eYk, this.eTs.aUn());
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
        if (this.eTV != null && !this.eTV.isEmpty()) {
            int size = this.eTV.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.eTV.get(i).onBackPressed()) {
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
            if (this.eTV == null) {
                this.eTV = new ArrayList();
            }
            if (!this.eTV.contains(aVar)) {
                this.eTV.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null && this.eTV != null) {
            this.eTV.remove(aVar);
        }
    }
}
