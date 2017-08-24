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
    private com.baidu.adp.lib.e.b<GifView> aRA;
    private com.baidu.adp.lib.e.b<ImageView> aRv;
    private com.baidu.adp.lib.e.b<TextView> aRw;
    private com.baidu.adp.lib.e.b<View> aRx;
    private com.baidu.adp.lib.e.b<View> aRy;
    private com.baidu.adp.lib.e.b<LinearLayout> aRz;
    private com.baidu.adp.lib.e.b<TbImageView> apB;
    private VoiceManager cjK;
    private com.baidu.tbadk.i.a cke;
    private com.baidu.tieba.e.b cmN;
    private com.baidu.tieba.pb.pb.main.a.b eIN;
    private com.baidu.tbadk.core.dialog.a eIT;
    private String eIt;
    private com.baidu.adp.base.e eJC;
    private com.baidu.tbadk.core.view.c eJD;
    private BdUniqueId eJE;
    private Runnable eJF;
    private at eJH;
    private com.baidu.adp.widget.a.a eJI;
    private String eJJ;
    private TbRichTextMemeInfo eJK;
    private boolean eJa;
    private com.baidu.tieba.pb.pb.main.b eJc;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eJi;
    private v eJq;
    private boolean eJv;
    private com.baidu.tieba.tbadkCore.data.e eJy;
    private com.baidu.tbadk.editortools.pb.c eJz;
    private boolean eKk;
    private String eKw;
    private com.baidu.tbadk.core.data.n eKx;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eIM = false;
    private boolean eIO = false;
    private boolean eIP = false;
    private boolean efV = false;
    private boolean eIQ = true;
    private int eIR = 0;
    private com.baidu.tbadk.core.dialog.b eIS = null;
    private long bZo = -1;
    private long aKk = 0;
    private long eIU = 0;
    private long createTime = 0;
    private long aKc = 0;
    private boolean eIV = false;
    private com.baidu.tbadk.l.d eIW = null;
    private long eIX = 0;
    private boolean eIY = false;
    private boolean eIZ = false;
    private long eJb = 0;
    private String aEb = null;
    private boolean eJd = false;
    private boolean eJe = false;
    private String eJf = "";
    private boolean eJg = true;
    private boolean eJh = false;
    private String source = "";
    private PbInterviewStatusView.a eJj = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eJl.jH(!PbActivity.this.eJg);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eIv != null && PbActivity.this.eIv.nM()) {
                        PbActivity.this.aRf();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel eIv = null;
    private com.baidu.tbadk.baseEditMark.a ech = null;
    private ForumManageModel eJk = null;
    private aq eJl = null;
    public final com.baidu.tieba.pb.pb.main.a.a eJm = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eJn = false;
    private boolean eJo = false;
    private boolean eJp = false;
    private boolean eJr = false;
    private boolean eJs = false;
    private boolean eJt = false;
    private boolean eJu = false;
    private boolean eJw = false;
    private boolean eJx = false;
    private boolean eJA = false;
    private com.baidu.tbadk.editortools.pb.b aEg = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Dx() {
            PbActivity.this.showProgressBar();
        }
    };
    private boolean eJB = false;
    private int mLastScrollState = -1;
    private int eJG = 4;
    private boolean ckr = false;
    private int eJL = -1;
    private final w.a eJM = new w.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void B(List<PostData> list) {
            if (PbActivity.this.eIv.getPbData().aPV() != null) {
                List<PostData> list2 = PbActivity.this.eIv.getPbData().aPV().eGK;
                int size = list2.size();
                if (!com.baidu.tbadk.core.util.u.v(list2)) {
                    PbActivity.this.eIv.getPbData().aPV().eGK.addAll(size, list);
                }
                PbActivity.this.eIv.a(PbActivity.this.eIv.getPbData(), size);
            }
            PbActivity.this.eJl.aTJ().a(PbActivity.this.eIv.getPbData(), true);
            if (PbActivity.this.eJl != null && PbActivity.this.eJl.aTJ() != null) {
                PbActivity.this.eJl.aTJ().notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eJl.showToast(str);
            }
        }
    };
    private final CustomMessageListener eJN = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eIv != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eJz != null) {
                    PbActivity.this.eJl.hk(PbActivity.this.eJz.DG());
                }
                PbActivity.this.eJl.aTv();
                PbActivity.this.eJz.DJ();
                PbActivity.this.eJl.aBM();
            }
        }
    };
    CustomMessageListener ckE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.eIv.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.eJl != null && PbActivity.this.eIv != null) {
                    PbActivity.this.eJl.d(PbActivity.this.eIv.getPbData(), PbActivity.this.eIv.aSa(), PbActivity.this.eIv.aSq());
                }
                if (PbActivity.this.eJl != null && PbActivity.this.eJl.aTJ() != null) {
                    PbActivity.this.eJl.aTJ().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eJO = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eJl != null) {
                    if (booleanValue) {
                        PbActivity.this.eJl.awq();
                    } else {
                        PbActivity.this.eJl.awp();
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
                if (PbActivity.this.eJz != null) {
                    PbActivity.this.eJl.hk(PbActivity.this.eJz.DG());
                }
                PbActivity.this.eJl.hl(false);
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
    private CustomMessageListener eJP = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eJl != null && PbActivity.this.eJl.aTJ() != null) {
                PbActivity.this.eJl.aTJ().notifyDataSetChanged();
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
    private i.a eJQ = new i.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        @Override // com.baidu.tieba.pb.pb.main.i.a
        public void i(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.pb(2);
                ai.aTl().reset();
                PbActivity.this.eIv.aSr();
                boolean z2 = false;
                ArrayList<PostData> aPN = PbActivity.this.eIv.getPbData().aPN();
                if (aPN != null) {
                    Iterator<PostData> it = aPN.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.k(next) && next.bth().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eJl.m(PbActivity.this.eIv.getPbData());
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
            PbActivity.this.showToast(PbActivity.this.aEb);
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
    private CustomMessageListener eJR = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                as.a aVar = new as.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.Xb = abVar.Xb;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIv.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eIv.aSh() != null && PbActivity.this.eIv.aSh().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eJl.a(abVar.sendCount, PbActivity.this.eIv.getPbData(), PbActivity.this.eIv.aSa(), PbActivity.this.eIv.aSq());
                    }
                    if (pbData.aPN() != null && pbData.aPN().size() >= 1 && pbData.aPN().get(0) != null) {
                        long d = com.baidu.adp.lib.g.b.d(pbData.aPN().get(0).getId(), 0L);
                        long d2 = com.baidu.adp.lib.g.b.d(PbActivity.this.eIv.getThreadID(), 0L);
                        if (d == abVar.postId && d2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.as btg = pbData.aPN().get(0).btg();
                            if (btg == null) {
                                btg = new com.baidu.tbadk.core.data.as();
                            }
                            ArrayList<as.a> qH = btg.qH();
                            if (qH == null) {
                                qH = new ArrayList<>();
                            }
                            qH.add(0, aVar);
                            btg.bN(abVar.sendCount + btg.qG());
                            btg.g(qH);
                            pbData.aPN().get(0).a(btg);
                            PbActivity.this.eJl.aTJ().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eJS = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null && aVar.acO() != null && !aVar.acO().isEmpty()) {
                PbActivity.this.eJl.a(aVar, PbActivity.this.eJT);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eJT = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
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
    private boolean eJU = false;
    private PraiseModel eJV = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hS(String str) {
            PbActivity.this.eJU = false;
            if (PbActivity.this.eJV != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIv.getPbData();
                if (pbData.aPL().rw().getIsLike() == 1) {
                    PbActivity.this.ja(0);
                } else {
                    PbActivity.this.ja(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aPL()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void A(int i, String str) {
            PbActivity.this.eJU = false;
            if (PbActivity.this.eJV != null && str != null) {
                if (AntiHelper.tx(i)) {
                    AntiHelper.ar(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eJW = 0;
    private boolean eJX = true;
    private b.a eJY = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void eq(boolean z) {
            PbActivity.this.jd(z);
            if (PbActivity.this.eJl.aUh() != null && z) {
                PbActivity.this.eJl.jH(false);
            }
        }
    };
    private CustomMessageListener bgM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().Ec) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aPS().getAuthor() != null && PbActivity.this.aPS().getAuthor().getGodUserData() != null) {
                            PbActivity.this.aPS().getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        PbActivity.this.c(updateAttentionMessage);
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        PbActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bpq = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eJl.Rq();
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
                    com.baidu.tieba.h.a.amw();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.l.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private CustomMessageListener eJZ = new CustomMessageListener(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()).getId() != PbActivity.this.getUniqueId().getId()) {
                PbActivity.this.eJr = false;
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRP = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eJl.aTw()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && ((PbActivity.this.eIv == null || PbActivity.this.eIv.getPbData() == null || !com.baidu.tieba.pb.f.T(PbActivity.this.eIv.getPbData().aPL())) && PbActivity.this.eIv != null && (PbActivity.this.eIv.getPbData() != null || PbActivity.this.eIv.getPbData().aQi() != null))) {
                    if (PbActivity.this.eIv.getPbData().aQi().aQo()) {
                        if (PbActivity.this.eIv.getPbData().aQi().eGw == 1 || PbActivity.this.eIv.getPbData().aQi().eGw == 3 || PbActivity.this.eIv.getPbData().aQi().eGw == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eIv.getPbData().aQi().aQo() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eIv.getPbData().aQi().aQo() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eJb > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).startAnimation(false);
                        PbActivity.this.eJb = System.currentTimeMillis();
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
                    if (PbActivity.this.ba(view)) {
                        return true;
                    }
                } else if (view.getId() == d.h.pb_floor_item_layout) {
                    if (view.getTag(d.h.tag_from) instanceof SparseArray) {
                        PbActivity.this.e((SparseArray) view.getTag(d.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.h.pb_post_header_layout) {
                    if (PbActivity.this.eJl != null && PbActivity.this.eJl.aQQ() && (view.getId() == d.h.pb_head_user_info_root || view == PbActivity.this.eJl.aUp())) {
                        if (view.getTag(d.h.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10630").aa("obj_id", (String) view.getTag(d.h.tag_user_id)));
                        }
                        if (PbActivity.this.eJm != null && PbActivity.this.eJm.eVG != null) {
                            PbActivity.this.eJm.eVG.onClick(view);
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
            if (PbActivity.this.eJz != null) {
                PbActivity.this.eJl.hk(PbActivity.this.eJz.DG());
            }
            PbActivity.this.eJl.aTv();
            PbActivity.this.eJz.DJ();
            PbActivity.this.eJl.aBM();
            return true;
        }
    });
    private CustomMessageListener eKa = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eJE) {
                PbActivity.this.eJl.Rq();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIv.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aPY().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eJD.c(PbActivity.this.eJC.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eJC.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    PbActivity.this.gg(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aRw();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.al.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eJC.getResources().getString(d.l.mute_fail);
                    }
                    PbActivity.this.eJD.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eKb = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eJE) {
                PbActivity.this.eJl.Rq();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eJD.c(PbActivity.this.eJC.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.al.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eJC.getResources().getString(d.l.un_mute_fail);
                }
                PbActivity.this.eJD.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eKc = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eJE) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eJl.Rq();
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
                    PbActivity.this.eJl.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eKd = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eJl.aTw() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aQP() != null && PbActivity.this.aQP().getPbData() != null && PbActivity.this.aQP().getPbData().aQi() != null && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.T(PbActivity.this.aQP().getPbData().aPL())) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aQo = PbActivity.this.aQP().getPbData().aQi().aQo();
                if (intValue < 10) {
                    if (aQo) {
                        if (PbActivity.this.eIv.getPbData().aQi().eGw == 1 || PbActivity.this.eIv.getPbData().aQi().eGw == 3 || PbActivity.this.eIv.getPbData().aQi().eGw == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eIv.getPbData().aQi().aQo() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aQo ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eJb > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).startAnimation(false);
                        PbActivity.this.eJb = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue / 11, aQo);
                TiebaStatic.log(PbActivity.this.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aQo ? 0 : 1));
            }
        }
    };
    private CustomMessageListener ckP = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.ckr = true;
                }
            }
        }
    };
    public a.b eql = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.afF();
            com.baidu.tbadk.core.data.ar aqO = PbActivity.this.eIv.aqO();
            int pageNum = PbActivity.this.eJl.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.l.pb_page_error);
            } else if (aqO == null || pageNum <= aqO.qz()) {
                PbActivity.this.eJl.aBM();
                PbActivity.this.pb(2);
                PbActivity.this.afE();
                PbActivity.this.eJl.aTO();
                if (com.baidu.adp.lib.util.i.hr()) {
                    PbActivity.this.eIv.pi(PbActivity.this.eJl.getPageNum());
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(d.l.pb_page_error);
            }
        }
    };
    public final View.OnClickListener clm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
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
            com.baidu.tieba.pb.data.m aQi;
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
            boolean j;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if ((PbActivity.this.eJl.eQh.aVj() != null && PbActivity.this.eJl.eQh.aVj().bf(view)) || PbActivity.this.eJl.aTI() == view || view.getId() == d.h.pb_item_tail_content) {
                        if (PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && com.baidu.tieba.pb.f.T(PbActivity.this.eIv.getPbData().aPL())) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (view == PbActivity.this.eJl.getNextView()) {
                        if (!PbActivity.this.mIsLoading && PbActivity.this.eIv.jk(true)) {
                            PbActivity.this.mIsLoading = true;
                            PbActivity.this.eJl.aTP();
                        }
                    } else if (view == PbActivity.this.eJl.aTA()) {
                        PbActivity.this.eJl.aTG();
                        if (!UtilHelper.isFloatWindowOpAllowed(PbActivity.this.getPageContext().getPageActivity())) {
                            PbActivity.this.Qb();
                            return;
                        }
                        PbActivity.this.eJr = true;
                        PbActivity.this.a(PbActivity.this.eIv.getPbData(), 0, 1, true, true);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10830").aa("tid", PbActivity.this.eIv.getThreadID()));
                        PbActivity.this.eJl.aBM();
                    } else if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSY()) {
                        if (view == PbActivity.this.eJl.eQh.aMc) {
                            if (PbActivity.this.eJl.jL(PbActivity.this.eIv.aSe())) {
                                PbActivity.this.afE();
                                return;
                            }
                            PbActivity.this.eIQ = false;
                            PbActivity.this.eIO = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eJl.aTM() && (PbActivity.this.eJl.eQh.aVj() == null || (view != PbActivity.this.eJl.eQh.aVj().aSX() && view != PbActivity.this.eJl.eQh.aVj().aSV()))) {
                            if (view == PbActivity.this.eJl.aUb()) {
                                if (PbActivity.this.eIv != null) {
                                    com.baidu.tbadk.browser.a.T(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIv.getPbData().aPL().rF().getLink());
                                }
                            } else if (view != PbActivity.this.eJl.eQh.eWp) {
                                if (view == PbActivity.this.eJl.eQh.eWr) {
                                    if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null) {
                                        ArrayList<PostData> aPN = PbActivity.this.eIv.getPbData().aPN();
                                        if ((aPN != null && aPN.size() > 0) || !PbActivity.this.eIv.aSa()) {
                                            if (!PbActivity.this.eJl.aUq()) {
                                                PbActivity.this.eJl.aTv();
                                            }
                                            PbActivity.this.aQW();
                                            return;
                                        }
                                        com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                        return;
                                    }
                                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                } else if (view != PbActivity.this.eJl.eQh.eWq && view.getId() != d.h.pb_god_user_tip_content) {
                                    if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSH()) {
                                        if ((PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSU()) && view.getId() != d.h.floor_owner_reply && view.getId() != d.h.reply_title) {
                                            if (PbActivity.this.eJl.eQh.aVj() == null || (view != PbActivity.this.eJl.eQh.aVj().getCancelView() && view != PbActivity.this.eJl.eQh.aVj().VN())) {
                                                if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aTa()) {
                                                    if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSP()) {
                                                        if ((PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSQ()) && view.getId() != d.h.pb_sort) {
                                                            if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSR()) {
                                                                if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSS()) {
                                                                    if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aST()) {
                                                                        if (PbActivity.this.eJq == null || view != PbActivity.this.eJq.aSJ()) {
                                                                            if (PbActivity.this.eJq == null || view != PbActivity.this.eJq.aSH()) {
                                                                                if (PbActivity.this.eJq == null || view != PbActivity.this.eJq.aSM()) {
                                                                                    if (PbActivity.this.eJq == null || view != PbActivity.this.eJq.aSK()) {
                                                                                        if (PbActivity.this.eJq == null || view != PbActivity.this.eJq.aSL()) {
                                                                                            if (PbActivity.this.eJl.aUh() == view) {
                                                                                                if (PbActivity.this.eJl.aUh().getIndicateStatus()) {
                                                                                                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIv.getPbData();
                                                                                                    if (pbData != null && pbData.aPL() != null && pbData.aPL().ro() != null) {
                                                                                                        String pI = pbData.aPL().ro().pI();
                                                                                                        if (StringUtils.isNull(pI)) {
                                                                                                            pI = pbData.aPL().ro().getTaskId();
                                                                                                        }
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11107").aa("obj_id", pI));
                                                                                                    }
                                                                                                } else {
                                                                                                    com.baidu.tieba.tbadkCore.d.a.cj("c10725", null);
                                                                                                }
                                                                                                PbActivity.this.aRr();
                                                                                                return;
                                                                                            } else if (PbActivity.this.eJl.aTI() != view) {
                                                                                                if (PbActivity.this.eJq == null || view != PbActivity.this.eJq.aSI()) {
                                                                                                    if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSZ()) {
                                                                                                        if (PbActivity.this.eJl.eQh.aVj() != null && view == PbActivity.this.eJl.eQh.aVj().aSW()) {
                                                                                                            if (com.baidu.adp.lib.util.i.hr()) {
                                                                                                                SparseArray<Object> c2 = PbActivity.this.eJl.c(PbActivity.this.eIv.getPbData(), PbActivity.this.eIv.aSa(), 1);
                                                                                                                if (c2 != null) {
                                                                                                                    PbActivity.this.eJl.a(((Integer) c2.get(d.h.tag_del_post_type)).intValue(), (String) c2.get(d.h.tag_del_post_id), ((Integer) c2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.h.tag_del_post_is_self)).booleanValue());
                                                                                                                }
                                                                                                                PbActivity.this.eJl.eQh.or();
                                                                                                                return;
                                                                                                            }
                                                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                                                            return;
                                                                                                        } else if (view.getId() != d.h.sub_pb_more && view.getId() != d.h.sub_pb_item && view.getId() != d.h.pb_floor_reply_more) {
                                                                                                            if (view != PbActivity.this.eJl.aQJ()) {
                                                                                                                if (view == PbActivity.this.eJl.eQh.aVk()) {
                                                                                                                    PbActivity.this.eJl.aTU();
                                                                                                                    return;
                                                                                                                }
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.h.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (bpVar = (bp) view.getTag()) != null && !StringUtils.isNull(bpVar.th())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        com.baidu.tbadk.core.util.at.wg().c(PbActivity.this.getPageContext(), new String[]{bpVar.th()});
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if ((id == d.h.pb_floor_agree || id == d.h.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData bb = PbActivity.this.bb(view);
                                                                                                                    if (bb != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", bb.btm() ? 0 : 1));
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.view_main_thread_praise_state) {
                                                                                                                    PbActivity.this.f(view, 2, false);
                                                                                                                    if (PbActivity.this.aQP() != null && PbActivity.this.aQP().getPbData() != null && PbActivity.this.aQP().getPbData().aQi() != null && PbActivity.this.aQP().getPbData().aQi() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aQP().getPbData().aQi().aQo() ? 0 : 1));
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.view_main_thread_praise_num || id == d.h.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && !StringUtils.isNull(PbActivity.this.eIv.getPbData().getThreadId()) && (aQi = PbActivity.this.eIv.getPbData().aQi()) != null && aQi.getPraiseNum() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.at.wg().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eIv.getPbData().getThreadId()});
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
                                                                                                                                if (PbActivity.this.eJq == null) {
                                                                                                                                    PbActivity.this.eJq = new v(PbActivity.this.getPageContext(), PbActivity.this.clm);
                                                                                                                                    PbActivity.this.eJq.jp(PbActivity.this.mIsLogin);
                                                                                                                                }
                                                                                                                                PbActivity.this.eJq.showDialog();
                                                                                                                                boolean z6 = id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right;
                                                                                                                                if (z6) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12006").aa("tid", PbActivity.this.eIv.eMJ));
                                                                                                                                }
                                                                                                                                SparseArray sparseArray2 = new SparseArray();
                                                                                                                                sparseArray2.put(d.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.h.tag_clip_board));
                                                                                                                                sparseArray2.put(d.h.tag_is_subpb, false);
                                                                                                                                PbActivity.this.eJq.aSH().setTag(sparseArray2);
                                                                                                                                PbActivity.this.eJq.aSM().setTag(view.getTag());
                                                                                                                                PbActivity.this.eJq.jr(z6);
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
                                                                                                                                        PbActivity.this.eJq.aSK().setVisibility(0);
                                                                                                                                    } else {
                                                                                                                                        sparseArray4.put(d.h.tag_should_delete_visible, false);
                                                                                                                                        PbActivity.this.eJq.aSK().setVisibility(8);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.eJq.aSI().setTag(sparseArray4);
                                                                                                                                    PbActivity.this.eJq.aSK().setTag(sparseArray4);
                                                                                                                                    PbActivity.this.eJq.aSI().setText(d.l.bar_manager);
                                                                                                                                    PbActivity.this.eJq.aSI().setVisibility(0);
                                                                                                                                } else if (!booleanValue3) {
                                                                                                                                    PbActivity.this.eJq.aSI().setVisibility(8);
                                                                                                                                    PbActivity.this.eJq.aSK().setVisibility(8);
                                                                                                                                } else {
                                                                                                                                    SparseArray sparseArray5 = new SparseArray();
                                                                                                                                    sparseArray5.put(d.h.tag_should_manage_visible, false);
                                                                                                                                    sparseArray5.put(d.h.tag_user_mute_visible, false);
                                                                                                                                    sparseArray5.put(d.h.tag_should_delete_visible, true);
                                                                                                                                    sparseArray5.put(d.h.tag_manage_user_identity, sparseArray3.get(d.h.tag_manage_user_identity));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_id, sparseArray3.get(d.h.tag_del_post_id));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_type, sparseArray3.get(d.h.tag_del_post_type));
                                                                                                                                    PbActivity.this.eJq.aSI().setTag(sparseArray5);
                                                                                                                                    PbActivity.this.eJq.aSK().setTag(sparseArray5);
                                                                                                                                    PbActivity.this.eJq.aSI().setText(d.l.delete);
                                                                                                                                    PbActivity.this.eJq.aSK().setVisibility(0);
                                                                                                                                    PbActivity.this.eJq.aSI().setVisibility(8);
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
                                                                                                                                    PbActivity.this.eJq.aSJ().setTag(sparseArray7);
                                                                                                                                    PbActivity.this.eJq.aSJ().setVisibility(0);
                                                                                                                                    PbActivity.this.eJq.aSI().setVisibility(8);
                                                                                                                                    PbActivity.this.eJq.aSJ().setText(d.l.mute_option);
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
                                                                                                                                    PbActivity.this.eKo = (PostData) sparseArray6.get(d.h.tag_clip_board);
                                                                                                                                    if (ap.k(PbActivity.this.eKo) ? false : iZ) {
                                                                                                                                        PbActivity.this.eJq.aSJ().setVisibility(0);
                                                                                                                                        PbActivity.this.eJq.aSJ().setTag(str3);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.eJq.aSJ().setVisibility(8);
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
                                                                                                                                    PbActivity.this.eJq.aSL().setVisibility(0);
                                                                                                                                    PbActivity.this.eJq.aSL().setTag(d.h.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                                    PbActivity.this.eJq.aSL().setTag(d.h.tag_chudian_monitor_id, str);
                                                                                                                                    PbActivity.this.eJq.aSL().setTag(d.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eJq.aSL().setVisibility(8);
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eIv.getPbData().nM()) {
                                                                                                                            String nL = PbActivity.this.eIv.getPbData().nL();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.j.isEmpty(nL) && nL.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.eJq.aSH().setText(d.l.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eJq.aSH().setText(d.l.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.eJq.jq(true);
                                                                                                                                PbActivity.this.eJq.refreshUI();
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.eJq.jq(true);
                                                                                                                        PbActivity.this.eJq.refreshUI();
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.pb_act_btn) {
                                                                                                                    if (PbActivity.this.eIv.getPbData() != null && PbActivity.this.eIv.getPbData().aPL() != null && PbActivity.this.eIv.getPbData().aPL().sm() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), PbActivity.this.eIv.getPbData().aPL().sm());
                                                                                                                        if (PbActivity.this.eIv.getPbData().aPL().sk() != 1) {
                                                                                                                            if (PbActivity.this.eIv.getPbData().aPL().sk() == 2) {
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
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10912").aa("fid", PbActivity.this.eIv.getPbData().getForumId()).aa("tid", PbActivity.this.eIv.getPbData().getThreadId()).aa("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.eIv.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.eJl.setSelection(0);
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
                                                                                                                        PbActivity.this.eJl.aTv();
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aQU() == 1) {
                                                                                                                            if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10397").aa("fid", PbActivity.this.eIv.getPbData().getForumId()).aa("tid", PbActivity.this.eIv.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else if (PbActivity.this.aQU() == 2 && PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10401").aa("fid", PbActivity.this.eIv.getPbData().getForumId()).aa("tid", PbActivity.this.eIv.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
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
                                                                                                                        if (PbActivity.this.aQU() == 1) {
                                                                                                                            if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10507").aa("fid", PbActivity.this.eIv.getPbData().getForumId()).aa("tid", PbActivity.this.eIv.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else if (PbActivity.this.aQU() == 2 && PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10508").aa("fid", PbActivity.this.eIv.getPbData().getForumId()).aa("tid", PbActivity.this.eIv.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.manga_prev_btn) {
                                                                                                                    PbActivity.this.aRm();
                                                                                                                    return;
                                                                                                                } else if (id == d.h.manga_next_btn) {
                                                                                                                    PbActivity.this.aRn();
                                                                                                                    return;
                                                                                                                } else if (id == d.h.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && PbActivity.this.eIv.getPbData().aQd() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eIv.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11679").aa("fid", pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.at.wg().c(PbActivity.this.getPageContext(), new String[]{pbData2.aQd().aQk()});
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.yule_head_img_all_rank && PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && PbActivity.this.eIv.getPbData().aQd() != null) {
                                                                                                                    com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eIv.getPbData();
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11678").aa("fid", pbData3.getForumId()));
                                                                                                                    com.baidu.tbadk.core.util.at.wg().c(PbActivity.this.getPageContext(), new String[]{pbData3.aQd().aQk()});
                                                                                                                    return;
                                                                                                                } else {
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.eIv.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.eIv.getThreadID(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eIv.getPbData().aPL().sa())));
                                                                                                                return;
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                            if (PbActivity.this.eIv.getPbData() != null) {
                                                                                                                PbActivity.this.eJl.aBM();
                                                                                                                SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                PostData postData3 = (PostData) sparseArray9.get(d.h.tag_load_sub_data);
                                                                                                                View view2 = (View) sparseArray9.get(d.h.tag_load_sub_view);
                                                                                                                if (postData3 != null && view2 != null) {
                                                                                                                    String threadID = PbActivity.this.eIv.getThreadID();
                                                                                                                    String id2 = postData3.getId();
                                                                                                                    int i2 = 0;
                                                                                                                    if (PbActivity.this.eIv.getPbData() != null) {
                                                                                                                        i2 = PbActivity.this.eIv.getPbData().aPW();
                                                                                                                    }
                                                                                                                    if (!com.baidu.tieba.pb.f.d(postData3)) {
                                                                                                                        PbActivity.this.afE();
                                                                                                                        if (view.getId() == d.h.replybtn) {
                                                                                                                            b px = PbActivity.this.px(id2);
                                                                                                                            if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && px != null) {
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i2, postData3.aWk(), PbActivity.this.eIv.getPbData().qs(), false, postData3.getAuthor().getIconInfo()).addBigImageData(px.eKS, px.eKT, px.eKU, px.index)));
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
                                                                                                                            b px2 = PbActivity.this.px(id2);
                                                                                                                            if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && px2 != null && PbActivity.this.aQO().aTt() != null) {
                                                                                                                                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                                                                                                                                nVar.b(PbActivity.this.eIv.getPbData().aPJ());
                                                                                                                                nVar.U(PbActivity.this.eIv.getPbData().aPL());
                                                                                                                                nVar.f(postData4);
                                                                                                                                PbActivity.this.aQO().aTt().d(nVar);
                                                                                                                                PbActivity.this.aQO().aTt().setPostId(str7);
                                                                                                                                PbActivity.this.a(view, str6, str5);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            b px3 = PbActivity.this.px(id2);
                                                                                                                            if (postData3 != null && PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && px3 != null) {
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i2, postData3.aWk(), PbActivity.this.eIv.getPbData().qs(), false, postData3.getAuthor().getIconInfo()).addBigImageData(px3.eKS, px3.eKT, px3.eKU, px3.index)));
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
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 3).aa("fid", PbActivity.this.eIv.getPbData().getForumId()));
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (com.baidu.adp.lib.util.i.hr()) {
                                                                                                        PbActivity.this.eJl.aBM();
                                                                                                        SparseArray<Object> c3 = PbActivity.this.eJl.c(PbActivity.this.eIv.getPbData(), PbActivity.this.eIv.aSa(), 1);
                                                                                                        if (c3 != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIv.getPbData().aPJ().getId(), PbActivity.this.eIv.getPbData().aPJ().getName(), PbActivity.this.eIv.getPbData().aPL().getId(), String.valueOf(PbActivity.this.eIv.getPbData().getUserData().getUserId()), (String) c3.get(d.h.tag_forbid_user_name), (String) c3.get(d.h.tag_forbid_user_post_id))));
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
                                                                                                        if (!com.baidu.tieba.c.a.VF() || sparseArray11.get(d.h.tag_del_post_id) == null || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eIv.getThreadID(), (String) sparseArray11.get(d.h.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.eJl.bg(view);
                                                                                                                return;
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.eJl.a(((Integer) sparseArray11.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.h.tag_del_post_id), ((Integer) sparseArray11.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.h.tag_del_post_is_self)).booleanValue());
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", PbActivity.this.eIv.getPbData().getForumId()));
                                                                                                return;
                                                                                            } else {
                                                                                                PbActivity.this.aQL();
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        long j3 = -1;
                                                                                        String str8 = "";
                                                                                        int i3 = 0;
                                                                                        if (view.getTag(d.h.tag_chudian_template_id) instanceof Long) {
                                                                                            j3 = ((Long) view.getTag(d.h.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (view.getTag(d.h.tag_chudian_monitor_id) instanceof String) {
                                                                                            str8 = (String) view.getTag(d.h.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (view.getTag(d.h.tag_chudian_hide_day) instanceof Integer) {
                                                                                            i3 = ((Integer) view.getTag(d.h.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eIv.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aPJ() != null) {
                                                                                            str9 = pbData4.aPJ().getId();
                                                                                            str10 = pbData4.aPJ().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.b.a(j3, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j3, str8, str9, str10, str11, i3);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                                    if (sparseArray12 != null && (sparseArray12.get(d.h.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.h.tag_del_post_id) instanceof String) && (sparseArray12.get(d.h.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.h.tag_del_post_is_self) instanceof Boolean)) {
                                                                                        boolean booleanValue7 = ((Boolean) sparseArray12.get(d.h.tag_del_post_is_self)).booleanValue();
                                                                                        int intValue = ((Integer) sparseArray12.get(d.h.tag_manage_user_identity)).intValue();
                                                                                        if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.VF() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eIv.getThreadID(), (String) sparseArray12.get(d.h.tag_del_post_id))) {
                                                                                            PbActivity.this.eJl.a(((Integer) sparseArray12.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.h.tag_del_post_id), intValue, booleanValue7);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                if (PbActivity.this.eJq.aSO()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12007").aa("tid", PbActivity.this.eIv.eMJ));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eIv.getPbData() != null) {
                                                                                    PbActivity.this.eJl.aBM();
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
                                                                                        String threadID2 = PbActivity.this.eIv.getThreadID();
                                                                                        String id3 = postData.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbActivity.this.eIv.getPbData() != null) {
                                                                                            i4 = PbActivity.this.eIv.getPbData().aPW();
                                                                                        }
                                                                                        PbActivity.this.afE();
                                                                                        b px4 = PbActivity.this.px(id3);
                                                                                        if (px4 != null) {
                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID2, id3, "pb", true, null, true, null, i4, postData.aWk(), PbActivity.this.eIv.getPbData().qs(), false, postData.getAuthor().getIconInfo()).addBigImageData(px4.eKS, px4.eKT, px4.eKU, px4.index)));
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
                                                                                PbActivity.this.bc(view);
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
                                                                            PbActivity.this.pu((String) tag);
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
                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), null, PbActivity.this.aQT(), true)));
                                                                    PbActivity.this.eJl.eQh.or();
                                                                    PbActivity.this.eJl.eQh.aVj().aTb();
                                                                    return;
                                                                }
                                                                TiebaStatic.log("c10414");
                                                                PbActivity.this.eJl.aBM();
                                                                if (PbActivity.this.eJl.rt() == aq.eRX) {
                                                                    PbActivity.this.eJl.aUg();
                                                                    return;
                                                                } else if (PbActivity.this.eIv.aSy() != null) {
                                                                    PbActivity.this.eIv.aSy().pg(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                                                    return;
                                                                } else {
                                                                    return;
                                                                }
                                                            } else if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && PbActivity.this.eIv.getPbData().aPL() != null) {
                                                                PbActivity.this.eJl.eQh.or();
                                                                PbActivity.this.pu(PbActivity.this.eIv.getPbData().aPL().rW());
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        PbActivity.this.eJl.aBM();
                                                        if (com.baidu.adp.lib.util.i.hr()) {
                                                            PbActivity.this.pb(2);
                                                            PbActivity.this.afE();
                                                            PbActivity.this.eJl.aTO();
                                                            PbActivity.this.eJl.aTJ().je(true);
                                                            boolean z7 = false;
                                                            if (!(view.getTag() instanceof Boolean)) {
                                                                PbActivity.this.eIv.aSk();
                                                            } else {
                                                                z7 = PbActivity.this.eIv.jm(!((Boolean) view.getTag()).booleanValue());
                                                            }
                                                            TiebaStatic.log("c12097");
                                                            if (z7 && PbActivity.this.getListView() != null) {
                                                                if (PbActivity.this.eJG > PbActivity.this.getListView().getFirstVisiblePosition()) {
                                                                    PbActivity.this.eJG = PbActivity.this.getListView().getFirstVisiblePosition();
                                                                }
                                                                View childAt = PbActivity.this.getListView().getChildAt(0);
                                                                int i5 = -1;
                                                                if (childAt != null) {
                                                                    i5 = childAt.getTop();
                                                                }
                                                                PbActivity.this.aQO().h(PbActivity.this.eJG, i5);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                        return;
                                                    }
                                                    PbActivity.this.eJl.aBM();
                                                    if (PbActivity.this.eIv.aqO() != null) {
                                                        PbActivity.this.eJl.a(PbActivity.this.eIv.aqO(), PbActivity.this.eql);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    return;
                                                } else if (PbActivity.this.checkUpIsLogin()) {
                                                    if (com.baidu.adp.lib.util.k.hI()) {
                                                        PbActivity.this.eJl.aBM();
                                                        PbActivity.this.afE();
                                                        PbActivity.this.pb(2);
                                                        if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && PbActivity.this.eIv.getPbData().aQd() != null && !StringUtils.isNull(PbActivity.this.eIv.getPbData().aQd().pW(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11678").aa("fid", PbActivity.this.eIv.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11939"));
                                                        PbActivity.this.eJl.showLoadingDialog();
                                                        PbActivity.this.eIv.aSB().p(CheckRealNameModel.TYPE_PB_SHARE, Integer.valueOf(view == PbActivity.this.eJl.eRG ? 1 : 2));
                                                        return;
                                                    }
                                                    PbActivity.this.showToast(d.l.neterror);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            PbActivity.this.eJl.eQh.or();
                                        } else if (com.baidu.adp.lib.util.i.hr()) {
                                            PbActivity.this.eJl.aBM();
                                            if (PbActivity.this.eJl.eQh.aVj() != null && view == PbActivity.this.eJl.eQh.aVj().aSU() && !PbActivity.this.eJl.aUq()) {
                                                PbActivity.this.eJl.aTv();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.eJl.eQh.eWq.setEnabled(false);
                                                PbActivity.this.afE();
                                                PbActivity.this.eJl.aTO();
                                                if (view.getId() == d.h.floor_owner_reply) {
                                                    j = PbActivity.this.eIv.j(true, PbActivity.this.aRk());
                                                } else {
                                                    j = view.getId() == d.h.reply_title ? PbActivity.this.eIv.j(false, PbActivity.this.aRk()) : PbActivity.this.eIv.pz(PbActivity.this.aRk());
                                                }
                                                if (j) {
                                                    PbActivity.this.eJl.awq();
                                                    PbActivity.this.mIsLoading = true;
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.pb(2);
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.l.network_not_available);
                                        }
                                    } else if (com.baidu.adp.lib.util.i.hr()) {
                                        PbActivity.this.eJl.aBM();
                                        if (PbActivity.this.pa(11009) && PbActivity.this.eIv.pp(PbActivity.this.eJl.aTT()) != null) {
                                            PbActivity.this.aRe();
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.l.network_not_available);
                                    }
                                } else if (com.baidu.adp.lib.util.i.hr()) {
                                    PbActivity.this.eJl.jh(true);
                                    PbActivity.this.eJl.aTv();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eJl.eQh.eWq.setEnabled(false);
                                        PbActivity.this.eJl.awq();
                                        PbActivity.this.afE();
                                        PbActivity.this.eJl.aTO();
                                        PbActivity.this.eIv.pz(PbActivity.this.aRk());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.pb(2);
                                    }
                                } else {
                                    PbActivity.this.showToast(d.l.network_not_available);
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.eIv.getPbData() != null && PbActivity.this.eIv.getPbData().aPL() != null && PbActivity.this.eIv.getPbData().aPL().st() && PbActivity.this.eIv.getPbData().aPL().rX() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11922"));
                                }
                                if (PbActivity.this.eIv.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eIv.aRZ()) && PbActivity.this.eIv.getAppealInfo() != null) {
                                        name = PbActivity.this.eIv.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eIv.getPbData().aPJ().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aRZ = PbActivity.this.eIv.aRZ();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eIv.aSb() && aRZ != null && aRZ.equals(name)) {
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
                            if (PbActivity.this.eIv.getPbData().aPW() == 1 && !PbActivity.this.eJk.btL()) {
                                PbActivity.this.eJl.aBM();
                                int i6 = 0;
                                if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSV()) {
                                    if (PbActivity.this.eJl.eQh.aVj() == null || view != PbActivity.this.eJl.eQh.aVj().aSX()) {
                                        if (view == PbActivity.this.eJl.aTM()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.eIv.getPbData().aPL().rC() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.eIv.getPbData().aPL().rB() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aPJ = PbActivity.this.eIv.getPbData().aPJ();
                                String name2 = aPJ.getName();
                                String id4 = aPJ.getId();
                                String id5 = PbActivity.this.eIv.getPbData().aPL().getId();
                                if (!com.baidu.tieba.c.a.VF() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eJl.aTL();
                                    PbActivity.this.eJk.a(id4, name2, id5, i6, PbActivity.this.eJl.aTN());
                                }
                            }
                        } else {
                            PbActivity.this.showToast(d.l.network_not_available);
                        }
                    } else if (com.baidu.adp.lib.util.i.hr()) {
                        PbActivity.this.eJl.aBM();
                        PbActivity.this.afE();
                        PbActivity.this.eJl.aTO();
                        PbActivity.this.eJl.showLoadingDialog();
                        PbActivity.this.eIv.pi(1);
                    } else {
                        PbActivity.this.showToast(d.l.network_not_available);
                    }
                } else if (PbActivity.this.eIZ) {
                    PbActivity.this.eIZ = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.h.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && PbActivity.this.aQO().aTt() != null && postData5.getAuthor() != null && postData5.bsZ() != 1 && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.d(postData5)) {
                                com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                                nVar2.b(PbActivity.this.eIv.getPbData().aPJ());
                                nVar2.U(PbActivity.this.eIv.getPbData().aPL());
                                nVar2.f(postData5);
                                PbActivity.this.aQO().aTt().d(nVar2);
                                PbActivity.this.aQO().aTt().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.getAuthor().getUserId(), "");
                                TiebaStatic.log("c11743");
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aEn = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.afE();
            PbActivity.this.eJl.jI(z);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbActivity.this.eJl.aBM();
                if (PbActivity.this.eJz != null) {
                    PbActivity.this.eJl.hk(PbActivity.this.eJz.DG());
                }
                PbActivity.this.eJl.aTs();
                PbActivity.this.eJl.hl(true);
                PbActivity.this.eIv.aSn();
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eIv.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIv.getPbData();
                            if (pbData != null && pbData.aPL() != null && pbData.aPL().getAuthor() != null && (userId = pbData.aPL().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && PbActivity.this.eIv.aSg()) {
                                PbActivity.this.eJl.aTO();
                            }
                        } else if (PbActivity.this.eIv.aSg()) {
                            PbActivity.this.eJl.aTO();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eJl.m(PbActivity.this.eIv.getPbData());
                    }
                    if (PbActivity.this.eIv.aSd()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10369").aa("tid", PbActivity.this.eIv.getThreadID()));
                    }
                }
            } else if (qVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    private final PbModel.a eKe = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eC;
            if (!z || fVar == null || fVar.aPU() != null || com.baidu.tbadk.core.util.u.u(fVar.aPN()) >= 1) {
                PbActivity.this.efV = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eJl.aTQ();
                if (fVar == null || !fVar.aPR()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eJl.getView());
                } else if (PbActivity.this.eJl.aTq() == null) {
                    PbActivity.this.eJB = true;
                }
                PbActivity.this.eJl.awp();
                PbActivity.this.eJl.aTK();
                if (PbActivity.this.eJe || PbActivity.this.eJl.aUq()) {
                    PbActivity.this.eJl.aUe();
                } else {
                    PbActivity.this.eJl.hl(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                    PbActivity.this.eJl.eQh.eWq.setEnabled(true);
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eJu = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eJl.Nr();
                    PbActivity.this.eJl.jN(fVar.aPR());
                    if (fVar.aPL() != null && fVar.aPL().sC() != null) {
                        PbActivity.this.a(fVar.aPL().sC());
                    }
                    if (PbActivity.this.eJz != null) {
                        PbActivity.this.eJl.hk(PbActivity.this.eJz.DG());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aPN() != null && fVar.aPN().size() >= 1 && fVar.aPN().get(0) != null) {
                        PbActivity.this.eIv.pB(fVar.aPN().get(0).getId());
                    } else if (fVar.aPU() != null) {
                        PbActivity.this.eIv.pB(fVar.aPU().getId());
                    }
                    if (PbActivity.this.eJz != null) {
                        PbActivity.this.eJz.a(fVar.qs());
                        PbActivity.this.eJz.a(fVar.aPJ(), fVar.getUserData());
                        PbActivity.this.eJz.a(PbActivity.this.eIv.aSh(), PbActivity.this.eIv.getThreadID(), PbActivity.this.eIv.aSD());
                        if (fVar.aPL() != null) {
                            PbActivity.this.eJz.bL(fVar.aPL().sS());
                        }
                    }
                    if (PbActivity.this.ech != null) {
                        PbActivity.this.ech.ac(fVar.nM());
                    }
                    if (fVar == null || fVar.aPX() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eJl.jM(PbActivity.this.mIsFromCDN);
                    if (PbActivity.this.eJr) {
                        PbActivity.this.a(PbActivity.this.eIv.getPbData(), -1, 0, false, true);
                    } else if (PbActivity.this.eJs && !PbActivity.this.eJt) {
                        PbActivity.this.a(PbActivity.this.eIv.getPbData(), -1, false, true);
                        PbActivity.this.eJt = true;
                        PbActivity.this.eJr = true;
                    }
                    PbActivity.this.eJl.a(fVar, i2, i3, PbActivity.this.eIv.aSa(), i4, PbActivity.this.eIv.getIsFromMark());
                    PbActivity.this.eJl.e(fVar, PbActivity.this.eIv.aSa());
                    PbActivity.this.eJl.jK(PbActivity.this.eIv.getHostMode());
                    if (PbActivity.this.eIv.aSw() != null) {
                        PbActivity.this.eJl.jJ(PbActivity.this.eIv.aSw().aRV());
                    }
                    AntiData qs = fVar.qs();
                    if (qs != null) {
                        PbActivity.this.aEb = qs.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aEb) && PbActivity.this.eJz != null && PbActivity.this.eJz.Da() != null && (eC = PbActivity.this.eJz.Da().eC(6)) != null && !TextUtils.isEmpty(PbActivity.this.aEb)) {
                            ((View) eC).setOnClickListener(PbActivity.this.dKU);
                        }
                    }
                    com.baidu.tieba.pb.f.pk(fVar.eGl);
                    if (PbActivity.this.eJw) {
                        PbActivity.this.eJw = false;
                        PbActivity.this.aQO().getListView().setSelection(PbActivity.this.aQY());
                    }
                    if (PbActivity.this.eJx) {
                        PbActivity.this.eJx = false;
                        int aQY = PbActivity.this.aQY();
                        if (aQY == -1) {
                            aQY = PbActivity.this.aQZ();
                        }
                        if (PbActivity.this.aQO() != null && PbActivity.this.aQO().getListView() != null) {
                            PbActivity.this.aQO().getListView().setSelection(aQY);
                        }
                    }
                    PbActivity.this.eIv.a(fVar.aPJ(), PbActivity.this.eJS);
                } else if (str != null) {
                    if (!PbActivity.this.eJu && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eIv != null && PbActivity.this.eIv.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eIv.getAppealInfo().eFG)) {
                                    PbActivity.this.eJl.a(PbActivity.this.eIv.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eJl.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eJl.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                            }
                            PbActivity.this.eJl.aUe();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i != -1) {
                        PbActivity.this.eJl.pD(PbActivity.this.getResources().getString(d.l.list_no_more_new));
                    } else {
                        PbActivity.this.eJl.pD("");
                    }
                    PbActivity.this.eJl.wY();
                }
                PbActivity.this.aKk = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aQP().aSa() || PbActivity.this.aQP().getPbData().qI().qF() != 0 || PbActivity.this.aQP().aSu()) {
                    PbActivity.this.eJA = true;
                    return;
                }
                return;
            }
            PbActivity.this.eIv.pi(1);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void c(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eJl.m(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.r.Gz().GA()) {
                com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m(i, z, responsedMessage, PbActivity.this.aKc, PbActivity.this.createTime, PbActivity.this.aKk, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.bZo : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aKc = 0L;
                if (mVar != null) {
                    mVar.Gu();
                }
            }
        }
    };
    private CustomMessageListener eKf = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aQU() == 1) {
                    PbActivity.this.aRc();
                }
                PbActivity.this.aQV();
            }
        }
    };
    private CustomMessageListener eKg = new CustomMessageListener(CmdConfigCustom.CMD_TTS_OPTION_PB) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
                com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
                if (aVar.tag == PbActivity.this.getUniqueId()) {
                    switch (aVar.eYF) {
                        case 0:
                            if (PbActivity.this.mIsLogin) {
                                if (PbActivity.this.eIv.jk(false)) {
                                    PbActivity.this.eJl.aTP();
                                    return;
                                } else if (PbActivity.this.eIv.getPbData() != null) {
                                    PbActivity.this.eJl.aUc();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        case 1:
                            if (!PbActivity.this.mIsLoading) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.eJl.eQh.eWq.setEnabled(false);
                                PbActivity.this.eJl.awq();
                                PbActivity.this.afE();
                                PbActivity.this.eJl.aTO();
                                PbActivity.this.eIv.pz(PbActivity.this.aRk());
                                return;
                            }
                            return;
                        case 2:
                            if (PbActivity.this.eIP) {
                                boolean hostMode = PbActivity.this.eIv.getHostMode();
                                boolean aSa = PbActivity.this.eIv.aSa();
                                String threadID = PbActivity.this.eIv.getThreadID();
                                String str = aVar.postId;
                                int i2 = aVar.eYG;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(PbActivity.this.getPageContext().getPageActivity());
                                pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aSa, null);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                                PbActivity.this.eJr = false;
                                PbActivity.this.finish();
                                return;
                            }
                            int i3 = aVar.eYG;
                            if (PbActivity.this.eIv.getHostMode()) {
                                i = i3 + 3;
                            } else {
                                i = i3 + 2;
                            }
                            PbActivity.this.eJl.getListView().setSelection(i);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    };
    private final a.InterfaceC0038a eKh = new a.InterfaceC0038a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0038a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eJl.aTQ();
            if (z) {
                if (PbActivity.this.ech != null) {
                    PbActivity.this.ech.ac(z2);
                }
                PbActivity.this.eIv.jn(z2);
                if (PbActivity.this.eIv.nM()) {
                    PbActivity.this.aRf();
                } else {
                    PbActivity.this.eJl.m(PbActivity.this.eIv.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.ech != null) {
                        if (PbActivity.this.ech.nP() != null) {
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
                if (PbActivity.this.eJl != null) {
                    PbActivity.this.eJl.aBM();
                    if (PbActivity.this.eJz != null && !PbActivity.this.eJl.aTw()) {
                        PbActivity.this.eJl.hk(PbActivity.this.eJz.DG());
                    }
                    PbActivity.this.eJl.aTv();
                }
                if (!PbActivity.this.eIV) {
                    PbActivity.this.eIV = true;
                    PbActivity.this.eJl.aUd();
                }
            }
            PbActivity.this.eJl.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eIN != null) {
                PbActivity.this.eIN.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eIW == null) {
                PbActivity.this.eIW = new com.baidu.tbadk.l.d();
                PbActivity.this.eIW.fi(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && PbActivity.this.eIv.getPbData().aPL() != null && PbActivity.this.eIv.getPbData().aPL().st()) {
                    z = false;
                }
                if (PbActivity.this.eJl.aTJ() != null && z) {
                    PbActivity.this.eJl.aTJ().notifyDataSetChanged();
                }
                PbActivity.this.eIW.Gg();
            } else if (i == 1) {
                PbActivity.this.eIW.Gg();
            } else {
                PbActivity.this.eIW.Gg();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aPN;
            if (PbActivity.this.eIv != null && PbActivity.this.eIv.getPbData() != null && PbActivity.this.eJl != null && PbActivity.this.eJl.aTJ() != null) {
                PbActivity.this.eJl.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eIN != null) {
                    PbActivity.this.eIN.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eIv.aSp() && (aPN = PbActivity.this.eIv.getPbData().aPN()) != null && !aPN.isEmpty()) {
                    int aRK = ((i + i2) - PbActivity.this.eJl.aTJ().aRK()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eIv.getPbData();
                    if (pbData != null) {
                        if (pbData.aPO() != null && pbData.aPO().hasData()) {
                            aRK--;
                        }
                        if (pbData.aPP() != null && pbData.aPP().hasData()) {
                            aRK--;
                        }
                        if (PbActivity.this.eIY) {
                            aRK--;
                        }
                        int size = aPN.size();
                        if (aRK < 0 || aRK >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eKi = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.adp.base.d
        public void g(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eJk.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eIv.aSn();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cJK || bVar.eXX <= 0 || bVar.glW == 0) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eJl.a(1, dVar.Co, dVar.glY, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eJk.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eJl.a(PbActivity.this.eJk.getLoadDataMode(), fVar.Co, fVar.glY, false);
                        PbActivity.this.eJl.am(fVar.gma);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eJl.a(PbActivity.this.eJk.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final c eKj = new c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
    };
    private final k.b bay = new k.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aRl()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eIv.jl(true)) {
                PbActivity.this.eJl.aTR();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eKl = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eKk && PbActivity.this.aRl()) {
                PbActivity.this.aRn();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eIv.jk(false)) {
                    PbActivity.this.eJl.aTP();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eIv.getPbData() != null) {
                    PbActivity.this.eJl.aUc();
                }
                PbActivity.this.eKk = true;
            }
        }
    };
    private int eKm = 0;
    private final TbRichTextView.e aRO = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
        public void a(View view, String str, int i) {
            TbRichTextData tbRichTextData;
            try {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                b bVar = new b();
                PbActivity.this.a(str, i, bVar);
                if (bVar.eKW) {
                    TbRichText ao = PbActivity.this.ao(str, i);
                    if (ao != null && (tbRichTextData = ao.Io().get(PbActivity.this.eKm)) != null && tbRichTextData.Iz() != null && tbRichTextData.Iz().memeInfo != null && !TextUtils.isEmpty(tbRichTextData.Iz().memeInfo.detail_link)) {
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextData.Iz().memeInfo.detail_link)));
                    }
                } else if (!bVar.eKV) {
                    ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eKS, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eKU, bVar.eKS.get(0), PbActivity.this.eIv.aSl(), bVar.eKT, true, false, PbActivity.this.eIv.getHostMode());
                    createConfig.getIntent().putExtra("from", "pb");
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                } else {
                    TbRichText ao2 = PbActivity.this.ao(str, i);
                    if (ao2 != null && PbActivity.this.eKm >= 0 && PbActivity.this.eKm < ao2.Io().size()) {
                        String c2 = com.baidu.tieba.pb.data.g.c(ao2.Io().get(PbActivity.this.eKm));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= bVar.eKS.size()) {
                                break;
                            } else if (!bVar.eKS.get(i3).equals(c2)) {
                                i2 = i3 + 1;
                            } else {
                                bVar.index = i3;
                                break;
                            }
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eKS, bVar.index, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eKU, bVar.lastId, PbActivity.this.eIv.aSl(), bVar.eKT, true, false, PbActivity.this.eIv.getHostMode());
                        createConfig2.getIntent().putExtra("from", "pb");
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eKn = false;
    PostData eKo = null;
    private final b.InterfaceC0043b eKp = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eKo != null) {
                if (i == 0) {
                    PbActivity.this.eKo.bN(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eKo = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.h(PbActivity.this.eKo);
                }
            }
        }
    };
    private final b.InterfaceC0043b eKq = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eJI != null && !TextUtils.isEmpty(PbActivity.this.eJJ)) {
                if (i == 0) {
                    if (PbActivity.this.eJK == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eJJ));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eJJ;
                        aVar.pkgId = PbActivity.this.eJK.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eJK.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eJH == null) {
                        PbActivity.this.eJH = new at(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eJH.h(PbActivity.this.eJJ, PbActivity.this.eJI.kZ());
                }
                PbActivity.this.eJI = null;
                PbActivity.this.eJJ = null;
            }
        }
    };
    private final View.OnLongClickListener awp = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eJI = ((TbImageView) view).getBdImage();
                PbActivity.this.eJJ = ((TbImageView) view).getUrl();
                if (PbActivity.this.eJI != null && !TextUtils.isEmpty(PbActivity.this.eJJ)) {
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eJK = null;
                    } else {
                        PbActivity.this.eJK = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eJl.a(PbActivity.this.eKq, PbActivity.this.eJI.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eKo = (PostData) sparseArray.get(d.h.tag_clip_board);
                    if (PbActivity.this.eKo != null && PbActivity.this.ech != null) {
                        PbActivity.this.eJl.a(PbActivity.this.eKp, PbActivity.this.ech.nM() && PbActivity.this.eKo.getId() != null && PbActivity.this.eKo.getId().equals(PbActivity.this.eIv.rP()), ((Boolean) sparseArray.get(d.h.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a bFF = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!PbActivity.this.eIP && z && !PbActivity.this.eIv.aSf()) {
                PbActivity.this.VY();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
        }
    };
    public View.OnTouchListener aMU = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).apQ()) {
                        break;
                    }
                }
            }
            PbActivity.this.cmN.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0080a bWS = new a.InterfaceC0080a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        final int byM;

        {
            this.byM = (int) PbActivity.this.getResources().getDimension(d.f.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2) && PbActivity.this.eJl != null && PbActivity.this.eIN != null) {
                PbActivity.this.eIN.eo(false);
                PbActivity.this.eIN.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ai(int i, int i2) {
            if (Y(i2) && PbActivity.this.eJl != null && PbActivity.this.eIN != null) {
                PbActivity.this.eIN.eo(true);
                if (Math.abs(i2) > this.byM) {
                    PbActivity.this.eIN.hideFloatingView();
                }
                if (PbActivity.this.aRl()) {
                    PbActivity.this.eJl.aTE();
                    PbActivity.this.eJl.aTF();
                }
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eKr = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tieba.e.b.a
        public void ef(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aQC();
            } else {
                com.baidu.tieba.pb.a.b.aQB();
            }
        }
    };
    private String eKs = null;
    private final m.a eKt = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.l.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eKs = str2;
                PbActivity.this.eJl.pE(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eKu = -1;
    private int eKv = -1;
    private CustomMessageListener eKy = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.Ub == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0041a) {
                    if (aVar.Uc != null && !aVar.Uc.hasError() && aVar.Uc.getError() == 0) {
                        if (PbActivity.this.eJl != null) {
                            PbActivity.this.eJl.w(((a.C0041a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aRx();
                        }
                    } else if (z) {
                        if (aVar.Uc != null && aVar.Uc.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Uc.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.Uc != null && !aVar.Uc.hasError() && aVar.Uc.getError() == 0) {
                        if (PbActivity.this.eJl != null && PbActivity.this.eJl != null) {
                            PbActivity.this.eJl.w(((a.C0041a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.Uc != null && aVar.Uc.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.Uc.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.Uc == null || aVar.Uc.hasError() || aVar.Uc.getError() != 0) {
                        if (z) {
                            if (aVar.Uc != null && aVar.Uc.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.Uc.getErrorString());
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
    private final CustomMessageListener ckI = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11455").aa("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.at.wg().c(PbActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    private d.b Kh = new d.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
        @Override // com.baidu.adp.widget.d.b
        public void lx() {
            PbActivity.this.eJl.aUs();
        }

        @Override // com.baidu.adp.widget.d.b
        public void W(boolean z) {
            if (z) {
                PbActivity.this.eJl.aUt();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> eKS;
        public ConcurrentHashMap<String, ImageUrlData> eKT;
        public boolean eKV;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eKU = false;
        public boolean eKW = false;
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

    public com.baidu.tbadk.editortools.pb.c aQK() {
        return this.eJz;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        if (nVar.aQt() != null) {
            String id = nVar.aQt().getId();
            ArrayList<PostData> aPN = this.eIv.getPbData().aPN();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aPN.size()) {
                    break;
                }
                PostData postData = aPN.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aQx = nVar.aQx();
                    postData.tr(nVar.getTotalCount());
                    if (postData.bsW() != null) {
                        postData.bsW().clear();
                        postData.bsW().addAll(aQx);
                    }
                }
            }
            this.eJl.m(this.eIv.getPbData());
            c(nVar);
        }
    }

    public void aQL() {
        com.baidu.tieba.pb.data.f pbData;
        bl aPL;
        if (!this.eJU) {
            if (!com.baidu.adp.lib.util.k.hI()) {
                showToast(d.l.no_network_guide);
            } else if (this.eJX) {
                this.eJU = true;
                if (this.eIv != null && (pbData = this.eIv.getPbData()) != null && (aPL = pbData.aPL()) != null) {
                    int isLike = aPL.rw() == null ? 0 : aPL.rw().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10796").aa("tid", aPL.getId()));
                    }
                    if (this.eJV != null) {
                        this.eJV.a(aPL.rW(), aPL.getId(), isLike, "pb");
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
                                    PbActivity.this.eJl.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eJE);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eJE);
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
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eJE);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eJE);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).tv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja(int i) {
        bl aPL;
        String str;
        String z;
        if (this.eIv != null && this.eIv.getPbData() != null && (aPL = this.eIv.getPbData().aPL()) != null) {
            if (i == 1) {
                PraiseData rw = aPL.rw();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (rw == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aPL.a(praiseData);
                    } else {
                        aPL.rw().getUser().add(0, metaData);
                        aPL.rw().setNum(aPL.rw().getNum() + 1);
                        aPL.rw().setIsLike(i);
                    }
                }
                if (aPL.rw() != null) {
                    if (aPL.rw().getNum() < 1) {
                        z = getResources().getString(d.l.frs_item_praise_text);
                    } else {
                        z = com.baidu.tbadk.core.util.al.z(aPL.rw().getNum());
                    }
                    this.eJl.T(z, true);
                }
            } else if (aPL.rw() != null) {
                aPL.rw().setIsLike(i);
                aPL.rw().setNum(aPL.rw().getNum() - 1);
                ArrayList<MetaData> user = aPL.rw().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aPL.rw().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aPL.rw().getNum() < 1) {
                    str = getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = aPL.rw().getNum() + "";
                }
                this.eJl.T(str, false);
            }
            if (this.eIv.aSa()) {
                this.eJl.aTJ().notifyDataSetChanged();
            } else {
                this.eJl.n(this.eIv.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.adp.framework.message.Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().asR && !StringUtils.isNull(updateAttentionMessage.getData().asS, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().asS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eIv != null && this.eIv.getPbData() != null && this.eJl != null) {
            this.eJl.d(this.eIv.getPbData(), this.eIv.aSa(), this.eIv.aSq());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eIv.q(bundle);
        if (this.cjK != null) {
            this.cjK.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eJz.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eJC = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.bZo = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eJf = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eJf)) {
                this.eIO = true;
            }
            this.eKu = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eKv = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eKw = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eJs = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.eJw = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eJx = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aRl()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.al.isEmpty(this.source) ? "" : this.source;
            this.eJL = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.eJa = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.bZo = System.currentTimeMillis();
        }
        this.eIU = System.currentTimeMillis();
        this.aKc = this.eIU - this.bZo;
        super.onCreate(bundle);
        this.mSwipeBackLayout.setOnSlidingStateChangeListener(this.Kh);
        this.eIR = 0;
        s(bundle);
        if (this.eIv != null && this.eIv.getPbData() != null) {
            this.eIv.getPbData().pq(this.source);
        }
        initUI();
        if (intent != null && this.eJl != null) {
            this.eJl.ePX = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eJF == null) {
                    this.eJF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eJl.pG("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eJF, 1500L);
            }
        }
        this.cjK = new VoiceManager();
        this.cjK.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
        dVar.setForumName(this.eIv.aRZ());
        if (this.eIv.getPbData() != null && this.eIv.getPbData().aPJ() != null) {
            dVar.setForumId(this.eIv.getPbData().aPJ().getId());
        }
        dVar.setFrom("pb");
        dVar.a(this.eIv);
        this.eJz = (com.baidu.tbadk.editortools.pb.c) dVar.aR(getActivity());
        this.eJz.d(this);
        this.eJz.a(this.aEn);
        this.eJz.a(this.aEg);
        this.eJz.a(this, bundle);
        this.eJz.Da().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eJz.Da().bE(true);
        iY(true);
        this.eJl.setEditorTools(this.eJz.Da());
        this.eJz.a(this.eIv.aSh(), this.eIv.getThreadID(), this.eIv.aSD());
        registerListener(this.dKV);
        if (!this.eIv.aSe()) {
            this.eJz.ga(this.eIv.getThreadID());
        }
        if (this.eIv.aSE()) {
            this.eJz.fY(getPageContext().getString(d.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eJz.fY(getPageContext().getString(d.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eIU;
        registerListener(this.eJO);
        registerListener(this.dLr);
        registerListener(this.eJP);
        registerListener(this.ckE);
        registerListener(this.eKd);
        registerListener(this.eJN);
        this.eJy = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gjg);
        this.eJy.bsA();
        registerListener(this.eJR);
        registerListener(this.bgM);
        if (this.eIv != null) {
            this.eIv.aSs();
        }
        if (TbadkCoreApplication.getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.eJZ);
        registerListener(this.eKg);
        registerListener(this.eKf);
        registerListener(this.eKy);
        registerListener(this.ckP);
        this.eJc = new com.baidu.tieba.pb.pb.main.b(this.eIv, this);
        if (this.eJl != null && this.eJl.aUi() != null && this.eJl.aUj() != null) {
            this.eIN = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eJl.aUi(), this.eJl.aUj());
            this.eIN.a(this.eJY);
        }
        if (this.eIM && this.eJl != null && this.eJl.aUj() != null) {
            this.eJl.aUj().setVisibility(8);
        }
        this.eJD = new com.baidu.tbadk.core.view.c();
        this.eJD.alo = 1000L;
        registerListener(this.eKc);
        registerListener(this.eKa);
        registerListener(this.eKb);
        this.eJE = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eJE;
        userMuteAddAndDelCustomMessage.setTag(this.eJE);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eJE;
        userMuteCheckCustomMessage.setTag(this.eJE);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eIv.aSB().a(this.bpq);
        if ("from_tieba_kuang".equals(this.eJf)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12264").r("obj_type", 2).aa("tid", this.eIv.getThreadID()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    public String aQM() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aQN() {
        return this.eIN;
    }

    private void iY(boolean z) {
        this.eJz.bI(z);
        this.eJz.bJ(z);
        this.eJz.bK(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cjK != null) {
            this.cjK.onStart(getPageContext());
        }
    }

    public aq aQO() {
        return this.eJl;
    }

    public PbModel aQP() {
        return this.eIv;
    }

    public void ps(String str) {
        if (this.eIv != null && !StringUtils.isNull(str) && this.eJl != null) {
            this.eJl.aTK();
            this.eJl.jP(true);
            this.eIv.ps(str);
            this.eJd = true;
            this.eJl.aBM();
            this.eJl.aUe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eIP = false;
        } else {
            this.eIP = true;
        }
        super.onPause();
        if (this.eJl.aTq() != null && this.eJl.aTq().aQH() != null) {
            this.eJl.aTq().aQH().onPause();
        }
        BdListView listView = getListView();
        this.eIR = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eIR == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.cjK != null) {
            this.cjK.onPause(getPageContext());
        }
        if (this.eJl != null) {
            this.eJl.onPause();
        }
        if (!this.eIv.aSe()) {
            this.eJz.fZ(this.eIv.getThreadID());
        }
        if (this.eIv != null) {
            this.eIv.aSt();
        }
        MessageManager.getInstance().unRegisterListener(this.dko);
        aqk();
        MessageManager.getInstance().unRegisterListener(this.eKa);
        MessageManager.getInstance().unRegisterListener(this.eKb);
        MessageManager.getInstance().unRegisterListener(this.eKc);
        MessageManager.getInstance().unRegisterListener(this.ckI);
        MessageManager.getInstance().unRegisterListener(this.cUD);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aQQ() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eIv.getPbData(), this.eIv.aSa(), this.eIv.aSq());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eIP = false;
        super.onResume();
        if (this.eJh) {
            this.eJh = false;
            aRr();
        }
        if (this.eJl.aTq() != null && this.eJl.aTq().aQH() != null) {
            this.eJl.aTq().aQH().onResume();
        }
        if (aQQ()) {
            this.eIX = System.currentTimeMillis();
        } else {
            this.eIX = -1L;
        }
        if (this.eJl != null && this.eJl.getView() != null) {
            if (!this.efV) {
                aRi();
            } else {
                hideLoadingView(this.eJl.getView());
            }
            this.eJl.onResume();
        }
        if (this.eIR == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eJl != null) {
            noNetworkView = this.eJl.aTr();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hr()) {
            noNetworkView.aL(false);
        }
        if (this.cjK != null) {
            this.cjK.onResume(getPageContext());
        }
        registerListener(this.dko);
        this.eJv = false;
        aRq();
        registerListener(this.eKa);
        registerListener(this.eKb);
        registerListener(this.eKc);
        registerListener(this.ckI);
        registerListener(this.cUD);
        if (this.ckr) {
            VY();
            this.ckr = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eJl.jG(z);
        if (this.eJq != null) {
            this.eJq.jp(z);
        }
        if (z && this.eJv) {
            this.eJl.aTP();
            this.eIv.jk(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eIX > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10804").aa("obj_duration", (System.currentTimeMillis() - this.eIX) + ""));
            this.eIX = 0L;
        }
        if (this.eJz != null && this.eJz.Da() != null && this.eJz.Da().getVisibility() != 0) {
            this.eJz.DJ();
        }
        if (aQO().aTu() != null) {
            aQO().aTu().onStop();
        }
        if (this.eJl.eQh != null && !this.eJl.eQh.XC()) {
            this.eJl.eQh.aCd();
        }
        if (this.eIv != null && this.eIv.getPbData() != null && this.eIv.getPbData().aPJ() != null && this.eIv.getPbData().aPL() != null) {
            com.baidu.tbadk.distribute.a.CK().a(getPageContext().getPageActivity(), "pb", this.eIv.getPbData().aPJ().getId(), com.baidu.adp.lib.g.b.d(this.eIv.getPbData().aPL().getId(), 0L));
        }
        if (this.cjK != null) {
            this.cjK.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.eJc != null) {
            this.eJc.destroy();
        }
        if (this.eJr && this.eIv != null) {
            a(this.eIv.getPbData(), -2, 0, false, false);
        }
        if (!this.eIV && this.eJl != null) {
            this.eIV = true;
            this.eJl.aUd();
            a(false, (PostData) null);
        }
        if (this.eIv != null) {
            this.eIv.cancelLoadData();
            this.eIv.destory();
            if (this.eIv.aSA() != null) {
                this.eIv.aSA().onDestroy();
            }
        }
        if (this.eJz != null) {
            this.eJz.onDestroy();
        }
        if (this.eJk != null) {
            this.eJk.cancelLoadData();
        }
        if (this.eJl != null) {
            this.eJl.onDestroy();
            if (this.eJl.eQh != null) {
                this.eJl.eQh.aCd();
            }
        }
        if (this.eIW != null) {
            this.eIW.onDestroy();
        }
        if (this.eIN != null) {
            this.eIN.Ho();
        }
        super.onDestroy();
        if (this.cjK != null) {
            this.cjK.onDestory(getPageContext());
        }
        if (this.cke != null) {
            this.cke.destory();
        }
        this.eJl.aBM();
        MessageManager.getInstance().unRegisterListener(this.eKa);
        MessageManager.getInstance().unRegisterListener(this.eKb);
        MessageManager.getInstance().unRegisterListener(this.eKc);
        MessageManager.getInstance().unRegisterListener(this.eJE);
        MessageManager.getInstance().unRegisterListener(this.eKd);
        MessageManager.getInstance().unRegisterListener(this.ckP);
        this.eJC = null;
        this.eJD = null;
        com.baidu.tieba.recapp.d.a.biJ().biL();
        if (this.eJF != null) {
            getSafeHandler().removeCallbacks(this.eJF);
        }
        if (this.eJi != null) {
            this.eJi.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g aTJ;
        ArrayList<PostData> aRL;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xW() && this.eJl != null && (aTJ = this.eJl.aTJ()) != null && (aRL = aTJ.aRL()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aRL.iterator();
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
                        bVar.bDO = id;
                        bVar.bJX = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ZU == 1 && !TextUtils.isEmpty(id)) {
                    next.ZU = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bDO = id;
                    bVar2.bJX = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eIv == null || this.eIv.getPbData() == null || this.eIv.getPbData().aPJ() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eIv.getPbData().aPJ().getFirst_class();
                    str2 = this.eIv.getPbData().aPJ().getSecond_class();
                    str = this.eIv.getPbData().aPJ().getId();
                    str4 = this.eIv.getThreadID();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eJl.onChangeSkinType(i);
        if (this.eJz != null && this.eJz.Da() != null) {
            this.eJz.Da().onChangeSkinType(i);
        }
        if (this.eJl.aTr() != null) {
            this.eJl.aTr().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eJl = new aq(this, this.clm, this.aRP);
        this.cmN = new com.baidu.tieba.e.b(getActivity());
        this.cmN.a(this.eKr);
        this.cmN.a(this.bWS);
        this.eJl.setOnScrollListener(this.mOnScrollListener);
        this.eJl.d(this.eKl);
        this.eJl.a(this.bay);
        this.eJl.iS(com.baidu.tbadk.core.h.oY().pe());
        this.eJl.setOnImageClickListener(this.aRO);
        this.eJl.a(this.awp);
        this.eJl.c(this.bFF);
        this.eJl.a(this.eKj);
        this.eJl.jG(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ba(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.gjJ == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oY().pe()) {
                    return false;
                }
                return pw(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eJl != null) {
            if (z && (!this.efV || this.eJB)) {
                aRi();
            } else {
                hideLoadingView(this.eJl.getView());
            }
            this.eJB = false;
        }
    }

    private void aQR() {
        if (this.eIS == null) {
            this.eIS = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eIS.a(new String[]{getPageContext().getString(d.l.call_phone), getPageContext().getString(d.l.sms_phone), getPageContext().getString(d.l.search_in_baidu)}, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eIt = PbActivity.this.eIt.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIt);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eIv.getThreadID(), PbActivity.this.eIt, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eIt = PbActivity.this.eIt.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIt);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eIv.getThreadID(), PbActivity.this.eIt, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eIt = PbActivity.this.eIt.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIt);
                        bVar.dismiss();
                    }
                }
            }).cg(b.a.ack).ch(17).d(getPageContext());
        }
    }

    private void s(Bundle bundle) {
        this.eIv = new PbModel(this);
        this.eIv.a(this.eKe);
        if (this.eIv.aSy() != null) {
            this.eIv.aSy().a(this.eKt);
        }
        if (this.eIv.aSx() != null) {
            this.eIv.aSx().a(this.eJQ);
        }
        if (this.eIv.aSA() != null) {
            this.eIv.aSA().a(this.eJM);
        }
        if (bundle != null) {
            this.eIv.initWithBundle(bundle);
        } else {
            this.eIv.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eIv.jo(true);
        }
        ai.aTl().S(this.eIv.aRY(), this.eIv.getIsFromMark());
        if (StringUtils.isNull(this.eIv.getThreadID())) {
            finish();
        } else {
            this.eIv.Fw();
        }
    }

    private void initData(Bundle bundle) {
        this.ech = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.ech != null) {
            this.ech.a(this.eKh);
        }
        this.eJk = new ForumManageModel(this);
        this.eJk.setLoadDataCallBack(this.eKi);
        this.eJl.a(new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
            public void g(Object obj) {
                if (!com.baidu.adp.lib.util.i.hr()) {
                    PbActivity.this.showToast(d.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eIv.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eIv.getPbData().aPJ().getId(), PbActivity.this.eIv.getPbData().aPJ().getName(), PbActivity.this.eIv.getPbData().aPL().getId(), valueOf, str, str2)));
            }
        });
        this.eJV.setUniqueId(getUniqueId());
        this.eJV.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eJl.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(d.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eJE;
        userMuteCheckCustomMessage.setTag(this.eJE);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qb() {
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
        aVar.b(getPageContext()).ts();
    }

    public PostData bb(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.h.tag_clip_board)) != null && !com.baidu.tieba.pb.f.d(postData)) {
            if (postData.btm()) {
                postData.cT(postData.btl() - 1);
            } else {
                postData.cT(postData.btl() + 1);
            }
            postData.mB(!postData.btm());
            ((PbFloorAgreeView) view).a(postData.btm(), postData.btl(), true);
            final int i = postData.btm() ? 0 : 1;
            this.eIv.aSz().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
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

    public com.baidu.tbadk.core.util.aj aQS() {
        return new com.baidu.tbadk.core.util.aj("c12003").aa("tid", this.eIv.eMJ).r("obj_type", 0).aa("fid", this.eIv.getForumId()).r("obj_param1", this.eIv.getPbData().aPL().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQT() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eIv != null && this.eIv.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eIv.getPbData();
            if (pbData.aPJ() != null) {
                sb.append("forum_name=").append(pt(pbData.aPJ().getName()));
                sb.append("&");
            }
            if (pbData.aPL() != null) {
                bl aPL = pbData.aPL();
                sb.append("thread_id=").append(aPL.getId());
                sb.append("&");
                sb.append("thread_title=").append(pt(aPL.getTitle()));
                if (aPL.getAuthor() != null && aPL.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aPL.getAuthor().getPortrait());
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
                        PbActivity.this.aQO().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aQO().aTu() != null) {
                        PbActivity.this.aQO().aTu().bN(str, str2);
                    }
                    PbActivity.this.aQO().aUe();
                }
            }, 500L);
        }
    }

    private String pt(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null && this.eIv != null && this.eIv.getPbData() != null && postData.bsZ() > 1) {
            String threadID = this.eIv.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.eIv.getPbData() != null) {
                i = this.eIv.getPbData().aPW();
            }
            b px = px(id);
            if (px != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, postData.aWk(), this.eIv.getPbData().qs(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(px.eKS, px.eKT, px.eKU, px.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        an anVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.k.hI()) {
                showToast(d.l.no_network_guide);
            } else if (aQP() != null && aQP().getPbData() != null && aQP().getPbData().aQi() != null && !com.baidu.tieba.pb.f.T(aQP().getPbData().aPL())) {
                com.baidu.tieba.pb.data.m aQi = aQP().getPbData().aQi();
                if (view == null || !(view.getTag(d.h.pb_main_thread_praise_view) instanceof an)) {
                    anVar = null;
                } else {
                    anVar = (an) view.getTag(d.h.pb_main_thread_praise_view);
                }
                if (aQi != null) {
                    int i2 = -1;
                    if (z) {
                        aQi.oV(i);
                    } else if (aQi.aQo()) {
                        aQi.aQq();
                        i2 = 1;
                    } else {
                        aQi.oW(i);
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
                    if (this.eIv != null && this.eIv.aSz() != null) {
                        String str = "";
                        if (this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null) {
                            str = this.eIv.getPbData().aPL().rW();
                        }
                        if (this.eIv.getPbData() != null) {
                            this.eIv.getPbData().a(aQi);
                        }
                        if (z) {
                            this.eIv.aSz().a(str, 3, i, this.eIv.getForumId(), aVar);
                        } else {
                            this.eIv.aSz().a(str, i2, 3, i, this.eIv.getForumId(), aVar);
                            com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                            lVar.eGw = i2;
                            lVar.eGx = aQi;
                            lVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, lVar));
                        }
                    }
                    if (anVar != null) {
                        anVar.b(aQi);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQU() {
        if (this.eIv.getPbData() == null || this.eIv.getPbData().aPL() == null) {
            return -1;
        }
        return this.eIv.getPbData().aPL().sk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQV() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.pS(this.eIv.getForumId()) && this.eIv.getPbData() != null && this.eIv.getPbData().aPJ() != null) {
            if (this.eIv.getPbData().aPJ().isLike() == 1) {
                aRj();
                this.eIv.aSC().bP(this.eIv.getForumId(), this.eIv.getThreadID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iZ(boolean z) {
        if (this.eIv == null || this.eIv.getPbData() == null) {
            return false;
        }
        return ((this.eIv.getPbData().aPW() != 0) || this.eIv.getPbData().aPL() == null || this.eIv.getPbData().aPL().getAuthor() == null || TextUtils.equals(this.eIv.getPbData().aPL().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean ja(boolean z) {
        if (z) {
            return true;
        }
        if (this.eIv == null || this.eIv.getPbData() == null) {
            return false;
        }
        return this.eIv.getPbData().aPW() != 0;
    }

    private boolean jb(boolean z) {
        return (z || this.eIv == null || this.eIv.getPbData() == null || this.eIv.getPbData().aPW() == 0) ? false : true;
    }

    public void aQW() {
        if (this.eIv != null && this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null && this.eIv.getPbData().aPL().getAuthor() != null) {
            if (this.eJl != null) {
                this.eJl.aTs();
            }
            bl aPL = this.eIv.getPbData().aPL();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aPL.getAuthor().getUserId());
            GodUserData godUserData = aPL.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            y yVar = new y();
            if (this.eIv.getPbData().aPW() == 1) {
                yVar.eOx = true;
                yVar.eOw = true;
                yVar.eOC = aPL.rB() == 1;
                yVar.eOB = aPL.rC() == 1;
            } else {
                yVar.eOx = false;
                yVar.eOw = false;
            }
            yVar.eOv = TbadkCoreApplication.getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            yVar.eOt = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            yVar.eOy = ja(equals);
            yVar.eOz = aQX();
            yVar.eOA = jb(equals);
            yVar.eOu = this.eIv.aSa();
            yVar.eGI = this.ech != null ? this.ech.nM() : false;
            yVar.eOs = iZ(equals);
            yVar.eOq = equals && this.eJl.aTV();
            yVar.eOr = z;
            yVar.isHostOnly = this.eIv.getHostMode();
            if (aPL.rX() == null) {
                yVar.eOD = false;
            } else {
                yVar.eOD = true;
            }
            this.eJl.eQh.a(yVar);
        }
    }

    private boolean aQX() {
        if (this.eIv != null && this.eIv.aSa()) {
            return this.eIv.aqO() == null || this.eIv.aqO().qF() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(View view) {
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
        if (fVar != null && this.eIv != null) {
            ad adVar = new ad(getUniqueId());
            adVar.pbData = fVar;
            adVar.threadId = this.eIv.getThreadID();
            adVar.postId = this.eIv.getPostId();
            adVar.ePd = i;
            adVar.ePe = i2;
            adVar.ePc = this.eIv.getHostMode();
            adVar.eGI = this.eIv.nM();
            adVar.isSquence = this.eIv.aSa();
            adVar.loadType = this.eIv.aSv();
            adVar.ePf = z;
            adVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, adVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQY() {
        if (aQO() == null || aQO().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aQO().getListView();
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
    public int aQZ() {
        if (aQO() == null || aQO().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = aQO().getListView();
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
        if (fVar != null && this.eIv != null) {
            ad adVar = new ad(getUniqueId());
            adVar.pbData = fVar;
            adVar.threadId = this.eIv.getThreadID();
            adVar.postId = this.eIv.getPostId();
            adVar.ePd = i;
            adVar.ePc = this.eIv.getHostMode();
            adVar.eGI = this.eIv.nM();
            adVar.isSquence = this.eIv.aSa();
            adVar.loadType = this.eIv.aSv();
            adVar.ePf = z;
            adVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, adVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        VY();
    }

    public void a(boolean z, MarkData markData) {
        this.eJl.aTQ();
        this.eIv.jn(z);
        if (this.ech != null) {
            this.ech.ac(z);
            if (markData != null) {
                this.ech.a(markData);
            }
        }
        if (this.eIv.nM()) {
            aRf();
        } else {
            this.eJl.m(this.eIv.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oZ(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(String str) {
        if (!StringUtils.isNull(str) && this.eIv != null) {
            String threadID = this.eIv.getThreadID();
            String id = this.eIv.getPbData().aPJ().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eIv.aSe()) {
                    antiData.setBlock_forum_name(this.eIv.getPbData().aPJ().getName());
                    antiData.setBlock_forum_id(this.eIv.getPbData().aPJ().getId());
                    antiData.setUser_name(this.eIv.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eIv.getPbData().getUserData().getUserId());
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
            gg(str);
        } else {
            this.eJl.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eJl.a(0, bVar.Co, bVar.glY, z);
            if (bVar.Co) {
                if (bVar.glW == 1) {
                    ArrayList<PostData> aPN = this.eIv.getPbData().aPN();
                    int size = aPN.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aPN.get(i).getId())) {
                            i++;
                        } else {
                            aPN.remove(i);
                            break;
                        }
                    }
                    this.eJl.m(this.eIv.getPbData());
                } else if (bVar.glW == 0) {
                    aRa();
                } else if (bVar.glW == 2) {
                    ArrayList<PostData> aPN2 = this.eIv.getPbData().aPN();
                    int size2 = aPN2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aPN2.get(i2).bsW().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aPN2.get(i2).bsW().get(i3).getId())) {
                                i3++;
                            } else {
                                aPN2.get(i2).bsW().remove(i3);
                                aPN2.get(i2).bsY();
                                z2 = true;
                                break;
                            }
                        }
                        aPN2.get(i2).si(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eJl.m(this.eIv.getPbData());
                    }
                    a(bVar, this.eJl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eJl.a(this.eJk.getLoadDataMode(), fVar.Co, fVar.glY, false);
            if (fVar.Co) {
                this.eJn = true;
                if (i == 2 || i == 3) {
                    this.eJo = true;
                    this.eJp = false;
                } else if (i == 4 || i == 5) {
                    this.eJo = false;
                    this.eJp = true;
                }
                if (i == 2) {
                    this.eIv.getPbData().aPL().bU(1);
                    this.eIv.setIsGood(1);
                } else if (i == 3) {
                    this.eIv.getPbData().aPL().bU(0);
                    this.eIv.setIsGood(0);
                } else if (i == 4) {
                    this.eIv.getPbData().aPL().bT(1);
                    this.eIv.hG(1);
                } else if (i == 5) {
                    this.eIv.getPbData().aPL().bT(0);
                    this.eIv.hG(0);
                }
                this.eJl.d(this.eIv.getPbData(), this.eIv.aSa());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aRa() {
        if (this.eIv.aSb() || this.eIv.aSc()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eIv.getThreadID());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eIv.getThreadID()));
        if (aRg()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRb() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aPT;
        if (this.eJl != null) {
            this.eJl.aBM();
        }
        if (this.eIv != null && this.eIv.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eIv.getPbData().aPL().getId();
            historyMessage.forumName = this.eIv.getPbData().aPJ().getName();
            historyMessage.threadName = this.eIv.getPbData().aPL().getTitle();
            ArrayList<PostData> aPN = this.eIv.getPbData().aPN();
            int aTS = this.eJl != null ? this.eJl.aTS() : 0;
            if (aPN != null && aTS >= 0 && aTS < aPN.size()) {
                historyMessage.postID = aPN.get(aTS).getId();
            }
            historyMessage.isHostOnly = this.eIv.getHostMode();
            historyMessage.isSquence = this.eIv.aSa();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eJz != null) {
            this.eJz.onDestroy();
        }
        if (this.eIQ && aQO() != null) {
            aQO().aUr();
        }
        if (this.eIv != null && (this.eIv.aSb() || this.eIv.aSc())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eIv.getThreadID());
            if (this.eJn) {
                if (this.eJp) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eIv.aBD());
                }
                if (this.eJo) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eIv.getIsGood());
                }
            }
            if (this.eIv.getPbData() != null && System.currentTimeMillis() - this.eIU >= 40000 && (aPT = this.eIv.getPbData().aPT()) != null && !com.baidu.tbadk.core.util.u.v(aPT.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aPT);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eJL);
            }
            setResult(-1, intent);
        }
        if (aRg()) {
            if (this.eIv != null && this.eJl != null && this.eJl.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eIv.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aPR() && !this.eJd) {
                        ai.aTl().a(this.eIv.getPbData(), this.eJl.getListView().onSaveInstanceState(), this.eIv.aSa(), this.eIv.getHostMode());
                    }
                }
            } else {
                ai.aTl().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eJl == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eJl.pu(i)) {
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
        this.eJz.onActivityResult(i, i2, intent);
        if (this.eJi != null) {
            this.eJi.onActivityResult(i, i2, intent);
        }
        if (aQO().aTu() != null) {
            aQO().aTu().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aRe();
                    return;
                case 13008:
                    ai.aTl().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eIv != null) {
                                PbActivity.this.eIv.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eIv != null) {
                        a(aRd(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (aQU() == 1) {
                        aRc();
                    }
                    String stringExtra = intent.getStringExtra("share_to");
                    if (!AddExperiencedModel.WEIXIN_FRIEND.equals(stringExtra) && !AddExperiencedModel.WEIXIN_TIMELINE.equals(stringExtra)) {
                        aQV();
                        return;
                    }
                    return;
                case 24008:
                    this.eJl.iX(false);
                    if (this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null && this.eIv.getPbData().aPL().sa() != null) {
                        this.eIv.getPbData().aPL().sa().setStatus(2);
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
            if (this.eJc != null) {
                this.eJc.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aQO() != null && aQK() != null && aQO().aTw() && com.baidu.tbadk.editortools.pb.a.Dw().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Dw().setStatus(0);
                    if (this.eJl != null) {
                        this.eJl.aTv();
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
            if (this.eJi == null) {
                this.eJi = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eJi.b(this.aEg);
                this.eJi.c(this.aEn);
            }
            this.eJi.a(emotionImageData, aQP(), aQP().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRc() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null && this.eIv.getPbData().aPL().rR() != null && this.eIv.getPbData().aPL().rR().size() > 0 && this.eIv.getPbData().aPL().rR().get(0) != null) {
            this.mAwardActId = this.eIv.getPbData().aPL().rR().get(0).pt();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.d(this.eIv.getPbData().getThreadId(), 0L));
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
                    this.eJl.aTH();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aRd() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bD = this.eIv.getPbData().bD(getPageContext().getPageActivity());
        PostData aTx = this.eJl.aTx();
        String str = "";
        if (aTx != null) {
            str = aTx.getId();
            String bO = aTx.bO(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bO)) {
                bD[1] = bO;
            }
        }
        String rW = this.eIv.getPbData().aPL().rW();
        if (rW != null && rW.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bD[1]);
        shareFromPBMsgData.setImageUrl(bD[0]);
        shareFromPBMsgData.setForumName(this.eIv.getPbData().aPJ().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eIv.getPbData().aPL().getId());
        shareFromPBMsgData.setTitle(this.eIv.getPbData().aPL().getTitle());
        return shareFromPBMsgData;
    }

    private void X(Intent intent) {
        b(aRd(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void b(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eIv != null && this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null) {
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
                    if (PbActivity.this.aQU() == 1) {
                        PbActivity.this.aRc();
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
            aVar.b(getPageContext()).ts();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                auVar.K(shareFromPBMsgData.getImageUrl(), this.eIv.getPbData().aPX() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eIv != null && this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null) {
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
                    if (PbActivity.this.aQU() == 1) {
                        PbActivity.this.aRc();
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
            aVar.b(getPageContext()).ts();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                auVar.K(shareFromPBMsgData.getImageUrl(), this.eIv.getPbData().aPX() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRe() {
        MarkData pp;
        if (this.ech != null && (pp = this.eIv.pp(this.eJl.aTT())) != null) {
            if (!pp.isApp() || (pp = this.eIv.pp(this.eJl.aTT() + 1)) != null) {
                this.eJl.aTO();
                this.ech.a(pp);
                if (!this.ech.nM()) {
                    this.ech.nO();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.ech.nN();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRf() {
        com.baidu.tieba.pb.data.f pbData = this.eIv.getPbData();
        this.eIv.jn(true);
        pbData.pp(this.ech.nL());
        this.eJl.m(pbData);
    }

    private boolean aRg() {
        if (this.eIv == null) {
            return true;
        }
        if (this.eIv.nM()) {
            final MarkData aSm = this.eIv.aSm();
            if (aSm == null || !this.eIv.getIsFromMark()) {
                return true;
            }
            final MarkData pp = this.eIv.pp(this.eJl.aTT());
            if (pp == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aSm);
                setResult(-1, intent);
                return true;
            } else if (pp.getPostId() == null || pp.getPostId().equals(aSm.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aSm);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cW(getPageContext().getString(d.l.alert_update_mark));
                aVar.a(d.l.alert_yes_btn, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.ech != null) {
                            if (PbActivity.this.ech.nM()) {
                                PbActivity.this.ech.nN();
                                PbActivity.this.ech.ac(false);
                            }
                            PbActivity.this.ech.a(pp);
                            PbActivity.this.ech.ac(true);
                            PbActivity.this.ech.nO();
                        }
                        aSm.setPostId(pp.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aSm);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aRb();
                    }
                });
                aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aSm);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aRb();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eJl != null && PbActivity.this.eJl.getView() != null) {
                            PbActivity.this.eJl.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aSm);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aRb();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.ts();
                return false;
            }
        } else if (this.eIv.getPbData() == null || this.eIv.getPbData().aPN() == null || this.eIv.getPbData().aPN().size() <= 0 || !this.eIv.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eJl == null) {
            return null;
        }
        return this.eJl.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        if (this.eJl == null) {
            return 0;
        }
        return this.eJl.aTY();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        if (this.aRv == null) {
            this.aRv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: TM */
                public ImageView fT() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean pe = com.baidu.tbadk.core.h.oY().pe();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ai.getDrawable(d.e.common_color_10220));
                    if (pe) {
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
                        if (com.baidu.tbadk.core.h.oY().pe()) {
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
        return this.aRv;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        if (this.aRw == null) {
            this.aRw = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aRw;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        if (this.aRA == null) {
            this.aRA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRB */
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
        return this.aRA;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        if (this.aRy == null) {
            this.aRy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: amB */
                public View fT() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.f.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: as */
                public void o(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: at */
                public View p(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: au */
                public View q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aRy;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aRx == null) {
            this.aRx = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 6);
        }
        return this.aRx;
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
        this.eIZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (av.pH(str) && this.eIv != null && this.eIv.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11664").r("obj_param1", 1).aa("post_id", this.eIv.getThreadID()));
        }
        av.aUv().f(getPageContext(), str);
        this.eIZ = true;
    }

    private com.baidu.tbadk.core.dialog.a aRh() {
        if (this.eIT == null) {
            this.eIT = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eIT.cV(getPageContext().getString(d.l.download_baidu_video_dialog));
            this.eIT.a(getPageContext().getString(d.l.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.dR()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.uJ());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.l.download_baidu_video));
                    }
                }
            });
            this.eIT.b(getPageContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eIT.ar(true);
            this.eIT.b(getPageContext());
            this.eIT.as(false);
        }
        this.eIT.ts();
        return this.eIT;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
        av.aUv().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eIZ = true;
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
            aRh();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eIZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eIv.getPbData();
            TbRichText ao = ao(str, i);
            if (ao != null && (tbRichTextData = ao.Io().get(this.eKm)) != null) {
                if (tbRichTextData.getType() == 20 || tbRichTextData.getType() == 17) {
                    bVar.eKW = true;
                    return;
                }
                bVar.eKS = new ArrayList<>();
                bVar.eKT = new ConcurrentHashMap<>();
                if (!tbRichTextData.It().IG()) {
                    bVar.eKV = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.eKS.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = ao.getPostId();
                    imageUrlData.mIsReserver = this.eIv.aSl();
                    imageUrlData.mIsSeeHost = this.eIv.getHostMode();
                    bVar.eKT.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aPJ() != null) {
                            bVar.forumName = pbData.aPJ().getName();
                            bVar.forumId = pbData.aPJ().getId();
                        }
                        if (pbData.aPL() != null) {
                            bVar.threadId = pbData.aPL().getId();
                        }
                        bVar.eKU = pbData.aPX() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bVar.threadId, -1L);
                    return;
                }
                bVar.eKV = true;
                int size = pbData.aPN().size();
                this.eKn = false;
                bVar.index = -1;
                if (pbData.aPS() != null) {
                    PostData aPS = pbData.aPS();
                    TbRichText aBr = aPS.aBr();
                    if (!ap.k(aPS)) {
                        i2 = a(aBr, ao, i, i, bVar.eKS, bVar.eKT);
                    } else {
                        i2 = a(aPS, i, bVar.eKS, bVar.eKT);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aPN().get(i4);
                    if (postData.getId() == null || pbData.aPS() == null || pbData.aPS().getId() == null || !postData.getId().equals(pbData.aPS().getId())) {
                        TbRichText aBr2 = postData.aBr();
                        if (!ap.k(postData)) {
                            i3 = a(aBr2, ao, i3, i, bVar.eKS, bVar.eKT);
                        } else {
                            i3 = a(postData, i3, bVar.eKS, bVar.eKT);
                        }
                    }
                }
                if (bVar.eKS.size() > 0) {
                    bVar.lastId = bVar.eKS.get(bVar.eKS.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aPJ() != null) {
                        bVar.forumName = pbData.aPJ().getName();
                        bVar.forumId = pbData.aPJ().getId();
                    }
                    if (pbData.aPL() != null) {
                        bVar.threadId = pbData.aPL().getId();
                    }
                    bVar.eKU = pbData.aPX() == 1;
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
            this.eKn = true;
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
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.eIv.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eIv.aSl();
                                imageUrlData.mIsSeeHost = this.eIv.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eKn) {
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
        com.baidu.tieba.tbadkCore.data.h bth;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bsE;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bsE = (bth = postData.bth()).bsE()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bsE.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bsE.get(i3);
                if (jVar != null) {
                    String bsJ = jVar.bsJ();
                    if (!com.baidu.tbadk.core.util.al.isEmpty(bsJ)) {
                        arrayList.add(bsJ);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bsJ;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bsI();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.eIv.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eIv.aSl();
                        imageUrlData.mIsSeeHost = this.eIv.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bth.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bsJ, imageUrlData);
                        }
                        if (!this.eKn) {
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
            if (postData.getId() != null && postData.getId().equals(this.eIv.rP())) {
                z = true;
            }
            MarkData j = this.eIv.j(postData);
            if (j != null) {
                this.eJl.aTO();
                if (this.ech != null) {
                    this.ech.a(j);
                    if (!z) {
                        this.ech.nO();
                    } else {
                        this.ech.nN();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ao(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eIv == null || this.eIv.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eIv.getPbData();
        if (pbData.aPS() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aPS());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            return a(pbData.aPN(), str, i);
        }
        return tbRichText;
    }

    private long pv(String str) {
        ArrayList<PostData> aPN;
        com.baidu.tieba.pb.data.f pbData = this.eIv.getPbData();
        if (pbData != null && (aPN = pbData.aPN()) != null && !aPN.isEmpty()) {
            Iterator<PostData> it = aPN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bth = next.bth();
                if (bth != null && bth.gjo) {
                    Iterator<TbRichTextData> it2 = next.aBr().Io().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.IC().getLink().equals(str)) {
                            return bth.getTemplateId();
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
            TbRichText aBr = arrayList.get(i2).aBr();
            if (aBr != null && (Io = aBr.Io()) != null) {
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
                            this.eKm = i4;
                            return aBr;
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
                                        this.eKm = i4;
                                        return aBr;
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
            this.eIt = str;
            if (this.eIS == null) {
                aQR();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eIS.cj(1).setVisibility(8);
            } else {
                this.eIS.cj(1).setVisibility(0);
            }
            this.eIS.tv();
            this.eIZ = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cjK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VY() {
        hideNetRefreshView(this.eJl.getView());
        aRi();
        if (this.eIv.Fw()) {
            this.eJl.aTO();
        }
    }

    private void aRi() {
        showLoadingView(this.eJl.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds400));
        View EQ = getLoadingView().EQ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EQ.getLayoutParams();
        layoutParams.addRule(3, this.eJl.aUi().getId());
        EQ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afE() {
        if (this.cjK != null) {
            this.cjK.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc(int i) {
        if (this.eIv.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eIv.getPbData();
            String name = pbData.aPJ().getName();
            String title = pbData.aPL().getTitle();
            int i2 = this.eIv.getHostMode() ? 1 : 0;
            boolean z = false;
            if (pbData != null && pbData.aPJ() != null) {
                if ((pbData.aPJ().isLike() == 1) && AddExperiencedModel.pS(pbData.getForumId())) {
                    z = true;
                }
            }
            String str = "http://tieba.baidu.com/p/" + this.eIv.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bD = pbData.bD(getPageContext().getPageActivity());
            String str2 = bD[0];
            if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str2 = str2.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bD[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aQU() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10399").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            } else if (aQU() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10406").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, name, str3);
            final com.baidu.tbadk.coreExtra.share.e eVar = new com.baidu.tbadk.coreExtra.share.e();
            eVar.title = title;
            eVar.content = format;
            eVar.linkUrl = str;
            eVar.ave = true;
            eVar.avh = z;
            eVar.extData = this.eIv.getThreadID();
            eVar.avo = 3;
            eVar.avn = i;
            eVar.fid = this.eIv.getForumId();
            if (parse != null) {
                eVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), eVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 23007)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10125").aa("tid", PbActivity.this.eIv.getThreadID()).r("obj_type", 1));
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aC(eVar.linkUrl);
                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private void aRj() {
        com.baidu.tbadk.util.u.a(new com.baidu.tbadk.util.t<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pT(PbActivity.this.eIv.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eJl.aUu();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        if (this.aRz == null) {
            this.aRz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aRC */
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
                /* renamed from: a */
                public void o(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public LinearLayout p(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout q(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.aRz;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eJl.aTI() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", this.eIv.getPbData().getForumId()));
            } else {
                bl aPL = this.eIv.getPbData().aPL();
                if (view != null) {
                    boolean z = aPL.rw() == null || aPL.rw().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eJW > 1000) {
                            this.eJX = true;
                            bd(view);
                        } else {
                            this.eJX = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            k(view, this.eJX);
                        } else {
                            j(view, this.eJX);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        j(view, this.eJX);
                    } else if (motionEvent.getAction() == 3) {
                        j(view, this.eJX);
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
                    PbActivity.this.eJW = System.currentTimeMillis();
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
                    PbActivity.this.eJW = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bd(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    public void afF() {
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
        } else if (aVar.tu() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tu();
            int intValue = ((Integer) sparseArray.get(aq.eRZ)).intValue();
            if (intValue == aq.eSa) {
                if (!this.eJk.btL()) {
                    this.eJl.aTL();
                    int intValue2 = ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue();
                    this.eJk.a(this.eIv.getPbData().aPJ().getId(), this.eIv.getPbData().aPJ().getName(), this.eIv.getPbData().aPL().getId(), (String) sparseArray.get(d.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == aq.eSb || intValue == aq.eSd) {
                if (this.eIv.aSy() != null) {
                    this.eIv.aSy().pg(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.eSb) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == aq.eSc) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eKs).po()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eJE);
        userMuteAddAndDelCustomMessage.setTag(this.eJE);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pw(String str) {
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
        this.eJv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aRk() {
        ArrayList<PostData> aPN;
        int u;
        if (this.eIv == null || this.eIv.getPbData() == null || this.eIv.getPbData().aPN() == null || (u = com.baidu.tbadk.core.util.u.u((aPN = this.eIv.getPbData().aPN()))) == 0) {
            return "";
        }
        if (this.eIv.aSl()) {
            Iterator<PostData> it = aPN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bsZ() == 1) {
                    return next.getId();
                }
            }
        }
        int aTS = this.eJl.aTS();
        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(aPN, aTS);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eIv.pA(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aTS - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.u.c(aPN, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eIv.pA(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aTS + 1; i2 < u; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.u.c(aPN, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eIv.pA(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.at.wg().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(pv(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eIv.getPbData().aPJ().getId(), this.eIv.getPbData().aPJ().getName(), this.eIv.getPbData().aPL().getTid());
            }
            this.eIZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cW(getResources().getString(d.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cW(getResources().getString(d.l.make_sure_hide));
        }
        aVar.a(getResources().getString(d.l.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eIv.aSx() != null) {
                    PbActivity.this.eIv.aSx().cu(j);
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
        aVar.ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b px(String str) {
        String str2;
        if (this.eIv.getPbData() == null || this.eIv.getPbData().aPN() == null || this.eIv.getPbData().aPN().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i >= this.eIv.getPbData().aPN().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eIv.getPbData().aPN().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eIv.getPbData().aPN().get(i);
        if (postData.aBr() == null || postData.aBr().Io() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aBr().Io().iterator();
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
        if (this.eIO) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eIO = false;
        } else if (aRl()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eIO) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eIO = false;
        } else if (aRl()) {
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
        if (pageStayDurationItem != null && this.eIv != null) {
            if (this.eIv.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.eIv.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.eIv.getThreadID(), 0L));
            if (this.eJa) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aRl() {
        return (!this.eIM && this.eKu == -1 && this.eKv == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eKx = nVar;
            this.eIM = true;
            this.eJl.aTz();
            this.eJl.pF(this.eKw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRm() {
        if (this.eKx != null) {
            if (this.eKu == -1) {
                showToast(d.l.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aN(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eKx.getCartoonId(), this.eKu, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRn() {
        if (this.eKx != null) {
            if (this.eKv == -1) {
                showToast(d.l.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aN(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eKx.getCartoonId(), this.eKv, 0)));
                finish();
            }
        }
    }

    public int aRo() {
        return this.eKu;
    }

    public int aRp() {
        return this.eKv;
    }

    private void aqk() {
        if (this.eIv != null && this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null && this.eIv.getPbData().aPL().st()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aRq() {
        if (this.eIv != null && this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null && this.eIv.getPbData().aPL().st()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aRr() {
        if (this.eIP) {
            this.eJh = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null && this.eIv.getPbData().aPL().ro() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eIv.getPbData().aPL().ro().getThreadId(), this.eIv.getPbData().aPL().ro().getTaskId(), this.eIv.getPbData().aPL().ro().getForumId(), this.eIv.getPbData().aPL().ro().getForumName(), this.eIv.getPbData().aPL().rB(), this.eIv.getPbData().aPL().rC())));
            this.eIO = true;
            finish();
        }
    }

    public boolean aRs() {
        return this.eIP;
    }

    public String aRt() {
        return this.eJf;
    }

    public PbInterviewStatusView.a aRu() {
        return this.eJj;
    }

    public void jd(boolean z) {
        this.eJg = z;
    }

    public boolean aRv() {
        if (this.eIv != null) {
            return this.eIv.aSb();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cW(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eJC).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eJC.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eJC).ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eJC != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eJC.getPageActivity());
            aVar.cW(str);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eJC).ts();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eJl.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eJC.getPageActivity());
        if (com.baidu.tbadk.core.util.al.isEmpty(str)) {
            aVar.cW(this.eJC.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cW(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eJl.showLoadingDialog();
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
        aVar.b(this.eJC).ts();
    }

    public void aRx() {
        if (this.eIv != null && this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null && this.eIv.getPbData().aPL().sK() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cc(d.l.channel_open_push_message);
            aVar.a(d.l.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eIv.getPbData().aPL().sK().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.ts();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.pH(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_pb_wenxue)) != null) {
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
            this.eJe = true;
        } else {
            this.eJe = false;
        }
        if (this.eJl != null) {
            this.eJl.onConfigurationChanged(configuration);
        }
        if (this.eJq != null) {
            this.eJq.dismiss();
        }
    }

    public boolean aRy() {
        if (this.eIv != null) {
            return this.eIv.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.eIv.getPbData().aPV().eGK;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bsW().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bsW().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bsW().remove(i2);
                    list.get(i).bsY();
                    z = true;
                    break;
                }
            }
            list.get(i).si(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.eIv.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.n nVar) {
        String id = nVar.aQt().getId();
        List<PostData> list = this.eIv.getPbData().aPV().eGK;
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
                ArrayList<PostData> aQx = nVar.aQx();
                postData.tr(nVar.getTotalCount());
                if (postData.bsW() != null) {
                    postData.bsW().clear();
                    postData.bsW().addAll(aQx);
                }
            }
        }
        this.eJl.m(this.eIv.getPbData());
    }

    public boolean aRz() {
        boolean z = true;
        if (this.eIv == null) {
            return false;
        }
        switch (this.eIv.aSG()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eIv.getPbData() != null && this.eIv.getPbData().aPL() != null && this.eIv.getPbData().aPL().sS() && StringUtils.isNull(this.eIv.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aRA() {
        if (this.eJl != null) {
            this.eJl.aTs();
            afF();
        }
    }

    public PostData aPS() {
        return this.eJl.c(this.eIv.eMZ, this.eIv.aSa());
    }
}
