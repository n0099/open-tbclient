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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
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
import com.baidu.tbadk.core.atomData.ReadPbServiceConfig;
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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
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
import tbclient.MemeInfo;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.b, com.baidu.tbadk.widget.richText.d {
    private com.baidu.adp.lib.e.b<ImageView> aRu;
    private com.baidu.adp.lib.e.b<TextView> aRv;
    private com.baidu.adp.lib.e.b<View> aRw;
    private com.baidu.adp.lib.e.b<View> aRx;
    private com.baidu.adp.lib.e.b<LinearLayout> aRy;
    private com.baidu.adp.lib.e.b<GifView> aRz;
    private com.baidu.adp.lib.e.b<TbImageView> apB;
    private VoiceManager cjJ;
    private com.baidu.tbadk.i.a ckd;
    private com.baidu.tieba.e.b cmM;
    private com.baidu.tieba.pb.pb.main.a.b eIL;
    private com.baidu.tbadk.core.dialog.a eIR;
    private boolean eIY;
    private String eIr;
    private com.baidu.adp.base.e eJA;
    private com.baidu.tbadk.core.view.c eJB;
    private BdUniqueId eJC;
    private Runnable eJD;
    private at eJF;
    private com.baidu.adp.widget.a.a eJG;
    private String eJH;
    private TbRichTextMemeInfo eJI;
    private com.baidu.tieba.pb.pb.main.b eJa;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eJg;
    private v eJo;
    private boolean eJt;
    private com.baidu.tieba.tbadkCore.data.e eJw;
    private com.baidu.tbadk.editortools.pb.c eJx;
    private boolean eKi;
    private String eKu;
    private com.baidu.tbadk.core.data.n eKv;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eIK = false;
    private boolean eIM = false;
    private boolean eIN = false;
    private boolean efV = false;
    private boolean eIO = true;
    private int eIP = 0;
    private com.baidu.tbadk.core.dialog.b eIQ = null;
    private long bZn = -1;
    private long aKj = 0;
    private long eIS = 0;
    private long createTime = 0;
    private long aKb = 0;
    private boolean eIT = false;
    private com.baidu.tbadk.l.d eIU = null;
    private long eIV = 0;
    private boolean eIW = false;
    private boolean eIX = false;
    private long eIZ = 0;
    private String aEa = null;
    private boolean eJb = false;
    private boolean eJc = false;
    private String eJd = "";
    private boolean eJe = true;
    private boolean eJf = false;
    private String source = "";
    private PbInterviewStatusView.a eJh = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eJj.jH(!PbActivity.this.eJe);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eIt != null && PbActivity.this.eIt.nL()) {
                        PbActivity.this.aRk();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel eIt = null;
    private com.baidu.tbadk.baseEditMark.a ech = null;
    private ForumManageModel eJi = null;
    private aq eJj = null;
    public final com.baidu.tieba.pb.pb.main.a.a eJk = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eJl = false;
    private boolean eJm = false;
    private boolean eJn = false;
    private boolean eJp = false;
    private boolean eJq = false;
    private boolean eJr = false;
    private boolean eJs = false;
    private boolean eJu = false;
    private boolean eJv = false;
    private boolean eJy = false;
    private com.baidu.tbadk.editortools.pb.b aEf = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Dx() {
            PbActivity.this.showProgressBar();
        }
    };
    private boolean eJz = false;
    private int mLastScrollState = -1;
    private int eJE = 4;
    private boolean ckq = false;
    private int eJJ = -1;
    private final w.a eJK = new w.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void B(List<PostData> list) {
            if (PbActivity.this.eIt.getPbData().aQa() != null) {
                List<PostData> list2 = PbActivity.this.eIt.getPbData().aQa().eGI;
                int size = list2.size();
                if (!com.baidu.tbadk.core.util.u.v(list2)) {
                    PbActivity.this.eIt.getPbData().aQa().eGI.addAll(size, list);
                }
                PbActivity.this.eIt.a(PbActivity.this.eIt.getPbData(), size);
            }
            PbActivity.this.eJj.aTO().a(PbActivity.this.eIt.getPbData(), true);
            if (PbActivity.this.eJj != null && PbActivity.this.eJj.aTO() != null) {
                PbActivity.this.eJj.aTO().notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eJj.showToast(str);
            }
        }
    };
    private final CustomMessageListener eJL = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eIt != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eJx != null) {
                    PbActivity.this.eJj.hk(PbActivity.this.eJx.DG());
                }
                PbActivity.this.eJj.aTA();
                PbActivity.this.eJx.DJ();
                PbActivity.this.eJj.aBR();
            }
        }
    };
    CustomMessageListener ckD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.eIt.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.eJj != null && PbActivity.this.eIt != null) {
                    PbActivity.this.eJj.d(PbActivity.this.eIt.getPbData(), PbActivity.this.eIt.aSf(), PbActivity.this.eIt.aSv());
                }
                if (PbActivity.this.eJj != null && PbActivity.this.eJj.aTO() != null) {
                    PbActivity.this.eJj.aTO().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eJM = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eJj != null) {
                    if (booleanValue) {
                        PbActivity.this.eJj.awv();
                    } else {
                        PbActivity.this.eJj.awu();
                    }
                }
            }
        }
    };
    private CustomMessageListener dKV = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eJx != null) {
                    PbActivity.this.eJj.hk(PbActivity.this.eJx.DG());
                }
                PbActivity.this.eJj.hl(false);
            }
        }
    };
    private CustomMessageListener dLr = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.n) eVar.getData());
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
    private CustomMessageListener eJN = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eJj != null && PbActivity.this.eJj.aTO() != null) {
                PbActivity.this.eJj.aTO().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dko = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private i.a eJO = new i.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        @Override // com.baidu.tieba.pb.pb.main.i.a
        public void i(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.pb(2);
                ai.aTq().reset();
                PbActivity.this.eIt.aSw();
                boolean z2 = false;
                ArrayList<PostData> aPS = PbActivity.this.eIt.getPbData().aPS();
                if (aPS != null) {
                    Iterator<PostData> it = aPS.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.k(next) && next.bto().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eJj.m(PbActivity.this.eIt.getPbData());
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
    private View.OnClickListener dKU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aEa);
        }
    };
    CustomMessageListener cUD = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eJP = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                as.a aVar = new as.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.Xa = abVar.Xa;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIt.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eIt.aSm() != null && PbActivity.this.eIt.aSm().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eJj.a(abVar.sendCount, PbActivity.this.eIt.getPbData(), PbActivity.this.eIt.aSf(), PbActivity.this.eIt.aSv());
                    }
                    if (pbData.aPS() != null && pbData.aPS().size() >= 1 && pbData.aPS().get(0) != null) {
                        long d = com.baidu.adp.lib.g.b.d(pbData.aPS().get(0).getId(), 0L);
                        long d2 = com.baidu.adp.lib.g.b.d(PbActivity.this.eIt.getThreadID(), 0L);
                        if (d == abVar.postId && d2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.as btn = pbData.aPS().get(0).btn();
                            if (btn == null) {
                                btn = new com.baidu.tbadk.core.data.as();
                            }
                            ArrayList<as.a> qG = btn.qG();
                            if (qG == null) {
                                qG = new ArrayList<>();
                            }
                            qG.add(0, aVar);
                            btn.bN(abVar.sendCount + btn.qF());
                            btn.g(qG);
                            pbData.aPS().get(0).a(btn);
                            PbActivity.this.eJj.aTO().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eJQ = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null && aVar.acS() != null && !aVar.acS().isEmpty()) {
                PbActivity.this.eJj.a(aVar, PbActivity.this.eJR);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eJR = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                aw.aO(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.fU().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9.1
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
    private boolean eJS = false;
    private PraiseModel eJT = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hP(String str) {
            PbActivity.this.eJS = false;
            if (PbActivity.this.eJT != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIt.getPbData();
                if (pbData.aPQ().rv().getIsLike() == 1) {
                    PbActivity.this.ja(0);
                } else {
                    PbActivity.this.ja(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aPQ()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void A(int i, String str) {
            PbActivity.this.eJS = false;
            if (PbActivity.this.eJT != null && str != null) {
                if (AntiHelper.tx(i)) {
                    AntiHelper.ar(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eJU = 0;
    private boolean eJV = true;
    private b.a eJW = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void eq(boolean z) {
            PbActivity.this.jd(z);
            if (PbActivity.this.eJj.aUm() != null && z) {
                PbActivity.this.eJj.jH(false);
            }
        }
    };
    private CustomMessageListener bgL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().Ec) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aPX().getAuthor() != null && PbActivity.this.aPX().getAuthor().getGodUserData() != null) {
                            PbActivity.this.aPX().getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        PbActivity.this.c(updateAttentionMessage);
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        PbActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bpo = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eJj.Rs();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.pc(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.amC();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.l.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private CustomMessageListener eJX = new CustomMessageListener(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()).getId() != PbActivity.this.getUniqueId().getId()) {
                PbActivity.this.eJp = false;
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRO = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eJj.aTB()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && ((PbActivity.this.eIt == null || PbActivity.this.eIt.getPbData() == null || !com.baidu.tieba.pb.f.T(PbActivity.this.eIt.getPbData().aPQ())) && PbActivity.this.eIt != null && (PbActivity.this.eIt.getPbData() != null || PbActivity.this.eIt.getPbData().aQn() != null))) {
                    if (PbActivity.this.eIt.getPbData().aQn().aQt()) {
                        if (PbActivity.this.eIt.getPbData().aQn().eGu == 1 || PbActivity.this.eIt.getPbData().aQn().eGu == 3 || PbActivity.this.eIt.getPbData().aQn().eGu == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eIt.getPbData().aQn().aQt() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eIt.getPbData().aQn().aQt() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eIZ > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).startAnimation(false);
                        PbActivity.this.eIZ = System.currentTimeMillis();
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
                    if (PbActivity.this.bb(view)) {
                        return true;
                    }
                } else if (view.getId() == d.h.pb_floor_item_layout) {
                    if (view.getTag(d.h.tag_from) instanceof SparseArray) {
                        PbActivity.this.e((SparseArray) view.getTag(d.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.h.pb_post_header_layout) {
                    if (PbActivity.this.eJj != null && PbActivity.this.eJj.aQV() && (view.getId() == d.h.pb_head_user_info_root || view == PbActivity.this.eJj.aUu())) {
                        if (view.getTag(d.h.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10630").aa("obj_id", (String) view.getTag(d.h.tag_user_id)));
                        }
                        if (PbActivity.this.eJk != null && PbActivity.this.eJk.eVE != null) {
                            PbActivity.this.eJk.eVE.onClick(view);
                        }
                    }
                } else {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        PbActivity.this.e(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (PbActivity.this.eJx != null) {
                PbActivity.this.eJj.hk(PbActivity.this.eJx.DG());
            }
            PbActivity.this.eJj.aTA();
            PbActivity.this.eJx.DJ();
            PbActivity.this.eJj.aBR();
            return true;
        }
    });
    private CustomMessageListener eJY = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eJC) {
                PbActivity.this.eJj.Rs();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIt.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aQd().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eJB.c(PbActivity.this.eJA.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eJA.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    PbActivity.this.gc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aRB();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.al.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eJA.getResources().getString(d.l.mute_fail);
                    }
                    PbActivity.this.eJB.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eJZ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eJC) {
                PbActivity.this.eJj.Rs();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eJB.c(PbActivity.this.eJA.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.al.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eJA.getResources().getString(d.l.un_mute_fail);
                }
                PbActivity.this.eJB.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eKa = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eJC) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eJj.Rs();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gwz;
                if (aVar.error == 0 && dataRes != null) {
                    int g = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = g == 1;
                    if (com.baidu.tbadk.core.util.al.isEmpty(str)) {
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
                    PbActivity.this.eJj.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eKb = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eJj.aTB() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aQU() != null && PbActivity.this.aQU().getPbData() != null && PbActivity.this.aQU().getPbData().aQn() != null && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.T(PbActivity.this.aQU().getPbData().aPQ())) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aQt = PbActivity.this.aQU().getPbData().aQn().aQt();
                if (intValue < 10) {
                    if (aQt) {
                        if (PbActivity.this.eIt.getPbData().aQn().eGu == 1 || PbActivity.this.eIt.getPbData().aQn().eGu == 3 || PbActivity.this.eIt.getPbData().aQn().eGu == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eIt.getPbData().aQn().aQt() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQt ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eIZ > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).startAnimation(false);
                        PbActivity.this.eIZ = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue / 11, aQt);
                TiebaStatic.log(PbActivity.this.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aQt ? 0 : 1));
            }
        }
    };
    private CustomMessageListener ckO = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.ckq = true;
                }
            }
        }
    };
    public a.b eqk = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.afL();
            com.baidu.tbadk.core.data.ar aqU = PbActivity.this.eIt.aqU();
            int pageNum = PbActivity.this.eJj.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.l.pb_page_error);
            } else if (aqU == null || pageNum <= aqU.qy()) {
                PbActivity.this.eJj.aBR();
                PbActivity.this.pb(2);
                PbActivity.this.afK();
                PbActivity.this.eJj.aTT();
                if (com.baidu.adp.lib.util.i.hr()) {
                    PbActivity.this.eIt.pi(PbActivity.this.eJj.getPageNum());
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(d.l.pb_page_error);
            }
        }
    };
    public final View.OnClickListener cll = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Multi-variable search result rejected for r4v138, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v142, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v183, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v19, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:655:0x1d00  */
        /* JADX WARN: Removed duplicated region for block: B:677:0x1ebd  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            com.baidu.tieba.pb.data.m aQn;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            String str;
            int i;
            bp bpVar;
            SparseArray sparseArray;
            PostData postData;
            boolean i2;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if ((PbActivity.this.eJj.eQf.aVo() != null && PbActivity.this.eJj.eQf.aVo().bg(view)) || PbActivity.this.eJj.aTN() == view || view.getId() == d.h.pb_item_tail_content) {
                        if (PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && com.baidu.tieba.pb.f.T(PbActivity.this.eIt.getPbData().aPQ())) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (view == PbActivity.this.eJj.getNextView()) {
                        if (!PbActivity.this.mIsLoading && PbActivity.this.eIt.jk(true)) {
                            PbActivity.this.mIsLoading = true;
                            PbActivity.this.eJj.aTU();
                        }
                    } else if (view == PbActivity.this.eJj.aTF()) {
                        PbActivity.this.eJj.aTL();
                        if (!UtilHelper.isFloatWindowOpAllowed(PbActivity.this.getPageContext().getPageActivity())) {
                            PbActivity.this.Qc();
                            return;
                        }
                        PbActivity.this.eJp = true;
                        PbActivity.this.a(PbActivity.this.eIt.getPbData(), 0, 1, true, true);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10830").aa("tid", PbActivity.this.eIt.getThreadID()));
                        PbActivity.this.eJj.aBR();
                    } else if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aTd()) {
                        if (view == PbActivity.this.eJj.eQf.aMb) {
                            if (PbActivity.this.eJj.jL(PbActivity.this.eIt.aSj())) {
                                PbActivity.this.afK();
                                return;
                            }
                            PbActivity.this.eIO = false;
                            PbActivity.this.eIM = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eJj.aTR() && (PbActivity.this.eJj.eQf.aVo() == null || (view != PbActivity.this.eJj.eQf.aVo().aTc() && view != PbActivity.this.eJj.eQf.aVo().aTa()))) {
                            if (view == PbActivity.this.eJj.aUg()) {
                                if (PbActivity.this.eIt != null) {
                                    com.baidu.tbadk.browser.a.T(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIt.getPbData().aPQ().rE().getLink());
                                }
                            } else if (view != PbActivity.this.eJj.eQf.eWn) {
                                if (view == PbActivity.this.eJj.eQf.eWp) {
                                    if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null) {
                                        ArrayList<PostData> aPS = PbActivity.this.eIt.getPbData().aPS();
                                        if ((aPS != null && aPS.size() > 0) || !PbActivity.this.eIt.aSf()) {
                                            if (!PbActivity.this.eJj.aUv()) {
                                                PbActivity.this.eJj.aTA();
                                            }
                                            PbActivity.this.aRb();
                                            return;
                                        }
                                        com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                        return;
                                    }
                                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                } else if (view != PbActivity.this.eJj.eQf.eWo && view.getId() != d.h.pb_god_user_tip_content) {
                                    if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aSM()) {
                                        if ((PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aSZ()) && view.getId() != d.h.floor_owner_reply && view.getId() != d.h.reply_title) {
                                            if (PbActivity.this.eJj.eQf.aVo() == null || (view != PbActivity.this.eJj.eQf.aVo().getCancelView() && view != PbActivity.this.eJj.eQf.aVo().VQ())) {
                                                if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aTf()) {
                                                    if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aSU()) {
                                                        if ((PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aSV()) && view.getId() != d.h.pb_sort) {
                                                            if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aSW()) {
                                                                if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aSX()) {
                                                                    if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aSY()) {
                                                                        if (PbActivity.this.eJo == null || view != PbActivity.this.eJo.aSO()) {
                                                                            if (PbActivity.this.eJo == null || view != PbActivity.this.eJo.aSM()) {
                                                                                if (PbActivity.this.eJo == null || view != PbActivity.this.eJo.aSR()) {
                                                                                    if (PbActivity.this.eJo == null || view != PbActivity.this.eJo.aSP()) {
                                                                                        if (PbActivity.this.eJo == null || view != PbActivity.this.eJo.aSQ()) {
                                                                                            if (PbActivity.this.eJj.aUm() == view) {
                                                                                                if (PbActivity.this.eJj.aUm().getIndicateStatus()) {
                                                                                                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIt.getPbData();
                                                                                                    if (pbData != null && pbData.aPQ() != null && pbData.aPQ().rn() != null) {
                                                                                                        String pH = pbData.aPQ().rn().pH();
                                                                                                        if (StringUtils.isNull(pH)) {
                                                                                                            pH = pbData.aPQ().rn().getTaskId();
                                                                                                        }
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11107").aa("obj_id", pH));
                                                                                                    }
                                                                                                } else {
                                                                                                    com.baidu.tieba.tbadkCore.d.a.ch("c10725", null);
                                                                                                }
                                                                                                PbActivity.this.aRw();
                                                                                                return;
                                                                                            } else if (PbActivity.this.eJj.aTN() != view) {
                                                                                                if (PbActivity.this.eJo == null || view != PbActivity.this.eJo.aSN()) {
                                                                                                    if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aTe()) {
                                                                                                        if (PbActivity.this.eJj.eQf.aVo() != null && view == PbActivity.this.eJj.eQf.aVo().aTb()) {
                                                                                                            if (com.baidu.adp.lib.util.i.hr()) {
                                                                                                                SparseArray<Object> c2 = PbActivity.this.eJj.c(PbActivity.this.eIt.getPbData(), PbActivity.this.eIt.aSf(), 1);
                                                                                                                if (c2 != null) {
                                                                                                                    PbActivity.this.eJj.a(((Integer) c2.get(d.h.tag_del_post_type)).intValue(), (String) c2.get(d.h.tag_del_post_id), ((Integer) c2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.h.tag_del_post_is_self)).booleanValue());
                                                                                                                }
                                                                                                                PbActivity.this.eJj.eQf.oq();
                                                                                                                return;
                                                                                                            }
                                                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                                                            return;
                                                                                                        } else if (view.getId() != d.h.sub_pb_more && view.getId() != d.h.sub_pb_item && view.getId() != d.h.pb_floor_reply_more) {
                                                                                                            if (view != PbActivity.this.eJj.aQO()) {
                                                                                                                if (view == PbActivity.this.eJj.eQf.aVp()) {
                                                                                                                    PbActivity.this.eJj.aTZ();
                                                                                                                    return;
                                                                                                                }
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.h.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (bpVar = (bp) view.getTag()) != null && !StringUtils.isNull(bpVar.tg())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        com.baidu.tbadk.core.util.at.wf().c(PbActivity.this.getPageContext(), new String[]{bpVar.tg()});
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if ((id == d.h.pb_floor_agree || id == d.h.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData bc = PbActivity.this.bc(view);
                                                                                                                    if (bc != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", bc.btt() ? 0 : 1));
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.view_main_thread_praise_state) {
                                                                                                                    PbActivity.this.f(view, 2, false);
                                                                                                                    if (PbActivity.this.aQU() != null && PbActivity.this.aQU().getPbData() != null && PbActivity.this.aQU().getPbData().aQn() != null && PbActivity.this.aQU().getPbData().aQn() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aQU().getPbData().aQn().aQt() ? 0 : 1));
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.view_main_thread_praise_num || id == d.h.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && !StringUtils.isNull(PbActivity.this.eIt.getPbData().getThreadId()) && (aQn = PbActivity.this.eIt.getPbData().aQn()) != null && aQn.getPraiseNum() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.at.wf().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eIt.getPbData().getThreadId()});
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.replybtn || id == d.h.cover_reply_content || id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right || id == d.h.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.h.tag_load_sub_data);
                                                                                                                            if (postData2 == null || !com.baidu.tieba.pb.f.d(postData2)) {
                                                                                                                                if (PbActivity.this.eJo == null) {
                                                                                                                                    PbActivity.this.eJo = new v(PbActivity.this.getPageContext(), PbActivity.this.cll);
                                                                                                                                    PbActivity.this.eJo.jp(PbActivity.this.mIsLogin);
                                                                                                                                }
                                                                                                                                PbActivity.this.eJo.showDialog();
                                                                                                                                boolean z6 = id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right;
                                                                                                                                if (z6) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12006").aa("tid", PbActivity.this.eIt.eMH));
                                                                                                                                }
                                                                                                                                SparseArray sparseArray2 = new SparseArray();
                                                                                                                                sparseArray2.put(d.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.h.tag_clip_board));
                                                                                                                                sparseArray2.put(d.h.tag_is_subpb, false);
                                                                                                                                PbActivity.this.eJo.aSM().setTag(sparseArray2);
                                                                                                                                PbActivity.this.eJo.aSR().setTag(view.getTag());
                                                                                                                                PbActivity.this.eJo.jr(z6);
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
                                                                                                                                        PbActivity.this.eJo.aSP().setVisibility(0);
                                                                                                                                    } else {
                                                                                                                                        sparseArray4.put(d.h.tag_should_delete_visible, false);
                                                                                                                                        PbActivity.this.eJo.aSP().setVisibility(8);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.eJo.aSN().setTag(sparseArray4);
                                                                                                                                    PbActivity.this.eJo.aSP().setTag(sparseArray4);
                                                                                                                                    PbActivity.this.eJo.aSN().setText(d.l.bar_manager);
                                                                                                                                    PbActivity.this.eJo.aSN().setVisibility(0);
                                                                                                                                } else if (!booleanValue3) {
                                                                                                                                    PbActivity.this.eJo.aSN().setVisibility(8);
                                                                                                                                    PbActivity.this.eJo.aSP().setVisibility(8);
                                                                                                                                } else {
                                                                                                                                    SparseArray sparseArray5 = new SparseArray();
                                                                                                                                    sparseArray5.put(d.h.tag_should_manage_visible, false);
                                                                                                                                    sparseArray5.put(d.h.tag_user_mute_visible, false);
                                                                                                                                    sparseArray5.put(d.h.tag_should_delete_visible, true);
                                                                                                                                    sparseArray5.put(d.h.tag_manage_user_identity, sparseArray3.get(d.h.tag_manage_user_identity));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_id, sparseArray3.get(d.h.tag_del_post_id));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_type, sparseArray3.get(d.h.tag_del_post_type));
                                                                                                                                    PbActivity.this.eJo.aSN().setTag(sparseArray5);
                                                                                                                                    PbActivity.this.eJo.aSP().setTag(sparseArray5);
                                                                                                                                    PbActivity.this.eJo.aSN().setText(d.l.delete);
                                                                                                                                    PbActivity.this.eJo.aSP().setVisibility(0);
                                                                                                                                    PbActivity.this.eJo.aSN().setVisibility(8);
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
                                                                                                                                    PbActivity.this.eJo.aSO().setTag(sparseArray7);
                                                                                                                                    PbActivity.this.eJo.aSO().setVisibility(0);
                                                                                                                                    PbActivity.this.eJo.aSN().setVisibility(8);
                                                                                                                                    PbActivity.this.eJo.aSO().setText(d.l.mute_option);
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
                                                                                                                                    PbActivity.this.eKm = (PostData) sparseArray6.get(d.h.tag_clip_board);
                                                                                                                                    if (ap.k(PbActivity.this.eKm) ? false : iZ) {
                                                                                                                                        PbActivity.this.eJo.aSO().setVisibility(0);
                                                                                                                                        PbActivity.this.eJo.aSO().setTag(str3);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.eJo.aSO().setVisibility(8);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                                                                                long j = 0;
                                                                                                                                if (!(sparseArray8.get(d.h.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                    z5 = false;
                                                                                                                                } else {
                                                                                                                                    z5 = ((Boolean) sparseArray8.get(d.h.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                                }
                                                                                                                                if (sparseArray8.get(d.h.tag_chudian_template_id) instanceof Long) {
                                                                                                                                    j = ((Long) sparseArray8.get(d.h.tag_chudian_template_id)).longValue();
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
                                                                                                                                    PbActivity.this.eJo.aSQ().setVisibility(0);
                                                                                                                                    PbActivity.this.eJo.aSQ().setTag(d.h.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                    PbActivity.this.eJo.aSQ().setTag(d.h.tag_chudian_monitor_id, str);
                                                                                                                                    PbActivity.this.eJo.aSQ().setTag(d.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eJo.aSQ().setVisibility(8);
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eIt.getPbData().nL()) {
                                                                                                                            String nK = PbActivity.this.eIt.getPbData().nK();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.j.isEmpty(nK) && nK.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.eJo.aSM().setText(d.l.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eJo.aSM().setText(d.l.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.eJo.jq(true);
                                                                                                                                PbActivity.this.eJo.refreshUI();
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.eJo.jq(true);
                                                                                                                        PbActivity.this.eJo.refreshUI();
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.pb_act_btn) {
                                                                                                                    if (PbActivity.this.eIt.getPbData() != null && PbActivity.this.eIt.getPbData().aPQ() != null && PbActivity.this.eIt.getPbData().aPQ().sl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), PbActivity.this.eIt.getPbData().aPQ().sl());
                                                                                                                        if (PbActivity.this.eIt.getPbData().aPQ().sj() != 1) {
                                                                                                                            if (PbActivity.this.eIt.getPbData().aPQ().sj() == 2) {
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
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10912").aa("fid", PbActivity.this.eIt.getPbData().getForumId()).aa("tid", PbActivity.this.eIt.getPbData().getThreadId()).aa("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.eIt.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.eJj.setSelection(0);
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.pb_item_tail_content) {
                                                                                                                    if (aw.aO(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.l.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.eJj.aTA();
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aQZ() == 1) {
                                                                                                                            if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10397").aa("fid", PbActivity.this.eIt.getPbData().getForumId()).aa("tid", PbActivity.this.eIt.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else if (PbActivity.this.aQZ() == 2 && PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10401").aa("fid", PbActivity.this.eIt.getPbData().getForumId()).aa("tid", PbActivity.this.eIt.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
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
                                                                                                                        if (PbActivity.this.aQZ() == 1) {
                                                                                                                            if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10507").aa("fid", PbActivity.this.eIt.getPbData().getForumId()).aa("tid", PbActivity.this.eIt.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else if (PbActivity.this.aQZ() == 2 && PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10508").aa("fid", PbActivity.this.eIt.getPbData().getForumId()).aa("tid", PbActivity.this.eIt.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.manga_prev_btn) {
                                                                                                                    PbActivity.this.aRr();
                                                                                                                    return;
                                                                                                                } else if (id == d.h.manga_next_btn) {
                                                                                                                    PbActivity.this.aRs();
                                                                                                                    return;
                                                                                                                } else if (id == d.h.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && PbActivity.this.eIt.getPbData().aQi() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eIt.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11679").aa("fid", pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.at.wf().c(PbActivity.this.getPageContext(), new String[]{pbData2.aQi().aQp()});
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.yule_head_img_all_rank && PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && PbActivity.this.eIt.getPbData().aQi() != null) {
                                                                                                                    com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eIt.getPbData();
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11678").aa("fid", pbData3.getForumId()));
                                                                                                                    com.baidu.tbadk.core.util.at.wf().c(PbActivity.this.getPageContext(), new String[]{pbData3.aQi().aQp()});
                                                                                                                    return;
                                                                                                                } else {
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.eIt.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.eIt.getThreadID(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eIt.getPbData().aPQ().rZ())));
                                                                                                                return;
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                            if (PbActivity.this.eIt.getPbData() != null) {
                                                                                                                PbActivity.this.eJj.aBR();
                                                                                                                SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                PostData postData3 = (PostData) sparseArray9.get(d.h.tag_load_sub_data);
                                                                                                                View view2 = (View) sparseArray9.get(d.h.tag_load_sub_view);
                                                                                                                if (postData3 != null && view2 != null) {
                                                                                                                    String threadID = PbActivity.this.eIt.getThreadID();
                                                                                                                    String id2 = postData3.getId();
                                                                                                                    int i3 = 0;
                                                                                                                    if (PbActivity.this.eIt.getPbData() != null) {
                                                                                                                        i3 = PbActivity.this.eIt.getPbData().aQb();
                                                                                                                    }
                                                                                                                    if (!com.baidu.tieba.pb.f.d(postData3)) {
                                                                                                                        PbActivity.this.afK();
                                                                                                                        if (view.getId() == d.h.replybtn) {
                                                                                                                            b ps = PbActivity.this.ps(id2);
                                                                                                                            if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && ps != null) {
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i3, postData3.aWp(), PbActivity.this.eIt.getPbData().qr(), false, postData3.getAuthor().getIconInfo()).addBigImageData(ps.eKQ, ps.eKR, ps.eKS, ps.index)));
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
                                                                                                                            b ps2 = PbActivity.this.ps(id2);
                                                                                                                            if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && ps2 != null && PbActivity.this.aQT().aTy() != null) {
                                                                                                                                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                                                                                                                                nVar.b(PbActivity.this.eIt.getPbData().aPO());
                                                                                                                                nVar.U(PbActivity.this.eIt.getPbData().aPQ());
                                                                                                                                nVar.f(postData4);
                                                                                                                                PbActivity.this.aQT().aTy().d(nVar);
                                                                                                                                PbActivity.this.aQT().aTy().setPostId(str7);
                                                                                                                                PbActivity.this.a(view, str6, str5);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            b ps3 = PbActivity.this.ps(id2);
                                                                                                                            if (postData3 != null && PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && ps3 != null) {
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i3, postData3.aWp(), PbActivity.this.eIt.getPbData().qr(), false, postData3.getAuthor().getIconInfo()).addBigImageData(ps3.eKQ, ps3.eKR, ps3.eKS, ps3.index)));
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
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 3).aa("fid", PbActivity.this.eIt.getPbData().getForumId()));
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (com.baidu.adp.lib.util.i.hr()) {
                                                                                                        PbActivity.this.eJj.aBR();
                                                                                                        SparseArray<Object> c3 = PbActivity.this.eJj.c(PbActivity.this.eIt.getPbData(), PbActivity.this.eIt.aSf(), 1);
                                                                                                        if (c3 != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIt.getPbData().aPO().getId(), PbActivity.this.eIt.getPbData().aPO().getName(), PbActivity.this.eIt.getPbData().aPQ().getId(), String.valueOf(PbActivity.this.eIt.getPbData().getUserData().getUserId()), (String) c3.get(d.h.tag_forbid_user_name), (String) c3.get(d.h.tag_forbid_user_post_id))));
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else {
                                                                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (!com.baidu.adp.lib.util.i.hr()) {
                                                                                                    PbActivity.this.showToast(d.l.network_not_available);
                                                                                                    return;
                                                                                                } else {
                                                                                                    SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                                    if (sparseArray11 != null) {
                                                                                                        if (!com.baidu.tieba.c.a.VI() || sparseArray11.get(d.h.tag_del_post_id) == null || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eIt.getThreadID(), (String) sparseArray11.get(d.h.tag_del_post_id))) {
                                                                                                            boolean booleanValue4 = ((Boolean) sparseArray11.get(d.h.tag_should_manage_visible)).booleanValue();
                                                                                                            boolean booleanValue5 = ((Boolean) sparseArray11.get(d.h.tag_should_delete_visible)).booleanValue();
                                                                                                            boolean booleanValue6 = ((Boolean) sparseArray11.get(d.h.tag_user_mute_visible)).booleanValue();
                                                                                                            if (booleanValue4) {
                                                                                                                if (booleanValue6) {
                                                                                                                    sparseArray11.put(d.h.tag_from, 1);
                                                                                                                    sparseArray11.put(d.h.tag_check_mute_from, 2);
                                                                                                                    PbActivity.this.d(sparseArray11);
                                                                                                                    return;
                                                                                                                }
                                                                                                                sparseArray11.put(d.h.tag_check_mute_from, 2);
                                                                                                                PbActivity.this.eJj.bh(view);
                                                                                                                return;
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.eJj.a(((Integer) sparseArray11.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.h.tag_del_post_id), ((Integer) sparseArray11.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.h.tag_del_post_is_self)).booleanValue());
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", PbActivity.this.eIt.getPbData().getForumId()));
                                                                                                return;
                                                                                            } else {
                                                                                                PbActivity.this.aQQ();
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        long j2 = -1;
                                                                                        String str8 = "";
                                                                                        int i4 = 0;
                                                                                        if (view.getTag(d.h.tag_chudian_template_id) instanceof Long) {
                                                                                            j2 = ((Long) view.getTag(d.h.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (view.getTag(d.h.tag_chudian_monitor_id) instanceof String) {
                                                                                            str8 = (String) view.getTag(d.h.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (view.getTag(d.h.tag_chudian_hide_day) instanceof Integer) {
                                                                                            i4 = ((Integer) view.getTag(d.h.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eIt.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aPO() != null) {
                                                                                            str9 = pbData4.aPO().getId();
                                                                                            str10 = pbData4.aPO().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.b.a(j2, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j2, str8, str9, str10, str11, i4);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                                    if (sparseArray12 != null && (sparseArray12.get(d.h.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.h.tag_del_post_id) instanceof String) && (sparseArray12.get(d.h.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.h.tag_del_post_is_self) instanceof Boolean)) {
                                                                                        boolean booleanValue7 = ((Boolean) sparseArray12.get(d.h.tag_del_post_is_self)).booleanValue();
                                                                                        int intValue = ((Integer) sparseArray12.get(d.h.tag_manage_user_identity)).intValue();
                                                                                        if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.VI() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eIt.getThreadID(), (String) sparseArray12.get(d.h.tag_del_post_id))) {
                                                                                            PbActivity.this.eJj.a(((Integer) sparseArray12.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.h.tag_del_post_id), intValue, booleanValue7);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                if (PbActivity.this.eJo.aST()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12007").aa("tid", PbActivity.this.eIt.eMH));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eIt.getPbData() != null) {
                                                                                    PbActivity.this.eJj.aBR();
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
                                                                                        String threadID2 = PbActivity.this.eIt.getThreadID();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.eIt.getPbData() != null) {
                                                                                            i5 = PbActivity.this.eIt.getPbData().aQb();
                                                                                        }
                                                                                        PbActivity.this.afK();
                                                                                        b ps4 = PbActivity.this.ps(id3);
                                                                                        if (ps4 != null) {
                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID2, id3, "pb", true, null, true, null, i5, postData.aWp(), PbActivity.this.eIt.getPbData().qr(), false, postData.getAuthor().getIconInfo()).addBigImageData(ps4.eKQ, ps4.eKR, ps4.eKS, ps4.index)));
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11739").r("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bd(view);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11739").r("obj_locate", 4));
                                                                        if (!com.baidu.adp.lib.util.i.hr()) {
                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                            return;
                                                                        }
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            PbActivity.this.pp((String) tag);
                                                                            return;
                                                                        } else if (tag instanceof SparseArray) {
                                                                            SparseArray<Object> sparseArray13 = (SparseArray) tag;
                                                                            if ((sparseArray13.get(d.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray13.get(d.h.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray13.put(d.h.tag_from, 0);
                                                                                sparseArray13.put(d.h.tag_check_mute_from, 2);
                                                                                PbActivity.this.d(sparseArray13);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), null, PbActivity.this.aQY(), true)));
                                                                    PbActivity.this.eJj.eQf.oq();
                                                                    PbActivity.this.eJj.eQf.aVo().aTg();
                                                                    return;
                                                                }
                                                                TiebaStatic.log("c10414");
                                                                PbActivity.this.eJj.aBR();
                                                                if (PbActivity.this.eJj.rs() == aq.eRV) {
                                                                    PbActivity.this.eJj.aUl();
                                                                    return;
                                                                } else if (PbActivity.this.eIt.aSD() != null) {
                                                                    PbActivity.this.eIt.aSD().pg(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                                                    return;
                                                                } else {
                                                                    return;
                                                                }
                                                            } else if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && PbActivity.this.eIt.getPbData().aPQ() != null) {
                                                                PbActivity.this.eJj.eQf.oq();
                                                                PbActivity.this.pp(PbActivity.this.eIt.getPbData().aPQ().rV());
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        PbActivity.this.eJj.aBR();
                                                        if (com.baidu.adp.lib.util.i.hr()) {
                                                            PbActivity.this.pb(2);
                                                            PbActivity.this.afK();
                                                            PbActivity.this.eJj.aTT();
                                                            PbActivity.this.eJj.aTO().je(true);
                                                            boolean z7 = false;
                                                            if (!(view.getTag() instanceof Boolean)) {
                                                                PbActivity.this.eIt.aSp();
                                                            } else {
                                                                z7 = PbActivity.this.eIt.jm(!((Boolean) view.getTag()).booleanValue());
                                                            }
                                                            TiebaStatic.log("c12097");
                                                            if (z7 && PbActivity.this.getListView() != null) {
                                                                if (PbActivity.this.eJE > PbActivity.this.getListView().getFirstVisiblePosition()) {
                                                                    PbActivity.this.eJE = PbActivity.this.getListView().getFirstVisiblePosition();
                                                                }
                                                                View childAt = PbActivity.this.getListView().getChildAt(0);
                                                                int i6 = -1;
                                                                if (childAt != null) {
                                                                    i6 = childAt.getTop();
                                                                }
                                                                PbActivity.this.aQT().i(PbActivity.this.eJE, i6);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                        return;
                                                    }
                                                    PbActivity.this.eJj.aBR();
                                                    if (PbActivity.this.eIt.aqU() != null) {
                                                        PbActivity.this.eJj.a(PbActivity.this.eIt.aqU(), PbActivity.this.eqk);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    return;
                                                } else if (PbActivity.this.checkUpIsLogin()) {
                                                    if (com.baidu.adp.lib.util.k.hI()) {
                                                        PbActivity.this.eJj.aBR();
                                                        PbActivity.this.afK();
                                                        PbActivity.this.pb(2);
                                                        if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && PbActivity.this.eIt.getPbData().aQi() != null && !StringUtils.isNull(PbActivity.this.eIt.getPbData().aQi().pV(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11678").aa("fid", PbActivity.this.eIt.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11939"));
                                                        PbActivity.this.eJj.Rr();
                                                        PbActivity.this.eIt.aSG().p(CheckRealNameModel.TYPE_PB_SHARE, Integer.valueOf(view == PbActivity.this.eJj.eRE ? 1 : 2));
                                                        return;
                                                    }
                                                    PbActivity.this.showToast(d.l.neterror);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            PbActivity.this.eJj.eQf.oq();
                                        } else if (com.baidu.adp.lib.util.i.hr()) {
                                            PbActivity.this.eJj.aBR();
                                            if (PbActivity.this.eJj.eQf.aVo() != null && view == PbActivity.this.eJj.eQf.aVo().aSZ() && !PbActivity.this.eJj.aUv()) {
                                                PbActivity.this.eJj.aTA();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.eJj.eQf.eWo.setEnabled(false);
                                                PbActivity.this.afK();
                                                PbActivity.this.eJj.aTT();
                                                if (view.getId() == d.h.floor_owner_reply) {
                                                    i2 = PbActivity.this.eIt.i(true, PbActivity.this.aRp());
                                                } else {
                                                    i2 = view.getId() == d.h.reply_title ? PbActivity.this.eIt.i(false, PbActivity.this.aRp()) : PbActivity.this.eIt.pu(PbActivity.this.aRp());
                                                }
                                                if (i2) {
                                                    PbActivity.this.eJj.awv();
                                                    PbActivity.this.mIsLoading = true;
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.pb(2);
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.l.network_not_available);
                                        }
                                    } else if (com.baidu.adp.lib.util.i.hr()) {
                                        PbActivity.this.eJj.aBR();
                                        if (PbActivity.this.pa(11009) && PbActivity.this.eIt.pp(PbActivity.this.eJj.aTY()) != null) {
                                            PbActivity.this.aRj();
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.l.network_not_available);
                                    }
                                } else if (com.baidu.adp.lib.util.i.hr()) {
                                    PbActivity.this.eJj.jh(true);
                                    PbActivity.this.eJj.aTA();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eJj.eQf.eWo.setEnabled(false);
                                        PbActivity.this.eJj.awv();
                                        PbActivity.this.afK();
                                        PbActivity.this.eJj.aTT();
                                        PbActivity.this.eIt.pu(PbActivity.this.aRp());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.pb(2);
                                    }
                                } else {
                                    PbActivity.this.showToast(d.l.network_not_available);
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.eIt.getPbData() != null && PbActivity.this.eIt.getPbData().aPQ() != null && PbActivity.this.eIt.getPbData().aPQ().ss() && PbActivity.this.eIt.getPbData().aPQ().rW() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11922"));
                                }
                                if (PbActivity.this.eIt.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eIt.aSe()) && PbActivity.this.eIt.getAppealInfo() != null) {
                                        name = PbActivity.this.eIt.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eIt.getPbData().aPO().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aSe = PbActivity.this.eIt.aSe();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eIt.aSg() && aSe != null && aSe.equals(name)) {
                                        PbActivity.this.finish();
                                        return;
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                        return;
                                    }
                                }
                                PbActivity.this.finish();
                            }
                        } else if (com.baidu.adp.lib.util.i.hr()) {
                            if (PbActivity.this.eIt.getPbData().aQb() == 1 && !PbActivity.this.eJi.btS()) {
                                PbActivity.this.eJj.aBR();
                                int i7 = 0;
                                if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aTa()) {
                                    if (PbActivity.this.eJj.eQf.aVo() == null || view != PbActivity.this.eJj.eQf.aVo().aTc()) {
                                        if (view == PbActivity.this.eJj.aTR()) {
                                            i7 = 2;
                                        }
                                    } else if (PbActivity.this.eIt.getPbData().aPQ().rB() == 1) {
                                        i7 = 3;
                                    } else {
                                        i7 = 6;
                                    }
                                } else if (PbActivity.this.eIt.getPbData().aPQ().rA() == 1) {
                                    i7 = 5;
                                } else {
                                    i7 = 4;
                                }
                                ForumData aPO = PbActivity.this.eIt.getPbData().aPO();
                                String name2 = aPO.getName();
                                String id4 = aPO.getId();
                                String id5 = PbActivity.this.eIt.getPbData().aPQ().getId();
                                if (!com.baidu.tieba.c.a.VI() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eJj.aTQ();
                                    PbActivity.this.eJi.a(id4, name2, id5, i7, PbActivity.this.eJj.aTS());
                                }
                            }
                        } else {
                            PbActivity.this.showToast(d.l.network_not_available);
                        }
                    } else if (com.baidu.adp.lib.util.i.hr()) {
                        PbActivity.this.eJj.aBR();
                        PbActivity.this.afK();
                        PbActivity.this.eJj.aTT();
                        PbActivity.this.eJj.Rr();
                        PbActivity.this.eIt.pi(1);
                    } else {
                        PbActivity.this.showToast(d.l.network_not_available);
                    }
                } else if (PbActivity.this.eIX) {
                    PbActivity.this.eIX = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.h.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && PbActivity.this.aQT().aTy() != null && postData5.getAuthor() != null && postData5.btg() != 1 && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.d(postData5)) {
                                com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                                nVar2.b(PbActivity.this.eIt.getPbData().aPO());
                                nVar2.U(PbActivity.this.eIt.getPbData().aPQ());
                                nVar2.f(postData5);
                                PbActivity.this.aQT().aTy().d(nVar2);
                                PbActivity.this.aQT().aTy().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.getAuthor().getUserId(), "");
                                TiebaStatic.log("c11743");
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aEm = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.afK();
            PbActivity.this.eJj.jI(z);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbActivity.this.eJj.aBR();
                if (PbActivity.this.eJx != null) {
                    PbActivity.this.eJj.hk(PbActivity.this.eJx.DG());
                }
                PbActivity.this.eJj.aTx();
                PbActivity.this.eJj.hl(true);
                PbActivity.this.eIt.aSs();
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eIt.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIt.getPbData();
                            if (pbData != null && pbData.aPQ() != null && pbData.aPQ().getAuthor() != null && (userId = pbData.aPQ().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && PbActivity.this.eIt.aSl()) {
                                PbActivity.this.eJj.aTT();
                            }
                        } else if (PbActivity.this.eIt.aSl()) {
                            PbActivity.this.eJj.aTT();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eJj.m(PbActivity.this.eIt.getPbData());
                    }
                    if (PbActivity.this.eIt.aSi()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10369").aa("tid", PbActivity.this.eIt.getThreadID()));
                    }
                }
            } else if (qVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    private final PbModel.a eKc = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eC;
            if (!z || fVar == null || fVar.aPZ() != null || com.baidu.tbadk.core.util.u.u(fVar.aPS()) >= 1) {
                PbActivity.this.efV = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eJj.aTV();
                if (fVar == null || !fVar.aPW()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eJj.getView());
                } else if (PbActivity.this.eJj.aTv() == null) {
                    PbActivity.this.eJz = true;
                }
                PbActivity.this.eJj.awu();
                PbActivity.this.eJj.aTP();
                if (PbActivity.this.eJc || PbActivity.this.eJj.aUv()) {
                    PbActivity.this.eJj.aUj();
                } else {
                    PbActivity.this.eJj.hl(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                    PbActivity.this.eJj.eQf.eWo.setEnabled(true);
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eJs = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eJj.Nr();
                    PbActivity.this.eJj.jN(fVar.aPW());
                    if (fVar.aPQ() != null && fVar.aPQ().sB() != null) {
                        PbActivity.this.a(fVar.aPQ().sB());
                    }
                    if (PbActivity.this.eJx != null) {
                        PbActivity.this.eJj.hk(PbActivity.this.eJx.DG());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aPS() != null && fVar.aPS().size() >= 1 && fVar.aPS().get(0) != null) {
                        PbActivity.this.eIt.pw(fVar.aPS().get(0).getId());
                    } else if (fVar.aPZ() != null) {
                        PbActivity.this.eIt.pw(fVar.aPZ().getId());
                    }
                    if (PbActivity.this.eJx != null) {
                        PbActivity.this.eJx.a(fVar.qr());
                        PbActivity.this.eJx.a(fVar.aPO(), fVar.getUserData());
                        PbActivity.this.eJx.a(PbActivity.this.eIt.aSm(), PbActivity.this.eIt.getThreadID(), PbActivity.this.eIt.aSI());
                        if (fVar.aPQ() != null) {
                            PbActivity.this.eJx.bL(fVar.aPQ().sR());
                        }
                    }
                    if (PbActivity.this.ech != null) {
                        PbActivity.this.ech.ac(fVar.nL());
                    }
                    if (fVar == null || fVar.aQc() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eJj.jM(PbActivity.this.mIsFromCDN);
                    if (PbActivity.this.eJp) {
                        PbActivity.this.a(PbActivity.this.eIt.getPbData(), -1, 0, false, true);
                    } else if (PbActivity.this.eJq && !PbActivity.this.eJr) {
                        PbActivity.this.a(PbActivity.this.eIt.getPbData(), -1, false, true);
                        PbActivity.this.eJr = true;
                        PbActivity.this.eJp = true;
                    }
                    PbActivity.this.eJj.a(fVar, i2, i3, PbActivity.this.eIt.aSf(), i4, PbActivity.this.eIt.getIsFromMark());
                    PbActivity.this.eJj.e(fVar, PbActivity.this.eIt.aSf());
                    PbActivity.this.eJj.jK(PbActivity.this.eIt.getHostMode());
                    if (PbActivity.this.eIt.aSB() != null) {
                        PbActivity.this.eJj.jJ(PbActivity.this.eIt.aSB().aSa());
                    }
                    AntiData qr = fVar.qr();
                    if (qr != null) {
                        PbActivity.this.aEa = qr.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aEa) && PbActivity.this.eJx != null && PbActivity.this.eJx.Da() != null && (eC = PbActivity.this.eJx.Da().eC(6)) != null && !TextUtils.isEmpty(PbActivity.this.aEa)) {
                            ((View) eC).setOnClickListener(PbActivity.this.dKU);
                        }
                    }
                    com.baidu.tieba.pb.f.pf(fVar.eGj);
                    if (PbActivity.this.eJu) {
                        PbActivity.this.eJu = false;
                        PbActivity.this.aQT().getListView().setSelection(PbActivity.this.aRd());
                    }
                    if (PbActivity.this.eJv) {
                        PbActivity.this.eJv = false;
                        int aRd = PbActivity.this.aRd();
                        if (aRd == -1) {
                            aRd = PbActivity.this.aRe();
                        }
                        if (PbActivity.this.aQT() != null && PbActivity.this.aQT().getListView() != null) {
                            PbActivity.this.aQT().getListView().setSelection(aRd);
                        }
                    }
                    PbActivity.this.eIt.a(fVar.aPO(), PbActivity.this.eJQ);
                } else if (str != null) {
                    if (!PbActivity.this.eJs && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eIt != null && PbActivity.this.eIt.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eIt.getAppealInfo().eFE)) {
                                    PbActivity.this.eJj.a(PbActivity.this.eIt.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eJj.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eJj.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                            }
                            PbActivity.this.eJj.aUj();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i != -1) {
                        PbActivity.this.eJj.py(PbActivity.this.getResources().getString(d.l.list_no_more_new));
                    } else {
                        PbActivity.this.eJj.py("");
                    }
                    PbActivity.this.eJj.wX();
                }
                PbActivity.this.aKj = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aQU().aSf() || PbActivity.this.aQU().getPbData().qH().qE() != 0 || PbActivity.this.aQU().aSz()) {
                    PbActivity.this.eJy = true;
                    return;
                }
                return;
            }
            PbActivity.this.eIt.pi(1);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void c(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eJj.m(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.r.Gz().GA()) {
                com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m(i, z, responsedMessage, PbActivity.this.aKb, PbActivity.this.createTime, PbActivity.this.aKj, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.bZn : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aKb = 0L;
                if (mVar != null) {
                    mVar.Gu();
                }
            }
        }
    };
    private CustomMessageListener eKd = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aQZ() == 1) {
                    PbActivity.this.aRh();
                }
                PbActivity.this.aRa();
            }
        }
    };
    private CustomMessageListener eKe = new CustomMessageListener(CmdConfigCustom.CMD_TTS_OPTION_PB) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
                com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
                if (aVar.tag == PbActivity.this.getUniqueId()) {
                    switch (aVar.eYD) {
                        case 0:
                            if (PbActivity.this.mIsLogin) {
                                if (PbActivity.this.eIt.jk(false)) {
                                    PbActivity.this.eJj.aTU();
                                    return;
                                } else if (PbActivity.this.eIt.getPbData() != null) {
                                    PbActivity.this.eJj.aUh();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        case 1:
                            if (!PbActivity.this.mIsLoading) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.eJj.eQf.eWo.setEnabled(false);
                                PbActivity.this.eJj.awv();
                                PbActivity.this.afK();
                                PbActivity.this.eJj.aTT();
                                PbActivity.this.eIt.pu(PbActivity.this.aRp());
                                return;
                            }
                            return;
                        case 2:
                            if (PbActivity.this.eIN) {
                                boolean hostMode = PbActivity.this.eIt.getHostMode();
                                boolean aSf = PbActivity.this.eIt.aSf();
                                String threadID = PbActivity.this.eIt.getThreadID();
                                String str = aVar.postId;
                                int i2 = aVar.eYE;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(PbActivity.this.getPageContext().getPageActivity());
                                pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aSf, null);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                                PbActivity.this.eJp = false;
                                PbActivity.this.finish();
                                return;
                            }
                            int i3 = aVar.eYE;
                            if (PbActivity.this.eIt.getHostMode()) {
                                i = i3 + 3;
                            } else {
                                i = i3 + 2;
                            }
                            PbActivity.this.eJj.getListView().setSelection(i);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    };
    private final a.InterfaceC0038a eKf = new a.InterfaceC0038a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0038a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eJj.aTV();
            if (z) {
                if (PbActivity.this.ech != null) {
                    PbActivity.this.ech.ac(z2);
                }
                PbActivity.this.eIt.jn(z2);
                if (PbActivity.this.eIt.nL()) {
                    PbActivity.this.aRk();
                } else {
                    PbActivity.this.eJj.m(PbActivity.this.eIt.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.ech != null) {
                        if (PbActivity.this.ech.nO() != null) {
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
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            boolean z = true;
            if (!PbActivity.this.oZ(PbActivity.this.mLastScrollState) && PbActivity.this.oZ(i)) {
                if (PbActivity.this.eJj != null) {
                    PbActivity.this.eJj.aBR();
                    if (PbActivity.this.eJx != null && !PbActivity.this.eJj.aTB()) {
                        PbActivity.this.eJj.hk(PbActivity.this.eJx.DG());
                    }
                    PbActivity.this.eJj.aTA();
                }
                if (!PbActivity.this.eIT) {
                    PbActivity.this.eIT = true;
                    PbActivity.this.eJj.aUi();
                }
            }
            PbActivity.this.eJj.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eIL != null) {
                PbActivity.this.eIL.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eIU == null) {
                PbActivity.this.eIU = new com.baidu.tbadk.l.d();
                PbActivity.this.eIU.fi(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && PbActivity.this.eIt.getPbData().aPQ() != null && PbActivity.this.eIt.getPbData().aPQ().ss()) {
                    z = false;
                }
                if (PbActivity.this.eJj.aTO() != null && z) {
                    PbActivity.this.eJj.aTO().notifyDataSetChanged();
                }
                PbActivity.this.eIU.Gg();
            } else if (i == 1) {
                PbActivity.this.eIU.Gg();
            } else {
                PbActivity.this.eIU.Gg();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aPS;
            if (PbActivity.this.eIt != null && PbActivity.this.eIt.getPbData() != null && PbActivity.this.eJj != null && PbActivity.this.eJj.aTO() != null) {
                PbActivity.this.eJj.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eIL != null) {
                    PbActivity.this.eIL.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eIt.aSu() && (aPS = PbActivity.this.eIt.getPbData().aPS()) != null && !aPS.isEmpty()) {
                    int aRP = ((i + i2) - PbActivity.this.eJj.aTO().aRP()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIt.getPbData();
                    if (pbData != null) {
                        if (pbData.aPT() != null && pbData.aPT().hasData()) {
                            aRP--;
                        }
                        if (pbData.aPU() != null && pbData.aPU().hasData()) {
                            aRP--;
                        }
                        if (PbActivity.this.eIW) {
                            aRP--;
                        }
                        int size = aPS.size();
                        if (aRP < 0 || aRP >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eKg = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.adp.base.d
        public void g(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eJi.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eIt.aSs();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cJK || bVar.eXV <= 0 || bVar.glW == 0) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eJj.a(1, dVar.Co, dVar.glY, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eJi.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eJj.a(PbActivity.this.eJi.getLoadDataMode(), fVar.Co, fVar.glY, false);
                        PbActivity.this.eJj.am(fVar.gma);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eJj.a(PbActivity.this.eJi.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final c eKh = new c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
    };
    private final k.b bax = new k.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aRq()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eIt.jl(true)) {
                PbActivity.this.eJj.aTW();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eKj = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eKi && PbActivity.this.aRq()) {
                PbActivity.this.aRs();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eIt.jk(false)) {
                    PbActivity.this.eJj.aTU();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eIt.getPbData() != null) {
                    PbActivity.this.eJj.aUh();
                }
                PbActivity.this.eKi = true;
            }
        }
    };
    private int eKk = 0;
    private final TbRichTextView.e aRN = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
        public void a(View view, String str, int i) {
            TbRichTextData tbRichTextData;
            try {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                b bVar = new b();
                PbActivity.this.a(str, i, bVar);
                if (bVar.eKU) {
                    TbRichText ao = PbActivity.this.ao(str, i);
                    if (ao != null && (tbRichTextData = ao.Io().get(PbActivity.this.eKk)) != null && tbRichTextData.Iz() != null && tbRichTextData.Iz().memeInfo != null && !TextUtils.isEmpty(tbRichTextData.Iz().memeInfo.detail_link)) {
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextData.Iz().memeInfo.detail_link)));
                    }
                } else if (!bVar.eKT) {
                    ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eKQ, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eKS, bVar.eKQ.get(0), PbActivity.this.eIt.aSq(), bVar.eKR, true, false, PbActivity.this.eIt.getHostMode());
                    createConfig.getIntent().putExtra("from", "pb");
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                } else {
                    TbRichText ao2 = PbActivity.this.ao(str, i);
                    if (ao2 != null && PbActivity.this.eKk >= 0 && PbActivity.this.eKk < ao2.Io().size()) {
                        String c2 = com.baidu.tieba.pb.data.g.c(ao2.Io().get(PbActivity.this.eKk));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= bVar.eKQ.size()) {
                                break;
                            } else if (!bVar.eKQ.get(i3).equals(c2)) {
                                i2 = i3 + 1;
                            } else {
                                bVar.index = i3;
                                break;
                            }
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eKQ, bVar.index, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eKS, bVar.lastId, PbActivity.this.eIt.aSq(), bVar.eKR, true, false, PbActivity.this.eIt.getHostMode());
                        createConfig2.getIntent().putExtra("from", "pb");
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eKl = false;
    PostData eKm = null;
    private final b.InterfaceC0043b eKn = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eKm != null) {
                if (i == 0) {
                    PbActivity.this.eKm.bN(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eKm = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.h(PbActivity.this.eKm);
                }
            }
        }
    };
    private final b.InterfaceC0043b eKo = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eJG != null && !TextUtils.isEmpty(PbActivity.this.eJH)) {
                if (i == 0) {
                    if (PbActivity.this.eJI == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eJH));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eJH;
                        aVar.pkgId = PbActivity.this.eJI.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eJI.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eJF == null) {
                        PbActivity.this.eJF = new at(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eJF.h(PbActivity.this.eJH, PbActivity.this.eJG.la());
                }
                PbActivity.this.eJG = null;
                PbActivity.this.eJH = null;
            }
        }
    };
    private final View.OnLongClickListener awo = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eJG = ((TbImageView) view).getBdImage();
                PbActivity.this.eJH = ((TbImageView) view).getUrl();
                if (PbActivity.this.eJG != null && !TextUtils.isEmpty(PbActivity.this.eJH)) {
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eJI = null;
                    } else {
                        PbActivity.this.eJI = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eJj.a(PbActivity.this.eKo, PbActivity.this.eJG.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eKm = (PostData) sparseArray.get(d.h.tag_clip_board);
                    if (PbActivity.this.eKm != null && PbActivity.this.ech != null) {
                        PbActivity.this.eJj.a(PbActivity.this.eKn, PbActivity.this.ech.nL() && PbActivity.this.eKm.getId() != null && PbActivity.this.eKm.getId().equals(PbActivity.this.eIt.rO()), ((Boolean) sparseArray.get(d.h.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a bFE = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!PbActivity.this.eIN && z && !PbActivity.this.eIt.aSk()) {
                PbActivity.this.Wb();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
        }
    };
    public View.OnTouchListener aMT = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).apW()) {
                        break;
                    }
                }
            }
            PbActivity.this.cmM.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0080a bWR = new a.InterfaceC0080a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        final int byL;

        {
            this.byL = (int) PbActivity.this.getResources().getDimension(d.f.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2) && PbActivity.this.eJj != null && PbActivity.this.eIL != null) {
                PbActivity.this.eIL.eo(false);
                PbActivity.this.eIL.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ai(int i, int i2) {
            if (Y(i2) && PbActivity.this.eJj != null && PbActivity.this.eIL != null) {
                PbActivity.this.eIL.eo(true);
                if (Math.abs(i2) > this.byL) {
                    PbActivity.this.eIL.hideFloatingView();
                }
                if (PbActivity.this.aRq()) {
                    PbActivity.this.eJj.aTJ();
                    PbActivity.this.eJj.aTK();
                }
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eKp = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tieba.e.b.a
        public void ef(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aQH();
            } else {
                com.baidu.tieba.pb.a.b.aQG();
            }
        }
    };
    private String eKq = null;
    private final m.a eKr = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.l.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eKq = str2;
                PbActivity.this.eJj.pz(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eKs = -1;
    private int eKt = -1;
    private CustomMessageListener eKw = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Ua == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0041a) {
                    if (aVar.Ub != null && !aVar.Ub.hasError() && aVar.Ub.getError() == 0) {
                        if (PbActivity.this.eJj != null) {
                            PbActivity.this.eJj.w(((a.C0041a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aRC();
                        }
                    } else if (z) {
                        if (aVar.Ub != null && aVar.Ub.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Ub.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Ub != null && !aVar.Ub.hasError() && aVar.Ub.getError() == 0) {
                        if (PbActivity.this.eJj != null && PbActivity.this.eJj != null) {
                            PbActivity.this.eJj.w(((a.C0041a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Ub != null && aVar.Ub.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Ub.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Ub == null || aVar.Ub.hasError() || aVar.Ub.getError() != 0) {
                        if (z) {
                            if (aVar.Ub != null && aVar.Ub.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Ub.getErrorString());
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
    private final CustomMessageListener ckH = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11455").aa("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.at.wf().c(PbActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    private d.b Kh = new d.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
        @Override // com.baidu.adp.widget.d.b
        public void ly() {
            PbActivity.this.eJj.aUx();
        }

        @Override // com.baidu.adp.widget.d.b
        public void W(boolean z) {
            if (z) {
                PbActivity.this.eJj.aUy();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> eKQ;
        public ConcurrentHashMap<String, ImageUrlData> eKR;
        public boolean eKT;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eKS = false;
        public boolean eKU = false;
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

    public com.baidu.tbadk.editortools.pb.c aQP() {
        return this.eJx;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        if (nVar.aQy() != null) {
            String id = nVar.aQy().getId();
            ArrayList<PostData> aPS = this.eIt.getPbData().aPS();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aPS.size()) {
                    break;
                }
                PostData postData = aPS.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aQC = nVar.aQC();
                    postData.tr(nVar.getTotalCount());
                    if (postData.btd() != null) {
                        postData.btd().clear();
                        postData.btd().addAll(aQC);
                    }
                }
            }
            this.eJj.m(this.eIt.getPbData());
            c(nVar);
        }
    }

    public void aQQ() {
        com.baidu.tieba.pb.data.f pbData;
        bl aPQ;
        if (!this.eJS) {
            if (!com.baidu.adp.lib.util.k.hI()) {
                showToast(d.l.no_network_guide);
            } else if (this.eJV) {
                this.eJS = true;
                if (this.eIt != null && (pbData = this.eIt.getPbData()) != null && (aPQ = pbData.aPQ()) != null) {
                    int isLike = aPQ.rv() == null ? 0 : aPQ.rv().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10796").aa("tid", aPQ.getId()));
                    }
                    if (this.eJT != null) {
                        this.eJT.a(aPQ.rV(), aPQ.getId(), isLike, "pb");
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
                    bVar.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.eJj.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eJC);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eJC);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.l.un_mute) : getResources().getString(d.l.mute);
                    bVar.a(strArr2, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eJC);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eJC);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).tu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja(int i) {
        bl aPQ;
        String str;
        String z;
        if (this.eIt != null && this.eIt.getPbData() != null && (aPQ = this.eIt.getPbData().aPQ()) != null) {
            if (i == 1) {
                PraiseData rv = aPQ.rv();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rv == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aPQ.a(praiseData);
                    } else {
                        aPQ.rv().getUser().add(0, metaData);
                        aPQ.rv().setNum(aPQ.rv().getNum() + 1);
                        aPQ.rv().setIsLike(i);
                    }
                }
                if (aPQ.rv() != null) {
                    if (aPQ.rv().getNum() < 1) {
                        z = getResources().getString(d.l.frs_item_praise_text);
                    } else {
                        z = com.baidu.tbadk.core.util.al.z(aPQ.rv().getNum());
                    }
                    this.eJj.T(z, true);
                }
            } else if (aPQ.rv() != null) {
                aPQ.rv().setIsLike(i);
                aPQ.rv().setNum(aPQ.rv().getNum() - 1);
                ArrayList<MetaData> user = aPQ.rv().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aPQ.rv().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aPQ.rv().getNum() < 1) {
                    str = getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = aPQ.rv().getNum() + "";
                }
                this.eJj.T(str, false);
            }
            if (this.eIt.aSf()) {
                this.eJj.aTO().notifyDataSetChanged();
            } else {
                this.eJj.n(this.eIt.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.adp.framework.message.Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().asR && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eIt != null && this.eIt.getPbData() != null && this.eJj != null) {
            this.eJj.d(this.eIt.getPbData(), this.eIt.aSf(), this.eIt.aSv());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eIt.r(bundle);
        if (this.cjJ != null) {
            this.cjJ.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eJx.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eJA = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.bZn = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eJd = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eJd)) {
                this.eIM = true;
            }
            this.eKs = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eKt = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eKu = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eJq = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.eJu = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eJv = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aRq()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.al.isEmpty(this.source) ? "" : this.source;
            this.eJJ = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.eIY = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.bZn = System.currentTimeMillis();
        }
        this.eIS = System.currentTimeMillis();
        this.aKb = this.eIS - this.bZn;
        super.onCreate(bundle);
        this.mSwipeBackLayout.setOnSlidingStateChangeListener(this.Kh);
        this.eIP = 0;
        t(bundle);
        if (this.eIt != null && this.eIt.getPbData() != null) {
            this.eIt.getPbData().pl(this.source);
        }
        initUI();
        if (intent != null && this.eJj != null) {
            this.eJj.ePV = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eJD == null) {
                    this.eJD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eJj.pB("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eJD, 1500L);
            }
        }
        this.cjJ = new VoiceManager();
        this.cjJ.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
        dVar.setForumName(this.eIt.aSe());
        if (this.eIt.getPbData() != null && this.eIt.getPbData().aPO() != null) {
            dVar.setForumId(this.eIt.getPbData().aPO().getId());
        }
        dVar.setFrom("pb");
        dVar.a(this.eIt);
        this.eJx = (com.baidu.tbadk.editortools.pb.c) dVar.aR(getActivity());
        this.eJx.d(this);
        this.eJx.a(this.aEm);
        this.eJx.a(this.aEf);
        this.eJx.a(this, bundle);
        this.eJx.Da().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eJx.Da().bE(true);
        iY(true);
        this.eJj.setEditorTools(this.eJx.Da());
        this.eJx.a(this.eIt.aSm(), this.eIt.getThreadID(), this.eIt.aSI());
        registerListener(this.dKV);
        if (!this.eIt.aSj()) {
            this.eJx.fW(this.eIt.getThreadID());
        }
        if (this.eIt.aSJ()) {
            this.eJx.fU(getPageContext().getString(d.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eJx.fU(getPageContext().getString(d.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eIS;
        registerListener(this.eJM);
        registerListener(this.dLr);
        registerListener(this.eJN);
        registerListener(this.ckD);
        registerListener(this.eKb);
        registerListener(this.eJL);
        this.eJw = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gjg);
        this.eJw.bsH();
        registerListener(this.eJP);
        registerListener(this.bgL);
        if (this.eIt != null) {
            this.eIt.aSx();
        }
        if (TbadkCoreApplication.getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.eJX);
        registerListener(this.eKe);
        registerListener(this.eKd);
        registerListener(this.eKw);
        registerListener(this.ckO);
        this.eJa = new com.baidu.tieba.pb.pb.main.b(this.eIt, this);
        if (this.eJj != null && this.eJj.aUn() != null && this.eJj.aUo() != null) {
            this.eIL = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eJj.aUn(), this.eJj.aUo());
            this.eIL.a(this.eJW);
        }
        if (this.eIK && this.eJj != null && this.eJj.aUo() != null) {
            this.eJj.aUo().setVisibility(8);
        }
        this.eJB = new com.baidu.tbadk.core.view.c();
        this.eJB.alo = 1000L;
        registerListener(this.eKa);
        registerListener(this.eJY);
        registerListener(this.eJZ);
        this.eJC = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eJC;
        userMuteAddAndDelCustomMessage.setTag(this.eJC);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eJC;
        userMuteCheckCustomMessage.setTag(this.eJC);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eIt.aSG().a(this.bpo);
        if ("from_tieba_kuang".equals(this.eJd)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12264").r("obj_type", 2).aa("tid", this.eIt.getThreadID()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    public String aQR() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aQS() {
        return this.eIL;
    }

    private void iY(boolean z) {
        this.eJx.bI(z);
        this.eJx.bJ(z);
        this.eJx.bK(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cjJ != null) {
            this.cjJ.onStart(getPageContext());
        }
    }

    public aq aQT() {
        return this.eJj;
    }

    public PbModel aQU() {
        return this.eIt;
    }

    public void pn(String str) {
        if (this.eIt != null && !StringUtils.isNull(str) && this.eJj != null) {
            this.eJj.aTP();
            this.eJj.jP(true);
            this.eIt.pn(str);
            this.eJb = true;
            this.eJj.aBR();
            this.eJj.aUj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eIN = false;
        } else {
            this.eIN = true;
        }
        super.onPause();
        if (this.eJj.aTv() != null && this.eJj.aTv().aQM() != null) {
            this.eJj.aTv().aQM().onPause();
        }
        BdListView listView = getListView();
        this.eIP = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eIP == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cjJ != null) {
            this.cjJ.onPause(getPageContext());
        }
        if (this.eJj != null) {
            this.eJj.onPause();
        }
        if (!this.eIt.aSj()) {
            this.eJx.fV(this.eIt.getThreadID());
        }
        if (this.eIt != null) {
            this.eIt.aSy();
        }
        MessageManager.getInstance().unRegisterListener(this.dko);
        aqq();
        MessageManager.getInstance().unRegisterListener(this.eJY);
        MessageManager.getInstance().unRegisterListener(this.eJZ);
        MessageManager.getInstance().unRegisterListener(this.eKa);
        MessageManager.getInstance().unRegisterListener(this.ckH);
        MessageManager.getInstance().unRegisterListener(this.cUD);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aQV() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eIt.getPbData(), this.eIt.aSf(), this.eIt.aSv());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eIN = false;
        super.onResume();
        if (this.eJf) {
            this.eJf = false;
            aRw();
        }
        if (this.eJj.aTv() != null && this.eJj.aTv().aQM() != null) {
            this.eJj.aTv().aQM().onResume();
        }
        if (aQV()) {
            this.eIV = System.currentTimeMillis();
        } else {
            this.eIV = -1L;
        }
        if (this.eJj != null && this.eJj.getView() != null) {
            if (!this.efV) {
                aRn();
            } else {
                hideLoadingView(this.eJj.getView());
            }
            this.eJj.onResume();
        }
        if (this.eIP == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eJj != null) {
            noNetworkView = this.eJj.aTw();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hr()) {
            noNetworkView.aL(false);
        }
        if (this.cjJ != null) {
            this.cjJ.onResume(getPageContext());
        }
        registerListener(this.dko);
        this.eJt = false;
        aRv();
        registerListener(this.eJY);
        registerListener(this.eJZ);
        registerListener(this.eKa);
        registerListener(this.ckH);
        registerListener(this.cUD);
        if (this.ckq) {
            Wb();
            this.ckq = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eJj.jG(z);
        if (this.eJo != null) {
            this.eJo.jp(z);
        }
        if (z && this.eJt) {
            this.eJj.aTU();
            this.eIt.jk(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eIV > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10804").aa("obj_duration", (System.currentTimeMillis() - this.eIV) + ""));
            this.eIV = 0L;
        }
        if (this.eJx != null && this.eJx.Da() != null && this.eJx.Da().getVisibility() != 0) {
            this.eJx.DJ();
        }
        if (aQT().aTz() != null) {
            aQT().aTz().onStop();
        }
        if (this.eJj.eQf != null && !this.eJj.eQf.XF()) {
            this.eJj.eQf.aCi();
        }
        if (this.eIt != null && this.eIt.getPbData() != null && this.eIt.getPbData().aPO() != null && this.eIt.getPbData().aPQ() != null) {
            com.baidu.tbadk.distribute.a.CK().a(getPageContext().getPageActivity(), "pb", this.eIt.getPbData().aPO().getId(), com.baidu.adp.lib.g.b.d(this.eIt.getPbData().aPQ().getId(), 0L));
        }
        if (this.cjJ != null) {
            this.cjJ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.eJa != null) {
            this.eJa.destroy();
        }
        if (this.eJp && this.eIt != null) {
            a(this.eIt.getPbData(), -2, 0, false, false);
        }
        if (!this.eIT && this.eJj != null) {
            this.eIT = true;
            this.eJj.aUi();
            a(false, (PostData) null);
        }
        if (this.eIt != null) {
            this.eIt.cancelLoadData();
            this.eIt.destory();
            if (this.eIt.aSF() != null) {
                this.eIt.aSF().onDestroy();
            }
        }
        if (this.eJx != null) {
            this.eJx.onDestroy();
        }
        if (this.eJi != null) {
            this.eJi.cancelLoadData();
        }
        if (this.eJj != null) {
            this.eJj.onDestroy();
            if (this.eJj.eQf != null) {
                this.eJj.eQf.aCi();
            }
        }
        if (this.eIU != null) {
            this.eIU.onDestroy();
        }
        if (this.eIL != null) {
            this.eIL.Ho();
        }
        super.onDestroy();
        if (this.cjJ != null) {
            this.cjJ.onDestory(getPageContext());
        }
        if (this.ckd != null) {
            this.ckd.destory();
        }
        this.eJj.aBR();
        MessageManager.getInstance().unRegisterListener(this.eJY);
        MessageManager.getInstance().unRegisterListener(this.eJZ);
        MessageManager.getInstance().unRegisterListener(this.eKa);
        MessageManager.getInstance().unRegisterListener(this.eJC);
        MessageManager.getInstance().unRegisterListener(this.eKb);
        MessageManager.getInstance().unRegisterListener(this.ckO);
        this.eJA = null;
        this.eJB = null;
        com.baidu.tieba.recapp.d.a.biO().biQ();
        if (this.eJD != null) {
            getSafeHandler().removeCallbacks(this.eJD);
        }
        if (this.eJg != null) {
            this.eJg.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g aTO;
        ArrayList<PostData> aRQ;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xW() && this.eJj != null && (aTO = this.eJj.aTO()) != null && (aRQ = aTO.aRQ()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aRQ.iterator();
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
                        bVar.bDN = id;
                        bVar.bJW = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ZU == 1 && !TextUtils.isEmpty(id)) {
                    next.ZU = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bDN = id;
                    bVar2.bJW = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eIt == null || this.eIt.getPbData() == null || this.eIt.getPbData().aPO() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eIt.getPbData().aPO().getFirst_class();
                    str2 = this.eIt.getPbData().aPO().getSecond_class();
                    str = this.eIt.getPbData().aPO().getId();
                    str4 = this.eIt.getThreadID();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eJj.onChangeSkinType(i);
        if (this.eJx != null && this.eJx.Da() != null) {
            this.eJx.Da().onChangeSkinType(i);
        }
        if (this.eJj.aTw() != null) {
            this.eJj.aTw().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eJj = new aq(this, this.cll, this.aRO);
        this.cmM = new com.baidu.tieba.e.b(getActivity());
        this.cmM.a(this.eKp);
        this.cmM.a(this.bWR);
        this.eJj.setOnScrollListener(this.mOnScrollListener);
        this.eJj.d(this.eKj);
        this.eJj.a(this.bax);
        this.eJj.iS(com.baidu.tbadk.core.h.oX().pd());
        this.eJj.setOnImageClickListener(this.aRN);
        this.eJj.a(this.awo);
        this.eJj.c(this.bFE);
        this.eJj.a(this.eKh);
        this.eJj.jG(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bb(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gjJ == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oX().pd()) {
                    return false;
                }
                return pr(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eJj != null) {
            if (z && (!this.efV || this.eJz)) {
                aRn();
            } else {
                hideLoadingView(this.eJj.getView());
            }
            this.eJz = false;
        }
    }

    private void aQW() {
        if (this.eIQ == null) {
            this.eIQ = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eIQ.a(new String[]{getPageContext().getString(d.l.call_phone), getPageContext().getString(d.l.sms_phone), getPageContext().getString(d.l.search_in_baidu)}, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eIr = PbActivity.this.eIr.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIr);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eIt.getThreadID(), PbActivity.this.eIr, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eIr = PbActivity.this.eIr.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIr);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eIt.getThreadID(), PbActivity.this.eIr, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eIr = PbActivity.this.eIr.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIr);
                        bVar.dismiss();
                    }
                }
            }).cg(b.a.ack).ch(17).d(getPageContext());
        }
    }

    private void t(Bundle bundle) {
        this.eIt = new PbModel(this);
        this.eIt.a(this.eKc);
        if (this.eIt.aSD() != null) {
            this.eIt.aSD().a(this.eKr);
        }
        if (this.eIt.aSC() != null) {
            this.eIt.aSC().a(this.eJO);
        }
        if (this.eIt.aSF() != null) {
            this.eIt.aSF().a(this.eJK);
        }
        if (bundle != null) {
            this.eIt.initWithBundle(bundle);
        } else {
            this.eIt.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eIt.jo(true);
        }
        ai.aTq().S(this.eIt.aSd(), this.eIt.getIsFromMark());
        if (StringUtils.isNull(this.eIt.getThreadID())) {
            finish();
        } else {
            this.eIt.Fw();
        }
    }

    private void initData(Bundle bundle) {
        this.ech = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.ech != null) {
            this.ech.a(this.eKf);
        }
        this.eJi = new ForumManageModel(this);
        this.eJi.setLoadDataCallBack(this.eKg);
        this.eJj.a(new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
            public void g(Object obj) {
                if (!com.baidu.adp.lib.util.i.hr()) {
                    PbActivity.this.showToast(d.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eIt.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIt.getPbData().aPO().getId(), PbActivity.this.eIt.getPbData().aPO().getName(), PbActivity.this.eIt.getPbData().aPQ().getId(), valueOf, str, str2)));
            }
        });
        this.eJT.setUniqueId(getUniqueId());
        this.eJT.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eJj.Rr();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(d.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eJC;
        userMuteCheckCustomMessage.setTag(this.eJC);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.cb(d.l.go_setting_float_window_permission);
        aVar.cc(d.l.step_to_setting_float_permission);
        aVar.a(d.l.go_and_setting, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                try {
                    PbActivity.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName())));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).tr();
    }

    public PostData bc(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.h.tag_clip_board)) != null && !com.baidu.tieba.pb.f.d(postData)) {
            if (postData.btt()) {
                postData.cT(postData.bts() - 1);
            } else {
                postData.cT(postData.bts() + 1);
            }
            postData.mB(!postData.btt());
            ((PbFloorAgreeView) view).a(postData.btt(), postData.bts(), true);
            final int i = postData.btt() ? 0 : 1;
            this.eIt.aSE().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void pd(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).pG(i2);
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

    public com.baidu.tbadk.core.util.aj aQX() {
        return new com.baidu.tbadk.core.util.aj("c12003").aa("tid", this.eIt.eMH).r("obj_type", 0).aa("fid", this.eIt.getForumId()).r("obj_param1", this.eIt.getPbData().aPQ().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQY() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eIt != null && this.eIt.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eIt.getPbData();
            if (pbData.aPO() != null) {
                sb.append("forum_name=").append(po(pbData.aPO().getName()));
                sb.append("&");
            }
            if (pbData.aPQ() != null) {
                bl aPQ = pbData.aPQ();
                sb.append("thread_id=").append(aPQ.getId());
                sb.append("&");
                sb.append("thread_title=").append(po(aPQ.getTitle()));
                if (aPQ.getAuthor() != null && aPQ.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aPQ.getAuthor().getPortrait());
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
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
                @Override // java.lang.Runnable
                public void run() {
                    int g;
                    int ah = (com.baidu.adp.lib.util.k.ah(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        g = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.g(PbActivity.this.getPageContext().getPageActivity(), d.f.ds120);
                    } else {
                        g = com.baidu.adp.lib.util.k.g(PbActivity.this.getPageContext().getPageActivity(), d.f.ds640);
                    }
                    int i = g - ah;
                    if (i > 0) {
                        PbActivity.this.aQT().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aQT().aTz() != null) {
                        PbActivity.this.aQT().aTz().bM(str, str2);
                    }
                    PbActivity.this.aQT().aUj();
                }
            }, 500L);
        }
    }

    private String po(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null && this.eIt != null && this.eIt.getPbData() != null && postData.btg() > 1) {
            String threadID = this.eIt.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.eIt.getPbData() != null) {
                i = this.eIt.getPbData().aQb();
            }
            b ps = ps(id);
            if (ps != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, postData.aWp(), this.eIt.getPbData().qr(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(ps.eKQ, ps.eKR, ps.eKS, ps.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        an anVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.k.hI()) {
                showToast(d.l.no_network_guide);
            } else if (aQU() != null && aQU().getPbData() != null && aQU().getPbData().aQn() != null && !com.baidu.tieba.pb.f.T(aQU().getPbData().aPQ())) {
                com.baidu.tieba.pb.data.m aQn = aQU().getPbData().aQn();
                if (view == null || !(view.getTag(d.h.pb_main_thread_praise_view) instanceof an)) {
                    anVar = null;
                } else {
                    anVar = (an) view.getTag(d.h.pb_main_thread_praise_view);
                }
                if (aQn != null) {
                    int i2 = -1;
                    if (z) {
                        aQn.oV(i);
                    } else if (aQn.aQt()) {
                        aQn.aQv();
                        i2 = 1;
                    } else {
                        aQn.oW(i);
                        i2 = 0;
                    }
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void pd(int i3) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void a(CustomDialogData customDialogData) {
                            com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), customDialogData);
                        }
                    };
                    if (this.eIt != null && this.eIt.aSE() != null) {
                        String str = "";
                        if (this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null) {
                            str = this.eIt.getPbData().aPQ().rV();
                        }
                        if (this.eIt.getPbData() != null) {
                            this.eIt.getPbData().a(aQn);
                        }
                        if (z) {
                            this.eIt.aSE().a(str, 3, i, this.eIt.getForumId(), aVar);
                        } else {
                            this.eIt.aSE().a(str, i2, 3, i, this.eIt.getForumId(), aVar);
                            com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                            lVar.eGu = i2;
                            lVar.eGv = aQn;
                            lVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, lVar));
                        }
                    }
                    if (anVar != null) {
                        anVar.b(aQn);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQZ() {
        if (this.eIt.getPbData() == null || this.eIt.getPbData().aPQ() == null) {
            return -1;
        }
        return this.eIt.getPbData().aPQ().sj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRa() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.pN(this.eIt.getForumId()) && this.eIt.getPbData() != null && this.eIt.getPbData().aPO() != null) {
            if (this.eIt.getPbData().aPO().isLike() == 1) {
                aRo();
                this.eIt.aSH().bO(this.eIt.getForumId(), this.eIt.getThreadID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iZ(boolean z) {
        if (this.eIt == null || this.eIt.getPbData() == null) {
            return false;
        }
        return ((this.eIt.getPbData().aQb() != 0) || this.eIt.getPbData().aPQ() == null || this.eIt.getPbData().aPQ().getAuthor() == null || TextUtils.equals(this.eIt.getPbData().aPQ().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean ja(boolean z) {
        if (z) {
            return true;
        }
        if (this.eIt == null || this.eIt.getPbData() == null) {
            return false;
        }
        return this.eIt.getPbData().aQb() != 0;
    }

    private boolean jb(boolean z) {
        return (z || this.eIt == null || this.eIt.getPbData() == null || this.eIt.getPbData().aQb() == 0) ? false : true;
    }

    public void aRb() {
        if (this.eIt != null && this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null && this.eIt.getPbData().aPQ().getAuthor() != null) {
            if (this.eJj != null) {
                this.eJj.aTx();
            }
            bl aPQ = this.eIt.getPbData().aPQ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aPQ.getAuthor().getUserId());
            GodUserData godUserData = aPQ.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            y yVar = new y();
            if (this.eIt.getPbData().aQb() == 1) {
                yVar.eOv = true;
                yVar.eOu = true;
                yVar.eOA = aPQ.rA() == 1;
                yVar.eOz = aPQ.rB() == 1;
            } else {
                yVar.eOv = false;
                yVar.eOu = false;
            }
            yVar.eOt = TbadkCoreApplication.getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            yVar.eOr = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            yVar.eOw = ja(equals);
            yVar.eOx = aRc();
            yVar.eOy = jb(equals);
            yVar.eOs = this.eIt.aSf();
            yVar.eGG = this.ech != null ? this.ech.nL() : false;
            yVar.eOq = iZ(equals);
            yVar.eOo = equals && this.eJj.aUa();
            yVar.eOp = z;
            yVar.isHostOnly = this.eIt.getHostMode();
            if (aPQ.rW() == null) {
                yVar.eOB = false;
            } else {
                yVar.eOB = true;
            }
            this.eJj.eQf.a(yVar);
        }
    }

    private boolean aRc() {
        if (this.eIt != null && this.eIt.aSf()) {
            return this.eIt.aqU() == null || this.eIt.aqU().qE() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(View view) {
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
    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, boolean z2) {
        if (fVar != null && this.eIt != null) {
            ad adVar = new ad(getUniqueId());
            adVar.pbData = fVar;
            adVar.threadId = this.eIt.getThreadID();
            adVar.postId = this.eIt.getPostId();
            adVar.ePb = i;
            adVar.ePc = i2;
            adVar.ePa = this.eIt.getHostMode();
            adVar.eGG = this.eIt.nL();
            adVar.isSquence = this.eIt.aSf();
            adVar.loadType = this.eIt.aSA();
            adVar.ePd = z;
            adVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, adVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aRd() {
        if (aQT() == null || aQT().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aQT().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof com.baidu.tieba.pb.data.k) && ((com.baidu.tieba.pb.data.k) fVar).mType == 0) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aRe() {
        if (aQT() == null || aQT().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aQT().getListView();
        List<com.baidu.adp.widget.ListView.f> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = data.get(i);
            if ((fVar instanceof PostData) && fVar.getType() == PostData.gjH) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.eIt != null) {
            ad adVar = new ad(getUniqueId());
            adVar.pbData = fVar;
            adVar.threadId = this.eIt.getThreadID();
            adVar.postId = this.eIt.getPostId();
            adVar.ePb = i;
            adVar.ePa = this.eIt.getHostMode();
            adVar.eGG = this.eIt.nL();
            adVar.isSquence = this.eIt.aSf();
            adVar.loadType = this.eIt.aSA();
            adVar.ePd = z;
            adVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, adVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        Wb();
    }

    public void a(boolean z, MarkData markData) {
        this.eJj.aTV();
        this.eIt.jn(z);
        if (this.ech != null) {
            this.ech.ac(z);
            if (markData != null) {
                this.ech.a(markData);
            }
        }
        if (this.eIt.nL()) {
            aRk();
        } else {
            this.eJj.m(this.eIt.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oZ(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pp(String str) {
        if (!StringUtils.isNull(str) && this.eIt != null) {
            String threadID = this.eIt.getThreadID();
            String id = this.eIt.getPbData().aPO().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eIt.aSj()) {
                    antiData.setBlock_forum_name(this.eIt.getPbData().aPO().getName());
                    antiData.setBlock_forum_id(this.eIt.getPbData().aPO().getId());
                    antiData.setUser_name(this.eIt.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eIt.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.tx(i)) {
            AntiHelper.ar(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            gc(str);
        } else {
            this.eJj.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eJj.a(0, bVar.Co, bVar.glY, z);
            if (bVar.Co) {
                if (bVar.glW == 1) {
                    ArrayList<PostData> aPS = this.eIt.getPbData().aPS();
                    int size = aPS.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aPS.get(i).getId())) {
                            i++;
                        } else {
                            aPS.remove(i);
                            break;
                        }
                    }
                    this.eJj.m(this.eIt.getPbData());
                } else if (bVar.glW == 0) {
                    aRf();
                } else if (bVar.glW == 2) {
                    ArrayList<PostData> aPS2 = this.eIt.getPbData().aPS();
                    int size2 = aPS2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aPS2.get(i2).btd().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aPS2.get(i2).btd().get(i3).getId())) {
                                i3++;
                            } else {
                                aPS2.get(i2).btd().remove(i3);
                                aPS2.get(i2).btf();
                                z2 = true;
                                break;
                            }
                        }
                        aPS2.get(i2).sd(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eJj.m(this.eIt.getPbData());
                    }
                    a(bVar, this.eJj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eJj.a(this.eJi.getLoadDataMode(), fVar.Co, fVar.glY, false);
            if (fVar.Co) {
                this.eJl = true;
                if (i == 2 || i == 3) {
                    this.eJm = true;
                    this.eJn = false;
                } else if (i == 4 || i == 5) {
                    this.eJm = false;
                    this.eJn = true;
                }
                if (i == 2) {
                    this.eIt.getPbData().aPQ().bU(1);
                    this.eIt.setIsGood(1);
                } else if (i == 3) {
                    this.eIt.getPbData().aPQ().bU(0);
                    this.eIt.setIsGood(0);
                } else if (i == 4) {
                    this.eIt.getPbData().aPQ().bT(1);
                    this.eIt.hG(1);
                } else if (i == 5) {
                    this.eIt.getPbData().aPQ().bT(0);
                    this.eIt.hG(0);
                }
                this.eJj.d(this.eIt.getPbData(), this.eIt.aSf());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aRf() {
        if (this.eIt.aSg() || this.eIt.aSh()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eIt.getThreadID());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eIt.getThreadID()));
        if (aRl()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRg() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aPY;
        if (this.eJj != null) {
            this.eJj.aBR();
        }
        if (this.eIt != null && this.eIt.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eIt.getPbData().aPQ().getId();
            historyMessage.forumName = this.eIt.getPbData().aPO().getName();
            historyMessage.threadName = this.eIt.getPbData().aPQ().getTitle();
            ArrayList<PostData> aPS = this.eIt.getPbData().aPS();
            int aTX = this.eJj != null ? this.eJj.aTX() : 0;
            if (aPS != null && aTX >= 0 && aTX < aPS.size()) {
                historyMessage.postID = aPS.get(aTX).getId();
            }
            historyMessage.isHostOnly = this.eIt.getHostMode();
            historyMessage.isSquence = this.eIt.aSf();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eJx != null) {
            this.eJx.onDestroy();
        }
        if (this.eIO && aQT() != null) {
            aQT().aUw();
        }
        if (this.eIt != null && (this.eIt.aSg() || this.eIt.aSh())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eIt.getThreadID());
            if (this.eJl) {
                if (this.eJn) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eIt.aBI());
                }
                if (this.eJm) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eIt.getIsGood());
                }
            }
            if (this.eIt.getPbData() != null && System.currentTimeMillis() - this.eIS >= 40000 && (aPY = this.eIt.getPbData().aPY()) != null && !com.baidu.tbadk.core.util.u.v(aPY.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aPY);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eJJ);
            }
            setResult(-1, intent);
        }
        if (aRl()) {
            if (this.eIt != null && this.eJj != null && this.eJj.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eIt.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aPW() && !this.eJb) {
                        ai.aTq().a(this.eIt.getPbData(), this.eJj.getListView().onSaveInstanceState(), this.eIt.aSf(), this.eIt.getHostMode());
                    }
                }
            } else {
                ai.aTq().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eJj == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eJj.pu(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pa(int i) {
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
        this.eJx.onActivityResult(i, i2, intent);
        if (this.eJg != null) {
            this.eJg.onActivityResult(i, i2, intent);
        }
        if (aQT().aTz() != null) {
            aQT().aTz().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aRj();
                    return;
                case 13008:
                    ai.aTq().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eIt != null) {
                                PbActivity.this.eIt.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eIt != null) {
                        a(aRi(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    X(intent);
                    return;
                case 24006:
                    W(intent);
                    return;
                case 24007:
                    if (aQZ() == 1) {
                        aRh();
                    }
                    String stringExtra = intent.getStringExtra("share_to");
                    if (!AddExperiencedModel.WEIXIN_FRIEND.equals(stringExtra) && !AddExperiencedModel.WEIXIN_TIMELINE.equals(stringExtra)) {
                        aRa();
                        return;
                    }
                    return;
                case 24008:
                    this.eJj.iX(false);
                    if (this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null && this.eIt.getPbData().aPQ().rZ() != null) {
                        this.eIt.getPbData().aPQ().rZ().setStatus(2);
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
                default:
                    return;
            }
            if (this.eJa != null) {
                this.eJa.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aQT() != null && aQP() != null && aQT().aTB() && com.baidu.tbadk.editortools.pb.a.Dw().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Dw().setStatus(0);
                    if (this.eJj != null) {
                        this.eJj.aTA();
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
            if (this.eJg == null) {
                this.eJg = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eJg.b(this.aEf);
                this.eJg.c(this.aEm);
            }
            this.eJg.a(emotionImageData, aQU(), aQU().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRh() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null && this.eIt.getPbData().aPQ().rQ() != null && this.eIt.getPbData().aPQ().rQ().size() > 0 && this.eIt.getPbData().aPQ().rQ().get(0) != null) {
            this.mAwardActId = this.eIt.getPbData().aPQ().rQ().get(0).ps();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.d(this.eIt.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void W(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    pc(2);
                    return;
                case 2:
                    this.eJj.aTM();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aRi() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bD = this.eIt.getPbData().bD(getPageContext().getPageActivity());
        PostData aTC = this.eJj.aTC();
        String str = "";
        if (aTC != null) {
            str = aTC.getId();
            String bO = aTC.bO(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bO)) {
                bD[1] = bO;
            }
        }
        String rV = this.eIt.getPbData().aPQ().rV();
        if (rV != null && rV.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bD[1]);
        shareFromPBMsgData.setImageUrl(bD[0]);
        shareFromPBMsgData.setForumName(this.eIt.getPbData().aPO().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eIt.getPbData().aPQ().getId());
        shareFromPBMsgData.setTitle(this.eIt.getPbData().aPQ().getTitle());
        return shareFromPBMsgData;
    }

    private void X(Intent intent) {
        b(aRi(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void b(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eIt != null && this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final au auVar = new au(getPageContext().getPageActivity());
            auVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(auVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), auVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, auVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aQZ() == 1) {
                        PbActivity.this.aRh();
                    }
                }
            });
            aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), auVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(getPageContext()).tr();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                auVar.K(shareFromPBMsgData.getImageUrl(), this.eIt.getPbData().aQc() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eIt != null && this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final au auVar = new au(getPageContext().getPageActivity());
            auVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(auVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), auVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", auVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aQZ() == 1) {
                        PbActivity.this.aRh();
                    }
                }
            });
            aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), auVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(getPageContext()).tr();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                auVar.K(shareFromPBMsgData.getImageUrl(), this.eIt.getPbData().aQc() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRj() {
        MarkData pp;
        if (this.ech != null && (pp = this.eIt.pp(this.eJj.aTY())) != null) {
            if (!pp.isApp() || (pp = this.eIt.pp(this.eJj.aTY() + 1)) != null) {
                this.eJj.aTT();
                this.ech.a(pp);
                if (!this.ech.nL()) {
                    this.ech.nN();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.ech.nM();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRk() {
        com.baidu.tieba.pb.data.f pbData = this.eIt.getPbData();
        this.eIt.jn(true);
        pbData.pk(this.ech.nK());
        this.eJj.m(pbData);
    }

    private boolean aRl() {
        if (this.eIt == null) {
            return true;
        }
        if (this.eIt.nL()) {
            final MarkData aSr = this.eIt.aSr();
            if (aSr == null || !this.eIt.getIsFromMark()) {
                return true;
            }
            final MarkData pp = this.eIt.pp(this.eJj.aTY());
            if (pp == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aSr);
                setResult(-1, intent);
                return true;
            } else if (pp.getPostId() == null || pp.getPostId().equals(aSr.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aSr);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cT(getPageContext().getString(d.l.alert_update_mark));
                aVar.a(d.l.alert_yes_btn, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.ech != null) {
                            if (PbActivity.this.ech.nL()) {
                                PbActivity.this.ech.nM();
                                PbActivity.this.ech.ac(false);
                            }
                            PbActivity.this.ech.a(pp);
                            PbActivity.this.ech.ac(true);
                            PbActivity.this.ech.nN();
                        }
                        aSr.setPostId(pp.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aSr);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aRg();
                    }
                });
                aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aSr);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aRg();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eJj != null && PbActivity.this.eJj.getView() != null) {
                            PbActivity.this.eJj.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aSr);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aRg();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.tr();
                return false;
            }
        } else if (this.eIt.getPbData() == null || this.eIt.getPbData().aPS() == null || this.eIt.getPbData().aPS().size() <= 0 || !this.eIt.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eJj == null) {
            return null;
        }
        return this.eJj.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        if (this.eJj == null) {
            return 0;
        }
        return this.eJj.aUd();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        if (this.aRu == null) {
            this.aRu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: TO */
                public ImageView fT() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean pd = com.baidu.tbadk.core.h.oX().pd();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ai.getDrawable(d.e.common_color_10220));
                    if (pd) {
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
                /* renamed from: g */
                public void o(ImageView imageView) {
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
                /* renamed from: f */
                public ImageView p(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.h.oX().pd()) {
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
                /* renamed from: h */
                public ImageView q(ImageView imageView) {
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
        return this.aRu;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        if (this.aRv == null) {
            this.aRv = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aRv;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        if (this.aRz == null) {
            this.aRz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRG */
                public GifView fT() {
                    return new GifView(PbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void o(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView p(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView q(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.aRz;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        if (this.aRx == null) {
            this.aRx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: amH */
                public View fT() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.f.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: at */
                public void o(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: au */
                public View p(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: av */
                public View q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aRx;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aRw == null) {
            this.aRw = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 6);
        }
        return this.aRw;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xn() {
        if (this.apB == null) {
            this.apB = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.apB;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eIX = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (av.pC(str) && this.eIt != null && this.eIt.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11664").r("obj_param1", 1).aa("post_id", this.eIt.getThreadID()));
        }
        av.aUA().f(getPageContext(), str);
        this.eIX = true;
    }

    private com.baidu.tbadk.core.dialog.a aRm() {
        if (this.eIR == null) {
            this.eIR = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eIR.cS(getPageContext().getString(d.l.download_baidu_video_dialog));
            this.eIR.a(getPageContext().getString(d.l.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.dR()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.uI());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.l.download_baidu_video));
                    }
                }
            });
            this.eIR.b(getPageContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eIR.ar(true);
            this.eIR.b(getPageContext());
            this.eIR.as(false);
        }
        this.eIR.tr();
        return this.eIR;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
        av.aUA().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eIX = true;
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
            aRm();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eIX = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eIt.getPbData();
            TbRichText ao = ao(str, i);
            if (ao != null && (tbRichTextData = ao.Io().get(this.eKk)) != null) {
                if (tbRichTextData.getType() == 20 || tbRichTextData.getType() == 17) {
                    bVar.eKU = true;
                    return;
                }
                bVar.eKQ = new ArrayList<>();
                bVar.eKR = new ConcurrentHashMap<>();
                if (!tbRichTextData.It().IG()) {
                    bVar.eKT = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.eKQ.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = ao.getPostId();
                    imageUrlData.mIsReserver = this.eIt.aSq();
                    imageUrlData.mIsSeeHost = this.eIt.getHostMode();
                    bVar.eKR.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aPO() != null) {
                            bVar.forumName = pbData.aPO().getName();
                            bVar.forumId = pbData.aPO().getId();
                        }
                        if (pbData.aPQ() != null) {
                            bVar.threadId = pbData.aPQ().getId();
                        }
                        bVar.eKS = pbData.aQc() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bVar.threadId, -1L);
                    return;
                }
                bVar.eKT = true;
                int size = pbData.aPS().size();
                this.eKl = false;
                bVar.index = -1;
                if (pbData.aPX() != null) {
                    PostData aPX = pbData.aPX();
                    TbRichText aBw = aPX.aBw();
                    if (!ap.k(aPX)) {
                        i2 = a(aBw, ao, i, i, bVar.eKQ, bVar.eKR);
                    } else {
                        i2 = a(aPX, i, bVar.eKQ, bVar.eKR);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aPS().get(i4);
                    if (postData.getId() == null || pbData.aPX() == null || pbData.aPX().getId() == null || !postData.getId().equals(pbData.aPX().getId())) {
                        TbRichText aBw2 = postData.aBw();
                        if (!ap.k(postData)) {
                            i3 = a(aBw2, ao, i3, i, bVar.eKQ, bVar.eKR);
                        } else {
                            i3 = a(postData, i3, bVar.eKQ, bVar.eKR);
                        }
                    }
                }
                if (bVar.eKQ.size() > 0) {
                    bVar.lastId = bVar.eKQ.get(bVar.eKQ.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aPO() != null) {
                        bVar.forumName = pbData.aPO().getName();
                        bVar.forumId = pbData.aPO().getId();
                    }
                    if (pbData.aPQ() != null) {
                        bVar.threadId = pbData.aPQ().getId();
                    }
                    bVar.eKS = pbData.aQc() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.It() == null) {
            return null;
        }
        return tbRichTextData.It().IK();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.It() == null) {
            return 0L;
        }
        return tbRichTextData.It().getOriginalSize();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo It;
        if (tbRichText == tbRichText2) {
            this.eKl = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Io().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Io().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ai = (int) com.baidu.adp.lib.util.k.ai(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.It().getWidth() * ai;
                    int height = ai * tbRichTextData.It().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.It().IG()) {
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
                            if (tbRichTextData != null && (It = tbRichTextData.It()) != null) {
                                String II = It.II();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = II;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.eIt.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eIt.aSq();
                                imageUrlData.mIsSeeHost = this.eIt.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eKl) {
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
        com.baidu.tieba.tbadkCore.data.h bto;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bsL;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bsL = (bto = postData.bto()).bsL()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bsL.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bsL.get(i3);
                if (jVar != null) {
                    String bsQ = jVar.bsQ();
                    if (!com.baidu.tbadk.core.util.al.isEmpty(bsQ)) {
                        arrayList.add(bsQ);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bsQ;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bsP();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.eIt.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eIt.aSq();
                        imageUrlData.mIsSeeHost = this.eIt.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bto.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bsQ, imageUrlData);
                        }
                        if (!this.eKl) {
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
            if (postData.getId() != null && postData.getId().equals(this.eIt.rO())) {
                z = true;
            }
            MarkData j = this.eIt.j(postData);
            if (j != null) {
                this.eJj.aTT();
                if (this.ech != null) {
                    this.ech.a(j);
                    if (!z) {
                        this.ech.nN();
                    } else {
                        this.ech.nM();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ao(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eIt == null || this.eIt.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eIt.getPbData();
        if (pbData.aPX() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aPX());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            return a(pbData.aPS(), str, i);
        }
        return tbRichText;
    }

    private long pq(String str) {
        ArrayList<PostData> aPS;
        com.baidu.tieba.pb.data.f pbData = this.eIt.getPbData();
        if (pbData != null && (aPS = pbData.aPS()) != null && !aPS.isEmpty()) {
            Iterator<PostData> it = aPS.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bto = next.bto();
                if (bto != null && bto.gjo) {
                    Iterator<TbRichTextData> it2 = next.aBw().Io().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IC().getLink().equals(str)) {
                            return bto.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Io;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText aBw = arrayList.get(i2).aBw();
            if (aBw != null && (Io = aBw.Io()) != null) {
                int size = Io.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Io.get(i4) != null && Io.get(i4).getType() == 8) {
                        i3++;
                        if (Io.get(i4).It().II().equals(str)) {
                            int ai = (int) com.baidu.adp.lib.util.k.ai(TbadkCoreApplication.getInst());
                            int width = Io.get(i4).It().getWidth() * ai;
                            int height = Io.get(i4).It().getHeight() * ai;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eKk = i4;
                            return aBw;
                        } else if (i3 <= i) {
                            i4++;
                            i3 = i3;
                        }
                    } else {
                        if (Io.get(i4) != null && Io.get(i4).Iz() != null && (Io.get(i4).getType() == 20 || Io.get(i4).getType() == 17)) {
                            i3++;
                            MemeInfo memeInfo = Io.get(i4).Iz().memeInfo;
                            if (memeInfo == null || TextUtils.isEmpty(memeInfo.pic_url)) {
                                return null;
                            }
                            if (memeInfo.pic_url.equals(str)) {
                                if (memeInfo.width.intValue() >= 80 && memeInfo.height.intValue() >= 80) {
                                    if (memeInfo.height.intValue() * memeInfo.width.intValue() >= 10000) {
                                        this.eKk = i4;
                                        return aBw;
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
            this.eIr = str;
            if (this.eIQ == null) {
                aQW();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eIQ.cj(1).setVisibility(8);
            } else {
                this.eIQ.cj(1).setVisibility(0);
            }
            this.eIQ.tu();
            this.eIX = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cjJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wb() {
        hideNetRefreshView(this.eJj.getView());
        aRn();
        if (this.eIt.Fw()) {
            this.eJj.aTT();
        }
    }

    private void aRn() {
        showLoadingView(this.eJj.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds400));
        View EQ = getLoadingView().EQ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EQ.getLayoutParams();
        layoutParams.addRule(3, this.eJj.aUn().getId());
        EQ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afK() {
        if (this.cjJ != null) {
            this.cjJ.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc(int i) {
        if (this.eIt.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eIt.getPbData();
            String name = pbData.aPO().getName();
            String title = pbData.aPQ().getTitle();
            int i2 = this.eIt.getHostMode() ? 1 : 0;
            boolean z = false;
            if (pbData != null && pbData.aPO() != null) {
                if ((pbData.aPO().isLike() == 1) && AddExperiencedModel.pN(pbData.getForumId())) {
                    z = true;
                }
            }
            String str = "http://tieba.baidu.com/p/" + this.eIt.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bD = pbData.bD(getPageContext().getPageActivity());
            String str2 = bD[0];
            if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str2 = str2.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bD[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aQZ() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10399").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            } else if (aQZ() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10406").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, name, str3);
            final com.baidu.tbadk.coreExtra.share.e eVar = new com.baidu.tbadk.coreExtra.share.e();
            eVar.title = title;
            eVar.content = format;
            eVar.linkUrl = str;
            eVar.avd = true;
            eVar.avg = z;
            eVar.extData = this.eIt.getThreadID();
            eVar.avn = 3;
            eVar.avm = i;
            eVar.fid = this.eIt.getForumId();
            if (parse != null) {
                eVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), eVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 23007)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10125").aa("tid", PbActivity.this.eIt.getThreadID()).r("obj_type", 1));
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aB(eVar.linkUrl);
                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private void aRo() {
        com.baidu.tbadk.util.u.a(new com.baidu.tbadk.util.t<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pO(PbActivity.this.eIt.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eJj.aUz();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        if (this.aRy == null) {
            this.aRy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRH */
                public LinearLayout fT() {
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
                /* renamed from: b */
                public void o(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout p(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout q(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.aRy;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eJj.aTN() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", this.eIt.getPbData().getForumId()));
            } else {
                bl aPQ = this.eIt.getPbData().aPQ();
                if (view != null) {
                    boolean z = aPQ.rv() == null || aPQ.rv().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eJU > 1000) {
                            this.eJV = true;
                            be(view);
                        } else {
                            this.eJV = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            k(view, this.eJV);
                        } else {
                            j(view, this.eJV);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        j(view, this.eJV);
                    } else if (motionEvent.getAction() == 3) {
                        j(view, this.eJV);
                    }
                }
            }
        }
        return false;
    }

    private void j(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eJU = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.eJU = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void be(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    public void afL() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.l.login_to_use), true, 11017)));
        } else if (aVar.tt() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tt();
            int intValue = ((Integer) sparseArray.get(aq.eRX)).intValue();
            if (intValue == aq.eRY) {
                if (!this.eJi.btS()) {
                    this.eJj.aTQ();
                    int intValue2 = ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue();
                    this.eJi.a(this.eIt.getPbData().aPO().getId(), this.eIt.getPbData().aPO().getName(), this.eIt.getPbData().aPQ().getId(), (String) sparseArray.get(d.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == aq.eRZ || intValue == aq.eSb) {
                if (this.eIt.aSD() != null) {
                    this.eIt.aSD().pg(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.eRZ) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == aq.eSa) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eKq).pn()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eJC);
        userMuteAddAndDelCustomMessage.setTag(this.eJC);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pr(String str) {
        if (!StringUtils.isNull(str) && aw.aO(getPageContext().getPageActivity())) {
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
        this.eJt = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aRp() {
        ArrayList<PostData> aPS;
        int u;
        if (this.eIt == null || this.eIt.getPbData() == null || this.eIt.getPbData().aPS() == null || (u = com.baidu.tbadk.core.util.u.u((aPS = this.eIt.getPbData().aPS()))) == 0) {
            return "";
        }
        if (this.eIt.aSq()) {
            Iterator<PostData> it = aPS.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.btg() == 1) {
                    return next.getId();
                }
            }
        }
        int aTX = this.eJj.aTX();
        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(aPS, aTX);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eIt.pv(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aTX - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.u.c(aPS, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eIt.pv(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aTX + 1; i2 < u; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.u.c(aPS, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eIt.pv(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.at.wf().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(pq(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eIt.getPbData().aPO().getId(), this.eIt.getPbData().aPO().getName(), this.eIt.getPbData().aPQ().getTid());
            }
            this.eIX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cT(getResources().getString(d.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cT(getResources().getString(d.l.make_sure_hide));
        }
        aVar.a(getResources().getString(d.l.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eIt.aSC() != null) {
                    PbActivity.this.eIt.aSC().cu(j);
                }
            }
        });
        aVar.b(getResources().getString(d.l.alert_no_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.as(false);
        aVar.b(getPageContext());
        aVar.tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b ps(String str) {
        String str2;
        if (this.eIt.getPbData() == null || this.eIt.getPbData().aPS() == null || this.eIt.getPbData().aPS().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i >= this.eIt.getPbData().aPS().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eIt.getPbData().aPS().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eIt.getPbData().aPS().get(i);
        if (postData.aBw() == null || postData.aBw().Io() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aBw().Io().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.It() != null) {
                    str2 = next.It().II();
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
        if (this.eIM) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eIM = false;
        } else if (aRq()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eIM) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eIM = false;
        } else if (aRq()) {
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
        if (pageStayDurationItem != null && this.eIt != null) {
            if (this.eIt.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.eIt.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.eIt.getThreadID(), 0L));
            if (this.eIY) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aRq() {
        return (!this.eIK && this.eKs == -1 && this.eKt == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eKv = nVar;
            this.eIK = true;
            this.eJj.aTE();
            this.eJj.pA(this.eKu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRr() {
        if (this.eKv != null) {
            if (this.eKs == -1) {
                showToast(d.l.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aN(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eKv.getCartoonId(), this.eKs, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRs() {
        if (this.eKv != null) {
            if (this.eKt == -1) {
                showToast(d.l.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aN(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eKv.getCartoonId(), this.eKt, 0)));
                finish();
            }
        }
    }

    public int aRt() {
        return this.eKs;
    }

    public int aRu() {
        return this.eKt;
    }

    private void aqq() {
        if (this.eIt != null && this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null && this.eIt.getPbData().aPQ().ss()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aRv() {
        if (this.eIt != null && this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null && this.eIt.getPbData().aPQ().ss()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aRw() {
        if (this.eIN) {
            this.eJf = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null && this.eIt.getPbData().aPQ().rn() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eIt.getPbData().aPQ().rn().getThreadId(), this.eIt.getPbData().aPQ().rn().getTaskId(), this.eIt.getPbData().aPQ().rn().getForumId(), this.eIt.getPbData().aPQ().rn().getForumName(), this.eIt.getPbData().aPQ().rA(), this.eIt.getPbData().aPQ().rB())));
            this.eIM = true;
            finish();
        }
    }

    public boolean aRx() {
        return this.eIN;
    }

    public String aRy() {
        return this.eJd;
    }

    public PbInterviewStatusView.a aRz() {
        return this.eJh;
    }

    public void jd(boolean z) {
        this.eJe = z;
    }

    public boolean aRA() {
        if (this.eIt != null) {
            return this.eIt.aSg();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cT(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eJA).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eJA.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eJA).tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eJA != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eJA.getPageActivity());
            aVar.cT(str);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eJA).tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eJj.Rr();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eJA.getPageActivity());
        if (com.baidu.tbadk.core.util.al.isEmpty(str)) {
            aVar.cT(this.eJA.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cT(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eJj.Rr();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eJA).tr();
    }

    public void aRC() {
        if (this.eIt != null && this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null && this.eIt.getPbData().aPQ().sJ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cc(d.l.channel_open_push_message);
            aVar.a(d.l.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eIt.getPbData().aPQ().sJ().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.l.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.tr();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.pC(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_pb_wenxue)) != null) {
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
            this.eJc = true;
        } else {
            this.eJc = false;
        }
        if (this.eJj != null) {
            this.eJj.onConfigurationChanged(configuration);
        }
        if (this.eJo != null) {
            this.eJo.dismiss();
        }
    }

    public boolean aRD() {
        if (this.eIt != null) {
            return this.eIt.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.eIt.getPbData().aQa().eGI;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).btd().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).btd().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).btd().remove(i2);
                    list.get(i).btf();
                    z = true;
                    break;
                }
            }
            list.get(i).sd(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.eIt.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.n nVar) {
        String id = nVar.aQy().getId();
        List<PostData> list = this.eIt.getPbData().aQa().eGI;
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
                ArrayList<PostData> aQC = nVar.aQC();
                postData.tr(nVar.getTotalCount());
                if (postData.btd() != null) {
                    postData.btd().clear();
                    postData.btd().addAll(aQC);
                }
            }
        }
        this.eJj.m(this.eIt.getPbData());
    }

    public boolean aRE() {
        boolean z = true;
        if (this.eIt == null) {
            return false;
        }
        switch (this.eIt.aSL()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eIt.getPbData() != null && this.eIt.getPbData().aPQ() != null && this.eIt.getPbData().aPQ().sR() && StringUtils.isNull(this.eIt.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aRF() {
        if (this.eJj != null) {
            this.eJj.aTx();
            afL();
        }
    }

    public PostData aPX() {
        return this.eJj.c(this.eIt.eMX, this.eIt.aSf());
    }
}
