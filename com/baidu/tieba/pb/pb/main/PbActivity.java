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
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.adp.widget.d;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
import com.baidu.tbadk.core.atomData.NewFaceShopActivityConfig;
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
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.GodUserData;
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
import com.baidu.tbadk.widget.richText.b;
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
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.i;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.main.w;
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
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tbclient.MemeInfo;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.d {
    private com.baidu.adp.lib.e.b<ImageView> aRe;
    private com.baidu.adp.lib.e.b<TextView> aRf;
    private com.baidu.adp.lib.e.b<View> aRg;
    private com.baidu.adp.lib.e.b<View> aRh;
    private com.baidu.adp.lib.e.b<LinearLayout> aRi;
    private com.baidu.adp.lib.e.b<GifView> aRj;
    private ShareReportModel aok;
    private com.baidu.adp.lib.e.b<TbImageView> apf;
    private VoiceManager cpd;
    private com.baidu.tbadk.i.a cpx;
    private com.baidu.tieba.e.b csh;
    private String eGM;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eHB;
    private v eHJ;
    private boolean eHL;
    private com.baidu.tieba.tbadkCore.data.e eHO;
    private com.baidu.tbadk.editortools.pb.c eHP;
    private com.baidu.adp.base.e eHS;
    private com.baidu.tbadk.core.view.c eHT;
    private BdUniqueId eHU;
    private Runnable eHV;
    private aq eHW;
    private com.baidu.adp.widget.a.a eHX;
    private String eHY;
    private TbRichTextMemeInfo eHZ;
    private com.baidu.tieba.pb.pb.main.a.b eHh;
    private com.baidu.tbadk.core.dialog.a eHn;
    private boolean eHu;
    private com.baidu.tieba.pb.pb.main.b eHw;
    private String eIJ;
    private com.baidu.tbadk.core.data.n eIK;
    private boolean eIx;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eHg = false;
    private boolean eHi = false;
    private boolean eHj = false;
    private boolean emE = false;
    private boolean eHk = true;
    private int eHl = 0;
    private com.baidu.tbadk.core.dialog.b eHm = null;
    private long ccl = -1;
    private long aJO = 0;
    private long eHo = 0;
    private long createTime = 0;
    private long aJG = 0;
    private boolean eHp = false;
    private com.baidu.tbadk.l.d eHq = null;
    private long eHr = 0;
    private boolean eHs = false;
    private boolean eHt = false;
    private long eHv = 0;
    private String aDs = null;
    private boolean eHx = false;
    private boolean csX = false;
    private String eHy = "";
    private boolean eHz = true;
    private boolean eHA = false;
    private String source = "";
    private PbInterviewStatusView.a eHC = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eHE.jF(!PbActivity.this.eHz);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eGP != null && PbActivity.this.eGP.nG()) {
                        PbActivity.this.aQt();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel eGP = null;
    private com.baidu.tbadk.baseEditMark.a eiQ = null;
    private ForumManageModel eHD = null;
    private an eHE = null;
    public final com.baidu.tieba.pb.pb.main.a.a eHF = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eHG = false;
    private boolean eHH = false;
    private boolean eHI = false;
    private boolean eHK = false;
    private boolean eHM = false;
    private boolean eHN = false;
    private boolean eHQ = false;
    private com.baidu.tbadk.editortools.pb.b aDx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Ds() {
            PbActivity.this.showProgressBar();
        }
    };
    private boolean eHR = false;
    private int mLastScrollState = -1;
    private boolean cpK = false;
    private int eIa = -1;
    private final w.a eIb = new w.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void B(List<PostData> list) {
            if (PbActivity.this.eGP.getPbData().aPh() != null) {
                List<PostData> list2 = PbActivity.this.eGP.getPbData().aPh().eFe;
                int size = list2.size();
                if (!com.baidu.tbadk.core.util.v.v(list2)) {
                    PbActivity.this.eGP.getPbData().aPh().eFe.addAll(size, list);
                }
                PbActivity.this.eGP.a(PbActivity.this.eGP.getPbData(), size);
            }
            PbActivity.this.eHE.aSS().a(PbActivity.this.eGP.getPbData(), true);
            if (PbActivity.this.eHE != null && PbActivity.this.eHE.aSS() != null) {
                PbActivity.this.eHE.aSS().notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eHE.showToast(str);
            }
        }
    };
    private final CustomMessageListener eIc = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eGP != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eHP != null) {
                    PbActivity.this.eHE.hs(PbActivity.this.eHP.DB());
                }
                PbActivity.this.eHE.aSF();
                PbActivity.this.eHP.DE();
                PbActivity.this.eHE.aDB();
            }
        }
    };
    CustomMessageListener cpX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.eGP.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.eHE != null && PbActivity.this.eGP != null) {
                    PbActivity.this.eHE.d(PbActivity.this.eGP.getPbData(), PbActivity.this.eGP.aRs(), PbActivity.this.eGP.aRJ());
                }
                if (PbActivity.this.eHE != null && PbActivity.this.eHE.aSS() != null) {
                    PbActivity.this.eHE.aSS().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eId = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eHE != null) {
                    if (booleanValue) {
                        PbActivity.this.eHE.ayf();
                    } else {
                        PbActivity.this.eHE.aye();
                    }
                }
            }
        }
    };
    private CustomMessageListener dRA = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eHP != null) {
                    PbActivity.this.eHE.hs(PbActivity.this.eHP.DB());
                }
                PbActivity.this.eHE.ht(false);
            }
        }
    };
    private CustomMessageListener dRW = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
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
    private CustomMessageListener eIe = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eHE != null && PbActivity.this.eHE.aSS() != null) {
                PbActivity.this.eHE.aSS().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dqT = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private i.a eIf = new i.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        @Override // com.baidu.tieba.pb.pb.main.i.a
        public void j(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.pi(2);
                af.aSt().reset();
                PbActivity.this.eGP.aRK();
                boolean z2 = false;
                ArrayList<PostData> aOZ = PbActivity.this.eGP.getPbData().aOZ();
                if (aOZ != null) {
                    Iterator<PostData> it = aOZ.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (am.k(next) && next.bsw().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eHE.m(PbActivity.this.eGP.getPbData());
                    }
                    PbActivity.this.showToast(d.l.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(d.l.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.i.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(d.l.operation_failed);
        }
    };
    private View.OnClickListener dRz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aDs);
        }
    };
    CustomMessageListener dbg = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eIg = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                as.a aVar = new as.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.Wk = abVar.Wk;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGP.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eGP.aRA() != null && PbActivity.this.eGP.aRA().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eHE.a(abVar.sendCount, PbActivity.this.eGP.getPbData(), PbActivity.this.eGP.aRs(), PbActivity.this.eGP.aRJ());
                    }
                    if (pbData.aOZ() != null && pbData.aOZ().size() >= 1 && pbData.aOZ().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aOZ().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eGP.getThreadID(), 0L);
                        if (c2 == abVar.postId && c3 == abVar.threadId) {
                            as bsv = pbData.aOZ().get(0).bsv();
                            if (bsv == null) {
                                bsv = new as();
                            }
                            ArrayList<as.a> qC = bsv.qC();
                            if (qC == null) {
                                qC = new ArrayList<>();
                            }
                            qC.add(0, aVar);
                            bsv.bN(abVar.sendCount + bsv.qB());
                            bsv.g(qC);
                            pbData.aOZ().get(0).a(bsv);
                            PbActivity.this.eHE.aSS().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eIh = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.adM() != null && !aVar.adM().isEmpty()) {
                    PbActivity.this.eHE.a(aVar, PbActivity.this.eIi);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.aTO()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eIi = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aT(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.fK().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9.1
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
    private boolean eIj = false;
    private PraiseModel eIk = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hO(String str) {
            PbActivity.this.eIj = false;
            if (PbActivity.this.eIk != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGP.getPbData();
                if (pbData.aOX().rr().getIsLike() == 1) {
                    PbActivity.this.jo(0);
                } else {
                    PbActivity.this.jo(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aOX()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void B(int i, String str) {
            PbActivity.this.eIj = false;
            if (PbActivity.this.eIk != null && str != null) {
                if (AntiHelper.tz(i)) {
                    AntiHelper.ar(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eIl = 0;
    private boolean eIm = true;
    private b.a eIn = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void et(boolean z) {
            PbActivity.this.jd(z);
            if (PbActivity.this.eHE.aTr() != null && z) {
                PbActivity.this.eHE.jF(false);
            }
            PbActivity.this.eHE.jI(z);
        }
    };
    private CustomMessageListener bgO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().BW) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aPe().getAuthor() != null && PbActivity.this.aPe().getAuthor().getGodUserData() != null) {
                            PbActivity.this.aPe().getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        PbActivity.this.c(updateAttentionMessage);
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        PbActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bpV = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eHE.RV();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.pj(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.aoe();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.l.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRz = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eHE.aSG()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && ((PbActivity.this.eGP == null || PbActivity.this.eGP.getPbData() == null || !com.baidu.tieba.pb.f.Y(PbActivity.this.eGP.getPbData().aOX())) && PbActivity.this.eGP != null && (PbActivity.this.eGP.getPbData() != null || PbActivity.this.eGP.getPbData().aPt() != null))) {
                    if (PbActivity.this.eGP.getPbData().aPt().aPA()) {
                        if (PbActivity.this.eGP.getPbData().aPt().eEP == 1 || PbActivity.this.eGP.getPbData().aPt().eEP == 3 || PbActivity.this.eGP.getPbData().aPt().eEP == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eGP.getPbData().aPt().aPA() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eGP.getPbData().aPt().aPA() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eHv > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).ki(false);
                        PbActivity.this.eHv = System.currentTimeMillis();
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
                if (view.getId() == d.h.richText) {
                    if (PbActivity.this.bh(view)) {
                        return true;
                    }
                } else if (view.getId() == d.h.pb_floor_item_layout) {
                    if (view.getTag(d.h.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.h.pb_post_header_layout) {
                    if (PbActivity.this.eHE != null && PbActivity.this.eHE.aQd() && (view.getId() == d.h.pb_head_user_info_root || view == PbActivity.this.eHE.aTy())) {
                        if (view.getTag(d.h.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ad("obj_id", (String) view.getTag(d.h.tag_user_id)));
                        }
                        if (PbActivity.this.eHF != null && PbActivity.this.eHF.eUh != null) {
                            PbActivity.this.eHF.eUh.onClick(view);
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
            if (PbActivity.this.eHP != null) {
                PbActivity.this.eHE.hs(PbActivity.this.eHP.DB());
            }
            PbActivity.this.eHE.aSF();
            PbActivity.this.eHP.DE();
            PbActivity.this.eHE.aDB();
            return true;
        }
    });
    private CustomMessageListener eIo = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eHU) {
                PbActivity.this.eHE.RV();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGP.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aPk().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eHT.c(PbActivity.this.eHS.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eHS.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    PbActivity.this.ga(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aQK();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eHS.getResources().getString(d.l.mute_fail);
                    }
                    PbActivity.this.eHT.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eIp = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eHU) {
                PbActivity.this.eHE.RV();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eHT.c(PbActivity.this.eHS.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eHS.getResources().getString(d.l.un_mute_fail);
                }
                PbActivity.this.eHT.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eIq = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eHU) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eHE.RV();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gva;
                if (aVar.error == 0 && dataRes != null) {
                    int g = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = g == 1;
                    if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                        sparseArray.put(d.h.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(d.h.tag_user_mute_msg, str);
                    }
                    sparseArray.put(d.h.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(d.h.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(d.h.tag_from)).intValue();
                if (intValue == 0) {
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.eHE.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eIr = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eHE.aSG() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aQc() != null && PbActivity.this.aQc().getPbData() != null && PbActivity.this.aQc().getPbData().aPt() != null && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.Y(PbActivity.this.aQc().getPbData().aOX())) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aPA = PbActivity.this.aQc().getPbData().aPt().aPA();
                if (intValue < 10) {
                    if (aPA) {
                        if (PbActivity.this.eGP.getPbData().aPt().eEP == 1 || PbActivity.this.eGP.getPbData().aPt().eEP == 3 || PbActivity.this.eGP.getPbData().aPt().eEP == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eGP.getPbData().aPt().aPA() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPA ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eHv > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).ki(false);
                        PbActivity.this.eHv = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue / 11, aPA);
                TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aPA ? 0 : 1));
            }
        }
    };
    private CustomMessageListener cqi = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cpK = true;
                }
            }
        }
    };
    public a.b ewX = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.ahd();
            com.baidu.tbadk.core.data.ar asy = PbActivity.this.eGP.asy();
            int pageNum = PbActivity.this.eHE.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.l.pb_page_error);
            } else if (asy == null || pageNum <= asy.qu()) {
                PbActivity.this.eHE.aDB();
                PbActivity.this.pi(2);
                PbActivity.this.ahc();
                PbActivity.this.eHE.aSX();
                if (com.baidu.adp.lib.util.i.hi()) {
                    PbActivity.this.eGP.pp(PbActivity.this.eHE.getPageNum());
                    if (PbActivity.this.eHh != null) {
                        PbActivity.this.eHh.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(d.l.pb_page_error);
            }
        }
    };
    public final View.OnClickListener cqF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Multi-variable search result rejected for r4v161, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v165, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v206, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v33, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:638:0x1ce0  */
        /* JADX WARN: Removed duplicated region for block: B:660:0x1e9d  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            com.baidu.tieba.pb.data.l aPt;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            String str;
            int i;
            bn bnVar;
            SparseArray sparseArray;
            PostData postData;
            boolean j;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if ((PbActivity.this.eHE.eOq.aUt() != null && PbActivity.this.eHE.eOq.aUt().bm(view)) || PbActivity.this.eHE.aSR() == view || view.getId() == d.h.pb_item_tail_content) {
                        if (PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && com.baidu.tieba.pb.f.Y(PbActivity.this.eGP.getPbData().aOX())) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (view == PbActivity.this.eHE.getNextView()) {
                        if (!PbActivity.this.mIsLoading && PbActivity.this.eGP.jl(true)) {
                            PbActivity.this.mIsLoading = true;
                            PbActivity.this.eHE.aSY();
                        }
                    } else if (PbActivity.this.eHE.eOq.aUt() == null || view != PbActivity.this.eHE.eOq.aUt().aSo()) {
                        if (view == PbActivity.this.eHE.eOq.aLI) {
                            if (PbActivity.this.eHE.jK(PbActivity.this.eGP.aRx())) {
                                PbActivity.this.ahc();
                                return;
                            }
                            PbActivity.this.eHk = false;
                            PbActivity.this.eHi = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eHE.aSV() && (PbActivity.this.eHE.eOq.aUt() == null || (view != PbActivity.this.eHE.eOq.aUt().aSn() && view != PbActivity.this.eHE.eOq.aUt().aSl()))) {
                            if (view == PbActivity.this.eHE.aTm()) {
                                if (PbActivity.this.eGP != null) {
                                    com.baidu.tbadk.browser.a.T(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGP.getPbData().aOX().rA().getLink());
                                }
                            } else if (view != PbActivity.this.eHE.eOq.eUO) {
                                if (view == PbActivity.this.eHE.eOq.eUP) {
                                    if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null) {
                                        ArrayList<PostData> aOZ = PbActivity.this.eGP.getPbData().aOZ();
                                        if ((aOZ == null || aOZ.size() <= 0) && PbActivity.this.eGP.aRs()) {
                                            com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ad("tid", PbActivity.this.eGP.getThreadID()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("fid", PbActivity.this.eGP.getForumId()));
                                        if (!PbActivity.this.eHE.aTz()) {
                                            PbActivity.this.eHE.aSF();
                                        }
                                        PbActivity.this.aQk();
                                        return;
                                    }
                                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                } else if (view.getId() != d.h.pb_god_user_tip_content) {
                                    if (PbActivity.this.eHE.eOq.aUt() == null || view != PbActivity.this.eHE.eOq.aUt().aRZ()) {
                                        if ((PbActivity.this.eHE.eOq.aUt() == null || view != PbActivity.this.eHE.eOq.aUt().aSk()) && view.getId() != d.h.floor_owner_reply && view.getId() != d.h.reply_title) {
                                            if (PbActivity.this.eHE.eOq.aUt() == null || (view != PbActivity.this.eHE.eOq.aUt().getCancelView() && view != PbActivity.this.eHE.eOq.aUt().WQ())) {
                                                if (view == PbActivity.this.eHE.eOq.eUQ || (PbActivity.this.eHE.eOq.aUt() != null && view == PbActivity.this.eHE.eOq.aUt().aSs())) {
                                                    if (PbActivity.this.eGP != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ad("tid", PbActivity.this.eGP.getThreadID()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("fid", PbActivity.this.eGP.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                        if (com.baidu.adp.lib.util.k.hz()) {
                                                            if (PbActivity.this.eGP.getPbData() != null) {
                                                                ArrayList<PostData> aOZ2 = PbActivity.this.eGP.getPbData().aOZ();
                                                                if ((aOZ2 != null && aOZ2.size() > 0) || !PbActivity.this.eGP.aRs()) {
                                                                    PbActivity.this.eHE.aDB();
                                                                    PbActivity.this.ahc();
                                                                    PbActivity.this.pi(2);
                                                                    if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && PbActivity.this.eGP.getPbData().aPp() != null && !StringUtils.isNull(PbActivity.this.eGP.getPbData().aPp().pR(), true)) {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ad("fid", PbActivity.this.eGP.getPbData().getForumId()));
                                                                    }
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                    PbActivity.this.eHE.showLoadingDialog();
                                                                    PbActivity.this.eGP.aRT().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                    return;
                                                                }
                                                                com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                                                return;
                                                            }
                                                            com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                                            return;
                                                        }
                                                        PbActivity.this.showToast(d.l.neterror);
                                                        return;
                                                    }
                                                    return;
                                                } else if (PbActivity.this.eHE.eOq.aUt() != null && view == PbActivity.this.eHE.eOq.aUt().aSh()) {
                                                    PbActivity.this.eHE.aDB();
                                                    if (PbActivity.this.eGP.asy() != null) {
                                                        PbActivity.this.eHE.a(PbActivity.this.eGP.asy(), PbActivity.this.ewX);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    return;
                                                } else if (view.getId() == d.h.pb_sort) {
                                                    PbActivity.this.eHE.aDB();
                                                    if (com.baidu.adp.lib.util.i.hi()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Boolean.valueOf(PbActivity.this.eGP.aRE()));
                                                            return;
                                                        }
                                                        PbActivity.this.pi(2);
                                                        PbActivity.this.ahc();
                                                        PbActivity.this.eHE.aSX();
                                                        PbActivity.this.eHE.aSS().je(true);
                                                        boolean aRD = PbActivity.this.eGP.aRD();
                                                        view.setTag(Boolean.valueOf(PbActivity.this.eGP.aRE()));
                                                        TiebaStatic.log("c12097");
                                                        if (aRD) {
                                                            PbActivity.this.mIsLoading = true;
                                                            PbActivity.this.eHE.jD(true);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    PbActivity.this.showToast(d.l.network_not_available);
                                                    return;
                                                } else if (PbActivity.this.eHE.eOq.aUt() == null || view != PbActivity.this.eHE.eOq.aUt().aSi()) {
                                                    if (PbActivity.this.eHE.eOq.aUt() == null || view != PbActivity.this.eHE.eOq.aUt().aSj()) {
                                                        if (PbActivity.this.eHJ == null || view != PbActivity.this.eHJ.aSb()) {
                                                            if (PbActivity.this.eHJ == null || view != PbActivity.this.eHJ.aRZ()) {
                                                                if (PbActivity.this.eHJ == null || view != PbActivity.this.eHJ.aSe()) {
                                                                    if (PbActivity.this.eHJ == null || view != PbActivity.this.eHJ.aSc()) {
                                                                        if (PbActivity.this.eHJ == null || view != PbActivity.this.eHJ.aSd()) {
                                                                            if (PbActivity.this.eHE.aTr() == view) {
                                                                                if (PbActivity.this.eHE.aTr().getIndicateStatus()) {
                                                                                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGP.getPbData();
                                                                                    if (pbData != null && pbData.aOX() != null && pbData.aOX().ri() != null) {
                                                                                        String pC = pbData.aOX().ri().pC();
                                                                                        if (StringUtils.isNull(pC)) {
                                                                                            pC = pbData.aOX().ri().getTaskId();
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ad("obj_id", pC));
                                                                                    }
                                                                                } else {
                                                                                    com.baidu.tieba.tbadkCore.d.a.ci("c10725", null);
                                                                                }
                                                                                PbActivity.this.aQF();
                                                                                return;
                                                                            } else if (PbActivity.this.eHE.aSR() != view) {
                                                                                if (PbActivity.this.eHJ == null || view != PbActivity.this.eHJ.aSa()) {
                                                                                    if (PbActivity.this.eHE.eOq.aUt() == null || view != PbActivity.this.eHE.eOq.aUt().aSp()) {
                                                                                        if (PbActivity.this.eHE.eOq.aUt() != null && view == PbActivity.this.eHE.eOq.aUt().aSm()) {
                                                                                            if (com.baidu.adp.lib.util.i.hi()) {
                                                                                                SparseArray<Object> c2 = PbActivity.this.eHE.c(PbActivity.this.eGP.getPbData(), PbActivity.this.eGP.aRs(), 1);
                                                                                                if (c2 != null) {
                                                                                                    PbActivity.this.eHE.a(((Integer) c2.get(d.h.tag_del_post_type)).intValue(), (String) c2.get(d.h.tag_del_post_id), ((Integer) c2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.h.tag_del_post_is_self)).booleanValue());
                                                                                                }
                                                                                                PbActivity.this.eHE.eOq.ol();
                                                                                                return;
                                                                                            }
                                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                                            return;
                                                                                        } else if (view.getId() != d.h.sub_pb_more && view.getId() != d.h.sub_pb_item && view.getId() != d.h.pb_floor_reply_more) {
                                                                                            if (view != PbActivity.this.eHE.aPW()) {
                                                                                                if (view == PbActivity.this.eHE.eOq.aUu()) {
                                                                                                    PbActivity.this.eHE.aTf();
                                                                                                    return;
                                                                                                }
                                                                                                int id = view.getId();
                                                                                                if (id == d.h.pb_u9_text_view) {
                                                                                                    if (PbActivity.this.checkUpIsLogin() && (bnVar = (bn) view.getTag()) != null && !StringUtils.isNull(bnVar.td())) {
                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                        au.wd().c(PbActivity.this.getPageContext(), new String[]{bnVar.td()});
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if ((id == d.h.pb_floor_agree || id == d.h.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                    PostData bi = PbActivity.this.bi(view);
                                                                                                    if (bi != null) {
                                                                                                        TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", bi.bsB() ? 0 : 1));
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.view_main_thread_praise_state) {
                                                                                                    PbActivity.this.f(view, 2, false);
                                                                                                    if (PbActivity.this.aQc() != null && PbActivity.this.aQc().getPbData() != null && PbActivity.this.aQc().getPbData().aPt() != null && PbActivity.this.aQc().getPbData().aPt() != null) {
                                                                                                        TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aQc().getPbData().aPt().aPA() ? 0 : 1));
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.view_main_thread_praise_num || id == d.h.view_main_thread_praise_name_list) {
                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && !StringUtils.isNull(PbActivity.this.eGP.getPbData().getThreadId()) && (aPt = PbActivity.this.eGP.getPbData().aPt()) != null && aPt.getPraiseNum() > 0) {
                                                                                                        au.wd().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eGP.getPbData().getThreadId()});
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.replybtn || id == d.h.cover_reply_content || id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right || id == d.h.image_more_tip) {
                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                        PostData postData2 = null;
                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.h.tag_load_sub_data);
                                                                                                            if (postData2 == null || !com.baidu.tieba.pb.f.d(postData2)) {
                                                                                                                if (PbActivity.this.eHJ == null) {
                                                                                                                    PbActivity.this.eHJ = new v(PbActivity.this.getPageContext(), PbActivity.this.cqF);
                                                                                                                    PbActivity.this.eHJ.jp(PbActivity.this.mIsLogin);
                                                                                                                }
                                                                                                                PbActivity.this.eHJ.showDialog();
                                                                                                                boolean z6 = id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right;
                                                                                                                if (z6) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ad("tid", PbActivity.this.eGP.eLb));
                                                                                                                }
                                                                                                                SparseArray sparseArray2 = new SparseArray();
                                                                                                                sparseArray2.put(d.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.h.tag_clip_board));
                                                                                                                sparseArray2.put(d.h.tag_is_subpb, false);
                                                                                                                PbActivity.this.eHJ.aRZ().setTag(sparseArray2);
                                                                                                                PbActivity.this.eHJ.aSe().setTag(view.getTag());
                                                                                                                PbActivity.this.eHJ.jr(z6);
                                                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                                                boolean booleanValue = ((Boolean) sparseArray3.get(d.h.tag_should_manage_visible)).booleanValue();
                                                                                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(d.h.tag_user_mute_visible)).booleanValue();
                                                                                                                boolean booleanValue3 = ((Boolean) sparseArray3.get(d.h.tag_should_delete_visible)).booleanValue();
                                                                                                                if (!(sparseArray3.get(d.h.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                    z2 = false;
                                                                                                                } else {
                                                                                                                    z2 = ((Boolean) sparseArray3.get(d.h.tag_del_post_is_self)).booleanValue();
                                                                                                                }
                                                                                                                String str2 = null;
                                                                                                                if (sparseArray3.get(d.h.tag_forbid_user_post_id) instanceof String) {
                                                                                                                    str2 = (String) sparseArray3.get(d.h.tag_forbid_user_post_id);
                                                                                                                }
                                                                                                                if (booleanValue) {
                                                                                                                    SparseArray sparseArray4 = new SparseArray();
                                                                                                                    sparseArray4.put(d.h.tag_should_manage_visible, true);
                                                                                                                    sparseArray4.put(d.h.tag_manage_user_identity, sparseArray3.get(d.h.tag_manage_user_identity));
                                                                                                                    sparseArray4.put(d.h.tag_forbid_user_name, sparseArray3.get(d.h.tag_forbid_user_name));
                                                                                                                    sparseArray4.put(d.h.tag_forbid_user_post_id, str2);
                                                                                                                    if (booleanValue2) {
                                                                                                                        sparseArray4.put(d.h.tag_user_mute_visible, true);
                                                                                                                        sparseArray4.put(d.h.tag_is_mem, sparseArray3.get(d.h.tag_is_mem));
                                                                                                                        sparseArray4.put(d.h.tag_user_mute_mute_userid, sparseArray3.get(d.h.tag_user_mute_mute_userid));
                                                                                                                        sparseArray4.put(d.h.tag_user_mute_mute_username, sparseArray3.get(d.h.tag_user_mute_mute_username));
                                                                                                                        sparseArray4.put(d.h.tag_user_mute_post_id, sparseArray3.get(d.h.tag_user_mute_post_id));
                                                                                                                        sparseArray4.put(d.h.tag_user_mute_thread_id, sparseArray3.get(d.h.tag_user_mute_thread_id));
                                                                                                                    } else {
                                                                                                                        sparseArray4.put(d.h.tag_user_mute_visible, false);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        sparseArray4.put(d.h.tag_should_delete_visible, true);
                                                                                                                        sparseArray4.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                        sparseArray4.put(d.h.tag_del_post_id, sparseArray3.get(d.h.tag_del_post_id));
                                                                                                                        sparseArray4.put(d.h.tag_del_post_type, sparseArray3.get(d.h.tag_del_post_type));
                                                                                                                        PbActivity.this.eHJ.aSc().setVisibility(0);
                                                                                                                    } else {
                                                                                                                        sparseArray4.put(d.h.tag_should_delete_visible, false);
                                                                                                                        PbActivity.this.eHJ.aSc().setVisibility(8);
                                                                                                                    }
                                                                                                                    PbActivity.this.eHJ.aSa().setTag(sparseArray4);
                                                                                                                    PbActivity.this.eHJ.aSc().setTag(sparseArray4);
                                                                                                                    PbActivity.this.eHJ.aSa().setText(d.l.bar_manager);
                                                                                                                    PbActivity.this.eHJ.aSa().setVisibility(0);
                                                                                                                } else if (!booleanValue3) {
                                                                                                                    PbActivity.this.eHJ.aSa().setVisibility(8);
                                                                                                                    PbActivity.this.eHJ.aSc().setVisibility(8);
                                                                                                                } else {
                                                                                                                    SparseArray sparseArray5 = new SparseArray();
                                                                                                                    sparseArray5.put(d.h.tag_should_manage_visible, false);
                                                                                                                    sparseArray5.put(d.h.tag_user_mute_visible, false);
                                                                                                                    sparseArray5.put(d.h.tag_should_delete_visible, true);
                                                                                                                    sparseArray5.put(d.h.tag_manage_user_identity, sparseArray3.get(d.h.tag_manage_user_identity));
                                                                                                                    sparseArray5.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                    sparseArray5.put(d.h.tag_del_post_id, sparseArray3.get(d.h.tag_del_post_id));
                                                                                                                    sparseArray5.put(d.h.tag_del_post_type, sparseArray3.get(d.h.tag_del_post_type));
                                                                                                                    PbActivity.this.eHJ.aSa().setTag(sparseArray5);
                                                                                                                    PbActivity.this.eHJ.aSc().setTag(sparseArray5);
                                                                                                                    PbActivity.this.eHJ.aSa().setText(d.l.delete);
                                                                                                                    PbActivity.this.eHJ.aSc().setVisibility(0);
                                                                                                                    PbActivity.this.eHJ.aSa().setVisibility(8);
                                                                                                                }
                                                                                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                                                                                if (!(sparseArray6.get(d.h.tag_user_mute_visible) instanceof Boolean)) {
                                                                                                                    z3 = false;
                                                                                                                } else {
                                                                                                                    z3 = ((Boolean) sparseArray6.get(d.h.tag_user_mute_visible)).booleanValue();
                                                                                                                }
                                                                                                                if (!((Boolean) sparseArray6.get(d.h.tag_should_manage_visible)).booleanValue() && z3) {
                                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                                    sparseArray7.put(d.h.tag_user_mute_visible, true);
                                                                                                                    sparseArray7.put(d.h.tag_is_mem, sparseArray6.get(d.h.tag_is_mem));
                                                                                                                    sparseArray7.put(d.h.tag_user_mute_mute_userid, sparseArray6.get(d.h.tag_user_mute_mute_userid));
                                                                                                                    sparseArray7.put(d.h.tag_user_mute_mute_username, sparseArray6.get(d.h.tag_user_mute_mute_username));
                                                                                                                    sparseArray7.put(d.h.tag_user_mute_post_id, sparseArray6.get(d.h.tag_user_mute_post_id));
                                                                                                                    sparseArray7.put(d.h.tag_user_mute_thread_id, sparseArray6.get(d.h.tag_user_mute_thread_id));
                                                                                                                    sparseArray7.put(d.h.tag_del_post_is_self, sparseArray6.get(d.h.tag_del_post_is_self));
                                                                                                                    sparseArray7.put(d.h.tag_del_post_type, sparseArray6.get(d.h.tag_del_post_type));
                                                                                                                    sparseArray7.put(d.h.tag_del_post_id, sparseArray6.get(d.h.tag_del_post_id));
                                                                                                                    sparseArray7.put(d.h.tag_manage_user_identity, sparseArray6.get(d.h.tag_manage_user_identity));
                                                                                                                    PbActivity.this.eHJ.aSb().setTag(sparseArray7);
                                                                                                                    PbActivity.this.eHJ.aSb().setVisibility(0);
                                                                                                                    PbActivity.this.eHJ.aSa().setVisibility(8);
                                                                                                                    PbActivity.this.eHJ.aSb().setText(d.l.mute_option);
                                                                                                                } else {
                                                                                                                    if (!(sparseArray6.get(d.h.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                        z4 = false;
                                                                                                                    } else {
                                                                                                                        z4 = ((Boolean) sparseArray6.get(d.h.tag_del_post_is_self)).booleanValue();
                                                                                                                    }
                                                                                                                    String str3 = null;
                                                                                                                    if (sparseArray6.get(d.h.tag_forbid_user_post_id) instanceof String) {
                                                                                                                        str3 = (String) sparseArray6.get(d.h.tag_forbid_user_post_id);
                                                                                                                    }
                                                                                                                    boolean iZ = PbActivity.this.iZ(z4) & PbActivity.this.isLogin();
                                                                                                                    PbActivity.this.eIB = (PostData) sparseArray6.get(d.h.tag_clip_board);
                                                                                                                    if (am.k(PbActivity.this.eIB) ? false : iZ) {
                                                                                                                        PbActivity.this.eHJ.aSb().setVisibility(0);
                                                                                                                        PbActivity.this.eHJ.aSb().setTag(str3);
                                                                                                                    } else {
                                                                                                                        PbActivity.this.eHJ.aSb().setVisibility(8);
                                                                                                                    }
                                                                                                                }
                                                                                                                SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                                                                long j2 = 0;
                                                                                                                if (!(sparseArray8.get(d.h.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                    z5 = false;
                                                                                                                } else {
                                                                                                                    z5 = ((Boolean) sparseArray8.get(d.h.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                }
                                                                                                                if (sparseArray8.get(d.h.tag_chudian_template_id) instanceof Long) {
                                                                                                                    j2 = ((Long) sparseArray8.get(d.h.tag_chudian_template_id)).longValue();
                                                                                                                }
                                                                                                                if (!(sparseArray8.get(d.h.tag_chudian_monitor_id) instanceof String)) {
                                                                                                                    str = "";
                                                                                                                } else {
                                                                                                                    str = (String) sparseArray8.get(d.h.tag_chudian_monitor_id);
                                                                                                                }
                                                                                                                if (!(sparseArray8.get(d.h.tag_chudian_hide_day) instanceof Integer)) {
                                                                                                                    i = 0;
                                                                                                                } else {
                                                                                                                    i = ((Integer) sparseArray8.get(d.h.tag_chudian_hide_day)).intValue();
                                                                                                                }
                                                                                                                if (z5) {
                                                                                                                    PbActivity.this.eHJ.aSd().setVisibility(0);
                                                                                                                    PbActivity.this.eHJ.aSd().setTag(d.h.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                    PbActivity.this.eHJ.aSd().setTag(d.h.tag_chudian_monitor_id, str);
                                                                                                                    PbActivity.this.eHJ.aSd().setTag(d.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                } else {
                                                                                                                    PbActivity.this.eHJ.aSd().setVisibility(8);
                                                                                                                }
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                        if (PbActivity.this.eGP.getPbData().nG()) {
                                                                                                            String nF = PbActivity.this.eGP.getPbData().nF();
                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.j.isEmpty(nF) && nF.equals(postData2.getId())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    PbActivity.this.eHJ.aRZ().setText(d.l.remove_mark);
                                                                                                                } else {
                                                                                                                    PbActivity.this.eHJ.aRZ().setText(d.l.mark);
                                                                                                                }
                                                                                                                PbActivity.this.eHJ.jq(true);
                                                                                                                PbActivity.this.eHJ.refreshUI();
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        PbActivity.this.eHJ.jq(true);
                                                                                                        PbActivity.this.eHJ.refreshUI();
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.pb_act_btn) {
                                                                                                    if (PbActivity.this.eGP.getPbData() != null && PbActivity.this.eGP.getPbData().aOX() != null && PbActivity.this.eGP.getPbData().aOX().sh() != null) {
                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), PbActivity.this.eGP.getPbData().aOX().sh());
                                                                                                        if (PbActivity.this.eGP.getPbData().aOX().sf() != 1) {
                                                                                                            if (PbActivity.this.eGP.getPbData().aOX().sf() == 2) {
                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        }
                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.lottery_tail) {
                                                                                                    if (view.getTag(d.h.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                        String str4 = (String) view.getTag(d.h.tag_pb_lottery_tail_link);
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ad("fid", PbActivity.this.eGP.getPbData().getForumId()).ad("tid", PbActivity.this.eGP.getPbData().getThreadId()).ad("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (PbActivity.this.eGP.getPbData().getThreadId().equals(str4)) {
                                                                                                            PbActivity.this.eHE.setSelection(0);
                                                                                                            return;
                                                                                                        } else {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.pb_item_tail_content) {
                                                                                                    if (ax.aT(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.l.tail_web_view_title);
                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                            TiebaStatic.log("c10056");
                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                        }
                                                                                                        PbActivity.this.eHE.aSF();
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.join_vote_tv) {
                                                                                                    if (view != null) {
                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (PbActivity.this.aQh() == 1) {
                                                                                                            if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null) {
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ad("fid", PbActivity.this.eGP.getPbData().getForumId()).ad("tid", PbActivity.this.eGP.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        } else if (PbActivity.this.aQh() == 2 && PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null) {
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ad("fid", PbActivity.this.eGP.getPbData().getForumId()).ad("tid", PbActivity.this.eGP.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                            return;
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.look_all_tv) {
                                                                                                    if (view != null) {
                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                        if (PbActivity.this.aQh() == 1) {
                                                                                                            if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null) {
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ad("fid", PbActivity.this.eGP.getPbData().getForumId()).ad("tid", PbActivity.this.eGP.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        } else if (PbActivity.this.aQh() == 2 && PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null) {
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ad("fid", PbActivity.this.eGP.getPbData().getForumId()).ad("tid", PbActivity.this.eGP.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                            return;
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.manga_prev_btn) {
                                                                                                    PbActivity.this.aQA();
                                                                                                    return;
                                                                                                } else if (id == d.h.manga_next_btn) {
                                                                                                    PbActivity.this.aQB();
                                                                                                    return;
                                                                                                } else if (id == d.h.yule_head_img_img) {
                                                                                                    if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && PbActivity.this.eGP.getPbData().aPp() != null) {
                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eGP.getPbData();
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ad("fid", pbData2.getForumId()));
                                                                                                        au.wd().c(PbActivity.this.getPageContext(), new String[]{pbData2.aPp().aPw()});
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.yule_head_img_all_rank) {
                                                                                                    if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && PbActivity.this.eGP.getPbData().aPp() != null) {
                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eGP.getPbData();
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ad("fid", pbData3.getForumId()));
                                                                                                        au.wd().c(PbActivity.this.getPageContext(), new String[]{pbData3.aPp().aPw()});
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (PbActivity.this.eHE.eOq.aUt() != null && view == PbActivity.this.eHE.eOq.aUt().aSq()) {
                                                                                                    if (PbActivity.this.eGP == null || PbActivity.this.eGP.getPbData() == null || PbActivity.this.eGP.getPbData().aOX() == null) {
                                                                                                        PbActivity.this.eHE.eOq.ol();
                                                                                                        return;
                                                                                                    } else if (!com.baidu.adp.lib.util.k.hz()) {
                                                                                                        PbActivity.this.showToast(d.l.neterror);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        int i2 = 1;
                                                                                                        if (PbActivity.this.eGP.getPbData().aOX().rl() == 0) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGP.getThreadID(), 25028)));
                                                                                                        } else {
                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.l.haved_fans_called)).tw();
                                                                                                            i2 = 2;
                                                                                                        }
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").r("obj_locate", PbActivity.this.ab(PbActivity.this.eGP.getPbData().aOX())).ad("tid", PbActivity.this.eGP.getPbData().aOX().getTid()).r("obj_type", i2));
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eGP.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eGP.getThreadID(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eGP.getPbData().aOX().rV())));
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                            if (PbActivity.this.eGP.getPbData() != null) {
                                                                                                PbActivity.this.eHE.aDB();
                                                                                                SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                PostData postData3 = (PostData) sparseArray9.get(d.h.tag_load_sub_data);
                                                                                                View view2 = (View) sparseArray9.get(d.h.tag_load_sub_view);
                                                                                                if (postData3 != null && view2 != null) {
                                                                                                    String threadID = PbActivity.this.eGP.getThreadID();
                                                                                                    String id2 = postData3.getId();
                                                                                                    int i3 = 0;
                                                                                                    if (PbActivity.this.eGP.getPbData() != null) {
                                                                                                        i3 = PbActivity.this.eGP.getPbData().aPi();
                                                                                                    }
                                                                                                    if (!com.baidu.tieba.pb.f.d(postData3)) {
                                                                                                        PbActivity.this.ahc();
                                                                                                        if (view.getId() == d.h.replybtn) {
                                                                                                            b pj = PbActivity.this.pj(id2);
                                                                                                            if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && pj != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i3, postData3.aVy(), PbActivity.this.eGP.getPbData().qn(), false, postData3.getAuthor().getIconInfo()).addBigImageData(pj.eJe, pj.eJf, pj.eJg, pj.index)));
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        } else if (view.getId() == d.h.sub_pb_item) {
                                                                                                            SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                                                                            String str5 = (String) sparseArray10.get(d.h.tag_photo_username);
                                                                                                            String str6 = (String) sparseArray9.get(d.h.tag_photo_userid);
                                                                                                            PostData postData4 = (PostData) sparseArray10.get(d.h.tag_load_sub_data);
                                                                                                            String str7 = null;
                                                                                                            if (postData4 != null) {
                                                                                                                str7 = postData4.getId();
                                                                                                            }
                                                                                                            TiebaStatic.log("c11741");
                                                                                                            b pj2 = PbActivity.this.pj(id2);
                                                                                                            if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && pj2 != null && PbActivity.this.aQb().aSD() != null) {
                                                                                                                com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                mVar.b(PbActivity.this.eGP.getPbData().aOV());
                                                                                                                mVar.Z(PbActivity.this.eGP.getPbData().aOX());
                                                                                                                mVar.f(postData4);
                                                                                                                PbActivity.this.aQb().aSD().d(mVar);
                                                                                                                PbActivity.this.aQb().aSD().setPostId(str7);
                                                                                                                PbActivity.this.a(view, str6, str5);
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        } else {
                                                                                                            TiebaStatic.log("c11742");
                                                                                                            b pj3 = PbActivity.this.pj(id2);
                                                                                                            if (postData3 != null && PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && pj3 != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i3, postData3.aVy(), PbActivity.this.eGP.getPbData().qn(), false, postData3.getAuthor().getIconInfo()).addBigImageData(pj3.eJe, pj3.eJf, pj3.eJg, pj3.index)));
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 3).ad("fid", PbActivity.this.eGP.getPbData().getForumId()));
                                                                                            return;
                                                                                        }
                                                                                    } else if (com.baidu.adp.lib.util.i.hi()) {
                                                                                        PbActivity.this.eHE.aDB();
                                                                                        SparseArray<Object> c3 = PbActivity.this.eHE.c(PbActivity.this.eGP.getPbData(), PbActivity.this.eGP.aRs(), 1);
                                                                                        if (c3 != null) {
                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGP.getPbData().aOV().getId(), PbActivity.this.eGP.getPbData().aOV().getName(), PbActivity.this.eGP.getPbData().aOX().getId(), String.valueOf(PbActivity.this.eGP.getPbData().getUserData().getUserId()), (String) c3.get(d.h.tag_forbid_user_name), (String) c3.get(d.h.tag_forbid_user_post_id))));
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    } else {
                                                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                } else if (!com.baidu.adp.lib.util.i.hi()) {
                                                                                    PbActivity.this.showToast(d.l.network_not_available);
                                                                                    return;
                                                                                } else {
                                                                                    SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                    if (sparseArray11 != null) {
                                                                                        if (!com.baidu.tieba.c.a.WI() || sparseArray11.get(d.h.tag_del_post_id) == null || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eGP.getThreadID(), (String) sparseArray11.get(d.h.tag_del_post_id))) {
                                                                                            boolean booleanValue4 = ((Boolean) sparseArray11.get(d.h.tag_should_manage_visible)).booleanValue();
                                                                                            boolean booleanValue5 = ((Boolean) sparseArray11.get(d.h.tag_should_delete_visible)).booleanValue();
                                                                                            boolean booleanValue6 = ((Boolean) sparseArray11.get(d.h.tag_user_mute_visible)).booleanValue();
                                                                                            if (booleanValue4) {
                                                                                                if (booleanValue6) {
                                                                                                    sparseArray11.put(d.h.tag_from, 1);
                                                                                                    sparseArray11.put(d.h.tag_check_mute_from, 2);
                                                                                                    PbActivity.this.c(sparseArray11);
                                                                                                    return;
                                                                                                }
                                                                                                sparseArray11.put(d.h.tag_check_mute_from, 2);
                                                                                                PbActivity.this.eHE.bn(view);
                                                                                                return;
                                                                                            } else if (booleanValue5) {
                                                                                                PbActivity.this.eHE.a(((Integer) sparseArray11.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.h.tag_del_post_id), ((Integer) sparseArray11.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.h.tag_del_post_is_self)).booleanValue());
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                            } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ad("fid", PbActivity.this.eGP.getPbData().getForumId()));
                                                                                return;
                                                                            } else {
                                                                                PbActivity.this.aPY();
                                                                                return;
                                                                            }
                                                                        }
                                                                        long j3 = -1;
                                                                        String str8 = "";
                                                                        int i4 = 0;
                                                                        if (view.getTag(d.h.tag_chudian_template_id) instanceof Long) {
                                                                            j3 = ((Long) view.getTag(d.h.tag_chudian_template_id)).longValue();
                                                                        }
                                                                        if (view.getTag(d.h.tag_chudian_monitor_id) instanceof String) {
                                                                            str8 = (String) view.getTag(d.h.tag_chudian_monitor_id);
                                                                        }
                                                                        if (view.getTag(d.h.tag_chudian_hide_day) instanceof Integer) {
                                                                            i4 = ((Integer) view.getTag(d.h.tag_chudian_hide_day)).intValue();
                                                                        }
                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eGP.getPbData();
                                                                        String str9 = null;
                                                                        String str10 = null;
                                                                        String str11 = null;
                                                                        if (pbData4 != null && pbData4.aOV() != null) {
                                                                            str9 = pbData4.aOV().getId();
                                                                            str10 = pbData4.aOV().getName();
                                                                            str11 = pbData4.getThreadId();
                                                                        }
                                                                        com.baidu.tieba.pb.b.a(j3, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                        PbActivity.this.a(j3, str8, str9, str10, str11, i4);
                                                                        return;
                                                                    }
                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                    if (sparseArray12 != null && (sparseArray12.get(d.h.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.h.tag_del_post_id) instanceof String) && (sparseArray12.get(d.h.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.h.tag_del_post_is_self) instanceof Boolean)) {
                                                                        boolean booleanValue7 = ((Boolean) sparseArray12.get(d.h.tag_del_post_is_self)).booleanValue();
                                                                        int intValue = ((Integer) sparseArray12.get(d.h.tag_manage_user_identity)).intValue();
                                                                        if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.WI() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eGP.getThreadID(), (String) sparseArray12.get(d.h.tag_del_post_id))) {
                                                                            PbActivity.this.eHE.a(((Integer) sparseArray12.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.h.tag_del_post_id), intValue, booleanValue7);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                if (PbActivity.this.eHJ.aSg()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ad("tid", PbActivity.this.eGP.eLb));
                                                                } else {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 1));
                                                                }
                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eGP.getPbData() != null) {
                                                                    PbActivity.this.eHE.aDB();
                                                                    if (!(view.getTag() instanceof SparseArray)) {
                                                                        sparseArray = null;
                                                                    } else {
                                                                        sparseArray = (SparseArray) view.getTag();
                                                                    }
                                                                    if (sparseArray == null || !(sparseArray.get(d.h.tag_load_sub_data) instanceof PostData)) {
                                                                        postData = null;
                                                                    } else {
                                                                        postData = (PostData) sparseArray.get(d.h.tag_load_sub_data);
                                                                    }
                                                                    if (postData != null) {
                                                                        String threadID2 = PbActivity.this.eGP.getThreadID();
                                                                        String id3 = postData.getId();
                                                                        int i5 = 0;
                                                                        if (PbActivity.this.eGP.getPbData() != null) {
                                                                            i5 = PbActivity.this.eGP.getPbData().aPi();
                                                                        }
                                                                        PbActivity.this.ahc();
                                                                        b pj4 = PbActivity.this.pj(id3);
                                                                        if (pj4 != null) {
                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID2, id3, "pb", true, null, true, null, i5, postData.aVy(), PbActivity.this.eGP.getPbData().qn(), false, postData.getAuthor().getIconInfo()).addBigImageData(pj4.eJe, pj4.eJf, pj4.eJg, pj4.index)));
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 2));
                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                PbActivity.this.bj(view);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 4));
                                                        if (!com.baidu.adp.lib.util.i.hi()) {
                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                            return;
                                                        }
                                                        Object tag = view.getTag();
                                                        if (tag instanceof String) {
                                                            PbActivity.this.pg((String) tag);
                                                            return;
                                                        } else if (tag instanceof SparseArray) {
                                                            SparseArray<Object> sparseArray13 = (SparseArray) tag;
                                                            if ((sparseArray13.get(d.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray13.get(d.h.tag_user_mute_visible)).booleanValue()) {
                                                                sparseArray13.put(d.h.tag_from, 0);
                                                                sparseArray13.put(d.h.tag_check_mute_from, 2);
                                                                PbActivity.this.c(sparseArray13);
                                                                return;
                                                            }
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), null, PbActivity.this.aQg(), true)));
                                                    PbActivity.this.eHE.eOq.ol();
                                                    PbActivity.this.eHE.eOq.aUt().aSr();
                                                    return;
                                                } else if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && PbActivity.this.eGP.getPbData().aOX() != null) {
                                                    PbActivity.this.eHE.eOq.ol();
                                                    PbActivity.this.pg(PbActivity.this.eGP.getPbData().aOX().rR());
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            PbActivity.this.eHE.eOq.ol();
                                        } else if (com.baidu.adp.lib.util.i.hi()) {
                                            PbActivity.this.eHE.aDB();
                                            if (PbActivity.this.eHE.eOq.aUt() != null && view == PbActivity.this.eHE.eOq.aUt().aSk() && !PbActivity.this.eHE.aTz()) {
                                                PbActivity.this.eHE.aSF();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.ahc();
                                                PbActivity.this.eHE.aSX();
                                                if (view.getId() == d.h.floor_owner_reply) {
                                                    j = PbActivity.this.eGP.j(true, PbActivity.this.aQy());
                                                } else {
                                                    j = view.getId() == d.h.reply_title ? PbActivity.this.eGP.j(false, PbActivity.this.aQy()) : PbActivity.this.eGP.pm(PbActivity.this.aQy());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.eHE.ji(true);
                                                    PbActivity.this.eHE.ayf();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.eHE.jD(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.pi(2);
                                                return;
                                            }
                                            view.setTag(Boolean.FALSE);
                                        } else {
                                            PbActivity.this.showToast(d.l.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                        }
                                    } else if (com.baidu.adp.lib.util.i.hi()) {
                                        PbActivity.this.eHE.aDB();
                                        if (PbActivity.this.ph(11009) && PbActivity.this.eGP.pw(PbActivity.this.eHE.aTc()) != null) {
                                            PbActivity.this.aQs();
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.l.network_not_available);
                                    }
                                } else if (com.baidu.adp.lib.util.i.hi()) {
                                    PbActivity.this.eHE.ji(true);
                                    PbActivity.this.eHE.aSF();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eHE.ayf();
                                        PbActivity.this.ahc();
                                        PbActivity.this.eHE.aSX();
                                        PbActivity.this.eGP.pm(PbActivity.this.aQy());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.pi(2);
                                    }
                                } else {
                                    PbActivity.this.showToast(d.l.network_not_available);
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.eGP.getPbData() != null && PbActivity.this.eGP.getPbData().aOX() != null && PbActivity.this.eGP.getPbData().aOX().so() && PbActivity.this.eGP.getPbData().aOX().rS() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.eGP.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eGP.aRr()) && PbActivity.this.eGP.getAppealInfo() != null) {
                                        name = PbActivity.this.eGP.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eGP.getPbData().aOV().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aRr = PbActivity.this.eGP.aRr();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eGP.aRt() && aRr != null && aRr.equals(name)) {
                                        PbActivity.this.finish();
                                        return;
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                        return;
                                    }
                                }
                                PbActivity.this.finish();
                            }
                        } else if (com.baidu.adp.lib.util.i.hi()) {
                            if (PbActivity.this.eGP.getPbData().aPi() == 1 && !PbActivity.this.eHD.bta()) {
                                PbActivity.this.eHE.aDB();
                                int i6 = 0;
                                if (PbActivity.this.eHE.eOq.aUt() == null || view != PbActivity.this.eHE.eOq.aUt().aSl()) {
                                    if (PbActivity.this.eHE.eOq.aUt() == null || view != PbActivity.this.eHE.eOq.aUt().aSn()) {
                                        if (view == PbActivity.this.eHE.aSV()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eGP.getPbData().aOX().rx() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eGP.getPbData().aOX().rw() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aOV = PbActivity.this.eGP.getPbData().aOV();
                                String name2 = aOV.getName();
                                String id4 = aOV.getId();
                                String id5 = PbActivity.this.eGP.getPbData().aOX().getId();
                                if (!com.baidu.tieba.c.a.WI() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eHE.aSU();
                                    PbActivity.this.eHD.a(id4, name2, id5, i6, PbActivity.this.eHE.aSW());
                                }
                            }
                        } else {
                            PbActivity.this.showToast(d.l.network_not_available);
                        }
                    } else if (com.baidu.adp.lib.util.i.hi()) {
                        PbActivity.this.eHE.aDB();
                        PbActivity.this.ahc();
                        PbActivity.this.eHE.aSX();
                        PbActivity.this.eHE.showLoadingDialog();
                        if (PbActivity.this.eHE.aSI() != null) {
                            PbActivity.this.eHE.aSI().setVisibility(8);
                        }
                        PbActivity.this.eGP.pp(1);
                        if (PbActivity.this.eHh != null) {
                            PbActivity.this.eHh.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.l.network_not_available);
                    }
                } else if (PbActivity.this.eHt) {
                    PbActivity.this.eHt = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.h.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && PbActivity.this.aQb().aSD() != null && postData5.getAuthor() != null && postData5.bso() != 1 && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.d(postData5)) {
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.eGP.getPbData().aOV());
                                mVar2.Z(PbActivity.this.eGP.getPbData().aOX());
                                mVar2.f(postData5);
                                PbActivity.this.aQb().aSD().d(mVar2);
                                PbActivity.this.aQb().aSD().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.getAuthor().getUserId(), "");
                                TiebaStatic.log("c11743");
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aDE = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.ahc();
            PbActivity.this.eHE.jG(z);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbActivity.this.eHE.aDB();
                if (PbActivity.this.eHP != null) {
                    PbActivity.this.eHE.hs(PbActivity.this.eHP.DB());
                }
                PbActivity.this.eHE.aSC();
                PbActivity.this.eHE.ht(true);
                PbActivity.this.eGP.aRG();
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eGP.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGP.getPbData();
                            if (pbData != null && pbData.aOX() != null && pbData.aOX().getAuthor() != null && (userId = pbData.aOX().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && PbActivity.this.eGP.aRz()) {
                                PbActivity.this.eHE.aSX();
                            }
                        } else if (PbActivity.this.eGP.aRz()) {
                            PbActivity.this.eHE.aSX();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eHE.m(PbActivity.this.eGP.getPbData());
                    }
                    if (PbActivity.this.eGP.aRw()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ad("tid", PbActivity.this.eGP.getThreadID()));
                    }
                }
            } else if (qVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    private final PbModel.a eIs = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eC;
            if (!z || fVar == null || fVar.aPg() != null || com.baidu.tbadk.core.util.v.u(fVar.aOZ()) >= 1) {
                PbActivity.this.emE = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eHE.aSZ();
                if (fVar == null || !fVar.aPd()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eHE.getView());
                } else if (PbActivity.this.eHE.aSA() == null) {
                    PbActivity.this.eHR = true;
                }
                PbActivity.this.eHE.aye();
                PbActivity.this.eHE.aST();
                if (PbActivity.this.csX || PbActivity.this.eHE.aTz()) {
                    PbActivity.this.eHE.aTp();
                } else {
                    PbActivity.this.eHE.ht(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eHK = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eHE.NH();
                    PbActivity.this.eHE.jM(fVar.aPd());
                    if (fVar.aOX() != null && fVar.aOX().sx() != null) {
                        PbActivity.this.a(fVar.aOX().sx());
                    }
                    if (PbActivity.this.eHP != null) {
                        PbActivity.this.eHE.hs(PbActivity.this.eHP.DB());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aOZ() != null && fVar.aOZ().size() >= 1 && fVar.aOZ().get(0) != null) {
                        PbActivity.this.eGP.po(fVar.aOZ().get(0).getId());
                    } else if (fVar.aPg() != null) {
                        PbActivity.this.eGP.po(fVar.aPg().getId());
                    }
                    if (PbActivity.this.eHP != null) {
                        PbActivity.this.eHP.a(fVar.qn());
                        PbActivity.this.eHP.a(fVar.aOV(), fVar.getUserData());
                        PbActivity.this.eHP.a(PbActivity.this.eGP.aRA(), PbActivity.this.eGP.getThreadID(), PbActivity.this.eGP.aRV());
                        if (fVar.aOX() != null) {
                            PbActivity.this.eHP.bK(fVar.aOX().sN());
                        }
                    }
                    if (PbActivity.this.eiQ != null) {
                        PbActivity.this.eiQ.ac(fVar.nG());
                    }
                    if (fVar == null || fVar.aPj() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eHE.jL(PbActivity.this.mIsFromCDN);
                    PbActivity.this.eHE.a(fVar, i2, i3, PbActivity.this.eGP.aRs(), i4, PbActivity.this.eGP.getIsFromMark());
                    PbActivity.this.eHE.d(fVar, PbActivity.this.eGP.aRs());
                    PbActivity.this.eHE.jJ(PbActivity.this.eGP.getHostMode());
                    AntiData qn = fVar.qn();
                    if (qn != null) {
                        PbActivity.this.aDs = qn.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aDs) && PbActivity.this.eHP != null && PbActivity.this.eHP.CV() != null && (eC = PbActivity.this.eHP.CV().eC(6)) != null && !TextUtils.isEmpty(PbActivity.this.aDs)) {
                            ((View) eC).setOnClickListener(PbActivity.this.dRz);
                        }
                    }
                    com.baidu.tieba.pb.f.oW(fVar.eEF);
                    if (PbActivity.this.eHM) {
                        PbActivity.this.eHM = false;
                        PbActivity.this.aQb().getListView().setSelection(PbActivity.this.aQm());
                    }
                    if (PbActivity.this.eHN) {
                        PbActivity.this.eHN = false;
                        int aQm = PbActivity.this.aQm();
                        if (aQm == -1) {
                            aQm = PbActivity.this.aQn();
                        }
                        if (PbActivity.this.aQb() != null && PbActivity.this.aQb().getListView() != null) {
                            PbActivity.this.aQb().getListView().setSelection(aQm);
                        }
                    } else {
                        PbActivity.this.eHE.aTd();
                    }
                    PbActivity.this.eGP.a(fVar.aOV(), PbActivity.this.eIh);
                } else if (str != null) {
                    if (!PbActivity.this.eHK && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eGP != null && PbActivity.this.eGP.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eGP.getAppealInfo().eEa)) {
                                    PbActivity.this.eHE.a(PbActivity.this.eGP.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eHE.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eHE.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                            }
                            PbActivity.this.eHE.aTp();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.eGP.getThreadID());
                            jSONObject.put("fid", PbActivity.this.eGP.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, jSONObject));
                    }
                    if (i != -1) {
                        PbActivity.this.eHE.pp(PbActivity.this.getResources().getString(d.l.list_no_more_new));
                    } else {
                        PbActivity.this.eHE.pp("");
                    }
                    PbActivity.this.eHE.wW();
                }
                PbActivity.this.aJO = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aQc().aRs() || PbActivity.this.aQc().getPbData().qD().qA() != 0 || PbActivity.this.aQc().aRN()) {
                    PbActivity.this.eHQ = true;
                    return;
                }
                return;
            }
            PbActivity.this.eGP.pp(1);
            if (PbActivity.this.eHh != null) {
                PbActivity.this.eHh.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void d(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eHE.m(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.r.Gx().Gy()) {
                com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m(i, z, responsedMessage, PbActivity.this.aJG, PbActivity.this.createTime, PbActivity.this.aJO, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.ccl : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aJG = 0L;
                if (mVar != null) {
                    mVar.Gs();
                }
            }
        }
    };
    private CustomMessageListener eIt = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aQh() == 1) {
                    PbActivity.this.aQq();
                }
                PbActivity.this.aQi();
            }
        }
    };
    private final a.InterfaceC0042a eIu = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eHE.aSZ();
            if (z) {
                if (PbActivity.this.eiQ != null) {
                    PbActivity.this.eiQ.ac(z2);
                }
                PbActivity.this.eGP.jn(z2);
                if (PbActivity.this.eGP.nG()) {
                    PbActivity.this.aQt();
                } else {
                    PbActivity.this.eHE.m(PbActivity.this.eGP.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.eiQ != null) {
                        if (PbActivity.this.eiQ.nJ() != null) {
                            PbActivity.this.showToast(d.l.add_mark_on_pb);
                            return;
                        } else {
                            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.l.add_mark));
                            return;
                        }
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.l.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.l.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            boolean z = true;
            if (!PbActivity.this.pg(PbActivity.this.mLastScrollState) && PbActivity.this.pg(i)) {
                if (PbActivity.this.eHE != null) {
                    PbActivity.this.eHE.aDB();
                    if (PbActivity.this.eHP != null && !PbActivity.this.eHE.aSG()) {
                        PbActivity.this.eHE.hs(PbActivity.this.eHP.DB());
                    }
                    PbActivity.this.eHE.aSF();
                }
                if (!PbActivity.this.eHp) {
                    PbActivity.this.eHp = true;
                    PbActivity.this.eHE.aTo();
                }
            }
            PbActivity.this.eHE.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eHh != null) {
                PbActivity.this.eHh.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eHq == null) {
                PbActivity.this.eHq = new com.baidu.tbadk.l.d();
                PbActivity.this.eHq.fi(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && PbActivity.this.eGP.getPbData().aOX() != null && PbActivity.this.eGP.getPbData().aOX().so()) {
                    z = false;
                }
                if (PbActivity.this.eHE.aSS() != null && z) {
                    PbActivity.this.eHE.aSS().notifyDataSetChanged();
                }
                PbActivity.this.eHq.Ge();
            } else if (i == 1) {
                PbActivity.this.eHq.Ge();
            } else {
                PbActivity.this.eHq.Ge();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aOZ;
            if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null && PbActivity.this.eHE != null && PbActivity.this.eHE.aSS() != null) {
                PbActivity.this.eHE.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eHh != null) {
                    PbActivity.this.eHh.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eGP.aRI() && (aOZ = PbActivity.this.eGP.getPbData().aOZ()) != null && !aOZ.isEmpty()) {
                    int aQZ = ((i + i2) - PbActivity.this.eHE.aSS().aQZ()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eGP.getPbData();
                    if (pbData != null) {
                        if (pbData.aPa() != null && pbData.aPa().hasData()) {
                            aQZ--;
                        }
                        if (pbData.aPb() != null && pbData.aPb().hasData()) {
                            aQZ--;
                        }
                        if (PbActivity.this.eHs) {
                            aQZ--;
                        }
                        int size = aOZ.size();
                        if (aQZ < 0 || aQZ >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eIv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eHD.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eGP.aRG();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cPZ || bVar.eWG <= 0 || bVar.gky == 0) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eHE.a(1, dVar.Ai, dVar.gkA, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eHD.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eHE.a(PbActivity.this.eHD.getLoadDataMode(), fVar.Ai, fVar.gkA, false);
                        PbActivity.this.eHE.al(fVar.gkC);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eHE.a(PbActivity.this.eHD.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final c eIw = new c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
    };
    private final k.b baj = new k.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aQz()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eGP.jm(true)) {
                PbActivity.this.eHE.aTa();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eIy = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eIx && PbActivity.this.aQz()) {
                PbActivity.this.aQB();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eGP.jl(false)) {
                    PbActivity.this.eHE.aSY();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eGP.getPbData() != null) {
                    PbActivity.this.eHE.aTn();
                }
                PbActivity.this.eIx = true;
            }
        }
    };
    private int eIz = 0;
    private final TbRichTextView.e aRy = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
        public void a(View view, String str, int i) {
            TbRichTextData tbRichTextData;
            try {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                b bVar = new b();
                PbActivity.this.a(str, i, bVar);
                if (bVar.eJi) {
                    TbRichText an = PbActivity.this.an(str, i);
                    if (an != null && (tbRichTextData = an.Iv().get(PbActivity.this.eIz)) != null && tbRichTextData.IH() != null && tbRichTextData.IH().memeInfo != null && !TextUtils.isEmpty(tbRichTextData.IH().memeInfo.detail_link)) {
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextData.IH().memeInfo.detail_link)));
                    }
                } else if (!bVar.eJh) {
                    ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eJe, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eJg, bVar.eJe.get(0), PbActivity.this.eGP.aRE(), bVar.eJf, true, false, PbActivity.this.eGP.getHostMode());
                    createConfig.getIntent().putExtra("from", "pb");
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                } else {
                    TbRichText an2 = PbActivity.this.an(str, i);
                    if (an2 != null && PbActivity.this.eIz >= 0 && PbActivity.this.eIz < an2.Iv().size()) {
                        String c2 = com.baidu.tieba.pb.data.g.c(an2.Iv().get(PbActivity.this.eIz));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= bVar.eJe.size()) {
                                break;
                            } else if (!bVar.eJe.get(i3).equals(c2)) {
                                i2 = i3 + 1;
                            } else {
                                bVar.index = i3;
                                break;
                            }
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eJe, bVar.index, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eJg, bVar.lastId, PbActivity.this.eGP.aRE(), bVar.eJf, true, false, PbActivity.this.eGP.getHostMode());
                        createConfig2.getIntent().putExtra("from", "pb");
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eIA = false;
    PostData eIB = null;
    private final b.InterfaceC0047b eIC = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eIB != null) {
                if (i == 0) {
                    PbActivity.this.eIB.bY(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eIB = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.h(PbActivity.this.eIB);
                }
            }
        }
    };
    private final b.InterfaceC0047b eID = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eHX != null && !TextUtils.isEmpty(PbActivity.this.eHY)) {
                if (i == 0) {
                    if (PbActivity.this.eHZ == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eHY));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eHY;
                        aVar.pkgId = PbActivity.this.eHZ.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eHZ.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eHW == null) {
                        PbActivity.this.eHW = new aq(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eHW.i(PbActivity.this.eHY, PbActivity.this.eHX.kR());
                }
                PbActivity.this.eHX = null;
                PbActivity.this.eHY = null;
            }
        }
    };
    private final View.OnLongClickListener avB = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eHX = ((TbImageView) view).getBdImage();
                PbActivity.this.eHY = ((TbImageView) view).getUrl();
                if (PbActivity.this.eHX != null && !TextUtils.isEmpty(PbActivity.this.eHY)) {
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eHZ = null;
                    } else {
                        PbActivity.this.eHZ = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eHE.a(PbActivity.this.eID, PbActivity.this.eHX.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eIB = (PostData) sparseArray.get(d.h.tag_clip_board);
                    if (PbActivity.this.eIB != null && PbActivity.this.eiQ != null) {
                        PbActivity.this.eHE.a(PbActivity.this.eIC, PbActivity.this.eiQ.nG() && PbActivity.this.eIB.getId() != null && PbActivity.this.eIB.getId().equals(PbActivity.this.eGP.rK()), ((Boolean) sparseArray.get(d.h.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a bIz = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!PbActivity.this.eHj && z && !PbActivity.this.eGP.aRy()) {
                PbActivity.this.Xb();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
        }
    };
    public View.OnTouchListener aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).arA()) {
                        break;
                    }
                }
            }
            PbActivity.this.csh.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0082a bZO = new a.InterfaceC0082a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        final int bzE;

        {
            this.bzE = (int) PbActivity.this.getResources().getDimension(d.f.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ag(int i, int i2) {
            if (N(i2) && PbActivity.this.eHE != null && PbActivity.this.eHh != null) {
                PbActivity.this.eHh.er(false);
                PbActivity.this.eHh.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ah(int i, int i2) {
            if (N(i2) && PbActivity.this.eHE != null && PbActivity.this.eHh != null) {
                PbActivity.this.eHh.er(true);
                if (Math.abs(i2) > this.bzE) {
                    PbActivity.this.eHh.hideFloatingView();
                }
                if (PbActivity.this.aQz()) {
                    PbActivity.this.eHE.aSO();
                    PbActivity.this.eHE.aSP();
                }
            }
        }

        private boolean N(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eIE = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // com.baidu.tieba.e.b.a
        public void ei(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aPP();
            } else {
                com.baidu.tieba.pb.a.b.aPO();
            }
        }
    };
    private String eIF = null;
    private final m.a eIG = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.l.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eIF = str2;
                PbActivity.this.eHE.pq(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eIH = -1;
    private int eII = -1;
    private CustomMessageListener eIL = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Td == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0045a) {
                    if (aVar.Te != null && !aVar.Te.hasError() && aVar.Te.getError() == 0) {
                        if (PbActivity.this.eHE != null) {
                            PbActivity.this.eHE.w(((a.C0045a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aQL();
                        }
                    } else if (z) {
                        if (aVar.Te != null && aVar.Te.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Te.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Te != null && !aVar.Te.hasError() && aVar.Te.getError() == 0) {
                        if (PbActivity.this.eHE != null && PbActivity.this.eHE != null) {
                            PbActivity.this.eHE.w(((a.C0045a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Te != null && aVar.Te.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Te.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Te == null || aVar.Te.hasError() || aVar.Te.getError() != 0) {
                        if (z) {
                            if (aVar.Te != null && aVar.Te.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Te.getErrorString());
                            } else {
                                PbActivity.this.showToast(d.l.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.l.channel_need_push), 1).show();
                    }
                }
            }
        }
    };
    private final CustomMessageListener cqb = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ad("obj_locate", "pb"));
                    au.wd().c(PbActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    private d.b Ib = new d.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.adp.widget.d.b
        public void lp() {
            PbActivity.this.eHE.aTB();
        }

        @Override // com.baidu.adp.widget.d.b
        public void X(boolean z) {
            if (z) {
                PbActivity.this.eHE.aTC();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void f(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> eJe;
        public ConcurrentHashMap<String, ImageUrlData> eJf;
        public boolean eJh;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eJg = false;
        public boolean eJi = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.c aPX() {
        return this.eHP;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar.aPF() != null) {
            String id = mVar.aPF().getId();
            ArrayList<PostData> aOZ = this.eGP.getPbData().aOZ();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aOZ.size()) {
                    break;
                }
                PostData postData = aOZ.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aPJ = mVar.aPJ();
                    postData.tt(mVar.getTotalCount());
                    if (postData.bsl() != null) {
                        postData.bsl().clear();
                        postData.bsl().addAll(aPJ);
                    }
                }
            }
            this.eHE.m(this.eGP.getPbData());
            c(mVar);
        }
    }

    public void aPY() {
        com.baidu.tieba.pb.data.f pbData;
        bj aOX;
        if (!this.eIj) {
            if (!com.baidu.adp.lib.util.k.hz()) {
                showToast(d.l.no_network_guide);
            } else if (this.eIm) {
                this.eIj = true;
                if (this.eGP != null && (pbData = this.eGP.getPbData()) != null && (aOX = pbData.aOX()) != null) {
                    int isLike = aOX.rr() == null ? 0 : aOX.rr().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ad("tid", aOX.getId()));
                    }
                    if (this.eIk != null) {
                        this.eIk.a(aOX.rR(), aOX.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(d.h.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(d.h.tag_check_mute_from) instanceof Integer)) {
            final String str = (String) sparseArray.get(d.h.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(d.h.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
                bVar.cf(d.l.operation);
                int i = -1;
                if (sparseArray.get(d.h.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.h.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.l.delete);
                    strArr[1] = z ? getResources().getString(d.l.un_mute) : getResources().getString(d.l.mute);
                    bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.eHE.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eHU);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eHU);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.l.un_mute) : getResources().getString(d.l.mute);
                    bVar.a(strArr2, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eHU);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eHU);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).tr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jo(int i) {
        bj aOX;
        String str;
        String y;
        if (this.eGP != null && this.eGP.getPbData() != null && (aOX = this.eGP.getPbData().aOX()) != null) {
            if (i == 1) {
                PraiseData rr = aOX.rr();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rr == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aOX.a(praiseData);
                    } else {
                        aOX.rr().getUser().add(0, metaData);
                        aOX.rr().setNum(aOX.rr().getNum() + 1);
                        aOX.rr().setIsLike(i);
                    }
                }
                if (aOX.rr() != null) {
                    if (aOX.rr().getNum() < 1) {
                        y = getResources().getString(d.l.frs_item_praise_text);
                    } else {
                        y = com.baidu.tbadk.core.util.am.y(aOX.rr().getNum());
                    }
                    this.eHE.U(y, true);
                }
            } else if (aOX.rr() != null) {
                aOX.rr().setIsLike(i);
                aOX.rr().setNum(aOX.rr().getNum() - 1);
                ArrayList<MetaData> user = aOX.rr().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aOX.rr().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aOX.rr().getNum() < 1) {
                    str = getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = aOX.rr().getNum() + "";
                }
                this.eHE.U(str, false);
            }
            if (this.eGP.aRs()) {
                this.eHE.aSS().notifyDataSetChanged();
            } else {
                this.eHE.n(this.eGP.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.adp.framework.message.Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().asy && !StringUtils.isNull(updateAttentionMessage.getData().asz, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().asz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eGP != null && this.eGP.getPbData() != null && this.eHE != null) {
            this.eHE.d(this.eGP.getPbData(), this.eGP.aRs(), this.eGP.aRJ());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eGP.t(bundle);
        if (this.cpd != null) {
            this.cpd.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eHP.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eHS = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.ccl = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eHy = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eHy)) {
                this.eHi = true;
            }
            this.eIH = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eII = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eIJ = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eHM = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eHN = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aQz()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.eIa = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.eHu = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.ccl = System.currentTimeMillis();
        }
        this.eHo = System.currentTimeMillis();
        this.aJG = this.eHo - this.ccl;
        super.onCreate(bundle);
        this.mSwipeBackLayout.setOnSlidingStateChangeListener(this.Ib);
        this.eHl = 0;
        v(bundle);
        if (this.eGP != null && this.eGP.getPbData() != null) {
            this.eGP.getPbData().pc(this.source);
        }
        initUI();
        if (intent != null && this.eHE != null) {
            this.eHE.eOj = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eHV == null) {
                    this.eHV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eHE.ps("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eHV, 1500L);
            }
        }
        this.cpd = new VoiceManager();
        this.cpd.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
        dVar.setForumName(this.eGP.aRr());
        if (this.eGP.getPbData() != null && this.eGP.getPbData().aOV() != null) {
            dVar.setForumId(this.eGP.getPbData().aOV().getId());
        }
        dVar.setFrom("pb");
        dVar.a(this.eGP);
        this.eHP = (com.baidu.tbadk.editortools.pb.c) dVar.aW(getActivity());
        this.eHP.d(this);
        this.eHP.a(this.aDE);
        this.eHP.a(this.aDx);
        this.eHP.a(this, bundle);
        this.eHP.CV().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eHP.CV().bD(true);
        iY(true);
        this.eHE.setEditorTools(this.eHP.CV());
        this.eHP.a(this.eGP.aRA(), this.eGP.getThreadID(), this.eGP.aRV());
        registerListener(this.dRA);
        if (!this.eGP.aRx()) {
            this.eHP.fU(this.eGP.getThreadID());
        }
        if (this.eGP.aRW()) {
            this.eHP.fS(getPageContext().getString(d.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eHP.fS(getPageContext().getString(d.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eHo;
        registerListener(this.eId);
        registerListener(this.dRW);
        registerListener(this.eIe);
        registerListener(this.cpX);
        registerListener(this.eIr);
        registerListener(this.eIc);
        this.eHO = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.ghH);
        this.eHO.brP();
        registerListener(this.eIg);
        registerListener(this.bgO);
        if (this.eGP != null) {
            this.eGP.aRL();
        }
        registerListener(this.eIt);
        registerListener(this.eIL);
        registerListener(this.cqi);
        this.eHw = new com.baidu.tieba.pb.pb.main.b(this.eGP, this);
        if (this.eHE != null && this.eHE.aTs() != null && this.eHE.aTt() != null) {
            this.eHh = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eHE.aTs(), this.eHE.aTt(), this.eHE.aSI());
            this.eHh.a(this.eIn);
        }
        if (this.eHg && this.eHE != null && this.eHE.aTt() != null) {
            this.eHE.aTt().setVisibility(8);
        }
        this.eHT = new com.baidu.tbadk.core.view.c();
        this.eHT.akH = 1000L;
        registerListener(this.eIq);
        registerListener(this.eIo);
        registerListener(this.eIp);
        this.eHU = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eHU;
        userMuteAddAndDelCustomMessage.setTag(this.eHU);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eHU;
        userMuteCheckCustomMessage.setTag(this.eHU);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eGP.aRT().a(this.bpV);
        if ("from_tieba_kuang".equals(this.eHy)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 2).ad("tid", this.eGP.getThreadID()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    public String aPZ() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aQa() {
        return this.eHh;
    }

    private void iY(boolean z) {
        this.eHP.bH(z);
        this.eHP.bI(z);
        this.eHP.bJ(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cpd != null) {
            this.cpd.onStart(getPageContext());
        }
    }

    public an aQb() {
        return this.eHE;
    }

    public PbModel aQc() {
        return this.eGP;
    }

    public void pe(String str) {
        if (this.eGP != null && !StringUtils.isNull(str) && this.eHE != null) {
            this.eHE.aST();
            this.eHE.jO(true);
            this.eGP.pe(str);
            this.eHx = true;
            this.eHE.aDB();
            this.eHE.aTp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eHj = false;
        } else {
            this.eHj = true;
        }
        super.onPause();
        if (this.eHE.aSA() != null && this.eHE.aSA().aPU() != null) {
            this.eHE.aSA().aPU().onPause();
        }
        BdListView listView = getListView();
        this.eHl = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eHl == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cpd != null) {
            this.cpd.onPause(getPageContext());
        }
        if (this.eHE != null) {
            this.eHE.onPause();
        }
        if (!this.eGP.aRx()) {
            this.eHP.fT(this.eGP.getThreadID());
        }
        if (this.eGP != null) {
            this.eGP.aRM();
        }
        MessageManager.getInstance().unRegisterListener(this.dqT);
        arU();
        MessageManager.getInstance().unRegisterListener(this.eIo);
        MessageManager.getInstance().unRegisterListener(this.eIp);
        MessageManager.getInstance().unRegisterListener(this.eIq);
        MessageManager.getInstance().unRegisterListener(this.cqb);
        MessageManager.getInstance().unRegisterListener(this.dbg);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aQd() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eGP.getPbData(), this.eGP.aRs(), this.eGP.aRJ());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eHj = false;
        super.onResume();
        if (this.eHA) {
            this.eHA = false;
            aQF();
        }
        if (this.eHE.aSA() != null && this.eHE.aSA().aPU() != null) {
            this.eHE.aSA().aPU().onResume();
        }
        if (aQd()) {
            this.eHr = System.currentTimeMillis();
        } else {
            this.eHr = -1L;
        }
        if (this.eHE != null && this.eHE.getView() != null) {
            if (!this.emE) {
                aQw();
            } else {
                hideLoadingView(this.eHE.getView());
            }
            this.eHE.onResume();
        }
        if (this.eHl == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eHE != null) {
            noNetworkView = this.eHE.aSB();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hi()) {
            noNetworkView.aL(false);
        }
        if (this.cpd != null) {
            this.cpd.onResume(getPageContext());
        }
        registerListener(this.dqT);
        this.eHL = false;
        aQE();
        registerListener(this.eIo);
        registerListener(this.eIp);
        registerListener(this.eIq);
        registerListener(this.cqb);
        registerListener(this.dbg);
        if (this.cpK) {
            Xb();
            this.cpK = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eHE.jE(z);
        if (this.eHJ != null) {
            this.eHJ.jp(z);
        }
        if (z && this.eHL) {
            this.eHE.aSY();
            this.eGP.jl(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eHr > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ad("obj_duration", (System.currentTimeMillis() - this.eHr) + ""));
            this.eHr = 0L;
        }
        if (this.eHP != null && this.eHP.CV() != null && this.eHP.CV().getVisibility() != 0) {
            this.eHP.DE();
        }
        if (aQb().aSE() != null) {
            aQb().aSE().onStop();
        }
        if (this.eHE.eOq != null && !this.eHE.eOq.YF()) {
            this.eHE.eOq.aDS();
        }
        if (this.eGP != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOV() != null && this.eGP.getPbData().aOX() != null) {
            com.baidu.tbadk.distribute.a.CF().a(getPageContext().getPageActivity(), "pb", this.eGP.getPbData().aOV().getId(), com.baidu.adp.lib.g.b.c(this.eGP.getPbData().aOX().getId(), 0L));
        }
        if (this.cpd != null) {
            this.cpd.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.eHw != null) {
            this.eHw.destroy();
        }
        if (!this.eHp && this.eHE != null) {
            this.eHp = true;
            this.eHE.aTo();
            a(false, (PostData) null);
        }
        if (this.eGP != null) {
            this.eGP.cancelLoadData();
            this.eGP.destory();
            if (this.eGP.aRS() != null) {
                this.eGP.aRS().onDestroy();
            }
        }
        if (this.eHP != null) {
            this.eHP.onDestroy();
        }
        if (this.eHD != null) {
            this.eHD.cancelLoadData();
        }
        if (this.eHE != null) {
            this.eHE.onDestroy();
            if (this.eHE.eOq != null) {
                this.eHE.eOq.aDS();
            }
        }
        if (this.eHq != null) {
            this.eHq.onDestroy();
        }
        if (this.eHh != null) {
            this.eHh.Hn();
        }
        super.onDestroy();
        if (this.cpd != null) {
            this.cpd.onDestory(getPageContext());
        }
        if (this.cpx != null) {
            this.cpx.destory();
        }
        this.eHE.aDB();
        MessageManager.getInstance().unRegisterListener(this.eIo);
        MessageManager.getInstance().unRegisterListener(this.eIp);
        MessageManager.getInstance().unRegisterListener(this.eIq);
        MessageManager.getInstance().unRegisterListener(this.eHU);
        MessageManager.getInstance().unRegisterListener(this.eIr);
        MessageManager.getInstance().unRegisterListener(this.cqi);
        this.eHS = null;
        this.eHT = null;
        com.baidu.tieba.recapp.d.a.bhI().bhK();
        if (this.eHV != null) {
            getSafeHandler().removeCallbacks(this.eHV);
        }
        if (this.eHB != null) {
            this.eHB.cancelLoadData();
        }
        if (this.eHE != null && this.eHE.eOq != null) {
            this.eHE.eOq.aUx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g aSS;
        ArrayList<PostData> aRa;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xY() && this.eHE != null && (aSS = this.eHE.aSS()) != null && (aRa = aSS.aRa()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aRa.iterator();
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
                        bVar.bGI = id;
                        bVar.bMP = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.YY == 1 && !TextUtils.isEmpty(id)) {
                    next.YY = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bGI = id;
                    bVar2.bMP = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eGP == null || this.eGP.getPbData() == null || this.eGP.getPbData().aOV() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eGP.getPbData().aOV().getFirst_class();
                    str2 = this.eGP.getPbData().aOV().getSecond_class();
                    str = this.eGP.getPbData().aOV().getId();
                    str4 = this.eGP.getThreadID();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.yb());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHE.onChangeSkinType(i);
        if (this.eHP != null && this.eHP.CV() != null) {
            this.eHP.CV().onChangeSkinType(i);
        }
        if (this.eHE.aSB() != null) {
            this.eHE.aSB().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eHE = new an(this, this.cqF, this.aRz);
        this.csh = new com.baidu.tieba.e.b(getActivity());
        this.csh.a(this.eIE);
        this.csh.a(this.bZO);
        this.eHE.setOnScrollListener(this.mOnScrollListener);
        this.eHE.d(this.eIy);
        this.eHE.a(this.baj);
        this.eHE.iS(com.baidu.tbadk.core.h.oS().oY());
        this.eHE.setOnImageClickListener(this.aRy);
        this.eHE.a(this.avB);
        this.eHE.c(this.bIz);
        this.eHE.a(this.eIw);
        this.eHE.jE(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bh(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gil == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oS().oY()) {
                    return false;
                }
                return pi(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eHE != null) {
            if (z && (!this.emE || this.eHR)) {
                aQw();
            } else {
                hideLoadingView(this.eHE.getView());
            }
            this.eHR = false;
        }
    }

    private void aQe() {
        if (this.eHm == null) {
            this.eHm = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eHm.a(new String[]{getPageContext().getString(d.l.call_phone), getPageContext().getString(d.l.sms_phone), getPageContext().getString(d.l.search_in_baidu)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eGM = PbActivity.this.eGM.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGM);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eGP.getThreadID(), PbActivity.this.eGM, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eGM = PbActivity.this.eGM.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGM);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eGP.getThreadID(), PbActivity.this.eGM, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eGM = PbActivity.this.eGM.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGM);
                        bVar.dismiss();
                    }
                }
            }).cg(b.a.abp).ch(17).d(getPageContext());
        }
    }

    private void v(Bundle bundle) {
        this.eGP = new PbModel(this);
        this.eGP.a(this.eIs);
        if (this.eGP.aRQ() != null) {
            this.eGP.aRQ().a(this.eIG);
        }
        if (this.eGP.aRP() != null) {
            this.eGP.aRP().a(this.eIf);
        }
        if (this.eGP.aRS() != null) {
            this.eGP.aRS().a(this.eIb);
        }
        if (bundle != null) {
            this.eGP.initWithBundle(bundle);
        } else {
            this.eGP.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eGP.jo(true);
        }
        af.aSt().T(this.eGP.aRq(), this.eGP.getIsFromMark());
        if (StringUtils.isNull(this.eGP.getThreadID())) {
            finish();
        } else {
            this.eGP.Fu();
        }
    }

    private void initData(Bundle bundle) {
        this.eiQ = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eiQ != null) {
            this.eiQ.a(this.eIu);
        }
        this.eHD = new ForumManageModel(this);
        this.eHD.setLoadDataCallBack(this.eIv);
        this.eHE.a(new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.i.hi()) {
                    PbActivity.this.showToast(d.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eGP.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eGP.getPbData().aOV().getId(), PbActivity.this.eGP.getPbData().aOV().getName(), PbActivity.this.eGP.getPbData().aOX().getId(), valueOf, str, str2)));
            }
        });
        this.eIk.setUniqueId(getUniqueId());
        this.eIk.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eHE.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eHU;
        userMuteCheckCustomMessage.setTag(this.eHU);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public PostData bi(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.h.tag_clip_board)) != null && !com.baidu.tieba.pb.f.d(postData)) {
            if (postData.bsB()) {
                postData.cO(postData.bsA() - 1);
            } else {
                postData.cO(postData.bsA() + 1);
            }
            postData.mH(!postData.bsB());
            ((PbFloorAgreeView) view).a(postData.bsB(), postData.bsA(), true);
            final int i = postData.bsB() ? 0 : 1;
            this.eGP.aRR().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pk(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).pJ(i2);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void a(CustomDialogData customDialogData) {
                    com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), customDialogData);
                }
            });
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.ak aQf() {
        return new com.baidu.tbadk.core.util.ak("c12003").ad("tid", this.eGP.eLb).r("obj_type", 0).ad("fid", this.eGP.getForumId()).r("obj_param1", this.eGP.getPbData().aOX().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQg() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eGP != null && this.eGP.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eGP.getPbData();
            if (pbData.aOV() != null) {
                sb.append("forum_name=").append(pf(pbData.aOV().getName()));
                sb.append("&");
            }
            if (pbData.aOX() != null) {
                bj aOX = pbData.aOX();
                sb.append("thread_id=").append(aOX.getId());
                sb.append("&");
                sb.append("thread_title=").append(pf(aOX.getTitle()));
                if (aOX.getAuthor() != null && aOX.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aOX.getAuthor().getPortrait());
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
                @Override // java.lang.Runnable
                public void run() {
                    int g;
                    int ae = (com.baidu.adp.lib.util.k.ae(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        g = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.g(PbActivity.this.getPageContext().getPageActivity(), d.f.ds120);
                    } else {
                        g = com.baidu.adp.lib.util.k.g(PbActivity.this.getPageContext().getPageActivity(), d.f.ds640);
                    }
                    int i = g - ae;
                    if (i > 0) {
                        PbActivity.this.aQb().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aQb().aSE() != null) {
                        PbActivity.this.aQb().aSE().bN(str, str2);
                    }
                    PbActivity.this.aQb().aTp();
                }
            }, 500L);
        }
    }

    private String pf(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null && this.eGP != null && this.eGP.getPbData() != null && postData.bso() > 1) {
            String threadID = this.eGP.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.eGP.getPbData() != null) {
                i = this.eGP.getPbData().aPi();
            }
            b pj = pj(id);
            if (pj != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, postData.aVy(), this.eGP.getPbData().qn(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(pj.eJe, pj.eJf, pj.eJg, pj.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        ak akVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.k.hz()) {
                showToast(d.l.no_network_guide);
            } else if (aQc() != null && aQc().getPbData() != null && aQc().getPbData().aPt() != null && !com.baidu.tieba.pb.f.Y(aQc().getPbData().aOX())) {
                com.baidu.tieba.pb.data.l aPt = aQc().getPbData().aPt();
                if (view == null || !(view.getTag(d.h.pb_main_thread_praise_view) instanceof ak)) {
                    akVar = null;
                } else {
                    akVar = (ak) view.getTag(d.h.pb_main_thread_praise_view);
                }
                if (aPt != null) {
                    int i2 = -1;
                    if (z) {
                        aPt.pc(i);
                    } else if (aPt.aPA()) {
                        aPt.aPC();
                        i2 = 1;
                    } else {
                        aPt.pd(i);
                        i2 = 0;
                    }
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pk(int i3) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void a(CustomDialogData customDialogData) {
                            com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), customDialogData);
                        }
                    };
                    if (this.eGP != null && this.eGP.aRR() != null) {
                        String str = "";
                        if (this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null) {
                            str = this.eGP.getPbData().aOX().rR();
                        }
                        if (this.eGP.getPbData() != null) {
                            this.eGP.getPbData().a(aPt);
                        }
                        if (z) {
                            this.eGP.aRR().a(str, 3, i, this.eGP.getForumId(), aVar);
                        } else {
                            this.eGP.aRR().a(str, i2, 3, i, this.eGP.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.eEP = i2;
                            kVar.eEQ = aPt;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (akVar != null) {
                        akVar.b(aPt);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQh() {
        if (this.eGP.getPbData() == null || this.eGP.getPbData().aOX() == null) {
            return -1;
        }
        return this.eGP.getPbData().aOX().sf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQi() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.pE(this.eGP.getForumId()) && this.eGP.getPbData() != null && this.eGP.getPbData().aOV() != null) {
            if (this.eGP.getPbData().aOV().isLike() == 1) {
                aQx();
                this.eGP.aRU().bP(this.eGP.getForumId(), this.eGP.getThreadID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iZ(boolean z) {
        if (this.eGP == null || this.eGP.getPbData() == null) {
            return false;
        }
        return ((this.eGP.getPbData().aPi() != 0) || this.eGP.getPbData().aOX() == null || this.eGP.getPbData().aOX().getAuthor() == null || TextUtils.equals(this.eGP.getPbData().aOX().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aQj() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.p.p.GQ()) {
            return "";
        }
        PostData aPe = aPe();
        if (this.eGP == null || (pbData = this.eGP.getPbData()) == null || pbData.getUserData() == null || pbData.aOX() == null || aPe == null || aPe.getAuthor() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aPe.getAuthor().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aOX().rl() == 0) {
            return "";
        }
        if (pbData.aOX().rl() == 0) {
            return getPageContext().getString(d.l.fans_call);
        }
        return getPageContext().getString(d.l.haved_fans_call);
    }

    private boolean ja(boolean z) {
        if (z) {
            return true;
        }
        if (this.eGP == null || this.eGP.getPbData() == null) {
            return false;
        }
        return this.eGP.getPbData().aPi() != 0;
    }

    private boolean jb(boolean z) {
        return (z || this.eGP == null || this.eGP.getPbData() == null || this.eGP.getPbData().aPi() == 0) ? false : true;
    }

    public void aQk() {
        if (this.eGP != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null && this.eGP.getPbData().aOX().getAuthor() != null) {
            if (this.eHE != null) {
                this.eHE.aSC();
            }
            bj aOX = this.eGP.getPbData().aOX();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aOX.getAuthor().getUserId());
            GodUserData godUserData = aOX.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            y yVar = new y();
            if (this.eGP.getPbData().aPi() == 1) {
                yVar.eMP = true;
                yVar.eMO = true;
                yVar.eMU = aOX.rw() == 1;
                yVar.eMT = aOX.rx() == 1;
            } else {
                yVar.eMP = false;
                yVar.eMO = false;
            }
            yVar.eML = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            yVar.eMQ = ja(equals);
            yVar.eMR = aQl();
            yVar.eMS = jb(equals);
            yVar.eMM = this.eGP.aRs();
            yVar.eFc = this.eiQ != null ? this.eiQ.nG() : false;
            yVar.eMK = iZ(equals);
            yVar.eMW = aQj();
            yVar.eMI = equals && this.eHE.aTg();
            yVar.eMJ = z;
            yVar.eMN = TbadkCoreApplication.getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            yVar.isHostOnly = this.eGP.getHostMode();
            yVar.eMV = false;
            if (aOX.rS() == null) {
                yVar.eMX = true;
            } else {
                yVar.eMX = false;
            }
            this.eHE.eOq.a(yVar);
        }
    }

    private boolean aQl() {
        if (this.eGP != null && this.eGP.aRs()) {
            return this.eGP.asy() == null || this.eGP.asy().qA() != 0;
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
        if (sparseArray != null && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null) {
            h(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQm() {
        if (aQb() == null || aQb().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aQb().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) fVar).mType == com.baidu.tieba.pb.data.j.eEM) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQn() {
        if (aQb() == null || aQb().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aQb().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.gij) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        Xb();
    }

    public void a(boolean z, MarkData markData) {
        this.eHE.aSZ();
        this.eGP.jn(z);
        if (this.eiQ != null) {
            this.eiQ.ac(z);
            if (markData != null) {
                this.eiQ.a(markData);
            }
        }
        if (this.eGP.nG()) {
            aQt();
        } else {
            this.eHE.m(this.eGP.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pg(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pg(String str) {
        if (!StringUtils.isNull(str) && this.eGP != null) {
            String threadID = this.eGP.getThreadID();
            String id = this.eGP.getPbData().aOV().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eGP.aRx()) {
                    antiData.setBlock_forum_name(this.eGP.getPbData().aOV().getName());
                    antiData.setBlock_forum_id(this.eGP.getPbData().aOV().getId());
                    antiData.setUser_name(this.eGP.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eGP.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.tz(i)) {
            AntiHelper.g(getPageContext().getPageActivity(), str, i);
        } else if (i == 230277) {
            ga(str);
        } else {
            this.eHE.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eHE.a(0, bVar.Ai, bVar.gkA, z);
            if (bVar.Ai) {
                if (bVar.gky == 1) {
                    ArrayList<PostData> aOZ = this.eGP.getPbData().aOZ();
                    int size = aOZ.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aOZ.get(i).getId())) {
                            i++;
                        } else {
                            aOZ.remove(i);
                            break;
                        }
                    }
                    this.eHE.m(this.eGP.getPbData());
                } else if (bVar.gky == 0) {
                    aQo();
                } else if (bVar.gky == 2) {
                    ArrayList<PostData> aOZ2 = this.eGP.getPbData().aOZ();
                    int size2 = aOZ2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aOZ2.get(i2).bsl().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aOZ2.get(i2).bsl().get(i3).getId())) {
                                i3++;
                            } else {
                                aOZ2.get(i2).bsl().remove(i3);
                                aOZ2.get(i2).bsn();
                                z2 = true;
                                break;
                            }
                        }
                        aOZ2.get(i2).sd(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eHE.m(this.eGP.getPbData());
                    }
                    a(bVar, this.eHE);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eHE.a(this.eHD.getLoadDataMode(), fVar.Ai, fVar.gkA, false);
            if (fVar.Ai) {
                this.eHG = true;
                if (i == 2 || i == 3) {
                    this.eHH = true;
                    this.eHI = false;
                } else if (i == 4 || i == 5) {
                    this.eHH = false;
                    this.eHI = true;
                }
                if (i == 2) {
                    this.eGP.getPbData().aOX().bU(1);
                    this.eGP.setIsGood(1);
                } else if (i == 3) {
                    this.eGP.getPbData().aOX().bU(0);
                    this.eGP.setIsGood(0);
                } else if (i == 4) {
                    this.eGP.getPbData().aOX().bT(1);
                    this.eGP.hR(1);
                } else if (i == 5) {
                    this.eGP.getPbData().aOX().bT(0);
                    this.eGP.hR(0);
                }
                this.eHE.c(this.eGP.getPbData(), this.eGP.aRs());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aQo() {
        if (this.eGP.aRt() || this.eGP.aRv()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eGP.getThreadID());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eGP.getThreadID()));
        if (aQu()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQp() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aPf;
        boolean z = true;
        if (this.eHE != null) {
            this.eHE.aDB();
        }
        if (this.eGP != null && this.eGP.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eGP.getPbData().aOX().getId();
            historyMessage.forumName = this.eGP.getPbData().aOV().getName();
            historyMessage.threadName = this.eGP.getPbData().aOX().getTitle();
            ArrayList<PostData> aOZ = this.eGP.getPbData().aOZ();
            int aTb = this.eHE != null ? this.eHE.aTb() : 0;
            if (aOZ != null && aTb >= 0 && aTb < aOZ.size()) {
                historyMessage.postID = aOZ.get(aTb).getId();
            }
            historyMessage.isHostOnly = this.eGP.getHostMode();
            historyMessage.isSquence = this.eGP.aRs();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eHP != null) {
            this.eHP.onDestroy();
        }
        if (this.eHk && aQb() != null) {
            aQb().aTA();
        }
        if (this.eGP != null && (this.eGP.aRt() || this.eGP.aRv())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eGP.getThreadID());
            if (this.eHG) {
                if (this.eHI) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eGP.aDs());
                }
                if (this.eHH) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eGP.getIsGood());
                }
            }
            if (this.eGP.getPbData() != null && System.currentTimeMillis() - this.eHo >= 40000 && (aPf = this.eGP.getPbData().aPf()) != null && !com.baidu.tbadk.core.util.v.v(aPf.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aPf);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eIa);
            }
            setResult(-1, intent);
        }
        if (aQu()) {
            if (this.eGP != null && this.eHE != null && this.eHE.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eGP.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aPd() && !this.eHx) {
                        af aSt = af.aSt();
                        com.baidu.tieba.pb.data.f pbData2 = this.eGP.getPbData();
                        Parcelable onSaveInstanceState = this.eHE.getListView().onSaveInstanceState();
                        boolean aRs = this.eGP.aRs();
                        boolean hostMode = this.eGP.getHostMode();
                        if (this.eHE.aSI() == null || this.eHE.aSI().getVisibility() != 0) {
                            z = false;
                        }
                        aSt.a(pbData2, onSaveInstanceState, aRs, hostMode, z);
                    }
                }
            } else {
                af.aSt().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eHE == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eHE.py(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ph(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.eHP.onActivityResult(i, i2, intent);
        if (this.eHB != null) {
            this.eHB.onActivityResult(i, i2, intent);
        }
        if (aQb().aSE() != null) {
            aQb().aSE().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aQs();
                    return;
                case 13008:
                    af.aSt().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eGP != null) {
                                PbActivity.this.eGP.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eGP != null) {
                        a(aQr(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    O(intent);
                    return;
                case 24006:
                    X(intent);
                    return;
                case 24007:
                    if (aQh() == 1) {
                        aQq();
                    }
                    intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aQi();
                        return;
                    }
                    return;
                case 24008:
                    this.eHE.iX(false);
                    if (this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null && this.eGP.getPbData().aOX().rV() != null) {
                        this.eGP.getPbData().aOX().rV().setStatus(2);
                        break;
                    }
                    break;
                case 25001:
                    break;
                case 25012:
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                    return;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        c(emotionImageData);
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.eHE != null && this.eHE.eOq != null) {
                        this.eHE.eOq.ol();
                        this.eHE.eOq.aUs();
                        if (this.eGP != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null) {
                            this.eGP.getPbData().aOX().bP(1);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.eHw != null) {
                this.eHw.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aQb() != null && aPX() != null && aQb().aSG() && com.baidu.tbadk.editortools.pb.a.Dr().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Dr().setStatus(0);
                    if (this.eHE != null) {
                        this.eHE.aSF();
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
            if (this.eHB == null) {
                this.eHB = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eHB.b(this.aDx);
                this.eHB.c(this.aDE);
            }
            this.eHB.a(emotionImageData, aQc(), aQc().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQq() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null && this.eGP.getPbData().aOX().rM() != null && this.eGP.getPbData().aOX().rM().size() > 0 && this.eGP.getPbData().aOX().rM().get(0) != null) {
            this.mAwardActId = this.eGP.getPbData().aOX().rM().get(0).pn();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eGP.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void X(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    pj(2);
                    return;
                case 2:
                    this.eHE.aSQ();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aQr() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bM = this.eGP.getPbData().bM(getPageContext().getPageActivity());
        PostData aSH = this.eHE.aSH();
        String str = "";
        if (aSH != null) {
            str = aSH.getId();
            String bZ = aSH.bZ(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bZ)) {
                bM[1] = bZ;
            }
        }
        String rR = this.eGP.getPbData().aOX().rR();
        if (rR != null && rR.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bM[1]);
        shareFromPBMsgData.setImageUrl(bM[0]);
        shareFromPBMsgData.setForumName(this.eGP.getPbData().aOV().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eGP.getPbData().aOX().getId());
        shareFromPBMsgData.setTitle(this.eGP.getPbData().aOX().getTitle());
        return shareFromPBMsgData;
    }

    private void O(Intent intent) {
        a(aQr(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eGP != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(lVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.eGP != null && PbActivity.this.eGP.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ad = new com.baidu.tbadk.core.util.ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ad("fid", PbActivity.this.eGP.getForumId()).ad("tid", PbActivity.this.eGP.getThreadID());
                        if (PbActivity.this.c(PbActivity.this.eGP.getPbData()) != 0) {
                            ad.r("obj_type", PbActivity.this.c(PbActivity.this.eGP.getPbData()));
                        }
                        TiebaStatic.log(ad);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aQh() == 1) {
                        PbActivity.this.aQq();
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(getPageContext()).to();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.L(shareFromPBMsgData.getImageUrl(), this.eGP.getPbData().aPj() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eGP != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(lVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aQh() == 1) {
                        PbActivity.this.aQq();
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(getPageContext()).to();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.L(shareFromPBMsgData.getImageUrl(), this.eGP.getPbData().aPj() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQs() {
        MarkData pw;
        if (this.eiQ != null && (pw = this.eGP.pw(this.eHE.aTc())) != null) {
            if (!pw.isApp() || (pw = this.eGP.pw(this.eHE.aTc() + 1)) != null) {
                this.eHE.aSX();
                this.eiQ.a(pw);
                if (!this.eiQ.nG()) {
                    this.eiQ.nI();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.eiQ.nH();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQt() {
        com.baidu.tieba.pb.data.f pbData = this.eGP.getPbData();
        this.eGP.jn(true);
        pbData.pb(this.eiQ.nF());
        this.eHE.m(pbData);
    }

    private boolean aQu() {
        if (this.eGP == null) {
            return true;
        }
        if (this.eGP.nG()) {
            final MarkData aRF = this.eGP.aRF();
            if (aRF == null || !this.eGP.getIsFromMark()) {
                return true;
            }
            final MarkData pw = this.eGP.pw(this.eHE.aTb());
            if (pw == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aRF);
                setResult(-1, intent);
                return true;
            } else if (pw.getPostId() == null || pw.getPostId().equals(aRF.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aRF);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cM(getPageContext().getString(d.l.alert_update_mark));
                aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.eiQ != null) {
                            if (PbActivity.this.eiQ.nG()) {
                                PbActivity.this.eiQ.nH();
                                PbActivity.this.eiQ.ac(false);
                            }
                            PbActivity.this.eiQ.a(pw);
                            PbActivity.this.eiQ.ac(true);
                            PbActivity.this.eiQ.nI();
                        }
                        aRF.setPostId(pw.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aRF);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aQp();
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aRF);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aQp();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eHE != null && PbActivity.this.eHE.getView() != null) {
                            PbActivity.this.eHE.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aRF);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aQp();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.to();
                return false;
            }
        } else if (this.eGP.getPbData() == null || this.eGP.getPbData().aOZ() == null || this.eGP.getPbData().aOZ().size() <= 0 || !this.eGP.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eHE == null) {
            return null;
        }
        return this.eHE.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IZ() {
        if (this.eHE == null) {
            return 0;
        }
        return this.eHE.aTj();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Ja() {
        if (this.aRe == null) {
            this.aRe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Uy */
                public ImageView fJ() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean oY = com.baidu.tbadk.core.h.oS().oY();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.e.common_color_10220));
                    if (oY) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(d.g.icon_click);
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
                        foreDrawableImageView.setDefaultBgResource(d.e.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView o(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.h.oS().oY()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(d.g.icon_click);
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
                        foreDrawableImageView.setDefaultBgResource(d.e.common_color_10220);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aRe;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Jb() {
        if (this.aRf == null) {
            this.aRf = TbRichTextView.m(getPageContext().getPageActivity(), 8);
        }
        return this.aRf;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jc() {
        if (this.aRj == null) {
            this.aRj = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQP */
                public GifView fJ() {
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
        return this.aRj;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jd() {
        if (this.aRh == null) {
            this.aRh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aoj */
                public View fJ() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.f.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aA */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aB */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aC */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aRh;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jf() {
        if (this.aRg == null) {
            this.aRg = com.baidu.tieba.graffiti.c.q(getPageContext().getPageActivity(), 6);
        }
        return this.aRg;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xp() {
        if (this.apf == null) {
            this.apf = UserIconBox.k(getPageContext().getPageActivity(), 8);
        }
        return this.apf;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eHt = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (ar.pt(str) && this.eGP != null && this.eGP.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").r("obj_param1", 1).ad("post_id", this.eGP.getThreadID()));
        }
        ar.aTE().f(getPageContext(), str);
        this.eHt = true;
    }

    private com.baidu.tbadk.core.dialog.a aQv() {
        if (this.eHn == null) {
            this.eHn = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eHn.cL(getPageContext().getString(d.l.download_baidu_video_dialog));
            this.eHn.a(getPageContext().getString(d.l.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.dH()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.uE());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.l.download_baidu_video));
                    }
                }
            });
            this.eHn.b(getPageContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eHn.ar(true);
            this.eHn.b(getPageContext());
            this.eHn.as(false);
        }
        this.eHn.to();
        return this.eHn;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
        ar.aTE().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eHt = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra(VrPlayerActivityConfig.TITLE, "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aQv();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eHt = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eGP.getPbData();
            TbRichText an = an(str, i);
            if (an != null && (tbRichTextData = an.Iv().get(this.eIz)) != null) {
                if (tbRichTextData.getType() == 20 || tbRichTextData.getType() == 17) {
                    bVar.eJi = true;
                    return;
                }
                bVar.eJe = new ArrayList<>();
                bVar.eJf = new ConcurrentHashMap<>();
                if (!tbRichTextData.IB().IO()) {
                    bVar.eJh = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.eJe.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = an.getPostId();
                    imageUrlData.mIsReserver = this.eGP.aRE();
                    imageUrlData.mIsSeeHost = this.eGP.getHostMode();
                    bVar.eJf.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aOV() != null) {
                            bVar.forumName = pbData.aOV().getName();
                            bVar.forumId = pbData.aOV().getId();
                        }
                        if (pbData.aOX() != null) {
                            bVar.threadId = pbData.aOX().getId();
                        }
                        bVar.eJg = pbData.aPj() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eJh = true;
                int size = pbData.aOZ().size();
                this.eIA = false;
                bVar.index = -1;
                if (pbData.aPe() != null) {
                    PostData aPe = pbData.aPe();
                    TbRichText aDg = aPe.aDg();
                    if (!am.k(aPe)) {
                        i2 = a(aDg, an, i, i, bVar.eJe, bVar.eJf);
                    } else {
                        i2 = a(aPe, i, bVar.eJe, bVar.eJf);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aOZ().get(i4);
                    if (postData.getId() == null || pbData.aPe() == null || pbData.aPe().getId() == null || !postData.getId().equals(pbData.aPe().getId())) {
                        TbRichText aDg2 = postData.aDg();
                        if (!am.k(postData)) {
                            i3 = a(aDg2, an, i3, i, bVar.eJe, bVar.eJf);
                        } else {
                            i3 = a(postData, i3, bVar.eJe, bVar.eJf);
                        }
                    }
                }
                if (bVar.eJe.size() > 0) {
                    bVar.lastId = bVar.eJe.get(bVar.eJe.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aOV() != null) {
                        bVar.forumName = pbData.aOV().getName();
                        bVar.forumId = pbData.aOV().getId();
                    }
                    if (pbData.aOX() != null) {
                        bVar.threadId = pbData.aOX().getId();
                    }
                    bVar.eJg = pbData.aPj() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IB() == null) {
            return null;
        }
        return tbRichTextData.IB().IS();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IB() == null) {
            return 0L;
        }
        return tbRichTextData.IB().getOriginalSize();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo IB;
        if (tbRichText == tbRichText2) {
            this.eIA = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Iv().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Iv().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int af = (int) com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.IB().getWidth() * af;
                    int height = af * tbRichTextData.IB().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.IB().IO()) {
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
                            if (tbRichTextData != null && (IB = tbRichTextData.IB()) != null) {
                                String IQ = IB.IQ();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = IQ;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eGP.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eGP.aRE();
                                imageUrlData.mIsSeeHost = this.eGP.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eIA) {
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
        com.baidu.tieba.tbadkCore.data.h bsw;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> brT;
        if (postData != null && arrayList != null && concurrentHashMap != null && (brT = (bsw = postData.bsw()).brT()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == brT.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = brT.get(i3);
                if (jVar != null) {
                    String brY = jVar.brY();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(brY)) {
                        arrayList.add(brY);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = brY;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.brX();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eGP.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eGP.aRE();
                        imageUrlData.mIsSeeHost = this.eGP.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bsw.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(brY, imageUrlData);
                        }
                        if (!this.eIA) {
                            i++;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    protected void h(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.eGP.rK())) {
                z = true;
            }
            MarkData j = this.eGP.j(postData);
            if (j != null) {
                this.eHE.aSX();
                if (this.eiQ != null) {
                    this.eiQ.a(j);
                    if (!z) {
                        this.eiQ.nI();
                    } else {
                        this.eiQ.nH();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText an(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eGP == null || this.eGP.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eGP.getPbData();
        if (pbData.aPe() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aPe());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aOZ = pbData.aOZ();
            a(pbData, aOZ);
            return a(aOZ, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aPh() != null && fVar.aPh().eFe != null && (list = fVar.aPh().eFe) != null && arrayList != null) {
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

    private long ph(String str) {
        ArrayList<PostData> aOZ;
        com.baidu.tieba.pb.data.f pbData = this.eGP.getPbData();
        if (pbData != null && (aOZ = pbData.aOZ()) != null && !aOZ.isEmpty()) {
            Iterator<PostData> it = aOZ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bsw = next.bsw();
                if (bsw != null && bsw.ghP) {
                    Iterator<TbRichTextData> it2 = next.aDg().Iv().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IK().getLink().equals(str)) {
                            return bsw.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Iv;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText aDg = arrayList.get(i2).aDg();
            if (aDg != null && (Iv = aDg.Iv()) != null) {
                int size = Iv.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Iv.get(i4) != null && Iv.get(i4).getType() == 8) {
                        i3++;
                        if (Iv.get(i4).IB().IQ().equals(str)) {
                            int af = (int) com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst());
                            int width = Iv.get(i4).IB().getWidth() * af;
                            int height = Iv.get(i4).IB().getHeight() * af;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eIz = i4;
                            return aDg;
                        } else if (i3 <= i) {
                            i4++;
                            i3 = i3;
                        }
                    } else {
                        if (Iv.get(i4) != null && Iv.get(i4).IH() != null && (Iv.get(i4).getType() == 20 || Iv.get(i4).getType() == 17)) {
                            i3++;
                            MemeInfo memeInfo = Iv.get(i4).IH().memeInfo;
                            if (memeInfo == null || TextUtils.isEmpty(memeInfo.pic_url)) {
                                return null;
                            }
                            if (memeInfo.pic_url.equals(str)) {
                                if (memeInfo.width.intValue() >= 80 && memeInfo.height.intValue() >= 80) {
                                    if (memeInfo.height.intValue() * memeInfo.width.intValue() >= 10000) {
                                        this.eIz = i4;
                                        return aDg;
                                    }
                                }
                                return null;
                            } else if (i3 > i) {
                                break;
                            }
                        }
                        i4++;
                        i3 = i3;
                    }
                }
                continue;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void f(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.eGM = str;
            if (this.eHm == null) {
                aQe();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eHm.cj(1).setVisibility(8);
            } else {
                this.eHm.cj(1).setVisibility(0);
            }
            this.eHm.tr();
            this.eHt = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cpd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xb() {
        hideNetRefreshView(this.eHE.getView());
        aQw();
        if (this.eGP.Fu()) {
            this.eHE.aSX();
        }
    }

    private void aQw() {
        showLoadingView(this.eHE.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds400));
        View EO = getLoadingView().EO();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EO.getLayoutParams();
        layoutParams.addRule(3, this.eHE.aTs().getId());
        EO.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahc() {
        if (this.cpd != null) {
            this.cpd.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void pj(int i) {
        boolean z;
        String str;
        Uri parse;
        if (this.eGP.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eGP.getPbData();
            pbData.aOV().getName();
            String title = pbData.aOX().getTitle();
            int i2 = this.eGP.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aOV() != null) {
                if ((pbData.aOV().isLike() == 1) && AddExperiencedModel.pE(pbData.getForumId())) {
                    z = true;
                    String str2 = "http://tieba.baidu.com/p/" + this.eGP.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bM = pbData.bM(getPageContext().getPageActivity());
                    str = bM[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    String str3 = bM[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aQh() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ad("fid", pbData.getForumId()).ad("tid", pbData.getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                    } else if (aQh() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ad("fid", pbData.getForumId()).ad("tid", pbData.getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                    }
                    String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, str3);
                    final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
                    dVar.title = title;
                    dVar.content = format;
                    dVar.linkUrl = str2;
                    dVar.aut = true;
                    dVar.aux = z;
                    dVar.extData = this.eGP.getThreadID();
                    dVar.auI = 3;
                    dVar.auH = i;
                    dVar.fid = this.eGP.getForumId();
                    dVar.Xe = this.eGP.getThreadID();
                    dVar.auJ = c(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.auC = parse;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.auI);
                    bundle.putInt("obj_type", dVar.auJ);
                    bundle.putString("fid", dVar.fid);
                    bundle.putString("tid", dVar.Xe);
                    bundle.putString(SapiAccountManager.SESSION_UID, dVar.uid);
                    dVar.e(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setIsCopyLink(true);
                    shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 23007)));
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10125").ad("tid", PbActivity.this.eGP.getThreadID()).ad("fid", PbActivity.this.eGP.getForumId()).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                            PbActivity.this.xi();
                        }
                    });
                    shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            dVar.linkUrl = PbActivity.this.pk(dVar.linkUrl);
                            com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                            com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                            PbActivity.this.xi();
                        }
                    });
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
                }
            }
            z = false;
            String str22 = "http://tieba.baidu.com/p/" + this.eGP.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bM2 = pbData.bM(getPageContext().getPageActivity());
            str = bM2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            String str32 = bM2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aQh() != 1) {
            }
            String format2 = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, str32);
            final com.baidu.tbadk.coreExtra.d.d dVar2 = new com.baidu.tbadk.coreExtra.d.d();
            dVar2.title = title;
            dVar2.content = format2;
            dVar2.linkUrl = str22;
            dVar2.aut = true;
            dVar2.aux = z;
            dVar2.extData = this.eGP.getThreadID();
            dVar2.auI = 3;
            dVar2.auH = i;
            dVar2.fid = this.eGP.getForumId();
            dVar2.Xe = this.eGP.getThreadID();
            dVar2.auJ = c(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.auI);
            bundle2.putInt("obj_type", dVar2.auJ);
            bundle2.putString("fid", dVar2.fid);
            bundle2.putString("tid", dVar2.Xe);
            bundle2.putString(SapiAccountManager.SESSION_UID, dVar2.uid);
            dVar2.e(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setIsCopyLink(true);
            shareDialogConfig2.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 23007)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10125").ad("tid", PbActivity.this.eGP.getThreadID()).ad("fid", PbActivity.this.eGP.getForumId()).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                    PbActivity.this.xi();
                }
            });
            shareDialogConfig2.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar2.linkUrl = PbActivity.this.pk(dVar2.linkUrl);
                    com.baidu.adp.lib.util.a.aw(dVar2.linkUrl);
                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                    PbActivity.this.xi();
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aOX() != null) {
            if (fVar.aOX().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aOX().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void aQx() {
        com.baidu.tbadk.util.u.a(new com.baidu.tbadk.util.t<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pF(PbActivity.this.eGP.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eHE.aTD();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.aok == null) {
                this.aok = new ShareReportModel(getPageContext());
            }
            this.aok.l(shareItem.fid, shareItem.Xe, shareItem.auz);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Je() {
        if (this.aRi == null) {
            this.aRi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQQ */
                public LinearLayout fJ() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
                    linearLayout.setId(d.h.pb_text_voice_layout);
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
                /* renamed from: a */
                public void n(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public LinearLayout o(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout p(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.aRi;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eHE.aSR() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ad("fid", this.eGP.getPbData().getForumId()));
            } else {
                bj aOX = this.eGP.getPbData().aOX();
                if (view != null) {
                    boolean z = aOX.rr() == null || aOX.rr().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eIl > 1000) {
                            this.eIm = true;
                            bk(view);
                        } else {
                            this.eIm = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            k(view, this.eIm);
                        } else {
                            j(view, this.eIm);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        j(view, this.eIm);
                    } else if (motionEvent.getAction() == 3) {
                        j(view, this.eIm);
                    }
                }
            }
        }
        return false;
    }

    private void j(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eIl = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eIl = System.currentTimeMillis();
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

    public void ahd() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11017)));
        } else if (aVar.tq() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tq();
            int intValue = ((Integer) sparseArray.get(an.eQp)).intValue();
            if (intValue == an.eQq) {
                if (!this.eHD.bta()) {
                    this.eHE.aSU();
                    int intValue2 = ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue();
                    this.eHD.a(this.eGP.getPbData().aOV().getId(), this.eGP.getPbData().aOV().getName(), this.eGP.getPbData().aOX().getId(), (String) sparseArray.get(d.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.eQr || intValue == an.eQt) {
                if (this.eGP.aRQ() != null) {
                    this.eGP.aRQ().pn(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.eQr) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == an.eQs) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eIF).pi()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(d.h.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
        }
        if (sparseArray.get(d.h.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(d.h.tag_user_mute_thread_id);
        }
        if (sparseArray.get(d.h.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(d.h.tag_user_mute_post_id);
        }
        if (sparseArray.get(d.h.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(d.h.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eHU);
        userMuteAddAndDelCustomMessage.setTag(this.eHU);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pi(String str) {
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
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(d.l.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void jc(boolean z) {
        this.eHL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQy() {
        ArrayList<PostData> aOZ;
        int u;
        if (this.eGP == null || this.eGP.getPbData() == null || this.eGP.getPbData().aOZ() == null || (u = com.baidu.tbadk.core.util.v.u((aOZ = this.eGP.getPbData().aOZ()))) == 0) {
            return "";
        }
        if (this.eGP.aRE()) {
            Iterator<PostData> it = aOZ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bso() == 1) {
                    return next.getId();
                }
            }
        }
        int aTb = this.eHE.aTb();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aOZ, aTb);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eGP.pn(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aTb - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aOZ, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eGP.pn(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aTb + 1; i2 < u; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aOZ, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eGP.pn(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (au.wd().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(ph(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eGP.getPbData().aOV().getId(), this.eGP.getPbData().aOV().getName(), this.eGP.getPbData().aOX().getTid());
            }
            this.eHt = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cM(getResources().getString(d.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cM(getResources().getString(d.l.make_sure_hide));
        }
        aVar.a(getResources().getString(d.l.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eGP.aRP() != null) {
                    PbActivity.this.eGP.aRP().cp(j);
                }
            }
        });
        aVar.b(getResources().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.as(false);
        aVar.b(getPageContext());
        aVar.to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b pj(String str) {
        String str2;
        if (this.eGP.getPbData() == null || this.eGP.getPbData().aOZ() == null || this.eGP.getPbData().aOZ().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i >= this.eGP.getPbData().aOZ().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eGP.getPbData().aOZ().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eGP.getPbData().aOZ().get(i);
        if (postData.aDg() == null || postData.aDg().Iv() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aDg().Iv().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.IB() != null) {
                    str2 = next.IB().IQ();
                }
            }
        }
        str2 = null;
        a(str2, 0, bVar);
        com.baidu.tieba.pb.data.g.a(postData, bVar);
        return bVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eHi) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eHi = false;
        } else if (aQz()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eHi) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eHi = false;
        } else if (aQz()) {
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
        if (pageStayDurationItem != null && this.eGP != null) {
            if (this.eGP.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eGP.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eGP.getThreadID(), 0L));
            if (this.eHu) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aQz() {
        return (!this.eHg && this.eIH == -1 && this.eII == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eIK = nVar;
            this.eHg = true;
            this.eHE.aSK();
            this.eHE.pr(this.eIJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQA() {
        if (this.eIK != null) {
            if (this.eIH == -1) {
                showToast(d.l.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eIK.getCartoonId(), this.eIH, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQB() {
        if (this.eIK != null) {
            if (this.eII == -1) {
                showToast(d.l.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eIK.getCartoonId(), this.eII, 0)));
                finish();
            }
        }
    }

    public int aQC() {
        return this.eIH;
    }

    public int aQD() {
        return this.eII;
    }

    private void arU() {
        if (this.eGP != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null && this.eGP.getPbData().aOX().so()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aQE() {
        if (this.eGP != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null && this.eGP.getPbData().aOX().so()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aQF() {
        if (this.eHj) {
            this.eHA = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null && this.eGP.getPbData().aOX().ri() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eGP.getPbData().aOX().ri().getThreadId(), this.eGP.getPbData().aOX().ri().getTaskId(), this.eGP.getPbData().aOX().ri().getForumId(), this.eGP.getPbData().aOX().ri().getForumName(), this.eGP.getPbData().aOX().rw(), this.eGP.getPbData().aOX().rx())));
            this.eHi = true;
            finish();
        }
    }

    public boolean aQG() {
        return this.eHj;
    }

    public String aQH() {
        return this.eHy;
    }

    public PbInterviewStatusView.a aQI() {
        return this.eHC;
    }

    public void jd(boolean z) {
        this.eHz = z;
    }

    public boolean aQJ() {
        if (this.eGP != null) {
            return this.eGP.aRt();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cM(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eHS).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eHS.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eHS).to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eHS != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHS.getPageActivity());
            aVar.cM(str);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eHS).to();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eHE.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eHS.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cM(this.eHS.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cM(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eHE.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eHS).to();
    }

    public void aQL() {
        if (this.eGP != null && this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null && this.eGP.getPbData().aOX().sF() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cc(d.l.channel_open_push_message);
            aVar.a(d.l.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eGP.getPbData().aOX().sF().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.l.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.to();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ar.pt(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_pb_wenxue)) != null) {
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
            this.csX = true;
        } else {
            this.csX = false;
        }
        if (this.eHE != null) {
            this.eHE.onConfigurationChanged(configuration);
        }
        if (this.eHJ != null) {
            this.eHJ.dismiss();
        }
    }

    public boolean aQM() {
        if (this.eGP != null) {
            return this.eGP.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.eGP.getPbData().aPh().eFe;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bsl().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bsl().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bsl().remove(i2);
                    list.get(i).bsn();
                    z = true;
                    break;
                }
            }
            list.get(i).sd(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.m(this.eGP.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aPF().getId();
        List<PostData> list = this.eGP.getPbData().aPh().eFe;
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
                ArrayList<PostData> aPJ = mVar.aPJ();
                postData.tt(mVar.getTotalCount());
                if (postData.bsl() != null) {
                    postData.bsl().clear();
                    postData.bsl().addAll(aPJ);
                }
            }
        }
        this.eHE.m(this.eGP.getPbData());
    }

    public boolean aQN() {
        boolean z = true;
        if (this.eGP == null) {
            return false;
        }
        switch (this.eGP.aRY()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eGP.getPbData() != null && this.eGP.getPbData().aOX() != null && this.eGP.getPbData().aOX().sN() && StringUtils.isNull(this.eGP.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aQO() {
        if (this.eHE != null) {
            this.eHE.aSC();
            ahd();
        }
    }

    public PostData aPe() {
        return this.eHE.b(this.eGP.eLs, this.eGP.aRs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ab(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.isLinkThread()) {
                return 3;
            }
            if (bjVar.sH()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    private String ak(String str, String str2) {
        if (com.baidu.tbadk.core.util.am.isEmpty(Uri.parse(str).getQuery())) {
            str = str + "?";
        }
        return str + "&" + str2;
    }

    public String pk(String str) {
        String aS;
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String ak = ak(ak(ak(str, "sfc=copy"), "client_type=2"), "client_version=" + TbConfig.getVersion());
        if (this.eGP == null || this.eGP.getThreadID() == null) {
            return ak;
        }
        if (com.baidu.adp.lib.b.d.eW().af("android_url_need_cuid") == 1) {
            aS = com.baidu.adp.lib.util.r.aS(this.eGP.getThreadID() + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
        } else {
            aS = com.baidu.adp.lib.util.r.aS(this.eGP.getThreadID() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
        }
        return ak(ak, "unique=" + aS);
    }
}
