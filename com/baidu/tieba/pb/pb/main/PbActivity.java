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
    private com.baidu.adp.lib.e.b<ImageView> aSd;
    private com.baidu.adp.lib.e.b<TextView> aSe;
    private com.baidu.adp.lib.e.b<View> aSf;
    private com.baidu.adp.lib.e.b<LinearLayout> aSg;
    private com.baidu.adp.lib.e.b<RelativeLayout> aSh;
    private com.baidu.adp.lib.e.b<GifView> aSi;
    private ShareReportModel any;
    private com.baidu.adp.lib.e.b<TbImageView> aoo;
    private com.baidu.tbadk.h.a cqL;
    private VoiceManager cqs;
    private com.baidu.tieba.e.b ctE;
    private com.baidu.tbadk.core.dialog.a eBB;
    private boolean eBH;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eBN;
    private View eBO;
    private u eBX;
    private boolean eBZ;
    private String eBe;
    private com.baidu.tieba.pb.pb.main.a.b eBv;
    private boolean eCO;
    private com.baidu.tieba.tbadkCore.data.e eCc;
    private com.baidu.tbadk.editortools.pb.d eCd;
    private com.baidu.tbadk.editortools.pb.c eCe;
    private com.baidu.adp.base.e eCh;
    private com.baidu.tbadk.core.view.c eCi;
    private BdUniqueId eCj;
    private Runnable eCk;
    private aq eCl;
    private com.baidu.adp.widget.ImageView.a eCm;
    private String eCn;
    private TbRichTextMemeInfo eCo;
    private String eDa;
    private com.baidu.tbadk.core.data.n eDb;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eBu = false;
    private boolean eBw = false;
    private boolean eBx = false;
    private boolean eiF = false;
    private boolean eBy = true;
    private int eBz = 0;
    private com.baidu.tbadk.core.dialog.b eBA = null;
    private long cde = -1;
    private long aJm = 0;
    private long eBC = 0;
    private long createTime = 0;
    private long aJe = 0;
    private boolean eBD = false;
    private com.baidu.tbadk.k.d eBE = null;
    private long eBF = 0;
    private boolean eBG = false;
    private long eBI = 0;
    private String aCF = null;
    private boolean eBJ = false;
    private boolean cuu = false;
    private String eBK = "";
    private boolean eBL = true;
    private boolean eBM = false;
    private String source = "";
    private PbInterviewStatusView.a eBP = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eBS.jt(!PbActivity.this.eBL);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.nG()) {
                        PbActivity.this.aOz();
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahm));
        }
    };
    private PbModel eBQ = null;
    private com.baidu.tbadk.baseEditMark.a efV = null;
    private ForumManageModel eBR = null;
    private com.baidu.tbadk.coreExtra.c.a aoP = null;
    private an eBS = null;
    public final com.baidu.tieba.pb.pb.main.a.a eBT = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eBU = false;
    private boolean eBV = false;
    private boolean eBW = false;
    private boolean eBY = false;
    private boolean eCa = false;
    private boolean eCb = false;
    private boolean eCf = false;
    private com.baidu.tbadk.editortools.pb.b aCJ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public void CW() {
            PbActivity.this.showProgressBar();
        }
    };
    private boolean eCg = false;
    private int mLastScrollState = -1;
    private boolean cqX = false;
    private int eCp = 0;
    private int eCq = -1;
    private final v.a eCr = new v.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tieba.pb.pb.main.v.a
        public void A(List<PostData> list) {
            if (PbActivity.this.eBQ.getPbData().aNl() != null) {
                List<PostData> list2 = PbActivity.this.eBQ.getPbData().aNl().ezu;
                int size = list2.size();
                if (!com.baidu.tbadk.core.util.v.u(list2)) {
                    PbActivity.this.eBQ.getPbData().aNl().ezu.addAll(size, list);
                }
                PbActivity.this.eBQ.a(PbActivity.this.eBQ.getPbData(), size);
            }
            PbActivity.this.eBS.aRj().a(PbActivity.this.eBQ.getPbData(), true);
            if (PbActivity.this.eBS != null && PbActivity.this.eBS.aRj() != null) {
                PbActivity.this.eBS.aRj().notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.v.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eBS.showToast(str);
            }
        }
    };
    private final CustomMessageListener eCs = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eBQ != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eCe != null) {
                    PbActivity.this.eBS.hg(PbActivity.this.eCe.Df());
                }
                PbActivity.this.eBS.aQU();
                PbActivity.this.eBS.aCA();
            }
        }
    };
    CustomMessageListener crn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                PbActivity.this.eBQ.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                if (PbActivity.this.eBS != null && PbActivity.this.eBQ != null) {
                    PbActivity.this.eBS.d(PbActivity.this.eBQ.getPbData(), PbActivity.this.eBQ.aPx(), PbActivity.this.eBQ.aPO());
                }
                if (PbActivity.this.eBS != null && PbActivity.this.eBS.aRj() != null) {
                    PbActivity.this.eBS.aRj().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eCt = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eBS != null) {
                    if (booleanValue) {
                        PbActivity.this.eBS.axb();
                    } else {
                        PbActivity.this.eBS.axa();
                    }
                }
            }
        }
    };
    private CustomMessageListener dOA = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eCe != null) {
                    PbActivity.this.eBS.hg(PbActivity.this.eCe.Df());
                }
                PbActivity.this.eBS.hh(false);
            }
        }
    };
    private CustomMessageListener dOW = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
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
    private CustomMessageListener eCu = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eBS != null && PbActivity.this.eBS.aRj() != null) {
                PbActivity.this.eBS.aRj().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener doe = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a eCv = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void j(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.pd(2);
                ae.aQE().reset();
                PbActivity.this.eBQ.aPP();
                boolean z2 = false;
                ArrayList<PostData> aNd = PbActivity.this.eBQ.getPbData().aNd();
                if (aNd != null) {
                    Iterator<PostData> it = aNd.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (am.l(next) && next.brG().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eBS.n(PbActivity.this.eBQ.getPbData());
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
    private View.OnClickListener dOz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aCF);
        }
    };
    CustomMessageListener cYs = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eCw = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                aq.a aVar = new aq.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.Wy = abVar.Wy;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBQ.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eBQ.aPF() != null && PbActivity.this.eBQ.aPF().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eBS.a(abVar.sendCount, PbActivity.this.eBQ.getPbData(), PbActivity.this.eBQ.aPx(), PbActivity.this.eBQ.aPO());
                    }
                    if (pbData.aNd() != null && pbData.aNd().size() >= 1 && pbData.aNd().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aNd().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eBQ.getThreadID(), 0L);
                        if (c2 == abVar.postId && c3 == abVar.threadId) {
                            com.baidu.tbadk.core.data.aq brF = pbData.aNd().get(0).brF();
                            if (brF == null) {
                                brF = new com.baidu.tbadk.core.data.aq();
                            }
                            ArrayList<aq.a> qw = brF.qw();
                            if (qw == null) {
                                qw = new ArrayList<>();
                            }
                            qw.add(0, aVar);
                            brF.bO(abVar.sendCount + brF.qv());
                            brF.g(qw);
                            pbData.aNd().get(0).a(brF);
                            PbActivity.this.eBS.aRj().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eCx = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.adD() != null && !aVar.adD().isEmpty()) {
                    PbActivity.this.eBS.a(aVar, PbActivity.this.eCz);
                }
                PbActivity.this.eBS.a(aVar, PbActivity.this.eBQ.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.aSi()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a eCy = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void A(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.u(list) && PbActivity.this.eBS != null) {
                PbActivity.this.eBS.cv(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eCz = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aU(PbActivity.this.getPageContext().getPageActivity());
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
    private boolean eCA = false;
    private PraiseModel eCB = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hL(String str) {
            PbActivity.this.eCA = false;
            if (PbActivity.this.eCB != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBQ.getPbData();
                if (pbData.aNb().rl().getIsLike() == 1) {
                    PbActivity.this.jz(0);
                } else {
                    PbActivity.this.jz(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aNb()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void A(int i, String str) {
            PbActivity.this.eCA = false;
            if (PbActivity.this.eCB != null && str != null) {
                if (AntiHelper.tG(i)) {
                    AntiHelper.at(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eCC = 0;
    private boolean eCD = true;
    private b.a eCE = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void iQ(boolean z) {
            PbActivity.this.iP(z);
            if (PbActivity.this.eBS.aRM() != null && z) {
                PbActivity.this.eBS.jt(false);
            }
            PbActivity.this.eBS.jw(z);
        }
    };
    private CustomMessageListener aoT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().arE != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().arE, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahm));
                        }
                    } else if (updateAttentionMessage.getData().BY) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aNi().getAuthor() != null && PbActivity.this.aNi().getAuthor().getGodUserData() != null) {
                            PbActivity.this.aNi().getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBQ.getPbData().aNb() != null && PbActivity.this.eBQ.getPbData().aNb().getAuthor() != null) {
                            PbActivity.this.eBQ.getPbData().aNb().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a brQ = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eBS.Sv();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.pe(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.aor();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.l.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aSx = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eBS.aQV()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && ((PbActivity.this.eBQ == null || PbActivity.this.eBQ.getPbData() == null || !com.baidu.tieba.pb.f.T(PbActivity.this.eBQ.getPbData().aNb())) && PbActivity.this.eBQ != null && (PbActivity.this.eBQ.getPbData() != null || PbActivity.this.eBQ.getPbData().aNx() != null))) {
                    if (PbActivity.this.eBQ.getPbData().aNx().aNF()) {
                        if (PbActivity.this.eBQ.getPbData().aNx().ezf == 1 || PbActivity.this.eBQ.getPbData().aNx().ezf == 3 || PbActivity.this.eBQ.getPbData().aNx().ezf == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eBQ.getPbData().aNx().aNF() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eBQ.getPbData().aNx().aNF() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eBI > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).jY(false);
                        PbActivity.this.eBI = System.currentTimeMillis();
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
                    if (PbActivity.this.eBS != null && PbActivity.this.eBS.aOj() && (view.getId() == d.h.pb_head_user_info_root || view == PbActivity.this.eBS.aRT())) {
                        if (view.getTag(d.h.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ad("obj_id", (String) view.getTag(d.h.tag_user_id)));
                        }
                        if (PbActivity.this.eBT != null && PbActivity.this.eBT.ePd != null) {
                            PbActivity.this.eBT.ePd.onClick(view);
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
            if (PbActivity.this.eCe != null) {
                PbActivity.this.eBS.hg(PbActivity.this.eCe.Df());
            }
            PbActivity.this.eBS.aQU();
            PbActivity.this.eBS.aCA();
            return true;
        }
    });
    private CustomMessageListener eCF = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eCj) {
                PbActivity.this.eBS.Sv();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBQ.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aNo().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eCi.c(PbActivity.this.eCh.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eCh.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    PbActivity.this.fT(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aOQ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eCh.getResources().getString(d.l.mute_fail);
                    }
                    PbActivity.this.eCi.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eCG = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eCj) {
                PbActivity.this.eBS.Sv();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eCi.c(PbActivity.this.eCh.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eCh.getResources().getString(d.l.un_mute_fail);
                }
                PbActivity.this.eCi.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eCH = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eCj) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eBS.Sv();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gtO;
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
                    PbActivity.this.eBS.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eCI = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eBS.aQV() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aOi() != null && PbActivity.this.aOi().getPbData() != null && PbActivity.this.aOi().getPbData().aNx() != null && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.T(PbActivity.this.aOi().getPbData().aNb())) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aNF = PbActivity.this.aOi().getPbData().aNx().aNF();
                if (intValue < 10) {
                    if (aNF) {
                        if (PbActivity.this.eBQ.getPbData().aNx().ezf == 1 || PbActivity.this.eBQ.getPbData().aNx().ezf == 3 || PbActivity.this.eBQ.getPbData().aNx().ezf == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eBQ.getPbData().aNx().aNF() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aNF ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eBI > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).jY(false);
                        PbActivity.this.eBI = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue / 11, aNF);
                TiebaStatic.log(PbActivity.this.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aNF ? 0 : 1));
            }
        }
    };
    private CustomMessageListener crx = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cqX = true;
                }
            }
        }
    };
    public a.b eqW = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.ahi();
            com.baidu.tbadk.core.data.ap ars = PbActivity.this.eBQ.ars();
            int pageNum = PbActivity.this.eBS.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.l.pb_page_error);
            } else if (ars == null || pageNum <= ars.qo()) {
                PbActivity.this.eBS.aCA();
                PbActivity.this.pd(2);
                PbActivity.this.ahh();
                PbActivity.this.eBS.aRo();
                if (com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.eBQ.pk(PbActivity.this.eBS.getPageNum());
                    if (PbActivity.this.eBv != null) {
                        PbActivity.this.eBv.showFloatingView();
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
    public final View.OnClickListener crU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
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
            com.baidu.tieba.pb.data.l aNx;
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
                    if ((PbActivity.this.eBS.eJb.aSN() != null && PbActivity.this.eBS.eJb.aSN().bj(view)) || PbActivity.this.eBS.aRi() == view || view.getId() == d.h.pb_item_tail_content) {
                        if (PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && com.baidu.tieba.pb.f.T(PbActivity.this.eBQ.getPbData().aNb())) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (view == PbActivity.this.eBS.getNextView()) {
                        if (!PbActivity.this.mIsLoading && PbActivity.this.eBQ.iY(true)) {
                            PbActivity.this.mIsLoading = true;
                            PbActivity.this.eBS.aRp();
                        }
                    } else if (PbActivity.this.eBS.eJb.aSN() == null || view != PbActivity.this.eBS.eJb.aSN().aQx()) {
                        if (view == PbActivity.this.eBS.eJb.aLh) {
                            if (PbActivity.this.eBS.jy(PbActivity.this.eBQ.aPC())) {
                                PbActivity.this.ahh();
                                return;
                            }
                            PbActivity.this.eBy = false;
                            PbActivity.this.eBw = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eBS.aRm() && (PbActivity.this.eBS.eJb.aSN() == null || (view != PbActivity.this.eBS.eJb.aSN().aQw() && view != PbActivity.this.eBS.eJb.aSN().aQu()))) {
                            if (view == PbActivity.this.eBS.aRE()) {
                                if (PbActivity.this.eBQ != null) {
                                    com.baidu.tbadk.browser.a.T(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBQ.getPbData().aNb().ru().getLink());
                                }
                            } else if (view != PbActivity.this.eBS.eJb.ePN && view.getId() != d.h.view_forum_name_first_floor) {
                                if (view == PbActivity.this.eBS.eJb.ePO) {
                                    if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null) {
                                        ArrayList<PostData> aNd = PbActivity.this.eBQ.getPbData().aNd();
                                        if ((aNd == null || aNd.size() <= 0) && PbActivity.this.eBQ.aPx()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ad("tid", PbActivity.this.eBQ.getThreadID()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("fid", PbActivity.this.eBQ.getForumId()));
                                        if (!PbActivity.this.eBS.aRU()) {
                                            PbActivity.this.eBS.aQU();
                                        }
                                        PbActivity.this.aOq();
                                        return;
                                    }
                                    com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                } else if (view.getId() != d.h.pb_god_user_tip_content) {
                                    if (PbActivity.this.eBS.eJb.aSN() == null || view != PbActivity.this.eBS.eJb.aSN().aQh()) {
                                        if ((PbActivity.this.eBS.eJb.aSN() == null || view != PbActivity.this.eBS.eJb.aSN().aQt()) && view.getId() != d.h.floor_owner_reply && view.getId() != d.h.reply_title) {
                                            if (PbActivity.this.eBS.eJb.aSN() == null || (view != PbActivity.this.eBS.eJb.aSN().getCancelView() && view != PbActivity.this.eBS.eJb.aSN().aQs())) {
                                                if (view != PbActivity.this.eBS.eJb.ePP && (PbActivity.this.eBS.eJb.aSN() == null || view != PbActivity.this.eBS.eJb.aSN().aQD())) {
                                                    if (PbActivity.this.eBS.eJb.aSN() != null && view == PbActivity.this.eBS.eJb.aSN().aQp()) {
                                                        PbActivity.this.eBS.aCA();
                                                        if (PbActivity.this.eBQ.ars() != null) {
                                                            PbActivity.this.eBS.a(PbActivity.this.eBQ.ars(), PbActivity.this.eqW);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        return;
                                                    } else if (view.getId() == d.h.pb_sort) {
                                                        PbActivity.this.eBS.aCA();
                                                        if (com.baidu.adp.lib.util.j.hh()) {
                                                            if (PbActivity.this.mIsLoading) {
                                                                view.setTag(Boolean.valueOf(PbActivity.this.eBQ.aPJ()));
                                                                return;
                                                            }
                                                            PbActivity.this.pd(2);
                                                            PbActivity.this.ahh();
                                                            PbActivity.this.eBS.aRo();
                                                            PbActivity.this.eBS.aRj().iR(true);
                                                            boolean aPI = PbActivity.this.eBQ.aPI();
                                                            view.setTag(Boolean.valueOf(PbActivity.this.eBQ.aPJ()));
                                                            TiebaStatic.log("c12097");
                                                            if (aPI) {
                                                                PbActivity.this.mIsLoading = true;
                                                                PbActivity.this.eBS.jq(true);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                        return;
                                                    } else if (PbActivity.this.eBS.eJb.aSN() == null || view != PbActivity.this.eBS.eJb.aSN().aQq()) {
                                                        if (PbActivity.this.eBS.eJb.aSN() == null || view != PbActivity.this.eBS.eJb.aSN().aQr()) {
                                                            if (PbActivity.this.eBX == null || view != PbActivity.this.eBX.aQj()) {
                                                                if (PbActivity.this.eBX == null || view != PbActivity.this.eBX.aQh()) {
                                                                    if (PbActivity.this.eBX == null || view != PbActivity.this.eBX.aQm()) {
                                                                        if (PbActivity.this.eBX == null || view != PbActivity.this.eBX.aQk()) {
                                                                            if (PbActivity.this.eBX == null || view != PbActivity.this.eBX.aQl()) {
                                                                                if (PbActivity.this.eBS.aRM() == view) {
                                                                                    if (PbActivity.this.eBS.aRM().getIndicateStatus()) {
                                                                                        com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBQ.getPbData();
                                                                                        if (pbData != null && pbData.aNb() != null && pbData.aNb().rc() != null) {
                                                                                            String pD = pbData.aNb().rc().pD();
                                                                                            if (StringUtils.isNull(pD)) {
                                                                                                pD = pbData.aNb().rc().getTaskId();
                                                                                            }
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ad("obj_id", pD));
                                                                                        }
                                                                                    } else {
                                                                                        com.baidu.tieba.tbadkCore.d.a.cd("c10725", null);
                                                                                    }
                                                                                    PbActivity.this.aOL();
                                                                                    return;
                                                                                } else if (PbActivity.this.eBS.aRi() != view) {
                                                                                    if (PbActivity.this.eBX == null || view != PbActivity.this.eBX.aQi()) {
                                                                                        if (PbActivity.this.eBS.eJb.aSN() == null || view != PbActivity.this.eBS.eJb.aSN().aQy()) {
                                                                                            if (PbActivity.this.eBS.eJb.aSN() != null && view == PbActivity.this.eBS.eJb.aSN().aQv()) {
                                                                                                if (com.baidu.adp.lib.util.j.hh()) {
                                                                                                    SparseArray<Object> c2 = PbActivity.this.eBS.c(PbActivity.this.eBQ.getPbData(), PbActivity.this.eBQ.aPx(), 1);
                                                                                                    if (c2 != null) {
                                                                                                        PbActivity.this.eBS.a(((Integer) c2.get(d.h.tag_del_post_type)).intValue(), (String) c2.get(d.h.tag_del_post_id), ((Integer) c2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.h.tag_del_post_is_self)).booleanValue());
                                                                                                    }
                                                                                                    PbActivity.this.eBS.eJb.om();
                                                                                                    return;
                                                                                                }
                                                                                                PbActivity.this.showToast(d.l.network_not_available);
                                                                                                return;
                                                                                            } else if (view.getId() != d.h.sub_pb_more && view.getId() != d.h.sub_pb_item && view.getId() != d.h.pb_floor_reply_more) {
                                                                                                if (view != PbActivity.this.eBS.aOb()) {
                                                                                                    if (view == PbActivity.this.eBS.eJb.aSO()) {
                                                                                                        PbActivity.this.eBS.aRw();
                                                                                                        return;
                                                                                                    }
                                                                                                    int id = view.getId();
                                                                                                    if (id == d.h.pb_u9_text_view) {
                                                                                                        if (PbActivity.this.checkUpIsLogin() && (blVar = (bl) view.getTag()) != null && !StringUtils.isNull(blVar.sX())) {
                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                            av.vH().c(PbActivity.this.getPageContext(), new String[]{blVar.sX()});
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if ((id == d.h.pb_floor_agree || id == d.h.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                        PostData be = PbActivity.this.be(view);
                                                                                                        if (be != null) {
                                                                                                            TiebaStatic.log(PbActivity.this.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", be.brL() ? 0 : 1));
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.view_main_thread_praise_state) {
                                                                                                        PbActivity.this.f(view, 2, false);
                                                                                                        if (PbActivity.this.aOi() != null && PbActivity.this.aOi().getPbData() != null && PbActivity.this.aOi().getPbData().aNx() != null && PbActivity.this.aOi().getPbData().aNx() != null) {
                                                                                                            TiebaStatic.log(PbActivity.this.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aOi().getPbData().aNx().aNF() ? 0 : 1));
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.view_main_thread_praise_num || id == d.h.view_main_thread_praise_name_list) {
                                                                                                        if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && !StringUtils.isNull(PbActivity.this.eBQ.getPbData().getThreadId()) && (aNx = PbActivity.this.eBQ.getPbData().aNx()) != null && aNx.getPraiseNum() > 0) {
                                                                                                            av.vH().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eBQ.getPbData().getThreadId()});
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
                                                                                                                    if (PbActivity.this.eBX == null) {
                                                                                                                        PbActivity.this.eBX = new u(PbActivity.this.getPageContext(), PbActivity.this.crU);
                                                                                                                        PbActivity.this.eBX.jc(PbActivity.this.mIsLogin);
                                                                                                                    }
                                                                                                                    PbActivity.this.eBX.showDialog();
                                                                                                                    boolean z6 = id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right;
                                                                                                                    if (z6) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ad("tid", PbActivity.this.eBQ.eFx));
                                                                                                                    }
                                                                                                                    SparseArray sparseArray2 = new SparseArray();
                                                                                                                    sparseArray2.put(d.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.h.tag_clip_board));
                                                                                                                    sparseArray2.put(d.h.tag_is_subpb, false);
                                                                                                                    PbActivity.this.eBX.aQh().setTag(sparseArray2);
                                                                                                                    PbActivity.this.eBX.aQm().setTag(view.getTag());
                                                                                                                    PbActivity.this.eBX.je(z6);
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
                                                                                                                            PbActivity.this.eBX.aQk().setVisibility(0);
                                                                                                                        } else {
                                                                                                                            sparseArray4.put(d.h.tag_should_delete_visible, false);
                                                                                                                            PbActivity.this.eBX.aQk().setVisibility(8);
                                                                                                                        }
                                                                                                                        PbActivity.this.eBX.aQi().setTag(sparseArray4);
                                                                                                                        PbActivity.this.eBX.aQk().setTag(sparseArray4);
                                                                                                                        PbActivity.this.eBX.aQi().setText(d.l.bar_manager);
                                                                                                                        PbActivity.this.eBX.aQi().setVisibility(0);
                                                                                                                    } else if (!booleanValue3) {
                                                                                                                        PbActivity.this.eBX.aQi().setVisibility(8);
                                                                                                                        PbActivity.this.eBX.aQk().setVisibility(8);
                                                                                                                    } else {
                                                                                                                        SparseArray sparseArray5 = new SparseArray();
                                                                                                                        sparseArray5.put(d.h.tag_should_manage_visible, false);
                                                                                                                        sparseArray5.put(d.h.tag_user_mute_visible, false);
                                                                                                                        sparseArray5.put(d.h.tag_should_delete_visible, true);
                                                                                                                        sparseArray5.put(d.h.tag_manage_user_identity, sparseArray3.get(d.h.tag_manage_user_identity));
                                                                                                                        sparseArray5.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                        sparseArray5.put(d.h.tag_del_post_id, sparseArray3.get(d.h.tag_del_post_id));
                                                                                                                        sparseArray5.put(d.h.tag_del_post_type, sparseArray3.get(d.h.tag_del_post_type));
                                                                                                                        PbActivity.this.eBX.aQi().setTag(sparseArray5);
                                                                                                                        PbActivity.this.eBX.aQk().setTag(sparseArray5);
                                                                                                                        PbActivity.this.eBX.aQi().setText(d.l.delete);
                                                                                                                        PbActivity.this.eBX.aQk().setVisibility(0);
                                                                                                                        if (PbActivity.this.eBQ.getPbData().aNm() != 1002 || z2) {
                                                                                                                            PbActivity.this.eBX.aQk().setText(d.l.delete);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.eBX.aQk().setText(d.l.report_text);
                                                                                                                        }
                                                                                                                        PbActivity.this.eBX.aQi().setVisibility(8);
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
                                                                                                                        PbActivity.this.eBX.aQj().setTag(sparseArray7);
                                                                                                                        PbActivity.this.eBX.aQj().setVisibility(0);
                                                                                                                        PbActivity.this.eBX.aQi().setVisibility(8);
                                                                                                                        PbActivity.this.eBX.aQj().setText(d.l.mute_option);
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
                                                                                                                        boolean iL = PbActivity.this.iL(z4) & PbActivity.this.isLogin();
                                                                                                                        PbActivity.this.eCS = (PostData) sparseArray6.get(d.h.tag_clip_board);
                                                                                                                        if (am.l(PbActivity.this.eCS) ? false : iL) {
                                                                                                                            PbActivity.this.eBX.aQj().setVisibility(0);
                                                                                                                            PbActivity.this.eBX.aQj().setTag(str3);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.eBX.aQj().setVisibility(8);
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
                                                                                                                        PbActivity.this.eBX.aQl().setVisibility(0);
                                                                                                                        PbActivity.this.eBX.aQl().setTag(d.h.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                        PbActivity.this.eBX.aQl().setTag(d.h.tag_chudian_monitor_id, str);
                                                                                                                        PbActivity.this.eBX.aQl().setTag(d.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                    } else {
                                                                                                                        PbActivity.this.eBX.aQl().setVisibility(8);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                            if (PbActivity.this.eBQ.getPbData().nG()) {
                                                                                                                String nF = PbActivity.this.eBQ.getPbData().nF();
                                                                                                                if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(nF) && nF.equals(postData2.getId())) {
                                                                                                                    z = true;
                                                                                                                    if (!z) {
                                                                                                                        PbActivity.this.eBX.aQh().setText(d.l.remove_mark);
                                                                                                                    } else {
                                                                                                                        PbActivity.this.eBX.aQh().setText(d.l.mark);
                                                                                                                    }
                                                                                                                    PbActivity.this.eBX.jd(true);
                                                                                                                    PbActivity.this.eBX.refreshUI();
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                            z = false;
                                                                                                            if (!z) {
                                                                                                            }
                                                                                                            PbActivity.this.eBX.jd(true);
                                                                                                            PbActivity.this.eBX.refreshUI();
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.pb_act_btn) {
                                                                                                        if (PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBQ.getPbData().aNb() != null && PbActivity.this.eBQ.getPbData().aNb().sb() != null) {
                                                                                                            com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), PbActivity.this.eBQ.getPbData().aNb().sb());
                                                                                                            if (PbActivity.this.eBQ.getPbData().aNb().rZ() != 1) {
                                                                                                                if (PbActivity.this.eBQ.getPbData().aNb().rZ() == 2) {
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
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ad("fid", PbActivity.this.eBQ.getPbData().getForumId()).ad("tid", PbActivity.this.eBQ.getPbData().getThreadId()).ad("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                            if (PbActivity.this.eBQ.getPbData().getThreadId().equals(str4)) {
                                                                                                                PbActivity.this.eBS.setSelection(0);
                                                                                                                return;
                                                                                                            } else {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.pb_item_tail_content) {
                                                                                                        if (ax.aU(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                            String string = TbadkCoreApplication.getInst().getString(d.l.tail_web_view_title);
                                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                            if (!StringUtils.isNull(string2)) {
                                                                                                                TiebaStatic.log("c10056");
                                                                                                                com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                            }
                                                                                                            PbActivity.this.eBS.aQU();
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.join_vote_tv) {
                                                                                                        if (view != null) {
                                                                                                            com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                            if (PbActivity.this.aOn() == 1) {
                                                                                                                if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ad("fid", PbActivity.this.eBQ.getPbData().getForumId()).ad("tid", PbActivity.this.eBQ.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                    return;
                                                                                                                }
                                                                                                                return;
                                                                                                            } else if (PbActivity.this.aOn() == 2 && PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null) {
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ad("fid", PbActivity.this.eBQ.getPbData().getForumId()).ad("tid", PbActivity.this.eBQ.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
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
                                                                                                            if (PbActivity.this.aOn() == 1) {
                                                                                                                if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ad("fid", PbActivity.this.eBQ.getPbData().getForumId()).ad("tid", PbActivity.this.eBQ.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                    return;
                                                                                                                }
                                                                                                                return;
                                                                                                            } else if (PbActivity.this.aOn() == 2 && PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null) {
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ad("fid", PbActivity.this.eBQ.getPbData().getForumId()).ad("tid", PbActivity.this.eBQ.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                return;
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.manga_prev_btn) {
                                                                                                        PbActivity.this.aOG();
                                                                                                        return;
                                                                                                    } else if (id == d.h.manga_next_btn) {
                                                                                                        PbActivity.this.aOH();
                                                                                                        return;
                                                                                                    } else if (id == d.h.yule_head_img_img) {
                                                                                                        if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBQ.getPbData().aNt() != null) {
                                                                                                            com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eBQ.getPbData();
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ad("fid", pbData2.getForumId()));
                                                                                                            av.vH().c(PbActivity.this.getPageContext(), new String[]{pbData2.aNt().aNB()});
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.yule_head_img_all_rank) {
                                                                                                        if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBQ.getPbData().aNt() != null) {
                                                                                                            com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eBQ.getPbData();
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ad("fid", pbData3.getForumId()));
                                                                                                            av.vH().c(PbActivity.this.getPageContext(), new String[]{pbData3.aNt().aNB()});
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (PbActivity.this.eBS.eJb.aSN() != null && view == PbActivity.this.eBS.eJb.aSN().aQz()) {
                                                                                                        if (PbActivity.this.eBQ == null || PbActivity.this.eBQ.getPbData() == null || PbActivity.this.eBQ.getPbData().aNb() == null) {
                                                                                                            PbActivity.this.eBS.eJb.om();
                                                                                                            return;
                                                                                                        } else if (!com.baidu.adp.lib.util.l.hy()) {
                                                                                                            PbActivity.this.showToast(d.l.neterror);
                                                                                                            return;
                                                                                                        } else {
                                                                                                            int i2 = 1;
                                                                                                            if (PbActivity.this.eBQ.getPbData().aNb().rf() == 0) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBQ.getThreadID(), 25028)));
                                                                                                            } else {
                                                                                                                BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.l.haved_fans_called)).tq();
                                                                                                                i2 = 2;
                                                                                                            }
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").r("obj_locate", PbActivity.this.W(PbActivity.this.eBQ.getPbData().aNb())).ad("tid", PbActivity.this.eBQ.getPbData().aNb().getTid()).r("obj_type", i2));
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (id == d.h.tv_pb_reply_more) {
                                                                                                        if (PbActivity.this.eCp >= 0) {
                                                                                                            if (PbActivity.this.eBQ != null) {
                                                                                                                PbActivity.this.eBQ.aQd();
                                                                                                            }
                                                                                                            if (PbActivity.this.eBS.aRj() != null) {
                                                                                                                PbActivity.this.eBS.aRj().a(PbActivity.this.eBQ.getPbData(), false);
                                                                                                            }
                                                                                                            PbActivity.this.eBS.getListView().setSelection(PbActivity.this.eBQ.aQg());
                                                                                                            PbActivity.this.eCp = 0;
                                                                                                            if (PbActivity.this.eBQ != null) {
                                                                                                                PbActivity.this.eBQ.bt(0, 0);
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else if (id == d.h.single_bar_tips) {
                                                                                                        PbActivity.this.eBS.aRX();
                                                                                                        return;
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eBQ.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eBQ.getThreadID(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eBQ.getPbData().aNb().rP())));
                                                                                                    return;
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                if (PbActivity.this.eBQ.getPbData() != null) {
                                                                                                    PbActivity.this.eBS.aCA();
                                                                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                    PostData postData3 = (PostData) sparseArray9.get(d.h.tag_load_sub_data);
                                                                                                    View view2 = (View) sparseArray9.get(d.h.tag_load_sub_view);
                                                                                                    if (postData3 != null && view2 != null) {
                                                                                                        String threadID = PbActivity.this.eBQ.getThreadID();
                                                                                                        String id2 = postData3.getId();
                                                                                                        int i3 = 0;
                                                                                                        if (PbActivity.this.eBQ.getPbData() != null) {
                                                                                                            i3 = PbActivity.this.eBQ.getPbData().aNm();
                                                                                                        }
                                                                                                        if (!com.baidu.tieba.pb.f.c(postData3)) {
                                                                                                            PbActivity.this.ahh();
                                                                                                            if (view.getId() == d.h.replybtn) {
                                                                                                                b oP = PbActivity.this.oP(id2);
                                                                                                                if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && oP != null) {
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i3, postData3.aTS(), PbActivity.this.eBQ.getPbData().qh(), false, postData3.getAuthor().getIconInfo()).addBigImageData(oP.eDw, oP.eDx, oP.eDy, oP.index)));
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
                                                                                                                b oP2 = PbActivity.this.oP(id2);
                                                                                                                if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && oP2 != null && PbActivity.this.aOh().aQS() != null) {
                                                                                                                    com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                    mVar.b(PbActivity.this.eBQ.getPbData().aMZ());
                                                                                                                    mVar.U(PbActivity.this.eBQ.getPbData().aNb());
                                                                                                                    mVar.e(postData4);
                                                                                                                    PbActivity.this.aOh().aQS().d(mVar);
                                                                                                                    PbActivity.this.aOh().aQS().setPostId(str7);
                                                                                                                    PbActivity.this.a(view, str6, str5);
                                                                                                                    return;
                                                                                                                }
                                                                                                                return;
                                                                                                            } else {
                                                                                                                TiebaStatic.log("c11742");
                                                                                                                b oP3 = PbActivity.this.oP(id2);
                                                                                                                if (postData3 != null && PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && oP3 != null) {
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i3, postData3.aTS(), PbActivity.this.eBQ.getPbData().qh(), false, postData3.getAuthor().getIconInfo()).addBigImageData(oP3.eDw, oP3.eDx, oP3.eDy, oP3.index)));
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 3).ad("fid", PbActivity.this.eBQ.getPbData().getForumId()));
                                                                                                return;
                                                                                            }
                                                                                        } else if (com.baidu.adp.lib.util.j.hh()) {
                                                                                            PbActivity.this.eBS.aCA();
                                                                                            SparseArray<Object> c3 = PbActivity.this.eBS.c(PbActivity.this.eBQ.getPbData(), PbActivity.this.eBQ.aPx(), 1);
                                                                                            if (c3 != null) {
                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBQ.getPbData().aMZ().getId(), PbActivity.this.eBQ.getPbData().aMZ().getName(), PbActivity.this.eBQ.getPbData().aNb().getId(), String.valueOf(PbActivity.this.eBQ.getPbData().getUserData().getUserId()), (String) c3.get(d.h.tag_forbid_user_name), (String) c3.get(d.h.tag_forbid_user_post_id))));
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
                                                                                            if (!com.baidu.tieba.c.a.Xn() || sparseArray11.get(d.h.tag_del_post_id) == null || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eBQ.getThreadID(), (String) sparseArray11.get(d.h.tag_del_post_id))) {
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
                                                                                                    PbActivity.this.eBS.bk(view);
                                                                                                    return;
                                                                                                } else if (booleanValue5) {
                                                                                                    PbActivity.this.eBS.a(((Integer) sparseArray11.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.h.tag_del_post_id), ((Integer) sparseArray11.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.h.tag_del_post_is_self)).booleanValue());
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
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ad("fid", PbActivity.this.eBQ.getPbData().getForumId()));
                                                                                    return;
                                                                                } else {
                                                                                    PbActivity.this.aOd();
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
                                                                            com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eBQ.getPbData();
                                                                            String str9 = null;
                                                                            String str10 = null;
                                                                            String str11 = null;
                                                                            if (pbData4 != null && pbData4.aMZ() != null) {
                                                                                str9 = pbData4.aMZ().getId();
                                                                                str10 = pbData4.aMZ().getName();
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
                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.Xn() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eBQ.getThreadID(), (String) sparseArray12.get(d.h.tag_del_post_id))) {
                                                                                PbActivity.this.eBS.a(((Integer) sparseArray12.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.h.tag_del_post_id), intValue, booleanValue7);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    if (PbActivity.this.eBX.aQo()) {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ad("tid", PbActivity.this.eBQ.eFx));
                                                                    } else {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 1));
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eBQ.getPbData() != null) {
                                                                        PbActivity.this.eBS.aCA();
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
                                                                            String threadID2 = PbActivity.this.eBQ.getThreadID();
                                                                            String id3 = postData.getId();
                                                                            int i5 = 0;
                                                                            if (PbActivity.this.eBQ.getPbData() != null) {
                                                                                i5 = PbActivity.this.eBQ.getPbData().aNm();
                                                                            }
                                                                            PbActivity.this.ahh();
                                                                            b oP4 = PbActivity.this.oP(id3);
                                                                            if (oP4 != null) {
                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID2, id3, "pb", true, null, true, null, i5, postData.aTS(), PbActivity.this.eBQ.getPbData().qh(), false, postData.getAuthor().getIconInfo()).addBigImageData(oP4.eDw, oP4.eDx, oP4.eDy, oP4.index)));
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
                                                                    if (PbActivity.this.eBQ.getPbData().aNb() != null && PbActivity.this.eBQ.getPbData().aNb().getAuthor() != null && PbActivity.this.eBQ.getPbData().aNb().getAuthor().getUserId() != null && PbActivity.this.efV != null) {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ad("tid", PbActivity.this.eBQ.eFx).r("obj_locate", 2).ad("obj_id", PbActivity.this.eBQ.getPbData().aNb().getAuthor().getUserId()).r("obj_type", PbActivity.this.efV.nG() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.eBQ.getPbData())));
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
                                                                PbActivity.this.oM((String) tag);
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
                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), null, PbActivity.this.aOm(), true)));
                                                        PbActivity.this.eBS.eJb.om();
                                                        PbActivity.this.eBS.eJb.aSN().aQC();
                                                        return;
                                                    } else if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBQ.getPbData().aNb() != null) {
                                                        PbActivity.this.eBS.eJb.om();
                                                        PbActivity.this.oM(PbActivity.this.eBQ.getPbData().aNb().rL());
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (com.baidu.tbadk.o.al.fS() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.eBQ != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ad("tid", PbActivity.this.eBQ.getThreadID()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("fid", PbActivity.this.eBQ.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.hy()) {
                                                        if (PbActivity.this.eBQ.getPbData() != null) {
                                                            ArrayList<PostData> aNd2 = PbActivity.this.eBQ.getPbData().aNd();
                                                            if ((aNd2 != null && aNd2.size() > 0) || !PbActivity.this.eBQ.aPx()) {
                                                                PbActivity.this.eBS.aCA();
                                                                PbActivity.this.ahh();
                                                                PbActivity.this.pd(2);
                                                                if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBQ.getPbData().aNt() != null && !StringUtils.isNull(PbActivity.this.eBQ.getPbData().aNt().pS(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ad("fid", PbActivity.this.eBQ.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.al.fS()) {
                                                                    PbActivity.this.pe(2);
                                                                    return;
                                                                }
                                                                PbActivity.this.eBS.showLoadingDialog();
                                                                PbActivity.this.eBQ.aPX().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                            PbActivity.this.eBS.eJb.om();
                                        } else if (com.baidu.adp.lib.util.j.hh()) {
                                            PbActivity.this.eBS.aCA();
                                            if (PbActivity.this.eBS.eJb.aSN() != null && view == PbActivity.this.eBS.eJb.aSN().aQt() && !PbActivity.this.eBS.aRU()) {
                                                PbActivity.this.eBS.aQU();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.ahh();
                                                PbActivity.this.eBS.aRo();
                                                if (view.getId() == d.h.floor_owner_reply) {
                                                    j = PbActivity.this.eBQ.j(true, PbActivity.this.aOE());
                                                } else {
                                                    j = view.getId() == d.h.reply_title ? PbActivity.this.eBQ.j(false, PbActivity.this.aOE()) : PbActivity.this.eBQ.oR(PbActivity.this.aOE());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.eBS.iV(true);
                                                    PbActivity.this.eBS.axb();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.eBS.jq(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.pd(2);
                                                return;
                                            }
                                            view.setTag(Boolean.FALSE);
                                        } else {
                                            PbActivity.this.showToast(d.l.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                        }
                                    } else if (com.baidu.adp.lib.util.j.hh()) {
                                        PbActivity.this.eBS.aCA();
                                        if (PbActivity.this.pc(11009) && PbActivity.this.eBQ.pr(PbActivity.this.eBS.aRt()) != null) {
                                            PbActivity.this.aOy();
                                            if (PbActivity.this.eBQ.getPbData().aNb() != null && PbActivity.this.eBQ.getPbData().aNb().getAuthor() != null && PbActivity.this.eBQ.getPbData().aNb().getAuthor().getUserId() != null && PbActivity.this.efV != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ad("tid", PbActivity.this.eBQ.eFx).r("obj_locate", 1).ad("obj_id", PbActivity.this.eBQ.getPbData().aNb().getAuthor().getUserId()).r("obj_type", PbActivity.this.efV.nG() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.eBQ.getPbData())));
                                            }
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.l.network_not_available);
                                    }
                                } else if (com.baidu.adp.lib.util.j.hh()) {
                                    PbActivity.this.eBS.iV(true);
                                    PbActivity.this.eBS.aQU();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eBS.axb();
                                        PbActivity.this.ahh();
                                        PbActivity.this.eBS.aRo();
                                        PbActivity.this.eBQ.oR(PbActivity.this.aOE());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.pd(2);
                                    }
                                } else {
                                    PbActivity.this.showToast(d.l.network_not_available);
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (view.getId() == d.h.view_forum_name_first_floor) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12505").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, com.baidu.tieba.pb.d.v(PbActivity.this.getPageContext())));
                                }
                                if (PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBQ.getPbData().aNb() != null && PbActivity.this.eBQ.getPbData().aNb().si() && PbActivity.this.eBQ.getPbData().aNb().rM() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.eBQ.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eBQ.aPw()) && PbActivity.this.eBQ.getAppealInfo() != null) {
                                        name = PbActivity.this.eBQ.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eBQ.getPbData().aMZ().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aPw = PbActivity.this.eBQ.aPw();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eBQ.aPy() && aPw != null && aPw.equals(name)) {
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
                            if (PbActivity.this.eBQ.getPbData().aNm() == 1 && !PbActivity.this.eBR.bsk()) {
                                PbActivity.this.eBS.aCA();
                                int i6 = 0;
                                if (PbActivity.this.eBS.eJb.aSN() == null || view != PbActivity.this.eBS.eJb.aSN().aQu()) {
                                    if (PbActivity.this.eBS.eJb.aSN() == null || view != PbActivity.this.eBS.eJb.aSN().aQw()) {
                                        if (view == PbActivity.this.eBS.aRm()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eBQ.getPbData().aNb().rr() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eBQ.getPbData().aNb().rq() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aMZ = PbActivity.this.eBQ.getPbData().aMZ();
                                String name2 = aMZ.getName();
                                String id4 = aMZ.getId();
                                String id5 = PbActivity.this.eBQ.getPbData().aNb().getId();
                                if (!com.baidu.tieba.c.a.Xn() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eBS.aRl();
                                    PbActivity.this.eBR.a(id4, name2, id5, i6, PbActivity.this.eBS.aRn());
                                }
                            }
                        } else {
                            PbActivity.this.showToast(d.l.network_not_available);
                        }
                    } else if (com.baidu.adp.lib.util.j.hh()) {
                        PbActivity.this.eBS.aCA();
                        PbActivity.this.ahh();
                        PbActivity.this.eBS.aRo();
                        PbActivity.this.eBS.showLoadingDialog();
                        if (PbActivity.this.eBS.aRa() != null) {
                            PbActivity.this.eBS.aRa().setVisibility(8);
                        }
                        PbActivity.this.eBQ.pk(1);
                        if (PbActivity.this.eBv != null) {
                            PbActivity.this.eBv.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.l.network_not_available);
                    }
                } else if (PbActivity.this.eBG) {
                    PbActivity.this.eBG = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.h.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && PbActivity.this.aOh().aQS() != null && postData5.getAuthor() != null && postData5.bry() != 1 && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.c(postData5)) {
                                if (PbActivity.this.aOh().aQT() != null) {
                                    PbActivity.this.aOh().aQT().aPq();
                                }
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.eBQ.getPbData().aMZ());
                                mVar2.U(PbActivity.this.eBQ.getPbData().aNb());
                                mVar2.e(postData5);
                                PbActivity.this.aOh().aQS().d(mVar2);
                                PbActivity.this.aOh().aQS().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.getAuthor().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.eCe != null) {
                                    PbActivity.this.eBS.hg(PbActivity.this.eCe.Df());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aCR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.ahh();
            PbActivity.this.eBS.ju(z);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ad.Gv() && PbActivity.this.aOi() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.aOi().oU(postWriteCallBackData.getPostId());
                    PbActivity.this.eCp = PbActivity.this.eBS.aQX();
                    if (PbActivity.this.eBQ != null) {
                        PbActivity.this.eBQ.bt(PbActivity.this.eCp, PbActivity.this.eBS.aQY());
                    }
                }
                PbActivity.this.eBS.aCA();
                if (PbActivity.this.eCe != null) {
                    PbActivity.this.eBS.hg(PbActivity.this.eCe.Df());
                }
                PbActivity.this.eBS.aQR();
                PbActivity.this.eBS.hh(true);
                PbActivity.this.eBQ.aPL();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eBQ.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBQ.getPbData();
                            if (pbData != null && pbData.aNb() != null && pbData.aNb().getAuthor() != null && (userId = pbData.aNb().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ad.Gv() && PbActivity.this.eBQ.aPE()) {
                                PbActivity.this.eBS.aRo();
                            }
                        } else if (!com.baidu.tbadk.o.ad.Gv() && PbActivity.this.eBQ.aPE()) {
                            PbActivity.this.eBS.aRo();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eBS.n(PbActivity.this.eBQ.getPbData());
                    }
                    if (PbActivity.this.eBQ.aPB()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ad("tid", PbActivity.this.eBQ.getThreadID()));
                    }
                }
            } else if (qVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    private final PbModel.a eCJ = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eN;
            if (!z || fVar == null || fVar.aNk() != null || com.baidu.tbadk.core.util.v.t(fVar.aNd()) >= 1) {
                PbActivity.this.eiF = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eBS.aRq();
                if (fVar == null || !fVar.aNh()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eBS.getView());
                } else if (PbActivity.this.eBS.aQP() == null) {
                    PbActivity.this.eCg = true;
                }
                PbActivity.this.eBS.axa();
                PbActivity.this.eBS.aRk();
                if (PbActivity.this.cuu || PbActivity.this.eBS.aRU()) {
                    PbActivity.this.eBS.aRI();
                } else if (!PbActivity.this.eBS.aRH()) {
                    PbActivity.this.eBS.hh(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eBY = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eBS.Od();
                    PbActivity.this.eBS.jA(fVar.aNh());
                    if (fVar.aNb() != null && fVar.aNb().sr() != null) {
                        PbActivity.this.a(fVar.aNb().sr());
                    }
                    PbActivity.this.aOe();
                    if (PbActivity.this.eCe != null) {
                        PbActivity.this.eBS.hg(PbActivity.this.eCe.Df());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aNd() != null && fVar.aNd().size() >= 1 && fVar.aNd().get(0) != null) {
                        PbActivity.this.eBQ.oT(fVar.aNd().get(0).getId());
                    } else if (fVar.aNk() != null) {
                        PbActivity.this.eBQ.oT(fVar.aNk().getId());
                    }
                    if (PbActivity.this.eCe != null) {
                        PbActivity.this.eCe.a(fVar.qh());
                        PbActivity.this.eCe.a(fVar.aMZ(), fVar.getUserData());
                        PbActivity.this.eCe.a(PbActivity.this.eBQ.aPF(), PbActivity.this.eBQ.getThreadID(), PbActivity.this.eBQ.aPZ());
                        if (fVar.aNb() != null) {
                            PbActivity.this.eCe.bJ(fVar.aNb().sH());
                        }
                    }
                    if (PbActivity.this.efV != null) {
                        PbActivity.this.efV.ad(fVar.nG());
                    }
                    if (fVar == null || fVar.aNn() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eBS.jz(PbActivity.this.mIsFromCDN);
                    PbActivity.this.eBS.a(fVar, i2, i3, PbActivity.this.eBQ.aPx(), i4, PbActivity.this.eBQ.getIsFromMark());
                    PbActivity.this.eBS.d(fVar, PbActivity.this.eBQ.aPx());
                    PbActivity.this.eBS.jx(PbActivity.this.eBQ.getHostMode());
                    AntiData qh = fVar.qh();
                    if (qh != null) {
                        PbActivity.this.aCF = qh.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aCF) && PbActivity.this.eCe != null && PbActivity.this.eCe.Cz() != null && (eN = PbActivity.this.eCe.Cz().eN(6)) != null && !TextUtils.isEmpty(PbActivity.this.aCF)) {
                            ((View) eN).setOnClickListener(PbActivity.this.dOz);
                        }
                    }
                    com.baidu.tieba.pb.f.oC(fVar.eyV);
                    if (PbActivity.this.eCa) {
                        PbActivity.this.eCa = false;
                        PbActivity.this.aOh().getListView().setSelection(PbActivity.this.aOs());
                    }
                    if (PbActivity.this.eCb) {
                        PbActivity.this.eCb = false;
                        int aOs = PbActivity.this.aOs();
                        if (aOs == -1) {
                            aOs = PbActivity.this.aOt();
                        }
                        if (PbActivity.this.aOh() != null) {
                            PbActivity.this.aOh().pv(aOs);
                        }
                    } else {
                        PbActivity.this.eBS.aRu();
                    }
                    PbActivity.this.eBQ.a(fVar.aMZ(), PbActivity.this.eCx);
                    PbActivity.this.eBQ.a(PbActivity.this.eCy);
                } else if (str != null) {
                    if (!PbActivity.this.eBY && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eBQ.getAppealInfo().eyp)) {
                                    PbActivity.this.eBS.a(PbActivity.this.eBQ.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eBS.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.f.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eBS.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.f.ds200));
                            }
                            PbActivity.this.eBS.aRI();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.eBQ.getThreadID());
                            jSONObject.put("fid", PbActivity.this.eBQ.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                    }
                    if (i != -1) {
                        PbActivity.this.eBS.oV(PbActivity.this.getResources().getString(d.l.list_no_more_new));
                    } else {
                        PbActivity.this.eBS.oV("");
                    }
                    PbActivity.this.eBS.wu();
                }
                PbActivity.this.aJm = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aOi().aPx() || PbActivity.this.aOi().getPbData().qx().qu() != 0 || PbActivity.this.aOi().aPS()) {
                    PbActivity.this.eCf = true;
                    return;
                }
                return;
            }
            PbActivity.this.eBQ.pk(1);
            if (PbActivity.this.eBv != null) {
                PbActivity.this.eBv.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eBS.n(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.r.Gc().Gd()) {
                com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, PbActivity.this.aJe, PbActivity.this.createTime, PbActivity.this.aJm, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.cde : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aJe = 0L;
                if (mVar != null) {
                    mVar.FX();
                }
            }
        }
    };
    private CustomMessageListener eCK = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aOn() == 1) {
                    PbActivity.this.aOw();
                }
                PbActivity.this.aOo();
            }
        }
    };
    private final a.InterfaceC0042a eCL = new a.InterfaceC0042a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0042a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eBS.aRq();
            if (z) {
                if (PbActivity.this.efV != null) {
                    PbActivity.this.efV.ad(z2);
                }
                PbActivity.this.eBQ.ja(z2);
                if (PbActivity.this.eBQ.nG()) {
                    PbActivity.this.aOz();
                } else {
                    PbActivity.this.eBS.n(PbActivity.this.eBQ.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.efV != null && PbActivity.this.efV.nJ() != null && PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBQ.getPbData().aNb() != null && PbActivity.this.eBQ.getPbData().aNb().getAuthor() != null) {
                        MarkData nJ = PbActivity.this.efV.nJ();
                        MetaData author = PbActivity.this.eBQ.getPbData().aNb().getAuthor();
                        if (nJ != null && author != null) {
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
            if (!PbActivity.this.pb(PbActivity.this.mLastScrollState) && PbActivity.this.pb(i)) {
                if (PbActivity.this.eBS != null) {
                    PbActivity.this.eBS.aCA();
                    if (PbActivity.this.eCe != null && !PbActivity.this.eBS.aQV()) {
                        PbActivity.this.eBS.hg(PbActivity.this.eCe.Df());
                    }
                    if (!PbActivity.this.cuu) {
                        PbActivity.this.eBS.aQU();
                    }
                }
                if (!PbActivity.this.eBD) {
                    PbActivity.this.eBD = true;
                    PbActivity.this.eBS.aRG();
                }
            }
            PbActivity.this.eBS.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eBv != null) {
                PbActivity.this.eBv.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eBE == null) {
                PbActivity.this.eBE = new com.baidu.tbadk.k.d();
                PbActivity.this.eBE.ft(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBQ.getPbData().aNb() != null && PbActivity.this.eBQ.getPbData().aNb().si()) {
                    z = false;
                }
                if (PbActivity.this.eBS.aRj() != null && z) {
                    PbActivity.this.eBS.aRj().notifyDataSetChanged();
                }
                PbActivity.this.eBE.FJ();
            } else if (i == 1) {
                PbActivity.this.eBE.FJ();
            } else {
                PbActivity.this.eBE.FJ();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aNd;
            if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null && PbActivity.this.eBS != null && PbActivity.this.eBS.aRj() != null) {
                PbActivity.this.eBS.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eBv != null) {
                    PbActivity.this.eBv.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eBQ.aPN() && (aNd = PbActivity.this.eBQ.getPbData().aNd()) != null && !aNd.isEmpty()) {
                    int aPg = ((i + i2) - PbActivity.this.eBS.aRj().aPg()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eBQ.getPbData();
                    if (pbData != null) {
                        if (pbData.aNe() != null && pbData.aNe().hasData()) {
                            aPg--;
                        }
                        if (pbData.aNf() != null && pbData.aNf().hasData()) {
                            aPg--;
                        }
                        int size = aNd.size();
                        if (aPg < 0 || aPg >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eCM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = true;
            if (obj != null) {
                switch (PbActivity.this.eBR.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eBQ.aPL();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (!bVar.cRU && bVar.eRJ > 0 && bVar.gjc != 0 && bVar.eRJ != 1002) {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                            z = false;
                        }
                        if (bVar.eRJ == 1002 && !bVar.cRU) {
                            z = false;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eBS.a(1, dVar.Ak, dVar.gje, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eBR.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eBS.a(PbActivity.this.eBR.getLoadDataMode(), fVar.Ak, fVar.gje, false);
                        PbActivity.this.eBS.aj(fVar.gjg);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eBS.a(PbActivity.this.eBR.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final c eCN = new c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
    };
    private final g.b bbT = new g.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aOF()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eBQ.iZ(true)) {
                PbActivity.this.eBS.aRr();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eCP = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eCO && PbActivity.this.aOF()) {
                PbActivity.this.aOH();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eBQ.iY(false)) {
                    PbActivity.this.eBS.aRp();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eBQ.getPbData() != null) {
                    PbActivity.this.eBS.aRF();
                }
                PbActivity.this.eCO = true;
            }
        }
    };
    private int eCQ = 0;
    private final TbRichTextView.f aSw = new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
        /* JADX DEBUG: Multi-variable search result rejected for r2v33, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
        public void a(View view, String str, int i) {
            TbRichTextData tbRichTextData;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.eBS.e((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                b bVar = new b();
                PbActivity.this.a(str, i, bVar);
                if (bVar.eDA) {
                    TbRichText am = PbActivity.this.am(str, i);
                    if (am != null && (tbRichTextData = am.ID().get(PbActivity.this.eCQ)) != null && tbRichTextData.IP() != null && tbRichTextData.IP().memeInfo != null && !TextUtils.isEmpty(tbRichTextData.IP().memeInfo.detail_link)) {
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextData.IP().memeInfo.pck_id.intValue(), tbRichTextData.IP().memeInfo.pic_id.longValue(), 25033)));
                        PbActivity.this.eBO = view;
                    }
                } else if (bVar.eDz) {
                    TbRichText am2 = PbActivity.this.am(str, i);
                    if (am2 != null && PbActivity.this.eCQ >= 0 && PbActivity.this.eCQ < am2.ID().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String c2 = com.baidu.tieba.pb.data.g.c(am2.ID().get(PbActivity.this.eCQ));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= bVar.eDw.size()) {
                                break;
                            } else if (!bVar.eDw.get(i3).equals(c2)) {
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
                            concurrentHashMap.put(str2, bVar.eDx.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eDy, bVar.lastId, PbActivity.this.eBQ.aPJ(), concurrentHashMap, true, false, PbActivity.this.eBQ.getHostMode());
                        createConfig.getIntent().putExtra("from", "pb");
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    }
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(bVar.eDw, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.u(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, bVar.eDx.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eDy, bVar.eDw.get(0), PbActivity.this.eBQ.aPJ(), concurrentHashMap2, true, false, PbActivity.this.eBQ.getHostMode());
                    createConfig2.getIntent().putExtra("from", "pb");
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eCR = false;
    PostData eCS = null;
    private final b.InterfaceC0047b eCT = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eCS != null) {
                if (i == 0) {
                    PbActivity.this.eCS.bX(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eCS = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.g(PbActivity.this.eCS);
                }
            }
        }
    };
    private final b.InterfaceC0047b eCU = new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eCm != null && !TextUtils.isEmpty(PbActivity.this.eCn)) {
                if (i == 0) {
                    if (PbActivity.this.eCo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eCn));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eCn;
                        aVar.pkgId = PbActivity.this.eCo.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eCo.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eCl == null) {
                        PbActivity.this.eCl = new aq(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eCl.i(PbActivity.this.eCn, PbActivity.this.eCm.kQ());
                }
                PbActivity.this.eCm = null;
                PbActivity.this.eCn = null;
            }
        }
    };
    private final View.OnLongClickListener auG = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eCm = ((TbImageView) view).getBdImage();
                PbActivity.this.eCn = ((TbImageView) view).getUrl();
                if (PbActivity.this.eCm != null && !TextUtils.isEmpty(PbActivity.this.eCn)) {
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eCo = null;
                    } else {
                        PbActivity.this.eCo = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eBS.a(PbActivity.this.eCU, PbActivity.this.eCm.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.eCm = ((GifView) view).getBdImage();
                }
                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                    PbActivity.this.eCn = ((GifView) view).getBdImage().getUrl();
                }
                if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                    PbActivity.this.eCo = null;
                } else {
                    PbActivity.this.eCo = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                }
                PbActivity.this.eBS.a(PbActivity.this.eCU, PbActivity.this.eCm.isGif());
            } else if (view instanceof com.baidu.tbadk.widget.c) {
                if (((com.baidu.tbadk.widget.c) view).getBdImage() != null) {
                    PbActivity.this.eCm = ((com.baidu.tbadk.widget.c) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.c) view).getBdImage().getUrl())) {
                        PbActivity.this.eCn = ((com.baidu.tbadk.widget.c) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eCo = null;
                    } else {
                        PbActivity.this.eCo = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eBS.a(PbActivity.this.eCU, PbActivity.this.eCm.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eCS = (PostData) sparseArray.get(d.h.tag_clip_board);
                    if (PbActivity.this.eCS != null && PbActivity.this.efV != null) {
                        PbActivity.this.eBS.a(PbActivity.this.eCT, PbActivity.this.efV.nG() && PbActivity.this.eCS.getId() != null && PbActivity.this.eCS.getId().equals(PbActivity.this.eBQ.rE()), ((Boolean) sparseArray.get(d.h.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a coJ = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!PbActivity.this.eBx && z && !PbActivity.this.eBQ.aPD()) {
                PbActivity.this.aCh();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.f.ds200));
        }
    };
    public View.OnTouchListener aLZ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).aqr()) {
                        break;
                    }
                }
            }
            PbActivity.this.ctE.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0081a caG = new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        final int bCg;

        {
            this.bCg = (int) PbActivity.this.getResources().getDimension(d.f.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ao(int i, int i2) {
            if (Q(i2) && PbActivity.this.eBS != null && PbActivity.this.eBv != null) {
                PbActivity.this.eBS.aRJ();
                PbActivity.this.eBv.eK(false);
                PbActivity.this.eBv.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ap(int i, int i2) {
            if (Q(i2) && PbActivity.this.eBS != null && PbActivity.this.eBv != null) {
                PbActivity.this.eBv.eK(true);
                if (Math.abs(i2) > this.bCg) {
                    PbActivity.this.eBv.hideFloatingView();
                }
                if (PbActivity.this.aOF()) {
                    PbActivity.this.eBS.aRf();
                    PbActivity.this.eBS.aRg();
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
    private final b.a eCV = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tieba.e.b.a
        public void ec(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aNU();
            } else {
                com.baidu.tieba.pb.a.b.aNT();
            }
        }
    };
    private String eCW = null;
    private final m.a eCX = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.l.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eCW = str2;
                PbActivity.this.eBS.oW(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eCY = -1;
    private int eCZ = -1;
    private CustomMessageListener eDc = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Tr == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0045a) {
                    if (aVar.Ts != null && !aVar.Ts.hasError() && aVar.Ts.getError() == 0) {
                        if (PbActivity.this.eBS != null) {
                            PbActivity.this.eBS.w(((a.C0045a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aOR();
                        }
                    } else if (z) {
                        if (aVar.Ts != null && aVar.Ts.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Ts.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Ts != null && !aVar.Ts.hasError() && aVar.Ts.getError() == 0) {
                        if (PbActivity.this.eBS != null && PbActivity.this.eBS != null) {
                            PbActivity.this.eBS.w(((a.C0045a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Ts != null && aVar.Ts.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Ts.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Ts == null || aVar.Ts.hasError() || aVar.Ts.getError() != 0) {
                        if (z) {
                            if (aVar.Ts != null && aVar.Ts.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Ts.getErrorString());
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
    private final CustomMessageListener crq = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ad("obj_locate", "pb"));
                    av.vH().c(PbActivity.this.getPageContext(), new String[]{str});
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
        public ArrayList<String> eDw;
        public ConcurrentHashMap<String, ImageUrlData> eDx;
        public boolean eDz;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eDy = false;
        public boolean eDA = false;
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

    public com.baidu.tbadk.editortools.pb.c aOc() {
        return this.eCe;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar.aNK() != null) {
            String id = mVar.aNK().getId();
            ArrayList<PostData> aNd = this.eBQ.getPbData().aNd();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aNd.size()) {
                    break;
                }
                PostData postData = aNd.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aNO = mVar.aNO();
                    postData.tA(mVar.getTotalCount());
                    if (postData.brv() != null) {
                        postData.brv().clear();
                        postData.brv().addAll(aNO);
                    }
                    if (postData.brr() != null) {
                        postData.brs();
                    }
                }
            }
            if (!this.eBQ.getIsFromMark()) {
                this.eBS.n(this.eBQ.getPbData());
            }
            c(mVar);
        }
    }

    public void aOd() {
        com.baidu.tieba.pb.data.f pbData;
        bh aNb;
        if (!this.eCA) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.l.no_network_guide);
            } else if (this.eCD) {
                this.eCA = true;
                if (this.eBQ != null && (pbData = this.eBQ.getPbData()) != null && (aNb = pbData.aNb()) != null) {
                    int isLike = aNb.rl() == null ? 0 : aNb.rl().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ad("tid", aNb.getId()));
                    }
                    if (this.eCB != null) {
                        this.eCB.a(aNb.rL(), aNb.getId(), isLike, "pb");
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
                bVar.cg(d.l.operation);
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
                                    PbActivity.this.eBS.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eCj);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eCj);
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
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eCj);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eCj);
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
    public void jz(int i) {
        bh aNb;
        String str;
        String x;
        if (this.eBQ != null && this.eBQ.getPbData() != null && (aNb = this.eBQ.getPbData().aNb()) != null) {
            if (i == 1) {
                PraiseData rl = aNb.rl();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rl == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aNb.a(praiseData);
                    } else {
                        aNb.rl().getUser().add(0, metaData);
                        aNb.rl().setNum(aNb.rl().getNum() + 1);
                        aNb.rl().setIsLike(i);
                    }
                }
                if (aNb.rl() != null) {
                    if (aNb.rl().getNum() < 1) {
                        x = getResources().getString(d.l.frs_item_praise_text);
                    } else {
                        x = com.baidu.tbadk.core.util.am.x(aNb.rl().getNum());
                    }
                    this.eBS.R(x, true);
                }
            } else if (aNb.rl() != null) {
                aNb.rl().setIsLike(i);
                aNb.rl().setNum(aNb.rl().getNum() - 1);
                ArrayList<MetaData> user = aNb.rl().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aNb.rl().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aNb.rl().getNum() < 1) {
                    str = getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = aNb.rl().getNum() + "";
                }
                this.eBS.R(str, false);
            }
            if (this.eBQ.aPx()) {
                this.eBS.aRj().notifyDataSetChanged();
            } else {
                this.eBS.o(this.eBQ.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eBQ != null && this.eBQ.getPbData() != null && this.eBS != null) {
            this.eBS.d(this.eBQ.getPbData(), this.eBQ.aPx(), this.eBQ.aPO());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eBQ.u(bundle);
        if (this.cqs != null) {
            this.cqs.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eCe.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eCh = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cde = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eBK = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eBK)) {
                this.eBw = true;
            }
            this.eCY = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eCZ = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eDa = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eCa = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eCb = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aOF()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.eCq = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.eBH = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.cde = System.currentTimeMillis();
        }
        this.eBC = System.currentTimeMillis();
        this.aJe = this.eBC - this.cde;
        super.onCreate(bundle);
        this.eBz = 0;
        w(bundle);
        if (this.eBQ != null && this.eBQ.getPbData() != null) {
            this.eBQ.getPbData().oI(this.source);
        }
        initUI();
        if (intent != null && this.eBS != null) {
            this.eBS.eIV = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eCk == null) {
                    this.eCk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eBS.oY("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eCk, 1500L);
            }
        }
        this.cqs = new VoiceManager();
        this.cqs.onCreate(getPageContext());
        initData(bundle);
        this.eCd = new com.baidu.tbadk.editortools.pb.d();
        aOe();
        this.eCe = (com.baidu.tbadk.editortools.pb.c) this.eCd.aX(getActivity());
        this.eCe.d(this);
        this.eCe.a(this.aCR);
        this.eCe.a(this.aCJ);
        this.eCe.a(this, bundle);
        this.eCe.Cz().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eCe.Cz().bC(true);
        iK(true);
        this.eBS.setEditorTools(this.eCe.Cz());
        this.eCe.a(this.eBQ.aPF(), this.eBQ.getThreadID(), this.eBQ.aPZ());
        registerListener(this.dOA);
        if (!this.eBQ.aPC()) {
            this.eCe.fN(this.eBQ.getThreadID());
        }
        if (this.eBQ.aQa()) {
            this.eCe.fL(getPageContext().getString(d.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eCe.fL(getPageContext().getString(d.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eBC;
        registerListener(this.eCt);
        registerListener(this.dOW);
        registerListener(this.eCu);
        registerListener(this.crn);
        registerListener(this.eCI);
        registerListener(this.eCs);
        this.eCc = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.ggj);
        this.eCc.bqY();
        registerListener(this.eCw);
        registerListener(this.aoT);
        if (this.eBQ != null) {
            this.eBQ.aPQ();
        }
        registerListener(this.eCK);
        registerListener(this.eDc);
        registerListener(this.crx);
        if (this.eBS != null && this.eBS.aRN() != null && this.eBS.aRO() != null) {
            this.eBv = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eBS.aRN(), this.eBS.aRO(), this.eBS.aRa());
            this.eBv.a(this.eCE);
        }
        if (this.eBu && this.eBS != null && this.eBS.aRO() != null) {
            this.eBS.aRO().setVisibility(8);
        }
        this.eCi = new com.baidu.tbadk.core.view.c();
        this.eCi.akH = 1000L;
        registerListener(this.eCH);
        registerListener(this.eCF);
        registerListener(this.eCG);
        this.eCj = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eCj;
        userMuteAddAndDelCustomMessage.setTag(this.eCj);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eCj;
        userMuteCheckCustomMessage.setTag(this.eCj);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eBQ.aPX().a(this.brQ);
        if ("from_tieba_kuang".equals(this.eBK)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 2).ad("tid", this.eBQ.getThreadID()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOe() {
        if (this.eCd != null && this.eBQ != null) {
            this.eCd.setForumName(this.eBQ.aPw());
            if (this.eBQ.getPbData() != null && this.eBQ.getPbData().aMZ() != null) {
                this.eCd.setForumId(this.eBQ.getPbData().aMZ().getId());
            }
            this.eCd.setFrom("pb");
            this.eCd.a(this.eBQ);
        }
    }

    public String aOf() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aOg() {
        return this.eBv;
    }

    private void iK(boolean z) {
        this.eCe.bG(z);
        this.eCe.bH(z);
        this.eCe.bI(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cqs != null) {
            this.cqs.onStart(getPageContext());
        }
    }

    public an aOh() {
        return this.eBS;
    }

    public PbModel aOi() {
        return this.eBQ;
    }

    public void oK(String str) {
        if (this.eBQ != null && !StringUtils.isNull(str) && this.eBS != null) {
            this.eBS.aRk();
            this.eBS.jC(true);
            this.eBQ.oK(str);
            this.eBJ = true;
            this.eBS.aCA();
            this.eBS.aRI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eBx = false;
        } else {
            this.eBx = true;
        }
        super.onPause();
        if (this.eBS.aQP() != null && this.eBS.aQP().aNZ() != null) {
            this.eBS.aQP().aNZ().onPause();
        }
        BdListView listView = getListView();
        this.eBz = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eBz == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cqs != null) {
            this.cqs.onPause(getPageContext());
        }
        if (this.eBS != null) {
            this.eBS.onPause();
        }
        if (!this.eBQ.aPC()) {
            this.eCe.fM(this.eBQ.getThreadID());
        }
        if (this.eBQ != null) {
            this.eBQ.aPR();
        }
        MessageManager.getInstance().unRegisterListener(this.doe);
        aqN();
        MessageManager.getInstance().unRegisterListener(this.eCF);
        MessageManager.getInstance().unRegisterListener(this.eCG);
        MessageManager.getInstance().unRegisterListener(this.eCH);
        MessageManager.getInstance().unRegisterListener(this.crq);
        MessageManager.getInstance().unRegisterListener(this.cYs);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aOj() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eBQ.getPbData(), this.eBQ.aPx(), this.eBQ.aPO());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eBx = false;
        super.onResume();
        if (this.eBM) {
            this.eBM = false;
            aOL();
        }
        if (this.eBS.aQP() != null && this.eBS.aQP().aNZ() != null) {
            this.eBS.aQP().aNZ().onResume();
        }
        if (aOj()) {
            this.eBF = System.currentTimeMillis();
        } else {
            this.eBF = -1L;
        }
        if (this.eBS != null && this.eBS.getView() != null) {
            if (!this.eiF) {
                aOC();
            } else {
                hideLoadingView(this.eBS.getView());
            }
            this.eBS.onResume();
        }
        if (this.eBz == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eBS != null) {
            noNetworkView = this.eBS.aQQ();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.hh()) {
            noNetworkView.aL(false);
        }
        if (this.cqs != null) {
            this.cqs.onResume(getPageContext());
        }
        registerListener(this.doe);
        this.eBZ = false;
        aOK();
        registerListener(this.eCF);
        registerListener(this.eCG);
        registerListener(this.eCH);
        registerListener(this.crq);
        registerListener(this.cYs);
        if (this.cqX) {
            aCh();
            this.cqX = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eBS.jr(z);
        if (this.eBX != null) {
            this.eBX.jc(z);
        }
        if (z && this.eBZ) {
            this.eBS.aRp();
            this.eBQ.iY(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eBF > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ad("obj_duration", (System.currentTimeMillis() - this.eBF) + ""));
            this.eBF = 0L;
        }
        if (aOh().aQT() != null) {
            aOh().aQT().onStop();
        }
        if (this.eBS.eJb != null && !this.eBS.eJb.Yy()) {
            this.eBS.eJb.aCT();
        }
        if (this.eBQ != null && this.eBQ.getPbData() != null && this.eBQ.getPbData().aMZ() != null && this.eBQ.getPbData().aNb() != null) {
            com.baidu.tbadk.distribute.a.Cj().a(getPageContext().getPageActivity(), "pb", this.eBQ.getPbData().aMZ().getId(), com.baidu.adp.lib.g.b.c(this.eBQ.getPbData().aNb().getId(), 0L));
        }
        if (this.cqs != null) {
            this.cqs.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.eBD && this.eBS != null) {
            this.eBD = true;
            this.eBS.aRG();
            a(false, (PostData) null);
        }
        if (this.eBQ != null) {
            this.eBQ.cancelLoadData();
            this.eBQ.destory();
            if (this.eBQ.aPW() != null) {
                this.eBQ.aPW().onDestroy();
            }
        }
        if (this.eCe != null) {
            this.eCe.onDestroy();
        }
        if (this.eBR != null) {
            this.eBR.cancelLoadData();
        }
        if (this.eBS != null) {
            this.eBS.onDestroy();
            if (this.eBS.eJb != null) {
                this.eBS.eJb.aCT();
            }
        }
        if (this.eBE != null) {
            this.eBE.onDestroy();
        }
        if (this.eBv != null) {
            this.eBv.GR();
        }
        super.onDestroy();
        if (this.cqs != null) {
            this.cqs.onDestory(getPageContext());
        }
        if (this.cqL != null) {
            this.cqL.destory();
        }
        this.eBS.aCA();
        MessageManager.getInstance().unRegisterListener(this.eCF);
        MessageManager.getInstance().unRegisterListener(this.eCG);
        MessageManager.getInstance().unRegisterListener(this.eCH);
        MessageManager.getInstance().unRegisterListener(this.eCj);
        MessageManager.getInstance().unRegisterListener(this.eCI);
        MessageManager.getInstance().unRegisterListener(this.crx);
        this.eCh = null;
        this.eCi = null;
        com.baidu.tieba.recapp.d.a.bgz().bgB();
        if (this.eCk != null) {
            getSafeHandler().removeCallbacks(this.eCk);
        }
        if (this.eBN != null) {
            this.eBN.cancelLoadData();
        }
        if (this.eBS != null && this.eBS.eJb != null) {
            this.eBS.eJb.aSR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f aRj;
        ArrayList<PostData> aPh;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xx() && this.eBS != null && (aRj = this.eBS.aRj()) != null && (aPh = aRj.aPh()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aPh.iterator();
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
                        bVar.chz = id;
                        bVar.bNk = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.YY == 1 && !TextUtils.isEmpty(id)) {
                    next.YY = 2;
                    a.b bVar2 = new a.b();
                    bVar2.chz = id;
                    bVar2.bNk = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eBQ == null || this.eBQ.getPbData() == null || this.eBQ.getPbData().aMZ() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eBQ.getPbData().aMZ().getFirst_class();
                    str2 = this.eBQ.getPbData().aMZ().getSecond_class();
                    str = this.eBQ.getPbData().aMZ().getId();
                    str4 = this.eBQ.getThreadID();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eBS.onChangeSkinType(i);
        if (this.eCe != null && this.eCe.Cz() != null) {
            this.eCe.Cz().onChangeSkinType(i);
        }
        if (this.eBS.aQQ() != null) {
            this.eBS.aQQ().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eBS = new an(this, this.crU, this.aSx);
        this.ctE = new com.baidu.tieba.e.b(getActivity());
        this.ctE.a(this.eCV);
        this.ctE.a(this.caG);
        this.eBS.setOnScrollListener(this.mOnScrollListener);
        this.eBS.d(this.eCP);
        this.eBS.a(this.bbT);
        this.eBS.iE(com.baidu.tbadk.core.h.oT().oZ());
        this.eBS.setOnImageClickListener(this.aSw);
        this.eBS.a(this.auG);
        this.eBS.h(this.coJ);
        this.eBS.a(this.eCN);
        this.eBS.jr(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bd(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.ggL == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oT().oZ()) {
                    return false;
                }
                return oO(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eBS != null) {
            if (z && (!this.eiF || this.eCg)) {
                aOC();
            } else {
                hideLoadingView(this.eBS.getView());
            }
            this.eCg = false;
        }
    }

    private void aOk() {
        if (this.eBA == null) {
            this.eBA = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eBA.a(new String[]{getPageContext().getString(d.l.call_phone), getPageContext().getString(d.l.sms_phone), getPageContext().getString(d.l.search_in_baidu)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eBe = PbActivity.this.eBe.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBe);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eBQ.getThreadID(), PbActivity.this.eBe, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eBe = PbActivity.this.eBe.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBe);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eBQ.getThreadID(), PbActivity.this.eBe, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eBe = PbActivity.this.eBe.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBe);
                        bVar.dismiss();
                    }
                }
            }).ch(b.a.abq).ci(17).d(getPageContext());
        }
    }

    private void w(Bundle bundle) {
        this.eBQ = new PbModel(this);
        this.eBQ.a(this.eCJ);
        if (this.eBQ.aPU() != null) {
            this.eBQ.aPU().a(this.eCX);
        }
        if (this.eBQ.aPT() != null) {
            this.eBQ.aPT().a(this.eCv);
        }
        if (this.eBQ.aPW() != null) {
            this.eBQ.aPW().a(this.eCr);
        }
        if (bundle != null) {
            this.eBQ.initWithBundle(bundle);
        } else {
            this.eBQ.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eBQ.jb(true);
        }
        ae.aQE().Q(this.eBQ.aPv(), this.eBQ.getIsFromMark());
        if (StringUtils.isNull(this.eBQ.getThreadID())) {
            finish();
        } else {
            this.eBQ.EZ();
        }
    }

    private void initData(Bundle bundle) {
        this.efV = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.efV != null) {
            this.efV.a(this.eCL);
        }
        this.eBR = new ForumManageModel(this);
        this.eBR.setLoadDataCallBack(this.eCM);
        this.aoP = new com.baidu.tbadk.coreExtra.c.a(null);
        this.eBS.a(new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    PbActivity.this.showToast(d.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eBQ.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eBQ.getPbData().aMZ().getId(), PbActivity.this.eBQ.getPbData().aMZ().getName(), PbActivity.this.eBQ.getPbData().aNb().getId(), valueOf, str, str2)));
            }
        });
        this.eCB.setUniqueId(getUniqueId());
        this.eCB.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eBS.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eCj;
        userMuteCheckCustomMessage.setTag(this.eCj);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aNb() != null) {
            if (fVar.aNb().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aNb().getThreadType() == 54) {
                return 2;
            }
            if (fVar.aNb().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData be(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.h.tag_clip_board)) != null && !com.baidu.tieba.pb.f.c(postData)) {
            if (postData.brL()) {
                postData.cL(postData.brK() - 1);
            } else {
                postData.cL(postData.brK() + 1);
            }
            postData.mC(!postData.brL());
            ((PbFloorAgreeView) view).a(postData.brL(), postData.brK(), true);
            final int i = postData.brL() ? 0 : 1;
            this.eBQ.aPV().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pf(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).pG(i2);
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

    public com.baidu.tbadk.core.util.ak aOl() {
        return new com.baidu.tbadk.core.util.ak("c12003").ad("tid", this.eBQ.eFx).r("obj_type", 0).ad("fid", this.eBQ.getForumId()).r("obj_param1", this.eBQ.getPbData().aNb().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aOm() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eBQ != null && this.eBQ.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eBQ.getPbData();
            if (pbData.aMZ() != null) {
                sb.append("forum_name=").append(oL(pbData.aMZ().getName()));
                sb.append("&");
            }
            if (pbData.aNb() != null) {
                bh aNb = pbData.aNb();
                sb.append("thread_id=").append(aNb.getId());
                sb.append("&");
                sb.append("thread_title=").append(oL(aNb.getTitle()));
                if (aNb.getAuthor() != null && aNb.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aNb.getAuthor().getPortrait());
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
                        PbActivity.this.aOh().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aOh().aQT() != null) {
                        PbActivity.this.eCe.Cz().setVisibility(8);
                        PbActivity.this.aOh().aQT().bG(str, str2);
                    }
                    PbActivity.this.aOh().aRI();
                }
            }, 500L);
        }
    }

    private String oL(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null && this.eBQ != null && this.eBQ.getPbData() != null && postData.bry() > 1) {
            String threadID = this.eBQ.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.eBQ.getPbData() != null) {
                i = this.eBQ.getPbData().aNm();
            }
            b oP = oP(id);
            if (oP != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, postData.aTS(), this.eBQ.getPbData().qh(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(oP.eDw, oP.eDx, oP.eDy, oP.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        ak akVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                showToast(d.l.no_network_guide);
            } else if (aOi() != null && aOi().getPbData() != null && aOi().getPbData().aNx() != null && !com.baidu.tieba.pb.f.T(aOi().getPbData().aNb())) {
                com.baidu.tieba.pb.data.l aNx = aOi().getPbData().aNx();
                if (view == null || !(view.getTag(d.h.pb_main_thread_praise_view) instanceof ak)) {
                    akVar = null;
                } else {
                    akVar = (ak) view.getTag(d.h.pb_main_thread_praise_view);
                }
                if (aNx != null) {
                    int i2 = -1;
                    if (z) {
                        aNx.oX(i);
                    } else if (aNx.aNF()) {
                        aNx.aNH();
                        i2 = 1;
                    } else {
                        aNx.oY(i);
                        i2 = 0;
                    }
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pf(int i3) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void a(CustomDialogData customDialogData) {
                            com.baidu.tieba.pb.b.a(PbActivity.this.getPageContext(), customDialogData);
                        }
                    };
                    if (this.eBQ != null && this.eBQ.aPV() != null) {
                        String str = "";
                        if (this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null) {
                            str = this.eBQ.getPbData().aNb().rL();
                        }
                        if (this.eBQ.getPbData() != null) {
                            this.eBQ.getPbData().a(aNx);
                        }
                        if (z) {
                            this.eBQ.aPV().a(str, 3, i, this.eBQ.getForumId(), aVar);
                        } else {
                            this.eBQ.aPV().a(str, i2, 3, i, this.eBQ.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.ezf = i2;
                            kVar.ezg = aNx;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (akVar != null) {
                        akVar.b(aNx);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aOn() {
        if (this.eBQ.getPbData() == null || this.eBQ.getPbData().aNb() == null) {
            return -1;
        }
        return this.eBQ.getPbData().aNb().rZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOo() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.pp(this.eBQ.getForumId()) && this.eBQ.getPbData() != null && this.eBQ.getPbData().aMZ() != null) {
            if (this.eBQ.getPbData().aMZ().isLike() == 1) {
                aOD();
                this.eBQ.aPY().bJ(this.eBQ.getForumId(), this.eBQ.getThreadID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iL(boolean z) {
        if (this.eBQ == null || this.eBQ.getPbData() == null) {
            return false;
        }
        return ((this.eBQ.getPbData().aNm() != 0) || this.eBQ.getPbData().aNb() == null || this.eBQ.getPbData().aNb().getAuthor() == null || TextUtils.equals(this.eBQ.getPbData().aNb().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aOp() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.o.q.Gw()) {
            return "";
        }
        PostData aNi = aNi();
        if (this.eBQ == null || (pbData = this.eBQ.getPbData()) == null || pbData.getUserData() == null || pbData.aNb() == null || aNi == null || aNi.getAuthor() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aNi.getAuthor().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aNb().rf() == 0) {
            return "";
        }
        if (pbData.aNb().rf() == 0) {
            return getPageContext().getString(d.l.fans_call);
        }
        return getPageContext().getString(d.l.haved_fans_call);
    }

    private boolean iM(boolean z) {
        if (z) {
            return true;
        }
        if (this.eBQ == null || this.eBQ.getPbData() == null) {
            return false;
        }
        return this.eBQ.getPbData().aNm() != 0;
    }

    private boolean iN(boolean z) {
        return (z || this.eBQ == null || this.eBQ.getPbData() == null || this.eBQ.getPbData().aNm() == 0) ? false : true;
    }

    public void aOq() {
        if (this.eBQ != null && this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null && this.eBQ.getPbData().aNb().getAuthor() != null) {
            if (this.eBS != null) {
                this.eBS.aQR();
            }
            bh aNb = this.eBQ.getPbData().aNb();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aNb.getAuthor().getUserId());
            GodUserData godUserData = aNb.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            x xVar = new x();
            int aNm = this.eBQ.getPbData().aNm();
            if (aNm == 1) {
                xVar.eHv = true;
                xVar.eHu = true;
                xVar.eHA = aNb.rq() == 1;
                xVar.eHz = aNb.rr() == 1;
            } else {
                xVar.eHv = false;
                xVar.eHu = false;
            }
            if (aNm == 1002 && !equals) {
                xVar.eHE = true;
            }
            xVar.eHr = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            xVar.eHw = iM(equals);
            xVar.eHx = aOr();
            xVar.eHy = iN(equals);
            xVar.eHs = this.eBQ.aPx();
            xVar.ezs = this.efV != null && this.efV.nG();
            xVar.eHq = iL(equals);
            xVar.eHC = aOp();
            xVar.eHo = equals && this.eBS.aRx();
            xVar.eHp = z;
            xVar.eHt = TbadkCoreApplication.getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            xVar.isHostOnly = this.eBQ.getHostMode();
            xVar.eHB = false;
            if (aNb.rM() == null) {
                xVar.eHD = true;
            } else {
                xVar.eHD = false;
            }
            this.eBS.eJb.a(xVar);
        }
    }

    private boolean aOr() {
        if (this.eBQ != null && this.eBQ.aPx()) {
            return this.eBQ.ars() == null || this.eBQ.ars().qu() != 0;
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

    public int aOs() {
        if (aOh() == null || aOh().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aOh().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) fVar).mType == com.baidu.tieba.pb.data.j.ezc) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aOt() {
        if (aOh() == null || aOh().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aOh().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.ggJ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        aCh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cL(getResources().getString(d.l.mark_done));
            aVar.ax(true);
            aVar.cM(getResources().getString(d.l.mark_like));
            aVar.aw(true);
            aVar.ar(false);
            aVar.b(getResources().getString(d.l.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ad("obj_id", metaData.getUserId()).r("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.l.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ad("obj_id", metaData.getUserId()).r("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.aoP.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.eBQ.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).ti();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.eBS.aRq();
        this.eBQ.ja(z);
        if (this.efV != null) {
            this.efV.ad(z);
            if (markData != null) {
                this.efV.a(markData);
            }
        }
        if (this.eBQ.nG()) {
            aOz();
        } else {
            this.eBS.n(this.eBQ.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pb(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oM(String str) {
        if (!StringUtils.isNull(str) && this.eBQ != null) {
            String threadID = this.eBQ.getThreadID();
            String id = this.eBQ.getPbData().aMZ().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eBQ.aPC()) {
                    antiData.setBlock_forum_name(this.eBQ.getPbData().aMZ().getName());
                    antiData.setBlock_forum_id(this.eBQ.getPbData().aMZ().getId());
                    antiData.setUser_name(this.eBQ.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eBQ.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.tG(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahk));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahk));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahk));
            }
        } else if (i == 230277) {
            fT(str);
        } else {
            this.eBS.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eBS.a(0, bVar.Ak, bVar.gje, z);
            if (bVar.Ak) {
                if (bVar.gjc == 1) {
                    ArrayList<PostData> aNd = this.eBQ.getPbData().aNd();
                    int size = aNd.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aNd.get(i).getId())) {
                            i++;
                        } else {
                            aNd.remove(i);
                            break;
                        }
                    }
                    this.eBS.n(this.eBQ.getPbData());
                } else if (bVar.gjc == 0) {
                    aOu();
                } else if (bVar.gjc == 2) {
                    ArrayList<PostData> aNd2 = this.eBQ.getPbData().aNd();
                    int size2 = aNd2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aNd2.get(i2).brv().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aNd2.get(i2).brv().get(i3).getId())) {
                                i3++;
                            } else {
                                aNd2.get(i2).brv().remove(i3);
                                aNd2.get(i2).brx();
                                z2 = true;
                                break;
                            }
                        }
                        aNd2.get(i2).rP(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eBS.n(this.eBQ.getPbData());
                    }
                    a(bVar, this.eBS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eBS.a(this.eBR.getLoadDataMode(), fVar.Ak, fVar.gje, false);
            if (fVar.Ak) {
                this.eBU = true;
                if (i == 2 || i == 3) {
                    this.eBV = true;
                    this.eBW = false;
                } else if (i == 4 || i == 5) {
                    this.eBV = false;
                    this.eBW = true;
                }
                if (i == 2) {
                    this.eBQ.getPbData().aNb().bV(1);
                    this.eBQ.setIsGood(1);
                } else if (i == 3) {
                    this.eBQ.getPbData().aNb().bV(0);
                    this.eBQ.setIsGood(0);
                } else if (i == 4) {
                    this.eBQ.getPbData().aNb().bU(1);
                    this.eBQ.ib(1);
                } else if (i == 5) {
                    this.eBQ.getPbData().aNb().bU(0);
                    this.eBQ.ib(0);
                }
                this.eBS.c(this.eBQ.getPbData(), this.eBQ.aPx());
                if (this.eBQ.getPbData().aNm() != 1002) {
                    com.baidu.tieba.c.a.a(getPageContext(), 2, i);
                }
            }
        }
    }

    private void aOu() {
        if (this.eBQ.aPy() || this.eBQ.aPA()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eBQ.getThreadID());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eBQ.getThreadID()));
        if (aOA()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOv() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aNj;
        boolean z = true;
        if (this.eBS != null) {
            this.eBS.aCA();
        }
        if (this.eBQ != null && this.eBQ.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eBQ.getPbData().aNb().getId();
            historyMessage.forumName = this.eBQ.getPbData().aMZ().getName();
            historyMessage.threadName = this.eBQ.getPbData().aNb().getTitle();
            ArrayList<PostData> aNd = this.eBQ.getPbData().aNd();
            int aRs = this.eBS != null ? this.eBS.aRs() : 0;
            if (aNd != null && aRs >= 0 && aRs < aNd.size()) {
                historyMessage.postID = aNd.get(aRs).getId();
            }
            historyMessage.isHostOnly = this.eBQ.getHostMode();
            historyMessage.isSquence = this.eBQ.aPx();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eCe != null) {
            this.eCe.onDestroy();
        }
        if (this.eBy && aOh() != null) {
            aOh().aRV();
        }
        if (this.eBQ != null && (this.eBQ.aPy() || this.eBQ.aPA())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eBQ.getThreadID());
            if (this.eBU) {
                if (this.eBW) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eBQ.aCr());
                }
                if (this.eBV) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eBQ.getIsGood());
                }
            }
            if (this.eBQ.getPbData() != null && System.currentTimeMillis() - this.eBC >= 40000 && (aNj = this.eBQ.getPbData().aNj()) != null && !com.baidu.tbadk.core.util.v.u(aNj.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aNj);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eCq);
            }
            setResult(-1, intent);
        }
        if (aOA()) {
            if (this.eBQ != null && this.eBS != null && this.eBS.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eBQ.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aNh() && !this.eBJ) {
                        ae aQE = ae.aQE();
                        com.baidu.tieba.pb.data.f pbData2 = this.eBQ.getPbData();
                        Parcelable onSaveInstanceState = this.eBS.getListView().onSaveInstanceState();
                        boolean aPx = this.eBQ.aPx();
                        boolean hostMode = this.eBQ.getHostMode();
                        if (this.eBS.aRa() == null || this.eBS.aRa().getVisibility() != 0) {
                            z = false;
                        }
                        aQE.a(pbData2, onSaveInstanceState, aPx, hostMode, z);
                        if (this.eCp >= 0 || this.eBQ.aQe() != null) {
                            ae.aQE().k(this.eBQ.aQe());
                            ae.aQE().j(this.eBQ.aQf());
                            ae.aQE().pt(this.eBQ.aQg());
                        }
                    }
                }
            } else {
                ae.aQE().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eBS == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eBS.pw(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pc(int i) {
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
        this.eCe.onActivityResult(i, i2, intent);
        if (this.eBN != null) {
            this.eBN.onActivityResult(i, i2, intent);
        }
        if (aOh().aQT() != null) {
            aOh().aQT().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aOy();
                    return;
                case 13008:
                    ae.aQE().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eBQ != null) {
                                PbActivity.this.eBQ.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eBQ != null) {
                        a(aOx(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aOn() == 1) {
                        aOw();
                    }
                    intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aOo();
                        return;
                    }
                    return;
                case 24008:
                    this.eBS.iJ(false);
                    if (this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null && this.eBQ.getPbData().aNb().rP() != null) {
                        this.eBQ.getPbData().aNb().rP().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.eBS != null && this.eBS.eJb != null) {
                        this.eBS.eJb.om();
                        this.eBS.eJb.aSM();
                        if (this.eBQ != null && this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null) {
                            this.eBQ.getPbData().aNb().bQ(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.eBO != null) {
                        this.eBS.bl(this.eBO);
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
                if (intent != null && aOh() != null && aOc() != null && aOh().aQV() && com.baidu.tbadk.editortools.pb.a.CV().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.CV().setStatus(0);
                    if (this.eBS != null) {
                        this.eBS.aQU();
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
            if (this.eBN == null) {
                this.eBN = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eBN.b(this.aCJ);
                this.eBN.c(this.aCR);
            }
            this.eBN.a(emotionImageData, aOi(), aOi().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOw() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null && this.eBQ.getPbData().aNb().rG() != null && this.eBQ.getPbData().aNb().rG().size() > 0 && this.eBQ.getPbData().aNb().rG().get(0) != null) {
            this.mAwardActId = this.eBQ.getPbData().aNb().rG().get(0).po();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eBQ.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void S(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    pe(2);
                    return;
                case 2:
                    this.eBS.aRh();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aOx() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bL = this.eBQ.getPbData().bL(getPageContext().getPageActivity());
        PostData aQW = this.eBS.aQW();
        String str = "";
        if (aQW != null) {
            str = aQW.getId();
            String bY = aQW.bY(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(bY)) {
                bL[1] = bY;
            }
        }
        String rL = this.eBQ.getPbData().aNb().rL();
        if (rL != null && rL.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bL[1]);
        shareFromPBMsgData.setImageUrl(bL[0]);
        shareFromPBMsgData.setForumName(this.eBQ.getPbData().aMZ().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eBQ.getPbData().aNb().getId());
        shareFromPBMsgData.setTitle(this.eBQ.getPbData().aNb().getTitle());
        return shareFromPBMsgData;
    }

    private void L(Intent intent) {
        a(aOx(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eBQ != null && this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(getPageContext().getPageActivity());
            jVar.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.v(jVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.eBQ != null && PbActivity.this.eBQ.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ad = new com.baidu.tbadk.core.util.ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ad("fid", PbActivity.this.eBQ.getForumId()).ad("tid", PbActivity.this.eBQ.getThreadID());
                        if (PbActivity.this.d(PbActivity.this.eBQ.getPbData()) != 0) {
                            ad.r("obj_type", PbActivity.this.d(PbActivity.this.eBQ.getPbData()));
                        }
                        TiebaStatic.log(ad);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), jVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, jVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aOn() == 1) {
                        PbActivity.this.aOw();
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
            aVar.as(true);
            aVar.b(getPageContext()).ti();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                jVar.I(shareFromPBMsgData.getImageUrl(), this.eBQ.getPbData().aNn() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eBQ != null && this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(getPageContext().getPageActivity());
            jVar.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.v(jVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), jVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", jVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aOn() == 1) {
                        PbActivity.this.aOw();
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
            aVar.as(true);
            aVar.b(getPageContext()).ti();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                jVar.I(shareFromPBMsgData.getImageUrl(), this.eBQ.getPbData().aNn() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOy() {
        MarkData pr;
        if (this.efV != null && (pr = this.eBQ.pr(this.eBS.aRt())) != null) {
            if (!pr.isApp() || (pr = this.eBQ.pr(this.eBS.aRt() + 1)) != null) {
                this.eBS.aRo();
                this.efV.a(pr);
                if (!this.efV.nG()) {
                    this.efV.nI();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.efV.nH();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOz() {
        com.baidu.tieba.pb.data.f pbData = this.eBQ.getPbData();
        this.eBQ.ja(true);
        if (this.efV != null) {
            pbData.oH(this.efV.nF());
        }
        this.eBS.n(pbData);
    }

    private boolean aOA() {
        if (this.eBQ == null) {
            return true;
        }
        if (this.eBQ.nG()) {
            final MarkData aPK = this.eBQ.aPK();
            if (aPK == null || !this.eBQ.getIsFromMark()) {
                return true;
            }
            final MarkData pr = this.eBQ.pr(this.eBS.aRs());
            if (pr == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aPK);
                setResult(-1, intent);
                return true;
            } else if (pr.getPostId() == null || pr.getPostId().equals(aPK.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aPK);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cM(getPageContext().getString(d.l.alert_update_mark));
                aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.efV != null) {
                            if (PbActivity.this.efV.nG()) {
                                PbActivity.this.efV.nH();
                                PbActivity.this.efV.ad(false);
                            }
                            PbActivity.this.efV.a(pr);
                            PbActivity.this.efV.ad(true);
                            PbActivity.this.efV.nI();
                        }
                        aPK.setPostId(pr.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aPK);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aOv();
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aPK);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aOv();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eBS != null && PbActivity.this.eBS.getView() != null) {
                            PbActivity.this.eBS.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aPK);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aOv();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.ti();
                return false;
            }
        } else if (this.eBQ.getPbData() == null || this.eBQ.getPbData().aNd() == null || this.eBQ.getPbData().aNd().size() <= 0 || !this.eBQ.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eBS == null) {
            return null;
        }
        return this.eBS.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Ji() {
        if (this.eBS == null) {
            return 0;
        }
        return this.eBS.aRB();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Jj() {
        if (this.aSd == null) {
            this.aSd = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Vc */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean oZ = com.baidu.tbadk.core.h.oT().oZ();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.e.common_color_10220));
                    if (oZ) {
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
                        if (com.baidu.tbadk.core.h.oT().oZ()) {
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
        return this.aSd;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Jk() {
        if (this.aSe == null) {
            this.aSe = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aSe;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jl() {
        if (this.aSi == null) {
            this.aSi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aOV */
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
        return this.aSi;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jm() {
        if (this.aSf == null) {
            this.aSf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aCi */
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
        return this.aSf;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<RelativeLayout> Jo() {
        this.aSh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aOW */
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
        return this.aSh;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aoo == null) {
            this.aoo = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.aoo;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eBG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (ar.oZ(str) && this.eBQ != null && this.eBQ.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").r("obj_param1", 1).ad("post_id", this.eBQ.getThreadID()));
        }
        ar.aRY().f(getPageContext(), str);
        this.eBG = true;
    }

    private com.baidu.tbadk.core.dialog.a aOB() {
        if (this.eBB == null) {
            this.eBB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eBB.cL(getPageContext().getString(d.l.download_baidu_video_dialog));
            this.eBB.a(getPageContext().getString(d.l.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.dG()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.uh());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.l.download_baidu_video));
                    }
                }
            });
            this.eBB.b(getPageContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eBB.ar(true);
            this.eBB.b(getPageContext());
            this.eBB.as(false);
        }
        this.eBB.ti();
        return this.eBB;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
        ar.aRY().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eBG = true;
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
            aOB();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eBG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eBQ.getPbData();
            TbRichText am = am(str, i);
            if (am != null && (tbRichTextData = am.ID().get(this.eCQ)) != null) {
                if (tbRichTextData.getType() == 20 || tbRichTextData.getType() == 17) {
                    bVar.eDA = true;
                    return;
                }
                bVar.eDw = new ArrayList<>();
                bVar.eDx = new ConcurrentHashMap<>();
                if (!tbRichTextData.IJ().IV()) {
                    bVar.eDz = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.eDw.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = am.getPostId();
                    imageUrlData.mIsReserver = this.eBQ.aPJ();
                    imageUrlData.mIsSeeHost = this.eBQ.getHostMode();
                    bVar.eDx.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aMZ() != null) {
                            bVar.forumName = pbData.aMZ().getName();
                            bVar.forumId = pbData.aMZ().getId();
                        }
                        if (pbData.aNb() != null) {
                            bVar.threadId = pbData.aNb().getId();
                        }
                        bVar.eDy = pbData.aNn() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eDz = true;
                int size = pbData.aNd().size();
                this.eCR = false;
                bVar.index = -1;
                if (pbData.aNi() != null) {
                    PostData aNi = pbData.aNi();
                    TbRichText aCd = aNi.aCd();
                    if (!am.l(aNi)) {
                        i2 = a(aCd, am, i, i, bVar.eDw, bVar.eDx);
                    } else {
                        i2 = a(aNi, i, bVar.eDw, bVar.eDx);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aNd().get(i4);
                    if (postData.getId() == null || pbData.aNi() == null || pbData.aNi().getId() == null || !postData.getId().equals(pbData.aNi().getId())) {
                        TbRichText aCd2 = postData.aCd();
                        if (!am.l(postData)) {
                            i3 = a(aCd2, am, i3, i, bVar.eDw, bVar.eDx);
                        } else {
                            i3 = a(postData, i3, bVar.eDw, bVar.eDx);
                        }
                    }
                }
                if (bVar.eDw.size() > 0) {
                    bVar.lastId = bVar.eDw.get(bVar.eDw.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aMZ() != null) {
                        bVar.forumName = pbData.aMZ().getName();
                        bVar.forumId = pbData.aMZ().getId();
                    }
                    if (pbData.aNb() != null) {
                        bVar.threadId = pbData.aNb().getId();
                    }
                    bVar.eDy = pbData.aNn() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IJ() == null) {
            return null;
        }
        return tbRichTextData.IJ().IZ();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IJ() == null) {
            return 0L;
        }
        return tbRichTextData.IJ().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IJ() == null) {
            return false;
        }
        return tbRichTextData.IJ().Ja();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.IJ() == null) {
            return false;
        }
        return tbRichTextData.IJ().Jb();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo IJ;
        if (tbRichText == tbRichText2) {
            this.eCR = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.ID().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.ID().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ag = (int) com.baidu.adp.lib.util.l.ag(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.IJ().getWidth() * ag;
                    int height = ag * tbRichTextData.IJ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.IJ().IV()) {
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
                            if (tbRichTextData != null && (IJ = tbRichTextData.IJ()) != null) {
                                String IX = IJ.IX();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = IX;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eBQ.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eBQ.aPJ();
                                imageUrlData.mIsSeeHost = this.eBQ.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eCR) {
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
        com.baidu.tieba.tbadkCore.data.h brG;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> brc;
        if (postData != null && arrayList != null && concurrentHashMap != null && (brc = (brG = postData.brG()).brc()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == brc.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = brc.get(i3);
                if (jVar != null) {
                    String brh = jVar.brh();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(brh)) {
                        arrayList.add(brh);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = brh;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.brg();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eBQ.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eBQ.aPJ();
                        imageUrlData.mIsSeeHost = this.eBQ.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = brG.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(brh, imageUrlData);
                        }
                        if (!this.eCR) {
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
            if (postData.getId() != null && postData.getId().equals(this.eBQ.rE())) {
                z = true;
            }
            MarkData i = this.eBQ.i(postData);
            if (i != null) {
                this.eBS.aRo();
                if (this.efV != null) {
                    this.efV.a(i);
                    if (!z) {
                        this.efV.nI();
                    } else {
                        this.efV.nH();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText am(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eBQ == null || this.eBQ.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eBQ.getPbData();
        if (pbData.aNi() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aNi());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aNd = pbData.aNd();
            a(pbData, aNd);
            return a(aNd, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aNl() != null && fVar.aNl().ezu != null && (list = fVar.aNl().ezu) != null && arrayList != null) {
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

    private long oN(String str) {
        ArrayList<PostData> aNd;
        com.baidu.tieba.pb.data.f pbData = this.eBQ.getPbData();
        if (pbData != null && (aNd = pbData.aNd()) != null && !aNd.isEmpty()) {
            Iterator<PostData> it = aNd.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h brG = next.brG();
                if (brG != null && brG.ggr) {
                    Iterator<TbRichTextData> it2 = next.aCd().ID().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IS().getLink().equals(str)) {
                            return brG.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> ID;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText aCd = arrayList.get(i2).aCd();
            if (aCd != null && (ID = aCd.ID()) != null) {
                int size = ID.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (ID.get(i4) != null && ID.get(i4).getType() == 8) {
                        i3++;
                        if (ID.get(i4).IJ().IX().equals(str)) {
                            int ag = (int) com.baidu.adp.lib.util.l.ag(TbadkCoreApplication.getInst());
                            int width = ID.get(i4).IJ().getWidth() * ag;
                            int height = ID.get(i4).IJ().getHeight() * ag;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eCQ = i4;
                            return aCd;
                        } else if (i3 <= i) {
                            i4++;
                            i3 = i3;
                        }
                    } else {
                        if (ID.get(i4) != null && ID.get(i4).IP() != null && (ID.get(i4).getType() == 20 || ID.get(i4).getType() == 17)) {
                            i3++;
                            MemeInfo memeInfo = ID.get(i4).IP().memeInfo;
                            if (memeInfo == null || TextUtils.isEmpty(memeInfo.pic_url)) {
                                return null;
                            }
                            if (memeInfo.pic_url.equals(str)) {
                                this.eCQ = i4;
                                return aCd;
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
            this.eBe = str;
            if (this.eBA == null) {
                aOk();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eBA.ck(1).setVisibility(8);
            } else {
                this.eBA.ck(1).setVisibility(0);
            }
            this.eBA.tl();
            this.eBG = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cqs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCh() {
        hideNetRefreshView(this.eBS.getView());
        aOC();
        if (this.eBQ.EZ()) {
            this.eBS.aRo();
        }
    }

    private void aOC() {
        showLoadingView(this.eBS.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds400));
        View Et = getLoadingView().Et();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Et.getLayoutParams();
        layoutParams.addRule(3, this.eBS.aRN().getId());
        Et.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahh() {
        if (this.cqs != null) {
            this.cqs.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pd(int i) {
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
    public void pe(int i) {
        boolean z;
        String str;
        Uri parse;
        if (this.eBQ.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eBQ.getPbData();
            pbData.aMZ().getName();
            String title = pbData.aNb().getTitle();
            int i2 = this.eBQ.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aMZ() != null) {
                if ((pbData.aMZ().isLike() == 1) && AddExperiencedModel.pp(pbData.getForumId())) {
                    z = true;
                    String str2 = "http://tieba.baidu.com/p/" + this.eBQ.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bL = pbData.bL(getPageContext().getPageActivity());
                    str = bL[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    String str3 = bL[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aOn() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ad("fid", pbData.getForumId()).ad("tid", pbData.getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                    } else if (aOn() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ad("fid", pbData.getForumId()).ad("tid", pbData.getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                    }
                    String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, str3);
                    final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
                    dVar.title = title;
                    dVar.content = format;
                    dVar.linkUrl = str2;
                    dVar.aty = true;
                    dVar.atC = z;
                    dVar.extData = this.eBQ.getThreadID();
                    dVar.atN = 3;
                    dVar.atM = i;
                    dVar.fid = this.eBQ.getForumId();
                    dVar.Xf = this.eBQ.getThreadID();
                    dVar.atO = d(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.atH = parse;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.atN);
                    bundle.putInt("obj_type", dVar.atO);
                    bundle.putString("fid", dVar.fid);
                    bundle.putString("tid", dVar.Xf);
                    bundle.putString(SapiAccountManager.SESSION_UID, dVar.uid);
                    dVar.e(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setIsCopyLink(true);
                    if (TbadkCoreApplication.isLogin()) {
                        shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 23007)));
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10125").ad("tid", PbActivity.this.eBQ.getThreadID()).ad("fid", PbActivity.this.eBQ.getForumId()).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                                PbActivity.this.wH();
                            }
                        });
                    }
                    shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            dVar.linkUrl = com.baidu.tbadk.coreExtra.d.e.ak(dVar.linkUrl, dVar.Xf);
                            com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                            PbActivity.this.wH();
                        }
                    });
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
                }
            }
            z = false;
            String str22 = "http://tieba.baidu.com/p/" + this.eBQ.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bL2 = pbData.bL(getPageContext().getPageActivity());
            str = bL2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            String str32 = bL2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aOn() != 1) {
            }
            String format2 = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, str32);
            final com.baidu.tbadk.coreExtra.d.d dVar2 = new com.baidu.tbadk.coreExtra.d.d();
            dVar2.title = title;
            dVar2.content = format2;
            dVar2.linkUrl = str22;
            dVar2.aty = true;
            dVar2.atC = z;
            dVar2.extData = this.eBQ.getThreadID();
            dVar2.atN = 3;
            dVar2.atM = i;
            dVar2.fid = this.eBQ.getForumId();
            dVar2.Xf = this.eBQ.getThreadID();
            dVar2.atO = d(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.atN);
            bundle2.putInt("obj_type", dVar2.atO);
            bundle2.putString("fid", dVar2.fid);
            bundle2.putString("tid", dVar2.Xf);
            bundle2.putString(SapiAccountManager.SESSION_UID, dVar2.uid);
            dVar2.e(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setIsCopyLink(true);
            if (TbadkCoreApplication.isLogin()) {
            }
            shareDialogConfig2.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar2.linkUrl = com.baidu.tbadk.coreExtra.d.e.ak(dVar2.linkUrl, dVar2.Xf);
                    com.baidu.adp.lib.util.a.aw(dVar2.linkUrl);
                    com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                    PbActivity.this.wH();
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aNb() != null) {
            if (fVar.aNb().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aNb().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void aOD() {
        com.baidu.tbadk.util.t.a(new com.baidu.tbadk.util.s<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.s
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pq(PbActivity.this.eBQ.getForumId()));
            }
        }, new com.baidu.tbadk.util.g<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eBS.aRW();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.any == null) {
                this.any = new ShareReportModel(getPageContext());
            }
            this.any.j(shareItem.fid, shareItem.Xf, shareItem.atE);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Jn() {
        if (this.aSg == null) {
            this.aSg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aOX */
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
        return this.aSg;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eBS.aRi() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ad("fid", this.eBQ.getPbData().getForumId()));
            } else {
                bh aNb = this.eBQ.getPbData().aNb();
                if (view != null) {
                    boolean z = aNb.rl() == null || aNb.rl().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eCC > 1000) {
                            this.eCD = true;
                            bg(view);
                        } else {
                            this.eCD = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            l(view, this.eCD);
                        } else {
                            k(view, this.eCD);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        k(view, this.eCD);
                    } else if (motionEvent.getAction() == 3) {
                        k(view, this.eCD);
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
                    PbActivity.this.eCC = System.currentTimeMillis();
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
                    PbActivity.this.eCC = System.currentTimeMillis();
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

    public void ahi() {
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
        } else if (aVar.tk() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tk();
            int intValue = ((Integer) sparseArray.get(an.eKR)).intValue();
            if (intValue == an.eKS) {
                if (!this.eBR.bsk()) {
                    this.eBS.aRl();
                    int intValue2 = ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue();
                    this.eBR.a(this.eBQ.getPbData().aMZ().getId(), this.eBQ.getPbData().aMZ().getName(), this.eBQ.getPbData().aNb().getId(), (String) sparseArray.get(d.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.eKT || intValue == an.eKV) {
                if (this.eBQ.aPU() != null) {
                    this.eBQ.aPU().pi(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.eKT) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == an.eKU) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eCW).pj()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eCj);
        userMuteAddAndDelCustomMessage.setTag(this.eCj);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean oO(String str) {
        if (!StringUtils.isNull(str) && ax.aU(getPageContext().getPageActivity())) {
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

    public void iO(boolean z) {
        this.eBZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aOE() {
        ArrayList<PostData> aNd;
        int t;
        if (this.eBQ == null || this.eBQ.getPbData() == null || this.eBQ.getPbData().aNd() == null || (t = com.baidu.tbadk.core.util.v.t((aNd = this.eBQ.getPbData().aNd()))) == 0) {
            return "";
        }
        if (this.eBQ.aPJ()) {
            Iterator<PostData> it = aNd.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bry() == 1) {
                    return next.getId();
                }
            }
        }
        int aRs = this.eBS.aRs();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aNd, aRs);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eBQ.oS(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aRs - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aNd, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eBQ.oS(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aRs + 1; i2 < t; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aNd, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eBQ.oS(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (av.vH().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(oN(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eBQ.getPbData().aMZ().getId(), this.eBQ.getPbData().aMZ().getName(), this.eBQ.getPbData().aNb().getTid());
            }
            this.eBG = true;
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
        aVar.a(getResources().getString(d.l.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eBQ.aPT() != null) {
                    PbActivity.this.eBQ.aPT().cm(j);
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
        aVar.as(false);
        aVar.b(getPageContext());
        aVar.ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b oP(String str) {
        String str2;
        if (this.eBQ.getPbData() == null || this.eBQ.getPbData().aNd() == null || this.eBQ.getPbData().aNd().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i >= this.eBQ.getPbData().aNd().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eBQ.getPbData().aNd().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eBQ.getPbData().aNd().get(i);
        if (postData.aCd() == null || postData.aCd().ID() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aCd().ID().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.IJ() != null) {
                    str2 = next.IJ().IX();
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
        if (this.eBw) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eBw = false;
        } else if (aOF()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eBw) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eBw = false;
        } else if (aOF()) {
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
        if (pageStayDurationItem != null && this.eBQ != null) {
            if (this.eBQ.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eBQ.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eBQ.getThreadID(), 0L));
            if (this.eBH) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aOF() {
        return (!this.eBu && this.eCY == -1 && this.eCZ == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eDb = nVar;
            this.eBu = true;
            this.eBS.aRb();
            this.eBS.oX(this.eDa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOG() {
        if (this.eDb != null) {
            if (this.eCY == -1) {
                showToast(d.l.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eDb.getCartoonId(), this.eCY, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOH() {
        if (this.eDb != null) {
            if (this.eCZ == -1) {
                showToast(d.l.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eDb.getCartoonId(), this.eCZ, 0)));
                finish();
            }
        }
    }

    public int aOI() {
        return this.eCY;
    }

    public int aOJ() {
        return this.eCZ;
    }

    private void aqN() {
        if (this.eBQ != null && this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null && this.eBQ.getPbData().aNb().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aOK() {
        if (this.eBQ != null && this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null && this.eBQ.getPbData().aNb().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aOL() {
        if (this.eBx) {
            this.eBM = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null && this.eBQ.getPbData().aNb().rc() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eBQ.getPbData().aNb().rc().getThreadId(), this.eBQ.getPbData().aNb().rc().getTaskId(), this.eBQ.getPbData().aNb().rc().getForumId(), this.eBQ.getPbData().aNb().rc().getForumName(), this.eBQ.getPbData().aNb().rq(), this.eBQ.getPbData().aNb().rr())));
            this.eBw = true;
            finish();
        }
    }

    public boolean aOM() {
        return this.eBx;
    }

    public String aON() {
        return this.eBK;
    }

    public PbInterviewStatusView.a aOO() {
        return this.eBP;
    }

    public void iP(boolean z) {
        this.eBL = z;
    }

    public boolean aOP() {
        if (this.eBQ != null) {
            return this.eBQ.aPy();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cM(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eCh).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eCh.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eCh).ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eCh != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCh.getPageActivity());
            aVar.cM(str);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eCh).ti();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eBS.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCh.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cM(this.eCh.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cM(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eBS.showLoadingDialog();
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
        aVar.b(this.eCh).ti();
    }

    public void aOR() {
        if (this.eBQ != null && this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null && this.eBQ.getPbData().aNb().sz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cd(d.l.channel_open_push_message);
            aVar.a(d.l.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eBQ.getPbData().aNb().sz().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.ti();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ar.oZ(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_pb_wenxue)) != null) {
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
            this.cuu = true;
        } else {
            this.cuu = false;
        }
        if (this.eBS != null) {
            this.eBS.onConfigurationChanged(configuration);
        }
        if (this.eBX != null) {
            this.eBX.dismiss();
        }
    }

    public boolean aOS() {
        if (this.eBQ != null) {
            return this.eBQ.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.eBQ.getPbData().aNl().ezu;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).brv().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).brv().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).brv().remove(i2);
                    list.get(i).brx();
                    z = true;
                    break;
                }
            }
            list.get(i).rP(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.n(this.eBQ.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aNK().getId();
        List<PostData> list = this.eBQ.getPbData().aNl().ezu;
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
                ArrayList<PostData> aNO = mVar.aNO();
                postData.tA(mVar.getTotalCount());
                if (postData.brv() != null) {
                    postData.brv().clear();
                    postData.brv().addAll(aNO);
                }
            }
        }
        if (!this.eBQ.getIsFromMark()) {
            this.eBS.n(this.eBQ.getPbData());
        }
    }

    public boolean aOT() {
        boolean z = true;
        if (this.eBQ == null) {
            return false;
        }
        switch (this.eBQ.aQc()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eBQ.getPbData() != null && this.eBQ.getPbData().aNb() != null && this.eBQ.getPbData().aNb().sH() && StringUtils.isNull(this.eBQ.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aOU() {
        if (this.eBS != null) {
            this.eBS.aQR();
            ahi();
        }
    }

    public PostData aNi() {
        return this.eBS.b(this.eBQ.eFO, this.eBQ.aPx());
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
}
