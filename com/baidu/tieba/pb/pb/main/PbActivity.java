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
    private com.baidu.adp.lib.e.b<ImageView> aQg;
    private com.baidu.adp.lib.e.b<TextView> aQh;
    private com.baidu.adp.lib.e.b<View> aQi;
    private com.baidu.adp.lib.e.b<View> aQj;
    private com.baidu.adp.lib.e.b<LinearLayout> aQk;
    private com.baidu.adp.lib.e.b<GifView> aQl;
    private com.baidu.adp.lib.e.b<TbImageView> aog;
    private VoiceManager chP;
    private com.baidu.tbadk.i.a cik;
    private com.baidu.tieba.e.b ckS;
    private com.baidu.tieba.pb.pb.main.a.b eFE;
    private com.baidu.tbadk.core.dialog.a eFK;
    private boolean eFR;
    private com.baidu.tieba.pb.pb.main.b eFT;
    private com.baidu.tieba.pb.pb.main.emotion.model.d eFZ;
    private String eFk;
    private String eGA;
    private TbRichTextMemeInfo eGB;
    private v eGh;
    private boolean eGm;
    private com.baidu.tieba.tbadkCore.data.e eGp;
    private com.baidu.tbadk.editortools.pb.c eGq;
    private com.baidu.adp.base.e eGt;
    private com.baidu.tbadk.core.view.c eGu;
    private BdUniqueId eGv;
    private Runnable eGw;
    private at eGy;
    private com.baidu.adp.widget.a.a eGz;
    private boolean eHb;
    private String eHn;
    private com.baidu.tbadk.core.data.n eHo;
    private long mAwardActId;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private boolean eFD = false;
    private boolean eFF = false;
    private boolean eFG = false;
    private boolean ecI = false;
    private boolean eFH = true;
    private int eFI = 0;
    private com.baidu.tbadk.core.dialog.b eFJ = null;
    private long bXv = -1;
    private long aIT = 0;
    private long eFL = 0;
    private long createTime = 0;
    private long aIL = 0;
    private boolean eFM = false;
    private com.baidu.tbadk.l.d eFN = null;
    private long eFO = 0;
    private boolean eFP = false;
    private boolean eFQ = false;
    private long eFS = 0;
    private String aCJ = null;
    private boolean eFU = false;
    private boolean eFV = false;
    private String eFW = "";
    private boolean eFX = true;
    private boolean eFY = false;
    private String source = "";
    private PbInterviewStatusView.a eGa = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void p(boolean z) {
            PbActivity.this.eGc.jE(!PbActivity.this.eFX);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.eFm != null && PbActivity.this.eFm.nB()) {
                        PbActivity.this.aQs();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel eFm = null;
    private com.baidu.tbadk.baseEditMark.a dYU = null;
    private ForumManageModel eGb = null;
    private aq eGc = null;
    public final com.baidu.tieba.pb.pb.main.a.a eGd = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean eGe = false;
    private boolean eGf = false;
    private boolean eGg = false;
    private boolean eGi = false;
    private boolean eGj = false;
    private boolean eGk = false;
    private boolean eGl = false;
    private boolean eGn = false;
    private boolean eGo = false;
    private boolean eGr = false;
    private com.baidu.tbadk.editortools.pb.b aCO = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tbadk.editortools.pb.b
        public void Dp() {
            PbActivity.this.showProgressBar();
        }
    };
    private boolean eGs = false;
    private int mLastScrollState = -1;
    private int eGx = 4;
    private boolean cix = false;
    private int eGC = -1;
    private final w.a eGD = new w.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void B(List<PostData> list) {
            if (PbActivity.this.eFm.getPbData().aPi() != null) {
                List<PostData> list2 = PbActivity.this.eFm.getPbData().aPi().eDB;
                int size = list2.size();
                if (!com.baidu.tbadk.core.util.u.v(list2)) {
                    PbActivity.this.eFm.getPbData().aPi().eDB.addAll(size, list);
                }
                PbActivity.this.eFm.a(PbActivity.this.eFm.getPbData(), size);
            }
            PbActivity.this.eGc.aSW().a(PbActivity.this.eFm.getPbData(), true);
            if (PbActivity.this.eGc != null && PbActivity.this.eGc.aSW() != null) {
                PbActivity.this.eGc.aSW().notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.w.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.eGc.showToast(str);
            }
        }
    };
    private final CustomMessageListener eGE = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eFm != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.eGq != null) {
                    PbActivity.this.eGc.hh(PbActivity.this.eGq.Dy());
                }
                PbActivity.this.eGc.aSI();
                PbActivity.this.eGq.DB();
                PbActivity.this.eGc.aAZ();
            }
        }
    };
    CustomMessageListener ciK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.eFm.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.eGc != null && PbActivity.this.eFm != null) {
                    PbActivity.this.eGc.d(PbActivity.this.eFm.getPbData(), PbActivity.this.eFm.aRn(), PbActivity.this.eFm.aRD());
                }
                if (PbActivity.this.eGc != null && PbActivity.this.eGc.aSW() != null) {
                    PbActivity.this.eGc.aSW().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eGF = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.eGc != null) {
                    if (booleanValue) {
                        PbActivity.this.eGc.avD();
                    } else {
                        PbActivity.this.eGc.avC();
                    }
                }
            }
        }
    };
    private CustomMessageListener dHI = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.eGq != null) {
                    PbActivity.this.eGc.hh(PbActivity.this.eGq.Dy());
                }
                PbActivity.this.eGc.hi(false);
            }
        }
    };
    private CustomMessageListener dIe = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
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
    private CustomMessageListener eGG = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eGc != null && PbActivity.this.eGc.aSW() != null) {
                PbActivity.this.eGc.aSW().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener dgZ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private i.a eGH = new i.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        @Override // com.baidu.tieba.pb.pb.main.i.a
        public void i(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.oR(2);
                ai.aSy().reset();
                PbActivity.this.eFm.aRE();
                boolean z2 = false;
                ArrayList<PostData> aPa = PbActivity.this.eFm.getPbData().aPa();
                if (aPa != null) {
                    Iterator<PostData> it = aPa.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.k(next) && next.bsz().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.eGc.m(PbActivity.this.eFm.getPbData());
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
    private View.OnClickListener dHH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aCJ);
        }
    };
    CustomMessageListener cRl = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_ACT_DIALOG) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof CustomDialogData)) {
                com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), (CustomDialogData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eGI = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                as.a aVar = new as.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.VC = abVar.VC;
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eFm.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.eFm.aRu() != null && PbActivity.this.eFm.aRu().getUserIdLong() == abVar.toUserId) {
                        PbActivity.this.eGc.a(abVar.sendCount, PbActivity.this.eFm.getPbData(), PbActivity.this.eFm.aRn(), PbActivity.this.eFm.aRD());
                    }
                    if (pbData.aPa() != null && pbData.aPa().size() >= 1 && pbData.aPa().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aPa().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.eFm.getThreadID(), 0L);
                        if (c2 == abVar.postId && c3 == abVar.threadId) {
                            com.baidu.tbadk.core.data.as bsy = pbData.aPa().get(0).bsy();
                            if (bsy == null) {
                                bsy = new com.baidu.tbadk.core.data.as();
                            }
                            ArrayList<as.a> qw = bsy.qw();
                            if (qw == null) {
                                qw = new ArrayList<>();
                            }
                            qw.add(0, aVar);
                            bsy.bL(abVar.sendCount + bsy.qv());
                            bsy.g(qw);
                            pbData.aPa().get(0).a(bsy);
                            PbActivity.this.eGc.aSW().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a eGJ = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null && aVar.acs() != null && !aVar.acs().isEmpty()) {
                PbActivity.this.eGc.a(aVar, PbActivity.this.eGK);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a eGK = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                aw.aN(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.fJ().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9.1
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
    private boolean eGL = false;
    private PraiseModel eGM = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void hJ(String str) {
            PbActivity.this.eGL = false;
            if (PbActivity.this.eGM != null) {
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eFm.getPbData();
                if (pbData.aOY().rl().getIsLike() == 1) {
                    PbActivity.this.iY(0);
                } else {
                    PbActivity.this.iY(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aOY()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void A(int i, String str) {
            PbActivity.this.eGL = false;
            if (PbActivity.this.eGM != null && str != null) {
                if (AntiHelper.tn(i)) {
                    AntiHelper.ar(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long eGN = 0;
    private boolean eGO = true;
    private b.a eGP = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void ep(boolean z) {
            PbActivity.this.ja(z);
            if (PbActivity.this.eGc.aTu() != null && z) {
                PbActivity.this.eGc.jE(false);
            }
        }
    };
    private CustomMessageListener bfA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().CB) {
                        PbActivity.this.b(updateAttentionMessage);
                        if (PbActivity.this.aPf().getAuthor() != null && PbActivity.this.aPf().getAuthor().getGodUserData() != null) {
                            PbActivity.this.aPf().getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        PbActivity.this.c(updateAttentionMessage);
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        PbActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bnG = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.eGc.QT();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.oS(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.alJ();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.l.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private CustomMessageListener eGQ = new CustomMessageListener(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && ((BdUniqueId) customResponsedMessage.getData()).getId() != PbActivity.this.getUniqueId().getId()) {
                PbActivity.this.eGi = false;
            }
        }
    };
    private com.baidu.tieba.pb.a.c aQB = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.eGc.aSJ()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && ((PbActivity.this.eFm == null || PbActivity.this.eFm.getPbData() == null || !com.baidu.tieba.pb.f.T(PbActivity.this.eFm.getPbData().aOY())) && PbActivity.this.eFm != null && (PbActivity.this.eFm.getPbData() != null || PbActivity.this.eFm.getPbData().aPv() != null))) {
                    if (PbActivity.this.eFm.getPbData().aPv().aPB()) {
                        if (PbActivity.this.eFm.getPbData().aPv().eDn == 1 || PbActivity.this.eFm.getPbData().aPv().eDn == 3 || PbActivity.this.eFm.getPbData().aPv().eDn == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, true);
                            TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eFm.getPbData().aPv().aPB() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), 2, false);
                        TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eFm.getPbData().aPv().aPB() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eFS > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).startAnimation(false);
                        PbActivity.this.eFS = System.currentTimeMillis();
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
                    if (PbActivity.this.aZ(view)) {
                        return true;
                    }
                } else if (view.getId() == d.h.pb_floor_item_layout) {
                    if (view.getTag(d.h.tag_from) instanceof SparseArray) {
                        PbActivity.this.e((SparseArray) view.getTag(d.h.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.h.pb_post_header_layout) {
                    if (PbActivity.this.eGc != null && PbActivity.this.eGc.aQd() && (view.getId() == d.h.pb_head_user_info_root || view == PbActivity.this.eGc.aTC())) {
                        if (view.getTag(d.h.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10630").aa("obj_id", (String) view.getTag(d.h.tag_user_id)));
                        }
                        if (PbActivity.this.eGd != null && PbActivity.this.eGd.eSy != null) {
                            PbActivity.this.eGd.eSy.onClick(view);
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
            if (PbActivity.this.eGq != null) {
                PbActivity.this.eGc.hh(PbActivity.this.eGq.Dy());
            }
            PbActivity.this.eGc.aSI();
            PbActivity.this.eGq.DB();
            PbActivity.this.eGc.aAZ();
            return true;
        }
    });
    private CustomMessageListener eGR = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eGv) {
                PbActivity.this.eGc.QT();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbActivity.this.eFm.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aPl().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eGu.c(PbActivity.this.eGt.getResources().getString(d.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.eGt.getResources().getString(d.l.mute_error_beyond_limit);
                    }
                    PbActivity.this.fW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.aQJ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.al.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.eGt.getResources().getString(d.l.mute_fail);
                    }
                    PbActivity.this.eGu.d(errorString2);
                }
            }
        }
    };
    private CustomMessageListener eGS = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eGv) {
                PbActivity.this.eGc.QT();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.eGu.c(PbActivity.this.eGt.getResources().getString(d.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.al.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.eGt.getResources().getString(d.l.un_mute_fail);
                }
                PbActivity.this.eGu.d(muteMessage);
            }
        }
    };
    private CustomMessageListener eGT = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.eGv) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.eGc.QT();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gtw;
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
                    PbActivity.this.eGc.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener eGU = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.eGc.aSJ() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.aQc() != null && PbActivity.this.aQc().getPbData() != null && PbActivity.this.aQc().getPbData().aPv() != null && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.T(PbActivity.this.aQc().getPbData().aOY())) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aPB = PbActivity.this.aQc().getPbData().aPv().aPB();
                if (intValue < 10) {
                    if (aPB) {
                        if (PbActivity.this.eFm.getPbData().aPv().eDn == 1 || PbActivity.this.eFm.getPbData().aPv().eDn == 3 || PbActivity.this.eFm.getPbData().aPv().eDn == 4) {
                            PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, true);
                            TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", PbActivity.this.eFm.getPbData().aPv().aPB() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue, false);
                        TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r("obj_id", aPB ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.eFS > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).startAnimation(false);
                        PbActivity.this.eFS = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.f(PbActivity.this.findViewById(d.h.view_main_thread_praise_state), intValue / 11, aPB);
                TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r("obj_id", aPB ? 0 : 1));
            }
        }
    };
    private CustomMessageListener ciV = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.cix = true;
                }
            }
        }
    };
    public a.b emX = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.afk();
            com.baidu.tbadk.core.data.ar aqb = PbActivity.this.eFm.aqb();
            int pageNum = PbActivity.this.eGc.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.l.pb_page_error);
            } else if (aqb == null || pageNum <= aqb.qo()) {
                PbActivity.this.eGc.aAZ();
                PbActivity.this.oR(2);
                PbActivity.this.afj();
                PbActivity.this.eGc.aTb();
                if (com.baidu.adp.lib.util.i.hh()) {
                    PbActivity.this.eFm.oY(PbActivity.this.eGc.getPageNum());
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(d.l.pb_page_error);
            }
        }
    };
    public final View.OnClickListener cjs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
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
            com.baidu.tieba.pb.data.m aPv;
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
                    if ((PbActivity.this.eGc.eMZ.aUw() != null && PbActivity.this.eGc.eMZ.aUw().be(view)) || PbActivity.this.eGc.aSV() == view || view.getId() == d.h.pb_item_tail_content) {
                        if (PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && com.baidu.tieba.pb.f.T(PbActivity.this.eFm.getPbData().aOY())) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (view == PbActivity.this.eGc.getNextView()) {
                        if (!PbActivity.this.mIsLoading && PbActivity.this.eFm.jh(true)) {
                            PbActivity.this.mIsLoading = true;
                            PbActivity.this.eGc.aTc();
                        }
                    } else if (view == PbActivity.this.eGc.aSN()) {
                        PbActivity.this.eGc.aST();
                        if (!UtilHelper.isFloatWindowOpAllowed(PbActivity.this.getPageContext().getPageActivity())) {
                            PbActivity.this.PN();
                            return;
                        }
                        PbActivity.this.eGi = true;
                        PbActivity.this.a(PbActivity.this.eFm.getPbData(), 0, 1, true, true);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10830").aa("tid", PbActivity.this.eFm.getThreadID()));
                        PbActivity.this.eGc.aAZ();
                    } else if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSl()) {
                        if (view == PbActivity.this.eGc.eMZ.aKL) {
                            if (PbActivity.this.eGc.jI(PbActivity.this.eFm.aRr())) {
                                PbActivity.this.afj();
                                return;
                            }
                            PbActivity.this.eFH = false;
                            PbActivity.this.eFF = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.eGc.aSZ() && (PbActivity.this.eGc.eMZ.aUw() == null || (view != PbActivity.this.eGc.eMZ.aUw().aSk() && view != PbActivity.this.eGc.eMZ.aUw().aSi()))) {
                            if (view == PbActivity.this.eGc.aTo()) {
                                if (PbActivity.this.eFm != null) {
                                    com.baidu.tbadk.browser.a.T(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eFm.getPbData().aOY().ru().getLink());
                                }
                            } else if (view != PbActivity.this.eGc.eMZ.eTh) {
                                if (view == PbActivity.this.eGc.eMZ.eTj) {
                                    if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null) {
                                        ArrayList<PostData> aPa = PbActivity.this.eFm.getPbData().aPa();
                                        if ((aPa != null && aPa.size() > 0) || !PbActivity.this.eFm.aRn()) {
                                            if (!PbActivity.this.eGc.aTD()) {
                                                PbActivity.this.eGc.aSI();
                                            }
                                            PbActivity.this.aQj();
                                            return;
                                        }
                                        com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                        return;
                                    }
                                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.l.pb_no_data_tips));
                                } else if (view != PbActivity.this.eGc.eMZ.eTi && view.getId() != d.h.pb_god_user_tip_content) {
                                    if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aRU()) {
                                        if ((PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSh()) && view.getId() != d.h.floor_owner_reply && view.getId() != d.h.reply_title) {
                                            if (PbActivity.this.eGc.eMZ.aUw() == null || (view != PbActivity.this.eGc.eMZ.aUw().getCancelView() && view != PbActivity.this.eGc.eMZ.aUw().Vp())) {
                                                if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSn()) {
                                                    if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSc()) {
                                                        if ((PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSd()) && view.getId() != d.h.pb_sort) {
                                                            if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSe()) {
                                                                if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSf()) {
                                                                    if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSg()) {
                                                                        if (PbActivity.this.eGh == null || view != PbActivity.this.eGh.aRW()) {
                                                                            if (PbActivity.this.eGh == null || view != PbActivity.this.eGh.aRU()) {
                                                                                if (PbActivity.this.eGh == null || view != PbActivity.this.eGh.aRZ()) {
                                                                                    if (PbActivity.this.eGh == null || view != PbActivity.this.eGh.aRX()) {
                                                                                        if (PbActivity.this.eGh == null || view != PbActivity.this.eGh.aRY()) {
                                                                                            if (PbActivity.this.eGc.aTu() == view) {
                                                                                                if (PbActivity.this.eGc.aTu().getIndicateStatus()) {
                                                                                                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eFm.getPbData();
                                                                                                    if (pbData != null && pbData.aOY() != null && pbData.aOY().rd() != null) {
                                                                                                        String px = pbData.aOY().rd().px();
                                                                                                        if (StringUtils.isNull(px)) {
                                                                                                            px = pbData.aOY().rd().getTaskId();
                                                                                                        }
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11107").aa("obj_id", px));
                                                                                                    }
                                                                                                } else {
                                                                                                    com.baidu.tieba.tbadkCore.d.a.cg("c10725", null);
                                                                                                }
                                                                                                PbActivity.this.aQE();
                                                                                                return;
                                                                                            } else if (PbActivity.this.eGc.aSV() != view) {
                                                                                                if (PbActivity.this.eGh == null || view != PbActivity.this.eGh.aRV()) {
                                                                                                    if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSm()) {
                                                                                                        if (PbActivity.this.eGc.eMZ.aUw() != null && view == PbActivity.this.eGc.eMZ.aUw().aSj()) {
                                                                                                            if (com.baidu.adp.lib.util.i.hh()) {
                                                                                                                SparseArray<Object> c2 = PbActivity.this.eGc.c(PbActivity.this.eFm.getPbData(), PbActivity.this.eFm.aRn(), 1);
                                                                                                                if (c2 != null) {
                                                                                                                    PbActivity.this.eGc.a(((Integer) c2.get(d.h.tag_del_post_type)).intValue(), (String) c2.get(d.h.tag_del_post_id), ((Integer) c2.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.h.tag_del_post_is_self)).booleanValue());
                                                                                                                }
                                                                                                                PbActivity.this.eGc.eMZ.og();
                                                                                                                return;
                                                                                                            }
                                                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                                                            return;
                                                                                                        } else if (view.getId() != d.h.sub_pb_more && view.getId() != d.h.sub_pb_item && view.getId() != d.h.pb_floor_reply_more) {
                                                                                                            if (view != PbActivity.this.eGc.aPW()) {
                                                                                                                if (view == PbActivity.this.eGc.eMZ.aUx()) {
                                                                                                                    PbActivity.this.eGc.aTh();
                                                                                                                    return;
                                                                                                                }
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.h.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (bpVar = (bp) view.getTag()) != null && !StringUtils.isNull(bpVar.sW())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        com.baidu.tbadk.core.util.at.vV().c(PbActivity.this.getPageContext(), new String[]{bpVar.sW()});
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if ((id == d.h.pb_floor_agree || id == d.h.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData ba = PbActivity.this.ba(view);
                                                                                                                    if (ba != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r("obj_id", ba.bsE() ? 0 : 1));
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.view_main_thread_praise_state) {
                                                                                                                    PbActivity.this.f(view, 2, false);
                                                                                                                    if (PbActivity.this.aQc() != null && PbActivity.this.aQc().getPbData() != null && PbActivity.this.aQc().getPbData().aPv() != null && PbActivity.this.aQc().getPbData().aPv() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r("obj_id", PbActivity.this.aQc().getPbData().aPv().aPB() ? 0 : 1));
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.view_main_thread_praise_num || id == d.h.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && !StringUtils.isNull(PbActivity.this.eFm.getPbData().getThreadId()) && (aPv = PbActivity.this.eFm.getPbData().aPv()) != null && aPv.getPraiseNum() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.at.vV().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.eFm.getPbData().getThreadId()});
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
                                                                                                                                if (PbActivity.this.eGh == null) {
                                                                                                                                    PbActivity.this.eGh = new v(PbActivity.this.getPageContext(), PbActivity.this.cjs);
                                                                                                                                    PbActivity.this.eGh.jm(PbActivity.this.mIsLogin);
                                                                                                                                }
                                                                                                                                PbActivity.this.eGh.showDialog();
                                                                                                                                boolean z6 = id == d.h.replybtn_top_right || id == d.h.cover_reply_content_top_right;
                                                                                                                                if (z6) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12006").aa("tid", PbActivity.this.eFm.eJA));
                                                                                                                                }
                                                                                                                                SparseArray sparseArray2 = new SparseArray();
                                                                                                                                sparseArray2.put(d.h.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.h.tag_clip_board));
                                                                                                                                sparseArray2.put(d.h.tag_is_subpb, false);
                                                                                                                                PbActivity.this.eGh.aRU().setTag(sparseArray2);
                                                                                                                                PbActivity.this.eGh.aRZ().setTag(view.getTag());
                                                                                                                                PbActivity.this.eGh.jo(z6);
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
                                                                                                                                        PbActivity.this.eGh.aRX().setVisibility(0);
                                                                                                                                    } else {
                                                                                                                                        sparseArray4.put(d.h.tag_should_delete_visible, false);
                                                                                                                                        PbActivity.this.eGh.aRX().setVisibility(8);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.eGh.aRV().setTag(sparseArray4);
                                                                                                                                    PbActivity.this.eGh.aRX().setTag(sparseArray4);
                                                                                                                                    PbActivity.this.eGh.aRV().setText(d.l.bar_manager);
                                                                                                                                    PbActivity.this.eGh.aRV().setVisibility(0);
                                                                                                                                } else if (!booleanValue3) {
                                                                                                                                    PbActivity.this.eGh.aRV().setVisibility(8);
                                                                                                                                    PbActivity.this.eGh.aRX().setVisibility(8);
                                                                                                                                } else {
                                                                                                                                    SparseArray sparseArray5 = new SparseArray();
                                                                                                                                    sparseArray5.put(d.h.tag_should_manage_visible, false);
                                                                                                                                    sparseArray5.put(d.h.tag_user_mute_visible, false);
                                                                                                                                    sparseArray5.put(d.h.tag_should_delete_visible, true);
                                                                                                                                    sparseArray5.put(d.h.tag_manage_user_identity, sparseArray3.get(d.h.tag_manage_user_identity));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_id, sparseArray3.get(d.h.tag_del_post_id));
                                                                                                                                    sparseArray5.put(d.h.tag_del_post_type, sparseArray3.get(d.h.tag_del_post_type));
                                                                                                                                    PbActivity.this.eGh.aRV().setTag(sparseArray5);
                                                                                                                                    PbActivity.this.eGh.aRX().setTag(sparseArray5);
                                                                                                                                    PbActivity.this.eGh.aRV().setText(d.l.delete);
                                                                                                                                    PbActivity.this.eGh.aRX().setVisibility(0);
                                                                                                                                    PbActivity.this.eGh.aRV().setVisibility(8);
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
                                                                                                                                    PbActivity.this.eGh.aRW().setTag(sparseArray7);
                                                                                                                                    PbActivity.this.eGh.aRW().setVisibility(0);
                                                                                                                                    PbActivity.this.eGh.aRV().setVisibility(8);
                                                                                                                                    PbActivity.this.eGh.aRW().setText(d.l.mute_option);
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
                                                                                                                                    boolean iW = PbActivity.this.iW(z4) & PbActivity.this.isLogin();
                                                                                                                                    PbActivity.this.eHf = (PostData) sparseArray6.get(d.h.tag_clip_board);
                                                                                                                                    if (ap.k(PbActivity.this.eHf) ? false : iW) {
                                                                                                                                        PbActivity.this.eGh.aRW().setVisibility(0);
                                                                                                                                        PbActivity.this.eGh.aRW().setTag(str3);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.eGh.aRW().setVisibility(8);
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
                                                                                                                                    PbActivity.this.eGh.aRY().setVisibility(0);
                                                                                                                                    PbActivity.this.eGh.aRY().setTag(d.h.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                    PbActivity.this.eGh.aRY().setTag(d.h.tag_chudian_monitor_id, str);
                                                                                                                                    PbActivity.this.eGh.aRY().setTag(d.h.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eGh.aRY().setVisibility(8);
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.eFm.getPbData().nB()) {
                                                                                                                            String nA = PbActivity.this.eFm.getPbData().nA();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.j.isEmpty(nA) && nA.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.eGh.aRU().setText(d.l.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.eGh.aRU().setText(d.l.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.eGh.jn(true);
                                                                                                                                PbActivity.this.eGh.refreshUI();
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.eGh.jn(true);
                                                                                                                        PbActivity.this.eGh.refreshUI();
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.pb_act_btn) {
                                                                                                                    if (PbActivity.this.eFm.getPbData() != null && PbActivity.this.eFm.getPbData().aOY() != null && PbActivity.this.eFm.getPbData().aOY().sb() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), PbActivity.this.eFm.getPbData().aOY().sb());
                                                                                                                        if (PbActivity.this.eFm.getPbData().aOY().rZ() != 1) {
                                                                                                                            if (PbActivity.this.eFm.getPbData().aOY().rZ() == 2) {
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
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10912").aa("fid", PbActivity.this.eFm.getPbData().getForumId()).aa("tid", PbActivity.this.eFm.getPbData().getThreadId()).aa("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.eFm.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.eGc.setSelection(0);
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.pb_item_tail_content) {
                                                                                                                    if (aw.aN(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.l.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.eGc.aSI();
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.T(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.aQh() == 1) {
                                                                                                                            if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10397").aa("fid", PbActivity.this.eFm.getPbData().getForumId()).aa("tid", PbActivity.this.eFm.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else if (PbActivity.this.aQh() == 2 && PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10401").aa("fid", PbActivity.this.eFm.getPbData().getForumId()).aa("tid", PbActivity.this.eFm.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
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
                                                                                                                            if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10507").aa("fid", PbActivity.this.eFm.getPbData().getForumId()).aa("tid", PbActivity.this.eFm.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else if (PbActivity.this.aQh() == 2 && PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10508").aa("fid", PbActivity.this.eFm.getPbData().getForumId()).aa("tid", PbActivity.this.eFm.getPbData().getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount2));
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.manga_prev_btn) {
                                                                                                                    PbActivity.this.aQz();
                                                                                                                    return;
                                                                                                                } else if (id == d.h.manga_next_btn) {
                                                                                                                    PbActivity.this.aQA();
                                                                                                                    return;
                                                                                                                } else if (id == d.h.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && PbActivity.this.eFm.getPbData().aPq() != null) {
                                                                                                                        com.baidu.tieba.pb.data.f pbData2 = PbActivity.this.eFm.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11679").aa("fid", pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.at.vV().c(PbActivity.this.getPageContext(), new String[]{pbData2.aPq().aPx()});
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    return;
                                                                                                                } else if (id == d.h.yule_head_img_all_rank && PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && PbActivity.this.eFm.getPbData().aPq() != null) {
                                                                                                                    com.baidu.tieba.pb.data.f pbData3 = PbActivity.this.eFm.getPbData();
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11678").aa("fid", pbData3.getForumId()));
                                                                                                                    com.baidu.tbadk.core.util.at.vV().c(PbActivity.this.getPageContext(), new String[]{pbData3.aPq().aPx()});
                                                                                                                    return;
                                                                                                                } else {
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.eFm.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.eFm.getThreadID(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.eFm.getPbData().aOY().rP())));
                                                                                                                return;
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                            if (PbActivity.this.eFm.getPbData() != null) {
                                                                                                                PbActivity.this.eGc.aAZ();
                                                                                                                SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                PostData postData3 = (PostData) sparseArray9.get(d.h.tag_load_sub_data);
                                                                                                                View view2 = (View) sparseArray9.get(d.h.tag_load_sub_view);
                                                                                                                if (postData3 != null && view2 != null) {
                                                                                                                    String threadID = PbActivity.this.eFm.getThreadID();
                                                                                                                    String id2 = postData3.getId();
                                                                                                                    int i3 = 0;
                                                                                                                    if (PbActivity.this.eFm.getPbData() != null) {
                                                                                                                        i3 = PbActivity.this.eFm.getPbData().aPj();
                                                                                                                    }
                                                                                                                    if (!com.baidu.tieba.pb.f.d(postData3)) {
                                                                                                                        PbActivity.this.afj();
                                                                                                                        if (view.getId() == d.h.replybtn) {
                                                                                                                            b pk = PbActivity.this.pk(id2);
                                                                                                                            if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && pk != null) {
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, true, null, i3, postData3.aVx(), PbActivity.this.eFm.getPbData().qh(), false, postData3.getAuthor().getIconInfo()).addBigImageData(pk.eHJ, pk.eHK, pk.eHL, pk.index)));
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
                                                                                                                            b pk2 = PbActivity.this.pk(id2);
                                                                                                                            if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && pk2 != null && PbActivity.this.aQb().aSG() != null) {
                                                                                                                                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                                                                                                                                nVar.b(PbActivity.this.eFm.getPbData().aOW());
                                                                                                                                nVar.U(PbActivity.this.eFm.getPbData().aOY());
                                                                                                                                nVar.f(postData4);
                                                                                                                                PbActivity.this.aQb().aSG().d(nVar);
                                                                                                                                PbActivity.this.aQb().aSG().setPostId(str7);
                                                                                                                                PbActivity.this.a(view, str6, str5);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            b pk3 = PbActivity.this.pk(id2);
                                                                                                                            if (postData3 != null && PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && pk3 != null) {
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id2, "pb", true, null, false, null, i3, postData3.aVx(), PbActivity.this.eFm.getPbData().qh(), false, postData3.getAuthor().getIconInfo()).addBigImageData(pk3.eHJ, pk3.eHK, pk3.eHL, pk3.index)));
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
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 3).aa("fid", PbActivity.this.eFm.getPbData().getForumId()));
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (com.baidu.adp.lib.util.i.hh()) {
                                                                                                        PbActivity.this.eGc.aAZ();
                                                                                                        SparseArray<Object> c3 = PbActivity.this.eGc.c(PbActivity.this.eFm.getPbData(), PbActivity.this.eFm.aRn(), 1);
                                                                                                        if (c3 != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eFm.getPbData().aOW().getId(), PbActivity.this.eFm.getPbData().aOW().getName(), PbActivity.this.eFm.getPbData().aOY().getId(), String.valueOf(PbActivity.this.eFm.getPbData().getUserData().getUserId()), (String) c3.get(d.h.tag_forbid_user_name), (String) c3.get(d.h.tag_forbid_user_post_id))));
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    } else {
                                                                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (!com.baidu.adp.lib.util.i.hh()) {
                                                                                                    PbActivity.this.showToast(d.l.network_not_available);
                                                                                                    return;
                                                                                                } else {
                                                                                                    SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                                    if (sparseArray11 != null) {
                                                                                                        if (!com.baidu.tieba.c.a.Vh() || sparseArray11.get(d.h.tag_del_post_id) == null || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eFm.getThreadID(), (String) sparseArray11.get(d.h.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.eGc.bf(view);
                                                                                                                return;
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.eGc.a(((Integer) sparseArray11.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.h.tag_del_post_id), ((Integer) sparseArray11.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.h.tag_del_post_is_self)).booleanValue());
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", PbActivity.this.eFm.getPbData().getForumId()));
                                                                                                return;
                                                                                            } else {
                                                                                                PbActivity.this.aPY();
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
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbActivity.this.eFm.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aOW() != null) {
                                                                                            str9 = pbData4.aOW().getId();
                                                                                            str10 = pbData4.aOW().getName();
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
                                                                                        if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.Vh() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), PbActivity.this.eFm.getThreadID(), (String) sparseArray12.get(d.h.tag_del_post_id))) {
                                                                                            PbActivity.this.eGc.a(((Integer) sparseArray12.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.h.tag_del_post_id), intValue, booleanValue7);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                if (PbActivity.this.eGh.aSb()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12007").aa("tid", PbActivity.this.eFm.eJA));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eFm.getPbData() != null) {
                                                                                    PbActivity.this.eGc.aAZ();
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
                                                                                        String threadID2 = PbActivity.this.eFm.getThreadID();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.eFm.getPbData() != null) {
                                                                                            i5 = PbActivity.this.eFm.getPbData().aPj();
                                                                                        }
                                                                                        PbActivity.this.afj();
                                                                                        b pk4 = PbActivity.this.pk(id3);
                                                                                        if (pk4 != null) {
                                                                                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(threadID2, id3, "pb", true, null, true, null, i5, postData.aVx(), PbActivity.this.eFm.getPbData().qh(), false, postData.getAuthor().getIconInfo()).addBigImageData(pk4.eHJ, pk4.eHK, pk4.eHL, pk4.index)));
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
                                                                                PbActivity.this.bb(view);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11739").r("obj_locate", 4));
                                                                        if (!com.baidu.adp.lib.util.i.hh()) {
                                                                            PbActivity.this.showToast(d.l.network_not_available);
                                                                            return;
                                                                        }
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            PbActivity.this.ph((String) tag);
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
                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), null, PbActivity.this.aQg(), true)));
                                                                    PbActivity.this.eGc.eMZ.og();
                                                                    PbActivity.this.eGc.eMZ.aUw().aSo();
                                                                    return;
                                                                }
                                                                TiebaStatic.log("c10414");
                                                                PbActivity.this.eGc.aAZ();
                                                                if (PbActivity.this.eGc.ri() == aq.eOP) {
                                                                    PbActivity.this.eGc.aTt();
                                                                    return;
                                                                } else if (PbActivity.this.eFm.aRL() != null) {
                                                                    PbActivity.this.eFm.aRL().oW(PbModel.UPGRADE_TO_PHOTO_LIVE);
                                                                    return;
                                                                } else {
                                                                    return;
                                                                }
                                                            } else if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && PbActivity.this.eFm.getPbData().aOY() != null) {
                                                                PbActivity.this.eGc.eMZ.og();
                                                                PbActivity.this.ph(PbActivity.this.eFm.getPbData().aOY().rL());
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        PbActivity.this.eGc.aAZ();
                                                        if (com.baidu.adp.lib.util.i.hh()) {
                                                            PbActivity.this.oR(2);
                                                            PbActivity.this.afj();
                                                            PbActivity.this.eGc.aTb();
                                                            PbActivity.this.eGc.aSW().jb(true);
                                                            boolean z7 = false;
                                                            if (!(view.getTag() instanceof Boolean)) {
                                                                PbActivity.this.eFm.aRx();
                                                            } else {
                                                                z7 = PbActivity.this.eFm.jj(!((Boolean) view.getTag()).booleanValue());
                                                            }
                                                            TiebaStatic.log("c12097");
                                                            if (z7 && PbActivity.this.getListView() != null) {
                                                                if (PbActivity.this.eGx > PbActivity.this.getListView().getFirstVisiblePosition()) {
                                                                    PbActivity.this.eGx = PbActivity.this.getListView().getFirstVisiblePosition();
                                                                }
                                                                View childAt = PbActivity.this.getListView().getChildAt(0);
                                                                int i6 = -1;
                                                                if (childAt != null) {
                                                                    i6 = childAt.getTop();
                                                                }
                                                                PbActivity.this.aQb().i(PbActivity.this.eGx, i6);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        PbActivity.this.showToast(d.l.network_not_available);
                                                        return;
                                                    }
                                                    PbActivity.this.eGc.aAZ();
                                                    if (PbActivity.this.eFm.aqb() != null) {
                                                        PbActivity.this.eGc.a(PbActivity.this.eFm.aqb(), PbActivity.this.emX);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    return;
                                                } else if (PbActivity.this.checkUpIsLogin()) {
                                                    if (com.baidu.adp.lib.util.k.hy()) {
                                                        PbActivity.this.eGc.aAZ();
                                                        PbActivity.this.afj();
                                                        PbActivity.this.oR(2);
                                                        if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && PbActivity.this.eFm.getPbData().aPq() != null && !StringUtils.isNull(PbActivity.this.eFm.getPbData().aPq().pL(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11678").aa("fid", PbActivity.this.eFm.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11939"));
                                                        PbActivity.this.eGc.QS();
                                                        PbActivity.this.eFm.aRO().p(CheckRealNameModel.TYPE_PB_SHARE, Integer.valueOf(view == PbActivity.this.eGc.eOy ? 1 : 2));
                                                        return;
                                                    }
                                                    PbActivity.this.showToast(d.l.neterror);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            PbActivity.this.eGc.eMZ.og();
                                        } else if (com.baidu.adp.lib.util.i.hh()) {
                                            PbActivity.this.eGc.aAZ();
                                            if (PbActivity.this.eGc.eMZ.aUw() != null && view == PbActivity.this.eGc.eMZ.aUw().aSh() && !PbActivity.this.eGc.aTD()) {
                                                PbActivity.this.eGc.aSI();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.eGc.eMZ.eTi.setEnabled(false);
                                                PbActivity.this.afj();
                                                PbActivity.this.eGc.aTb();
                                                if (view.getId() == d.h.floor_owner_reply) {
                                                    i2 = PbActivity.this.eFm.i(true, PbActivity.this.aQx());
                                                } else {
                                                    i2 = view.getId() == d.h.reply_title ? PbActivity.this.eFm.i(false, PbActivity.this.aQx()) : PbActivity.this.eFm.pm(PbActivity.this.aQx());
                                                }
                                                if (i2) {
                                                    PbActivity.this.eGc.avD();
                                                    PbActivity.this.mIsLoading = true;
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.oR(2);
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.l.network_not_available);
                                        }
                                    } else if (com.baidu.adp.lib.util.i.hh()) {
                                        PbActivity.this.eGc.aAZ();
                                        if (PbActivity.this.oQ(11009) && PbActivity.this.eFm.pf(PbActivity.this.eGc.aTg()) != null) {
                                            PbActivity.this.aQr();
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.l.network_not_available);
                                    }
                                } else if (com.baidu.adp.lib.util.i.hh()) {
                                    PbActivity.this.eGc.je(true);
                                    PbActivity.this.eGc.aSI();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.eGc.eMZ.eTi.setEnabled(false);
                                        PbActivity.this.eGc.avD();
                                        PbActivity.this.afj();
                                        PbActivity.this.eGc.aTb();
                                        PbActivity.this.eFm.pm(PbActivity.this.aQx());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.oR(2);
                                    }
                                } else {
                                    PbActivity.this.showToast(d.l.network_not_available);
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.eFm.getPbData() != null && PbActivity.this.eFm.getPbData().aOY() != null && PbActivity.this.eFm.getPbData().aOY().si() && PbActivity.this.eFm.getPbData().aOY().rM() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11922"));
                                }
                                if (PbActivity.this.eFm.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.eFm.aRm()) && PbActivity.this.eFm.getAppealInfo() != null) {
                                        name = PbActivity.this.eFm.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.eFm.getPbData().aOW().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String aRm = PbActivity.this.eFm.aRm();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.eFm.aRo() && aRm != null && aRm.equals(name)) {
                                        PbActivity.this.finish();
                                        return;
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                        return;
                                    }
                                }
                                PbActivity.this.finish();
                            }
                        } else if (com.baidu.adp.lib.util.i.hh()) {
                            if (PbActivity.this.eFm.getPbData().aPj() == 1 && !PbActivity.this.eGb.btd()) {
                                PbActivity.this.eGc.aAZ();
                                int i7 = 0;
                                if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSi()) {
                                    if (PbActivity.this.eGc.eMZ.aUw() == null || view != PbActivity.this.eGc.eMZ.aUw().aSk()) {
                                        if (view == PbActivity.this.eGc.aSZ()) {
                                            i7 = 2;
                                        }
                                    } else if (PbActivity.this.eFm.getPbData().aOY().rr() == 1) {
                                        i7 = 3;
                                    } else {
                                        i7 = 6;
                                    }
                                } else if (PbActivity.this.eFm.getPbData().aOY().rq() == 1) {
                                    i7 = 5;
                                } else {
                                    i7 = 4;
                                }
                                ForumData aOW = PbActivity.this.eFm.getPbData().aOW();
                                String name2 = aOW.getName();
                                String id4 = aOW.getId();
                                String id5 = PbActivity.this.eFm.getPbData().aOY().getId();
                                if (!com.baidu.tieba.c.a.Vh() || !com.baidu.tieba.c.a.h(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.eGc.aSY();
                                    PbActivity.this.eGb.a(id4, name2, id5, i7, PbActivity.this.eGc.aTa());
                                }
                            }
                        } else {
                            PbActivity.this.showToast(d.l.network_not_available);
                        }
                    } else if (com.baidu.adp.lib.util.i.hh()) {
                        PbActivity.this.eGc.aAZ();
                        PbActivity.this.afj();
                        PbActivity.this.eGc.aTb();
                        PbActivity.this.eGc.QS();
                        PbActivity.this.eFm.oY(1);
                    } else {
                        PbActivity.this.showToast(d.l.network_not_available);
                    }
                } else if (PbActivity.this.eFQ) {
                    PbActivity.this.eFQ = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.h.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && PbActivity.this.aQb().aSG() != null && postData5.getAuthor() != null && postData5.bsr() != 1 && PbActivity.this.checkUpIsLogin() && !com.baidu.tieba.pb.f.d(postData5)) {
                                com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                                nVar2.b(PbActivity.this.eFm.getPbData().aOW());
                                nVar2.U(PbActivity.this.eFm.getPbData().aOY());
                                nVar2.f(postData5);
                                PbActivity.this.aQb().aSG().d(nVar2);
                                PbActivity.this.aQb().aSG().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.getAuthor().getUserId(), "");
                                TiebaStatic.log("c11743");
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aCV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.afj();
            PbActivity.this.eGc.jF(z);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbActivity.this.eGc.aAZ();
                if (PbActivity.this.eGq != null) {
                    PbActivity.this.eGc.hh(PbActivity.this.eGq.Dy());
                }
                PbActivity.this.eGc.aSF();
                PbActivity.this.eGc.hi(true);
                PbActivity.this.eFm.aRA();
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.eFm.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbActivity.this.eFm.getPbData();
                            if (pbData != null && pbData.aOY() != null && pbData.aOY().getAuthor() != null && (userId = pbData.aOY().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && PbActivity.this.eFm.aRt()) {
                                PbActivity.this.eGc.aTb();
                            }
                        } else if (PbActivity.this.eFm.aRt()) {
                            PbActivity.this.eGc.aTb();
                        }
                    } else if (floor != null) {
                        PbActivity.this.eGc.m(PbActivity.this.eFm.getPbData());
                    }
                    if (PbActivity.this.eFm.aRq()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10369").aa("tid", PbActivity.this.eFm.getThreadID()));
                    }
                }
            } else if (qVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    private final PbModel.a eGV = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.l eA;
            if (!z || fVar == null || fVar.aPh() != null || com.baidu.tbadk.core.util.u.u(fVar.aPa()) >= 1) {
                PbActivity.this.ecI = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.eGc.aTd();
                if (fVar == null || !fVar.aPe()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.eGc.getView());
                } else if (PbActivity.this.eGc.aSD() == null) {
                    PbActivity.this.eGs = true;
                }
                PbActivity.this.eGc.avC();
                PbActivity.this.eGc.aSX();
                if (PbActivity.this.eFV || PbActivity.this.eGc.aTD()) {
                    PbActivity.this.eGc.aTr();
                } else {
                    PbActivity.this.eGc.hi(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                    PbActivity.this.eGc.eMZ.eTi.setEnabled(true);
                }
                if (i4 == 0 && fVar != null) {
                    PbActivity.this.eGl = true;
                }
                if (z && fVar != null) {
                    PbActivity.this.eGc.Nm();
                    PbActivity.this.eGc.jK(fVar.aPe());
                    if (fVar.aOY() != null && fVar.aOY().sr() != null) {
                        PbActivity.this.a(fVar.aOY().sr());
                    }
                    if (PbActivity.this.eGq != null) {
                        PbActivity.this.eGc.hh(PbActivity.this.eGq.Dy());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.aPa() != null && fVar.aPa().size() >= 1 && fVar.aPa().get(0) != null) {
                        PbActivity.this.eFm.po(fVar.aPa().get(0).getId());
                    } else if (fVar.aPh() != null) {
                        PbActivity.this.eFm.po(fVar.aPh().getId());
                    }
                    if (PbActivity.this.eGq != null) {
                        PbActivity.this.eGq.a(fVar.qh());
                        PbActivity.this.eGq.a(fVar.aOW(), fVar.getUserData());
                        PbActivity.this.eGq.a(PbActivity.this.eFm.aRu(), PbActivity.this.eFm.getThreadID(), PbActivity.this.eFm.aRQ());
                        if (fVar.aOY() != null) {
                            PbActivity.this.eGq.bL(fVar.aOY().sH());
                        }
                    }
                    if (PbActivity.this.dYU != null) {
                        PbActivity.this.dYU.ac(fVar.nB());
                    }
                    if (fVar == null || fVar.aPk() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.eGc.jJ(PbActivity.this.mIsFromCDN);
                    if (PbActivity.this.eGi) {
                        PbActivity.this.a(PbActivity.this.eFm.getPbData(), -1, 0, false, true);
                    } else if (PbActivity.this.eGj && !PbActivity.this.eGk) {
                        PbActivity.this.a(PbActivity.this.eFm.getPbData(), -1, false, true);
                        PbActivity.this.eGk = true;
                        PbActivity.this.eGi = true;
                    }
                    PbActivity.this.eGc.a(fVar, i2, i3, PbActivity.this.eFm.aRn(), i4, PbActivity.this.eFm.getIsFromMark());
                    PbActivity.this.eGc.e(fVar, PbActivity.this.eFm.aRn());
                    PbActivity.this.eGc.jH(PbActivity.this.eFm.getHostMode());
                    if (PbActivity.this.eFm.aRJ() != null) {
                        PbActivity.this.eGc.jG(PbActivity.this.eFm.aRJ().aRi());
                    }
                    AntiData qh = fVar.qh();
                    if (qh != null) {
                        PbActivity.this.aCJ = qh.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aCJ) && PbActivity.this.eGq != null && PbActivity.this.eGq.CS() != null && (eA = PbActivity.this.eGq.CS().eA(6)) != null && !TextUtils.isEmpty(PbActivity.this.aCJ)) {
                            ((View) eA).setOnClickListener(PbActivity.this.dHH);
                        }
                    }
                    com.baidu.tieba.pb.f.oX(fVar.eDc);
                    if (PbActivity.this.eGn) {
                        PbActivity.this.eGn = false;
                        PbActivity.this.aQb().getListView().setSelection(PbActivity.this.aQl());
                    }
                    if (PbActivity.this.eGo) {
                        PbActivity.this.eGo = false;
                        int aQl = PbActivity.this.aQl();
                        if (aQl == -1) {
                            aQl = PbActivity.this.aQm();
                        }
                        if (PbActivity.this.aQb() != null && PbActivity.this.aQb().getListView() != null) {
                            PbActivity.this.aQb().getListView().setSelection(aQl);
                        }
                    }
                    PbActivity.this.eFm.a(fVar.aOW(), PbActivity.this.eGJ);
                } else if (str != null) {
                    if (!PbActivity.this.eGl && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.eFm != null && PbActivity.this.eFm.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.eFm.getAppealInfo().eCx)) {
                                    PbActivity.this.eGc.a(PbActivity.this.eFm.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.eGc.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.eGc.getView(), PbActivity.this.getPageContext().getResources().getString(d.l.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
                            }
                            PbActivity.this.eGc.aTr();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i != -1) {
                        PbActivity.this.eGc.pq(PbActivity.this.getResources().getString(d.l.list_no_more_new));
                    } else {
                        PbActivity.this.eGc.pq("");
                    }
                    PbActivity.this.eGc.wO();
                }
                PbActivity.this.aIT = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.aQc().aRn() || PbActivity.this.aQc().getPbData().qx().qu() != 0 || PbActivity.this.aQc().aRH()) {
                    PbActivity.this.eGr = true;
                    return;
                }
                return;
            }
            PbActivity.this.eFm.oY(1);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void c(com.baidu.tieba.pb.data.f fVar) {
            PbActivity.this.eGc.m(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.r.Gr().Gs()) {
                com.baidu.tbadk.l.m mVar = new com.baidu.tbadk.l.m(i, z, responsedMessage, PbActivity.this.aIL, PbActivity.this.createTime, PbActivity.this.aIT, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.bXv : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aIL = 0L;
                if (mVar != null) {
                    mVar.Gm();
                }
            }
        }
    };
    private CustomMessageListener eGW = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.aQh() == 1) {
                    PbActivity.this.aQp();
                }
                PbActivity.this.aQi();
            }
        }
    };
    private CustomMessageListener eGX = new CustomMessageListener(CmdConfigCustom.CMD_TTS_OPTION_PB) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.b.a)) {
                com.baidu.tieba.pb.b.a aVar = (com.baidu.tieba.pb.b.a) customResponsedMessage.getData();
                if (aVar.tag == PbActivity.this.getUniqueId()) {
                    switch (aVar.eVx) {
                        case 0:
                            if (PbActivity.this.mIsLogin) {
                                if (PbActivity.this.eFm.jh(false)) {
                                    PbActivity.this.eGc.aTc();
                                    return;
                                } else if (PbActivity.this.eFm.getPbData() != null) {
                                    PbActivity.this.eGc.aTp();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        case 1:
                            if (!PbActivity.this.mIsLoading) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.eGc.eMZ.eTi.setEnabled(false);
                                PbActivity.this.eGc.avD();
                                PbActivity.this.afj();
                                PbActivity.this.eGc.aTb();
                                PbActivity.this.eFm.pm(PbActivity.this.aQx());
                                return;
                            }
                            return;
                        case 2:
                            if (PbActivity.this.eFG) {
                                boolean hostMode = PbActivity.this.eFm.getHostMode();
                                boolean aRn = PbActivity.this.eFm.aRn();
                                String threadID = PbActivity.this.eFm.getThreadID();
                                String str = aVar.postId;
                                int i2 = aVar.eVy;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(PbActivity.this.getPageContext().getPageActivity());
                                pbActivityConfig.createReaderServiceCfg(threadID, str, i2, hostMode, aRn, null);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                                PbActivity.this.eGi = false;
                                PbActivity.this.finish();
                                return;
                            }
                            int i3 = aVar.eVy;
                            if (PbActivity.this.eFm.getHostMode()) {
                                i = i3 + 3;
                            } else {
                                i = i3 + 2;
                            }
                            PbActivity.this.eGc.getListView().setSelection(i);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    };
    private final a.InterfaceC0038a eGY = new a.InterfaceC0038a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0038a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.eGc.aTd();
            if (z) {
                if (PbActivity.this.dYU != null) {
                    PbActivity.this.dYU.ac(z2);
                }
                PbActivity.this.eFm.jk(z2);
                if (PbActivity.this.eFm.nB()) {
                    PbActivity.this.aQs();
                } else {
                    PbActivity.this.eGc.m(PbActivity.this.eFm.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.dYU != null) {
                        if (PbActivity.this.dYU.nE() != null) {
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
            if (!PbActivity.this.oP(PbActivity.this.mLastScrollState) && PbActivity.this.oP(i)) {
                if (PbActivity.this.eGc != null) {
                    PbActivity.this.eGc.aAZ();
                    if (PbActivity.this.eGq != null && !PbActivity.this.eGc.aSJ()) {
                        PbActivity.this.eGc.hh(PbActivity.this.eGq.Dy());
                    }
                    PbActivity.this.eGc.aSI();
                }
                if (!PbActivity.this.eFM) {
                    PbActivity.this.eFM = true;
                    PbActivity.this.eGc.aTq();
                }
            }
            PbActivity.this.eGc.onScrollStateChanged(absListView, i);
            if (PbActivity.this.eFE != null) {
                PbActivity.this.eFE.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.eFN == null) {
                PbActivity.this.eFN = new com.baidu.tbadk.l.d();
                PbActivity.this.eFN.fg(1001);
            }
            if (i == 0) {
                if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && PbActivity.this.eFm.getPbData().aOY() != null && PbActivity.this.eFm.getPbData().aOY().si()) {
                    z = false;
                }
                if (PbActivity.this.eGc.aSW() != null && z) {
                    PbActivity.this.eGc.aSW().notifyDataSetChanged();
                }
                PbActivity.this.eFN.FY();
            } else if (i == 1) {
                PbActivity.this.eFN.FY();
            } else {
                PbActivity.this.eFN.FY();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aPa;
            if (PbActivity.this.eFm != null && PbActivity.this.eFm.getPbData() != null && PbActivity.this.eGc != null && PbActivity.this.eGc.aSW() != null) {
                PbActivity.this.eGc.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.eFE != null) {
                    PbActivity.this.eFE.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.eFm.aRC() && (aPa = PbActivity.this.eFm.getPbData().aPa()) != null && !aPa.isEmpty()) {
                    int aQX = ((i + i2) - PbActivity.this.eGc.aSW().aQX()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbActivity.this.eFm.getPbData();
                    if (pbData != null) {
                        if (pbData.aPb() != null && pbData.aPb().hasData()) {
                            aQX--;
                        }
                        if (pbData.aPc() != null && pbData.aPc().hasData()) {
                            aQX--;
                        }
                        if (PbActivity.this.eFP) {
                            aQX--;
                        }
                        int size = aPa.size();
                        if (aQX < 0 || aQX >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eGZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.adp.base.d
        public void g(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eGb.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.eFm.aRA();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.cGs || bVar.eUP <= 0 || bVar.giT == 0) {
                            z = true;
                        } else {
                            com.baidu.tieba.c.a.a(PbActivity.this.getPageContext(), 2, 1);
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.eGc.a(1, dVar.AM, dVar.giV, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eGb.getLoadDataMode(), (ForumManageModel.f) obj);
                        return;
                    case 6:
                        ForumManageModel.f fVar = (ForumManageModel.f) obj;
                        PbActivity.this.eGc.a(PbActivity.this.eGb.getLoadDataMode(), fVar.AM, fVar.giV, false);
                        PbActivity.this.eGc.am(fVar.giX);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.eGc.a(PbActivity.this.eGb.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final c eHa = new c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
    };
    private final k.b aZk = new k.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.aQy()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.eFm.ji(true)) {
                PbActivity.this.eGc.aTe();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eHc = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.eHb && PbActivity.this.aQy()) {
                PbActivity.this.aQA();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.eFm.jh(false)) {
                    PbActivity.this.eGc.aTc();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.eFm.getPbData() != null) {
                    PbActivity.this.eGc.aTp();
                }
                PbActivity.this.eHb = true;
            }
        }
    };
    private int eHd = 0;
    private final TbRichTextView.e aQA = new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
        public void a(View view, String str, int i) {
            TbRichTextData tbRichTextData;
            try {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                b bVar = new b();
                PbActivity.this.a(str, i, bVar);
                if (bVar.eHN) {
                    TbRichText ao = PbActivity.this.ao(str, i);
                    if (ao != null && (tbRichTextData = ao.Ig().get(PbActivity.this.eHd)) != null && tbRichTextData.Is() != null && tbRichTextData.Is().memeInfo != null && !TextUtils.isEmpty(tbRichTextData.Is().memeInfo.detail_link)) {
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextData.Is().memeInfo.detail_link)));
                    }
                } else if (!bVar.eHM) {
                    ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eHJ, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eHL, bVar.eHJ.get(0), PbActivity.this.eFm.aRy(), bVar.eHK, true, false, PbActivity.this.eFm.getHostMode());
                    createConfig.getIntent().putExtra("from", "pb");
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                } else {
                    TbRichText ao2 = PbActivity.this.ao(str, i);
                    if (ao2 != null && PbActivity.this.eHd >= 0 && PbActivity.this.eHd < ao2.Ig().size()) {
                        String c2 = com.baidu.tieba.pb.data.g.c(ao2.Ig().get(PbActivity.this.eHd));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= bVar.eHJ.size()) {
                                break;
                            } else if (!bVar.eHJ.get(i3).equals(c2)) {
                                i2 = i3 + 1;
                            } else {
                                bVar.index = i3;
                                break;
                            }
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(bVar.eHJ, bVar.index, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eHL, bVar.lastId, PbActivity.this.eFm.aRy(), bVar.eHK, true, false, PbActivity.this.eFm.getHostMode());
                        createConfig2.getIntent().putExtra("from", "pb");
                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean eHe = false;
    PostData eHf = null;
    private final b.InterfaceC0043b eHg = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eHf != null) {
                if (i == 0) {
                    PbActivity.this.eHf.bO(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.eHf = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.h(PbActivity.this.eHf);
                }
            }
        }
    };
    private final b.InterfaceC0043b eHh = new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.eGz != null && !TextUtils.isEmpty(PbActivity.this.eGA)) {
                if (i == 0) {
                    if (PbActivity.this.eGB == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.eGA));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.eGA;
                        aVar.pkgId = PbActivity.this.eGB.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.eGB.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.eGy == null) {
                        PbActivity.this.eGy = new at(PbActivity.this.getPageContext());
                    }
                    PbActivity.this.eGy.h(PbActivity.this.eGA, PbActivity.this.eGz.kQ());
                }
                PbActivity.this.eGz = null;
                PbActivity.this.eGA = null;
            }
        }
    };
    private final View.OnLongClickListener auW = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.eGz = ((TbImageView) view).getBdImage();
                PbActivity.this.eGA = ((TbImageView) view).getUrl();
                if (PbActivity.this.eGz != null && !TextUtils.isEmpty(PbActivity.this.eGA)) {
                    if (view.getTag(d.h.tag_rich_text_meme_info) == null || !(view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.eGB = null;
                    } else {
                        PbActivity.this.eGB = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                    }
                    PbActivity.this.eGc.a(PbActivity.this.eHh, PbActivity.this.eGz.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.eHf = (PostData) sparseArray.get(d.h.tag_clip_board);
                    if (PbActivity.this.eHf != null && PbActivity.this.dYU != null) {
                        PbActivity.this.eGc.a(PbActivity.this.eHg, PbActivity.this.dYU.nB() && PbActivity.this.eHf.getId() != null && PbActivity.this.eHf.getId().equals(PbActivity.this.eFm.rE()), ((Boolean) sparseArray.get(d.h.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a bDL = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!PbActivity.this.eFG && z && !PbActivity.this.eFm.aRs()) {
                PbActivity.this.VA();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(PbActivity.this.getApplicationContext(), d.f.ds200));
        }
    };
    public View.OnTouchListener aLD = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).apd()) {
                        break;
                    }
                }
            }
            PbActivity.this.ckS.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0080a bUZ = new a.InterfaceC0080a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        final int bwS;

        {
            this.bwS = (int) PbActivity.this.getResources().getDimension(d.f.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ag(int i, int i2) {
            if (Y(i2) && PbActivity.this.eGc != null && PbActivity.this.eFE != null) {
                PbActivity.this.eFE.en(false);
                PbActivity.this.eFE.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2) && PbActivity.this.eGc != null && PbActivity.this.eFE != null) {
                PbActivity.this.eFE.en(true);
                if (Math.abs(i2) > this.bwS) {
                    PbActivity.this.eFE.hideFloatingView();
                }
                if (PbActivity.this.aQy()) {
                    PbActivity.this.eGc.aSR();
                    PbActivity.this.eGc.aSS();
                }
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a eHi = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tieba.e.b.a
        public void ee(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.aPP();
            } else {
                com.baidu.tieba.pb.a.b.aPO();
            }
        }
    };
    private String eHj = null;
    private final m.a eHk = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.l.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.l.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.eHj = str2;
                PbActivity.this.eGc.pr(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int eHl = -1;
    private int eHm = -1;
    private CustomMessageListener eHp = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.SA == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0041a) {
                    if (aVar.SB != null && !aVar.SB.hasError() && aVar.SB.getError() == 0) {
                        if (PbActivity.this.eGc != null) {
                            PbActivity.this.eGc.w(((a.C0041a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.aQK();
                        }
                    } else if (z) {
                        if (aVar.SB != null && aVar.SB.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.SB.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.SB != null && !aVar.SB.hasError() && aVar.SB.getError() == 0) {
                        if (PbActivity.this.eGc != null && PbActivity.this.eGc != null) {
                            PbActivity.this.eGc.w(((a.C0041a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.SB != null && aVar.SB.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.SB.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.l.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.SB == null || aVar.SB.hasError() || aVar.SB.getError() != 0) {
                        if (z) {
                            if (aVar.SB != null && aVar.SB.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.SB.getErrorString());
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
    private final CustomMessageListener ciO = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11455").aa("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.at.vV().c(PbActivity.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    private d.b IG = new d.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
        @Override // com.baidu.adp.widget.d.b
        public void lo() {
            PbActivity.this.eGc.aTF();
        }

        @Override // com.baidu.adp.widget.d.b
        public void W(boolean z) {
            if (z) {
                PbActivity.this.eGc.aTG();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* loaded from: classes.dex */
    public static class b {
        public ArrayList<String> eHJ;
        public ConcurrentHashMap<String, ImageUrlData> eHK;
        public boolean eHM;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean eHL = false;
        public boolean eHN = false;
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
        return this.eGq;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        if (nVar.aPG() != null) {
            String id = nVar.aPG().getId();
            ArrayList<PostData> aPa = this.eFm.getPbData().aPa();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aPa.size()) {
                    break;
                }
                PostData postData = aPa.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aPK = nVar.aPK();
                    postData.th(nVar.getTotalCount());
                    if (postData.bso() != null) {
                        postData.bso().clear();
                        postData.bso().addAll(aPK);
                    }
                }
            }
            this.eGc.m(this.eFm.getPbData());
            c(nVar);
        }
    }

    public void aPY() {
        com.baidu.tieba.pb.data.f pbData;
        bl aOY;
        if (!this.eGL) {
            if (!com.baidu.adp.lib.util.k.hy()) {
                showToast(d.l.no_network_guide);
            } else if (this.eGO) {
                this.eGL = true;
                if (this.eFm != null && (pbData = this.eFm.getPbData()) != null && (aOY = pbData.aOY()) != null) {
                    int isLike = aOY.rl() == null ? 0 : aOY.rl().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10796").aa("tid", aOY.getId()));
                    }
                    if (this.eGM != null) {
                        this.eGM.a(aOY.rL(), aOY.getId(), isLike, "pb");
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
                bVar.cd(d.l.operation);
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
                                    PbActivity.this.eGc.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.h.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eGv);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eGv);
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
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.h.tag_user_mute_thread_id), (String) sparseArray.get(d.h.tag_user_mute_post_id), 1, str, PbActivity.this.eGv);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.eGv);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).tk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iY(int i) {
        bl aOY;
        String str;
        String z;
        if (this.eFm != null && this.eFm.getPbData() != null && (aOY = this.eFm.getPbData().aOY()) != null) {
            if (i == 1) {
                PraiseData rl = aOY.rl();
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
                        aOY.a(praiseData);
                    } else {
                        aOY.rl().getUser().add(0, metaData);
                        aOY.rl().setNum(aOY.rl().getNum() + 1);
                        aOY.rl().setIsLike(i);
                    }
                }
                if (aOY.rl() != null) {
                    if (aOY.rl().getNum() < 1) {
                        z = getResources().getString(d.l.frs_item_praise_text);
                    } else {
                        z = com.baidu.tbadk.core.util.al.z(aOY.rl().getNum());
                    }
                    this.eGc.T(z, true);
                }
            } else if (aOY.rl() != null) {
                aOY.rl().setIsLike(i);
                aOY.rl().setNum(aOY.rl().getNum() - 1);
                ArrayList<MetaData> user = aOY.rl().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aOY.rl().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aOY.rl().getNum() < 1) {
                    str = getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = aOY.rl().getNum() + "";
                }
                this.eGc.T(str, false);
            }
            if (this.eFm.aRn()) {
                this.eGc.aSW().notifyDataSetChanged();
            } else {
                this.eGc.n(this.eFm.getPbData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.adp.framework.message.Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().ary && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        if (this.eFm != null && this.eFm.getPbData() != null && this.eGc != null) {
            this.eGc.d(this.eFm.getPbData(), this.eFm.aRn(), this.eFm.aRD());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eFm.r(bundle);
        if (this.chP != null) {
            this.chP.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.eGq.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.eGt = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.bXv = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.eFW = intent.getStringExtra("from");
            if (PbActivityConfig.FROM_INTERVIEW_LIVE.equals(this.eFW)) {
                this.eFF = true;
            }
            this.eHl = intent.getIntExtra(PbActivityConfig.KEY_MANGA_PREV_CHAPTER, -1);
            this.eHm = intent.getIntExtra(PbActivityConfig.KEY_MANGA_NEXT_CHAPTER, -1);
            this.eHn = intent.getStringExtra(PbActivityConfig.KEY_MANGA_TITLE);
            this.eGj = intent.getBooleanExtra(PbActivityConfig.FROM_READER_SERVICE, false);
            this.eGn = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_GOD_REPLY, false);
            this.eGo = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_COMMENT_AREA, false);
            if (aQy()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.al.isEmpty(this.source) ? "" : this.source;
            this.eGC = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            this.eFR = intent.getBooleanExtra("is_from_push", false);
        } else {
            this.bXv = System.currentTimeMillis();
        }
        this.eFL = System.currentTimeMillis();
        this.aIL = this.eFL - this.bXv;
        super.onCreate(bundle);
        this.mSwipeBackLayout.setOnSlidingStateChangeListener(this.IG);
        this.eFI = 0;
        t(bundle);
        if (this.eFm != null && this.eFm.getPbData() != null) {
            this.eFm.getPbData().pd(this.source);
        }
        initUI();
        if (intent != null && this.eGc != null) {
            this.eGc.eMP = intent.getIntExtra(PbActivityConfig.PRAISE_DATA, -1);
            if (!StringUtils.isNull(intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME))) {
                if (this.eGw == null) {
                    this.eGw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.eGc.pt("@" + intent.getStringExtra(PbActivityConfig.BIG_PIC_NAME) + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.eGw, 1500L);
            }
        }
        this.chP = new VoiceManager();
        this.chP.onCreate(getPageContext());
        initData(bundle);
        com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
        dVar.setForumName(this.eFm.aRm());
        if (this.eFm.getPbData() != null && this.eFm.getPbData().aOW() != null) {
            dVar.setForumId(this.eFm.getPbData().aOW().getId());
        }
        dVar.setFrom("pb");
        dVar.a(this.eFm);
        this.eGq = (com.baidu.tbadk.editortools.pb.c) dVar.aQ(getActivity());
        this.eGq.d(this);
        this.eGq.a(this.aCV);
        this.eGq.a(this.aCO);
        this.eGq.a(this, bundle);
        this.eGq.CS().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.eGq.CS().bE(true);
        iV(true);
        this.eGc.setEditorTools(this.eGq.CS());
        this.eGq.a(this.eFm.aRu(), this.eFm.getThreadID(), this.eFm.aRQ());
        registerListener(this.dHI);
        if (!this.eFm.aRr()) {
            this.eGq.fQ(this.eFm.getThreadID());
        }
        if (this.eFm.aRR()) {
            this.eGq.fO(getPageContext().getString(d.l.pb_reply_hint_from_smart_frs));
        } else {
            this.eGq.fO(getPageContext().getString(d.l.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.eFL;
        registerListener(this.eGF);
        registerListener(this.dIe);
        registerListener(this.eGG);
        registerListener(this.ciK);
        registerListener(this.eGU);
        registerListener(this.eGE);
        this.eGp = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.ggc);
        this.eGp.brS();
        registerListener(this.eGI);
        registerListener(this.bfA);
        if (this.eFm != null) {
            this.eFm.aRF();
        }
        if (TbadkCoreApplication.getInst().isTTSCanUse()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReadPbServiceConfig(getPageContext().getPageActivity())));
        }
        registerListener(this.eGQ);
        registerListener(this.eGX);
        registerListener(this.eGW);
        registerListener(this.eHp);
        registerListener(this.ciV);
        this.eFT = new com.baidu.tieba.pb.pb.main.b(this.eFm, this);
        if (this.eGc != null && this.eGc.aTv() != null && this.eGc.aTw() != null) {
            this.eFE = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.eGc.aTv(), this.eGc.aTw());
            this.eFE.a(this.eGP);
        }
        if (this.eFD && this.eGc != null && this.eGc.aTw() != null) {
            this.eGc.aTw().setVisibility(8);
        }
        this.eGu = new com.baidu.tbadk.core.view.c();
        this.eGu.ajS = 1000L;
        registerListener(this.eGT);
        registerListener(this.eGR);
        registerListener(this.eGS);
        this.eGv = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eGv;
        userMuteAddAndDelCustomMessage.setTag(this.eGv);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eGv;
        userMuteCheckCustomMessage.setTag(this.eGv);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.eFm.aRO().a(this.bnG);
        if ("from_tieba_kuang".equals(this.eFW)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12264").r("obj_type", 2).aa("tid", this.eFm.getThreadID()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    public String aPZ() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b aQa() {
        return this.eFE;
    }

    private void iV(boolean z) {
        this.eGq.bI(z);
        this.eGq.bJ(z);
        this.eGq.bK(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.chP != null) {
            this.chP.onStart(getPageContext());
        }
    }

    public aq aQb() {
        return this.eGc;
    }

    public PbModel aQc() {
        return this.eFm;
    }

    public void pf(String str) {
        if (this.eFm != null && !StringUtils.isNull(str) && this.eGc != null) {
            this.eGc.aSX();
            this.eGc.jM(true);
            this.eFm.pf(str);
            this.eFU = true;
            this.eGc.aAZ();
            this.eGc.aTr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.eFG = false;
        } else {
            this.eFG = true;
        }
        super.onPause();
        if (this.eGc.aSD() != null && this.eGc.aSD().aPU() != null) {
            this.eGc.aSD().aPU().onPause();
        }
        BdListView listView = getListView();
        this.eFI = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.eFI == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.chP != null) {
            this.chP.onPause(getPageContext());
        }
        if (this.eGc != null) {
            this.eGc.onPause();
        }
        if (!this.eFm.aRr()) {
            this.eGq.fP(this.eFm.getThreadID());
        }
        if (this.eFm != null) {
            this.eFm.aRG();
        }
        MessageManager.getInstance().unRegisterListener(this.dgZ);
        apx();
        MessageManager.getInstance().unRegisterListener(this.eGR);
        MessageManager.getInstance().unRegisterListener(this.eGS);
        MessageManager.getInstance().unRegisterListener(this.eGT);
        MessageManager.getInstance().unRegisterListener(this.ciO);
        MessageManager.getInstance().unRegisterListener(this.cRl);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean aQd() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.eFm.getPbData(), this.eFm.aRn(), this.eFm.aRD());
        return (a2 == null || a2.getAuthor() == null || a2.getAuthor().getGodUserData() == null || a2.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eFG = false;
        super.onResume();
        if (this.eFY) {
            this.eFY = false;
            aQE();
        }
        if (this.eGc.aSD() != null && this.eGc.aSD().aPU() != null) {
            this.eGc.aSD().aPU().onResume();
        }
        if (aQd()) {
            this.eFO = System.currentTimeMillis();
        } else {
            this.eFO = -1L;
        }
        if (this.eGc != null && this.eGc.getView() != null) {
            if (!this.ecI) {
                aQv();
            } else {
                hideLoadingView(this.eGc.getView());
            }
            this.eGc.onResume();
        }
        if (this.eFI == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.eGc != null) {
            noNetworkView = this.eGc.aSE();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.i.hh()) {
            noNetworkView.aL(false);
        }
        if (this.chP != null) {
            this.chP.onResume(getPageContext());
        }
        registerListener(this.dgZ);
        this.eGm = false;
        aQD();
        registerListener(this.eGR);
        registerListener(this.eGS);
        registerListener(this.eGT);
        registerListener(this.ciO);
        registerListener(this.cRl);
        if (this.cix) {
            VA();
            this.cix = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.eGc.jD(z);
        if (this.eGh != null) {
            this.eGh.jm(z);
        }
        if (z && this.eGm) {
            this.eGc.aTc();
            this.eFm.jh(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eFO > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10804").aa("obj_duration", (System.currentTimeMillis() - this.eFO) + ""));
            this.eFO = 0L;
        }
        if (this.eGq != null && this.eGq.CS() != null && this.eGq.CS().getVisibility() != 0) {
            this.eGq.DB();
        }
        if (aQb().aSH() != null) {
            aQb().aSH().onStop();
        }
        if (this.eGc.eMZ != null && !this.eGc.eMZ.Xe()) {
            this.eGc.eMZ.aBq();
        }
        if (this.eFm != null && this.eFm.getPbData() != null && this.eFm.getPbData().aOW() != null && this.eFm.getPbData().aOY() != null) {
            com.baidu.tbadk.distribute.a.CC().a(getPageContext().getPageActivity(), "pb", this.eFm.getPbData().aOW().getId(), com.baidu.adp.lib.g.b.c(this.eFm.getPbData().aOY().getId(), 0L));
        }
        if (this.chP != null) {
            this.chP.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.eFT != null) {
            this.eFT.destroy();
        }
        if (this.eGi && this.eFm != null) {
            a(this.eFm.getPbData(), -2, 0, false, false);
        }
        if (!this.eFM && this.eGc != null) {
            this.eFM = true;
            this.eGc.aTq();
            a(false, (PostData) null);
        }
        if (this.eFm != null) {
            this.eFm.cancelLoadData();
            this.eFm.destory();
            if (this.eFm.aRN() != null) {
                this.eFm.aRN().onDestroy();
            }
        }
        if (this.eGq != null) {
            this.eGq.onDestroy();
        }
        if (this.eGb != null) {
            this.eGb.cancelLoadData();
        }
        if (this.eGc != null) {
            this.eGc.onDestroy();
            if (this.eGc.eMZ != null) {
                this.eGc.eMZ.aBq();
            }
        }
        if (this.eFN != null) {
            this.eFN.onDestroy();
        }
        if (this.eFE != null) {
            this.eFE.Hg();
        }
        super.onDestroy();
        if (this.chP != null) {
            this.chP.onDestory(getPageContext());
        }
        if (this.cik != null) {
            this.cik.destory();
        }
        this.eGc.aAZ();
        MessageManager.getInstance().unRegisterListener(this.eGR);
        MessageManager.getInstance().unRegisterListener(this.eGS);
        MessageManager.getInstance().unRegisterListener(this.eGT);
        MessageManager.getInstance().unRegisterListener(this.eGv);
        MessageManager.getInstance().unRegisterListener(this.eGU);
        MessageManager.getInstance().unRegisterListener(this.ciV);
        this.eGt = null;
        this.eGu = null;
        com.baidu.tieba.recapp.d.a.bhY().bia();
        if (this.eGw != null) {
            getSafeHandler().removeCallbacks(this.eGw);
        }
        if (this.eFZ != null) {
            this.eFZ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g aSW;
        ArrayList<PostData> aQY;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xO() && this.eGc != null && (aSW = this.eGc.aSW()) != null && (aQY = aSW.aQY()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = aQY.iterator();
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
                        bVar.bBU = id;
                        bVar.bId = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.Yw == 1 && !TextUtils.isEmpty(id)) {
                    next.Yw = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bBU = id;
                    bVar2.bId = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.eFm == null || this.eFm.getPbData() == null || this.eFm.getPbData().aOW() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.eFm.getPbData().aOW().getFirst_class();
                    str2 = this.eFm.getPbData().aOW().getSecond_class();
                    str = this.eFm.getPbData().aOW().getId();
                    str4 = this.eFm.getThreadID();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.xR());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eGc.onChangeSkinType(i);
        if (this.eGq != null && this.eGq.CS() != null) {
            this.eGq.CS().onChangeSkinType(i);
        }
        if (this.eGc.aSE() != null) {
            this.eGc.aSE().onChangeSkinType(getPageContext(), i);
        }
    }

    private void initUI() {
        this.eGc = new aq(this, this.cjs, this.aQB);
        this.ckS = new com.baidu.tieba.e.b(getActivity());
        this.ckS.a(this.eHi);
        this.ckS.a(this.bUZ);
        this.eGc.setOnScrollListener(this.mOnScrollListener);
        this.eGc.d(this.eHc);
        this.eGc.a(this.aZk);
        this.eGc.iP(com.baidu.tbadk.core.h.oN().oT());
        this.eGc.setOnImageClickListener(this.aQA);
        this.eGc.a(this.auW);
        this.eGc.c(this.bDL);
        this.eGc.a(this.eHa);
        this.eGc.jD(this.mIsLogin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZ(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.h.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (PostData.ggF == postData.getType() || TextUtils.isEmpty(postData.getBimg_url()) || !com.baidu.tbadk.core.h.oN().oT()) {
                    return false;
                }
                return pj(postData.getId());
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.eGc != null) {
            if (z && (!this.ecI || this.eGs)) {
                aQv();
            } else {
                hideLoadingView(this.eGc.getView());
            }
            this.eGs = false;
        }
    }

    private void aQe() {
        if (this.eFJ == null) {
            this.eFJ = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.eFJ.a(new String[]{getPageContext().getString(d.l.call_phone), getPageContext().getString(d.l.sms_phone), getPageContext().getString(d.l.search_in_baidu)}, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", "call");
                        PbActivity.this.eFk = PbActivity.this.eFk.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eFk);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eFm.getThreadID(), PbActivity.this.eFk, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.eFk = PbActivity.this.eFk.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eFk);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.eFm.getThreadID(), PbActivity.this.eFk, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.eFk = PbActivity.this.eFk.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eFk);
                        bVar.dismiss();
                    }
                }
            }).ce(b.a.aaL).cf(17).d(getPageContext());
        }
    }

    private void t(Bundle bundle) {
        this.eFm = new PbModel(this);
        this.eFm.a(this.eGV);
        if (this.eFm.aRL() != null) {
            this.eFm.aRL().a(this.eHk);
        }
        if (this.eFm.aRK() != null) {
            this.eFm.aRK().a(this.eGH);
        }
        if (this.eFm.aRN() != null) {
            this.eFm.aRN().a(this.eGD);
        }
        if (bundle != null) {
            this.eFm.initWithBundle(bundle);
        } else {
            this.eFm.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.eFm.jl(true);
        }
        ai.aSy().S(this.eFm.aRl(), this.eFm.getIsFromMark());
        if (StringUtils.isNull(this.eFm.getThreadID())) {
            finish();
        } else {
            this.eFm.Fo();
        }
    }

    private void initData(Bundle bundle) {
        this.dYU = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dYU != null) {
            this.dYU.a(this.eGY);
        }
        this.eGb = new ForumManageModel(this);
        this.eGb.setLoadDataCallBack(this.eGZ);
        this.eGc.a(new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
            public void g(Object obj) {
                if (!com.baidu.adp.lib.util.i.hh()) {
                    PbActivity.this.showToast(d.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.eFm.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.eFm.getPbData().aOW().getId(), PbActivity.this.eFm.getPbData().aOW().getName(), PbActivity.this.eFm.getPbData().aOY().getId(), valueOf, str, str2)));
            }
        });
        this.eGM.setUniqueId(getUniqueId());
        this.eGM.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eGc.QS();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.h.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.eGv;
        userMuteCheckCustomMessage.setTag(this.eGv);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.bZ(d.l.go_setting_float_window_permission);
        aVar.ca(d.l.step_to_setting_float_permission);
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
        aVar.b(getPageContext()).th();
    }

    public PostData ba(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.h.tag_clip_board)) != null && !com.baidu.tieba.pb.f.d(postData)) {
            if (postData.bsE()) {
                postData.cT(postData.bsD() - 1);
            } else {
                postData.cT(postData.bsD() + 1);
            }
            postData.my(!postData.bsE());
            ((PbFloorAgreeView) view).a(postData.bsE(), postData.bsD(), true);
            final int i = postData.bsE() ? 0 : 1;
            this.eFm.aRM().a(postData.getId(), i, new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
                @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                public void oT(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).pw(i2);
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

    public com.baidu.tbadk.core.util.aj aQf() {
        return new com.baidu.tbadk.core.util.aj("c12003").aa("tid", this.eFm.eJA).r("obj_type", 0).aa("fid", this.eFm.getForumId()).r("obj_param1", this.eFm.getPbData().aOY().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQg() {
        StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/god/call/?");
        if (this.eFm != null && this.eFm.getPbData() != null) {
            com.baidu.tieba.pb.data.f pbData = this.eFm.getPbData();
            if (pbData.aOW() != null) {
                sb.append("forum_name=").append(pg(pbData.aOW().getName()));
                sb.append("&");
            }
            if (pbData.aOY() != null) {
                bl aOY = pbData.aOY();
                sb.append("thread_id=").append(aOY.getId());
                sb.append("&");
                sb.append("thread_title=").append(pg(aOY.getTitle()));
                if (aOY.getAuthor() != null && aOY.getAuthor().getPortrait() != null) {
                    sb.append("&");
                    sb.append("head_url=").append(aOY.getAuthor().getPortrait());
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
                    int ag = (com.baidu.adp.lib.util.k.ag(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        g = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.k.g(PbActivity.this.getPageContext().getPageActivity(), d.f.ds120);
                    } else {
                        g = com.baidu.adp.lib.util.k.g(PbActivity.this.getPageContext().getPageActivity(), d.f.ds640);
                    }
                    int i = g - ag;
                    if (i > 0) {
                        PbActivity.this.aQb().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.aQb().aSH() != null) {
                        PbActivity.this.aQb().aSH().bL(str, str2);
                    }
                    PbActivity.this.aQb().aTr();
                }
            }, 500L);
        }
    }

    private String pg(String str) {
        return URLEncoder.encode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.h.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null && this.eFm != null && this.eFm.getPbData() != null && postData.bsr() > 1) {
            String threadID = this.eFm.getThreadID();
            String id = postData.getId();
            int i = 0;
            if (this.eFm.getPbData() != null) {
                i = this.eFm.getPbData().aPj();
            }
            b pk = pk(id);
            if (pk != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(threadID, id, "pb", true, null, false, null, i, postData.aVx(), this.eFm.getPbData().qh(), false, postData.getAuthor() != null ? postData.getAuthor().getIconInfo() : null).addBigImageData(pk.eHJ, pk.eHK, pk.eHL, pk.index)));
            }
        }
    }

    public void f(View view, int i, boolean z) {
        an anVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.k.hy()) {
                showToast(d.l.no_network_guide);
            } else if (aQc() != null && aQc().getPbData() != null && aQc().getPbData().aPv() != null && !com.baidu.tieba.pb.f.T(aQc().getPbData().aOY())) {
                com.baidu.tieba.pb.data.m aPv = aQc().getPbData().aPv();
                if (view == null || !(view.getTag(d.h.pb_main_thread_praise_view) instanceof an)) {
                    anVar = null;
                } else {
                    anVar = (an) view.getTag(d.h.pb_main_thread_praise_view);
                }
                if (aPv != null) {
                    int i2 = -1;
                    if (z) {
                        aPv.oL(i);
                    } else if (aPv.aPB()) {
                        aPv.aPD();
                        i2 = 1;
                    } else {
                        aPv.oM(i);
                        i2 = 0;
                    }
                    PbFloorAgreeModel.a aVar = new PbFloorAgreeModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void oT(int i3) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
                        public void a(CustomDialogData customDialogData) {
                            com.baidu.tieba.pb.c.a(PbActivity.this.getPageContext(), customDialogData);
                        }
                    };
                    if (this.eFm != null && this.eFm.aRM() != null) {
                        String str = "";
                        if (this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null) {
                            str = this.eFm.getPbData().aOY().rL();
                        }
                        if (this.eFm.getPbData() != null) {
                            this.eFm.getPbData().a(aPv);
                        }
                        if (z) {
                            this.eFm.aRM().a(str, 3, i, this.eFm.getForumId(), aVar);
                        } else {
                            this.eFm.aRM().a(str, i2, 3, i, this.eFm.getForumId(), aVar);
                            com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                            lVar.eDn = i2;
                            lVar.eDo = aPv;
                            lVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_AGREE_CHANGED, lVar));
                        }
                    }
                    if (anVar != null) {
                        anVar.b(aPv);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQh() {
        if (this.eFm.getPbData() == null || this.eFm.getPbData().aOY() == null) {
            return -1;
        }
        return this.eFm.getPbData().aOY().rZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQi() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.pG(this.eFm.getForumId()) && this.eFm.getPbData() != null && this.eFm.getPbData().aOW() != null) {
            if (this.eFm.getPbData().aOW().isLike() == 1) {
                aQw();
                this.eFm.aRP().bN(this.eFm.getForumId(), this.eFm.getThreadID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iW(boolean z) {
        if (this.eFm == null || this.eFm.getPbData() == null) {
            return false;
        }
        return ((this.eFm.getPbData().aPj() != 0) || this.eFm.getPbData().aOY() == null || this.eFm.getPbData().aOY().getAuthor() == null || TextUtils.equals(this.eFm.getPbData().aOY().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean iX(boolean z) {
        if (z) {
            return true;
        }
        if (this.eFm == null || this.eFm.getPbData() == null) {
            return false;
        }
        return this.eFm.getPbData().aPj() != 0;
    }

    private boolean iY(boolean z) {
        return (z || this.eFm == null || this.eFm.getPbData() == null || this.eFm.getPbData().aPj() == 0) ? false : true;
    }

    public void aQj() {
        if (this.eFm != null && this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null && this.eFm.getPbData().aOY().getAuthor() != null) {
            if (this.eGc != null) {
                this.eGc.aSF();
            }
            bl aOY = this.eFm.getPbData().aOY();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aOY.getAuthor().getUserId());
            GodUserData godUserData = aOY.getAuthor().getGodUserData();
            boolean z = equals && godUserData != null && godUserData.isCanSendCall();
            y yVar = new y();
            if (this.eFm.getPbData().aPj() == 1) {
                yVar.eLo = true;
                yVar.eLn = true;
                yVar.eLt = aOY.rq() == 1;
                yVar.eLs = aOY.rr() == 1;
            } else {
                yVar.eLo = false;
                yVar.eLn = false;
            }
            yVar.eLm = TbadkCoreApplication.getInst().appResponseToIntentClass(WriteShareActivityConfig.class);
            yVar.eLk = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
            yVar.eLp = iX(equals);
            yVar.eLq = aQk();
            yVar.eLr = iY(equals);
            yVar.eLl = this.eFm.aRn();
            yVar.eDz = this.dYU != null ? this.dYU.nB() : false;
            yVar.eLj = iW(equals);
            yVar.eLh = equals && this.eGc.aTi();
            yVar.eLi = z;
            yVar.isHostOnly = this.eFm.getHostMode();
            if (aOY.rM() == null) {
                yVar.eLu = false;
            } else {
                yVar.eLu = true;
            }
            this.eGc.eMZ.a(yVar);
        }
    }

    private boolean aQk() {
        if (this.eFm != null && this.eFm.aRn()) {
            return this.eFm.aqb() == null || this.eFm.aqb().qu() != 0;
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
        if (sparseArray != null && (postData = (PostData) sparseArray.get(d.h.tag_clip_board)) != null) {
            h(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, boolean z2) {
        if (fVar != null && this.eFm != null) {
            ad adVar = new ad(getUniqueId());
            adVar.pbData = fVar;
            adVar.threadId = this.eFm.getThreadID();
            adVar.postId = this.eFm.getPostId();
            adVar.eLU = i;
            adVar.eLV = i2;
            adVar.eLT = this.eFm.getHostMode();
            adVar.eDz = this.eFm.nB();
            adVar.isSquence = this.eFm.aRn();
            adVar.loadType = this.eFm.aRI();
            adVar.eLW = z;
            adVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_TRANSFOR_PBDATA, adVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQl() {
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
            if ((fVar instanceof com.baidu.tieba.pb.data.k) && ((com.baidu.tieba.pb.data.k) fVar).mType == 0) {
                return i + headerViewsCount;
            }
        }
        return -1;
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
            if ((fVar instanceof PostData) && fVar.getType() == PostData.ggD) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && this.eFm != null) {
            ad adVar = new ad(getUniqueId());
            adVar.pbData = fVar;
            adVar.threadId = this.eFm.getThreadID();
            adVar.postId = this.eFm.getPostId();
            adVar.eLU = i;
            adVar.eLT = this.eFm.getHostMode();
            adVar.eDz = this.eFm.nB();
            adVar.isSquence = this.eFm.aRn();
            adVar.loadType = this.eFm.aRI();
            adVar.eLW = z;
            adVar.isAlive = z2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_CHANGE_PB_POWER, adVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        VA();
    }

    public void a(boolean z, MarkData markData) {
        this.eGc.aTd();
        this.eFm.jk(z);
        if (this.dYU != null) {
            this.dYU.ac(z);
            if (markData != null) {
                this.dYU.a(markData);
            }
        }
        if (this.eFm.nB()) {
            aQs();
        } else {
            this.eGc.m(this.eFm.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oP(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ph(String str) {
        if (!StringUtils.isNull(str) && this.eFm != null) {
            String threadID = this.eFm.getThreadID();
            String id = this.eFm.getPbData().aOW().getId();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.f(antiData) || AntiHelper.g(antiData) || AntiHelper.h(antiData) || AntiHelper.i(antiData)) {
                if (!this.eFm.aRr()) {
                    antiData.setBlock_forum_name(this.eFm.getPbData().aOW().getName());
                    antiData.setBlock_forum_id(this.eFm.getPbData().aOW().getId());
                    antiData.setUser_name(this.eFm.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.eFm.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.tn(i)) {
            AntiHelper.ar(getPageContext().getPageActivity(), str);
        } else if (i == 230277) {
            fW(str);
        } else {
            this.eGc.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.eGc.a(0, bVar.AM, bVar.giV, z);
            if (bVar.AM) {
                if (bVar.giT == 1) {
                    ArrayList<PostData> aPa = this.eFm.getPbData().aPa();
                    int size = aPa.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aPa.get(i).getId())) {
                            i++;
                        } else {
                            aPa.remove(i);
                            break;
                        }
                    }
                    this.eGc.m(this.eFm.getPbData());
                } else if (bVar.giT == 0) {
                    aQn();
                } else if (bVar.giT == 2) {
                    ArrayList<PostData> aPa2 = this.eFm.getPbData().aPa();
                    int size2 = aPa2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aPa2.get(i2).bso().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aPa2.get(i2).bso().get(i3).getId())) {
                                i3++;
                            } else {
                                aPa2.get(i2).bso().remove(i3);
                                aPa2.get(i2).bsq();
                                z2 = true;
                                break;
                            }
                        }
                        aPa2.get(i2).rW(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.eGc.m(this.eFm.getPbData());
                    }
                    a(bVar, this.eGc);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.f fVar) {
        if (fVar != null) {
            this.eGc.a(this.eGb.getLoadDataMode(), fVar.AM, fVar.giV, false);
            if (fVar.AM) {
                this.eGe = true;
                if (i == 2 || i == 3) {
                    this.eGf = true;
                    this.eGg = false;
                } else if (i == 4 || i == 5) {
                    this.eGf = false;
                    this.eGg = true;
                }
                if (i == 2) {
                    this.eFm.getPbData().aOY().bS(1);
                    this.eFm.setIsGood(1);
                } else if (i == 3) {
                    this.eFm.getPbData().aOY().bS(0);
                    this.eFm.setIsGood(0);
                } else if (i == 4) {
                    this.eFm.getPbData().aOY().bR(1);
                    this.eFm.hE(1);
                } else if (i == 5) {
                    this.eFm.getPbData().aOY().bR(0);
                    this.eFm.hE(0);
                }
                this.eGc.d(this.eFm.getPbData(), this.eFm.aRn());
                com.baidu.tieba.c.a.a(getPageContext(), 2, i);
            }
        }
    }

    private void aQn() {
        if (this.eFm.aRo() || this.eFm.aRp()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.eFm.getThreadID());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.eFm.getThreadID()));
        if (aQt()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aPg;
        if (this.eGc != null) {
            this.eGc.aAZ();
        }
        if (this.eFm != null && this.eFm.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.eFm.getPbData().aOY().getId();
            historyMessage.forumName = this.eFm.getPbData().aOW().getName();
            historyMessage.threadName = this.eFm.getPbData().aOY().getTitle();
            ArrayList<PostData> aPa = this.eFm.getPbData().aPa();
            int aTf = this.eGc != null ? this.eGc.aTf() : 0;
            if (aPa != null && aTf >= 0 && aTf < aPa.size()) {
                historyMessage.postID = aPa.get(aTf).getId();
            }
            historyMessage.isHostOnly = this.eFm.getHostMode();
            historyMessage.isSquence = this.eFm.aRn();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.eGq != null) {
            this.eGq.onDestroy();
        }
        if (this.eFH && aQb() != null) {
            aQb().aTE();
        }
        if (this.eFm != null && (this.eFm.aRo() || this.eFm.aRp())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.eFm.getThreadID());
            if (this.eGe) {
                if (this.eGg) {
                    intent.putExtra("type", 4);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_TOP_DATA, this.eFm.aAQ());
                }
                if (this.eGf) {
                    intent.putExtra("type", 2);
                    intent.putExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, this.eFm.getIsGood());
                }
            }
            if (this.eFm.getPbData() != null && System.currentTimeMillis() - this.eFL >= 40000 && (aPg = this.eFm.getPbData().aPg()) != null && !com.baidu.tbadk.core.util.u.v(aPg.getDataList())) {
                intent.putExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA, aPg);
                intent.putExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, this.eGC);
            }
            setResult(-1, intent);
        }
        if (aQt()) {
            if (this.eFm != null && this.eGc != null && this.eGc.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.eFm.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aPe() && !this.eFU) {
                        ai.aSy().a(this.eFm.getPbData(), this.eGc.getListView().onSaveInstanceState(), this.eFm.aRn(), this.eFm.getHostMode());
                    }
                }
            } else {
                ai.aSy().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.eGc == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.eGc.pk(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oQ(int i) {
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
        this.eGq.onActivityResult(i, i2, intent);
        if (this.eFZ != null) {
            this.eFZ.onActivityResult(i, i2, intent);
        }
        if (aQb().aSH() != null) {
            aQb().aSH().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case 11009:
                    aQr();
                    return;
                case 13008:
                    ai.aSy().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.eFm != null) {
                                PbActivity.this.eFm.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.eFm != null) {
                        a(aQq(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    V(intent);
                    return;
                case 24006:
                    U(intent);
                    return;
                case 24007:
                    if (aQh() == 1) {
                        aQp();
                    }
                    String stringExtra = intent.getStringExtra("share_to");
                    if (!AddExperiencedModel.WEIXIN_FRIEND.equals(stringExtra) && !AddExperiencedModel.WEIXIN_TIMELINE.equals(stringExtra)) {
                        aQi();
                        return;
                    }
                    return;
                case 24008:
                    this.eGc.iU(false);
                    if (this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null && this.eFm.getPbData().aOY().rP() != null) {
                        this.eFm.getPbData().aOY().rP().setStatus(2);
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
            if (this.eFT != null) {
                this.eFT.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        switch (i) {
            case 12002:
                if (intent != null && aQb() != null && aPX() != null && aQb().aSJ() && com.baidu.tbadk.editortools.pb.a.Do().getStatus() == 1) {
                    com.baidu.tbadk.editortools.pb.a.Do().setStatus(0);
                    if (this.eGc != null) {
                        this.eGc.aSI();
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
            if (this.eFZ == null) {
                this.eFZ = new com.baidu.tieba.pb.pb.main.emotion.model.d(this);
                this.eFZ.b(this.aCO);
                this.eFZ.c(this.aCV);
            }
            this.eFZ.a(emotionImageData, aQc(), aQc().getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQp() {
        AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
        if (this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null && this.eFm.getPbData().aOY().rG() != null && this.eFm.getPbData().aOY().rG().size() > 0 && this.eFm.getPbData().aOY().rG().get(0) != null) {
            this.mAwardActId = this.eFm.getPbData().aOY().rG().get(0).pi();
        }
        addLotteryCountRequestMessage.setAwardActId(this.mAwardActId);
        addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        addLotteryCountRequestMessage.setThreadId(com.baidu.adp.lib.g.b.c(this.eFm.getPbData().getThreadId(), 0L));
        addLotteryCountRequestMessage.setFromType(2);
        sendMessage(addLotteryCountRequestMessage);
    }

    private void U(Intent intent) {
        if (intent != null) {
            switch (intent.getIntExtra(GetLotteryChanceActivityConfig.KEY_ACTION, 0)) {
                case 1:
                    oS(2);
                    return;
                case 2:
                    this.eGc.aSU();
                    return;
                default:
                    return;
            }
        }
    }

    private ShareFromPBMsgData aQq() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bE = this.eFm.getPbData().bE(getPageContext().getPageActivity());
        PostData aSK = this.eGc.aSK();
        String str = "";
        if (aSK != null) {
            str = aSK.getId();
            String bP = aSK.bP(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.j.isEmpty(bP)) {
                bE[1] = bP;
            }
        }
        String rL = this.eFm.getPbData().aOY().rL();
        if (rL != null && rL.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bE[1]);
        shareFromPBMsgData.setImageUrl(bE[0]);
        shareFromPBMsgData.setForumName(this.eFm.getPbData().aOW().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.eFm.getPbData().aOY().getId());
        shareFromPBMsgData.setTitle(this.eFm.getPbData().aOY().getTitle());
        return shareFromPBMsgData;
    }

    private void V(Intent intent) {
        b(aQq(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void b(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.eFm != null && this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final au auVar = new au(getPageContext().getPageActivity());
            auVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.v(auVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), auVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, auVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aQh() == 1) {
                        PbActivity.this.aQp();
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
            aVar.b(getPageContext()).th();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                auVar.K(shareFromPBMsgData.getImageUrl(), this.eFm.getPbData().aPk() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.eFm != null && this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final au auVar = new au(getPageContext().getPageActivity());
            auVar.setData(shareFromPBMsgData);
            aVar.cc(1);
            aVar.v(auVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), auVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", auVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    if (PbActivity.this.aQh() == 1) {
                        PbActivity.this.aQp();
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
            aVar.b(getPageContext()).th();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromPBMsgData.getImageUrl())) {
                auVar.K(shareFromPBMsgData.getImageUrl(), this.eFm.getPbData().aPk() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQr() {
        MarkData pf;
        if (this.dYU != null && (pf = this.eFm.pf(this.eGc.aTg())) != null) {
            if (!pf.isApp() || (pf = this.eFm.pf(this.eGc.aTg() + 1)) != null) {
                this.eGc.aTb();
                this.dYU.a(pf);
                if (!this.dYU.nB()) {
                    this.dYU.nD();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.dYU.nC();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQs() {
        com.baidu.tieba.pb.data.f pbData = this.eFm.getPbData();
        this.eFm.jk(true);
        pbData.pc(this.dYU.nA());
        this.eGc.m(pbData);
    }

    private boolean aQt() {
        if (this.eFm == null) {
            return true;
        }
        if (this.eFm.nB()) {
            final MarkData aRz = this.eFm.aRz();
            if (aRz == null || !this.eFm.getIsFromMark()) {
                return true;
            }
            final MarkData pf = this.eFm.pf(this.eGc.aTg());
            if (pf == null) {
                Intent intent = new Intent();
                intent.putExtra(PbActivityConfig.KEY_MARK, aRz);
                setResult(-1, intent);
                return true;
            } else if (pf.getPostId() == null || pf.getPostId().equals(aRz.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(PbActivityConfig.KEY_MARK, aRz);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cN(getPageContext().getString(d.l.alert_update_mark));
                aVar.a(d.l.alert_yes_btn, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.dYU != null) {
                            if (PbActivity.this.dYU.nB()) {
                                PbActivity.this.dYU.nC();
                                PbActivity.this.dYU.ac(false);
                            }
                            PbActivity.this.dYU.a(pf);
                            PbActivity.this.dYU.ac(true);
                            PbActivity.this.dYU.nD();
                        }
                        aRz.setPostId(pf.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aRz);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aQo();
                    }
                });
                aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra(PbActivityConfig.KEY_MARK, aRz);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.aQo();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.eGc != null && PbActivity.this.eGc.getView() != null) {
                            PbActivity.this.eGc.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PbActivityConfig.KEY_MARK, aRz);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.aQo();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.th();
                return false;
            }
        } else if (this.eFm.getPbData() == null || this.eFm.getPbData().aPa() == null || this.eFm.getPbData().aPa().size() <= 0 || !this.eFm.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.eGc == null) {
            return null;
        }
        return this.eGc.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IK() {
        if (this.eGc == null) {
            return 0;
        }
        return this.eGc.aTl();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IL() {
        if (this.aQg == null) {
            this.aQg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: Tn */
                public ImageView fI() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean oT = com.baidu.tbadk.core.h.oN().oT();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ai.getDrawable(d.e.common_color_10220));
                    if (oT) {
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
                        if (com.baidu.tbadk.core.h.oN().oT()) {
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
        return this.aQg;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IM() {
        if (this.aQh == null) {
            this.aQh = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aQh;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IN() {
        if (this.aQl == null) {
            this.aQl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQO */
                public GifView fI() {
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
        return this.aQl;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IO() {
        if (this.aQj == null) {
            this.aQj = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: alO */
                public View fI() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.f.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ar */
                public void o(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: as */
                public View p(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: at */
                public View q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.aQj;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IQ() {
        if (this.aQi == null) {
            this.aQi = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 6);
        }
        return this.aQi;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xf() {
        if (this.aog == null) {
            this.aog = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.aog;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eFQ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (av.pu(str) && this.eFm != null && this.eFm.getThreadID() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11664").r("obj_param1", 1).aa("post_id", this.eFm.getThreadID()));
        }
        av.aTI().f(getPageContext(), str);
        this.eFQ = true;
    }

    private com.baidu.tbadk.core.dialog.a aQu() {
        if (this.eFK == null) {
            this.eFK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.eFK.cM(getPageContext().getString(d.l.download_baidu_video_dialog));
            this.eFK.a(getPageContext().getString(d.l.install), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (!com.baidu.tbadk.core.util.k.dG()) {
                        PbActivity.this.showToast(com.baidu.tbadk.core.util.k.uy());
                    } else {
                        FileDownloader.download(PbActivity.this.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, PbActivity.this.getPageContext().getString(d.l.download_baidu_video));
                    }
                }
            });
            this.eFK.b(getPageContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eFK.ar(true);
            this.eFK.b(getPageContext());
            this.eFK.as(false);
        }
        this.eFK.th();
        return this.eFK;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
        av.aTI().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.eFQ = true;
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
            aQu();
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "baidu_video", "click", 1, new Object[0]);
        this.eFQ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, b bVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (bVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.eFm.getPbData();
            TbRichText ao = ao(str, i);
            if (ao != null && (tbRichTextData = ao.Ig().get(this.eHd)) != null) {
                if (tbRichTextData.getType() == 20 || tbRichTextData.getType() == 17) {
                    bVar.eHN = true;
                    return;
                }
                bVar.eHJ = new ArrayList<>();
                bVar.eHK = new ConcurrentHashMap<>();
                if (!tbRichTextData.Im().Iz()) {
                    bVar.eHM = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    bVar.eHJ.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.postId = ao.getPostId();
                    imageUrlData.mIsReserver = this.eFm.aRy();
                    imageUrlData.mIsSeeHost = this.eFm.getHostMode();
                    bVar.eHK.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aOW() != null) {
                            bVar.forumName = pbData.aOW().getName();
                            bVar.forumId = pbData.aOW().getId();
                        }
                        if (pbData.aOY() != null) {
                            bVar.threadId = pbData.aOY().getId();
                        }
                        bVar.eHL = pbData.aPk() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bVar.threadId, -1L);
                    return;
                }
                bVar.eHM = true;
                int size = pbData.aPa().size();
                this.eHe = false;
                bVar.index = -1;
                if (pbData.aPf() != null) {
                    PostData aPf = pbData.aPf();
                    TbRichText aAE = aPf.aAE();
                    if (!ap.k(aPf)) {
                        i2 = a(aAE, ao, i, i, bVar.eHJ, bVar.eHK);
                    } else {
                        i2 = a(aPf, i, bVar.eHJ, bVar.eHK);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aPa().get(i4);
                    if (postData.getId() == null || pbData.aPf() == null || pbData.aPf().getId() == null || !postData.getId().equals(pbData.aPf().getId())) {
                        TbRichText aAE2 = postData.aAE();
                        if (!ap.k(postData)) {
                            i3 = a(aAE2, ao, i3, i, bVar.eHJ, bVar.eHK);
                        } else {
                            i3 = a(postData, i3, bVar.eHJ, bVar.eHK);
                        }
                    }
                }
                if (bVar.eHJ.size() > 0) {
                    bVar.lastId = bVar.eHJ.get(bVar.eHJ.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aOW() != null) {
                        bVar.forumName = pbData.aOW().getName();
                        bVar.forumId = pbData.aOW().getId();
                    }
                    if (pbData.aOY() != null) {
                        bVar.threadId = pbData.aOY().getId();
                    }
                    bVar.eHL = pbData.aPk() == 1;
                }
                bVar.index = i3;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Im() == null) {
            return null;
        }
        return tbRichTextData.Im().ID();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Im() == null) {
            return 0L;
        }
        return tbRichTextData.Im().getOriginalSize();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Im;
        if (tbRichText == tbRichText2) {
            this.eHe = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Ig().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Ig().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ah = (int) com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.Im().getWidth() * ah;
                    int height = ah * tbRichTextData.Im().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.Im().Iz()) {
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
                            if (tbRichTextData != null && (Im = tbRichTextData.Im()) != null) {
                                String IB = Im.IB();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = IB;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eFm.getThreadID(), -1L);
                                imageUrlData.mIsReserver = this.eFm.aRy();
                                imageUrlData.mIsSeeHost = this.eFm.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.eHe) {
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
        com.baidu.tieba.tbadkCore.data.h bsz;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> brW;
        if (postData != null && arrayList != null && concurrentHashMap != null && (brW = (bsz = postData.bsz()).brW()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == brW.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = brW.get(i3);
                if (jVar != null) {
                    String bsb = jVar.bsb();
                    if (!com.baidu.tbadk.core.util.al.isEmpty(bsb)) {
                        arrayList.add(bsb);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bsb;
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        imageUrlData.originalUrl = jVar.bsa();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.eFm.getThreadID(), -1L);
                        imageUrlData.mIsReserver = this.eFm.aRy();
                        imageUrlData.mIsSeeHost = this.eFm.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bsz.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bsb, imageUrlData);
                        }
                        if (!this.eHe) {
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
            if (postData.getId() != null && postData.getId().equals(this.eFm.rE())) {
                z = true;
            }
            MarkData j = this.eFm.j(postData);
            if (j != null) {
                this.eGc.aTb();
                if (this.dYU != null) {
                    this.dYU.a(j);
                    if (!z) {
                        this.dYU.nD();
                    } else {
                        this.dYU.nC();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ao(String str, int i) {
        TbRichText tbRichText = null;
        if (this.eFm == null || this.eFm.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.eFm.getPbData();
        if (pbData.aPf() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aPf());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            return a(pbData.aPa(), str, i);
        }
        return tbRichText;
    }

    private long pi(String str) {
        ArrayList<PostData> aPa;
        com.baidu.tieba.pb.data.f pbData = this.eFm.getPbData();
        if (pbData != null && (aPa = pbData.aPa()) != null && !aPa.isEmpty()) {
            Iterator<PostData> it = aPa.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bsz = next.bsz();
                if (bsz != null && bsz.ggk) {
                    Iterator<TbRichTextData> it2 = next.aAE().Ig().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Iv().getLink().equals(str)) {
                            return bsz.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Ig;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText aAE = arrayList.get(i2).aAE();
            if (aAE != null && (Ig = aAE.Ig()) != null) {
                int size = Ig.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Ig.get(i4) != null && Ig.get(i4).getType() == 8) {
                        i3++;
                        if (Ig.get(i4).Im().IB().equals(str)) {
                            int ah = (int) com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst());
                            int width = Ig.get(i4).Im().getWidth() * ah;
                            int height = Ig.get(i4).Im().getHeight() * ah;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.eHd = i4;
                            return aAE;
                        } else if (i3 <= i) {
                            i4++;
                            i3 = i3;
                        }
                    } else {
                        if (Ig.get(i4) != null && Ig.get(i4).Is() != null && (Ig.get(i4).getType() == 20 || Ig.get(i4).getType() == 17)) {
                            i3++;
                            MemeInfo memeInfo = Ig.get(i4).Is().memeInfo;
                            if (memeInfo == null || TextUtils.isEmpty(memeInfo.pic_url)) {
                                return null;
                            }
                            if (memeInfo.pic_url.equals(str)) {
                                if (memeInfo.width.intValue() >= 80 && memeInfo.height.intValue() >= 80) {
                                    if (memeInfo.height.intValue() * memeInfo.width.intValue() >= 10000) {
                                        this.eHd = i4;
                                        return aAE;
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
            this.eFk = str;
            if (this.eFJ == null) {
                aQe();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.eFJ.ch(1).setVisibility(8);
            } else {
                this.eFJ.ch(1).setVisibility(0);
            }
            this.eFJ.tk();
            this.eFQ = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.chP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VA() {
        hideNetRefreshView(this.eGc.getView());
        aQv();
        if (this.eFm.Fo()) {
            this.eGc.aTb();
        }
    }

    private void aQv() {
        showLoadingView(this.eGc.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds400));
        View EI = getLoadingView().EI();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EI.getLayoutParams();
        layoutParams.addRule(3, this.eGc.aTv().getId());
        EI.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afj() {
        if (this.chP != null) {
            this.chP.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(int i) {
        if (this.eFm.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.f pbData = this.eFm.getPbData();
            String name = pbData.aOW().getName();
            String title = pbData.aOY().getTitle();
            int i2 = this.eFm.getHostMode() ? 1 : 0;
            boolean z = false;
            if (pbData != null && pbData.aOW() != null) {
                if ((pbData.aOW().isLike() == 1) && AddExperiencedModel.pG(pbData.getForumId())) {
                    z = true;
                }
            }
            String str = "http://tieba.baidu.com/p/" + this.eFm.getThreadID() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bE = pbData.bE(getPageContext().getPageActivity());
            String str2 = bE[0];
            if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str2 = str2.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String str3 = bE[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (aQh() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10399").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            } else if (aQh() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10406").aa("fid", pbData.getForumId()).aa("tid", pbData.getThreadId()).aa(SapiAccountManager.SESSION_UID, currentAccount));
            }
            String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, name, str3);
            final com.baidu.tbadk.coreExtra.share.e eVar = new com.baidu.tbadk.coreExtra.share.e();
            eVar.title = title;
            eVar.content = format;
            eVar.linkUrl = str;
            eVar.atL = true;
            eVar.atO = z;
            eVar.extData = this.eFm.getThreadID();
            eVar.atV = 3;
            eVar.atU = i;
            eVar.fid = this.eFm.getForumId();
            if (parse != null) {
                eVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), eVar, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 23007)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10125").aa("tid", PbActivity.this.eFm.getThreadID()).r("obj_type", 1));
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.av(eVar.linkUrl);
                    com.baidu.adp.lib.util.k.showToast(PbActivity.this.getPageContext().getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                }
            });
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private void aQw() {
        com.baidu.tbadk.util.u.a(new com.baidu.tbadk.util.t<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.pH(PbActivity.this.eFm.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.eGc.aTH();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IP() {
        if (this.aQk == null) {
            this.aQk = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aQP */
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
        return this.aQk;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eGc.aSV() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", this.eFm.getPbData().getForumId()));
            } else {
                bl aOY = this.eFm.getPbData().aOY();
                if (view != null) {
                    boolean z = aOY.rl() == null || aOY.rl().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.eGN > 1000) {
                            this.eGO = true;
                            bc(view);
                        } else {
                            this.eGO = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            k(view, this.eGO);
                        } else {
                            j(view, this.eGO);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        j(view, this.eGO);
                    } else if (motionEvent.getAction() == 3) {
                        j(view, this.eGO);
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
                    PbActivity.this.eGN = System.currentTimeMillis();
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
                    PbActivity.this.eGN = System.currentTimeMillis();
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

    public void afk() {
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
        } else if (aVar.tj() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.tj();
            int intValue = ((Integer) sparseArray.get(aq.eOR)).intValue();
            if (intValue == aq.eOS) {
                if (!this.eGb.btd()) {
                    this.eGc.aSY();
                    int intValue2 = ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue();
                    this.eGb.a(this.eFm.getPbData().aOW().getId(), this.eFm.getPbData().aOW().getName(), this.eFm.getPbData().aOY().getId(), (String) sparseArray.get(d.h.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == aq.eOT || intValue == aq.eOV) {
                if (this.eFm.aRL() != null) {
                    this.eFm.aRL().oW(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.eOT) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == aq.eOU) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.eHj).pd()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.eGv);
        userMuteAddAndDelCustomMessage.setTag(this.eGv);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean pj(String str) {
        if (!StringUtils.isNull(str) && aw.aN(getPageContext().getPageActivity())) {
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

    public void iZ(boolean z) {
        this.eGm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQx() {
        ArrayList<PostData> aPa;
        int u;
        if (this.eFm == null || this.eFm.getPbData() == null || this.eFm.getPbData().aPa() == null || (u = com.baidu.tbadk.core.util.u.u((aPa = this.eFm.getPbData().aPa()))) == 0) {
            return "";
        }
        if (this.eFm.aRy()) {
            Iterator<PostData> it = aPa.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bsr() == 1) {
                    return next.getId();
                }
            }
        }
        int aTf = this.eGc.aTf();
        PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(aPa, aTf);
        if (postData == null || postData.getAuthor() == null) {
            return "";
        }
        if (this.eFm.pn(postData.getAuthor().getUserId())) {
            return postData.getId();
        }
        for (int i = aTf - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.u.c(aPa, i);
            if (postData2 == null || postData2.getAuthor() == null || postData2.getAuthor().getUserId() == null) {
                break;
            } else if (this.eFm.pn(postData2.getAuthor().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = aTf + 1; i2 < u; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.u.c(aPa, i2);
            if (postData3 == null || postData3.getAuthor() == null || postData3.getAuthor().getUserId() == null) {
                return "";
            }
            if (this.eFm.pn(postData3.getAuthor().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.at.vV().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(pi(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.eFm.getPbData().aOW().getId(), this.eFm.getPbData().aOW().getName(), this.eFm.getPbData().aOY().getTid());
            }
            this.eFQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.cN(getResources().getString(d.l.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.cN(getResources().getString(d.l.make_sure_hide));
        }
        aVar.a(getResources().getString(d.l.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.eFm.aRK() != null) {
                    PbActivity.this.eFm.aRK().cu(j);
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
        aVar.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b pk(String str) {
        String str2;
        if (this.eFm.getPbData() == null || this.eFm.getPbData().aPa() == null || this.eFm.getPbData().aPa().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        b bVar = new b();
        int i = 0;
        while (true) {
            if (i >= this.eFm.getPbData().aPa().size()) {
                i = 0;
                break;
            } else if (str.equals(this.eFm.getPbData().aPa().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.eFm.getPbData().aPa().get(i);
        if (postData.aAE() == null || postData.aAE().Ig() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.aAE().Ig().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Im() != null) {
                    str2 = next.Im().IB();
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
        if (this.eFF) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.eFF = false;
        } else if (aQy()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eFF) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.eFF = false;
        } else if (aQy()) {
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
        if (pageStayDurationItem != null && this.eFm != null) {
            if (this.eFm.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eFm.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eFm.getThreadID(), 0L));
            if (this.eFR) {
                pageStayDurationItem.objParam1 = "1";
            }
        }
        return pageStayDurationItem;
    }

    public boolean aQy() {
        return (!this.eFD && this.eHl == -1 && this.eHm == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.eHo = nVar;
            this.eFD = true;
            this.eGc.aSM();
            this.eGc.ps(this.eHn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQz() {
        if (this.eHo != null) {
            if (this.eHl == -1) {
                showToast(d.l.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aM(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eHo.getCartoonId(), this.eHl, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQA() {
        if (this.eHo != null) {
            if (this.eHm == -1) {
                showToast(d.l.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aM(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.eHo.getCartoonId(), this.eHm, 0)));
                finish();
            }
        }
    }

    public int aQB() {
        return this.eHl;
    }

    public int aQC() {
        return this.eHm;
    }

    private void apx() {
        if (this.eFm != null && this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null && this.eFm.getPbData().aOY().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void aQD() {
        if (this.eFm != null && this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null && this.eFm.getPbData().aOY().si()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void aQE() {
        if (this.eFG) {
            this.eFY = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null && this.eFm.getPbData().aOY().rd() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.eFm.getPbData().aOY().rd().getThreadId(), this.eFm.getPbData().aOY().rd().getTaskId(), this.eFm.getPbData().aOY().rd().getForumId(), this.eFm.getPbData().aOY().rd().getForumName(), this.eFm.getPbData().aOY().rq(), this.eFm.getPbData().aOY().rr())));
            this.eFF = true;
            finish();
        }
    }

    public boolean aQF() {
        return this.eFG;
    }

    public String aQG() {
        return this.eFW;
    }

    public PbInterviewStatusView.a aQH() {
        return this.eGa;
    }

    public void ja(boolean z) {
        this.eFX = z;
    }

    public boolean aQI() {
        if (this.eFm != null) {
            return this.eFm.aRo();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cN(getResources().getString(d.l.mute_is_super_member_function));
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.eGt).showToast(d.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.eGt.getPageActivity(), 2, true, 4);
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
        aVar.b(this.eGt).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(String str) {
        if (str == null) {
            str = "";
        }
        if (this.eGt != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGt.getPageActivity());
            aVar.cN(str);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eGt).th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eGc.QS();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGt.getPageActivity());
        if (com.baidu.tbadk.core.util.al.isEmpty(str)) {
            aVar.cN(this.eGt.getResources().getString(d.l.block_mute_message_alert, str2));
        } else {
            aVar.cN(str);
        }
        aVar.a(d.l.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.eGc.QS();
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
        aVar.b(this.eGt).th();
    }

    public void aQK() {
        if (this.eFm != null && this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null && this.eFm.getPbData().aOY().sz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.ca(d.l.channel_open_push_message);
            aVar.a(d.l.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.eFm.getPbData().aOY().sz().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.th();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.b
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.b.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.pu(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ai.getDrawable(d.g.icon_pb_wenxue)) != null) {
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
            this.eFV = true;
        } else {
            this.eFV = false;
        }
        if (this.eGc != null) {
            this.eGc.onConfigurationChanged(configuration);
        }
        if (this.eGh != null) {
            this.eGh.dismiss();
        }
    }

    public boolean aQL() {
        if (this.eFm != null) {
            return this.eFm.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.eFm.getPbData().aPi().eDB;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bso().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bso().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bso().remove(i2);
                    list.get(i).bsq();
                    z = true;
                    break;
                }
            }
            list.get(i).rW(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.eFm.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.n nVar) {
        String id = nVar.aPG().getId();
        List<PostData> list = this.eFm.getPbData().aPi().eDB;
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
                ArrayList<PostData> aPK = nVar.aPK();
                postData.th(nVar.getTotalCount());
                if (postData.bso() != null) {
                    postData.bso().clear();
                    postData.bso().addAll(aPK);
                }
            }
        }
        this.eGc.m(this.eFm.getPbData());
    }

    public boolean aQM() {
        boolean z = true;
        if (this.eFm == null) {
            return false;
        }
        switch (this.eFm.aRT()) {
            case 1:
            case 2:
                break;
            default:
                if (this.eFm.getPbData() != null && this.eFm.getPbData().aOY() != null && this.eFm.getPbData().aOY().sH() && StringUtils.isNull(this.eFm.getForumId())) {
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }

    public void aQN() {
        if (this.eGc != null) {
            this.eGc.aSF();
            afk();
        }
    }

    public PostData aPf() {
        return this.eGc.c(this.eFm.eJQ, this.eFm.aRn());
    }
}
