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
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
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
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.pb.main.v;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
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
    private com.baidu.adp.lib.e.b<ImageView> aRQ;
    private com.baidu.adp.lib.e.b<TextView> aRR;
    private com.baidu.adp.lib.e.b<View> aRS;
    private com.baidu.adp.lib.e.b<LinearLayout> aRT;
    private com.baidu.adp.lib.e.b<RelativeLayout> aRU;
    private com.baidu.adp.lib.e.b<GifView> aRV;
    private ShareReportModel anm;
    private com.baidu.adp.lib.e.b<TbImageView> aoc;
    private VoiceManager cqg;
    private com.baidu.tbadk.h.a cqz;
    private com.baidu.tieba.e.b ctr;
    private String eAQ;
    private View eBA;
    private u eBJ;
    private boolean eBL;
    private com.baidu.tieba.tbadkCore.data.e eBO;
    private com.baidu.tbadk.editortools.pb.d eBP;
    private com.baidu.tbadk.editortools.pb.c eBQ;
    private com.baidu.adp.base.e eBT;
    private com.baidu.tbadk.core.view.c eBU;
    private BdUniqueId eBV;
    private Runnable eBW;
    private aq eBX;
    private com.baidu.adp.widget.ImageView.a eBY;
    private String eBZ;
    private com.baidu.tieba.pb.pb.main.a.b eBh;
    private com.baidu.tbadk.core.dialog.a eBn;
    private boolean eBt;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eBz;
    private boolean eCA;
    private String eCM;
    private com.baidu.tbadk.core.data.n eCN;
    private TbRichTextMemeInfo eCa;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eBg = false;
    private boolean eBi = false;
    private boolean eBj = false;
    private boolean eir = false;
    private boolean eBk = true;
    private int eBl = 0;
    private com.baidu.tbadk.core.dialog.b eBm = null;
    private long ccS = -1;
    private long aIZ = 0;
    private long eBo = 0;
    private long createTime = 0;
    private long aIR = 0;
    private boolean eBp = false;
    private com.baidu.tbadk.k.d eBq = null;
    private long eBr = 0;
    private boolean eBs = false;
    private long eBu = 0;
    private String aCs = null;
    private boolean eBv = false;
    private boolean cui = false;
    private String eBw = "";
    private boolean eBx = true;
    private boolean eBy = false;
    private String source = "";
    private PbInterviewStatusView.a eBB = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eBE.js(!PbActivity.this.eBx);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eBC != null && PbActivity.this.eBC.nz()) {
                        PbActivity.this.aOu();
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.aha));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.aha));
        }
    };
    private PbModel eBC = null;
    private com.baidu.tbadk.baseEditMark.a efH = null;
    private ForumManageModel eBD = null;
    private com.baidu.tbadk.coreExtra.c.a aoD = null;
    private an eBE = null;
    public final com.baidu.tieba.pb.pb.main.a.a eBF = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eBG = false;
    private boolean eBH = false;
    private boolean eBI = false;
    private boolean eBK = false;
    private boolean eBM = false;
    private boolean eBN = false;
    private boolean eBR = false;
    private com.baidu.tbadk.editortools.pb.b aCw = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public void CQ() {
            PbActivity.this.showProgressBar();
        }
    };
    private boolean eBS = false;
    private int mLastScrollState = -1;
    private boolean cqL = false;
    private int eCb = 0;
    private int eCc = -1;
    private final v.a eCd = new v.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tieba.pb.pb.main.v.a
        public void A(List<PostData> list) {
            if (PbActivity.this.eBC.getPbData().aNg() != null) {
                List<PostData> list2 = PbActivity.this.eBC.getPbData().aNg().ezg;
                int size = list2.size();
                if (!com.baidu.tbadk.core.util.v.u(list2)) {
                    PbActivity.this.eBC.getPbData().aNg().ezg.addAll(size, list);
                }
                PbActivity.this.eBC.a(PbActivity.this.eBC.getPbData(), size);
            }
            PbActivity.this.eBE.aRe().a(PbActivity.this.eBC.getPbData(), true);
            if (PbActivity.this.eBE != null && PbActivity.this.eBE.aRe() != null) {
                PbActivity.this.eBE.aRe().notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.v.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eBE.showToast(str);
            }
        }
    };
    private final CustomMessageListener eCe = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eBC != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eBQ != null) {
                    PbActivity.this.eBE.hf(PbActivity.this.eBQ.CZ());
                }
                PbActivity.this.eBE.aQP();
                PbActivity.this.eBE.aCv();
            }
        }
    };
    CustomMessageListener cra = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                PbActivity.this.eBC.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                if (PbActivity.this.eBE != null && PbActivity.this.eBC != null) {
                    PbActivity.this.eBE.d(PbActivity.this.eBC.getPbData(), PbActivity.this.eBC.aPs(), PbActivity.this.eBC.aPJ());
                }
                if (PbActivity.this.eBE != null && PbActivity.this.eBE.aRe() != null) {
                    PbActivity.this.eBE.aRe().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eCf = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eBE != null) {
                    if (booleanValue) {
                        PbActivity.this.eBE.awW();
                    } else {
                        PbActivity.this.eBE.awV();
                    }
                }
            }
        }
    };
    private CustomMessageListener dOm = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eBQ != null) {
                    PbActivity.this.eBE.hf(PbActivity.this.eBQ.CZ());
                }
                PbActivity.this.eBE.hg(false);
            }
        }
    };
    private CustomMessageListener dOI = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
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
    private CustomMessageListener eCg = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eBE != null && PbActivity.this.eBE.aRe() != null) {
                PbActivity.this.eBE.aRe().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dnQ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a eCh = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void j(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.pc(2);
                ae.aQz().reset();
                PbActivity.this.eBC.aPK();
                boolean z2 = false;
                ArrayList<PostData> aMY = PbActivity.this.eBC.getPbData().aMY();
                if (aMY != null) {
                    Iterator<PostData> it = aMY.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (am.l(next) && next.bry().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eBE.n(PbActivity.this.eBC.getPbData());
                    }
                    PbActivity.this.showToast(d.l.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(d.l.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(d.l.operation_failed);
        }
    };
    private View.OnClickListener dOl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aCs);
        }
    };
    CustomMessageListener cYg = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eCi = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                aq.a aVar = new aq.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.Wm = abVar.Wm;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBC.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eBC.aPA() != null && PbActivity.this.eBC.aPA().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eBE.a(abVar.sendCount, PbActivity.this.eBC.getPbData(), PbActivity.this.eBC.aPs(), PbActivity.this.eBC.aPJ());
                    }
                    if (pbData.aMY() != null && pbData.aMY().size() >= 1 && pbData.aMY().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aMY().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eBC.getThreadID(), 0L);
                        if (c2 == abVar.postId && c3 == abVar.threadId) {
                            com.baidu.tbadk.core.data.aq brx = pbData.aMY().get(0).brx();
                            if (brx == null) {
                                brx = new com.baidu.tbadk.core.data.aq();
                            }
                            ArrayList<aq.a> qp = brx.qp();
                            if (qp == null) {
                                qp = new ArrayList<>();
                            }
                            qp.add(0, aVar);
                            brx.bN(abVar.sendCount + brx.qo());
                            brx.g(qp);
                            pbData.aMY().get(0).a(brx);
                            PbActivity.this.eBE.aRe().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eCj = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.adz() != null && !aVar.adz().isEmpty()) {
                    PbActivity.this.eBE.a(aVar, PbActivity.this.eCl);
                }
                PbActivity.this.eBE.a(aVar, PbActivity.this.eBC.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.aSd()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a eCk = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void A(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.u(list) && PbActivity.this.eBE != null) {
                PbActivity.this.eBE.cv(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eCl = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aT(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.fJ().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
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
    private boolean eCm = false;
    private PraiseModel eCn = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hK(String str) {
            PbActivity.this.eCm = false;
            if (PbActivity.this.eCn != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBC.getPbData();
                if (pbData.aMW().re().getIsLike() == 1) {
                    PbActivity.this.jy(0);
                } else {
                    PbActivity.this.jy(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aMW()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void A(int i, String str) {
            PbActivity.this.eCm = false;
            if (PbActivity.this.eCn != null && str != null) {
                if (AntiHelper.tF(i)) {
                    AntiHelper.ao(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eCo = 0;
    private boolean eCp = true;
    private b.a eCq = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void iP(boolean z) {
            PbActivity.this.iO(z);
            if (PbActivity.this.eBE.aRH() != null && z) {
                PbActivity.this.eBE.js(false);
            }
            PbActivity.this.eBE.jv(z);
        }
    };
    private CustomMessageListener aoH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().ars != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().ars, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.aha));
                        }
                    } else if (updateAttentionMessage.getData().BZ) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aNd().getAuthor() != null && PbActivity.this.aNd().getAuthor().getGodUserData() != null) {
                            PbActivity.this.aNd().getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBC.getPbData().aMW() != null && PbActivity.this.eBC.getPbData().aMW().getAuthor() != null) {
                            PbActivity.this.eBC.getPbData().aMW().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a brE = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eBE.Sr();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.pd(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.aom();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.l.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aSk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eBE.aQQ()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && ((PbActivity.this.eBC == null || PbActivity.this.eBC.getPbData() == null || !com.baidu.tieba.pb.f.T(PbActivity.this.eBC.getPbData().aMW())) && PbActivity.this.eBC != null && (PbActivity.this.eBC.getPbData() != null || PbActivity.this.eBC.getPbData().aNs() != null))) {
                    if (PbActivity.this.eBC.getPbData().aNs().aNA()) {
                        if (PbActivity.this.eBC.getPbData().aNs().eyR == 1 || PbActivity.this.eBC.getPbData().aNs().eyR == 3 || PbActivity.this.eBC.getPbData().aNs().eyR == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eBC.getPbData().aNs().aNA() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eBC.getPbData().aNs().aNA() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eBu > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).jX(false);
                        PbActivity.this.eBu = System.currentTimeMillis();
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
                    if (PbActivity.this.bd(view)) {
                        return true;
                    }
                } else if (view.getId() == d.h.pb_floor_item_layout) {
                    if (view.getTag(d.h.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.h.pb_post_header_layout) {
                    if (PbActivity.this.eBE != null && PbActivity.this.eBE.aOe() && (view.getId() == d.h.pb_head_user_info_root || view == PbActivity.this.eBE.aRO())) {
                        if (view.getTag(d.h.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ac("obj_id", (String) view.getTag(d.h.tag_user_id)));
                        }
                        if (PbActivity.this.eBF != null && PbActivity.this.eBF.eOP != null) {
                            PbActivity.this.eBF.eOP.onClick(view);
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
            if (PbActivity.this.eBQ != null) {
                PbActivity.this.eBE.hf(PbActivity.this.eBQ.CZ());
            }
            PbActivity.this.eBE.aQP();
            PbActivity.this.eBE.aCv();
            return true;
        }
    });
    private CustomMessageListener eCr = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eBV) {
                PbActivity.this.eBE.Sr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBC.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aNj().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eBU.c(PbActivity.this.eBT.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eBT.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    PbActivity.this.fS(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aOL();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eBT.getResources().getString(d.l.mute_fail);
                    }
                    PbActivity.this.eBU.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eCs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eBV) {
                PbActivity.this.eBE.Sr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eBU.c(PbActivity.this.eBT.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eBT.getResources().getString(d.l.un_mute_fail);
                }
                PbActivity.this.eBU.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eCt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eBV) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eBE.Sr();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gtz;
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
                    PbActivity.this.eBE.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eCu = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eBE.aQQ() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aOd() != null && PbActivity.this.aOd().getPbData() != null && PbActivity.this.aOd().getPbData().aNs() != null && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.T(PbActivity.this.aOd().getPbData().aMW())) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aNA = PbActivity.this.aOd().getPbData().aNs().aNA();
                if (intValue < 10) {
                    if (aNA) {
                        if (PbActivity.this.eBC.getPbData().aNs().eyR == 1 || PbActivity.this.eBC.getPbData().aNs().eyR == 3 || PbActivity.this.eBC.getPbData().aNs().eyR == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eBC.getPbData().aNs().aNA() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aNA ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eBu > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).jX(false);
                        PbActivity.this.eBu = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue / 11, aNA);
                TiebaStatic.log(PbActivity.this.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aNA ? 0 : 1));
            }
        }
    };
    private CustomMessageListener crl = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cqL = true;
                }
            }
        }
    };
    public a.b eqI = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.ahd();
            com.baidu.tbadk.core.data.ap arn = PbActivity.this.eBC.arn();
            int pageNum = PbActivity.this.eBE.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.l.pb_page_error);
            } else if (arn == null || pageNum <= arn.qh()) {
                PbActivity.this.eBE.aCv();
                PbActivity.this.pc(2);
                PbActivity.this.ahc();
                PbActivity.this.eBE.aRj();
                if (com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.eBC.pj(PbActivity.this.eBE.getPageNum());
                    if (PbActivity.this.eBh != null) {
                        PbActivity.this.eBh.showFloatingView();
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
    public final View.OnClickListener crI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Multi-variable search result rejected for r4v172, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v176, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v217, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v39, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:677:0x1ee5  */
        /* JADX WARN: Removed duplicated region for block: B:704:0x20db  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String name;
            com.baidu.tieba.pb.data.l aNs;
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
                    if ((PbActivity.this.eBE.eIN.aSI() != null && PbActivity.this.eBE.eIN.aSI().bj(view)) || PbActivity.this.eBE.aRd() == view || view.getId() == d.h.pb_item_tail_content) {
                        if (PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && com.baidu.tieba.pb.f.T(PbActivity.this.eBC.getPbData().aMW())) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (view == PbActivity.this.eBE.getNextView()) {
                        if (!PbActivity.this.mIsLoading && PbActivity.this.eBC.iX(true)) {
                            PbActivity.this.mIsLoading = true;
                            PbActivity.this.eBE.aRk();
                        }
                    } else if (PbActivity.this.eBE.eIN.aSI() == null || view != PbActivity.this.eBE.eIN.aSI().aQs()) {
                        if (view == PbActivity.this.eBE.eIN.aKU) {
                            if (PbActivity.this.eBE.jx(PbActivity.this.eBC.aPx())) {
                                PbActivity.this.ahc();
                                return;
                            }
                            PbActivity.this.eBk = false;
                            PbActivity.this.eBi = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eBE.aRh() && (PbActivity.this.eBE.eIN.aSI() == null || (view != PbActivity.this.eBE.eIN.aSI().aQr() && view != PbActivity.this.eBE.eIN.aSI().aQp()))) {
                            if (view == PbActivity.this.eBE.aRz()) {
                                if (PbActivity.this.eBC != null) {
                                    com.baidu.tbadk.browser.a.O(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBC.getPbData().aMW().rn().getLink());
                                }
                            } else if (view != PbActivity.this.eBE.eIN.ePz && view.getId() != d.h.view_forum_name_first_floor) {
                                if (view == PbActivity.this.eBE.eIN.ePA) {
                                    if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null) {
                                        ArrayList<PostData> aMY = PbActivity.this.eBC.getPbData().aMY();
                                        if ((aMY == null || aMY.size() <= 0) && PbActivity.this.eBC.aPs()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ac("tid", PbActivity.this.eBC.getThreadID()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("fid", PbActivity.this.eBC.getForumId()));
                                        if (!PbActivity.this.eBE.aRP()) {
                                            PbActivity.this.eBE.aQP();
                                        }
                                        PbActivity.this.aOl();
                                        return;
                                    }
                                    com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                } else if (view.getId() != d.h.pb_god_user_tip_content) {
                                    if (PbActivity.this.eBE.eIN.aSI() == null || view != PbActivity.this.eBE.eIN.aSI().aQc()) {
                                        if ((PbActivity.this.eBE.eIN.aSI() == null || view != PbActivity.this.eBE.eIN.aSI().aQo()) && view.getId() != d.h.floor_owner_reply && view.getId() != d.h.reply_title) {
                                            if (PbActivity.this.eBE.eIN.aSI() == null || (view != PbActivity.this.eBE.eIN.aSI().getCancelView() && view != PbActivity.this.eBE.eIN.aSI().aQn())) {
                                                if (view != PbActivity.this.eBE.eIN.ePB && (PbActivity.this.eBE.eIN.aSI() == null || view != PbActivity.this.eBE.eIN.aSI().aQy())) {
                                                    if (PbActivity.this.eBE.eIN.aSI() != null && view == PbActivity.this.eBE.eIN.aSI().aQk()) {
                                                        PbActivity.this.eBE.aCv();
                                                        if (PbActivity.this.eBC.arn() != null) {
                                                            PbActivity.this.eBE.a(PbActivity.this.eBC.arn(), PbActivity.this.eqI);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        return;
                                                    } else if (view.getId() == d.h.pb_sort) {
                                                        PbActivity.this.eBE.aCv();
                                                        if (com.baidu.adp.lib.util.j.hh()) {
                                                            if (PbActivity.this.mIsLoading) {
                                                                view.setTag(Boolean.valueOf(PbActivity.this.eBC.aPE()));
                                                                return;
                                                            }
                                                            PbActivity.this.pc(2);
                                                            PbActivity.this.ahc();
                                                            PbActivity.this.eBE.aRj();
                                                            PbActivity.this.eBE.aRe().iQ(true);
                                                            boolean aPD = PbActivity.this.eBC.aPD();
                                                            view.setTag(Boolean.valueOf(PbActivity.this.eBC.aPE()));
                                                            TiebaStatic.log("c12097");
                                                            if (aPD) {
                                                                PbActivity.this.mIsLoading = true;
                                                                PbActivity.this.eBE.jp(true);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                        return;
                                                    } else if (PbActivity.this.eBE.eIN.aSI() == null || view != PbActivity.this.eBE.eIN.aSI().aQl()) {
                                                        if (PbActivity.this.eBE.eIN.aSI() == null || view != PbActivity.this.eBE.eIN.aSI().aQm()) {
                                                            if (PbActivity.this.eBJ == null || view != PbActivity.this.eBJ.aQe()) {
                                                                if (PbActivity.this.eBJ == null || view != PbActivity.this.eBJ.aQc()) {
                                                                    if (PbActivity.this.eBJ == null || view != PbActivity.this.eBJ.aQh()) {
                                                                        if (PbActivity.this.eBJ == null || view != PbActivity.this.eBJ.aQf()) {
                                                                            if (PbActivity.this.eBJ == null || view != PbActivity.this.eBJ.aQg()) {
                                                                                if (PbActivity.this.eBE.aRH() == view) {
                                                                                    if (PbActivity.this.eBE.aRH().getIndicateStatus()) {
                                                                                        com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBC.getPbData();
                                                                                        if (pbData != null && pbData.aMW() != null && pbData.aMW().qV() != null) {
                                                                                            String pw = pbData.aMW().qV().pw();
                                                                                            if (StringUtils.isNull(pw)) {
                                                                                                pw = pbData.aMW().qV().getTaskId();
                                                                                            }
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ac("obj_id", pw));
                                                                                        }
                                                                                    } else {
                                                                                        com.baidu.tieba.tbadkCore.d.a.cc("c10725", null);
                                                                                    }
                                                                                    PbActivity.this.aOG();
                                                                                    return;
                                                                                } else if (PbActivity.this.eBE.aRd() != view) {
                                                                                    if (PbActivity.this.eBJ == null || view != PbActivity.this.eBJ.aQd()) {
                                                                                        if (PbActivity.this.eBE.eIN.aSI() == null || view != PbActivity.this.eBE.eIN.aSI().aQt()) {
                                                                                            if (PbActivity.this.eBE.eIN.aSI() != null && view == PbActivity.this.eBE.eIN.aSI().aQq()) {
                                                                                                if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                    SparseArray<Object> c2 = PbActivity.this.eBE.c(PbActivity.this.eBC.getPbData(), PbActivity.this.eBC.aPs(), 1);
                                                                                                    if (c2 != null) {
                                                                                                        PbActivity.this.eBE.a(((Integer) c2.get(d.h.tag_del_post_type)).intValue(), (String) c2.get(d.h.tag_del_post_id), ((Integer) c2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.h.tag_del_post_is_self)).booleanValue());
                                                                                                    }
                                                                                                    PbActivity.this.eBE.eIN.of();
                                                                                                    return;
                                                                                                }
                                                                                                PbActivity.this.showToast(d.l.network_not_available);
                                                                                                return;
                                                                                            } else if (view.getId() != d.h.sub_pb_more && view.getId() != d.h.sub_pb_item && view.getId() != d.h.pb_floor_reply_more) {
                                                                                                if (view != PbActivity.this.eBE.aNW()) {
                                                                                                    if (view == PbActivity.this.eBE.eIN.aSJ()) {
                                                                                                        PbActivity.this.eBE.aRr();
                                                                                                        return;
                                                                                                    }
                                                                                                    int id = view.getId();
                                                                                                    if (id == d.h.pb_u9_text_view) {
                                                                                                        if (PbActivity.this.checkUpIsLogin() && (blVar = (bl) view.getTag()) != null && !StringUtils.isNull(blVar.sQ())) {
                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                            av.vA().c(PbActivity.this.getPageContext(), new String[]{blVar.sQ()});
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if ((id == d.h.pb_floor_agree || id == d.h.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                        PostData be = PbActivity.this.be(view);
                                                                                                        if (be != null) {
                                                                                                            TiebaStatic.log(PbActivity.this.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", be.brD() ? 0 : 1));
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.view_main_thread_praise_state) {
                                                                                                        PbActivity.this.f(view, 2, false);
                                                                                                        if (PbActivity.this.aOd() != null && PbActivity.this.aOd().getPbData() != null && PbActivity.this.aOd().getPbData().aNs() != null && PbActivity.this.aOd().getPbData().aNs() != null) {
                                                                                                            TiebaStatic.log(PbActivity.this.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aOd().getPbData().aNs().aNA() ? 0 : 1));
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.view_main_thread_praise_num || id == d.h.view_main_thread_praise_name_list) {
                                                                                                        if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && !StringUtils.isNull(PbActivity.this.eBC.getPbData().getThreadId()) && (aNs = PbActivity.this.eBC.getPbData().aNs()) != null && aNs.getPraiseNum() > 0) {
                                                                                                            av.vA().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eBC.getPbData().getThreadId()});
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.replybtn || id == d.h.cover_reply_content || id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right || id == d.h.image_more_tip) {
                                                                                                        if (PbActivity.this.checkUpIsLogin()) {
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                            PostData postData2 = null;
                                                                                                            if (view != null && view.getTag() != null) {
                                                                                                                postData2 = (PostData) ((SparseArray) view.getTag()).get(d.h.tag_load_sub_data);
                                                                                                                if (postData2 == null || !com.baidu.tieba.pb.f.c(postData2)) {
                                                                                                                    if (PbActivity.this.eBJ == null) {
                                                                                                                        PbActivity.this.eBJ = new u(PbActivity.this.getPageContext(), PbActivity.this.crI);
                                                                                                                        PbActivity.this.eBJ.jb(PbActivity.this.mIsLogin);
                                                                                                                    }
                                                                                                                    PbActivity.this.eBJ.showDialog();
                                                                                                                    boolean z6 = id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right;
                                                                                                                    if (z6) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ac("tid", PbActivity.this.eBC.eFj));
                                                                                                                    }
                                                                                                                    SparseArray sparseArray2 = new SparseArray();
                                                                                                                    sparseArray2.put(d.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.h.tag_clip_board));
                                                                                                                    sparseArray2.put(d.h.tag_is_subpb, false);
                                                                                                                    PbActivity.this.eBJ.aQc().setTag(sparseArray2);
                                                                                                                    PbActivity.this.eBJ.aQh().setTag(view.getTag());
                                                                                                                    PbActivity.this.eBJ.jd(z6);
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
                                                                                                                            PbActivity.this.eBJ.aQf().setVisibility(0);
                                                                                                                        } else {
                                                                                                                            sparseArray4.put(d.h.tag_should_delete_visible, false);
                                                                                                                            PbActivity.this.eBJ.aQf().setVisibility(8);
                                                                                                                        }
                                                                                                                        PbActivity.this.eBJ.aQd().setTag(sparseArray4);
                                                                                                                        PbActivity.this.eBJ.aQf().setTag(sparseArray4);
                                                                                                                        PbActivity.this.eBJ.aQd().setText(d.l.bar_manager);
                                                                                                                        PbActivity.this.eBJ.aQd().setVisibility(0);
                                                                                                                    } else if (!booleanValue3) {
                                                                                                                        PbActivity.this.eBJ.aQd().setVisibility(8);
                                                                                                                        PbActivity.this.eBJ.aQf().setVisibility(8);
                                                                                                                    } else {
                                                                                                                        SparseArray sparseArray5 = new SparseArray();
                                                                                                                        sparseArray5.put(d.h.tag_should_manage_visible, false);
                                                                                                                        sparseArray5.put(d.h.tag_user_mute_visible, false);
                                                                                                                        sparseArray5.put(d.h.tag_should_delete_visible, true);
                                                                                                                        sparseArray5.put(d.h.tag_manage_user_identity, sparseArray3.get(d.h.tag_manage_user_identity));
                                                                                                                        sparseArray5.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                        sparseArray5.put(d.h.tag_del_post_id, sparseArray3.get(d.h.tag_del_post_id));
                                                                                                                        sparseArray5.put(d.h.tag_del_post_type, sparseArray3.get(d.h.tag_del_post_type));
                                                                                                                        PbActivity.this.eBJ.aQd().setTag(sparseArray5);
                                                                                                                        PbActivity.this.eBJ.aQf().setTag(sparseArray5);
                                                                                                                        PbActivity.this.eBJ.aQd().setText(d.l.delete);
                                                                                                                        PbActivity.this.eBJ.aQf().setVisibility(0);
                                                                                                                        if (PbActivity.this.eBC.getPbData().aNh() != 1002 || z2) {
                                                                                                                            PbActivity.this.eBJ.aQf().setText(d.l.delete);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.eBJ.aQf().setText(d.l.report_text);
                                                                                                                        }
                                                                                                                        PbActivity.this.eBJ.aQd().setVisibility(8);
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
                                                                                                                        PbActivity.this.eBJ.aQe().setTag(sparseArray7);
                                                                                                                        PbActivity.this.eBJ.aQe().setVisibility(0);
                                                                                                                        PbActivity.this.eBJ.aQd().setVisibility(8);
                                                                                                                        PbActivity.this.eBJ.aQe().setText(d.l.mute_option);
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
                                                                                                                        boolean iK = PbActivity.this.iK(z4) & PbActivity.this.isLogin();
                                                                                                                        PbActivity.this.eCE = (PostData) sparseArray6.get(d.h.tag_clip_board);
                                                                                                                        if (am.l(PbActivity.this.eCE) ? false : iK) {
                                                                                                                            PbActivity.this.eBJ.aQe().setVisibility(0);
                                                                                                                            PbActivity.this.eBJ.aQe().setTag(str3);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.eBJ.aQe().setVisibility(8);
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
                                                                                                                        PbActivity.this.eBJ.aQg().setVisibility(0);
                                                                                                                        PbActivity.this.eBJ.aQg().setTag(d.h.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                        PbActivity.this.eBJ.aQg().setTag(d.h.tag_chudian_monitor_id, str);
                                                                                                                        PbActivity.this.eBJ.aQg().setTag(d.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                    } else {
                                                                                                                        PbActivity.this.eBJ.aQg().setVisibility(8);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                            if (PbActivity.this.eBC.getPbData().nz()) {
                                                                                                                String ny = PbActivity.this.eBC.getPbData().ny();
                                                                                                                if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(ny) && ny.equals(postData2.getId())) {
                                                                                                                    z = true;
                                                                                                                    if (!z) {
                                                                                                                        PbActivity.this.eBJ.aQc().setText(d.l.remove_mark);
                                                                                                                    } else {
                                                                                                                        PbActivity.this.eBJ.aQc().setText(d.l.mark);
                                                                                                                    }
                                                                                                                    PbActivity.this.eBJ.jc(true);
                                                                                                                    PbActivity.this.eBJ.refreshUI();
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                            z = false;
                                                                                                            if (!z) {
                                                                                                            }
                                                                                                            PbActivity.this.eBJ.jc(true);
                                                                                                            PbActivity.this.eBJ.refreshUI();
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.pb_act_btn) {
                                                                                                        if (PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBC.getPbData().aMW() != null && PbActivity.this.eBC.getPbData().aMW().rU() != null) {
                                                                                                            com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), PbActivity.this.eBC.getPbData().aMW().rU());
                                                                                                            if (PbActivity.this.eBC.getPbData().aMW().rS() != 1) {
                                                                                                                if (PbActivity.this.eBC.getPbData().aMW().rS() == 2) {
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
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ac("fid", PbActivity.this.eBC.getPbData().getForumId()).ac("tid", PbActivity.this.eBC.getPbData().getThreadId()).ac("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                            if (PbActivity.this.eBC.getPbData().getThreadId().equals(str4)) {
                                                                                                                PbActivity.this.eBE.setSelection(0);
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
                                                                                                            PbActivity.this.eBE.aQP();
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.join_vote_tv) {
                                                                                                        if (view != null) {
                                                                                                            com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                            if (PbActivity.this.aOi() == 1) {
                                                                                                                if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ac("fid", PbActivity.this.eBC.getPbData().getForumId()).ac("tid", PbActivity.this.eBC.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                    return;
                                                                                                                }
                                                                                                                return;
                                                                                                            } else if (PbActivity.this.aOi() == 2 && PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null) {
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ac("fid", PbActivity.this.eBC.getPbData().getForumId()).ac("tid", PbActivity.this.eBC.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                return;
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.look_all_tv) {
                                                                                                        if (view != null) {
                                                                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                            com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                            if (PbActivity.this.aOi() == 1) {
                                                                                                                if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ac("fid", PbActivity.this.eBC.getPbData().getForumId()).ac("tid", PbActivity.this.eBC.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                    return;
                                                                                                                }
                                                                                                                return;
                                                                                                            } else if (PbActivity.this.aOi() == 2 && PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null) {
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ac("fid", PbActivity.this.eBC.getPbData().getForumId()).ac("tid", PbActivity.this.eBC.getPbData().getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                return;
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.manga_prev_btn) {
                                                                                                        PbActivity.this.aOB();
                                                                                                        return;
                                                                                                    } else if (id == d.h.manga_next_btn) {
                                                                                                        PbActivity.this.aOC();
                                                                                                        return;
                                                                                                    } else if (id == d.h.yule_head_img_img) {
                                                                                                        if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBC.getPbData().aNo() != null) {
                                                                                                            com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eBC.getPbData();
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ac("fid", pbData2.getForumId()));
                                                                                                            av.vA().c(PbActivity.this.getPageContext(), new String[]{pbData2.aNo().aNw()});
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.yule_head_img_all_rank) {
                                                                                                        if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBC.getPbData().aNo() != null) {
                                                                                                            com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eBC.getPbData();
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac("fid", pbData3.getForumId()));
                                                                                                            av.vA().c(PbActivity.this.getPageContext(), new String[]{pbData3.aNo().aNw()});
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (PbActivity.this.eBE.eIN.aSI() != null && view == PbActivity.this.eBE.eIN.aSI().aQu()) {
                                                                                                        if (PbActivity.this.eBC == null || PbActivity.this.eBC.getPbData() == null || PbActivity.this.eBC.getPbData().aMW() == null) {
                                                                                                            PbActivity.this.eBE.eIN.of();
                                                                                                            return;
                                                                                                        } else if (!com.baidu.adp.lib.util.l.hy()) {
                                                                                                            PbActivity.this.showToast(d.l.neterror);
                                                                                                            return;
                                                                                                        } else {
                                                                                                            int i2 = 1;
                                                                                                            if (PbActivity.this.eBC.getPbData().aMW().qY() == 0) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBC.getThreadID(), 25028)));
                                                                                                            } else {
                                                                                                                BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.l.haved_fans_called)).tj();
                                                                                                                i2 = 2;
                                                                                                            }
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").r("obj_locate", PbActivity.this.W(PbActivity.this.eBC.getPbData().aMW())).ac("tid", PbActivity.this.eBC.getPbData().aMW().getTid()).r("obj_type", i2));
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (id == d.h.tv_pb_reply_more) {
                                                                                                        if (PbActivity.this.eCb >= 0) {
                                                                                                            if (PbActivity.this.eBC != null) {
                                                                                                                PbActivity.this.eBC.aPY();
                                                                                                            }
                                                                                                            if (PbActivity.this.eBE.aRe() != null) {
                                                                                                                PbActivity.this.eBE.aRe().a(PbActivity.this.eBC.getPbData(), false);
                                                                                                            }
                                                                                                            PbActivity.this.eBE.getListView().setSelection(PbActivity.this.eBC.aQb());
                                                                                                            PbActivity.this.eCb = 0;
                                                                                                            if (PbActivity.this.eBC != null) {
                                                                                                                PbActivity.this.eBC.bt(0, 0);
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.single_bar_tips) {
                                                                                                        PbActivity.this.eBE.aRS();
                                                                                                        return;
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eBC.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eBC.getThreadID(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eBC.getPbData().aMW().rI())));
                                                                                                    return;
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                if (PbActivity.this.eBC.getPbData() != null) {
                                                                                                    PbActivity.this.eBE.aCv();
                                                                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                    PostData postData3 = (PostData) sparseArray9.get(d.h.tag_load_sub_data);
                                                                                                    View view2 = (View) sparseArray9.get(d.h.tag_load_sub_view);
                                                                                                    if (postData3 != null && view2 != null) {
                                                                                                        String threadID = PbActivity.this.eBC.getThreadID();
                                                                                                        String id2 = postData3.getId();
                                                                                                        int i3 = 0;
                                                                                                        if (PbActivity.this.eBC.getPbData() != null) {
                                                                                                            i3 = PbActivity.this.eBC.getPbData().aNh();
                                                                                                        }
                                                                                                        if (!com.baidu.tieba.pb.f.c(postData3)) {
                                                                                                            PbActivity.this.ahc();
                                                                                                            if (view.getId() == d.h.replybtn) {
                                                                                                                b oO = PbActivity.this.oO(id2);
                                                                                                                if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && oO != null) {
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i3, postData3.aTN(), PbActivity.this.eBC.getPbData().qa(), false, postData3.getAuthor().getIconInfo()).addBigImageData(oO.eDi, oO.eDj, oO.eDk, oO.index)));
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
                                                                                                                b oO2 = PbActivity.this.oO(id2);
                                                                                                                if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && oO2 != null && PbActivity.this.aOc().aQN() != null) {
                                                                                                                    com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                    mVar.b(PbActivity.this.eBC.getPbData().aMU());
                                                                                                                    mVar.U(PbActivity.this.eBC.getPbData().aMW());
                                                                                                                    mVar.e(postData4);
                                                                                                                    PbActivity.this.aOc().aQN().d(mVar);
                                                                                                                    PbActivity.this.aOc().aQN().setPostId(str7);
                                                                                                                    PbActivity.this.a(view, str6, str5);
                                                                                                                    return;
                                                                                                                }
                                                                                                                return;
                                                                                                            } else {
                                                                                                                TiebaStatic.log("c11742");
                                                                                                                b oO3 = PbActivity.this.oO(id2);
                                                                                                                if (postData3 != null && PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && oO3 != null) {
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i3, postData3.aTN(), PbActivity.this.eBC.getPbData().qa(), false, postData3.getAuthor().getIconInfo()).addBigImageData(oO3.eDi, oO3.eDj, oO3.eDk, oO3.index)));
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 3).ac("fid", PbActivity.this.eBC.getPbData().getForumId()));
                                                                                                return;
                                                                                            }
                                                                                        } else if (com.baidu.adp.lib.util.j.hh()) {
                                                                                            PbActivity.this.eBE.aCv();
                                                                                            SparseArray<Object> c3 = PbActivity.this.eBE.c(PbActivity.this.eBC.getPbData(), PbActivity.this.eBC.aPs(), 1);
                                                                                            if (c3 != null) {
                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBC.getPbData().aMU().getId(), PbActivity.this.eBC.getPbData().aMU().getName(), PbActivity.this.eBC.getPbData().aMW().getId(), String.valueOf(PbActivity.this.eBC.getPbData().getUserData().getUserId()), (String) c3.get(d.h.tag_forbid_user_name), (String) c3.get(d.h.tag_forbid_user_post_id))));
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                                            return;
                                                                                        }
                                                                                    } else if (!com.baidu.adp.lib.util.j.hh()) {
                                                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                        if (sparseArray11 != null) {
                                                                                            if (!com.baidu.tieba.c.a.Xj() || sparseArray11.get(d.h.tag_del_post_id) == null || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eBC.getThreadID(), (String) sparseArray11.get(d.h.tag_del_post_id))) {
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
                                                                                                    PbActivity.this.eBE.bk(view);
                                                                                                    return;
                                                                                                } else if (booleanValue5) {
                                                                                                    PbActivity.this.eBE.a(((Integer) sparseArray11.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.h.tag_del_post_id), ((Integer) sparseArray11.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.h.tag_del_post_is_self)).booleanValue());
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
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac("fid", PbActivity.this.eBC.getPbData().getForumId()));
                                                                                    return;
                                                                                } else {
                                                                                    PbActivity.this.aNY();
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
                                                                            com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eBC.getPbData();
                                                                            String str9 = null;
                                                                            String str10 = null;
                                                                            String str11 = null;
                                                                            if (pbData4 != null && pbData4.aMU() != null) {
                                                                                str9 = pbData4.aMU().getId();
                                                                                str10 = pbData4.aMU().getName();
                                                                                str11 = pbData4.getThreadId();
                                                                            }
                                                                            com.baidu.tieba.pb.a.a(j3, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                            PbActivity.this.a(j3, str8, str9, str10, str11, i4);
                                                                            return;
                                                                        }
                                                                        SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                        if (sparseArray12 != null && (sparseArray12.get(d.h.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.h.tag_del_post_id) instanceof String) && (sparseArray12.get(d.h.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.h.tag_del_post_is_self) instanceof Boolean)) {
                                                                            boolean booleanValue7 = ((Boolean) sparseArray12.get(d.h.tag_del_post_is_self)).booleanValue();
                                                                            int intValue = ((Integer) sparseArray12.get(d.h.tag_manage_user_identity)).intValue();
                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.Xj() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eBC.getThreadID(), (String) sparseArray12.get(d.h.tag_del_post_id))) {
                                                                                PbActivity.this.eBE.a(((Integer) sparseArray12.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.h.tag_del_post_id), intValue, booleanValue7);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    if (PbActivity.this.eBJ.aQj()) {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ac("tid", PbActivity.this.eBC.eFj));
                                                                    } else {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 1));
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eBC.getPbData() != null) {
                                                                        PbActivity.this.eBE.aCv();
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
                                                                            String threadID2 = PbActivity.this.eBC.getThreadID();
                                                                            String id3 = postData.getId();
                                                                            int i5 = 0;
                                                                            if (PbActivity.this.eBC.getPbData() != null) {
                                                                                i5 = PbActivity.this.eBC.getPbData().aNh();
                                                                            }
                                                                            PbActivity.this.ahc();
                                                                            b oO4 = PbActivity.this.oO(id3);
                                                                            if (oO4 != null) {
                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID2, id3, "pb", true, null, true, null, i5, postData.aTN(), PbActivity.this.eBC.getPbData().qa(), false, postData.getAuthor().getIconInfo()).addBigImageData(oO4.eDi, oO4.eDj, oO4.eDk, oO4.index)));
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
                                                                    PbActivity.this.bf(view);
                                                                    if (PbActivity.this.eBC.getPbData().aMW() != null && PbActivity.this.eBC.getPbData().aMW().getAuthor() != null && PbActivity.this.eBC.getPbData().aMW().getAuthor().getUserId() != null && PbActivity.this.efH != null) {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eBC.eFj).r("obj_locate", 2).ac("obj_id", PbActivity.this.eBC.getPbData().aMW().getAuthor().getUserId()).r("obj_type", PbActivity.this.efH.nz() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.eBC.getPbData())));
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 4));
                                                            if (!com.baidu.adp.lib.util.j.hh()) {
                                                                PbActivity.this.showToast(d.l.network_not_available);
                                                                return;
                                                            }
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                PbActivity.this.oL((String) tag);
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
                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), null, PbActivity.this.aOh(), true)));
                                                        PbActivity.this.eBE.eIN.of();
                                                        PbActivity.this.eBE.eIN.aSI().aQx();
                                                        return;
                                                    } else if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBC.getPbData().aMW() != null) {
                                                        PbActivity.this.eBE.eIN.of();
                                                        PbActivity.this.oL(PbActivity.this.eBC.getPbData().aMW().rE());
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (com.baidu.tbadk.o.al.fS() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.eBC != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ac("tid", PbActivity.this.eBC.getThreadID()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("fid", PbActivity.this.eBC.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.hy()) {
                                                        if (PbActivity.this.eBC.getPbData() != null) {
                                                            ArrayList<PostData> aMY2 = PbActivity.this.eBC.getPbData().aMY();
                                                            if ((aMY2 != null && aMY2.size() > 0) || !PbActivity.this.eBC.aPs()) {
                                                                PbActivity.this.eBE.aCv();
                                                                PbActivity.this.ahc();
                                                                PbActivity.this.pc(2);
                                                                if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBC.getPbData().aNo() != null && !StringUtils.isNull(PbActivity.this.eBC.getPbData().aNo().pL(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ac("fid", PbActivity.this.eBC.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.al.fS()) {
                                                                    PbActivity.this.pd(2);
                                                                    return;
                                                                }
                                                                PbActivity.this.eBE.showLoadingDialog();
                                                                PbActivity.this.eBC.aPS().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                return;
                                                            }
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                                            return;
                                                        }
                                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                                        return;
                                                    }
                                                    PbActivity.this.showToast(d.l.neterror);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            PbActivity.this.eBE.eIN.of();
                                        } else if (com.baidu.adp.lib.util.j.hh()) {
                                            PbActivity.this.eBE.aCv();
                                            if (PbActivity.this.eBE.eIN.aSI() != null && view == PbActivity.this.eBE.eIN.aSI().aQo() && !PbActivity.this.eBE.aRP()) {
                                                PbActivity.this.eBE.aQP();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.ahc();
                                                PbActivity.this.eBE.aRj();
                                                if (view.getId() == d.h.floor_owner_reply) {
                                                    j = PbActivity.this.eBC.j(true, PbActivity.this.aOz());
                                                } else {
                                                    j = view.getId() == d.h.reply_title ? PbActivity.this.eBC.j(false, PbActivity.this.aOz()) : PbActivity.this.eBC.oQ(PbActivity.this.aOz());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.eBE.iU(true);
                                                    PbActivity.this.eBE.awW();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.eBE.jp(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.pc(2);
                                                return;
                                            }
                                            view.setTag(Boolean.FALSE);
                                        } else {
                                            PbActivity.this.showToast(d.l.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                        }
                                    } else if (com.baidu.adp.lib.util.j.hh()) {
                                        PbActivity.this.eBE.aCv();
                                        if (PbActivity.this.pb(11009) && PbActivity.this.eBC.pq(PbActivity.this.eBE.aRo()) != null) {
                                            PbActivity.this.aOt();
                                            if (PbActivity.this.eBC.getPbData().aMW() != null && PbActivity.this.eBC.getPbData().aMW().getAuthor() != null && PbActivity.this.eBC.getPbData().aMW().getAuthor().getUserId() != null && PbActivity.this.efH != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ac("tid", PbActivity.this.eBC.eFj).r("obj_locate", 1).ac("obj_id", PbActivity.this.eBC.getPbData().aMW().getAuthor().getUserId()).r("obj_type", PbActivity.this.efH.nz() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.eBC.getPbData())));
                                            }
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.l.network_not_available);
                                    }
                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                    PbActivity.this.eBE.iU(true);
                                    PbActivity.this.eBE.aQP();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eBE.awW();
                                        PbActivity.this.ahc();
                                        PbActivity.this.eBE.aRj();
                                        PbActivity.this.eBC.oQ(PbActivity.this.aOz());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.pc(2);
                                    }
                                } else {
                                    PbActivity.this.showToast(d.l.network_not_available);
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (view.getId() == d.h.view_forum_name_first_floor) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12505").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, com.baidu.tieba.pb.d.v(PbActivity.this.getPageContext())));
                                }
                                if (PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBC.getPbData().aMW() != null && PbActivity.this.eBC.getPbData().aMW().sb() && PbActivity.this.eBC.getPbData().aMW().rF() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.eBC.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eBC.aPr()) && PbActivity.this.eBC.getAppealInfo() != null) {
                                        name = PbActivity.this.eBC.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eBC.getPbData().aMU().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aPr = PbActivity.this.eBC.aPr();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eBC.aPt() && aPr != null && aPr.equals(name)) {
                                        PbActivity.this.finish();
                                        return;
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                        return;
                                    }
                                }
                                PbActivity.this.finish();
                            }
                        } else if (com.baidu.adp.lib.util.j.hh()) {
                            if (PbActivity.this.eBC.getPbData().aNh() == 1 && !PbActivity.this.eBD.bsc()) {
                                PbActivity.this.eBE.aCv();
                                int i6 = 0;
                                if (PbActivity.this.eBE.eIN.aSI() == null || view != PbActivity.this.eBE.eIN.aSI().aQp()) {
                                    if (PbActivity.this.eBE.eIN.aSI() == null || view != PbActivity.this.eBE.eIN.aSI().aQr()) {
                                        if (view == PbActivity.this.eBE.aRh()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eBC.getPbData().aMW().rk() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eBC.getPbData().aMW().rj() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aMU = PbActivity.this.eBC.getPbData().aMU();
                                String name2 = aMU.getName();
                                String id4 = aMU.getId();
                                String id5 = PbActivity.this.eBC.getPbData().aMW().getId();
                                if (!com.baidu.tieba.c.a.Xj() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eBE.aRg();
                                    PbActivity.this.eBD.a(id4, name2, id5, i6, PbActivity.this.eBE.aRi());
                                }
                            }
                        } else {
                            PbActivity.this.showToast(d.l.network_not_available);
                        }
                    } else if (com.baidu.adp.lib.util.j.hh()) {
                        PbActivity.this.eBE.aCv();
                        PbActivity.this.ahc();
                        PbActivity.this.eBE.aRj();
                        PbActivity.this.eBE.showLoadingDialog();
                        if (PbActivity.this.eBE.aQV() != null) {
                            PbActivity.this.eBE.aQV().setVisibility(8);
                        }
                        PbActivity.this.eBC.pj(1);
                        if (PbActivity.this.eBh != null) {
                            PbActivity.this.eBh.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.l.network_not_available);
                    }
                } else if (PbActivity.this.eBs) {
                    PbActivity.this.eBs = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.h.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && PbActivity.this.aOc().aQN() != null && postData5.getAuthor() != null && postData5.brq() != 1 && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.c(postData5)) {
                                if (PbActivity.this.aOc().aQO() != null) {
                                    PbActivity.this.aOc().aQO().aPl();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.eBC.getPbData().aMU());
                                mVar2.U(PbActivity.this.eBC.getPbData().aMW());
                                mVar2.e(postData5);
                                PbActivity.this.aOc().aQN().d(mVar2);
                                PbActivity.this.aOc().aQN().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.getAuthor().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.eBQ != null) {
                                    PbActivity.this.eBE.hf(PbActivity.this.eBQ.CZ());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aCE = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.ahc();
            PbActivity.this.eBE.jt(z);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ad.Gp() && PbActivity.this.aOd() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aOd().oT(postWriteCallBackData.getPostId());
                    PbActivity.this.eCb = PbActivity.this.eBE.aQS();
                    if (PbActivity.this.eBC != null) {
                        PbActivity.this.eBC.bt(PbActivity.this.eCb, PbActivity.this.eBE.aQT());
                    }
                }
                PbActivity.this.eBE.aCv();
                if (PbActivity.this.eBQ != null) {
                    PbActivity.this.eBE.hf(PbActivity.this.eBQ.CZ());
                }
                PbActivity.this.eBE.aQM();
                PbActivity.this.eBE.hg(true);
                PbActivity.this.eBC.aPG();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eBC.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBC.getPbData();
                            if (pbData != null && pbData.aMW() != null && pbData.aMW().getAuthor() != null && (userId = pbData.aMW().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ad.Gp() && PbActivity.this.eBC.aPz()) {
                                PbActivity.this.eBE.aRj();
                            }
                        } else if (!com.baidu.tbadk.o.ad.Gp() && PbActivity.this.eBC.aPz()) {
                            PbActivity.this.eBE.aRj();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eBE.n(PbActivity.this.eBC.getPbData());
                    }
                    if (PbActivity.this.eBC.aPw()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ac("tid", PbActivity.this.eBC.getThreadID()));
                    }
                }
            } else if (qVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    private final PbModel.a eCv = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eM;
            if (!z || fVar == null || fVar.aNf() != null || com.baidu.tbadk.core.util.v.t(fVar.aMY()) >= 1) {
                PbActivity.this.eir = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eBE.aRl();
                if (fVar == null || !fVar.aNc()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eBE.getView());
                } else if (PbActivity.this.eBE.aQK() == null) {
                    PbActivity.this.eBS = true;
                }
                PbActivity.this.eBE.awV();
                PbActivity.this.eBE.aRf();
                if (PbActivity.this.cui || PbActivity.this.eBE.aRP()) {
                    PbActivity.this.eBE.aRD();
                } else if (!PbActivity.this.eBE.aRC()) {
                    PbActivity.this.eBE.hg(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eBK = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eBE.NX();
                    PbActivity.this.eBE.jz(fVar.aNc());
                    if (fVar.aMW() != null && fVar.aMW().sk() != null) {
                        PbActivity.this.a(fVar.aMW().sk());
                    }
                    PbActivity.this.aNZ();
                    if (PbActivity.this.eBQ != null) {
                        PbActivity.this.eBE.hf(PbActivity.this.eBQ.CZ());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aMY() != null && fVar.aMY().size() >= 1 && fVar.aMY().get(0) != null) {
                        PbActivity.this.eBC.oS(fVar.aMY().get(0).getId());
                    } else if (fVar.aNf() != null) {
                        PbActivity.this.eBC.oS(fVar.aNf().getId());
                    }
                    if (PbActivity.this.eBQ != null) {
                        PbActivity.this.eBQ.a(fVar.qa());
                        PbActivity.this.eBQ.a(fVar.aMU(), fVar.getUserData());
                        PbActivity.this.eBQ.a(PbActivity.this.eBC.aPA(), PbActivity.this.eBC.getThreadID(), PbActivity.this.eBC.aPU());
                        if (fVar.aMW() != null) {
                            PbActivity.this.eBQ.bI(fVar.aMW().sA());
                        }
                    }
                    if (PbActivity.this.efH != null) {
                        PbActivity.this.efH.ac(fVar.nz());
                    }
                    if (fVar == null || fVar.aNi() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eBE.jy(PbActivity.this.mIsFromCDN);
                    PbActivity.this.eBE.a(fVar, i2, i3, PbActivity.this.eBC.aPs(), i4, PbActivity.this.eBC.getIsFromMark());
                    PbActivity.this.eBE.d(fVar, PbActivity.this.eBC.aPs());
                    PbActivity.this.eBE.jw(PbActivity.this.eBC.getHostMode());
                    AntiData qa = fVar.qa();
                    if (qa != null) {
                        PbActivity.this.aCs = qa.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aCs) && PbActivity.this.eBQ != null && PbActivity.this.eBQ.Ct() != null && (eM = PbActivity.this.eBQ.Ct().eM(6)) != null && !TextUtils.isEmpty(PbActivity.this.aCs)) {
                            ((View) eM).setOnClickListener(PbActivity.this.dOl);
                        }
                    }
                    com.baidu.tieba.pb.f.oB(fVar.eyH);
                    if (PbActivity.this.eBM) {
                        PbActivity.this.eBM = false;
                        PbActivity.this.aOc().getListView().setSelection(PbActivity.this.aOn());
                    }
                    if (PbActivity.this.eBN) {
                        PbActivity.this.eBN = false;
                        int aOn = PbActivity.this.aOn();
                        if (aOn == -1) {
                            aOn = PbActivity.this.aOo();
                        }
                        if (PbActivity.this.aOc() != null) {
                            PbActivity.this.aOc().pu(aOn);
                        }
                    } else {
                        PbActivity.this.eBE.aRp();
                    }
                    PbActivity.this.eBC.a(fVar.aMU(), PbActivity.this.eCj);
                    PbActivity.this.eBC.a(PbActivity.this.eCk);
                } else if (str != null) {
                    if (!PbActivity.this.eBK && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eBC != null && PbActivity.this.eBC.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eBC.getAppealInfo().eya)) {
                                    PbActivity.this.eBE.a(PbActivity.this.eBC.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eBE.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.f.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eBE.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.f.ds200));
                            }
                            PbActivity.this.eBE.aRD();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.eBC.getThreadID());
                            jSONObject.put("fid", PbActivity.this.eBC.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                    }
                    if (i != -1) {
                        PbActivity.this.eBE.oU(PbActivity.this.getResources().getString(d.l.list_no_more_new));
                    } else {
                        PbActivity.this.eBE.oU("");
                    }
                    PbActivity.this.eBE.wn();
                }
                PbActivity.this.aIZ = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aOd().aPs() || PbActivity.this.aOd().getPbData().qq().qn() != 0 || PbActivity.this.aOd().aPN()) {
                    PbActivity.this.eBR = true;
                    return;
                }
                return;
            }
            PbActivity.this.eBC.pj(1);
            if (PbActivity.this.eBh != null) {
                PbActivity.this.eBh.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eBE.n(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.r.FW().FX()) {
                com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, PbActivity.this.aIR, PbActivity.this.createTime, PbActivity.this.aIZ, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.ccS : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aIR = 0L;
                if (mVar != null) {
                    mVar.FR();
                }
            }
        }
    };
    private CustomMessageListener eCw = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aOi() == 1) {
                    PbActivity.this.aOr();
                }
                PbActivity.this.aOj();
            }
        }
    };
    private final a.InterfaceC0042a eCx = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eBE.aRl();
            if (z) {
                if (PbActivity.this.efH != null) {
                    PbActivity.this.efH.ac(z2);
                }
                PbActivity.this.eBC.iZ(z2);
                if (PbActivity.this.eBC.nz()) {
                    PbActivity.this.aOu();
                } else {
                    PbActivity.this.eBE.n(PbActivity.this.eBC.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.efH != null && PbActivity.this.efH.nC() != null && PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBC.getPbData().aMW() != null && PbActivity.this.eBC.getPbData().aMW().getAuthor() != null) {
                        MarkData nC = PbActivity.this.efH.nC();
                        MetaData author = PbActivity.this.eBC.getPbData().aMW().getAuthor();
                        if (nC != null && author != null) {
                            if (!com.baidu.tbadk.core.util.am.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                PbActivity.this.a(author);
                                return;
                            } else {
                                PbActivity.this.showToast(d.l.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.l.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.l.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.l.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            boolean z = true;
            if (!PbActivity.this.pa(PbActivity.this.mLastScrollState) && PbActivity.this.pa(i)) {
                if (PbActivity.this.eBE != null) {
                    PbActivity.this.eBE.aCv();
                    if (PbActivity.this.eBQ != null && !PbActivity.this.eBE.aQQ()) {
                        PbActivity.this.eBE.hf(PbActivity.this.eBQ.CZ());
                    }
                    if (!PbActivity.this.cui) {
                        PbActivity.this.eBE.aQP();
                    }
                }
                if (!PbActivity.this.eBp) {
                    PbActivity.this.eBp = true;
                    PbActivity.this.eBE.aRB();
                }
            }
            PbActivity.this.eBE.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eBh != null) {
                PbActivity.this.eBh.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eBq == null) {
                PbActivity.this.eBq = new com.baidu.tbadk.k.d();
                PbActivity.this.eBq.fs(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBC.getPbData().aMW() != null && PbActivity.this.eBC.getPbData().aMW().sb()) {
                    z = false;
                }
                if (PbActivity.this.eBE.aRe() != null && z) {
                    PbActivity.this.eBE.aRe().notifyDataSetChanged();
                }
                PbActivity.this.eBq.FD();
            } else if (i == 1) {
                PbActivity.this.eBq.FD();
            } else {
                PbActivity.this.eBq.FD();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aMY;
            if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null && PbActivity.this.eBE != null && PbActivity.this.eBE.aRe() != null) {
                PbActivity.this.eBE.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eBh != null) {
                    PbActivity.this.eBh.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eBC.aPI() && (aMY = PbActivity.this.eBC.getPbData().aMY()) != null && !aMY.isEmpty()) {
                    int aPb = ((i + i2) - PbActivity.this.eBE.aRe().aPb()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBC.getPbData();
                    if (pbData != null) {
                        if (pbData.aMZ() != null && pbData.aMZ().hasData()) {
                            aPb--;
                        }
                        if (pbData.aNa() != null && pbData.aNa().hasData()) {
                            aPb--;
                        }
                        int size = aMY.size();
                        if (aPb < 0 || aPb >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eCy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.eBD.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eBC.aPG();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.cRI && bVar.eRv > 0 && bVar.giN != 0 && bVar.eRv != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.eRv == 1002 && !bVar.cRI) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eBE.a(1, dVar.Al, dVar.giP, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eBD.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eBE.a(PbActivity.this.eBD.getLoadDataMode(), fVar.Al, fVar.giP, false);
                        PbActivity.this.eBE.aj(fVar.giR);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eBE.a(PbActivity.this.eBD.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final c eCz = new c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
    };
    private final g.b bbF = new g.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aOA()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eBC.iY(true)) {
                PbActivity.this.eBE.aRm();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eCB = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eCA && PbActivity.this.aOA()) {
                PbActivity.this.aOC();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eBC.iX(false)) {
                    PbActivity.this.eBE.aRk();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eBC.getPbData() != null) {
                    PbActivity.this.eBE.aRA();
                }
                PbActivity.this.eCA = true;
            }
        }
    };
    private int eCC = 0;
    private final TbRichTextView.f aSj = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
        /* JADX DEBUG: Multi-variable search result rejected for r2v33, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
        public void a(View view, String str, int i) {
            TbRichTextData tbRichTextData;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.eBE.e((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                b bVar = new b();
                PbActivity.this.a(str, i, bVar);
                if (bVar.eDm) {
                    TbRichText am = PbActivity.this.am(str, i);
                    if (am != null && (tbRichTextData = am.Ix().get(PbActivity.this.eCC)) != null && tbRichTextData.IJ() != null && tbRichTextData.IJ().memeInfo != null && !TextUtils.isEmpty(tbRichTextData.IJ().memeInfo.detail_link)) {
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextData.IJ().memeInfo.pck_id.intValue(), tbRichTextData.IJ().memeInfo.pic_id.longValue(), 25033)));
                        PbActivity.this.eBA = view;
                    }
                } else if (bVar.eDl) {
                    TbRichText am2 = PbActivity.this.am(str, i);
                    if (am2 != null && PbActivity.this.eCC >= 0 && PbActivity.this.eCC < am2.Ix().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String c2 = com.baidu.tieba.pb.data.g.c(am2.Ix().get(PbActivity.this.eCC));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= bVar.eDi.size()) {
                                break;
                            } else if (!bVar.eDi.get(i3).equals(c2)) {
                                i2 = i3 + 1;
                            } else {
                                bVar.index = i3;
                                arrayList.add(c2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.u(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, bVar.eDj.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eDk, bVar.lastId, PbActivity.this.eBC.aPE(), concurrentHashMap, true, false, PbActivity.this.eBC.getHostMode());
                        createConfig.getIntent().putExtra("from", "pb");
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    }
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(bVar.eDi, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.u(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, bVar.eDj.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eDk, bVar.eDi.get(0), PbActivity.this.eBC.aPE(), concurrentHashMap2, true, false, PbActivity.this.eBC.getHostMode());
                    createConfig2.getIntent().putExtra("from", "pb");
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eCD = false;
    PostData eCE = null;
    private final b.InterfaceC0047b eCF = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eCE != null) {
                if (i == 0) {
                    PbActivity.this.eCE.bW(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eCE = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.g(PbActivity.this.eCE);
                }
            }
        }
    };
    private final b.InterfaceC0047b eCG = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eBY != null && !TextUtils.isEmpty(PbActivity.this.eBZ)) {
                if (i == 0) {
                    if (PbActivity.this.eCa == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eBZ));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eBZ;
                        aVar.pkgId = PbActivity.this.eCa.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eCa.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eBX == null) {
                        PbActivity.this.eBX = new aq(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eBX.i(PbActivity.this.eBZ, PbActivity.this.eBY.kQ());
                }
                PbActivity.this.eBY = null;
                PbActivity.this.eBZ = null;
            }
        }
    };
    private final View.OnLongClickListener auu = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eBY = ((TbImageView) view).getBdImage();
                PbActivity.this.eBZ = ((TbImageView) view).getUrl();
                if (PbActivity.this.eBY != null && !TextUtils.isEmpty(PbActivity.this.eBZ)) {
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eCa = null;
                    } else {
                        PbActivity.this.eCa = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eBE.a(PbActivity.this.eCG, PbActivity.this.eBY.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.eBY = ((GifView) view).getBdImage();
                }
                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                    PbActivity.this.eBZ = ((GifView) view).getBdImage().getUrl();
                }
                if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                    PbActivity.this.eCa = null;
                } else {
                    PbActivity.this.eCa = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                }
                PbActivity.this.eBE.a(PbActivity.this.eCG, PbActivity.this.eBY.isGif());
            } else if (view instanceof com.baidu.tbadk.widget.c) {
                if (((com.baidu.tbadk.widget.c) view).getBdImage() != null) {
                    PbActivity.this.eBY = ((com.baidu.tbadk.widget.c) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.c) view).getBdImage().getUrl())) {
                        PbActivity.this.eBZ = ((com.baidu.tbadk.widget.c) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eCa = null;
                    } else {
                        PbActivity.this.eCa = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eBE.a(PbActivity.this.eCG, PbActivity.this.eBY.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eCE = (PostData) sparseArray.get(d.h.tag_clip_board);
                    if (PbActivity.this.eCE != null && PbActivity.this.efH != null) {
                        PbActivity.this.eBE.a(PbActivity.this.eCF, PbActivity.this.efH.nz() && PbActivity.this.eCE.getId() != null && PbActivity.this.eCE.getId().equals(PbActivity.this.eBC.rx()), ((Boolean) sparseArray.get(d.h.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a cow = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aL(boolean z) {
            if (!PbActivity.this.eBj && z && !PbActivity.this.eBC.aPy()) {
                PbActivity.this.aCc();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.f.ds200));
        }
    };
    public View.OnTouchListener aLM = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).aqm()) {
                        break;
                    }
                }
            }
            PbActivity.this.ctr.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0081a cau = new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        final int bBU;

        {
            this.bBU = (int) PbActivity.this.getResources().getDimension(d.f.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ao(int i, int i2) {
            if (Q(i2) && PbActivity.this.eBE != null && PbActivity.this.eBh != null) {
                PbActivity.this.eBE.aRE();
                PbActivity.this.eBh.eJ(false);
                PbActivity.this.eBh.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ap(int i, int i2) {
            if (Q(i2) && PbActivity.this.eBE != null && PbActivity.this.eBh != null) {
                PbActivity.this.eBh.eJ(true);
                if (Math.abs(i2) > this.bBU) {
                    PbActivity.this.eBh.hideFloatingView();
                }
                if (PbActivity.this.aOA()) {
                    PbActivity.this.eBE.aRa();
                    PbActivity.this.eBE.aRb();
                }
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void aq(int i, int i2) {
        }

        private boolean Q(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eCH = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tieba.e.b.a
        public void eb(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aNP();
            } else {
                com.baidu.tieba.pb.a.b.aNO();
            }
        }
    };
    private String eCI = null;
    private final m.a eCJ = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.l.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eCI = str2;
                PbActivity.this.eBE.oV(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eCK = -1;
    private int eCL = -1;
    private CustomMessageListener eCO = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Tf == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0045a) {
                    if (aVar.Tg != null && !aVar.Tg.hasError() && aVar.Tg.getError() == 0) {
                        if (PbActivity.this.eBE != null) {
                            PbActivity.this.eBE.w(((a.C0045a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aOM();
                        }
                    } else if (z) {
                        if (aVar.Tg != null && aVar.Tg.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Tg.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Tg != null && !aVar.Tg.hasError() && aVar.Tg.getError() == 0) {
                        if (PbActivity.this.eBE != null && PbActivity.this.eBE != null) {
                            PbActivity.this.eBE.w(((a.C0045a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Tg != null && aVar.Tg.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Tg.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Tg == null || aVar.Tg.hasError() || aVar.Tg.getError() != 0) {
                        if (z) {
                            if (aVar.Tg != null && aVar.Tg.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Tg.getErrorString());
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
    private final CustomMessageListener cre = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ac("obj_locate", "pb"));
                    av.vA().c(PbActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void f(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> eDi;
        public ConcurrentHashMap<String, ImageUrlData> eDj;
        public boolean eDl;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eDk = false;
        public boolean eDm = false;
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

    public com.baidu.tbadk.editortools.pb.c aNX() {
        return this.eBQ;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar.aNF() != null) {
            String id = mVar.aNF().getId();
            ArrayList<PostData> aMY = this.eBC.getPbData().aMY();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aMY.size()) {
                    break;
                }
                PostData postData = aMY.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aNJ = mVar.aNJ();
                    postData.tz(mVar.getTotalCount());
                    if (postData.brn() != null) {
                        postData.brn().clear();
                        postData.brn().addAll(aNJ);
                    }
                    if (postData.brj() != null) {
                        postData.brk();
                    }
                }
            }
            if (!this.eBC.getIsFromMark()) {
                this.eBE.n(this.eBC.getPbData());
            }
            c(mVar);
        }
    }

    public void aNY() {
        com.baidu.tieba.pb.data.f pbData;
        bh aMW;
        if (!this.eCm) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.l.no_network_guide);
            } else if (this.eCp) {
                this.eCm = true;
                if (this.eBC != null && (pbData = this.eBC.getPbData()) != null && (aMW = pbData.aMW()) != null) {
                    int isLike = aMW.re() == null ? 0 : aMW.re().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ac("tid", aMW.getId()));
                    }
                    if (this.eCn != null) {
                        this.eCn.a(aMW.rE(), aMW.getId(), isLike, "pb");
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
                    bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.eBE.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eBV);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eBV);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.l.un_mute) : getResources().getString(d.l.mute);
                    bVar.a(strArr2, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eBV);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eBV);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).te();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(int i) {
        bh aMW;
        String str;
        String y;
        if (this.eBC != null && this.eBC.getPbData() != null && (aMW = this.eBC.getPbData().aMW()) != null) {
            if (i == 1) {
                PraiseData re = aMW.re();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (re == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aMW.a(praiseData);
                    } else {
                        aMW.re().getUser().add(0, metaData);
                        aMW.re().setNum(aMW.re().getNum() + 1);
                        aMW.re().setIsLike(i);
                    }
                }
                if (aMW.re() != null) {
                    if (aMW.re().getNum() < 1) {
                        y = getResources().getString(d.l.frs_item_praise_text);
                    } else {
                        y = com.baidu.tbadk.core.util.am.y(aMW.re().getNum());
                    }
                    this.eBE.R(y, true);
                }
            } else if (aMW.re() != null) {
                aMW.re().setIsLike(i);
                aMW.re().setNum(aMW.re().getNum() - 1);
                ArrayList<MetaData> user = aMW.re().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aMW.re().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aMW.re().getNum() < 1) {
                    str = getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = aMW.re().getNum() + "";
                }
                this.eBE.R(str, false);
            }
            if (this.eBC.aPs()) {
                this.eBE.aRe().notifyDataSetChanged();
            } else {
                this.eBE.o(this.eBC.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eBC != null && this.eBC.getPbData() != null && this.eBE != null) {
            this.eBE.d(this.eBC.getPbData(), this.eBC.aPs(), this.eBC.aPJ());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eBC.u(bundle);
        if (this.cqg != null) {
            this.cqg.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eBQ.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eBT = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.ccS = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eBw = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eBw)) {
                this.eBi = true;
            }
            this.eCK = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eCL = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eCM = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eBM = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eBN = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aOA()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.eCc = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.eBt = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.ccS = System.currentTimeMillis();
        }
        this.eBo = System.currentTimeMillis();
        this.aIR = this.eBo - this.ccS;
        super.onCreate(bundle);
        this.eBl = 0;
        w(bundle);
        if (this.eBC != null && this.eBC.getPbData() != null) {
            this.eBC.getPbData().oH(this.source);
        }
        initUI();
        if (intent != null && this.eBE != null) {
            this.eBE.eIH = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eBW == null) {
                    this.eBW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eBE.oX("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eBW, 1500L);
            }
        }
        this.cqg = new VoiceManager();
        this.cqg.onCreate(getPageContext());
        initData(bundle);
        this.eBP = new com.baidu.tbadk.editortools.pb.d();
        aNZ();
        this.eBQ = (com.baidu.tbadk.editortools.pb.c) this.eBP.aW(getActivity());
        this.eBQ.d(this);
        this.eBQ.a(this.aCE);
        this.eBQ.a(this.aCw);
        this.eBQ.a(this, bundle);
        this.eBQ.Ct().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eBQ.Ct().bB(true);
        iJ(true);
        this.eBE.setEditorTools(this.eBQ.Ct());
        this.eBQ.a(this.eBC.aPA(), this.eBC.getThreadID(), this.eBC.aPU());
        registerListener(this.dOm);
        if (!this.eBC.aPx()) {
            this.eBQ.fM(this.eBC.getThreadID());
        }
        if (this.eBC.aPV()) {
            this.eBQ.fK(getPageContext().getString(d.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eBQ.fK(getPageContext().getString(d.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eBo;
        registerListener(this.eCf);
        registerListener(this.dOI);
        registerListener(this.eCg);
        registerListener(this.cra);
        registerListener(this.eCu);
        registerListener(this.eCe);
        this.eBO = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gfU);
        this.eBO.bqQ();
        registerListener(this.eCi);
        registerListener(this.aoH);
        if (this.eBC != null) {
            this.eBC.aPL();
        }
        registerListener(this.eCw);
        registerListener(this.eCO);
        registerListener(this.crl);
        if (this.eBE != null && this.eBE.aRI() != null && this.eBE.aRJ() != null) {
            this.eBh = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eBE.aRI(), this.eBE.aRJ(), this.eBE.aQV());
            this.eBh.a(this.eCq);
        }
        if (this.eBg && this.eBE != null && this.eBE.aRJ() != null) {
            this.eBE.aRJ().setVisibility(8);
        }
        this.eBU = new com.baidu.tbadk.core.view.c();
        this.eBU.akv = 1000L;
        registerListener(this.eCt);
        registerListener(this.eCr);
        registerListener(this.eCs);
        this.eBV = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eBV;
        userMuteAddAndDelCustomMessage.setTag(this.eBV);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eBV;
        userMuteCheckCustomMessage.setTag(this.eBV);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eBC.aPS().a(this.brE);
        if ("from_tieba_kuang".equals(this.eBw)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 2).ac("tid", this.eBC.getThreadID()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNZ() {
        if (this.eBP != null && this.eBC != null) {
            this.eBP.setForumName(this.eBC.aPr());
            if (this.eBC.getPbData() != null && this.eBC.getPbData().aMU() != null) {
                this.eBP.setForumId(this.eBC.getPbData().aMU().getId());
            }
            this.eBP.setFrom("pb");
            this.eBP.a(this.eBC);
        }
    }

    public String aOa() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aOb() {
        return this.eBh;
    }

    private void iJ(boolean z) {
        this.eBQ.bF(z);
        this.eBQ.bG(z);
        this.eBQ.bH(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cqg != null) {
            this.cqg.onStart(getPageContext());
        }
    }

    public an aOc() {
        return this.eBE;
    }

    public PbModel aOd() {
        return this.eBC;
    }

    public void oJ(String str) {
        if (this.eBC != null && !StringUtils.isNull(str) && this.eBE != null) {
            this.eBE.aRf();
            this.eBE.jB(true);
            this.eBC.oJ(str);
            this.eBv = true;
            this.eBE.aCv();
            this.eBE.aRD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eBj = false;
        } else {
            this.eBj = true;
        }
        super.onPause();
        if (this.eBE.aQK() != null && this.eBE.aQK().aNU() != null) {
            this.eBE.aQK().aNU().onPause();
        }
        BdListView listView = getListView();
        this.eBl = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eBl == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cqg != null) {
            this.cqg.onPause(getPageContext());
        }
        if (this.eBE != null) {
            this.eBE.onPause();
        }
        if (!this.eBC.aPx()) {
            this.eBQ.fL(this.eBC.getThreadID());
        }
        if (this.eBC != null) {
            this.eBC.aPM();
        }
        MessageManager.getInstance().unRegisterListener(this.dnQ);
        aqI();
        MessageManager.getInstance().unRegisterListener(this.eCr);
        MessageManager.getInstance().unRegisterListener(this.eCs);
        MessageManager.getInstance().unRegisterListener(this.eCt);
        MessageManager.getInstance().unRegisterListener(this.cre);
        MessageManager.getInstance().unRegisterListener(this.cYg);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aOe() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eBC.getPbData(), this.eBC.aPs(), this.eBC.aPJ());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eBj = false;
        super.onResume();
        if (this.eBy) {
            this.eBy = false;
            aOG();
        }
        if (this.eBE.aQK() != null && this.eBE.aQK().aNU() != null) {
            this.eBE.aQK().aNU().onResume();
        }
        if (aOe()) {
            this.eBr = System.currentTimeMillis();
        } else {
            this.eBr = -1L;
        }
        if (this.eBE != null && this.eBE.getView() != null) {
            if (!this.eir) {
                aOx();
            } else {
                hideLoadingView(this.eBE.getView());
            }
            this.eBE.onResume();
        }
        if (this.eBl == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eBE != null) {
            noNetworkView = this.eBE.aQL();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.hh()) {
            noNetworkView.aK(false);
        }
        if (this.cqg != null) {
            this.cqg.onResume(getPageContext());
        }
        registerListener(this.dnQ);
        this.eBL = false;
        aOF();
        registerListener(this.eCr);
        registerListener(this.eCs);
        registerListener(this.eCt);
        registerListener(this.cre);
        registerListener(this.cYg);
        if (this.cqL) {
            aCc();
            this.cqL = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eBE.jq(z);
        if (this.eBJ != null) {
            this.eBJ.jb(z);
        }
        if (z && this.eBL) {
            this.eBE.aRk();
            this.eBC.iX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eBr > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ac("obj_duration", (System.currentTimeMillis() - this.eBr) + ""));
            this.eBr = 0L;
        }
        if (aOc().aQO() != null) {
            aOc().aQO().onStop();
        }
        if (this.eBE.eIN != null && !this.eBE.eIN.Yu()) {
            this.eBE.eIN.aCO();
        }
        if (this.eBC != null && this.eBC.getPbData() != null && this.eBC.getPbData().aMU() != null && this.eBC.getPbData().aMW() != null) {
            com.baidu.tbadk.distribute.a.Cd().a(getPageContext().getPageActivity(), "pb", this.eBC.getPbData().aMU().getId(), com.baidu.adp.lib.g.b.c(this.eBC.getPbData().aMW().getId(), 0L));
        }
        if (this.cqg != null) {
            this.cqg.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.eBp && this.eBE != null) {
            this.eBp = true;
            this.eBE.aRB();
            a(false, (PostData) null);
        }
        if (this.eBC != null) {
            this.eBC.cancelLoadData();
            this.eBC.destory();
            if (this.eBC.aPR() != null) {
                this.eBC.aPR().onDestroy();
            }
        }
        if (this.eBQ != null) {
            this.eBQ.onDestroy();
        }
        if (this.eBD != null) {
            this.eBD.cancelLoadData();
        }
        if (this.eBE != null) {
            this.eBE.onDestroy();
            if (this.eBE.eIN != null) {
                this.eBE.eIN.aCO();
            }
        }
        if (this.eBq != null) {
            this.eBq.onDestroy();
        }
        if (this.eBh != null) {
            this.eBh.GL();
        }
        super.onDestroy();
        if (this.cqg != null) {
            this.cqg.onDestory(getPageContext());
        }
        if (this.cqz != null) {
            this.cqz.destory();
        }
        this.eBE.aCv();
        MessageManager.getInstance().unRegisterListener(this.eCr);
        MessageManager.getInstance().unRegisterListener(this.eCs);
        MessageManager.getInstance().unRegisterListener(this.eCt);
        MessageManager.getInstance().unRegisterListener(this.eBV);
        MessageManager.getInstance().unRegisterListener(this.eCu);
        MessageManager.getInstance().unRegisterListener(this.crl);
        this.eBT = null;
        this.eBU = null;
        com.baidu.tieba.recapp.d.a.bgt().bgv();
        if (this.eBW != null) {
            getSafeHandler().removeCallbacks(this.eBW);
        }
        if (this.eBz != null) {
            this.eBz.cancelLoadData();
        }
        if (this.eBE != null && this.eBE.eIN != null) {
            this.eBE.eIN.aSM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f aRe;
        ArrayList<PostData> aPc;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xq() && this.eBE != null && (aRe = this.eBE.aRe()) != null && (aPc = aRe.aPc()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aPc.iterator();
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
                        bVar.chn = id;
                        bVar.bMY = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.YM == 1 && !TextUtils.isEmpty(id)) {
                    next.YM = 2;
                    a.b bVar2 = new a.b();
                    bVar2.chn = id;
                    bVar2.bMY = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eBC == null || this.eBC.getPbData() == null || this.eBC.getPbData().aMU() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eBC.getPbData().aMU().getFirst_class();
                    str2 = this.eBC.getPbData().aMU().getSecond_class();
                    str = this.eBC.getPbData().aMU().getId();
                    str4 = this.eBC.getThreadID();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xt());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eBE.onChangeSkinType(i);
        if (this.eBQ != null && this.eBQ.Ct() != null) {
            this.eBQ.Ct().onChangeSkinType(i);
        }
        if (this.eBE.aQL() != null) {
            this.eBE.aQL().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eBE = new an(this, this.crI, this.aSk);
        this.ctr = new com.baidu.tieba.e.b(getActivity());
        this.ctr.a(this.eCH);
        this.ctr.a(this.cau);
        this.eBE.setOnScrollListener(this.mOnScrollListener);
        this.eBE.d(this.eCB);
        this.eBE.a(this.bbF);
        this.eBE.iD(com.baidu.tbadk.core.h.oM().oS());
        this.eBE.setOnImageClickListener(this.aSj);
        this.eBE.a(this.auu);
        this.eBE.h(this.cow);
        this.eBE.a(this.eCz);
        this.eBE.jq(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bd(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.ggw == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oM().oS()) {
                    return false;
                }
                return oN(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eBE != null) {
            if (z && (!this.eir || this.eBS)) {
                aOx();
            } else {
                hideLoadingView(this.eBE.getView());
            }
            this.eBS = false;
        }
    }

    private void aOf() {
        if (this.eBm == null) {
            this.eBm = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eBm.a(new String[]{getPageContext().getString(d.l.call_phone), getPageContext().getString(d.l.sms_phone), getPageContext().getString(d.l.search_in_baidu)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eAQ = PbActivity.this.eAQ.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eAQ);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eBC.getThreadID(), PbActivity.this.eAQ, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eAQ = PbActivity.this.eAQ.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eAQ);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eBC.getThreadID(), PbActivity.this.eAQ, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eAQ = PbActivity.this.eAQ.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eAQ);
                        bVar.dismiss();
                    }
                }
            }).cg(b.a.abe).ch(17).d(getPageContext());
        }
    }

    private void w(Bundle bundle) {
        this.eBC = new PbModel(this);
        this.eBC.a(this.eCv);
        if (this.eBC.aPP() != null) {
            this.eBC.aPP().a(this.eCJ);
        }
        if (this.eBC.aPO() != null) {
            this.eBC.aPO().a(this.eCh);
        }
        if (this.eBC.aPR() != null) {
            this.eBC.aPR().a(this.eCd);
        }
        if (bundle != null) {
            this.eBC.initWithBundle(bundle);
        } else {
            this.eBC.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eBC.ja(true);
        }
        ae.aQz().Q(this.eBC.aPq(), this.eBC.getIsFromMark());
        if (StringUtils.isNull(this.eBC.getThreadID())) {
            finish();
        } else {
            this.eBC.ET();
        }
    }

    private void initData(Bundle bundle) {
        this.efH = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.efH != null) {
            this.efH.a(this.eCx);
        }
        this.eBD = new ForumManageModel(this);
        this.eBD.setLoadDataCallBack(this.eCy);
        this.aoD = new com.baidu.tbadk.coreExtra.c.a(null);
        this.eBE.a(new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.showToast(d.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eBC.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBC.getPbData().aMU().getId(), PbActivity.this.eBC.getPbData().aMU().getName(), PbActivity.this.eBC.getPbData().aMW().getId(), valueOf, str, str2)));
            }
        });
        this.eCn.setUniqueId(getUniqueId());
        this.eCn.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eBE.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eBV;
        userMuteCheckCustomMessage.setTag(this.eBV);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aMW() != null) {
            if (fVar.aMW().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aMW().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aMW().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData be(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.h.tag_clip_board)) != null && !com.baidu.tieba.pb.f.c(postData)) {
            if (postData.brD()) {
                postData.cM(postData.brC() - 1);
            } else {
                postData.cM(postData.brC() + 1);
            }
            postData.mB(!postData.brD());
            ((PbFloorAgreeView) view).a(postData.brD(), postData.brC(), true);
            final int i = postData.brD() ? 0 : 1;
            this.eBC.aPQ().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pe(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).pF(i2);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void a(CustomDialogData customDialogData) {
                    com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), customDialogData);
                }
            });
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.ak aOg() {
        return new com.baidu.tbadk.core.util.ak("c12003").ac("tid", this.eBC.eFj).r("obj_type", 0).ac("fid", this.eBC.getForumId()).r("obj_param1", this.eBC.getPbData().aMW().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aOh() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eBC != null && this.eBC.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eBC.getPbData();
            if (pbData.aMU() != null) {
                sb.append("forum_name=").append(oK(pbData.aMU().getName()));
                sb.append("&");
            }
            if (pbData.aMW() != null) {
                bh aMW = pbData.aMW();
                sb.append("thread_id=").append(aMW.getId());
                sb.append("&");
                sb.append("thread_title=").append(oK(aMW.getTitle()));
                if (aMW.getAuthor() != null && aMW.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aMW.getAuthor().getPortrait());
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
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
                @Override // java.lang.Runnable
                public void run() {
                    int f;
                    int af = (com.baidu.adp.lib.util.l.af(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        f = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.f(PbActivity.this.getPageContext().getPageActivity(), d.f.ds120);
                    } else {
                        f = com.baidu.adp.lib.util.l.f(PbActivity.this.getPageContext().getPageActivity(), d.f.ds640);
                    }
                    int i = f - af;
                    if (i > 0) {
                        PbActivity.this.aOc().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aOc().aQO() != null) {
                        PbActivity.this.eBQ.Ct().setVisibility(8);
                        PbActivity.this.aOc().aQO().bF(str, str2);
                    }
                    PbActivity.this.aOc().aRD();
                }
            }, 500L);
        }
    }

    private String oK(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null && this.eBC != null && this.eBC.getPbData() != null && postData.brq() > 1) {
            String threadID = this.eBC.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.eBC.getPbData() != null) {
                i = this.eBC.getPbData().aNh();
            }
            b oO = oO(id);
            if (oO != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, postData.aTN(), this.eBC.getPbData().qa(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(oO.eDi, oO.eDj, oO.eDk, oO.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        ak akVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.l.no_network_guide);
            } else if (aOd() != null && aOd().getPbData() != null && aOd().getPbData().aNs() != null && !com.baidu.tieba.pb.f.T(aOd().getPbData().aMW())) {
                com.baidu.tieba.pb.data.l aNs = aOd().getPbData().aNs();
                if (view == null || !(view.getTag(d.h.pb_main_thread_praise_view) instanceof ak)) {
                    akVar = null;
                } else {
                    akVar = (ak) view.getTag(d.h.pb_main_thread_praise_view);
                }
                if (aNs != null) {
                    int i2 = -1;
                    if (z) {
                        aNs.oW(i);
                    } else if (aNs.aNA()) {
                        aNs.aNC();
                        i2 = 1;
                    } else {
                        aNs.oX(i);
                        i2 = 0;
                    }
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pe(int i3) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void a(CustomDialogData customDialogData) {
                            com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), customDialogData);
                        }
                    };
                    if (this.eBC != null && this.eBC.aPQ() != null) {
                        String str = "";
                        if (this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null) {
                            str = this.eBC.getPbData().aMW().rE();
                        }
                        if (this.eBC.getPbData() != null) {
                            this.eBC.getPbData().a(aNs);
                        }
                        if (z) {
                            this.eBC.aPQ().a(str, 3, i, this.eBC.getForumId(), aVar);
                        } else {
                            this.eBC.aPQ().a(str, i2, 3, i, this.eBC.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.eyR = i2;
                            kVar.eyS = aNs;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (akVar != null) {
                        akVar.b(aNs);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aOi() {
        if (this.eBC.getPbData() == null || this.eBC.getPbData().aMW() == null) {
            return -1;
        }
        return this.eBC.getPbData().aMW().rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOj() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.po(this.eBC.getForumId()) && this.eBC.getPbData() != null && this.eBC.getPbData().aMU() != null) {
            if (this.eBC.getPbData().aMU().isLike() == 1) {
                aOy();
                this.eBC.aPT().bI(this.eBC.getForumId(), this.eBC.getThreadID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iK(boolean z) {
        if (this.eBC == null || this.eBC.getPbData() == null) {
            return false;
        }
        return ((this.eBC.getPbData().aNh() != 0) || this.eBC.getPbData().aMW() == null || this.eBC.getPbData().aMW().getAuthor() == null || TextUtils.equals(this.eBC.getPbData().aMW().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aOk() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.o.q.Gq()) {
            return "";
        }
        PostData aNd = aNd();
        if (this.eBC == null || (pbData = this.eBC.getPbData()) == null || pbData.getUserData() == null || pbData.aMW() == null || aNd == null || aNd.getAuthor() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aNd.getAuthor().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aMW().qY() == 0) {
            return "";
        }
        if (pbData.aMW().qY() == 0) {
            return getPageContext().getString(d.l.fans_call);
        }
        return getPageContext().getString(d.l.haved_fans_call);
    }

    private boolean iL(boolean z) {
        if (z) {
            return true;
        }
        if (this.eBC == null || this.eBC.getPbData() == null) {
            return false;
        }
        return this.eBC.getPbData().aNh() != 0;
    }

    private boolean iM(boolean z) {
        return (z || this.eBC == null || this.eBC.getPbData() == null || this.eBC.getPbData().aNh() == 0) ? false : true;
    }

    public void aOl() {
        if (this.eBC != null && this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null && this.eBC.getPbData().aMW().getAuthor() != null) {
            if (this.eBE != null) {
                this.eBE.aQM();
            }
            bh aMW = this.eBC.getPbData().aMW();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aMW.getAuthor().getUserId());
            GodUserData godUserData = aMW.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            x xVar = new x();
            int aNh = this.eBC.getPbData().aNh();
            if (aNh == 1) {
                xVar.eHh = true;
                xVar.eHg = true;
                xVar.eHm = aMW.rj() == 1;
                xVar.eHl = aMW.rk() == 1;
            } else {
                xVar.eHh = false;
                xVar.eHg = false;
            }
            if (aNh == 1002 && !equals) {
                xVar.eHq = true;
            }
            xVar.eHd = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            xVar.eHi = iL(equals);
            xVar.eHj = aOm();
            xVar.eHk = iM(equals);
            xVar.eHe = this.eBC.aPs();
            xVar.eze = this.efH != null && this.efH.nz();
            xVar.eHc = iK(equals);
            xVar.eHo = aOk();
            xVar.eHa = equals && this.eBE.aRs();
            xVar.eHb = z;
            xVar.eHf = TbadkCoreApplication.getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            xVar.isHostOnly = this.eBC.getHostMode();
            xVar.eHn = false;
            if (aMW.rF() == null) {
                xVar.eHp = true;
            } else {
                xVar.eHp = false;
            }
            this.eBE.eIN.a(xVar);
        }
    }

    private boolean aOm() {
        if (this.eBC != null && this.eBC.aPs()) {
            return this.eBC.arn() == null || this.eBC.arn().qn() != 0;
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
        if (sparseArray != null && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null) {
            g(postData);
        }
    }

    public int aOn() {
        if (aOc() == null || aOc().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aOc().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) fVar).mType == com.baidu.tieba.pb.data.j.eyO) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aOo() {
        if (aOc() == null || aOc().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aOc().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.ggu) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aCc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cK(getResources().getString(d.l.mark_done));
            aVar.aw(true);
            aVar.cL(getResources().getString(d.l.mark_like));
            aVar.av(true);
            aVar.aq(false);
            aVar.b(getResources().getString(d.l.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ac("obj_id", metaData.getUserId()).r("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.l.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ac("obj_id", metaData.getUserId()).r("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.aoD.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.eBC.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).tb();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.eBE.aRl();
        this.eBC.iZ(z);
        if (this.efH != null) {
            this.efH.ac(z);
            if (markData != null) {
                this.efH.a(markData);
            }
        }
        if (this.eBC.nz()) {
            aOu();
        } else {
            this.eBE.n(this.eBC.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pa(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oL(String str) {
        if (!StringUtils.isNull(str) && this.eBC != null) {
            String threadID = this.eBC.getThreadID();
            String id = this.eBC.getPbData().aMU().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eBC.aPx()) {
                    antiData.setBlock_forum_name(this.eBC.getPbData().aMU().getName());
                    antiData.setBlock_forum_id(this.eBC.getPbData().aMU().getId());
                    antiData.setUser_name(this.eBC.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eBC.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.tF(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.agY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.agY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.agY));
            }
        } else if (i == 230277) {
            fS(str);
        } else {
            this.eBE.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eBE.a(0, bVar.Al, bVar.giP, z);
            if (bVar.Al) {
                if (bVar.giN == 1) {
                    ArrayList<PostData> aMY = this.eBC.getPbData().aMY();
                    int size = aMY.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aMY.get(i).getId())) {
                            i++;
                        } else {
                            aMY.remove(i);
                            break;
                        }
                    }
                    this.eBE.n(this.eBC.getPbData());
                } else if (bVar.giN == 0) {
                    aOp();
                } else if (bVar.giN == 2) {
                    ArrayList<PostData> aMY2 = this.eBC.getPbData().aMY();
                    int size2 = aMY2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aMY2.get(i2).brn().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aMY2.get(i2).brn().get(i3).getId())) {
                                i3++;
                            } else {
                                aMY2.get(i2).brn().remove(i3);
                                aMY2.get(i2).brp();
                                z2 = true;
                                break;
                            }
                        }
                        aMY2.get(i2).rO(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eBE.n(this.eBC.getPbData());
                    }
                    a(bVar, this.eBE);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eBE.a(this.eBD.getLoadDataMode(), fVar.Al, fVar.giP, false);
            if (fVar.Al) {
                this.eBG = true;
                if (i == 2 || i == 3) {
                    this.eBH = true;
                    this.eBI = false;
                } else if (i == 4 || i == 5) {
                    this.eBH = false;
                    this.eBI = true;
                }
                if (i == 2) {
                    this.eBC.getPbData().aMW().bU(1);
                    this.eBC.setIsGood(1);
                } else if (i == 3) {
                    this.eBC.getPbData().aMW().bU(0);
                    this.eBC.setIsGood(0);
                } else if (i == 4) {
                    this.eBC.getPbData().aMW().bT(1);
                    this.eBC.ia(1);
                } else if (i == 5) {
                    this.eBC.getPbData().aMW().bT(0);
                    this.eBC.ia(0);
                }
                this.eBE.c(this.eBC.getPbData(), this.eBC.aPs());
                if (this.eBC.getPbData().aNh() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void aOp() {
        if (this.eBC.aPt() || this.eBC.aPv()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eBC.getThreadID());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eBC.getThreadID()));
        if (aOv()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOq() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aNe;
        boolean z = true;
        if (this.eBE != null) {
            this.eBE.aCv();
        }
        if (this.eBC != null && this.eBC.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eBC.getPbData().aMW().getId();
            historyMessage.forumName = this.eBC.getPbData().aMU().getName();
            historyMessage.threadName = this.eBC.getPbData().aMW().getTitle();
            ArrayList<PostData> aMY = this.eBC.getPbData().aMY();
            int aRn = this.eBE != null ? this.eBE.aRn() : 0;
            if (aMY != null && aRn >= 0 && aRn < aMY.size()) {
                historyMessage.postID = aMY.get(aRn).getId();
            }
            historyMessage.isHostOnly = this.eBC.getHostMode();
            historyMessage.isSquence = this.eBC.aPs();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eBQ != null) {
            this.eBQ.onDestroy();
        }
        if (this.eBk && aOc() != null) {
            aOc().aRQ();
        }
        if (this.eBC != null && (this.eBC.aPt() || this.eBC.aPv())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eBC.getThreadID());
            if (this.eBG) {
                if (this.eBI) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eBC.aCm());
                }
                if (this.eBH) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eBC.getIsGood());
                }
            }
            if (this.eBC.getPbData() != null && System.currentTimeMillis() - this.eBo >= 40000 && (aNe = this.eBC.getPbData().aNe()) != null && !com.baidu.tbadk.core.util.v.u(aNe.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aNe);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eCc);
            }
            setResult(-1, intent);
        }
        if (aOv()) {
            if (this.eBC != null && this.eBE != null && this.eBE.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eBC.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aNc() && !this.eBv) {
                        ae aQz = ae.aQz();
                        com.baidu.tieba.pb.data.f pbData2 = this.eBC.getPbData();
                        Parcelable onSaveInstanceState = this.eBE.getListView().onSaveInstanceState();
                        boolean aPs = this.eBC.aPs();
                        boolean hostMode = this.eBC.getHostMode();
                        if (this.eBE.aQV() == null || this.eBE.aQV().getVisibility() != 0) {
                            z = false;
                        }
                        aQz.a(pbData2, onSaveInstanceState, aPs, hostMode, z);
                        if (this.eCb >= 0 || this.eBC.aPZ() != null) {
                            ae.aQz().k(this.eBC.aPZ());
                            ae.aQz().j(this.eBC.aQa());
                            ae.aQz().ps(this.eBC.aQb());
                        }
                    }
                }
            } else {
                ae.aQz().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eBE == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eBE.pv(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pb(int i) {
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
        this.eBQ.onActivityResult(i, i2, intent);
        if (this.eBz != null) {
            this.eBz.onActivityResult(i, i2, intent);
        }
        if (aOc().aQO() != null) {
            aOc().aQO().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aOt();
                    return;
                case 13008:
                    ae.aQz().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eBC != null) {
                                PbActivity.this.eBC.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eBC != null) {
                        a(aOs(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    L(intent);
                    return;
                case 24006:
                    S(intent);
                    return;
                case 24007:
                    if (aOi() == 1) {
                        aOr();
                    }
                    intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aOj();
                        return;
                    }
                    return;
                case 24008:
                    this.eBE.iI(false);
                    if (this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null && this.eBC.getPbData().aMW().rI() != null) {
                        this.eBC.getPbData().aMW().rI().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.eBE != null && this.eBE.eIN != null) {
                        this.eBE.eIN.of();
                        this.eBE.eIN.aSH();
                        if (this.eBC != null && this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null) {
                            this.eBC.getPbData().aMW().bP(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.eBA != null) {
                        this.eBE.bl(this.eBA);
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
                if (intent != null && aOc() != null && aNX() != null && aOc().aQQ() && com.baidu.tbadk.editortools.pb.a.CP().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.CP().setStatus(0);
                    if (this.eBE != null) {
                        this.eBE.aQP();
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
            if (this.eBz == null) {
                this.eBz = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eBz.b(this.aCw);
                this.eBz.c(this.aCE);
            }
            this.eBz.a(emotionImageData, aOd(), aOd().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOr() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null && this.eBC.getPbData().aMW().rz() != null && this.eBC.getPbData().aMW().rz().size() > 0 && this.eBC.getPbData().aMW().rz().get(0) != null) {
            this.mAwardActId = this.eBC.getPbData().aMW().rz().get(0).ph();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eBC.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void S(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    pd(2);
                    return;
                case 2:
                    this.eBE.aRc();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aOs() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bK = this.eBC.getPbData().bK(getPageContext().getPageActivity());
        PostData aQR = this.eBE.aQR();
        String str = "";
        if (aQR != null) {
            str = aQR.getId();
            String bX = aQR.bX(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(bX)) {
                bK[1] = bX;
            }
        }
        String rE = this.eBC.getPbData().aMW().rE();
        if (rE != null && rE.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bK[1]);
        shareFromPBMsgData.setImageUrl(bK[0]);
        shareFromPBMsgData.setForumName(this.eBC.getPbData().aMU().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eBC.getPbData().aMW().getId());
        shareFromPBMsgData.setTitle(this.eBC.getPbData().aMW().getTitle());
        return shareFromPBMsgData;
    }

    private void L(Intent intent) {
        a(aOs(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eBC != null && this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(getPageContext().getPageActivity());
            jVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(jVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.eBC != null && PbActivity.this.eBC.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ac = new com.baidu.tbadk.core.util.ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ac("fid", PbActivity.this.eBC.getForumId()).ac("tid", PbActivity.this.eBC.getThreadID());
                        if (PbActivity.this.d(PbActivity.this.eBC.getPbData()) != 0) {
                            ac.r("obj_type", PbActivity.this.d(PbActivity.this.eBC.getPbData()));
                        }
                        TiebaStatic.log(ac);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), jVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, jVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aOi() == 1) {
                        PbActivity.this.aOr();
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), jVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ar(true);
            aVar.b(getPageContext()).tb();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                jVar.I(shareFromPBMsgData.getImageUrl(), this.eBC.getPbData().aNi() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eBC != null && this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(getPageContext().getPageActivity());
            jVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(jVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), jVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", jVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aOi() == 1) {
                        PbActivity.this.aOr();
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), jVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ar(true);
            aVar.b(getPageContext()).tb();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                jVar.I(shareFromPBMsgData.getImageUrl(), this.eBC.getPbData().aNi() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOt() {
        MarkData pq;
        if (this.efH != null && (pq = this.eBC.pq(this.eBE.aRo())) != null) {
            if (!pq.isApp() || (pq = this.eBC.pq(this.eBE.aRo() + 1)) != null) {
                this.eBE.aRj();
                this.efH.a(pq);
                if (!this.efH.nz()) {
                    this.efH.nB();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.efH.nA();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOu() {
        com.baidu.tieba.pb.data.f pbData = this.eBC.getPbData();
        this.eBC.iZ(true);
        if (this.efH != null) {
            pbData.oG(this.efH.ny());
        }
        this.eBE.n(pbData);
    }

    private boolean aOv() {
        if (this.eBC == null) {
            return true;
        }
        if (this.eBC.nz()) {
            final MarkData aPF = this.eBC.aPF();
            if (aPF == null || !this.eBC.getIsFromMark()) {
                return true;
            }
            final MarkData pq = this.eBC.pq(this.eBE.aRn());
            if (pq == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aPF);
                setResult(-1, intent);
                return true;
            } else if (pq.getPostId() == null || pq.getPostId().equals(aPF.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aPF);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cL(getPageContext().getString(d.l.alert_update_mark));
                aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.efH != null) {
                            if (PbActivity.this.efH.nz()) {
                                PbActivity.this.efH.nA();
                                PbActivity.this.efH.ac(false);
                            }
                            PbActivity.this.efH.a(pq);
                            PbActivity.this.efH.ac(true);
                            PbActivity.this.efH.nB();
                        }
                        aPF.setPostId(pq.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aPF);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aOq();
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aPF);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aOq();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eBE != null && PbActivity.this.eBE.getView() != null) {
                            PbActivity.this.eBE.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aPF);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aOq();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.tb();
                return false;
            }
        } else if (this.eBC.getPbData() == null || this.eBC.getPbData().aMY() == null || this.eBC.getPbData().aMY().size() <= 0 || !this.eBC.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eBE == null) {
            return null;
        }
        return this.eBE.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Jc() {
        if (this.eBE == null) {
            return 0;
        }
        return this.eBE.aRw();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Jd() {
        if (this.aRQ == null) {
            this.aRQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: UY */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean oS = com.baidu.tbadk.core.h.oM().oS();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.e.common_color_10220));
                    if (oS) {
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
                        if (com.baidu.tbadk.core.h.oM().oS()) {
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
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.aRQ;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Je() {
        if (this.aRR == null) {
            this.aRR = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.aRR;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jf() {
        if (this.aRV == null) {
            this.aRV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aOQ */
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
        return this.aRV;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jg() {
        if (this.aRS == null) {
            this.aRS = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aCd */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.f.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aM */
                public void n(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aN */
                public View o(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aO */
                public View p(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aRS;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<RelativeLayout> Ji() {
        this.aRU = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aOR */
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
        return this.aRU;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wG() {
        if (this.aoc == null) {
            this.aoc = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoc;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eBs = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void V(Context context, String str) {
        if (ar.oY(str) && this.eBC != null && this.eBC.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").r("obj_param1", 1).ac("post_id", this.eBC.getThreadID()));
        }
        ar.aRT().f(getPageContext(), str);
        this.eBs = true;
    }

    private com.baidu.tbadk.core.dialog.a aOw() {
        if (this.eBn == null) {
            this.eBn = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eBn.cK(getPageContext().getString(d.l.download_baidu_video_dialog));
            this.eBn.a(getPageContext().getString(d.l.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.dG()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.ua());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.l.download_baidu_video));
                    }
                }
            });
            this.eBn.b(getPageContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eBn.aq(true);
            this.eBn.b(getPageContext());
            this.eBn.ar(false);
        }
        this.eBn.tb();
        return this.eBn;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void W(Context context, String str) {
        ar.aRT().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eBs = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra(VrPlayerActivityConfig.TITLE, "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            aOw();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eBs = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void X(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eBC.getPbData();
            TbRichText am = am(str, i);
            if (am != null && (tbRichTextData = am.Ix().get(this.eCC)) != null) {
                if (tbRichTextData.getType() == 20 || tbRichTextData.getType() == 17) {
                    bVar.eDm = true;
                    return;
                }
                bVar.eDi = new ArrayList<>();
                bVar.eDj = new ConcurrentHashMap<>();
                if (!tbRichTextData.ID().IP()) {
                    bVar.eDl = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.eDi.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = am.getPostId();
                    imageUrlData.mIsReserver = this.eBC.aPE();
                    imageUrlData.mIsSeeHost = this.eBC.getHostMode();
                    bVar.eDj.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aMU() != null) {
                            bVar.forumName = pbData.aMU().getName();
                            bVar.forumId = pbData.aMU().getId();
                        }
                        if (pbData.aMW() != null) {
                            bVar.threadId = pbData.aMW().getId();
                        }
                        bVar.eDk = pbData.aNi() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eDl = true;
                int size = pbData.aMY().size();
                this.eCD = false;
                bVar.index = -1;
                if (pbData.aNd() != null) {
                    PostData aNd = pbData.aNd();
                    TbRichText aBY = aNd.aBY();
                    if (!am.l(aNd)) {
                        i2 = a(aBY, am, i, i, bVar.eDi, bVar.eDj);
                    } else {
                        i2 = a(aNd, i, bVar.eDi, bVar.eDj);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aMY().get(i4);
                    if (postData.getId() == null || pbData.aNd() == null || pbData.aNd().getId() == null || !postData.getId().equals(pbData.aNd().getId())) {
                        TbRichText aBY2 = postData.aBY();
                        if (!am.l(postData)) {
                            i3 = a(aBY2, am, i3, i, bVar.eDi, bVar.eDj);
                        } else {
                            i3 = a(postData, i3, bVar.eDi, bVar.eDj);
                        }
                    }
                }
                if (bVar.eDi.size() > 0) {
                    bVar.lastId = bVar.eDi.get(bVar.eDi.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aMU() != null) {
                        bVar.forumName = pbData.aMU().getName();
                        bVar.forumId = pbData.aMU().getId();
                    }
                    if (pbData.aMW() != null) {
                        bVar.threadId = pbData.aMW().getId();
                    }
                    bVar.eDk = pbData.aNi() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ID() == null) {
            return null;
        }
        return tbRichTextData.ID().IT();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ID() == null) {
            return 0L;
        }
        return tbRichTextData.ID().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ID() == null) {
            return false;
        }
        return tbRichTextData.ID().IU();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ID() == null) {
            return false;
        }
        return tbRichTextData.ID().IV();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo ID;
        if (tbRichText == tbRichText2) {
            this.eCD = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Ix().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Ix().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ag = (int) com.baidu.adp.lib.util.l.ag(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.ID().getWidth() * ag;
                    int height = ag * tbRichTextData.ID().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.ID().IP()) {
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
                            if (tbRichTextData != null && (ID = tbRichTextData.ID()) != null) {
                                String IR = ID.IR();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = IR;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eBC.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eBC.aPE();
                                imageUrlData.mIsSeeHost = this.eBC.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eCD) {
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
        com.baidu.tieba.tbadkCore.data.h bry;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bqU;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bqU = (bry = postData.bry()).bqU()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bqU.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bqU.get(i3);
                if (jVar != null) {
                    String bqZ = jVar.bqZ();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bqZ)) {
                        arrayList.add(bqZ);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bqZ;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bqY();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eBC.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eBC.aPE();
                        imageUrlData.mIsSeeHost = this.eBC.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bry.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bqZ, imageUrlData);
                        }
                        if (!this.eCD) {
                            i++;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    protected void g(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.eBC.rx())) {
                z = true;
            }
            MarkData i = this.eBC.i(postData);
            if (i != null) {
                this.eBE.aRj();
                if (this.efH != null) {
                    this.efH.a(i);
                    if (!z) {
                        this.efH.nB();
                    } else {
                        this.efH.nA();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText am(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eBC == null || this.eBC.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eBC.getPbData();
        if (pbData.aNd() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aNd());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aMY = pbData.aMY();
            a(pbData, aMY);
            return a(aMY, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aNg() != null && fVar.aNg().ezg != null && (list = fVar.aNg().ezg) != null && arrayList != null) {
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

    private long oM(String str) {
        ArrayList<PostData> aMY;
        com.baidu.tieba.pb.data.f pbData = this.eBC.getPbData();
        if (pbData != null && (aMY = pbData.aMY()) != null && !aMY.isEmpty()) {
            Iterator<PostData> it = aMY.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bry = next.bry();
                if (bry != null && bry.ggc) {
                    Iterator<TbRichTextData> it2 = next.aBY().Ix().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IM().getLink().equals(str)) {
                            return bry.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Ix;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText aBY = arrayList.get(i2).aBY();
            if (aBY != null && (Ix = aBY.Ix()) != null) {
                int size = Ix.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Ix.get(i4) != null && Ix.get(i4).getType() == 8) {
                        i3++;
                        if (Ix.get(i4).ID().IR().equals(str)) {
                            int ag = (int) com.baidu.adp.lib.util.l.ag(TbadkCoreApplication.getInst());
                            int width = Ix.get(i4).ID().getWidth() * ag;
                            int height = Ix.get(i4).ID().getHeight() * ag;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eCC = i4;
                            return aBY;
                        } else if (i3 <= i) {
                            i4++;
                            i3 = i3;
                        }
                    } else {
                        if (Ix.get(i4) != null && Ix.get(i4).IJ() != null && (Ix.get(i4).getType() == 20 || Ix.get(i4).getType() == 17)) {
                            i3++;
                            MemeInfo memeInfo = Ix.get(i4).IJ().memeInfo;
                            if (memeInfo == null || TextUtils.isEmpty(memeInfo.pic_url)) {
                                return null;
                            }
                            if (memeInfo.pic_url.equals(str)) {
                                this.eCC = i4;
                                return aBY;
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
    public void g(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.eAQ = str;
            if (this.eBm == null) {
                aOf();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eBm.cj(1).setVisibility(8);
            } else {
                this.eBm.cj(1).setVisibility(0);
            }
            this.eBm.te();
            this.eBs = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cqg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCc() {
        hideNetRefreshView(this.eBE.getView());
        aOx();
        if (this.eBC.ET()) {
            this.eBE.aRj();
        }
    }

    private void aOx() {
        showLoadingView(this.eBE.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds400));
        View En = getLoadingView().En();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) En.getLayoutParams();
        layoutParams.addRule(3, this.eBE.aRI().getId());
        En.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahc() {
        if (this.cqg != null) {
            this.cqg.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void pd(int i) {
        boolean z;
        String str;
        Uri parse;
        if (this.eBC.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eBC.getPbData();
            pbData.aMU().getName();
            String title = pbData.aMW().getTitle();
            int i2 = this.eBC.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aMU() != null) {
                if ((pbData.aMU().isLike() == 1) && AddExperiencedModel.po(pbData.getForumId())) {
                    z = true;
                    String str2 = "http://tieba.baidu.com/p/" + this.eBC.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bK = pbData.bK(getPageContext().getPageActivity());
                    str = bK[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    String str3 = bK[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aOi() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ac("fid", pbData.getForumId()).ac("tid", pbData.getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                    } else if (aOi() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ac("fid", pbData.getForumId()).ac("tid", pbData.getThreadId()).ac(SapiAccountManager.SESSION_UID, currentAccount));
                    }
                    String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, str3);
                    final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
                    dVar.title = title;
                    dVar.content = format;
                    dVar.linkUrl = str2;
                    dVar.atm = true;
                    dVar.atq = z;
                    dVar.extData = this.eBC.getThreadID();
                    dVar.atB = 3;
                    dVar.atA = i;
                    dVar.fid = this.eBC.getForumId();
                    dVar.WT = this.eBC.getThreadID();
                    dVar.atC = d(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.atv = parse;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.atB);
                    bundle.putInt("obj_type", dVar.atC);
                    bundle.putString("fid", dVar.fid);
                    bundle.putString("tid", dVar.WT);
                    bundle.putString(SapiAccountManager.SESSION_UID, dVar.uid);
                    dVar.e(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setIsCopyLink(true);
                    if (TbadkCoreApplication.isLogin()) {
                        shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 23007)));
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10125").ac("tid", PbActivity.this.eBC.getThreadID()).ac("fid", PbActivity.this.eBC.getForumId()).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                                PbActivity.this.wA();
                            }
                        });
                    }
                    shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            dVar.linkUrl = com.baidu.tbadk.coreExtra.d.e.aj(dVar.linkUrl, dVar.WT);
                            com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                            PbActivity.this.wA();
                        }
                    });
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
                }
            }
            z = false;
            String str22 = "http://tieba.baidu.com/p/" + this.eBC.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bK2 = pbData.bK(getPageContext().getPageActivity());
            str = bK2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            String str32 = bK2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aOi() != 1) {
            }
            String format2 = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, str32);
            final com.baidu.tbadk.coreExtra.d.d dVar2 = new com.baidu.tbadk.coreExtra.d.d();
            dVar2.title = title;
            dVar2.content = format2;
            dVar2.linkUrl = str22;
            dVar2.atm = true;
            dVar2.atq = z;
            dVar2.extData = this.eBC.getThreadID();
            dVar2.atB = 3;
            dVar2.atA = i;
            dVar2.fid = this.eBC.getForumId();
            dVar2.WT = this.eBC.getThreadID();
            dVar2.atC = d(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.atB);
            bundle2.putInt("obj_type", dVar2.atC);
            bundle2.putString("fid", dVar2.fid);
            bundle2.putString("tid", dVar2.WT);
            bundle2.putString(SapiAccountManager.SESSION_UID, dVar2.uid);
            dVar2.e(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setIsCopyLink(true);
            if (TbadkCoreApplication.isLogin()) {
            }
            shareDialogConfig2.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar2.linkUrl = com.baidu.tbadk.coreExtra.d.e.aj(dVar2.linkUrl, dVar2.WT);
                    com.baidu.adp.lib.util.a.aw(dVar2.linkUrl);
                    com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                    PbActivity.this.wA();
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aMW() != null) {
            if (fVar.aMW().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aMW().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void aOy() {
        com.baidu.tbadk.util.t.a(new com.baidu.tbadk.util.s<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.s
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pp(PbActivity.this.eBC.getForumId()));
            }
        }, new com.baidu.tbadk.util.g<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eBE.aRR();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.anm == null) {
                this.anm = new ShareReportModel(getPageContext());
            }
            this.anm.j(shareItem.fid, shareItem.WT, shareItem.ats);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Jh() {
        if (this.aRT == null) {
            this.aRT = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aOS */
                public LinearLayout fI() {
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
        return this.aRT;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eBE.aRd() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac("fid", this.eBC.getPbData().getForumId()));
            } else {
                bh aMW = this.eBC.getPbData().aMW();
                if (view != null) {
                    boolean z = aMW.re() == null || aMW.re().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eCo > 1000) {
                            this.eCp = true;
                            bg(view);
                        } else {
                            this.eCp = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            l(view, this.eCp);
                        } else {
                            k(view, this.eCp);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        k(view, this.eCp);
                    } else if (motionEvent.getAction() == 3) {
                        k(view, this.eCp);
                    }
                }
            }
        }
        return false;
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eCo = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void l(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eCo = System.currentTimeMillis();
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

    public void ahd() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11017)));
        } else if (aVar.td() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.td();
            int intValue = ((Integer) sparseArray.get(an.eKD)).intValue();
            if (intValue == an.eKE) {
                if (!this.eBD.bsc()) {
                    this.eBE.aRg();
                    int intValue2 = ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue();
                    this.eBD.a(this.eBC.getPbData().aMU().getId(), this.eBC.getPbData().aMU().getName(), this.eBC.getPbData().aMW().getId(), (String) sparseArray.get(d.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.eKF || intValue == an.eKH) {
                if (this.eBC.aPP() != null) {
                    this.eBC.aPP().ph(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.eKF) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == an.eKG) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eCI).pc()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eBV);
        userMuteAddAndDelCustomMessage.setTag(this.eBV);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean oN(String str) {
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

    public void iN(boolean z) {
        this.eBL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aOz() {
        ArrayList<PostData> aMY;
        int t;
        if (this.eBC == null || this.eBC.getPbData() == null || this.eBC.getPbData().aMY() == null || (t = com.baidu.tbadk.core.util.v.t((aMY = this.eBC.getPbData().aMY()))) == 0) {
            return "";
        }
        if (this.eBC.aPE()) {
            Iterator<PostData> it = aMY.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.brq() == 1) {
                    return next.getId();
                }
            }
        }
        int aRn = this.eBE.aRn();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aMY, aRn);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eBC.oR(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aRn - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aMY, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eBC.oR(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aRn + 1; i2 < t; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aMY, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eBC.oR(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (av.vA().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(oM(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eBC.getPbData().aMU().getId(), this.eBC.getPbData().aMU().getName(), this.eBC.getPbData().aMW().getTid());
            }
            this.eBs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cL(getResources().getString(d.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cL(getResources().getString(d.l.make_sure_hide));
        }
        aVar.a(getResources().getString(d.l.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eBC.aPO() != null) {
                    PbActivity.this.eBC.aPO().cn(j);
                }
            }
        });
        aVar.b(getResources().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.ar(false);
        aVar.b(getPageContext());
        aVar.tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b oO(String str) {
        String str2;
        if (this.eBC.getPbData() == null || this.eBC.getPbData().aMY() == null || this.eBC.getPbData().aMY().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i >= this.eBC.getPbData().aMY().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eBC.getPbData().aMY().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eBC.getPbData().aMY().get(i);
        if (postData.aBY() == null || postData.aBY().Ix() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aBY().Ix().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.ID() != null) {
                    str2 = next.ID().IR();
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
        if (this.eBi) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eBi = false;
        } else if (aOA()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eBi) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eBi = false;
        } else if (aOA()) {
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
        if (pageStayDurationItem != null && this.eBC != null) {
            if (this.eBC.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eBC.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eBC.getThreadID(), 0L));
            if (this.eBt) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aOA() {
        return (!this.eBg && this.eCK == -1 && this.eCL == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eCN = nVar;
            this.eBg = true;
            this.eBE.aQW();
            this.eBE.oW(this.eCM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOB() {
        if (this.eCN != null) {
            if (this.eCK == -1) {
                showToast(d.l.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eCN.getCartoonId(), this.eCK, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOC() {
        if (this.eCN != null) {
            if (this.eCL == -1) {
                showToast(d.l.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eCN.getCartoonId(), this.eCL, 0)));
                finish();
            }
        }
    }

    public int aOD() {
        return this.eCK;
    }

    public int aOE() {
        return this.eCL;
    }

    private void aqI() {
        if (this.eBC != null && this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null && this.eBC.getPbData().aMW().sb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aOF() {
        if (this.eBC != null && this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null && this.eBC.getPbData().aMW().sb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aOG() {
        if (this.eBj) {
            this.eBy = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null && this.eBC.getPbData().aMW().qV() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eBC.getPbData().aMW().qV().getThreadId(), this.eBC.getPbData().aMW().qV().getTaskId(), this.eBC.getPbData().aMW().qV().getForumId(), this.eBC.getPbData().aMW().qV().getForumName(), this.eBC.getPbData().aMW().rj(), this.eBC.getPbData().aMW().rk())));
            this.eBi = true;
            finish();
        }
    }

    public boolean aOH() {
        return this.eBj;
    }

    public String aOI() {
        return this.eBw;
    }

    public PbInterviewStatusView.a aOJ() {
        return this.eBB;
    }

    public void iO(boolean z) {
        this.eBx = z;
    }

    public boolean aOK() {
        if (this.eBC != null) {
            return this.eBC.aPt();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cL(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eBT).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eBT.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eBT).tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eBT != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eBT.getPageActivity());
            aVar.cL(str);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eBT).tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eBE.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eBT.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cL(this.eBT.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cL(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eBE.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eBT).tb();
    }

    public void aOM() {
        if (this.eBC != null && this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null && this.eBC.getPbData().aMW().ss() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cc(d.l.channel_open_push_message);
            aVar.a(d.l.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eBC.getPbData().aMW().ss().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.l.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.tb();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ar.oY(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_pb_wenxue)) != null) {
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
            this.cui = true;
        } else {
            this.cui = false;
        }
        if (this.eBE != null) {
            this.eBE.onConfigurationChanged(configuration);
        }
        if (this.eBJ != null) {
            this.eBJ.dismiss();
        }
    }

    public boolean aON() {
        if (this.eBC != null) {
            return this.eBC.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.eBC.getPbData().aNg().ezg;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).brn().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).brn().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).brn().remove(i2);
                    list.get(i).brp();
                    z = true;
                    break;
                }
            }
            list.get(i).rO(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.n(this.eBC.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aNF().getId();
        List<PostData> list = this.eBC.getPbData().aNg().ezg;
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
                ArrayList<PostData> aNJ = mVar.aNJ();
                postData.tz(mVar.getTotalCount());
                if (postData.brn() != null) {
                    postData.brn().clear();
                    postData.brn().addAll(aNJ);
                }
            }
        }
        if (!this.eBC.getIsFromMark()) {
            this.eBE.n(this.eBC.getPbData());
        }
    }

    public boolean aOO() {
        boolean z = true;
        if (this.eBC == null) {
            return false;
        }
        switch (this.eBC.aPX()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eBC.getPbData() != null && this.eBC.getPbData().aMW() != null && this.eBC.getPbData().aMW().sA() && StringUtils.isNull(this.eBC.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aOP() {
        if (this.eBE != null) {
            this.eBE.aQM();
            ahd();
        }
    }

    public PostData aNd() {
        return this.eBE.b(this.eBC.eFA, this.eBC.aPs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.isLinkThread()) {
                return 3;
            }
            if (bhVar.su()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }
}
