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
    private com.baidu.adp.lib.e.b<ImageView> aRb;
    private com.baidu.adp.lib.e.b<TextView> aRc;
    private com.baidu.adp.lib.e.b<View> aRd;
    private com.baidu.adp.lib.e.b<View> aRe;
    private com.baidu.adp.lib.e.b<LinearLayout> aRf;
    private com.baidu.adp.lib.e.b<GifView> aRg;
    private ShareReportModel aoi;
    private com.baidu.adp.lib.e.b<TbImageView> apd;
    private VoiceManager cpV;
    private com.baidu.tbadk.i.a cqp;
    private com.baidu.tieba.e.b csZ;
    private String eHG;
    private v eID;
    private boolean eIF;
    private com.baidu.tieba.tbadkCore.data.e eII;
    private com.baidu.tbadk.editortools.pb.c eIJ;
    private com.baidu.adp.base.e eIM;
    private com.baidu.tbadk.core.view.c eIN;
    private BdUniqueId eIO;
    private Runnable eIP;
    private aq eIQ;
    private com.baidu.adp.widget.a.a eIR;
    private String eIS;
    private TbRichTextMemeInfo eIT;
    private com.baidu.tieba.pb.pb.main.a.b eIb;
    private com.baidu.tbadk.core.dialog.a eIh;
    private boolean eIo;
    private com.baidu.tieba.pb.pb.main.b eIq;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eIv;
    private String eJD;
    private com.baidu.tbadk.core.data.n eJE;
    private boolean eJr;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eIa = false;
    private boolean eIc = false;
    private boolean eId = false;
    private boolean enz = false;
    private boolean eIe = true;
    private int eIf = 0;
    private com.baidu.tbadk.core.dialog.b eIg = null;
    private long cdd = -1;
    private long aJL = 0;
    private long eIi = 0;
    private long createTime = 0;
    private long aJD = 0;
    private boolean eIj = false;
    private com.baidu.tbadk.l.d eIk = null;
    private long eIl = 0;
    private boolean eIm = false;
    private boolean eIn = false;
    private long eIp = 0;
    private String aDp = null;
    private boolean eIr = false;
    private boolean ctQ = false;
    private String eIs = "";
    private boolean eIt = true;
    private boolean eIu = false;
    private String source = "";
    private PbInterviewStatusView.a eIw = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eIy.jG(!PbActivity.this.eIt);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.nG()) {
                        PbActivity.this.aQE();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel eHJ = null;
    private com.baidu.tbadk.baseEditMark.a ejK = null;
    private ForumManageModel eIx = null;
    private an eIy = null;
    public final com.baidu.tieba.pb.pb.main.a.a eIz = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eIA = false;
    private boolean eIB = false;
    private boolean eIC = false;
    private boolean eIE = false;
    private boolean eIG = false;
    private boolean eIH = false;
    private boolean eIK = false;
    private com.baidu.tbadk.editortools.pb.b aDu = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Ds() {
            PbActivity.this.showProgressBar();
        }
    };
    private boolean eIL = false;
    private int mLastScrollState = -1;
    private boolean cqC = false;
    private int eIU = -1;
    private final w.a eIV = new w.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void B(List<PostData> list) {
            if (PbActivity.this.eHJ.getPbData().aPs() != null) {
                List<PostData> list2 = PbActivity.this.eHJ.getPbData().aPs().eFY;
                int size = list2.size();
                if (!com.baidu.tbadk.core.util.v.v(list2)) {
                    PbActivity.this.eHJ.getPbData().aPs().eFY.addAll(size, list);
                }
                PbActivity.this.eHJ.a(PbActivity.this.eHJ.getPbData(), size);
            }
            PbActivity.this.eIy.aTd().a(PbActivity.this.eHJ.getPbData(), true);
            if (PbActivity.this.eIy != null && PbActivity.this.eIy.aTd() != null) {
                PbActivity.this.eIy.aTd().notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eIy.showToast(str);
            }
        }
    };
    private final CustomMessageListener eIW = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eHJ != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eIJ != null) {
                    PbActivity.this.eIy.ht(PbActivity.this.eIJ.DB());
                }
                PbActivity.this.eIy.aSQ();
                PbActivity.this.eIJ.DE();
                PbActivity.this.eIy.aDM();
            }
        }
    };
    CustomMessageListener cqP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.eHJ.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.eIy != null && PbActivity.this.eHJ != null) {
                    PbActivity.this.eIy.d(PbActivity.this.eHJ.getPbData(), PbActivity.this.eHJ.aRD(), PbActivity.this.eHJ.aRU());
                }
                if (PbActivity.this.eIy != null && PbActivity.this.eIy.aTd() != null) {
                    PbActivity.this.eIy.aTd().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eIX = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eIy != null) {
                    if (booleanValue) {
                        PbActivity.this.eIy.ayq();
                    } else {
                        PbActivity.this.eIy.ayp();
                    }
                }
            }
        }
    };
    private CustomMessageListener dSu = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eIJ != null) {
                    PbActivity.this.eIy.ht(PbActivity.this.eIJ.DB());
                }
                PbActivity.this.eIy.hu(false);
            }
        }
    };
    private CustomMessageListener dSQ = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
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
    private CustomMessageListener eIY = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eIy != null && PbActivity.this.eIy.aTd() != null) {
                PbActivity.this.eIy.aTd().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener drO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private i.a eIZ = new i.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        @Override // com.baidu.tieba.pb.pb.main.i.a
        public void j(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.pk(2);
                af.aSE().reset();
                PbActivity.this.eHJ.aRV();
                boolean z2 = false;
                ArrayList<PostData> aPk = PbActivity.this.eHJ.getPbData().aPk();
                if (aPk != null) {
                    Iterator<PostData> it = aPk.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (am.k(next) && next.bsH().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eIy.m(PbActivity.this.eHJ.getPbData());
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
    private View.OnClickListener dSt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aDp);
        }
    };
    CustomMessageListener dca = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eJa = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                as.a aVar = new as.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.Wk = abVar.Wk;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eHJ.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eHJ.aRL() != null && PbActivity.this.eHJ.aRL().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eIy.a(abVar.sendCount, PbActivity.this.eHJ.getPbData(), PbActivity.this.eHJ.aRD(), PbActivity.this.eHJ.aRU());
                    }
                    if (pbData.aPk() != null && pbData.aPk().size() >= 1 && pbData.aPk().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aPk().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eHJ.getThreadID(), 0L);
                        if (c2 == abVar.postId && c3 == abVar.threadId) {
                            as bsG = pbData.aPk().get(0).bsG();
                            if (bsG == null) {
                                bsG = new as();
                            }
                            ArrayList<as.a> qC = bsG.qC();
                            if (qC == null) {
                                qC = new ArrayList<>();
                            }
                            qC.add(0, aVar);
                            bsG.bN(abVar.sendCount + bsG.qB());
                            bsG.g(qC);
                            pbData.aPk().get(0).a(bsG);
                            PbActivity.this.eIy.aTd().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eJb = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.adX() != null && !aVar.adX().isEmpty()) {
                    PbActivity.this.eIy.a(aVar, PbActivity.this.eJc);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.aTZ()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eJc = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aU(PbActivity.this.getPageContext().getPageActivity());
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
    private boolean eJd = false;
    private PraiseModel eJe = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hO(String str) {
            PbActivity.this.eJd = false;
            if (PbActivity.this.eJe != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eHJ.getPbData();
                if (pbData.aPi().rr().getIsLike() == 1) {
                    PbActivity.this.jq(0);
                } else {
                    PbActivity.this.jq(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aPi()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void B(int i, String str) {
            PbActivity.this.eJd = false;
            if (PbActivity.this.eJe != null && str != null) {
                if (AntiHelper.tB(i)) {
                    AntiHelper.ar(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eJf = 0;
    private boolean eJg = true;
    private b.a eJh = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void eu(boolean z) {
            PbActivity.this.je(z);
            if (PbActivity.this.eIy.aTC() != null && z) {
                PbActivity.this.eIy.jG(false);
            }
            PbActivity.this.eIy.jJ(z);
        }
    };
    private CustomMessageListener bgL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().BW) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aPp().getAuthor() != null && PbActivity.this.aPp().getAuthor().getGodUserData() != null) {
                            PbActivity.this.aPp().getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        PbActivity.this.c(updateAttentionMessage);
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        PbActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bqh = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eIy.Sb();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.pl(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.aop();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.l.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eIy.aSR()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && ((PbActivity.this.eHJ == null || PbActivity.this.eHJ.getPbData() == null || !com.baidu.tieba.pb.f.Y(PbActivity.this.eHJ.getPbData().aPi())) && PbActivity.this.eHJ != null && (PbActivity.this.eHJ.getPbData() != null || PbActivity.this.eHJ.getPbData().aPE() != null))) {
                    if (PbActivity.this.eHJ.getPbData().aPE().aPL()) {
                        if (PbActivity.this.eHJ.getPbData().aPE().eFJ == 1 || PbActivity.this.eHJ.getPbData().aPE().eFJ == 3 || PbActivity.this.eHJ.getPbData().aPE().eFJ == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eHJ.getPbData().aPE().aPL() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eHJ.getPbData().aPE().aPL() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eIp > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).kj(false);
                        PbActivity.this.eIp = System.currentTimeMillis();
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
                    if (PbActivity.this.eIy != null && PbActivity.this.eIy.aQo() && (view.getId() == d.h.pb_head_user_info_root || view == PbActivity.this.eIy.aTJ())) {
                        if (view.getTag(d.h.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ad("obj_id", (String) view.getTag(d.h.tag_user_id)));
                        }
                        if (PbActivity.this.eIz != null && PbActivity.this.eIz.eVb != null) {
                            PbActivity.this.eIz.eVb.onClick(view);
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
            if (PbActivity.this.eIJ != null) {
                PbActivity.this.eIy.ht(PbActivity.this.eIJ.DB());
            }
            PbActivity.this.eIy.aSQ();
            PbActivity.this.eIJ.DE();
            PbActivity.this.eIy.aDM();
            return true;
        }
    });
    private CustomMessageListener eJi = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eIO) {
                PbActivity.this.eIy.Sb();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eHJ.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aPv().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eIN.c(PbActivity.this.eIM.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eIM.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    PbActivity.this.ga(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aQV();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eIM.getResources().getString(d.l.mute_fail);
                    }
                    PbActivity.this.eIN.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eJj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eIO) {
                PbActivity.this.eIy.Sb();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eIN.c(PbActivity.this.eIM.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eIM.getResources().getString(d.l.un_mute_fail);
                }
                PbActivity.this.eIN.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eJk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eIO) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eIy.Sb();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gvU;
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
                    PbActivity.this.eIy.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eJl = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eIy.aSR() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aQn() != null && PbActivity.this.aQn().getPbData() != null && PbActivity.this.aQn().getPbData().aPE() != null && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.Y(PbActivity.this.aQn().getPbData().aPi())) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aPL = PbActivity.this.aQn().getPbData().aPE().aPL();
                if (intValue < 10) {
                    if (aPL) {
                        if (PbActivity.this.eHJ.getPbData().aPE().eFJ == 1 || PbActivity.this.eHJ.getPbData().aPE().eFJ == 3 || PbActivity.this.eHJ.getPbData().aPE().eFJ == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eHJ.getPbData().aPE().aPL() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPL ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eIp > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).kj(false);
                        PbActivity.this.eIp = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue / 11, aPL);
                TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aPL ? 0 : 1));
            }
        }
    };
    private CustomMessageListener cra = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cqC = true;
                }
            }
        }
    };
    public a.b exS = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.aho();
            com.baidu.tbadk.core.data.ar asJ = PbActivity.this.eHJ.asJ();
            int pageNum = PbActivity.this.eIy.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.l.pb_page_error);
            } else if (asJ == null || pageNum <= asJ.qu()) {
                PbActivity.this.eIy.aDM();
                PbActivity.this.pk(2);
                PbActivity.this.ahn();
                PbActivity.this.eIy.aTi();
                if (com.baidu.adp.lib.util.i.hi()) {
                    PbActivity.this.eHJ.pr(PbActivity.this.eIy.getPageNum());
                    if (PbActivity.this.eIb != null) {
                        PbActivity.this.eIb.showFloatingView();
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
    public final View.OnClickListener cry = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
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
            com.baidu.tieba.pb.data.l aPE;
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
                    if ((PbActivity.this.eIy.ePk.aUE() != null && PbActivity.this.eIy.ePk.aUE().bm(view)) || PbActivity.this.eIy.aTc() == view || view.getId() == d.h.pb_item_tail_content) {
                        if (PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && com.baidu.tieba.pb.f.Y(PbActivity.this.eHJ.getPbData().aPi())) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (view == PbActivity.this.eIy.getNextView()) {
                        if (!PbActivity.this.mIsLoading && PbActivity.this.eHJ.jm(true)) {
                            PbActivity.this.mIsLoading = true;
                            PbActivity.this.eIy.aTj();
                        }
                    } else if (PbActivity.this.eIy.ePk.aUE() == null || view != PbActivity.this.eIy.ePk.aUE().aSz()) {
                        if (view == PbActivity.this.eIy.ePk.aLF) {
                            if (PbActivity.this.eIy.jL(PbActivity.this.eHJ.aRI())) {
                                PbActivity.this.ahn();
                                return;
                            }
                            PbActivity.this.eIe = false;
                            PbActivity.this.eIc = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eIy.aTg() && (PbActivity.this.eIy.ePk.aUE() == null || (view != PbActivity.this.eIy.ePk.aUE().aSy() && view != PbActivity.this.eIy.ePk.aUE().aSw()))) {
                            if (view == PbActivity.this.eIy.aTx()) {
                                if (PbActivity.this.eHJ != null) {
                                    com.baidu.tbadk.browser.a.T(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eHJ.getPbData().aPi().rA().getLink());
                                }
                            } else if (view != PbActivity.this.eIy.ePk.eVI) {
                                if (view == PbActivity.this.eIy.ePk.eVJ) {
                                    if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null) {
                                        ArrayList<PostData> aPk = PbActivity.this.eHJ.getPbData().aPk();
                                        if ((aPk == null || aPk.size() <= 0) && PbActivity.this.eHJ.aRD()) {
                                            com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ad("tid", PbActivity.this.eHJ.getThreadID()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("fid", PbActivity.this.eHJ.getForumId()));
                                        if (!PbActivity.this.eIy.aTK()) {
                                            PbActivity.this.eIy.aSQ();
                                        }
                                        PbActivity.this.aQv();
                                        return;
                                    }
                                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                } else if (view.getId() != d.h.pb_god_user_tip_content) {
                                    if (PbActivity.this.eIy.ePk.aUE() == null || view != PbActivity.this.eIy.ePk.aUE().aSk()) {
                                        if ((PbActivity.this.eIy.ePk.aUE() == null || view != PbActivity.this.eIy.ePk.aUE().aSv()) && view.getId() != d.h.floor_owner_reply && view.getId() != d.h.reply_title) {
                                            if (PbActivity.this.eIy.ePk.aUE() == null || (view != PbActivity.this.eIy.ePk.aUE().getCancelView() && view != PbActivity.this.eIy.ePk.aUE().Xb())) {
                                                if (view == PbActivity.this.eIy.ePk.eVK || (PbActivity.this.eIy.ePk.aUE() != null && view == PbActivity.this.eIy.ePk.aUE().aSD())) {
                                                    if (PbActivity.this.eHJ != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ad("tid", PbActivity.this.eHJ.getThreadID()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("fid", PbActivity.this.eHJ.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                        if (com.baidu.adp.lib.util.k.hz()) {
                                                            if (PbActivity.this.eHJ.getPbData() != null) {
                                                                ArrayList<PostData> aPk2 = PbActivity.this.eHJ.getPbData().aPk();
                                                                if ((aPk2 != null && aPk2.size() > 0) || !PbActivity.this.eHJ.aRD()) {
                                                                    PbActivity.this.eIy.aDM();
                                                                    PbActivity.this.ahn();
                                                                    PbActivity.this.pk(2);
                                                                    if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && PbActivity.this.eHJ.getPbData().aPA() != null && !StringUtils.isNull(PbActivity.this.eHJ.getPbData().aPA().pR(), true)) {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ad("fid", PbActivity.this.eHJ.getPbData().getForumId()));
                                                                    }
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                    PbActivity.this.eIy.showLoadingDialog();
                                                                    PbActivity.this.eHJ.aSe().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                } else if (PbActivity.this.eIy.ePk.aUE() != null && view == PbActivity.this.eIy.ePk.aUE().aSs()) {
                                                    PbActivity.this.eIy.aDM();
                                                    if (PbActivity.this.eHJ.asJ() != null) {
                                                        PbActivity.this.eIy.a(PbActivity.this.eHJ.asJ(), PbActivity.this.exS);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    return;
                                                } else if (view.getId() == d.h.pb_sort) {
                                                    PbActivity.this.eIy.aDM();
                                                    if (com.baidu.adp.lib.util.i.hi()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Boolean.valueOf(PbActivity.this.eHJ.aRP()));
                                                            return;
                                                        }
                                                        PbActivity.this.pk(2);
                                                        PbActivity.this.ahn();
                                                        PbActivity.this.eIy.aTi();
                                                        PbActivity.this.eIy.aTd().jf(true);
                                                        boolean aRO = PbActivity.this.eHJ.aRO();
                                                        view.setTag(Boolean.valueOf(PbActivity.this.eHJ.aRP()));
                                                        TiebaStatic.log("c12097");
                                                        if (aRO) {
                                                            PbActivity.this.mIsLoading = true;
                                                            PbActivity.this.eIy.jE(true);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    PbActivity.this.showToast(d.l.network_not_available);
                                                    return;
                                                } else if (PbActivity.this.eIy.ePk.aUE() == null || view != PbActivity.this.eIy.ePk.aUE().aSt()) {
                                                    if (PbActivity.this.eIy.ePk.aUE() == null || view != PbActivity.this.eIy.ePk.aUE().aSu()) {
                                                        if (PbActivity.this.eID == null || view != PbActivity.this.eID.aSm()) {
                                                            if (PbActivity.this.eID == null || view != PbActivity.this.eID.aSk()) {
                                                                if (PbActivity.this.eID == null || view != PbActivity.this.eID.aSp()) {
                                                                    if (PbActivity.this.eID == null || view != PbActivity.this.eID.aSn()) {
                                                                        if (PbActivity.this.eID == null || view != PbActivity.this.eID.aSo()) {
                                                                            if (PbActivity.this.eIy.aTC() == view) {
                                                                                if (PbActivity.this.eIy.aTC().getIndicateStatus()) {
                                                                                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eHJ.getPbData();
                                                                                    if (pbData != null && pbData.aPi() != null && pbData.aPi().ri() != null) {
                                                                                        String pC = pbData.aPi().ri().pC();
                                                                                        if (StringUtils.isNull(pC)) {
                                                                                            pC = pbData.aPi().ri().getTaskId();
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ad("obj_id", pC));
                                                                                    }
                                                                                } else {
                                                                                    com.baidu.tieba.tbadkCore.d.a.ci("c10725", null);
                                                                                }
                                                                                PbActivity.this.aQQ();
                                                                                return;
                                                                            } else if (PbActivity.this.eIy.aTc() != view) {
                                                                                if (PbActivity.this.eID == null || view != PbActivity.this.eID.aSl()) {
                                                                                    if (PbActivity.this.eIy.ePk.aUE() == null || view != PbActivity.this.eIy.ePk.aUE().aSA()) {
                                                                                        if (PbActivity.this.eIy.ePk.aUE() != null && view == PbActivity.this.eIy.ePk.aUE().aSx()) {
                                                                                            if (com.baidu.adp.lib.util.i.hi()) {
                                                                                                SparseArray<Object> c2 = PbActivity.this.eIy.c(PbActivity.this.eHJ.getPbData(), PbActivity.this.eHJ.aRD(), 1);
                                                                                                if (c2 != null) {
                                                                                                    PbActivity.this.eIy.a(((Integer) c2.get(d.h.tag_del_post_type)).intValue(), (String) c2.get(d.h.tag_del_post_id), ((Integer) c2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.h.tag_del_post_is_self)).booleanValue());
                                                                                                }
                                                                                                PbActivity.this.eIy.ePk.ol();
                                                                                                return;
                                                                                            }
                                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                                            return;
                                                                                        } else if (view.getId() != d.h.sub_pb_more && view.getId() != d.h.sub_pb_item && view.getId() != d.h.pb_floor_reply_more) {
                                                                                            if (view != PbActivity.this.eIy.aQh()) {
                                                                                                if (view == PbActivity.this.eIy.ePk.aUF()) {
                                                                                                    PbActivity.this.eIy.aTq();
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
                                                                                                        TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", bi.bsM() ? 0 : 1));
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.view_main_thread_praise_state) {
                                                                                                    PbActivity.this.f(view, 2, false);
                                                                                                    if (PbActivity.this.aQn() != null && PbActivity.this.aQn().getPbData() != null && PbActivity.this.aQn().getPbData().aPE() != null && PbActivity.this.aQn().getPbData().aPE() != null) {
                                                                                                        TiebaStatic.log(PbActivity.this.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aQn().getPbData().aPE().aPL() ? 0 : 1));
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.view_main_thread_praise_num || id == d.h.view_main_thread_praise_name_list) {
                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && !StringUtils.isNull(PbActivity.this.eHJ.getPbData().getThreadId()) && (aPE = PbActivity.this.eHJ.getPbData().aPE()) != null && aPE.getPraiseNum() > 0) {
                                                                                                        au.wd().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eHJ.getPbData().getThreadId()});
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
                                                                                                                if (PbActivity.this.eID == null) {
                                                                                                                    PbActivity.this.eID = new v(PbActivity.this.getPageContext(), PbActivity.this.cry);
                                                                                                                    PbActivity.this.eID.jq(PbActivity.this.mIsLogin);
                                                                                                                }
                                                                                                                PbActivity.this.eID.showDialog();
                                                                                                                boolean z6 = id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right;
                                                                                                                if (z6) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ad("tid", PbActivity.this.eHJ.eLV));
                                                                                                                }
                                                                                                                SparseArray sparseArray2 = new SparseArray();
                                                                                                                sparseArray2.put(d.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.h.tag_clip_board));
                                                                                                                sparseArray2.put(d.h.tag_is_subpb, false);
                                                                                                                PbActivity.this.eID.aSk().setTag(sparseArray2);
                                                                                                                PbActivity.this.eID.aSp().setTag(view.getTag());
                                                                                                                PbActivity.this.eID.js(z6);
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
                                                                                                                        PbActivity.this.eID.aSn().setVisibility(0);
                                                                                                                    } else {
                                                                                                                        sparseArray4.put(d.h.tag_should_delete_visible, false);
                                                                                                                        PbActivity.this.eID.aSn().setVisibility(8);
                                                                                                                    }
                                                                                                                    PbActivity.this.eID.aSl().setTag(sparseArray4);
                                                                                                                    PbActivity.this.eID.aSn().setTag(sparseArray4);
                                                                                                                    PbActivity.this.eID.aSl().setText(d.l.bar_manager);
                                                                                                                    PbActivity.this.eID.aSl().setVisibility(0);
                                                                                                                } else if (!booleanValue3) {
                                                                                                                    PbActivity.this.eID.aSl().setVisibility(8);
                                                                                                                    PbActivity.this.eID.aSn().setVisibility(8);
                                                                                                                } else {
                                                                                                                    SparseArray sparseArray5 = new SparseArray();
                                                                                                                    sparseArray5.put(d.h.tag_should_manage_visible, false);
                                                                                                                    sparseArray5.put(d.h.tag_user_mute_visible, false);
                                                                                                                    sparseArray5.put(d.h.tag_should_delete_visible, true);
                                                                                                                    sparseArray5.put(d.h.tag_manage_user_identity, sparseArray3.get(d.h.tag_manage_user_identity));
                                                                                                                    sparseArray5.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                    sparseArray5.put(d.h.tag_del_post_id, sparseArray3.get(d.h.tag_del_post_id));
                                                                                                                    sparseArray5.put(d.h.tag_del_post_type, sparseArray3.get(d.h.tag_del_post_type));
                                                                                                                    PbActivity.this.eID.aSl().setTag(sparseArray5);
                                                                                                                    PbActivity.this.eID.aSn().setTag(sparseArray5);
                                                                                                                    PbActivity.this.eID.aSl().setText(d.l.delete);
                                                                                                                    PbActivity.this.eID.aSn().setVisibility(0);
                                                                                                                    PbActivity.this.eID.aSl().setVisibility(8);
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
                                                                                                                    PbActivity.this.eID.aSm().setTag(sparseArray7);
                                                                                                                    PbActivity.this.eID.aSm().setVisibility(0);
                                                                                                                    PbActivity.this.eID.aSl().setVisibility(8);
                                                                                                                    PbActivity.this.eID.aSm().setText(d.l.mute_option);
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
                                                                                                                    boolean ja = PbActivity.this.ja(z4) & PbActivity.this.isLogin();
                                                                                                                    PbActivity.this.eJv = (PostData) sparseArray6.get(d.h.tag_clip_board);
                                                                                                                    if (am.k(PbActivity.this.eJv) ? false : ja) {
                                                                                                                        PbActivity.this.eID.aSm().setVisibility(0);
                                                                                                                        PbActivity.this.eID.aSm().setTag(str3);
                                                                                                                    } else {
                                                                                                                        PbActivity.this.eID.aSm().setVisibility(8);
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
                                                                                                                    PbActivity.this.eID.aSo().setVisibility(0);
                                                                                                                    PbActivity.this.eID.aSo().setTag(d.h.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                    PbActivity.this.eID.aSo().setTag(d.h.tag_chudian_monitor_id, str);
                                                                                                                    PbActivity.this.eID.aSo().setTag(d.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                } else {
                                                                                                                    PbActivity.this.eID.aSo().setVisibility(8);
                                                                                                                }
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                        if (PbActivity.this.eHJ.getPbData().nG()) {
                                                                                                            String nF = PbActivity.this.eHJ.getPbData().nF();
                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.j.isEmpty(nF) && nF.equals(postData2.getId())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    PbActivity.this.eID.aSk().setText(d.l.remove_mark);
                                                                                                                } else {
                                                                                                                    PbActivity.this.eID.aSk().setText(d.l.mark);
                                                                                                                }
                                                                                                                PbActivity.this.eID.jr(true);
                                                                                                                PbActivity.this.eID.refreshUI();
                                                                                                                return;
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        PbActivity.this.eID.jr(true);
                                                                                                        PbActivity.this.eID.refreshUI();
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.pb_act_btn) {
                                                                                                    if (PbActivity.this.eHJ.getPbData() != null && PbActivity.this.eHJ.getPbData().aPi() != null && PbActivity.this.eHJ.getPbData().aPi().sh() != null) {
                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), PbActivity.this.eHJ.getPbData().aPi().sh());
                                                                                                        if (PbActivity.this.eHJ.getPbData().aPi().sf() != 1) {
                                                                                                            if (PbActivity.this.eHJ.getPbData().aPi().sf() == 2) {
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ad("fid", PbActivity.this.eHJ.getPbData().getForumId()).ad("tid", PbActivity.this.eHJ.getPbData().getThreadId()).ad("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (PbActivity.this.eHJ.getPbData().getThreadId().equals(str4)) {
                                                                                                            PbActivity.this.eIy.setSelection(0);
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
                                                                                                        PbActivity.this.eIy.aSQ();
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.join_vote_tv) {
                                                                                                    if (view != null) {
                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (PbActivity.this.aQs() == 1) {
                                                                                                            if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null) {
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ad("fid", PbActivity.this.eHJ.getPbData().getForumId()).ad("tid", PbActivity.this.eHJ.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        } else if (PbActivity.this.aQs() == 2 && PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null) {
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10401").ad("fid", PbActivity.this.eHJ.getPbData().getForumId()).ad("tid", PbActivity.this.eHJ.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
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
                                                                                                        if (PbActivity.this.aQs() == 1) {
                                                                                                            if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null) {
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ad("fid", PbActivity.this.eHJ.getPbData().getForumId()).ad("tid", PbActivity.this.eHJ.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        } else if (PbActivity.this.aQs() == 2 && PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null) {
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10508").ad("fid", PbActivity.this.eHJ.getPbData().getForumId()).ad("tid", PbActivity.this.eHJ.getPbData().getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                            return;
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.manga_prev_btn) {
                                                                                                    PbActivity.this.aQL();
                                                                                                    return;
                                                                                                } else if (id == d.h.manga_next_btn) {
                                                                                                    PbActivity.this.aQM();
                                                                                                    return;
                                                                                                } else if (id == d.h.yule_head_img_img) {
                                                                                                    if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && PbActivity.this.eHJ.getPbData().aPA() != null) {
                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eHJ.getPbData();
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ad("fid", pbData2.getForumId()));
                                                                                                        au.wd().c(PbActivity.this.getPageContext(), new String[]{pbData2.aPA().aPH()});
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == d.h.yule_head_img_all_rank) {
                                                                                                    if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && PbActivity.this.eHJ.getPbData().aPA() != null) {
                                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eHJ.getPbData();
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ad("fid", pbData3.getForumId()));
                                                                                                        au.wd().c(PbActivity.this.getPageContext(), new String[]{pbData3.aPA().aPH()});
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (PbActivity.this.eIy.ePk.aUE() != null && view == PbActivity.this.eIy.ePk.aUE().aSB()) {
                                                                                                    if (PbActivity.this.eHJ == null || PbActivity.this.eHJ.getPbData() == null || PbActivity.this.eHJ.getPbData().aPi() == null) {
                                                                                                        PbActivity.this.eIy.ePk.ol();
                                                                                                        return;
                                                                                                    } else if (!com.baidu.adp.lib.util.k.hz()) {
                                                                                                        PbActivity.this.showToast(d.l.neterror);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        int i2 = 1;
                                                                                                        if (PbActivity.this.eHJ.getPbData().aPi().rl() == 0) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eHJ.getThreadID(), 25028)));
                                                                                                        } else {
                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.l.haved_fans_called)).tw();
                                                                                                            i2 = 2;
                                                                                                        }
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").r("obj_locate", PbActivity.this.ab(PbActivity.this.eHJ.getPbData().aPi())).ad("tid", PbActivity.this.eHJ.getPbData().aPi().getTid()).r("obj_type", i2));
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eHJ.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eHJ.getThreadID(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eHJ.getPbData().aPi().rV())));
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                            if (PbActivity.this.eHJ.getPbData() != null) {
                                                                                                PbActivity.this.eIy.aDM();
                                                                                                SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                PostData postData3 = (PostData) sparseArray9.get(d.h.tag_load_sub_data);
                                                                                                View view2 = (View) sparseArray9.get(d.h.tag_load_sub_view);
                                                                                                if (postData3 != null && view2 != null) {
                                                                                                    String threadID = PbActivity.this.eHJ.getThreadID();
                                                                                                    String id2 = postData3.getId();
                                                                                                    int i3 = 0;
                                                                                                    if (PbActivity.this.eHJ.getPbData() != null) {
                                                                                                        i3 = PbActivity.this.eHJ.getPbData().aPt();
                                                                                                    }
                                                                                                    if (!com.baidu.tieba.pb.f.d(postData3)) {
                                                                                                        PbActivity.this.ahn();
                                                                                                        if (view.getId() == d.h.replybtn) {
                                                                                                            b pl = PbActivity.this.pl(id2);
                                                                                                            if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && pl != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i3, postData3.aVJ(), PbActivity.this.eHJ.getPbData().qn(), false, postData3.getAuthor().getIconInfo()).addBigImageData(pl.eJY, pl.eJZ, pl.eKa, pl.index)));
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
                                                                                                            b pl2 = PbActivity.this.pl(id2);
                                                                                                            if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && pl2 != null && PbActivity.this.aQm().aSO() != null) {
                                                                                                                com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                                                mVar.b(PbActivity.this.eHJ.getPbData().aPg());
                                                                                                                mVar.Z(PbActivity.this.eHJ.getPbData().aPi());
                                                                                                                mVar.f(postData4);
                                                                                                                PbActivity.this.aQm().aSO().d(mVar);
                                                                                                                PbActivity.this.aQm().aSO().setPostId(str7);
                                                                                                                PbActivity.this.a(view, str6, str5);
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        } else {
                                                                                                            TiebaStatic.log("c11742");
                                                                                                            b pl3 = PbActivity.this.pl(id2);
                                                                                                            if (postData3 != null && PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && pl3 != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i3, postData3.aVJ(), PbActivity.this.eHJ.getPbData().qn(), false, postData3.getAuthor().getIconInfo()).addBigImageData(pl3.eJY, pl3.eJZ, pl3.eKa, pl3.index)));
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
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 3).ad("fid", PbActivity.this.eHJ.getPbData().getForumId()));
                                                                                            return;
                                                                                        }
                                                                                    } else if (com.baidu.adp.lib.util.i.hi()) {
                                                                                        PbActivity.this.eIy.aDM();
                                                                                        SparseArray<Object> c3 = PbActivity.this.eIy.c(PbActivity.this.eHJ.getPbData(), PbActivity.this.eHJ.aRD(), 1);
                                                                                        if (c3 != null) {
                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eHJ.getPbData().aPg().getId(), PbActivity.this.eHJ.getPbData().aPg().getName(), PbActivity.this.eHJ.getPbData().aPi().getId(), String.valueOf(PbActivity.this.eHJ.getPbData().getUserData().getUserId()), (String) c3.get(d.h.tag_forbid_user_name), (String) c3.get(d.h.tag_forbid_user_post_id))));
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
                                                                                        if (!com.baidu.tieba.c.a.WT() || sparseArray11.get(d.h.tag_del_post_id) == null || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eHJ.getThreadID(), (String) sparseArray11.get(d.h.tag_del_post_id))) {
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
                                                                                                PbActivity.this.eIy.bn(view);
                                                                                                return;
                                                                                            } else if (booleanValue5) {
                                                                                                PbActivity.this.eIy.a(((Integer) sparseArray11.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.h.tag_del_post_id), ((Integer) sparseArray11.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.h.tag_del_post_is_self)).booleanValue());
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ad("fid", PbActivity.this.eHJ.getPbData().getForumId()));
                                                                                return;
                                                                            } else {
                                                                                PbActivity.this.aQj();
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
                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eHJ.getPbData();
                                                                        String str9 = null;
                                                                        String str10 = null;
                                                                        String str11 = null;
                                                                        if (pbData4 != null && pbData4.aPg() != null) {
                                                                            str9 = pbData4.aPg().getId();
                                                                            str10 = pbData4.aPg().getName();
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
                                                                        if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.WT() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), PbActivity.this.eHJ.getThreadID(), (String) sparseArray12.get(d.h.tag_del_post_id))) {
                                                                            PbActivity.this.eIy.a(((Integer) sparseArray12.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.h.tag_del_post_id), intValue, booleanValue7);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                if (PbActivity.this.eID.aSr()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ad("tid", PbActivity.this.eHJ.eLV));
                                                                } else {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").r("obj_locate", 1));
                                                                }
                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eHJ.getPbData() != null) {
                                                                    PbActivity.this.eIy.aDM();
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
                                                                        String threadID2 = PbActivity.this.eHJ.getThreadID();
                                                                        String id3 = postData.getId();
                                                                        int i5 = 0;
                                                                        if (PbActivity.this.eHJ.getPbData() != null) {
                                                                            i5 = PbActivity.this.eHJ.getPbData().aPt();
                                                                        }
                                                                        PbActivity.this.ahn();
                                                                        b pl4 = PbActivity.this.pl(id3);
                                                                        if (pl4 != null) {
                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID2, id3, "pb", true, null, true, null, i5, postData.aVJ(), PbActivity.this.eHJ.getPbData().qn(), false, postData.getAuthor().getIconInfo()).addBigImageData(pl4.eJY, pl4.eJZ, pl4.eKa, pl4.index)));
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
                                                            PbActivity.this.pi((String) tag);
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
                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), null, PbActivity.this.aQr(), true)));
                                                    PbActivity.this.eIy.ePk.ol();
                                                    PbActivity.this.eIy.ePk.aUE().aSC();
                                                    return;
                                                } else if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && PbActivity.this.eHJ.getPbData().aPi() != null) {
                                                    PbActivity.this.eIy.ePk.ol();
                                                    PbActivity.this.pi(PbActivity.this.eHJ.getPbData().aPi().rR());
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            PbActivity.this.eIy.ePk.ol();
                                        } else if (com.baidu.adp.lib.util.i.hi()) {
                                            PbActivity.this.eIy.aDM();
                                            if (PbActivity.this.eIy.ePk.aUE() != null && view == PbActivity.this.eIy.ePk.aUE().aSv() && !PbActivity.this.eIy.aTK()) {
                                                PbActivity.this.eIy.aSQ();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.ahn();
                                                PbActivity.this.eIy.aTi();
                                                if (view.getId() == d.h.floor_owner_reply) {
                                                    j = PbActivity.this.eHJ.j(true, PbActivity.this.aQJ());
                                                } else {
                                                    j = view.getId() == d.h.reply_title ? PbActivity.this.eHJ.j(false, PbActivity.this.aQJ()) : PbActivity.this.eHJ.po(PbActivity.this.aQJ());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.eIy.jj(true);
                                                    PbActivity.this.eIy.ayq();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.eIy.jE(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.pk(2);
                                                return;
                                            }
                                            view.setTag(Boolean.FALSE);
                                        } else {
                                            PbActivity.this.showToast(d.l.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                        }
                                    } else if (com.baidu.adp.lib.util.i.hi()) {
                                        PbActivity.this.eIy.aDM();
                                        if (PbActivity.this.pj(11009) && PbActivity.this.eHJ.py(PbActivity.this.eIy.aTn()) != null) {
                                            PbActivity.this.aQD();
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.l.network_not_available);
                                    }
                                } else if (com.baidu.adp.lib.util.i.hi()) {
                                    PbActivity.this.eIy.jj(true);
                                    PbActivity.this.eIy.aSQ();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eIy.ayq();
                                        PbActivity.this.ahn();
                                        PbActivity.this.eIy.aTi();
                                        PbActivity.this.eHJ.po(PbActivity.this.aQJ());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.pk(2);
                                    }
                                } else {
                                    PbActivity.this.showToast(d.l.network_not_available);
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.eHJ.getPbData() != null && PbActivity.this.eHJ.getPbData().aPi() != null && PbActivity.this.eHJ.getPbData().aPi().so() && PbActivity.this.eHJ.getPbData().aPi().rS() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.eHJ.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eHJ.aRC()) && PbActivity.this.eHJ.getAppealInfo() != null) {
                                        name = PbActivity.this.eHJ.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eHJ.getPbData().aPg().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aRC = PbActivity.this.eHJ.aRC();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eHJ.aRE() && aRC != null && aRC.equals(name)) {
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
                            if (PbActivity.this.eHJ.getPbData().aPt() == 1 && !PbActivity.this.eIx.btl()) {
                                PbActivity.this.eIy.aDM();
                                int i6 = 0;
                                if (PbActivity.this.eIy.ePk.aUE() == null || view != PbActivity.this.eIy.ePk.aUE().aSw()) {
                                    if (PbActivity.this.eIy.ePk.aUE() == null || view != PbActivity.this.eIy.ePk.aUE().aSy()) {
                                        if (view == PbActivity.this.eIy.aTg()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eHJ.getPbData().aPi().rx() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eHJ.getPbData().aPi().rw() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aPg = PbActivity.this.eHJ.getPbData().aPg();
                                String name2 = aPg.getName();
                                String id4 = aPg.getId();
                                String id5 = PbActivity.this.eHJ.getPbData().aPi().getId();
                                if (!com.baidu.tieba.c.a.WT() || !com.baidu.tieba.c.a.i(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eIy.aTf();
                                    PbActivity.this.eIx.a(id4, name2, id5, i6, PbActivity.this.eIy.aTh());
                                }
                            }
                        } else {
                            PbActivity.this.showToast(d.l.network_not_available);
                        }
                    } else if (com.baidu.adp.lib.util.i.hi()) {
                        PbActivity.this.eIy.aDM();
                        PbActivity.this.ahn();
                        PbActivity.this.eIy.aTi();
                        PbActivity.this.eIy.showLoadingDialog();
                        if (PbActivity.this.eIy.aST() != null) {
                            PbActivity.this.eIy.aST().setVisibility(8);
                        }
                        PbActivity.this.eHJ.pr(1);
                        if (PbActivity.this.eIb != null) {
                            PbActivity.this.eIb.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.l.network_not_available);
                    }
                } else if (PbActivity.this.eIn) {
                    PbActivity.this.eIn = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.h.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && PbActivity.this.aQm().aSO() != null && postData5.getAuthor() != null && postData5.bsz() != 1 && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.d(postData5)) {
                                com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                                mVar2.b(PbActivity.this.eHJ.getPbData().aPg());
                                mVar2.Z(PbActivity.this.eHJ.getPbData().aPi());
                                mVar2.f(postData5);
                                PbActivity.this.aQm().aSO().d(mVar2);
                                PbActivity.this.aQm().aSO().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.getAuthor().getUserId(), "");
                                TiebaStatic.log("c11743");
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aDB = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.ahn();
            PbActivity.this.eIy.jH(z);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbActivity.this.eIy.aDM();
                if (PbActivity.this.eIJ != null) {
                    PbActivity.this.eIy.ht(PbActivity.this.eIJ.DB());
                }
                PbActivity.this.eIy.aSN();
                PbActivity.this.eIy.hu(true);
                PbActivity.this.eHJ.aRR();
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eHJ.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eHJ.getPbData();
                            if (pbData != null && pbData.aPi() != null && pbData.aPi().getAuthor() != null && (userId = pbData.aPi().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && PbActivity.this.eHJ.aRK()) {
                                PbActivity.this.eIy.aTi();
                            }
                        } else if (PbActivity.this.eHJ.aRK()) {
                            PbActivity.this.eIy.aTi();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eIy.m(PbActivity.this.eHJ.getPbData());
                    }
                    if (PbActivity.this.eHJ.aRH()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ad("tid", PbActivity.this.eHJ.getThreadID()));
                    }
                }
            } else if (qVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    private final PbModel.a eJm = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eC;
            if (!z || fVar == null || fVar.aPr() != null || com.baidu.tbadk.core.util.v.u(fVar.aPk()) >= 1) {
                PbActivity.this.enz = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eIy.aTk();
                if (fVar == null || !fVar.aPo()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eIy.getView());
                } else if (PbActivity.this.eIy.aSL() == null) {
                    PbActivity.this.eIL = true;
                }
                PbActivity.this.eIy.ayp();
                PbActivity.this.eIy.aTe();
                if (PbActivity.this.ctQ || PbActivity.this.eIy.aTK()) {
                    PbActivity.this.eIy.aTA();
                } else {
                    PbActivity.this.eIy.hu(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eIE = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eIy.NI();
                    PbActivity.this.eIy.jN(fVar.aPo());
                    if (fVar.aPi() != null && fVar.aPi().sx() != null) {
                        PbActivity.this.a(fVar.aPi().sx());
                    }
                    if (PbActivity.this.eIJ != null) {
                        PbActivity.this.eIy.ht(PbActivity.this.eIJ.DB());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aPk() != null && fVar.aPk().size() >= 1 && fVar.aPk().get(0) != null) {
                        PbActivity.this.eHJ.pq(fVar.aPk().get(0).getId());
                    } else if (fVar.aPr() != null) {
                        PbActivity.this.eHJ.pq(fVar.aPr().getId());
                    }
                    if (PbActivity.this.eIJ != null) {
                        PbActivity.this.eIJ.a(fVar.qn());
                        PbActivity.this.eIJ.a(fVar.aPg(), fVar.getUserData());
                        PbActivity.this.eIJ.a(PbActivity.this.eHJ.aRL(), PbActivity.this.eHJ.getThreadID(), PbActivity.this.eHJ.aSg());
                        if (fVar.aPi() != null) {
                            PbActivity.this.eIJ.bK(fVar.aPi().sN());
                        }
                    }
                    if (PbActivity.this.ejK != null) {
                        PbActivity.this.ejK.ac(fVar.nG());
                    }
                    if (fVar == null || fVar.aPu() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eIy.jM(PbActivity.this.mIsFromCDN);
                    PbActivity.this.eIy.a(fVar, i2, i3, PbActivity.this.eHJ.aRD(), i4, PbActivity.this.eHJ.getIsFromMark());
                    PbActivity.this.eIy.d(fVar, PbActivity.this.eHJ.aRD());
                    PbActivity.this.eIy.jK(PbActivity.this.eHJ.getHostMode());
                    AntiData qn = fVar.qn();
                    if (qn != null) {
                        PbActivity.this.aDp = qn.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aDp) && PbActivity.this.eIJ != null && PbActivity.this.eIJ.CV() != null && (eC = PbActivity.this.eIJ.CV().eC(6)) != null && !TextUtils.isEmpty(PbActivity.this.aDp)) {
                            ((View) eC).setOnClickListener(PbActivity.this.dSt);
                        }
                    }
                    com.baidu.tieba.pb.f.oY(fVar.eFz);
                    if (PbActivity.this.eIG) {
                        PbActivity.this.eIG = false;
                        PbActivity.this.aQm().getListView().setSelection(PbActivity.this.aQx());
                    }
                    if (PbActivity.this.eIH) {
                        PbActivity.this.eIH = false;
                        int aQx = PbActivity.this.aQx();
                        if (aQx == -1) {
                            aQx = PbActivity.this.aQy();
                        }
                        if (PbActivity.this.aQm() != null && PbActivity.this.aQm().getListView() != null) {
                            PbActivity.this.aQm().getListView().setSelection(aQx);
                        }
                    } else {
                        PbActivity.this.eIy.aTo();
                    }
                    PbActivity.this.eHJ.a(fVar.aPg(), PbActivity.this.eJb);
                } else if (str != null) {
                    if (!PbActivity.this.eIE && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eHJ.getAppealInfo().eEU)) {
                                    PbActivity.this.eIy.a(PbActivity.this.eHJ.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eIy.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.f(PbActivity.this.getApplicationContext(), d.f.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eIy.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.f(PbActivity.this.getApplicationContext(), d.f.ds200));
                            }
                            PbActivity.this.eIy.aTA();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.eHJ.getThreadID());
                            jSONObject.put("fid", PbActivity.this.eHJ.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, jSONObject));
                    }
                    if (i != -1) {
                        PbActivity.this.eIy.pr(PbActivity.this.getResources().getString(d.l.list_no_more_new));
                    } else {
                        PbActivity.this.eIy.pr("");
                    }
                    PbActivity.this.eIy.wW();
                }
                PbActivity.this.aJL = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aQn().aRD() || PbActivity.this.aQn().getPbData().qD().qA() != 0 || PbActivity.this.aQn().aRY()) {
                    PbActivity.this.eIK = true;
                    return;
                }
                return;
            }
            PbActivity.this.eHJ.pr(1);
            if (PbActivity.this.eIb != null) {
                PbActivity.this.eIb.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void d(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eIy.m(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.r.Gx().Gy()) {
                com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m(i, z, responsedMessage, PbActivity.this.aJD, PbActivity.this.createTime, PbActivity.this.aJL, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.cdd : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aJD = 0L;
                if (mVar != null) {
                    mVar.Gs();
                }
            }
        }
    };
    private CustomMessageListener eJn = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aQs() == 1) {
                    PbActivity.this.aQB();
                }
                PbActivity.this.aQt();
            }
        }
    };
    private final a.InterfaceC0041a eJo = new a.InterfaceC0041a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0041a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eIy.aTk();
            if (z) {
                if (PbActivity.this.ejK != null) {
                    PbActivity.this.ejK.ac(z2);
                }
                PbActivity.this.eHJ.jo(z2);
                if (PbActivity.this.eHJ.nG()) {
                    PbActivity.this.aQE();
                } else {
                    PbActivity.this.eIy.m(PbActivity.this.eHJ.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.ejK != null) {
                        if (PbActivity.this.ejK.nJ() != null) {
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
            if (!PbActivity.this.pi(PbActivity.this.mLastScrollState) && PbActivity.this.pi(i)) {
                if (PbActivity.this.eIy != null) {
                    PbActivity.this.eIy.aDM();
                    if (PbActivity.this.eIJ != null && !PbActivity.this.eIy.aSR()) {
                        PbActivity.this.eIy.ht(PbActivity.this.eIJ.DB());
                    }
                    PbActivity.this.eIy.aSQ();
                }
                if (!PbActivity.this.eIj) {
                    PbActivity.this.eIj = true;
                    PbActivity.this.eIy.aTz();
                }
            }
            PbActivity.this.eIy.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eIb != null) {
                PbActivity.this.eIb.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eIk == null) {
                PbActivity.this.eIk = new com.baidu.tbadk.l.d();
                PbActivity.this.eIk.fi(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && PbActivity.this.eHJ.getPbData().aPi() != null && PbActivity.this.eHJ.getPbData().aPi().so()) {
                    z = false;
                }
                if (PbActivity.this.eIy.aTd() != null && z) {
                    PbActivity.this.eIy.aTd().notifyDataSetChanged();
                }
                PbActivity.this.eIk.Ge();
            } else if (i == 1) {
                PbActivity.this.eIk.Ge();
            } else {
                PbActivity.this.eIk.Ge();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aPk;
            if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null && PbActivity.this.eIy != null && PbActivity.this.eIy.aTd() != null) {
                PbActivity.this.eIy.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eIb != null) {
                    PbActivity.this.eIb.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eHJ.aRT() && (aPk = PbActivity.this.eHJ.getPbData().aPk()) != null && !aPk.isEmpty()) {
                    int aRk = ((i + i2) - PbActivity.this.eIy.aTd().aRk()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eHJ.getPbData();
                    if (pbData != null) {
                        if (pbData.aPl() != null && pbData.aPl().hasData()) {
                            aRk--;
                        }
                        if (pbData.aPm() != null && pbData.aPm().hasData()) {
                            aRk--;
                        }
                        if (PbActivity.this.eIm) {
                            aRk--;
                        }
                        int size = aPk.size();
                        if (aRk < 0 || aRk >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eJp = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eIx.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eHJ.aRR();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cQT || bVar.eXA <= 0 || bVar.gls == 0) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eIy.a(1, dVar.Ai, dVar.glu, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eIx.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eIy.a(PbActivity.this.eIx.getLoadDataMode(), fVar.Ai, fVar.glu, false);
                        PbActivity.this.eIy.al(fVar.glw);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eIy.a(PbActivity.this.eIx.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final c eJq = new c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
    };
    private final k.b bag = new k.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aQK()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eHJ.jn(true)) {
                PbActivity.this.eIy.aTl();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eJs = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eJr && PbActivity.this.aQK()) {
                PbActivity.this.aQM();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eHJ.jm(false)) {
                    PbActivity.this.eIy.aTj();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eHJ.getPbData() != null) {
                    PbActivity.this.eIy.aTy();
                }
                PbActivity.this.eJr = true;
            }
        }
    };
    private int eJt = 0;
    private final TbRichTextView.e aRv = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
        public void a(View view, String str, int i) {
            TbRichTextData tbRichTextData;
            try {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                b bVar = new b();
                PbActivity.this.a(str, i, bVar);
                if (bVar.eKc) {
                    TbRichText an = PbActivity.this.an(str, i);
                    if (an != null && (tbRichTextData = an.Iv().get(PbActivity.this.eJt)) != null && tbRichTextData.IH() != null && tbRichTextData.IH().memeInfo != null && !TextUtils.isEmpty(tbRichTextData.IH().memeInfo.detail_link)) {
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextData.IH().memeInfo.detail_link)));
                    }
                } else if (!bVar.eKb) {
                    ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eJY, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eKa, bVar.eJY.get(0), PbActivity.this.eHJ.aRP(), bVar.eJZ, true, false, PbActivity.this.eHJ.getHostMode());
                    createConfig.getIntent().putExtra("from", "pb");
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                } else {
                    TbRichText an2 = PbActivity.this.an(str, i);
                    if (an2 != null && PbActivity.this.eJt >= 0 && PbActivity.this.eJt < an2.Iv().size()) {
                        String c2 = com.baidu.tieba.pb.data.g.c(an2.Iv().get(PbActivity.this.eJt));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= bVar.eJY.size()) {
                                break;
                            } else if (!bVar.eJY.get(i3).equals(c2)) {
                                i2 = i3 + 1;
                            } else {
                                bVar.index = i3;
                                break;
                            }
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eJY, bVar.index, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eKa, bVar.lastId, PbActivity.this.eHJ.aRP(), bVar.eJZ, true, false, PbActivity.this.eHJ.getHostMode());
                        createConfig2.getIntent().putExtra("from", "pb");
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eJu = false;
    PostData eJv = null;
    private final b.InterfaceC0046b eJw = new b.InterfaceC0046b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eJv != null) {
                if (i == 0) {
                    PbActivity.this.eJv.bZ(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eJv = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.h(PbActivity.this.eJv);
                }
            }
        }
    };
    private final b.InterfaceC0046b eJx = new b.InterfaceC0046b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eIR != null && !TextUtils.isEmpty(PbActivity.this.eIS)) {
                if (i == 0) {
                    if (PbActivity.this.eIT == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eIS));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eIS;
                        aVar.pkgId = PbActivity.this.eIT.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eIT.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eIQ == null) {
                        PbActivity.this.eIQ = new aq(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eIQ.i(PbActivity.this.eIS, PbActivity.this.eIR.kR());
                }
                PbActivity.this.eIR = null;
                PbActivity.this.eIS = null;
            }
        }
    };
    private final View.OnLongClickListener avy = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eIR = ((TbImageView) view).getBdImage();
                PbActivity.this.eIS = ((TbImageView) view).getUrl();
                if (PbActivity.this.eIR != null && !TextUtils.isEmpty(PbActivity.this.eIS)) {
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eIT = null;
                    } else {
                        PbActivity.this.eIT = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eIy.a(PbActivity.this.eJx, PbActivity.this.eIR.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eJv = (PostData) sparseArray.get(d.h.tag_clip_board);
                    if (PbActivity.this.eJv != null && PbActivity.this.ejK != null) {
                        PbActivity.this.eIy.a(PbActivity.this.eJw, PbActivity.this.ejK.nG() && PbActivity.this.eJv.getId() != null && PbActivity.this.eJv.getId().equals(PbActivity.this.eHJ.rK()), ((Boolean) sparseArray.get(d.h.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a bJq = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!PbActivity.this.eId && z && !PbActivity.this.eHJ.aRJ()) {
                PbActivity.this.Xm();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.f(PbActivity.this.getApplicationContext(), d.f.ds200));
        }
    };
    public View.OnTouchListener aMx = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).arL()) {
                        break;
                    }
                }
            }
            PbActivity.this.csZ.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0081a caG = new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        final int bAv;

        {
            this.bAv = (int) PbActivity.this.getResources().getDimension(d.f.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ak(int i, int i2) {
            if (N(i2) && PbActivity.this.eIy != null && PbActivity.this.eIb != null) {
                PbActivity.this.eIb.es(false);
                PbActivity.this.eIb.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void al(int i, int i2) {
            if (N(i2) && PbActivity.this.eIy != null && PbActivity.this.eIb != null) {
                PbActivity.this.eIb.es(true);
                if (Math.abs(i2) > this.bAv) {
                    PbActivity.this.eIb.hideFloatingView();
                }
                if (PbActivity.this.aQK()) {
                    PbActivity.this.eIy.aSZ();
                    PbActivity.this.eIy.aTa();
                }
            }
        }

        private boolean N(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eJy = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // com.baidu.tieba.e.b.a
        public void ej(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aQa();
            } else {
                com.baidu.tieba.pb.a.b.aPZ();
            }
        }
    };
    private String eJz = null;
    private final m.a eJA = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.l.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eJz = str2;
                PbActivity.this.eIy.ps(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eJB = -1;
    private int eJC = -1;
    private CustomMessageListener eJF = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Td == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0044a) {
                    if (aVar.Te != null && !aVar.Te.hasError() && aVar.Te.getError() == 0) {
                        if (PbActivity.this.eIy != null) {
                            PbActivity.this.eIy.w(((a.C0044a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aQW();
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
                        if (PbActivity.this.eIy != null && PbActivity.this.eIy != null) {
                            PbActivity.this.eIy.w(((a.C0044a) aVar).channelId, 2);
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
    private final CustomMessageListener cqT = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
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
            PbActivity.this.eIy.aTM();
        }

        @Override // com.baidu.adp.widget.d.b
        public void X(boolean z) {
            if (z) {
                PbActivity.this.eIy.aTN();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void f(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> eJY;
        public ConcurrentHashMap<String, ImageUrlData> eJZ;
        public boolean eKb;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eKa = false;
        public boolean eKc = false;
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

    public com.baidu.tbadk.editortools.pb.c aQi() {
        return this.eIJ;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar.aPQ() != null) {
            String id = mVar.aPQ().getId();
            ArrayList<PostData> aPk = this.eHJ.getPbData().aPk();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aPk.size()) {
                    break;
                }
                PostData postData = aPk.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aPU = mVar.aPU();
                    postData.tv(mVar.getTotalCount());
                    if (postData.bsw() != null) {
                        postData.bsw().clear();
                        postData.bsw().addAll(aPU);
                    }
                }
            }
            this.eIy.m(this.eHJ.getPbData());
            c(mVar);
        }
    }

    public void aQj() {
        com.baidu.tieba.pb.data.f pbData;
        bj aPi;
        if (!this.eJd) {
            if (!com.baidu.adp.lib.util.k.hz()) {
                showToast(d.l.no_network_guide);
            } else if (this.eJg) {
                this.eJd = true;
                if (this.eHJ != null && (pbData = this.eHJ.getPbData()) != null && (aPi = pbData.aPi()) != null) {
                    int isLike = aPi.rr() == null ? 0 : aPi.rr().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ad("tid", aPi.getId()));
                    }
                    if (this.eJe != null) {
                        this.eJe.a(aPi.rR(), aPi.getId(), isLike, "pb");
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
                    bVar.a(strArr, new b.InterfaceC0046b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.eIy.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eIO);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eIO);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.l.un_mute) : getResources().getString(d.l.mute);
                    bVar.a(strArr2, new b.InterfaceC0046b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eIO);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eIO);
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
    public void jq(int i) {
        bj aPi;
        String str;
        String y;
        if (this.eHJ != null && this.eHJ.getPbData() != null && (aPi = this.eHJ.getPbData().aPi()) != null) {
            if (i == 1) {
                PraiseData rr = aPi.rr();
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
                        aPi.a(praiseData);
                    } else {
                        aPi.rr().getUser().add(0, metaData);
                        aPi.rr().setNum(aPi.rr().getNum() + 1);
                        aPi.rr().setIsLike(i);
                    }
                }
                if (aPi.rr() != null) {
                    if (aPi.rr().getNum() < 1) {
                        y = getResources().getString(d.l.frs_item_praise_text);
                    } else {
                        y = com.baidu.tbadk.core.util.am.y(aPi.rr().getNum());
                    }
                    this.eIy.U(y, true);
                }
            } else if (aPi.rr() != null) {
                aPi.rr().setIsLike(i);
                aPi.rr().setNum(aPi.rr().getNum() - 1);
                ArrayList<MetaData> user = aPi.rr().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aPi.rr().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aPi.rr().getNum() < 1) {
                    str = getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = aPi.rr().getNum() + "";
                }
                this.eIy.U(str, false);
            }
            if (this.eHJ.aRD()) {
                this.eIy.aTd().notifyDataSetChanged();
            } else {
                this.eIy.n(this.eHJ.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.adp.framework.message.Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().asv && !StringUtils.isNull(updateAttentionMessage.getData().asw, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().asw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eHJ != null && this.eHJ.getPbData() != null && this.eIy != null) {
            this.eIy.d(this.eHJ.getPbData(), this.eHJ.aRD(), this.eHJ.aRU());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eHJ.t(bundle);
        if (this.cpV != null) {
            this.cpV.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eIJ.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eIM = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cdd = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eIs = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eIs)) {
                this.eIc = true;
            }
            this.eJB = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eJC = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eJD = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eIG = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eIH = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aQK()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.eIU = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.eIo = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.cdd = System.currentTimeMillis();
        }
        this.eIi = System.currentTimeMillis();
        this.aJD = this.eIi - this.cdd;
        super.onCreate(bundle);
        this.mSwipeBackLayout.setOnSlidingStateChangeListener(this.Ib);
        this.eIf = 0;
        v(bundle);
        if (this.eHJ != null && this.eHJ.getPbData() != null) {
            this.eHJ.getPbData().pe(this.source);
        }
        initUI();
        if (intent != null && this.eIy != null) {
            this.eIy.ePd = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eIP == null) {
                    this.eIP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eIy.pu("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eIP, 1500L);
            }
        }
        this.cpV = new VoiceManager();
        this.cpV.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
        dVar.setForumName(this.eHJ.aRC());
        if (this.eHJ.getPbData() != null && this.eHJ.getPbData().aPg() != null) {
            dVar.setForumId(this.eHJ.getPbData().aPg().getId());
        }
        dVar.setFrom("pb");
        dVar.a(this.eHJ);
        this.eIJ = (com.baidu.tbadk.editortools.pb.c) dVar.aX(getActivity());
        this.eIJ.d(this);
        this.eIJ.a(this.aDB);
        this.eIJ.a(this.aDu);
        this.eIJ.a(this, bundle);
        this.eIJ.CV().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eIJ.CV().bD(true);
        iZ(true);
        this.eIy.setEditorTools(this.eIJ.CV());
        this.eIJ.a(this.eHJ.aRL(), this.eHJ.getThreadID(), this.eHJ.aSg());
        registerListener(this.dSu);
        if (!this.eHJ.aRI()) {
            this.eIJ.fU(this.eHJ.getThreadID());
        }
        if (this.eHJ.aSh()) {
            this.eIJ.fS(getPageContext().getString(d.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eIJ.fS(getPageContext().getString(d.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eIi;
        registerListener(this.eIX);
        registerListener(this.dSQ);
        registerListener(this.eIY);
        registerListener(this.cqP);
        registerListener(this.eJl);
        registerListener(this.eIW);
        this.eII = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.giC);
        this.eII.bsa();
        registerListener(this.eJa);
        registerListener(this.bgL);
        if (this.eHJ != null) {
            this.eHJ.aRW();
        }
        registerListener(this.eJn);
        registerListener(this.eJF);
        registerListener(this.cra);
        this.eIq = new com.baidu.tieba.pb.pb.main.b(this.eHJ, this);
        if (this.eIy != null && this.eIy.aTD() != null && this.eIy.aTE() != null) {
            this.eIb = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eIy.aTD(), this.eIy.aTE(), this.eIy.aST());
            this.eIb.a(this.eJh);
        }
        if (this.eIa && this.eIy != null && this.eIy.aTE() != null) {
            this.eIy.aTE().setVisibility(8);
        }
        this.eIN = new com.baidu.tbadk.core.view.c();
        this.eIN.akG = 1000L;
        registerListener(this.eJk);
        registerListener(this.eJi);
        registerListener(this.eJj);
        this.eIO = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eIO;
        userMuteAddAndDelCustomMessage.setTag(this.eIO);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eIO;
        userMuteCheckCustomMessage.setTag(this.eIO);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eHJ.aSe().a(this.bqh);
        if ("from_tieba_kuang".equals(this.eIs)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 2).ad("tid", this.eHJ.getThreadID()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    public String aQk() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aQl() {
        return this.eIb;
    }

    private void iZ(boolean z) {
        this.eIJ.bH(z);
        this.eIJ.bI(z);
        this.eIJ.bJ(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cpV != null) {
            this.cpV.onStart(getPageContext());
        }
    }

    public an aQm() {
        return this.eIy;
    }

    public PbModel aQn() {
        return this.eHJ;
    }

    public void pg(String str) {
        if (this.eHJ != null && !StringUtils.isNull(str) && this.eIy != null) {
            this.eIy.aTe();
            this.eIy.jP(true);
            this.eHJ.pg(str);
            this.eIr = true;
            this.eIy.aDM();
            this.eIy.aTA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eId = false;
        } else {
            this.eId = true;
        }
        super.onPause();
        if (this.eIy.aSL() != null && this.eIy.aSL().aQf() != null) {
            this.eIy.aSL().aQf().onPause();
        }
        BdListView listView = getListView();
        this.eIf = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eIf == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cpV != null) {
            this.cpV.onPause(getPageContext());
        }
        if (this.eIy != null) {
            this.eIy.onPause();
        }
        if (!this.eHJ.aRI()) {
            this.eIJ.fT(this.eHJ.getThreadID());
        }
        if (this.eHJ != null) {
            this.eHJ.aRX();
        }
        MessageManager.getInstance().unRegisterListener(this.drO);
        asf();
        MessageManager.getInstance().unRegisterListener(this.eJi);
        MessageManager.getInstance().unRegisterListener(this.eJj);
        MessageManager.getInstance().unRegisterListener(this.eJk);
        MessageManager.getInstance().unRegisterListener(this.cqT);
        MessageManager.getInstance().unRegisterListener(this.dca);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aQo() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eHJ.getPbData(), this.eHJ.aRD(), this.eHJ.aRU());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eId = false;
        super.onResume();
        if (this.eIu) {
            this.eIu = false;
            aQQ();
        }
        if (this.eIy.aSL() != null && this.eIy.aSL().aQf() != null) {
            this.eIy.aSL().aQf().onResume();
        }
        if (aQo()) {
            this.eIl = System.currentTimeMillis();
        } else {
            this.eIl = -1L;
        }
        if (this.eIy != null && this.eIy.getView() != null) {
            if (!this.enz) {
                aQH();
            } else {
                hideLoadingView(this.eIy.getView());
            }
            this.eIy.onResume();
        }
        if (this.eIf == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eIy != null) {
            noNetworkView = this.eIy.aSM();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hi()) {
            noNetworkView.aL(false);
        }
        if (this.cpV != null) {
            this.cpV.onResume(getPageContext());
        }
        registerListener(this.drO);
        this.eIF = false;
        aQP();
        registerListener(this.eJi);
        registerListener(this.eJj);
        registerListener(this.eJk);
        registerListener(this.cqT);
        registerListener(this.dca);
        if (this.cqC) {
            Xm();
            this.cqC = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eIy.jF(z);
        if (this.eID != null) {
            this.eID.jq(z);
        }
        if (z && this.eIF) {
            this.eIy.aTj();
            this.eHJ.jm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eIl > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ad("obj_duration", (System.currentTimeMillis() - this.eIl) + ""));
            this.eIl = 0L;
        }
        if (this.eIJ != null && this.eIJ.CV() != null && this.eIJ.CV().getVisibility() != 0) {
            this.eIJ.DE();
        }
        if (aQm().aSP() != null) {
            aQm().aSP().onStop();
        }
        if (this.eIy.ePk != null && !this.eIy.ePk.YQ()) {
            this.eIy.ePk.aEd();
        }
        if (this.eHJ != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPg() != null && this.eHJ.getPbData().aPi() != null) {
            com.baidu.tbadk.distribute.a.CF().a(getPageContext().getPageActivity(), "pb", this.eHJ.getPbData().aPg().getId(), com.baidu.adp.lib.g.b.c(this.eHJ.getPbData().aPi().getId(), 0L));
        }
        if (this.cpV != null) {
            this.cpV.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.eIq != null) {
            this.eIq.destroy();
        }
        if (!this.eIj && this.eIy != null) {
            this.eIj = true;
            this.eIy.aTz();
            a(false, (PostData) null);
        }
        if (this.eHJ != null) {
            this.eHJ.cancelLoadData();
            this.eHJ.destory();
            if (this.eHJ.aSd() != null) {
                this.eHJ.aSd().onDestroy();
            }
        }
        if (this.eIJ != null) {
            this.eIJ.onDestroy();
        }
        if (this.eIx != null) {
            this.eIx.cancelLoadData();
        }
        if (this.eIy != null) {
            this.eIy.onDestroy();
            if (this.eIy.ePk != null) {
                this.eIy.ePk.aEd();
            }
        }
        if (this.eIk != null) {
            this.eIk.onDestroy();
        }
        if (this.eIb != null) {
            this.eIb.Hn();
        }
        super.onDestroy();
        if (this.cpV != null) {
            this.cpV.onDestory(getPageContext());
        }
        if (this.cqp != null) {
            this.cqp.destory();
        }
        this.eIy.aDM();
        MessageManager.getInstance().unRegisterListener(this.eJi);
        MessageManager.getInstance().unRegisterListener(this.eJj);
        MessageManager.getInstance().unRegisterListener(this.eJk);
        MessageManager.getInstance().unRegisterListener(this.eIO);
        MessageManager.getInstance().unRegisterListener(this.eJl);
        MessageManager.getInstance().unRegisterListener(this.cra);
        this.eIM = null;
        this.eIN = null;
        com.baidu.tieba.recapp.d.a.bhT().bhV();
        if (this.eIP != null) {
            getSafeHandler().removeCallbacks(this.eIP);
        }
        if (this.eIv != null) {
            this.eIv.cancelLoadData();
        }
        if (this.eIy != null && this.eIy.ePk != null) {
            this.eIy.ePk.aUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g aTd;
        ArrayList<PostData> aRl;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xY() && this.eIy != null && (aTd = this.eIy.aTd()) != null && (aRl = aTd.aRl()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aRl.iterator();
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
                        bVar.bHz = id;
                        bVar.bNG = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.YY == 1 && !TextUtils.isEmpty(id)) {
                    next.YY = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bHz = id;
                    bVar2.bNG = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eHJ == null || this.eHJ.getPbData() == null || this.eHJ.getPbData().aPg() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eHJ.getPbData().aPg().getFirst_class();
                    str2 = this.eHJ.getPbData().aPg().getSecond_class();
                    str = this.eHJ.getPbData().aPg().getId();
                    str4 = this.eHJ.getThreadID();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.yb());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eIy.onChangeSkinType(i);
        if (this.eIJ != null && this.eIJ.CV() != null) {
            this.eIJ.CV().onChangeSkinType(i);
        }
        if (this.eIy.aSM() != null) {
            this.eIy.aSM().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eIy = new an(this, this.cry, this.aRw);
        this.csZ = new com.baidu.tieba.e.b(getActivity());
        this.csZ.a(this.eJy);
        this.csZ.a(this.caG);
        this.eIy.setOnScrollListener(this.mOnScrollListener);
        this.eIy.d(this.eJs);
        this.eIy.a(this.bag);
        this.eIy.iT(com.baidu.tbadk.core.h.oS().oY());
        this.eIy.setOnImageClickListener(this.aRv);
        this.eIy.a(this.avy);
        this.eIy.c(this.bJq);
        this.eIy.a(this.eJq);
        this.eIy.jF(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bh(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gjf == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oS().oY()) {
                    return false;
                }
                return pk(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eIy != null) {
            if (z && (!this.enz || this.eIL)) {
                aQH();
            } else {
                hideLoadingView(this.eIy.getView());
            }
            this.eIL = false;
        }
    }

    private void aQp() {
        if (this.eIg == null) {
            this.eIg = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eIg.a(new String[]{getPageContext().getString(d.l.call_phone), getPageContext().getString(d.l.sms_phone), getPageContext().getString(d.l.search_in_baidu)}, new b.InterfaceC0046b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eHG = PbActivity.this.eHG.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eHG);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eHJ.getThreadID(), PbActivity.this.eHG, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eHG = PbActivity.this.eHG.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eHG);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eHJ.getThreadID(), PbActivity.this.eHG, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eHG = PbActivity.this.eHG.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eHG);
                        bVar.dismiss();
                    }
                }
            }).cg(b.a.abp).ch(17).d(getPageContext());
        }
    }

    private void v(Bundle bundle) {
        this.eHJ = new PbModel(this);
        this.eHJ.a(this.eJm);
        if (this.eHJ.aSb() != null) {
            this.eHJ.aSb().a(this.eJA);
        }
        if (this.eHJ.aSa() != null) {
            this.eHJ.aSa().a(this.eIZ);
        }
        if (this.eHJ.aSd() != null) {
            this.eHJ.aSd().a(this.eIV);
        }
        if (bundle != null) {
            this.eHJ.initWithBundle(bundle);
        } else {
            this.eHJ.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eHJ.jp(true);
        }
        af.aSE().T(this.eHJ.aRB(), this.eHJ.getIsFromMark());
        if (StringUtils.isNull(this.eHJ.getThreadID())) {
            finish();
        } else {
            this.eHJ.Fu();
        }
    }

    private void initData(Bundle bundle) {
        this.ejK = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.ejK != null) {
            this.ejK.a(this.eJo);
        }
        this.eIx = new ForumManageModel(this);
        this.eIx.setLoadDataCallBack(this.eJp);
        this.eIy.a(new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
            public void f(Object obj) {
                if (!com.baidu.adp.lib.util.i.hi()) {
                    PbActivity.this.showToast(d.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eHJ.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eHJ.getPbData().aPg().getId(), PbActivity.this.eHJ.getPbData().aPg().getName(), PbActivity.this.eHJ.getPbData().aPi().getId(), valueOf, str, str2)));
            }
        });
        this.eJe.setUniqueId(getUniqueId());
        this.eJe.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eIy.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eIO;
        userMuteCheckCustomMessage.setTag(this.eIO);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public PostData bi(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.h.tag_clip_board)) != null && !com.baidu.tieba.pb.f.d(postData)) {
            if (postData.bsM()) {
                postData.cO(postData.bsL() - 1);
            } else {
                postData.cO(postData.bsL() + 1);
            }
            postData.mI(!postData.bsM());
            ((PbFloorAgreeView) view).a(postData.bsM(), postData.bsL(), true);
            final int i = postData.bsM() ? 0 : 1;
            this.eHJ.aSc().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pm(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).pL(i2);
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

    public com.baidu.tbadk.core.util.ak aQq() {
        return new com.baidu.tbadk.core.util.ak("c12003").ad("tid", this.eHJ.eLV).r("obj_type", 0).ad("fid", this.eHJ.getForumId()).r("obj_param1", this.eHJ.getPbData().aPi().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQr() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eHJ != null && this.eHJ.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eHJ.getPbData();
            if (pbData.aPg() != null) {
                sb.append("forum_name=").append(ph(pbData.aPg().getName()));
                sb.append("&");
            }
            if (pbData.aPi() != null) {
                bj aPi = pbData.aPi();
                sb.append("thread_id=").append(aPi.getId());
                sb.append("&");
                sb.append("thread_title=").append(ph(aPi.getTitle()));
                if (aPi.getAuthor() != null && aPi.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aPi.getAuthor().getPortrait());
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
                    int f;
                    int af = (com.baidu.adp.lib.util.k.af(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        f = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.f(PbActivity.this.getPageContext().getPageActivity(), d.f.ds120);
                    } else {
                        f = com.baidu.adp.lib.util.k.f(PbActivity.this.getPageContext().getPageActivity(), d.f.ds640);
                    }
                    int i = f - af;
                    if (i > 0) {
                        PbActivity.this.aQm().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aQm().aSP() != null) {
                        PbActivity.this.aQm().aSP().bN(str, str2);
                    }
                    PbActivity.this.aQm().aTA();
                }
            }, 500L);
        }
    }

    private String ph(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null && this.eHJ != null && this.eHJ.getPbData() != null && postData.bsz() > 1) {
            String threadID = this.eHJ.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.eHJ.getPbData() != null) {
                i = this.eHJ.getPbData().aPt();
            }
            b pl = pl(id);
            if (pl != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, postData.aVJ(), this.eHJ.getPbData().qn(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(pl.eJY, pl.eJZ, pl.eKa, pl.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        ak akVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.k.hz()) {
                showToast(d.l.no_network_guide);
            } else if (aQn() != null && aQn().getPbData() != null && aQn().getPbData().aPE() != null && !com.baidu.tieba.pb.f.Y(aQn().getPbData().aPi())) {
                com.baidu.tieba.pb.data.l aPE = aQn().getPbData().aPE();
                if (view == null || !(view.getTag(d.h.pb_main_thread_praise_view) instanceof ak)) {
                    akVar = null;
                } else {
                    akVar = (ak) view.getTag(d.h.pb_main_thread_praise_view);
                }
                if (aPE != null) {
                    int i2 = -1;
                    if (z) {
                        aPE.pe(i);
                    } else if (aPE.aPL()) {
                        aPE.aPN();
                        i2 = 1;
                    } else {
                        aPE.pf(i);
                        i2 = 0;
                    }
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pm(int i3) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void a(CustomDialogData customDialogData) {
                            com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), customDialogData);
                        }
                    };
                    if (this.eHJ != null && this.eHJ.aSc() != null) {
                        String str = "";
                        if (this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null) {
                            str = this.eHJ.getPbData().aPi().rR();
                        }
                        if (this.eHJ.getPbData() != null) {
                            this.eHJ.getPbData().a(aPE);
                        }
                        if (z) {
                            this.eHJ.aSc().a(str, 3, i, this.eHJ.getForumId(), aVar);
                        } else {
                            this.eHJ.aSc().a(str, i2, 3, i, this.eHJ.getForumId(), aVar);
                            com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                            kVar.eFJ = i2;
                            kVar.eFK = aPE;
                            kVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, kVar));
                        }
                    }
                    if (akVar != null) {
                        akVar.b(aPE);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQs() {
        if (this.eHJ.getPbData() == null || this.eHJ.getPbData().aPi() == null) {
            return -1;
        }
        return this.eHJ.getPbData().aPi().sf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQt() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.pG(this.eHJ.getForumId()) && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPg() != null) {
            if (this.eHJ.getPbData().aPg().isLike() == 1) {
                aQI();
                this.eHJ.aSf().bP(this.eHJ.getForumId(), this.eHJ.getThreadID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ja(boolean z) {
        if (this.eHJ == null || this.eHJ.getPbData() == null) {
            return false;
        }
        return ((this.eHJ.getPbData().aPt() != 0) || this.eHJ.getPbData().aPi() == null || this.eHJ.getPbData().aPi().getAuthor() == null || TextUtils.equals(this.eHJ.getPbData().aPi().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String aQu() {
        com.baidu.tieba.pb.data.f pbData;
        if (!com.baidu.tbadk.p.p.GQ()) {
            return "";
        }
        PostData aPp = aPp();
        if (this.eHJ == null || (pbData = this.eHJ.getPbData()) == null || pbData.getUserData() == null || pbData.aPi() == null || aPp == null || aPp.getAuthor() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aPp.getAuthor().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aPi().rl() == 0) {
            return "";
        }
        if (pbData.aPi().rl() == 0) {
            return getPageContext().getString(d.l.fans_call);
        }
        return getPageContext().getString(d.l.haved_fans_call);
    }

    private boolean jb(boolean z) {
        if (z) {
            return true;
        }
        if (this.eHJ == null || this.eHJ.getPbData() == null) {
            return false;
        }
        return this.eHJ.getPbData().aPt() != 0;
    }

    private boolean jc(boolean z) {
        return (z || this.eHJ == null || this.eHJ.getPbData() == null || this.eHJ.getPbData().aPt() == 0) ? false : true;
    }

    public void aQv() {
        if (this.eHJ != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null && this.eHJ.getPbData().aPi().getAuthor() != null) {
            if (this.eIy != null) {
                this.eIy.aSN();
            }
            bj aPi = this.eHJ.getPbData().aPi();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aPi.getAuthor().getUserId());
            GodUserData godUserData = aPi.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            y yVar = new y();
            if (this.eHJ.getPbData().aPt() == 1) {
                yVar.eNJ = true;
                yVar.eNI = true;
                yVar.eNO = aPi.rw() == 1;
                yVar.eNN = aPi.rx() == 1;
            } else {
                yVar.eNJ = false;
                yVar.eNI = false;
            }
            yVar.eNF = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            yVar.eNK = jb(equals);
            yVar.eNL = aQw();
            yVar.eNM = jc(equals);
            yVar.eNG = this.eHJ.aRD();
            yVar.eFW = this.ejK != null ? this.ejK.nG() : false;
            yVar.eNE = ja(equals);
            yVar.eNQ = aQu();
            yVar.eNC = equals && this.eIy.aTr();
            yVar.eND = z;
            yVar.eNH = TbadkCoreApplication.getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            yVar.isHostOnly = this.eHJ.getHostMode();
            yVar.eNP = false;
            if (aPi.rS() == null) {
                yVar.eNR = true;
            } else {
                yVar.eNR = false;
            }
            this.eIy.ePk.a(yVar);
        }
    }

    private boolean aQw() {
        if (this.eHJ != null && this.eHJ.aRD()) {
            return this.eHJ.asJ() == null || this.eHJ.asJ().qA() != 0;
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
    public int aQx() {
        if (aQm() == null || aQm().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aQm().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) fVar).mType == com.baidu.tieba.pb.data.j.eFG) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQy() {
        if (aQm() == null || aQm().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aQm().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.gjd) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        Xm();
    }

    public void a(boolean z, MarkData markData) {
        this.eIy.aTk();
        this.eHJ.jo(z);
        if (this.ejK != null) {
            this.ejK.ac(z);
            if (markData != null) {
                this.ejK.a(markData);
            }
        }
        if (this.eHJ.nG()) {
            aQE();
        } else {
            this.eIy.m(this.eHJ.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pi(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(String str) {
        if (!StringUtils.isNull(str) && this.eHJ != null) {
            String threadID = this.eHJ.getThreadID();
            String id = this.eHJ.getPbData().aPg().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eHJ.aRI()) {
                    antiData.setBlock_forum_name(this.eHJ.getPbData().aPg().getName());
                    antiData.setBlock_forum_id(this.eHJ.getPbData().aPg().getId());
                    antiData.setUser_name(this.eHJ.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eHJ.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.tB(i)) {
            AntiHelper.g(getPageContext().getPageActivity(), str, i);
        } else if (i == 230277) {
            ga(str);
        } else {
            this.eIy.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eIy.a(0, bVar.Ai, bVar.glu, z);
            if (bVar.Ai) {
                if (bVar.gls == 1) {
                    ArrayList<PostData> aPk = this.eHJ.getPbData().aPk();
                    int size = aPk.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aPk.get(i).getId())) {
                            i++;
                        } else {
                            aPk.remove(i);
                            break;
                        }
                    }
                    this.eIy.m(this.eHJ.getPbData());
                } else if (bVar.gls == 0) {
                    aQz();
                } else if (bVar.gls == 2) {
                    ArrayList<PostData> aPk2 = this.eHJ.getPbData().aPk();
                    int size2 = aPk2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aPk2.get(i2).bsw().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aPk2.get(i2).bsw().get(i3).getId())) {
                                i3++;
                            } else {
                                aPk2.get(i2).bsw().remove(i3);
                                aPk2.get(i2).bsy();
                                z2 = true;
                                break;
                            }
                        }
                        aPk2.get(i2).sf(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eIy.m(this.eHJ.getPbData());
                    }
                    a(bVar, this.eIy);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eIy.a(this.eIx.getLoadDataMode(), fVar.Ai, fVar.glu, false);
            if (fVar.Ai) {
                this.eIA = true;
                if (i == 2 || i == 3) {
                    this.eIB = true;
                    this.eIC = false;
                } else if (i == 4 || i == 5) {
                    this.eIB = false;
                    this.eIC = true;
                }
                if (i == 2) {
                    this.eHJ.getPbData().aPi().bU(1);
                    this.eHJ.setIsGood(1);
                } else if (i == 3) {
                    this.eHJ.getPbData().aPi().bU(0);
                    this.eHJ.setIsGood(0);
                } else if (i == 4) {
                    this.eHJ.getPbData().aPi().bT(1);
                    this.eHJ.hT(1);
                } else if (i == 5) {
                    this.eHJ.getPbData().aPi().bT(0);
                    this.eHJ.hT(0);
                }
                this.eIy.c(this.eHJ.getPbData(), this.eHJ.aRD());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aQz() {
        if (this.eHJ.aRE() || this.eHJ.aRG()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eHJ.getThreadID());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eHJ.getThreadID()));
        if (aQF()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQA() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aPq;
        boolean z = true;
        if (this.eIy != null) {
            this.eIy.aDM();
        }
        if (this.eHJ != null && this.eHJ.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eHJ.getPbData().aPi().getId();
            historyMessage.forumName = this.eHJ.getPbData().aPg().getName();
            historyMessage.threadName = this.eHJ.getPbData().aPi().getTitle();
            ArrayList<PostData> aPk = this.eHJ.getPbData().aPk();
            int aTm = this.eIy != null ? this.eIy.aTm() : 0;
            if (aPk != null && aTm >= 0 && aTm < aPk.size()) {
                historyMessage.postID = aPk.get(aTm).getId();
            }
            historyMessage.isHostOnly = this.eHJ.getHostMode();
            historyMessage.isSquence = this.eHJ.aRD();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eIJ != null) {
            this.eIJ.onDestroy();
        }
        if (this.eIe && aQm() != null) {
            aQm().aTL();
        }
        if (this.eHJ != null && (this.eHJ.aRE() || this.eHJ.aRG())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eHJ.getThreadID());
            if (this.eIA) {
                if (this.eIC) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eHJ.aDD());
                }
                if (this.eIB) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eHJ.getIsGood());
                }
            }
            if (this.eHJ.getPbData() != null && System.currentTimeMillis() - this.eIi >= 40000 && (aPq = this.eHJ.getPbData().aPq()) != null && !com.baidu.tbadk.core.util.v.v(aPq.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aPq);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eIU);
            }
            setResult(-1, intent);
        }
        if (aQF()) {
            if (this.eHJ != null && this.eIy != null && this.eIy.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eHJ.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aPo() && !this.eIr) {
                        af aSE = af.aSE();
                        com.baidu.tieba.pb.data.f pbData2 = this.eHJ.getPbData();
                        Parcelable onSaveInstanceState = this.eIy.getListView().onSaveInstanceState();
                        boolean aRD = this.eHJ.aRD();
                        boolean hostMode = this.eHJ.getHostMode();
                        if (this.eIy.aST() == null || this.eIy.aST().getVisibility() != 0) {
                            z = false;
                        }
                        aSE.a(pbData2, onSaveInstanceState, aRD, hostMode, z);
                    }
                }
            } else {
                af.aSE().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eIy == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eIy.pA(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pj(int i) {
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
        this.eIJ.onActivityResult(i, i2, intent);
        if (this.eIv != null) {
            this.eIv.onActivityResult(i, i2, intent);
        }
        if (aQm().aSP() != null) {
            aQm().aSP().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aQD();
                    return;
                case 13008:
                    af.aSE().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eHJ != null) {
                                PbActivity.this.eHJ.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eHJ != null) {
                        a(aQC(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                case 24006:
                    W(intent);
                    return;
                case 24007:
                    if (aQs() == 1) {
                        aQB();
                    }
                    intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        aQt();
                        return;
                    }
                    return;
                case 24008:
                    this.eIy.iY(false);
                    if (this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null && this.eHJ.getPbData().aPi().rV() != null) {
                        this.eHJ.getPbData().aPi().rV().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.eIy != null && this.eIy.ePk != null) {
                        this.eIy.ePk.ol();
                        this.eIy.ePk.aUD();
                        if (this.eHJ != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null) {
                            this.eHJ.getPbData().aPi().bP(1);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this.eIq != null) {
                this.eIq.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aQm() != null && aQi() != null && aQm().aSR() && com.baidu.tbadk.editortools.pb.a.Dr().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Dr().setStatus(0);
                    if (this.eIy != null) {
                        this.eIy.aSQ();
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
            if (this.eIv == null) {
                this.eIv = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eIv.b(this.aDu);
                this.eIv.c(this.aDB);
            }
            this.eIv.a(emotionImageData, aQn(), aQn().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQB() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null && this.eHJ.getPbData().aPi().rM() != null && this.eHJ.getPbData().aPi().rM().size() > 0 && this.eHJ.getPbData().aPi().rM().get(0) != null) {
            this.mAwardActId = this.eHJ.getPbData().aPi().rM().get(0).pn();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eHJ.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void W(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    pl(2);
                    return;
                case 2:
                    this.eIy.aTb();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aQC() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bN = this.eHJ.getPbData().bN(getPageContext().getPageActivity());
        PostData aSS = this.eIy.aSS();
        String str = "";
        if (aSS != null) {
            str = aSS.getId();
            String ca = aSS.ca(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(ca)) {
                bN[1] = ca;
            }
        }
        String rR = this.eHJ.getPbData().aPi().rR();
        if (rR != null && rR.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bN[1]);
        shareFromPBMsgData.setImageUrl(bN[0]);
        shareFromPBMsgData.setForumName(this.eHJ.getPbData().aPg().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eHJ.getPbData().aPi().getId());
        shareFromPBMsgData.setTitle(this.eHJ.getPbData().aPi().getTitle());
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        a(aQC(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eHJ != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(lVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.eHJ != null && PbActivity.this.eHJ.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ad = new com.baidu.tbadk.core.util.ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ad("fid", PbActivity.this.eHJ.getForumId()).ad("tid", PbActivity.this.eHJ.getThreadID());
                        if (PbActivity.this.c(PbActivity.this.eHJ.getPbData()) != 0) {
                            ad.r("obj_type", PbActivity.this.c(PbActivity.this.eHJ.getPbData()));
                        }
                        TiebaStatic.log(ad);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aQs() == 1) {
                        PbActivity.this.aQB();
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
                lVar.L(shareFromPBMsgData.getImageUrl(), this.eHJ.getPbData().aPu() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eHJ != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null) {
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
                    if (PbActivity.this.aQs() == 1) {
                        PbActivity.this.aQB();
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
                lVar.L(shareFromPBMsgData.getImageUrl(), this.eHJ.getPbData().aPu() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQD() {
        MarkData py;
        if (this.ejK != null && (py = this.eHJ.py(this.eIy.aTn())) != null) {
            if (!py.isApp() || (py = this.eHJ.py(this.eIy.aTn() + 1)) != null) {
                this.eIy.aTi();
                this.ejK.a(py);
                if (!this.ejK.nG()) {
                    this.ejK.nI();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.ejK.nH();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQE() {
        com.baidu.tieba.pb.data.f pbData = this.eHJ.getPbData();
        this.eHJ.jo(true);
        pbData.pd(this.ejK.nF());
        this.eIy.m(pbData);
    }

    private boolean aQF() {
        if (this.eHJ == null) {
            return true;
        }
        if (this.eHJ.nG()) {
            final MarkData aRQ = this.eHJ.aRQ();
            if (aRQ == null || !this.eHJ.getIsFromMark()) {
                return true;
            }
            final MarkData py = this.eHJ.py(this.eIy.aTm());
            if (py == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aRQ);
                setResult(-1, intent);
                return true;
            } else if (py.getPostId() == null || py.getPostId().equals(aRQ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aRQ);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cM(getPageContext().getString(d.l.alert_update_mark));
                aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.ejK != null) {
                            if (PbActivity.this.ejK.nG()) {
                                PbActivity.this.ejK.nH();
                                PbActivity.this.ejK.ac(false);
                            }
                            PbActivity.this.ejK.a(py);
                            PbActivity.this.ejK.ac(true);
                            PbActivity.this.ejK.nI();
                        }
                        aRQ.setPostId(py.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aRQ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aQA();
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aRQ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aQA();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eIy != null && PbActivity.this.eIy.getView() != null) {
                            PbActivity.this.eIy.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aRQ);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aQA();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.to();
                return false;
            }
        } else if (this.eHJ.getPbData() == null || this.eHJ.getPbData().aPk() == null || this.eHJ.getPbData().aPk().size() <= 0 || !this.eHJ.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eIy == null) {
            return null;
        }
        return this.eIy.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IZ() {
        if (this.eIy == null) {
            return 0;
        }
        return this.eIy.aTu();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Ja() {
        if (this.aRb == null) {
            this.aRb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: UI */
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
        return this.aRb;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Jb() {
        if (this.aRc == null) {
            this.aRc = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aRc;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jc() {
        if (this.aRg == null) {
            this.aRg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRa */
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
        return this.aRg;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jd() {
        if (this.aRe == null) {
            this.aRe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aou */
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
        return this.aRe;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jf() {
        if (this.aRd == null) {
            this.aRd = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 6);
        }
        return this.aRd;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xp() {
        if (this.apd == null) {
            this.apd = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.apd;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eIn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (ar.pv(str) && this.eHJ != null && this.eHJ.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").r("obj_param1", 1).ad("post_id", this.eHJ.getThreadID()));
        }
        ar.aTP().f(getPageContext(), str);
        this.eIn = true;
    }

    private com.baidu.tbadk.core.dialog.a aQG() {
        if (this.eIh == null) {
            this.eIh = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eIh.cL(getPageContext().getString(d.l.download_baidu_video_dialog));
            this.eIh.a(getPageContext().getString(d.l.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
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
            this.eIh.b(getPageContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eIh.ar(true);
            this.eIh.b(getPageContext());
            this.eIh.as(false);
        }
        this.eIh.to();
        return this.eIh;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
        ar.aTP().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eIn = true;
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
            aQG();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eIn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eHJ.getPbData();
            TbRichText an = an(str, i);
            if (an != null && (tbRichTextData = an.Iv().get(this.eJt)) != null) {
                if (tbRichTextData.getType() == 20 || tbRichTextData.getType() == 17) {
                    bVar.eKc = true;
                    return;
                }
                bVar.eJY = new ArrayList<>();
                bVar.eJZ = new ConcurrentHashMap<>();
                if (!tbRichTextData.IB().IO()) {
                    bVar.eKb = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.eJY.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = an.getPostId();
                    imageUrlData.mIsReserver = this.eHJ.aRP();
                    imageUrlData.mIsSeeHost = this.eHJ.getHostMode();
                    bVar.eJZ.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aPg() != null) {
                            bVar.forumName = pbData.aPg().getName();
                            bVar.forumId = pbData.aPg().getId();
                        }
                        if (pbData.aPi() != null) {
                            bVar.threadId = pbData.aPi().getId();
                        }
                        bVar.eKa = pbData.aPu() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eKb = true;
                int size = pbData.aPk().size();
                this.eJu = false;
                bVar.index = -1;
                if (pbData.aPp() != null) {
                    PostData aPp = pbData.aPp();
                    TbRichText aDr = aPp.aDr();
                    if (!am.k(aPp)) {
                        i2 = a(aDr, an, i, i, bVar.eJY, bVar.eJZ);
                    } else {
                        i2 = a(aPp, i, bVar.eJY, bVar.eJZ);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aPk().get(i4);
                    if (postData.getId() == null || pbData.aPp() == null || pbData.aPp().getId() == null || !postData.getId().equals(pbData.aPp().getId())) {
                        TbRichText aDr2 = postData.aDr();
                        if (!am.k(postData)) {
                            i3 = a(aDr2, an, i3, i, bVar.eJY, bVar.eJZ);
                        } else {
                            i3 = a(postData, i3, bVar.eJY, bVar.eJZ);
                        }
                    }
                }
                if (bVar.eJY.size() > 0) {
                    bVar.lastId = bVar.eJY.get(bVar.eJY.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aPg() != null) {
                        bVar.forumName = pbData.aPg().getName();
                        bVar.forumId = pbData.aPg().getId();
                    }
                    if (pbData.aPi() != null) {
                        bVar.threadId = pbData.aPi().getId();
                    }
                    bVar.eKa = pbData.aPu() == 1;
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
            this.eJu = true;
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
                    int ag = (int) com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.IB().getWidth() * ag;
                    int height = ag * tbRichTextData.IB().getHeight();
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
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eHJ.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eHJ.aRP();
                                imageUrlData.mIsSeeHost = this.eHJ.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eJu) {
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
        com.baidu.tieba.tbadkCore.data.h bsH;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bse;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bse = (bsH = postData.bsH()).bse()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bse.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bse.get(i3);
                if (jVar != null) {
                    String bsj = jVar.bsj();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bsj)) {
                        arrayList.add(bsj);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bsj;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bsi();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eHJ.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eHJ.aRP();
                        imageUrlData.mIsSeeHost = this.eHJ.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bsH.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bsj, imageUrlData);
                        }
                        if (!this.eJu) {
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
            if (postData.getId() != null && postData.getId().equals(this.eHJ.rK())) {
                z = true;
            }
            MarkData j = this.eHJ.j(postData);
            if (j != null) {
                this.eIy.aTi();
                if (this.ejK != null) {
                    this.ejK.a(j);
                    if (!z) {
                        this.ejK.nI();
                    } else {
                        this.ejK.nH();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText an(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eHJ == null || this.eHJ.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eHJ.getPbData();
        if (pbData.aPp() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aPp());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aPk = pbData.aPk();
            a(pbData, aPk);
            return a(aPk, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.aPs() != null && fVar.aPs().eFY != null && (list = fVar.aPs().eFY) != null && arrayList != null) {
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

    private long pj(String str) {
        ArrayList<PostData> aPk;
        com.baidu.tieba.pb.data.f pbData = this.eHJ.getPbData();
        if (pbData != null && (aPk = pbData.aPk()) != null && !aPk.isEmpty()) {
            Iterator<PostData> it = aPk.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bsH = next.bsH();
                if (bsH != null && bsH.giK) {
                    Iterator<TbRichTextData> it2 = next.aDr().Iv().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IK().getLink().equals(str)) {
                            return bsH.getTemplateId();
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
            TbRichText aDr = arrayList.get(i2).aDr();
            if (aDr != null && (Iv = aDr.Iv()) != null) {
                int size = Iv.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Iv.get(i4) != null && Iv.get(i4).getType() == 8) {
                        i3++;
                        if (Iv.get(i4).IB().IQ().equals(str)) {
                            int ag = (int) com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst());
                            int width = Iv.get(i4).IB().getWidth() * ag;
                            int height = Iv.get(i4).IB().getHeight() * ag;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eJt = i4;
                            return aDr;
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
                                        this.eJt = i4;
                                        return aDr;
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
    public void g(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.eHG = str;
            if (this.eIg == null) {
                aQp();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eIg.cj(1).setVisibility(8);
            } else {
                this.eIg.cj(1).setVisibility(0);
            }
            this.eIg.tr();
            this.eIn = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cpV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xm() {
        hideNetRefreshView(this.eIy.getView());
        aQH();
        if (this.eHJ.Fu()) {
            this.eIy.aTi();
        }
    }

    private void aQH() {
        showLoadingView(this.eIy.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds400));
        View EO = getLoadingView().EO();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EO.getLayoutParams();
        layoutParams.addRule(3, this.eIy.aTD().getId());
        EO.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahn() {
        if (this.cpV != null) {
            this.cpV.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(int i) {
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
    public void pl(int i) {
        boolean z;
        String str;
        Uri parse;
        if (this.eHJ.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eHJ.getPbData();
            pbData.aPg().getName();
            String title = pbData.aPi().getTitle();
            int i2 = this.eHJ.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aPg() != null) {
                if ((pbData.aPg().isLike() == 1) && AddExperiencedModel.pG(pbData.getForumId())) {
                    z = true;
                    String str2 = "http://tieba.baidu.com/p/" + this.eHJ.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bN = pbData.bN(getPageContext().getPageActivity());
                    str = bN[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    String str3 = bN[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (aQs() != 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ad("fid", pbData.getForumId()).ad("tid", pbData.getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                    } else if (aQs() == 2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10406").ad("fid", pbData.getForumId()).ad("tid", pbData.getThreadId()).ad(SapiAccountManager.SESSION_UID, currentAccount));
                    }
                    String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, str3);
                    final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
                    dVar.title = title;
                    dVar.content = format;
                    dVar.linkUrl = str2;
                    dVar.auq = true;
                    dVar.auu = z;
                    dVar.extData = this.eHJ.getThreadID();
                    dVar.auF = 3;
                    dVar.auE = i;
                    dVar.fid = this.eHJ.getForumId();
                    dVar.Xe = this.eHJ.getThreadID();
                    dVar.auG = c(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.auz = parse;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.auF);
                    bundle.putInt("obj_type", dVar.auG);
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
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10125").ad("tid", PbActivity.this.eHJ.getThreadID()).ad("fid", PbActivity.this.eHJ.getForumId()).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                            PbActivity.this.xi();
                        }
                    });
                    shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            dVar.linkUrl = PbActivity.this.pm(dVar.linkUrl);
                            com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                            com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                            PbActivity.this.xi();
                        }
                    });
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
                }
            }
            z = false;
            String str22 = "http://tieba.baidu.com/p/" + this.eHJ.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bN2 = pbData.bN(getPageContext().getPageActivity());
            str = bN2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            String str32 = bN2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (aQs() != 1) {
            }
            String format2 = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, str32);
            final com.baidu.tbadk.coreExtra.d.d dVar2 = new com.baidu.tbadk.coreExtra.d.d();
            dVar2.title = title;
            dVar2.content = format2;
            dVar2.linkUrl = str22;
            dVar2.auq = true;
            dVar2.auu = z;
            dVar2.extData = this.eHJ.getThreadID();
            dVar2.auF = 3;
            dVar2.auE = i;
            dVar2.fid = this.eHJ.getForumId();
            dVar2.Xe = this.eHJ.getThreadID();
            dVar2.auG = c(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.auF);
            bundle2.putInt("obj_type", dVar2.auG);
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10125").ad("tid", PbActivity.this.eHJ.getThreadID()).ad("fid", PbActivity.this.eHJ.getForumId()).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                    PbActivity.this.xi();
                }
            });
            shareDialogConfig2.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar2.linkUrl = PbActivity.this.pm(dVar2.linkUrl);
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
        if (fVar != null && fVar.aPi() != null) {
            if (fVar.aPi().getThreadType() == 0) {
                return 1;
            }
            if (fVar.aPi().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    private void aQI() {
        com.baidu.tbadk.util.u.a(new com.baidu.tbadk.util.t<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pH(PbActivity.this.eHJ.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eIy.aTO();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.aoi == null) {
                this.aoi = new ShareReportModel(getPageContext());
            }
            this.aoi.l(shareItem.fid, shareItem.Xe, shareItem.auw);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Je() {
        if (this.aRf == null) {
            this.aRf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRb */
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
        return this.aRf;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eIy.aTc() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ad("fid", this.eHJ.getPbData().getForumId()));
            } else {
                bj aPi = this.eHJ.getPbData().aPi();
                if (view != null) {
                    boolean z = aPi.rr() == null || aPi.rr().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eJf > 1000) {
                            this.eJg = true;
                            bk(view);
                        } else {
                            this.eJg = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            l(view, this.eJg);
                        } else {
                            k(view, this.eJg);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        k(view, this.eJg);
                    } else if (motionEvent.getAction() == 3) {
                        k(view, this.eJg);
                    }
                }
            }
        }
        return false;
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eJf = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void l(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eJf = System.currentTimeMillis();
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

    public void aho() {
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
            int intValue = ((Integer) sparseArray.get(an.eRj)).intValue();
            if (intValue == an.eRk) {
                if (!this.eIx.btl()) {
                    this.eIy.aTf();
                    int intValue2 = ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue();
                    this.eIx.a(this.eHJ.getPbData().aPg().getId(), this.eHJ.getPbData().aPg().getName(), this.eHJ.getPbData().aPi().getId(), (String) sparseArray.get(d.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.eRl || intValue == an.eRn) {
                if (this.eHJ.aSb() != null) {
                    this.eHJ.aSb().pp(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.eRl) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == an.eRm) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eJz).pi()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eIO);
        userMuteAddAndDelCustomMessage.setTag(this.eIO);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pk(String str) {
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

    public void jd(boolean z) {
        this.eIF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQJ() {
        ArrayList<PostData> aPk;
        int u;
        if (this.eHJ == null || this.eHJ.getPbData() == null || this.eHJ.getPbData().aPk() == null || (u = com.baidu.tbadk.core.util.v.u((aPk = this.eHJ.getPbData().aPk()))) == 0) {
            return "";
        }
        if (this.eHJ.aRP()) {
            Iterator<PostData> it = aPk.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bsz() == 1) {
                    return next.getId();
                }
            }
        }
        int aTm = this.eIy.aTm();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aPk, aTm);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eHJ.pp(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aTm - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(aPk, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eHJ.pp(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aTm + 1; i2 < u; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(aPk, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eHJ.pp(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (au.wd().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(pj(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eHJ.getPbData().aPg().getId(), this.eHJ.getPbData().aPg().getName(), this.eHJ.getPbData().aPi().getTid());
            }
            this.eIn = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eHJ.aSa() != null) {
                    PbActivity.this.eHJ.aSa().cp(j);
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
    public b pl(String str) {
        String str2;
        if (this.eHJ.getPbData() == null || this.eHJ.getPbData().aPk() == null || this.eHJ.getPbData().aPk().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i >= this.eHJ.getPbData().aPk().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eHJ.getPbData().aPk().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eHJ.getPbData().aPk().get(i);
        if (postData.aDr() == null || postData.aDr().Iv() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aDr().Iv().iterator();
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
        if (this.eIc) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eIc = false;
        } else if (aQK()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eIc) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eIc = false;
        } else if (aQK()) {
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
        if (pageStayDurationItem != null && this.eHJ != null) {
            if (this.eHJ.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eHJ.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eHJ.getThreadID(), 0L));
            if (this.eIo) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aQK() {
        return (!this.eIa && this.eJB == -1 && this.eJC == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eJE = nVar;
            this.eIa = true;
            this.eIy.aSV();
            this.eIy.pt(this.eJD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQL() {
        if (this.eJE != null) {
            if (this.eJB == -1) {
                showToast(d.l.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eJE.getCartoonId(), this.eJB, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQM() {
        if (this.eJE != null) {
            if (this.eJC == -1) {
                showToast(d.l.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eJE.getCartoonId(), this.eJC, 0)));
                finish();
            }
        }
    }

    public int aQN() {
        return this.eJB;
    }

    public int aQO() {
        return this.eJC;
    }

    private void asf() {
        if (this.eHJ != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null && this.eHJ.getPbData().aPi().so()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aQP() {
        if (this.eHJ != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null && this.eHJ.getPbData().aPi().so()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aQQ() {
        if (this.eId) {
            this.eIu = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null && this.eHJ.getPbData().aPi().ri() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eHJ.getPbData().aPi().ri().getThreadId(), this.eHJ.getPbData().aPi().ri().getTaskId(), this.eHJ.getPbData().aPi().ri().getForumId(), this.eHJ.getPbData().aPi().ri().getForumName(), this.eHJ.getPbData().aPi().rw(), this.eHJ.getPbData().aPi().rx())));
            this.eIc = true;
            finish();
        }
    }

    public boolean aQR() {
        return this.eId;
    }

    public String aQS() {
        return this.eIs;
    }

    public PbInterviewStatusView.a aQT() {
        return this.eIw;
    }

    public void je(boolean z) {
        this.eIt = z;
    }

    public boolean aQU() {
        if (this.eHJ != null) {
            return this.eHJ.aRE();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cM(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eIM).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eIM.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eIM).to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eIM != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIM.getPageActivity());
            aVar.cM(str);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eIM).to();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eIy.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIM.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.cM(this.eIM.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cM(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eIy.showLoadingDialog();
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
        aVar.b(this.eIM).to();
    }

    public void aQW() {
        if (this.eHJ != null && this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null && this.eHJ.getPbData().aPi().sF() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cc(d.l.channel_open_push_message);
            aVar.a(d.l.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eHJ.getPbData().aPi().sF().channelId, true, PbActivity.this.getUniqueId())));
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
                if (ar.pv(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_pb_wenxue)) != null) {
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
            this.ctQ = true;
        } else {
            this.ctQ = false;
        }
        if (this.eIy != null) {
            this.eIy.onConfigurationChanged(configuration);
        }
        if (this.eID != null) {
            this.eID.dismiss();
        }
    }

    public boolean aQX() {
        if (this.eHJ != null) {
            return this.eHJ.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.eHJ.getPbData().aPs().eFY;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bsw().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bsw().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bsw().remove(i2);
                    list.get(i).bsy();
                    z = true;
                    break;
                }
            }
            list.get(i).sf(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.m(this.eHJ.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.aPQ().getId();
        List<PostData> list = this.eHJ.getPbData().aPs().eFY;
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
                ArrayList<PostData> aPU = mVar.aPU();
                postData.tv(mVar.getTotalCount());
                if (postData.bsw() != null) {
                    postData.bsw().clear();
                    postData.bsw().addAll(aPU);
                }
            }
        }
        this.eIy.m(this.eHJ.getPbData());
    }

    public boolean aQY() {
        boolean z = true;
        if (this.eHJ == null) {
            return false;
        }
        switch (this.eHJ.aSj()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eHJ.getPbData() != null && this.eHJ.getPbData().aPi() != null && this.eHJ.getPbData().aPi().sN() && StringUtils.isNull(this.eHJ.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aQZ() {
        if (this.eIy != null) {
            this.eIy.aSN();
            aho();
        }
    }

    public PostData aPp() {
        return this.eIy.b(this.eHJ.eMm, this.eHJ.aRD());
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

    public String pm(String str) {
        String aS;
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String ak = ak(ak(ak(ak(str, "sfc=copy"), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (this.eHJ == null || this.eHJ.getThreadID() == null) {
            return ak;
        }
        if (com.baidu.adp.lib.b.d.eW().af("android_url_need_cuid") == 1) {
            aS = com.baidu.adp.lib.util.r.aS(this.eHJ.getThreadID() + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
        } else {
            aS = com.baidu.adp.lib.util.r.aS(this.eHJ.getThreadID() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
        }
        return ak(ak, "unique=" + aS);
    }
}
